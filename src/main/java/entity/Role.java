package entity;

import lombok.Data;

@Data
public class Role implements Entity<Integer> {

  private Integer id;
  private String name;

  @Override
  public Integer getId() {
    return this.id;
  }

  @Override
  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
