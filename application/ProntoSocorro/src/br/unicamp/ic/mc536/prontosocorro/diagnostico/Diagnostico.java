
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
        query = "INSERT INTO medicamento (medico, paciente, data, hora, doenca) VALUES ("
                + this.CRM + ",'" + this.CPF + "','" + this.data + "','" + this.hora + "','" + this.doenca +"');";      
        
        return d.insere(query);
    }
    
    

    public static ResultSet consultar(String valor1, String valor2 ,short campo) {
        String query;
        switch(campo){
            case 1:     // O filtro é a doenca
                query = "SELECT * FROM diagnostico WHERE doenca LIKE '" + valor1 + "%';";
                break;
            case 2:     // O filtro é o medico e paciente
                query = "SELECT * FROM diagnostico WHERE paciente='" + valor1 + "'"
                        + " AND medico=" + valor2 + ";";
                break;
            default: 
                query = "SELECT * FROM diagnostico;";
                break;
        }
            
        Database d = new Database();
        d.conecta();
        return d.consulta(query);
    }    
    
    
    

}



