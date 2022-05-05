package com.fundamentosplatzi.springboot.fundamentos.bean;

public class MyFirstBeanAloneWithDependencyImplement implements MyFirstBeanAloneWithDependency {

    private MyFirstBeanAlone myFirstBeanAlone;

    public MyFirstBeanAloneWithDependencyImplement(MyFirstBeanAlone myFirstBeanAlone) {
        this.myFirstBeanAlone = myFirstBeanAlone;
    }

    @Override
    public void unionNumberCharacter(int number) {
        int number2 = 100;
        int sum_numbers = number2 + number;
        String conversion = String.valueOf(sum_numbers);
        String dependenciaTraida = myFirstBeanAlone.union_characters("|2da palabra enviada| ");
        System.out.println("Resultado de bean con Dependencia: \n" + dependenciaTraida + conversion + "¡¡SUPER!!");
    }
}
