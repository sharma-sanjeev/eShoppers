<%@include file="/WEB-INF/views/template/header.jsp" %>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <br>
            <h1>Edit Product</h1>
            <p class="lead">Please edit the following details</p>

            <form:form action="/admin/product/editProduct" method="post" commandName="product"
                       enctype="multipart/form-data">
                <form:hidden path="productId" value="${product.productId}"/>
                <div class="form-group">
                    <label for="name">Name</label><form:errors path="productName" cssStyle="color: red"/>
                    <form:input path="productName" id="name" class="form-control" value="${product.productName}"/>
                </div>
                <div class="form-group">
                    <label for="category">Category</label>
                    <label class="check-box-inline"><form:radiobutton path="productCategory" id="category"
                                                                      value="Mobile"/>Mobile</label>
                    <label class="check-box-inline"><form:radiobutton path="productCategory" id="category"
                                                                      value="Computer"/>Computer</label>
                    <label class="check-box-inline"><form:radiobutton path="productCategory" id="category"
                                                                      value="Watch"/>Watch</label>
                </div>
                <div class="form-group">
                    <label for="description">Description</label>
                    <form:textarea path="productDescription" id="description" class="form-control"
                                   value="${product.productDescription}"/>
                </div>

                <div class="form-group">
                    <label for="price">Price</label><form:errors path="productPrice" cssStyle="color: red"/>
                    <form:input path="productPrice" id="price" class="form-control" value="${product.productPrice}"/>
                </div>

                <div class="form-group">
                    <label for="condition">Condition</label>
                    <label class="check-box-inline"><form:radiobutton path="productCondition" id="condition"
                                                                      value="new"/>New</label>
                    <label class="check-box-inline"><form:radiobutton path="productCondition" id="condition"
                                                                      value="used"/>Used</label>
                </div>

                <div class="form-group">
                    <label for="status">Status</label>
                    <label class="check-box-inline"><form:radiobutton path="productStatus" id="status"
                                                                      value="Active"/>Active</label>
                    <label class="check-box-inline"><form:radiobutton path="productStatus" id="status"
                                                                      value="Inactive"/>Inactive</label>
                </div>
                <div class="form-group">
                    <label for="unitInStock">Units In Stock</label><form:errors path="unitInStock"
                                                                                cssStyle="color: red"/>
                    <form:input path="unitInStock" id="unitInStock" class="form-control"
                                value="${product.unitInStock}"/>
                </div>
                <div class="form-group">
                    <label for="productmanufacturer">Product Manufacturer</label>
                    <form:input path="productManufacturer" id="productmanufacturer" class="form-control"
                                value="${product.productManufacturer}"/>
                </div>

                <div class="form-group">
                    <label for="productimage" class="control-label">Upload Image</label><br>
                    <form:input path="productImage" id="productimage" type="file" class="form:input-large"/>
                </div>

                <br><br>

                <input type="submit" value="submit"/>
                <a href="<c:url value="/admin/productInventory"/>" class="btn">Cancel</a>

            </form:form>

        </div>
    </div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>