package cl.modelo.beans;

import cl.modelo.ejb.SessionBeanLocal;
import cl.modelo.pojos.Veterinario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name="veterinarioBean")
@SessionScoped
public class veterinarioBean {

    private Veterinario veterinario;
    private Veterinario veterinarionuevo;
    private boolean bandera;

    HttpSession session;

    @EJB
    private SessionBeanLocal sbl;
    List<Veterinario> listaVeterinarios;

    @PostConstruct
    public void init() {
        listaVeterinarios = sbl.getALLVeterinarios();
    }

    public veterinarioBean() {
        veterinario = new Veterinario();
        veterinarionuevo = new Veterinario();
        listaVeterinarios = new ArrayList();
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public Veterinario getVeterinarionuevo() {
        return veterinarionuevo;
    }

    public void setVeterinarionuevo(Veterinario veterinarionuevo) {
        this.veterinarionuevo = veterinarionuevo;
    }

    public boolean isBandera() {
        return bandera;
    }

    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }

    public List<Veterinario> getListaVeterinarios() {
        return listaVeterinarios;
    }

    public void setListaVeterinarios(List<Veterinario> listaVeterinarios) {
        this.listaVeterinarios = listaVeterinarios;
    }

    /////////////////////////////////
    public boolean existeVeterinario() {
        if (sbl.validaVeterinario(veterinario.getRut(), veterinario.getPassword())) {
            Veterinario aux = sbl.buscarVeterinario(veterinario.getRut());
            System.out.println("error");

            session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);

            veterinario.setRol(aux.getRol());
            bandera = true;
        }
        return bandera;
    }

    public void resetearCampos() {
        veterinario = new Veterinario();
        veterinario.setRut("");
        veterinario.setNombres("");
        veterinario.setApellidos("");
        veterinario.setDomicilio("");
        veterinario.setCelular(0);
        veterinario.setEmail("");
        veterinario.setPassword("");
        veterinario.setRol("");
    }

    //Funcion para redireccionar a la siguiente vista, recibe la ruta
    public void redireccionar(String ruta) {
        try {
            //Mantener mensaje que se publica
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            //Retornar automaticamente a la siguiente vista
            FacesContext.getCurrentInstance().getExternalContext().redirect(ruta);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    //Metodo para cerrar sesion del veterinario
    public void cerrarSesion() {
        session.invalidate();
        resetearCampos();
        //Obtener la ruta de la pagina actual desde donde se cierra la sesion
        String path = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
        //Llamada a funcion encargada de redireccionar
        redireccionar(path + "/faces/index.xhtml");
    }

    //metodo asociado al boton de ingreso de veterinario en pagina index
    public void eventoBotonIngresar() {
        bandera = existeVeterinario();
        
        if(!bandera){
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veterinario no encontrado", "Rut y Password no coinciden");
            FacesContext.getCurrentInstance().addMessage(null, msj);
            resetearCampos();
            String path = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
            redireccionar(path + "/faces/index.xhtml");
        }else{
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido " + veterinario.getNombres(), "");
            FacesContext.getCurrentInstance().addMessage(null, msj);
            String path = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
            redireccionar(path + "/faces/menu.xhtml");
        }
    }
    public boolean isLogueado(){
        return session != null;
    }
}
