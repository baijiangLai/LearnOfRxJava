package com.lixiang.rxjavademo.createOperator.normal;

import android.util.Log;

import com.lixiang.rxjavademo.Constant;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class FromIterable {
    public static void use() {
        /*
         * 快速发送集合
         **/
// 1. 设置一个集合
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

// 2. 通过fromIterable()将集合中的对象 / 数据发送出去
        Observable.fromIterable(list)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(Constant.TAG, "开始采用subscribe连接");
                    }

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


//        /*
//         * 集合遍历
//         **/
//        // 1. 设置一个集合
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//
//        // 2. 通过fromIterable()将集合中的对象 / 数据发送出去
//        Observable.fromIterable(list)
//                .subscribe(new Observer<Integer>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "集合遍历");
//                    }
//
//                    @Override
//                    public void onNext(Integer value) {
//                        Log.d(TAG, "集合中的数据元素 = "+ value  );
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "对Error事件作出响应");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "遍历结束");
//                    }
//                });
    }
}
