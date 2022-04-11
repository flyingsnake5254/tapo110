package com.airbnb.lottie.s.c;

import android.graphics.Path;
import com.airbnb.lottie.model.content.h;
import com.airbnb.lottie.v.g;
import java.util.List;

public class l
  extends a<h, Path>
{
  private final h i = new h();
  private final Path j = new Path();
  
  public l(List<com.airbnb.lottie.w.a<h>> paramList)
  {
    super(paramList);
  }
  
  public Path o(com.airbnb.lottie.w.a<h> parama, float paramFloat)
  {
    h localh = (h)parama.b;
    parama = (h)parama.c;
    this.i.c(localh, parama, paramFloat);
    g.h(this.i, this.j);
    return this.j;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\s\c\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */