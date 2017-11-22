package cl.modelo.pojos;

import cl.modelo.pojos.Mascota;
import cl.modelo.pojos.Veterinario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-22T11:32:05")
@StaticMetamodel(Procedimiento.class)
public class Procedimiento_ { 

    public static volatile SingularAttribute<Procedimiento, String> descripcion;
    public static volatile SingularAttribute<Procedimiento, String> fecha;
    public static volatile SingularAttribute<Procedimiento, Integer> idProcedimiento;
    public static volatile SingularAttribute<Procedimiento, String> observaciones;
    public static volatile SingularAttribute<Procedimiento, Veterinario> rutVet;
    public static volatile SingularAttribute<Procedimiento, Mascota> idMasc;

}