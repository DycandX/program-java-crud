package projectkelompok1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Global {
    public static String id;
    public static String sql;
    
    boolean isEmptyStr(String string) {
        return string == null || string.isEmpty();
    }
    
    public static int JmlRec(String sql) throws SQLException {
        int n = 0;
        Connection db = ConnectionDB.getConnection();
        try (PreparedStatement q = db.prepareStatement(sql)) {
            ResultSet rs = q.executeQuery();
            while (rs.next()) {
                n++;
            } // end while
        } // end try
        return n;
    }
} // end Class
