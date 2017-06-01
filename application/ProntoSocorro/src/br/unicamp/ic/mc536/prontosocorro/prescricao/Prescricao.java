/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicamp.ic.mc536.prontosocorro.prescricao;


import br.unicamp.ic.mc536.prontosocorro.Database;
import br.unicamp.ic.mc536.prontosocorro.medicamento.Medicamento;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;

/**
 *
 * @author Administrador
 */
public class Prescricao {
    
   private int CRM;
   private String CPF;
   private Date data;
   private Time hora;
   private Medicamento medicamento;
   private String posologia;
   
    private Database d;

    public Prescricao(int CRM, String CPF, Date data, Time hora, Medicamento medicamento, String posologia) {
        this.CRM = CRM;
        this.CPF = CPF;
        this.data = data;
        this.hora = hora;
        this.medicamento = medicamento;
        this.posologia = posologia;
        d = new Database();
        d.conecta();   
    }

    public boolean novo() {               
        String query;        
        query = "INSERT INTO prescricao (medico, paciente, data, hora, medicamento,posologia) VALUES ("
                + this.CRM + ",'" + this.CPF + "','" + this.data + "','" + this.hora + "','" + this.medicamento.getId_medicamento() +"','" + this.posologia +"');";      
        
        return d.insere(query);
    }
    
    

    public static ResultSet consultar(String medicamento) {
        String query;
        
        query = "SELECT * FROM prescricao WHERE medicamento=" + medicamento + ";";
            
        Database d = new Database();
        d.conecta();
        return d.consulta(query);
    }    
    
    public static ResultSet consultar() {
        String query = "SELECT * FROM prescricao;";
                
        Database d = new Database();
        d.conecta();
        return d.consulta(query);             
    }
    
    public static ResultSet consultar(String medico, String paciente, Date data, Time hora) {
        String query;
        query = "SELECT p.*,m.nome,m.dosagem FROM prescricao WHERE paciente='" + paciente + "'"
                + " AND medico=" + medico + " AND data='" + data + "'" + " AND hora='" + hora + "'"
                +";";
                
        Database d = new Database();
        d.conecta();
        return d.consulta(query);
    }  

    public int getCRM() {
        return CRM;
    }

    public void setCRM(int CRM) {
        this.CRM = CRM;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getPosologia() {
        return posologia;
    }

    public void setPosologia(String posologia) {
        this.posologia = posologia;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }
    
    
    

}




