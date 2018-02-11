/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivio;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author youne
 */
public class ConvertString {
     public static Date convertStringToDate(String dataString){
         DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
         Date date = null;
         try {
             date = df.parse(dataString);
         } catch (ParseException ex) {
             Logger.getLogger(ConvertString.class.getName()).log(Level.SEVERE, null, ex);
         }
        return date;
    }
}
