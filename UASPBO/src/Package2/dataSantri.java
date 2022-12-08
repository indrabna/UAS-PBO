/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Package2;

import java.sql.SQLException;
import javax.swing.JOptionPane;

public class dataSantri extends Koneksi implements CRUD{
//overloading
    public static void insertdataSantri(String ns) {
        System.out.println(" berhasil di tambahkan");
    }
    // Constructor untuk Connect ke Database
    public dataSantri() throws ClassNotFoundException, SQLException {
        super();
    }

    // Create
    @Override
    public void insertdataSantri(String nama_santri, String orangtua_santri, String jumlah_hapalan ){
        try {
        String sql = String.format("INSERT INTO data_santri (nama_santri,orangtua_santri,jumlah_hapalan) VALUE ('%s', '%s','%s')", nama_santri, orangtua_santri, jumlah_hapalan);
        this.setQuery(sql);
        this.execute();  
        } catch (Exception e) {
        }

    }

    // Read
    public void getAll() throws SQLException {
        String sql = "SELECT * FROM data_santri";
        this.setQuery(sql);
        this.fetch();
    }
    
    // Update
    @Override
    public void updateSantri (String nama_santri, String orangtua_santri, String jumlah_hapalan, String id_santri){
        try {
            String sql = String.format("UPDATE data_santri SET nama_santri = '%s', orangtua_santri ='%s', jumlah_hapalan ='%s' WHERE id_santri = %s",
            nama_santri, orangtua_santri, jumlah_hapalan, id_santri);
            this.setQuery(sql);
            this.execute();
        } catch (Exception e) {
        }
        
    }

    // Delete
    @Override
    public void deleteSantri(String id_santri ) {
        try {
            String sql = String.format("DELETE FROM data_santri WHERE id_santri = '%s'", id_santri);
            this.setQuery(sql);
            this.execute();
        } catch (Exception e) {
        }
        
    }

    // Validation untuk mencegah redudansi data
    public boolean checkSantri(String nama) throws SQLException {
        getAll();
        while (this.rs.next()) {
            if (this.rs.getString("data_santri") == nama) {
                return false;
            }
        }
        return true;
    }

    // Print
    public String[][] showSantri() throws SQLException {
        String[][] data = new String[this.lenSantri()][4];
        getAll();
        this.fetch();
        int i = 0;
        while (this.rs.next()) {
            data[i][0] = this.rs.getString("id_santri");
            data[i][1] = this.rs.getString("nama_santri");
            data[i][2] = this.rs.getString("orangtua_santri");
            data[i][3] = this.rs.getString("jumlah_hapalan");
            i++;
        }
        return data;
    }
    
    public int lenSantri() throws SQLException {
        getAll();
        this.fetch();
        int i = 0;
        while (this.rs.next()) {
            i++;
        }
        return i;
    }
}


