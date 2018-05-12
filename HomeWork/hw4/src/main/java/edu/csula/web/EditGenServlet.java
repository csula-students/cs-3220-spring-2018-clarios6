package edu.ccsula.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import edu.csula.storage.mysql.GeneratorsDAOImpl;
import edu.csula.storage.mysql.Database;
import edu.csula.storage.GeneratorsDAO;
import edu.csula.models.Generator;

@WebServlet("/admin/generators/edit")
public class EditGenServlet extends HttpServlet{
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    int id = Integer.parseInt(request.getParameter("id"));
    GeneratorsDAO dao = new GeneratorsDAOImpl(new Database());
    Optional<Generator> gen = dao.getById(id);
    Generator edGen = null;
    if(gen.isPresent()){
      edGen = gen.get();
    }

    request.setAttribute("edGen", edGen);
    request.getRequestDispatcher("/WEB-INF/admingenedit.jsp").forward(request, response);
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    int id = Integer.parseInt(request.getParameter("id"));
    GeneratorsDAO dao = new GeneratorsDAOImpl(new Database());
    Optional<Generator> gens = dao.getById(id);
    Generator edGen = null;
    if(gens.isPresent()){
      edGen = gens.get();
    }
    edGen.setName(request.getParameter("generatorname"));
    edGen.setRate(Integer.parseInt(request.getParameter("generatorrate")));
    edGen.setBaseCost(Integer.parseInt(request.getParameter("basecost")));
    edGen.setUnlockAt(Integer.parseInt(request.getParameter("unlockat")));
    edGen.setDescription(request.getParameter("description"));
    dao.set(id, edGen);
    response.sendRedirect("../generators");
  }
}
