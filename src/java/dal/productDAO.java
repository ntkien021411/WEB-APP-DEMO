/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import modal.product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Comparator;
import modal.account;
import modal.category;
import modal.order;
import modal.popularProduct;

/**
 *
 * @author asus
 */
public class productDAO extends DBContextShop {

    // doc all recoed from table categories
    public List<product> getAll() {
        List<product> list = new ArrayList<>();
        String sql = "select * from product";
        try {
            //  chay dc ca lenh ko tham so va co tham so
            PreparedStatement st = connection.prepareStatement(sql);

            // rieng select la chay executeQuery
            // con lai la chay executeUpdate()
            ResultSet rs = st.executeQuery();
            while (rs.next()) {    // read record in table 
                // take value from attibute of table
// value attribute of object category is value of attribute in sql table 
                category c = getCategoryID(rs.getInt("tid"));
                product ct = new product(rs.getInt("id"),
                        rs.getString("img"),
                        rs.getString("title"),
                        rs.getInt("price"),
                        rs.getInt("quantity"),
                        c,
                        rs.getString("username"));
                list.add(ct);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
     public List<product> getP(int name) {
        List<product> list = new ArrayList<>();
        String sql = "";
        if(name == 1){
             sql += "select * from product order by quantity asc";
        }else{
             sql += "select * from product order by quantity desc";
        }
        
        try {
            //  chay dc ca lenh ko tham so va co tham so
            PreparedStatement st = connection.prepareStatement(sql);
            // rieng select la chay executeQuery
            // con lai la chay executeUpdate()
            ResultSet rs = st.executeQuery();
            while (rs.next()) {    // read record in table 
                // take value from attibute of table
// value attribute of object category is value of attribute in sql table 
                category c = getCategoryID(rs.getInt("tid"));
                product ct = new product(rs.getInt("id"),
                        rs.getString("img"),
                        rs.getString("title"),
                        rs.getInt("price"),
                        rs.getInt("quantity"),
                        c,
                        rs.getString("username"));
                list.add(ct);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public List<order> getAllOrder() {
        List<order> list = new ArrayList<>();
        String sql = "select * from OrderUser";
        try {
            //  chay dc ca lenh ko tham so va co tham so
            PreparedStatement st = connection.prepareStatement(sql);

            // rieng select la chay executeQuery
            // con lai la chay executeUpdate()
            ResultSet rs = st.executeQuery();
            while (rs.next()) {    // read record in table 
                // take value from attibute of table
// value attribute of object category is value of attribute in sql table 
                category c = getCategoryID(rs.getInt("tid"));
                order ct = new order(
                        rs.getInt("price"),
                        rs.getInt("ID"),
                        rs.getString("img"),
                        rs.getString("title"),
                        rs.getInt("quantity"),
                        rs.getString("username"),
                        rs.getDate("dateOrder"), c,
                        rs.getInt("priceSumProduct"),
                        rs.getInt("priceSum"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("phoneNumber"),
                        rs.getInt("code"));
                list.add(ct);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<product> sortProduct(List<product> list, String choice) {
        
            if (choice.equals("1")) {
                Collections.sort(list, (product o1, product o2) -> {
                    //sort increase by name
                    // compare two object
                    // if o1 < o2
                    if (o1.getPrice() < o2.getPrice()) {
                        // return value -1
                        return -1;
                        // if o1 = o2
                    } else if (o1.getPrice() == o2.getPrice()) {
                        // return value 0
                        return 0;
                    } else { // if o1 > o2
                        // return value 1
                        return 1;
                    }
                });
            } else if (choice.equals("2")) {
                Collections.sort(list, (product o1, product o2) -> {
                    //sort increase by name
                    // compare two object
                    // if o1 < o2
                    if (o1.getPrice() > o2.getPrice()) {
                        // return value -1
                        return -1;
                        // if o1 = o2
                    } else if (o1.getPrice() == o2.getPrice()) {
                        // return value 0
                        return 0;
                    } else { // if o1 > o2
                        // return value 1
                        return 1;
                    }
                });
            }
        

        return list;
    }

    public List<product> getAllByTID(product p) {
        List<product> list = new ArrayList<>();
        String sql = "select * from listproduct   WHERE tid = ?";
        try {
            //  chay dc ca lenh ko tham so va co tham so
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, p.getCategory().getId());
            // rieng select la chay executeQuery
            // con lai la chay executeUpdate()
            ResultSet rs = st.executeQuery();
            while (rs.next()) {    // read record in table 
                // take value from attibute of table
// value attribute of object category is value of attribute in sql table 
                category c = getCategoryID(rs.getInt("tid"));
                product ct = new product(rs.getInt("id"),
                        rs.getString("img"),
                        rs.getString("title"),
                        rs.getInt("price"),
                        rs.getInt("quantity"),
                        c);
                list.add(ct);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<product> getAllByPrice(product p) {
        List<product> list = new ArrayList<>();
        String sql = "select * from listproduct   WHERE price = ?";
        try {
            //  chay dc ca lenh ko tham so va co tham so
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, p.getPrice());
            // rieng select la chay executeQuery
            // con lai la chay executeUpdate()
            ResultSet rs = st.executeQuery();
            while (rs.next()) {    // read record in table 
                // take value from attibute of table
// value attribute of object category is value of attribute in sql table 
                category c = getCategoryID(rs.getInt("tid"));
                product ct = new product(rs.getInt("id"),
                        rs.getString("img"),
                        rs.getString("title"),
                        rs.getInt("price"),
                        rs.getInt("quantity"),
                        c);
                list.add(ct);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<product> getAllByTIDAndPRICE(product p) {
        List<product> list = new ArrayList<>();
        String sql = "select * from listproduct   WHERE tid = ? and price = ?";
        try {
            //  chay dc ca lenh ko tham so va co tham so
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, p.getCategory().getId());
            st.setInt(2, p.getPrice());
            // rieng select la chay executeQuery
            // con lai la chay executeUpdate()
            ResultSet rs = st.executeQuery();
            while (rs.next()) {    // read record in table 
                // take value from attibute of table
// value attribute of object category is value of attribute in sql table 
                category c = getCategoryID(rs.getInt("tid"));
                product ct = new product(rs.getInt("id"),
                        rs.getString("img"),
                        rs.getString("title"),
                        rs.getInt("price"),
                        rs.getInt("quantity"),
                        c);
                list.add(ct);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<product> getAllByTIDAndSmallerPRICE(product p) {
        List<product> list = new ArrayList<>();
        String sql = "select * from listproduct   WHERE tid = ? and price <= ?";
        try {
            //  chay dc ca lenh ko tham so va co tham so
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, p.getCategory().getId());
            st.setInt(2, p.getPrice());
            // rieng select la chay executeQuery
            // con lai la chay executeUpdate()
            ResultSet rs = st.executeQuery();
            while (rs.next()) {    // read record in table 
                // take value from attibute of table
// value attribute of object category is value of attribute in sql table 
                category c = getCategoryID(rs.getInt("tid"));
                product ct = new product(rs.getInt("id"),
                        rs.getString("img"),
                        rs.getString("title"),
                        rs.getInt("price"),
                        rs.getInt("quantity"),
                        c);
                list.add(ct);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<product> getAllBySmallerPRICE(product p) {
        List<product> list = new ArrayList<>();
        String sql = "select * from listproduct   WHERE  price <= ?";
        try {
            //  chay dc ca lenh ko tham so va co tham so
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, p.getPrice());
            // rieng select la chay executeQuery
            // con lai la chay executeUpdate()
            ResultSet rs = st.executeQuery();
            while (rs.next()) {    // read record in table 
                // take value from attibute of table
// value attribute of object category is value of attribute in sql table 
                category c = getCategoryID(rs.getInt("tid"));
                product ct = new product(rs.getInt("id"),
                        rs.getString("img"),
                        rs.getString("title"),
                        rs.getInt("price"),
                        rs.getInt("quantity"),
                        c);
                list.add(ct);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<product> getAllByFromToPRICE(product p, int priceTo) {
        List<product> list = new ArrayList<>();
        String sql = "select * from listproduct   WHERE  price >= ? and price <= ?";
        try {
            //  chay dc ca lenh ko tham so va co tham so
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, p.getPrice());
            st.setInt(2, priceTo);
            // rieng select la chay executeQuery
            // con lai la chay executeUpdate()
            ResultSet rs = st.executeQuery();
            while (rs.next()) {    // read record in table 
                // take value from attibute of table
// value attribute of object category is value of attribute in sql table 
                category c = getCategoryID(rs.getInt("tid"));
                product ct = new product(rs.getInt("id"),
                        rs.getString("img"),
                        rs.getString("title"),
                        rs.getInt("price"),
                        rs.getInt("quantity"),
                        c);
                list.add(ct);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<product> getAllByTitle(product p) {
        List<product> list = new ArrayList<>();
        String sql = "select * from listproduct   WHERE  title like ?  ";
        try {
            //  chay dc ca lenh ko tham so va co tham so
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, p.getTitle());
            // rieng select la chay executeQuery
            // con lai la chay executeUpdate()
            ResultSet rs = st.executeQuery();
            while (rs.next()) {    // read record in table 
                // take value from attibute of table
// value attribute of object category is value of attribute in sql table 
                category c = getCategoryID(rs.getInt("tid"));
                product ct = new product(rs.getInt("id"),
                        rs.getString("img"),
                        rs.getString("title"),
                        rs.getInt("price"),
                        rs.getInt("quantity"),
                        c);
                list.add(ct);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<product> getAllByFromToPRICEwithTID(product p, int priceTo) {
        List<product> list = new ArrayList<>();
        String sql = "select * from listproduct   WHERE  price >= ? and price <= ? and tid = ?";
        try {
            //  chay dc ca lenh ko tham so va co tham so
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, p.getPrice());
            st.setInt(2, priceTo);
            st.setInt(3, p.getCategory().getId());
            // rieng select la chay executeQuery
            // con lai la chay executeUpdate()
            ResultSet rs = st.executeQuery();
            while (rs.next()) {    // read record in table 
                // take value from attibute of table
// value attribute of object category is value of attribute in sql table 
                category c = getCategoryID(rs.getInt("tid"));
                product ct = new product(rs.getInt("id"),
                        rs.getString("img"),
                        rs.getString("title"),
                        rs.getInt("price"),
                        rs.getInt("quantity"),
                        c);
                list.add(ct);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<product> getAll2(int tid) {
        List<product> list = new ArrayList<>();
        String sql = "select * from listproduct   WHERE tid = ?";
        try {
            //  chay dc ca lenh ko tham so va co tham so
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, tid);
            // rieng select la chay executeQuery
            // con lai la chay executeUpdate()
            ResultSet rs = st.executeQuery();
            while (rs.next()) {    // read record in table 
                // take value from attibute of table
// value attribute of object category is value of attribute in sql table 
                category c = getCategoryID(rs.getInt("tid"));
                product ct = new product(rs.getInt("id"),
                        rs.getString("img"),
                        rs.getString("title"),
                        rs.getInt("price"),
                        rs.getInt("quantity"),
                        c);
                list.add(ct);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<product> getAll1() {
        List<product> list = new ArrayList<>();
        String sql = "select * from listproduct";
        try {
            //  chay dc ca lenh ko tham so va co tham so
            PreparedStatement st = connection.prepareStatement(sql);
            // rieng select la chay executeQuery
            // con lai la chay executeUpdate()
            ResultSet rs = st.executeQuery();
            while (rs.next()) {    // read record in table 
                // take value from attibute of table
// value attribute of object category is value of attribute in sql table 
                category c = getCategoryID(rs.getInt("tid"));
                product ct = new product(rs.getInt("id"),
                        rs.getString("img"),
                        rs.getString("title"),
                        rs.getInt("price"),
                        rs.getInt("quantity"),
                        c);
                
                list.add(ct);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public String ChangeOneMoney(int total) {
        String money = Integer.toString(total);
        List<String> list1 = new ArrayList<>();
        int length = money.length();
        int count = 0;
        for (int i = length - 1; i >= 0; i--) {
            String cd = money.charAt(i) + "";
            list1.add(cd);
            count++;
            if (count == 3) {
                list1.add(",");
                count = 0;
            }
        }
        if (list1.get(list1.size() - 1).equals(",")) {
            list1.remove(list1.size() - 1);
        }
        String price1 = "";
        for (int i = list1.size() - 1; i >= 0; i--) {
            price1 += list1.get(i);
        }

        return price1;
    }

    public List<product> ChangeMoney(List<product> list) {
        List<product> listAfterFormat = new ArrayList<>();
        for (product item : list) {
            String money = Integer.toString(item.getPrice());
            List<String> list1 = new ArrayList<>();
            int length = money.length();
            int count = 0;
            for (int i = length - 1; i >= 0; i--) {
                String cd = money.charAt(i) + "";
                list1.add(cd);
                count++;
                if (count == 3) {
                    list1.add(",");
                    count = 0;
                }
            }
            if (list1.get(list1.size() - 1).equals(",")) {
                list1.remove(list1.size() - 1);
            }
            String price1 = "";
            for (int i = list1.size() - 1; i >= 0; i--) {
                price1 += list1.get(i);
            }
            product p1 = new product(item.getId(),
                    item.getImg(), item.getTitle(), price1,
                    item.getQuantity(),
                    item.getCategory(),
                    item.getPrice());
            listAfterFormat.add(p1);

        }
        return listAfterFormat;
    }

    public product ChangeMoneyProduct(product p) {
        String money = Integer.toString(p.getPrice());
        List<String> list1 = new ArrayList<>();
        int length = money.length();
        int count = 0;
        for (int i = length - 1; i >= 0; i--) {
            String cd = money.charAt(i) + "";
            list1.add(cd);
            count++;
            if (count == 3) {
                list1.add(",");
                count = 0;
            }
        }
        if (list1.get(list1.size() - 1).equals(",")) {
            list1.remove(list1.size() - 1);
        }
        String price1 = "";
        for (int i = list1.size() - 1; i >= 0; i--) {
            price1 += list1.get(i);
        }
        p.setPrice1(price1);

        return p;
    }

    public List<product> ChangeTotal(List<product> list) {
//        List<product> list2 = ChangeMoney(list);
        List<product> listAfterFormat = new ArrayList<>();
        for (product item : list) {
            String money = Integer.toString(item.getPrice() * item.getQuantity());
            List<String> list1 = new ArrayList<>();
            int length = money.length();
            int count = 0;
            for (int i = length - 1; i >= 0; i--) {
                String cd = money.charAt(i) + "";
                list1.add(cd);
                count++;
                if (count == 3) {
                    list1.add(",");
                    count = 0;
                }
            }
            if (list1.get(list1.size() - 1).equals(",")) {
                list1.remove(list1.size() - 1);
            }
            String price1 = "";
            for (int i = list1.size() - 1; i >= 0; i--) {
                price1 += list1.get(i);
            }
            product p1 = new product(item.getId(),
                    item.getImg(), item.getTitle(), item.getPrice1(),
                    item.getQuantity(),
                    price1,
                    item.getCategory(),
                    item.getUserName());
            listAfterFormat.add(p1);

        }
        return listAfterFormat;
    }

    public List<product> getAllByName(String name) {
        List<product> list = new ArrayList<>();
        String sql = "select * from product where username = ?";
        try {
            //  chay dc ca lenh ko tham so va co tham so
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            // rieng select la chay executeQuery
            // con lai la chay executeUpdate()
            ResultSet rs = st.executeQuery();
            while (rs.next()) {    // read record in table 
                // take value from attibute of table
// value attribute of object category is value of attribute in sql table 
                category c = getCategoryID(rs.getInt("tid"));
                product ct = new product(rs.getInt("id"),
                        rs.getString("img"),
                        rs.getString("title"),
                        rs.getInt("price"),
                        rs.getInt("quantity"),
                        c,
                        rs.getString("username"));
                list.add(ct);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    //add a new record in table 
    public void deleteAllProduct(String name) {

        String sql
                = "  delete  from product where username = ?";
        try {
            PreparedStatement st = connection.prepareCall(sql);
            st.setString(1, name);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void insertOrder(List<order> list) {

        try {
            String sql
                    = "INSERT INTO [dbo].[OrderUser]\n"
                    + "           ([ID]\n"
                    + "           ,[img]\n"
                    + "           ,[title]\n"
                    + "           ,[price]\n"
                    + "           ,[priceSumProduct]\n"
                    + "           ,[priceSum]\n"
                    + "           ,[quantity]\n"
                    + "           ,[tid]\n"
                    + "           ,[dateOrder]\n"
                    + "           ,[username]\n"
                    + "           ,[email]\n"
                    + "           ,[address]\n"
                    + "           ,[phoneNumber],[code])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?,?)";
            for (order ct : list) {
                PreparedStatement st = connection.prepareStatement(sql);
                st.setInt(1, ct.getId());
                st.setString(2, ct.getImg());
                st.setString(3, ct.getTitle());
                st.setInt(4, ct.getPrice());
                st.setInt(5, ct.getPriceSumProduct());
                st.setInt(6, ct.getPriceSum());
                st.setInt(7, ct.getQuantity());
                st.setInt(8, ct.getCategory().getId());
                java.util.Date date = ct.getDateOrder();
                java.sql.Date sqlDate = new Date(date.getTime());
                st.setDate(9, sqlDate);
                st.setString(10, ct.getUserName());
                st.setString(11, ct.getEmail());
                st.setString(12, ct.getAddress());
                st.setString(13, ct.getPhoneNumber());
                st.setInt(14, ct.getCodeOrder());
                st.executeUpdate();
            }
        } catch (Exception e) {
        }
    }

    //add a new record in table 
    public void addDataTable(product ct) {
        String sql
                = "insert into product \n"
                + "values(?,?,\n"
                + "?, ?,?,?,?);";
        try {
            PreparedStatement st = connection.prepareCall(sql);
            st.setInt(1, ct.getId());
            st.setString(2, ct.getImg());
            st.setString(3, ct.getTitle());
            st.setInt(4, ct.getPrice());
            st.setInt(5, ct.getQuantity());
            st.setInt(6, ct.getCategory().getId());
            st.setString(7, ct.getUserName());
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
    //add a new record in table 

    public void addDataTable1(product ct) {
        String sql
                = "insert into listproduct  VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareCall(sql);
            st.setInt(1, ct.getId());
            st.setString(2, ct.getImg());
            st.setString(3, ct.getTitle());
            st.setInt(4, ct.getPrice());
            st.setInt(5, ct.getQuantity());
            st.setInt(6, ct.getCategory().getId());
//            st.setString(7, ct.getUserName());
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public category getCategoryID(int id) {
        String sql = "select * from category where id =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            // set ? dau tien
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                category ct = new category(rs.getInt("id"),
                        rs.getString("title"));
                return ct;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    // kiem tra id trung lap 
    // doc all recoed from table categories
    public product getProductID(int id) {
        String sql = "select * from product where id =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            // set ? dau tien
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                category c = getCategoryID(rs.getInt("tid"));
                product ct = new product(rs.getInt("id"),
                        rs.getString("img"),
                        rs.getString("title"),
                        rs.getInt("price"),
                        rs.getInt("quantity"),
                        c,
                        rs.getString("username"));
                return ct;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public product getProductIMG(String img) {
        String sql = "select * from listproduct where img =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            // set ? dau tien
            st.setString(1, img);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                category c = getCategoryID(rs.getInt("tid"));
                product ct = new product(rs.getInt("id"),
                        rs.getString("img"),
                        rs.getString("title"),
                        rs.getInt("price"),
                        rs.getInt("quantity"),
                        c);
                return ct;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<product> getProductByTidAndName(int tid, String name) {
        List<product> list = new ArrayList<>();
        String sql = "select * from product where tid = ? and username = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            // set ? dau tien
            st.setInt(1, tid);
            st.setString(2, name);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                category c = getCategoryID(rs.getInt("tid"));
                product ct = new product(rs.getInt("id"),
                        rs.getString("img"),
                        rs.getString("title"),
                        rs.getInt("price"),
                        rs.getInt("quantity"),
                        c,
                        rs.getString("username"));
                list.add(ct);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<product> getProductByName(String name) {
        List<product> list = new ArrayList<>();
        String sql = "select * from product where username =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            // set ? dau tien
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                category c = getCategoryID(rs.getInt("tid"));
                product ct = new product(rs.getInt("id"),
                        rs.getString("img"),
                        rs.getString("title"),
                        rs.getInt("price"),
                        rs.getInt("quantity"),
                        c,
                        rs.getString("username"));
                list.add(ct);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    // kiem tra id trung lap 
    // doc all recoed from table categories
    public boolean checkExist(String img, String name) {
        productDAO ac = new productDAO();
        List<product> list = ac.getAll();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUserName().equals(name)) {
                if (list.get(i).getImg().equals(img)) {
                    return true;
                }
            }

        }
        return false;
    }

    public boolean checkExist1(int id) {
        productDAO ac = new productDAO();
        List<product> list = ac.getAll1();
        for (product item : list) {
            if (item.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public product checkDuplicate(String img, String name) {
        String sql = "select * from product where img =? and username = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            // set ? dau tien
            st.setString(1, img);
            st.setString(2, name);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                category c = getCategoryID(rs.getInt("tid"));
                product ct = new product(rs.getInt("id"),
                        rs.getString("img"),
                        rs.getString("title"),
                        rs.getInt("price"),
                        rs.getInt("quantity"),
                        c,
                        rs.getString("username"));
                return ct;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    // xoa 

    public void delete(String img) {
        String sql = "DELETE FROM [dbo].[product]\n"
                + "      WHERE img = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, img);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteList(String img) {
        String sql = "DELETE FROM [dbo].[listproduct]\n"
                + "      WHERE img = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, img);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    // update 
    public void update(product p) {
        String sql
                = "update product \n"
                + "set \n"
                + "quantity = ?\n"
                + "where img = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, p.getQuantity());
            st.setString(2, p.getImg());
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updatePrice(String price, String img) {
        String sql = "";
        int price_change = Integer.parseInt(price);
        sql
                += "update product \n"
                + "set \n"
                + "price = ?\n"
                + "where img = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, price_change);
            st.setString(2, img);
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void updateTitle(String title, String img) {
        String sql = "";
        sql
                += "update product \n"
                + "set \n"
                + "title = ?\n"
                + "where img = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, title);
            st.setString(2, img);
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }

    // update 
    public void update1(product p) {
        String sql
                = "update listproduct \n"
                + "set \n"
                + "quantity = ?,"
                + "title = ?,"
                + "price = ?\n"
                + "where img = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, p.getQuantity());
            st.setString(2, p.getTitle());
            st.setInt(3, p.getPrice());
            st.setString(4, p.getImg());
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public int findMaxPrice(int tid) {
        productDAO c = new productDAO();
        List<product> list = c.getAll1();
        int maxP = list.get(0).getPrice();

        for (int i = 0; i < list.size(); i++) {
            if (maxP < list.get(i).getPrice()) {
                maxP = list.get(i).getPrice();
            }
        }
        return maxP;
    }

    public int findMaxPrice() {
        productDAO c = new productDAO();
        List<product> list = c.getAll1();
        int maxP = list.get(0).getPrice();

        for (int i = 0; i < list.size(); i++) {
            if (maxP < list.get(i).getPrice()) {
                maxP = list.get(i).getPrice();
            }
        }
        return maxP;
    }

    public int findMinPrice() {
        productDAO c = new productDAO();
        List<product> list = c.getAll1();
        int minP = list.get(0).getPrice();

        for (int i = 0; i < list.size(); i++) {
            if (minP > list.get(i).getPrice()) {
                minP = list.get(i).getPrice();
            }
        }
        return minP;
    }

    public int findMaxPriceByTID(int tid) {
        productDAO c = new productDAO();
        List<product> list = c.getAll1();

        List<product> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCategory().getId() == tid) {
                product p = list.get(i);
                list1.add(p);
            }
        }
        int maxP = list1.get(0).getPrice();
        for (int i = 0; i < list1.size(); i++) {
            if (maxP < list1.get(i).getPrice()) {
                maxP = list1.get(i).getPrice();
            }
        }
        return maxP;
    }

    public int findMinPriceByTID(int tid) {
        productDAO c = new productDAO();
        List<product> list = c.getAll1();

        List<product> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCategory().getId() == tid) {
                product p = list.get(i);
                list1.add(p);
            }
        }
        int minP = list1.get(0).getPrice();
        for (int i = 0; i < list1.size(); i++) {
            if (minP > list1.get(i).getPrice()) {
                minP = list1.get(i).getPrice();
            }
        }
        return minP;
    }

    public product findMaxPriceListProduct() {
        productDAO c = new productDAO();
        List<product> list = c.getAll1();

        product maxP = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (maxP.getPrice() < list.get(i).getPrice()) {
                maxP = list.get(i);
            }
        }
        return maxP;
    }

    public product findMinPriceListProduct() {
        productDAO c = new productDAO();
        List<product> list = c.getAll1();

        product minP = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (minP.getPrice() > list.get(i).getPrice()) {
                minP = list.get(i);
            }
        }
        return minP;
    }

    public int calculateOrderQuantity() throws SQLException {
        String sql
                = "select MAX(code) from OrderUser";
        int num;
        PreparedStatement st = connection.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {

            num = rs.getInt(1);
            return num;
        }
        return 0;
    }

    public List<String> findImgDistince() throws SQLException {
        List<String> listImg = new ArrayList<>();
        String sql
                = "SELECT DISTINCT img FROM OrderUser;";
        PreparedStatement st = connection.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            listImg.add(rs.getString(1));
        }
        return listImg;
    }

    public List<String> findNameDistince() throws SQLException {
        List<String> listImg = new ArrayList<>();
        String sql
                = "SELECT DISTINCT username FROM OrderUser;";
        PreparedStatement st = connection.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            listImg.add(rs.getString(1));
        }
        return listImg;
    }

    public int calculateProductQuantity() {
        productDAO c = new productDAO();
        List<product> list = c.getAll1();
        int count = list.size();
        return count;

    }

    public int calculateProductQuantityWithProductInOrder() throws SQLException {
        productDAO c = new productDAO();
        List<product> list = c.getAll1();
        int count = list.size();
        List<String> listImg = c.findImgDistince();
        int countTwo = listImg.size();
        int percentage = countTwo * 100 / count;
//        DecimalFormat df = new DecimalFormat();
//        df.setMaximumFractionDigits(2);
        return percentage;

    }

    public order selectOneRecordFromOrder(int num) throws SQLException {
        String sql = "SELECT top(1) * FROM OrderUser where code = ?";
        PreparedStatement st = connection.prepareStatement(sql);
        st.setInt(1, num);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            category c = getCategoryID(rs.getInt("tid"));
            order ct = new order(
                    rs.getInt("price"),
                    rs.getInt("ID"),
                    rs.getString("img"),
                    rs.getString("title"),
                    rs.getInt("quantity"),
                    rs.getString("username"),
                    rs.getDate("dateOrder"), c,
                    rs.getInt("priceSumProduct"),
                    rs.getInt("priceSum"),
                    rs.getString("email"),
                    rs.getString("address"),
                    rs.getString("phoneNumber"),
                    rs.getInt("code"));
            return ct;
        }
        return null;
    }

    public int calculateOrderOvertargets() throws SQLException {
        productDAO c = new productDAO();
        List<order> list = c.getAllOrder();
        int count = list.get(list.size() - 1).getCodeOrder();

        List<order> listO = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            order o = c.selectOneRecordFromOrder(i);
            listO.add(o);
        }

        int countTwo = 0;

        for (order item : listO) {
            if (item.getPriceSum() >= 2000000) {
                countTwo++;
            }
        }

        int percentage = countTwo * 100 / count;
        return percentage;

    }

    public popularProduct findPopularProduct() throws SQLException {
        productDAO c = new productDAO();
        List<order> list = c.getAllOrder();
        List<String> listImg = c.findImgDistince();
        List<popularProduct> listPP = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < listImg.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (listImg.get(i).equals(list.get(j).getImg())) {
                    count++;
                }
            }
            popularProduct pp = new popularProduct(listImg.get(i), count);
            listPP.add(pp);
//            listQuantity.add(count);
            count = 0;
        }
        popularProduct max = listPP.get(0);
        for (int i = 0; i < listPP.size() - 1; i++) {
            if (max.getQuantity() < listPP.get(i).getQuantity()) {
                max = listPP.get(i);
            }
        }
        return max;

    }

    public static void main(String[] args) throws SQLException {
        productDAO c = new productDAO();
        int count = 0;
        List<product> listO = c.getP(2);
        for (product object : listO) {
            System.out.println(object.getQuantity());
        }
        
    }
}
