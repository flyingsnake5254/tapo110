package com.tplink.iot.devices.lightstrip.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.View;
import java.util.List;
import kotlin.collections.l;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class LightStripDetailBgView
  extends View
{
  private final List<Integer> c = l.h(new Integer[] { Integer.valueOf(-3355444) });
  private final Paint d;
  private boolean f;
  
  public LightStripDetailBgView(Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  public LightStripDetailBgView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  public LightStripDetailBgView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = new Paint();
    paramAttributeSet.setAntiAlias(true);
    paramAttributeSet.setStyle(Paint.Style.FILL);
    paramAttributeSet.setColor((int)4294945485L);
    paramContext = p.a;
    this.d = paramAttributeSet;
  }
  
  private final void a()
  {
    if (!this.f)
    {
      this.f = true;
      if (this.c.size() == 1)
      {
        int i = ((Number)this.c.get(0)).intValue();
        int j = (int)3003121664L;
        int k = ((Number)this.c.get(0)).intValue();
        float f1 = getWidth() / 2.0F;
        float f2 = getHeight() / 2.0F;
        Paint localPaint = this.d;
        float f3 = (float)Math.hypot(f1, f2);
        Shader.TileMode localTileMode = Shader.TileMode.MIRROR;
        localPaint.setShader(new RadialGradient(f1, f2, f3, new int[] { i & 0xFFFFFF | j, 0xFFFFFF & k | 0x8000000 }, null, localTileMode));
      }
      else if (this.c.size() > 1)
      {
        this.d.setShader(new LinearGradient(0.0F, 0.0F, 0.0F, getHeight(), l.R(this.c), null, Shader.TileMode.CLAMP));
      }
      else
      {
        this.d.setShader(null);
        this.d.setColor(-1);
      }
    }
  }
  
  public final void b(List<Integer> paramList)
  {
    j.e(paramList, "colors");
    this.c.clear();
    this.c.addAll(paramList);
    this.f = false;
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    j.e(paramCanvas, "canvas");
    a();
    paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), this.d);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\widget\LightStripDetailBgView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */