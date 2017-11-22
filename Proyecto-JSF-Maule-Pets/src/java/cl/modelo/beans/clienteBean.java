package cl.modelo.beans;

import cl.modelo.ejb.SessionBeanClienteLocal;
import cl.modelo.pojos.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;

@ManagedBean(name="clienteBean")
//@Entity
public class clienteBean implements Serializable {
    
    private Cliente cliente;
    private Cliente clientenuevo;
    private boolean bandera;
    
    @EJB
    private SessionBeanClienteLocal sbl;
    List<Cliente> listaClientes;
    
    @PostConstruct
    public void init(){
        //listaClientes = sbl.getALLClientes();
    }
    //constructor
    public clienteBean(){
        cliente = new Cliente();
        clientenuevo = new Cliente();
        listaClientes = new ArrayList();
    }
    
    //setters y getters

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getClientenuevo() {
        return clientenuevo;
    }

    public void setClientenuevo(Cliente clientenuevo) {
        this.clientenuevo = clientenuevo;
    }

    public boolean isBandera() {
        return bandera;
    }

    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }

    public List<Cliente> getListaClientes() {
        listaClientes = sbl.getALLClientes();
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
    
    ////////////////////////////
    public void resetearCampos() {
        cliente = new Cliente();
        cliente.setRut("");
        cliente.setNombres("");
        cliente.setApellidos("");
        cliente.setCelular(0);
        cliente.setDomicilio("");
        cliente.setEmail("");
    }
    
    
}
