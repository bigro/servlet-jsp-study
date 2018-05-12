package book.dao;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;

public class DAO {
    static DataSource dataSource;
    
    public Connection getConnection() throws Exception {
        if(dataSource==null) {
            InitialContext initialContext = new InitialContext();
            dataSource = (DataSource) initialContext.lookup("java:/comp/env/jdbc/book");
        }
        
        return dataSource.getConnection();
    }
}
