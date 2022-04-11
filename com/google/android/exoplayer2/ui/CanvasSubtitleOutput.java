package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.text.c.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class CanvasSubtitleOutput
  extends View
  implements SubtitleView.a
{
  private final List<w0> c = new ArrayList();
  private List<c> d = Collections.emptyList();
  private int f = 0;
  private float q = 0.0533F;
  private f0 x = f0.a;
  private float y = 0.08F;
  
  public CanvasSubtitleOutput(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CanvasSubtitleOutput(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private static c b(c paramc)
  {
    c.b localb = paramc.a().k(-3.4028235E38F).l(Integer.MIN_VALUE).p(null);
    if (paramc.h == 0) {
      localb.h(1.0F - paramc.g, 0);
    } else {
      localb.h(-paramc.g - 1.0F, 1);
    }
    int i = paramc.i;
    if (i != 0)
    {
      if (i == 2) {
        localb.i(0);
      }
    }
    else {
      localb.i(2);
    }
    return localb.a();
  }
  
  public void a(List<c> paramList, f0 paramf0, float paramFloat1, int paramInt, float paramFloat2)
  {
    this.d = paramList;
    this.x = paramf0;
    this.q = paramFloat1;
    this.f = paramInt;
    this.y = paramFloat2;
    while (this.c.size() < paramList.size()) {
      this.c.add(new w0(getContext()));
    }
    invalidate();
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    List localList = this.d;
    if (localList.isEmpty()) {
      return;
    }
    int i = getHeight();
    int j = getPaddingLeft();
    int k = getPaddingTop();
    int m = getWidth() - getPaddingRight();
    int n = i - getPaddingBottom();
    if ((n > k) && (m > j))
    {
      int i1 = n - k;
      float f1 = x0.f(this.f, this.q, i, i1);
      if (f1 <= 0.0F) {
        return;
      }
      int i2 = localList.size();
      for (int i3 = 0; i3 < i2; i3++)
      {
        c localc1 = (c)localList.get(i3);
        c localc2 = localc1;
        if (localc1.r != Integer.MIN_VALUE) {
          localc2 = b(localc1);
        }
        float f2 = x0.f(localc2.p, localc2.q, i, i1);
        ((w0)this.c.get(i3)).b(localc2, this.x, f1, f2, this.y, paramCanvas, j, k, m, n);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\ui\CanvasSubtitleOutput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */