package com.dkcr.vrich.homeFg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.dkcr.vrich.R;
import com.dkcr.vrich.databinding.FragmentHomeBinding;
import com.zlx.module_base.base_fg.BaseMvvmFg;
import com.zlx.module_base.viewmodel.BaseViewModel;

/**
 */
public class HomeFragment extends BaseMvvmFg<FragmentHomeBinding, BaseViewModel> {

    @Override
    protected int initContentView(LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return R.layout.fragment_home;
    }

    @Override
    protected int initVariableId() {
        return 0;
    }
}