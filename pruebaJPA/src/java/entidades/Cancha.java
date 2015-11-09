/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ingenieria
 */
@Entity
@Table(name = "cancha")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cancha.findAll", query = "SELECT c FROM Cancha c"),
    @NamedQuery(name = "Cancha.findByIdcancha", query = "SELECT c FROM Cancha c WHERE c.idcancha = :idcancha"),
    @NamedQuery(name = "Cancha.findByNombre", query = "SELECT c FROM Cancha c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Cancha.findByDireccion", query = "SELECT c FROM Cancha c WHERE c.direccion = :direccion")})
public class Cancha implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcancha")
    private Integer idcancha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "direccion")
    private String direccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcancha")
    private Collection<Partido> partidoCollection;

    public Cancha() {
    }

    public Cancha(Integer idcancha) {
        this.idcancha = idcancha;
    }

    public Cancha(Integer idcancha, String nombre, String direccion) {
        this.idcancha = idcancha;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Integer getIdcancha() {
        return idcancha;
    }

    public void setIdcancha(Integer idcancha) {
        this.idcancha = idcancha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @XmlTransient
    public Collection<Partido> getPartidoCollection() {
        return partidoCollection;
    }

    public void setPartidoCollection(Collection<Partido> partidoCollection) {
        this.partidoCollection = partidoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcancha != null ? idcancha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cancha)) {
            return false;
        }
        Cancha other = (Cancha) object;
        if ((this.idcancha == null && other.idcancha != null) || (this.idcancha != null && !this.idcancha.equals(other.idcancha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Cancha[ idcancha=" + idcancha + " ]";
    }
    
}
