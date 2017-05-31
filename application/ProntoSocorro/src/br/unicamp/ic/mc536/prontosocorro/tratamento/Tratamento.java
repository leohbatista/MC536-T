/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicamp.ic.mc536.prontosocorro.tratamento;
 
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import br.unicamp.ic.mc536.prontosocorro.Database;
import java.sql.ResultSet;

/**
 *
 * @author Administrador
 */
public class Tratamento {
    
   private int medicamento;
   private String doenca;
   private String descricao;
   
    private Database d;

    public Tratamento(int medicamento, String doenca, String descricao) {
        this.medicamento = medicamento;
        this.doenca = doenca;
        this.descricao = descricao;
        d = new Database();
        d.conecta();   
    }

    public boolean novo() {               
        String query;        
        query = "INSERT INTO tratamento (medicamento, doenca, descricao) VALUES ("
                + this.medicamento + ",'" + this.doenca + "','" + this.descricao + "');";      
        
        return d.insere(query);
    }
    
    

    public static ResultSet consultar(String valor,short campo) {
        String query;
        switch(campo){
            case 1:     // O filtro é a medicamento
                query = "SELECT * FROM tratamento WHERE medicamento =" + valor + ";";
                break;
            case 2:     // O filtro é a doenca
                query = "SELECT * FROM tratamento WHERE paciente LIKE ='"+ valor +"'%;";
                break;
            default: 
                query = "SELECT * FROM tratamento;";
                break;
        }
            
        Database d = new Database();
        d.conecta();
        return d.consulta(query);
    }    
    
    
    

}

