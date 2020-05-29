package execute;

import connection.DBConnection;

import java.io.*;
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
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                Statement st = connection.createStatement();
                int rs = st.executeUpdate(line);
                st.close();
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(connection!=null){
                connection.close();
            }
        }
    }
}
