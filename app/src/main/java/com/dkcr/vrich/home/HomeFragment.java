package com.dkcr.vrich.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.dkcr.vrich.BR;
import com.dkcr.vrich.R;
import com.dkcr.vrich.databinding.FragmentHomeBinding;
import com.dkcr.vrich.home.bean.BannerBean;
import com.dkcr.vrich.home.viewmodel.HomeViewModel;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;
import com.zlx.module_base.base_api.res_data.BannerRes;
import com.zlx.module_base.base_fg.BaseMvvmFg;
import com.zlx.module_base.base_util.GlideUtil;
import com.zlx.module_base.constant.RouterFragmentPath;
import com.zlx.widget.shadow.GlideRoundUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Route(path = RouterFragmentPath.Home.PAGER_HOME)
public class HomeFragment extends BaseMvvmFg<FragmentHomeBinding, HomeViewModel> {

    private List<BannerRes> bannerList = new ArrayList<>();
    //private HomeBannerAdapter homeBannerAdapter = new HomeBannerAdapter(bannerList);

    @Override
    protected int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_home;
    }
    @Override
    protected boolean immersionBar() {
        return true;
    }

    @Override
    protected int initVariableId() {
        return BR.viewmodel;
    }

    @Override
    protected void initViews() {
        super.initViews();
        LogUtils.e("HomeFragment");
        initBanner();
    }

    @Override
    protected void initData() {
        super.initData();
        viewModel.getBanner();
        viewModel.bannerLiveData.observe(this, bannerRes -> {
            bannerList.clear();
            bannerList.addAll(bannerRes);
        });
    }

    private Banner banner;

    private void initBanner() {
        banner = binding.banner;
        banner.setAdapter(new BannerImageAdapter<BannerRes>(bannerList) {
            @Override
            public void onBindView(BannerImageHolder holder, BannerRes data, int position, int size) {
                GlideUtil.loadRoundImage(holder.imageView, data.getImagePath(), 10);
            }
        })
                .addBannerLifecycleObserver(this)//添加生命周期观察者
                .setIndicator(new CircleIndicator(getContext()));
        banner.setBannerGalleryEffect(20, 10);
        banner.setOnBannerListener((data, position) -> {
            ToastUtils.showShort(position + "");
        });
    }


}