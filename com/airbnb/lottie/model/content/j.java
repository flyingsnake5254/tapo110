package com.airbnb.lottie.model.content;

import com.airbnb.lottie.f;
import com.airbnb.lottie.model.layer.a;
import com.airbnb.lottie.s.b.c;
import com.airbnb.lottie.s.b.d;
import java.util.Arrays;
import java.util.List;

public class j
  implements b
{
  private final String a;
  private final List<b> b;
  private final boolean c;
  
  public j(String paramString, List<b> paramList, boolean paramBoolean)
  {
    this.a = paramString;
    this.b = paramList;
    this.c = paramBoolean;
  }
  
  public c a(f paramf, a parama)
  {
    return new d(paramf, parama, this);
  }
  
  public List<b> b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.a;
  }
  
  public boolean d()
  {
    return this.c;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ShapeGroup{name='");
    localStringBuilder.append(this.a);
    localStringBuilder.append("' Shapes: ");
    localStringBuilder.append(Arrays.toString(this.b.toArray()));
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\model\content\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */