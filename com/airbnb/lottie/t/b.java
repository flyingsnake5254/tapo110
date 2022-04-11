package com.airbnb.lottie.t;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable.Callback;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import androidx.annotation.Nullable;
import com.airbnb.lottie.g;
import com.airbnb.lottie.v.d;
import com.airbnb.lottie.v.h;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class b
{
  private static final Object a = new Object();
  private final Context b;
  private String c;
  @Nullable
  private com.airbnb.lottie.b d;
  private final Map<String, g> e;
  
  public b(Drawable.Callback paramCallback, String paramString, com.airbnb.lottie.b paramb, Map<String, g> paramMap)
  {
    this.c = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = this.c;
      if (paramString.charAt(paramString.length() - 1) != '/')
      {
        paramString = new StringBuilder();
        paramString.append(this.c);
        paramString.append('/');
        this.c = paramString.toString();
      }
    }
    if (!(paramCallback instanceof View))
    {
      d.c("LottieDrawable must be inside of a view for images to work.");
      this.e = new HashMap();
      this.b = null;
      return;
    }
    this.b = ((View)paramCallback).getContext();
    this.e = paramMap;
    d(paramb);
  }
  
  private Bitmap c(String paramString, @Nullable Bitmap paramBitmap)
  {
    synchronized (a)
    {
      ((g)this.e.get(paramString)).f(paramBitmap);
      return paramBitmap;
    }
  }
  
  @Nullable
  public Bitmap a(String paramString)
  {
    Object localObject1 = (g)this.e.get(paramString);
    if (localObject1 == null) {
      return null;
    }
    Object localObject2 = ((g)localObject1).a();
    if (localObject2 != null) {
      return (Bitmap)localObject2;
    }
    localObject2 = this.d;
    if (localObject2 != null)
    {
      localObject1 = ((com.airbnb.lottie.b)localObject2).a((g)localObject1);
      if (localObject1 != null) {
        c(paramString, (Bitmap)localObject1);
      }
      return (Bitmap)localObject1;
    }
    Object localObject3 = ((g)localObject1).b();
    localObject2 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject2).inScaled = true;
    ((BitmapFactory.Options)localObject2).inDensity = 160;
    if ((((String)localObject3).startsWith("data:")) && (((String)localObject3).indexOf("base64,") > 0)) {
      try
      {
        localObject1 = Base64.decode(((String)localObject3).substring(((String)localObject3).indexOf(',') + 1), 0);
        return c(paramString, BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length, (BitmapFactory.Options)localObject2));
      }
      catch (IllegalArgumentException paramString)
      {
        d.d("data URL did not have correct base64 format.", paramString);
        return null;
      }
    }
    try
    {
      if (!TextUtils.isEmpty(this.c))
      {
        AssetManager localAssetManager = this.b.getAssets();
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        localStringBuilder.append(this.c);
        localStringBuilder.append((String)localObject3);
        localObject3 = localAssetManager.open(localStringBuilder.toString());
        return c(paramString, h.l(BitmapFactory.decodeStream((InputStream)localObject3, null, (BitmapFactory.Options)localObject2), ((g)localObject1).e(), ((g)localObject1).c()));
      }
      paramString = new java/lang/IllegalStateException;
      paramString.<init>("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
      throw paramString;
    }
    catch (IOException paramString)
    {
      d.d("Unable to open asset.", paramString);
    }
    return null;
  }
  
  public boolean b(Context paramContext)
  {
    boolean bool;
    if (((paramContext == null) && (this.b == null)) || (this.b.equals(paramContext))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void d(@Nullable com.airbnb.lottie.b paramb)
  {
    this.d = paramb;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\t\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */