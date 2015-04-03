/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompan.apacheshiro.service;

import com.mycompany.apacheshrio.entity.HocaBilgileri;
import com.mycompany.apacheshrio.entity.UyeBilgisi;
import com.mycompany.apacheshrio.entity.UyeOlcum;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Batuhan
 */
@Stateless
public class UyeOlcumService implements Serializable {

    @PersistenceContext(unitName = "com.mycompany_ApacheShiro_war_1.0-SNAPSHOTPU")
    EntityManager entityManager;

    public boolean uyeOlcumKayit(UyeOlcum uyeOlcum) {
        try {
            entityManager.persist(uyeOlcum);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            return false;
        }
    }

    public List<UyeBilgisi> uyeleriIsmeGoreGetir(UyeBilgisi uyeBilgisi) {
        List<UyeBilgisi> uyeIsımListesi = new ArrayList<>();
        Query query = entityManager.createQuery("Select U from UyeBilgisi U where U.uyeAdi=:uyeAdiParam");
        try {
            query.setParameter("uyeAdiParam", uyeBilgisi.getUyeAdi().toString());
            uyeIsımListesi = query.getResultList();
            return uyeIsımListesi;
        } catch (NoResultException nre) {
            nre.printStackTrace(System.out);
            return null;
        } catch (NonUniqueResultException nue) {
            return (List<UyeBilgisi>) query.getResultList().get(0);
        }
    }

    public List<UyeOlcum> uyeOlcumBilgileriniGetir() {
        List<UyeOlcum> uyeOlcumBilgileri = new ArrayList<>();
        Query query = entityManager.createQuery("SELECT u FROM UyeOlcum u");
        try {
            uyeOlcumBilgileri = query.getResultList();
            return uyeOlcumBilgileri;
        } catch (NoResultException nre) {
            nre.printStackTrace(System.out);
            return null;
        } catch (NonUniqueResultException nue) {
            return (List<UyeOlcum>) query.getResultList().get(0);
        }
    }


    public boolean uyeOlcumGuncelle(UyeOlcum uyeOlcum) {
        try {
            entityManager.merge(uyeOlcum);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }

}
