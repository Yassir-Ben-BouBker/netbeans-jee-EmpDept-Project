

<%@page import="java.util.List"%>
<%@page import="Entities.Departement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% List<Departement> departements=(List<Departement>)request.getAttribute("departements"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Departements</title>
    </head>
    <body>
        <h1>Departements</h1>
        <table>
            <th>Reference</th>
            <th>Nom</th>
            <% for(Departement e : departements) {%>
               <tr>
                 <td><%=e.getIdDept()%></td>
                 <td><%=e.getNom()%></td>
                 <td>
                    <a href="Dashboard?action=DeleteDepartement&id=<%=e.getIdDept()%>">Supprimer</a>
                 </td>
                 <td>
                    <a href="Dashboard?action=UpdateDepartement&id=<%=e.getIdDept()%>">Modifier</a>
                 </td>
                 <td>
                    <a href="Dashboard?action=CreateEmploye&departement_id=<%=e.getIdDept()%>">Ajouter Employé</a>
                 </td>
                </tr>
            <%}%>
            
        </table>
    </body>
</html>
