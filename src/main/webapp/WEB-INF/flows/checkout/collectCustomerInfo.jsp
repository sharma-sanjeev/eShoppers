<%@include file="/WEB-INF/views/template/header.jsp" %>
<!-----------------------Checkout Page One: Collect Customer Info Starts----------------------->
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <br>
            <h1>Customer Details</h1>
            <br>
            <p class="lead">Please check/fill the following details</p>
            <form:form commandName="order" class="form-horizontal">
                <h3>Basic Information</h3><br>

                <div class="form-group">
                    <label for="customerName">Name</label>
                    <form:input path="cart.customer.customerName" id="customerName" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="customerEmail">Email</label>
                    <form:input path="cart.customer.customerEmail" id="customerEmail" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="customerPhone">Contact No.</label>
                    <form:input path="cart.customer.customerPhone" id="customerPhone" class="form-control"/>
                </div><br>

                <h3>Billing Address</h3><br>

                <div class="form-group">
                    <label for="billingAddressLine1">Address Line 1</label>
                    <form:input path="cart.customer.billingAddress.addressLine1" id="billingAddressLine1"
                                class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="billingAddressLine2">Address Line 2</label>
                    <form:input path="cart.customer.billingAddress.addressLine2" id="billingAddressLine2"
                                class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="billingCity">City</label>
                    <form:input path="cart.customer.billingAddress.city" id="billingCity" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="billingState">State</label>
                    <form:input path="cart.customer.billingAddress.state" id="billingState" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="billingCountry">Country</label>
                    <form:input path="cart.customer.billingAddress.country" id="billingCountry" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="billingPinCode">Pincode</label>
                    <form:input path="cart.customer.billingAddress.pinCode" id="billingPinCode" class="form-control"/>
                </div>

                <input type="hidden" name="_flowExecutionKey"/>
                <br><br>
                <input type="submit" value="Next" name="_eventId_customerInfoCollected"
                       class="btn btn-primary btn-lg pull-right"/>

                <button class="btn btn-link" name="_eventId_cancel">Cancel</button>
            </form:form>
            <br>
        </div>
    </div>
</div>
<!-----------------------Checkout Page One: Collect Customer Info Ends----------------------->
<%@include file="/WEB-INF/views/template/footer.jsp" %>