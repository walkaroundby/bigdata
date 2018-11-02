package com.stormdemo.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

/**
 * Created by Administrator on 2017/4/1.
 */
public class Util {

    //主机名
    public static String getHostname()  {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null ;
    }

    /**
     * 返回进程pid
     */
    public static String getPID(){
        String info = ManagementFactory.getRuntimeMXBean().getName();
        return info.split("@")[0] ;
    }

    //线程信息
    public static String getTID(){
        return Thread.currentThread().getName() ;
    }

    //对象信息
    public static String getOID(Object obj ){
        String cname = obj.getClass().getSimpleName();
        int hash = obj.hashCode() ;
        return cname + "@" + hash ;
    }

    public static String info(Object obj , String msg){
        return new Date()+"\t"+getHostname() + "\t" + getPID() + "\t" + getTID() + "\t" + getOID(obj) + "\t" + msg ;
    }

    /**
     * 向远端发送sock消息
     */
    static File file = new File("/home/record.log");
    public static void sendToClient(Object obj,String msg,int port ){
        try {
            OutputStream out=new FileOutputStream(file,true);
            String info = info(obj,msg);
            out.write((info + "\r\n").getBytes());
//            Socket sock = new Socket("s1", port);
//            OutputStream os = sock.getOutputStream();
//            os.write((info + "\r\n").getBytes());
//            os.flush();
//            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
