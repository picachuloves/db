<%@ page import="java.util.List" %>
<%@ page import="model.Clients" %><%--
  Created by IntelliJ IDEA.
  User: Елена
  Date: 17.05.2020
  Time: 18:50
  To change this template use File | Settings | File Templates.http
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="styles/w3.css">
</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-center">
    <h1>List of clients</h1>
</div>

<div class="w3-container w3-center w3-margin-bottom w3-padding">
    <div class="w3-responsive">
        <h2>Clients</h2>
        <table class="w3-table-all">
            <tr>
                <th>id</th>
                <th>fio</th>
                <th>phone number</th>
            </tr>
            <%
                List<Clients> clients = (List<Clients>) request.getAttribute("clientslist");

                if (clients != null && !clients.isEmpty()) {
                    for (Clients c : clients) {
                        out.println("<tr>");
                        out.println("<th>" + c.getId() + "</th>");
                        out.println("<th>" + c.getFio() + "</th>");
                        out.println("<th>" + c.getPhone_number() + "</th>");
                        out.println("</tr>");
                    }
                    out.println("</table>");
                } else out.println("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n"
                        +
                        "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                        "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey\">×</span>\n" +
                        "   <h5>There are no users yet!</h5>\n" +
                        "</div>");
            %>

</div>

<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>
