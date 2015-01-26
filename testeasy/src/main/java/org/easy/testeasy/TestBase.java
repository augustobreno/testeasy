package org.easy.testeasy;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.List;

import org.easy.testeasy.cdi.CdiJUnitRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;

/**
 * Classe base com comportamento comum para testes unitários que utilizam um
 * contexto transacional. Gerencia o ciclo de vida do JUnit, suporta CDI.
 * 
 * @author Augusto
 * 
 */
@RunWith(CdiJUnitRunner.class)
@Ignore
public abstract class TestBase {

	/**
	 * Executado antes de cada método de teste. 
	 */
	@Before
	public void beforeEachTest() {};

	/**
	 * Executado após de cada método de teste.
	 */
	@After
	public void afterEachTest() {};

	/**
	 * Verifica se ambas as listas possuem os mesmos objetos. A ordem não é
	 * verificada.
	 */
	public void assertContentEqual(List<?> esperado, List<?> encontrado) {
		assertTrue("A lista esperada não contem todos os objetos da lista encontrada",
				esperado.containsAll(encontrado));
		assertTrue("A lista encontrada não contem todos os objetos da lista esperada",
				encontrado.containsAll(esperado));
	}

	/**
	 * Verifica se ambas as listas não possuem os mesmos objetos. A ordem não é
	 * verificada.
	 */
	public void assertContentNotEqual(List<?> esperado, List<?> encontrado) {
		boolean hqlContemQBE = esperado.containsAll(encontrado);
		boolean qbeContemHQL = encontrado.containsAll(esperado);
		assertFalse("As listas deveriam conter dados equivalentes.",
				hqlContemQBE && qbeContemHQL);
	}

	/**
	 * Verifica se a coleção é diferente de null e não vazia.
	 * 
	 * @param collection
	 *            Para validação.
	 */
	protected void assertNotEmpty(Collection<?> collection) {
		assertTrue(collection != null && !collection.isEmpty());
	}

}
