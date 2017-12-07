package salesforce.salesforceapp.entities;

public class Product {

  private String name;
  private String code;
  private String description;

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


}
