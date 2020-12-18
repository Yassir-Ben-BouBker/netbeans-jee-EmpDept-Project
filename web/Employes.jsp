

<%@page import="java.util.List"%>
<%@page import="Entities.Employe"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% List<Employe> employes=(List<Employe>)request.getAttribute("employes"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste Employes</title>
    </head>
    <body>
        <h1>Liste Employes</h1>
        <table>
            <th>Code</th>
            <th>Nom</th>
            <th>Salaire</th>
            <th>Departement</th>
            <% for(Employe e : employes) {%>
               <tr>
                 <td><%=e.getIdEmp()%></td>
                 <td><%=e.getNom()%></td>
                 <td><%=e.getSalaire()%></td>
                 <td><%=e.getRefDept().getNom()%></td>
                 <td>
                    <a href="Dash?action=DeleteEmploye&id=<%=e.getIdEmp()%>">Supprimer</a>
                 </td>
                 <td>
                    <a href="Dash?action=UpdateEmploye&id=<%=e.getIdEmp()%>">Modifier</a>
                 </td>
                </tr>
            <%}%>
            
        </table>
    </body>
</html>
