package br.com.rafaelrosa.restaurant.vo;

public class CustomerVo {

    private String cpf;
    private String name;

    public CustomerVo(String cpf, String name) {
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

    @Override
    public String toString() {
        return "CustomerVo{" +
                "cpf='" + cpf + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
