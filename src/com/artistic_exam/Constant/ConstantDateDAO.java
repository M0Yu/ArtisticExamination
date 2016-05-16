package com.artistic_exam.Constant;

import com.artistic_exam.ExaminationInfor_Inside.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * ConstantDate entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.artistic_exam.Constant.ConstantDate
 * @author MyEclipse Persistence Tools
 */
public class ConstantDateDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ConstantDateDAO.class);
	// property constants
	public static final String CONSTANT_VALUE = "constantValue";
	public static final String CONSTANT_DES = "constantDes";

	public void save(ConstantDate transientInstance) {
		log.debug("saving ConstantDate instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ConstantDate persistentInstance) {
		log.debug("deleting ConstantDate instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ConstantDate findById(java.lang.String id) {
		log.debug("getting ConstantDate instance with id: " + id);
		try {
			ConstantDate instance = (ConstantDate) getSession().get(
					"com.artistic_exam.Constant.ConstantDate", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ConstantDate instance) {
		log.debug("finding ConstantDate instance by example");
		try {
			List results = getSession()
					.createCriteria("com.artistic_exam.Constant.ConstantDate")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding ConstantDate instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ConstantDate as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByConstantValue(Object constantValue) {
		return findByProperty(CONSTANT_VALUE, constantValue);
	}

	public List findByConstantDes(Object constantDes) {
		return findByProperty(CONSTANT_DES, constantDes);
	}

	public List findAll() {
		log.debug("finding all ConstantDate instances");
		try {
			String queryString = "from ConstantDate";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ConstantDate merge(ConstantDate detachedInstance) {
		log.debug("merging ConstantDate instance");
		try {
			ConstantDate result = (ConstantDate) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ConstantDate instance) {
		log.debug("attaching dirty ConstantDate instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ConstantDate instance) {
		log.debug("attaching clean ConstantDate instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}