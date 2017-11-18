package demo.studydemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2017/3/16.
 */
public class MyView extends View {
    private float ScalX=100;
    private float ScalY=100;
    Paint paint=new Paint();
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.RED);
        paint.setAlpha(50);
        canvas.drawCircle(ScalX,ScalY,80,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        ScalX=event.getX();
        ScalY=event.getY();
        invalidate();
        return true;
    }
}
