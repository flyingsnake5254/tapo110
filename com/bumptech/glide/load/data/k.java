package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.z.b;
import com.bumptech.glide.load.resource.bitmap.u;
import java.io.IOException;
import java.io.InputStream;

public final class k
  implements e<InputStream>
{
  private final u a;
  
  public k(InputStream paramInputStream, b paramb)
  {
    paramInputStream = new u(paramInputStream, paramb);
    this.a = paramInputStream;
    paramInputStream.mark(5242880);
  }
  
  public void b()
  {
    this.a.e();
  }
  
  public void c()
  {
    this.a.c();
  }
  
  @NonNull
  public InputStream d()
    throws IOException
  {
    this.a.reset();
    return this.a;
  }
  
  public static final class a
    implements e.a<InputStream>
  {
    private final b a;
    
    public a(b paramb)
    {
      this.a = paramb;
    }
    
    @NonNull
    public Class<InputStream> a()
    {
      return InputStream.class;
    }
    
    @NonNull
    public e<InputStream> c(InputStream paramInputStream)
    {
      return new k(paramInputStream, this.a);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\data\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */