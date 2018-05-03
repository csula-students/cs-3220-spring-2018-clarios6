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

@WebServlet("/admin/events/delete")
public class DeleteEventServlet extends HttpServlet {
	@Override
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// TODO: render the generators page HTML
    int id = Integer.parseInt(request.getParameter("id"));
    int index = -1;
		EventsDAO dao = new EventsDAOImpl(getServletContext());
    List<Event> events = dao.getAll();
    for(int i = 0 ; i < events.size() ; i++){
      if(events.get(i).getId() == id){
        index = i;
        break;
      }
    }
    events.remove(index);
    out.println("<a href='/admin/events'>go back to events</a>");
	}
}
