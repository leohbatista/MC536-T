/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicamp.ic.mc536.prontosocorro.exame;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import br.unicamp.ic.mc536.prontosocorro.Database;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class Exame {
    private int ID;
    private int CRM;
    private String CPF;
    private String tipo;
    private String data;
    private String hora;
    private String informacoes;
    private String laudo;
    private int laboratorio;
   
    private Database d;

    public Exame(int ID,int CRM, String CPF, String tipo,String data,String hora,String informacoes,String laudo,int laboratorio){
        this.ID = ID;
        this.CRM = CRM;
        this.CPF = CPF;
        this.tipo = tipo;
        this.data = data;
        this.hora = hora;
        this.informacoes = informacoes;
        this.laudo = laudo;
        this.laboratorio = laboratorio;
        d = new Database();
        d.conecta();   
    }

    public boolean novo() {               
        String query;        
        query = "INSERT INTO exame ( medico, paciente, tipo, data, hora, informacoes, laudo, laboratorio) VALUES ("
                 + this.CRM + ",'" + this.CPF + "','" + this.tipo + "','" + this.data +"','" + this.hora 
                        + "','" + this.informacoes + "','" + this.laudo + "','" + this.laboratorio + "');";      
        
        return d.insere(query);
    }
    
    public boolean alterar() {
        String query;       
        query = "UPDATE exame SET "
                + "tipo='" + this.CRM + "',"
                + "laudo='" + this.laudo + "'"
                + "informacoes" + this.informacoes + "'"
                + " WHERE id_exame=" + this.ID + ";";
     
        return d.atualiza(query); 
    }  
    
    public boolean excluir() {
        String query;       
        query = "DELETE FROM exame WHERE id_exame="+this.ID+";";               
     
        return d.remove(query); 
    }

    public static ResultSet consultar(String valor1,String valor2,Date data, Time hora, short campo) {
        String query;
        switch(campo){
            case 1:     // O filtro é o campo exame
                query= "SELECT * FROM exame WHERE id_exame = " + valor1 + ";";
                break;
            case 2:     // O filtro é o campo paciente
                query= "SELECT * FROM exame WHERE paciente LIKE '" + valor1 + "%';";
                break;
            case 3:     // O filtro é o medico
               query= "SELECT * FROM exame WHERE medico = " + valor1 + ";";
               break;
            case 4:
                query = "SELECT * FROM exame WHERE data='" + data + "' AND hora='" + hora + "';"; 
                break;
            case 5:
                query = "SELECT * FROM prescricao WHERE paciente='" + valor1 + "'"
                + " AND medico=" + valor2 + " AND data='" + data + "'" + " AND hora='" + hora + "'"
                +";";
            case 6:
                 query= "SELECT * FROM exame WHERE laboratorio =" + valor1 + ";";
                break;
            default: 
                query = "SELECT * FROM exame;";
                break;
        }
            
        Database d = new Database();
        d.conecta();
        return d.consulta(query);
    }    
    
    public static boolean verificaID(String ID){
        Database d = new Database();
        d.conecta();
        ResultSet rs = d.consulta("SELECT count(*) AS n FROM medico WHERE crm='" + ID +"';");
        try {
            rs.next();
            if(rs.getInt(1) > 0){
                return true;       
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Exame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public int getCRM() {
        return CRM;
    }

    public void setCRM(int CRM) {
        this.CRM = CRM;
    }

    

    
    
    public static boolean verificaExclusao(int id){
        ResultSet rs = consultar(id+"","",null,null,(short)1);
        try {
            return !rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(Exame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;       
    }
    

}

