

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ajout Employe</title>
    </head>
    <body>
        <h1>Ajouter un Employe</h1>
        <form action="Dash?action=SaveEmploye" method="POST">
            <input type="hidden" value="${departement.idDept}" name="idDep">
            <div>
                <span> Code </span>
                <input name="code" type="text">
            </div>
            <div>
                <span> Nom </span>
                <input name="name" type="text">
            </div>
            <div>
                <span> Salaire </span>
                <input name="salaire" type="text">
            </div>
            <input type="submit" value="Submit">
            
        </form>
    </body>
</html>
