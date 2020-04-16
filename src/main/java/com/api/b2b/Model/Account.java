package com.api.b2b.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "msAccount")
public class Account {

    @Id
    @NotBlank(message = "Tidak Boleh Kosong")
    @Size(min = 0, max = 20)
    public String accountId;

    @NotBlank(message = "Tidak Boleh Kosong")
    public String accountName;

    @NotBlank(message = "Tidak Boleh Kosong")
    @Email(message = "Masukkan Email yang bener")
    public String accountEmail;

    @NotBlank(message = "Tidak Boleh Kosong")
    @Size(min = 5, message = "Minimal 5 karakter")
    public String accountAddress;

    @NotBlank(message = "Tidak Boleh Kosong")
    public String accountResidentCard;

    @NotBlank(message = "Tidak Boleh Kosong")
    public String accountPhoto;

    @NotBlank(message = "Tidak Boleh Kosong")
    public String town;
    
    @NotBlank(message = "Tidak Boleh Kosong")
    public String npwp;

    @NotBlank(message = "Tidak Boleh Kosong")
    public String phoneNumber;

    public String fax;

    public String remarks;

    @NotNull
    public Date entryTime;

    @NotNull
    public Boolean active;

    // @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @OneToMany(mappedBy = "account")
    // @JoinColumn(name = "accountId")
    public List<Dealer> dealer;

    @OneToOne(fetch = FetchType.LAZY)
    public UserExt userExt;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountEmail() {
        return accountEmail;
    }

    public void setAccountEmail(String accountEmail) {
        this.accountEmail = accountEmail;
    }

    public String getAccountAddress() {
        return accountAddress;
    }

    public void setAccountAddress(String accountAddress) {
        this.accountAddress = accountAddress;
    }

    public String getAccountResidentCard() {
        return accountResidentCard;
    }

    public void setAccountResidentCard(String accountResidentCard) {
        this.accountResidentCard = accountResidentCard;
    }

    public String getAccountPhoto() {
        return accountPhoto;
    }

    public void setAccountPhoto(String accountPhoto) {
        this.accountPhoto = accountPhoto;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getNpwp() {
        return npwp;
    }

    public void setNpwp(String npwp) {
        this.npwp = npwp;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<Dealer> getDealer() {
        return dealer;
    }

    public void setDealer(List<Dealer> dealer) {
        this.dealer = dealer;
    }

	public UserExt getUserExt() {
		return userExt;
	}

	public void setUserExt(UserExt userExt) {
		this.userExt = userExt;
	}

}