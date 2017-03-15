package com.statusbar_alexleo.alexstatusbarutils.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.statusbar_alexleo.alexstatusbarutils.R;

/**
 * Created by Alex on 2017/3/13.
 * Alex
 */

public class TextFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.text_frag_layout,container,false);
    }
}
