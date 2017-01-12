/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lucas
 */
@Entity
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByIdUsu", query = "SELECT u FROM Usuario u WHERE u.idUsu = :idUsu")
    , @NamedQuery(name = "Usuario.findByNome", query = "SELECT u FROM Usuario u WHERE u.nome = :nome")
    , @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email")
    , @NamedQuery(name = "Usuario.findBySenha", query = "SELECT u FROM Usuario u WHERE u.senha = :senha")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usu")
    private Integer idUsu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nome")
    private String nome;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "senha")
    private String senha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProf")
    private Collection<SolicitaEquipamento> solicitaEquipamentoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProf")
    private Collection<SolicitaSala> solicitaSalaCollection;
    @JoinColumn(name = "id_tipo_usuario", referencedColumnName = "id_tipo_usuario")
    @ManyToOne(optional = false)
    private TipoUsuario idTipoUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAssistente")
    private Collection<ControleEquipamentos> controleEquipamentosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGerente")
    private Collection<ReservaEquipamento> reservaEquipamentoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProf")
    private Collection<ReservaEquipamento> reservaEquipamentoCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGerente")
    private Collection<ReservaSala> reservaSalaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProf")
    private Collection<ReservaSala> reservaSalaCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAssistente")
    private Collection<ControleChavesSala> controleChavesSalaCollection;

    public Usuario() {
    }

    public Usuario(Integer idUsu) {
        this.idUsu = idUsu;
    }

    public Usuario(Integer idUsu, String nome, String email, String senha) {
        this.idUsu = idUsu;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Integer getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(Integer idUsu) {
        this.idUsu = idUsu;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @XmlTransient
    public Collection<SolicitaEquipamento> getSolicitaEquipamentoCollection() {
        return solicitaEquipamentoCollection;
    }

    public void setSolicitaEquipamentoCollection(Collection<SolicitaEquipamento> solicitaEquipamentoCollection) {
        this.solicitaEquipamentoCollection = solicitaEquipamentoCollection;
    }

    @XmlTransient
    public Collection<SolicitaSala> getSolicitaSalaCollection() {
        return solicitaSalaCollection;
    }

    public void setSolicitaSalaCollection(Collection<SolicitaSala> solicitaSalaCollection) {
        this.solicitaSalaCollection = solicitaSalaCollection;
    }

    public TipoUsuario getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(TipoUsuario idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    @XmlTransient
    public Collection<ControleEquipamentos> getControleEquipamentosCollection() {
        return controleEquipamentosCollection;
    }

    public void setControleEquipamentosCollection(Collection<ControleEquipamentos> controleEquipamentosCollection) {
        this.controleEquipamentosCollection = controleEquipamentosCollection;
    }

    @XmlTransient
    public Collection<ReservaEquipamento> getReservaEquipamentoCollection() {
        return reservaEquipamentoCollection;
    }

    public void setReservaEquipamentoCollection(Collection<ReservaEquipamento> reservaEquipamentoCollection) {
        this.reservaEquipamentoCollection = reservaEquipamentoCollection;
    }

    @XmlTransient
    public Collection<ReservaEquipamento> getReservaEquipamentoCollection1() {
        return reservaEquipamentoCollection1;
    }

    public void setReservaEquipamentoCollection1(Collection<ReservaEquipamento> reservaEquipamentoCollection1) {
        this.reservaEquipamentoCollection1 = reservaEquipamentoCollection1;
    }

    @XmlTransient
    public Collection<ReservaSala> getReservaSalaCollection() {
        return reservaSalaCollection;
    }

    public void setReservaSalaCollection(Collection<ReservaSala> reservaSalaCollection) {
        this.reservaSalaCollection = reservaSalaCollection;
    }

    @XmlTransient
    public Collection<ReservaSala> getReservaSalaCollection1() {
        return reservaSalaCollection1;
    }

    public void setReservaSalaCollection1(Collection<ReservaSala> reservaSalaCollection1) {
        this.reservaSalaCollection1 = reservaSalaCollection1;
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
        hash += (idUsu != null ? idUsu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsu == null && other.idUsu != null) || (this.idUsu != null && !this.idUsu.equals(other.idUsu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "jpa.entities.Usuario[ idUsu=" + idUsu + " ]";
        return this.nome;
    }
    
}
