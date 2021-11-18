package com.wgg.sb2.util;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.ResolvableType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 构造校验类和校验处理器映射
 */
public class ValidatorChain implements ApplicationContextAware {
    private Map<Class, List<Validator>> validatorMap = new HashMap<>();

    /**
     * 根据自定义校验器进行参数校验
     * @param param
     * @param <P>
     */
    public <P> void checkParam(P param) {
        checkParam(param,validator -> true);
    }

    /**
     * 符合某种条件才参数校验
     */
    public <P> void checkParam(P param, Predicate<Validator> predicate){
        List<Validator> validators = getValidators(param.getClass());
        if (CollectionUtils.isNotEmpty(validators)) {
            validators.stream()
                    .filter(predicate)
                    .forEach(validator -> {
                        try {
                            validator.validate(param);
                        } catch (BusinessException e) {
                            e.printStackTrace();
                        }
                    });
        }
    }

    /**
     * 查找相关的所有校验器
     */
    private List<Validator> getValidators(Class<?> clazz) {
        return validatorMap.get(clazz);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, Validator> beansOfType = applicationContext.getBeansOfType(Validator.class);
        /*this.validatorMap = beansOfType.values()
                .stream()
                .collect(Collectors.groupingBy(validator -> getParamType(validator.getClass())));*/
    }

    /**
     * 解析泛型待校验参数类型
     */
    private Object getParamType(Class<? extends Validator> clazz) {
        ResolvableType resolvableType = ResolvableType.forClass(clazz);
        return resolvableType.getSuperType().getGeneric(0).resolve();
    }
}
