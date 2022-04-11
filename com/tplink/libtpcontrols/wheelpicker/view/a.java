package com.tplink.libtpcontrols.wheelpicker.view;

import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.text.TextPaint;
import android.view.VelocityTracker;
import com.tplink.libtpcontrols.wheelpicker.core.d;
import java.util.HashMap;

class a
  implements c
{
  private final HashMap<Integer, Integer> a = new HashMap();
  
  public void a(d paramd, int paramInt1, int paramInt2)
  {
    paramd.c(paramInt1, 0, paramInt2, 0, 300);
  }
  
  public int b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return (int)(((paramInt1 + 1) * paramInt3 + (paramInt1 - 1) * paramInt2) / 3.141592653589793D);
  }
  
  public void c()
  {
    this.a.clear();
  }
  
  public void d(Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11)
  {
    paramInt1 = (paramInt4 + paramInt1) / 2;
    paramRect.set(paramInt6 - paramInt1, 0, paramInt6 + paramInt1, paramInt3);
  }
  
  public int e(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return paramInt4;
  }
  
  public int f(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt2 + paramInt1;
  }
  
  public int g(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt3;
  }
  
  public void h(Rect paramRect1, Rect paramRect2, Rect paramRect3, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramRect1.set(paramRect3.left, 0, paramRect3.right, paramInt2);
    paramInt1 = paramRect3.left;
    paramInt2 = paramRect3.bottom;
    paramRect2.set(paramInt1, paramInt2 - paramInt4, paramRect3.right, paramInt2);
  }
  
  public int i(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 * 2;
  }
  
  public int j(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    return paramInt1 * paramInt2 + paramInt3 + paramInt5;
  }
  
  public void k(Canvas paramCanvas, TextPaint paramTextPaint, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    paramCanvas.drawText(paramString, paramInt2 + paramInt1, paramInt3, paramTextPaint);
  }
  
  public void l(d paramd, VelocityTracker paramVelocityTracker, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramd.a(paramInt1, 0, (int)paramVelocityTracker.getXVelocity(), 0, paramInt2, paramInt3, 0, 0, paramInt4, 0);
  }
  
  public void m(Camera paramCamera, int paramInt)
  {
    paramCamera.rotateY(paramInt);
  }
  
  public int n(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.containsKey(Integer.valueOf(paramInt1)))
    {
      paramInt1 = ((Integer)this.a.get(Integer.valueOf(paramInt1))).intValue();
    }
    else
    {
      paramInt2 = (int)Math.toDegrees(Math.asin(paramInt1 * 1.0D / paramInt3));
      this.a.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      paramInt1 = paramInt2;
    }
    return paramInt1;
  }
  
  public void o(Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramRect.set(paramRect.left, paramRect.top + paramInt2, paramRect.right, paramRect.bottom - paramInt4);
  }
  
  public int p(d paramd)
  {
    return paramd.d();
  }
  
  public int q(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return (paramInt1 / 2 + 1) * (paramInt3 + paramInt2);
  }
  
  public int r(int paramInt1, int paramInt2)
  {
    return paramInt1;
  }
  
  public int s(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return paramInt3 * paramInt1 + (paramInt1 - 1) * paramInt2;
  }
  
  public void t(Matrix paramMatrix, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = paramInt2 + paramInt1;
    paramMatrix.preTranslate(-paramInt1, -paramInt3);
    paramMatrix.postTranslate(paramInt1, paramInt3);
  }
  
  public int u(int paramInt1, int paramInt2)
  {
    return paramInt1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\wheelpicker\view\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */