<%@include file="/WEB-INF/views/template/search-header.jsp" %>
<!-----------------------Age Search Starts----------------------->
<c:if test="${products.size()>0}">
    <div class="row">
        <div class="col-md-6 col-md-push-3">
            <form:form action="/search/pageThree" method="get" commandName="smartSearch" ng-init="flag = false"
                       ng-hide="flag">
                <div class="form-group">
                    <div id="custom-search-input">
                        <label for="age"><h3><strong> Age of the consumer (3/3) </strong></h3></label>
                        <div class="input-group col-md-12">
                            <form:input
                                    type="number"
                                    class="form-control input-lg"
                                    placeholder="e.g. 21"
                                    path="age"
                                    id="age"
                                    autofocus="autofocus"
                                    min="0"
                                    max="100"/>
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
<!-----------------------Age Search Starts----------------------->
<%@include file="/WEB-INF/views/smartSearchProducts.jsp" %>
<%@include file="/WEB-INF/views/template/search-footer.jsp" %>