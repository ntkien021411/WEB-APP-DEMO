/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modal;

/**
 *
 * @author asus
 */
public class product {
//    ID [int] primary key,
//   img nvarchar(200) ,
//   title nvarchar(50), 
//   price int, 

    private int id, price;
    private String price1;
    private String total1;

    public void setTotal1(String total1) {
        this.total1 = total1;
    }

    public String getTotal1() {
        return total1;
    }

    

   
    public product(int id, String img, String title, String price1, int quantity, String total1, category category, String userName) {
        this.id = id;
        this.price1 = price1;
        this.total1 = total1;
        this.img = img;
        this.title = title;
        this.quantity = quantity;
        this.category = category;
        this.userName = userName;
    }

    // constructor to format money
    public product(int id, String img, String title, String price1, int quantity, category category, int price) {
        this.id = id;
        this.price1 = price1;
        this.img = img;
        this.title = title;
        this.quantity = quantity;
        this.category = category;
        this.price = price;
    }

    public String getPrice1() {
        return price1;
    }

    public void setPrice1(String price1) {
        this.price1 = price1;
    }
    ///

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
    private String img, title;
    private int quantity;
    private category category;
    private String userName;

    public product(int id, String img, String title, int price, int quantity, category category) {
        this.id = id;
        this.price = price;
        this.img = img;
        this.title = title;
        this.quantity = quantity;
        this.category = category;
    }

    public category getCategory() {
        return category;
    }

    public void setCategory(category category) {
        this.category = category;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public product() {
    }

    public product(int id, String img, String title, int price, int quantity, category category, String userName) {
        this.id = id;
        this.price = price;
        this.img = img;
        this.title = title;
        this.quantity = quantity;
        this.category = category;
        this.userName = userName;
    }

    public product(int id, int quantity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getId() {
        return id;
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

    public void setId(int id) {
        this.id = id;
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

}
