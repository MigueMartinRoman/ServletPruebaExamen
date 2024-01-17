package org.eclipse.jakarta.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.eclipse.jakarta.model.Usuari;
import org.eclipse.jakarta.service.UsuarioService;

import java.io.IOException;
import java.util.List;

@WebServlet(name= "listUsuariController",urlPatterns = "/usuaris")
public class UsuariListController extends HttpServlet {

    private UsuarioService usuarioService;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //List<Usuari> listaaa = usuarioService.findAll();

        //List<Usuari> usuaris = this.usuarioService.findAll();
        //req.setAttribute("relacionusuarios",listaaa);
        req.getRequestDispatcher("usuaris.jsp").forward(req,resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
