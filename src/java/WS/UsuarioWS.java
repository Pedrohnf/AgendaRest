/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import Dao.UsuarioDao;
import Modelo.Usuario;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
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
@Path("usuario")
public class UsuarioWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UsuarioWS
     */
    public UsuarioWS() {
    }

    /**
     * Retrieves representation of an instance of WS.UsuarioWS
     * @return an instance of java.lang.String
     */
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Usuario/listar/{id}")
    public String listUsuario(@PathParam("id")int id) throws ClassNotFoundException, SQLException {
        //TODO return proper representation object
       List<Usuario> listaUsuarios;
       UsuarioDao dao = new UsuarioDao();
       listaUsuarios = dao.listarUsuarios(id);
       
       Gson g = new Gson();
         
       return g.toJson(listaUsuarios);
    }
    /**
     * PUT method for updating or creating an instance of UsuarioWS
     * @param content representation for the resource
     */
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("Usuario/inserir")
    public boolean inserir(String content) throws ClassNotFoundException, SQLException{
        Gson g = new Gson();
        UsuarioDao dao = new UsuarioDao();
        Usuario u = (Usuario) g.fromJson(content, Usuario.class);
        return dao.inserir(u);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
