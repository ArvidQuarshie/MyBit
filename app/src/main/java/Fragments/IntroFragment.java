package Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.mybit.R;

import pl.droidsonroids.gif.GifImageView;

/**
 * Created by android on 11/4/17.
 */

public class IntroFragment extends android.support.v4.app.Fragment {

    private GifImageView mGifImageView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.splash, container, false);
//        mGifImageView = (GifImageView) view.findViewById(R.id.splash);


        return view;
    }
}

