package edu.csula.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csula.storage.mysql.EventsDAOImpl;
import edu.csula.storage.EventsDAO;
import edu.csula.models.Event;
import edu.csula.storage.mysql.GeneratorsDAOImpl;
import edu.csula.storage.GeneratorsDAO;
import edu.csula.models.Generator;
import edu.csula.storage.mysql.Database;

@WebServlet("/game")
public class Game extends HttpServlet {

	@Override
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		EventsDAO eventsDao = new EventsDAOImpl(new Database());
		Collection<Event> events = eventsDao.getAll();

		GeneratorsDAO genDao = new GeneratorsDAOImpl(new Database());
		Collection<Generator> gens = genDao.getAll();

		GsonBuilder builder = new GsonBuilder();
 		Gson gson = builder.create();
 		String gensJSON = gson.toJson(gens);
		String storyJSON = gson.toJson(events);

		out.println(gensJSON);
		request.setAttribute("genjson", gensJSON);
		request.setAttribute("storyjson", storyJSON);
		request.getRequestDispatcher("/WEB-INF/game.jsp").forward(request, response);

	}
}
