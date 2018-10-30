<%
      String headerPath = request.getContextPath();
      String headerBasePath = request.getScheme() + "://"
                  + request.getServerName() + ":" + request.getServerPort()
                  + headerPath + "/";
%>

<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
<div class="container">
     <a href="<%=headerBasePath %>book/getBooks" class="navbar-brand d-flex align-items-center">
       <img width="20" height="20" alt="" src="https://doc-00-88-docs.googleusercontent.com/docs/securesc/1lhra9ur6rbc8etdjasmei79ag64jeuu/725dvpemcaa8gcnqjp5f9elovo0tunp2/1540900800000/01552601290929276177/01552601290929276177/1xsv1SLUU0uBRiop9xazGwArXswPAl3XW?e=download&nonce=f1ju7vdo00m3m&user=01552601290929276177&hash=omdjkaps6nrjuinda3nnlllp0o6huvj2">
       <strong>&nbspHappyReader</strong>
     </a>
     <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
       <span class="navbar-toggler-icon"></span>
     </button>
     <div class="collapse navbar-collapse" id="navbarsExampleDefault">
       <ul class="navbar-nav mr-auto">
         <li class="nav-item">
           <a class="nav-link" href="<%=headerBasePath%>">Home</a>
         </li>

         <c:choose>
          <c:when test="${sessionScope.role == 'admin' }">
          	<li class="nav-item">
          		<a class="nav-link" href="<%=headerBasePath %>book/addBook">Add Book</a>
          	</li>
          	<li class="nav-item">
          		<a class="nav-link" href="<%=headerBasePath%>delivery">Delivery</a>
          	</li>
          	<li class="nav-item">
          		<a class="nav-link" href="<%=headerBasePath%>user/manage">Manage User</a>
          	</li>
          </c:when>
          <c:when test="${sessionScope.role == 'user' }">
	          <li class="nav-item">
	            <a class="nav-link" href="<%=headerBasePath%>cart">Cart</a>
	          </li>
          </c:when>
         </c:choose>
       </ul>
       <c:choose>
       	<c:when test="${sessionScope.userID eq null}">
       		<div class="span12">
				<a class="btn btn-outline-info" href="<%=headerBasePath%>user/register" role="button">Signup</a>&nbsp
				<a class="btn btn-outline-success" href="<%=headerBasePath%>user/login" role="button">Signin</a>
			</div>
       	</c:when>
       	<c:otherwise>
       		<a class="btn btn-dark" href="" role="button">${username}</a>&nbsp
       		<a class="btn btn-secondary" href="<%=headerBasePath %>user/logout" role="button">Logout</a>
       	</c:otherwise>
       </c:choose>
     </div>
     </div>
   </nav>
