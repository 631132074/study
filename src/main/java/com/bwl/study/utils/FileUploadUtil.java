package com.bwl.study.utils;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author BW Li
 * @date 2020-07-20 10:44
 * @description  操作远程文件工具
 */
@Configuration
@Component
public class FileUploadUtil {


    static public String ip;

    /**
     * 指定的资源服务器ip
     */
    @Value("${resourceServer.ip}")
    public void setIp(String ip) {
        FileUploadUtil.ip = ip;
    }

    static public Integer port;

    /**
     * 指定的资源服务器端口号
     */
    @Value("${resourceServer.port}")
    public void setPort(Integer port) {
        FileUploadUtil.port = port;
    }

//    static public String path;
//
//    /**指定的资源服务器存放目录*/
//    @Value("${resourceServer.path}")
//    public void setPath(String path) {
//        FileUploadUtil.path = path;
//    }

    static public String user;

    /**
     * 指定的资源服务器用户名
     */
    @Value("${resourceServer.user}")
    public void setUser(String user) {
        FileUploadUtil.user = user;
    }

    static public String password;

    /**
     * 指定的资源服务器用户名
     */
    @Value("${resourceServer.password}")
    public void setPassword(String password) {
        FileUploadUtil.password = password;
    }


    /**
     * 利用JSch包实现SFTP上传文件
     *
     * @param bytes    文件字节流
     * @param fileName 文件名
     * @throws Exception
     */
    public static void fileUpload(byte[] bytes, String path, String fileName) throws Exception {


        Session session = null;
        Channel channel = null;


        JSch jsch = new JSch();


        if (port <= 0) {
            //连接服务器，采用默认端口
            session = jsch.getSession(user, ip);
        } else {
            //采用指定的端口连接服务器
            session = jsch.getSession(user, ip, port);
        }

        //如果服务器连接不上，则抛出异常
        if (session == null) {
            throw new Exception("session is null");
        }

        //设置登陆主机的密码
        session.setPassword(password);
        //设置第一次登陆的时候提示，可选值：(ask | yes | no)
        session.setConfig("StrictHostKeyChecking", "no");
        //设置登陆超时时间
        session.connect(30000);

        OutputStream outstream = null;
        try {
            //创建sftp通信通道
            channel = (Channel) session.openChannel("sftp");
            channel.connect(1000);
            ChannelSftp sftp = (ChannelSftp) channel;


            //进入服务器指定的文件夹
            sftp.cd(path);

            //列出服务器指定的文件列表
//            Vector v = sftp.ls("*");
//            for(int i=0;i<v.size();i++){
//                System.out.println(v.get(i));
//            }

            //以下代码实现从本地上传一个文件到服务器，如果要实现下载，对换以下流就可以了
            outstream = sftp.put(fileName);
            outstream.write(bytes);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关流操作
            if (outstream != null) {
                outstream.flush();
                outstream.close();
            }
            if (session != null) {
                session.disconnect();
            }
            if (channel != null) {
                channel.disconnect();
            }
        }
    }

    public static InputStream getInputStream(String path) throws Exception {


        Session session = null;
        Channel channel = null;


        JSch jsch = new JSch();


        if (port <= 0) {
            //连接服务器，采用默认端口
            session = jsch.getSession(user, ip);
        } else {
            //采用指定的端口连接服务器
            session = jsch.getSession(user, ip, port);
        }

        //如果服务器连接不上，则抛出异常
        if (session == null) {
            throw new Exception("session is null");
        }

        //设置登陆主机的密码
        session.setPassword(password);
        //设置第一次登陆的时候提示，可选值：(ask | yes | no)
        session.setConfig("StrictHostKeyChecking", "no");
        //设置登陆超时时间
        session.connect(30000);

        InputStream inputStream = null;
        try {
            //创建sftp通信通道
            channel = (Channel) session.openChannel("sftp");
            channel.connect(1000);
            ChannelSftp sftp = (ChannelSftp) channel;
            inputStream = sftp.get(path);



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.disconnect();
            }
            if (channel != null) {
                channel.disconnect();
            }
        }
        return inputStream;
    }



}
