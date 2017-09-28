<%@include file="/WEB-INF/views/template/search-header.jsp" %>
<!-----------------------Budget Search Starts----------------------->
<c:if test="${products.size()>0}">
    <div class="row">
        <div class="col-md-6 col-md-push-3">
            <form:form action="/search/pageTwo" method="get" commandName="smartSearch" ng-init="flag = false"
                       ng-hide="flag">
                <div class="form-group">
                    <div id="custom-search-input">
                        <label for="budget"><h3><strong>What is your approximate budget? (2/3)</strong></h3>
                        </label>
                        <div class="input-group col-md-12">
                            <form:input
                                    type="number"
                                    class="form-control input-lg"
                                    placeholder="10000.0"
                                    path="budget"
                                    id="budget"
                                    autofocus="autofocus"
                                    min="0"/>
                            <span class="input-group-btn">
                        <input type="submit"
                               class="btn btn-info btn-lg"
                               value="Search" ng-click="flag = true"/>
                    </span>
                        </div>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</c:if>
<!-----------------------Budget Search Ends----------------------->
<%@include file="/WEB-INF/views/smartSearchProducts.jsp" %>
<%@include file="/WEB-INF/views/template/search-footer.jsp" %>