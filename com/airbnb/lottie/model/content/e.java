package com.airbnb.lottie.model.content;

import androidx.annotation.Nullable;
import com.airbnb.lottie.model.i.d;
import com.airbnb.lottie.model.layer.a;
import com.airbnb.lottie.s.b.i;
import java.util.List;

public class e
  implements b
{
  private final String a;
  private final GradientType b;
  private final com.airbnb.lottie.model.i.c c;
  private final d d;
  private final com.airbnb.lottie.model.i.f e;
  private final com.airbnb.lottie.model.i.f f;
  private final com.airbnb.lottie.model.i.b g;
  private final ShapeStroke.LineCapType h;
  private final ShapeStroke.LineJoinType i;
  private final float j;
  private final List<com.airbnb.lottie.model.i.b> k;
  @Nullable
  private final com.airbnb.lottie.model.i.b l;
  private final boolean m;
  
  public e(String paramString, GradientType paramGradientType, com.airbnb.lottie.model.i.c paramc, d paramd, com.airbnb.lottie.model.i.f paramf1, com.airbnb.lottie.model.i.f paramf2, com.airbnb.lottie.model.i.b paramb1, ShapeStroke.LineCapType paramLineCapType, ShapeStroke.LineJoinType paramLineJoinType, float paramFloat, List<com.airbnb.lottie.model.i.b> paramList, @Nullable com.airbnb.lottie.model.i.b paramb2, boolean paramBoolean)
  {
    this.a = paramString;
    this.b = paramGradientType;
    this.c = paramc;
    this.d = paramd;
    this.e = paramf1;
    this.f = paramf2;
    this.g = paramb1;
    this.h = paramLineCapType;
    this.i = paramLineJoinType;
    this.j = paramFloat;
    this.k = paramList;
    this.l = paramb2;
    this.m = paramBoolean;
  }
  
  public com.airbnb.lottie.s.b.c a(com.airbnb.lottie.f paramf, a parama)
  {
    return new i(paramf, parama, this);
  }
  
  public ShapeStroke.LineCapType b()
  {
    return this.h;
  }
  
  @Nullable
  public com.airbnb.lottie.model.i.b c()
  {
    return this.l;
  }
  
  public com.airbnb.lottie.model.i.f d()
  {
    return this.f;
  }
  
  public com.airbnb.lottie.model.i.c e()
  {
    return this.c;
  }
  
  public GradientType f()
  {
    return this.b;
  }
  
  public ShapeStroke.LineJoinType g()
  {
    return this.i;
  }
  
  public List<com.airbnb.lottie.model.i.b> h()
  {
    return this.k;
  }
  
  public float i()
  {
    return this.j;
  }
  
  public String j()
  {
    return this.a;
  }
  
  public d k()
  {
    return this.d;
  }
  
  public com.airbnb.lottie.model.i.f l()
  {
    return this.e;
  }
  
  public com.airbnb.lottie.model.i.b m()
  {
    return this.g;
  }
  
  public boolean n()
  {
    return this.m;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\model\content\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */