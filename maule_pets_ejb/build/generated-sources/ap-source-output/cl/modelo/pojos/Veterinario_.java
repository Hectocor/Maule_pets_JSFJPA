package cl.modelo.pojos;

import cl.modelo.pojos.Procedimiento;
import cl.modelo.pojos.Vacuna;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-22T11:32:05")
@StaticMetamodel(Veterinario.class)
public class Veterinario_ { 

    public static volatile SingularAttribute<Veterinario, String> rut;
    public static volatile SingularAttribute<Veterinario, String> apellidos;
    public static volatile SingularAttribute<Veterinario, String> password;
    public static volatile SingularAttribute<Veterinario, String> domicilio;
    public static volatile SingularAttribute<Veterinario, Integer> celular;
    public static volatile ListAttribute<Veterinario, Vacuna> vacunaList;
    public static volatile ListAttribute<Veterinario, Procedimiento> procedimientoList;
    public static volatile SingularAttribute<Veterinario, String> email;
    public static volatile SingularAttribute<Veterinario, String> rol;
    public static volatile SingularAttribute<Veterinario, String> nombres;

}