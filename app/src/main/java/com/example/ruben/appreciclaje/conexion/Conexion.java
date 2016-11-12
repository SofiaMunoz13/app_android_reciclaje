package com.example.ruben.appreciclaje.conexion;

public class Conexion {

    private static String ip="http://192.168.1.37/";
    private static String dirUser="sider/";
    private static String[] pagina={"insertSession", "insertMesaje"};
    private static String urlServer=ip+dirUser;

    public static String getUrlServer(int i) {
        String res="";
        if (pagina.length>=i)
            res=urlServer+pagina[i];
        return res;
    }
}
