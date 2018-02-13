package controller.servlet;

import action.Action;
import action.ActionFactory;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet("/page/*")
public class Servlet extends HttpServlet {

  private final static Logger logger = LogManager.getLogger();

  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    logger.debug("Servlet starts");

    try {
      Action action = ActionFactory.getAction(request);
      String view = action.execute(request, response);

      request.getRequestDispatcher("/jsp/" + view + ".jsp").forward(request, response);

    } catch (Exception e) {
      throw new ServletException("Executing action failed.", e);
    }
    logger.debug("Servlet ends");
  }
}
