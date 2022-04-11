package com.airbnb.lottie.t;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable.Callback;
import android.view.View;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.h;
import com.airbnb.lottie.v.d;
import java.util.HashMap;
import java.util.Map;

public class a
{
  private final h<String> a = new h();
  private final Map<h<String>, Typeface> b = new HashMap();
  private final Map<String, Typeface> c = new HashMap();
  private final AssetManager d;
  @Nullable
  private com.airbnb.lottie.a e;
  private String f = ".ttf";
  
  public a(Drawable.Callback paramCallback, @Nullable com.airbnb.lottie.a parama)
  {
    this.e = parama;
    if (!(paramCallback instanceof View))
    {
      d.c("LottieDrawable must be inside of a view for images to work.");
      this.d = null;
      return;
    }
    this.d = ((View)paramCallback).getContext().getAssets();
  }
  
  private Typeface a(String paramString)
  {
    Object localObject1 = (Typeface)this.c.get(paramString);
    if (localObject1 != null) {
      return (Typeface)localObject1;
    }
    Object localObject2 = null;
    localObject1 = this.e;
    if (localObject1 != null) {
      localObject2 = ((com.airbnb.lottie.a)localObject1).a(paramString);
    }
    Object localObject3 = this.e;
    localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject3 = ((com.airbnb.lottie.a)localObject3).b(paramString);
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = Typeface.createFromAsset(this.d, (String)localObject3);
        }
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("fonts/");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(this.f);
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = Typeface.createFromAsset(this.d, (String)localObject1);
    }
    this.c.put(paramString, localObject2);
    return (Typeface)localObject2;
  }
  
  private Typeface d(Typeface paramTypeface, String paramString)
  {
    boolean bool1 = paramString.contains("Italic");
    boolean bool2 = paramString.contains("Bold");
    int i;
    if ((bool1) && (bool2)) {
      i = 3;
    } else if (bool1) {
      i = 2;
    } else if (bool2) {
      i = 1;
    } else {
      i = 0;
    }
    if (paramTypeface.getStyle() == i) {
      return paramTypeface;
    }
    return Typeface.create(paramTypeface, i);
  }
  
  public Typeface b(String paramString1, String paramString2)
  {
    this.a.b(paramString1, paramString2);
    Typeface localTypeface = (Typeface)this.b.get(this.a);
    if (localTypeface != null) {
      return localTypeface;
    }
    paramString1 = d(a(paramString1), paramString2);
    this.b.put(this.a, paramString1);
    return paramString1;
  }
  
  public void c(@Nullable com.airbnb.lottie.a parama)
  {
    this.e = parama;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\t\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */