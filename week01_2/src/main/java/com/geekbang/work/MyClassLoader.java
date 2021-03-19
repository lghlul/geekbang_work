package com.geekbang.work;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

public class MyClassLoader extends ClassLoader {


    public static void main(String[] args) throws Exception {
        Class<?> helloClazz = new MyClassLoader().findClass("Hello");
        Method method = helloClazz.getDeclaredMethod("hello");
        method.invoke(helloClazz.getDeclaredConstructor().newInstance());
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String resourcePath = name.replace(".", "/");
        InputStream inputStream = MyClassLoader.class.getClassLoader().getResourceAsStream(resourcePath + ".xlass");
        try {
            int length = inputStream.available();
            byte[] bytes = new byte[length];
            inputStream.read(bytes);
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) (255 - bytes[i]);
            }
            return defineClass(name, bytes, 0, bytes.length);
        } catch (IOException e) {
            throw new ClassNotFoundException(name, e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
