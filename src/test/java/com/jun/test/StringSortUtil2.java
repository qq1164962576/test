package com.jun.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**  
 * ClassName:StringScortUtil <br/>  
 * Function:  <br/>  
 * Date:     Nov 4, 2017 11:37:07 AM <br/>       
 */


public class StringSortUtil2 {
    private static Map<String, Double> tradMap = new HashMap<>();
    static {
        char[] chrabc = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] chrABC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        double i = 1;
        for (char chr : chrabc) {
            String str = chr + "";
            tradMap.put(str, i);
            i++;
        }
        i = 1;
        for (char chr : chrABC) {
            String str = chr + "";
            tradMap.put(str, i);
            i++;
        }
    }

    
    
    
    
    
    /*
     * 
     * */
    public static String[] getSortByDouble(String[] arr) {
        if(arr==null) { return null;}
        Map<Double, String> strMap = new HashMap<>(); 
        
        //用算法将每个字符串对应的数值放进
        for (String str : arr) {
            int k = str.length();
            double count = 0;
            double Jis = 1;
            int m = 1;
            for(int j = 0; j< k ; j++) {
                String z = str.substring(j, j+1);
                double num = tradMap.get(z);
                count = count + num/Jis;
                m = m * 3;
                Jis = m * 26;
            }
            strMap.put(count, str);
        }
        
        //获取键值并排序    
        Set<Double> set = strMap.keySet();
        double[] doubles = new double[set.size()];
        int o = 0;
        for (Double doub : set) {
            doubles[o] = doub;
            o++;
        }
        //给键排序
        Arrays.sort(doubles);
        //将数组顺序封装
        String[] newarr = new String[doubles.length];
        int j = 0;
        for (Double doub : doubles) {
            String str = strMap.get(doub);
            System.out.println(doub);
            newarr[j] = str;
                j++;
        }
        return newarr;
    }
}
  
