package JDBC.Statement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 * <p> ResultSet 案例 </p>
 * 查询数据库中账户数据, 封装为Account对象并储存到集合中
 */

public class ResultSetCase {
    public static void main(String[] args) throws SQLException {

        ArrayList<Account> arr = new ArrayList<>();

        Statement stat = DriverManager.getConnection(
                "jdbc:mysql:///db1?useSSL=false","root","123456").createStatement();
        ResultSet rs = stat.executeQuery("select * from jdbc");

        while (rs.next()) {
            Account acc = new Account();
            acc.setId(rs.getInt(1));
            acc.setName(rs.getString(2));
            acc.setMoney(rs.getDouble(3));
            arr.add(acc);
        }

        for (Account a : arr) {
            System.out.println(a);
        }

        rs.close();
        stat.close();
    }

    //
    static class Account {
        private int id;
        private String name;
        private double money;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getMoney() {
            return money;
        }

        public void setMoney(double money) {
            this.money = money;
        }

        @Override
        public String toString() {
            return "Account{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", money=" + money +
                    '}';
        }
    }
}
