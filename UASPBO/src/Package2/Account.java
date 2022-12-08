package Package2;

import java.sql.*;

public class Account extends Koneksi{
    
    public Account () throws ClassNotFoundException, SQLException{
        super();
    }
    
    public boolean auth(String username, String password) throws SQLException{
        String sql =String.format ("SELECT * FROM admin WHERE username = '%s' AND password = '%s'", username, password);
        this.setQuery(sql);
        this.fetch();
        
        while (this.rs.next()){           
            if(this.rs.getString("username") != null){
                return true;
            }
        }
        return false;
    }
    
    public boolean validation(String username){
        return true;
    }
}

