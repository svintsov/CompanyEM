package action;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.http.HttpServletRequest;

public class ActionFactory {

  public static Action getAction(HttpServletRequest request) {
    Map<String, Action> actions = (ConcurrentHashMap<String, Action>) request.getServletContext()
        .getAttribute("actions");
    String path = request.getRequestURI().replace("/CompanyEm/page","");
    return actions.get(path);
  }
}
