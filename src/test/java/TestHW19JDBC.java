import config.StateMent;
import object.Person;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static work.SQuery.*;

public class TestHW19JDBC {
    static StateMent stateMent;

    @BeforeClass
    public static void bb() {
        stateMent = new StateMent();
    }

    @Test
    public void testNameById() throws SQLException {
        Person person = getPersonForId(2);
        System.out.println(person.name);
    }

    @Test
    public void testNameByAddress() throws SQLException {
        List<Person> persons = getPersonForAddress("Kyiv");
        for (Person l : persons) {
            System.out.println(l.name);
        }
    }
}
