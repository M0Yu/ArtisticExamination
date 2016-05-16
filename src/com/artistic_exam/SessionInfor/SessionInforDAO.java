package com.artistic_exam.SessionInfor;

import com.artistic_exam.ExaminationInfor_Inside.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * SessionInfor entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.artistic_exam.SessionInfor.SessionInfor
 * @author MyEclipse Persistence Tools
 */
public class SessionInforDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(SessionInforDAO.class);
	// property constants
	public static final String DATE_TIME = "dateTime";
	public static final String PERSON_NUM = "personNum";

	public void save(SessionInfor transientInstance) {
		log.debug("saving SessionInfor instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(SessionInfor persistentInstance) {
		log.debug("deleting SessionInfor instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SessionInfor findById(java.lang.String id) {
		log.debug("getting SessionInfor instance with id: " + id);
		try {
			SessionInfor instance = (SessionInfor) getSession().get(
					"com.artistic_exam.SessionInfor.SessionInfor", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(SessionInfor instance) {
		log.debug("finding SessionInfor instance by example");
		try {
			List results = getSession()
					.createCriteria(
							"com.artistic_exam.SessionInfor.SessionInfor")
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
		log.debug("finding SessionInfor instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from SessionInfor as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDateTime(Object dateTime) {
		return findByProperty(DATE_TIME, dateTime);
	}

	public List findByPersonNum(Object personNum) {
		return findByProperty(PERSON_NUM, personNum);
	}

	public List findAll() {
		log.debug("finding all SessionInfor instances");
		try {
			String queryString = "from SessionInfor";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public SessionInfor merge(SessionInfor detachedInstance) {
		log.debug("merging SessionInfor instance");
		try {
			SessionInfor result = (SessionInfor) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(SessionInfor instance) {
		log.debug("attaching dirty SessionInfor instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SessionInfor instance) {
		log.debug("attaching clean SessionInfor instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}