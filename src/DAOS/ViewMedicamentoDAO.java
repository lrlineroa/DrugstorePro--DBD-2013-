/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import DAOS.exceptions.NonexistentEntityException;
import DAOS.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entities.UsoMedicamento;
import Entities.TipoProducto;
import Entities.Proveedor;
import Entities.Presentacion;
import Entities.Views.ViewMedicamento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Edward
 */
public class ViewMedicamentoDAO implements Serializable {

    public ViewMedicamentoDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ViewMedicamento viewMedicamento) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            UsoMedicamento idUsoMedicamento = viewMedicamento.getIdUsoMedicamento();
            if (idUsoMedicamento != null) {
                idUsoMedicamento = em.getReference(idUsoMedicamento.getClass(), idUsoMedicamento.getIdUsoMedicamento());
                viewMedicamento.setIdUsoMedicamento(idUsoMedicamento);
            }
            TipoProducto idTipoProducto = viewMedicamento.getIdTipoProducto();
            if (idTipoProducto != null) {
                idTipoProducto = em.getReference(idTipoProducto.getClass(), idTipoProducto.getIdTipoProducto());
                viewMedicamento.setIdTipoProducto(idTipoProducto);
            }
            Proveedor idProveedor = viewMedicamento.getIdProveedor();
            if (idProveedor != null) {
                idProveedor = em.getReference(idProveedor.getClass(), idProveedor.getIdProveedor());
                viewMedicamento.setIdProveedor(idProveedor);
            }
            Presentacion idPresentacion = viewMedicamento.getIdPresentacion();
            if (idPresentacion != null) {
                idPresentacion = em.getReference(idPresentacion.getClass(), idPresentacion.getIdPresentacion());
                viewMedicamento.setIdPresentacion(idPresentacion);
            }
            em.persist(viewMedicamento);
            if (idUsoMedicamento != null) {
                idUsoMedicamento.getViewMedicamentoList().add(viewMedicamento);
                idUsoMedicamento = em.merge(idUsoMedicamento);
            }
            if (idTipoProducto != null) {
                idTipoProducto.getViewMedicamentoList().add(viewMedicamento);
                idTipoProducto = em.merge(idTipoProducto);
            }
            if (idProveedor != null) {
                idProveedor.getViewMedicamentoList().add(viewMedicamento);
                idProveedor = em.merge(idProveedor);
            }
            if (idPresentacion != null) {
                idPresentacion.getViewMedicamentoList().add(viewMedicamento);
                idPresentacion = em.merge(idPresentacion);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findViewMedicamento(viewMedicamento.getIdProducto()) != null) {
                throw new PreexistingEntityException("ViewMedicamento " + viewMedicamento + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ViewMedicamento viewMedicamento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ViewMedicamento persistentViewMedicamento = em.find(ViewMedicamento.class, viewMedicamento.getIdProducto());
            UsoMedicamento idUsoMedicamentoOld = persistentViewMedicamento.getIdUsoMedicamento();
            UsoMedicamento idUsoMedicamentoNew = viewMedicamento.getIdUsoMedicamento();
            TipoProducto idTipoProductoOld = persistentViewMedicamento.getIdTipoProducto();
            TipoProducto idTipoProductoNew = viewMedicamento.getIdTipoProducto();
            Proveedor idProveedorOld = persistentViewMedicamento.getIdProveedor();
            Proveedor idProveedorNew = viewMedicamento.getIdProveedor();
            Presentacion idPresentacionOld = persistentViewMedicamento.getIdPresentacion();
            Presentacion idPresentacionNew = viewMedicamento.getIdPresentacion();
            if (idUsoMedicamentoNew != null) {
                idUsoMedicamentoNew = em.getReference(idUsoMedicamentoNew.getClass(), idUsoMedicamentoNew.getIdUsoMedicamento());
                viewMedicamento.setIdUsoMedicamento(idUsoMedicamentoNew);
            }
            if (idTipoProductoNew != null) {
                idTipoProductoNew = em.getReference(idTipoProductoNew.getClass(), idTipoProductoNew.getIdTipoProducto());
                viewMedicamento.setIdTipoProducto(idTipoProductoNew);
            }
            if (idProveedorNew != null) {
                idProveedorNew = em.getReference(idProveedorNew.getClass(), idProveedorNew.getIdProveedor());
                viewMedicamento.setIdProveedor(idProveedorNew);
            }
            if (idPresentacionNew != null) {
                idPresentacionNew = em.getReference(idPresentacionNew.getClass(), idPresentacionNew.getIdPresentacion());
                viewMedicamento.setIdPresentacion(idPresentacionNew);
            }
            viewMedicamento = em.merge(viewMedicamento);
            if (idUsoMedicamentoOld != null && !idUsoMedicamentoOld.equals(idUsoMedicamentoNew)) {
                idUsoMedicamentoOld.getViewMedicamentoList().remove(viewMedicamento);
                idUsoMedicamentoOld = em.merge(idUsoMedicamentoOld);
            }
            if (idUsoMedicamentoNew != null && !idUsoMedicamentoNew.equals(idUsoMedicamentoOld)) {
                idUsoMedicamentoNew.getViewMedicamentoList().add(viewMedicamento);
                idUsoMedicamentoNew = em.merge(idUsoMedicamentoNew);
            }
            if (idTipoProductoOld != null && !idTipoProductoOld.equals(idTipoProductoNew)) {
                idTipoProductoOld.getViewMedicamentoList().remove(viewMedicamento);
                idTipoProductoOld = em.merge(idTipoProductoOld);
            }
            if (idTipoProductoNew != null && !idTipoProductoNew.equals(idTipoProductoOld)) {
                idTipoProductoNew.getViewMedicamentoList().add(viewMedicamento);
                idTipoProductoNew = em.merge(idTipoProductoNew);
            }
            if (idProveedorOld != null && !idProveedorOld.equals(idProveedorNew)) {
                idProveedorOld.getViewMedicamentoList().remove(viewMedicamento);
                idProveedorOld = em.merge(idProveedorOld);
            }
            if (idProveedorNew != null && !idProveedorNew.equals(idProveedorOld)) {
                idProveedorNew.getViewMedicamentoList().add(viewMedicamento);
                idProveedorNew = em.merge(idProveedorNew);
            }
            if (idPresentacionOld != null && !idPresentacionOld.equals(idPresentacionNew)) {
                idPresentacionOld.getViewMedicamentoList().remove(viewMedicamento);
                idPresentacionOld = em.merge(idPresentacionOld);
            }
            if (idPresentacionNew != null && !idPresentacionNew.equals(idPresentacionOld)) {
                idPresentacionNew.getViewMedicamentoList().add(viewMedicamento);
                idPresentacionNew = em.merge(idPresentacionNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = viewMedicamento.getIdProducto();
                if (findViewMedicamento(id) == null) {
                    throw new NonexistentEntityException("The viewMedicamento with id " + id + " no longer exists.");
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
            ViewMedicamento viewMedicamento;
            try {
                viewMedicamento = em.getReference(ViewMedicamento.class, id);
                viewMedicamento.getIdProducto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The viewMedicamento with id " + id + " no longer exists.", enfe);
            }
            UsoMedicamento idUsoMedicamento = viewMedicamento.getIdUsoMedicamento();
            if (idUsoMedicamento != null) {
                idUsoMedicamento.getViewMedicamentoList().remove(viewMedicamento);
                idUsoMedicamento = em.merge(idUsoMedicamento);
            }
            TipoProducto idTipoProducto = viewMedicamento.getIdTipoProducto();
            if (idTipoProducto != null) {
                idTipoProducto.getViewMedicamentoList().remove(viewMedicamento);
                idTipoProducto = em.merge(idTipoProducto);
            }
            Proveedor idProveedor = viewMedicamento.getIdProveedor();
            if (idProveedor != null) {
                idProveedor.getViewMedicamentoList().remove(viewMedicamento);
                idProveedor = em.merge(idProveedor);
            }
            Presentacion idPresentacion = viewMedicamento.getIdPresentacion();
            if (idPresentacion != null) {
                idPresentacion.getViewMedicamentoList().remove(viewMedicamento);
                idPresentacion = em.merge(idPresentacion);
            }
            em.remove(viewMedicamento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ViewMedicamento> findViewMedicamentoEntities() {
        return findViewMedicamentoEntities(true, -1, -1);
    }

    public List<ViewMedicamento> findViewMedicamentoEntities(int maxResults, int firstResult) {
        return findViewMedicamentoEntities(false, maxResults, firstResult);
    }

    private List<ViewMedicamento> findViewMedicamentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ViewMedicamento.class));
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

    public ViewMedicamento findViewMedicamento(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ViewMedicamento.class, id);
        } finally {
            em.close();
        }
    }

    public int getViewMedicamentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ViewMedicamento> rt = cq.from(ViewMedicamento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    //this method returns a list of products such name is like the given.
    public List<ViewMedicamento> findViewMedicamento(String name) {
        Query q= getEntityManager().createNamedQuery("ViewMedicamento.findByNombreProducto");
        try {
           return q.getResultList();
        } catch (javax.persistence.NoResultException e) {
           System.out.println("datos no encontrados");
           return null;
        }
    }
    // this method returns a specific  product with a ID a name given
    public ViewMedicamento findViewMedicamento(Integer ID,String name) {
        Query q= getEntityManager().createNamedQuery("ViewMedicamento.findByIdNombreProducto");
        q.setParameter("idProducto", ID);
        q.setParameter("nombreProducto", name);
        try {
           return (ViewMedicamento) q.getSingleResult();
        } catch (javax.persistence.NoResultException e) {
           System.out.println("datos no encontrados");
           return null;
        }
    }
    
      //this method increases or decreases  the amount in the inventary of a specific product
         //if sum equals true the amount incremets, if false decreases
         public int Update(Long ID, Object amount , boolean isInventary ){
             EntityManager em=getEntityManager();
             em.getTransaction().begin();
            try {
               if(isInventary){
                    Query q=getEntityManager().createQuery("UPDATE ViewMedicamento SET cantidadProducto= cantidadProducto + "+amount+" WHERE idProducto=:idProducto");
//                    q.setParameter(1, amount);
                    q.setParameter("idProducto",ID);
                    int updateCount=q.executeUpdate();
                    em.getTransaction().commit();
                    return 0;
               }else{
                    ViewMedicamento pro= em.find(ViewMedicamento.class, ID);  
                    if (!(pro.getCantidadProducto()-Integer.parseInt(amount.toString())<0)){
                        Query q=em.createQuery("UPDATE ProductoGeneral  SET cantidadProducto= cantidadProducto - "+amount+" WHERE idProducto=:idProducto");
//                       q.setParameter(1, amount);
                        q.setParameter("idProducto", ID);
                        int updateCount=q.executeUpdate();
                        em.getTransaction().commit();
                        return 0;
                       
                    }
               } 
               
             } catch (javax.persistence.PersistenceException evt) {
                   em.getTransaction().rollback();
             }finally{
                em.getTransaction().commit();
                return -1;
             }
             
             
         }
    
    
}
