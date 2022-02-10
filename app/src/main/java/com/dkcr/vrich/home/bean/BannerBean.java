package com.dkcr.vrich.home.bean;

/**
 * @Description:
 * @Author: lyl
 * @Date: 2022/2/10 15:01
 */
@lombok.NoArgsConstructor
@lombok.Data
public class BannerBean {

    private String desc;
    private Integer id;
    private String imagePath;
    private Integer isVisible;
    private Integer order;
    private String title;
    private Integer type;
    private String url;
}
