package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.model.i.m;
import com.airbnb.lottie.model.layer.a;
import com.airbnb.lottie.s.b.c;
import com.airbnb.lottie.s.b.o;

public class f
  implements b
{
  private final String a;
  private final m<PointF, PointF> b;
  private final com.airbnb.lottie.model.i.f c;
  private final com.airbnb.lottie.model.i.b d;
  private final boolean e;
  
  public f(String paramString, m<PointF, PointF> paramm, com.airbnb.lottie.model.i.f paramf, com.airbnb.lottie.model.i.b paramb, boolean paramBoolean)
  {
    this.a = paramString;
    this.b = paramm;
    this.c = paramf;
    this.d = paramb;
    this.e = paramBoolean;
  }
  
  public c a(com.airbnb.lottie.f paramf, a parama)
  {
    return new o(paramf, parama, this);
  }
  
  public com.airbnb.lottie.model.i.b b()
  {
    return this.d;
  }
  
  public String c()
  {
    return this.a;
  }
  
  public m<PointF, PointF> d()
  {
    return this.b;
  }
  
  public com.airbnb.lottie.model.i.f e()
  {
    return this.c;
  }
  
  public boolean f()
  {
    return this.e;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RectangleShape{position=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", size=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\model\content\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */