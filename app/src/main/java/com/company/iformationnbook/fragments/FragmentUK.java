package com.company.iformationnbook.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.company.iformationnbook.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class FragmentUK extends Fragment {

    public  static FragmentUK newInstance(){
        return new FragmentUK();
    }

    private ImageView imageViewUK;
    private ProgressBar progressBarUK;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view= inflater.inflate(R.layout.fragment_uk,container,false);

        imageViewUK=view.findViewById(R.id.imageViewUK);
        progressBarUK=view.findViewById(R.id.progressBar);

        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a5/" +
                "Flag_of_the_United_Kingdom_%281-2%29.svg/1920px-Flag_of_the_United_Kingdom_%281-2%29.svg.png")
                .into(imageViewUK, new Callback() {
                    @Override
                    public void onSuccess() {
                        progressBarUK.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void onError(Exception e) {

                        Toast.makeText(getActivity(),e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                        progressBarUK.setVisibility(View.INVISIBLE);

                    }
                });

        return view;
    }
}