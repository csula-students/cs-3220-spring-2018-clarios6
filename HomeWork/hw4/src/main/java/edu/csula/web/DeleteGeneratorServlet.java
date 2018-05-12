package edu.csula.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csula.storage.mysql.GeneratorsDAOImpl;
import edu.csula.storage.mysql.Database;
import edu.csula.storage.GeneratorsDAO;
import edu.csula.models.Generator;

@WebServlet("/admin/generator/delete")
public class DeleteGeneratorServlet extends HttpServlet {
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GeneratorsDAO dao = new GeneratorsDAOImpl(new Database());
    int id = Integer.parseInt(request.getParameter("id"));
		dao.remove(id);
		request.getRequestDispatcher("/WEB-INF/admingenremove.jsp").forward(request, response);
	}
}
