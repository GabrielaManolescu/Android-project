package com.example.gestiunechirii;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;



import java.util.Date;
@Entity(tableName = "apartment")
public class Apartments implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    private long idApartament;

    @ColumnInfo(name="name")
    private String nameApartament;//desciere camere
    @ColumnInfo(name="location")
    private String location;
    @ColumnInfo(name="price")
    private Float price;


    @ColumnInfo(name="date")
    protected Date dateValidity;

    @Ignore//pt a ignora acest constructor de Room
    public Apartments(String nameApartament, String location, Float price, Date dateValidity) {
        this.nameApartament = nameApartament;
        this.location = location;
        this.price = price;
        this.dateValidity = dateValidity;
    }

    public Apartments(long idApartament, String nameApartament, String location, Float price, Date dateValidity) {
        this.idApartament = idApartament;
        this.nameApartament = nameApartament;
        this.location = location;
        this.price = price;
        this.dateValidity = dateValidity;
    }

    protected Apartments(Parcel in) {
//        if (in.readByte() == 0) {
//            idApartament = null;
//        } else {
            idApartament = in.readLong();
       // }
        nameApartament = in.readString();
        location = in.readString();
        if (in.readByte() == 0) {
            price = null;
        } else {
            price = in.readFloat();
        }
      //  price = in.readFloat();
    // DateConverter.fromDate(this.dateValidity=in.readString());
     //String date = DateConverter.fromDate(this.dateValidity);
   //date = in.readString();
        dateValidity = DateConverter.fromString(in.readString());

       // dateValidity=in.readString();
      //  dateValidity=in.readString();



    }

    public static final Creator<Apartments> CREATOR = new Creator<Apartments>() {
        @Override
        public Apartments createFromParcel(Parcel in) {
            return new Apartments(in);
        }

        @Override
        public Apartments[] newArray(int size) {
            return new Apartments[size];
        }
    };

    public long getIdApartament() {
        return idApartament;
    }

    public void setIdApartament(long idApartament) {
        this.idApartament = idApartament;
    }

    public String getNameApartament() {
        return nameApartament;
    }

    public void setNameApartament(String nameApartament) {
        this.nameApartament = nameApartament;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Date getDateValidity() {
        return dateValidity;
    }

    public void setDateValidity(Date dateValidity) {
        this.dateValidity = dateValidity;
    }


    @Override
    public String toString() {
        return "Apartments{" +
                "Name Apartament='" + nameApartament + '\'' +
                ", location='" + location + '\'' +
                ", price=" + price +
                ", dateValidity=" + dateValidity +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeLong(idApartament);
      //  if (idApartament == null) {
           // dest.writeByte((byte) 0);
       // } else {
          //  dest.writeByte((byte) 1);
            dest.writeLong(idApartament);
      //  }
        dest.writeString(nameApartament);
        dest.writeString(location);
        if (price == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeFloat(price);
        }

        dest.writeString(DateConverter.fromDate(dateValidity));
      //  dest.writeString(dateValidity);


//        String dateAp = this.dateValidity != null ?
//                new SimpleDateFormat(DateConverter.fromDate(dateValidity), Locale.US)
//                        .format(this.dateValidity) :
//                null;
//        dest.writeString(dateAp);

    }
}
