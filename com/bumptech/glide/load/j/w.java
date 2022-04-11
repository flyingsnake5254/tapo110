package com.bumptech.glide.load.j;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.data.a;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.i;
import com.bumptech.glide.load.f;
import com.bumptech.glide.o.b;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class w<Data>
  implements n<Uri, Data>
{
  private static final Set<String> a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[] { "file", "android.resource", "content" })));
  private final c<Data> b;
  
  public w(c<Data> paramc)
  {
    this.b = paramc;
  }
  
  public n.a<Data> c(@NonNull Uri paramUri, int paramInt1, int paramInt2, @NonNull f paramf)
  {
    return new n.a(new b(paramUri), this.b.b(paramUri));
  }
  
  public boolean d(@NonNull Uri paramUri)
  {
    return a.contains(paramUri.getScheme());
  }
  
  public static final class a
    implements o<Uri, AssetFileDescriptor>, w.c<AssetFileDescriptor>
  {
    private final ContentResolver a;
    
    public a(ContentResolver paramContentResolver)
    {
      this.a = paramContentResolver;
    }
    
    public void a() {}
    
    public d<AssetFileDescriptor> b(Uri paramUri)
    {
      return new a(this.a, paramUri);
    }
    
    public n<Uri, AssetFileDescriptor> c(r paramr)
    {
      return new w(this);
    }
  }
  
  public static class b
    implements o<Uri, ParcelFileDescriptor>, w.c<ParcelFileDescriptor>
  {
    private final ContentResolver a;
    
    public b(ContentResolver paramContentResolver)
    {
      this.a = paramContentResolver;
    }
    
    public void a() {}
    
    public d<ParcelFileDescriptor> b(Uri paramUri)
    {
      return new i(this.a, paramUri);
    }
    
    @NonNull
    public n<Uri, ParcelFileDescriptor> c(r paramr)
    {
      return new w(this);
    }
  }
  
  public static abstract interface c<Data>
  {
    public abstract d<Data> b(Uri paramUri);
  }
  
  public static class d
    implements o<Uri, InputStream>, w.c<InputStream>
  {
    private final ContentResolver a;
    
    public d(ContentResolver paramContentResolver)
    {
      this.a = paramContentResolver;
    }
    
    public void a() {}
    
    public d<InputStream> b(Uri paramUri)
    {
      return new com.bumptech.glide.load.data.n(this.a, paramUri);
    }
    
    @NonNull
    public n<Uri, InputStream> c(r paramr)
    {
      return new w(this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\j\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */