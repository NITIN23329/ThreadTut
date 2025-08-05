package lld.questions.amazon;


import java.util.List;

class Address {
    private String flatNo;
    private String street;
    private String city;

    public Address(String flatNo, String street, String city) {
        this.flatNo = flatNo;
        this.street = street;
        this.city = city;
    }
}
public class User {
    private String username;
    private List<Address> address;

    public User(String username, List<Address> address) {
        this.username = username;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }
}
