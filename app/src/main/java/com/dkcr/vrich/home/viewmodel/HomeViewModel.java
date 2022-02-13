package com.dkcr.vrich.home.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.dkcr.vrich.home.bean.BannerBean;
import com.zlx.module_base.base_api.res_data.BannerRes;
import com.zlx.module_base.viewmodel.BaseViewModel;
import com.zlx.module_network.bean.ApiResponse;
import com.zlx.module_network.factory.ApiCallback;

import java.util.List;

/**
 * @Description:
 * @Author: lyl
 * @Date: 2022/2/10 13:54
 */
public class HomeViewModel extends BaseViewModel<HomeRepository> {
    public HomeViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<List<BannerRes>> bannerLiveData = new MutableLiveData<>();

    public void getBanner() {
        model.getBanner(new ApiCallback<List<BannerRes>>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(@NonNull ApiResponse<List<BannerRes>> response) {
                bannerLiveData.postValue(response.getData());
            }

            @Override
            public void onError(@NonNull Throwable t) {
                bannerLiveData.postValue(null);
            }
        });
    }

    public String[] viewFlipperDatas(){
        String datas[] = {"滚动广告数据000001"
                ,"滚动广告数据000002"
                ,"滚动广告数据000003"
                ,"滚动广告数据000004"
                ,"滚动广告数据000005"
                ,"滚动广告数据000006"
                ,"滚动广告数据000007"
                ,"滚动广告数据000008"
                ,"滚动广告数据000009"};
        return datas;
    }
}
