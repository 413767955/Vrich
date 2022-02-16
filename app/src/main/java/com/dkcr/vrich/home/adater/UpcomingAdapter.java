package com.dkcr.vrich.home.adater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.dkcr.vrich.R;
import com.dkcr.vrich.databinding.ItemUpcomingRvBinding;
import com.dkcr.vrich.home.bean.FinanceListBean;

import java.util.List;

/**
 * @Description:
 * @Author: lyl
 * @Date: 2022/2/16 11:35
 */
public class UpcomingAdapter extends BaseQuickAdapter<FinanceListBean, BaseDataBindingHolder<ItemUpcomingRvBinding>> {
    public UpcomingAdapter(@Nullable List<FinanceListBean> data) {
        super(R.layout.item_upcoming_rv, data);
    }

    @Override
    protected void convert(@NonNull BaseDataBindingHolder<ItemUpcomingRvBinding> itemUpcomingRvBindingBaseDataBindingHolder, FinanceListBean financeListBean) {

    }
}
