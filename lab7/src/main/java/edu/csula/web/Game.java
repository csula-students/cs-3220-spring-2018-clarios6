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

import edu.csula.storage.servlet.EventsDAOImpl;
import edu.csula.storage.EventsDAO;
import edu.csula.models.Event;
import edu.csula.storage.servlet.GeneratorsDAOImpl;
import edu.csula.storage.GeneratorsDAO;
import edu.csula.models.Generator;


@WebServlet("/game")
public class Game extends HttpServlet {

	public void init() {
	EventsDAO eventsDao = new EventsDAOImpl(getServletContext());
	Collection<Event> events = eventsDao.getAll();
	if (events.size() == 0) {
		eventsDao.add(new Event(0, "Slave shows up", "Slave mining ores", 10));
		eventsDao.add(new Event(1, "Robots are invented", "Robots mine faster than slaves", 15));
		eventsDao.add(new Event(2, "Advanced Robots created", "Advanced Robots just do it better", 20));
	}

	GeneratorsDAO generatorsDao = new GeneratorsDAOImpl(getServletContext());
	Collection<Generator> generators = generatorsDao.getAll();
	if (generators.size() == 0) {
		generatorsDao.add(new Generator(0, "Slave", "A run of the mill slave it generates one ore per minute", 5, 10, 10));
		generatorsDao.add(new Generator(1, "Robot", "An expensive robot that generates 10 ores per minute", 10, 15, 30));
		generatorsDao.add(new Generator(2, "Advanced Robot", "A state-of-the-art robot. It generates 20 ores per minute", 20, 20, 100));
	}
}

	@Override
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		EventsDAO eventsDao = new EventsDAOImpl(getServletContext());
		Collection<Event> events = eventsDao.getAll();

		GeneratorsDAO genDao = new GeneratorsDAOImpl(getServletContext());
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
