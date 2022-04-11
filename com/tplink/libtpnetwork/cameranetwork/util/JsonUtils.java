package com.tplink.libtpnetwork.cameranetwork.util;

import b.d.w.c.a;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.d;
import com.google.gson.e;
import com.google.gson.f;
import com.google.gson.g;
import com.google.gson.h;
import com.google.gson.i;
import com.google.gson.l;
import com.google.gson.m;
import com.google.gson.n;
import com.google.gson.o;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceCategory;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceCategory.Deserializer;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceCategory.Serializer;
import com.tplink.libtpnetwork.cameranetwork.bean.listing.ColumnFilter;
import com.tplink.libtpnetwork.cameranetwork.bean.listing.ColumnFilter.ColumnFilterDeserializer;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class JsonUtils
{
  private static d a = new d().c();
  private static d b = new d().c();
  public static DateFormat c = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
  private static Gson d;
  private static Gson e;
  private static l f;
  
  static
  {
    a.e("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    b.e("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    d = a.b();
    e = b.b();
    f = new l();
    f(DeviceCategory.class, DeviceCategory.Serializer.class);
    f(DeviceCategory.class, DeviceCategory.Deserializer.class);
    f(ColumnFilter.class, ColumnFilter.ColumnFilterDeserializer.class);
  }
  
  public static <T> T a(String paramString, Type paramType)
  {
    if (paramType == null) {
      return null;
    }
    return (T)d.m(paramString, paramType);
  }
  
  public static <T> List<T> b(f paramf)
  {
    if (paramf == null) {
      return null;
    }
    return (List)d.g(paramf, List.class);
  }
  
  public static void c(Class paramClass, e parame)
  {
    try
    {
      a.d(paramClass, parame);
      d = a.b();
      b.d(paramClass, parame);
      e = b.b();
      return;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  public static void d(Class paramClass, h paramh)
  {
    try
    {
      a.d(paramClass, paramh);
      d = a.b();
      b.d(paramClass, paramh);
      e = b.f().b();
      return;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  public static void e(Class paramClass, o paramo)
  {
    try
    {
      a.d(paramClass, paramo);
      d = a.b();
      b.d(paramClass, paramo);
      e = b.b();
      return;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  /* Error */
  public static boolean f(Class paramClass1, Class paramClass2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: iconst_1
    //   4: istore_2
    //   5: ldc 104
    //   7: aload_1
    //   8: invokevirtual 110	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   11: ifeq +17 -> 28
    //   14: aload_0
    //   15: aload_1
    //   16: invokevirtual 114	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   19: checkcast 104	com/google/gson/h
    //   22: invokestatic 116	com/tplink/libtpnetwork/cameranetwork/util/JsonUtils:d	(Ljava/lang/Class;Lcom/google/gson/h;)V
    //   25: goto +46 -> 71
    //   28: ldc 118
    //   30: aload_1
    //   31: invokevirtual 110	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   34: ifeq +17 -> 51
    //   37: aload_0
    //   38: aload_1
    //   39: invokevirtual 114	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   42: checkcast 118	com/google/gson/o
    //   45: invokestatic 120	com/tplink/libtpnetwork/cameranetwork/util/JsonUtils:e	(Ljava/lang/Class;Lcom/google/gson/o;)V
    //   48: goto +23 -> 71
    //   51: ldc 122
    //   53: aload_1
    //   54: invokevirtual 110	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   57: ifeq +45 -> 102
    //   60: aload_0
    //   61: aload_1
    //   62: invokevirtual 114	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   65: checkcast 122	com/google/gson/e
    //   68: invokestatic 124	com/tplink/libtpnetwork/cameranetwork/util/JsonUtils:c	(Ljava/lang/Class;Lcom/google/gson/e;)V
    //   71: ldc 126
    //   73: ldc -128
    //   75: iconst_2
    //   76: anewarray 4	java/lang/Object
    //   79: dup
    //   80: iconst_0
    //   81: aload_1
    //   82: invokevirtual 132	java/lang/Class:getName	()Ljava/lang/String;
    //   85: aastore
    //   86: dup
    //   87: iconst_1
    //   88: aload_0
    //   89: invokevirtual 132	java/lang/Class:getName	()Ljava/lang/String;
    //   92: aastore
    //   93: invokestatic 138	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   96: invokestatic 143	b/d/w/c/a:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: goto +162 -> 261
    //   102: new 145	java/lang/IllegalArgumentException
    //   105: astore_0
    //   106: aload_0
    //   107: ldc -109
    //   109: iconst_1
    //   110: anewarray 4	java/lang/Object
    //   113: dup
    //   114: iconst_0
    //   115: aload_1
    //   116: invokevirtual 132	java/lang/Class:getName	()Ljava/lang/String;
    //   119: aastore
    //   120: invokestatic 138	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   123: invokespecial 148	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   126: aload_0
    //   127: athrow
    //   128: astore_0
    //   129: goto +137 -> 266
    //   132: astore_1
    //   133: new 150	java/lang/StringBuilder
    //   136: astore_0
    //   137: aload_0
    //   138: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   141: aload_0
    //   142: ldc -103
    //   144: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload_0
    //   149: aload_1
    //   150: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: ldc 126
    //   156: aload_0
    //   157: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokestatic 143	b/d/w/c/a:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   163: goto +96 -> 259
    //   166: astore_3
    //   167: new 150	java/lang/StringBuilder
    //   170: astore_0
    //   171: aload_0
    //   172: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   175: aload_0
    //   176: ldc -91
    //   178: iconst_1
    //   179: anewarray 4	java/lang/Object
    //   182: dup
    //   183: iconst_0
    //   184: aload_1
    //   185: invokevirtual 132	java/lang/Class:getName	()Ljava/lang/String;
    //   188: aastore
    //   189: invokestatic 138	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   192: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload_0
    //   197: aload_3
    //   198: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: ldc 126
    //   204: aload_0
    //   205: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 143	b/d/w/c/a:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   211: goto +48 -> 259
    //   214: astore_0
    //   215: new 150	java/lang/StringBuilder
    //   218: astore_3
    //   219: aload_3
    //   220: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   223: aload_3
    //   224: ldc -89
    //   226: iconst_1
    //   227: anewarray 4	java/lang/Object
    //   230: dup
    //   231: iconst_0
    //   232: aload_1
    //   233: invokevirtual 132	java/lang/Class:getName	()Ljava/lang/String;
    //   236: aastore
    //   237: invokestatic 138	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   240: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: aload_3
    //   245: aload_0
    //   246: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: ldc 126
    //   252: aload_3
    //   253: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 143	b/d/w/c/a:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   259: iconst_0
    //   260: istore_2
    //   261: ldc 2
    //   263: monitorexit
    //   264: iload_2
    //   265: ireturn
    //   266: ldc 2
    //   268: monitorexit
    //   269: aload_0
    //   270: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	271	0	paramClass1	Class
    //   0	271	1	paramClass2	Class
    //   4	261	2	bool	boolean
    //   166	32	3	localIllegalAccessException	IllegalAccessException
    //   218	35	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   5	25	128	finally
    //   28	48	128	finally
    //   51	71	128	finally
    //   71	99	128	finally
    //   102	128	128	finally
    //   133	163	128	finally
    //   167	211	128	finally
    //   215	259	128	finally
    //   5	25	132	java/lang/Exception
    //   28	48	132	java/lang/Exception
    //   51	71	132	java/lang/Exception
    //   71	99	132	java/lang/Exception
    //   102	128	132	java/lang/Exception
    //   5	25	166	java/lang/IllegalAccessException
    //   28	48	166	java/lang/IllegalAccessException
    //   51	71	166	java/lang/IllegalAccessException
    //   71	99	166	java/lang/IllegalAccessException
    //   102	128	166	java/lang/IllegalAccessException
    //   5	25	214	java/lang/InstantiationException
    //   28	48	214	java/lang/InstantiationException
    //   51	71	214	java/lang/InstantiationException
    //   71	99	214	java/lang/InstantiationException
    //   102	128	214	java/lang/InstantiationException
  }
  
  public static String g(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    try
    {
      if ((paramObject instanceof i)) {
        return paramObject.toString();
      }
      paramObject = d.u(paramObject);
      return (String)paramObject;
    }
    catch (Error paramObject)
    {
      a.e("JsonUtil", ((Error)paramObject).getMessage());
    }
    catch (Exception paramObject)
    {
      a.e("JsonUtil", ((Exception)paramObject).getMessage());
    }
    return null;
  }
  
  public static class Deserializer
    implements h<DeviceCategory>
  {
    public DeviceCategory a(i parami, Type paramType, g paramg)
      throws JsonParseException
    {
      return DeviceCategory.fromValue(parami.e());
    }
  }
  
  public static class Serializer
    implements o<DeviceCategory>
  {
    public i a(DeviceCategory paramDeviceCategory, Type paramType, n paramn)
    {
      return new m(paramDeviceCategory.value());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\util\JsonUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */