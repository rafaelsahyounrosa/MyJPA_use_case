package br.com.rafaelrosa.restaurant.vo;

public class BestSellerVo {

    private String name;
    private Long quantity;

    public BestSellerVo(String name, Long quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "BestSellerVo{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
