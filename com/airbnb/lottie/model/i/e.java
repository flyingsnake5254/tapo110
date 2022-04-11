package com.airbnb.lottie.model.i;

import android.graphics.PointF;
import com.airbnb.lottie.s.c.i;
import com.airbnb.lottie.s.c.j;
import java.util.List;

public class e
  implements m<PointF, PointF>
{
  private final List<com.airbnb.lottie.w.a<PointF>> a;
  
  public e(List<com.airbnb.lottie.w.a<PointF>> paramList)
  {
    this.a = paramList;
  }
  
  public com.airbnb.lottie.s.c.a<PointF, PointF> a()
  {
    if (((com.airbnb.lottie.w.a)this.a.get(0)).h()) {
      return new j(this.a);
    }
    return new i(this.a);
  }
  
  public List<com.airbnb.lottie.w.a<PointF>> b()
  {
    return this.a;
  }
  
  public boolean c()
  {
    int i = this.a.size();
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (i == 1)
    {
      bool2 = bool1;
      if (((com.airbnb.lottie.w.a)this.a.get(0)).h()) {
        bool2 = true;
      }
    }
    return bool2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\model\i\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */