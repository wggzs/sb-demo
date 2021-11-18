package com.wgg.sb2.util;

import org.springframework.stereotype.Component;

@Component
public class UserSexValidator extends Validator<UserParam> {

    @Override
    void validate(UserParam param) throws BusinessException{
        System.out.println("验证性别");
        if (param == null) {
            throw new BusinessException("");
        }
        //模拟服务，根据userId 查询性别
        boolean isFemale = false;
        if (!isFemale) {
            throw new BusinessException("仅限女性玩家哦！");
        }
    }
}
