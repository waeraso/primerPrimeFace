/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ingenieria
 */
@Entity
@Table(name = "gol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gol.findAll", query = "SELECT g FROM Gol g"),
    @NamedQuery(name = "Gol.findByIdgol", query = "SELECT g FROM Gol g WHERE g.idgol = :idgol")})
public class Gol implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idgol")
    private Integer idgol;
    @JoinColumn(name = "equipo_jugador", referencedColumnName = "id_equipo_jugador")
    @ManyToOne(optional = false)
    private EquipoJugador equipoJugador;
    @JoinColumn(name = "idpartido", referencedColumnName = "idpartido")
    @ManyToOne(optional = false)
    private Partido idpartido;

    public Gol() {
    }

    public Gol(Integer idgol) {
        this.idgol = idgol;
    }

    public Integer getIdgol() {
        return idgol;
    }

    public void setIdgol(Integer idgol) {
        this.idgol = idgol;
    }

    public EquipoJugador getEquipoJugador() {
        return equipoJugador;
    }

    public void setEquipoJugador(EquipoJugador equipoJugador) {
        this.equipoJugador = equipoJugador;
    }

    public Partido getIdpartido() {
        return idpartido;
    }

    public void setIdpartido(Partido idpartido) {
        this.idpartido = idpartido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgol != null ? idgol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gol)) {
            return false;
        }
        Gol other = (Gol) object;
        if ((this.idgol == null && other.idgol != null) || (this.idgol != null && !this.idgol.equals(other.idgol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Gol[ idgol=" + idgol + " ]";
    }
    
}
