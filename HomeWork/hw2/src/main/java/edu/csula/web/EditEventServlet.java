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

@WebServlet("/admin/events/edit")
public class EditEventServlet extends HttpServlet {
	@Override
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
		String html = "";
    html += "<!DOCTYPE html>";
		html += "	<html lang=\"en\">";
		html += "  <head>";
		html += "    <meta charset=\"UTF-8\">";
		html += "    <link rel=\"stylesheet\" type=\"text/css\" href=\"admin-generators-styles.css\">";
		html += "    <title>Incremental Game</title>";
		html += "  </head>";
		html += "  <body>";
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
    html += "<h1>Editing Event</h1>";
    html += "        <form method=\"POST\">";
		html += "          <label for=\"eventname\">Event Name</label></br>";
		html += "          <input name=\"eventname\" type=\"text\" placeholder=\"Grandma\"></br>";
		html += "          <label for=\"eventdescription\">Event Description</label></br>";
		html += "          <input name=\"eventdescription\" type=\"text\" placeholder=\"Lorem ...\"></br>";
		html += "          <label for=\"triggerat\">Trigger At</label></br>";
		html += "          <input name=\"triggerat\" type=\"text\" placeholder=\"10\"></br>";
		html += "          <button >{Add|Edit}</button>";
		html += "        </form>";
    html += "            <div>";
    html += "              <a>" + edEvent.getId() + "</a>";
    html += "              <a>" + edEvent.getName() + "</a>";
    html += "              <a>" + edEvent.getDescription() + "</a>";
    html += "              <a>" + edEvent.getTriggerAt() + "</a>";
    html += "            </div>";
    html += " </body>";
    html += "</html>";
    out.println(html);
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
