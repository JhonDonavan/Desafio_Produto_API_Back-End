package com.desafioapi;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;

import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.jdbi.v3.core.Jdbi;

import com.desafioapi.dao.ProdutoDao;
import com.desafioapi.resources.ProdutoResource;
import com.desafioapi.services.ProdutoServiceImpl;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class ProdutoAPIApplication extends Application<ProdutoAPIConfiguration> {

	public static void main(final String[] args) throws Exception {
		new ProdutoAPIApplication().run(args);
	}

	@Override
	public String getName() {
		return "ProdutoAPI";
	}

	@Override
	public void initialize(final Bootstrap<ProdutoAPIConfiguration> bootstrap) {
		bootstrap.addBundle(new MigrationsBundle<ProdutoAPIConfiguration>() {
			@Override
			public DataSourceFactory getDataSourceFactory(ProdutoAPIConfiguration configuration) {
				return configuration.getDataSourceFactory();
			}
		});
	}

	@Override
	public void run(final ProdutoAPIConfiguration configuration, final Environment environment) {

		final JdbiFactory factory = new JdbiFactory();
		final Jdbi jdbi = factory.build(environment, configuration.getDataSourceFactory(), "mysql");
		final ProdutoDao produtoDao = jdbi.onDemand(ProdutoDao.class);

		ProdutoServiceImpl produtoService = new ProdutoServiceImpl(produtoDao);
		// register endpoints
		ProdutoResource produtoResource = new ProdutoResource(produtoService);
		environment.jersey().register(produtoResource);
		environment.jersey().register(produtoDao);
		
		
		
		
		//CORS
		final FilterRegistration.Dynamic cors = environment.servlets().addFilter("CORS", CrossOriginFilter.class);

		cors.setInitParameter("allowedOrigins", "*");
		cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
		cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");

		// Add URL mapping
		cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
	}

}
