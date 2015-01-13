package org.easy.testeasy.dataloader;

import org.easy.testeasy.dataloader.HibernateDataLoader;
import org.easy.testeasy.domain.UF;

/**
 * Bean DataLoader para execução de testes unitários. Insere um
 * objeto {@link UF} com sigla "dd".
 * @author augusto
 *
 */
public class UF_dd_DataLoader extends HibernateDataLoader {

	@Override
	public void load() throws Exception {
		UF uf = new UF("dd");
		getEntityManager().persist(uf);
		getEntityManager().flush();
	}

}