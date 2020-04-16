package com.api.b2b.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name= "msProduct")
public class Product {

    @Id
    @NotBlank(message = "Kode Product Tidak Boleh Kosong")
    @Size(min = 0, max = 50)
    public String kd_product;

    @NotBlank(message = "Kode Product Tidak Boleh Kosong")
    public String nm_product;

    public long harga;

    public boolean aktif;

    public String getKd_product() {
        return kd_product;
    }

    public void setKd_product(String kd_product) {
        this.kd_product = kd_product;
    }

    public String getNm_product() {
        return nm_product;
    }

    public void setNm_product(String nm_product) {
        this.nm_product = nm_product;
    }

    public long getHarga() {
        return harga;
    }

    public void setHarga(long harga) {
        this.harga = harga;
    }

    public boolean isAktif() {
        return aktif;
    }

    public void setAktif(boolean aktif) {
        this.aktif = aktif;
    }

    

}