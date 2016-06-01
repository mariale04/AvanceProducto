package android.android.app.com.avanceproductomaria.entities;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Alejandra on 01/06/2016.
 */

public class BEProducto implements Parcelable {
    private int idProducto;
    private String nomProducto;
    private String descProducto;
    private float precioProducto;


    public BEProducto(){

    }



    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNomProducto() {
        return nomProducto;
    }

    public void setNomProducto(String nomProducto) {
        this.nomProducto = nomProducto;
    }

    public String getDescProducto() {
        return descProducto;
    }

    public void setDescProducto(String descProducto) {
        this.descProducto = descProducto;
    }

    public float getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(float precioProducto) {
        this.precioProducto = precioProducto;
    }



    protected BEProducto(Parcel in) {
        idProducto = in.readInt();
        nomProducto = in.readString();
        descProducto = in.readString();
        precioProducto = in.readFloat();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idProducto);
        dest.writeString(nomProducto);
        dest.writeString(descProducto);
        dest.writeFloat(precioProducto);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<BEProducto> CREATOR = new Parcelable.Creator<BEProducto>() {
        @Override
        public BEProducto createFromParcel(Parcel in) {
            return new BEProducto(in);
        }

        @Override
        public BEProducto[] newArray(int size) {
            return new BEProducto[size];
        }
    };
}
