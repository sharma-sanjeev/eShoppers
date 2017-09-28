<!-----------------------Carousel Starts----------------------->
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img class="first-slide" src="resources/img/10.jpg" alt="First slide">
            <c:if test="${pageContext.request.userPrincipal.name == null}">
                <div class="container">
                    <div class="carousel-caption">

                        <h1 class="pull-left" style="color: red; margin-bottom: -20px">This site is under
                            construction.</h1>
                        <p><a class="btn btn-lg btn-primary pull-right btn-responsive" href="/register" role="button">Sign
                            up today</a></p>
                    </div>
                </div>
            </c:if>
        </div>
        <div class="item">
            <img class="second-slide" src="resources/img/11.jpg" alt="Second slide">
            <c:if test="${pageContext.request.userPrincipal.name == null}">
                <div class="container">
                    <div class="carousel-caption">
                        <p><a class="btn btn-lg btn-primary pull-right btn-responsive" href="/login" role="button">Login
                            Now</a></p>
                    </div>
                </div>
            </c:if>
        </div>
        <div class="item">
            <img class="third-slide" src="resources/img/12.jpg" alt="Third slide">
            <div class="container">
                <div class="carousel-caption">
                    <p><a class="btn btn-lg btn-primary pull-left btn-responsive" href="/product/productList"
                          role="button">Browse Products</a>
                    </p>
                </div>
            </div>
        </div>
    </div>
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
    <div class="pull-right">
        <img src="<c:url value="/resources/paypal_logo.png" />" alt="PayPal" style="height: 50px; margin-right: 15px;">
    </div>
</div>
<!-----------------------Carousel Ends----------------------->