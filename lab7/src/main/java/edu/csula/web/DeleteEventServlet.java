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

@WebServlet("/admin/events/delete")
public class DeleteEventServlet extends HttpServlet {
	@Override
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
    int id = Integer.parseInt(request.getParameter("id"));
    /*int index = -1;
		EventsDAO dao = new EventsDAOImpl(new Database());
    List<Event> events = dao.getAll();
    for(int i = 0 ; i < events.size() ; i++){
      if(events.get(i).getId() == id){
        index = i;
        break;
      }
    }
		*/
    events.remove(id);
		request.getRequestDispatcher("/WEB-INF/admineventsremove.jsp").forward(request,response);
	}
}
