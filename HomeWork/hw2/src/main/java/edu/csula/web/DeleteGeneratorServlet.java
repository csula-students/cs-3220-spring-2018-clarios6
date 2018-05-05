package edu.csula.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csula.storage.servlet.EventsDAOImpl;
import edu.csula.storage.EventsDAO;
import edu.csula.models.Event;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		GeneratorsDAO dao = new GeneratorsDAOImpl(getServletContext());
    Collection<Generators> gens = dao.getAll();
    int index = -1;
    int id = Integer.parseInt(reques.getParameter("id"));
    for(int i = 0 ; i < events.size() ; i++){
      if(events.get(i).getId() == id)
    }
	}
}
