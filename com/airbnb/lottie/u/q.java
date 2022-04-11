package com.airbnb.lottie.u;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.airbnb.lottie.d;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader.a;
import com.airbnb.lottie.v.g;
import com.airbnb.lottie.v.h;
import com.airbnb.lottie.w.a;
import java.io.IOException;
import java.lang.ref.WeakReference;

class q
{
  private static final Interpolator a = new LinearInterpolator();
  private static SparseArrayCompat<WeakReference<Interpolator>> b;
  static JsonReader.a c = JsonReader.a.a(new String[] { "t", "s", "e", "o", "i", "h", "to", "ti" });
  
  @Nullable
  private static WeakReference<Interpolator> a(int paramInt)
  {
    try
    {
      WeakReference localWeakReference = (WeakReference)e().get(paramInt);
      return localWeakReference;
    }
    finally {}
  }
  
  static <T> a<T> b(JsonReader paramJsonReader, d paramd, float paramFloat, j0<T> paramj0, boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean) {
      return c(paramd, paramJsonReader, paramFloat, paramj0);
    }
    return d(paramJsonReader, paramFloat, paramj0);
  }
  
  private static <T> a<T> c(d paramd, JsonReader paramJsonReader, float paramFloat, j0<T> paramj0)
    throws IOException
  {
    paramJsonReader.e();
    Object localObject1 = null;
    PointF localPointF1 = null;
    PointF localPointF2 = localPointF1;
    Object localObject2 = localPointF2;
    Object localObject3 = localObject2;
    Object localObject4 = localObject3;
    Object localObject5 = localObject4;
    int i = 0;
    float f1 = 0.0F;
    while (paramJsonReader.j()) {
      switch (paramJsonReader.y(c))
      {
      default: 
        paramJsonReader.A();
        break;
      case 7: 
        localObject4 = p.e(paramJsonReader, paramFloat);
        break;
      case 6: 
        localObject5 = p.e(paramJsonReader, paramFloat);
        break;
      case 5: 
        if (paramJsonReader.s() == 1) {
          i = 1;
        } else {
          i = 0;
        }
        break;
      case 4: 
        localPointF2 = p.e(paramJsonReader, paramFloat);
        break;
      case 3: 
        localPointF1 = p.e(paramJsonReader, paramFloat);
        break;
      case 2: 
        localObject2 = paramj0.a(paramJsonReader, paramFloat);
        break;
      case 1: 
        localObject3 = paramj0.a(paramJsonReader, paramFloat);
        break;
      case 0: 
        f1 = (float)paramJsonReader.l();
      }
    }
    paramJsonReader.i();
    if (i != 0)
    {
      paramj0 = a;
      paramJsonReader = (JsonReader)localObject3;
    }
    else if ((localPointF1 != null) && (localPointF2 != null))
    {
      float f2 = localPointF1.x;
      float f3 = -paramFloat;
      localPointF1.x = g.b(f2, f3, paramFloat);
      localPointF1.y = g.b(localPointF1.y, -100.0F, 100.0F);
      localPointF2.x = g.b(localPointF2.x, f3, paramFloat);
      f3 = g.b(localPointF2.y, -100.0F, 100.0F);
      localPointF2.y = f3;
      i = h.i(localPointF1.x, localPointF1.y, localPointF2.x, f3);
      paramj0 = a(i);
      paramJsonReader = (JsonReader)localObject1;
      if (paramj0 != null) {
        paramJsonReader = (Interpolator)paramj0.get();
      }
      if (paramj0 != null)
      {
        paramj0 = paramJsonReader;
        if (paramJsonReader != null) {}
      }
      else
      {
        localPointF1.x /= paramFloat;
        localPointF1.y /= paramFloat;
        f3 = localPointF2.x / paramFloat;
        localPointF2.x = f3;
        paramFloat = localPointF2.y / paramFloat;
        localPointF2.y = paramFloat;
        try
        {
          paramJsonReader = PathInterpolatorCompat.create(localPointF1.x, localPointF1.y, f3, paramFloat);
        }
        catch (IllegalArgumentException paramJsonReader)
        {
          if (paramJsonReader.getMessage().equals("The Path cannot loop back on itself.")) {
            paramJsonReader = PathInterpolatorCompat.create(Math.min(localPointF1.x, 1.0F), localPointF1.y, Math.max(localPointF2.x, 0.0F), localPointF2.y);
          } else {
            paramJsonReader = new LinearInterpolator();
          }
        }
      }
    }
    try
    {
      paramj0 = new java/lang/ref/WeakReference;
      paramj0.<init>(paramJsonReader);
      f(i, paramj0);
      paramj0 = paramJsonReader;
    }
    catch (ArrayIndexOutOfBoundsException paramj0)
    {
      for (;;)
      {
        paramj0 = paramJsonReader;
      }
    }
    paramJsonReader = paramj0;
    break label515;
    paramJsonReader = a;
    label515:
    paramj0 = paramJsonReader;
    paramJsonReader = (JsonReader)localObject2;
    paramd = new a(paramd, localObject3, paramJsonReader, paramj0, f1, null);
    paramd.m = ((PointF)localObject5);
    paramd.n = ((PointF)localObject4);
    return paramd;
  }
  
  private static <T> a<T> d(JsonReader paramJsonReader, float paramFloat, j0<T> paramj0)
    throws IOException
  {
    return new a(paramj0.a(paramJsonReader, paramFloat));
  }
  
  private static SparseArrayCompat<WeakReference<Interpolator>> e()
  {
    if (b == null) {
      b = new SparseArrayCompat();
    }
    return b;
  }
  
  private static void f(int paramInt, WeakReference<Interpolator> paramWeakReference)
  {
    try
    {
      b.put(paramInt, paramWeakReference);
      return;
    }
    finally {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\u\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */