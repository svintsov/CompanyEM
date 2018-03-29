package action;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ActionFactory {

  private static final Logger logger = LogManager.getLogger();

  public static Action getAction(HttpServletRequest request) {
    Map<String, Action> actions = (ConcurrentHashMap<String, Action>) request.getServletContext()
        .getAttribute("actions");
    String path = request.getRequestURI().replaceAll(".*/page","");
    logger.debug("Path:"+path);

    return actions.get(path);
  }
}
