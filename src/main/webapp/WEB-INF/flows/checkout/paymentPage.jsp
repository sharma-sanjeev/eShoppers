<%@include file="/WEB-INF/views/template/header.jsp" %>
<!-----------------------Checkout Page Four: Payment Page Starts----------------------->
<jsp:useBean id="now" class="java.util.Date"/>
<script src="https://www.paypalobjects.com/api/checkout.js"></script>
<script src="<c:url value="/resources/js/paypal.js" />"></script>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
        </div>
        <div class="Controls">
            <div class="row">
                <form:form commandName="order" class="form-horizontal">
                    <div class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">
                        <div class="text-center">
                            <h1>Payment Options</h1>
                        </div>
                        <div class="row">
                            <table class="table table-hover">
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td class="text-center"><br>
                                        <h4><strong> Amount: &#8377;${order.cart.grandTotal}</strong></h4>
                                    </td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td class="text-center"><br>
                                        <button name="_eventId_paymentPage"
                                                class="btn btn-success btn-lg btn-responsive btn-toolbar">
                                            Cash On Delivery
                                            <span class="glyphicon glyphicon-thumbs-up"></span>
                                        </button>
                                        <br>
                                    </td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td class="text-center"><br>
                                        <div id="paypal-button-container"></div>
                                        <br>
                                    </td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                            </table>
                        </div>
                        <input type="hidden" name="_flowExecutionKey"/>
                        <br><br><br><br>
                        <button class="btn btn-default pull-left" name="_eventId_backToOrderConfirmation">Back</button>
                        <button class="btn btn-default pull-right" name="_eventId_cancel">Cancel</button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
<!-----------------------Checkout Page Four: Payment Page Ends----------------------->
<%@include file="/WEB-INF/views/template/footer.jsp" %>