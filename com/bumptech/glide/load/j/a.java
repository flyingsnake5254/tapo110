package com.bumptech.glide.load.j;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.h;
import com.bumptech.glide.load.data.m;
import com.bumptech.glide.load.f;
import com.bumptech.glide.o.b;
import java.io.InputStream;
import java.util.List;

public class a<Data>
  implements n<Uri, Data>
{
  private static final int a = 22;
  private final AssetManager b;
  private final a<Data> c;
  
  public a(AssetManager paramAssetManager, a<Data> parama)
  {
    this.b = paramAssetManager;
    this.c = parama;
  }
  
  public n.a<Data> c(@NonNull Uri paramUri, int paramInt1, int paramInt2, @NonNull f paramf)
  {
    paramf = paramUri.toString().substring(a);
    return new n.a(new b(paramUri), this.c.b(this.b, paramf));
  }
  
  public boolean d(@NonNull Uri paramUri)
  {
    boolean bool1 = "file".equals(paramUri.getScheme());
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      bool3 = bool2;
      if (!paramUri.getPathSegments().isEmpty())
      {
        bool3 = bool2;
        if ("android_asset".equals(paramUri.getPathSegments().get(0))) {
          bool3 = true;
        }
      }
    }
    return bool3;
  }
  
  public static abstract interface a<Data>
  {
    public abstract d<Data> b(AssetManager paramAssetManager, String paramString);
  }
  
  public static class b
    implements o<Uri, ParcelFileDescriptor>, a.a<ParcelFileDescriptor>
  {
    private final AssetManager a;
    
    public b(AssetManager paramAssetManager)
    {
      this.a = paramAssetManager;
    }
    
    public void a() {}
    
    public d<ParcelFileDescriptor> b(AssetManager paramAssetManager, String paramString)
    {
      return new h(paramAssetManager, paramString);
    }
    
    @NonNull
    public n<Uri, ParcelFileDescriptor> c(r paramr)
    {
      return new a(this.a, this);
    }
  }
  
  public static class c
    implements o<Uri, InputStream>, a.a<InputStream>
  {
    private final AssetManager a;
    
    public c(AssetManager paramAssetManager)
    {
      this.a = paramAssetManager;
    }
    
    public void a() {}
    
    public d<InputStream> b(AssetManager paramAssetManager, String paramString)
    {
      return new m(paramAssetManager, paramString);
    }
    
    @NonNull
    public n<Uri, InputStream> c(r paramr)
    {
      return new a(this.a, this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\j\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */