package com.example.cryptotracker;

import static android.icu.lang.UCharacter.toLowerCase;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class CurrencyRVAdapter extends RecyclerView.Adapter<CurrencyRVAdapter.ViewHolder> {
    private ArrayList<CurrencyRVModal> currencyRVModalArrayList;
    private Context context;
    private static DecimalFormat df2 = new DecimalFormat("#.##");

    public CurrencyRVAdapter(ArrayList<CurrencyRVModal> currencyRVModalArrayList, Context context) {
        this.currencyRVModalArrayList = currencyRVModalArrayList;
        this.context = context;
    }

    public void filterList(ArrayList<CurrencyRVModal> filteredList){
        currencyRVModalArrayList = filteredList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public CurrencyRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.currency_rv_item,parent,false);
        return new CurrencyRVAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CurrencyRVModal currencyRVModal = currencyRVModalArrayList.get(position);
        holder.currencyNameTV.setText(currencyRVModal.getName());
        holder.symbolTV.setText(currencyRVModal.getSymbol());
        holder.rateTV.setText("$" + df2.format(currencyRVModal.getPrice()));
        String imgUrl = "https://s2.coinmarketcap.com/static/img/coins/64x64/" + currencyRVModal.getId() + ".png";
        Picasso.get().load(imgUrl).into(holder.imageTV);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, currency.class);
                intent.putExtra("imageId",Integer.toString(currencyRVModal.getId()));
                intent.putExtra("currName",currencyRVModal.getName());
                intent.putExtra("currSymbol",currencyRVModal.getSymbol());
                intent.putExtra("currRate","$" + df2.format(currencyRVModal.getPrice()));
                intent.putExtra("twentyFour",Double.toString(currencyRVModal.getTwentyFour()));
                intent.putExtra("sevenDays",Double.toString(currencyRVModal.getSevenDays()));
                intent.putExtra("thirtyDays",Double.toString(currencyRVModal.getThirtyDays()));
                intent.putExtra("marketCap",Double.toString(currencyRVModal.getMarketCap()));

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return currencyRVModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView currencyNameTV, symbolTV, rateTV;
        private ImageView imageTV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            currencyNameTV = itemView.findViewById(R.id.idTvCurrencyName);
            symbolTV = itemView.findViewById(R.id.idTVSymbol);
            rateTV = itemView.findViewById(R.id.idTvCurrencyRate);
            imageTV = itemView.findViewById(R.id.imageView);
        }
    }
}

