package com.tplink.libtpcontrols;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

public class StretchScrollView
  extends ScrollView
{
  private View c;
  private float d;
  private boolean f = false;
  private int q = 0;
  private int x = 0;
  private Handler y = new a();
  
  public StretchScrollView(Context paramContext)
  {
    super(paramContext);
    g();
  }
  
  public StretchScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    g();
  }
  
  public StretchScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    g();
  }
  
  private void f(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 1)
    {
      if (i == 2)
      {
        float f1 = paramMotionEvent.getY();
        int j = (int)(this.d - f1);
        this.d = f1;
        if (h())
        {
          i = this.c.getScrollY();
          if ((i < 400) && (i > 65136))
          {
            this.c.scrollBy(0, (int)(j * 0.4F));
            this.f = false;
          }
        }
      }
    }
    else
    {
      i = this.c.getScrollY();
      this.q = i;
      if (i != 0)
      {
        this.f = true;
        this.x = ((int)(i / 10.0F));
        this.y.sendEmptyMessage(1);
      }
    }
  }
  
  private void g()
  {
    setOverScrollMode(2);
  }
  
  private boolean h()
  {
    int i = this.c.getMeasuredHeight();
    int j = getHeight();
    int k = getScrollY();
    boolean bool;
    if ((k != 0) && (k != i - j)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (getChildCount() > 0) {
      this.c = getChildAt(0);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      this.d = paramMotionEvent.getY();
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.c != null) {
      f(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  class a
    extends Handler
  {
    a() {}
    
    public void handleMessage(Message paramMessage)
    {
      if ((1 == paramMessage.what) && (StretchScrollView.a(StretchScrollView.this) != 0) && (StretchScrollView.c(StretchScrollView.this)))
      {
        paramMessage = StretchScrollView.this;
        StretchScrollView.b(paramMessage, StretchScrollView.a(paramMessage) - StretchScrollView.d(StretchScrollView.this));
        if (((StretchScrollView.d(StretchScrollView.this) < 0) && (StretchScrollView.a(StretchScrollView.this) > 0)) || ((StretchScrollView.d(StretchScrollView.this) > 0) && (StretchScrollView.a(StretchScrollView.this) < 0))) {
          StretchScrollView.b(StretchScrollView.this, 0);
        }
        StretchScrollView.e(StretchScrollView.this).scrollTo(0, StretchScrollView.a(StretchScrollView.this));
        sendEmptyMessageDelayed(1, 20L);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\StretchScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */