package com.tplink.iot.view.ipcamera.widget.touchlayout;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;
import java.lang.ref.WeakReference;

public class TouchListenerRelativeLayout
  extends RelativeLayout
  implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener
{
  private static final int c = ;
  a d;
  GestureDetector f;
  private b q;
  
  public TouchListenerRelativeLayout(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public TouchListenerRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  public TouchListenerRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext);
  }
  
  private void b(Context paramContext)
  {
    setClickable(true);
    this.q = new b(this);
    paramContext = new GestureDetector(paramContext, this);
    this.f = paramContext;
    paramContext.setOnDoubleTapListener(this);
  }
  
  private void c(MotionEvent paramMotionEvent)
  {
    a locala = this.d;
    if (locala != null) {
      locala.X(paramMotionEvent);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    this.f.onTouchEvent(paramMotionEvent);
    this.q.removeMessages(1);
    if (paramMotionEvent.getAction() == 1)
    {
      Message localMessage = this.q.obtainMessage(1);
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("event", paramMotionEvent);
      localMessage.setData(localBundle);
      this.q.sendMessageDelayed(localMessage, c);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    a locala = this.d;
    if (locala != null) {
      locala.c(paramMotionEvent);
    }
    return true;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    a locala = this.d;
    if (locala != null) {
      locala.onSingleTapUp(paramMotionEvent);
    }
    return true;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void setListener(a parama)
  {
    this.d = parama;
  }
  
  public static abstract interface a
  {
    public abstract void X(MotionEvent paramMotionEvent);
    
    public abstract void c(MotionEvent paramMotionEvent);
    
    public abstract void onSingleTapUp(MotionEvent paramMotionEvent);
  }
  
  private static class b
    extends Handler
  {
    private TouchListenerRelativeLayout a;
    
    b(TouchListenerRelativeLayout paramTouchListenerRelativeLayout)
    {
      this.a = ((TouchListenerRelativeLayout)new WeakReference(paramTouchListenerRelativeLayout).get());
    }
    
    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      if ((this.a != null) && (paramMessage.what == 1))
      {
        paramMessage = (MotionEvent)paramMessage.getData().getParcelable("event");
        if (paramMessage != null) {
          TouchListenerRelativeLayout.a(this.a, paramMessage);
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\widget\touchlayout\TouchListenerRelativeLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */