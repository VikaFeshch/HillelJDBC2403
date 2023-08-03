package config;

import object.Person;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import static work.SQuery.getPersonForAddress;
import static work.SQuery.getPersonForId;

public class StateMent {
    public static Statement getStateMent() {
        return stateMent;
    }

    private static Statement stateMent;

    public StateMent() {
        try {
            makeStat();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Statement makeStat() throws SQLException {
        Connect c = null;
        c = new Connect();
        Connection con = c.newConnection();
        stateMent = con.createStatement();
        return stateMent;
    }


    public void selectAll() throws SQLException {
        ResultSet resultSet = stateMent.executeQuery("SELECT * FROM sys.hillel2403;");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("id") + " " + resultSet.getString("name") + " " + resultSet.getString("address"));
        }
    }

    public List<Map<String, String>> getRows() throws SQLException {
        ResultSet resultSet = stateMent.executeQuery("SELECT * FROM sys.hillel2403;");
        List<Map<String, String>> list = new ArrayList<>();
        while (resultSet.next()) {
            Map<String, String> map = new HashMap<>();
            map.put("id", resultSet.getString("id"));
            map.put("name", resultSet.getString("name"));
            map.put("address", resultSet.getString("address"));
            list.add(map);
        }
        return list;
    }

    public void nameById() throws SQLException {
        Person person = getPersonForId(2);
        System.out.println("id: " + person.id + " -> name: " + person.name);
    }

    public void checkNameByAddress() throws SQLException {
        HashSet<String> addr = new HashSet<>();
        for (Map<String, String> row : getRows()) {
            addr.add(row.get("address"));
        }
        for (String l : addr) {
            System.out.print(l + " -> name: ");
            List<Person> persons = getPersonForAddress(l);
            List<String> names = new ArrayList<>();
            for (Person ll : persons) {
                names.add(ll.name);
            }
            System.out.println(names);
        }
    }
}
