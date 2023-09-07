
package liquibasedb;

import liquibasedb.LiquibaseDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClient {

    private static Connection conexao;

    public static Connection getConnection() {
        if (conexao == null) {
            try {
                String url = "jdbc:postgresql://localhost:5432/liquibaseTest";
                String user = "postgres" ;
                String password = "senai";

                conexao = DriverManager.getConnection(url, user, password);
                
                System.out.println("Conectado ao banco");
            } catch (SQLException e) {
                
                e.printStackTrace();
                System.out.println("Erro");
            }

        }
        return conexao;
    }
}
