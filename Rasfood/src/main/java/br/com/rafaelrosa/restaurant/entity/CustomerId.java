package br.com.rafaelrosa.restaurant.entity;


import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;

import java.io.Serializable;

@Embeddable
public class CustomerId implements Serializable {

    private String login;
    private String cpf;

    public CustomerId() {
    }

    public CustomerId(String login, String cpf) {
        this.login = login;
        this.cpf = cpf;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
