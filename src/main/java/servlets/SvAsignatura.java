/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import dao.AsignaturaDao;
import dao.AsignaturaDao_Impl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Asignatura;

/**
 *
 * @author lucas
 */
@WebServlet(name = "SvAsignatura", urlPatterns = {"/SvAsignatura"})
public class SvAsignatura extends HttpServlet {

    String listar="listadoAsignaturas.jsp";
    String eliminar="eliminarAsignatura.jsp";
    String editar="editarAsignatura.jsp";
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
       
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);        
        String acceso="";
        String action=request.getParameter("accion");
        String id= request.getParameter("id"); 
        
        
        if("listarAsignatura".equals(request.getParameter("botonlistar"))){
                    
             response.sendRedirect(listar);
        }
        else if ("modificar".equals(request.getParameter("btnModificar"))) { 
            int ident = Integer.parseInt(request.getParameter("id"));
            String AsignaturaModificado = request.getParameter("modAsignatura");
            AsignaturaDao asignatura = new AsignaturaDao_Impl();
            asignatura.update(new Asignatura(ident,AsignaturaModificado));        
            response.sendRedirect(listar); 
         }
        
        else if (action.equalsIgnoreCase("editar")){          
           request.getSession().setAttribute("servletMsg", id);
           response.sendRedirect(editar);
                                      
        }
        
           
        else if (action.equalsIgnoreCase("eliminar")){
            Integer ident= Integer.parseInt(id);
            AsignaturaDao asignatura = new AsignaturaDao_Impl();
            asignatura.delete(ident);   
            response.sendRedirect(listar);   
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
                 
         if("agregar".equals(request.getParameter("btnAgregar"))){
            String AsignaturaRecibida = request.getParameter("asignatura");
            AsignaturaDao asignatura = new AsignaturaDao_Impl();
            asignatura.insert(new Asignatura(AsignaturaRecibida));        
            response.sendRedirect(listar);
         } 
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
