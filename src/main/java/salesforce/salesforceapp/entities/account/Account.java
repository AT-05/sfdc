package salesforce.salesforceapp.entities.account;

/**
 * Created by Administrator on 12/6/2017.
 */
public class Account {
  private String id;
  private String name;
  private String type;
  private String web;
  private String description;
  private String phone;
  private String sector;
  private String employees;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getWeb() {
    return web;
  }

  public void setWeb(String web) {
    this.web = web;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getSector() {
    return sector;
  }

  public void setSector(String sector) {
    this.sector = sector;
  }

  public String getEmployees() {
    return employees;
  }

  public void setEmployees(String employees) {
    this.employees = employees;
  }

    public boolean isSame(String name, String type) {
        return (this.name.equalsIgnoreCase(name)
                && this.web.equalsIgnoreCase(type));
    }
}
