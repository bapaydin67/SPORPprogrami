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
@Table(name = "HocaBilgileri")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HocaBilgileri.findAll", query = "SELECT h FROM HocaBilgileri h"),
    @NamedQuery(name = "HocaBilgileri.findById", query = "SELECT h FROM HocaBilgileri h WHERE h.id = :id"),
    @NamedQuery(name = "HocaBilgileri.findByHocaAdi", query = "SELECT h FROM HocaBilgileri h WHERE h.hocaAdi = :hocaAdi"),
    @NamedQuery(name = "HocaBilgileri.findByHocaSeviye", query = "SELECT h FROM HocaBilgileri h WHERE h.hocaSeviye = :hocaSeviye"),
    @NamedQuery(name = "HocaBilgileri.findByHocaSoyadi", query = "SELECT h FROM HocaBilgileri h WHERE h.hocaSoyadi = :hocaSoyadi")})
public class HocaBilgileri implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "HocaAdi")
    private String hocaAdi;
    @Size(max = 255)
    @Column(name = "HocaSeviye")
    private String hocaSeviye;
    @Size(max = 255)
    @Column(name = "HocaSoyadi")
    private String hocaSoyadi;

    public HocaBilgileri() {
    }

    public HocaBilgileri(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHocaAdi() {
        return hocaAdi;
    }

    public void setHocaAdi(String hocaAdi) {
        this.hocaAdi = hocaAdi;
    }

    public String getHocaSeviye() {
        return hocaSeviye;
    }

    public void setHocaSeviye(String hocaSeviye) {
        this.hocaSeviye = hocaSeviye;
    }

    public String getHocaSoyadi() {
        return hocaSoyadi;
    }

    public void setHocaSoyadi(String hocaSoyadi) {
        this.hocaSoyadi = hocaSoyadi;
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
        if (!(object instanceof HocaBilgileri)) {
            return false;
        }
        HocaBilgileri other = (HocaBilgileri) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.apacheshrio.entity.HocaBilgileri[ id=" + id + " ]";
    }
    
}
