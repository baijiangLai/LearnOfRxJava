package com.lixiang.rxjavademo.createOperator.delay;

import android.util.Log;

import com.lixiang.rxjavademo.Constant;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Timer {
    public static void use() {
        // 该例子 = 延迟2s后，发送一个long类型数值
        Observable.timer(2, TimeUnit.SECONDS).subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(Constant.TAG, "开始采用subscribe连接");
            }

            @Override
            public void onNext(Long value) {
                Log.d(Constant.TAG, "接收到了事件" + value);
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

// 注：timer操作符默认运行在一个新线程上
// 也可自定义线程调度器（第3个参数）：timer(long,TimeUnit,Scheduler) 
    }
}
