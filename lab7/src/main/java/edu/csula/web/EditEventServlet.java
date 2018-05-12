package edu.csula.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import edu.csula.storage.mysql.EventsDAOImpl;
import edu.csula.storage.EventsDAO;
import edu.csula.models.Event;
import edu.csula.storage.mysql.Database;

@WebServlet("/admin/events/edit")
public class EditEventServlet extends HttpServlet {
	@Override
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// TODO: render the events page HTML
		int id = Integer.parseInt(request.getParameter("id"));
    EventsDAO dao = new EventsDAOImpl(new Database());
		Optional<Event> events = dao.getById(id);
    Event edEvent = null;
    if(events.isPresent()){
			edEvent = events.get(); 
		}
		request.setAttribute("ev", edEvent);
		request.getRequestDispatcher("/WEB-INF/admineventsedit.jsp").forward(request, response);
	}


	@Override
	public void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO: handle upsert transaction
    int id = Integer.parseInt(request.getParameter("id"));
		EventsDAO dao = new EventsDAOImpl(new Database());
		Collection<Event> events = dao.getAll();
    Event edEvent = null;
    for(Event e : events){
      if(e.getId() == id){
        edEvent = e;
        break;
      }
    }

		edEvent.setName(request.getParameter("eventname"));
		edEvent.setDescription(request.getParameter("eventdescription"));
		edEvent.setTriggerAt(Integer.parseInt(request.getParameter("triggerat")));
		System.out.println("Edit Event");

		dao.set(id, edEvent);

		response.sendRedirect("../events");
	}
}
