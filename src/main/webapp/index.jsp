<%@page import="com.emergentes.tarea_tem1010.Tarea"%>
<%@page import="java.util.ArrayList"%>

<%
    //verificar si existe la coleccion de objetos en el objeto session
    if (session.getAttribute("tarea") == null) {
        //iniciar la lista auxiliar
        ArrayList<Tarea> listaux = new ArrayList<Tarea>();
        //creando un atributoo con una collecion vacia
        session.setAttribute("tarea", listaux);
    }

    ArrayList<Tarea> tarea = (ArrayList<Tarea>) session.getAttribute("tarea");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="EDEDAF"><center>
        <font face="Comic Sans MS,arial">
         <h1>Tareas</h1>
        <table border="0">
            <thead>
                <tr>
                    <th width="150"><a href="form.jsp">Nueva tarea</a></th>
                    <th width="150"><a href="TareaServlet?op=vaciar">Vaciar lista</a></th>
                </tr>
            </thead>
            
        </table>
        <table border="1">
            <thead>
                <tr>
                    <th width="20">Id</th>
                    <th width="280">Tarea</th>
                    <th width="100">Completado</th>
                    <td width="20"></td>
                </tr>
             <%
                if (tarea != null) {
                    for (Tarea t : tarea) {
            %>
            <tr>
                <td><%= t.getId()%></td>
                <td><%= t.getTarea()%></td>

                <td><input type="checkbox" id="completado" name="completado" value="" checked = "">

                <td><a href="TareaServlet?op=eliminar&id=<%= t.getId()%>">Eliminar</a></td>
            </tr>
            <%
                    }
                }
            %>
        </table>

    </body>
</html>
