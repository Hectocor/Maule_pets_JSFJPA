package cl.modelo.ejb;

import cl.modelo.Controlador.Controla;
import cl.modelo.pojos.*;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class SessionBean implements SessionBeanLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private final Controla controla;

    public SessionBean() {
        controla = new Controla();
    }

    //logica de negocios
    @Override
    public void insertar(Object o) {
        controla.insertar(o);
    }

    @Override
    public void eliminar(Object o) {
        controla.eliminar(o);
    }

    @Override
    public void actualizar(Object o) {
        controla.actualizar(o);
    }
    /////////////////////////
    //metodos veterinario
    @Override
    public Veterinario buscarVeterinario(String rut) {
        return controla.buscarVeterinario(rut);
    }

    @Override
    public List<Veterinario> getALLVeterinarios() {
        return controla.getAllVeterinarios();
    }

    @Override
    public boolean validaVeterinario(String rut, String password) {
        if (controla.buscarVeterinarioLC(rut, password) != null) {
            return true;
        } else {
            return false;
        }
    }
    //metodos para cliente
    /*
    @Override
    public List<Cliente> getALLClientes() {
        return controla.getAllClientes();
    }

    @Override
    public Cliente buscarCliente(String Rut) {
        return controla.buscarCliente(Rut);
    }*/
    
    
    
}
