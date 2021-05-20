package com.robert.goods.rabbit;

import com.robert.goods.bean.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author robert
 * @date 2021/5/18 18:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodMessage {

    private int goodsId;

    private User user;
}
