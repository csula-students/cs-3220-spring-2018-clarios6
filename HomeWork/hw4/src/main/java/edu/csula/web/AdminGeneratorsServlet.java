package edu.csula.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

import edu.csula.storage.mysql.GeneratorsDAOImpl;
import edu.csula.storage.mysql.Database;
import edu.csula.storage.GeneratorsDAO;
import edu.csula.models.Generator;

import edu.csula.storage.servlet.UsersDAOImpl;
import edu.csula.storage.UsersDAO;
import edu.csula.models.User;

@WebServlet("/admin/generators")
public class AdminGeneratorsServlet extends HttpServlet {
	@Override
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// TODO: render the generators page HTML
		GeneratorsDAO dao = new GeneratorsDAOImpl(new Database());
		Collection<Generator> gens = dao.getAll();
		request.setAttribute("g", gens);

		UsersDAO daoT = new UsersDAOImpl(request.getSession());
		if(!daoT.getAuthenticatedUser().isPresent()){
			response.sendRedirect("../admin/auth");
		} else {
			request.getRequestDispatcher("/WEB-INF/admingen.jsp").forward(request, response);
		}

	}


	@Override
	public void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO: handle upsert transaction
		GeneratorsDAO dao = new GeneratorsDAOImpl(new Database());
		Collection<Generator> gens = dao.getAll();

		int lastId = -1;
		for(Generator g : gens){
			lastId = g.getId();
		}
		lastId++;
		String name = request.getParameter("generatorname");
		String desc = request.getParameter("description");
		int rate = Integer.parseInt(request.getParameter("generatorrate"));
		int baseCost = Integer.parseInt(request.getParameter("basecost"));
		int unlock = Integer.parseInt(request.getParameter("unlockat"));

		Generator nGen = new Generator(lastId, name, desc, rate, baseCost, unlock);
		dao.add(nGen);
		response.sendRedirect("../admin/generators");
	}
}
