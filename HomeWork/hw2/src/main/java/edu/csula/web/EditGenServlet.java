package edu.ccsula.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import edu.csula.storage.servlet.GeneratorsDAOImpl;
import edu.csula.storage.GeneratorsDAO;
import edu.csula.models.Generator;

@WebServlet("/admin/generators/edit")
public class EditGenServlet extends HttpServlet{
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    response.setContentType("text/html");
    int id = Integer.parseInt(request.getParameter("id"));
    GeneratorsDAO dao = new GeneratorsDAOImpl(getServletContext());
    List<Generator> gens = dao.getAll();
    Generator edGen = null;
    for(Generator g : gens){
      if(g.getId() == id){
        edGen = g;
        break;
      }
    }
    request.setAttribute("edGen", edGen);
    request.getRequestDispatcher("/WEB-INF/admingenedit.jsp").forward(request, response);
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    int id = Integer.parseInt(request.getParameter("id"));
    GeneratorsDAO dao = new GeneratorsDAOImpl(getServletContext());
    List<Generator> gens = dao.getAll();
    Generator edGen = null;
    for(Generator g : gens){
      if(g.getId() == id){
        edGen = g;
        break;
      }
    }
    edGen.setName(request.getParameter("generatorname"));
    edGen.setRate(Integer.parseInt(request.getParameter("generatorrate")));
    edGen.setBaseCost(Integer.parseInt(request.getParameter("basecost")));
    edGen.setUnlockAt(Integer.parseInt(request.getParameter("unlockat")));
    edGen.setDescription(request.getParameter("description"));
    response.sendRedirect("../generators");
  }
}
