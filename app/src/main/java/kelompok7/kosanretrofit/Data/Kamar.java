package kelompok7.kosanretrofit.Data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zs on 11/28/2017.
 */

public class Kamar {

    @SerializedName("id_kamar")
    private String id_kamar;
    @SerializedName("nama_kamar")
    private String nama_kamar;
    @SerializedName("harga")
    private String harga;
    @SerializedName("fasilitas")
    private String fasilitas;
    @SerializedName("deskripsi")
    private String deskripsi;

    public Kamar() {}
    public Kamar(String id_kamar, String nama_kamar, String harga, String
            fasilitas, String deskripsi) {
        this.id_kamar = id_kamar;
        this.nama_kamar = nama_kamar;
        this.harga = harga;
        this.fasilitas = fasilitas;
        this.deskripsi = deskripsi;

    }
    public String getid_kamar() {
        return id_kamar;
    }
    public void setid_kamar(String id_kamar) {
        this.id_kamar = id_kamar;
    }
    public String getnama_kamar() {
        return nama_kamar;
    }
    public void setnama_kamar(String nama_kamar) {
        this.nama_kamar = nama_kamar;
    }
    public String getharga() {
        return harga;
    }
    public void setharga(String harga) {
        this.harga = harga;
    }
    public String getfasilitas() {
        return fasilitas;
    }
    public void setfasilitas(String fasilitas) {
        this.fasilitas = fasilitas;
    }
    public String getdeskripsi() {
        return deskripsi;
    }
    public void setdeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
    
}
