/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.modelo.pojos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JONAS
 */
@Entity
@Table(name = "procedimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Procedimiento.findAll", query = "SELECT p FROM Procedimiento p"),
    @NamedQuery(name = "Procedimiento.findByIdProcedimiento", query = "SELECT p FROM Procedimiento p WHERE p.idProcedimiento = :idProcedimiento"),
    @NamedQuery(name = "Procedimiento.findByFecha", query = "SELECT p FROM Procedimiento p WHERE p.fecha = :fecha"),
    @NamedQuery(name = "Procedimiento.findByDescripcion", query = "SELECT p FROM Procedimiento p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Procedimiento.findByObservaciones", query = "SELECT p FROM Procedimiento p WHERE p.observaciones = :observaciones")})
public class Procedimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProcedimiento")
    private Integer idProcedimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "fecha")
    private String fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "rutVet", referencedColumnName = "rut")
    @ManyToOne
    private Veterinario rutVet;
    @JoinColumn(name = "idMasc", referencedColumnName = "idMascota")
    @ManyToOne(optional = false)
    private Mascota idMasc;

    public Procedimiento() {
    }

    public Procedimiento(Integer idProcedimiento) {
        this.idProcedimiento = idProcedimiento;
    }

    public Procedimiento(Integer idProcedimiento, String fecha, String descripcion, String observaciones) {
        this.idProcedimiento = idProcedimiento;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.observaciones = observaciones;
    }

    public Integer getIdProcedimiento() {
        return idProcedimiento;
    }

    public void setIdProcedimiento(Integer idProcedimiento) {
        this.idProcedimiento = idProcedimiento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Veterinario getRutVet() {
        return rutVet;
    }

    public void setRutVet(Veterinario rutVet) {
        this.rutVet = rutVet;
    }

    public Mascota getIdMasc() {
        return idMasc;
    }

    public void setIdMasc(Mascota idMasc) {
        this.idMasc = idMasc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProcedimiento != null ? idProcedimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Procedimiento)) {
            return false;
        }
        Procedimiento other = (Procedimiento) object;
        if ((this.idProcedimiento == null && other.idProcedimiento != null) || (this.idProcedimiento != null && !this.idProcedimiento.equals(other.idProcedimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.modelo.pojos.Procedimiento[ idProcedimiento=" + idProcedimiento + " ]";
    }
    
}
