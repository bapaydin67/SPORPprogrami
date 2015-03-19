/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompan.apacheshiro.service;

import com.mycompany.apacheshrio.entity.HocaBilgileri;
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
public class HocaService {

    @PersistenceContext(unitName = "com.mycompany_ApacheShiro_war_1.0-SNAPSHOTPU")
    EntityManager entityManager;

    public boolean hocaEkle(HocaBilgileri hocaBilgileri) {
        try {
            entityManager.persist(hocaBilgileri);
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return false;
        }

    }

    public List<HocaBilgileri> hocaBilgileriGetir() {
        List<HocaBilgileri> hocaListesi = new ArrayList<>();
        Query query = entityManager.createQuery("SELECT h FROM HocaBilgileri h");
        try {
            hocaListesi = query.getResultList();
            return hocaListesi;
        } catch (NoResultException nre) {
            nre.printStackTrace(System.out);
            return null;
        } catch (NonUniqueResultException nue) {
            return (List<HocaBilgileri>) query.getResultList().get(0);
        }
    }
    
    public boolean hocaBilgisiGüncelle(HocaBilgileri hocaBilgileri){
        try{
            entityManager.merge(hocaBilgileri);
            return true;
        }catch(Exception e){
            e.printStackTrace(System.out);
            return false;
        }
        
    }
    
    public boolean hocaSil(HocaBilgileri hocaBilgileri){
        try{
            hocaBilgileri = entityManager.merge(hocaBilgileri);
            entityManager.remove(hocaBilgileri);
            return true;
        }catch(Exception e){
            e.printStackTrace(System.out);
            return false;
        }
    }
    
}
