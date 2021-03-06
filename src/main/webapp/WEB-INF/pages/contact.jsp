<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Grocery Store a Ecommerce Online Shopping Category Flat
	Bootstrap Responsive Website Template | Products :: w3layouts</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Grocery Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!-- //for-mobile-apps -->
<link href="resources/css/bootstrap.css" rel="stylesheet"
	type="text/css" media="all" />
<link href="resources/css/style.css" rel="stylesheet" type="text/css"
	media="all" />
<!-- font-awesome icons -->
<link href="resources/css/font-awesome.css" rel="stylesheet"
	type="text/css" media="all" />
<!-- //font-awesome icons -->
<!-- js -->
<script src="resources/js/jquery-1.11.1.min.js"></script>
<!-- //js -->
<link
	href='//fonts.googleapis.com/css?family=Ubuntu:400,300,300italic,400italic,500,500italic,700,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic'
	rel='stylesheet' type='text/css'>
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event) {
			event.preventDefault();
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top
			}, 1000);
		});
	});
</script>
<!-- start-smoth-scrolling -->
</head>

<body>
	<!-- header -->
	<jsp:include page="parts/head.jsp" />
	<!-- //header -->
	<!-- products-breadcrumb -->
	<div class="products-breadcrumb">
		<div class="container">
			<ul>
				<li><i class="fa fa-home" aria-hidden="true"></i><a href="./">Home</a><span>|</span></li>
				<li>Mail Us</li>
			</ul>
		</div>
	</div>
	<!-- //products-breadcrumb -->
	<!-- banner -->
	<div class="banner">
		<div class="w3l_banner_nav_left">
			<nav class="navbar nav_bottom">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header nav_2">
					<button type="button"
						class="navbar-toggle collapsed navbar-toggle1"
						data-toggle="collapse" data-target="#bs-megadropdown-tabs">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>
				<!-- Side menu -->
				<jsp:include page="parts/sidepanel.jsp" />
				<!-- /.Side menu -->
			</nav>
		</div>
		<div class="w3l_banner_nav_right">
			<!-- mail -->
			<div class="mail">
				<h3>Mail Us</h3>
				<div class="agileinfo_mail_grids">
					<div class="col-md-4 agileinfo_mail_grid_left">
						<ul>
							<li><i class="fa fa-home" aria-hidden="true"></i></li>
							<li>address<span>3457 Hollow Way, Boise ID.</span></li>
						</ul>
						<ul>
							<li><i class="fa fa-envelope" aria-hidden="true"></i></li>
							<li>email<span><a href="mailto:info@example.com">office@sympatic.eu</a></span></li>
						</ul>
						<ul>
							<li><i class="fa fa-phone" aria-hidden="true"></i></li>
							<li>call to us<span>(+48) 732 981 462</span></li>
						</ul>
					</div>
					<div class="col-md-8 agileinfo_mail_grid_right">
						<form action="#" method="post">
							<div class="col-md-6 wthree_contact_left_grid">
								<input type="text" name="Name" value="Name*"
									onfocus="this.value = '';"
									onblur="if (this.value == '') {this.value = 'Name*';}"
									required=""> <input type="email" name="Email"
									value="Email*" onfocus="this.value = '';"
									onblur="if (this.value == '') {this.value = 'Email*';}"
									required="">
							</div>
							<div class="col-md-6 wthree_contact_left_grid">
								<input type="text" name="Telephone" value="Phone Number*"
									onfocus="this.value = '';"
									onblur="if (this.value == '') {this.value = 'Telephone*';}"
									required=""> <input type="text" name="Subject"
									value="Subject*" onfocus="this.value = '';"
									onblur="if (this.value == '') {this.value = 'Subject*';}"
									required="">
							</div>
							<div class="clearfix"></div>
							<textarea name="Message" onfocus="this.value = '';"
								onblur="if (this.value == '') {this.value = 'Message...';}"
								required="">Message...</textarea>
							<input type="submit" value="Submit"> <input type="reset"
								value="Clear">
						</form>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			<!-- //mail -->
		</div>
		<div class="clearfix"></div>
	</div>
	<!-- //banner -->
	<!-- map -->
	<div class="map">
		<iframe
			src="https://www.google.com/maps/embed?pb=!1m16!1m12!1m3!1d96748.15352429623!2d-74.25419879353115!3d40.731667701988506!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!2m1!1sshopping+mall+in+New+York%2C+NY%2C+United+States!5e0!3m2!1sen!2sin!4v1467205237951"
			style="border: 0"></iframe>
	</div>
	<!-- //map -->
	<!-- footer -->
	<jsp:include page="parts/footer.jsp" />
	<!-- //footer -->
	<!-- Bootstrap Core JavaScript -->
	<script src="resources/js/bootstrap.min.js"></script>
	<script>
		$(document).ready(function() {
			$(".dropdown").hover(function() {
				$('.dropdown-menu', this).stop(true, true).slideDown("fast");
				$(this).toggleClass('open');
			}, function() {
				$('.dropdown-menu', this).stop(true, true).slideUp("fast");
				$(this).toggleClass('open');
			});
		});
	</script>
	<!-- here stars scrolling icon -->
	<script type="text/javascript">
		$(document).ready(function() {
			/*
				var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
				};
			 */

			$().UItoTop({
				easingType : 'easeOutQuart'
			});

		});
	</script>
	<!-- //here ends scrolling icon -->
	<script src="resources/js/minicart.js"></script>
	<script>
		paypal.minicart.render();

		paypal.minicart.cart
				.on(
						'checkout',
						function(evt) {
							var items = this.items(), len = items.length, total = 0, i;

							// Count the number of each item in the cart
							for (i = 0; i < len; i++) {
								total += items[i].get('quantity');
							}

							if (total < 3) {
								alert('The minimum order quantity is 3. Please add more to your shopping cart before checking out');
								evt.preventDefault();
							}
						});
	</script>
	s
</body>
</html>