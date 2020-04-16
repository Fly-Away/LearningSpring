package com.api.b2b.Model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "msDealer")
public class Dealer {

    @Id
    @NotBlank(message = "Tidak Boleh Kosong")
    @Size(min = 0, max = 20)
    public String dealerId;

    @NotBlank(message = "Tidak Boleh Kosong")
    public String dealerName;

    @NotBlank(message = "Tidak Boleh Kosong")
    @Email(message = "Masukkan Email yang bener")
    public String dealerEmail;

    @NotBlank(message = "Tidak Boleh Kosong")
    @Size(min = 5, message = "Minimal 5 karakter")
    public String dealerAddress;

    public String town;

    public String npwp;

    public String phoneNumber;

    public String fax;

    public String contactPerson;

    public String region;

    public String invoiceReceptionSum;

    public String pendingPaymentSum;

    public String paymentSum;

    public String remarks;

    public String tempCredit;

    public Date entryTime;

    public String inputBy;

    public boolean active;

    public BigDecimal clMishirin;

    public BigDecimal clTrading;

    public BigDecimal clCosan;
    
    // public String accountId;

    public String pphType;

    public String bankName;

    public String bankBranch;

    public String bankAccountNumber;

    public String bankRegisteredName;

    public String vaNumber;

    public String locationCode;

    public Date firstInvoice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountId")
    public Account account;

    public String getDealerId() {
        return dealerId;
    }

    public void setDealerId(String dealerId) {
        this.dealerId = dealerId;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public String getDealerEmail() {
        return dealerEmail;
    }

    public void setDealerEmail(String dealerEmail) {
        this.dealerEmail = dealerEmail;
    }

    public String getDealerAddress() {
        return dealerAddress;
    }

    public void setDealerAddress(String dealerAddress) {
        this.dealerAddress = dealerAddress;
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

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getInvoiceReceptionSum() {
        return invoiceReceptionSum;
    }

    public void setInvoiceReceptionSum(String invoiceReceptionSum) {
        this.invoiceReceptionSum = invoiceReceptionSum;
    }

    public String getPendingPaymentSum() {
        return pendingPaymentSum;
    }

    public void setPendingPaymentSum(String pendingPaymentSum) {
        this.pendingPaymentSum = pendingPaymentSum;
    }

    public String getPaymentSum() {
        return paymentSum;
    }

    public void setPaymentSum(String paymentSum) {
        this.paymentSum = paymentSum;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getTempCredit() {
        return tempCredit;
    }

    public void setTempCredit(String tempCredit) {
        this.tempCredit = tempCredit;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public String getInputBy() {
        return inputBy;
    }

    public void setInputBy(String inputBy) {
        this.inputBy = inputBy;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public BigDecimal getClMishirin() {
        return clMishirin;
    }

    public void setClMishirin(BigDecimal clMishirin) {
        this.clMishirin = clMishirin;
    }

    public BigDecimal getClTrading() {
        return clTrading;
    }

    public void setClTrading(BigDecimal clTrading) {
        this.clTrading = clTrading;
    }

    public BigDecimal getClCosan() {
        return clCosan;
    }

    public void setClCosan(BigDecimal clCosan) {
        this.clCosan = clCosan;
    }

    // public String getAccountId() {
    //     return accountId;
    // }

    // public void setAccountId(String accountId) {
    //     this.accountId = accountId;
    // }

    public String getPphType() {
        return pphType;
    }

    public void setPphType(String pphType) {
        this.pphType = pphType;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getBankRegisteredName() {
        return bankRegisteredName;
    }

    public void setBankRegisteredName(String bankRegisteredName) {
        this.bankRegisteredName = bankRegisteredName;
    }

    public String getVaNumber() {
        return vaNumber;
    }

    public void setVaNumber(String vaNumber) {
        this.vaNumber = vaNumber;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public Date getFirstInvoice() {
        return firstInvoice;
    }

    public void setFirstInvoice(Date firstInvoice) {
        this.firstInvoice = firstInvoice;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


}