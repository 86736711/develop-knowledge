package com.npf.knowledge.demo.java.classload;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.java.classload
 * @ClassName: MyClassLoader
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/1/15 14:36
 * @Version: 1.0
 */
public class MyClassLoader extends ClassLoader {

    private String libPath;

    public MyClassLoader(String path){
     this.libPath =  path;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException{
        String fileName = getFileName(name);
        File file = new File(libPath,fileName);
        try {
            FileInputStream is = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int len = 0;
            try {
                while ((len = is.read()) != -1){
                bos.write(len);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            byte[] data = bos.toByteArray();
            is.close();
            bos.close();
            return defineClass(name,data,0,data.length);
        } catch (IOException e){
            e.printStackTrace();
            return super.findClass(name);
        }
    }


    //获取要加载 的class文件名
    private String getFileName(String name) {

        int index = name.lastIndexOf('.');

        if(index == -1){
            return name+".class";
        }else{
            return name.substring(index+1)+".class";
        }
    }

}
