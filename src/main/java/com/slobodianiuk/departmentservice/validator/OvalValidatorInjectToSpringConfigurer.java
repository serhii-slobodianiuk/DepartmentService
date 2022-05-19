package com.slobodianiuk.departmentservice.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.validation.ValidatorAdapter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;

@Component
public class OvalValidatorInjectToSpringConfigurer implements BeanPostProcessor, ApplicationContextAware {
    private static final Logger LOGGER = LoggerFactory.getLogger(OvalValidatorInjectToSpringConfigurer.class);

    private ApplicationContext applicationContext;

    @Override
    public Object postProcessAfterInitialization(@Nullable Object bean, String beanName) throws BeansException {
        //Just for inform list of all beans
//		LOGGER.info("Bean name - {}", beanName);
        if ("mvcValidator".equals(beanName)) {
            //overwrite default mvc validator with oval validator
            LOGGER.info("overwrite default mvc");
            Validator validator = new net.sf.oval.integration.spring.SpringValidator(new net.sf.oval.Validator());
            bean = ValidatorAdapter.get(this.applicationContext, validator);
        }
        return bean;
    }

    @Override
    public void setApplicationContext(@Nullable ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
