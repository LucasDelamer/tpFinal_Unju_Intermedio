<%-- 
    Document   : index
    Created on : 18 ago. 2023, 16:26:34
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
        <title>Trabajo Final Lucas Delamer</title>
    </head>
    <body style="background-color:aliceblue;">
        
        <div class="container">
            <h1 style="text-align: center">Gestión de asignaturas y profesores</h1>
            
        </div>
               
        <div class="container">
            
            <div class="row">
                
              <div class="col-sm">
                  <h1>Alta de Asignaturas</h1>
                      <form action="SvAsignatura" method="POST">
                          <p><label>Asignatura a dar de alta</label><input type="text" class="form-control" name="asignatura" required></p>
                        <button type="submit" name="btnAgregar" value="agregar" class="btn btn-primary">Agregar asignatura</button>
                      </form>
                  <div style="margin: 10px">
                        <form action="SvAsignatura" method="GET">
                            <button type="submit"  class="btn btn-secondary" name="botonlistar" value="listarAsignatura">Ver listado, editar, eliminar</button>
                        </form>
                  </div>
              </div>
                
              <div class="col-sm">
                <h1>Alta de profesores </h1>
                    <form action="SvProfesor" method="POST">
                        <p><label>Legajo</label><input type="text" class="form-control" name="legajo" required></p>
                        <p><label>Nombre</label><input type="text" class="form-control" name="nombre" required></p>
                        <p><label>Apellido</label><input type="text" class="form-control" name="apellido" required></p>
                        <p><label>Telefono</label><input type="text" class="form-control" name="telefono" ></p>
                        <button type="submit" name="btnAgrega" value="agrega" class="btn btn-primary">Agregar profesor</button>
                      </form>
                <div style="margin: 10px">
                  <form action="SvProfesor" method="GET">
                      <button type="submit"  class="btn btn-secondary" name="botonlistar" value="listaProfesor">Ver listado, editar, eliminar</button>
                  </form>
                </div>    
              </div>
            </div>
          </div>
        
    </body>
   
</html>
