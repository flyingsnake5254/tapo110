package com.google.android.exoplayer2.drm;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.HttpDataSource.InvalidResponseCodeException;
import com.google.android.exoplayer2.upstream.HttpDataSource.a;
import com.google.android.exoplayer2.upstream.n.b;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.w0;
import com.google.common.collect.ImmutableMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class h0
  implements i0
{
  private final HttpDataSource.a a;
  @Nullable
  private final String b;
  private final boolean c;
  private final Map<String, String> d;
  
  public h0(@Nullable String paramString, boolean paramBoolean, HttpDataSource.a parama)
  {
    boolean bool;
    if ((paramBoolean) && (TextUtils.isEmpty(paramString))) {
      bool = false;
    } else {
      bool = true;
    }
    g.a(bool);
    this.a = parama;
    this.b = paramString;
    this.c = paramBoolean;
    this.d = new HashMap();
  }
  
  /* Error */
  private static byte[] c(HttpDataSource.a parama, String paramString, @Nullable byte[] paramArrayOfByte, Map<String, String> paramMap)
    throws MediaDrmCallbackException
  {
    // Byte code:
    //   0: new 54	com/google/android/exoplayer2/upstream/z
    //   3: dup
    //   4: aload_0
    //   5: invokeinterface 59 1 0
    //   10: invokespecial 62	com/google/android/exoplayer2/upstream/z:<init>	(Lcom/google/android/exoplayer2/upstream/l;)V
    //   13: astore 4
    //   15: new 64	com/google/android/exoplayer2/upstream/n$b
    //   18: dup
    //   19: invokespecial 65	com/google/android/exoplayer2/upstream/n$b:<init>	()V
    //   22: aload_1
    //   23: invokevirtual 69	com/google/android/exoplayer2/upstream/n$b:j	(Ljava/lang/String;)Lcom/google/android/exoplayer2/upstream/n$b;
    //   26: aload_3
    //   27: invokevirtual 73	com/google/android/exoplayer2/upstream/n$b:e	(Ljava/util/Map;)Lcom/google/android/exoplayer2/upstream/n$b;
    //   30: iconst_2
    //   31: invokevirtual 76	com/google/android/exoplayer2/upstream/n$b:d	(I)Lcom/google/android/exoplayer2/upstream/n$b;
    //   34: aload_2
    //   35: invokevirtual 79	com/google/android/exoplayer2/upstream/n$b:c	([B)Lcom/google/android/exoplayer2/upstream/n$b;
    //   38: iconst_1
    //   39: invokevirtual 81	com/google/android/exoplayer2/upstream/n$b:b	(I)Lcom/google/android/exoplayer2/upstream/n$b;
    //   42: invokevirtual 84	com/google/android/exoplayer2/upstream/n$b:a	()Lcom/google/android/exoplayer2/upstream/n;
    //   45: astore_1
    //   46: iconst_0
    //   47: istore 5
    //   49: aload_1
    //   50: astore_0
    //   51: new 86	com/google/android/exoplayer2/upstream/m
    //   54: astore_2
    //   55: aload_2
    //   56: aload 4
    //   58: aload_0
    //   59: invokespecial 89	com/google/android/exoplayer2/upstream/m:<init>	(Lcom/google/android/exoplayer2/upstream/l;Lcom/google/android/exoplayer2/upstream/n;)V
    //   62: aload_2
    //   63: invokestatic 95	com/google/android/exoplayer2/util/o0:J0	(Ljava/io/InputStream;)[B
    //   66: astore_3
    //   67: aload_2
    //   68: invokestatic 99	com/google/android/exoplayer2/util/o0:m	(Ljava/io/Closeable;)V
    //   71: aload_3
    //   72: areturn
    //   73: astore_0
    //   74: goto +42 -> 116
    //   77: astore 6
    //   79: aload 6
    //   81: iload 5
    //   83: invokestatic 102	com/google/android/exoplayer2/drm/h0:d	(Lcom/google/android/exoplayer2/upstream/HttpDataSource$InvalidResponseCodeException;I)Ljava/lang/String;
    //   86: astore_3
    //   87: aload_3
    //   88: ifnull +25 -> 113
    //   91: iinc 5 1
    //   94: aload_0
    //   95: invokevirtual 107	com/google/android/exoplayer2/upstream/n:a	()Lcom/google/android/exoplayer2/upstream/n$b;
    //   98: aload_3
    //   99: invokevirtual 69	com/google/android/exoplayer2/upstream/n$b:j	(Ljava/lang/String;)Lcom/google/android/exoplayer2/upstream/n$b;
    //   102: invokevirtual 84	com/google/android/exoplayer2/upstream/n$b:a	()Lcom/google/android/exoplayer2/upstream/n;
    //   105: astore_0
    //   106: aload_2
    //   107: invokestatic 99	com/google/android/exoplayer2/util/o0:m	(Ljava/io/Closeable;)V
    //   110: goto -59 -> 51
    //   113: aload 6
    //   115: athrow
    //   116: aload_2
    //   117: invokestatic 99	com/google/android/exoplayer2/util/o0:m	(Ljava/io/Closeable;)V
    //   120: aload_0
    //   121: athrow
    //   122: astore_0
    //   123: new 48	com/google/android/exoplayer2/drm/MediaDrmCallbackException
    //   126: dup
    //   127: aload_1
    //   128: aload 4
    //   130: invokevirtual 111	com/google/android/exoplayer2/upstream/z:p	()Landroid/net/Uri;
    //   133: invokestatic 114	com/google/android/exoplayer2/util/g:e	(Ljava/lang/Object;)Ljava/lang/Object;
    //   136: checkcast 116	android/net/Uri
    //   139: aload 4
    //   141: invokevirtual 119	com/google/android/exoplayer2/upstream/z:d	()Ljava/util/Map;
    //   144: aload 4
    //   146: invokevirtual 123	com/google/android/exoplayer2/upstream/z:o	()J
    //   149: aload_0
    //   150: invokespecial 126	com/google/android/exoplayer2/drm/MediaDrmCallbackException:<init>	(Lcom/google/android/exoplayer2/upstream/n;Landroid/net/Uri;Ljava/util/Map;JLjava/lang/Throwable;)V
    //   153: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	parama	HttpDataSource.a
    //   0	154	1	paramString	String
    //   0	154	2	paramArrayOfByte	byte[]
    //   0	154	3	paramMap	Map<String, String>
    //   13	132	4	localz	com.google.android.exoplayer2.upstream.z
    //   47	45	5	i	int
    //   77	37	6	localInvalidResponseCodeException	HttpDataSource.InvalidResponseCodeException
    // Exception table:
    //   from	to	target	type
    //   62	67	73	finally
    //   79	87	73	finally
    //   94	106	73	finally
    //   113	116	73	finally
    //   62	67	77	com/google/android/exoplayer2/upstream/HttpDataSource$InvalidResponseCodeException
    //   51	62	122	java/lang/Exception
    //   67	71	122	java/lang/Exception
    //   106	110	122	java/lang/Exception
    //   116	122	122	java/lang/Exception
  }
  
  @Nullable
  private static String d(HttpDataSource.InvalidResponseCodeException paramInvalidResponseCodeException, int paramInt)
  {
    int i = paramInvalidResponseCodeException.responseCode;
    if (((i == 307) || (i == 308)) && (paramInt < 5)) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (paramInt == 0) {
      return null;
    }
    paramInvalidResponseCodeException = paramInvalidResponseCodeException.headerFields;
    if (paramInvalidResponseCodeException != null)
    {
      paramInvalidResponseCodeException = (List)paramInvalidResponseCodeException.get("Location");
      if ((paramInvalidResponseCodeException != null) && (!paramInvalidResponseCodeException.isEmpty())) {
        return (String)paramInvalidResponseCodeException.get(0);
      }
    }
    return null;
  }
  
  public byte[] a(UUID paramUUID, e0.d paramd)
    throws MediaDrmCallbackException
  {
    paramUUID = paramd.b();
    String str = o0.B(paramd.a());
    paramd = new StringBuilder(String.valueOf(paramUUID).length() + 15 + String.valueOf(str).length());
    paramd.append(paramUUID);
    paramd.append("&signedRequest=");
    paramd.append(str);
    paramUUID = paramd.toString();
    return c(this.a, paramUUID, null, Collections.emptyMap());
  }
  
  public byte[] b(UUID arg1, e0.a parama)
    throws MediaDrmCallbackException
  {
    String str1 = parama.b();
    String str2;
    if (!this.c)
    {
      str2 = str1;
      if (!TextUtils.isEmpty(str1)) {}
    }
    else
    {
      str2 = this.b;
    }
    if (!TextUtils.isEmpty(str2))
    {
      HashMap localHashMap = new HashMap();
      UUID localUUID = w0.e;
      if (localUUID.equals(???)) {
        str1 = "text/xml";
      } else if (w0.c.equals(???)) {
        str1 = "application/json";
      } else {
        str1 = "application/octet-stream";
      }
      localHashMap.put("Content-Type", str1);
      if (localUUID.equals(???)) {
        localHashMap.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
      }
      synchronized (this.d)
      {
        localHashMap.putAll(this.d);
        return c(this.a, str2, parama.a(), localHashMap);
      }
    }
    throw new MediaDrmCallbackException(new n.b().i(Uri.EMPTY).a(), Uri.EMPTY, ImmutableMap.of(), 0L, new IllegalStateException("No license URL"));
  }
  
  public void e(String paramString1, String paramString2)
  {
    g.e(paramString1);
    g.e(paramString2);
    synchronized (this.d)
    {
      this.d.put(paramString1, paramString2);
      return;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\drm\h0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */