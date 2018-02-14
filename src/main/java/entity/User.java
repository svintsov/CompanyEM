package entity;

import entity.proxy.UserProxy;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User implements Entity<Integer>{

  private int id;
  private String email;
  private String password;

  @Override
  public Integer getId() {
    return id;
  }

  @Override
  public void setId(Integer id) {
    this.id=id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public static final class UserBuilder {
    private Integer id;
    private String email;
    private String password;

    public UserBuilder setId(Integer id) {
      this.id = id;
      return this;
    }

    public UserBuilder setEmail(String email) {
      this.email = email;
      return this;
    }

    public UserBuilder setPassword(String password) {
      this.password = password;
      return this;
    }


    public User buildUser() {
      User user = new User();
      user.setId(id);
      user.setEmail(email);
      user.setPassword(password);
      return user;
    }

    public User buildUserProxy() {
      UserProxy user = new UserProxy();
      user.setId(id);
      user.setEmail(email);
      user.setPassword(password);
      return user;
    }
  }
}
