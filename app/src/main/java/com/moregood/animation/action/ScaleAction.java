package com.moregood.animation.action;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.moregood.animation.action.Action;

public class ScaleAction extends Action<Float> {
    private ValueAnimator animator;

    public ScaleAction(float startScale,float endScale) {
        animator = ValueAnimator.ofFloat(startScale,endScale);
        animator.setInterpolator(new LinearInterpolator());
    }
    public ScaleAction(float endScale) {
        this(0,endScale);
    }

    @Override
    public ValueAnimator getValueAnimator() {
        return animator;
    }

    @Override
    public void onValueUpdate(View view, Float value) {
        view.setScaleX(value);
        view.setScaleY(value);
    }
}
