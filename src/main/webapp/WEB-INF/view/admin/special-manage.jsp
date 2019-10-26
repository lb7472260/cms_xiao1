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
    
     <link href="https://cdn.staticfile.org/ionic/1.3.2/css/ionic.css" rel="stylesheet">
     <script src="https://cdn.staticfile.org/ionic/1.3.2/js/ionic.bundle.min.js"></script>
    
    <!-- Bootstrap core CSS-->
    <link href="/libs/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template-->
    <link href="/libs/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template-->
    <link href="/libs/sb-admin/sb-admin.css" rel="stylesheet">


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
              <a href="/admin/adminindex">后台首页</a>
            </li>
            <li class="breadcrumb-item active">用户管理</li>
          </ol>

          <!-- Page Content -->
          <h1>专题管理</h1>
          <hr>
   <!-- 表格 -->
         <button type="button"  class="btn btn-success" onclick="location='/admin/toaddSpecial'">添加专题</button>
          <table class="table table-bordered">
				<tr>
					<td>专题标题</td>
					<td>专题文章</td>
					<td>操作</td>
				</tr>
				<c:forEach var="special" items="${specialList}">
					<tr>
						<td>${special.title}</td>
						<td>${special.middleList.size()}篇</td>
						<td>
							<button  class="btn btn-success" type="button" onclick="location='/admin/getSpecial?specialID=${special.id}'">追加文章</button>
							<button  class="btn btn-success" type="button" onclick="location='/admin/toChangeSpecial?specialID=${special.id}'">修改专题</button>
						</td>
					</tr>
				</c:forEach>
			</table>
          
			
	<!-- 表格完 -->
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
<script type="text/javascript">
	$(".lock").click(function(){
		var id = $(this).val();
		$.post("/admin/lockUser",{"uid":id},function(data){
			location='/admin/userManger';
		},"json");
	});
</script>
</html>
