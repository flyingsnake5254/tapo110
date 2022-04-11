package com.airbnb.lottie.model.content;

import com.airbnb.lottie.f;
import com.airbnb.lottie.model.i.h;
import com.airbnb.lottie.model.layer.a;
import com.airbnb.lottie.s.b.c;
import com.airbnb.lottie.s.b.q;

public class k
  implements b
{
  private final String a;
  private final int b;
  private final h c;
  private final boolean d;
  
  public k(String paramString, int paramInt, h paramh, boolean paramBoolean)
  {
    this.a = paramString;
    this.b = paramInt;
    this.c = paramh;
    this.d = paramBoolean;
  }
  
  public c a(f paramf, a parama)
  {
    return new q(paramf, parama, this);
  }
  
  public String b()
  {
    return this.a;
  }
  
  public h c()
  {
    return this.c;
  }
  
  public boolean d()
  {
    return this.d;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ShapePath{name=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", index=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\model\content\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */