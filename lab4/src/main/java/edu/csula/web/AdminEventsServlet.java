package edu.csula.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csula.storage.servlet.EventsDAOImpl;
import edu.csula.storage.EventsDAO;
import edu.csula.models.Event;

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
		System.out.println(events);
		html += "<!DOCTYPE html>";
		html += "	<html lang=\"en\">";
		html += "  <head>";
		html += "    <meta charset=\"UTF-8\">";
		html += "    <link rel=\"stylesheet\" type=\"text/css\" href=\"admin-generators-styles.css\">";
		html += "    <title>Incremental Game</title>";
		html += "  </head>";
		html += "  <body>";
		html += "    <h1>Incremental Game Framework</h1>";
		html += "    <nav>";
		html += "      <a href=\"admin-info.html\">Game Infomation</a> |";
		html += "      <a href=\"admin-generators.html\">Generators</a> |";
		html += "      <a href=\"admin-events.html\">Events</a>";
		html += "    </nav>";
		html += "    <div id=\"wrap\">";
		html += "      <div class=\"add-event\">";
		html += "        <form>";
		html += "          <label for=\"event-name\">Event Name</label></br>";
		html += "          <input id=\"event-name\" type=\"text\" placeholder=\"Grandma\"></br>";
		html += "          <label for=\"event-description\">Event Description</label></br>";
		html += "          <input id=\"event-description\" type=\"text\" placeholder=\"Lorem ...\"></br>";
		html += "          <label for=\"trigger-at\">Trigger At</label></br>";
		html += "          <input id=\"trigger-at\" type=\"text\" placeholder=\"10\"></br>";
		html += "          <button id=\"add-edit-button\">{Add|Edit}</button>";
		html += "        </form>";
		html += "      </div>";
		html += "      <div class=\"event-table\">";
		html += "        <table>";
		html += "          <thead>";
		html += "            <tr>";
		html += "              <th>Name</th>";
		html += "              <th>Description</th>";
		html += "              <th>Trigger At</th>";
		html += "            </tr>";
		html += "          </thead>";
		html += "          <tbody>";
		for(Event e : events) {
			html += "            <tr>";
			html += "              <td>" + e.getName() + "</td>";
			html += "              <td>" + e.getDescription() + "</td>";
			html += "              <td>" + e.getTriggerAt() + "</td>";
			html += "            </td>";
		}
		html += "        </tbody>";
		html += "      </table>";
		html += "    </div>";
		html += "  </div>";
		html += " </body>";
		html += "</html>";
		
		System.out.println(html);
	}


	@Override
	public void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO: handle upsert transaction
		int id = Integer.parseInt((String) request.getAttribute("id"));
		String name = (String) request.getAttribute("name");
		String desc = (String) request.getAttribute("desc");
		int trigger = Integer.parseInt((String) (request.getAttribute("triggerAt")));
		
		

	}
	
}
