/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modal;

import java.util.Date;

/**
 *
 * @author asus
 */
public class order {

    private int price, id;
    private String img, title;
    private int quantity;
    private String userName;
    private Date dateOrder;
    private category category;
    private int priceSumProduct, priceSum;
    private String email, address, phoneNumber;
    private int codeOrder;

    public order() {
    }

    public order(int price, int id, String img, String title, int quantity, String userName, Date dateOrder, category category, int priceSumProduct, int priceSum, String email, String address, String phoneNumber, int codeOrder) {
        this.price = price;
        this.id = id;
        this.img = img;
        this.title = title;
        this.quantity = quantity;
        this.userName = userName;
        this.dateOrder = dateOrder;
        this.category = category;
        this.priceSumProduct = priceSumProduct;
        this.priceSum = priceSum;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.codeOrder = codeOrder;
    }

    public int getCodeOrder() {
        return codeOrder;
    }

    public void setCodeOrder(int codeOrder) {
        this.codeOrder = codeOrder;
    }

   

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getPriceSumProduct() {
        return priceSumProduct;
    }

    public int getPriceSum() {
        return priceSum;
    }

    public void setPriceSumProduct(int priceSumProduct) {
        this.priceSumProduct = priceSumProduct;
    }

    public void setPriceSum(int priceSum) {
        this.priceSum = priceSum;
    }

    public category getCategory() {
        return category;
    }

    public void setCategory(category category) {
        this.category = category;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public String getImg() {
        return img;
    }

    public String getTitle() {
        return title;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getUserName() {
        return userName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
