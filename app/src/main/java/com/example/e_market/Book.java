package com.example.e_market;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {
    private String name;
    private String description;
    private String price;
    private String photo;

    public Book(String name, String description, String price, String photo){
        this.name = name;
        this.description = description;
        this.price = price;
        this.photo = photo;
    }

    protected Book(Parcel in) {
        name = in.readString();
        description = in.readString();
        price = in.readString();
        photo = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getPhoto() {
        return photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(price);
        dest.writeString(photo);
    }
}
