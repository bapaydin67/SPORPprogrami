/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apacheshiro.controller;

import com.mycompan.apacheshiro.service.YeniUyeEkleService;
import com.mycompany.apacheshrio.entity.UyeBilgisi;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@ManagedBean(name = "uyeEkleController")
@ViewScoped
public class UyeEkleController {

    UyeBilgisi uyeBilgisi = new UyeBilgisi();
    @Inject
    YeniUyeEkleService yeniUyeEkleService;
    private String MesajGoster;

    List<UyeBilgisi> uyeListesiVer = new ArrayList<UyeBilgisi>();

    @PostConstruct
    public void init() {
        uyeListesiVer = yeniUyeEkleService.uyeleriGetir();
    }

    public void UyeKayitTamamla() {
        try {
            boolean UyeEklendiMI;
            UyeEklendiMI = yeniUyeEkleService.UYEKAYITYAP(uyeBilgisi);
            if (UyeEklendiMI) {
                MesajGoster = "Uye Kayit Yapıldı.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(MesajGoster, "Başarılı"));
            } else {
                MesajGoster = "Uye Kayit Yapılmadı.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(MesajGoster, "Başarısız"));
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }

    }

    public UyeBilgisi getUyeBilgisi() {
        return uyeBilgisi;
    }

    public void setUyeBilgisi(UyeBilgisi uyeBilgisi) {
        this.uyeBilgisi = uyeBilgisi;
    }

    public List<UyeBilgisi> getUyeListesiVer() {
        return uyeListesiVer;
    }

    public void setUyeListesiVer(List<UyeBilgisi> uyeListesiVer) {
        this.uyeListesiVer = uyeListesiVer;
    }

}
