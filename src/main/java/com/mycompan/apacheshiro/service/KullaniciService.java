/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompan.apacheshiro.service;

import com.mycompany.apacheshrio.entity.KullaniciTablosu;
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
public class KullaniciService {

    @PersistenceContext(unitName = "com.mycompany_ApacheShiro_war_1.0-SNAPSHOTPU")
    EntityManager entityManager;

    public boolean kullaniciEkle(KullaniciTablosu kullaniciTablosu) {
        try {
            entityManager.persist(kullaniciTablosu);
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return false;
        }
    }

    public List<KullaniciTablosu> kullaniciTablosunuGetir() {
        List<KullaniciTablosu> kullaniciListesi = new ArrayList<>();
        Query query = entityManager.createQuery("SELECT k FROM KullaniciTablosu k");
        try {
            kullaniciListesi = query.getResultList();
            return kullaniciListesi;
        } catch (NoResultException nre) {
            nre.printStackTrace(System.out);
            return null;
        } catch (NonUniqueResultException nue) {
            return (List<KullaniciTablosu>) query.getResultList().get(0);
        }
    }

    public boolean kullaniciGuncelle(KullaniciTablosu kullaniciTablosu) {
        try {
            entityManager.merge(kullaniciTablosu);
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return false;
        }
    }

    public boolean kullaniciSil(KullaniciTablosu kullaniciTablosu) {
        try {
            kullaniciTablosu = entityManager.merge(kullaniciTablosu);
            entityManager.remove(kullaniciTablosu);
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return false;
        }
    }
}
