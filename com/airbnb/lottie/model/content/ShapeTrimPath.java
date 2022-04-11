package com.airbnb.lottie.model.content;

import com.airbnb.lottie.f;
import com.airbnb.lottie.model.layer.a;
import com.airbnb.lottie.s.b.c;
import com.airbnb.lottie.s.b.s;

public class ShapeTrimPath
  implements b
{
  private final String a;
  private final Type b;
  private final com.airbnb.lottie.model.i.b c;
  private final com.airbnb.lottie.model.i.b d;
  private final com.airbnb.lottie.model.i.b e;
  private final boolean f;
  
  public ShapeTrimPath(String paramString, Type paramType, com.airbnb.lottie.model.i.b paramb1, com.airbnb.lottie.model.i.b paramb2, com.airbnb.lottie.model.i.b paramb3, boolean paramBoolean)
  {
    this.a = paramString;
    this.b = paramType;
    this.c = paramb1;
    this.d = paramb2;
    this.e = paramb3;
    this.f = paramBoolean;
  }
  
  public c a(f paramf, a parama)
  {
    return new s(parama, this);
  }
  
  public com.airbnb.lottie.model.i.b b()
  {
    return this.d;
  }
  
  public String c()
  {
    return this.a;
  }
  
  public com.airbnb.lottie.model.i.b d()
  {
    return this.e;
  }
  
  public com.airbnb.lottie.model.i.b e()
  {
    return this.c;
  }
  
  public Type f()
  {
    return this.b;
  }
  
  public boolean g()
  {
    return this.f;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Trim Path: {start: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", end: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", offset: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public static enum Type
  {
    static
    {
      Type localType1 = new Type("SIMULTANEOUSLY", 0);
      SIMULTANEOUSLY = localType1;
      Type localType2 = new Type("INDIVIDUALLY", 1);
      INDIVIDUALLY = localType2;
      $VALUES = new Type[] { localType1, localType2 };
    }
    
    public static Type forId(int paramInt)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2) {
          return INDIVIDUALLY;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unknown trim path type ");
        localStringBuilder.append(paramInt);
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      return SIMULTANEOUSLY;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\model\content\ShapeTrimPath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */