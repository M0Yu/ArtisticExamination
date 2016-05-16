package com.artistic_exam.ScoreSumma_Inside;

import com.artistic_exam.ExaminationInfor_Inside.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * ScoreSummaInside entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.artistic_exam.ScoreSumma_Inside.ScoreSummaInside
 * @author MyEclipse Persistence Tools
 */
public class ScoreSummaInsideDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ScoreSummaInsideDAO.class);
	// property constants
	public static final String QUS_TYPE1SCORE = "qusType1score";
	public static final String QUS_TYPE2SCORE = "qusType2score";
	public static final String QUS_TYPE3SCORE = "qusType3score";
	public static final String SUM_SCORE = "sumScore";
	public static final String HEIGHT = "height";

	public void save(ScoreSummaInside transientInstance) {
		log.debug("saving ScoreSummaInside instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ScoreSummaInside persistentInstance) {
		log.debug("deleting ScoreSummaInside instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ScoreSummaInside findById(java.lang.String id) {
		log.debug("getting ScoreSummaInside instance with id: " + id);
		try {
			ScoreSummaInside instance = (ScoreSummaInside) getSession().get(
					"com.artistic_exam.ScoreSumma_Inside.ScoreSummaInside", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ScoreSummaInside instance) {
		log.debug("finding ScoreSummaInside instance by example");
		try {
			List results = getSession()
					.createCriteria(
							"com.artistic_exam.ScoreSumma_Inside.ScoreSummaInside")
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
		log.debug("finding ScoreSummaInside instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ScoreSummaInside as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByQusType1score(Object qusType1score) {
		return findByProperty(QUS_TYPE1SCORE, qusType1score);
	}

	public List findByQusType2score(Object qusType2score) {
		return findByProperty(QUS_TYPE2SCORE, qusType2score);
	}

	public List findByQusType3score(Object qusType3score) {
		return findByProperty(QUS_TYPE3SCORE, qusType3score);
	}

	public List findBySumScore(Object sumScore) {
		return findByProperty(SUM_SCORE, sumScore);
	}

	public List findByHeight(Object height) {
		return findByProperty(HEIGHT, height);
	}

	public List findAll() {
		log.debug("finding all ScoreSummaInside instances");
		try {
			String queryString = "from ScoreSummaInside";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ScoreSummaInside merge(ScoreSummaInside detachedInstance) {
		log.debug("merging ScoreSummaInside instance");
		try {
			ScoreSummaInside result = (ScoreSummaInside) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ScoreSummaInside instance) {
		log.debug("attaching dirty ScoreSummaInside instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ScoreSummaInside instance) {
		log.debug("attaching clean ScoreSummaInside instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}