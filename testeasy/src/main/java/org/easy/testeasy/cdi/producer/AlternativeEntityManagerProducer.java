package org.easy.testeasy.cdi.producer;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;

import org.easy.testeasy.jpa.JPAStandalone;

/**
 * Producer alternativo para injeção de dependência de um EntityManager em ambiente de testes.
 * @author Augusto
 */
@Alternative
public class AlternativeEntityManagerProducer {

	/**
	 * Retorna uma instancia de {@link EntityManager} baseado no {@link JPAStandalone} default informado.
	 * @param jpaStandalone Instância em utilização pelo teste unitário.
	 * @return {@link EntityManager} devidamente configurado e pronto para uso.
	 */
	@Produces 
    public EntityManager createEntityManager(JPAStandalone jpaStandalone) {
		jpaStandalone.startSession(); // garante um EM disponível
        return jpaStandalone.getEm();
    }
	
}
