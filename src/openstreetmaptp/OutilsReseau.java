/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package openstreetmaptp;

/**
 *
 * @author guillaume.laurent
 */
public class OutilsReseau {

    public static void utiliserProxy(String proxyHost, String proxyPort) {
        java.util.Properties properties = System.getProperties();
        properties.put("https.proxyHost", proxyHost);
        properties.put("https.proxyPort", proxyPort);
        properties.put("http.proxyHost", proxyHost);
        properties.put("http.proxyPort", proxyPort);
        System.setProperties(properties);
    }

    public static void utiliserProxyENSMM() {
       utiliserProxy("proxy-www.ens2m.fr","3128");
    }

}
