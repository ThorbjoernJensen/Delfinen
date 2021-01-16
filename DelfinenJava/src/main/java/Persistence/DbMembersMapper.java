package Persistence;

import Domain.Subscriber;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbMembersMapper {

    Database database;

    public DbMembersMapper(Database database) {
        this.database = database;
    }

    public List<Subscriber> showAllMembers() {
        List<Subscriber> memberList = new ArrayList<>();
        String sql = "select * from medlem";
        try (Connection connection = database.connect()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int mnr= rs.getInt("mnr");
                    String fornavn = rs.getString("fornavn");
                    String efternavn = rs.getString("efternavn");
                    memberList.add(new Subscriber(mnr, fornavn, efternavn));

                }

//                    (int mnr, String fornavn, String efternavn) {
//                        this.mnr = mnr;
//                        this.fornavn = fornavn;
//                        this.efternavn = efternavn;
//


            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return memberList;


    }
}
