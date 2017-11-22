package cl.modelo.ejb;

import javax.ejb.Stateless;
import cl.modelo.Controlador.ControlaCliente;
import cl.modelo.pojos.*;
import java.util.List;

@Stateless
public class SessionBeanCliente implements SessionBeanClienteLocal {

    private final ControlaCliente contrCliente;
    
    public SessionBeanCliente(){
        contrCliente = new ControlaCliente();
    }
    //logica de negocios

    @Override
    public void insertar(Object o) {
        contrCliente.insertar(o);
    }

    @Override
    public void eliminar(Object o) {
        contrCliente.eliminar(o);
    }

    @Override
    public void actualizar(Object o) {
        contrCliente.actualizar(o);
    }

    @Override
    public Cliente buscarCliente(String rut) {
        return contrCliente.buscarCliente(rut);
    }

    @Override
    public List<Cliente> getALLClientes() {
        return contrCliente.getAllClientes();
    }
    
    
    
}
