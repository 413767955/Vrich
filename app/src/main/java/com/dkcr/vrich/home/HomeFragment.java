package com.dkcr.vrich.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.dkcr.vrich.BR;
import com.dkcr.vrich.R;
import com.dkcr.vrich.databinding.FragmentHomeBinding;
import com.dkcr.vrich.home.adater.HomeFinanceAdapter;
import com.dkcr.vrich.home.adater.UpcomingAdapter;
import com.dkcr.vrich.home.bean.BannerBean;
import com.dkcr.vrich.home.bean.FinanceListBean;
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
        initBanner();
        initViewFlipper();
        initFinanceRV();
        initUpcomingRV();
        initHotRV();
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
                .addBannerLifecycleObserver(this)//???????????????????????????
                .setIndicator(new CircleIndicator(getContext()));
        banner.setBannerGalleryEffect(10, 10);
        banner.setOnBannerListener((data, position) -> {
            ToastUtils.showShort(position + "");
        });
    }

    private void initViewFlipper(){
        String[] datas = viewModel.viewFlipperDatas();

        for (int i = 0; i < datas.length; i++) { //????????????????????????
            View v = View.inflate(getContext(),R.layout.item_home_view_flipper,null);
            ImageView iv = v.findViewById(R.id.iv);
            TextView tv = v.findViewById(R.id.title);
            tv.setText(datas[i]);
            binding.viewFlipper.addView(v); //??????????????????????????????ViewFlipper
        }
        binding.viewFlipper.startFlipping(); //????????????
    }
    private HomeFinanceAdapter financeAdapter;
    private void initFinanceRV(){
        binding.financeRv.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL,false));
        financeAdapter = new HomeFinanceAdapter(new ArrayList<>());
        List<FinanceListBean> list = viewModel.getFinanceList();
        financeAdapter.addData(list);
        binding.financeRv.setAdapter(financeAdapter);
    }
    private UpcomingAdapter upcomingAdapter;
    private void initUpcomingRV(){
        binding.upcomingRV.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL,false));
        upcomingAdapter = new UpcomingAdapter(new ArrayList<>());
        List<FinanceListBean> list = viewModel.getUpcoming();
        upcomingAdapter.addData(list);
        binding.upcomingRV.setAdapter(upcomingAdapter);
    }
    private UpcomingAdapter hotAdapter;
    private void initHotRV(){
        binding.hotRV.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL,false));
        hotAdapter = new UpcomingAdapter(new ArrayList<>());
        List<FinanceListBean> list = viewModel.getUpcoming();
        hotAdapter.addData(list);
        binding.hotRV.setAdapter(hotAdapter);
    }

}