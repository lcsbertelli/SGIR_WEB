/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lucas
 */
@Entity
@Table(name = "SOLICITA_SALA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SolicitaSala.findAll", query = "SELECT s FROM SolicitaSala s")
    , @NamedQuery(name = "SolicitaSala.findByDateSolicitacao", query = "SELECT s FROM SolicitaSala s WHERE s.dateSolicitacao = :dateSolicitacao")
    , @NamedQuery(name = "SolicitaSala.findByIdSolicitaSala", query = "SELECT s FROM SolicitaSala s WHERE s.idSolicitaSala = :idSolicitaSala")})
public class SolicitaSala implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_solicitacao")
    @Temporal(TemporalType.DATE)
    private Date dateSolicitacao;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_solicita_sala")
    private Integer idSolicitaSala;
    @JoinColumn(name = "id_disciplina", referencedColumnName = "id_disciplina")
    @ManyToOne
    private Disciplina idDisciplina;
    @JoinColumn(name = "id_prof", referencedColumnName = "id_usu")
    @ManyToOne(optional = false)
    private Usuario idProf;
    @JoinColumn(name = "id_sala", referencedColumnName = "id_sala")
    @ManyToOne(optional = false)
    private Sala idSala;

    public SolicitaSala() {
    }

    public SolicitaSala(Integer idSolicitaSala) {
        this.idSolicitaSala = idSolicitaSala;
    }

    public SolicitaSala(Integer idSolicitaSala, Date dateSolicitacao) {
        this.idSolicitaSala = idSolicitaSala;
        this.dateSolicitacao = dateSolicitacao;
    }

    public Date getDateSolicitacao() {
        return dateSolicitacao;
    }

    public void setDateSolicitacao(Date dateSolicitacao) {
        this.dateSolicitacao = dateSolicitacao;
    }

    public Integer getIdSolicitaSala() {
        return idSolicitaSala;
    }

    public void setIdSolicitaSala(Integer idSolicitaSala) {
        this.idSolicitaSala = idSolicitaSala;
    }

    public Disciplina getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Disciplina idDisciplina) {
        this.idDisciplina = idDisciplina;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSolicitaSala != null ? idSolicitaSala.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitaSala)) {
            return false;
        }
        SolicitaSala other = (SolicitaSala) object;
        if ((this.idSolicitaSala == null && other.idSolicitaSala != null) || (this.idSolicitaSala != null && !this.idSolicitaSala.equals(other.idSolicitaSala))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.SolicitaSala[ idSolicitaSala=" + idSolicitaSala + " ]";
    }
    
}
