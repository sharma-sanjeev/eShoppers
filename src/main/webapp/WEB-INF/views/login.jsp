<%@include file="/WEB-INF/views/template/header.jsp" %>
<br><br><br>
<div class="container">
    <form class="form-signin" name="loginForm" action="<c:url value="/j_spring_security_check"/>" method="post">
        <h2 class="form-signin-heading">Please Login</h2>
        <h4>to continue</h4>
        <c:if test="${not empty msg}">
            <div class="msg">${msg}</div>
        </c:if>
        <c:if test="${not empty error}">
            <div class="error" style="color: red">${error}</div>
        </c:if>

        <label for="username" class="sr-only">Username</label>
        <input type="text" id="username" class="form-control" placeholder="Username" name="username" required
               autofocus>
        <br>
        <label for="password" class="sr-only">Password</label>
        <input type="password" id="password" class="form-control" placeholder="Password" name="password"
               required>
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> Remember me
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
        <input type="hidden" name="${_carf.parameterName}" value="${_csrf_token}">
        <br>
        <a href="/register">Register Now</a>
    </form>
</div>
<%--Redirect to correct URL--%>
<c:if test="${pageContext.request.userPrincipal.name == null}">
    <% String url = request.getHeader("referer");
        session.setAttribute("url", url); %>
</c:if>
<c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
    <c:redirect url="/admin"/>
</c:if>
<c:if test="${pageContext.request.userPrincipal.name != null}">
    <% String newUrl = "";
        String oldUrl = String.valueOf(session.getAttribute("url"));
        if (oldUrl.contains("error") ||
                oldUrl.contains("logout") ||
                oldUrl.contains("login") ||
                oldUrl.contains("checkout") ||
                oldUrl.contains("admin") ||
                oldUrl.contains("register")) {
            newUrl = "/";
        } else {
            newUrl = oldUrl;
        }
        session.setAttribute("newUrl", newUrl);
    %>
    <c:redirect url="${newUrl}"/>
</c:if>
<div class="container">
    <div class="row">
        <div class="col-xl-6 push-xl-3 m-2-md col-sm-8 push-sm-2 pull-right">
            <div class="card">
                <div class="card-block">
                    <div class="card-title"><br>
                        <h2>Is this your first time here?</h2>
                    </div>
                    <div>
                        <h5><span>To explore this site for testing purpose, log in with the role of:</span></h5>
                        <form action="<c:url value="/j_spring_security_check?username=customer&password=customer"/>"
                              method="post">
                            <p>
                                <button class="btn btn-sm btn-primary" type="submit">Customer Direct Login</button>
                                - or with the username <b>customer </b>and password <b>customer</b>
                            </p>
                        </form>
                        <form action="<c:url value="/j_spring_security_check?username=admin&password=admin"/>"
                              method="post">
                            <p>
                                <button class="btn btn-sm btn-primary" type="submit">Admin Direct Login</button>
                                - or with the username <b>admin</b> and password <b>admin</b>
                            </p>
                        </form>
                        <p>
                            <a class="btn btn-sm btn-primary" href="/register">Register Now</a>
                            - to register as a new customer
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>