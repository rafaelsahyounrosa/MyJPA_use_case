package br.com.rafaelrosa.restaurant.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Contact {

    private String number;
    private String email;

    public Contact() {
    }

    public Contact(String number, String email) {
        this.number = number;
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "number='" + number + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
