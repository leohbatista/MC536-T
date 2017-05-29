/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicamp.ic.mc536.prontosocorro.laboratorio;

import br.unicamp.ic.mc536.prontosocorro.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;

/**
 *
 * @author filipe
 */
public class Laboratorio {
    private int nRegistro;
    private String nome;
    private String telefone;
    private String tipo;
    private String responsavel;
    private Database d;
    
    public Laboratorio(String nome, String telefone, String tipo, String responsavel) {
        Random randomGenerator = new Random();
        this.nRegistro = randomGenerator.nextInt(100);
        this.nome = nome;
        this.telefone = telefone;
        this.tipo = tipo;
        this.responsavel = responsavel;
        d = new Database();
        d.conecta();
    }
    
    public boolean novo() {               
        String query;        
        query = "INSERT INTO laboratorio (nregistro, nome, telefone, tipo, responsavel) VALUES ("
                + this.nRegistro + ",'" + this.nome + "','" + this.telefone + "','" + this.tipo
                + "','" + this.responsavel + "');";      
        
        return d.insere(query);
    }
    
    public boolean alterar() {
        String query;       
        query = "UPDATE paciente SET "
                + "nRegistro='" + this.nRegistro + "',"
                + "nome='" + this.nome + "',"
                + "telefone='" + this.telefone + "',"
                + "tipo='" + this.tipo + "',"
                + "reponsavel='" + this.responsavel + "';";
     
        return d.atualiza(query); 
    }  
    
    public boolean excluir() {
        String query;       
        query = "DELETE FROM paciente WHERE nRegistro='" + this.nRegistro + "';";               
     
        return d.remove(query); 
    }
    
    public static ResultSet consultar(String valor, short campo) {
        String query;
        switch(campo){
            case 1:     // o filtro é o nRegistro
                query= "SELECT * FROM laboratorio WHERE nRegistro LIKE '" + valor + "%';";
                break;
            case 2:     // O filtro é o campo Nome
                query= "SELECT * FROM laboratorio WHERE nome LIKE '" + valor + "%';";
                break;
            case 3:     // O filtro é o campo Tipo
                query= "SELECT * FROM laboratorio WHERE tipo LIKE '" + valor + "%';";
                break;

            default: 
                query = "SELECT * FROM laboratorio;";
                break;
        }
            
        Database d = new Database();
        d.conecta();
        return d.consulta(query);
    }
    
}
