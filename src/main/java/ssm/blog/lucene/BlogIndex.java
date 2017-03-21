package ssm.blog.lucene;


import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.search.highlight.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.wltea.analyzer.lucene.IKAnalyzer;
import ssm.blog.entity.Blog;
import ssm.blog.util.DateUtil;
import ssm.blog.util.StringUtil;

import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Paths;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/17 0017.
 */
public class BlogIndex {

    private Directory dir;

    public IndexWriter getWriter() throws IOException {

        dir = FSDirectory.open(Paths.get("E:\\studyResource\\index\\index"));
        Analyzer analyzer = new IKAnalyzer();
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
        IndexWriter indexWriter = new IndexWriter(dir,indexWriterConfig);

        return indexWriter;
    }
    //添加博客索引
    public void addIndex(Blog blog) throws Exception {

        IndexWriter indexWriter = getWriter();

        Document doc = new Document();
        doc.add(new StringField("id",String.valueOf(blog.getId()), Field.Store.YES));
        doc.add(new TextField("content",blog.getContentNoTag(),Field.Store.YES));
        doc.add(new StringField("releaseDate", DateUtil.DateToString(new Date(),"yyyy-MM-dd"),Field.Store.YES));
        doc.add(new TextField("title",blog.getTitle(),Field.Store.YES));

        indexWriter.addDocument(doc);
        indexWriter.close();
    }

    //查询博客索引信息
    public List<Blog> searchIndex(String searchStr) throws Exception {

        dir = FSDirectory.open(Paths.get("E:\\studyResource\\index\\index"));
        IndexReader indexReader = DirectoryReader.open(dir);
        IndexSearcher searcher = new IndexSearcher(indexReader);
        BooleanQuery.Builder booleanQuery = new BooleanQuery.Builder();
        Analyzer analyzer = new IKAnalyzer();

        QueryParser queryParser = new QueryParser("title",analyzer);
        Query query = queryParser.parse(searchStr);
        QueryParser queryParser1 = new QueryParser("content",analyzer);
        Query query1 = queryParser1.parse(searchStr);
        //查询结果包含标题和内容
        booleanQuery.add(query, BooleanClause.Occur.SHOULD);
        booleanQuery.add(query1, BooleanClause.Occur.SHOULD);

        TopDocs topDocs = searcher.search(booleanQuery.build(),100);
        QueryScorer queryScorer = new QueryScorer(query);
        Fragmenter fragmenter = new SimpleSpanFragmenter(queryScorer); //得分高的片段
        SimpleHTMLFormatter simpleHTMLFormatter = new SimpleHTMLFormatter("<b><font color='red'>", "</font></b>");
        Highlighter highlighter = new Highlighter(simpleHTMLFormatter, queryScorer); //高亮显示
        highlighter.setTextFragmenter(fragmenter); //将得分高的片段设置进去

        List<Blog> blogIndexList = new LinkedList<Blog>();
        for(ScoreDoc scorer:topDocs.scoreDocs){
            Document doc = searcher.doc(scorer.doc);
            Blog blog = new Blog();
            blog.setId(Integer.parseInt(doc.get("id")));
            blog.setReleaseDate(DateUtil.StringToDate(doc.get("releaseDate"),"yyyy-MM-dd"));
            System.out.println(blog.getReleaseDateStr());
            System.out.println(blog.getReleaseDateStr());
            System.out.println(blog.getReleaseDateStr());
            System.out.println(blog.getReleaseDateStr());
            String title = doc.get("title");
            String content = doc.get("content");
            if(title != null){
                TokenStream tokenStream = analyzer.tokenStream("title", new StringReader(title));
                String hTitle = highlighter.getBestFragment(tokenStream, title);
                if(StringUtil.isEmpty(hTitle)) {
                    blog.setTitle(title);
                } else {
                    blog.setTitle(hTitle);
                }
            }
            if(content != null) {
                TokenStream tokenStream = analyzer.tokenStream("content", new StringReader(content));
                String hContent = highlighter.getBestFragment(tokenStream, content);
                if(StringUtil.isEmpty(hContent)) {
                    if(content.length() > 100) { //如果没查到且content内容又大于100的话
                        blog.setContent(content.substring(0, 100)); //截取100个字符
                    } else {
                        blog.setContent(content);
                    }
                } else {
                    blog.setContent(hContent);
                }
            }
            blogIndexList.add(blog);
        }
        return blogIndexList;
    }
}
