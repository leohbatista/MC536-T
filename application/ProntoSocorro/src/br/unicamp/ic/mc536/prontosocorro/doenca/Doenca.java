/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicamp.ic.mc536.prontosocorro.doenca;

import br.unicamp.ic.mc536.prontosocorro.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author filipe
 */
public class Doenca {
    private String cid;
    private String nome;
    private Database d;
    
    public Doenca (String cid, String nome){
        this.cid = cid;
        this.nome = nome;
        d = new Database();
        d.conecta();
    }
    
    public static ResultSet consultar(String valor, short campo) {
        String query;
        switch(campo){
            case 1:     // o filtro é o cid
                query= "SELECT * FROM doenca WHERE cpf LIKE '" + valor + "%';";
                break;
            case 2:     // O filtro é o campo nome
                query= "SELECT * FROM doenca WHERE nome LIKE '" + valor + "%';";
                break;
            default: 
                query = "SELECT * FROM doenca;";
                break;
        }
            
        Database d = new Database();
        d.conecta();
        return d.consulta(query);
    }
    
    public String getCID() {
        return cid;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setCID(String cid) {
        this.cid = cid;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
