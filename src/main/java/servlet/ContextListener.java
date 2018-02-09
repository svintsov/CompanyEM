package servlet;

import action.Action;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebListener
public class ContextListener implements ServletContextListener{

  private Map<String, Action> actions;
 // private static final Logger logger = LogManager.getLogger();

  @Override
  public void contextInitialized(ServletContextEvent servletContextEvent) {
   // logger.info("Context init");
    actions = new ConcurrentHashMap<>();
    final ServletContext servletContext = servletContextEvent.getServletContext();

    String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    String iconConfigPath = rootPath + "actions.xml";
    Properties actionsProps = new Properties();
    try {
      actionsProps.loadFromXML(new FileInputStream(iconConfigPath));
    } catch (IOException e) {
      e.printStackTrace();
    }

    for(Entry entry : actionsProps.entrySet() ){
      try {
        actions.put((String)entry.getKey(),
            (Action) Class.forName((String) entry.getValue()).newInstance());
      } catch (InstantiationException | ClassNotFoundException | IllegalAccessException e) {
        e.printStackTrace();
      }
    }


    servletContext.setAttribute("actions",actions);
   // logger.info("Actions were set");

  }

  @Override
  public void contextDestroyed(ServletContextEvent servletContextEvent) {
    actions = null;
   // logger.info("Context destroyed");
  }
}
