package com.star.validation;

import com.star.anno.State;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @Classname: StateValidation
 * @Date: 2024/12/2 19:09
 * @Author: 聂建强
 * @Description:
 */
// ConstraintValidator<给哪个注解提供校验规则,校验的数据类型>
public class StateValidation implements ConstraintValidator<State, String> {

    /**
     * 自定义校验规则
     * @param value 将来要校验的数据
     * @param content 对约束进行计算的上下文
     * @return 如果返回false，则校验不通过，如果返回true，则校验通过
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext content) {
        // 提供校验规则
        if (value == null){
            return false;
        }
        if (value.equals("已发布") || value.equals("草稿")){
            return true;
        }
        return false;
    }
}
