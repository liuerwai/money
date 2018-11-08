package com.liuxg.money.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializerUtills {


    /**
     * 保存序列化对象
     *
     * @param object
     * @param path
     * @return
     */
    public static synchronized int save(Object object, String path) {

        try {
            FileOutputStream fileOut =
                    new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(object);
            out.close();
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    /**
     * 查询序列化对象
     *
     * @param path
     * @return
     */
    public static synchronized Object get(String path) {

        try {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Object object = in.readObject();
            in.close();
            fileIn.close();
            return object;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
