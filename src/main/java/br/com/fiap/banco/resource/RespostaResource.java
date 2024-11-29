package br.com.fiap.banco.resource;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.banco.exception.BadInfoException;
import br.com.fiap.banco.exception.IdNotFoundException;
import br.com.fiap.banco.model.Resposta;
import br.com.fiap.banco.service.RespostaService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;

@Path("/resposta") // http://localhost:8080/07-WebApi/api/resposta
public class RespostaResource {

    private RespostaService service;
/*
    public RespostaResource() throws ClassNotFoundException, SQLException {
        service = new RespostaService();
    }

    // POST http://localhost:8080/07-WebApi/api/resposta/ (Resposta das questões)
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrar(Resposta resposta, @Context UriInfo uri)
            throws ClassNotFoundException, SQLException {
        try {
            service.cadastrar(resposta);
            // Recupera o path (URL atual(http://localhost:8080/07-WebApi/api/resposta/))
            UriBuilder uriBuilder = uri.getAbsolutePathBuilder();
            // Adiciona o ID da resposta criada na URL
            //uriBuilder.path(String.valueOf(resposta.getCodigoQuestionarioResposta()));
            //uriBuilder.path(String.valueOf(resposta.getQuestaoUmResposta()));
            uriBuilder.path((resposta.getQuestaoUmResposta()));
            
            // Retornar o status 201 com a URL para acessar o questionario criado
            return Response.created(uriBuilder.build()).build();
        } catch (BadInfoException e) {
            e.printStackTrace();
            // Retornar o status 400 bad request
            return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    // GET http://localhost:8080/07-WebApi/api/resposta (Lista de respostas)
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Resposta> lista() throws ClassNotFoundException, SQLException {
        return service.listar();
    }

    // DELETE http://localhost:8080/07-WebApi/api/resposta/{id} (Apagar uma resposta)
    @DELETE
    @Path("/{id}")
    public Response remover(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
        try {
            service.remover(id);
            return Response.noContent().build();
        } catch (IdNotFoundException e) {
        	return Response.status(Status.NOT_FOUND).build();
            //return Response.status(Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    // PUT http://localhost:8080/07-WebApi/api/resposta/{id} (Atualizar uma resposta)
    @PUT
    @Path("/{questaoUmResposta}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizar(Resposta resposta, @PathParam("questaoUmResposta") String questaoUmResposta)
    		throws ClassNotFoundException, SQLException {
		try {
			service.atualizar(resposta);
			return Response.ok().build();
		} catch (IdNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		} catch (BadInfoException e) {
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}

*/
}



/*package br.com.fiap.banco.resource;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.banco.exception.BadInfoException;
import br.com.fiap.banco.exception.IdNotFoundException;
import br.com.fiap.banco.model.Resposta;
import br.com.fiap.banco.service.RespostaService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;

@Path("/resposta") // http://localhost:8080/07-WebApi/api/resposta
public class RespostaResource {

	private RespostaService service;

	public RespostaResource() throws ClassNotFoundException, SQLException {
		service = new RespostaService();
	}

	// POST http://localhost:8080/07-WebApi/api/resposta/ (Resposta das questões)
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Resposta resposta, @Context UriInfo uri)
			throws ClassNotFoundException, SQLException {
		try {
			service.cadastrar(resposta);
			// Recupera o path (URL atual(http://localhost:8080/07-WebApi/api/resposta/))
			UriBuilder uriBuilder = uri.getAbsolutePathBuilder();
			// Adiciona o nome do pesquisador que foi criado na URL
			// uriBuilder.path(String.valueOf(pesquisador.getNome()));
			uriBuilder.path((resposta.getQuestaoUmResposta()));
			
			// Retornar o status 201 com a URL para acessar o questionario criado
			return Response.created(uriBuilder.build()).build();
		} catch (BadInfoException e) {
			e.printStackTrace();
			// Retornar o status 400 bad request
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}

	// pesquisadores)
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Resposta> lista() throws ClassNotFoundException, SQLException {
		return service.listar();
	}

	

	// DELETE http://localhost:8080/07-WebApi/api/resposta/Rafael (Apagar um produto)
	@DELETE
	@Path("/{id}")
	public Response remover(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
		try {
			service.remover(id);
			return Response.noContent().build();
		} catch (IdNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	// PUT http://localhost:8080/07-WebApi/api/resposta/...(Atualizar um questionario)
	@PUT
	@Path("/{questaoUmResposta}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Resposta resposta, @PathParam("questaoUmResposta") String questaoUmResposta)
			throws ClassNotFoundException, SQLException {
		try {
			service.atualizar(resposta);
			return Response.ok().build();
		} catch (IdNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		} catch (BadInfoException e) {
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}
}

*/