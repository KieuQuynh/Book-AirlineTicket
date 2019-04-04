<%-- 
    Document   : searchBooking
    Created on : Mar 16, 2019, 4:20:51 PM
    Author     : admin
--%>

<h1>Search Bookings</h1>
<div>
     <form action="manage" method="GET">
        <input name="typeSearch" type="radio" checked="true" value="one" /> Reservation Code
        <input name="typeSearch" type="radio" value="all"/>All Bookings

            Enter reservation Code: <input type="text" name="code"/>
            <input type="submit" value="Search"/>
    </form>
</div>