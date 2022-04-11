package com.airbnb.lottie.model.content;

import androidx.annotation.Nullable;
import com.airbnb.lottie.f;
import com.airbnb.lottie.model.i.l;
import com.airbnb.lottie.model.layer.a;
import com.airbnb.lottie.s.b.c;
import com.airbnb.lottie.s.b.p;

public class g
  implements b
{
  private final String a;
  private final com.airbnb.lottie.model.i.b b;
  private final com.airbnb.lottie.model.i.b c;
  private final l d;
  private final boolean e;
  
  public g(String paramString, com.airbnb.lottie.model.i.b paramb1, com.airbnb.lottie.model.i.b paramb2, l paraml, boolean paramBoolean)
  {
    this.a = paramString;
    this.b = paramb1;
    this.c = paramb2;
    this.d = paraml;
    this.e = paramBoolean;
  }
  
  @Nullable
  public c a(f paramf, a parama)
  {
    return new p(paramf, parama, this);
  }
  
  public com.airbnb.lottie.model.i.b b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.a;
  }
  
  public com.airbnb.lottie.model.i.b d()
  {
    return this.c;
  }
  
  public l e()
  {
    return this.d;
  }
  
  public boolean f()
  {
    return this.e;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\model\content\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */