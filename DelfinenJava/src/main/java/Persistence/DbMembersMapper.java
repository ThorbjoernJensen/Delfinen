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
                    int mnr = rs.getInt("member_id");
                    String fornavn = rs.getString("fornavn");
                    String efternavn = rs.getString("efternavn");
                    String medlemstypeString = rs.getString("medlemstype");
                    MemberType medlemstype = MemberType.valueOf(medlemstypeString); //konverterer string fra db til enum
                    int aargang = rs.getInt("aargang");
                    memberList.add(new Member(mnr, fornavn, efternavn, medlemstype, aargang));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return memberList;
    }


    //    kunne også være, at det var smart at returnere objektet...
//    skulle den her tilhøre en anden mapper-klasse?
    public boolean printNewAnnualSubscription(Subscription subscription) {
        boolean result = false;
        int newId = 0;
        String sql = "insert into subscription (due_date, amount, year) values (?,?,?)";
        try (Connection connection = database.connect()) {
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, subscription.getDuedate());
                ps.setInt(2, subscription.getAmount());
                ps.setInt(3, subscription.getYear());

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    result = true;
                }
                ResultSet idResultset = ps.getGeneratedKeys();
                if (idResultset.next()) {
                    newId = idResultset.getInt(1);
                    subscription.setSubscriptionId(newId);
                } else {
                    subscription = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }

    public void insertMemberPayment(Subscription subscription, Member member) {
        boolean result = false;
        int newId = 0;
        String sql = "insert into subscription_payments (subscription_id, member_id, amount) values (?,?,?)";
        try (Connection connection = database.connect()) {
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, subscription.getSubscriptionId());
                ps.setInt(2, member.getMnr());
                ps.setInt(3, member.getMemberPayment());
                ps.executeUpdate();

//                Behøver vi et objekt som svarer til tabellen? skal der være 1:1 mellem java og database? det giver ikke rigtig mening..

//                ResultSet idResultset = ps.getGeneratedKeys();
//                if (idResultset.next()) {
//                    newId = idResultset.getInt(1);
//                    subscription.setSubscriptionId(newId);
//                } else {
//                    subscription= null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getMemberBalance(int mnr) {
//        int i = 5;
//        StringBuilder sql = new StringBuilder("select * from subscription_payments where member_id = ");
//        sql.append(i);
//        sql.append(" and status=1");

        String sql = "select * from subscription_payments where member_id = " + mnr + " and status=1";
        int restance = 0;
        try (Connection connection = database.connect()) {
            try (PreparedStatement ps = connection.prepareStatement(sql.toString())) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    restance = restance + rs.getInt("amount");
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return restance;
    }
}





