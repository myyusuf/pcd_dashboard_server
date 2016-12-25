package id.co.wika.pcd.dashboard.dao.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import id.co.wika.pcd.dashboard.model.ProjectProgress;

@Repository
@Transactional
public class ProjectProgressDao {
  
  // ------------------------
  // PUBLIC METHODS
  // ------------------------
  
  /**
   * Save the project in the database.
   */
  public void create(ProjectProgress projectProgress) {
    entityManager.persist(projectProgress);
    return;
  }
  
  /**
   * Delete the project from the database.
   */
  public void delete(ProjectProgress projectProgress) {
    if (entityManager.contains(projectProgress))
      entityManager.remove(projectProgress);
    else
      entityManager.remove(entityManager.merge(projectProgress));
    return;
  }
  
  /**
   * Return all the projects stored in the database.
   */
  @SuppressWarnings("unchecked")
  public List<ProjectProgress> getAll() {
    return entityManager.createQuery("from ProjectProgress").getResultList();
  }
  
  /**
   * Return the project having the passed email.
   */
  public ProjectProgress getByCodeMonthYear(String code, int month, int year) {
    return (ProjectProgress) entityManager.createQuery(
        "from ProjectProgress where project.code = :code and month = :month and year = :year")
    	.setParameter("code", code)
    	.setParameter("month", month)
        .setParameter("year", year)
        .getSingleResult();
  }

  /**
   * Return the project having the passed id.
   */
  public ProjectProgress getById(long id) {
    return entityManager.find(ProjectProgress.class, id);
  }

  /**
   * Update the passed project in the database.
   */
  public void update(ProjectProgress projectProgress) {
    entityManager.merge(projectProgress);
    return;
  }
  
  @SuppressWarnings("unchecked")
  public List<ProjectProgress> selectAllByMonthAndYear(int month, int year) {
	return entityManager.createQuery(
	        "from ProjectProgress where month = :month and year = :year")
	    	.setParameter("month", month)
	        .setParameter("year", year)
	        .getResultList();
  }

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------
  
  // An EntityManager will be automatically injected from entityManagerFactory
  // setup on DatabaseConfig class.
  @PersistenceContext
  private EntityManager entityManager;
  
}
