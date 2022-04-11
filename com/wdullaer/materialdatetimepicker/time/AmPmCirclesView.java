package com.wdullaer.materialdatetimepicker.time;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class AmPmCirclesView
  extends View
{
  private String H3;
  private boolean I3;
  private boolean J3;
  private boolean K3 = false;
  private boolean L3;
  private int M3;
  private int N3;
  private int O3;
  private int P3;
  private int Q3;
  private int R3;
  private final Paint c = new Paint();
  private int d;
  private int f;
  private int p0;
  private float p1;
  private float p2;
  private String p3;
  private int q;
  private int x;
  private int y;
  private int z;
  
  public AmPmCirclesView(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a(float paramFloat1, float paramFloat2)
  {
    if (!this.L3) {
      return -1;
    }
    int i = this.P3;
    i = (int)((paramFloat2 - i) * (paramFloat2 - i));
    int j = this.N3;
    paramFloat2 = j;
    float f1 = j;
    float f2 = i;
    if (((int)Math.sqrt((paramFloat1 - paramFloat2) * (paramFloat1 - f1) + f2) <= this.M3) && (!this.I3)) {
      return 0;
    }
    i = this.O3;
    if (((int)Math.sqrt((paramFloat1 - i) * (paramFloat1 - i) + f2) <= this.M3) && (!this.J3)) {
      return 1;
    }
    return -1;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if ((getWidth() != 0) && (this.K3))
    {
      int m;
      if (!this.L3)
      {
        i = getWidth() / 2;
        j = getHeight() / 2;
        k = (int)(Math.min(i, j) * this.p1);
        m = (int)(k * this.p2);
        this.M3 = m;
        j = (int)(j + m * 0.75D);
        m = m * 3 / 4;
        this.c.setTextSize(m);
        m = this.M3;
        this.P3 = (j - m / 2 + k);
        this.N3 = (i - k + m);
        this.O3 = (i + k - m);
        this.L3 = true;
      }
      int i = this.q;
      int n = this.x;
      int k = this.Q3;
      int i1;
      int i2;
      int i3;
      if (k == 0)
      {
        j = this.p0;
        m = this.d;
        i1 = this.y;
        i2 = i;
        i3 = 255;
        k = n;
        n = i1;
      }
      else if (k == 1)
      {
        i2 = this.p0;
        i3 = this.d;
        k = this.y;
        m = 255;
        j = i;
      }
      else
      {
        j = i;
        i2 = j;
        k = n;
        m = 255;
        i3 = 255;
      }
      int i4 = this.R3;
      int i5;
      if (i4 == 0)
      {
        i1 = this.f;
        i5 = this.d;
      }
      else
      {
        i1 = j;
        i5 = m;
        if (i4 == 1)
        {
          i2 = this.f;
          i3 = this.d;
          i5 = m;
          i1 = j;
        }
      }
      if (this.I3)
      {
        n = this.z;
        i1 = i;
      }
      if (this.J3) {
        k = this.z;
      } else {
        i = i2;
      }
      this.c.setColor(i1);
      this.c.setAlpha(i5);
      paramCanvas.drawCircle(this.N3, this.P3, this.M3, this.c);
      this.c.setColor(i);
      this.c.setAlpha(i3);
      paramCanvas.drawCircle(this.O3, this.P3, this.M3, this.c);
      this.c.setColor(n);
      i = this.P3;
      int j = (int)(this.c.descent() + this.c.ascent()) / 2;
      String str = this.p3;
      float f1 = this.N3;
      float f2 = i - j;
      paramCanvas.drawText(str, f1, f2, this.c);
      this.c.setColor(k);
      paramCanvas.drawText(this.H3, this.O3, f2, this.c);
    }
  }
  
  public void setAmOrPm(int paramInt)
  {
    this.Q3 = paramInt;
  }
  
  public void setAmOrPmPressed(int paramInt)
  {
    this.R3 = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\wdullaer\materialdatetimepicker\time\AmPmCirclesView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */