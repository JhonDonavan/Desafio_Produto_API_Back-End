package com.desafioapi.resources;

import com.desafioapi.api.Produto;
import com.desafioapi.services.ProdutoService;
import com.desafioapi.util.ResultValidacaoProduto;
import com.desafioapi.util.ValidadorProduto;
import io.dropwizard.validation.Validated;


import java.util.List;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

@Path("/produtos")
@Produces(MediaType.APPLICATION_JSON)
public class ProdutoResource {

	@Inject
	Produto produto;
	
	@Inject
	ProdutoService produtoService;

	public ProdutoResource(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	@GET
	public Response index() {
			List<Produto> allProducts = produtoService.findAllProdutos();
			return Response.ok(allProducts).build();
	}

	@GET
	@Path("{id}")
	public Response show(@PathParam("id") Long id) {
		this.produto = produtoService.findById(id);
		return Response.ok(produto).build();
	}
	
	@GET
	@Path("categoria/{categoria}")
	public Response getByCategoria(@PathParam("categoria") String nameCategoria) {
		List<Produto> allProducts = produtoService.findAllByCategoria(nameCategoria);
		return Response.ok(allProducts).build();
	}
	
	@GET
	@Path("nome/{nome}")
	public Response getByName(String name) {
		List<Produto> allProducts = produtoService.findAllByName(name);
		return Response.ok(allProducts).build();
	}

	@POST
	public Response create(@NotNull @Validated Produto produto) {
		validarProduto(produto);
		produtoService.createProduto(produto);
		return Response.created(null).build();
	}

	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") int id) {
		produtoService.deleteProduto(id);
		return Response.noContent().build();
	}

	@PUT
	public Response update(Produto produto) {
		validarProduto(produto);
		produtoService.updateProduto(produto);
		return Response.ok().build();
	}
	

	@SuppressWarnings("static-access")
	public static void validarProduto(Produto produto) {
		ValidadorProduto validador = null;
		System.out.println("Validados 1");
		ResultValidacaoProduto result = null;

		result = validador.validarProduto(produto);

		if (result.getErro() == true) {
			throw new WebApplicationException(result.getMsg().toString(), Response.Status.BAD_REQUEST);
		}
	}

}
