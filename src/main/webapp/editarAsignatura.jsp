<%-- 
    Document   : editarAsignatura
    Created on : 19 ago. 2023, 14:45:38
    Author     : lucas
--%>


<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="model.Asignatura"%>
<%@page import="dao.AsignaturaDao_Impl"%>
<%@page import="dao.AsignaturaDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
        <title>Editar asignatura</title>
    </head>
    <body style="background-color:aliceblue;">
        <div class="container">
  <nav class="navbar navbar-dark bg-primary">
    <a class="navbar-brand" href="index.jsp">Ir a la pagina pricipal</a>
  </nav>
</div>
        <%
            String msg = (String) session.getAttribute("servletMsg");
        %>
        <h1>Se va a editar la asignatura con el ID N° <%= msg%></h1>

        <table class="table table-dark table-striped">
            <thead>
                <tr>
                    <th scope="col"> ID Asignatura</th>
                    <th scope="col"> Nombre </th>
                </tr>
            </thead>
            <tbody>
                <%  AsignaturaDao dao = new AsignaturaDao_Impl();
                    int id = Integer.parseInt(msg);
                    Asignatura asig = dao.readOne(id);
                %>
                <tr>
                    <th scope="row" name="id"><%=asig.getId_asignatura()%></th>
                    <td><%=asig.getNombre()%></td>
                </tr>
            </tbody> 
        </table>    
            
        <form  action="SvAsignatura" method="GET">
            <p><label>Nuevo nombre asignatura</label><input type="text" class="form-control" name="modAsignatura" required></p>
            <input type="hidden" name="id" value=<%=asig.getId_asignatura()%>>
            <button type="submit" name="btnModificar" value="modificar" class="btn btn-primary">modificar asignatura</button>   
        </form>
    </body>
   
</html>
