package com.hardis.fr.text.converter.dao;

import java.util.Collection;

/**
 * Classe générique de DAO
 * 
 * @author SFKI
 *
 * @param <O>
 *            Classe
 * @param <K>
 *            type de clé primaire
 */
public interface GenericDAO<O, K> {

	void create(O objet);

	public O getObjectByPrimaryKey(K key);

	public Collection<O> retreive() throws Exception;

	public O update(O object);

	public void delete(O object);
}
