/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import dao.ProfesorDao;
import dao.ProfesorDao_Impl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Profesor;

/**
 *
 * @author lucas
 */
@WebServlet(name = "SvProfesor", urlPatterns = {"/SvProfesor"})
public class SvProfesor extends HttpServlet {
    
    String listar="listadoProfesor.jsp";
    String eliminar="eliminarProfesor.jsp";
    String editar="editarProfesor.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try ( PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet SvProfesor</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet SvProfesor at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String acceso="";
        String action=request.getParameter("accion");
        String id= request.getParameter("id"); 
        
        
        if("listaProfesor".equals(request.getParameter("botonlistar"))){
            response.sendRedirect(listar);
        }
        else if ("modificar".equals(request.getParameter("btnModificar"))) { 
            int ident = Integer.parseInt(request.getParameter("id"));
            String legProfesor = request.getParameter("legProfesor");
            int legajo =Integer.parseInt(legProfesor);
            String nomProfesor = request.getParameter("nomProfesor");
            String apeProfesor = request.getParameter("apeProfesor");
            String telProfesor = request.getParameter("telProfesor");
            ProfesorDao profesor = new ProfesorDao_Impl();
            profesor.update(new Profesor(ident,legajo,nomProfesor,apeProfesor,telProfesor));        
            response.sendRedirect(listar); 
         }
        
        else if (action.equalsIgnoreCase("editar")){          
           request.getSession().setAttribute("servletMsg", id);
           response.sendRedirect(editar);
                                      
        }
        
           
        else if (action.equalsIgnoreCase("eliminar")){
            Integer ident= Integer.parseInt(id);
            ProfesorDao profesor = new ProfesorDao_Impl();
            profesor.delete(ident);   
            response.sendRedirect(listar);   
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
       // if("agregar".equals(request.getParameter("btnAgregar"))){
            String lega = request.getParameter("legajo");
            int legajo=Integer.parseInt(lega);
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String telefono = request.getParameter("telefono");            
            ProfesorDao profesor = new ProfesorDao_Impl();
            profesor.insert(new Profesor(legajo,nombre,apellido,telefono));        
            response.sendRedirect(listar);
        // } 
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
