/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modal;

/**
 *
 * @author asus
 */
public class popularProduct {
    String img;
    int quantity;

    public popularProduct(String img, int quantity) {
        this.img = img;
        this.quantity = quantity;
    }

    public String getImg() {
        return img;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
