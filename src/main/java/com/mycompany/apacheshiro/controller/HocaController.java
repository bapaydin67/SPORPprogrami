/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apacheshiro.controller;

import com.mycompan.apacheshiro.service.HocaService;
import com.mycompany.apacheshrio.entity.HocaBilgileri;
import com.mycompany.apacheshrio.entity.KullaniciTablosu;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Batuhan
 */
@ManagedBean(name = "hocaController")
@ViewScoped
public class HocaController implements Serializable {

    private HocaBilgileri hocaBilgileri;
    private String message;
    private List<HocaBilgileri> hocaListesi = new ArrayList<HocaBilgileri>();

    @Inject
    HocaService hocaService;

    @PostConstruct
    public void init() {
        hocaBilgileri = new HocaBilgileri();
        hocaListesi = hocaService.hocaBilgileriGetir();
        message = null;
    }

    public void hocaEkle() {
        try {
            boolean eklendimi = hocaService.hocaEkle(hocaBilgileri);
            if (eklendimi) {
                message = "Hoca başarıyla eklenmiştir.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                hocaBilgileri = new HocaBilgileri();
                hocaListesi = hocaService.hocaBilgileriGetir();
            } else {
                message = "Hoca ekleme işlemi başarısız.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
            }
        } catch (Exception e) {
        }
    }

    public void hocaBilgisiGüncelle(RowEditEvent editEvent) {

        String hocaAdi = ((HocaBilgileri) editEvent.getObject()).getHocaAdi();
        String hocaSoyadi = ((HocaBilgileri) editEvent.getObject()).getHocaSoyadi();
        String hocaSeviye = ((HocaBilgileri) editEvent.getObject()).getHocaSeviye();

        FacesMessage fsg = new FacesMessage(hocaAdi + " " + hocaSoyadi + " hoca güncellendi.");

        FacesContext.getCurrentInstance().addMessage(null, fsg);

        String yeniHocaAdi = ((HocaBilgileri) editEvent.getObject()).getHocaAdi();
        String yeniHocaSoyadi = ((HocaBilgileri) editEvent.getObject()).getHocaSoyadi();
        String yeniHocaSeviye = ((HocaBilgileri) editEvent.getObject()).getHocaSeviye();

        HocaBilgileri yeniHocaTablosu = (HocaBilgileri) editEvent.getObject();
        yeniHocaTablosu.setHocaAdi(yeniHocaAdi);
        yeniHocaTablosu.setHocaSoyadi(yeniHocaSoyadi);
        yeniHocaTablosu.setHocaSeviye(yeniHocaSeviye);

        hocaService.hocaBilgisiGüncelle(yeniHocaTablosu);

    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Güncelleme iptal edildi.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public HocaBilgileri getHocaBilgileri() {
        return hocaBilgileri;
    }

    public void setHocaBilgileri(HocaBilgileri hocaBilgileri) {
        this.hocaBilgileri = hocaBilgileri;
    }

    public List<HocaBilgileri> getHocaListesi() {
        return hocaListesi;
    }

    public void setHocaListesi(List<HocaBilgileri> hocaListesi) {
        this.hocaListesi = hocaListesi;
    }

}
