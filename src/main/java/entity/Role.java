package entity;

import entity.proxy.RoleProxy;
import java.util.List;
import javax.xml.registry.infomodel.User;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Role implements Entity<Integer>{

  private Integer id;
  private String name;


  @Override
  public Integer getId() {
    return this.id;
  }

  @Override
  public void setId(Integer integer) {
    this.id=id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public static final class RoleBuilder {
    private Integer id;
    private String name;
    private List<User> users;

    public RoleBuilder setId(Integer id) {
      this.id = id;
      return this;
    }

    public RoleBuilder setName(String name) {
      this.name = name;
      return this;
    }

    public Role buildRole() {
      Role role = new Role();
      role.setId(id);
      role.setName(name);
      return role;
    }

    public Role buildRoleProxy() {
      RoleProxy role = new RoleProxy();
      role.setId(id);
      role.setName(name);
      return role;
    }
  }
}
