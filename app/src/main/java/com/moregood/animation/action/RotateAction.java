package com.moregood.animation.action;

import android.animation.ValueAnimator;
import android.view.View;

import com.moregood.animation.action.Action;

public class RotateAction extends Action<Float> {
    private ValueAnimator animator;

    public RotateAction(float endAngel) {
        this(0,endAngel);
    }
    public RotateAction(float startAngel,float endAngel) {
        animator = ValueAnimator.ofFloat(startAngel,endAngel);
    }

    @Override
    public ValueAnimator getValueAnimator() {
        return animator;
    }

    @Override
    public void onValueUpdate(View view, Float value) {
        view.setRotation(value.floatValue());
        view.invalidate();
    }
}
