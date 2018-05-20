package Dao;

import Modelo.Contato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContatoDao {

    private PreparedStatement pst;
    private ResultSet rs;
    private Connection con;
    private String sql;

    public List<Contato> listarContatos(int id) throws ClassNotFoundException, SQLException {
        List<Contato> contatos = new ArrayList<>();

        Contato c = null;

        sql = "SELECT * FROM contato WEHRE id = ?;";
        con = Conexao.cb();
        pst = con.prepareStatement(sql);
        pst.setInt(1, id);
        rs = pst.executeQuery();

        while (rs.next()) {
            c = new Contato();
            c.setId(rs.getInt("id"));
            c.setNome(rs.getString("nome"));
            c.setTelefones((List<Contato>) rs.getObject("telefone"));
            contatos.add(c);
        }
        Conexao.db();
        return contatos;

    }

    public boolean inserirContatos(Contato c) {

        try {
            sql = "INSERT INTO contato (nome,telefone) VALUES (?,?);";
            con = Conexao.cb();
            pst = con.prepareStatement(sql);

            pst.setString(1, c.getNome());
            pst.setObject(2, c.getTelefones());
            pst.execute();
            Conexao.db();

            return true;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean deletarContato(int id) {
        try {
            sql = "DELETE * FROM contato WHERE id = ?;";
            con = Conexao.cb();
            pst = con.prepareStatement(sql);

            pst.setInt(1, id);
            pst.execute();
            Conexao.db();

            return true;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean AtualizarContatos(Contato c) {

        try {
            sql = "UPDATE contato SET nome = ?, cpf= ? WHERE id = ?;";
            con = Conexao.cb();
            pst = con.prepareStatement(sql);

            pst.setString(1, c.getNome());
            pst.setObject(2, c.getTelefones());
            pst.setInt(3, c.getId());
            pst.executeUpdate();
            Conexao.db();

            return true;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
