<%@include file="header.jspf"%>

<article>
    <section>
        <form action="buy" method="post">
            <fieldset>
                <legend>Search</legend>
                <table>
                    <tbody>
                    <tr>
                        <th>
                            <label for="search">Search:</label>
                        </th>
                        <td>
                            <input type="search" name="search" id="search" size="40"
                                    maxlength="40" title="text to search" placeholder="enter text to search for">
                        </td>
                        <td>
                            <input type="reset">
                            <input type="submit">
                        </td>
                    </tr>
                    </tbody>
                </table>
            </fieldset>
        </form>
    </section>
</article>

<jsp:include page="footer.jspf"/>