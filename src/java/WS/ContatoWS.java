/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import Dao.ContatoDao;
import Modelo.Contato;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author phnf2
 */
@Path("contato")
public class ContatoWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ContatoWS
     */
    public ContatoWS() {
    }

    /**
     * Retrieves representation of an instance of WS.ContatoWS
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Contato/listar/{id}")
    public String listUsuario(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
        //TODO return proper representation object

        List<Contato> contatos = null;
        contatos.get(1).setId(id);
        ContatoDao dao = new ContatoDao();
        contatos = dao.listarContatos(id);

        Gson g = new Gson();
        return g.toJson(contatos);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/inserir")
    public boolean inserir(String content) throws ClassNotFoundException, SQLException {
        Gson g = new Gson();
        ContatoDao dao = new ContatoDao();
        Contato u = (Contato) g.fromJson(content, Contato.class);
        return dao.inserirContatos(u);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("Contato/Atualizar/{id}")
    public boolean Atualizar(@PathParam("id") int id, String content) {
        Gson g = new Gson();
        ContatoDao dao = new ContatoDao();
        Contato c = (Contato) g.fromJson(content, Contato.class);
        return dao.AtualizarContatos(c);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Contato/Deletar/{id}")
    public String deletarContato(@PathParam("id") int id) {
        ContatoDao dao = new ContatoDao();
        if (dao.deletarContato(id)) {
            return "true";
        } else {
            return "false";
        }
    }
}
