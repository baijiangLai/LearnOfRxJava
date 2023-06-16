package com.lixiang.rxjavademo.createOperator.delay;

import android.util.Log;

import com.lixiang.rxjavademo.Constant;


import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Defer {
    public static void use() {
//               <-- 1. 第1次对i赋值 ->>
        Integer i = 10;

        // 2. 通过defer 定义被观察者对象
        // 注：此时被观察者对象还没创建
        Integer finalI = i;
        Observable<Integer> observable = Observable.defer(() -> Observable.just(finalI));

//        <-- 2. 第2次对i赋值 ->>
        i = 15;

//        <-- 3. 观察者开始订阅 ->>
        // 注：此时，才会调用defer（）创建被观察者对象（Observable）
        observable.subscribe(new Observer<Integer>() {

            @Override
            public void onSubscribe(Disposable d) {
                Log.d(Constant.TAG, "开始采用subscribe连接");
            }

            @Override
            public void onNext(Integer value) {
                Log.d(Constant.TAG, "接收到的整数是" + value);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(Constant.TAG, "对Error事件作出响应");
            }

            @Override
            public void onComplete() {
                Log.d(Constant.TAG, "对Complete事件作出响应");
            }
        });
    }
}
