package com.tplink.libtpnetwork.cameranetwork.util;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.q.c;
import io.reactivex.q;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class d
{
  private Context a;
  private final Map<String, Map<String, b>> b = new LinkedHashMap();
  private final Object c = new Object();
  
  private Map<String, Map<String, b>> a(Context paramContext)
  {
    String str = f("daylight_saving.json", paramContext);
    paramContext = new a().getType();
    Gson localGson = new Gson();
    try
    {
      paramContext = (Map)localGson.m(str, paramContext);
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      paramContext = null;
    }
    return paramContext;
  }
  
  private Map<String, b> b(String paramString)
  {
    paramString = (Map)this.b.get(paramString);
    if (paramString == null) {
      paramString = new HashMap();
    }
    return paramString;
  }
  
  public static d c()
  {
    return c.a();
  }
  
  /* Error */
  private String f(String paramString, Context paramContext)
  {
    // Byte code:
    //   0: new 102	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   7: astore_3
    //   8: aconst_null
    //   9: astore 4
    //   11: aload_2
    //   12: invokevirtual 109	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   15: invokevirtual 115	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   18: aload_1
    //   19: invokevirtual 121	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   22: astore 5
    //   24: new 123	java/io/InputStreamReader
    //   27: astore 6
    //   29: aload 6
    //   31: aload 5
    //   33: invokespecial 126	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   36: new 128	java/io/BufferedReader
    //   39: astore_1
    //   40: aload_1
    //   41: aload 6
    //   43: invokespecial 131	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   46: aload_1
    //   47: astore 7
    //   49: aload 5
    //   51: astore 4
    //   53: aload 6
    //   55: astore 8
    //   57: aload_1
    //   58: invokevirtual 135	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   61: astore_2
    //   62: aload_2
    //   63: ifnull +23 -> 86
    //   66: aload_1
    //   67: astore 7
    //   69: aload 5
    //   71: astore 4
    //   73: aload 6
    //   75: astore 8
    //   77: aload_3
    //   78: aload_2
    //   79: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: goto -37 -> 46
    //   86: aload_1
    //   87: invokevirtual 142	java/io/BufferedReader:close	()V
    //   90: aload 6
    //   92: invokevirtual 143	java/io/InputStreamReader:close	()V
    //   95: aload 5
    //   97: ifnull +144 -> 241
    //   100: aload 5
    //   102: invokevirtual 146	java/io/InputStream:close	()V
    //   105: goto +136 -> 241
    //   108: astore_2
    //   109: aload 5
    //   111: astore 9
    //   113: aload 6
    //   115: astore 5
    //   117: goto +67 -> 184
    //   120: astore_1
    //   121: aload 6
    //   123: astore_2
    //   124: goto +134 -> 258
    //   127: astore_2
    //   128: aconst_null
    //   129: astore_1
    //   130: aload 5
    //   132: astore 9
    //   134: aload 6
    //   136: astore 5
    //   138: goto +46 -> 184
    //   141: astore_1
    //   142: aconst_null
    //   143: astore_2
    //   144: goto +114 -> 258
    //   147: astore_2
    //   148: aconst_null
    //   149: astore_1
    //   150: aload_1
    //   151: astore 6
    //   153: aload 5
    //   155: astore 9
    //   157: aload 6
    //   159: astore 5
    //   161: goto +23 -> 184
    //   164: astore_1
    //   165: aconst_null
    //   166: astore 5
    //   168: aload 5
    //   170: astore_2
    //   171: goto +87 -> 258
    //   174: astore_2
    //   175: aconst_null
    //   176: astore 5
    //   178: aload 5
    //   180: astore_1
    //   181: aload_1
    //   182: astore 9
    //   184: aload_1
    //   185: astore 7
    //   187: aload 9
    //   189: astore 4
    //   191: aload 5
    //   193: astore 8
    //   195: aload_2
    //   196: invokevirtual 61	java/lang/Exception:printStackTrace	()V
    //   199: aload_1
    //   200: ifnull +14 -> 214
    //   203: aload_1
    //   204: invokevirtual 142	java/io/BufferedReader:close	()V
    //   207: goto +7 -> 214
    //   210: astore_1
    //   211: goto +26 -> 237
    //   214: aload 5
    //   216: ifnull +8 -> 224
    //   219: aload 5
    //   221: invokevirtual 143	java/io/InputStreamReader:close	()V
    //   224: aload 9
    //   226: ifnull +15 -> 241
    //   229: aload 9
    //   231: invokevirtual 146	java/io/InputStream:close	()V
    //   234: goto +7 -> 241
    //   237: aload_1
    //   238: invokevirtual 147	java/io/IOException:printStackTrace	()V
    //   241: aload_3
    //   242: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: areturn
    //   246: astore_1
    //   247: aload 8
    //   249: astore_2
    //   250: aload 4
    //   252: astore 5
    //   254: aload 7
    //   256: astore 4
    //   258: aload 4
    //   260: ifnull +15 -> 275
    //   263: aload 4
    //   265: invokevirtual 142	java/io/BufferedReader:close	()V
    //   268: goto +7 -> 275
    //   271: astore_2
    //   272: goto +24 -> 296
    //   275: aload_2
    //   276: ifnull +7 -> 283
    //   279: aload_2
    //   280: invokevirtual 143	java/io/InputStreamReader:close	()V
    //   283: aload 5
    //   285: ifnull +15 -> 300
    //   288: aload 5
    //   290: invokevirtual 146	java/io/InputStream:close	()V
    //   293: goto +7 -> 300
    //   296: aload_2
    //   297: invokevirtual 147	java/io/IOException:printStackTrace	()V
    //   300: aload_1
    //   301: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	302	0	this	d
    //   0	302	1	paramString	String
    //   0	302	2	paramContext	Context
    //   7	235	3	localStringBuilder	StringBuilder
    //   9	255	4	localObject1	Object
    //   22	267	5	localObject2	Object
    //   27	131	6	localObject3	Object
    //   47	208	7	str	String
    //   55	193	8	localObject4	Object
    //   111	119	9	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   57	62	108	java/lang/Exception
    //   77	83	108	java/lang/Exception
    //   36	46	120	finally
    //   36	46	127	java/lang/Exception
    //   24	36	141	finally
    //   24	36	147	java/lang/Exception
    //   11	24	164	finally
    //   11	24	174	java/lang/Exception
    //   86	95	210	java/io/IOException
    //   100	105	210	java/io/IOException
    //   203	207	210	java/io/IOException
    //   219	224	210	java/io/IOException
    //   229	234	210	java/io/IOException
    //   57	62	246	finally
    //   77	83	246	finally
    //   195	199	246	finally
    //   263	268	271	java/io/IOException
    //   279	283	271	java/io/IOException
    //   288	293	271	java/io/IOException
  }
  
  public q<Map<String, b>> g(String paramString)
  {
    return q.f0(paramString).N(new a(this)).L0(io.reactivex.l0.a.c());
  }
  
  public void h(Context paramContext)
  {
    this.a = paramContext;
  }
  
  class a
    extends com.google.gson.r.a<Map<String, Map<String, d.b>>>
  {
    a() {}
  }
  
  public static class b
  {
    @c("zone_id")
    private String a;
    @c("year")
    private Integer b;
    @c("dst_saving")
    private int c;
    @c("start_time")
    private long d;
    @c("end_time")
    private long e;
    
    public long a()
    {
      return this.e;
    }
    
    public long b()
    {
      return this.d;
    }
  }
  
  private static class c
  {
    private static final d a = new d(null);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\util\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */