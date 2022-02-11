package com.dkcr.vrich.mine;

import android.os.Bundle;

import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dkcr.vrich.BR;
import com.dkcr.vrich.R;
import com.dkcr.vrich.databinding.FragmentMineBinding;
import com.zlx.module_base.base_fg.BaseMvvmFg;
import com.zlx.module_base.constant.RouterFragmentPath;
import com.zlx.module_base.viewmodel.BaseViewModel;

@Route(path = RouterFragmentPath.Mine.PAGER_MINE)
public class MineFragment extends BaseMvvmFg<FragmentMineBinding, BaseViewModel> {

    @Override
    protected int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_mine;
    }

    @Override
    protected int initVariableId() {
        return BR.viewmodel;
    }
}