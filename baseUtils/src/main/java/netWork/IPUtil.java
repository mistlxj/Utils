package netWork;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * Created by lixiaojian on 2017/2/21.
 */
public final class IPUtil {

    public static final String LOCAL_IP = getLocalIp();

    public static final String LOCAL_HOST = getLocalHostName();


    public static void main(String[] args) {
        System.out.println(LOCAL_IP);
        System.out.println(LOCAL_HOST);
    }


    /**
     * 获取本机ip地址
     * 此方法为重量级的方法，不要频繁调用
     */
    public static String getLocalIp(){
        try{
            //根据网卡取本机配置的IP
            Enumeration<NetworkInterface> netInterfaces=NetworkInterface.getNetworkInterfaces();
            String ip = null;
            a: while(netInterfaces.hasMoreElements()){
                NetworkInterface ni=netInterfaces.nextElement();
                Enumeration<InetAddress> ips = ni.getInetAddresses();
                while (ips.hasMoreElements()) {
                    InetAddress ipObj = ips.nextElement();
                    if (ipObj.isSiteLocalAddress()) {
                        ip =  ipObj.getHostAddress();
                        break a;
                    }
                }
            }
            return ip;
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 获取本地机器名
     * 此方法为重量级的方法，不要频繁调用
     * 一般耗时在百毫秒，缓存使用
     * @return
     * @throws java.net.UnknownHostException
     */
    public static String getLocalHostName(){

        String hostName = null ;
        try {
            hostName = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            System.out.println("get hostname error");
        }
        System.out.println("get local hostName ：" + hostName);

        return hostName ;
    }
}
