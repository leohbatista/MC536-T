/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicamp.ic.mc536.prontosocorro.prescricao;


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
public class Prescricao {
    
   private int CRM;
   private String CPF;
   private Date data;
   private Time hora;
   private int medicamento;
   private String posologia;
   
    private Database d;

    public Prescricao(int CRM, String CPF, Date data, Time hora, int medicamento, String posologia) {
        this.CRM = CRM;
        this.CPF = CPF;
        this.data = data;
        this.medicamento = medicamento;
        this.posologia = posologia;
        d = new Database();
        d.conecta();   
    }

    public boolean novo() {               
        String query;        
        query = "INSERT INTO medicamento (medico, paciente, data, hora) VALUES ("
                + this.CRM + ",'" + this.CPF + "','" + this.data + "','" + this.hora + "','" + this.doenca + "','" + this.medicamento +"','" + this.posologia +"');";      
        
        return d.insere(query);
    }
    
    

    public static ResultSet consultar(String valor1, String valor2 ,short campo) {
        String query;
        switch(campo){
            case 1:     // O filtro é a medicamento
                query = "SELECT * FROM prescricao WHERE medicamento LIKE '" + valor1 + "%';";
                break;
            case 2:     // O filtro é o medico e paciente
                query = "SELECT * FROM prescricao WHERE paciente ='" + valor1 + "' AND medico=" + valor2 + ";";
                break;
            default: 
                query = "SELECT * FROM prescricao;";
                break;
        }
            
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

    public int getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(int medicamento) {
        this.medicamento = medicamento;
    }

    public String getPosologia() {
        return posologia;
    }

    public void setPosologia(String posologia) {
        this.posologia = posologia;
    }
    
    
    

}




