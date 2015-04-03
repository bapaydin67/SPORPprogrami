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
@Table(name = "ProgramTablosu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProgramTablosu.findAll", query = "SELECT p FROM ProgramTablosu p"),
    @NamedQuery(name = "ProgramTablosu.findById", query = "SELECT p FROM ProgramTablosu p WHERE p.id = :id"),
    @NamedQuery(name = "ProgramTablosu.findByBolgeAdi", query = "SELECT p FROM ProgramTablosu p WHERE p.bolgeAdi = :bolgeAdi"),
    @NamedQuery(name = "ProgramTablosu.findByGunAdi", query = "SELECT p FROM ProgramTablosu p WHERE p.gunAdi = :gunAdi"),
    @NamedQuery(name = "ProgramTablosu.findByHareketAdi", query = "SELECT p FROM ProgramTablosu p WHERE p.hareketAdi = :hareketAdi"),
    @NamedQuery(name = "ProgramTablosu.findByProgramTarihi", query = "SELECT p FROM ProgramTablosu p WHERE p.programTarihi = :programTarihi"),
    @NamedQuery(name = "ProgramTablosu.findBySetSayisi", query = "SELECT p FROM ProgramTablosu p WHERE p.setSayisi = :setSayisi"),
    @NamedQuery(name = "ProgramTablosu.findByTekrarSayisi", query = "SELECT p FROM ProgramTablosu p WHERE p.tekrarSayisi = :tekrarSayisi"),
    @NamedQuery(name = "ProgramTablosu.findByHocaId", query = "SELECT p FROM ProgramTablosu p WHERE p.hocaId = :hocaId"),
    @NamedQuery(name = "ProgramTablosu.findByUyeId", query = "SELECT p FROM ProgramTablosu p WHERE p.uyeId = :uyeId")})
public class ProgramTablosu implements Serializable {
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
    @Column(name = "GunAdi")
    private String gunAdi;
    @Size(max = 255)
    @Column(name = "HareketAdi")
    private String hareketAdi;
    @Size(max = 255)
    @Column(name = "ProgramTarihi")
    private String programTarihi;
    @Column(name = "SetSayisi")
    private Integer setSayisi;
    @Column(name = "TekrarSayisi")
    private Integer tekrarSayisi;
    @Column(name = "HocaId")
    private Integer hocaId;
    @Column(name = "UyeId")
    private Integer uyeId;

    public ProgramTablosu() {
    }

    public ProgramTablosu(Integer id) {
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

    public String getGunAdi() {
        return gunAdi;
    }

    public void setGunAdi(String gunAdi) {
        this.gunAdi = gunAdi;
    }

    public String getHareketAdi() {
        return hareketAdi;
    }

    public void setHareketAdi(String hareketAdi) {
        this.hareketAdi = hareketAdi;
    }

    public String getProgramTarihi() {
        return programTarihi;
    }

    public void setProgramTarihi(String programTarihi) {
        this.programTarihi = programTarihi;
    }

    public Integer getSetSayisi() {
        return setSayisi;
    }

    public void setSetSayisi(Integer setSayisi) {
        this.setSayisi = setSayisi;
    }

    public Integer getTekrarSayisi() {
        return tekrarSayisi;
    }

    public void setTekrarSayisi(Integer tekrarSayisi) {
        this.tekrarSayisi = tekrarSayisi;
    }

    public Integer getHocaId() {
        return hocaId;
    }

    public void setHocaId(Integer hocaId) {
        this.hocaId = hocaId;
    }

    public Integer getUyeId() {
        return uyeId;
    }

    public void setUyeId(Integer uyeId) {
        this.uyeId = uyeId;
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
        if (!(object instanceof ProgramTablosu)) {
            return false;
        }
        ProgramTablosu other = (ProgramTablosu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.apacheshrio.entity.ProgramTablosu[ id=" + id + " ]";
    }
    
}
