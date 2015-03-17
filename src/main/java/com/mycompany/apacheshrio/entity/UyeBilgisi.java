/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.apacheshrio.entity;

import java.io.Serializable;
import java.util.List;
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
 * @author Batuhan
 */
@Entity
@Table(name = "UyeBilgisi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UyeBilgisi.findAll", query = "SELECT u FROM UyeBilgisi u"),
    @NamedQuery(name = "UyeBilgisi.findById", query = "SELECT u FROM UyeBilgisi u WHERE u.id = :id"),
    @NamedQuery(name = "UyeBilgisi.findByUyeAdi", query = "SELECT u FROM UyeBilgisi u WHERE u.uyeAdi = :uyeAdi"),
    @NamedQuery(name = "UyeBilgisi.findByUyeSoyadi", query = "SELECT u FROM UyeBilgisi u WHERE u.uyeSoyadi = :uyeSoyadi"),
    @NamedQuery(name = "UyeBilgisi.findByDogumTarihi", query = "SELECT u FROM UyeBilgisi u WHERE u.dogumTarihi = :dogumTarihi"),
    @NamedQuery(name = "UyeBilgisi.findByTelefonNo", query = "SELECT u FROM UyeBilgisi u WHERE u.telefonNo = :telefonNo"),
    @NamedQuery(name = "UyeBilgisi.findByEmail", query = "SELECT u FROM UyeBilgisi u WHERE u.email = :email"),
    @NamedQuery(name = "UyeBilgisi.findByCinsiyet", query = "SELECT u FROM UyeBilgisi u WHERE u.cinsiyet = :cinsiyet")})
public class UyeBilgisi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "Id")
    private Integer id;
  
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "UyeAdi")
    private String uyeAdi;
   
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "UyeSoyadi")
    private String uyeSoyadi;
  
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Dogum_Tarihi")
    private String dogumTarihi;
   
    @NotNull
    @Column(name = "TelefonNo")
    private int telefonNo;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
   
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Email")
    private String email;
   
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Cinsiyet")
    private String cinsiyet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uyeId")
    private List<UyeOlcum> uyeOlcumList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uyeId")
    private List<ProgramTablosu> programTablosuList;

    public UyeBilgisi() {
    }

    public UyeBilgisi(Integer id) {
        this.id = id;
    }

    public UyeBilgisi(Integer id, String uyeAdi, String uyeSoyadi, String dogumTarihi, int telefonNo, String email, String cinsiyet) {
        this.id = id;
        this.uyeAdi = uyeAdi;
        this.uyeSoyadi = uyeSoyadi;
        this.dogumTarihi = dogumTarihi;
        this.telefonNo = telefonNo;
        this.email = email;
        this.cinsiyet = cinsiyet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUyeAdi() {
        return uyeAdi;
    }

    public void setUyeAdi(String uyeAdi) {
        this.uyeAdi = uyeAdi;
    }

    public String getUyeSoyadi() {
        return uyeSoyadi;
    }

    public void setUyeSoyadi(String uyeSoyadi) {
        this.uyeSoyadi = uyeSoyadi;
    }

    public String getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(String dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public int getTelefonNo() {
        return telefonNo;
    }

    public void setTelefonNo(int telefonNo) {
        this.telefonNo = telefonNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    @XmlTransient
    public List<UyeOlcum> getUyeOlcumList() {
        return uyeOlcumList;
    }

    public void setUyeOlcumList(List<UyeOlcum> uyeOlcumList) {
        this.uyeOlcumList = uyeOlcumList;
    }

    @XmlTransient
    public List<ProgramTablosu> getProgramTablosuList() {
        return programTablosuList;
    }

    public void setProgramTablosuList(List<ProgramTablosu> programTablosuList) {
        this.programTablosuList = programTablosuList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UyeBilgisi)) {
            return false;
        }
        UyeBilgisi other = (UyeBilgisi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.apacheshrio.entity.UyeBilgisi[ id=" + id + " ]";
    }
    
}
