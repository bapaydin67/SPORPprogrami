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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "UyeOlcum.findByTarih", query = "SELECT u FROM UyeOlcum u WHERE u.tarih = :tarih"),
    @NamedQuery(name = "UyeOlcum.findByBoyu", query = "SELECT u FROM UyeOlcum u WHERE u.boyu = :boyu"),
    @NamedQuery(name = "UyeOlcum.findByKilo", query = "SELECT u FROM UyeOlcum u WHERE u.kilo = :kilo"),
    @NamedQuery(name = "UyeOlcum.findByYagOrani", query = "SELECT u FROM UyeOlcum u WHERE u.yagOrani = :yagOrani"),
    @NamedQuery(name = "UyeOlcum.findByKasOrani", query = "SELECT u FROM UyeOlcum u WHERE u.kasOrani = :kasOrani"),
    @NamedQuery(name = "UyeOlcum.findByMetabolizmaYasi", query = "SELECT u FROM UyeOlcum u WHERE u.metabolizmaYasi = :metabolizmaYasi"),
    @NamedQuery(name = "UyeOlcum.findByIdealKilosu", query = "SELECT u FROM UyeOlcum u WHERE u.idealKilosu = :idealKilosu")})
public class UyeOlcum implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Tarih")
    private String tarih;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Boyu")
    private int boyu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Kilo")
    private int kilo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "YagOrani")
    private int yagOrani;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "KasOrani")
    private String kasOrani;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MetabolizmaYasi")
    private int metabolizmaYasi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdealKilosu")
    private int idealKilosu;
    @JoinColumn(name = "UyeId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private UyeBilgisi uyeId;

    public UyeOlcum() {
    }

    public UyeOlcum(Integer id) {
        this.id = id;
    }

    public UyeOlcum(Integer id, String tarih, int boyu, int kilo, int yagOrani, String kasOrani, int metabolizmaYasi, int idealKilosu) {
        this.id = id;
        this.tarih = tarih;
        this.boyu = boyu;
        this.kilo = kilo;
        this.yagOrani = yagOrani;
        this.kasOrani = kasOrani;
        this.metabolizmaYasi = metabolizmaYasi;
        this.idealKilosu = idealKilosu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public int getBoyu() {
        return boyu;
    }

    public void setBoyu(int boyu) {
        this.boyu = boyu;
    }

    public int getKilo() {
        return kilo;
    }

    public void setKilo(int kilo) {
        this.kilo = kilo;
    }

    public int getYagOrani() {
        return yagOrani;
    }

    public void setYagOrani(int yagOrani) {
        this.yagOrani = yagOrani;
    }

    public String getKasOrani() {
        return kasOrani;
    }

    public void setKasOrani(String kasOrani) {
        this.kasOrani = kasOrani;
    }

    public int getMetabolizmaYasi() {
        return metabolizmaYasi;
    }

    public void setMetabolizmaYasi(int metabolizmaYasi) {
        this.metabolizmaYasi = metabolizmaYasi;
    }

    public int getIdealKilosu() {
        return idealKilosu;
    }

    public void setIdealKilosu(int idealKilosu) {
        this.idealKilosu = idealKilosu;
    }

    public UyeBilgisi getUyeId() {
        return uyeId;
    }

    public void setUyeId(UyeBilgisi uyeId) {
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
