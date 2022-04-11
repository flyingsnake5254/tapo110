package com.bumptech.glide.load.j;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.f;
import java.io.File;
import java.io.InputStream;

public class u<Data>
  implements n<String, Data>
{
  private final n<Uri, Data> a;
  
  public u(n<Uri, Data> paramn)
  {
    this.a = paramn;
  }
  
  @Nullable
  private static Uri e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (paramString.charAt(0) == '/')
    {
      paramString = f(paramString);
    }
    else
    {
      Uri localUri = Uri.parse(paramString);
      if (localUri.getScheme() == null) {
        paramString = f(paramString);
      } else {
        paramString = localUri;
      }
    }
    return paramString;
  }
  
  private static Uri f(String paramString)
  {
    return Uri.fromFile(new File(paramString));
  }
  
  public n.a<Data> c(@NonNull String paramString, int paramInt1, int paramInt2, @NonNull f paramf)
  {
    paramString = e(paramString);
    if ((paramString != null) && (this.a.a(paramString))) {
      return this.a.b(paramString, paramInt1, paramInt2, paramf);
    }
    return null;
  }
  
  public boolean d(@NonNull String paramString)
  {
    return true;
  }
  
  public static final class a
    implements o<String, AssetFileDescriptor>
  {
    public void a() {}
    
    public n<String, AssetFileDescriptor> c(@NonNull r paramr)
    {
      return new u(paramr.d(Uri.class, AssetFileDescriptor.class));
    }
  }
  
  public static class b
    implements o<String, ParcelFileDescriptor>
  {
    public void a() {}
    
    @NonNull
    public n<String, ParcelFileDescriptor> c(@NonNull r paramr)
    {
      return new u(paramr.d(Uri.class, ParcelFileDescriptor.class));
    }
  }
  
  public static class c
    implements o<String, InputStream>
  {
    public void a() {}
    
    @NonNull
    public n<String, InputStream> c(@NonNull r paramr)
    {
      return new u(paramr.d(Uri.class, InputStream.class));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\j\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */