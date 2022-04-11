package com.wdullaer.materialdatetimepicker.time;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class CircleView
  extends View
{
  private final Paint c = new Paint();
  private boolean d;
  private int f;
  private boolean p0;
  private int p1;
  private int p2;
  private int p3;
  private int q;
  private float x;
  private float y;
  private boolean z = false;
  
  public CircleView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if ((getWidth() != 0) && (this.z))
    {
      if (!this.p0)
      {
        this.p1 = (getWidth() / 2);
        int i = getHeight() / 2;
        this.p2 = i;
        i = (int)(Math.min(this.p1, i) * this.x);
        this.p3 = i;
        if (!this.d)
        {
          i = (int)(i * this.y);
          this.p2 = ((int)(this.p2 - i * 0.75D));
        }
        this.p0 = true;
      }
      this.c.setColor(this.f);
      paramCanvas.drawCircle(this.p1, this.p2, this.p3, this.c);
      this.c.setColor(this.q);
      paramCanvas.drawCircle(this.p1, this.p2, 8.0F, this.c);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\wdullaer\materialdatetimepicker\time\CircleView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */