package execute;

import connection.DBConnection;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLExecutor {
    public void update(String filepath) throws SQLException {
        Connection connection = DBConnection.getConnection();
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource(filepath).getFile());
            FileReader fr = new FileReader(file, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                Statement st = connection.createStatement();
                int rs = st.executeUpdate(line);
                st.close();
                line = reader.readLine();
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(connection!=null){
                connection.close();
            }
        }
    }
    public void execute(String filepath) throws SQLException{
        Connection connection = DBConnection.getConnection();
    }
}
