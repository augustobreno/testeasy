package org.easy.testeasy.dataloader;

import javax.inject.Inject;

import org.easy.testeasy.LocalTransactionTestBase;
import org.easy.testeasy.dataloader.DataLoaderSQL;
import org.junit.Assert;
import org.junit.Test;


/**
 * Testes da classe {@link DataLoaderSQL}
 * @author augusto
 */
public class DataLoaderSQLTest extends LocalTransactionTestBase {

	@Inject
	private DataLoaderSQL loaderSQL;
	
	/**
	 * Tenta executar um script existente na raiz do projeto, considerando seu caminho relativo.
	 */
	@Test
	public void loadScriptTest() throws Exception {
		// garante que não há nenhuma uf com sigla "aa"
		long count = executeCountQuery("select count(uf) from UF uf where uf.sigla=?", "aa");
		Assert.assertEquals(0, count);
		
		loaderSQL.setScriptPath("dataloader/uf_aa.sql");
		loaderSQL.load();
		
		// buscando o registro para confirmação
		count = executeCountQuery("select count(uf) from UF uf where uf.sigla=?", "aa");
		Assert.assertEquals(1, count);
	}
	
}
