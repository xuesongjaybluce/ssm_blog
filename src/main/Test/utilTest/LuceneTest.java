package utilTest;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;
import ssm.blog.lucene.BlogIndex;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * Created by Administrator on 2017/3/18 0018.
 */

public class LuceneTest {
    BlogIndex blogIndex = new BlogIndex();
    private Directory dir;
    @Test
    public void test() throws IOException {
        Document doc = new Document();
        doc.add(new TextField("id","你是中国人", Field.Store.YES));
        IndexWriter indexWriter= getWriter();
        indexWriter.addDocument(doc);
        indexWriter.close();
    }
    public IndexWriter getWriter() throws IOException {

        dir = FSDirectory.open(Paths.get("E:\\studyResource\\index\\index"));
        Analyzer analyzer = new IKAnalyzer();
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
        IndexWriter indexWriter = new IndexWriter(dir,indexWriterConfig);

        return indexWriter;
    }
}
