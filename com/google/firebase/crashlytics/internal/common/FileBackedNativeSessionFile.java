package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File.Builder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

class FileBackedNativeSessionFile
  implements NativeSessionFile
{
  @NonNull
  private final String dataTransportFilename;
  @NonNull
  private final File file;
  @NonNull
  private final String reportsEndpointFilename;
  
  FileBackedNativeSessionFile(@NonNull String paramString1, @NonNull String paramString2, @NonNull File paramFile)
  {
    this.dataTransportFilename = paramString1;
    this.reportsEndpointFilename = paramString2;
    this.file = paramFile;
  }
  
  /* Error */
  @Nullable
  private byte[] asGzippedBytes()
  {
    // Byte code:
    //   0: sipush 8192
    //   3: newarray <illegal type>
    //   5: astore_1
    //   6: aload_0
    //   7: invokevirtual 34	com/google/firebase/crashlytics/internal/common/FileBackedNativeSessionFile:getStream	()Ljava/io/InputStream;
    //   10: astore_2
    //   11: new 36	java/io/ByteArrayOutputStream
    //   14: astore_3
    //   15: aload_3
    //   16: invokespecial 37	java/io/ByteArrayOutputStream:<init>	()V
    //   19: new 39	java/util/zip/GZIPOutputStream
    //   22: astore 4
    //   24: aload 4
    //   26: aload_3
    //   27: invokespecial 42	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   30: aload_2
    //   31: ifnonnull +22 -> 53
    //   34: aload 4
    //   36: invokevirtual 45	java/util/zip/GZIPOutputStream:close	()V
    //   39: aload_3
    //   40: invokevirtual 46	java/io/ByteArrayOutputStream:close	()V
    //   43: aload_2
    //   44: ifnull +7 -> 51
    //   47: aload_2
    //   48: invokevirtual 49	java/io/InputStream:close	()V
    //   51: aconst_null
    //   52: areturn
    //   53: aload_2
    //   54: aload_1
    //   55: invokevirtual 53	java/io/InputStream:read	([B)I
    //   58: istore 5
    //   60: iload 5
    //   62: ifle +15 -> 77
    //   65: aload 4
    //   67: aload_1
    //   68: iconst_0
    //   69: iload 5
    //   71: invokevirtual 57	java/util/zip/GZIPOutputStream:write	([BII)V
    //   74: goto -21 -> 53
    //   77: aload 4
    //   79: invokevirtual 60	java/util/zip/GZIPOutputStream:finish	()V
    //   82: aload_3
    //   83: invokevirtual 63	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   86: astore_1
    //   87: aload 4
    //   89: invokevirtual 45	java/util/zip/GZIPOutputStream:close	()V
    //   92: aload_3
    //   93: invokevirtual 46	java/io/ByteArrayOutputStream:close	()V
    //   96: aload_2
    //   97: invokevirtual 49	java/io/InputStream:close	()V
    //   100: aload_1
    //   101: areturn
    //   102: astore_1
    //   103: aload 4
    //   105: invokevirtual 45	java/util/zip/GZIPOutputStream:close	()V
    //   108: goto +11 -> 119
    //   111: astore 4
    //   113: aload_1
    //   114: aload 4
    //   116: invokevirtual 69	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   119: aload_1
    //   120: athrow
    //   121: astore 4
    //   123: aload_3
    //   124: invokevirtual 46	java/io/ByteArrayOutputStream:close	()V
    //   127: goto +10 -> 137
    //   130: astore_3
    //   131: aload 4
    //   133: aload_3
    //   134: invokevirtual 69	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   137: aload 4
    //   139: athrow
    //   140: astore_3
    //   141: aload_2
    //   142: ifnull +16 -> 158
    //   145: aload_2
    //   146: invokevirtual 49	java/io/InputStream:close	()V
    //   149: goto +9 -> 158
    //   152: astore_2
    //   153: aload_3
    //   154: aload_2
    //   155: invokevirtual 69	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   158: aload_3
    //   159: athrow
    //   160: astore_2
    //   161: aconst_null
    //   162: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	FileBackedNativeSessionFile
    //   5	96	1	arrayOfByte	byte[]
    //   102	18	1	localObject1	Object
    //   10	136	2	localInputStream	InputStream
    //   152	3	2	localThrowable1	Throwable
    //   160	1	2	localIOException	java.io.IOException
    //   14	110	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   130	4	3	localThrowable2	Throwable
    //   140	19	3	localObject2	Object
    //   22	82	4	localGZIPOutputStream	java.util.zip.GZIPOutputStream
    //   111	4	4	localThrowable3	Throwable
    //   121	17	4	localObject3	Object
    //   58	12	5	i	int
    // Exception table:
    //   from	to	target	type
    //   53	60	102	finally
    //   65	74	102	finally
    //   77	87	102	finally
    //   103	108	111	finally
    //   19	30	121	finally
    //   34	39	121	finally
    //   87	92	121	finally
    //   113	119	121	finally
    //   119	121	121	finally
    //   123	127	130	finally
    //   11	19	140	finally
    //   39	43	140	finally
    //   92	96	140	finally
    //   131	137	140	finally
    //   137	140	140	finally
    //   145	149	152	finally
    //   6	11	160	java/io/IOException
    //   47	51	160	java/io/IOException
    //   96	100	160	java/io/IOException
    //   153	158	160	java/io/IOException
    //   158	160	160	java/io/IOException
  }
  
  @Nullable
  public CrashlyticsReport.FilesPayload.File asFilePayload()
  {
    Object localObject = asGzippedBytes();
    if (localObject != null) {
      localObject = CrashlyticsReport.FilesPayload.File.builder().setContents((byte[])localObject).setFilename(this.dataTransportFilename).build();
    } else {
      localObject = null;
    }
    return (CrashlyticsReport.FilesPayload.File)localObject;
  }
  
  @NonNull
  public String getReportsEndpointFilename()
  {
    return this.reportsEndpointFilename;
  }
  
  @Nullable
  public InputStream getStream()
  {
    if ((this.file.exists()) && (this.file.isFile())) {}
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(this.file);
      return localFileInputStream;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;) {}
    }
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\common\FileBackedNativeSessionFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */