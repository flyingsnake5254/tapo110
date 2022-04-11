package com.airbnb.lottie.s.c;

import android.graphics.Path;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.i.d;
import java.util.ArrayList;
import java.util.List;

public class g
{
  private final List<a<com.airbnb.lottie.model.content.h, Path>> a;
  private final List<a<Integer, Integer>> b;
  private final List<Mask> c;
  
  public g(List<Mask> paramList)
  {
    this.c = paramList;
    this.a = new ArrayList(paramList.size());
    this.b = new ArrayList(paramList.size());
    for (int i = 0; i < paramList.size(); i++)
    {
      this.a.add(((Mask)paramList.get(i)).b().a());
      d locald = ((Mask)paramList.get(i)).c();
      this.b.add(locald.a());
    }
  }
  
  public List<a<com.airbnb.lottie.model.content.h, Path>> a()
  {
    return this.a;
  }
  
  public List<Mask> b()
  {
    return this.c;
  }
  
  public List<a<Integer, Integer>> c()
  {
    return this.b;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\s\c\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */