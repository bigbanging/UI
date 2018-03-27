package com.litte.ui.real;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.litte.ui.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 *  输入一个数，计算后通过Toast输出在这个范围内的所有质数
 *  如果是Handler写在了子线程（new Thread）中的话,我们就需要自己创建一个Looper对象了!创建的流程如下:
 * 1 )直接调用Looper.prepare()方法即可为当前线程创建Looper对象,而它的构造器会创建配套的MessageQueue;
 * 2 )创建Handler对象,重写handleMessage( )方法就可以处理来自于其他线程的信息了!
 * 3 )调用Looper.loop()方法启动Looper
 */
public class HandlerActivity extends Activity {

    @BindView(R.id.et_num)
    EditText etNum;
    @BindView(R.id.btn_cal)
    Button btnCal;

    static final String UPPER_NUM = "upper";
    private CalThread calThread;

    //定义一个线程类
    class CalThread extends Thread{
        public Handler mHandler;

        @Override
        public void run() {
            Looper.prepare();
            mHandler = new Handler(){
                @Override
                public void handleMessage(Message msg) {
                    if (msg.what == 0x123){
                        int upper = msg.getData().getInt(UPPER_NUM);
                        List<Integer> nums = new ArrayList<>();
                        //计算从2开始，到upper的所有质数
                        outer:
                        for (int i = 2; i <= upper ; i++) {
                            //用i处于从2开始、到i的平方根的所有数
                            for (int j = 2; j <Math.sqrt(i) ; j++) {
                                //如果可以整除 说明不是质数
                                if (i!=2&&i%j==0){
                                    continue outer;
                                }
                            }
                            nums.add(i);
                        }
                        Toast.makeText(HandlerActivity.this, nums.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
            };
            Looper.loop();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        ButterKnife.bind(this);
        //启动线程
        calThread = new CalThread();
        calThread.start();
    }

    @OnClick(R.id.btn_cal)
    public void onViewClicked() {
        //创建消息
        Message msg = new Message();
        msg.what = 0x123;
        Bundle bundle = new Bundle();
        bundle.putInt(UPPER_NUM,Integer.parseInt(etNum.getText().toString()));
        msg.setData(bundle);
        //向新线程中的handler发送消息
        calThread.mHandler.sendMessage(msg);
    }
}
