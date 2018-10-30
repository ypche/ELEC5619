<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>


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

    <title>Books</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=basePath %>css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%=basePath %>css/album.css" type="text/css" rel="stylesheet">
    
    <script type="text/javascript">
    	function download(bid) {
    		var str = "";
    		var code = document.getElementById("inputCode");
    		str = bid + "," + code.value;
    		window.location.href="/onlineshopping/delivery/download/" + str;
    	}
    </script>
  </head>

  <body>

    <header>
    	<%@ include file="header.jsp" %>
    </header>

    <main role="main">

      <section class="jumbotron text-center" >
        <div class="container">
          <h1 class="jumbotron-heading">HappyReader</h1>
          
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
						<img class="card-img-top" alt="" src="${book.image}" height="500">
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
	                      <c:choose>
	                      	<c:when test="${book.status == 'InCart' }">
	                      		<button type="button" class="btn btn-sm btn-outline-secondary" disabled>In Cart</button>
	                      	</c:when>
	                      	<c:when test="${book.status == 'Bought' }">
	                      		<button type="button" class="btn btn-sm btn-outline-secondary" disabled>Bought</button>
	                      	</c:when>
	                      	<c:when test="${book.status == 'Delivered' }">
	                      		<button type="button" class="btn btn-sm btn-outline-secondary" data-toggle="modal" data-target="#downloadModal">Download</button>
		                      	<div class="modal fade" id="downloadModal" tabindex="-1" role="dialog" aria-labelledby="downloadModalLabel" aria-hidden="true">
								  <div class="modal-dialog" role="document">
								    <div class="modal-content">
								      <div class="modal-header">
								        <h5 class="modal-title" id="downloadModalLabel">Download</h5>
								        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
								          <span aria-hidden="true">&times;</span>
								        </button>
								      </div>
								      <div class="modal-body">
								      	<div class="form-group">
											<label for="inputCode">Purchase Code</label>
											<input class="form-control" id="inputCode" placeholder="Enter Purchase Code" />
										</div>
								      </div>
								      <div class="modal-footer">
								        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
								        <button type="button" class="btn btn-primary" onClick="download('${book.id}')">OK</button>
								      </div>
								    </div>
								  </div>
								</div>
							</c:when>
	                      	<c:otherwise>
	                      		<button type="button" class="btn btn-sm btn-outline-secondary" onClick="location.href='/onlineshopping/cart/addItem/${book.id}';">Add Cart</button>
	                      	</c:otherwise>
	                      </c:choose>
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
