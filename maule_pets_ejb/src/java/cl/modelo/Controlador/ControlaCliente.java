package cl.modelo.Controlador;

import cl.modelo.pojos.*;
import java.util.List;
import javax.persistence.*;


public class ControlaCliente {

    private EntityManagerFactory emf;
    private EntityManager em;

    public ControlaCliente() {
        emf = Persistence.createEntityManagerFactory("maule_pets_ejbPU");
        em = emf.createEntityManager();
    }
    
    /*metodos crud*/
    // 1 metodo para insertar
    public void insertar(Object o){
        //iniciar transaccion
        em.getTransaction().begin();
        try{
            //metodo para insertar
            em.persist(o);
            //se confirma
            em.getTransaction().commit();
        }catch(PersistenceException e){
            System.out.println(e);
            em.getTransaction().rollback();
        }
    }
    //2 metodo para eliminar
    public void eliminar(Object o){
        em.getTransaction().begin();
        try{
            //metodo para eliminar
            em.remove(o);
            em.getTransaction().commit();
        }catch(PersistenceException e){
            System.out.println(e);
            em.getTransaction().rollback();
        }
    }
    //3 metodo para actualizar
    public void actualizar(Object o) {
        em.getTransaction().begin();
        try {
            //Metodo para actualizar
            em.merge(o);
            em.getTransaction().commit();
        } catch (PersistenceException e) {
            System.out.println(e);
            em.getTransaction().rollback();
        }
    }
    
    public Cliente buscarCliente(String rut) {
        return em.find(Cliente.class, rut);
    }
    
    public List<Cliente> getAllClientes() {
        String sql = "SELECT c from Cliente c";
        return em.createQuery(sql).getResultList();
    }

    public List<Cliente> obtenerClientePorRut(String rut) {
        try {
            String sql = "SELECT v from Veterinario v where v.rut like '" + rut + "%'";
            return em.createQuery(sql).getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
    
}

