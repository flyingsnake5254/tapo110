package com.bumptech.glide.load.k.e;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.g;
import java.util.List;

public class d
  implements g<Uri, Drawable>
{
  private final Context a;
  
  public d(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
  }
  
  @NonNull
  private Context d(Uri paramUri, String paramString)
  {
    if (paramString.equals(this.a.getPackageName())) {
      return this.a;
    }
    try
    {
      Context localContext = this.a.createPackageContext(paramString, 0);
      return localContext;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      if (paramString.contains(this.a.getPackageName())) {
        return this.a;
      }
      paramString = new StringBuilder();
      paramString.append("Failed to obtain context or unrecognized Uri format for: ");
      paramString.append(paramUri);
      throw new IllegalArgumentException(paramString.toString(), localNameNotFoundException);
    }
  }
  
  @DrawableRes
  private int e(Uri paramUri)
  {
    Object localObject = paramUri.getPathSegments();
    try
    {
      int i = Integer.parseInt((String)((List)localObject).get(0));
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Unrecognized Uri format: ");
      ((StringBuilder)localObject).append(paramUri);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString(), localNumberFormatException);
    }
  }
  
  @DrawableRes
  private int f(Context paramContext, Uri paramUri)
  {
    Object localObject = paramUri.getPathSegments();
    String str1 = paramUri.getAuthority();
    String str2 = (String)((List)localObject).get(0);
    localObject = (String)((List)localObject).get(1);
    int i = paramContext.getResources().getIdentifier((String)localObject, str2, str1);
    int j = i;
    if (i == 0) {
      j = Resources.getSystem().getIdentifier((String)localObject, str2, "android");
    }
    if (j != 0) {
      return j;
    }
    paramContext = new StringBuilder();
    paramContext.append("Failed to find resource id for: ");
    paramContext.append(paramUri);
    throw new IllegalArgumentException(paramContext.toString());
  }
  
  @DrawableRes
  private int g(Context paramContext, Uri paramUri)
  {
    List localList = paramUri.getPathSegments();
    if (localList.size() == 2) {
      return f(paramContext, paramUri);
    }
    if (localList.size() == 1) {
      return e(paramUri);
    }
    paramContext = new StringBuilder();
    paramContext.append("Unrecognized Uri format: ");
    paramContext.append(paramUri);
    throw new IllegalArgumentException(paramContext.toString());
  }
  
  @Nullable
  public u<Drawable> c(@NonNull Uri paramUri, int paramInt1, int paramInt2, @NonNull f paramf)
  {
    paramf = d(paramUri, paramUri.getAuthority());
    paramInt1 = g(paramf, paramUri);
    return c.f(a.b(this.a, paramf, paramInt1));
  }
  
  public boolean h(@NonNull Uri paramUri, @NonNull f paramf)
  {
    return paramUri.getScheme().equals("android.resource");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\k\e\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */