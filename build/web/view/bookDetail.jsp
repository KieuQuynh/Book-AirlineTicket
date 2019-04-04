<%-- 
    Document   : bookDetail
    Created on : Mar 15, 2019, 7:56:37 PM
    Author     : admin
--%>

<table>
    <thead>
        <tr>
            <td>Departs</td>
            <td>Arrives</td>
            <td>Flight Detail</td>
            <td></td>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${list2}" var="s">
        <tr>
            <td>${s.getDepart()}</td>
            <td>${s.getArrival()}</td>
            <td>${s.getRoundTime()}</td>
            <td><div class="chooseInfo">
                <input type="radio" required 
                 name="choose2" value="${s.getID()}"/><span class="price">$ ${s.getPrice()}</span>
                </div>
            </td>
        </tr>
    </c:forEach>

</tbody>
</table>