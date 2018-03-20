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
<script type="text/javascript" src="resources/js/move-top.js"></script>
<script type="text/javascript" src="resources/js/easing.js"></script>
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
				<li>${categoryName}</li>
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
			<div class="w3ls_w3l_banner_nav_right_grid">
				<br>
				<h3>${categoryName}</h3>
				<div class="w3ls_w3l_banner_nav_right_grid1">

					<c:forEach items="${products}" var="product">
						<div class="col-md-3 top_brand_left">
							<div class="hover14 column">
								<div class="agile_top_brand_left_grid">
									<div class="agile_top_brand_left_grid_pos">
										<img src="resources/images/offer.png" alt=" "
											class="img-responsive" />
									</div>
									<div class="agile_top_brand_left_grid1">
										<figure>
											<div class="snipcart-item block">
												<div class="snipcart-thumb">
													<a href="single.html"><img src="${product.image}"
														alt=" " class="img-responsive" /></a>
													<p>${product.pruductName}</p>
													<h4>${product.price}</h4>
												</div>
												<div class="snipcart-details top_brand_home_details">
													<form action="#" method="post">
														<fieldset>
															<input type="hidden" name="cmd" value="_cart" /> <input
																type="hidden" name="add" value="1" /> <input
																type="hidden" name="business" value=" " /> <input
																type="hidden" name="item_name" value="dogs food" /> <input
																type="hidden" name="amount" value="9.00" /> <input
																type="hidden" name="discount_amount" value="1.00" /> <input
																type="hidden" name="currency_code" value="USD" /> <input
																type="hidden" name="return" value=" " /> <input
																type="hidden" name="cancel_return" value=" " /> <input
																type="submit" name="submit" value="Add to cart"
																class="button" />
														</fieldset>
													</form>
												</div>
											</div>
										</figure>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>


					<div class="clearfix"></div>
				</div>
			</div>
		</div>
		<div class="clearfix"></div>
	</div>
	<!-- //banner -->
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
</body>
</html>