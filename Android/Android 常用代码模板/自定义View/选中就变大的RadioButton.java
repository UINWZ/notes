package com.xfhy.daily.ui.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v7.widget.AppCompatRadioButton;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;

/**
 * Created by xfhy on 2017/8/13.
 * �Զ���RadioButton
 * ��ʵ����checked��ʱ��,ͨ�����Զ�����view���
 * ��δѡ��ʱ,��С
 */

public class VariableLargeRadioButton extends AppCompatRadioButton {

    public VariableLargeRadioButton(Context context) {
        super(context);
    }

    public VariableLargeRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VariableLargeRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setChecked(boolean checked) {
        super.setChecked(checked);

        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator scaleX = null;
        ObjectAnimator scaleY = null;
        if (checked) {  //ѡ��ʱ��������   δѡ�����С
            scaleX = ObjectAnimator.ofFloat(this, "scaleX", 1, 1.1f);
            scaleY = ObjectAnimator.ofFloat(this, "scaleY", 1, 1.1f);
        } else {
            scaleX = ObjectAnimator.ofFloat(this, "scaleX", 1, 0.9f);
            scaleY = ObjectAnimator.ofFloat(this, "scaleY", 1, 0.9f);
        }
        animatorSet.setDuration(500);
        //���ò�ֵ��  ������Ѹ�ٱ��,�ټ���
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.play(scaleX).with(scaleY);//��������ͬʱ��ʼ
        animatorSet.start();

    }
}
