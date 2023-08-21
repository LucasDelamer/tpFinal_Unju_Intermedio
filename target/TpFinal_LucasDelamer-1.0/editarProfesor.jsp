<%-- 
    Document   : editarProfesor
    Created on : 20 ago. 2023, 11:03:25
    Author     : lucas
--%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="model.Profesor"%>
<%@page import="dao.ProfesorDao_Impl"%>
<%@page import="dao.ProfesorDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
        <title>Editar Profesor</title>
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
        <h1>Se va a editar el profesor con el ID N° <%= msg%></h1>

        <table class="table table-dark table-striped">
            <thead>
                <tr>
                    <th scope="col"> ID Profesor</th>
                    <th scope="col"> Legajo</th>
                    <th scope="col"> Nombre </th>
                    <th scope="col"> Apellido</th>
                    <th scope="col"> Telefono</th>
                </tr>
            </thead>
            <tbody>
                <%  ProfesorDao dao = new ProfesorDao_Impl();
                    int id = Integer.parseInt(msg);
                    Profesor prof = dao.readOne(id);
                %>
                <tr>
                    <th scope="row" name="id"><%=prof.getId_profesor()%></th>
                    <td><%=prof.getLegajo()%></td>
                    <td><%=prof.getNombre()%></td>
                    <td><%=prof.getApellido()%></td>
                    <td><%=prof.getTelefono()%></td>
                </tr>
            </tbody> 
        </table>    
            
        <form  action="SvProfesor" method="GET">
            <p><label>Nuevo legajo profesor</label><input type="text" class="form-control" name="legProfesor" required></p>
            <p><label>Nuevo nombre profesor</label><input type="text" class="form-control" name="nomProfesor" required></p>
            <p><label>Nuevo apellido profesor</label><input type="text" class="form-control" name="apeProfesor" required></p>
            <p><label>Nuevo telefono profesor</label><input type="text" class="form-control" name="telProfesor" required></p>
            <input type="hidden" name="id" value=<%=prof.getId_profesor()%>>
            <button type="submit" name="btnModificar" value="modificar" class="btn btn-primary">modificar profesor</button>   
        </form>
        
    </body>
    
</html>
