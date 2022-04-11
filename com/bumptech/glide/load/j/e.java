package com.bumptech.glide.load.j;

import android.util.Base64;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.d.a;
import com.bumptech.glide.load.f;
import com.bumptech.glide.o.b;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class e<Model, Data>
  implements n<Model, Data>
{
  private final a<Data> a;
  
  public e(a<Data> parama)
  {
    this.a = parama;
  }
  
  public boolean a(@NonNull Model paramModel)
  {
    return paramModel.toString().startsWith("data:image");
  }
  
  public n.a<Data> b(@NonNull Model paramModel, int paramInt1, int paramInt2, @NonNull f paramf)
  {
    return new n.a(new b(paramModel), new b(paramModel.toString(), this.a));
  }
  
  public static abstract interface a<Data>
  {
    public abstract Class<Data> a();
    
    public abstract Data b(String paramString)
      throws IllegalArgumentException;
    
    public abstract void close(Data paramData)
      throws IOException;
  }
  
  private static final class b<Data>
    implements d<Data>
  {
    private final String c;
    private final e.a<Data> d;
    private Data f;
    
    b(String paramString, e.a<Data> parama)
    {
      this.c = paramString;
      this.d = parama;
    }
    
    @NonNull
    public Class<Data> a()
    {
      return this.d.a();
    }
    
    public void b()
    {
      try
      {
        this.d.close(this.f);
        return;
      }
      catch (IOException localIOException)
      {
        for (;;) {}
      }
    }
    
    public void cancel() {}
    
    @NonNull
    public DataSource d()
    {
      return DataSource.LOCAL;
    }
    
    public void e(@NonNull Priority paramPriority, @NonNull d.a<? super Data> parama)
    {
      try
      {
        paramPriority = this.d.b(this.c);
        this.f = paramPriority;
        parama.f(paramPriority);
      }
      catch (IllegalArgumentException paramPriority)
      {
        parama.c(paramPriority);
      }
    }
  }
  
  public static final class c<Model>
    implements o<Model, InputStream>
  {
    private final e.a<InputStream> a = new a();
    
    public void a() {}
    
    @NonNull
    public n<Model, InputStream> c(@NonNull r paramr)
    {
      return new e(this.a);
    }
    
    class a
      implements e.a<InputStream>
    {
      a() {}
      
      public Class<InputStream> a()
      {
        return InputStream.class;
      }
      
      public void c(InputStream paramInputStream)
        throws IOException
      {
        paramInputStream.close();
      }
      
      public InputStream d(String paramString)
      {
        if (paramString.startsWith("data:image"))
        {
          int i = paramString.indexOf(',');
          if (i != -1)
          {
            if (paramString.substring(0, i).endsWith(";base64")) {
              return new ByteArrayInputStream(Base64.decode(paramString.substring(i + 1), 0));
            }
            throw new IllegalArgumentException("Not a base64 image data URL.");
          }
          throw new IllegalArgumentException("Missing comma in data URL.");
        }
        throw new IllegalArgumentException("Not a valid image data URL.");
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\j\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */