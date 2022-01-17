
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="#">Start Bootstrap</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a class="nav-link" href="#">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<c:if test="${not empty USERMODEL}">
					<li class="nav-item">
					    <a class="nav-link" href="#">Hello, ${USERMODEL.fullName}</a>
					</li>
					<li class="nav-item">
                    	<a class="nav-link" href="<c:url value="/thoat?action=logout"/>" >Logout</a>
                    </li>
				</c:if>
				<c:if test="${empty USERMODEL}">
                	<li class="nav-item">
                	    <a class="nav-link" href="<c:url value="/dang-nhap?action=login"/>" >Login</a>
                	</li>
                </c:if>
				<li class="nav-item"><a class="nav-link" href="#">Services</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Contact</a></li>
			</ul>
		</div>
	</div>
</nav>