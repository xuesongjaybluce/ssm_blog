package ssm.blog.entity;

/**
 * Created by Administrator on 2017/3/4 0004.
 */
public class Page {

    Integer pageNumber;
    Integer totalNumber;
    Integer everPageNumber;

    public Page(Integer totalNumber, Integer everPageNumber){
        this.everPageNumber = everPageNumber;
        this.totalNumber = totalNumber;
        this.pageNumber = everPageNumber / totalNumber;
    }


    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
    }

    public Integer getEverPageNumber() {
        return everPageNumber;
    }

    public void setEverPageNumber(Integer everPageNumber) {
        this.everPageNumber = everPageNumber;
    }
}
