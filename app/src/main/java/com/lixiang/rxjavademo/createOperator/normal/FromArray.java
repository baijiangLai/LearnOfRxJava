package com.lixiang.rxjavademo.createOperator.normal;

import android.util.Log;

import com.lixiang.rxjavademo.Constant;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class FromArray {
    public static void use() {
        // 1. 设置需要传入的数组
        Integer[] items = {0, 1, 2, 3, 4};

        // 2. 创建被观察者对象（Observable）时传入数组
        // 在创建后就会将该数组转换成Observable & 发送该对象中的所有数据
        Observable.fromArray(items)
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
    }

// 注：
// 可发送10个以上参数
// 若直接传递一个list集合进去，否则会直接把list当做一个数据元素发送

//    /*
//     * 数组遍历
//     **/
//    // 1. 设置需要传入的数组
//    Integer[] items = {0, 1, 2, 3, 4};
//
//    // 2. 创建被观察者对象（Observable）时传入数组
//    // 在创建后就会将该数组转换成Observable & 发送该对象中的所有数据
//        Observable.fromArray(items)
//            .
//
//    subscribe(new Observer<Integer>() {
//        @Override
//        public void onSubscribe (Disposable d){
//            Log.d(TAG, "数组遍历");
//        }
//
//        @Override
//        public void onNext (Integer value){
//            Log.d(TAG, "数组中的元素 = " + value);
//        }
//
//        @Override
//        public void onError (Throwable e){
//            Log.d(TAG, "对Error事件作出响应");
//        }
//
//        @Override
//        public void onComplete () {
//            Log.d(TAG, "遍历结束");
//        }
//
//    });

}
