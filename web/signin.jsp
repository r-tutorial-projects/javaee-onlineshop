<%@include file="header.jspf"%>

<%@page import="de.rubeen.javaee.buch.onlineshop.model.*" %>
<%
    String mail = request.getParameter("email");
    String password = request.getParameter("password");
    if(mail != null && password != null) {
        Customer customer = new Customer();
        customer.setEmail(mail);
        customer.setPassword(password);
        pageContext.setAttribute("customer", customer, PageContext.SESSION_SCOPE);
        request.getSession().getServletContext().log("Mail: " + mail + "; Password: " + password);
    }
%>

<form action="signin" method="post">
    <fieldset>
        <legend>SignIn</legend>
        <table>
            <tbody>
            <tr>
                <th>
                    <label for="email">Mail:</label>
                </th>
                <td>
                    <input type="email" name="email" id="email" size="40"
                           maxlength="40" title="mail@example.com" placeholder="Enter Mail"
                           minlength="6" required="required">
                </td>
            </tr>
            <tr>
                <th>
                    <label for="password">Password:</label>
                </th>
                <td>
                    <input type="password" name="password" id="password" size="40"
                           maxlength="40" title="6-40 Symbols" placeholder="Enter Password"
                           minlength="6" required="required">
                </td>
            </tr>
            <tr>
                <td /><td>
                    <input type="reset">
                    <input type="submit">
                </td>
            </tr>
            </tbody>
        </table>
    </fieldset>
</form>

<jsp:include page="footer.jspf"/>