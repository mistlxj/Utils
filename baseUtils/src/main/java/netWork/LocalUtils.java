package netWork;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * Created by lixiaojian on 2017/3/23.
 */
public class LocalUtils {

    public static String getLocalHostName(){
        String hostName = null ;
        try {
            hostName = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.getMessage();
        }
        return hostName ;
    }

    public static String getLocalIp(){
        try{
            //根据网卡取本机配置的IP
            Enumeration<NetworkInterface> netInterfaces=NetworkInterface.getNetworkInterfaces();
            String ip = null;
            ii: while(netInterfaces.hasMoreElements()){
                NetworkInterface ni=netInterfaces.nextElement();
                Enumeration<InetAddress> ips = ni.getInetAddresses();
                while (ips.hasMoreElements()) {
                    InetAddress ipObj = ips.nextElement();
                    if (ipObj.isSiteLocalAddress()) {
                        ip =  ipObj.getHostAddress();
                        break ii;
                    }
                }
            }
            return ip;
        }catch (Exception e){
            e.getMessage();
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(getLocalHostName() + getLocalIp());
    }
}
