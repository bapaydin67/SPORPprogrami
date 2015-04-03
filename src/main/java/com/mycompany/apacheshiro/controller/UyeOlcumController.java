/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apacheshiro.controller;

import com.mycompan.apacheshiro.service.UyeOlcumService;
import com.mycompan.apacheshiro.service.UyeService;
import com.mycompany.apacheshrio.entity.UyeBilgisi;
import com.mycompany.apacheshrio.entity.UyeOlcum;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Batuhan
 */
@ManagedBean(name = "uyeOlcumController")
@ViewScoped
public class UyeOlcumController implements Serializable {

    private String mesajVer;
    private int id;

    UyeOlcum uyeOlcum = new UyeOlcum();
    UyeBilgisi uyeBilgisi = new UyeBilgisi();

    List<UyeBilgisi> uyeIsımBilgisi = new ArrayList<UyeBilgisi>();
    List<UyeBilgisi> uyeİsimBilgisiAjax = new ArrayList<UyeBilgisi>();
    List<UyeOlcum> uyeOlcumBilgi = new ArrayList<UyeOlcum>();
    List<UyeOlcum> uyeAramaListesi = new ArrayList<UyeOlcum>();

    @Inject
    UyeOlcumService uyeOlcumService;

    public UyeOlcumController() {
        uyeİsimBilgisiAjax = uyeIsımBilgisi;

    }

    @PostConstruct
    public void init() {
        uyeOlcumBilgi = uyeOlcumService.uyeOlcumBilgileriniGetir();
        //uyeAramaListesi = uyeOlcumService.uyeOlcumBilgileriniGetirIDYEGORE(uyeBilgisi);
        uyeAramaListesi = uyeOlcumService.uyeOlcumBilgileriniGetir();
    }

    public void uyeOlcumEkle() {
        try {
            boolean uyeEklendiMi;
            uyeEklendiMi = uyeOlcumService.uyeOlcumKayit(uyeOlcum);
            if (uyeEklendiMi) {
                mesajVer = "Uye Olcum Kayit Başarıyla Tamamlandı";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(mesajVer, "Başarılı."));
            } else {
                mesajVer = "Uye Olcum Kayit Edilemedi";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(mesajVer, "Başarısız"));
            }

        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    public void uyeIsımGetir() {
        try {
            uyeIsımBilgisi = uyeOlcumService.uyeleriIsmeGoreGetir(uyeBilgisi);
            if (uyeIsımBilgisi != null) {
                uyeİsimBilgisiAjax = uyeIsımBilgisi;

                mesajVer = "Uye Bilgisi getirildi";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(mesajVer, "Başarılı."));
            } else {
                mesajVer = "Uye Bilgisi getirelemedi";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(mesajVer, "Başarısız."));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void uyeOlcumGuncelle(RowEditEvent rowEditEvent) {
        int uyeId = ((UyeOlcum) rowEditEvent.getObject()).getUyeId();
        String uyeKasOrani = ((UyeOlcum) rowEditEvent.getObject()).getKasOrani();
        int uyeKilo = ((UyeOlcum) rowEditEvent.getObject()).getKilo();
        int uyeMetabolizmaYasi = ((UyeOlcum) rowEditEvent.getObject()).getMetabolizmaYasi();
        String olcumTarihi = ((UyeOlcum) rowEditEvent.getObject()).getTarih();
        int uyeYagOrani = ((UyeOlcum) rowEditEvent.getObject()).getYagOrani();

        FacesMessage facesMessage = new FacesMessage("Seçilen : " + uyeId + " Nolu Uye Olcum Bilgileri Güncellenmiştir.");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);

        String yeniKasOrani = ((UyeOlcum) rowEditEvent.getObject()).getKasOrani();
        int yeniKiloDegeri = ((UyeOlcum) rowEditEvent.getObject()).getKilo();
        int yeniMetabolizmaYasi = ((UyeOlcum) rowEditEvent.getObject()).getMetabolizmaYasi();
        int yeniYagOrani = ((UyeOlcum) rowEditEvent.getObject()).getYagOrani();
        String yeniOlcumTarihi = ((UyeOlcum) rowEditEvent.getObject()).getTarih();

        UyeOlcum yeniOlcumDegerleri = (UyeOlcum) rowEditEvent.getObject();
        yeniOlcumDegerleri.setKasOrani(yeniKasOrani);
        yeniOlcumDegerleri.setKilo(yeniKiloDegeri);
        yeniOlcumDegerleri.setMetabolizmaYasi(yeniMetabolizmaYasi);
        yeniOlcumDegerleri.setYagOrani(yeniYagOrani);
        yeniOlcumDegerleri.setTarih(yeniOlcumTarihi);

        uyeOlcumService.uyeOlcumGuncelle(yeniOlcumDegerleri);

    }

    public void onRowCancel(RowEditEvent rowEditEvent) {
        FacesMessage fm = new FacesMessage("Güncelleme İşlemi İptaledildi.");
        FacesContext.getCurrentInstance().addMessage(null, fm);
    }

    public void veriyiGetir() {
        this.id = id;
        this.uyeOlcum.setUyeId(id);
    }

    public void idGor() {
        System.out.println(id);

    }

    public UyeOlcum getUyeOlcum() {
        return uyeOlcum;
    }

    public void setUyeOlcum(UyeOlcum uyeOlcum) {
        this.uyeOlcum = uyeOlcum;
    }

    public List<UyeBilgisi> getUyeIsımBilgisi() {
        return uyeIsımBilgisi;
    }

    public void setUyeIsımBilgisi(List<UyeBilgisi> uyeIsımBilgisi) {
        this.uyeIsımBilgisi = uyeIsımBilgisi;
    }

    public UyeBilgisi getUyeBilgisi() {
        return uyeBilgisi;
    }

    public void setUyeBilgisi(UyeBilgisi uyeBilgisi) {
        this.uyeBilgisi = uyeBilgisi;
    }

    public List<UyeBilgisi> getUyeİsimBilgisiAjax() {
        return uyeİsimBilgisiAjax;
    }

    public void setUyeİsimBilgisiAjax(List<UyeBilgisi> uyeİsimBilgisiAjax) {
        this.uyeİsimBilgisiAjax = uyeİsimBilgisiAjax;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<UyeOlcum> getUyeOlcumBilgi() {
        return uyeOlcumBilgi;
    }

    public void setUyeOlcumBilgi(List<UyeOlcum> uyeOlcumBilgi) {
        this.uyeOlcumBilgi = uyeOlcumBilgi;
    }

    public List<UyeOlcum> getUyeAramaListesi() {
        return uyeAramaListesi;
    }

    public void setUyeAramaListesi(List<UyeOlcum> uyeAramaListesi) {
        this.uyeAramaListesi = uyeAramaListesi;
    }

}
