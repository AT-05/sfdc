package salesforce.salesforceapp.entities;

/**
 * Created by Administrator on 12/6/2017.
 */
public class Account {
    private String name;
    private String address;
    private String phone;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isSame(String name, String type) {
        return (this.name.equalsIgnoreCase(name)
                && this.address.equalsIgnoreCase(type));
    }
}
