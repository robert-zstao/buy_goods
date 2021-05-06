package com.robert.goods.bean.vo;

import lombok.Data;

/**
 * @author robert
 * @date 2021/4/14 18:42
 */

@Data
public class IpVo {
    private String ip;//IP地址
    private String pro;//省
    private String proCode;//省编码
    private String city;//城市
    private String cityCode;//城市编码
    private String region;//区
    private String regionCode;//区编码
    private String addr;//详细地址 + 运营商
    //主要用于接参，无实际意义
    private String regionNames;
    private String err;
}
