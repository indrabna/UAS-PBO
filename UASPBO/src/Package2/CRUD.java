/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Package2;
/**
 *
 * @author INDRA BUANA
 */
public interface CRUD {
    public abstract void insertdataSantri(String nama_santri, String orangtua_santri, String jumlah_hapalan ) ;
    public abstract void updateSantri (String nama_santri, String orangtua_santri, String jumlah_hapalan, String id_santri );
    public abstract void deleteSantri(String id_santri );
}
