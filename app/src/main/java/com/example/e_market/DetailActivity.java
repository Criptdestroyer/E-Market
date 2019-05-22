package com.example.e_market;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.io.InputStream;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_PRICE = "extra_price";
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_PHOTO = "extra_photo";
    public static final String EXTRA_DESCRIPTION = "extra_description";
    private Context context;
    private String name, description, price, photo;
    TextView tvName, tvPrice, tvDescription;
    ImageView tvPhoto;
    Button btnBuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvName = findViewById(R.id.tv_item_name);
        tvDescription = findViewById(R.id.tv_item_description);
        tvPrice = findViewById(R.id.tv_item_price);
        tvPhoto = findViewById(R.id.img_item_photo);
        btnBuy = findViewById(R.id.btn_buy);

        name = getIntent().getStringExtra(EXTRA_NAME);
        description = getIntent().getStringExtra(EXTRA_DESCRIPTION);
        price = "Rp. "+getIntent().getStringExtra(EXTRA_PRICE);
        photo = getIntent().getStringExtra(EXTRA_PHOTO);

        setActionBarTitle(name);

        tvName.setText(name);
        tvDescription.setText(description);
        tvPrice.setText(price);
        new DownloadImageFromInternet(tvPhoto)
                .execute(photo);

    }

    public void displayToast(View v){
        Toast.makeText(this,"Buy "+name+" Book",Toast.LENGTH_SHORT).show();
    }

    private void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    private class DownloadImageFromInternet extends AsyncTask<String, Void, Bitmap> {
        ImageView imageView;

        public DownloadImageFromInternet(ImageView imageView) {
            this.imageView = imageView;
        }

        protected Bitmap doInBackground(String... urls) {
            String imageURL = urls[0];
            Bitmap bimage = null;
            try {
                InputStream in = new java.net.URL(imageURL).openStream();
                bimage = BitmapFactory.decodeStream(in);

            } catch (Exception e) {
                Log.e("Error Message", e.getMessage());
                e.printStackTrace();
            }
            return bimage;
        }

        protected void onPostExecute(Bitmap result) {
            imageView.setImageBitmap(result);
        }
    }
}
