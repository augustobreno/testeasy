package org.easy.testeasy;

import javax.inject.Inject;
import javax.persistence.EntityManager;

//import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.junit.runner.RunWith;

/**
 * Classe base para testes realizados no servidor de aplicação.
 * Suas principais atividades são: Ativar o Arquillian; Configurar o arquivo para
 * deploy dos testes no servidores de aplicação; Gerenciar a transação via Arquillian (realiza
 * rollback por padrão) 
 * @author Augusto
 *
 */
//@RunWith(Arquillian.class)
@Transactional(value=TransactionMode.ROLLBACK)
public class DeployableBaseTest extends TestBase {

	/**
	 * EM para acesso direto à base
	 */
	@Inject
	private EntityManager em;

	
	/**
     * Provoca uma pausa na execução da thread corrente.
     * @param time Tempo em ms de pausa. 
     */
    protected void sleep(int time) {
    	try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			throw new RuntimeException("Não foi possível fazer a thread dormir.", e);
		}
	}

	protected EntityManager getEm() {
		return em;
	}

	protected void setEm(EntityManager em) {
		this.em = em;
	}
}
