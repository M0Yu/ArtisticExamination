package com.artistic_exam.ExaminationInfor_Inside;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * ExaminationInforInside entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.artistic_exam.ExaminationInfor_Inside.ExaminationInforInside
 * @author MyEclipse Persistence Tools
 */
public class ExaminationInforInsideDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ExaminationInforInsideDAO.class);
	// property constants
	public static final String SESSION_NUM = "sessionNum";
	public static final String QUS_NUM = "qusNum";
	public static final String EXAMINER_NAME1 = "examinerName1";
	public static final String EXAMINER_SCORE1 = "examinerScore1";
	public static final String EXAMINER_NAME2 = "examinerName2";
	public static final String EXAMINER_SCORE2 = "examinerScore2";
	public static final String EXAMINER_NAME3 = "examinerName3";
	public static final String EXAMINER_SCORE3 = "examinerScore3";
	public static final String EXAMINER_NAME4 = "examinerName4";
	public static final String EXAMINER_SCORE4 = "examinerScore4";
	public static final String EXAMINER_NAME5 = "examinerName5";
	public static final String EXAMINER_SCORE5 = "examinerScore5";

	public void save(ExaminationInforInside transientInstance) {
		log.debug("saving ExaminationInforInside instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ExaminationInforInside persistentInstance) {
		log.debug("deleting ExaminationInforInside instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ExaminationInforInside findById(
			com.artistic_exam.ExaminationInfor_Inside.ExaminationInforInsideId id) {
		log.debug("getting ExaminationInforInside instance with id: " + id);
		try {
			ExaminationInforInside instance = (ExaminationInforInside) getSession()
					.get("com.artistic_exam.ExaminationInfor_Inside.ExaminationInforInside",
							id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ExaminationInforInside instance) {
		log.debug("finding ExaminationInforInside instance by example");
		try {
			List results = getSession()
					.createCriteria(
							"com.artistic_exam.ExaminationInfor_Inside.ExaminationInforInside")
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
		log.debug("finding ExaminationInforInside instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ExaminationInforInside as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySessionNum(Object sessionNum) {
		return findByProperty(SESSION_NUM, sessionNum);
	}

	public List findByQusNum(Object qusNum) {
		return findByProperty(QUS_NUM, qusNum);
	}

	public List findByExaminerName1(Object examinerName1) {
		return findByProperty(EXAMINER_NAME1, examinerName1);
	}

	public List findByExaminerScore1(Object examinerScore1) {
		return findByProperty(EXAMINER_SCORE1, examinerScore1);
	}

	public List findByExaminerName2(Object examinerName2) {
		return findByProperty(EXAMINER_NAME2, examinerName2);
	}

	public List findByExaminerScore2(Object examinerScore2) {
		return findByProperty(EXAMINER_SCORE2, examinerScore2);
	}

	public List findByExaminerName3(Object examinerName3) {
		return findByProperty(EXAMINER_NAME3, examinerName3);
	}

	public List findByExaminerScore3(Object examinerScore3) {
		return findByProperty(EXAMINER_SCORE3, examinerScore3);
	}

	public List findByExaminerName4(Object examinerName4) {
		return findByProperty(EXAMINER_NAME4, examinerName4);
	}

	public List findByExaminerScore4(Object examinerScore4) {
		return findByProperty(EXAMINER_SCORE4, examinerScore4);
	}

	public List findByExaminerName5(Object examinerName5) {
		return findByProperty(EXAMINER_NAME5, examinerName5);
	}

	public List findByExaminerScore5(Object examinerScore5) {
		return findByProperty(EXAMINER_SCORE5, examinerScore5);
	}

	public List findAll() {
		log.debug("finding all ExaminationInforInside instances");
		try {
			String queryString = "from ExaminationInforInside";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ExaminationInforInside merge(ExaminationInforInside detachedInstance) {
		log.debug("merging ExaminationInforInside instance");
		try {
			ExaminationInforInside result = (ExaminationInforInside) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ExaminationInforInside instance) {
		log.debug("attaching dirty ExaminationInforInside instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ExaminationInforInside instance) {
		log.debug("attaching clean ExaminationInforInside instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}