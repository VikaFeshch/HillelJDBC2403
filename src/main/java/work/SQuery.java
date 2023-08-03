package work;

import config.StateMent;
import object.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQuery extends StateMent {
    public static List<Person> selectObj() throws SQLException {
        ResultSet resultSet = getStateMent().executeQuery("SELECT * FROM sys.hillel2403;");
        List<Person> list = new ArrayList<>();
        while (resultSet.next()) {
            list.add(new Person(resultSet));
        }
        return list;
    }

    public static Person getPersonForName(String name) throws SQLException {
        ResultSet resultSet = getStateMent().executeQuery("SELECT * FROM sys.hillel2403 where name='" + name + "';");
        resultSet.next();
        return new Person(resultSet);
    }
    public static Person getPersonForId(int i) throws SQLException {
        ResultSet resultSet = getStateMent().executeQuery("SELECT * FROM sys.hillel2403 WHERE id ='"+ i+ "';");
        resultSet.next();
        return new Person(resultSet);
    }
    public static List<Person> getPersonForAddress(String address) throws SQLException {
        ResultSet resultSet = getStateMent().executeQuery("SELECT * FROM sys.hillel2403 WHERE address ='"+ address+ "';");
        List<Person> list = new ArrayList<>();
        while (resultSet.next()) {
            list.add(new Person(resultSet));
        }
        return list;
    }
}
