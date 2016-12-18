package id.co.wika.pcd.dashboard.dao.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import id.co.wika.pcd.dashboard.model.Project;

@Repository
@Transactional
public class ProjectDao {
  
  // ------------------------
  // PUBLIC METHODS
  // ------------------------
  
  /**
   * Save the project in the database.
   */
  public void create(Project project) {
    entityManager.persist(project);
    return;
  }
  
  /**
   * Delete the project from the database.
   */
  public void delete(Project project) {
    if (entityManager.contains(project))
      entityManager.remove(project);
    else
      entityManager.remove(entityManager.merge(project));
    return;
  }
  
  /**
   * Return all the projects stored in the database.
   */
  @SuppressWarnings("unchecked")
  public List<Project> getAll() {
    return entityManager.createQuery("from Project").getResultList();
  }
  
  /**
   * Return the project having the passed email.
   */
  public Project getByCode(String code) {
    return (Project) entityManager.createQuery(
        "from Project where code = :code")
        .setParameter("code", code)
        .getSingleResult();
  }

  /**
   * Return the project having the passed id.
   */
  public Project getById(long id) {
    return entityManager.find(Project.class, id);
  }

  /**
   * Update the passed project in the database.
   */
  public void update(Project project) {
    entityManager.merge(project);
    return;
  }

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------
  
  // An EntityManager will be automatically injected from entityManagerFactory
  // setup on DatabaseConfig class.
  @PersistenceContext
  private EntityManager entityManager;
  
}
