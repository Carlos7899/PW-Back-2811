package br.com.fiap.banco.resource;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.banco.exception.BadInfoException;
import br.com.fiap.banco.exception.IdNotFoundException;
import br.com.fiap.banco.model.QuestionarioRespPesq;
import br.com.fiap.banco.service.QuestionarioServiceRespPesq;
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

@Path("/questionarioresppesq") // http://localhost:8080/07-WebApi/api/pesquisador
public class QuestionarioResourceRespPesq {

	private QuestionarioServiceRespPesq service;

	public QuestionarioResourceRespPesq() throws ClassNotFoundException, SQLException {
		service = new QuestionarioServiceRespPesq();
	}

	// POST http://localhost:8080/07-WebApi/api/questionario/ (Cadastrar um pesquisador)
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(QuestionarioRespPesq questionarioRespPesq, @Context UriInfo uri)
			throws ClassNotFoundException, SQLException {
		try {
			service.cadastrar(questionarioRespPesq);
			// Recupera o path (URL atual(http://localhost:8080/07-WebApi/api/questionario/))
			UriBuilder uriBuilder = uri.getAbsolutePathBuilder();
			// Adiciona o nome do pesquisador que foi criado na URL
			// uriBuilder.path(String.valueOf(pesquisador.getNome()));
			uriBuilder.path((questionarioRespPesq.getQuestaoUmRespPesq()));
			
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
	public List<QuestionarioRespPesq> lista() throws ClassNotFoundException, SQLException {
		return service.listar();
	}

	// DELETE http://localhost:8080/07-WebApi/api/questionario/Rafael (Apagar um produto)
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

	// PUT http://localhost:8080/07-WebApi/api/questionario/...(Atualizar um questionario)
	@PUT
	@Path("/{questaoUmRespPesq}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(QuestionarioRespPesq questionarioRespPesq, @PathParam("questaoUmRespPesq") String questaoUmRespPesq)
			throws ClassNotFoundException, SQLException {
		try {
			service.atualizar(questionarioRespPesq);
			return Response.ok().build();
		} catch (IdNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		} catch (BadInfoException e) {
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}
}