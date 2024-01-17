package org.eclipse.jakarta.controller;

import com.mysql.cj.MysqlConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.eclipse.jakarta.model.Escola;
import org.eclipse.jakarta.model.Usuari;
import org.eclipse.jakarta.service.EscolaService;
import org.eclipse.jakarta.service.EscolaServiceImpl;
import org.eclipse.jakarta.service.UsuarioService;
import org.eclipse.jakarta.service.UsuarioServiceImpl;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(name = "login",urlPatterns = "/login")
public class LoginController extends HttpServlet {

    private EscolaService escolaService;
    private UsuarioServiceImpl usuarioService;

    public LoginController(){
        this.escolaService = new EscolaServiceImpl();
        this.usuarioService = new UsuarioServiceImpl();
    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Escola> escoles = this.escolaService.findAll();

        req.setAttribute("schools",escoles);
        //req.setAttribute("hola","hola");

        req.getRequestDispatcher("loginForm.jsp").forward(req,resp);
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        System.out.println("Entra a POST");

        String user = (String) req.getParameter("user");
        String password = (String) req.getParameter("passw");
        Long escu = Long.valueOf(req.getParameter("escola"));

        System.out.println(user+"---"+password+"---"+escu);

        Usuari usuari = this.usuarioService.findUserByUsernamePasswordEscola(user,password,escu);
        if(usuari != null){
            //creamos la sesion
            HttpSession session = req.getSession();
            session.setAttribute("usuari",usuari);
            resp.sendRedirect("usuaris");
            //req.getRequestDispatcher("usuaris").forward(req,resp);
            //req.setAttribute("listausu",usuari);

        }else{
            resp.sendRedirect("/login?error=true");
        }


    }
}
