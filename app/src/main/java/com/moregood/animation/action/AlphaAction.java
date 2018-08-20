package com.moregood.animation.action;

import android.animation.ValueAnimator;
import android.view.View;

import com.moregood.animation.action.Action;

public class AlphaAction extends Action<Float> {
    private ValueAnimator animator;

    public AlphaAction(float startAlpha,float endAlpha) {
        if(startAlpha<0){
            startAlpha = 0.0f;
        }
        if(startAlpha>1){
            startAlpha = 1.0f;
        }
        if(endAlpha<0){
            endAlpha = 0.0f;
        }
        if(endAlpha>1){
            endAlpha = 1.0f;
        }
        animator = ValueAnimator.ofFloat(startAlpha,endAlpha);
    }
    public AlphaAction(float endAlpha) {
        this(0,endAlpha);
    }

    @Override
    public ValueAnimator getValueAnimator() {
        return animator;
    }

    @Override
    public void onValueUpdate(View view, Float value) {
        view.setAlpha(value.floatValue());
    }


}
