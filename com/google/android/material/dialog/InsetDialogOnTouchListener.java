package com.google.android.material.dialog;

import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class InsetDialogOnTouchListener
  implements View.OnTouchListener
{
  @NonNull
  private final Dialog dialog;
  private final int leftInset;
  private final int prePieSlop;
  private final int topInset;
  
  public InsetDialogOnTouchListener(@NonNull Dialog paramDialog, @NonNull Rect paramRect)
  {
    this.dialog = paramDialog;
    this.leftInset = paramRect.left;
    this.topInset = paramRect.top;
    this.prePieSlop = ViewConfiguration.get(paramDialog.getContext()).getScaledWindowTouchSlop();
  }
  
  public boolean onTouch(@NonNull View paramView, @NonNull MotionEvent paramMotionEvent)
  {
    Object localObject = paramView.findViewById(16908290);
    int i = this.leftInset + ((View)localObject).getLeft();
    int j = ((View)localObject).getWidth();
    int k = this.topInset + ((View)localObject).getTop();
    int m = ((View)localObject).getHeight();
    if (new RectF(i, k, j + i, m + k).contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
      return false;
    }
    localObject = MotionEvent.obtain(paramMotionEvent);
    if (paramMotionEvent.getAction() == 1) {
      ((MotionEvent)localObject).setAction(4);
    }
    if (Build.VERSION.SDK_INT < 28)
    {
      ((MotionEvent)localObject).setAction(0);
      k = this.prePieSlop;
      ((MotionEvent)localObject).setLocation(-k - 1, -k - 1);
    }
    paramView.performClick();
    return this.dialog.onTouchEvent((MotionEvent)localObject);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\dialog\InsetDialogOnTouchListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */