/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.apacheshrio.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

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
    @NamedQuery(name = "UyeBilgisi.findByCinsiyet", query = "SELECT u FROM UyeBilgisi u WHERE u.cinsiyet = :cinsiyet"),
    @NamedQuery(name = "UyeBilgisi.findByDogumTarihi", query = "SELECT u FROM UyeBilgisi u WHERE u.dogumTarihi = :dogumTarihi"),
    @NamedQuery(name = "UyeBilgisi.findByEmail", query = "SELECT u FROM UyeBilgisi u WHERE u.email = :email"),
    @NamedQuery(name = "UyeBilgisi.findByTelefonNo", query = "SELECT u FROM UyeBilgisi u WHERE u.telefonNo = :telefonNo"),
    @NamedQuery(name = "UyeBilgisi.findByUyeAdi", query = "SELECT u FROM UyeBilgisi u WHERE u.uyeAdi = :uyeAdi"),
    @NamedQuery(name = "UyeBilgisi.findByUyeSoyadi", query = "SELECT u FROM UyeBilgisi u WHERE u.uyeSoyadi = :uyeSoyadi")})
public class UyeBilgisi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "Cinsiyet")
    private String cinsiyet;
    @Size(max = 255)
    @Column(name = "Dogum_Tarihi")
    private String dogumTarihi;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "Email")
    private String email;
    @Column(name = "TelefonNo")
    private Integer telefonNo;
    @Size(max = 255)
    @Column(name = "UyeAdi")
    private String uyeAdi;
    @Size(max = 255)
    @Column(name = "UyeSoyadi")
    private String uyeSoyadi;

    public UyeBilgisi() {
    }

    public UyeBilgisi(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(String dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTelefonNo() {
        return telefonNo;
    }

    public void setTelefonNo(Integer telefonNo) {
        this.telefonNo = telefonNo;
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
