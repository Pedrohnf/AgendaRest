/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phnf2
 */
public class UsuarioDao {

    private PreparedStatement pst;
    private ResultSet rs;
    private Connection con;
    private String sql;
    
    public UsuarioDao() {
    }

    public boolean inserir(Usuario usuario) throws ClassNotFoundException {
       try{ 
        sql = "INSERT INTO usuario (nome,cpf) VALUES (?,?);";
        con = Conexao.cb();
        pst = con.prepareStatement(sql);
      
        pst.setString(1, usuario.getNome());
        pst.setString(2, usuario.getCpf());
        pst.execute();
        Conexao.db();
        
        return true;
        
        }catch(ClassNotFoundException | SQLException ex){
              Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        return false;
        }
 

    }
    
   
    public List<Usuario> listarUsuarios(int id) throws ClassNotFoundException, SQLException{
        List<Usuario> usuarios = new ArrayList<>();
        
        Usuario u = null;
        
        sql = "SELECT * FROM usuario WHERE id = ?;";
        con = Conexao.cb();
        pst = con.prepareStatement(sql);
        pst.setInt(1, id);
        rs = pst.executeQuery();
        
        while(rs.next()){
            u = new Usuario();
            u.setId(rs.getInt("id"));
            u.setNome(rs.getString("nome"));
            u.setCpf(rs.getString("cpf"));
            usuarios.add(u);
        }
        Conexao.db();
        return usuarios;
        
    } 

}
