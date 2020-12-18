
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ajout Departement</title>
    </head>
    <body>
        <h1>Ajouter un Departement</h1>
        <form action="Dash?action=SaveDepartement" method="POST">
            <div>
                <span> Reference </span>
                <input name="ref" type="text">
            </div>
            <div>
                <span> Nom </span>
                <input name="name" type="text">
            </div>
            <input type="submit" value="Submit">
            
        </form>
    </body>
</html>
