<%@ page import="model.Clients" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Rooms" %>
<%@ page import="model.Reservations" %>
<%@ page import="model.Partners" %>
<%@ page import="service.PartnersService" %><%--
  Created by IntelliJ IDEA.
  User: Елена
  Date: 13.06.2020
  Time: 0:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HotelWEB</title>
    <link rel="stylesheet" href="styles/w3.css">
    <style>
        /*the container must be positioned relative:*/
        .custom-select {
            position: relative;
            font-family: Arial;
        }

        .custom-select select {
            display: none; /*hide original SELECT element:*/
        }

        .select-selected {
            background-color: DodgerBlue;
        }

        /*style the arrow inside the select element:*/
        .select-selected:after {
            position: absolute;
            content: "";
            top: 14px;
            right: 10px;
            width: 0;
            height: 0;
            border: 6px solid transparent;
            border-color: #fff transparent transparent transparent;
        }

        /*point the arrow upwards when the select box is open (active):*/
        .select-selected.select-arrow-active:after {
            border-color: transparent transparent #fff transparent;
            top: 7px;
        }

        /*style the items (options), including the selected item:*/
        .select-items div,.select-selected {
            color: #ffffff;
            padding: 8px 16px;
            border: 1px solid transparent;
            border-color: transparent transparent rgba(0, 0, 0, 0.1) transparent;
            cursor: pointer;
            user-select: none;
        }

        /*style items (options):*/
        .select-items {
            position: absolute;
            background-color: DodgerBlue;
            top: 100%;
            left: 0;
            right: 0;
            z-index: 99;
        }

        /*hide the items when the select box is closed:*/
        .select-hide {
            display: none;
        }

        .select-items div:hover, .same-as-selected {
            background-color: rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body class="w3-light-grey">
<div class="w3-container w3-light-grey w3-opacity w3-center">
    <h1>Here you can add new contract</h1>
</div>

<div class="w3-container w3-padding">
    <%
        if (request.getAttribute("answer") != null) {
            out.println("<div class=\"w3-panel w3-green w3-display-container w3-card-4 w3-round\">\n" +
                    "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                    "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green w3-border w3-border-green w3-hover-border-grey\">×</span>\n" +
                    "   <h5>Successful!</h5>\n" +
                    "</div>");
        }
    %>
    <div class="w3-card-4">
        <div class="w3-container w3-center w3-green">
            <h2>Add contract</h2>
        </div>

        <form method="post" class="w3-select w3-light-grey w3-padding">
            <label for="id_client">Id client:</label>
            <div class="custom-select"  id="id_client" style="width: 30%">
                <select name="id_client">
                    <%
                        List<Clients> clientsList = (List<Clients>) request.getAttribute("clients");
                        if (clientsList != null && !clientsList.isEmpty()) {
                            for (Clients c : clientsList) {
                                out.println(" <option " + "value =\"" + c.getId() + "\">" + c.getFio() + "</option>");
                            }
                        }
                    %>
                </select>
            </div>
            <label for="id_room">Id room:</label>
            <div class="custom-select"  id="id_room" style="width: 30%">
                <select name="id_room">
                    <%
                        List<Rooms> roomsList = (List<Rooms>) request.getAttribute("rooms");
                        if (roomsList != null && !roomsList.isEmpty()) {
                            for (Rooms c : roomsList) {
                                out.println(" <option " + "value =\"" + c.getId() + "\">" + c.getId() + "</option>");
                            }
                        }
                    %>
                </select>
            </div>
            <label>living_start:
                <input type="date" name="living_start" min="<%=request.getAttribute("today")%>" value="<%=request.getAttribute("today")%>" required class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <label>living_end:
                <input type="date" name="living_end" required min="<%=request.getAttribute("today")%>" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <label for="id_reservation">Id reservation:</label>
            <div class="custom-select"  id="id_reservation" style="width: 30%">
                <select name="id_reservation">
                    <option value="0">NO RESERVATION</option>
                    <%
                        List<Reservations> reservationsList = (List<Reservations>) request.getAttribute("reservations");
                        PartnersService partnersService = new PartnersService();
                        if (reservationsList != null && !reservationsList.isEmpty()) {
                            for (Reservations c : reservationsList) {
                                out.println(" <option " + "value =\"" + c.getId() + "\">" + "Reservation #" + c.getId() + " by " + partnersService.getByContractNumber(c.getRes_partner()).getInformation() + "</option>");
                            }
                        }
                    %>
                </select>
            </div>
            <br />
            <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Submit</button>
        </form>
    </div>
</div>
<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='/contracts'">Back to list</button>
</div>
<script>
    var x, i, j, l, ll, selElmnt, a, b, c;
    /*look for any elements with the class "custom-select":*/
    x = document.getElementsByClassName("custom-select");
    l = x.length;
    for (i = 0; i < l; i++) {
        selElmnt = x[i].getElementsByTagName("select")[0];
        ll = selElmnt.length;
        /*for each element, create a new DIV that will act as the selected item:*/
        a = document.createElement("DIV");
        a.setAttribute("class", "select-selected");
        a.innerHTML = selElmnt.options[selElmnt.selectedIndex].innerHTML;
        x[i].appendChild(a);
        /*for each element, create a new DIV that will contain the option list:*/
        b = document.createElement("DIV");
        b.setAttribute("class", "select-items select-hide");
        for (j = 1; j < ll; j++) {
            /*for each option in the original select element,
            create a new DIV that will act as an option item:*/
            c = document.createElement("DIV");
            c.innerHTML = selElmnt.options[j].innerHTML;
            c.addEventListener("click", function(e) {
                /*when an item is clicked, update the original select box,
                and the selected item:*/
                var y, i, k, s, h, sl, yl;
                s = this.parentNode.parentNode.getElementsByTagName("select")[0];
                sl = s.length;
                h = this.parentNode.previousSibling;
                for (i = 0; i < sl; i++) {
                    if (s.options[i].innerHTML == this.innerHTML) {
                        s.selectedIndex = i;
                        h.innerHTML = this.innerHTML;
                        y = this.parentNode.getElementsByClassName("same-as-selected");
                        yl = y.length;
                        for (k = 0; k < yl; k++) {
                            y[k].removeAttribute("class");
                        }
                        this.setAttribute("class", "same-as-selected");
                        break;
                    }
                }
                h.click();
            });
            b.appendChild(c);
        }
        x[i].appendChild(b);
        a.addEventListener("click", function(e) {
            /*when the select box is clicked, close any other select boxes,
            and open/close the current select box:*/
            e.stopPropagation();
            closeAllSelect(this);
            this.nextSibling.classList.toggle("select-hide");
            this.classList.toggle("select-arrow-active");
        });
    }
    function closeAllSelect(elmnt) {
        /*a function that will close all select boxes in the document,
        except the current select box:*/
        var x, y, i, xl, yl, arrNo = [];
        x = document.getElementsByClassName("select-items");
        y = document.getElementsByClassName("select-selected");
        xl = x.length;
        yl = y.length;
        for (i = 0; i < yl; i++) {
            if (elmnt == y[i]) {
                arrNo.push(i)
            } else {
                y[i].classList.remove("select-arrow-active");
            }
        }
        for (i = 0; i < xl; i++) {
            if (arrNo.indexOf(i)) {
                x[i].classList.add("select-hide");
            }
        }
    }
    /*if the user clicks anywhere outside the select box,
    then close all select boxes:*/
    document.addEventListener("click", closeAllSelect);
</script>
</body>
</html>
