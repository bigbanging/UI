package com.litte.ui.layout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import com.litte.ui.R;

/**
 * Created by litte on 2018/3/19.
 */

public class MeiziView extends View {
      float bitmapX;
      float bitmapY;
    public MeiziView(Context context) {
        super(context);
        //图像起始位置
        bitmapX = 0;
        bitmapY = 200;
    }

    /*step 1:先将main.xml布局设置为空白的FrameLayout,为其设置一个图片背景
        step 2:新建一个继承View类的MeziView自定义组件类,在构造方法中初始化view的初始坐标
        step 3:重写onDraw()方法,实例化一个空的画笔类Paint
        step 4:调用BitmapFactory.decodeResource()生成位图对象
        step 5:调用canvas.drawBitmap()绘制妹子的位图对象
        step 6:判断图片上是否回收,否则强制回收图片
        step 7:在主Java代码中获取帧布局对象,并且实例化一个MeziView类
        step 8:会实例化的mezi对象添加一个触摸事件的监听器,重写onTouch方法,改变mezi的X,Y坐标，调用invalidate()重绘方法
        step 9: 将mezi对象添加到帧布局中*/

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //创建并实例化一个画笔
        Paint paint = new Paint();
//        BitmapFactory.decodeResource()生成位图
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.title);
        //绘制图像
        canvas.drawBitmap(bitmap,bitmapX,bitmapY,paint);
        //判断图像是否强制回收，没有回收的话前置回收
        if (bitmap.isRecycled()) {
            bitmap.recycle();
        }

    }
}
