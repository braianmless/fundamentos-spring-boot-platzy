package com.fundamentosplatzi.springboot.fundamentos.configuration;

import com.fundamentosplatzi.springboot.fundamentos.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//para configuracion adicional del bean (interfaces a utilizar)
public class MyConfigurationBean {
    @Bean
    public MyBean beanOperation(){
        return new MyBean2Implement();
    }

    @Bean
    public MyOperation beanOperationOperation(){
        return new MyOperationImplement();
    }

    @Bean
    public MyBeanWithDependency beanOperationOperationWithDependency(MyOperation myOperation){
        return new MyBeanWithDependencyImplement(myOperation);
    }

    @Bean
    public MyFirstBeanAlone beanMyFirstOperation(){
        return new MyFirstBeanAloneImplement();
        /*la clase con la implementacion a instanciar*/
    }

    @Bean
    public MyFirstBeanAloneWithDependency beanSecondOperation(MyFirstBeanAlone myFirstBeanAlone){
        return new MyFirstBeanAloneWithDependencyImplement(myFirstBeanAlone);
    }
}
