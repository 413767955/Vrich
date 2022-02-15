package com.dkcr.vrich.home.adater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.dkcr.vrich.R;
import com.dkcr.vrich.databinding.ItemHomeFinanceBinding;
import com.dkcr.vrich.home.bean.FinanceListBean;

import java.util.List;


/**
 * @Description:
 * @Author: lyl
 * @Date: 2022/2/14 14:11
 */
public class HomeFinanceAdapter extends BaseQuickAdapter<FinanceListBean, BaseDataBindingHolder<ItemHomeFinanceBinding>> {

    public HomeFinanceAdapter(@Nullable List<FinanceListBean> data) {
        super(R.layout.item_home_finance, data);
    }
/*
    @Override
    protected void convert(@NonNull BaseViewHolder holder, FinanceListBean financeListBean) {
        //holder.setText(R.id.iv_img,financeListBean.getImg());
        holder.setText(R.id.tv_name,financeListBean.getName());
        ((ProgressBar)holder.getView(R.id.progress_bar)).setProgress(30);
    }*/

    @Override
    protected void convert(@NonNull BaseDataBindingHolder<ItemHomeFinanceBinding> bindingHolder, FinanceListBean financeListBean) {
        if (financeListBean == null){
            return;
        }
        ItemHomeFinanceBinding binding = bindingHolder.getDataBinding();
        binding.setBean(financeListBean);

    }
}
