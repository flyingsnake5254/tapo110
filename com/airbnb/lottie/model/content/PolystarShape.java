package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.f;
import com.airbnb.lottie.model.i.m;
import com.airbnb.lottie.model.layer.a;
import com.airbnb.lottie.s.b.c;
import com.airbnb.lottie.s.b.n;

public class PolystarShape
  implements b
{
  private final String a;
  private final Type b;
  private final com.airbnb.lottie.model.i.b c;
  private final m<PointF, PointF> d;
  private final com.airbnb.lottie.model.i.b e;
  private final com.airbnb.lottie.model.i.b f;
  private final com.airbnb.lottie.model.i.b g;
  private final com.airbnb.lottie.model.i.b h;
  private final com.airbnb.lottie.model.i.b i;
  private final boolean j;
  
  public PolystarShape(String paramString, Type paramType, com.airbnb.lottie.model.i.b paramb1, m<PointF, PointF> paramm, com.airbnb.lottie.model.i.b paramb2, com.airbnb.lottie.model.i.b paramb3, com.airbnb.lottie.model.i.b paramb4, com.airbnb.lottie.model.i.b paramb5, com.airbnb.lottie.model.i.b paramb6, boolean paramBoolean)
  {
    this.a = paramString;
    this.b = paramType;
    this.c = paramb1;
    this.d = paramm;
    this.e = paramb2;
    this.f = paramb3;
    this.g = paramb4;
    this.h = paramb5;
    this.i = paramb6;
    this.j = paramBoolean;
  }
  
  public c a(f paramf, a parama)
  {
    return new n(paramf, parama, this);
  }
  
  public com.airbnb.lottie.model.i.b b()
  {
    return this.f;
  }
  
  public com.airbnb.lottie.model.i.b c()
  {
    return this.h;
  }
  
  public String d()
  {
    return this.a;
  }
  
  public com.airbnb.lottie.model.i.b e()
  {
    return this.g;
  }
  
  public com.airbnb.lottie.model.i.b f()
  {
    return this.i;
  }
  
  public com.airbnb.lottie.model.i.b g()
  {
    return this.c;
  }
  
  public m<PointF, PointF> h()
  {
    return this.d;
  }
  
  public com.airbnb.lottie.model.i.b i()
  {
    return this.e;
  }
  
  public Type j()
  {
    return this.b;
  }
  
  public boolean k()
  {
    return this.j;
  }
  
  public static enum Type
  {
    private final int value;
    
    static
    {
      Type localType1 = new Type("STAR", 0, 1);
      STAR = localType1;
      Type localType2 = new Type("POLYGON", 1, 2);
      POLYGON = localType2;
      $VALUES = new Type[] { localType1, localType2 };
    }
    
    private Type(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static Type forValue(int paramInt)
    {
      for (Type localType : ) {
        if (localType.value == paramInt) {
          return localType;
        }
      }
      return null;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\model\content\PolystarShape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */