/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.modelo.ejb;

import cl.modelo.pojos.Cliente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Moises
 */
@Local
public interface SessionBeanClienteLocal {
    public void insertar(Object o);
    public void eliminar(Object o);
    public void actualizar(Object o);
    public Cliente buscarCliente(String rut);
    public List<Cliente> getALLClientes();
}
