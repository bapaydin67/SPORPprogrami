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
@Table(name = "KullaniciTablosu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KullaniciTablosu.findAll", query = "SELECT k FROM KullaniciTablosu k"),
    @NamedQuery(name = "KullaniciTablosu.findById", query = "SELECT k FROM KullaniciTablosu k WHERE k.id = :id"),
    @NamedQuery(name = "KullaniciTablosu.findByKullaniciAdi", query = "SELECT k FROM KullaniciTablosu k WHERE k.kullaniciAdi = :kullaniciAdi"),
    @NamedQuery(name = "KullaniciTablosu.findByKullaniciSifresi", query = "SELECT k FROM KullaniciTablosu k WHERE k.kullaniciSifresi = :kullaniciSifresi")})
public class KullaniciTablosu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "KullaniciAdi")
    private String kullaniciAdi;
    @Size(max = 255)
    @Column(name = "KullaniciSifresi")
    private String kullaniciSifresi;

    public KullaniciTablosu() {
    }

    public KullaniciTablosu(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getKullaniciSifresi() {
        return kullaniciSifresi;
    }

    public void setKullaniciSifresi(String kullaniciSifresi) {
        this.kullaniciSifresi = kullaniciSifresi;
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
        if (!(object instanceof KullaniciTablosu)) {
            return false;
        }
        KullaniciTablosu other = (KullaniciTablosu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.apacheshrio.entity.KullaniciTablosu[ id=" + id + " ]";
    }
    
}
