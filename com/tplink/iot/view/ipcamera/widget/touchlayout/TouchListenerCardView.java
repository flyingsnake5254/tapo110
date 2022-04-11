package com.tplink.iot.view.ipcamera.widget.touchlayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

public class TouchListenerCardView
  extends CardView
{
  private View.OnTouchListener c;
  
  public TouchListenerCardView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public TouchListenerCardView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TouchListenerCardView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    View.OnTouchListener localOnTouchListener = this.c;
    if (localOnTouchListener != null) {
      localOnTouchListener.onTouch(this, paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool;
    if ((this.c == null) && (!super.onTouchEvent(paramMotionEvent))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public void setDispatchEventListener(View.OnTouchListener paramOnTouchListener)
  {
    this.c = paramOnTouchListener;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\widget\touchlayout\TouchListenerCardView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */