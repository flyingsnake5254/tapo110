package com.scwang.smart.refresh.layout.a;

import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import com.scwang.smart.refresh.layout.c.i;

public abstract interface b
{
  public abstract void c(MotionEvent paramMotionEvent);
  
  public abstract void d(i parami);
  
  public abstract void e(e parame, View paramView1, View paramView2);
  
  public abstract void f(boolean paramBoolean);
  
  public abstract ValueAnimator.AnimatorUpdateListener g(int paramInt);
  
  @NonNull
  public abstract View getView();
  
  @NonNull
  public abstract View h();
  
  public abstract boolean i();
  
  public abstract void j(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract boolean k();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\scwang\smart\refresh\layout\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */