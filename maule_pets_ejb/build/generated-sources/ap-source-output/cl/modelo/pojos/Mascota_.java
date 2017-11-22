package cl.modelo.pojos;

import cl.modelo.pojos.Cliente;
import cl.modelo.pojos.Especie;
import cl.modelo.pojos.Procedimiento;
import cl.modelo.pojos.Raza;
import cl.modelo.pojos.Sexo;
import cl.modelo.pojos.Vacuna;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-22T11:32:05")
@StaticMetamodel(Mascota.class)
public class Mascota_ { 

    public static volatile SingularAttribute<Mascota, String> descripcion;
    public static volatile SingularAttribute<Mascota, String> fechaNac;
    public static volatile SingularAttribute<Mascota, Cliente> rutCli;
    public static volatile SingularAttribute<Mascota, Sexo> idSexo;
    public static volatile SingularAttribute<Mascota, String> color;
    public static volatile SingularAttribute<Mascota, Double> peso;
    public static volatile SingularAttribute<Mascota, Raza> idRaza;
    public static volatile ListAttribute<Mascota, Vacuna> vacunaList;
    public static volatile ListAttribute<Mascota, Procedimiento> procedimientoList;
    public static volatile SingularAttribute<Mascota, Integer> idMascota;
    public static volatile SingularAttribute<Mascota, String> nombre;
    public static volatile SingularAttribute<Mascota, Especie> idEspecie;

}