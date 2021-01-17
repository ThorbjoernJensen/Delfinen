package Persistence;

import Domain.Member;
import Domain.MemberType;

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
}
