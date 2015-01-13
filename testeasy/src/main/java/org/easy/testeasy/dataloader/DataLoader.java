package org.easy.testeasy.dataloader;

/**
 * Representa uma estratégia para implementação da carga de dados para execução de testes de unidade.
 * @author augusto
 */
public interface DataLoader {

	/**
	 * Executa a carga de dados apropriadamente
	 */
	public void load() throws Exception;
	
}
