package com.google.firebase.crashlytics.internal.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HttpGetRequest
{
  private static final int DEFAULT_TIMEOUT_MS = 10000;
  private static final String METHOD_GET = "GET";
  private static final int READ_BUFFER_SIZE = 8192;
  private final Map<String, String> headers;
  private final Map<String, String> queryParams;
  private final String url;
  
  public HttpGetRequest(String paramString, Map<String, String> paramMap)
  {
    this.url = paramString;
    this.queryParams = paramMap;
    this.headers = new HashMap();
  }
  
  private String createParamsString(Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    Iterator localIterator = paramMap.entrySet().iterator();
    paramMap = (Map.Entry)localIterator.next();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append((String)paramMap.getKey());
    localStringBuilder2.append("=");
    if (paramMap.getValue() != null) {
      paramMap = (String)paramMap.getValue();
    } else {
      paramMap = "";
    }
    localStringBuilder2.append(paramMap);
    localStringBuilder1.append(localStringBuilder2.toString());
    while (localIterator.hasNext())
    {
      paramMap = (Map.Entry)localIterator.next();
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("&");
      localStringBuilder2.append((String)paramMap.getKey());
      localStringBuilder2.append("=");
      if (paramMap.getValue() != null) {
        paramMap = (String)paramMap.getValue();
      } else {
        paramMap = "";
      }
      localStringBuilder2.append(paramMap);
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    return localStringBuilder1.toString();
  }
  
  private String createUrlWithParams(String paramString, Map<String, String> paramMap)
  {
    Object localObject = createParamsString(paramMap);
    if (((String)localObject).isEmpty()) {
      return paramString;
    }
    if (paramString.contains("?"))
    {
      paramMap = (Map<String, String>)localObject;
      if (!paramString.endsWith("&"))
      {
        paramMap = new StringBuilder();
        paramMap.append("&");
        paramMap.append((String)localObject);
        paramMap = paramMap.toString();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(paramMap);
      return ((StringBuilder)localObject).toString();
    }
    paramMap = new StringBuilder();
    paramMap.append(paramString);
    paramMap.append("?");
    paramMap.append((String)localObject);
    return paramMap.toString();
  }
  
  private String readStream(InputStream paramInputStream)
    throws IOException
  {
    paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream, "UTF-8"));
    char[] arrayOfChar = new char[' '];
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      int i = paramInputStream.read(arrayOfChar);
      if (i == -1) {
        break;
      }
      localStringBuilder.append(arrayOfChar, 0, i);
    }
    return localStringBuilder.toString();
  }
  
  /* Error */
  public HttpResponse execute()
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_0
    //   5: aload_0
    //   6: getfield 25	com/google/firebase/crashlytics/internal/network/HttpGetRequest:url	Ljava/lang/String;
    //   9: aload_0
    //   10: getfield 27	com/google/firebase/crashlytics/internal/network/HttpGetRequest:queryParams	Ljava/util/Map;
    //   13: invokespecial 133	com/google/firebase/crashlytics/internal/network/HttpGetRequest:createUrlWithParams	(Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
    //   16: astore_3
    //   17: invokestatic 139	com/google/firebase/crashlytics/internal/Logger:getLogger	()Lcom/google/firebase/crashlytics/internal/Logger;
    //   20: astore 4
    //   22: new 39	java/lang/StringBuilder
    //   25: astore 5
    //   27: aload 5
    //   29: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   32: aload 5
    //   34: ldc -115
    //   36: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload 5
    //   42: aload_3
    //   43: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload 4
    //   49: aload 5
    //   51: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokevirtual 145	com/google/firebase/crashlytics/internal/Logger:v	(Ljava/lang/String;)V
    //   57: new 147	java/net/URL
    //   60: astore 5
    //   62: aload 5
    //   64: aload_3
    //   65: invokespecial 149	java/net/URL:<init>	(Ljava/lang/String;)V
    //   68: aload 5
    //   70: invokevirtual 153	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   73: checkcast 155	javax/net/ssl/HttpsURLConnection
    //   76: astore_3
    //   77: aload_3
    //   78: sipush 10000
    //   81: invokevirtual 159	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   84: aload_3
    //   85: sipush 10000
    //   88: invokevirtual 162	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   91: aload_3
    //   92: ldc 11
    //   94: invokevirtual 165	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   97: aload_0
    //   98: getfield 32	com/google/firebase/crashlytics/internal/network/HttpGetRequest:headers	Ljava/util/Map;
    //   101: invokeinterface 46 1 0
    //   106: invokeinterface 52 1 0
    //   111: astore 5
    //   113: aload 5
    //   115: invokeinterface 84 1 0
    //   120: ifeq +42 -> 162
    //   123: aload 5
    //   125: invokeinterface 58 1 0
    //   130: checkcast 60	java/util/Map$Entry
    //   133: astore 4
    //   135: aload_3
    //   136: aload 4
    //   138: invokeinterface 63 1 0
    //   143: checkcast 65	java/lang/String
    //   146: aload 4
    //   148: invokeinterface 74 1 0
    //   153: checkcast 65	java/lang/String
    //   156: invokevirtual 169	javax/net/ssl/HttpsURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   159: goto -46 -> 113
    //   162: aload_3
    //   163: invokevirtual 172	javax/net/ssl/HttpsURLConnection:connect	()V
    //   166: aload_3
    //   167: invokevirtual 176	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   170: istore 6
    //   172: aload_3
    //   173: invokevirtual 180	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   176: astore 5
    //   178: aload 5
    //   180: ifnull +20 -> 200
    //   183: aload_0
    //   184: aload 5
    //   186: invokespecial 182	com/google/firebase/crashlytics/internal/network/HttpGetRequest:readStream	(Ljava/io/InputStream;)Ljava/lang/String;
    //   189: astore_2
    //   190: goto +10 -> 200
    //   193: astore_2
    //   194: aload 5
    //   196: astore_1
    //   197: goto +35 -> 232
    //   200: aload 5
    //   202: ifnull +8 -> 210
    //   205: aload 5
    //   207: invokevirtual 187	java/io/InputStream:close	()V
    //   210: aload_3
    //   211: invokevirtual 190	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   214: new 192	com/google/firebase/crashlytics/internal/network/HttpResponse
    //   217: dup
    //   218: iload 6
    //   220: aload_2
    //   221: invokespecial 195	com/google/firebase/crashlytics/internal/network/HttpResponse:<init>	(ILjava/lang/String;)V
    //   224: areturn
    //   225: astore_2
    //   226: goto +6 -> 232
    //   229: astore_2
    //   230: aconst_null
    //   231: astore_3
    //   232: aload_1
    //   233: ifnull +7 -> 240
    //   236: aload_1
    //   237: invokevirtual 187	java/io/InputStream:close	()V
    //   240: aload_3
    //   241: ifnull +7 -> 248
    //   244: aload_3
    //   245: invokevirtual 190	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   248: aload_2
    //   249: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	250	0	this	HttpGetRequest
    //   1	236	1	localObject1	Object
    //   3	187	2	str1	String
    //   193	28	2	str2	String
    //   225	1	2	localObject2	Object
    //   229	20	2	localObject3	Object
    //   16	229	3	localObject4	Object
    //   20	127	4	localObject5	Object
    //   25	181	5	localObject6	Object
    //   170	49	6	i	int
    // Exception table:
    //   from	to	target	type
    //   183	190	193	finally
    //   77	113	225	finally
    //   113	159	225	finally
    //   162	178	225	finally
    //   4	77	229	finally
  }
  
  public HttpGetRequest header(String paramString1, String paramString2)
  {
    this.headers.put(paramString1, paramString2);
    return this;
  }
  
  public HttpGetRequest header(Map.Entry<String, String> paramEntry)
  {
    return header((String)paramEntry.getKey(), (String)paramEntry.getValue());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\network\HttpGetRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */