/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import DAOS.exceptions.DataBaseException;
import DAOS.exceptions.NonexistentEntityException;
import DAOS.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entities.Drogueria;
import Entities.Cargo;
import Entities.Views.ViewPersona;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;

/**
 *
 * @author Edward
 */
public class ViewPersonaDAO implements Serializable {

    public ViewPersonaDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ViewPersona viewPersona) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Drogueria idDrogueria = viewPersona.getIdDrogueria();
            if (idDrogueria != null) {
                idDrogueria = em.getReference(idDrogueria.getClass(), idDrogueria.getIdDrogueria());
                viewPersona.setIdDrogueria(idDrogueria);
            }
            Cargo idCargo = viewPersona.getIdCargo();
            if (idCargo != null) {
                idCargo = em.getReference(idCargo.getClass(), idCargo.getIdCargo());
                viewPersona.setIdCargo(idCargo);
            }
            em.persist(viewPersona);
            if (idDrogueria != null) {
                idDrogueria.getViewPersonaList().add(viewPersona);
                idDrogueria = em.merge(idDrogueria);
            }
            if (idCargo != null) {
                idCargo.getViewPersonaList().add(viewPersona);
                idCargo = em.merge(idCargo);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findViewPersona(viewPersona.getIdPersona()) != null) {
                throw new PreexistingEntityException("ViewPersona " + viewPersona + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ViewPersona viewPersona) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ViewPersona persistentViewPersona = em.find(ViewPersona.class, viewPersona.getIdPersona());
            Drogueria idDrogueriaOld = persistentViewPersona.getIdDrogueria();
            Drogueria idDrogueriaNew = viewPersona.getIdDrogueria();
            Cargo idCargoOld = persistentViewPersona.getIdCargo();
            Cargo idCargoNew = viewPersona.getIdCargo();
            if (idDrogueriaNew != null) {
                idDrogueriaNew = em.getReference(idDrogueriaNew.getClass(), idDrogueriaNew.getIdDrogueria());
                viewPersona.setIdDrogueria(idDrogueriaNew);
            }
            if (idCargoNew != null) {
                idCargoNew = em.getReference(idCargoNew.getClass(), idCargoNew.getIdCargo());
                viewPersona.setIdCargo(idCargoNew);
            }
            viewPersona = em.merge(viewPersona);
            if (idDrogueriaOld != null && !idDrogueriaOld.equals(idDrogueriaNew)) {
                idDrogueriaOld.getViewPersonaList().remove(viewPersona);
                idDrogueriaOld = em.merge(idDrogueriaOld);
            }
            if (idDrogueriaNew != null && !idDrogueriaNew.equals(idDrogueriaOld)) {
                idDrogueriaNew.getViewPersonaList().add(viewPersona);
                idDrogueriaNew = em.merge(idDrogueriaNew);
            }
            if (idCargoOld != null && !idCargoOld.equals(idCargoNew)) {
                idCargoOld.getViewPersonaList().remove(viewPersona);
                idCargoOld = em.merge(idCargoOld);
            }
            if (idCargoNew != null && !idCargoNew.equals(idCargoOld)) {
                idCargoNew.getViewPersonaList().add(viewPersona);
                idCargoNew = em.merge(idCargoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = viewPersona.getIdPersona();
                if (findViewPersona(id) == null) {
                    throw new NonexistentEntityException("The viewPersona with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ViewPersona viewPersona;
            try {
                viewPersona = em.getReference(ViewPersona.class, id);
                viewPersona.getIdPersona();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The viewPersona with id " + id + " no longer exists.", enfe);
            }
            Drogueria idDrogueria = viewPersona.getIdDrogueria();
            if (idDrogueria != null) {
                idDrogueria.getViewPersonaList().remove(viewPersona);
                idDrogueria = em.merge(idDrogueria);
            }
            Cargo idCargo = viewPersona.getIdCargo();
            if (idCargo != null) {
                idCargo.getViewPersonaList().remove(viewPersona);
                idCargo = em.merge(idCargo);
            }
            em.remove(viewPersona);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ViewPersona> findViewPersonaEntities() {
        return findViewPersonaEntities(true, -1, -1);
    }

    public List<ViewPersona> findViewPersonaEntities(int maxResults, int firstResult) {
        return findViewPersonaEntities(false, maxResults, firstResult);
    }

    private List<ViewPersona> findViewPersonaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ViewPersona.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public ViewPersona findViewPersona(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ViewPersona.class, id);
        } finally {
            em.close();
        }
    }

    public int getViewPersonaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ViewPersona> rt = cq.from(ViewPersona.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public ViewPersona login(ViewPersona entity) throws DataBaseException {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            ViewPersona usuario;
            Query q = entityManager.createQuery("SELECT u FROM ViewPersona u "
                    + "WHERE u.nombreDeUsuario LIKE :username "
                    + "AND u.password LIKE :password")
                    .setParameter("username", entity.getNombreDeUsuario())
                    .setParameter("password", entity.getPassword());
            try {
                usuario = (ViewPersona) q.getSingleResult();
            } catch (NoResultException e) {
                usuario = null;
            }
            return usuario;
        } catch (Exception e) {
            throw new DataBaseException("Error de Conexion a la Base de Datos", e);
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }
    }
    
}
