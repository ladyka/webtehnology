package org.vurtatoo.ptv4;

public class Calculator {

    public static double getCubeVolume(String a){
        return Math.pow(Double.parseDouble(a), 3);
    }

    public static double getParVolume(String a, String b, String c){
        return Double.parseDouble(a) * Double.parseDouble(b) * Double.parseDouble(c);
    }

    public static double getParallelepipedVolume(String a, String b, String c){
        return Double.parseDouble(a) * Double.parseDouble(b) * Double.parseDouble(c);
    }

    public static double getSphereVolume(String r){
        return 3.14 * Math.pow(Double.parseDouble(r), 3) * 4.0 / 3.0;
    }

    public static double getTorusVolume(String r1, String r2){
        return  2 * 3.14 * 3.14 * Double.parseDouble(r1) * Math.pow(Double.parseDouble(r2), 2);
    }

    public static double getTetrahedronVolume(String a, String b, String c, String h){
        double ad = Double.parseDouble(a);
        double bd = Double.parseDouble(b);
        double cd = Double.parseDouble(c);
        double hd = Double.parseDouble(h);
        double s = Math.sqrt((ad + bd + cd)*(-ad + bd + cd)*(ad - bd + cd)*(ad + bd - cd)) / 4.0;
        return  s * hd / 3.0;
    }
    
}
