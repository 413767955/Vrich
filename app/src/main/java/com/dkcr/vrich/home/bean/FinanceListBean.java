package com.dkcr.vrich.home.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author: lyl
 * @Date: 2022/2/14 14:21
 */
@NoArgsConstructor
@Data
public class FinanceListBean {

    private int img;
    private String timeDue;//到期
    private String daileRate;//每日利率
    private int progress;
    private String name;

}
