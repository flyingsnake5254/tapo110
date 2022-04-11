package com.bumptech.glide.load.j;

import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.d.a;
import com.bumptech.glide.load.f;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class b<Data>
  implements n<byte[], Data>
{
  private final b<Data> a;
  
  public b(b<Data> paramb)
  {
    this.a = paramb;
  }
  
  public n.a<Data> c(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2, @NonNull f paramf)
  {
    return new n.a(new com.bumptech.glide.o.b(paramArrayOfByte), new c(paramArrayOfByte, this.a));
  }
  
  public boolean d(@NonNull byte[] paramArrayOfByte)
  {
    return true;
  }
  
  public static class a
    implements o<byte[], ByteBuffer>
  {
    public void a() {}
    
    @NonNull
    public n<byte[], ByteBuffer> c(@NonNull r paramr)
    {
      return new b(new a());
    }
    
    class a
      implements b.b<ByteBuffer>
    {
      a() {}
      
      public Class<ByteBuffer> a()
      {
        return ByteBuffer.class;
      }
      
      public ByteBuffer c(byte[] paramArrayOfByte)
      {
        return ByteBuffer.wrap(paramArrayOfByte);
      }
    }
  }
  
  public static abstract interface b<Data>
  {
    public abstract Class<Data> a();
    
    public abstract Data b(byte[] paramArrayOfByte);
  }
  
  private static class c<Data>
    implements d<Data>
  {
    private final byte[] c;
    private final b.b<Data> d;
    
    c(byte[] paramArrayOfByte, b.b<Data> paramb)
    {
      this.c = paramArrayOfByte;
      this.d = paramb;
    }
    
    @NonNull
    public Class<Data> a()
    {
      return this.d.a();
    }
    
    public void b() {}
    
    public void cancel() {}
    
    @NonNull
    public DataSource d()
    {
      return DataSource.LOCAL;
    }
    
    public void e(@NonNull Priority paramPriority, @NonNull d.a<? super Data> parama)
    {
      parama.f(this.d.b(this.c));
    }
  }
  
  public static class d
    implements o<byte[], InputStream>
  {
    public void a() {}
    
    @NonNull
    public n<byte[], InputStream> c(@NonNull r paramr)
    {
      return new b(new a());
    }
    
    class a
      implements b.b<InputStream>
    {
      a() {}
      
      public Class<InputStream> a()
      {
        return InputStream.class;
      }
      
      public InputStream c(byte[] paramArrayOfByte)
      {
        return new ByteArrayInputStream(paramArrayOfByte);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\j\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */