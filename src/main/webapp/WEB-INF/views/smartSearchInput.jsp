<%@include file="/WEB-INF/views/template/header.jsp" %>
<br><br>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h2>Please share the details of the person who will use this product.</h2>
        </div>
        <div class="row">
            <form:form action="/search/input" method="post" commandName="smartSearch">
                <div class="form-group">
                    <label for="consumer">1. Who is going to use this product?</label><br>
                    <label class="check-box-inline"><form:radiobutton path="consumer"
                                                                      id="consumer"
                                                                      value="Myself"/> Myself </label><br>

                    <label class="check-box-inline"> <form:radiobutton id="consumer" name="consumer" value="Gift"
                                                                       path="consumer"
                                                                       ng-model="content"/> Gift </label>
                    <span ng-show="content == 'Gift'"><strong>for....</strong>
                        <form:input class="form-control"
                                    placeholder="Please enter the relationship"
                                    path="relationship"
                                    id="relationship"/></span>
                    <br>
                    <label class="check-box-inline"><form:radiobutton path="consumer"
                                                                      id="consumer"
                                                                      value="for domestic use"/> Domestic use </label>
                    <br>
                    <label class="check-box-inline"> <form:radiobutton id="consumer" name="consumer" value="Other"
                                                                       path="consumer"
                                                                       ng-model="content"/> Other </label>
                    <span ng-show="content == 'Other'">
                            <form:input class="form-control"
                                        path="consumer"
                                        id="consumer"/></span>
                </div>
                <div class="form-group">
                    <label for="gender">2. Gender of the consumer</label><br>
                    <label class="check-box-inline"><form:radiobutton path="gender" id="gender"
                                                                      value="Male"/> Male </label>
                    <label class="check-box-inline"><form:radiobutton path="gender" id="gender"
                                                                      value="Female"/> Female </label>
                    <label class="check-box-inline"><form:radiobutton path="gender" id="gender"
                                                                      value="Other"/> Other </label>
                </div>
                <div class="form-group">
                    <label for="category">3. Age Group of the consumer</label><br>
                    <label class="check-box-inline"><form:radiobutton path="age" id="category"
                                                                      value="5"/> less than 10 </label><br>
                    <label class="check-box-inline"><form:radiobutton path="age" id="category"
                                                                      value="15"/> 10-20 </label><br>
                    <label class="check-box-inline"><form:radiobutton path="age" id="category"
                                                                      value="25"/> 20-30 </label><br>
                    <label class="check-box-inline"><form:radiobutton path="age" id="category"
                                                                      value="35"/> 30-40 </label><br>
                    <label class="check-box-inline"><form:radiobutton path="age" id="category"
                                                                      value="45"/> 40-50 </label><br>
                    <label class="check-box-inline"><form:radiobutton path="age" id="category"
                                                                      value="55"/> 50-60 </label><br>
                    <label class="check-box-inline"><form:radiobutton path="age" id="category"
                                                                      value="65"/> 60-70 </label><br>
                    <label class="check-box-inline"><form:radiobutton path="age" id="category"
                                                                      value="75"/> more than 70 </label><br>
                </div>
                <div class="form-group">
                    <label for="smartSearchInput">4. What was there in your mind, when you bought these
                        product(s)?</label>
                    <form:textarea type="text" class="form-control" placeholder="Please enter one or more sentence..."
                                   path="smartSearchInput" id="smartSearchInput"/>
                </div>
                <br>
                <input type="submit" value="Submit " class="btn btn-success">
            </form:form>
            <a href="<c:url value="/"/>" class="btn btn-default pull-right">Cancel</a>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/views/template/footer.jsp" %>

