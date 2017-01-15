/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lucas
 */
@Entity
@Table(name = "RESERVA_SALA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReservaSala.findAll", query = "SELECT r FROM ReservaSala r")
    , @NamedQuery(name = "ReservaSala.findByIdReservaSala", query = "SELECT r FROM ReservaSala r WHERE r.idReservaSala = :idReservaSala")
    , @NamedQuery(name = "ReservaSala.findByDateReserva", query = "SELECT r FROM ReservaSala r WHERE r.dateReserva = :dateReserva")})
public class ReservaSala implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "date_rerva_fim")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRervaFim;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_reserva_sala")
    private Integer idReservaSala;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_reserva")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateReserva;
    @JoinColumn(name = "id_disciplina", referencedColumnName = "id_disciplina")
    @ManyToOne
    private Disciplina idDisciplina;
    @JoinColumn(name = "id_gerente", referencedColumnName = "id_usu")
    @ManyToOne(optional = false)
    private Usuario idGerente;
    @JoinColumn(name = "id_prof", referencedColumnName = "id_usu")
    @ManyToOne(optional = false)
    private Usuario idProf;
    @JoinColumn(name = "id_sala", referencedColumnName = "id_sala")
    @ManyToOne(optional = false)
    private Sala idSala;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idReservaSala")
    private Collection<ControleChavesSala> controleChavesSalaCollection;

    public ReservaSala() {
    }

    public ReservaSala(Integer idReservaSala) {
        this.idReservaSala = idReservaSala;
    }

    public ReservaSala(Integer idReservaSala, Date dateReserva) {
        this.idReservaSala = idReservaSala;
        this.dateReserva = dateReserva;
    }

    public Integer getIdReservaSala() {
        return idReservaSala;
    }

    public void setIdReservaSala(Integer idReservaSala) {
        this.idReservaSala = idReservaSala;
    }

    public Date getDateReserva() {
        return dateReserva;
    }

    public void setDateReserva(Date dateReserva) {
        this.dateReserva = dateReserva;
    }

    public Disciplina getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Disciplina idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public Usuario getIdGerente() {
        return idGerente;
    }

    public void setIdGerente(Usuario idGerente) {
        this.idGerente = idGerente;
    }

    public Usuario getIdProf() {
        return idProf;
    }

    public void setIdProf(Usuario idProf) {
        this.idProf = idProf;
    }

    public Sala getIdSala() {
        return idSala;
    }

    public void setIdSala(Sala idSala) {
        this.idSala = idSala;
    }

    @XmlTransient
    public Collection<ControleChavesSala> getControleChavesSalaCollection() {
        return controleChavesSalaCollection;
    }

    public void setControleChavesSalaCollection(Collection<ControleChavesSala> controleChavesSalaCollection) {
        this.controleChavesSalaCollection = controleChavesSalaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReservaSala != null ? idReservaSala.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservaSala)) {
            return false;
        }
        ReservaSala other = (ReservaSala) object;
        if ((this.idReservaSala == null && other.idReservaSala != null) || (this.idReservaSala != null && !this.idReservaSala.equals(other.idReservaSala))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "jpa.entities.ReservaSala[ idReservaSala=" + idReservaSala + " ]";
        return " "+ this.dateReserva;
    }

    public Date getDateRervaFim() {
        return dateRervaFim;
    }

    public void setDateRervaFim(Date dateRervaFim) {
        this.dateRervaFim = dateRervaFim;
    }
    
}
