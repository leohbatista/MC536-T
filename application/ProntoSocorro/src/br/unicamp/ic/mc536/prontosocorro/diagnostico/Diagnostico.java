
package br.unicamp.ic.mc536.prontosocorro.diagnostico;

import br.unicamp.ic.mc536.prontosocorro.Database;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;

/**
 *
 * @author Administrador
 */
public class Diagnostico {
    
   private int CRM;
   private String CPF;
   private Date data;
   private Time hora;
   private String doenca;
   
    private Database d;

    public Diagnostico(int CRM, String CPF, Date data, Time hora, String doenca) {
        this.CRM = CRM;
        this.CPF = CPF;
        this.data = data;
        this.hora = hora;
        this.doenca = doenca;
        d = new Database();
        d.conecta();   
    }

    public boolean novo() {               
        String query;        
        query = "INSERT INTO diagnostico (medico, paciente, data, hora, doenca) VALUES ("
                + this.CRM + ",'" + this.CPF + "','" + this.data + "','" + this.hora + "','" + this.doenca +"');";      
        
        return d.insere(query);
    }
    
    

    public static ResultSet consultar(String doenca) {
        String query = "SELECT * FROM diagnostico WHERE doenca LIKE '" + doenca + "%';";
                           
        Database d = new Database();
        d.conecta();
        return d.consulta(query);
    }    
    
    public static ResultSet consultar() {
        String query = "SELECT * FROM diagnostico;";
                
        Database d = new Database();
        d.conecta();
        return d.consulta(query);             
    }

    public static ResultSet consultar(String medico, String paciente, Date data, Time hora) {
        String query;
        query = "SELECT * FROM diagnostico WHERE paciente='" + paciente + "'"
                + " AND medico=" + medico + " AND data='" + data + "'" + " AND hora='" + hora + "'"
                +";";
                
        Database d = new Database();
        d.conecta();
        return d.consulta(query);
    }  
    

}



