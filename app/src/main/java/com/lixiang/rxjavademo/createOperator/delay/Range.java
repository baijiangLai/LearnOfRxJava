package com.lixiang.rxjavademo.createOperator.delay;

import android.util.Log;

import com.lixiang.rxjavademo.Constant;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Range {
    public static void use() {

// 参数说明：
        // 参数1 = 事件序列起始点；
        // 参数2 = 事件数量；
        // 注：若设置为负数，则会抛出异常
        Observable.range(3, 10)
                // 该例子发送的事件序列特点：从3开始发送，每次发送事件递增1，一共发送10个事件
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(Constant.TAG, "开始采用subscribe连接");
                    }
                    // 默认最先调用复写的 onSubscribe（）

                    @Override
                    public void onNext(Integer value) {
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

    }
}
