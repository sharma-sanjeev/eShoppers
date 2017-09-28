<%@include file="/WEB-INF/views/template/header.jsp" %>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <br>
            <h1>Register Customer</h1>
            <p class="lead">Please fill in your information</p>
            <p class="pull-right">* Mandatory fields.</p>
            <form:form action="/register" method="post" commandName="customer">

                <h3>Basic Info</h3>

                <div class="form-group">
                    <label for="customerName">Name* </label>
                    <c:if test="${not empty msg}">
                        <msg class="error" style="color: red">${error}</msg>
                    </c:if>
                    <form:input path="customerName" id="name" class="form-control" autofocus="autofocus" />
                </div>

                <div class="form-group">
                    <label for="customerEmail">Email* </label>
                    <span style="color: red;">${emailMsg}</span>
                    <form:errors path="customerEmail" cssStyle="color: red"/>
                    <form:input path="customerEmail" id="email" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="customerPhone">Contact Number </label>
                    <form:input path="customerPhone" id="phone" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="username">Username* </label>
                    <span style="color: red;">${usernameMsg}</span>
                    <form:errors path="username" cssStyle="color: red"/>
                    <form:input path="username" id="username" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="password">Password* </label>
                    <form:errors path="password" cssStyle="color: red"/>
                    <form:password path="password" id="password" class="form-control"/>
                </div>

                <h3>Billing Address</h3>

                <div class="form-group">
                    <label for="billingAddressLine1">Address Line 1</label>
                    <form:input path="billingAddress.addressLine1" id="billingAddressLine1" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="billingAddressLine2">Address Line 2</label>
                    <form:input path="billingAddress.addressLine2" id="billingAddressLine2" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="billingCity">City</label>
                    <form:input path="billingAddress.city" id="billingCity" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="billingState">State</label>
                    <form:input path="billingAddress.state" id="billingState" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="billingCountry">Country</label>
                    <form:input path="billingAddress.country" id="billingCountry" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="billingPinCode">Pincode</label>
                    <form:input path="billingAddress.pinCode" id="billingPinCode" class="form-control"/>
                </div>

                <h3>Shipping Address</h3>
                <p>
                    <input type="checkbox" name="copyAddress" onclick="FillShiiping(this.form)">
                    <em><strong>Check this box if Billing Address and Shipping Address are the same.</strong></em>
                </p>
                <div class="form-group">

                    <label for="shippingAddressLine1">Address Line 1</label>
                    <form:input path="shippingAddress.addressLine1" id="shippingAddressLine1" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="shippingAddressLine2">Address Line 2</label>
                    <form:input path="shippingAddress.addressLine2" id="shippingAddressLine2"
                                class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="shippingCity">City</label>
                    <form:input path="shippingAddress.city" id="shippingCity" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="shippingState">State</label>
                    <form:input path="shippingAddress.state" id="shippingState" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="shippingCountry">Country</label>
                    <form:input path="shippingAddress.country" id="shippingCountry" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="shippingPinCode">Pincode</label>
                    <form:input path="shippingAddress.pinCode" id="shippingPinCode" class="form-control"/>
                </div>

                <br><br>

                <input type="submit" value="submit"/>
                <a href="<c:url value="/"/>" class="btn">Cancel</a>
            </form:form>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>