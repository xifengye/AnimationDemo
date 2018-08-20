package com.moregood.animation.action;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.moregood.animation.Point;
import com.moregood.animation.evaluator.PointEvaluator;

public  class MoveAction extends Action<Point> {
    private ValueAnimator animator;

    public MoveAction(Point start,Point end) {
        animator =  ValueAnimator.ofObject(new PointEvaluator(),start,end);
        animator.setInterpolator(new LinearInterpolator());
//        animator.setInterpolator(new TimeInterpolator() {
//            @Override
//            public float getInterpolation(float input) {
//                float factor = 0.5f;
//                return (float) (Math.pow(2, -10 * input) * Math.sin((input - factor / 4) * (2 * Math.PI) / factor) + 1);
//            }
//        });
    }

    @Override
    public ValueAnimator getValueAnimator() {
        return animator;
    }

    @Override
    public void onValueUpdate(View view, Point value) {
        view.setX(value.getX());
        view.setY(value.getY());
    }
}
