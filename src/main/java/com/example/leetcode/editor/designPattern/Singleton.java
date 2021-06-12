package com.example.leetcode.editor.designPattern;

import java.io.ObjectStreamException;

/**
 * 单例模式
 *
 * @author: lijiawei04
 * @date: 2021/6/10 11:35 上午
 */
public class Singleton {

    // 单例变量
    // volatile防止指令重排，new对象过程非原子，分为三部(1.分配内存 2.实例化 3.返回对象地址给引用)，防止A线程new完对象(只走了1,3)，
    // A认为算初始化完了，但实际上没走2，如果此时B线程去使用这个对象会出NPE
    private static volatile Singleton instance = null;

    // 获取单例模式对象
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    // 私有化构造方法,保证不被其他类使用构造器实例化
    private Singleton() {
        if (instance != null) {
            throw new IllegalStateException();
        }
    }

    // 反序列化流调用，返回指定的对象，防止反序列化破坏单例
    private Object readResolve() throws ObjectStreamException {
        return instance;
    }

}
