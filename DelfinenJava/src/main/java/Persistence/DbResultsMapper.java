package Persistence;

import Domain.Result;

import java.sql.*;

public class DbResultsMapper {

    Database database;

    public DbResultsMapper(Database database) {
        this.database = database;
    }

//    public List<Member> showAllResults() {
//        List<Member> memberList = new ArrayList<>();
//        String sql = "select * from member";
//        try (Connection connection = database.connect()) {
//            try (PreparedStatement ps = connection.prepareStatement(sql)) {
//                ResultSet rs = ps.executeQuery();
//                while (rs.next()) {
//                    int mnr = rs.getInt("member_id");
//                    String fornavn = rs.getString("fornavn");
//                    String efternavn = rs.getString("efternavn");
//                    String medlemstypeString = rs.getString("medlemstype");
//                    MemberType medlemstype = MemberType.valueOf(medlemstypeString); //konverterer string fra db til enum
//                    String engagementString = rs.getString("engagement");
//                    MemberActivityLevel engagement = MemberActivityLevel.valueOf(engagementString);
//                    int aargang = rs.getInt("aargang");
//                    memberList.add(new Member(mnr, fornavn, efternavn, medlemstype, engagement, aargang));
//                }
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return memberList;
//    }


    public boolean insertNewResult(Result r) {

        boolean updated = false;
        int newId = 0;
        String sql = "insert into result (mnr, tid, swimmingStyle, distance) values(?,?,?,?)";
        try (Connection connection = database.connect()) {
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, r.getMnr());
                ps.setInt(2, r.getTime());
                ps.setString(3, r.getSwimmingStyle().toString());
                ps.setString(4, r.getDistance().toString());

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    updated = true;
                }

                ResultSet resultSet = ps.getGeneratedKeys();
                if (resultSet.next()) {
                    newId = resultSet.getInt(1);
                    r.setResultId(newId);
                }
// else = null?

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return updated;

    }


//    public void insertMemberPayment(Subscription subscription, Member member) {
//        boolean result = false;
//        int newId = 0;
//        String sql = "insert into subscription_payments (subscription_id, member_id, amount) values (?,?,?)";
//        try (Connection connection = database.connect()) {
//            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
//                ps.setInt(1, subscription.getSubscriptionId());
//                ps.setInt(2, member.getMnr());
//                ps.setInt(3, member.getMemberPayment());
//                ps.executeUpdate();
//
////                Behøver vi et objekt som svarer til tabellen? skal der være 1:1 mellem java og database? det giver ikke rigtig mening..
//
////                ResultSet idResultset = ps.getGeneratedKeys();
////                if (idResultset.next()) {
////                    newId = idResultset.getInt(1);
////                    subscription.setSubscriptionId(newId);
////                } else {
////                    subscription= null;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//
//    }
}



