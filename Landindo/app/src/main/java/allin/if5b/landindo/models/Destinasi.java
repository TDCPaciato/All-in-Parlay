package allin.if5b.landindo.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Destinasi implements Parcelable {
    Integer id;
    String nama, kota, provinsi, gambar, deskripsi, pulau;

    protected Destinasi(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        nama = in.readString();
        kota = in.readString();
        provinsi = in.readString();
        gambar = in.readString();
        deskripsi = in.readString();
        pulau = in.readString();
    }

    public static final Creator<Destinasi> CREATOR = new Creator<Destinasi>() {
        @Override
        public Destinasi createFromParcel(Parcel in) {
            return new Destinasi(in);
        }

        @Override
        public Destinasi[] newArray(int size) {
            return new Destinasi[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getKota() {
        return kota;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public String getGambar() {
        return gambar;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getPulau() {
        return pulau;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        if (id == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(id);
        }
        parcel.writeString(nama);
        parcel.writeString(kota);
        parcel.writeString(provinsi);
        parcel.writeString(gambar);
        parcel.writeString(deskripsi);
        parcel.writeString(pulau);
    }
}
