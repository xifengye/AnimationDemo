package com.moregood.animation.action;

import android.animation.ValueAnimator;
import android.view.View;

import com.moregood.animation.Point;

public abstract class Action<T> {
    private int mDuration;
    private int mRepeatMode;
    private int mRepeatCount;

    public int getDuration() {
        return mDuration;
    }

    public void setDuration(int duration) {
        this.mDuration = duration;
    }

    public int getRepeatMode() {
        return mRepeatMode;
    }

    public void setRepeatMode(int repeatMode) {
        this.mRepeatMode = repeatMode;
    }

    public int getRepeatCount() {
        return mRepeatCount;
    }

    public void setRepeatCount(int repeatCount) {
        this.mRepeatCount = repeatCount;
    }

    public abstract ValueAnimator getValueAnimator();
    public abstract void onValueUpdate(View view,T value);

    public void run(final View view){
        ValueAnimator animator = getValueAnimator();
        animator.setDuration(mDuration);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                onValueUpdate(view,(T)valueAnimator.getAnimatedValue());
            }
        });
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.start();
    }

    public static void runAlpha(View view,int during,float end){
        runAlpha(view,during,0,end);
    }
    public static void runAlpha(View view,int during,float start,float end){
        AlphaAction action = new AlphaAction(start,end);
        action.setDuration(during);
        action.run(view);
    }
    public static void runScale(View view,int during,float end){
        runScale(view,during,0,end);
    }
    public static void runScale(View view,int during,float start,float end){
        ScaleAction action = new ScaleAction(start,end);
        action.setDuration(during);
        action.run(view);
    }

    public static void runRotate(View view,int during,float end){
        runRotate(view,during,0,end);
    }

    public static void runRotate(View view,int during,float start,float end){
        RotateAction action = new RotateAction(start,end);
        action.setDuration(during);
        action.run(view);
    }

    public static void runMove(View view,int during,Point end){
        runMove(view,during,new Point(view.getX(),view.getY()),end);
    }

    public static void runMove(View view,int during,Point start,Point end){
        MoveAction action = new MoveAction(start,end);
        action.setDuration(during);
        action.run(view);
    }
}
