<%@include file="/WEB-INF/views/template/search-header.jsp" %>
<!-----------------------Smart Search Starts----------------------->
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <div class="row">
            <div class="col-md-6 col-md-push-3">
                <form:form action="/search/pageOne" method="get" commandName="smartSearch" ng-init="flag = false"
                           ng-hide="flag">
                    <div class="form-group">
                        <div id="custom-search-input">
                            <label for="smartSearchInput"><h3><strong>What you want to shop? (1/3)</strong></h3>
                            </label>
                            <div class="input-group col-md-12">
                                <form:input type="text"
                                            class="form-control input-lg"
                                            placeholder=""
                                            path="smartSearchInput"
                                            id="smartSearchInput"
                                            autofocus="autofocus"/>
                                <span class="input-group-btn">
                        <input type="submit" class="btn btn-info btn-lg" value="Search" ng-click="flag = true"/>
                        </span>
                            </div>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </c:if> <c:if test="${pageContext.request.userPrincipal.name == null}">
        <div class="row">
            <div class="col-md-12 col-md-push-3">
                <h3><strong class="text-center">Please login to continue to use Smart Search!</strong>
                    <a href="/login" type="button" class="btn btn-success btn-lg" value="Login"> Login <span
                            class="glyphicon-hand-right glyphicon">
                                </span></a></h3>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 col-md-push-4">
                <h4><strong class="text-center">Not interested today.</strong>
                    <a href="/product/productList" type="button" class="btn btn-info btn-md" value="Login">Go to
                        Normal Search</a></h4>
            </div>
        </div>
    </c:if>
<!-----------------------Smart Search Ends----------------------->
<%@include file="/WEB-INF/views/template/search-footer.jsp" %>