<%@include file="header.jspf"%>

<form action="register" method="post">
    <fieldset>
        <legend>Register</legend>
        <table>
            <tbody>
            <tr>
                <th>
                    <label for="email">Mail:</label>
                </th>
                <td>
                    <input type="email" name="email" id="email" size="40"
                           maxlength="40" title="mail@example.com" placeholder="Enter Mail"
                           pattern=".{6,40}" required="required">
                </td>
            </tr>
            <tr>
                <th>
                    <label for="password">Password:</label>
                </th>
                <td>
                    <input type="password" name="password" id="password" size="40"
                           maxlength="40" minlength="6" title="6-40 Symbols"
                           placeholder="Enter Password" required="required">
                </td>
            </tr>
            <tr>
                <td/>
                <td>
                    <input type="reset">
                    <input type="submit">
                </td>
            </tr>
            </tbody>
        </table>
    </fieldset>
</form>

<jsp:include page="footer.jspf"/>