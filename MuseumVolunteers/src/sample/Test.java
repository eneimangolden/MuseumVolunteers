package sample;

import org.junit.jupiter.api.*;
import java.sql.Connection;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class Test {

    private static Connection con;

    @BeforeAll
    static void connectToDB() {
        con = DBConnector.connect();
    }
    


}
