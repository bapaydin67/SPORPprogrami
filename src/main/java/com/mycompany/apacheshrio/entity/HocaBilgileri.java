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
@Table(name = "HocaBilgileri")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HocaBilgileri.findAll", query = "SELECT h FROM HocaBilgileri h"),
    @NamedQuery(name = "HocaBilgileri.findById", query = "SELECT h FROM HocaBilgileri h WHERE h.id = :id"),
    @NamedQuery(name = "HocaBilgileri.findByHocaAdi", query = "SELECT h FROM HocaBilgileri h WHERE h.hocaAdi = :hocaAdi"),
    @NamedQuery(name = "HocaBilgileri.findByHocaSoyadi", query = "SELECT h FROM HocaBilgileri h WHERE h.hocaSoyadi = :hocaSoyadi"),
    @NamedQuery(name = "HocaBilgileri.findByHocaSeviye", query = "SELECT h FROM HocaBilgileri h WHERE h.hocaSeviye = :hocaSeviye")})
public class HocaBilgileri implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Size(min = 1, max = 50)
    @NotNull
    @Column(name = "HocaAdi")
    private String hocaAdi;

    @Size(min = 1, max = 50)
    @NotNull
    @Column(name = "HocaSoyadi")
    private String hocaSoyadi;

    @Size(min = 1, max = 250)
    @NotNull
    @Column(name = "HocaSeviye")
    private String hocaSeviye;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hocaId")
    private List<ProgramTablosu> programTablosuList;

    public HocaBilgileri() {
    }

    public HocaBilgileri(Integer id) {
        this.id = id;
    }

    public HocaBilgileri(Integer id, String hocaAdi, String hocaSoyadi, String hocaSeviye) {
        this.id = id;
        this.hocaAdi = hocaAdi;
        this.hocaSoyadi = hocaSoyadi;
        this.hocaSeviye = hocaSeviye;
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

    public String getHocaSoyadi() {
        return hocaSoyadi;
    }

    public void setHocaSoyadi(String hocaSoyadi) {
        this.hocaSoyadi = hocaSoyadi;
    }

    public String getHocaSeviye() {
        return hocaSeviye;
    }

    public void setHocaSeviye(String hocaSeviye) {
        this.hocaSeviye = hocaSeviye;
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
