
package liquibasedb;

import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import static liquibasedb.ConnectionClient.getConnection;

public class Conexao {

    public Conexao() {
        database();
    }
    
    
    public static void database()  {
        Properties properties = new Properties();
        Connection connection = getConnection();
        Database database;
        try {
            database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(connection));       
            Liquibase liquibase = new Liquibase("testLiquid/insert.xml", new ClassLoaderResourceAccessor(), database);
        properties.forEach((key, value) -> liquibase.setChangeLogParameter(Objects.toString(key), value));

        liquibase.update(new Contexts(), new LabelExpression());
        } catch (DatabaseException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LiquibaseException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    
    }
}
