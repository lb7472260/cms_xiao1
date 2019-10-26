<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>CMS后台管理系统</title>

    <!-- Bootstrap core CSS-->
    <link href="/libs/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template-->
    <link href="/libs/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template-->
    <link href="/libs/sb-admin/sb-admin.css" rel="stylesheet">
    
    
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		function shenhe(aid,status){
			$.post("/admin/article/updateArticleStatus",{"aid":aid,"status":status},function(data){
				if(data){
					alert("审核铜锅");
					location.href="/admin/article/list"
				}else{
					alert("审核未铜锅");
				}
			},"json")
		}
	</script>
  </head>

  <body id="page-top">

    <!-- 后台管理系统顶部 -->
 	<jsp:include page="_inc_top.jsp"/>

    <div id="wrapper">

      	<!-- 后台管理系统左部菜单 -->
 		<jsp:include page="_inc_left.jsp"/>

      <div id="content-wrapper">

        <div class="container-fluid">

          <!-- 面包屑 -->
          <ol class="breadcrumb">
            <li class="breadcrumb-item">
              <a href="index.html">后台首页</a>
            </li>
            <li class="breadcrumb-item active">文章管理</li>
          </ol>

          <!-- Page Content -->
          <h1>文章管理</h1>
          <hr>
			
			<table class="table">
 
			  <tr>
			    <td>文章ID</td>
			    <td>文章标题</td>
			    <td>文章内容</td>
			    <td>发布人</td>
			    <td>发布时间</td>
			    <td>操作</td>
			  </tr>
			  
			  <c:forEach items="${page.list }" var="l">
			  	<tr>
			    <td>${l.id }</td>
			    <td>${l.title }</td>
			    <td>${l.content }</td>
			    <td>${l.author.nickname }</td>			   
			    <td><fmt:formatDate value="${l.created }" pattern="yyyy-MM-dd"/>
			    </td>
			    
			    <td>
			    	<input type="button" value="通过"  class="btn btn-success" onclick="shenhe('${l.id}',1)">
			    	<input type="button" value="未通过"  class="btn btn-danger" onclick="shenhe('${l.id}',0)">
			    </td>
			  </tr>
			  </c:forEach>
			  
			  <tr align="center">
						<td colspan="6">
							<ul class="pagination" id="page">
								<li><a href="?pageNum=1">&laquo;</a></li>
								<c:forEach var="i" begin="1" end="${page.pages}">
									<li><a href="?pageNum=${i}">${i}</a></li>
								</c:forEach>
								<li><a href="?pageNum=${page.pages}">&raquo;</a></li>
							</ul>
						</td>
					</tr>
			
			</table>
			
			
			
			<%-- <div  align="center">
			  	<ul class="pagination">
					<li><a href="?pageNum=1">首页</a></li>
					<li><a href="?pageNum=${page.pageNum-1<1?page.pageNum:page.pageNum-1 }">上一页</a></li>
					<li><a href="?pageNum=${page.pageNum+1>page.pages?page.pageNum:page.pageNum+1 }">下一页</a></li>					
					<li><a href="?pageNum=${page.pages}">尾页</a></li>
				</ul>
			</div>	 --%>
			
        </div>
        <!-- /.container-fluid -->

        <!-- Sticky Footer -->
        <footer class="sticky-footer">
          <div class="container my-auto">
            <div class="copyright text-center my-auto">
              <span>Copyright © Your Website 2018</span>
            </div>
          </div>
        </footer>

      </div>
      <!-- /.content-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
            <a class="btn btn-primary" href="login.html">Logout</a>
          </div>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="/libs/jquery/jquery.min.js"></script>
    <script src="/libs/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="/libs/sb-admin/sb-admin.min.js"></script>

  </body>

</html>
