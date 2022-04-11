package com.airbnb.lottie.model.content;

import android.graphics.Path.FillType;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.layer.a;
import com.airbnb.lottie.s.b.h;

public class d
  implements b
{
  private final GradientType a;
  private final Path.FillType b;
  private final com.airbnb.lottie.model.i.c c;
  private final com.airbnb.lottie.model.i.d d;
  private final com.airbnb.lottie.model.i.f e;
  private final com.airbnb.lottie.model.i.f f;
  private final String g;
  @Nullable
  private final com.airbnb.lottie.model.i.b h;
  @Nullable
  private final com.airbnb.lottie.model.i.b i;
  private final boolean j;
  
  public d(String paramString, GradientType paramGradientType, Path.FillType paramFillType, com.airbnb.lottie.model.i.c paramc, com.airbnb.lottie.model.i.d paramd, com.airbnb.lottie.model.i.f paramf1, com.airbnb.lottie.model.i.f paramf2, com.airbnb.lottie.model.i.b paramb1, com.airbnb.lottie.model.i.b paramb2, boolean paramBoolean)
  {
    this.a = paramGradientType;
    this.b = paramFillType;
    this.c = paramc;
    this.d = paramd;
    this.e = paramf1;
    this.f = paramf2;
    this.g = paramString;
    this.h = paramb1;
    this.i = paramb2;
    this.j = paramBoolean;
  }
  
  public com.airbnb.lottie.s.b.c a(com.airbnb.lottie.f paramf, a parama)
  {
    return new h(paramf, parama, this);
  }
  
  public com.airbnb.lottie.model.i.f b()
  {
    return this.f;
  }
  
  public Path.FillType c()
  {
    return this.b;
  }
  
  public com.airbnb.lottie.model.i.c d()
  {
    return this.c;
  }
  
  public GradientType e()
  {
    return this.a;
  }
  
  public String f()
  {
    return this.g;
  }
  
  public com.airbnb.lottie.model.i.d g()
  {
    return this.d;
  }
  
  public com.airbnb.lottie.model.i.f h()
  {
    return this.e;
  }
  
  public boolean i()
  {
    return this.j;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\model\content\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */