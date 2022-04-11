package com.bumptech.glide.load.j;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.f;
import com.bumptech.glide.o.b;
import com.bumptech.glide.util.a;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public class d
  implements n<File, ByteBuffer>
{
  public n.a<ByteBuffer> c(@NonNull File paramFile, int paramInt1, int paramInt2, @NonNull f paramf)
  {
    return new n.a(new b(paramFile), new a(paramFile));
  }
  
  public boolean d(@NonNull File paramFile)
  {
    return true;
  }
  
  private static final class a
    implements com.bumptech.glide.load.data.d<ByteBuffer>
  {
    private final File c;
    
    a(File paramFile)
    {
      this.c = paramFile;
    }
    
    @NonNull
    public Class<ByteBuffer> a()
    {
      return ByteBuffer.class;
    }
    
    public void b() {}
    
    public void cancel() {}
    
    @NonNull
    public DataSource d()
    {
      return DataSource.LOCAL;
    }
    
    public void e(@NonNull Priority paramPriority, @NonNull com.bumptech.glide.load.data.d.a<? super ByteBuffer> parama)
    {
      try
      {
        parama.f(a.a(this.c));
      }
      catch (IOException paramPriority)
      {
        if (Log.isLoggable("ByteBufferFileLoader", 3)) {
          Log.d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", paramPriority);
        }
        parama.c(paramPriority);
      }
    }
  }
  
  public static class b
    implements o<File, ByteBuffer>
  {
    public void a() {}
    
    @NonNull
    public n<File, ByteBuffer> c(@NonNull r paramr)
    {
      return new d();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\j\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */