package javaProject.recipedia;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import static com.jayway.jsonpath.internal.path.PathCompiler.fail;

public class JDBCTest {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testConnection() {

        try(Connection con =
                    DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/recipedia?serverTimezone=Asia/Seoul",
                            "root",
                            "123456")){
            System.out.println(con);
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }
}
