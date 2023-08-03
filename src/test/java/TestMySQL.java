import config.StateMent;
import object.Person;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Map;

import static work.SQuery.getPersonForName;

public class TestMySQL {
    static StateMent stateMent;

    @BeforeClass
    public static void bb() {
        stateMent = new StateMent();
    }

    @Test
    public void test1() throws SQLException {
        for (Map<String, String> row : stateMent.getRows()) {
            System.out.println(row);
        }
    }

    @Test
    public void test2() throws SQLException {
        Person person = getPersonForName("Vasiliy");
        System.out.println(person.address);
    }

    @Test
    public void test3() throws SQLException {
//        Person person=getPersonForName("Vasiliy");
//        System.out.println(person.address);
//        Assert.assertNull(getPersonForName("Vasiliy").name);
        Assert.assertNotNull(getPersonForName("Vasiliy").name);
    }
}
