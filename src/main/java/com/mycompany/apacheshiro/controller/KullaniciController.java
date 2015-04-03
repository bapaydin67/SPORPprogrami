/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apacheshiro.controller;

import com.mycompan.apacheshiro.service.KullaniciService;
import com.mycompany.apacheshrio.entity.KullaniciTablosu;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Batuhan
 */
@ManagedBean(name = "kullaniciController")
@ViewScoped
public class KullaniciController implements Serializable {

    KullaniciTablosu kullaniciTablosu = new KullaniciTablosu();
    KullaniciTablosu secilenKullaniciTablosu = new KullaniciTablosu();

    List<KullaniciTablosu> kullaniciListesi = new ArrayList<KullaniciTablosu>();
    List<KullaniciTablosu> güncellenenKullaniciListesi = new ArrayList<KullaniciTablosu>();

    private String message;

    @Inject
    KullaniciService kullaniciEkleService;

    @PostConstruct
    public void init() {

        message = null;
        kullaniciListesi = kullaniciEkleService.kullaniciTablosunuGetir();

    }

    public void kullaniciInsert() {
        try {
            boolean kullaniciVarMi = kullaniciEkleService.kullaniciEkle(kullaniciTablosu);
            if (kullaniciVarMi) {

                message = "Kullanici başariyla eklendi";
                kullaniciTablosu = new KullaniciTablosu();
                kullaniciListesi = kullaniciEkleService.kullaniciTablosunuGetir();

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message, "Başarılı"));
            } else {
                message = "Kullanici eklenemedi.";

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message, "Başarısız"));
            }
        } catch (Exception e) {
            kullaniciTablosu = new KullaniciTablosu();
            message = e.toString();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message, "Başarısız"));
        }
    }

    public void tabloyuGüncelle(RowEditEvent editEvent) {
        String kullaniciAdi = ((KullaniciTablosu) editEvent.getObject()).getKullaniciAdi();
        String kullaniciSifre = ((KullaniciTablosu) editEvent.getObject()).getKullaniciSifresi();
        try {

            FacesMessage fsg = new FacesMessage(kullaniciAdi + " adlı ve şifresi " + kullaniciSifre + " güncellendi.");

            FacesContext.getCurrentInstance().addMessage(null, fsg);

            String yeniKullaniciAdi = ((KullaniciTablosu) editEvent.getObject()).getKullaniciAdi();
            String yeniKullaniciSifre = ((KullaniciTablosu) editEvent.getObject()).getKullaniciSifresi();

            KullaniciTablosu yeniKullaniciTablosu = (KullaniciTablosu) editEvent.getObject();
            yeniKullaniciTablosu.setKullaniciAdi(yeniKullaniciAdi);
            yeniKullaniciTablosu.setKullaniciSifresi(yeniKullaniciSifre);

            kullaniciEkleService.kullaniciGuncelle(yeniKullaniciTablosu);
        } catch (Exception e) {
            e.printStackTrace(System.out);
            FacesMessage fsg = new FacesMessage(kullaniciAdi + " adlı ve şifresi " + kullaniciSifre + " güncellenemedi.");

            FacesContext.getCurrentInstance().addMessage(null, fsg);
        }

    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Güncelleme iptal edildi.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void tabloyuSil(RowEditEvent editEvent) {
        try {
            int kullaniciID = ((KullaniciTablosu) editEvent.getObject()).getId();
            String kullaniciAdi = ((KullaniciTablosu) editEvent.getObject()).getKullaniciAdi();
            String kullaniciSifre = ((KullaniciTablosu) editEvent.getObject()).getKullaniciSifresi();

            secilenKullaniciTablosu = (KullaniciTablosu) editEvent.getObject();
            secilenKullaniciTablosu.setId(kullaniciID);
            secilenKullaniciTablosu.setKullaniciAdi(kullaniciAdi);
            secilenKullaniciTablosu.setKullaniciSifresi(kullaniciSifre);

            boolean silindimi = kullaniciEkleService.kullaniciSil(secilenKullaniciTablosu);
            if (silindimi) {

                message = kullaniciAdi + " adlı ve sifresi " + kullaniciSifre + " veri başariyla silindi";
                FacesMessage fsg = new FacesMessage(message, message);
                FacesContext.getCurrentInstance().addMessage(null, fsg);

                güncellenenKullaniciListesi = kullaniciEkleService.kullaniciTablosunuGetir();
                kullaniciListesi = güncellenenKullaniciListesi;
            } else {
                message = "Veri silinemedi.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message, "Başarısız"));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

    }

    public KullaniciTablosu getKullaniciTablosu() {
        return kullaniciTablosu;
    }

    public void setKullaniciTablosu(KullaniciTablosu kullaniciTablosu) {
        this.kullaniciTablosu = kullaniciTablosu;
    }

    public List<KullaniciTablosu> getKullaniciListesi() {
        return kullaniciListesi;
    }

    public void setKullaniciListesi(List<KullaniciTablosu> kullaniciListesi) {
        this.kullaniciListesi = kullaniciListesi;
    }

}
