package cl.modelo.pojos;

import cl.modelo.pojos.Mascota;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-22T11:32:05")
@StaticMetamodel(Especie.class)
public class Especie_ { 

    public static volatile SingularAttribute<Especie, String> descripcion;
    public static volatile ListAttribute<Especie, Mascota> mascotaList;
    public static volatile SingularAttribute<Especie, Integer> idEspecie;

}