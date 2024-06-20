package com.example.lab9_20206466.servlets;
import com.example.lab9_20206466.beans.Usuario;
import com.example.lab9_20206466.daos.UsuarioDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
@WebServlet(name = "UsuarioServlet", value = "/UsuarioServlet")
public class UsuarioServlet extends HttpServlet{
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        String action = request.getParameter("action") == null ? "lista" : request.getParameter("action");

        UsuarioDao usuarioDao = new UsuarioDao();

        switch (action){
            case "lista":
                //saca del modelo
                ArrayList<Usuario> list = usuarioDao.listarUsuarios();
                //mandar la lista a la vista -> job/lista.jsp
                request.setAttribute("lista",list);
                RequestDispatcher rd = request.getRequestDispatcher("lista.jsp");
                rd.forward(request,response);
                break;

        }
    }
}
