package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import java.io.File;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class MetaDataStore
{
  private static final String KEYDATA_SUFFIX = "keys";
  private static final String KEY_USER_ID = "userId";
  private static final String METADATA_EXT = ".meta";
  private static final String USERDATA_SUFFIX = "user";
  private static final Charset UTF_8 = Charset.forName("UTF-8");
  private final File filesDir;
  
  public MetaDataStore(File paramFile)
  {
    this.filesDir = paramFile;
  }
  
  private static Map<String, String> jsonToKeysData(String paramString)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject(paramString);
    HashMap localHashMap = new HashMap();
    paramString = localJSONObject.keys();
    while (paramString.hasNext())
    {
      String str = (String)paramString.next();
      localHashMap.put(str, valueOrNull(localJSONObject, str));
    }
    return localHashMap;
  }
  
  private static UserMetadata jsonToUserData(String paramString)
    throws JSONException
  {
    paramString = new JSONObject(paramString);
    UserMetadata localUserMetadata = new UserMetadata();
    localUserMetadata.setUserId(valueOrNull(paramString, "userId"));
    return localUserMetadata;
  }
  
  private static String keysDataToJson(Map<String, String> paramMap)
    throws JSONException
  {
    return new JSONObject(paramMap).toString();
  }
  
  private static String userDataToJson(UserMetadata paramUserMetadata)
    throws JSONException
  {
    new JSONObject() {}.toString();
  }
  
  private static String valueOrNull(JSONObject paramJSONObject, String paramString)
  {
    boolean bool = paramJSONObject.isNull(paramString);
    String str = null;
    if (!bool) {
      str = paramJSONObject.optString(paramString, null);
    }
    return str;
  }
  
  @NonNull
  public File getKeysFileForSession(String paramString)
  {
    File localFile = this.filesDir;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("keys");
    localStringBuilder.append(".meta");
    return new File(localFile, localStringBuilder.toString());
  }
  
  @NonNull
  public File getUserDataFileForSession(String paramString)
  {
    File localFile = this.filesDir;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("user");
    localStringBuilder.append(".meta");
    return new File(localFile, localStringBuilder.toString());
  }
  
  /* Error */
  public Map<String, String> readKeyData(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 136	com/google/firebase/crashlytics/internal/common/MetaDataStore:getKeysFileForSession	(Ljava/lang/String;)Ljava/io/File;
    //   5: astore_2
    //   6: aload_2
    //   7: invokevirtual 139	java/io/File:exists	()Z
    //   10: ifne +7 -> 17
    //   13: invokestatic 145	java/util/Collections:emptyMap	()Ljava/util/Map;
    //   16: areturn
    //   17: aconst_null
    //   18: astore_3
    //   19: aconst_null
    //   20: astore 4
    //   22: aload 4
    //   24: astore_1
    //   25: new 147	java/io/FileInputStream
    //   28: astore 5
    //   30: aload 4
    //   32: astore_1
    //   33: aload 5
    //   35: aload_2
    //   36: invokespecial 149	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   39: aload 5
    //   41: invokestatic 155	com/google/firebase/crashlytics/internal/common/CommonUtils:streamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   44: invokestatic 157	com/google/firebase/crashlytics/internal/common/MetaDataStore:jsonToKeysData	(Ljava/lang/String;)Ljava/util/Map;
    //   47: astore_1
    //   48: aload 5
    //   50: ldc -97
    //   52: invokestatic 163	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   55: aload_1
    //   56: areturn
    //   57: astore_1
    //   58: goto +48 -> 106
    //   61: astore 4
    //   63: goto +19 -> 82
    //   66: astore 4
    //   68: aload_1
    //   69: astore 5
    //   71: aload 4
    //   73: astore_1
    //   74: goto +32 -> 106
    //   77: astore 4
    //   79: aload_3
    //   80: astore 5
    //   82: aload 5
    //   84: astore_1
    //   85: invokestatic 169	com/google/firebase/crashlytics/internal/Logger:getLogger	()Lcom/google/firebase/crashlytics/internal/Logger;
    //   88: ldc -85
    //   90: aload 4
    //   92: invokevirtual 175	com/google/firebase/crashlytics/internal/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   95: aload 5
    //   97: ldc -97
    //   99: invokestatic 163	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   102: invokestatic 145	java/util/Collections:emptyMap	()Ljava/util/Map;
    //   105: areturn
    //   106: aload 5
    //   108: ldc -97
    //   110: invokestatic 163	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   113: aload_1
    //   114: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	this	MetaDataStore
    //   0	115	1	paramString	String
    //   5	31	2	localFile	File
    //   18	62	3	localObject1	Object
    //   20	11	4	localObject2	Object
    //   61	1	4	localException1	Exception
    //   66	6	4	localObject3	Object
    //   77	14	4	localException2	Exception
    //   28	79	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   39	48	57	finally
    //   39	48	61	java/lang/Exception
    //   25	30	66	finally
    //   33	39	66	finally
    //   85	95	66	finally
    //   25	30	77	java/lang/Exception
    //   33	39	77	java/lang/Exception
  }
  
  /* Error */
  public UserMetadata readUserData(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 178	com/google/firebase/crashlytics/internal/common/MetaDataStore:getUserDataFileForSession	(Ljava/lang/String;)Ljava/io/File;
    //   5: astore_2
    //   6: aload_2
    //   7: invokevirtual 139	java/io/File:exists	()Z
    //   10: ifne +11 -> 21
    //   13: new 86	com/google/firebase/crashlytics/internal/common/UserMetadata
    //   16: dup
    //   17: invokespecial 87	com/google/firebase/crashlytics/internal/common/UserMetadata:<init>	()V
    //   20: areturn
    //   21: aconst_null
    //   22: astore_3
    //   23: aconst_null
    //   24: astore 4
    //   26: aload 4
    //   28: astore_1
    //   29: new 147	java/io/FileInputStream
    //   32: astore 5
    //   34: aload 4
    //   36: astore_1
    //   37: aload 5
    //   39: aload_2
    //   40: invokespecial 149	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   43: aload 5
    //   45: invokestatic 155	com/google/firebase/crashlytics/internal/common/CommonUtils:streamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   48: invokestatic 180	com/google/firebase/crashlytics/internal/common/MetaDataStore:jsonToUserData	(Ljava/lang/String;)Lcom/google/firebase/crashlytics/internal/common/UserMetadata;
    //   51: astore_1
    //   52: aload 5
    //   54: ldc -97
    //   56: invokestatic 163	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   59: aload_1
    //   60: areturn
    //   61: astore 4
    //   63: aload 5
    //   65: astore_1
    //   66: aload 4
    //   68: astore 5
    //   70: goto +48 -> 118
    //   73: astore_1
    //   74: aload_1
    //   75: astore 4
    //   77: goto +13 -> 90
    //   80: astore 5
    //   82: goto +36 -> 118
    //   85: astore 4
    //   87: aload_3
    //   88: astore 5
    //   90: aload 5
    //   92: astore_1
    //   93: invokestatic 169	com/google/firebase/crashlytics/internal/Logger:getLogger	()Lcom/google/firebase/crashlytics/internal/Logger;
    //   96: ldc -85
    //   98: aload 4
    //   100: invokevirtual 175	com/google/firebase/crashlytics/internal/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   103: aload 5
    //   105: ldc -97
    //   107: invokestatic 163	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   110: new 86	com/google/firebase/crashlytics/internal/common/UserMetadata
    //   113: dup
    //   114: invokespecial 87	com/google/firebase/crashlytics/internal/common/UserMetadata:<init>	()V
    //   117: areturn
    //   118: aload_1
    //   119: ldc -97
    //   121: invokestatic 163	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   124: aload 5
    //   126: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	MetaDataStore
    //   0	127	1	paramString	String
    //   5	35	2	localFile	File
    //   22	66	3	localObject1	Object
    //   24	11	4	localObject2	Object
    //   61	6	4	localObject3	Object
    //   75	1	4	str	String
    //   85	14	4	localException	Exception
    //   32	37	5	localObject4	Object
    //   80	1	5	localObject5	Object
    //   88	37	5	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   43	52	61	finally
    //   43	52	73	java/lang/Exception
    //   29	34	80	finally
    //   37	43	80	finally
    //   93	103	80	finally
    //   29	34	85	java/lang/Exception
    //   37	43	85	java/lang/Exception
  }
  
  /* Error */
  public void writeKeyData(String paramString, Map<String, String> paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 136	com/google/firebase/crashlytics/internal/common/MetaDataStore:getKeysFileForSession	(Ljava/lang/String;)Ljava/io/File;
    //   5: astore_3
    //   6: aconst_null
    //   7: astore 4
    //   9: aconst_null
    //   10: astore 5
    //   12: aload 5
    //   14: astore_1
    //   15: aload_2
    //   16: invokestatic 184	com/google/firebase/crashlytics/internal/common/MetaDataStore:keysDataToJson	(Ljava/util/Map;)Ljava/lang/String;
    //   19: astore 6
    //   21: aload 5
    //   23: astore_1
    //   24: new 186	java/io/BufferedWriter
    //   27: astore_2
    //   28: aload 5
    //   30: astore_1
    //   31: new 188	java/io/OutputStreamWriter
    //   34: astore 7
    //   36: aload 5
    //   38: astore_1
    //   39: new 190	java/io/FileOutputStream
    //   42: astore 8
    //   44: aload 5
    //   46: astore_1
    //   47: aload 8
    //   49: aload_3
    //   50: invokespecial 191	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   53: aload 5
    //   55: astore_1
    //   56: aload 7
    //   58: aload 8
    //   60: getstatic 35	com/google/firebase/crashlytics/internal/common/MetaDataStore:UTF_8	Ljava/nio/charset/Charset;
    //   63: invokespecial 194	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
    //   66: aload 5
    //   68: astore_1
    //   69: aload_2
    //   70: aload 7
    //   72: invokespecial 197	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   75: aload_2
    //   76: aload 6
    //   78: invokevirtual 202	java/io/Writer:write	(Ljava/lang/String;)V
    //   81: aload_2
    //   82: invokevirtual 205	java/io/Writer:flush	()V
    //   85: aload_2
    //   86: ldc -49
    //   88: invokestatic 163	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   91: goto +45 -> 136
    //   94: astore_1
    //   95: goto +42 -> 137
    //   98: astore 5
    //   100: goto +18 -> 118
    //   103: astore 5
    //   105: aload_1
    //   106: astore_2
    //   107: aload 5
    //   109: astore_1
    //   110: goto +27 -> 137
    //   113: astore 5
    //   115: aload 4
    //   117: astore_2
    //   118: aload_2
    //   119: astore_1
    //   120: invokestatic 169	com/google/firebase/crashlytics/internal/Logger:getLogger	()Lcom/google/firebase/crashlytics/internal/Logger;
    //   123: ldc -47
    //   125: aload 5
    //   127: invokevirtual 175	com/google/firebase/crashlytics/internal/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   130: aload_2
    //   131: ldc -49
    //   133: invokestatic 163	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   136: return
    //   137: aload_2
    //   138: ldc -49
    //   140: invokestatic 163	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   143: aload_1
    //   144: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	this	MetaDataStore
    //   0	145	1	paramString	String
    //   0	145	2	paramMap	Map<String, String>
    //   5	45	3	localFile	File
    //   7	109	4	localObject1	Object
    //   10	57	5	localObject2	Object
    //   98	1	5	localException1	Exception
    //   103	5	5	localObject3	Object
    //   113	13	5	localException2	Exception
    //   19	58	6	str	String
    //   34	37	7	localOutputStreamWriter	java.io.OutputStreamWriter
    //   42	17	8	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   75	85	94	finally
    //   75	85	98	java/lang/Exception
    //   15	21	103	finally
    //   24	28	103	finally
    //   31	36	103	finally
    //   39	44	103	finally
    //   47	53	103	finally
    //   56	66	103	finally
    //   69	75	103	finally
    //   120	130	103	finally
    //   15	21	113	java/lang/Exception
    //   24	28	113	java/lang/Exception
    //   31	36	113	java/lang/Exception
    //   39	44	113	java/lang/Exception
    //   47	53	113	java/lang/Exception
    //   56	66	113	java/lang/Exception
    //   69	75	113	java/lang/Exception
  }
  
  /* Error */
  public void writeUserData(String paramString, UserMetadata paramUserMetadata)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 178	com/google/firebase/crashlytics/internal/common/MetaDataStore:getUserDataFileForSession	(Ljava/lang/String;)Ljava/io/File;
    //   5: astore_3
    //   6: aconst_null
    //   7: astore 4
    //   9: aconst_null
    //   10: astore 5
    //   12: aload 5
    //   14: astore_1
    //   15: aload_2
    //   16: invokestatic 214	com/google/firebase/crashlytics/internal/common/MetaDataStore:userDataToJson	(Lcom/google/firebase/crashlytics/internal/common/UserMetadata;)Ljava/lang/String;
    //   19: astore 6
    //   21: aload 5
    //   23: astore_1
    //   24: new 186	java/io/BufferedWriter
    //   27: astore_2
    //   28: aload 5
    //   30: astore_1
    //   31: new 188	java/io/OutputStreamWriter
    //   34: astore 7
    //   36: aload 5
    //   38: astore_1
    //   39: new 190	java/io/FileOutputStream
    //   42: astore 8
    //   44: aload 5
    //   46: astore_1
    //   47: aload 8
    //   49: aload_3
    //   50: invokespecial 191	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   53: aload 5
    //   55: astore_1
    //   56: aload 7
    //   58: aload 8
    //   60: getstatic 35	com/google/firebase/crashlytics/internal/common/MetaDataStore:UTF_8	Ljava/nio/charset/Charset;
    //   63: invokespecial 194	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
    //   66: aload 5
    //   68: astore_1
    //   69: aload_2
    //   70: aload 7
    //   72: invokespecial 197	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   75: aload_2
    //   76: aload 6
    //   78: invokevirtual 202	java/io/Writer:write	(Ljava/lang/String;)V
    //   81: aload_2
    //   82: invokevirtual 205	java/io/Writer:flush	()V
    //   85: aload_2
    //   86: ldc -97
    //   88: invokestatic 163	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   91: goto +45 -> 136
    //   94: astore_1
    //   95: goto +42 -> 137
    //   98: astore 5
    //   100: goto +18 -> 118
    //   103: astore 5
    //   105: aload_1
    //   106: astore_2
    //   107: aload 5
    //   109: astore_1
    //   110: goto +27 -> 137
    //   113: astore 5
    //   115: aload 4
    //   117: astore_2
    //   118: aload_2
    //   119: astore_1
    //   120: invokestatic 169	com/google/firebase/crashlytics/internal/Logger:getLogger	()Lcom/google/firebase/crashlytics/internal/Logger;
    //   123: ldc -40
    //   125: aload 5
    //   127: invokevirtual 175	com/google/firebase/crashlytics/internal/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   130: aload_2
    //   131: ldc -97
    //   133: invokestatic 163	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   136: return
    //   137: aload_2
    //   138: ldc -97
    //   140: invokestatic 163	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   143: aload_1
    //   144: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	this	MetaDataStore
    //   0	145	1	paramString	String
    //   0	145	2	paramUserMetadata	UserMetadata
    //   5	45	3	localFile	File
    //   7	109	4	localObject1	Object
    //   10	57	5	localObject2	Object
    //   98	1	5	localException1	Exception
    //   103	5	5	localObject3	Object
    //   113	13	5	localException2	Exception
    //   19	58	6	str	String
    //   34	37	7	localOutputStreamWriter	java.io.OutputStreamWriter
    //   42	17	8	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   75	85	94	finally
    //   75	85	98	java/lang/Exception
    //   15	21	103	finally
    //   24	28	103	finally
    //   31	36	103	finally
    //   39	44	103	finally
    //   47	53	103	finally
    //   56	66	103	finally
    //   69	75	103	finally
    //   120	130	103	finally
    //   15	21	113	java/lang/Exception
    //   24	28	113	java/lang/Exception
    //   31	36	113	java/lang/Exception
    //   39	44	113	java/lang/Exception
    //   47	53	113	java/lang/Exception
    //   56	66	113	java/lang/Exception
    //   69	75	113	java/lang/Exception
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\common\MetaDataStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */