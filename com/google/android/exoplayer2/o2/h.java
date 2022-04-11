package com.google.android.exoplayer2.o2;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.extractor.flv.c;
import com.google.android.exoplayer2.o2.g0.a;
import com.google.android.exoplayer2.o2.h0.e;
import com.google.android.exoplayer2.o2.j0.i;
import com.google.android.exoplayer2.o2.j0.k;
import com.google.android.exoplayer2.o2.l0.b0;
import com.google.android.exoplayer2.o2.l0.h0;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class h
  implements o
{
  private static final int[] b = { 5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 14 };
  @Nullable
  private static final Constructor<? extends j> c;
  private boolean d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l = 1;
  private int m;
  private int n = 112800;
  
  static
  {
    localObject1 = null;
    Object localObject2 = localObject1;
    try
    {
      try
      {
        if (Boolean.TRUE.equals(Class.forName("com.google.android.exoplayer2.ext.flac.FlacLibrary").getMethod("isAvailable", new Class[0]).invoke(null, new Object[0]))) {
          localObject2 = Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(j.class).getConstructor(new Class[] { Integer.TYPE });
        }
      }
      catch (Exception localException)
      {
        throw new RuntimeException("Error instantiating FLAC extension", localException);
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        Object localObject3 = localObject1;
      }
    }
    c = localException;
  }
  
  private void c(int paramInt, List<j> paramList)
  {
    switch (paramInt)
    {
    case 13: 
    default: 
      break;
    case 14: 
      paramList.add(new a());
      break;
    case 12: 
      paramList.add(new com.google.android.exoplayer2.o2.m0.b());
      break;
    case 11: 
      paramList.add(new h0(this.l, this.m, this.n));
      break;
    case 10: 
      paramList.add(new b0());
      break;
    case 9: 
      paramList.add(new com.google.android.exoplayer2.o2.k0.d());
      break;
    case 8: 
      paramList.add(new i(this.j));
      paramList.add(new k(this.i));
      break;
    case 7: 
      paramList.add(new com.google.android.exoplayer2.o2.i0.f(this.k | this.d));
      break;
    case 6: 
      paramList.add(new e(this.h));
      break;
    case 5: 
      paramList.add(new c());
      break;
    case 4: 
      Constructor localConstructor = c;
      if (localConstructor != null) {
        try
        {
          paramList.add((j)localConstructor.newInstance(new Object[] { Integer.valueOf(this.g) }));
        }
        catch (Exception paramList)
        {
          throw new IllegalStateException("Unexpected error creating FLAC extractor", paramList);
        }
      } else {
        paramList.add(new com.google.android.exoplayer2.o2.f0.d(this.g));
      }
      break;
    case 3: 
      paramList.add(new com.google.android.exoplayer2.o2.e0.b(this.f | this.d));
      break;
    case 2: 
      paramList.add(new com.google.android.exoplayer2.o2.l0.j(this.e | this.d));
      break;
    case 1: 
      paramList.add(new com.google.android.exoplayer2.o2.l0.h());
      break;
    case 0: 
      paramList.add(new com.google.android.exoplayer2.o2.l0.f());
    }
  }
  
  public j[] a(Uri paramUri, Map<String, List<String>> paramMap)
  {
    try
    {
      ArrayList localArrayList = new java/util/ArrayList;
      localArrayList.<init>(14);
      int i1 = com.google.android.exoplayer2.util.o.b(paramMap);
      if (i1 != -1) {
        c(i1, localArrayList);
      }
      int i2 = com.google.android.exoplayer2.util.o.c(paramUri);
      if ((i2 != -1) && (i2 != i1)) {
        c(i2, localArrayList);
      }
      for (int i5 : b) {
        if ((i5 != i1) && (i5 != i2)) {
          c(i5, localArrayList);
        }
      }
      paramUri = (j[])localArrayList.toArray(new j[localArrayList.size()]);
      return paramUri;
    }
    finally {}
  }
  
  public j[] b()
  {
    try
    {
      Object localObject1 = Uri.EMPTY;
      HashMap localHashMap = new java/util/HashMap;
      localHashMap.<init>();
      localObject1 = a((Uri)localObject1, localHashMap);
      return (j[])localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */