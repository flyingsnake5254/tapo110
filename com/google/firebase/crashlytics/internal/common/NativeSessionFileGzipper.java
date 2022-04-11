package com.google.firebase.crashlytics.internal.common;

class NativeSessionFileGzipper
{
  /* Error */
  private static void gzipInputStream(@androidx.annotation.Nullable java.io.InputStream paramInputStream, @androidx.annotation.NonNull java.io.File paramFile)
    throws java.io.IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: sipush 8192
    //   8: newarray <illegal type>
    //   10: astore_2
    //   11: aconst_null
    //   12: astore_3
    //   13: new 17	java/util/zip/GZIPOutputStream
    //   16: astore 4
    //   18: new 19	java/io/FileOutputStream
    //   21: astore 5
    //   23: aload 5
    //   25: aload_1
    //   26: invokespecial 22	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   29: aload 4
    //   31: aload 5
    //   33: invokespecial 25	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   36: aload_0
    //   37: aload_2
    //   38: invokevirtual 31	java/io/InputStream:read	([B)I
    //   41: istore 6
    //   43: iload 6
    //   45: ifle +15 -> 60
    //   48: aload 4
    //   50: aload_2
    //   51: iconst_0
    //   52: iload 6
    //   54: invokevirtual 35	java/util/zip/GZIPOutputStream:write	([BII)V
    //   57: goto -21 -> 36
    //   60: aload 4
    //   62: invokevirtual 38	java/util/zip/GZIPOutputStream:finish	()V
    //   65: aload 4
    //   67: invokestatic 44	com/google/firebase/crashlytics/internal/common/CommonUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   70: return
    //   71: astore_0
    //   72: aload 4
    //   74: astore_1
    //   75: goto +6 -> 81
    //   78: astore_0
    //   79: aload_3
    //   80: astore_1
    //   81: aload_1
    //   82: invokestatic 44	com/google/firebase/crashlytics/internal/common/CommonUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   85: aload_0
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	paramInputStream	java.io.InputStream
    //   0	87	1	paramFile	java.io.File
    //   10	41	2	arrayOfByte	byte[]
    //   12	68	3	localObject	Object
    //   16	57	4	localGZIPOutputStream	java.util.zip.GZIPOutputStream
    //   21	11	5	localFileOutputStream	java.io.FileOutputStream
    //   41	12	6	i	int
    // Exception table:
    //   from	to	target	type
    //   36	43	71	finally
    //   48	57	71	finally
    //   60	65	71	finally
    //   13	36	78	finally
  }
  
  /* Error */
  static void processNativeSessions(java.io.File paramFile, java.util.List<NativeSessionFile> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface 54 1 0
    //   6: astore_2
    //   7: aload_2
    //   8: invokeinterface 60 1 0
    //   13: ifeq +100 -> 113
    //   16: aload_2
    //   17: invokeinterface 64 1 0
    //   22: checkcast 66	com/google/firebase/crashlytics/internal/common/NativeSessionFile
    //   25: astore_3
    //   26: aconst_null
    //   27: astore_1
    //   28: aconst_null
    //   29: astore 4
    //   31: aload_3
    //   32: invokeinterface 70 1 0
    //   37: astore 5
    //   39: aload 5
    //   41: ifnonnull +13 -> 54
    //   44: aload 5
    //   46: astore_1
    //   47: aload_1
    //   48: invokestatic 44	com/google/firebase/crashlytics/internal/common/CommonUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   51: goto -44 -> 7
    //   54: aload 5
    //   56: astore 4
    //   58: aload 5
    //   60: astore_1
    //   61: new 72	java/io/File
    //   64: astore 6
    //   66: aload 5
    //   68: astore 4
    //   70: aload 5
    //   72: astore_1
    //   73: aload 6
    //   75: aload_0
    //   76: aload_3
    //   77: invokeinterface 76 1 0
    //   82: invokespecial 79	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   85: aload 5
    //   87: astore 4
    //   89: aload 5
    //   91: astore_1
    //   92: aload 5
    //   94: aload 6
    //   96: invokestatic 81	com/google/firebase/crashlytics/internal/common/NativeSessionFileGzipper:gzipInputStream	(Ljava/io/InputStream;Ljava/io/File;)V
    //   99: aload 5
    //   101: astore_1
    //   102: goto -55 -> 47
    //   105: astore_0
    //   106: aload 4
    //   108: invokestatic 44	com/google/firebase/crashlytics/internal/common/CommonUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   111: aload_0
    //   112: athrow
    //   113: return
    //   114: astore 5
    //   116: goto -69 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	paramFile	java.io.File
    //   0	119	1	paramList	java.util.List<NativeSessionFile>
    //   6	11	2	localIterator	java.util.Iterator
    //   25	52	3	localNativeSessionFile	NativeSessionFile
    //   29	78	4	localObject	Object
    //   37	63	5	localInputStream	java.io.InputStream
    //   114	1	5	localIOException	java.io.IOException
    //   64	31	6	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   31	39	105	finally
    //   61	66	105	finally
    //   73	85	105	finally
    //   92	99	105	finally
    //   31	39	114	java/io/IOException
    //   61	66	114	java/io/IOException
    //   73	85	114	java/io/IOException
    //   92	99	114	java/io/IOException
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\common\NativeSessionFileGzipper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */