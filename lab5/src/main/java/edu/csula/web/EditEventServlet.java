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

import edu.csula.storage.servlet.EventsDAOImpl;
import edu.csula.storage.EventsDAO;
import edu.csula.models.Event;

@WebServlet("/admin/events/edit")
public class EditEventServlet extends HttpServlet {
	@Override
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// TODO: render the events page HTML
		int id = Integer.parseInt(request.getParameter("id"));
    EventsDAO dao = new EventsDAOImpl(getServletContext());
		Collection<Event> events = dao.getAll();
    Event edEvent = null;
    for(Event e : events){
      if(e.getId() == id){
        edEvent = e;
        break;
      }
    }
		request.setAttribute("ev", edEvent);
		request.getRequestDispatcher("/WEB-INF/admineventsedit.jsp").forward(request, response);
	}


	@Override
	public void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO: handle upsert transaction
    int id = Integer.parseInt(request.getParameter("id"));
		EventsDAO dao = new EventsDAOImpl(getServletContext());
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

		response.sendRedirect("/admin/events");
	}
}
