/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.businessmanagment.utils;

import java.util.Locale;
import java.util.UUID;
import org.apache.commons.lang3.RandomStringUtils;
/**
 *
 * @author miccarurb
 */
public class UuidHelper {
    public static String generate(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-", "");
    }
    
    public static String generate(int limit){
        return RandomStringUtils.randomAlphanumeric(limit).toUpperCase(Locale.US); 
    }
}
