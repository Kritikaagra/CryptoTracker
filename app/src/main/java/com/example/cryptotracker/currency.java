package com.example.cryptotracker;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class currency extends AppCompatActivity {

    private ImageView img, imgGraph;
    private TextView name, symbol,rate, twentyFour, sevenDays, thirtyDays, marketCap;
    String url, urlGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);

        img = findViewById(R.id.image);
        name = findViewById(R.id.name);
        symbol = findViewById(R.id.symbol);
        rate = findViewById(R.id.rate);
        imgGraph = findViewById(R.id.graph);
        twentyFour = findViewById(R.id.twentyFourData);
        sevenDays = findViewById(R.id.sevenDaysData);
        thirtyDays = findViewById(R.id.thirtyDaysData);
        marketCap = findViewById(R.id.marketCapData);

        name.setText(getIntent().getStringExtra("currName"));
        symbol.setText(getIntent().getStringExtra("currSymbol"));
        rate.setText(getIntent().getStringExtra("currRate"));
        twentyFour.setText(getIntent().getStringExtra("twentyFour"));
        sevenDays.setText(getIntent().getStringExtra("sevenDays"));
        thirtyDays.setText(getIntent().getStringExtra("thirtyDays"));
        marketCap.setText(new BigDecimal(getIntent().getStringExtra("marketCap")).toPlainString());

        color(twentyFour);
        color(sevenDays);
        color(thirtyDays);


        //Toast.makeText(currency.this, getIntent().getStringExtra("currTwentyFour"), Toast.LENGTH_SHORT).show();

        url = "https://s2.coinmarketcap.com/static/img/coins/64x64/" + getIntent().getStringExtra("imageId") + ".png";
        Picasso.get().load(url).into(img);

        urlGraph = "https://s3.coinmarketcap.com/generated/sparklines/web/7d/2781/" + getIntent().getStringExtra("imageId") + ".svg";
        //GlideToVectorYou.init().with(this).load(Uri.parse(urlGraph),imgGraph);
        Utils.fetchSvg(this, urlGraph, imgGraph);




    }




    private void color(TextView v){
        if(Double.parseDouble(v.getText().toString()) > 0.0){
            v.setTextColor(this.getResources().getColor(R.color.green));
        }
        if(Double.parseDouble(v.getText().toString()) < 0.0){
            v.setTextColor(this.getResources().getColor(R.color.red));
        }
        if(Double.parseDouble(v.getText().toString()) == 0.0){
            v.setTextColor(this.getResources().getColor(R.color.blue));
        }
    }


}