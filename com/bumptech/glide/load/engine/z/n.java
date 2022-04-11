package com.bumptech.glide.load.engine.z;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.j;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

@RequiresApi(19)
public class n
  implements l
{
  private static final Bitmap.Config[] a;
  private static final Bitmap.Config[] b;
  private static final Bitmap.Config[] c = { Bitmap.Config.RGB_565 };
  private static final Bitmap.Config[] d = { Bitmap.Config.ARGB_4444 };
  private static final Bitmap.Config[] e = { Bitmap.Config.ALPHA_8 };
  private final c f = new c();
  private final h<b, Bitmap> g = new h();
  private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> h = new HashMap();
  
  static
  {
    Bitmap.Config[] arrayOfConfig1 = new Bitmap.Config[2];
    arrayOfConfig1[0] = Bitmap.Config.ARGB_8888;
    arrayOfConfig1[1] = null;
    Bitmap.Config[] arrayOfConfig2 = arrayOfConfig1;
    if (Build.VERSION.SDK_INT >= 26)
    {
      arrayOfConfig2 = (Bitmap.Config[])Arrays.copyOf(arrayOfConfig1, 3);
      arrayOfConfig2[(arrayOfConfig2.length - 1)] = Bitmap.Config.RGBA_F16;
    }
    a = arrayOfConfig2;
    b = arrayOfConfig2;
  }
  
  private void f(Integer paramInteger, Bitmap paramBitmap)
  {
    NavigableMap localNavigableMap = j(paramBitmap.getConfig());
    Object localObject = (Integer)localNavigableMap.get(paramInteger);
    if (localObject != null)
    {
      if (((Integer)localObject).intValue() == 1) {
        localNavigableMap.remove(paramInteger);
      } else {
        localNavigableMap.put(paramInteger, Integer.valueOf(((Integer)localObject).intValue() - 1));
      }
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Tried to decrement empty size, size: ");
    ((StringBuilder)localObject).append(paramInteger);
    ((StringBuilder)localObject).append(", removed: ");
    ((StringBuilder)localObject).append(a(paramBitmap));
    ((StringBuilder)localObject).append(", this: ");
    ((StringBuilder)localObject).append(this);
    throw new NullPointerException(((StringBuilder)localObject).toString());
  }
  
  private b g(int paramInt, Bitmap.Config paramConfig)
  {
    b localb1 = this.f.e(paramInt, paramConfig);
    Bitmap.Config[] arrayOfConfig = i(paramConfig);
    int i = arrayOfConfig.length;
    b localb2;
    for (int j = 0;; j++)
    {
      localb2 = localb1;
      if (j >= i) {
        break;
      }
      Bitmap.Config localConfig = arrayOfConfig[j];
      Integer localInteger = (Integer)j(localConfig).ceilingKey(Integer.valueOf(paramInt));
      if ((localInteger != null) && (localInteger.intValue() <= paramInt * 8))
      {
        if (localInteger.intValue() == paramInt) {
          if (localConfig == null)
          {
            localb2 = localb1;
            if (paramConfig == null) {
              break;
            }
          }
          else
          {
            localb2 = localb1;
            if (localConfig.equals(paramConfig)) {
              break;
            }
          }
        }
        this.f.c(localb1);
        localb2 = this.f.e(localInteger.intValue(), localConfig);
        break;
      }
    }
    return localb2;
  }
  
  static String h(int paramInt, Bitmap.Config paramConfig)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("](");
    localStringBuilder.append(paramConfig);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  private static Bitmap.Config[] i(Bitmap.Config paramConfig)
  {
    if ((Build.VERSION.SDK_INT >= 26) && (Bitmap.Config.RGBA_F16.equals(paramConfig))) {
      return b;
    }
    int i = a.a[paramConfig.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return new Bitmap.Config[] { paramConfig };
          }
          return e;
        }
        return d;
      }
      return c;
    }
    return a;
  }
  
  private NavigableMap<Integer, Integer> j(Bitmap.Config paramConfig)
  {
    NavigableMap localNavigableMap = (NavigableMap)this.h.get(paramConfig);
    Object localObject = localNavigableMap;
    if (localNavigableMap == null)
    {
      localObject = new TreeMap();
      this.h.put(paramConfig, localObject);
    }
    return (NavigableMap<Integer, Integer>)localObject;
  }
  
  public String a(Bitmap paramBitmap)
  {
    return h(j.h(paramBitmap), paramBitmap.getConfig());
  }
  
  public String b(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    return h(j.g(paramInt1, paramInt2, paramConfig), paramConfig);
  }
  
  public void c(Bitmap paramBitmap)
  {
    int i = j.h(paramBitmap);
    b localb = this.f.e(i, paramBitmap.getConfig());
    this.g.d(localb, paramBitmap);
    NavigableMap localNavigableMap = j(paramBitmap.getConfig());
    paramBitmap = (Integer)localNavigableMap.get(Integer.valueOf(localb.b));
    int j = localb.b;
    i = 1;
    if (paramBitmap != null) {
      i = 1 + paramBitmap.intValue();
    }
    localNavigableMap.put(Integer.valueOf(j), Integer.valueOf(i));
  }
  
  @Nullable
  public Bitmap d(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    b localb = g(j.g(paramInt1, paramInt2, paramConfig), paramConfig);
    Bitmap localBitmap = (Bitmap)this.g.a(localb);
    if (localBitmap != null)
    {
      f(Integer.valueOf(localb.b), localBitmap);
      localBitmap.reconfigure(paramInt1, paramInt2, paramConfig);
    }
    return localBitmap;
  }
  
  public int e(Bitmap paramBitmap)
  {
    return j.h(paramBitmap);
  }
  
  @Nullable
  public Bitmap removeLast()
  {
    Bitmap localBitmap = (Bitmap)this.g.f();
    if (localBitmap != null) {
      f(Integer.valueOf(j.h(localBitmap)), localBitmap);
    }
    return localBitmap;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SizeConfigStrategy{groupedMap=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", sortedSizes=(");
    Iterator localIterator = this.h.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localStringBuilder.append(localEntry.getKey());
      localStringBuilder.append('[');
      localStringBuilder.append(localEntry.getValue());
      localStringBuilder.append("], ");
    }
    if (!this.h.isEmpty()) {
      localStringBuilder.replace(localStringBuilder.length() - 2, localStringBuilder.length(), "");
    }
    localStringBuilder.append(")}");
    return localStringBuilder.toString();
  }
  
  @VisibleForTesting
  static final class b
    implements m
  {
    private final n.c a;
    int b;
    private Bitmap.Config c;
    
    public b(n.c paramc)
    {
      this.a = paramc;
    }
    
    public void a()
    {
      this.a.c(this);
    }
    
    public void b(int paramInt, Bitmap.Config paramConfig)
    {
      this.b = paramInt;
      this.c = paramConfig;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool1 = paramObject instanceof b;
      boolean bool2 = false;
      boolean bool3 = bool2;
      if (bool1)
      {
        paramObject = (b)paramObject;
        bool3 = bool2;
        if (this.b == ((b)paramObject).b)
        {
          bool3 = bool2;
          if (j.d(this.c, ((b)paramObject).c)) {
            bool3 = true;
          }
        }
      }
      return bool3;
    }
    
    public int hashCode()
    {
      int i = this.b;
      Bitmap.Config localConfig = this.c;
      int j;
      if (localConfig != null) {
        j = localConfig.hashCode();
      } else {
        j = 0;
      }
      return i * 31 + j;
    }
    
    public String toString()
    {
      return n.h(this.b, this.c);
    }
  }
  
  @VisibleForTesting
  static class c
    extends d<n.b>
  {
    protected n.b d()
    {
      return new n.b(this);
    }
    
    public n.b e(int paramInt, Bitmap.Config paramConfig)
    {
      n.b localb = (n.b)b();
      localb.b(paramInt, paramConfig);
      return localb;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\engine\z\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */