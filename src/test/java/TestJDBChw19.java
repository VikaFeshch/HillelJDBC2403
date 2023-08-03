import config.StateMent;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;

public class TestJDBChw19 {
    static StateMent stateMent;
    @BeforeClass
    public static void bb() {
        stateMent = new StateMent();
    }
    @Test
    public void test1() throws SQLException {
        stateMent.nameById();
    }
    @Test
    public void test2() throws SQLException {
        stateMent.checkNameByAddress();
    }
}
