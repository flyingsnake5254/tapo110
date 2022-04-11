package com.airbnb.lottie;

import androidx.collection.ArraySet;
import androidx.core.util.Pair;
import com.airbnb.lottie.v.f;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class n
{
  private boolean a = false;
  private final Set<b> b = new ArraySet();
  private final Map<String, f> c = new HashMap();
  private final Comparator<Pair<String, Float>> d = new a();
  
  public void a(String paramString, float paramFloat)
  {
    if (!this.a) {
      return;
    }
    f localf1 = (f)this.c.get(paramString);
    f localf2 = localf1;
    if (localf1 == null)
    {
      localf2 = new f();
      this.c.put(paramString, localf2);
    }
    localf2.a(paramFloat);
    if (paramString.equals("__container"))
    {
      paramString = this.b.iterator();
      while (paramString.hasNext()) {
        ((b)paramString.next()).a(paramFloat);
      }
    }
  }
  
  void b(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  class a
    implements Comparator<Pair<String, Float>>
  {
    a() {}
    
    public int a(Pair<String, Float> paramPair1, Pair<String, Float> paramPair2)
    {
      float f1 = ((Float)paramPair1.second).floatValue();
      float f2 = ((Float)paramPair2.second).floatValue();
      if (f2 > f1) {
        return 1;
      }
      if (f1 > f2) {
        return -1;
      }
      return 0;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(float paramFloat);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */