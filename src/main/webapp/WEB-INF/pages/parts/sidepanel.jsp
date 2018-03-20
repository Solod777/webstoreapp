<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Collect the nav links, forms, and other content for toggling -->
<div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
	<ul class="nav navbar-nav nav_1">
		<c:forEach items="${categories}" var="categ">
			<li><a href="?id=${categ.id}">${categ.categoryName}</a></li>
		</c:forEach>

	</ul>
</div>
<!-- /.navbar-collapse -->