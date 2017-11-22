package cl.modelo.pojos;

import cl.modelo.pojos.Mascota;
import cl.modelo.pojos.Veterinario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-22T11:32:05")
@StaticMetamodel(Vacuna.class)
public class Vacuna_ { 

    public static volatile SingularAttribute<Vacuna, String> descripcion;
    public static volatile SingularAttribute<Vacuna, String> fecha;
    public static volatile SingularAttribute<Vacuna, String> proximaFecha;
    public static volatile SingularAttribute<Vacuna, String> observaciones;
    public static volatile SingularAttribute<Vacuna, Integer> idVacuna;
    public static volatile SingularAttribute<Vacuna, Veterinario> rutVet;
    public static volatile SingularAttribute<Vacuna, Mascota> idMasc;

}