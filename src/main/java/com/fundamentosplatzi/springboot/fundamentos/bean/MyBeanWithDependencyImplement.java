package com.fundamentosplatzi.springboot.fundamentos.bean;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency {

    Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);
    /*Traigo una Interfaz para utilizar sus metodos*/
    private MyOperation myOperation;
    /*click derecho Generate, luego en Constructor*/
    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        LOGGER.info("Hemos ingresado al metodo printWithDependency");
        int numero=1;
        LOGGER.debug("El número enviado como parametro a la dependencia operation es: " + numero);
        System.out.println("Este es el resultado: " + myOperation.sum(numero));
        System.out.println("Hello since the implement of a bean with dependency");
    }
}
