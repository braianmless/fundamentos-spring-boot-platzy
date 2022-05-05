package com.fundamentosplatzi.springboot.fundamentos.bean;

public class MyFirstBeanAloneImplement implements MyFirstBeanAlone {

    @Override
    public String union_characters(String word) {
        String firstCharacter = "Primera palabra";
        //String cadena = "Union de las palabras \n:" + firstCharacter + " " + word;
        return "Union de las palabras \n:" + firstCharacter + " " + word;
    }
}
