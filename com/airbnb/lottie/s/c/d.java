package com.airbnb.lottie.s.c;

import com.airbnb.lottie.model.content.c;
import com.airbnb.lottie.w.a;
import java.util.List;

public class d
  extends f<c>
{
  private final c i;
  
  public d(List<a<c>> paramList)
  {
    super(paramList);
    int j = 0;
    paramList = (c)((a)paramList.get(0)).b;
    if (paramList != null) {
      j = paramList.c();
    }
    this.i = new c(new float[j], new int[j]);
  }
  
  c o(a<c> parama, float paramFloat)
  {
    this.i.d((c)parama.b, (c)parama.c, paramFloat);
    return this.i;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\s\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */