package com.airbnb.lottie.s.c;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.airbnb.lottie.w.c;
import java.util.List;

public class i
  extends f<PointF>
{
  private final PointF i = new PointF();
  private final float[] j = new float[2];
  private h k;
  private PathMeasure l = new PathMeasure();
  
  public i(List<? extends com.airbnb.lottie.w.a<PointF>> paramList)
  {
    super(paramList);
  }
  
  public PointF o(com.airbnb.lottie.w.a<PointF> parama, float paramFloat)
  {
    Object localObject = (h)parama;
    Path localPath = ((h)localObject).j();
    if (localPath == null) {
      return (PointF)parama.b;
    }
    parama = this.e;
    if (parama != null)
    {
      parama = (PointF)parama.b(((com.airbnb.lottie.w.a)localObject).e, ((com.airbnb.lottie.w.a)localObject).f.floatValue(), ((com.airbnb.lottie.w.a)localObject).b, ((com.airbnb.lottie.w.a)localObject).c, e(), paramFloat, f());
      if (parama != null) {
        return parama;
      }
    }
    if (this.k != localObject)
    {
      this.l.setPath(localPath, false);
      this.k = ((h)localObject);
    }
    parama = this.l;
    parama.getPosTan(paramFloat * parama.getLength(), this.j, null);
    parama = this.i;
    localObject = this.j;
    parama.set(localObject[0], localObject[1]);
    return this.i;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\s\c\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */