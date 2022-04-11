package com.tplink.libtpnetwork.cameranetwork.util;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.q.c;
import com.google.gson.r.a;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public final class i
{
  private static Context a;
  
  private static String a(String paramString)
  {
    if (paramString != null)
    {
      paramString = TimeZone.getTimeZone(paramString);
      int i = paramString.getRawOffset() / 3600000;
      int j = paramString.getRawOffset() - 3600000 * i;
      int k = j;
      if (j != 0) {
        k = Math.abs(j) / 60000;
      }
      j = Math.abs(i);
      if (paramString.getRawOffset() > 0) {
        return String.format(Locale.US, "UTC+%02d:%02d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
      }
      return String.format(Locale.US, "UTC-%02d:%02d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
    }
    return "UTC-00:00";
  }
  
  private static long b(String paramString)
  {
    if (paramString != null) {
      return TimeZone.getTimeZone(paramString).getRawOffset();
    }
    return 0L;
  }
  
  public static String c(b paramb)
  {
    long l1 = paramb.b() / 3600000L;
    long l2 = paramb.b() - 3600000L * l1;
    long l3 = l2;
    if (l2 != 0L) {
      l3 = Math.abs(l2) / 60000L;
    }
    l2 = Math.abs(l1);
    if (paramb.b() > 0L) {
      paramb = String.format(Locale.US, "GMT+%02d:%02d", new Object[] { Long.valueOf(l2), Long.valueOf(l3) });
    } else if (paramb.b() < 0L) {
      paramb = String.format(Locale.US, "GMT-%02d:%02d", new Object[] { Long.valueOf(l2), Long.valueOf(l3) });
    } else {
      paramb = "GMT";
    }
    return paramb;
  }
  
  public static b d()
  {
    TimeZone localTimeZone = TimeZone.getDefault();
    long l1 = localTimeZone.getRawOffset();
    Object localObject1 = localTimeZone.getID().split("/");
    String str;
    if (localObject1.length == 2) {
      str = localObject1[1];
    } else {
      str = localTimeZone.getID();
    }
    Iterator localIterator = e().iterator();
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject4;
    do
    {
      localObject4 = localObject2;
      localObject1 = localObject3;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject4 = (b)localIterator.next();
      long l2 = ((b)localObject4).b();
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject1 = localObject3;
        if (l1 == l2) {
          localObject1 = localObject4;
        }
      }
      if (TextUtils.equals(localTimeZone.getID(), ((b)localObject4).d())) {
        break;
      }
      localObject3 = localObject1;
    } while (!((b)localObject4).a().contains(str));
    localObject3 = new b();
    ((b)localObject3).f(0L);
    ((b)localObject3).h("UTC");
    ((b)localObject3).g("UTC-00:00");
    ((b)localObject3).e("(UTC-00:00) Coordinated Universal Time");
    if (localObject4 == null) {
      localObject4 = localObject1;
    }
    localObject1 = localObject3;
    if (localObject4 != null) {
      localObject1 = localObject4;
    }
    return (b)localObject1;
  }
  
  public static List<b> e()
  {
    Object localObject1 = f("timezone.json", a);
    Object localObject2 = new a().getType();
    Gson localGson = new Gson();
    localArrayList = new ArrayList();
    try
    {
      localArrayList.addAll((Collection)((Map)localGson.m((String)localObject1, (Type)localObject2)).get("timezones"));
      localObject2 = localArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (b)((Iterator)localObject2).next();
        ((b)localObject1).f(b(((b)localObject1).d()));
        ((b)localObject1).g(a(((b)localObject1).d()));
      }
      return localArrayList;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  /* Error */
  private static String f(String paramString, Context paramContext)
  {
    // Byte code:
    //   0: new 203	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 204	java/lang/StringBuilder:<init>	()V
    //   7: astore_2
    //   8: aconst_null
    //   9: astore_3
    //   10: aload_1
    //   11: invokevirtual 210	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   14: invokevirtual 216	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   17: aload_0
    //   18: invokevirtual 222	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   21: astore 4
    //   23: new 224	java/io/InputStreamReader
    //   26: astore 5
    //   28: aload 5
    //   30: aload 4
    //   32: invokespecial 227	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   35: new 229	java/io/BufferedReader
    //   38: astore_0
    //   39: aload_0
    //   40: aload 5
    //   42: invokespecial 232	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   45: aload_0
    //   46: astore 6
    //   48: aload 4
    //   50: astore_3
    //   51: aload 5
    //   53: astore 7
    //   55: aload_0
    //   56: invokevirtual 235	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   59: astore_1
    //   60: aload_1
    //   61: ifnull +22 -> 83
    //   64: aload_0
    //   65: astore 6
    //   67: aload 4
    //   69: astore_3
    //   70: aload 5
    //   72: astore 7
    //   74: aload_2
    //   75: aload_1
    //   76: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: goto -35 -> 45
    //   83: aload_0
    //   84: invokevirtual 242	java/io/BufferedReader:close	()V
    //   87: aload 5
    //   89: invokevirtual 243	java/io/InputStreamReader:close	()V
    //   92: aload 4
    //   94: ifnull +143 -> 237
    //   97: aload 4
    //   99: invokevirtual 246	java/io/InputStream:close	()V
    //   102: goto +135 -> 237
    //   105: astore_1
    //   106: aload 4
    //   108: astore 8
    //   110: aload 5
    //   112: astore 4
    //   114: goto +67 -> 181
    //   117: astore_0
    //   118: aload 5
    //   120: astore_1
    //   121: goto +131 -> 252
    //   124: astore_1
    //   125: aconst_null
    //   126: astore_0
    //   127: aload 4
    //   129: astore 8
    //   131: aload 5
    //   133: astore 4
    //   135: goto +46 -> 181
    //   138: astore_0
    //   139: aconst_null
    //   140: astore_1
    //   141: goto +111 -> 252
    //   144: astore_1
    //   145: aconst_null
    //   146: astore_0
    //   147: aload_0
    //   148: astore 5
    //   150: aload 4
    //   152: astore 8
    //   154: aload 5
    //   156: astore 4
    //   158: goto +23 -> 181
    //   161: astore_0
    //   162: aconst_null
    //   163: astore 4
    //   165: aload 4
    //   167: astore_1
    //   168: goto +84 -> 252
    //   171: astore_1
    //   172: aconst_null
    //   173: astore 4
    //   175: aload 4
    //   177: astore_0
    //   178: aload_0
    //   179: astore 8
    //   181: aload_0
    //   182: astore 6
    //   184: aload 8
    //   186: astore_3
    //   187: aload 4
    //   189: astore 7
    //   191: aload_1
    //   192: invokevirtual 197	java/lang/Exception:printStackTrace	()V
    //   195: aload_0
    //   196: ifnull +14 -> 210
    //   199: aload_0
    //   200: invokevirtual 242	java/io/BufferedReader:close	()V
    //   203: goto +7 -> 210
    //   206: astore_0
    //   207: goto +26 -> 233
    //   210: aload 4
    //   212: ifnull +8 -> 220
    //   215: aload 4
    //   217: invokevirtual 243	java/io/InputStreamReader:close	()V
    //   220: aload 8
    //   222: ifnull +15 -> 237
    //   225: aload 8
    //   227: invokevirtual 246	java/io/InputStream:close	()V
    //   230: goto +7 -> 237
    //   233: aload_0
    //   234: invokevirtual 247	java/io/IOException:printStackTrace	()V
    //   237: aload_2
    //   238: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: areturn
    //   242: astore_0
    //   243: aload 7
    //   245: astore_1
    //   246: aload_3
    //   247: astore 4
    //   249: aload 6
    //   251: astore_3
    //   252: aload_3
    //   253: ifnull +14 -> 267
    //   256: aload_3
    //   257: invokevirtual 242	java/io/BufferedReader:close	()V
    //   260: goto +7 -> 267
    //   263: astore_1
    //   264: goto +24 -> 288
    //   267: aload_1
    //   268: ifnull +7 -> 275
    //   271: aload_1
    //   272: invokevirtual 243	java/io/InputStreamReader:close	()V
    //   275: aload 4
    //   277: ifnull +15 -> 292
    //   280: aload 4
    //   282: invokevirtual 246	java/io/InputStream:close	()V
    //   285: goto +7 -> 292
    //   288: aload_1
    //   289: invokevirtual 247	java/io/IOException:printStackTrace	()V
    //   292: aload_0
    //   293: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	294	0	paramString	String
    //   0	294	1	paramContext	Context
    //   7	231	2	localStringBuilder	StringBuilder
    //   9	248	3	localObject1	Object
    //   21	260	4	localObject2	Object
    //   26	129	5	localObject3	Object
    //   46	204	6	str	String
    //   53	191	7	localObject4	Object
    //   108	118	8	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   55	60	105	java/lang/Exception
    //   74	80	105	java/lang/Exception
    //   35	45	117	finally
    //   35	45	124	java/lang/Exception
    //   23	35	138	finally
    //   23	35	144	java/lang/Exception
    //   10	23	161	finally
    //   10	23	171	java/lang/Exception
    //   83	92	206	java/io/IOException
    //   97	102	206	java/io/IOException
    //   199	203	206	java/io/IOException
    //   215	220	206	java/io/IOException
    //   225	230	206	java/io/IOException
    //   55	60	242	finally
    //   74	80	242	finally
    //   191	195	242	finally
    //   256	260	263	java/io/IOException
    //   271	275	263	java/io/IOException
    //   280	285	263	java/io/IOException
  }
  
  public static void g(Context paramContext)
  {
    a = paramContext;
  }
  
  static final class a
    extends a<Map<String, List<i.b>>>
  {}
  
  public static class b
  {
    @c("timezone")
    private String a;
    @c("name")
    private String b;
    private long c;
    private String d;
    
    public String a()
    {
      return this.b;
    }
    
    public long b()
    {
      return this.c;
    }
    
    public String c()
    {
      return this.d;
    }
    
    public String d()
    {
      return this.a;
    }
    
    public void e(String paramString)
    {
      this.b = paramString;
    }
    
    public void f(long paramLong)
    {
      this.c = paramLong;
    }
    
    public void g(String paramString)
    {
      this.d = paramString;
    }
    
    public void h(String paramString)
    {
      this.a = paramString;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\util\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */