package com.qa.persistence.repository;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qa.persistence.domain.Trainee;
import com.qa.util.JSONUtil;

@Default
public class ClassroomDBRepository implements ClassroomRepository {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;

	@Override
	public String getAllClassrooms() {
		Query query = manager.createQuery("Select c FROM Classroom c");
		Collection<Trainee> result = (Collection<Trainee>) query.getResultList();
		return util.getJSONForObject(result);
	}
	
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}