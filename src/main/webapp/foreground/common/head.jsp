<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/3 0003
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

        <div class="col-md-12 column heading">
            <div class="data-list">
                <div class="page-header">
                    <h2>
                        Garry的博客空间
                    </h2>
                    <div class="weather">
                        <iframe style="color:#D3B196;float:right" width="420" scrolling="no" height="60" frameborder="0"
                                allowtransparency="true"
                                src="http://i.tianqi.com/index.php?c=code&id=12&icon=1&num=5"></iframe>
                    </div>
                </div>
                <nav class="navbar navbar-default" role="navigation">
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li>
                                <a href="#">博客首页</a>
                            </li>
                            <li>
                                <a href="#">文章集</a>
                            </li>
                            <li>
                                <a href="#">相册集</a>
                            </li>
                            <li>
                                <a href="#">关于博主</a>
                            </li>
                        </ul>
                        <form class="navbar-form navbar-right" action="${pageContext.request.contextPath}/blog/search.do" role="search" onsubmit="return checkData()">
                            <div class="form-group">
                                <input type="text" class="form-control" name="search" id="keyword" placeholder="请输入文章关键字"/>
                            </div> <button type="submit" class="btn btn-default">查找</button>
                        </form>
                    </div>
                </nav>
            </div>
        </div>
<script type="text/javascript">
    function checkData() {

        var q = document.getElementById("q").value.trim();
        if(q == null || q == "") {
            alert("请输入您要查询的关键字！");
            return false;
        } else {
            return true;
        }
    }
</script>
