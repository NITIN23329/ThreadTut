package designPattern.creational;

class Address implements Cloneable {
    String city;
    int pincode;
    public Address(String city, int pincode) {
        this.city = city;
        this.pincode = pincode;
    }
    @Override
    public Address clone() {
        try {
            return (Address) super.clone();
        }catch (CloneNotSupportedException e) {
            System.out.println("Not able to clone"+ this.getClass());
            return null;
        }
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", pincode=" + pincode +
                '}';
    }
}
class Employee implements Cloneable {
    String name;
    int age;
    Address address;
    public Employee(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
    @Override
    public Employee clone(){
        try{
            Employee clone = (Employee) super.clone();
            clone.address =  this.address.clone();
            return clone;
        }catch (CloneNotSupportedException e) {
            System.out.println("Not able to clone"+this.getClass());
            return null;
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}
public class Prototype {
    public static void main(String[] args) {
        Address address = new Address("Srinagar",12334);
        Employee employee = new Employee("Nitin",23,address);

        Employee employeeClone = employee.clone();
        employeeClone.name = "Das";
        employeeClone.address.city = "Delhi";

        System.out.println(employee);
        System.out.println(employeeClone);

    }
}
