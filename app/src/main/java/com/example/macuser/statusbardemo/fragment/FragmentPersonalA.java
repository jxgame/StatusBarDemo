package com.example.macuser.statusbardemo.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.macuser.statusbardemo.R;
import com.example.macuser.statusbardemo.glides.GlideRoundTransform;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by macuser on 16/7/22.
 **/
public class FragmentPersonalA extends Fragment {

    @BindView(R.id.fragment_persion_a_avatar)
    ImageView fragmentPersionAAvatar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personal_a, null);
        ButterKnife.bind(this, view);
        String url = "http://p3.music.126.net/W55TYYGM5slNClLPGAZG6Q==/3274345634221976.jpg?param=50y50";
        Glide.with(this).load(url).transform(new GlideRoundTransform(getActivity(), 2)).into(fragmentPersionAAvatar);
        return view;
    }
}