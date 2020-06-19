package servlets;

import connection.DBConnection;
import execute.SQLExecutor;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.*;

public class IndexServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        DBConnection.checkPostgresDriver();
        SQLExecutor executor = new SQLExecutor();
        try
        {
            executor.update("sqlscripts/createTables.sql");
            init_trigger();
            executor.update("sqlscripts/ins.sql");
            init_func();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void init_trigger() throws SQLException{
        Connection connection = DBConnection.getConnection();
        String sql = "CREATE FUNCTION add_bill() RETURNS trigger AS $new_service$\n" +
                "    BEGIN\n" +
                "\t\tUPDATE bills set bill=bill+NEW.service_bill WHERE bill_number=NEW.bill_number;\n" +
                "        RETURN NEW;\n" +
                "    END;\n" +
                "$new_service$ LANGUAGE plpgsql;\n" +
                "\n" +
                "CREATE TRIGGER new_service\n" +
                "  AFTER INSERT\n" +
                "  ON added_services\n" +
                "  FOR EACH ROW\n" +
                "  EXECUTE PROCEDURE add_bill();";

        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        }catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
    private void init_func() throws SQLException{
        Connection connection = DBConnection.getConnection();
        String sql = "CREATE FUNCTION calc_bill(id_con int)\n" +
                "RETURNS decimal\n" +
                "AS $$\n" +
                "DECLARE\n" +
                "  building_min_price decimal;\n" +
                "  services_allowance decimal;\n" +
                "  food_allowance decimal;\n" +
                "  entertainments_allowance decimal;\n" +
                "  min_price decimal;\n" +
                "  result decimal;\n" +
                "BEGIN\n" +
                "  EXECUTE 'select building_min_price, services_allowance, food_allowance,entertainments_allowance, min_price  from buildings join add_services on buildings.id_add_services=add_services.id\n" +
                "\t\t\tjoin rooms on rooms.id_building=buildings.id\n" +
                "\t\t\tjoin room_types on room_types.id=rooms.id_room_types\n" +
                "\t\t\tleft join res_rooms on res_rooms.id_room=rooms.id\n" +
                "\t\t\tleft join reservations on reservations.id=res_rooms.id_reservation\n" +
                "\t\t\tleft join contracts on contracts.id_reservation=reservations.id\n" +
                "\t\t\twhere contract_number=COALESCE(@1, contract_number)'\n" +
                "         INTO building_min_price, services_allowance, food_allowance, entertainments_allowance, min_price;\n" +
                "\n" +
                "  result := building_min_price+services_allowance+food_allowance+entertainments_allowance+min_price;\n" +
                "  RETURN result;\n" +
                "\n" +
                "END;\n" +
                "$$\n" +
                "LANGUAGE plpgsql;";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        }catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
