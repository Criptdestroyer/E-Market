package com.example.e_market;

import java.util.ArrayList;

public class BookData {
    public static String[][] data = new String[][]{
            {"Menjadi Android Developer Expert", "Jadi seorang Android Developer Expert hanya dalam waktu kurang dari 100 hari dengan Dicoding, satu-satunya Google Developers Authorized Training Partner di Indonesia.","500000","https://cdn-images-1.medium.com/max/1600/1*zugyA0rTW3Ll5y8DgPqE8g.jpeg"},
            {"Kotlin Android Developer Expert","Buku “Kotlin Android Developer Expert” Dicoding ini ditulis oleh Rendra Toro dan Nur Rohman, developer dan Kotlin enthusiast di Indonesia.","700000","https://blog.dicoding.com/wp-content/uploads/2018/04/IMG_20180404_084143-1.jpg?x10697"},
            {"Android Studio Mastery","Untuk pemula yang ingin belajar membuat aplikasi android buku ini sangat cocok dipelajari, karena akan dibahas dari mulai installasi tools sampai dengan upload aplikasi ke playstore","100000","https://badoystudio.com/wp-content/uploads/2018/08/ebook-android-mastery-Copy.png"},
            {"Effective Java","Java has changed dramatically since the previous edition of Effective Java was published shortly after the release of Java 6.","300000","https://images-na.ssl-images-amazon.com/images/I/516yIUucShL._SX408_BO1,204,203,200_.jpg"}
    };

    public static ArrayList<Book> getListData(){
        Book book = null;
        ArrayList<Book> list = new ArrayList<>();
        for (String[] aData: data) {
            book = new Book(aData[0],aData[1],aData[2],aData[3]);
            list.add(book);
        }
        return list;
    }
}
