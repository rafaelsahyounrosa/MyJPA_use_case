package br.com.rafaelrosa.restaurant.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    private String cpf;
    private String name;
    private String cep;

    public Customer() {
    }

    public Customer(String cpf, String name, String cep) {
        this.cpf = cpf;
        this.name = name;
        this.cep = cep;
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cpf='" + cpf + '\'' +
                ", name='" + name + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}
