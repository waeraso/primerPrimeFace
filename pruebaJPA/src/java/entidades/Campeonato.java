/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ingenieria
 */
@Entity
@Table(name = "campeonato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Campeonato.findAll", query = "SELECT c FROM Campeonato c"),
    @NamedQuery(name = "Campeonato.findByIdcampeonato", query = "SELECT c FROM Campeonato c WHERE c.idcampeonato = :idcampeonato"),
    @NamedQuery(name = "Campeonato.findByDescripcion", query = "SELECT c FROM Campeonato c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "Campeonato.findByFechaInicio", query = "SELECT c FROM Campeonato c WHERE c.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Campeonato.findByFechaFin", query = "SELECT c FROM Campeonato c WHERE c.fechaFin = :fechaFin")})
public class Campeonato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcampeonato")
    private Integer idcampeonato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcampeonato")
    private Collection<Grupo> grupoCollection;
    @JoinColumn(name = "tipo_campeonato", referencedColumnName = "idtipo_campeonato")
    @ManyToOne(optional = false)
    private TipoCampeonato tipoCampeonato;

    public Campeonato() {
    }

    public Campeonato(Integer idcampeonato) {
        this.idcampeonato = idcampeonato;
    }

    public Campeonato(Integer idcampeonato, String descripcion, Date fechaInicio, Date fechaFin) {
        this.idcampeonato = idcampeonato;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Integer getIdcampeonato() {
        return idcampeonato;
    }

    public void setIdcampeonato(Integer idcampeonato) {
        this.idcampeonato = idcampeonato;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @XmlTransient
    public Collection<Grupo> getGrupoCollection() {
        return grupoCollection;
    }

    public void setGrupoCollection(Collection<Grupo> grupoCollection) {
        this.grupoCollection = grupoCollection;
    }

    public TipoCampeonato getTipoCampeonato() {
        return tipoCampeonato;
    }

    public void setTipoCampeonato(TipoCampeonato tipoCampeonato) {
        this.tipoCampeonato = tipoCampeonato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcampeonato != null ? idcampeonato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Campeonato)) {
            return false;
        }
        Campeonato other = (Campeonato) object;
        if ((this.idcampeonato == null && other.idcampeonato != null) || (this.idcampeonato != null && !this.idcampeonato.equals(other.idcampeonato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Campeonato[ idcampeonato=" + idcampeonato + " ]";
    }
    
}
