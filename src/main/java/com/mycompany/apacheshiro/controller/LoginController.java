    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apacheshiro.controller;

import com.mycompany.apacheshrio.entity.JatomiYonetimPOJO;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

/**
 *
 * @author Batuhan
 */
@ManagedBean(name = "loginController")
@SessionScoped
public class LoginController implements Serializable {

    JatomiYonetimPOJO jyp = new JatomiYonetimPOJO();

    boolean rememberMe = false;

    private static final Logger log = Logger.getLogger(LoginController.class.getName());

    public String authenticate() {

        UsernamePasswordToken token = new UsernamePasswordToken(jyp.getFirstName(), jyp.getPassword(), rememberMe);

        Subject currentUser = SecurityUtils.getSubject();

        log.log(Level.INFO, "Submitting login with username of {0} and password of {1}", new Object[]{jyp.getFirstName()});

        try {
            currentUser.login(token);

            if (currentUser.isAuthenticated()) {
                log.info("Kullanıcı bağlandı.");
            }
        } catch (AuthenticationException e) {
            log.warning(e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Login Failed:" + e.getMessage().toString()));

            return "/error/error.xhtml?faces-redirect=true";
        }

        return "/template/main.xhtml?faces-redirect=true";

    }

    public String logout() {

        Subject currentUser = SecurityUtils.getSubject();
        try {

            currentUser.logout();
        } catch (Exception e) {
            log.info(e.toString());
        }

        return "/login/loginPage.xhtml?faces-redirect=true";
    }

    public JatomiYonetimPOJO getJyp() {
        return jyp;
    }

    public void setJyp(JatomiYonetimPOJO jyp) {
        this.jyp = jyp;
    }

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

}
