package com.bumptech.glide.load.j;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.f;
import java.io.InputStream;

public class s<Data>
  implements n<Integer, Data>
{
  private final n<Uri, Data> a;
  private final Resources b;
  
  public s(Resources paramResources, n<Uri, Data> paramn)
  {
    this.b = paramResources;
    this.a = paramn;
  }
  
  @Nullable
  private Uri d(Integer paramInteger)
  {
    try
    {
      localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      ((StringBuilder)localObject).append("android.resource://");
      ((StringBuilder)localObject).append(this.b.getResourcePackageName(paramInteger.intValue()));
      ((StringBuilder)localObject).append('/');
      ((StringBuilder)localObject).append(this.b.getResourceTypeName(paramInteger.intValue()));
      ((StringBuilder)localObject).append('/');
      ((StringBuilder)localObject).append(this.b.getResourceEntryName(paramInteger.intValue()));
      localObject = Uri.parse(((StringBuilder)localObject).toString());
      return (Uri)localObject;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      Object localObject;
      if (Log.isLoggable("ResourceLoader", 5))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Received invalid resource id: ");
        ((StringBuilder)localObject).append(paramInteger);
        Log.w("ResourceLoader", ((StringBuilder)localObject).toString(), localNotFoundException);
      }
    }
    return null;
  }
  
  public n.a<Data> c(@NonNull Integer paramInteger, int paramInt1, int paramInt2, @NonNull f paramf)
  {
    paramInteger = d(paramInteger);
    if (paramInteger == null) {
      paramInteger = null;
    } else {
      paramInteger = this.a.b(paramInteger, paramInt1, paramInt2, paramf);
    }
    return paramInteger;
  }
  
  public boolean e(@NonNull Integer paramInteger)
  {
    return true;
  }
  
  public static final class a
    implements o<Integer, AssetFileDescriptor>
  {
    private final Resources a;
    
    public a(Resources paramResources)
    {
      this.a = paramResources;
    }
    
    public void a() {}
    
    public n<Integer, AssetFileDescriptor> c(r paramr)
    {
      return new s(this.a, paramr.d(Uri.class, AssetFileDescriptor.class));
    }
  }
  
  public static class b
    implements o<Integer, ParcelFileDescriptor>
  {
    private final Resources a;
    
    public b(Resources paramResources)
    {
      this.a = paramResources;
    }
    
    public void a() {}
    
    @NonNull
    public n<Integer, ParcelFileDescriptor> c(r paramr)
    {
      return new s(this.a, paramr.d(Uri.class, ParcelFileDescriptor.class));
    }
  }
  
  public static class c
    implements o<Integer, InputStream>
  {
    private final Resources a;
    
    public c(Resources paramResources)
    {
      this.a = paramResources;
    }
    
    public void a() {}
    
    @NonNull
    public n<Integer, InputStream> c(r paramr)
    {
      return new s(this.a, paramr.d(Uri.class, InputStream.class));
    }
  }
  
  public static class d
    implements o<Integer, Uri>
  {
    private final Resources a;
    
    public d(Resources paramResources)
    {
      this.a = paramResources;
    }
    
    public void a() {}
    
    @NonNull
    public n<Integer, Uri> c(r paramr)
    {
      return new s(this.a, v.c());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\j\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */