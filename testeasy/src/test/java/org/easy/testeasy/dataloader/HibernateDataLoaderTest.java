package org.easy.testeasy.dataloader;

import javax.inject.Inject;

import org.easy.testeasy.LocalTransactionTestBase;
import org.easy.testeasy.dataloader.HibernateDataLoader;
import org.junit.Assert;
import org.junit.Test;

/**
 * Teste para a classe {@link HibernateDataLoader}
 * @author augusto
 *
 */
public class HibernateDataLoaderTest extends LocalTransactionTestBase {

	@Inject
	private UF_aa_DataLoader ufDataLoader;
	
	@Test
	public void simpleDataLoaderTest() throws Exception {
		// garante que não há nenhuma uf com sigla "aa"
		long count = executeCountQuery("select count(uf) from UF uf where uf.sigla=?", "aa");
		Assert.assertEquals(0, count);
		
		ufDataLoader.load();
		
		// buscando o registro para confirmação
		count = executeCountQuery("select count(uf) from UF uf where uf.sigla=?", "aa");
		Assert.assertEquals(1, count);		
	}
}
