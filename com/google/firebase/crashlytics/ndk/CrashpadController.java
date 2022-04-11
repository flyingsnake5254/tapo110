package com.google.firebase.crashlytics.ndk;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.Logger;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

class CrashpadController
  implements NativeComponentController
{
  private static final String APP_METADATA_FILE = "app.json";
  private static final String DEVICE_METADATA_FILE = "device.json";
  private static final String OS_METADATA_FILE = "os.json";
  private static final String SESSION_METADATA_FILE = "session.json";
  private static final Charset UTF_8 = Charset.forName("UTF-8");
  private final Context context;
  private final CrashFilesManager filesManager;
  private final NativeApi nativeApi;
  
  CrashpadController(Context paramContext, NativeApi paramNativeApi, CrashFilesManager paramCrashFilesManager)
  {
    this.context = paramContext;
    this.nativeApi = paramNativeApi;
    this.filesManager = paramCrashFilesManager;
  }
  
  @Nullable
  private static File getSingleFileWithExtension(File paramFile, String paramString)
  {
    paramFile = paramFile.listFiles();
    if (paramFile == null) {
      return null;
    }
    int i = paramFile.length;
    for (int j = 0; j < i; j++)
    {
      File localFile = paramFile[j];
      if (localFile.getName().endsWith(paramString)) {
        return localFile;
      }
    }
    return null;
  }
  
  private void writeSessionJsonFile(String paramString1, String paramString2, String paramString3)
  {
    writeTextFile(new File(this.filesManager.getSessionFileDirectory(paramString1), paramString3), paramString2);
  }
  
  /* Error */
  private static void writeTextFile(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: new 88	java/io/BufferedWriter
    //   7: astore 4
    //   9: new 90	java/io/OutputStreamWriter
    //   12: astore 5
    //   14: new 92	java/io/FileOutputStream
    //   17: astore 6
    //   19: aload 6
    //   21: aload_0
    //   22: invokespecial 95	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   25: aload 5
    //   27: aload 6
    //   29: getstatic 39	com/google/firebase/crashlytics/ndk/CrashpadController:UTF_8	Ljava/nio/charset/Charset;
    //   32: invokespecial 98	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
    //   35: aload 4
    //   37: aload 5
    //   39: invokespecial 101	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   42: aload 4
    //   44: aload_1
    //   45: invokevirtual 105	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   48: new 107	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   55: astore_1
    //   56: aload_1
    //   57: ldc 110
    //   59: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload_1
    //   64: aload_0
    //   65: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload 4
    //   71: aload_1
    //   72: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 126	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   78: goto +89 -> 167
    //   81: astore_3
    //   82: aload 4
    //   84: astore_1
    //   85: aload_3
    //   86: astore 4
    //   88: goto +14 -> 102
    //   91: astore_1
    //   92: aload 4
    //   94: astore_1
    //   95: goto +39 -> 134
    //   98: astore 4
    //   100: aload_3
    //   101: astore_1
    //   102: new 107	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   109: astore_3
    //   110: aload_3
    //   111: ldc 110
    //   113: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload_3
    //   118: aload_0
    //   119: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload_1
    //   124: aload_3
    //   125: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 126	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   131: aload 4
    //   133: athrow
    //   134: new 107	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   141: astore 4
    //   143: aload 4
    //   145: ldc 110
    //   147: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload 4
    //   153: aload_0
    //   154: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload_1
    //   159: aload 4
    //   161: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokestatic 126	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   167: return
    //   168: astore_1
    //   169: aload_2
    //   170: astore_1
    //   171: goto -37 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	paramFile	File
    //   0	174	1	paramString	String
    //   1	169	2	localObject1	Object
    //   3	1	3	localObject2	Object
    //   81	20	3	localObject3	Object
    //   109	16	3	localStringBuilder1	StringBuilder
    //   7	86	4	localObject4	Object
    //   98	34	4	localObject5	Object
    //   141	19	4	localStringBuilder2	StringBuilder
    //   12	26	5	localOutputStreamWriter	java.io.OutputStreamWriter
    //   17	11	6	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   42	48	81	finally
    //   42	48	91	java/io/IOException
    //   4	42	98	finally
    //   4	42	168	java/io/IOException
  }
  
  public boolean finalizeSession(String paramString)
  {
    this.filesManager.deleteSessionFileDirectory(paramString);
    this.filesManager.cleanOldSessionFileDirectories();
    return true;
  }
  
  @NonNull
  public SessionFiles getFilesForSession(String paramString)
  {
    File localFile1 = this.filesManager.getSessionFileDirectory(paramString);
    File localFile2 = new File(localFile1, "pending");
    Logger localLogger = Logger.getLogger();
    paramString = new StringBuilder();
    paramString.append("Minidump directory: ");
    paramString.append(localFile2.getAbsolutePath());
    localLogger.v(paramString.toString());
    paramString = getSingleFileWithExtension(localFile2, ".dmp");
    localLogger = Logger.getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Minidump file ");
    if ((paramString != null) && (paramString.exists())) {
      paramString = "exists";
    } else {
      paramString = "does not exist";
    }
    localStringBuilder.append(paramString);
    localLogger.v(localStringBuilder.toString());
    paramString = new SessionFiles.Builder();
    if ((localFile1 != null) && (localFile1.exists()) && (localFile2.exists())) {
      paramString.minidumpFile(getSingleFileWithExtension(localFile2, ".dmp")).metadataFile(getSingleFileWithExtension(localFile1, ".device_info")).sessionFile(new File(localFile1, "session.json")).appFile(new File(localFile1, "app.json")).deviceFile(new File(localFile1, "device.json")).osFile(new File(localFile1, "os.json"));
    }
    return paramString.build();
  }
  
  public boolean hasCrashDataForSession(String paramString)
  {
    boolean bool1 = this.filesManager.hasSessionFileDirectory(paramString);
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      paramString = getFilesForSession(paramString).minidump;
      bool3 = bool2;
      if (paramString != null)
      {
        bool3 = bool2;
        if (paramString.exists()) {
          bool3 = true;
        }
      }
    }
    return bool3;
  }
  
  public boolean initialize(String paramString)
  {
    this.filesManager.cleanOldSessionFileDirectories();
    paramString = this.filesManager.getSessionFileDirectory(paramString);
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramString != null) {
      try
      {
        paramString = paramString.getCanonicalPath();
        bool2 = this.nativeApi.initialize(paramString, this.context.getAssets());
      }
      catch (IOException paramString)
      {
        Logger.getLogger().e("Error initializing Crashlytics NDK", paramString);
        bool2 = bool1;
      }
    }
    return bool2;
  }
  
  public void writeBeginSession(String paramString1, String paramString2, long paramLong)
  {
    writeSessionJsonFile(paramString1, SessionMetadataJsonSerializer.serializeBeginSession(paramString1, paramString2, paramLong), "session.json");
  }
  
  public void writeSessionApp(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6)
  {
    if (TextUtils.isEmpty(paramString6)) {
      paramString6 = "";
    }
    writeSessionJsonFile(paramString1, SessionMetadataJsonSerializer.serializeSessionApp(paramString2, paramString3, paramString4, paramString5, paramInt, paramString6), "app.json");
  }
  
  public void writeSessionDevice(String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, int paramInt3, String paramString3, String paramString4)
  {
    writeSessionJsonFile(paramString1, SessionMetadataJsonSerializer.serializeSessionDevice(paramInt1, paramString2, paramInt2, paramLong1, paramLong2, paramBoolean, paramInt3, paramString3, paramString4), "device.json");
  }
  
  public void writeSessionOs(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    writeSessionJsonFile(paramString1, SessionMetadataJsonSerializer.serializeSessionOs(paramString2, paramString3, paramBoolean), "os.json");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\ndk\CrashpadController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */