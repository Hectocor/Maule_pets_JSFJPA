package cl.modelo.pojos;

import cl.modelo.pojos.Mascota;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-22T12:52:25")
@StaticMetamodel(Raza.class)
public class Raza_ { 

    public static volatile SingularAttribute<Raza, String> descripcion;
    public static volatile ListAttribute<Raza, Mascota> mascotaList;
    public static volatile SingularAttribute<Raza, Integer> idRaza;

}