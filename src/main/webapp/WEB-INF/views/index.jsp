<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%
      String path = request.getContextPath();
      String basePath = request.getScheme() + "://"
                  + request.getServerName() + ":" + request.getServerPort()
                  + path + "/";
%>

<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>Album example for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=basePath %>css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%=basePath %>css/album.css" type="text/css" rel="stylesheet">
  </head>

  <body>

    <header>
      <div class="collapse bg-dark" id="navbarHeader">
        <div class="container">
          <div class="row">
            <div class="col-sm-8 col-md-7 py-4">
              <h4 class="text-white">About</h4>
              <p class="text-muted">Add some information about the album below, the author, or any other background context. Make it a few sentences long so folks can pick up some informative tidbits. Then, link them off to some social networking sites or contact information.</p>
            </div>
            <div class="col-sm-4 offset-md-1 py-4">
              <h4 class="text-white">Contact</h4>
              <ul class="list-unstyled">
                <li><a href="#" class="text-white">Follow on Twitter</a></li>
                <li><a href="#" class="text-white">Like on Facebook</a></li>
                <li><a href="#" class="text-white">Email me</a></li>
              </ul>
            </div>
          </div>
        </div>
      </div>
      <div class="navbar navbar-dark bg-dark box-shadow">
        <div class="container d-flex justify-content-between">
          <a href="#" class="navbar-brand d-flex align-items-center">
            <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="mr-2"><path d="M23 19a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h4l2-3h6l2 3h4a2 2 0 0 1 2 2z"></path><circle cx="12" cy="13" r="4"></circle></svg>
            <strong>HappyReader</strong>
          </a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarHeader" aria-controls="navbarHeader" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
        </div>
      </div>
    </header>

    <main role="main">

      <section class="jumbotron text-center" >
        <div class="container">
          <h1 class="jumbotron-heading">HappyReader</h1>
          <p class="lead text-muted">Something short and leading about the collection below—its contents, the creator, etc. Make it short and sweet, but not too short so folks don't simply skip over it entirely.</p>
		
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
  			<a class="navbar-brand" href="#">Category</a>		
	  		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
	   			 <div class="navbar-nav">
				      <a class="nav-item nav-link col-sm-5" href="<%=basePath %>book/genre/children">Children</a>
				      <a class="nav-item nav-link col-sm-5" href="<%=basePath %>book/genre/Science">Science</a>
				      <a class="nav-item nav-link col-sm-5" href="<%=basePath %>book/genre/Toolbook">Toolbook</a>
				      <a class="nav-item nav-link col-sm-5" href="<%=basePath %>book/genre/Family">Family</a>
	   			 </div>
	  		</div>
		</nav>
          <form class="input-group" action="search/${keyword}">
			<input type="text" class="form-control input-lg"  method="post" name="keyword"  >
			<button class="input-group-addon btn btn-primary" type="submit" > Search</button>
		  </form>
        </div>
      </section>

      <div class="album py-5 bg-light">
        <div class="container">

          <div class="row">
         	<c:forEach items="${requestScope.pageBean.list}" var="book">
	            <div class="col-md-4">
	              <div class="card mb-4 box-shadow">
              		<c:if test="${book.image!=null}">
						<img class="card-img-top" alt="" src="/image/${book.image}" width="200" height="300">
					</c:if>
	<!--                 <img class="card-img-top" data-src="holder.js/100px225?theme=thumb&bg=55595c&fg=eceeef&text=Thumbnail" alt="Card image cap"> -->
	                <div class="card-body">
	                 <p class="card-text" style="color: navy; font-family: sans-serif; font-weight: bold;" ><a href="<%=basePath %>book/${book.id}">${book.title}</a></p>
	                 <div >
	                 	Author:<span class="card-text" style="color:activeborder; font-family: sans-serif;"> ${book.author}</span>
	                 </div>
	                 <hr>
	                 <%--  <p class="card-text" style="font-weight:600; font-family: sans-serif;">Description:</p>
	                  <p class="card-text">${book.description}</p> --%>
	                  <div class="d-flex justify-content-between align-items-center">
	                    <div class="btn-group">
	                      <button type="button" class="btn btn-sm btn-outline-secondary">To Wishlist</button>
	                      <button type="button" class="btn btn-sm btn-outline-secondary">Add Cart</button>
	                    </div>
	                    <small class="text-muted">Price: $${book.price}</small>
	                  </div>
	                </div>
	              </div>
	            </div>
			</c:forEach>
          </div>
        </div>
      </div>
      
     <!-- --------------------------------分页功能--------------------------------- --> 
    <div class="container" align="center">
		<%-- 构建分页导航 --%>
		<p style="font-weight: bold;">Total book number:<span style="color: olive;">${requestScope.pageBean.totalRecord}</span></p> 
		<p style="font-weight: bold;">Total Pages:<span style="color: olive;">${requestScope.pageBean.totalPage}</span></p> 
		<p style="font-weight: bold;">Current Page:<span style="color: olive;">${requestScope.pageBean.pageNum}</span></p> 
		
		<button><a	href="${pageContext.request.contextPath}/book/getBooks?pageNum=1">First Page</a></button>	
		<%--如果当前页为第一页时，就没有上一页这个超链接显示 --%>	
			<c:if test="${requestScope.pageBean.pageNum ==1}">		
				<c:forEach begin="${requestScope.pageBean.start}"			
					end="${requestScope.pageBean.end}" step="1" var="i">			
					<c:if test="${requestScope.pageBean.pageNum == i}">                        
						${i}                   
					</c:if>			
				 	<c:if test="${requestScope.pageBean.pageNum != i}">				
					 	<a	href="${pageContext.request.contextPath}/book/getBooks?pageNum=${i}">${i}</a>			
					</c:if>		
			 	</c:forEach>		
				 	<a	href="${pageContext.request.contextPath}/book/getBooks?pageNum=${requestScope.pageBean.pageNum+1}">Next</a>	
		 	</c:if>
		 	
		 	<%--如果当前页不是第一页也不是最后一页，则有上一页和下一页这个超链接显示 --%>	
		 	<c:if test="${requestScope.pageBean.pageNum > 1 && requestScope.pageBean.pageNum < requestScope.pageBean.totalPage}">	
		 		<a	href="${pageContext.request.contextPath}/book/getBooks?pageNum=${requestScope.pageBean.pageNum-1}">Previous</a>		
		 		<c:forEach begin="${requestScope.pageBean.start}" end="${requestScope.pageBean.end}" step="1" var="i">
		 			<c:if test="${requestScope.pageBean.pageNum == i}">
		 			  ${i} 
		 			</c:if>			
			 		<c:if test="${requestScope.pageBean.pageNum != i}">			
			 			<a	href="${pageContext.request.contextPath}/book/getBooks?pageNum=${i}">${i}</a>
			 		</c:if>		
			   </c:forEach>		
			   	<a href="${pageContext.request.contextPath}/book/getBooks?pageNum=${requestScope.pageBean.pageNum+1}">Next</a>
		     </c:if>
		     
		    <%--如果当前页是最后一页，则有上一页超链接显示 --%>	
		 	<c:if test="${requestScope.pageBean.pageNum == requestScope.pageBean.totalPage}">	
		 		<a	href="${pageContext.request.contextPath}/book/getBooks?pageNum=${requestScope.pageBean.pageNum-1}">Previous</a>		
		 		<c:forEach begin="${requestScope.pageBean.start}" end="${requestScope.pageBean.end}" step="1" var="i">
		 			<c:if test="${requestScope.pageBean.pageNum == i}">
		 			  ${i} 
		 			</c:if>			
			 		<c:if test="${requestScope.pageBean.pageNum != i}">			
			 			<a	href="${pageContext.request.contextPath}/book/getBooks?pageNum=${i}">${i}</a>
			 		</c:if>		
			   </c:forEach>	
		     </c:if>
		     
		     <%--尾页 --%>
		<button><a href="${pageContext.request.contextPath}/book/getBooks?pageNum=${requestScope.pageBean.totalPage}">Last Page</a></button>
	     
	 </div> 
	 
	   <!-- --------------------------------分页功能--------------------------------- --> 

    </main>

	<br><br><br>
    <footer class="footerCus">
      <div class="container">
        <p>Album example is &copy; Bootstrap, but please download and customize it for yourself!</p>
        <p>New to Bootstrap? Visit the homepage or read our getting started guide.</p>
      </div>
    </footer>

    <!-- Bootstrap core JavaScript ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
  	<script src="<%=basePath %>js/popper.min.js"></script> 
    <script src="<%=basePath %>js/bootstrap.min.js"></script>
	<script src="<%=basePath %>js/holder.min.js"></script> 
  </body>
</html>