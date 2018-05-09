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

import edu.csula.storage.servlet.UsersDAOImpl;
import edu.csula.storage.UsersDAO;
import edu.csula.models.User;

@WebServlet("/admin/events")
public class AdminEventsServlet extends HttpServlet {
	@Override
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String html = "";
		PrintWriter out = response.getWriter();
		// TODO: render the events page HTML
		EventsDAO dao = new EventsDAOImpl(getServletContext());
		Collection<Event> events = dao.getAll();
		request.setAttribute("e", events);

		UsersDAO daoT = new UsersDAOImpl(request.getSession());
		if(!daoT.getAuthenticatedUser().isPresent()){
			response.sendRedirect("../admin/auth");
		} else {
			request.getRequestDispatcher("/WEB-INF/adminevents.jsp").forward(request, response);
		}
		//System.out.println(events);

		//out.println(html);
	}


	@Override
	public void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO: handle upsert transaction
		EventsDAO dao = new EventsDAOImpl(getServletContext());
		Collection<Event> events = dao.getAll();

		int id = events.size();
		String name = request.getParameter("eventname");
		String desc = request.getParameter("eventdescription");
		int triggerAt = Integer.parseInt(request.getParameter("triggerat"));
		Event nEvent = new Event(id, name, desc, triggerAt);
		dao.add(nEvent);

		//request.setAttribute("e", events);
		//request.getRequestDispatcher("/WEB-INF/adminevents.jsp").forward(request, response);
		response.sendRedirect("../admin/events");
		//response.sendRedirect("/admin/events");


	}

}
