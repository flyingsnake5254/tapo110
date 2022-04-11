package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File.Builder;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

class BytesBackedNativeSessionFile
  implements NativeSessionFile
{
  @Nullable
  private final byte[] bytes;
  @NonNull
  private final String dataTransportFilename;
  @NonNull
  private final String reportsEndpointFilename;
  
  BytesBackedNativeSessionFile(@NonNull String paramString1, @NonNull String paramString2, @Nullable byte[] paramArrayOfByte)
  {
    this.dataTransportFilename = paramString1;
    this.reportsEndpointFilename = paramString2;
    this.bytes = paramArrayOfByte;
  }
  
  /* Error */
  @Nullable
  private byte[] asGzippedBytes()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 34	com/google/firebase/crashlytics/internal/common/BytesBackedNativeSessionFile:isEmpty	()Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 36	java/io/ByteArrayOutputStream
    //   12: astore_1
    //   13: aload_1
    //   14: invokespecial 37	java/io/ByteArrayOutputStream:<init>	()V
    //   17: new 39	java/util/zip/GZIPOutputStream
    //   20: astore_2
    //   21: aload_2
    //   22: aload_1
    //   23: invokespecial 42	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   26: aload_2
    //   27: aload_0
    //   28: getfield 24	com/google/firebase/crashlytics/internal/common/BytesBackedNativeSessionFile:bytes	[B
    //   31: invokevirtual 46	java/util/zip/GZIPOutputStream:write	([B)V
    //   34: aload_2
    //   35: invokevirtual 49	java/util/zip/GZIPOutputStream:finish	()V
    //   38: aload_1
    //   39: invokevirtual 52	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   42: astore_3
    //   43: aload_2
    //   44: invokevirtual 55	java/util/zip/GZIPOutputStream:close	()V
    //   47: aload_1
    //   48: invokevirtual 56	java/io/ByteArrayOutputStream:close	()V
    //   51: aload_3
    //   52: areturn
    //   53: astore_3
    //   54: aload_2
    //   55: invokevirtual 55	java/util/zip/GZIPOutputStream:close	()V
    //   58: goto +9 -> 67
    //   61: astore_2
    //   62: aload_3
    //   63: aload_2
    //   64: invokevirtual 62	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   67: aload_3
    //   68: athrow
    //   69: astore_3
    //   70: aload_1
    //   71: invokevirtual 56	java/io/ByteArrayOutputStream:close	()V
    //   74: goto +9 -> 83
    //   77: astore_1
    //   78: aload_3
    //   79: aload_1
    //   80: invokevirtual 62	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   83: aload_3
    //   84: athrow
    //   85: astore_1
    //   86: aconst_null
    //   87: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	BytesBackedNativeSessionFile
    //   12	59	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   77	3	1	localThrowable1	Throwable
    //   85	1	1	localIOException	java.io.IOException
    //   20	35	2	localGZIPOutputStream	java.util.zip.GZIPOutputStream
    //   61	3	2	localThrowable2	Throwable
    //   42	10	3	arrayOfByte	byte[]
    //   53	15	3	localObject1	Object
    //   69	15	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   26	43	53	finally
    //   54	58	61	finally
    //   17	26	69	finally
    //   43	47	69	finally
    //   62	67	69	finally
    //   67	69	69	finally
    //   70	74	77	finally
    //   9	17	85	java/io/IOException
    //   47	51	85	java/io/IOException
    //   78	83	85	java/io/IOException
    //   83	85	85	java/io/IOException
  }
  
  private boolean isEmpty()
  {
    byte[] arrayOfByte = this.bytes;
    boolean bool;
    if ((arrayOfByte != null) && (arrayOfByte.length != 0)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  @Nullable
  public CrashlyticsReport.FilesPayload.File asFilePayload()
  {
    Object localObject = asGzippedBytes();
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = CrashlyticsReport.FilesPayload.File.builder().setContents((byte[])localObject).setFilename(this.dataTransportFilename).build();
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
    ByteArrayInputStream localByteArrayInputStream;
    if (isEmpty()) {
      localByteArrayInputStream = null;
    } else {
      localByteArrayInputStream = new ByteArrayInputStream(this.bytes);
    }
    return localByteArrayInputStream;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\common\BytesBackedNativeSessionFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */