<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2023-07-12
  Time: 오후 3:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../includes/header.jsp" %>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Board Get</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">Board Get</div>
            <!-- /.panel-heading -->
            <div class="panel-body">

                <form action="/board/modify" role="form" method="post">
                    <input type="hidden" id="pageNum" value="${cri.pageNum}" name="pageNum">
                    <input type="hidden" id="amount" value="${cri.amount}" name="amount">
					<input type="hidden" value="${cri.type}" name="type">
          			<input type="hidden" value="${cri.keyword}" name="keyword">

                    <div class="form-group">
                        <label>Bno</label>
                        <input class="form-control" name="bno" value="${board.bno}" readonly="readonly">
                    </div>
                    <div class="form-group">
                        <label>Title</label>
                        <input class="form-control" name="title" value="${board.title}">
                    </div>
                    <div class="form-group">
                        <label>Content</label>
                        <textarea rows="3" name="content" class="form-control">${board.content}</textarea>
                    </div>
                    <div class="form-group">
                        <label>Writer</label>
                        <textarea rows="3" name="writer" class="form-control">${board.writer}</textarea>
                    </div>
                    <button type="submit" data-oper="modify" class="btn btn-default">Modify</button>
                    <button type="submit" data-oper="remove" class="btn btn-danger">Remove</button>
                    <button type="submit" data-oper="list" class="btn btn-info">List</button>

                </form>


            </div>
        </div>
        <!-- /.panel-body -->
    </div>
    <!-- /.panel -->
</div>
<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<%@include file="../includes/footer.jsp" %>

<script>
    $(document).ready(function(){
        var formObj = $("form");

        $("button").on("click",function (e){
            e.preventDefault();
            var operation = $(this).data("oper");
            console.log(operation);

            if(operation==="remove"){
                formObj.attr("action","/board/remove");
            }else if(operation==="list") {
                formObj.attr("action","/board/list").attr("method","get");

                var pageNumTag = $("input[name='pageNum']").clone();
                var amountTag = $("input[name='amount']").clone();
                var typeTag= $("input[name='type']").clone();
                var keywordTag= $("input[name='keyword']").clone();

                formObj.empty();
                formObj.append(pageNumTag);
                formObj.append(amountTag);
                formObj.append(typeTag);
                formObj.append(keywordTag);
            }
                formObj.submit();
        })
    });
</script>
