package com.tplink.libtpcontrols.wheelpicker.view;

import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.text.TextPaint;
import android.view.VelocityTracker;
import com.tplink.libtpcontrols.wheelpicker.core.d;

abstract interface c
{
  public abstract void a(d paramd, int paramInt1, int paramInt2);
  
  public abstract int b(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void c();
  
  public abstract void d(Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11);
  
  public abstract int e(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract int f(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract int g(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void h(Rect paramRect1, Rect paramRect2, Rect paramRect3, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract int i(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract int j(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  public abstract void k(Canvas paramCanvas, TextPaint paramTextPaint, String paramString, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void l(d paramd, VelocityTracker paramVelocityTracker, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void m(Camera paramCamera, int paramInt);
  
  public abstract int n(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void o(Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract int p(d paramd);
  
  public abstract int q(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract int r(int paramInt1, int paramInt2);
  
  public abstract int s(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void t(Matrix paramMatrix, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract int u(int paramInt1, int paramInt2);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\wheelpicker\view\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */