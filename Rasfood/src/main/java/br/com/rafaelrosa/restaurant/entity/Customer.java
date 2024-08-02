package br.com.rafaelrosa.restaurant.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    private String cpf;
    private String name;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Address> addressList = new ArrayList<>();

    public Customer() {
    }

    public void addAddress(Address address) {
        address.setCustomer(this);
        this.addressList.add(address);
    }

    public Customer(String cpf, String name) {
        this.cpf = cpf;
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    @Override
    public String toString() {

        return "Customer{" +
                "cpf='" + cpf + '\'' +
                ", name='" + name + '\'' +
                ", addressList=" + addressList +
                '}';
    }
}
