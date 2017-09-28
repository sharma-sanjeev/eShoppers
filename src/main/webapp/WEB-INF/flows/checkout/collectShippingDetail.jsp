<%@include file="/WEB-INF/views/template/header.jsp" %>
<!-----------------------Checkout Page Two: Collect Shipping Details Starts----------------------->
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <br>
            <h1>Customer Details</h1>
            <p class="lead">Please check/fill the following details</p>

            <form:form commandName="order" class="form-horizontal">

                <h3>Shipping Address</h3><br>

                <div class="form-group">
                    <label for="shippingAddressLine1">Address Line 1</label>
                    <form:input path="cart.customer.shippingAddress.addressLine1" id="shippingAddressLine1"
                                class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="shippingAddressLine2">Address Line 2</label>
                    <form:input path="cart.customer.shippingAddress.addressLine2" id="shippingAddressLine2"
                                class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="shippingCity">City</label>
                    <form:input path="cart.customer.shippingAddress.city" id="shippingCity" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="shippingState">State</label>
                    <form:input path="cart.customer.shippingAddress.state" id="shippingState" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="shippingCountry">Country</label>
                    <form:input path="cart.customer.shippingAddress.country" id="shippingCountry" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="shippingPinCode">Pincode</label>
                    <form:input path="cart.customer.shippingAddress.pinCode" id="shippingPinCode" class="form-control"/>
                </div>

                <input type="hidden" name="_flowExecutionKey"/>
                <br><br>

                <button class="btn btn-default" name="_eventId_backToCollectCustomerInfo"
                        class="btn btn-default btn-lg pull-left">Back
                </button>

                <input type="submit" value="Confirm Order" name="_eventId_shippingDetailCollected"
                       class="btn btn-primary btn-lg pull-right"/>

                <button class="btn btn-link" name="_eventId_cancel">Cancel</button>
            </form:form>
            <br>
        </div>
    </div>
</div>
<!-----------------------Checkout Page Two: Collect Shipping Details Ends----------------------->
<%@include file="/WEB-INF/views/template/footer.jsp" %>