package br.com.rafaelrosa.restaurant.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @EmbeddedId
    private CustomerId customerId;
    private String name;

    @Embedded
    private Contact contact;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Address> addressList = new ArrayList<>();

    public Customer() {
    }

    public void addAddress(Address address) {
        address.setCustomer(this);
        this.addressList.add(address);
    }

    public Customer(String cpf, String login, String name) {
        this.customerId = new CustomerId(login, cpf);
        this.name = name;
    }

    public String getCpf() {
        return customerId.getCpf();
    }

    public void setCpf(String cpf) {
        this.customerId.setCpf(cpf);
    }

    public String getLogin() {
        return customerId.getLogin();
    }

    public void setLogin(String login) {
        this.customerId.setLogin(login);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

//    @Override
//    public String toString() {
//        return "Customer{" +
//                "cpf='" + cpf + '\'' +
//                ", name='" + name + '\'' +
//                ", contactEmail=" + contact.getEmail() +
//                ", contactNumber=" + contact.getNumber() +
//                ", addressList=" + addressList +
//                '}';
//    }


    @Override
    public String toString() {
        return "Customer{" +
                "cpf='" + customerId.getCpf() + '\'' +
                ", login='" + customerId.getLogin() + '\'' +
                ", name='" + name + '\'' +
                ", contact=" + contact +
                ", addressList=" + addressList +
                '}';
    }
}
