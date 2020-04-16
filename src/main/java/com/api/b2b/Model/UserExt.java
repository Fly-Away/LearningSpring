package com.api.b2b.Model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name= "msUserExt")
public class UserExt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Size(min = 0, max = 50)
    public long id;

    @NotBlank(message = "Tidak Boleh Kosong")
    public String userName;

    @NotBlank(message = "Tidak Boleh Kosong")
    public String userEmail;

    @NotBlank(message = "Tidak Boleh Kosong")
    @Size(min = 4, max = 50)
    public String password;

    @NotNull
    public boolean active;
    
    @NotNull
    public boolean deleted;

    public Date createdAt;

    public String createdBy;

    @OneToMany
    // @JoinTable(name="ms_user_dealer_tag", joinColumns={
    //     @JoinColumn(name="id", referencedColumnName="id")
    //     }, inverseJoinColumns={
    //     @JoinColumn(name="dealerId", referencedColumnName="dealerId")
    //     })
    public List<Dealer> dealer;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public List<Dealer> getDealer() {
        return dealer;
    }

    public void setDealer(List<Dealer> dealer) {
        this.dealer = dealer;
    }

}