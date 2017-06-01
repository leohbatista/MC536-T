package br.unicamp.ic.mc536.prontosocorro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Database
{
    Connection con;
    //public boolean conecta(String local, String banco, String usuario, String senha) {
    public boolean conecta() {    
        boolean retorno = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
                //con = DriverManager.getConnection("jdbc:mysql://" + local + "/" + banco, usuario, senha);
                //con = DriverManager.getConnection("jdbc:mysql://143.106.241.1/3infd16","3infd16","3infd16");
                //con = DriverManager.getConnection("jdbc:mysql://localhost/pronto_socorro","root","farol");
                //con = DriverManager.getConnection("jdbc:mysql://localhost/pronto_socorro","root","plmstms14");
                con = DriverManager.getConnection("jdbc:mysql://localhost/pronto_socorro","root","123456");
                retorno = true;
            }
            catch(ClassNotFoundException | SQLException e)
            {
                System.err.println("Erro de conexão:\n" + e);
            }
            return retorno;
    }
    
    public boolean insere(String insere)
    {
        boolean retorno = false;
        try {
            try (PreparedStatement stmt = (PreparedStatement) this.con.prepareStatement(insere)) {
                stmt.execute();
            }
            retorno = true;
        } catch (SQLException ex) {
            System.err.println("Erro INSERT: " + ex);
        }
        return retorno;
    }
    
    public ResultSet consulta(String consulta) {
        ResultSet rs = null;
        try {
            PreparedStatement stmt = (PreparedStatement) this.con.prepareStatement(consulta);
            rs = stmt.executeQuery();
        } catch(SQLException e) {
            System.err.println("Erro CONSULTA: " + e);
        }
        return rs;
    }
    
    public boolean atualiza(String atualiza)
    {
        boolean retorno = false;
        try {
            try (PreparedStatement stmt = (PreparedStatement) this.con.prepareStatement(atualiza)) {
                stmt.execute();
            }
            retorno = true;
        } catch (SQLException ex) {
            System.err.println("Erro UPDATE: " + ex);
        }
        return retorno;
    }
    
    public boolean remove(String exclusao)
    {
        boolean retorno = false;
        try {
            try (PreparedStatement stmt = (PreparedStatement) this.con.prepareStatement(exclusao)) {
                stmt.execute();
            }
            retorno = true;
        } catch (SQLException ex) {
            System.err.println("Erro DELETE: " + ex);
        }
        return retorno;
    }
}