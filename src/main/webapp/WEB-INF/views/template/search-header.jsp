<%@include file="/WEB-INF/views/template/header.jsp" %>
<!-----------------------Search Header Starts----------------------->
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <br>
            <div>
                <h3 class="text-center"> Welcome to Smart Search! </h3>
                <h5 class="text-center"> (A Community based commodity search.)</h5>
            </div>
        </div>
        <div class="row" ng-show="flag">
            <div class="col-md-4 col-md-push-4 text-center">
                <div class="show" id="pleaseWaitDialog" data-backdrop="static" data-keyboard="false">
                    <br>
                    <h4>Searching...</h4>
                    <div><img src="<c:url value="/resources/ajax-loader.gif"/>"></div>
                </div>
            </div>
        </div>
<!-----------------------Search Header Ends----------------------->