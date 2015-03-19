/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apacheshiro.controller;

import com.mycompan.apacheshiro.service.UyeService;
import com.mycompany.apacheshrio.entity.UyeBilgisi;
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

@ManagedBean(name = "uyeController")
@ViewScoped
public class UyeController implements Serializable{

    UyeBilgisi uyeBilgisi = new UyeBilgisi();
    @Inject
    UyeService uyeService;
    private String MesajGoster;
    UyeService yeniUyeEkleService;
    UyeBilgisi secilenUye = new UyeBilgisi();

    List<UyeBilgisi> uyeListesiVer = new ArrayList<UyeBilgisi>();
    List<UyeBilgisi> guncelUyeListesi = new ArrayList<>();
    List<UyeBilgisi> uyeListeVer_2 = new ArrayList<>();

    @PostConstruct
    public void init() {
        uyeListesiVer = uyeService.uyeleriGetir();
    }

    public void UyeKayitTamamla() {
        try {
            boolean UyeEklendiMI;
            UyeEklendiMI = uyeService.UYEKAYITYAP(uyeBilgisi);
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

  public void uyeTablosunuGuncelle(RowEditEvent rowEditEvent) {
        String uyeAdi = ((UyeBilgisi) rowEditEvent.getObject()).getUyeAdi();

        FacesMessage facesMessage = new FacesMessage(uyeAdi + " adlı kişinin bilgilerini değiştirdiniz...");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);

        String uyeYeniAdi = ((UyeBilgisi) rowEditEvent.getObject()).getUyeAdi();
        String uyeYeniSoyadi = ((UyeBilgisi) rowEditEvent.getObject()).getUyeSoyadi();
        String uyeYeniDogumTarihi = ((UyeBilgisi) rowEditEvent.getObject()).getDogumTarihi();
        int uyeYeniTelNo = ((UyeBilgisi) rowEditEvent.getObject()).getTelefonNo();
        String uyeYeniMailAdres = ((UyeBilgisi) rowEditEvent.getObject()).getEmail();
        String uyeYeniCinsiyet = ((UyeBilgisi) rowEditEvent.getObject()).getCinsiyet();

        UyeBilgisi yeniUyeBilgisi = (UyeBilgisi) rowEditEvent.getObject();
        yeniUyeBilgisi.setUyeAdi(uyeYeniAdi);
        yeniUyeBilgisi.setUyeSoyadi(uyeYeniSoyadi);
        yeniUyeBilgisi.setDogumTarihi(uyeYeniDogumTarihi);
        yeniUyeBilgisi.setTelefonNo(uyeYeniTelNo);
        yeniUyeBilgisi.setEmail(uyeYeniMailAdres);
        yeniUyeBilgisi.setCinsiyet(uyeYeniCinsiyet);

        yeniUyeEkleService.uyeBilgisiGuncele(yeniUyeBilgisi);

    }

    public void uyeSil(RowEditEvent rowEditEvent) {
        try {
            int uyeId = ((UyeBilgisi) rowEditEvent.getObject()).getId();

            secilenUye = (UyeBilgisi) rowEditEvent.getObject();
            secilenUye.setId(uyeId);

            boolean uyeSilindiMi = yeniUyeEkleService.uyeBilgisiSil(secilenUye);
            if (uyeSilindiMi) {
                MesajGoster = "Secilen Uye Başarıyla Silindi.";
                FacesMessage facesMessage = new FacesMessage(MesajGoster, MesajGoster);
                FacesContext.getCurrentInstance().addMessage(null, facesMessage);
                guncelUyeListesi = yeniUyeEkleService.uyeleriGetir();
                uyeListesiVer = guncelUyeListesi;
            } else {
                MesajGoster = "Seçilen Uye Silinemedi.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(MesajGoster, "Başarısız"));
            }

        } catch (Exception ex) {

        }
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage facesMessage = new FacesMessage("Güncelleme İşlemi İptal Edildi...");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);

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

    public List<UyeBilgisi> getUyeListeVer_2() {
        return uyeListeVer_2;
    }

    public void setUyeListeVer_2(List<UyeBilgisi> uyeListeVer_2) {
        this.uyeListeVer_2 = uyeListeVer_2;
    }

}
