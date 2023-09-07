package liquibasedb;

import io.github.cdimascio.dotenv.Dotenv;
import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import liquibase.Contexts;
import liquibase.LabelExpression;
import static liquibasedb.ConnectionClient.getConnection;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import  liquibasedb.Conexao;

public class LiquibaseDB {

    public static Dotenv dotenv = Dotenv.load();

    public static void main(String[] args) {

    
            new Conexao();

    }

}
