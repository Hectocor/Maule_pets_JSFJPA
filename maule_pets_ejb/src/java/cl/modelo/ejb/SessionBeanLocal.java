/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.modelo.ejb;

import cl.modelo.pojos.*;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Moises
 */
@Local
public interface SessionBeanLocal {

    void insertar(Object o);

    void eliminar(Object o);

    void actualizar(Object o);

    Veterinario buscarVeterinario(String rut);

    List<Veterinario> getALLVeterinarios();

    boolean validaVeterinario(String rut, String password);
/*
    List<Cliente> buscarClientes();

    List<Cliente> getALLClientes();

    public Cliente buscarCliente(String Rut);
  */  
    
}
