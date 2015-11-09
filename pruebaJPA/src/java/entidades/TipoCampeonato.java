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
@Table(name = "tipo_campeonato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCampeonato.findAll", query = "SELECT t FROM TipoCampeonato t"),
    @NamedQuery(name = "TipoCampeonato.findByIdtipoCampeonato", query = "SELECT t FROM TipoCampeonato t WHERE t.idtipoCampeonato = :idtipoCampeonato"),
    @NamedQuery(name = "TipoCampeonato.findByNombre", query = "SELECT t FROM TipoCampeonato t WHERE t.nombre = :nombre")})
public class TipoCampeonato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipo_campeonato")
    private Integer idtipoCampeonato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoCampeonato")
    private Collection<Campeonato> campeonatoCollection;

    public TipoCampeonato() {
    }

    public TipoCampeonato(Integer idtipoCampeonato) {
        this.idtipoCampeonato = idtipoCampeonato;
    }

    public TipoCampeonato(Integer idtipoCampeonato, String nombre) {
        this.idtipoCampeonato = idtipoCampeonato;
        this.nombre = nombre;
    }

    public Integer getIdtipoCampeonato() {
        return idtipoCampeonato;
    }

    public void setIdtipoCampeonato(Integer idtipoCampeonato) {
        this.idtipoCampeonato = idtipoCampeonato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Campeonato> getCampeonatoCollection() {
        return campeonatoCollection;
    }

    public void setCampeonatoCollection(Collection<Campeonato> campeonatoCollection) {
        this.campeonatoCollection = campeonatoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoCampeonato != null ? idtipoCampeonato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCampeonato)) {
            return false;
        }
        TipoCampeonato other = (TipoCampeonato) object;
        if ((this.idtipoCampeonato == null && other.idtipoCampeonato != null) || (this.idtipoCampeonato != null && !this.idtipoCampeonato.equals(other.idtipoCampeonato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TipoCampeonato[ idtipoCampeonato=" + idtipoCampeonato + " ]";
    }
    
}
