package com.artistic_exam.ScoreSumma_Outside;

import com.artistic_exam.ExaminationInfor_Inside.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * ScoreSummaOutside entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.artistic_exam.ScoreSumma_Outside.ScoreSummaOutside
 * @author MyEclipse Persistence Tools
 */
public class ScoreSummaOutsideDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ScoreSummaOutsideDAO.class);
	// property constants
	public static final String SUM_SCORE = "sumScore";
	public static final String HEIGHT = "height";

	public void save(ScoreSummaOutside transientInstance) {
		log.debug("saving ScoreSummaOutside instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ScoreSummaOutside persistentInstance) {
		log.debug("deleting ScoreSummaOutside instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ScoreSummaOutside findById(java.lang.String id) {
		log.debug("getting ScoreSummaOutside instance with id: " + id);
		try {
			ScoreSummaOutside instance = (ScoreSummaOutside) getSession().get(
					"com.artistic_exam.ScoreSumma_Outside.ScoreSummaOutside",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ScoreSummaOutside instance) {
		log.debug("finding ScoreSummaOutside instance by example");
		try {
			List results = getSession()
					.createCriteria(
							"com.artistic_exam.ScoreSumma_Outside.ScoreSummaOutside")
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
		log.debug("finding ScoreSummaOutside instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ScoreSummaOutside as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySumScore(Object sumScore) {
		return findByProperty(SUM_SCORE, sumScore);
	}

	public List findByHeight(Object height) {
		return findByProperty(HEIGHT, height);
	}

	public List findAll() {
		log.debug("finding all ScoreSummaOutside instances");
		try {
			String queryString = "from ScoreSummaOutside";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ScoreSummaOutside merge(ScoreSummaOutside detachedInstance) {
		log.debug("merging ScoreSummaOutside instance");
		try {
			ScoreSummaOutside result = (ScoreSummaOutside) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ScoreSummaOutside instance) {
		log.debug("attaching dirty ScoreSummaOutside instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ScoreSummaOutside instance) {
		log.debug("attaching clean ScoreSummaOutside instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}