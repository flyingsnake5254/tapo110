package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;

public final class zzic
{
  public static String zza(Context paramContext, String paramString1, String paramString2)
  {
    Preconditions.checkNotNull(paramContext);
    paramString1 = paramContext.getResources();
    if (TextUtils.isEmpty(paramString2)) {
      paramString2 = zzfm.zza(paramContext);
    }
    return zzfm.zzb("google_app_id", paramString1, paramString2);
  }
  
  /* Error */
  public static Object zzb(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +98 -> 99
    //   4: new 42	java/io/ByteArrayOutputStream
    //   7: astore_1
    //   8: aload_1
    //   9: invokespecial 46	java/io/ByteArrayOutputStream:<init>	()V
    //   12: new 48	java/io/ObjectOutputStream
    //   15: astore_2
    //   16: aload_2
    //   17: aload_1
    //   18: invokespecial 51	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   21: aload_2
    //   22: aload_0
    //   23: invokevirtual 55	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   26: aload_2
    //   27: invokevirtual 58	java/io/ObjectOutputStream:flush	()V
    //   30: new 60	java/io/ObjectInputStream
    //   33: astore_3
    //   34: new 62	java/io/ByteArrayInputStream
    //   37: astore_0
    //   38: aload_0
    //   39: aload_1
    //   40: invokevirtual 66	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   43: invokespecial 69	java/io/ByteArrayInputStream:<init>	([B)V
    //   46: aload_3
    //   47: aload_0
    //   48: invokespecial 72	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   51: aload_3
    //   52: invokevirtual 76	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   55: astore_0
    //   56: aload_2
    //   57: invokevirtual 79	java/io/ObjectOutputStream:close	()V
    //   60: aload_3
    //   61: invokevirtual 80	java/io/ObjectInputStream:close	()V
    //   64: aload_0
    //   65: areturn
    //   66: astore_0
    //   67: goto +14 -> 81
    //   70: astore_0
    //   71: aconst_null
    //   72: astore_3
    //   73: goto +8 -> 81
    //   76: astore_0
    //   77: aconst_null
    //   78: astore_3
    //   79: aload_3
    //   80: astore_2
    //   81: aload_2
    //   82: ifnull +7 -> 89
    //   85: aload_2
    //   86: invokevirtual 79	java/io/ObjectOutputStream:close	()V
    //   89: aload_3
    //   90: ifnull +7 -> 97
    //   93: aload_3
    //   94: invokevirtual 80	java/io/ObjectInputStream:close	()V
    //   97: aload_0
    //   98: athrow
    //   99: aconst_null
    //   100: areturn
    //   101: astore_0
    //   102: goto -3 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	paramObject	Object
    //   7	33	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   15	71	2	localObject	Object
    //   33	61	3	localObjectInputStream	java.io.ObjectInputStream
    // Exception table:
    //   from	to	target	type
    //   51	56	66	finally
    //   21	51	70	finally
    //   4	21	76	finally
    //   56	64	101	java/io/IOException
    //   56	64	101	java/lang/ClassNotFoundException
    //   85	89	101	java/io/IOException
    //   85	89	101	java/lang/ClassNotFoundException
    //   93	97	101	java/io/IOException
    //   93	97	101	java/lang/ClassNotFoundException
    //   97	99	101	java/io/IOException
    //   97	99	101	java/lang/ClassNotFoundException
  }
  
  public static String zzc(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    Preconditions.checkNotNull(paramArrayOfString1);
    Preconditions.checkNotNull(paramArrayOfString2);
    int i = Math.min(paramArrayOfString1.length, paramArrayOfString2.length);
    for (int j = 0; j < i; j++)
    {
      String str = paramArrayOfString1[j];
      if (((paramString == null) && (str == null)) || ((paramString != null) && (paramString.equals(str)))) {
        return paramArrayOfString2[j];
      }
    }
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */