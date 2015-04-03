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
@Table(name = "HareketTablosu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HareketTablosu.findAll", query = "SELECT h FROM HareketTablosu h"),
    @NamedQuery(name = "HareketTablosu.findById", query = "SELECT h FROM HareketTablosu h WHERE h.id = :id"),
    @NamedQuery(name = "HareketTablosu.findByBolgeAdi", query = "SELECT h FROM HareketTablosu h WHERE h.bolgeAdi = :bolgeAdi"),
    @NamedQuery(name = "HareketTablosu.findByHareketAdi", query = "SELECT h FROM HareketTablosu h WHERE h.hareketAdi = :hareketAdi")})
public class HareketTablosu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "BolgeAdi")
    private String bolgeAdi;
    @Size(max = 255)
    @Column(name = "HareketAdi")
    private String hareketAdi;

    public HareketTablosu() {
    }

    public HareketTablosu(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBolgeAdi() {
        return bolgeAdi;
    }

    public void setBolgeAdi(String bolgeAdi) {
        this.bolgeAdi = bolgeAdi;
    }

    public String getHareketAdi() {
        return hareketAdi;
    }

    public void setHareketAdi(String hareketAdi) {
        this.hareketAdi = hareketAdi;
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
        if (!(object instanceof HareketTablosu)) {
            return false;
        }
        HareketTablosu other = (HareketTablosu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.apacheshrio.entity.HareketTablosu[ id=" + id + " ]";
    }
    
}
