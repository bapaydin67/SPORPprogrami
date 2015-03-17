/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apacheshiro.controller;

import com.mycompan.apacheshiro.service.YeniUyeEkleService;

import com.mycompany.apacheshrio.entity.UyeBilgisi;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@ManagedBean(name = "yeniUyeEkleController")
@ViewScoped
public class YeniUyeEkleController implements Serializable {

    UyeBilgisi uyeBilgisi = new UyeBilgisi();
    String MesajGoster;
    @Inject
    YeniUyeEkleService uyeEkleService;

    @PostConstruct
    public void init() {

    }

    public void UYEInsert() {
        try {
            boolean kullaniciVarMi = uyeEkleService.uyeEkle(uyeBilgisi);
            if (kullaniciVarMi) {

                MesajGoster = "Kullanici başariyla eklendi";

              
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(MesajGoster, "Başarılı"));
            } else {

                
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(MesajGoster, "Başarısız"));
            }
        } catch (Exception e) {

           
        }
    }

    public UyeBilgisi getUyeBilgisi() {
        return uyeBilgisi;
    }

    public void setUyeBilgisi(UyeBilgisi uyeBilgisi) {
        this.uyeBilgisi = uyeBilgisi;
    }
}
