package config;

import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StateMent {
    public static Statement getStateMent(){
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

    @Test
    public void selectAll() throws SQLException {
        ResultSet resultSet=stateMent.executeQuery("SELECT * FROM sys.hillel2403;");
        while (resultSet.next()){
            System.out.println(resultSet.getString("id")+" "+resultSet.getString("name")+" "+resultSet.getString("address"));
        }
    }
    @Test
    public List<Map<String,String>> getRows() throws SQLException {
        ResultSet resultSet=stateMent.executeQuery("SELECT * FROM sys.hillel2403;");
        List<Map<String,String>> list=new ArrayList<>();
        while(resultSet.next()){
            Map<String,String> map=new HashMap<>();
            map.put("id",resultSet.getString("id"));
            map.put("name",resultSet.getString("name"));
            map.put("address",resultSet.getString("address"));
            list.add(map);
        }
        return list;
    }
}
