package com.uniyaz;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class OgrenciServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //  resp.getWriter().println("DENEME");
        String message="Deneme";
      //  PrintWriter out = resp.getWriter();
      //  out.println("<h1>" + message + "</h1>");
       // out.println("<p>"+"paragraf"+"</p>");

        String adi=req.getParameter("adi");
        resp.getWriter().write(1+" "+ adi);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        super.doPost(req, resp);
    }
}
