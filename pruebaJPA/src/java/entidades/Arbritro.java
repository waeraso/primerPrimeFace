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
@Table(name = "arbritro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Arbritro.findAll", query = "SELECT a FROM Arbritro a"),
    @NamedQuery(name = "Arbritro.findByIdarbritro", query = "SELECT a FROM Arbritro a WHERE a.idarbritro = :idarbritro"),
    @NamedQuery(name = "Arbritro.findByNombre", query = "SELECT a FROM Arbritro a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Arbritro.findByApellido", query = "SELECT a FROM Arbritro a WHERE a.apellido = :apellido"),
    @NamedQuery(name = "Arbritro.findByFechaNacimiento", query = "SELECT a FROM Arbritro a WHERE a.fechaNacimiento = :fechaNacimiento")})
public class Arbritro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idarbritro")
    private Integer idarbritro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "arbritroCentral")
    private Collection<Partido> partidoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idarbritro1")
    private Collection<Partido> partidoCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idarbritro2")
    private Collection<Partido> partidoCollection2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idarbritro3")
    private Collection<Partido> partidoCollection3;

    public Arbritro() {
    }

    public Arbritro(Integer idarbritro) {
        this.idarbritro = idarbritro;
    }

    public Arbritro(Integer idarbritro, String nombre, String apellido, Date fechaNacimiento) {
        this.idarbritro = idarbritro;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getIdarbritro() {
        return idarbritro;
    }

    public void setIdarbritro(Integer idarbritro) {
        this.idarbritro = idarbritro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @XmlTransient
    public Collection<Partido> getPartidoCollection() {
        return partidoCollection;
    }

    public void setPartidoCollection(Collection<Partido> partidoCollection) {
        this.partidoCollection = partidoCollection;
    }

    @XmlTransient
    public Collection<Partido> getPartidoCollection1() {
        return partidoCollection1;
    }

    public void setPartidoCollection1(Collection<Partido> partidoCollection1) {
        this.partidoCollection1 = partidoCollection1;
    }

    @XmlTransient
    public Collection<Partido> getPartidoCollection2() {
        return partidoCollection2;
    }

    public void setPartidoCollection2(Collection<Partido> partidoCollection2) {
        this.partidoCollection2 = partidoCollection2;
    }

    @XmlTransient
    public Collection<Partido> getPartidoCollection3() {
        return partidoCollection3;
    }

    public void setPartidoCollection3(Collection<Partido> partidoCollection3) {
        this.partidoCollection3 = partidoCollection3;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idarbritro != null ? idarbritro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Arbritro)) {
            return false;
        }
        Arbritro other = (Arbritro) object;
        if ((this.idarbritro == null && other.idarbritro != null) || (this.idarbritro != null && !this.idarbritro.equals(other.idarbritro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Arbritro[ idarbritro=" + idarbritro + " ]";
    }
    
}
