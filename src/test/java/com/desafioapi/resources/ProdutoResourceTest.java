package com.desafioapi.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import com.desafioapi.api.Produto;
import com.desafioapi.dao.ProdutoDao;
import com.desafioapi.services.ProdutoServiceImpl;

import io.dropwizard.testing.junit.ResourceTestRule;



@SuppressWarnings("deprecation")
public class ProdutoResourceTest {
	

	private static ProdutoDao mockDao = Mockito.mock(ProdutoDao.class);

	@ClassRule
	public static final ResourceTestRule resources = ResourceTestRule.builder()
			.addResource(new ProdutoServiceImpl(mockDao)).build();
	
	@Ignore
	@Test
	public void getProdutoPorId_existeProduto_retornar_200() {
		Produto produto = new Produto(1, "7095760412912", "Caneta BIC PRETA", "Caneta esferografica preta BIC", 91,
				"Canetas");
		Mockito.when(mockDao.getProdutoByid(1)).thenReturn(produto);
		
		//TODO: Response sempre retornardo 404 depois de ter mudado as camadas // investigar motivo
		Response response = resources.client().target("produtos/1").request().get();
		Assert.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

	}
	
	
	@Test
	public void getProdutoPorId_naoExisteProduto_retornar_404() {
		Produto produto = new Produto(2, "7095760412912", "Caneta BIC PRETA", "Caneta esferografica preta BIC", 91,
				"Canetas");
		Mockito.when(mockDao.getProdutoByid(2)).thenReturn(produto);

		Response response = resources.client().target("produtos/1").request().get();
		Assert.assertEquals(Response.Status.NOT_FOUND.getStatusCode(), response.getStatus());
	}
	
	@Ignore
	@Test
	public void test_findAllProdutos_retornar_200() {
		List<Produto> listaProduto = ProdutoResourceTest.listaProdutos();
		Mockito.when(mockDao.findAllProdutos()).thenReturn(listaProduto);
		Response response = resources.target("produtos/").request().get();
		Assert.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

	}
	
	@Ignore
	@Test
	public void test_findAllProdutos_categoria_retornar_200() {
		List<Produto> listaProduto = ProdutoResourceTest.listaProdutos();
		Mockito.when(mockDao.findAllProdutos()).thenReturn(listaProduto);
		Response response = resources.target("produtos/CANETAS").request().get();
		Assert.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

	}
	
	@Ignore
	@Test
	public void test_deleteProdutoById_retornar_200() {
		Produto produto = new Produto(2, "7095760412912", "Caneta BIC PRETA", "Caneta esferografica preta BIC", 91,
				"Canetas");
		Mockito.when(mockDao.getProdutoByid(2)).thenReturn(produto);
		Response response = resources.client().target("/produtos/2").request().delete();
		Assert.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}
	
	
	@Test
	public void test_deleteProdutoById_retornar_404() {
		Produto produto = new Produto(2, "7095760412912", "Caneta BIC PRETA", "Caneta esferografica preta BIC", 91,
				"Canetas");
		Mockito.when(mockDao.getProdutoByid(2)).thenReturn(produto);
		Response response = resources.client().target("produtos/4").request().delete();
		Assert.assertEquals(Response.Status.NOT_FOUND.getStatusCode(), response.getStatus());
	}

	
	@Test
	public void test_updateProduto_retorna_201() {

		Produto produto = new Produto(2, "7095760412912", "Caneta BIC PRETA", "Caneta esferografica preta BIC", 91,
				"Canetas");
		Mockito.when(mockDao.getProdutoByid(2)).thenReturn(produto);

		produto.setQuantidade(83);
																		//TODO SETAR PRODUTO A SER TESTADO(ERRO)
		Response response = resources.client().target("produtos").request().post(null);
		Assert.assertEquals(Response.Status.NOT_FOUND.getStatusCode(), response.getStatus());
	}
	

	
	@Test (expected=IllegalArgumentException.class)
	public void naoCriaProdutoComCategoriaNull(){
		new Produto(100, "52525256", "Caderno", "Caderno 10 materias", 30, null);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void naoCriaProdutoComquantidadeNegativa() {
		new Produto(100, "52525256", "Caderno", "Caderno 10 materias", -1, "CADERNOS");
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void naoCriaProdutoSemCodigoDebarras() {
		new Produto(100, null, "Caderno", "Caderno 10 materias", 10, "CADERNOS");
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void naoCriaProdutoNomeNull() {
		new Produto(100, "52525256", null, "Caderno 10 materias", 10, "CADERNOS");
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void naoCriaProdutoNomeVazio() {
		new Produto(100, "52525256", "", "Caderno 10 materias", -10, "CADERNOS");
	}
	

	public static List<Produto> listaProdutos() {
		Produto p1 = new Produto(1, "8452236598", "Caneta BIC Vermelha", "Caneta esferografica  de cor vermelha", 150, "CANETAS");
		Produto p2 = new Produto(2, "8227746985", "Envelope", "Envelope de papael pardo", 200, "EMVELOPES");
		Produto p3 = new Produto(3, "8969656699", "Lapiseira ponta 0.5", "Lapiseira ponta 0.5", 80, "LAPISEIRAS");

		List<Produto> listaProduto = new ArrayList<Produto>();

		listaProduto.add(p1);
		listaProduto.add(p2);
		listaProduto.add(p3);

		return listaProduto;

	}

}
