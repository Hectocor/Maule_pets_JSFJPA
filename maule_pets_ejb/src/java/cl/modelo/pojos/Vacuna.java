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
 * @author Moises
 */
@Entity
@Table(name = "vacuna")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vacuna.findAll", query = "SELECT v FROM Vacuna v"),
    @NamedQuery(name = "Vacuna.findByIdVacuna", query = "SELECT v FROM Vacuna v WHERE v.idVacuna = :idVacuna"),
    @NamedQuery(name = "Vacuna.findByFecha", query = "SELECT v FROM Vacuna v WHERE v.fecha = :fecha"),
    @NamedQuery(name = "Vacuna.findByDescripcion", query = "SELECT v FROM Vacuna v WHERE v.descripcion = :descripcion"),
    @NamedQuery(name = "Vacuna.findByObservaciones", query = "SELECT v FROM Vacuna v WHERE v.observaciones = :observaciones"),
    @NamedQuery(name = "Vacuna.findByProximaFecha", query = "SELECT v FROM Vacuna v WHERE v.proximaFecha = :proximaFecha")})
public class Vacuna implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVacuna")
    private Integer idVacuna;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "proximaFecha")
    private String proximaFecha;
    @JoinColumn(name = "rutVet", referencedColumnName = "rut")
    @ManyToOne
    private Veterinario rutVet;
    @JoinColumn(name = "idMasc", referencedColumnName = "idMascota")
    @ManyToOne(optional = false)
    private Mascota idMasc;

    public Vacuna() {
    }

    public Vacuna(Integer idVacuna) {
        this.idVacuna = idVacuna;
    }

    public Vacuna(Integer idVacuna, String fecha, String descripcion, String observaciones, String proximaFecha) {
        this.idVacuna = idVacuna;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.observaciones = observaciones;
        this.proximaFecha = proximaFecha;
    }

    public Integer getIdVacuna() {
        return idVacuna;
    }

    public void setIdVacuna(Integer idVacuna) {
        this.idVacuna = idVacuna;
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

    public String getProximaFecha() {
        return proximaFecha;
    }

    public void setProximaFecha(String proximaFecha) {
        this.proximaFecha = proximaFecha;
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
        hash += (idVacuna != null ? idVacuna.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vacuna)) {
            return false;
        }
        Vacuna other = (Vacuna) object;
        if ((this.idVacuna == null && other.idVacuna != null) || (this.idVacuna != null && !this.idVacuna.equals(other.idVacuna))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.modelo.pojos.Vacuna[ idVacuna=" + idVacuna + " ]";
    }
    
}
