package com.airbnb.lottie.model.content;

import android.graphics.Path.FillType;
import androidx.annotation.Nullable;
import com.airbnb.lottie.f;
import com.airbnb.lottie.model.i.d;
import com.airbnb.lottie.s.b.c;
import com.airbnb.lottie.s.b.g;

public class i
  implements b
{
  private final boolean a;
  private final Path.FillType b;
  private final String c;
  @Nullable
  private final com.airbnb.lottie.model.i.a d;
  @Nullable
  private final d e;
  private final boolean f;
  
  public i(String paramString, boolean paramBoolean1, Path.FillType paramFillType, @Nullable com.airbnb.lottie.model.i.a parama, @Nullable d paramd, boolean paramBoolean2)
  {
    this.c = paramString;
    this.a = paramBoolean1;
    this.b = paramFillType;
    this.d = parama;
    this.e = paramd;
    this.f = paramBoolean2;
  }
  
  public c a(f paramf, com.airbnb.lottie.model.layer.a parama)
  {
    return new g(paramf, parama, this);
  }
  
  @Nullable
  public com.airbnb.lottie.model.i.a b()
  {
    return this.d;
  }
  
  public Path.FillType c()
  {
    return this.b;
  }
  
  public String d()
  {
    return this.c;
  }
  
  @Nullable
  public d e()
  {
    return this.e;
  }
  
  public boolean f()
  {
    return this.f;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ShapeFill{color=, fillEnabled=");
    localStringBuilder.append(this.a);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\model\content\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */