
package com.emergentes.tarea_tem1010;

import java.io.IOException;
//import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "TareaServlet", urlPatterns = {"/TareaServlet"})
public class TareaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String op = request.getParameter("op");

        if (op.equals("vaciar")) {
            // obtener acceso al objeto session
            HttpSession ses = request.getSession();
            //se elimina la session
            ses.invalidate();
            //trasnfiere el control a index.jsp
            response.sendRedirect("index.jsp");
        }
        if (op.equals("eliminar")) {
            int pos = -1;
            int buscado = -1;
            int id = Integer.parseInt(request.getParameter("id"));
            // Eliminar el producto
            HttpSession ses = request.getSession();
            ArrayList<Tarea> lista = (ArrayList<Tarea>) ses.getAttribute("tarea");

            for (Tarea p : lista) {
                pos++;
                if (p.getId() == id) {
                    buscado = pos;
                }
            }
            lista.remove(buscado);
            response.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
         int id = Integer.parseInt(request.getParameter("id"));
        //recupera el producto enviadoo desde formulario 
        String tarea = request.getParameter("tarea");
        // String[] completado = (request.getParameterValues("completado"));
        //char completado = Integer.parseInt(request.getParameter("cantidad"));
        //double precio = Double.parseDouble(request.getParameter("precio"));

        Tarea tar = new Tarea();

        tar.setId(id);
        tar.setTarea(tarea);
        //tar.setCompletado(completado);
        //prod.setPrecio(precio);

        HttpSession ses = request.getSession();

        ArrayList<Tarea> lista = (ArrayList<Tarea>) ses.getAttribute("tarea");

        lista.add(tar);

        response.sendRedirect("index.jsp");

    }

}
