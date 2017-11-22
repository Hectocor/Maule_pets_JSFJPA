package cl.modelo.Controlador;

import cl.modelo.pojos.*;
import java.util.List;
import javax.persistence.*;


public class Controla {
    
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public Controla(){
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
    /////////////////////////////
    //metodos para logueo de veterinario    
    public Veterinario buscarVeterinario(String rut) {
        return em.find(Veterinario.class, rut);
    }

    /*public Formulario buscarFormulario(int id) {
        return em.find(Formulario.class, id);
    }*/

    public List<Veterinario> getAllVeterinarios() {
        String sql = "SELECT v from Veterinario v";
        return em.createQuery(sql).getResultList();
    }

    /*public List<Formulario> getAllFormulario() {
        String sql = "SELECT f from Formulario f";
        return em.createQuery(sql).getResultList();
    }*/
    public Veterinario buscarVeterinarioLC(String rut, String password) {
        try {
            Query query = em.createQuery("SELECT v from Veterinario v where v.rut =:rut and v.password =:password");
            query.setParameter("rut",rut);
            query.setParameter("password", password);
            Object o = query.getSingleResult();
            return (Veterinario) o;
        } catch (NoResultException e) {
            return null;
        }
    }
    //////////////////////////////////////////////////////////
    //metodos para cliente
    
}
