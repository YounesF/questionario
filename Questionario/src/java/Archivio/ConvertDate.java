/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivio;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author firari.younes
 */
public class ConvertDate {
   public static String convertStringToDate(Date indate){
        String dateString = null;
        SimpleDateFormat sdfr = new SimpleDateFormat("yyyy/MM/dd");
        /*you can also use DateFormat reference instead of SimpleDateFormat 
         * like this: DateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
         */
        try{
             dateString = sdfr.format( indate );
        }catch (Exception ex ){
             System.out.println(ex);
        }
        return dateString;
    }
}
