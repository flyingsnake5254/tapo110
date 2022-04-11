package com.airbnb.lottie.model.layer;

import androidx.annotation.Nullable;
import com.airbnb.lottie.d;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.i.j;
import com.airbnb.lottie.model.i.k;
import com.airbnb.lottie.model.i.l;
import com.airbnb.lottie.w.a;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class Layer
{
  private final List<com.airbnb.lottie.model.content.b> a;
  private final d b;
  private final String c;
  private final long d;
  private final LayerType e;
  private final long f;
  @Nullable
  private final String g;
  private final List<Mask> h;
  private final l i;
  private final int j;
  private final int k;
  private final int l;
  private final float m;
  private final float n;
  private final int o;
  private final int p;
  @Nullable
  private final j q;
  @Nullable
  private final k r;
  @Nullable
  private final com.airbnb.lottie.model.i.b s;
  private final List<a<Float>> t;
  private final MatteType u;
  private final boolean v;
  
  public Layer(List<com.airbnb.lottie.model.content.b> paramList, d paramd, String paramString1, long paramLong1, LayerType paramLayerType, long paramLong2, @Nullable String paramString2, List<Mask> paramList1, l paraml, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, int paramInt4, int paramInt5, @Nullable j paramj, @Nullable k paramk, List<a<Float>> paramList2, MatteType paramMatteType, @Nullable com.airbnb.lottie.model.i.b paramb, boolean paramBoolean)
  {
    this.a = paramList;
    this.b = paramd;
    this.c = paramString1;
    this.d = paramLong1;
    this.e = paramLayerType;
    this.f = paramLong2;
    this.g = paramString2;
    this.h = paramList1;
    this.i = paraml;
    this.j = paramInt1;
    this.k = paramInt2;
    this.l = paramInt3;
    this.m = paramFloat1;
    this.n = paramFloat2;
    this.o = paramInt4;
    this.p = paramInt5;
    this.q = paramj;
    this.r = paramk;
    this.t = paramList2;
    this.u = paramMatteType;
    this.s = paramb;
    this.v = paramBoolean;
  }
  
  d a()
  {
    return this.b;
  }
  
  public long b()
  {
    return this.d;
  }
  
  List<a<Float>> c()
  {
    return this.t;
  }
  
  public LayerType d()
  {
    return this.e;
  }
  
  List<Mask> e()
  {
    return this.h;
  }
  
  MatteType f()
  {
    return this.u;
  }
  
  String g()
  {
    return this.c;
  }
  
  long h()
  {
    return this.f;
  }
  
  int i()
  {
    return this.p;
  }
  
  int j()
  {
    return this.o;
  }
  
  @Nullable
  String k()
  {
    return this.g;
  }
  
  List<com.airbnb.lottie.model.content.b> l()
  {
    return this.a;
  }
  
  int m()
  {
    return this.l;
  }
  
  int n()
  {
    return this.k;
  }
  
  int o()
  {
    return this.j;
  }
  
  float p()
  {
    return this.n / this.b.e();
  }
  
  @Nullable
  j q()
  {
    return this.q;
  }
  
  @Nullable
  k r()
  {
    return this.r;
  }
  
  @Nullable
  com.airbnb.lottie.model.i.b s()
  {
    return this.s;
  }
  
  float t()
  {
    return this.m;
  }
  
  public String toString()
  {
    return w("");
  }
  
  l u()
  {
    return this.i;
  }
  
  public boolean v()
  {
    return this.v;
  }
  
  public String w(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(g());
    localStringBuilder.append("\n");
    Object localObject = this.b.s(h());
    if (localObject != null)
    {
      localStringBuilder.append("\t\tParents: ");
      localStringBuilder.append(((Layer)localObject).g());
      for (localObject = this.b.s(((Layer)localObject).h()); localObject != null; localObject = this.b.s(((Layer)localObject).h()))
      {
        localStringBuilder.append("->");
        localStringBuilder.append(((Layer)localObject).g());
      }
      localStringBuilder.append(paramString);
      localStringBuilder.append("\n");
    }
    if (!e().isEmpty())
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append("\tMasks: ");
      localStringBuilder.append(e().size());
      localStringBuilder.append("\n");
    }
    if ((o() != 0) && (n() != 0))
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append("\tBackground: ");
      localStringBuilder.append(String.format(Locale.US, "%dx%d %X\n", new Object[] { Integer.valueOf(o()), Integer.valueOf(n()), Integer.valueOf(m()) }));
    }
    if (!this.a.isEmpty())
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append("\tShapes:\n");
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        localObject = localIterator.next();
        localStringBuilder.append(paramString);
        localStringBuilder.append("\t\t");
        localStringBuilder.append(localObject);
        localStringBuilder.append("\n");
      }
    }
    return localStringBuilder.toString();
  }
  
  public static enum LayerType
  {
    static
    {
      LayerType localLayerType1 = new LayerType("PRE_COMP", 0);
      PRE_COMP = localLayerType1;
      LayerType localLayerType2 = new LayerType("SOLID", 1);
      SOLID = localLayerType2;
      LayerType localLayerType3 = new LayerType("IMAGE", 2);
      IMAGE = localLayerType3;
      LayerType localLayerType4 = new LayerType("NULL", 3);
      NULL = localLayerType4;
      LayerType localLayerType5 = new LayerType("SHAPE", 4);
      SHAPE = localLayerType5;
      LayerType localLayerType6 = new LayerType("TEXT", 5);
      TEXT = localLayerType6;
      LayerType localLayerType7 = new LayerType("UNKNOWN", 6);
      UNKNOWN = localLayerType7;
      $VALUES = new LayerType[] { localLayerType1, localLayerType2, localLayerType3, localLayerType4, localLayerType5, localLayerType6, localLayerType7 };
    }
  }
  
  public static enum MatteType
  {
    static
    {
      MatteType localMatteType1 = new MatteType("NONE", 0);
      NONE = localMatteType1;
      MatteType localMatteType2 = new MatteType("ADD", 1);
      ADD = localMatteType2;
      MatteType localMatteType3 = new MatteType("INVERT", 2);
      INVERT = localMatteType3;
      MatteType localMatteType4 = new MatteType("UNKNOWN", 3);
      UNKNOWN = localMatteType4;
      $VALUES = new MatteType[] { localMatteType1, localMatteType2, localMatteType3, localMatteType4 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\model\layer\Layer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */