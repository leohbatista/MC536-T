/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicamp.ic.mc536.prontosocorro.medicamento;

import br.unicamp.ic.mc536.prontosocorro.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class Medicamento {
    
   private int id_medicamento;
   private String principio_ativo;
   private String dosagem;
   private String contra_indicacao;
   
    private Database d;

    public Medicamento(int id_medicamento, String principio_ativo, String dosagem,String contra_indicacao) {
        this.id_medicamento = id_medicamento;
        this.principio_ativo = principio_ativo;
        this.dosagem = dosagem;
        this.contra_indicacao = contra_indicacao;
        d = new Database();
        d.conecta();   
    }

    public boolean novo() {               
        String query;        
        query = "INSERT INTO medicamento (id_medicamento, principio_ativo, dosagem, contra_indicacao) VALUES ("
                + this.id_medicamento + ",'" + this.principio_ativo + "','" + this.dosagem + "','" + this.contra_indicacao + "');";      
        
        return d.insere(query);
    }
    
    

    public static ResultSet consultar(String valor, short campo) {
        String query;
        switch(campo){
            case 1:     // O filtro é o campo id_medicamento
                query= "SELECT * FROM medicamento WHERE id_medicamento = " + valor + ";";
                break;
            case 2:     // O filtro é o campo principio ativo
                query= "SELECT * FROM medicamento WHERE principio_ativo LIKE '" + valor + "%';";
                break;
            default: 
                query = "SELECT * FROM medicamento;";
                break;
        }
            
        Database d = new Database();
        d.conecta();
        return d.consulta(query);
    }    

    public int getId_medicamento() {
        return id_medicamento;
    }

    public void setId_medicamento(int id_medicamento) {
        this.id_medicamento = id_medicamento;
    }

    public String getPrincipio_ativo() {
        return principio_ativo;
    }

    public void setPrincipio_ativo(String principio_ativo) {
        this.principio_ativo = principio_ativo;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public String getContra_indicacao() {
        return contra_indicacao;
    }

    public void setContra_indicacao(String contra_indicacao) {
        this.contra_indicacao = contra_indicacao;
    }            

}



