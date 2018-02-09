package servlet;

import action.Action;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener{

  Map<String, Action> actions;

  @Override
  public void contextInitialized(ServletContextEvent servletContextEvent) {
    actions = new ConcurrentHashMap<>();

  }

  @Override
  public void contextDestroyed(ServletContextEvent servletContextEvent) {
    actions = null;
  }
}
