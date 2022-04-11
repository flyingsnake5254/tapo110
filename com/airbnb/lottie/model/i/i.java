package com.airbnb.lottie.model.i;

import android.graphics.PointF;
import java.util.List;

public class i
  implements m<PointF, PointF>
{
  private final b a;
  private final b b;
  
  public i(b paramb1, b paramb2)
  {
    this.a = paramb1;
    this.b = paramb2;
  }
  
  public com.airbnb.lottie.s.c.a<PointF, PointF> a()
  {
    return new com.airbnb.lottie.s.c.m(this.a.a(), this.b.a());
  }
  
  public List<com.airbnb.lottie.w.a<PointF>> b()
  {
    throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
  }
  
  public boolean c()
  {
    boolean bool;
    if ((this.a.c()) && (this.b.c())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\model\i\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */