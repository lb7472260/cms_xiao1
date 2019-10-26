<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>我的个人空间</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" type="text/css" href="/libs/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="/css/cms.css"/>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style type="text/css">
    </style>
  </head>
  <body>
    <jsp:include page="/WEB-INF/inc/top.jsp"></jsp:include>
	<br/>
	<!-- 横幅 -->
	<div class="container">
		<div class="row">
			<div class="col-md-12 my_banner">
			</div>
		</div>
	</div>
	<br/>
	<!-- 主体内容区 -->
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<jsp:include page="/WEB-INF/inc/my_left.jsp"></jsp:include>
				<br/>
			</div>
			<div class="col-md-9">
				<div class="panel panel-default">
				  <div class="panel-body">
				 <!--    右边区域 -->
				 	<c:forEach items="${articleList}" var="article">
				 		<div class="content">
						${article.content}
						</div>
						<div class="text-left">
						浏览量: ${article.hits} 	发布时间 ：<fmt:formatDate value="${article.created}" pattern="yyyy-MM-dd HH:mm:ss"/> 
						</div>
						<div class="text-right">
							
							
							<c:choose>
								<c:when test="${article.status==0}">
									<span style="color:red;">审核未通过</span>
								</c:when>
								<c:when test="${article.status==1}">
									<span style="color:green;">审核通过</span>
								</c:when>
								
								
								<c:otherwise>
									<span style="color:gray;">审核中</span>
								</c:otherwise>
							</c:choose>
							
							<input type="button" class="btn btn-danger" value="删除">
						</div>
							<hr/>
				 	</c:forEach>
					 
				
					
				
					<hr/>
				 
				  </div>	
				</div>
				
			</div>
		</div>
	</div>
	
	<jsp:include page="/WEB-INF/inc/footer.jsp"/>
	
	<script type="text/javascript">
		
	</script>
  </body>
</html>