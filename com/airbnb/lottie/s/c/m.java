package com.airbnb.lottie.s.c;

import android.graphics.PointF;
import java.util.Collections;
import java.util.List;

public class m
  extends a<PointF, PointF>
{
  private final PointF i = new PointF();
  private final a<Float, Float> j;
  private final a<Float, Float> k;
  
  public m(a<Float, Float> parama1, a<Float, Float> parama2)
  {
    super(Collections.emptyList());
    this.j = parama1;
    this.k = parama2;
    l(f());
  }
  
  public void l(float paramFloat)
  {
    this.j.l(paramFloat);
    this.k.l(paramFloat);
    this.i.set(((Float)this.j.h()).floatValue(), ((Float)this.k.h()).floatValue());
    for (int m = 0; m < this.a.size(); m++) {
      ((a.b)this.a.get(m)).a();
    }
  }
  
  public PointF o()
  {
    return p(null, 0.0F);
  }
  
  PointF p(com.airbnb.lottie.w.a<PointF> parama, float paramFloat)
  {
    return this.i;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\s\c\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */