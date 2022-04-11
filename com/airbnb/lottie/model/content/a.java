package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.model.i.m;
import com.airbnb.lottie.s.b.c;

public class a
  implements b
{
  private final String a;
  private final m<PointF, PointF> b;
  private final com.airbnb.lottie.model.i.f c;
  private final boolean d;
  private final boolean e;
  
  public a(String paramString, m<PointF, PointF> paramm, com.airbnb.lottie.model.i.f paramf, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = paramString;
    this.b = paramm;
    this.c = paramf;
    this.d = paramBoolean1;
    this.e = paramBoolean2;
  }
  
  public c a(com.airbnb.lottie.f paramf, com.airbnb.lottie.model.layer.a parama)
  {
    return new com.airbnb.lottie.s.b.f(paramf, parama, this);
  }
  
  public String b()
  {
    return this.a;
  }
  
  public m<PointF, PointF> c()
  {
    return this.b;
  }
  
  public com.airbnb.lottie.model.i.f d()
  {
    return this.c;
  }
  
  public boolean e()
  {
    return this.e;
  }
  
  public boolean f()
  {
    return this.d;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\model\content\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */