package com.airbnb.lottie;

import android.content.Context;
import android.graphics.Rect;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.model.b;
import com.airbnb.lottie.model.c;
import com.airbnb.lottie.model.layer.Layer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class d
{
  private final n a = new n();
  private final HashSet<String> b = new HashSet();
  private Map<String, List<Layer>> c;
  private Map<String, g> d;
  private Map<String, b> e;
  private List<com.airbnb.lottie.model.g> f;
  private SparseArrayCompat<c> g;
  private LongSparseArray<Layer> h;
  private List<Layer> i;
  private Rect j;
  private float k;
  private float l;
  private float m;
  private boolean n;
  private int o = 0;
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public void a(String paramString)
  {
    com.airbnb.lottie.v.d.c(paramString);
    this.b.add(paramString);
  }
  
  public Rect b()
  {
    return this.j;
  }
  
  public SparseArrayCompat<c> c()
  {
    return this.g;
  }
  
  public float d()
  {
    return (float)(e() / this.m * 1000.0F);
  }
  
  public float e()
  {
    return this.l - this.k;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public float f()
  {
    return this.l;
  }
  
  public Map<String, b> g()
  {
    return this.e;
  }
  
  public float h()
  {
    return this.m;
  }
  
  public Map<String, g> i()
  {
    return this.d;
  }
  
  public List<Layer> j()
  {
    return this.i;
  }
  
  @Nullable
  public com.airbnb.lottie.model.g k(String paramString)
  {
    this.f.size();
    for (int i1 = 0; i1 < this.f.size(); i1++)
    {
      com.airbnb.lottie.model.g localg = (com.airbnb.lottie.model.g)this.f.get(i1);
      if (localg.a(paramString)) {
        return localg;
      }
    }
    return null;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public int l()
  {
    return this.o;
  }
  
  public n m()
  {
    return this.a;
  }
  
  @Nullable
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public List<Layer> n(String paramString)
  {
    return (List)this.c.get(paramString);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public float o()
  {
    return this.k;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public boolean p()
  {
    return this.n;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public void q(int paramInt)
  {
    this.o += paramInt;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public void r(Rect paramRect, float paramFloat1, float paramFloat2, float paramFloat3, List<Layer> paramList, LongSparseArray<Layer> paramLongSparseArray, Map<String, List<Layer>> paramMap, Map<String, g> paramMap1, SparseArrayCompat<c> paramSparseArrayCompat, Map<String, b> paramMap2, List<com.airbnb.lottie.model.g> paramList1)
  {
    this.j = paramRect;
    this.k = paramFloat1;
    this.l = paramFloat2;
    this.m = paramFloat3;
    this.i = paramList;
    this.h = paramLongSparseArray;
    this.c = paramMap;
    this.d = paramMap1;
    this.g = paramSparseArrayCompat;
    this.e = paramMap2;
    this.f = paramList1;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public Layer s(long paramLong)
  {
    return (Layer)this.h.get(paramLong);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public void t(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("LottieComposition:\n");
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((Layer)localIterator.next()).w("\t"));
    }
    return localStringBuilder.toString();
  }
  
  public void u(boolean paramBoolean)
  {
    this.a.b(paramBoolean);
  }
  
  @Deprecated
  public static class a
  {
    @Deprecated
    @Nullable
    @WorkerThread
    public static d a(Context paramContext, String paramString)
    {
      return (d)e.f(paramContext, paramString).b();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */