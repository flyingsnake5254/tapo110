package com.bumptech.glide.load.k.d;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.data.e;
import com.bumptech.glide.load.data.e.a;
import java.nio.ByteBuffer;

public class a
  implements e<ByteBuffer>
{
  private final ByteBuffer a;
  
  public a(ByteBuffer paramByteBuffer)
  {
    this.a = paramByteBuffer;
  }
  
  public void b() {}
  
  @NonNull
  public ByteBuffer c()
  {
    this.a.position(0);
    return this.a;
  }
  
  public static class a
    implements e.a<ByteBuffer>
  {
    @NonNull
    public Class<ByteBuffer> a()
    {
      return ByteBuffer.class;
    }
    
    @NonNull
    public e<ByteBuffer> c(ByteBuffer paramByteBuffer)
    {
      return new a(paramByteBuffer);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\k\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */