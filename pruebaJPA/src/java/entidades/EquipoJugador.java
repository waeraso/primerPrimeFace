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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ingenieria
 */
@Entity
@Table(name = "equipo_jugador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EquipoJugador.findAll", query = "SELECT e FROM EquipoJugador e"),
    @NamedQuery(name = "EquipoJugador.findByIdEquipoJugador", query = "SELECT e FROM EquipoJugador e WHERE e.idEquipoJugador = :idEquipoJugador")})
public class EquipoJugador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_equipo_jugador")
    private Integer idEquipoJugador;
    @JoinColumn(name = "idequipo", referencedColumnName = "idequipo")
    @ManyToOne(optional = false)
    private Equipo idequipo;
    @JoinColumn(name = "idjugador", referencedColumnName = "idjugador")
    @ManyToOne(optional = false)
    private Jugador idjugador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipoJugador")
    private Collection<Gol> golCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquipoJugado")
    private Collection<Sancion> sancionCollection;

    public EquipoJugador() {
    }

    public EquipoJugador(Integer idEquipoJugador) {
        this.idEquipoJugador = idEquipoJugador;
    }

    public Integer getIdEquipoJugador() {
        return idEquipoJugador;
    }

    public void setIdEquipoJugador(Integer idEquipoJugador) {
        this.idEquipoJugador = idEquipoJugador;
    }

    public Equipo getIdequipo() {
        return idequipo;
    }

    public void setIdequipo(Equipo idequipo) {
        this.idequipo = idequipo;
    }

    public Jugador getIdjugador() {
        return idjugador;
    }

    public void setIdjugador(Jugador idjugador) {
        this.idjugador = idjugador;
    }

    @XmlTransient
    public Collection<Gol> getGolCollection() {
        return golCollection;
    }

    public void setGolCollection(Collection<Gol> golCollection) {
        this.golCollection = golCollection;
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
        hash += (idEquipoJugador != null ? idEquipoJugador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EquipoJugador)) {
            return false;
        }
        EquipoJugador other = (EquipoJugador) object;
        if ((this.idEquipoJugador == null && other.idEquipoJugador != null) || (this.idEquipoJugador != null && !this.idEquipoJugador.equals(other.idEquipoJugador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.EquipoJugador[ idEquipoJugador=" + idEquipoJugador + " ]";
    }
    
}
