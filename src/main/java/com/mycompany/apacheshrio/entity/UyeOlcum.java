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
@Table(name = "UyeOlcum")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UyeOlcum.findAll", query = "SELECT u FROM UyeOlcum u"),
    @NamedQuery(name = "UyeOlcum.findById", query = "SELECT u FROM UyeOlcum u WHERE u.id = :id"),
    @NamedQuery(name = "UyeOlcum.findByBoyu", query = "SELECT u FROM UyeOlcum u WHERE u.boyu = :boyu"),
    @NamedQuery(name = "UyeOlcum.findByIdealKilosu", query = "SELECT u FROM UyeOlcum u WHERE u.idealKilosu = :idealKilosu"),
    @NamedQuery(name = "UyeOlcum.findByKasOrani", query = "SELECT u FROM UyeOlcum u WHERE u.kasOrani = :kasOrani"),
    @NamedQuery(name = "UyeOlcum.findByKilo", query = "SELECT u FROM UyeOlcum u WHERE u.kilo = :kilo"),
    @NamedQuery(name = "UyeOlcum.findByMetabolizmaYasi", query = "SELECT u FROM UyeOlcum u WHERE u.metabolizmaYasi = :metabolizmaYasi"),
    @NamedQuery(name = "UyeOlcum.findByTarih", query = "SELECT u FROM UyeOlcum u WHERE u.tarih = :tarih"),
    @NamedQuery(name = "UyeOlcum.findByYagOrani", query = "SELECT u FROM UyeOlcum u WHERE u.yagOrani = :yagOrani"),
    @NamedQuery(name = "UyeOlcum.findByUyeId", query = "SELECT u FROM UyeOlcum u WHERE u.uyeId = :uyeId")})
public class UyeOlcum implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "Boyu")
    private Integer boyu;
    @Column(name = "IdealKilosu")
    private Integer idealKilosu;
    @Size(max = 255)
    @Column(name = "KasOrani")
    private String kasOrani;
    @Column(name = "Kilo")
    private Integer kilo;
    @Column(name = "MetabolizmaYasi")
    private Integer metabolizmaYasi;
    @Size(max = 255)
    @Column(name = "Tarih")
    private String tarih;
    @Column(name = "YagOrani")
    private Integer yagOrani;
   
    @Column(name = "UyeId")
    private int uyeId;

    public UyeOlcum() {
    }

    public UyeOlcum(Integer id) {
        this.id = id;
    }

    public UyeOlcum(Integer id, int uyeId) {
        this.id = id;
        this.uyeId = uyeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBoyu() {
        return boyu;
    }

    public void setBoyu(Integer boyu) {
        this.boyu = boyu;
    }

    public Integer getIdealKilosu() {
        return idealKilosu;
    }

    public void setIdealKilosu(Integer idealKilosu) {
        this.idealKilosu = idealKilosu;
    }

    public String getKasOrani() {
        return kasOrani;
    }

    public void setKasOrani(String kasOrani) {
        this.kasOrani = kasOrani;
    }

    public Integer getKilo() {
        return kilo;
    }

    public void setKilo(Integer kilo) {
        this.kilo = kilo;
    }

    public Integer getMetabolizmaYasi() {
        return metabolizmaYasi;
    }

    public void setMetabolizmaYasi(Integer metabolizmaYasi) {
        this.metabolizmaYasi = metabolizmaYasi;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public Integer getYagOrani() {
        return yagOrani;
    }

    public void setYagOrani(Integer yagOrani) {
        this.yagOrani = yagOrani;
    }

    public int getUyeId() {
        return uyeId;
    }

    public void setUyeId(int uyeId) {
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
        if (!(object instanceof UyeOlcum)) {
            return false;
        }
        UyeOlcum other = (UyeOlcum) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.apacheshrio.entity.UyeOlcum[ id=" + id + " ]";
    }
    
}
