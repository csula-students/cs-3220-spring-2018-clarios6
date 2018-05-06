package edu.csula.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csula.storage.servlet.GeneratorsDAOImpl;
import edu.csula.storage.GeneratorsDAO;
import edu.csula.models.Generator;

@WebServlet("/admin/generator/delete")
public class DeleteGeneratorServlet extends HttpServlet {
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		GeneratorsDAO dao = new GeneratorsDAOImpl(getServletContext());
    List<Generator> gens = dao.getAll();
    int index = -1;
    int id = Integer.parseInt(request.getParameter("id"));
    for(int i = 0 ; i < gens.size() ; i++){
      if(gens.get(i).getId() == id){
				index = i;
				break;
			}
    }
		gens.remove(index);
		request.getRequestDispatcher("/WEB-INF/admingenremove.jsp").forward(request, response);
	}
}
