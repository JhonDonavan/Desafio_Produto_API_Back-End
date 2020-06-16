package com.desafioapi.db;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;

import org.junit.Ignore;
import org.junit.Test;

import io.dropwizard.configuration.YamlConfigurationFactory;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jackson.Jackson;
import io.dropwizard.jersey.validation.Validators;
import io.dropwizard.util.Resources;

public class DataSourceConfigurationTest {
	
	//TODO: teste de configuração config.yml
	//TODO: teste reclama que DriveClass e Url não pode ser vazio. //investigando motivo
	
	@Ignore
	@Test
	public void fullTestConfigurationConfigYml() throws Exception {
		DataSourceFactory ds = getDataSourceFactory("testConfig.yml");
		assertThat(ds.getDriverClass()).isEqualTo("com.mysql.jdbc.Driver");
		assertThat(ds.getUser()).isEqualTo("root");
		assertThat(ds.getUrl())
				.isEqualTo("jdbc:mysql://localhost:3306/ProdutoAPI?useTimezone=true&serverTimezone=UTC&useSSL=false");
		assertThat(ds.getPassword()).isEqualTo("mysql");
	}

	private DataSourceFactory getDataSourceFactory(String resourceName) throws Exception {
		return new YamlConfigurationFactory<>(DataSourceFactory.class, Validators.newValidator(),
				Jackson.newObjectMapper(), "ds").build(new File(Resources.getResource(resourceName).toURI()));
	}

}
