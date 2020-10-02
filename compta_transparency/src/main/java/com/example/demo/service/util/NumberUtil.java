package com.example.demo.service.util;
 
 
 
import java.math.BigDecimal;

public class NumberUtil {

    private static final String CHAINE_VIDE = "";

    public static String toString(BigDecimal value) {
        if (value == null) {
            return CHAINE_VIDE;
        } else {
            return String.valueOf(value);
        }
    }

}
