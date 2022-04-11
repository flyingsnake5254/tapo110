package com.airbnb.lottie.s.c;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.d;
import com.airbnb.lottie.w.a;

public class h
  extends a<PointF>
{
  @Nullable
  private Path o;
  private final a<PointF> p;
  
  public h(d paramd, a<PointF> parama)
  {
    super(paramd, parama.b, parama.c, parama.d, parama.e, parama.f);
    this.p = parama;
    i();
  }
  
  public void i()
  {
    Object localObject1 = this.c;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = this.b;
      if ((localObject2 != null) && (((PointF)localObject2).equals(((PointF)localObject1).x, ((PointF)localObject1).y)))
      {
        i = 1;
        break label49;
      }
    }
    int i = 0;
    label49:
    localObject1 = this.c;
    if ((localObject1 != null) && (i == 0))
    {
      localObject2 = (PointF)this.b;
      localObject1 = (PointF)localObject1;
      a locala = this.p;
      this.o = com.airbnb.lottie.v.h.d((PointF)localObject2, (PointF)localObject1, locala.m, locala.n);
    }
  }
  
  @Nullable
  Path j()
  {
    return this.o;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\s\c\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */