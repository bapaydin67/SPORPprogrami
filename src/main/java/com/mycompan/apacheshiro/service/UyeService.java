/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompan.apacheshiro.service;

import com.mycompany.apacheshrio.entity.UyeBilgisi;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class UyeService {

    @PersistenceContext(unitName = "com.mycompany_ApacheShiro_war_1.0-SNAPSHOTPU")
    EntityManager entityManager;

    public boolean UYEKAYITYAP(UyeBilgisi uyeBilgisi) {
        try {
            entityManager.persist(uyeBilgisi);
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return false;
        }
    }

    public List<UyeBilgisi> uyeleriGetir() {
        List<UyeBilgisi> uyeListesi = new ArrayList<>();
        Query query = entityManager.createQuery("Select U from UyeBilgisi U");
        try {
            uyeListesi = query.getResultList();
            return uyeListesi;
        } catch (NoResultException nre) {
            nre.printStackTrace(System.out);
            return null;
        } catch (NonUniqueResultException nue) {
            return (List<UyeBilgisi>) query.getResultList().get(0);
        }
    }
    
    
    public boolean uyeBilgisiGuncele(UyeBilgisi uyeBilgisi) {
        try {
            entityManager.merge(uyeBilgisi);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            return false;
        }

    }


    public boolean uyeBilgisiSil(UyeBilgisi uyeBilgisi) {
        try {
            uyeBilgisi = entityManager.merge(uyeBilgisi);
            entityManager.remove(uyeBilgisi);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
