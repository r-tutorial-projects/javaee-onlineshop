<%@include file="header.jspf"%>

<form action="sell" method="post" enctype="multipart/form-data">
    <fieldset>
        <legend>Sell products</legend>
        <table>
            <tbody>
            <tr>
                <th>
                    <label for="title">Title:</label>
                </th>
                <td>
                    <input type="text" name="title" id="title" size="40"
                           maxlength="40" title="Title for the product" placeholder="Enter title"
                           pattern=".{6,40}" required="required">
                </td>
            </tr>
            <tr>
                <th>
                    <label for="description">Description:</label>
                </th>
                <td>
                    <textarea name="description" id="description" cols="100" rows="10" maxlength="1000"></textarea>
                </td>
            </tr>
            <tr>
                <th>
                    <label for="price">Price:</label>
                </th>
                <td>
                    <input type="number" name="price" id="price" size="40" maxlength="40" title="Price for the article"
                           placeholder="Enter price" pattern=".{1,40}" required="required">
                </td>
            </tr>
            <tr>
                <th>
                    <label for="foto">Foto:</label>
                </th>
                <td>
                    <input type="file" name="foto" id="foto">
                </td>
            </tr>
            <tr>
                <td/><td>
                <input type="reset">
                <input type="submit">
            </td>
            </tr>
            </tbody>
        </table>
    </fieldset>
</form>

<jsp:include page="footer.jspf"/>