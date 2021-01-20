package Persistence;

import Domain.Member;
import Domain.MemberType;
import Domain.Subscription;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbMembersMapper {

    Database database;

    public DbMembersMapper(Database database) {
        this.database = database;
    }

    public List<Member> showAllMembers() {
        List<Member> memberList = new ArrayList<>();
        String sql = "select * from member";
        try (Connection connection = database.connect()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int mnr= rs.getInt("mnr");
                    String fornavn = rs.getString("fornavn");
                    String efternavn = rs.getString("efternavn");
                    String medlemstypeString = rs.getString("medlemstype");
                    MemberType medlemstype = MemberType.valueOf(medlemstypeString); //konverterer string fra db til enum
                    memberList.add(new Member(mnr, fornavn, efternavn, medlemstype));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return memberList;
    }
    public boolean createNewSubscription (Subscription subscription){
        boolean result = false;
        int newId = 0;
        String sql = "insert into pizza (pizza_no, name, ingredients, price) values (?,?,?,?)";
        try (Connection connection = database.connect()) {
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, subscription.);


                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    result = true;
                }
                ResultSet idResultset = ps.getGeneratedKeys();
                if (idResultset.next()) {
                    newId = idResultset.getInt(1);
                    pizza.setPizzaId(newId);
                } else {
                    pizza = null;
                }
            } catch (Exception e) {
                throw new ExceptionHandling(e);
            }
        } catch (Exception e) {
            throw new ExceptionHandling(e);
        }
        return pizza;
    }



}
//    public Pizza insertPizza(Pizza pizza) throws Exception {
//        boolean result = false;
//        int newId = 0;
//        String sql = "insert into pizza (pizza_no, name, ingredients, price) values (?,?,?,?)";
//        try (Connection connection = database.connect()) {
//            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
//                ps.setInt(1, pizza.getPizzaNo());
//                ps.setString(2, pizza.getName());
//                ps.setString(3, pizza.getIngredients());
//                ps.setInt(4, pizza.getPrice());
//                int rowsAffected = ps.executeUpdate();
//                if (rowsAffected == 1) {
//                    result = true;
//                }
//                ResultSet idResultset = ps.getGeneratedKeys();
//                if (idResultset.next()) {
//                    newId = idResultset.getInt(1);
//                    pizza.setPizzaId(newId);
//                } else {
//                    pizza = null;
//                }
//            } catch (Exception e) {
//                throw new ExceptionHandling(e);
//            }
//        } catch (Exception e) {
//            throw new ExceptionHandling(e);
//        }
//        return pizza;
//    }


}
