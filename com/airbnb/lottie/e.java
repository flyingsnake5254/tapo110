package com.airbnb.lottie;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.WorkerThread;
import com.airbnb.lottie.model.f;
import com.airbnb.lottie.network.b;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import okio.Okio;

public class e
{
  private static final Map<String, m<d>> a = new HashMap();
  
  private static m<d> b(@Nullable String paramString, Callable<l<d>> paramCallable)
  {
    Object localObject;
    if (paramString == null) {
      localObject = null;
    } else {
      localObject = f.b().a(paramString);
    }
    if (localObject != null) {
      return new m(new g((d)localObject));
    }
    if (paramString != null)
    {
      localObject = a;
      if (((Map)localObject).containsKey(paramString)) {
        return (m)((Map)localObject).get(paramString);
      }
    }
    paramCallable = new m(paramCallable);
    if (paramString != null)
    {
      paramCallable.f(new a());
      paramCallable.e(new b());
      a.put(paramString, paramCallable);
    }
    return paramCallable;
  }
  
  @Nullable
  private static g c(d paramd, String paramString)
  {
    paramd = paramd.i().values().iterator();
    while (paramd.hasNext())
    {
      g localg = (g)paramd.next();
      if (localg.b().equals(paramString)) {
        return localg;
      }
    }
    return null;
  }
  
  public static m<d> d(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("asset_");
    localStringBuilder.append(paramString);
    return e(paramContext, paramString, localStringBuilder.toString());
  }
  
  public static m<d> e(Context paramContext, final String paramString1, @Nullable final String paramString2)
  {
    return b(paramString2, new d(paramContext.getApplicationContext(), paramString1, paramString2));
  }
  
  @WorkerThread
  public static l<d> f(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("asset_");
    localStringBuilder.append(paramString);
    return g(paramContext, paramString, localStringBuilder.toString());
  }
  
  @WorkerThread
  public static l<d> g(Context paramContext, String paramString1, @Nullable String paramString2)
  {
    try
    {
      if (paramString1.endsWith(".zip"))
      {
        ZipInputStream localZipInputStream = new java/util/zip/ZipInputStream;
        localZipInputStream.<init>(paramContext.getAssets().open(paramString1));
        return s(localZipInputStream, paramString2);
      }
      paramContext = i(paramContext.getAssets().open(paramString1), paramString2);
      return paramContext;
    }
    catch (IOException paramContext) {}
    return new l(paramContext);
  }
  
  public static m<d> h(InputStream paramInputStream, @Nullable final String paramString)
  {
    return b(paramString, new f(paramString));
  }
  
  @WorkerThread
  public static l<d> i(InputStream paramInputStream, @Nullable String paramString)
  {
    return j(paramInputStream, paramString, true);
  }
  
  @WorkerThread
  private static l<d> j(InputStream paramInputStream, @Nullable String paramString, boolean paramBoolean)
  {
    try
    {
      paramString = k(JsonReader.v(Okio.buffer(Okio.source(paramInputStream))), paramString);
      return paramString;
    }
    finally
    {
      if (paramBoolean) {
        com.airbnb.lottie.v.h.c(paramInputStream);
      }
    }
  }
  
  @WorkerThread
  public static l<d> k(JsonReader paramJsonReader, @Nullable String paramString)
  {
    return l(paramJsonReader, paramString, true);
  }
  
  /* Error */
  private static l<d> l(JsonReader paramJsonReader, @Nullable String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 239	com/airbnb/lottie/u/t:a	(Lcom/airbnb/lottie/parser/moshi/JsonReader;)Lcom/airbnb/lottie/d;
    //   4: astore_3
    //   5: aload_1
    //   6: ifnull +11 -> 17
    //   9: invokestatic 40	com/airbnb/lottie/model/f:b	()Lcom/airbnb/lottie/model/f;
    //   12: aload_1
    //   13: aload_3
    //   14: invokevirtual 242	com/airbnb/lottie/model/f:c	(Ljava/lang/String;Lcom/airbnb/lottie/d;)V
    //   17: new 186	com/airbnb/lottie/l
    //   20: dup
    //   21: aload_3
    //   22: invokespecial 245	com/airbnb/lottie/l:<init>	(Ljava/lang/Object;)V
    //   25: astore_1
    //   26: iload_2
    //   27: ifeq +7 -> 34
    //   30: aload_0
    //   31: invokestatic 226	com/airbnb/lottie/v/h:c	(Ljava/io/Closeable;)V
    //   34: aload_1
    //   35: areturn
    //   36: astore_1
    //   37: goto +23 -> 60
    //   40: astore_1
    //   41: new 186	com/airbnb/lottie/l
    //   44: dup
    //   45: aload_1
    //   46: invokespecial 189	com/airbnb/lottie/l:<init>	(Ljava/lang/Throwable;)V
    //   49: astore_1
    //   50: iload_2
    //   51: ifeq +7 -> 58
    //   54: aload_0
    //   55: invokestatic 226	com/airbnb/lottie/v/h:c	(Ljava/io/Closeable;)V
    //   58: aload_1
    //   59: areturn
    //   60: iload_2
    //   61: ifeq +7 -> 68
    //   64: aload_0
    //   65: invokestatic 226	com/airbnb/lottie/v/h:c	(Ljava/io/Closeable;)V
    //   68: aload_1
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	paramJsonReader	JsonReader
    //   0	70	1	paramString	String
    //   0	70	2	paramBoolean	boolean
    //   4	18	3	locald	d
    // Exception table:
    //   from	to	target	type
    //   0	5	36	finally
    //   9	17	36	finally
    //   17	26	36	finally
    //   41	50	36	finally
    //   0	5	40	java/lang/Exception
    //   9	17	40	java/lang/Exception
    //   17	26	40	java/lang/Exception
  }
  
  public static m<d> m(Context paramContext, @RawRes int paramInt)
  {
    return n(paramContext, paramInt, v(paramContext, paramInt));
  }
  
  public static m<d> n(Context paramContext, @RawRes final int paramInt, @Nullable String paramString)
  {
    return b(paramString, new e(new WeakReference(paramContext), paramContext.getApplicationContext(), paramInt));
  }
  
  @WorkerThread
  public static l<d> o(Context paramContext, @RawRes int paramInt)
  {
    return p(paramContext, paramInt, v(paramContext, paramInt));
  }
  
  @WorkerThread
  public static l<d> p(Context paramContext, @RawRes int paramInt, @Nullable String paramString)
  {
    try
    {
      paramContext = i(paramContext.getResources().openRawResource(paramInt), paramString);
      return paramContext;
    }
    catch (Resources.NotFoundException paramContext) {}
    return new l(paramContext);
  }
  
  public static m<d> q(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("url_");
    localStringBuilder.append(paramString);
    return r(paramContext, paramString, localStringBuilder.toString());
  }
  
  public static m<d> r(Context paramContext, final String paramString1, @Nullable final String paramString2)
  {
    return b(paramString2, new c(paramString1, paramString2));
  }
  
  @WorkerThread
  public static l<d> s(ZipInputStream paramZipInputStream, @Nullable String paramString)
  {
    try
    {
      paramString = t(paramZipInputStream, paramString);
      return paramString;
    }
    finally
    {
      com.airbnb.lottie.v.h.c(paramZipInputStream);
    }
  }
  
  @WorkerThread
  private static l<d> t(ZipInputStream paramZipInputStream, @Nullable String paramString)
  {
    Object localObject1 = new HashMap();
    try
    {
      Object localObject2 = paramZipInputStream.getNextEntry();
      d locald = null;
      while (localObject2 != null)
      {
        String str = ((ZipEntry)localObject2).getName();
        if (str.contains("__MACOSX"))
        {
          paramZipInputStream.closeEntry();
        }
        else if (((ZipEntry)localObject2).getName().contains(".json"))
        {
          locald = (d)l(JsonReader.v(Okio.buffer(Okio.source(paramZipInputStream))), null, false).b();
        }
        else if ((!str.contains(".png")) && (!str.contains(".webp")))
        {
          paramZipInputStream.closeEntry();
        }
        else
        {
          localObject2 = str.split("/");
          ((Map)localObject1).put(localObject2[(localObject2.length - 1)], BitmapFactory.decodeStream(paramZipInputStream));
        }
        localObject2 = paramZipInputStream.getNextEntry();
      }
      if (locald == null) {
        return new l(new IllegalArgumentException("Unable to parse composition"));
      }
      paramZipInputStream = ((Map)localObject1).entrySet().iterator();
      while (paramZipInputStream.hasNext())
      {
        localObject2 = (Map.Entry)paramZipInputStream.next();
        localObject1 = c(locald, (String)((Map.Entry)localObject2).getKey());
        if (localObject1 != null) {
          ((g)localObject1).f(com.airbnb.lottie.v.h.l((Bitmap)((Map.Entry)localObject2).getValue(), ((g)localObject1).e(), ((g)localObject1).c()));
        }
      }
      localObject2 = locald.i().entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        paramZipInputStream = (Map.Entry)((Iterator)localObject2).next();
        if (((g)paramZipInputStream.getValue()).a() == null)
        {
          paramString = new StringBuilder();
          paramString.append("There is no image for ");
          paramString.append(((g)paramZipInputStream.getValue()).b());
          return new l(new IllegalStateException(paramString.toString()));
        }
      }
      if (paramString != null) {
        f.b().c(paramString, locald);
      }
      return new l(locald);
    }
    catch (IOException paramZipInputStream) {}
    return new l(paramZipInputStream);
  }
  
  private static boolean u(Context paramContext)
  {
    boolean bool;
    if ((paramContext.getResources().getConfiguration().uiMode & 0x30) == 32) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static String v(Context paramContext, @RawRes int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("rawRes");
    if (u(paramContext)) {
      paramContext = "_night_";
    } else {
      paramContext = "_day_";
    }
    localStringBuilder.append(paramContext);
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  class a
    implements h<d>
  {
    a() {}
    
    public void b(d paramd)
    {
      e.a().remove(e.this);
    }
  }
  
  class b
    implements h<Throwable>
  {
    b() {}
    
    public void b(Throwable paramThrowable)
    {
      e.a().remove(e.this);
    }
  }
  
  class c
    implements Callable<l<d>>
  {
    c(String paramString1, String paramString2) {}
    
    public l<d> a()
    {
      return b.e(e.this, paramString1, paramString2);
    }
  }
  
  class d
    implements Callable<l<d>>
  {
    d(String paramString1, String paramString2) {}
    
    public l<d> a()
    {
      return e.g(e.this, paramString1, paramString2);
    }
  }
  
  class e
    implements Callable<l<d>>
  {
    e(Context paramContext, int paramInt) {}
    
    public l<d> a()
    {
      Context localContext = (Context)e.this.get();
      if (localContext == null) {
        localContext = this.d;
      }
      return e.o(localContext, paramInt);
    }
  }
  
  class f
    implements Callable<l<d>>
  {
    f(String paramString) {}
    
    public l<d> a()
    {
      return e.i(e.this, paramString);
    }
  }
  
  class g
    implements Callable<l<d>>
  {
    g() {}
    
    public l<d> a()
    {
      return new l(e.this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */