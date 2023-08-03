import config.StateMent;
import object.Person;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

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
        System.out.println("id: " + person.id + " -> name: " + person.name);
    }

    @Test
    public void testNameByAddress() throws SQLException {
        List<Person> persons = getPersonForAddress("Kyiv");
        for (Person l : persons) {
            System.out.print(l.address);
            System.out.println(" -> name: " + l.name);
        }
    }

    @Test
    public void test1() throws SQLException {
        stateMent.checkNameByAddress();
//        HashSet<String> addr = new HashSet<>();
//        for (Map<String, String> row : stateMent.getRows()) {
//            addr.add(row.get("address"));
//        }
//        System.out.println(addr);
//        for (String l : addr) {
//            System.out.print(l + " -> name: ");
//            List<Person> persons = getPersonForAddress(l);
//            List<String> names = new ArrayList<>();
//            for (Person ll : persons) {
//                names.add(ll.name);
//            }
//            System.out.println(names);
//        }
    }
}
