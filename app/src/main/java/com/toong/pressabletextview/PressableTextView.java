package com.toong.pressabletextview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 *
 */
public class PressableTextView extends TextView {
    private static final float DEFAULT_ALPHA_WHEN_PRESS = 0.5f;
    private static final float DEFAULT_ALPHA = 1f;

    public PressableTextView(Context context) {
        super(context);
    }

    public PressableTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PressableTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    private void refresh() {
        if (isPressed()) {
            setAlpha(DEFAULT_ALPHA_WHEN_PRESS);
            invalidate();
            return;
        }
        setAlpha(DEFAULT_ALPHA);
        invalidate();
    }

    @Override
    public void setPressed(boolean pressed) {
        super.setPressed(pressed);
        refresh();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
            Log.d("TouchTest", "Touch down");
            setPressed(true);
        } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
            Log.d("TouchTest", "Touch up");
            setPressed(false);
        }
        return true;
    }
}
