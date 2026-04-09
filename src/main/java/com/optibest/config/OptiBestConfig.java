package com.optibest;

public class OptiBestConfig {
    // Sisin çalışması için gereken değişken
    public static boolean extremeCulling = false;
    
    // Diğer Mixin'lerin (EntityRenderer, ConfigScreen) hata vermemesi için bu ŞART:
    public static boolean aggressiveCulling = false; 
    
    // Sis mesafesi
    public static int renderDistanceLimit = 10;
}
