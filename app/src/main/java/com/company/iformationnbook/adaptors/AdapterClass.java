package com.company.iformationnbook.adaptors;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.company.iformationnbook.activities.CountriesActivity;
import com.company.iformationnbook.activities.LeadersActivity;
import com.company.iformationnbook.activities.MuseumsActivity;
import com.company.iformationnbook.activities.WondersActivity;
import com.company.iformationnbook.ModelClass;
import com.company.iformationnbook.R;

import java.util.ArrayList;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.CardViewHolder> {

    private ArrayList<ModelClass> modelList=new ArrayList<>();
    private Context context;

    public AdapterClass(ArrayList<ModelClass> modelList, Context context) {
        this.modelList = modelList;
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_design,parent,false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder,
                                 int position) {
        ModelClass model=modelList.get(position);
        holder.textViewSplash.setText(model.getCategoryName());
        holder.imageViewSplash.setImageResource(context.getResources().getIdentifier(
                model.getImageName(),"drawable", context.getPackageName()
        ));

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (position) {
                    case 0:
                        Intent intent = new Intent(context, CountriesActivity.class);
                        context.startActivity(intent);
                        break;
                    case 1:
                        Intent leaderIntent = new Intent(context, LeadersActivity.class);
                        context.startActivity(leaderIntent);
                        break;
                    case 2:
                        Intent museumIntent = new Intent(context, MuseumsActivity.class);
                        context.startActivity(museumIntent);
                        break;
                    case 3:
                        Intent wondersIntent = new Intent(context, WondersActivity.class);
                        context.startActivity(wondersIntent);
                        break;

                }


            }
        });


    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public  class  CardViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewSplash;
        private TextView textViewSplash;
        private View cardView;
        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewSplash=itemView.findViewById(R.id.imageViewSplash);
            textViewSplash=itemView.findViewById(R.id.textViewSplash);
            cardView=itemView.findViewById(R.id.cardView);



        }
    }
}
