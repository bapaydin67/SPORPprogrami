/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompan.apacheshiro.service;

import com.mycompany.apacheshrio.entity.UyeBilgisi;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



@Stateless
public class YeniUyeEkleService  {

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

}
