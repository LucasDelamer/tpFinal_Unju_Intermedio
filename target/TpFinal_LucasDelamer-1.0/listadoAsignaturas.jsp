<%-- 
    Document   : ListadoAsignaturas
    Created on : 18 ago. 2023, 18:45:00
    Author     : lucas
--%>

<%@page import="java.util.Iterator"%>
<%@page import="dao.AsignaturaDao_Impl"%>
<%@page import="dao.AsignaturaDao"%>
<%@page import="model.Asignatura"%>
<%@page import="servlets.SvAsignatura"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body style="background-color:aliceblue;">
        <div class="container">
            <nav class="navbar navbar-dark bg-primary">
              <a class="navbar-brand" href="index.jsp">Ir a la pagina pricipal</a>
            </nav>
            
            <table class="table table-dark table-striped">
            <thead>
                <tr>
                    <th scope="col"> ID Asignatura</th>
                    <th scope="col"> Nombre </th>
                    <th scope="col"> Editar </th>
                    <th scope="col"> Eliminar </th>
                </tr>
            </thead>
            <tbody>
               
                <%
                    AsignaturaDao dao = new AsignaturaDao_Impl();
                    List<Asignatura>listaAsignatura=dao.read();
                    Iterator<Asignatura>iter=listaAsignatura.iterator();
                    Asignatura asig=null;
                    while(iter.hasNext()){
                        asig=iter.next();
                %>

                <tr>
                    <td name="id"><%=asig.getId_asignatura()%></th>
                    <td><%=asig.getNombre()%></td>
                    <td><a href="SvAsignatura?accion=editar&id=<%=asig.getId_asignatura()%>"  value="editar" name="btnEdita" >Editar</a>
                    <td><a href="SvAsignatura?accion=eliminar&id=<%=asig.getId_asignatura()%>"  value="eliminar" name="btnElimina" >Eliminar</a>
                      
                    
                </tr>
                <%}%>
    </body>
     
</html>
