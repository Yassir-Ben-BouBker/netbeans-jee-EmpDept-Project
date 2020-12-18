

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modification Employe</title>
    </head>
    <body>
        <h1>Modifier un Employe</h1>
        <form action="Dash?action=ModifyEmploye" method="POST">
            <input type="hidden" value="${employe.getIdEmp()}" name="id">
            <input type="hidden" value="${employe.getRefDept().getIdDept()}" name="ref">
            <div>
                <span> Code </span>
                <input name="code" type="text" disabled value="${employe.getIdEmp()}">
            </div>
            <div>
                <span> Nom </span>
                <input name="name" type="text" value="${employe.getNom()}">
            </div>
            <div>
                <span> Salaire </span>
                <input name="salaire" type="text" value="${employe.getSalaire()}">
            </div>
            <input type="submit" value="Submit">
            
        </form>
    </body>
</html>
