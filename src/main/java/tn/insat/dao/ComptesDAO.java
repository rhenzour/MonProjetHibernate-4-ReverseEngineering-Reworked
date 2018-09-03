package tn.insat.dao;

import java.util.List;

import tn.insat.entities.Compte;

public interface ComptesDAO {

	public abstract void persist(Compte transientInstance);

	public abstract void attachDirty(Compte instance);

	public abstract void attachClean(Compte instance);

	public abstract void delete(Compte persistentInstance);

	public abstract Compte merge(Compte detachedInstance);

	public abstract Compte findById(java.lang.String id);

	public abstract List<Compte> findByExample(Compte instance);

}