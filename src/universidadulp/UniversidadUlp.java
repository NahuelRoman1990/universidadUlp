/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadulp;

import accesoAdatos.Conexion;
import java.sql.Connection;

/**
 *
 * @author roman
 */
public class UniversidadUlp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connection con=Conexion.getConnection();
    }
    
}
