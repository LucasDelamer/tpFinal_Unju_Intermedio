<%-- 
    Document   : listadoProfesor
    Created on : 20 ago. 2023, 11:04:32
    Author     : lucas
--%>

<%@page import="java.util.Iterator"%>
<%@page import="dao.ProfesorDao_Impl"%>
<%@page import="dao.ProfesorDao"%>
<%@page import="model.Profesor"%>
<%@page import="servlets.SvProfesor"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Profesores</title>
    </head>
    <body style="background-color:aliceblue;">
         <div class="container">
  <nav class="navbar navbar-dark bg-primary">
    <a class="navbar-brand" href="index.jsp">Ir a la pagina pricipal</a>
  </nav>
        <table class="table table-dark table-striped">
            <thead>
                <tr>
                    <th scope="col"> ID</th>
                    <th scope="col"> Legajo</th>
                    <th scope="col"> Nombre </th>
                    <th scope="col"> Apellido </th>
                    <th scope="col"> Telefono </th>
                    <th scope="col"> Editar </th>
                    <th scope="col"> Eliminar </th>
                </tr>
            </thead>
            <tbody>
               
                <%
                    ProfesorDao dao = new ProfesorDao_Impl();
                    List<Profesor>listaProfesor=dao.read();
                    Iterator<Profesor>iter=listaProfesor.iterator();
                    Profesor prof=null;
                    while(iter.hasNext()){
                        prof=iter.next();
                %>

                <tr>
                    <td name="id"><%=prof.getId_profesor()%></th>
                    <td><%=prof.getLegajo()%></td>
                    <td><%=prof.getNombre()%></td>
                    <td><%=prof.getApellido()%></td>
                    <td><%=prof.getTelefono()%></td>
                    <td><a href="SvProfesor?accion=editar&id=<%=prof.getId_profesor()%>"  value="editar" name="btnEdita" >Editar</a>
                    <td><a href="SvProfesor?accion=eliminar&id=<%=prof.getId_profesor()%>"  value="eliminar" name="btnElimina" >Eliminar</a>
                      
                    
                </tr>
                <%}%>
    </body>
</html>
