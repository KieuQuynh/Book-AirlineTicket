<%-- 
    Document   : infoBook
    Created on : Mar 15, 2019, 9:10:53 PM
    Author     : admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${error eq 'true'}">
   No Results
</c:if>
<c:forEach items="${map}" var="item">
<div class="infoBook">
    <div class="box1">
        <h3>E Ticket Receipt</h3>
        <div class="detail">
            <p>Prepared For</p>
            <p class="nameBooker">${item.value.get(0).getFirstName()}  ${item.value.get(0).getLastName()}</p>
            <p class="Rcode">Reservation Code:<span>${item.key}</span></p>
            <p class ="time">Ticket Issue Date:<span>${item.value.get(3)}</span></p>
        </div>
    </div> 
    <div class="box2">
         <h3>Itinerary Details</h3>
        <table>
            <thead>
              <td>TRAVEL DATE</td>
              <td>DEPARTURE</td>
              <td>ARRIVAL</td>
            </thead>
            <tbody>
           
                <tr>
                    <td>${item.value.get(1).getDateFlight()}</td>
                    <td>
                        <p>${item.value.get(1).FromCity().getName()}</p>
                        <p>Time :${item.value.get(1).getDepart()}</p>
                    </td>
                    <td>
                        <p>${item.value.get(1).ToCity().getName()}</p>
                        <p>Time :${item.value.get(1).getArrival()}</p>
                    </td>
                </tr>
          
                
                <c:if test="${item.value.get(2) ne null}">
                <tr>
                    <td>${item.value.get(2).getDateFlight()}</td>
                    <td>
                        <p>${item.value.get(2).FromCity().getName()}</p>
                        <p>Time :${item.value.get(2).getDepart()}</p>
                    </td>
                    <td>
                        <p>${item.value.get(2).ToCity().getName()}</p>
                        <p>Time :${item.value.get(2).getArrival()}</p>
                    </td>
                </tr>
                </c:if>
            </tbody>
        </table>
                  
    </div>
</div>
 </c:forEach>
  ${pagger}