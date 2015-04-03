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
@Table(name = "GunlerTablosu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GunlerTablosu.findAll", query = "SELECT g FROM GunlerTablosu g"),
    @NamedQuery(name = "GunlerTablosu.findById", query = "SELECT g FROM GunlerTablosu g WHERE g.id = :id"),
    @NamedQuery(name = "GunlerTablosu.findByGunAdi", query = "SELECT g FROM GunlerTablosu g WHERE g.gunAdi = :gunAdi")})
public class GunlerTablosu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "GunAdi")
    private String gunAdi;

    public GunlerTablosu() {
    }

    public GunlerTablosu(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGunAdi() {
        return gunAdi;
    }

    public void setGunAdi(String gunAdi) {
        this.gunAdi = gunAdi;
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
        if (!(object instanceof GunlerTablosu)) {
            return false;
        }
        GunlerTablosu other = (GunlerTablosu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.apacheshrio.entity.GunlerTablosu[ id=" + id + " ]";
    }
    
}
