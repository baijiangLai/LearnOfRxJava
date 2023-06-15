package com.lixiang.rxjavademo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jakewharton.rxbinding2.widget.RxTextView;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class FirstUseActivity extends AppCompatActivity {
    private String TAG = "RxJava";
    EditText ed;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_use);

        ed = this.findViewById(R.id.ed);
        tv = this.findViewById(R.id.tv);

        // 使用 RxBinding 监听 EditText 文本变化
        RxTextView.textChanges(ed)
                .debounce(1, TimeUnit.SECONDS) // 防抖动，等待1秒钟
                .skip(1) // 跳过初始值
                .observeOn(AndroidSchedulers.mainThread()) // 在主线程观察结果
                .subscribe(new Observer<CharSequence>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        // 订阅开始时执行
                    }

                    @Override
                    public void onNext(CharSequence value) {
                        // 当文本变化时执行
                        tv.setText("发送给服务器的字符 = " + value.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        // 发生错误时执行
                        Log.e(TAG, "onError: ");
                    }

                    @Override
                    public void onComplete() {
                        // 完成事件时执行
                        Log.d(TAG, "对Complete事件作出响应");
                    }
                });
    }
}