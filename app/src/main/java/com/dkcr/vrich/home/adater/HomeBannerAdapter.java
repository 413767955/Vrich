package com.dkcr.vrich.home.adater;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.dkcr.vrich.R;
import com.dkcr.vrich.home.bean.BannerBean;

/**
 * @Description:
 * @Author: lyl
 * @Date: 2022/2/10 16:15
 */
class HomeBannerAdapter extends BaseQuickAdapter<BannerBean, BaseViewHolder> {


    public HomeBannerAdapter() {
        super(R.layout.rv_item_home_banner);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder holder, BannerBean bannerBean) {

    }
}
