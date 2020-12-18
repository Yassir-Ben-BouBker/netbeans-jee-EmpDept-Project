
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modification Departement</title>
    </head>
    <body>
        <h1>Modifier un Departement</h1>
        <form action="Dash?action=ModifyDepartement" method="POST">
            <input name="code" value="${departement.getIdDept()}" type="hidden">
            <div>
                <span> Code </span>
                <input name="ref" value="${departement.getIdDept()}" type="text" disabled>
            </div>
            <div>
                <span> Nom </span>
                <input name="name" value="${departement.getNom()}" type="text">
            </div>
            <input type="submit" value="Submit">
            
        </form>
    </body>
</html>
