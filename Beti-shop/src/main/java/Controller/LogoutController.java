/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Dell
 */
public class LogoutController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Logout</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Logout at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session != null) {
            session.invalidate(); // Xóa session
        }
        // Clear the authentication cookie

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {
                    cookie.setValue("");
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    break;
                }
                if (cookie.getName().equals("staff")) {
                    cookie.setValue("");
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    break;
                }
                if (cookie.getName().equals("admin")) {
                    cookie.setValue("");
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    break;
                }

            }
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("nameUser")) {
                    cookie.setValue("");
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    break;
                }
                if (cookie.getName().equals("nameStaff")) {
                    cookie.setValue("");
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    break;
                }
                if (cookie.getName().equals("nameAdmin")) {
                    cookie.setValue("");
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    break;
                }
            }
        }

        // Redirect the user to the login page or any other desired page
        response.sendRedirect("/Beti-shop/Login");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
