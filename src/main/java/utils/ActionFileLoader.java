package utils;

import java.util.ResourceBundle;

public class ActionFileLoader {

  private final static ResourceBundle resourceBundle = ResourceBundle
      .getBundle("actions");

  public static String getProperty(String key) {
    return resourceBundle.getString(key);
  }
}
