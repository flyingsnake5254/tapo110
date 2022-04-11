package kotlinx.coroutines.internal;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import kotlin.TypeCastException;
import kotlin.collections.l;
import kotlin.io.a;
import kotlin.jvm.internal.j;
import kotlin.text.m;

public final class f
{
  public static final f a = new f();
  
  private final <S> S a(String paramString, ClassLoader paramClassLoader, Class<S> paramClass)
  {
    paramString = Class.forName(paramString, false, paramClassLoader);
    if (paramClass.isAssignableFrom(paramString)) {
      return (S)paramClass.cast(paramString.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
    }
    paramClassLoader = new StringBuilder();
    paramClassLoader.append("Expected service of class ");
    paramClassLoader.append(paramClass);
    paramClassLoader.append(", but found ");
    paramClassLoader.append(paramString);
    throw new IllegalArgumentException(paramClassLoader.toString().toString());
  }
  
  private final List<String> d(URL paramURL)
  {
    Object localObject1 = paramURL.toString();
    j.b(localObject1, "url.toString()");
    if (m.A((String)localObject1, "jar", false, 2, null))
    {
      paramURL = m.r0(m.m0((String)localObject1, "jar:file:", null, 2, null), '!', null, 2, null);
      Object localObject3 = m.m0((String)localObject1, "!/", null, 2, null);
      paramURL = new JarFile(paramURL, false);
      try
      {
        localObject1 = new java/io/BufferedReader;
        InputStreamReader localInputStreamReader = new java/io/InputStreamReader;
        ZipEntry localZipEntry = new java/util/zip/ZipEntry;
        localZipEntry.<init>((String)localObject3);
        localInputStreamReader.<init>(paramURL.getInputStream(localZipEntry), "UTF-8");
        ((BufferedReader)localObject1).<init>(localInputStreamReader);
        try
        {
          localObject3 = a.e((BufferedReader)localObject1);
          a.a((Closeable)localObject1, null);
          try
          {
            paramURL.close();
            return (List<String>)localObject3;
          }
          finally {}
          localThrowable1 = finally;
        }
        finally {}
        paramURL = new BufferedReader(new InputStreamReader(paramURL.openStream()));
      }
      finally
      {
        try
        {
          throw localThrowable1;
        }
        finally {}
      }
    }
    try
    {
      List localList = a.e(paramURL);
      a.a(paramURL, null);
      return localList;
    }
    finally
    {
      try
      {
        throw localThrowable2;
      }
      finally
      {
        a.a(paramURL, localThrowable2);
      }
    }
  }
  
  private final List<String> e(BufferedReader paramBufferedReader)
  {
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    String str;
    for (;;)
    {
      str = paramBufferedReader.readLine();
      if (str == null) {
        break label196;
      }
      str = m.s0(str, "#", null, 2, null);
      if (str == null) {
        break label186;
      }
      str = m.t0(str).toString();
      int i = 0;
      for (int j = 0; j < str.length(); j++)
      {
        char c = str.charAt(j);
        int k;
        if ((c != '.') && (!Character.isJavaIdentifierPart(c))) {
          k = 0;
        } else {
          k = 1;
        }
        if (k == 0)
        {
          j = 0;
          break label113;
        }
      }
      j = 1;
      label113:
      if (j == 0) {
        break;
      }
      j = i;
      if (str.length() > 0) {
        j = 1;
      }
      if (j != 0) {
        localLinkedHashSet.add(str);
      }
    }
    paramBufferedReader = new StringBuilder();
    paramBufferedReader.append("Illegal service provider class name: ");
    paramBufferedReader.append(str);
    throw new IllegalArgumentException(paramBufferedReader.toString().toString());
    label186:
    throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    label196:
    return l.S(localLinkedHashSet);
  }
  
  /* Error */
  public final <S> List<S> b(Class<S> paramClass, ClassLoader paramClassLoader)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc -54
    //   3: invokestatic 205	kotlin/jvm/internal/j:f	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_2
    //   7: ldc -49
    //   9: invokestatic 205	kotlin/jvm/internal/j:f	(Ljava/lang/Object;Ljava/lang/String;)V
    //   12: aload_0
    //   13: aload_1
    //   14: aload_2
    //   15: invokevirtual 210	kotlinx/coroutines/internal/f:c	(Ljava/lang/Class;Ljava/lang/ClassLoader;)Ljava/util/List;
    //   18: astore_3
    //   19: aload_3
    //   20: astore_1
    //   21: goto +21 -> 42
    //   24: astore_3
    //   25: aload_1
    //   26: aload_2
    //   27: invokestatic 216	java/util/ServiceLoader:load	(Ljava/lang/Class;Ljava/lang/ClassLoader;)Ljava/util/ServiceLoader;
    //   30: astore_1
    //   31: aload_1
    //   32: ldc -38
    //   34: invokestatic 79	kotlin/jvm/internal/j:b	(Ljava/lang/Object;Ljava/lang/String;)V
    //   37: aload_1
    //   38: invokestatic 198	kotlin/collections/l:S	(Ljava/lang/Iterable;)Ljava/util/List;
    //   41: astore_1
    //   42: aload_1
    //   43: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	f
    //   0	44	1	paramClass	Class<S>
    //   0	44	2	paramClassLoader	ClassLoader
    //   18	2	3	localList	List
    //   24	1	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   12	19	24	finally
  }
  
  public final <S> List<S> c(Class<S> paramClass, ClassLoader paramClassLoader)
  {
    j.f(paramClass, "service");
    j.f(paramClassLoader, "loader");
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("META-INF/services/");
    ((StringBuilder)localObject1).append(paramClass.getName());
    localObject1 = paramClassLoader.getResources(((StringBuilder)localObject1).toString());
    j.b(localObject1, "urls");
    Object localObject2 = Collections.list((Enumeration)localObject1);
    j.b(localObject2, "java.util.Collections.list(this)");
    localObject1 = new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (URL)((Iterator)localObject2).next();
      f localf = a;
      j.b(localObject3, "it");
      l.p((Collection)localObject1, localf.d((URL)localObject3));
    }
    localObject2 = l.V((Iterable)localObject1);
    if ((((Collection)localObject2).isEmpty() ^ true))
    {
      localObject1 = new ArrayList(l.l((Iterable)localObject2, 10));
      localObject3 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject2 = (String)((Iterator)localObject3).next();
        ((Collection)localObject1).add(a.a((String)localObject2, paramClassLoader, paramClass));
      }
      return (List<S>)localObject1;
    }
    throw new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\internal\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */