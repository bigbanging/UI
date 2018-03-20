package com.litte.ui.view;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;

import com.litte.ui.R;

/**
 * Created by litte on 2018/3/19.
 */

public class MyEditText extends EditText {

    /**
     * 删除按钮的引用
     */
    private Drawable drawableClean;
    private Context mContext;

    /**
     * 控件是否有焦点
     */
    private boolean hasFocus;

    public MyEditText(Context context) {
        super(context);
    }

    public MyEditText(Context context, AttributeSet attrs) {
        //这个构造方法也很重要，不加这个  很多属性都不能在XML中定义
        super(context, attrs);
        mContext = context;
//        init();
        initial();
    }

    public MyEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
//        init();
        initial();
    }

    private void initial() {
        drawableClean = mContext.getResources().getDrawable(R.drawable.clear_selector);
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setDrawable();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        setDrawable();
    }

    //设置删除图片
    private void setDrawable() {
        if (length()<1){
            setCompoundDrawablesWithIntrinsicBounds(getCompoundDrawables()[0],null,null,null);
        }else {
            setCompoundDrawablesWithIntrinsicBounds(getCompoundDrawables()[0],null,drawableClean,null);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (drawableClean != null && event.getAction() == MotionEvent.ACTION_UP){
            int eventX = (int) event.getRawX();
            int eventY = (int) event.getRawY();
            Log.i("TAG", "onTouchEvent: eventX"+eventX+"eventY:"+eventY);
            Rect rect = new Rect();
            getGlobalVisibleRect(rect);
            rect.left = rect.right-100;
            if (rect.contains(eventX,eventY)) {
                setText("");
            }
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
    /* private void init() {
        //获取EditText的DrawableRight,没有这个设置就使用默认图片
//        drawableClean = getCompoundDrawables()[2];
        drawableClean = mContext.getResources().getDrawable(R.drawable.clear_selector);
        *//*if (drawableClean == null){
            drawableClean = getResources().getDrawable(R.drawable.clear_selector);
        }
        drawableClean.setBounds(0,0,drawableClean.getIntrinsicWidth(),drawableClean.getIntrinsicHeight());*//*
        //默认隐藏图片
        setClearIconVisible(false);
        //设置焦点改变的监听
        setOnFocusChangeListener(this);
        //输入框变化监听
        addTextChangedListener(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (drawableClean != null &event.getAction() == MotionEvent.ACTION_UP){
            int x = (int) event.getX();
            //判断触摸点是否在水平范围内
            boolean isInnerWidth = (x>(getWidth() - getTotalPaddingRight()))&&(x<(getWidth() - getPaddingRight()));
            //获取删除图标的边界，返回一个Rect对象
            Rect rect = drawableClean.getBounds();
            //获取删除图标的高度
            int height = rect.height();
            int y = (int) event.getY();
            //计算图标底部到控件底部的距离
            int distance = (getHeight()-height)/2;
            //判断触摸点是否在竖直范围内
            //触摸点的纵坐标distance到distance+图标自身的高度，则被视为点中了删除按钮图标
            boolean isInnerHeight = (y>distance)&&(y<distance+height);
            if (isInnerWidth&&isInnerHeight){
                this.setText("");
            }
        }
        return super.onTouchEvent(event);
    }

    *//**
     * 设置清除图像的显示与隐藏,运用setCompoundDrawables为EditText绘制上去
     * @param visible
     *//*
    private void setClearIconVisible(boolean visible) {
        Drawable right = visible?drawableClean:null;
        Log.i("TAG", "setClearIconVisible: "+visible);
        setCompoundDrawables(getCompoundDrawables()[0],getCompoundDrawables()[1],right,getCompoundDrawables()[3]);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        this.hasFocus = hasFocus;
        if (hasFocus){
            setClearIconVisible(getText().length()>0);
        }else {
            setClearIconVisible(false);
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (hasFocus){
            setClearIconVisible(s.length()>0);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
    *//**
     * 设置晃动图画
     *//*
    */
     public void setShakeAnimation(){
        this.setAnimation(shakeAnimation(5));
    }

    private Animation shakeAnimation(int counts) {
        Animation translateAnimation = new TranslateAnimation(0,10,0,0);
        translateAnimation.setInterpolator(new CycleInterpolator(counts));
        translateAnimation.setDuration(1000);
        return translateAnimation;
    }
}
