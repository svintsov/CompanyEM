package servlet;

import action.Action;
import action.ActionFactory;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/page/*")
public class Servlet extends HttpServlet {

  public void doGet(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {
    service(request, response);
  }

  public void doPost(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {
    service(request, response);
  }

  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      Action action = ActionFactory.getAction(request);
      String view = action.execute(request, response);

      request.getRequestDispatcher("/jsp/" + view + ".jsp").forward(request, response);

    } catch (Exception e) {
      throw new ServletException("Executing action failed.", e);
    }
  }
}
