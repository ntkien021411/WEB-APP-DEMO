/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modal.account;
import modal.order;
import modal.product;

/**
 *
 * @author asus
 */
public class accountDAO extends DBContextShop {

    public List<account> getAll() {
        List<account> list = new ArrayList<>();
        String sql = "select * from account";
        try {
            //  chay dc ca lenh ko tham so va co tham so
            PreparedStatement st = connection.prepareStatement(sql);

            // rieng select la chay executeQuery
            // con lai la chay executeUpdate()
            ResultSet rs = st.executeQuery();
            while (rs.next()) {    // read record in table 
                // take value from attibute of table
// value attribute of object category is value of attribute in sql table 
                account ct = new account(
                        rs.getString("accountuser"),
                        rs.getString("passuser"));
                list.add(ct);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    public List<account> getAllName(String name) {
        List<account> list = new ArrayList<>();
        String sql = "select * from account where accountuser like ?";
      
        name = "%" + name + "%";
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
                account ct = new account(
                        rs.getString("accountuser"),
                        rs.getString("passuser"));
                list.add(ct);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
      

    public List<account> getAll1() {
        List<account> list = new ArrayList<>();
        String sql = "select * from account";
        try {
            //  chay dc ca lenh ko tham so va co tham so
            PreparedStatement st = connection.prepareStatement(sql);

            // rieng select la chay executeQuery
            // con lai la chay executeUpdate()
            ResultSet rs = st.executeQuery();
            while (rs.next()) {    // read record in table 
                // take value from attibute of table
// value attribute of object category is value of attribute in sql table 
                account ct = new account(
                        rs.getString("accountuser"),
                        rs.getString("passuser"),
                        rs.getInt("role"));
                list.add(ct);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    //add a new record in table
    public void addDataTable(account ct) {
        String sql
                = "INSERT INTO account\n"
                + "           (accountuser\n"
                + "           ,passuser,role)\n"
                + "     VALUES\n"
                + "           (?,\n"
                + "           ?,?);";
        try {
            PreparedStatement st = connection.prepareCall(sql);
            st.setString(1, ct.getAccountuser());
            st.setString(2, ct.getPassuser());
            st.setInt(3, ct.getRole());
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    // kiem tra id trung lap 
    // doc all recoed from table categories
    public account getDuplicateAccountUser(String name) {
        String sql = "select * from account where accountuser =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            // set ? dau tien
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                account ct = new account(
                        rs.getString("accountuser"),
                        rs.getString("passuser"),
                        rs.getInt("role"));
                return ct;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void changePassWord(String name, String newpass) {
        String sql = "UPDATE [dbo].[account]\n"
                + "   SET \n"
                + "      [passuser] = ?\n"
                + " WHERE  accountuser = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            // set ? dau tien
            st.setString(1, newpass);
            st.setString(2, name);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
//    / doc all recoed from table categories

    public boolean getDuplicate(String name) {
        accountDAO ac = new accountDAO();
        List<account> list = ac.getAll();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAccountuser().equals(name)) {
                return true;
            }
        }
        return false;
    }

    //    / doc all recoed from table categories
    public boolean checkExist(String name, String pass) {
        accountDAO ac = new accountDAO();
        List<account> list = ac.getAll();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAccountuser().equals(name)
                    && list.get(i).getPassuser().equals(pass)) {
                return true;
            }
        }
        return false;
    }

    public int calculateUserQuantity() {
        accountDAO ac = new accountDAO();
        List<account> list = ac.getAll1();
        int count = 0;
        for (account item : list) {
            if (item.getRole() == 0) {
                count++;
            }
        }
        return count;
    }

    public int quantityUserTakeOrder() throws SQLException {
        accountDAO ac = new accountDAO();
        List<account> list = ac.getAll1();
        productDAO c = new productDAO();
        List<String> list1 = c.findNameDistince();
        List<String> listName = new ArrayList<>();

        int count = 0;
        for (account item : list) {
            if (item.getRole() == 0) {
                count++;
                listName.add(item.getAccountuser());
            }
        }
        int countTwo = 0;
        for (int i = 0; i < listName.size(); i++) {
            for (int j = 0; j < list1.size(); j++) {
                if(listName.get(i).equals(list1.get(j))){
                    countTwo++;
                }
            }
        }
        int percentCal = countTwo * 100 / count;

        return percentCal;
    }

    public static void main(String[] args) throws SQLException {
        accountDAO ac = new accountDAO();
        List<account> list = ac.getAllName("a");
        int x =0;
        for (int i = 0; i < 3; i++) {
            x++;
            
        }
          System.out.println(x);
    }

}
