package com.tplink.libtpcontrols.wheelpicker.view;

import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.text.TextPaint;
import android.view.VelocityTracker;
import com.tplink.libtpcontrols.wheelpicker.core.d;
import java.util.HashMap;

class b
  implements c
{
  private final HashMap<Integer, Integer> a = new HashMap();
  
  public void a(d paramd, int paramInt1, int paramInt2)
  {
    paramd.c(0, paramInt1, 0, paramInt2, 300);
  }
  
  public int b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return (int)(((paramInt1 + 1) * paramInt4 + (paramInt1 - 1) * paramInt2) / 3.141592653589793D);
  }
  
  public void c()
  {
    this.a.clear();
  }
  
  public void d(Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11)
  {
    paramInt1 = (paramInt5 + paramInt1) / 2;
    paramRect.set(0, paramInt7 - paramInt1 + 20, paramInt2, paramInt7 + paramInt1 - 20);
  }
  
  public int e(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return paramInt4 * paramInt1 + (paramInt1 - 1) * paramInt2;
  }
  
  public int f(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt3 + paramInt1;
  }
  
  public int g(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 * 2;
  }
  
  public void h(Rect paramRect1, Rect paramRect2, Rect paramRect3, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramRect1.set(0, paramRect3.top, paramInt1, paramRect3.bottom);
    paramInt1 = paramRect3.right;
    paramRect2.set(paramInt1 - paramInt3, paramRect3.top, paramInt1, paramRect3.bottom);
  }
  
  public int i(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt2;
  }
  
  public int j(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    return paramInt1 * paramInt2 + paramInt4 + paramInt6;
  }
  
  public void k(Canvas paramCanvas, TextPaint paramTextPaint, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    paramCanvas.drawText(paramString, paramInt2, paramInt3 + paramInt1, paramTextPaint);
  }
  
  public void l(d paramd, VelocityTracker paramVelocityTracker, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramd.a(0, paramInt1, 0, (int)paramVelocityTracker.getYVelocity(), 0, 0, paramInt2, paramInt3, 0, paramInt4);
  }
  
  public void m(Camera paramCamera, int paramInt)
  {
    paramCamera.rotateX(-paramInt);
  }
  
  public int n(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.containsKey(Integer.valueOf(paramInt2)))
    {
      paramInt1 = ((Integer)this.a.get(Integer.valueOf(paramInt2))).intValue();
    }
    else
    {
      paramInt1 = (int)Math.toDegrees(Math.asin(paramInt2 * 1.0D / paramInt3));
      this.a.put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
    }
    return paramInt1;
  }
  
  public void o(Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramRect.set(paramRect.left + paramInt1, paramRect.top, paramRect.right - paramInt3, paramRect.bottom);
  }
  
  public int p(d paramd)
  {
    return paramd.e();
  }
  
  public int q(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return (paramInt1 / 2 + 1) * (paramInt4 + paramInt2);
  }
  
  public int r(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
  
  public int s(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return paramInt3;
  }
  
  public void t(Matrix paramMatrix, int paramInt1, int paramInt2, int paramInt3)
  {
    float f = -paramInt2;
    paramInt1 = paramInt3 + paramInt1;
    paramMatrix.preTranslate(f, -paramInt1);
    paramMatrix.postTranslate(paramInt2, paramInt1);
  }
  
  public int u(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\wheelpicker\view\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */