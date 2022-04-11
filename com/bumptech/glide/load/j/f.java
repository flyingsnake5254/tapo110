package com.bumptech.glide.load.j;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.d.a;
import com.bumptech.glide.o.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class f<Data>
  implements n<File, Data>
{
  private final d<Data> a;
  
  public f(d<Data> paramd)
  {
    this.a = paramd;
  }
  
  public n.a<Data> c(@NonNull File paramFile, int paramInt1, int paramInt2, @NonNull com.bumptech.glide.load.f paramf)
  {
    return new n.a(new b(paramFile), new c(paramFile, this.a));
  }
  
  public boolean d(@NonNull File paramFile)
  {
    return true;
  }
  
  public static class a<Data>
    implements o<File, Data>
  {
    private final f.d<Data> a;
    
    public a(f.d<Data> paramd)
    {
      this.a = paramd;
    }
    
    public final void a() {}
    
    @NonNull
    public final n<File, Data> c(@NonNull r paramr)
    {
      return new f(this.a);
    }
  }
  
  public static class b
    extends f.a<ParcelFileDescriptor>
  {
    public b()
    {
      super();
    }
    
    class a
      implements f.d<ParcelFileDescriptor>
    {
      public Class<ParcelFileDescriptor> a()
      {
        return ParcelFileDescriptor.class;
      }
      
      public void c(ParcelFileDescriptor paramParcelFileDescriptor)
        throws IOException
      {
        paramParcelFileDescriptor.close();
      }
      
      public ParcelFileDescriptor d(File paramFile)
        throws FileNotFoundException
      {
        return ParcelFileDescriptor.open(paramFile, 268435456);
      }
    }
  }
  
  private static final class c<Data>
    implements d<Data>
  {
    private final File c;
    private final f.d<Data> d;
    private Data f;
    
    c(File paramFile, f.d<Data> paramd)
    {
      this.c = paramFile;
      this.d = paramd;
    }
    
    @NonNull
    public Class<Data> a()
    {
      return this.d.a();
    }
    
    public void b()
    {
      Object localObject = this.f;
      if (localObject != null) {}
      try
      {
        this.d.close(localObject);
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
      catch (FileNotFoundException paramPriority)
      {
        if (Log.isLoggable("FileLoader", 3)) {
          Log.d("FileLoader", "Failed to open file", paramPriority);
        }
        parama.c(paramPriority);
      }
    }
  }
  
  public static abstract interface d<Data>
  {
    public abstract Class<Data> a();
    
    public abstract Data b(File paramFile)
      throws FileNotFoundException;
    
    public abstract void close(Data paramData)
      throws IOException;
  }
  
  public static class e
    extends f.a<InputStream>
  {
    public e()
    {
      super();
    }
    
    class a
      implements f.d<InputStream>
    {
      public Class<InputStream> a()
      {
        return InputStream.class;
      }
      
      public void c(InputStream paramInputStream)
        throws IOException
      {
        paramInputStream.close();
      }
      
      public InputStream d(File paramFile)
        throws FileNotFoundException
      {
        return new FileInputStream(paramFile);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\j\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */