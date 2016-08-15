package br.com.iterator.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.iterator.model.dao.InterfaceDAO;
import br.com.iterator.model.helper.LogHelper;
import br.com.iterator.model.util.HibernateUtil;

public class HibernateDAO<T> implements InterfaceDAO<T> {
	private Class<T> classe;
	private Session session;

	public HibernateDAO(Class<T> classe) {
		super();
		this.classe = classe;
	}

	@Override
	public void salvar(T bean) {
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(bean);
			session.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
			LogHelper.LOGGER.severe(e.getMessage());
			session.getTransaction().rollback();
		} finally {
			session.close();
		}	
	}

	@Override
	public void atualizar(T bean) {
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.update(bean);
			session.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
			LogHelper.LOGGER.severe(e.getMessage());
			session.getTransaction().rollback();
		} finally {
			session.close();
		}	
	}

	@Override
	public void excluir(T bean) {
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.delete(bean);
			session.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
			LogHelper.LOGGER.severe(e.getMessage());
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getBean(Serializable codigo) {
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			T bean = (T) session.get(classe, codigo);
			session.getTransaction().commit();
			return bean;
		} finally {
			session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getBeans() {
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			List<T> beans = (List<T>)session.createCriteria(classe).list();			
			session.getTransaction().commit();
			return beans;
		} finally {
			session.close();
		}		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getBeansMaxResults(Integer qtd) {
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			List<T> beans = (List<T>)session.createCriteria(classe).setMaxResults(qtd).list();			
			session.getTransaction().commit();
			return beans;
		} finally {
			session.close();
		}		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getBeansByExample(T bean) {
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Example example = Example.create(bean);
			example.enableLike(MatchMode.ANYWHERE);
			example.ignoreCase();		
			session.getTransaction().commit();
			return session.createCriteria(classe).add(example).list();
		} finally {
			session.close();
		}		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T getBeanByParametro(String parametro, String valor) {
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Criteria criteria = session.createCriteria(classe);
			criteria.add(Restrictions.eq(parametro, valor));	
			T bean = (T) criteria.uniqueResult();
			session.getTransaction().commit();
			return bean;
		} finally {
			session.close();
		}
	}
}
