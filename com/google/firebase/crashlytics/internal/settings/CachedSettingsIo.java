package com.google.firebase.crashlytics.internal.settings;

import android.content.Context;
import com.google.firebase.crashlytics.internal.persistence.FileStoreImpl;
import java.io.File;

public class CachedSettingsIo
{
  private static final String SETTINGS_CACHE_FILENAME = "com.crashlytics.settings.json";
  private final Context context;
  
  public CachedSettingsIo(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private File getSettingsFile()
  {
    return new File(new FileStoreImpl(this.context).getFilesDir(), "com.crashlytics.settings.json");
  }
  
  /* Error */
  public org.json.JSONObject readCachedSettings()
  {
    // Byte code:
    //   0: invokestatic 42	com/google/firebase/crashlytics/internal/Logger:getLogger	()Lcom/google/firebase/crashlytics/internal/Logger;
    //   3: ldc 44
    //   5: invokevirtual 48	com/google/firebase/crashlytics/internal/Logger:d	(Ljava/lang/String;)V
    //   8: aconst_null
    //   9: astore_1
    //   10: aconst_null
    //   11: astore_2
    //   12: aload_0
    //   13: invokespecial 50	com/google/firebase/crashlytics/internal/settings/CachedSettingsIo:getSettingsFile	()Ljava/io/File;
    //   16: astore_3
    //   17: aload_3
    //   18: invokevirtual 54	java/io/File:exists	()Z
    //   21: ifeq +53 -> 74
    //   24: new 56	java/io/FileInputStream
    //   27: astore 4
    //   29: aload 4
    //   31: aload_3
    //   32: invokespecial 59	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   35: aload 4
    //   37: astore_2
    //   38: aload 4
    //   40: invokestatic 65	com/google/firebase/crashlytics/internal/common/CommonUtils:streamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   43: astore 5
    //   45: aload 4
    //   47: astore_2
    //   48: new 67	org/json/JSONObject
    //   51: astore_3
    //   52: aload 4
    //   54: astore_2
    //   55: aload_3
    //   56: aload 5
    //   58: invokespecial 69	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   61: aload 4
    //   63: astore_2
    //   64: aload_3
    //   65: astore 4
    //   67: goto +18 -> 85
    //   70: astore_3
    //   71: goto +34 -> 105
    //   74: invokestatic 42	com/google/firebase/crashlytics/internal/Logger:getLogger	()Lcom/google/firebase/crashlytics/internal/Logger;
    //   77: ldc 71
    //   79: invokevirtual 74	com/google/firebase/crashlytics/internal/Logger:v	(Ljava/lang/String;)V
    //   82: aconst_null
    //   83: astore 4
    //   85: aload_2
    //   86: ldc 76
    //   88: invokestatic 80	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   91: goto +36 -> 127
    //   94: astore 4
    //   96: aconst_null
    //   97: astore_2
    //   98: goto +34 -> 132
    //   101: astore_3
    //   102: aconst_null
    //   103: astore 4
    //   105: aload 4
    //   107: astore_2
    //   108: invokestatic 42	com/google/firebase/crashlytics/internal/Logger:getLogger	()Lcom/google/firebase/crashlytics/internal/Logger;
    //   111: ldc 82
    //   113: aload_3
    //   114: invokevirtual 86	com/google/firebase/crashlytics/internal/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   117: aload 4
    //   119: ldc 76
    //   121: invokestatic 80	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   124: aload_1
    //   125: astore 4
    //   127: aload 4
    //   129: areturn
    //   130: astore 4
    //   132: aload_2
    //   133: ldc 76
    //   135: invokestatic 80	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   138: aload 4
    //   140: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	this	CachedSettingsIo
    //   9	116	1	localObject1	Object
    //   11	122	2	localObject2	Object
    //   16	49	3	localObject3	Object
    //   70	1	3	localException1	Exception
    //   101	13	3	localException2	Exception
    //   27	57	4	localObject4	Object
    //   94	1	4	localObject5	Object
    //   103	25	4	localObject6	Object
    //   130	9	4	localObject7	Object
    //   43	14	5	str	String
    // Exception table:
    //   from	to	target	type
    //   38	45	70	java/lang/Exception
    //   48	52	70	java/lang/Exception
    //   55	61	70	java/lang/Exception
    //   12	35	94	finally
    //   74	82	94	finally
    //   12	35	101	java/lang/Exception
    //   74	82	101	java/lang/Exception
    //   38	45	130	finally
    //   48	52	130	finally
    //   55	61	130	finally
    //   108	117	130	finally
  }
  
  /* Error */
  public void writeCachedSettings(long paramLong, org.json.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: invokestatic 42	com/google/firebase/crashlytics/internal/Logger:getLogger	()Lcom/google/firebase/crashlytics/internal/Logger;
    //   3: ldc 90
    //   5: invokevirtual 74	com/google/firebase/crashlytics/internal/Logger:v	(Ljava/lang/String;)V
    //   8: aload_3
    //   9: ifnull +127 -> 136
    //   12: aconst_null
    //   13: astore 4
    //   15: aconst_null
    //   16: astore 5
    //   18: aload 5
    //   20: astore 6
    //   22: aload_3
    //   23: ldc 92
    //   25: lload_1
    //   26: invokevirtual 96	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   29: pop
    //   30: aload 5
    //   32: astore 6
    //   34: new 98	java/io/FileWriter
    //   37: astore 7
    //   39: aload 5
    //   41: astore 6
    //   43: aload 7
    //   45: aload_0
    //   46: invokespecial 50	com/google/firebase/crashlytics/internal/settings/CachedSettingsIo:getSettingsFile	()Ljava/io/File;
    //   49: invokespecial 99	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   52: aload 7
    //   54: aload_3
    //   55: invokevirtual 103	org/json/JSONObject:toString	()Ljava/lang/String;
    //   58: invokevirtual 106	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   61: aload 7
    //   63: invokevirtual 109	java/io/FileWriter:flush	()V
    //   66: aload 7
    //   68: ldc 111
    //   70: invokestatic 80	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   73: goto +63 -> 136
    //   76: astore_3
    //   77: aload 7
    //   79: astore 6
    //   81: goto +46 -> 127
    //   84: astore 6
    //   86: aload 7
    //   88: astore_3
    //   89: aload 6
    //   91: astore 7
    //   93: goto +12 -> 105
    //   96: astore_3
    //   97: goto +30 -> 127
    //   100: astore 7
    //   102: aload 4
    //   104: astore_3
    //   105: aload_3
    //   106: astore 6
    //   108: invokestatic 42	com/google/firebase/crashlytics/internal/Logger:getLogger	()Lcom/google/firebase/crashlytics/internal/Logger;
    //   111: ldc 113
    //   113: aload 7
    //   115: invokevirtual 86	com/google/firebase/crashlytics/internal/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   118: aload_3
    //   119: ldc 111
    //   121: invokestatic 80	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   124: goto +12 -> 136
    //   127: aload 6
    //   129: ldc 111
    //   131: invokestatic 80	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   134: aload_3
    //   135: athrow
    //   136: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	this	CachedSettingsIo
    //   0	137	1	paramLong	long
    //   0	137	3	paramJSONObject	org.json.JSONObject
    //   13	90	4	localObject1	Object
    //   16	24	5	localObject2	Object
    //   20	60	6	localObject3	Object
    //   84	6	6	localException1	Exception
    //   106	22	6	localJSONObject	org.json.JSONObject
    //   37	55	7	localObject4	Object
    //   100	14	7	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   52	66	76	finally
    //   52	66	84	java/lang/Exception
    //   22	30	96	finally
    //   34	39	96	finally
    //   43	52	96	finally
    //   108	118	96	finally
    //   22	30	100	java/lang/Exception
    //   34	39	100	java/lang/Exception
    //   43	52	100	java/lang/Exception
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\settings\CachedSettingsIo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */