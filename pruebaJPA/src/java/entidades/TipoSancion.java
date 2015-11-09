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
@Table(name = "tipo_sancion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoSancion.findAll", query = "SELECT t FROM TipoSancion t"),
    @NamedQuery(name = "TipoSancion.findByIdtipoSancion", query = "SELECT t FROM TipoSancion t WHERE t.idtipoSancion = :idtipoSancion"),
    @NamedQuery(name = "TipoSancion.findByNombre", query = "SELECT t FROM TipoSancion t WHERE t.nombre = :nombre")})
public class TipoSancion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipo_sancion")
    private Integer idtipoSancion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoSancion")
    private Collection<Sancion> sancionCollection;

    public TipoSancion() {
    }

    public TipoSancion(Integer idtipoSancion) {
        this.idtipoSancion = idtipoSancion;
    }

    public TipoSancion(Integer idtipoSancion, String nombre) {
        this.idtipoSancion = idtipoSancion;
        this.nombre = nombre;
    }

    public Integer getIdtipoSancion() {
        return idtipoSancion;
    }

    public void setIdtipoSancion(Integer idtipoSancion) {
        this.idtipoSancion = idtipoSancion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Sancion> getSancionCollection() {
        return sancionCollection;
    }

    public void setSancionCollection(Collection<Sancion> sancionCollection) {
        this.sancionCollection = sancionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoSancion != null ? idtipoSancion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoSancion)) {
            return false;
        }
        TipoSancion other = (TipoSancion) object;
        if ((this.idtipoSancion == null && other.idtipoSancion != null) || (this.idtipoSancion != null && !this.idtipoSancion.equals(other.idtipoSancion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TipoSancion[ idtipoSancion=" + idtipoSancion + " ]";
    }
    
}
