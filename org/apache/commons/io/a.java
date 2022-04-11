package org.apache.commons.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.util.Objects;

public class a
{
  public static final BigInteger a;
  public static final BigInteger b;
  public static final BigInteger c;
  public static final BigInteger d;
  public static final BigInteger e;
  public static final BigInteger f;
  public static final BigInteger g;
  public static final BigInteger h;
  public static final File[] i = new File[0];
  
  static
  {
    BigInteger localBigInteger1 = BigInteger.valueOf(1024L);
    a = localBigInteger1;
    BigInteger localBigInteger2 = localBigInteger1.multiply(localBigInteger1);
    b = localBigInteger2;
    localBigInteger2 = localBigInteger1.multiply(localBigInteger2);
    c = localBigInteger2;
    localBigInteger2 = localBigInteger1.multiply(localBigInteger2);
    d = localBigInteger2;
    localBigInteger2 = localBigInteger1.multiply(localBigInteger2);
    e = localBigInteger2;
    f = localBigInteger1.multiply(localBigInteger2);
    localBigInteger2 = BigInteger.valueOf(1024L).multiply(BigInteger.valueOf(1152921504606846976L));
    g = localBigInteger2;
    h = localBigInteger1.multiply(localBigInteger2);
  }
  
  private static void a(File paramFile)
  {
    if (paramFile.exists())
    {
      if (paramFile.isDirectory()) {
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramFile);
      localStringBuilder.append(" is not a directory");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramFile);
    localStringBuilder.append(" does not exist");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private static void b(File paramFile1, File paramFile2)
    throws FileNotFoundException
  {
    Objects.requireNonNull(paramFile1, "Source must not be null");
    Objects.requireNonNull(paramFile2, "Destination must not be null");
    if (paramFile1.exists()) {
      return;
    }
    paramFile2 = new StringBuilder();
    paramFile2.append("Source '");
    paramFile2.append(paramFile1);
    paramFile2.append("' does not exist");
    throw new FileNotFoundException(paramFile2.toString());
  }
  
  public static void c(File paramFile)
    throws IOException
  {
    File[] arrayOfFile = p(paramFile);
    int j = arrayOfFile.length;
    paramFile = null;
    for (int k = 0; k < j; k++)
    {
      File localFile = arrayOfFile[k];
      try
      {
        i(localFile);
      }
      catch (IOException paramFile) {}
    }
    if (paramFile == null) {
      return;
    }
    throw paramFile;
  }
  
  public static void d(File paramFile1, File paramFile2)
    throws IOException
  {
    e(paramFile1, paramFile2, true);
  }
  
  public static void e(File paramFile1, File paramFile2, boolean paramBoolean)
    throws IOException
  {
    b(paramFile1, paramFile2);
    if (!paramFile1.isDirectory())
    {
      if (!paramFile1.getCanonicalPath().equals(paramFile2.getCanonicalPath()))
      {
        localObject = paramFile2.getParentFile();
        if ((localObject != null) && (!((File)localObject).mkdirs()) && (!((File)localObject).isDirectory()))
        {
          paramFile1 = new StringBuilder();
          paramFile1.append("Destination '");
          paramFile1.append(localObject);
          paramFile1.append("' directory cannot be created");
          throw new IOException(paramFile1.toString());
        }
        if ((paramFile2.exists()) && (!paramFile2.canWrite()))
        {
          paramFile1 = new StringBuilder();
          paramFile1.append("Destination '");
          paramFile1.append(paramFile2);
          paramFile1.append("' exists but is read-only");
          throw new IOException(paramFile1.toString());
        }
        h(paramFile1, paramFile2, paramBoolean);
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Source '");
      ((StringBuilder)localObject).append(paramFile1);
      ((StringBuilder)localObject).append("' and destination '");
      ((StringBuilder)localObject).append(paramFile2);
      ((StringBuilder)localObject).append("' are the same");
      throw new IOException(((StringBuilder)localObject).toString());
    }
    paramFile2 = new StringBuilder();
    paramFile2.append("Source '");
    paramFile2.append(paramFile1);
    paramFile2.append("' exists but is a directory");
    throw new IOException(paramFile2.toString());
  }
  
  public static void f(File paramFile)
    throws IOException
  {
    if (!paramFile.exists()) {
      return;
    }
    if (!k(paramFile)) {
      c(paramFile);
    }
    if (paramFile.delete()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unable to delete directory ");
    localStringBuilder.append(paramFile);
    localStringBuilder.append(".");
    throw new IOException(localStringBuilder.toString());
  }
  
  public static boolean g(File paramFile)
  {
    if (paramFile == null) {
      return false;
    }
    try
    {
      if (paramFile.isDirectory()) {
        c(paramFile);
      }
      try
      {
        boolean bool = paramFile.delete();
        return bool;
      }
      catch (Exception paramFile)
      {
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  /* Error */
  private static void h(File paramFile1, File paramFile2, boolean paramBoolean)
    throws IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 57	java/io/File:exists	()Z
    //   4: ifeq +53 -> 57
    //   7: aload_1
    //   8: invokevirtual 60	java/io/File:isDirectory	()Z
    //   11: ifne +6 -> 17
    //   14: goto +43 -> 57
    //   17: new 62	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   24: astore_0
    //   25: aload_0
    //   26: ldc -121
    //   28: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload_0
    //   33: aload_1
    //   34: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload_0
    //   39: ldc -105
    //   41: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: new 106	java/io/IOException
    //   48: dup
    //   49: aload_0
    //   50: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokespecial 138	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   56: athrow
    //   57: new 168	java/io/FileInputStream
    //   60: dup
    //   61: aload_0
    //   62: invokespecial 170	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   65: astore_3
    //   66: aload_3
    //   67: invokevirtual 174	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   70: astore 4
    //   72: new 176	java/io/FileOutputStream
    //   75: astore 5
    //   77: aload 5
    //   79: aload_1
    //   80: invokespecial 177	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   83: aload 5
    //   85: invokevirtual 178	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   88: astore 6
    //   90: aload 4
    //   92: invokevirtual 184	java/nio/channels/FileChannel:size	()J
    //   95: lstore 7
    //   97: lconst_0
    //   98: lstore 9
    //   100: lload 9
    //   102: lload 7
    //   104: lcmp
    //   105: ifge +60 -> 165
    //   108: lload 7
    //   110: lload 9
    //   112: lsub
    //   113: lstore 11
    //   115: lload 11
    //   117: ldc2_w 185
    //   120: lcmp
    //   121: ifle +11 -> 132
    //   124: ldc2_w 185
    //   127: lstore 11
    //   129: goto +3 -> 132
    //   132: aload 6
    //   134: aload 4
    //   136: lload 9
    //   138: lload 11
    //   140: invokevirtual 190	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   143: lstore 11
    //   145: lload 11
    //   147: lconst_0
    //   148: lcmp
    //   149: ifne +6 -> 155
    //   152: goto +13 -> 165
    //   155: lload 9
    //   157: lload 11
    //   159: ladd
    //   160: lstore 9
    //   162: goto -62 -> 100
    //   165: aload 6
    //   167: ifnull +8 -> 175
    //   170: aload 6
    //   172: invokevirtual 193	java/nio/channels/FileChannel:close	()V
    //   175: aload 5
    //   177: invokevirtual 194	java/io/FileOutputStream:close	()V
    //   180: aload 4
    //   182: invokevirtual 193	java/nio/channels/FileChannel:close	()V
    //   185: aload_3
    //   186: invokevirtual 195	java/io/FileInputStream:close	()V
    //   189: aload_0
    //   190: invokevirtual 198	java/io/File:length	()J
    //   193: lstore 9
    //   195: aload_1
    //   196: invokevirtual 198	java/io/File:length	()J
    //   199: lstore 11
    //   201: lload 9
    //   203: lload 11
    //   205: lcmp
    //   206: ifne +17 -> 223
    //   209: iload_2
    //   210: ifeq +12 -> 222
    //   213: aload_1
    //   214: aload_0
    //   215: invokevirtual 201	java/io/File:lastModified	()J
    //   218: invokevirtual 205	java/io/File:setLastModified	(J)Z
    //   221: pop
    //   222: return
    //   223: new 62	java/lang/StringBuilder
    //   226: dup
    //   227: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   230: astore_3
    //   231: aload_3
    //   232: ldc -49
    //   234: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: aload_3
    //   239: aload_0
    //   240: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: aload_3
    //   245: ldc -47
    //   247: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: aload_3
    //   252: aload_1
    //   253: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload_3
    //   258: ldc -45
    //   260: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: aload_3
    //   265: lload 9
    //   267: invokevirtual 214	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload_3
    //   272: ldc -40
    //   274: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: aload_3
    //   279: lload 11
    //   281: invokevirtual 214	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: new 106	java/io/IOException
    //   288: dup
    //   289: aload_3
    //   290: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: invokespecial 138	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   296: athrow
    //   297: astore_1
    //   298: aload_1
    //   299: athrow
    //   300: astore_0
    //   301: aload 6
    //   303: ifnull +19 -> 322
    //   306: aload 6
    //   308: invokevirtual 193	java/nio/channels/FileChannel:close	()V
    //   311: goto +11 -> 322
    //   314: astore 6
    //   316: aload_1
    //   317: aload 6
    //   319: invokevirtual 222	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   322: aload_0
    //   323: athrow
    //   324: astore_0
    //   325: aload_0
    //   326: athrow
    //   327: astore_1
    //   328: aload 5
    //   330: invokevirtual 194	java/io/FileOutputStream:close	()V
    //   333: goto +11 -> 344
    //   336: astore 5
    //   338: aload_0
    //   339: aload 5
    //   341: invokevirtual 222	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   344: aload_1
    //   345: athrow
    //   346: astore_1
    //   347: aload_1
    //   348: athrow
    //   349: astore_0
    //   350: aload 4
    //   352: ifnull +19 -> 371
    //   355: aload 4
    //   357: invokevirtual 193	java/nio/channels/FileChannel:close	()V
    //   360: goto +11 -> 371
    //   363: astore 4
    //   365: aload_1
    //   366: aload 4
    //   368: invokevirtual 222	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   371: aload_0
    //   372: athrow
    //   373: astore_0
    //   374: aload_0
    //   375: athrow
    //   376: astore_1
    //   377: aload_3
    //   378: invokevirtual 195	java/io/FileInputStream:close	()V
    //   381: goto +9 -> 390
    //   384: astore_3
    //   385: aload_0
    //   386: aload_3
    //   387: invokevirtual 222	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   390: aload_1
    //   391: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	392	0	paramFile1	File
    //   0	392	1	paramFile2	File
    //   0	392	2	paramBoolean	boolean
    //   65	313	3	localObject	Object
    //   384	3	3	localThrowable1	Throwable
    //   70	286	4	localFileChannel1	java.nio.channels.FileChannel
    //   363	4	4	localThrowable2	Throwable
    //   75	254	5	localFileOutputStream	java.io.FileOutputStream
    //   336	4	5	localThrowable3	Throwable
    //   88	219	6	localFileChannel2	java.nio.channels.FileChannel
    //   314	4	6	localThrowable4	Throwable
    //   95	14	7	l1	long
    //   98	168	9	l2	long
    //   113	167	11	l3	long
    // Exception table:
    //   from	to	target	type
    //   90	97	297	finally
    //   132	145	297	finally
    //   298	300	300	finally
    //   306	311	314	finally
    //   83	90	324	finally
    //   170	175	324	finally
    //   316	322	324	finally
    //   322	324	324	finally
    //   325	327	327	finally
    //   328	333	336	finally
    //   72	83	346	finally
    //   175	180	346	finally
    //   338	344	346	finally
    //   344	346	346	finally
    //   347	349	349	finally
    //   355	360	363	finally
    //   66	72	373	finally
    //   180	185	373	finally
    //   365	371	373	finally
    //   371	373	373	finally
    //   374	376	376	finally
    //   377	381	384	finally
  }
  
  public static void i(File paramFile)
    throws IOException
  {
    if (paramFile.isDirectory())
    {
      f(paramFile);
    }
    else
    {
      boolean bool = paramFile.exists();
      if (!paramFile.delete())
      {
        if (!bool)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("File does not exist: ");
          localStringBuilder.append(paramFile);
          throw new FileNotFoundException(localStringBuilder.toString());
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unable to delete file: ");
        localStringBuilder.append(paramFile);
        throw new IOException(localStringBuilder.toString());
      }
    }
  }
  
  public static boolean j(File paramFile, long paramLong)
  {
    if (paramFile != null)
    {
      boolean bool1 = paramFile.exists();
      boolean bool2 = false;
      if (!bool1) {
        return false;
      }
      if (paramFile.lastModified() > paramLong) {
        bool2 = true;
      }
      return bool2;
    }
    throw new IllegalArgumentException("No specified file");
  }
  
  public static boolean k(File paramFile)
    throws IOException
  {
    Objects.requireNonNull(paramFile, "File must not be null");
    return Files.isSymbolicLink(paramFile.toPath());
  }
  
  public static void l(File paramFile1, File paramFile2)
    throws IOException
  {
    Objects.requireNonNull(paramFile1, "Source must not be null");
    Objects.requireNonNull(paramFile2, "Destination must not be null");
    if (paramFile1.exists())
    {
      if (!paramFile1.isDirectory())
      {
        if (!paramFile2.exists())
        {
          if (!paramFile2.isDirectory())
          {
            if (!paramFile1.renameTo(paramFile2))
            {
              d(paramFile1, paramFile2);
              if (!paramFile1.delete())
              {
                g(paramFile2);
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("Failed to delete original file '");
                localStringBuilder.append(paramFile1);
                localStringBuilder.append("' after copy to '");
                localStringBuilder.append(paramFile2);
                localStringBuilder.append("'");
                throw new IOException(localStringBuilder.toString());
              }
            }
            return;
          }
          paramFile1 = new StringBuilder();
          paramFile1.append("Destination '");
          paramFile1.append(paramFile2);
          paramFile1.append("' is a directory");
          throw new IOException(paramFile1.toString());
        }
        paramFile1 = new StringBuilder();
        paramFile1.append("Destination '");
        paramFile1.append(paramFile2);
        paramFile1.append("' already exists");
        throw new FileExistsException(paramFile1.toString());
      }
      paramFile2 = new StringBuilder();
      paramFile2.append("Source '");
      paramFile2.append(paramFile1);
      paramFile2.append("' is a directory");
      throw new IOException(paramFile2.toString());
    }
    paramFile2 = new StringBuilder();
    paramFile2.append("Source '");
    paramFile2.append(paramFile1);
    paramFile2.append("' does not exist");
    throw new FileNotFoundException(paramFile2.toString());
  }
  
  private static long m(File paramFile)
  {
    if (paramFile.isDirectory()) {
      return o(paramFile);
    }
    return paramFile.length();
  }
  
  public static long n(File paramFile)
  {
    a(paramFile);
    return o(paramFile);
  }
  
  private static long o(File paramFile)
  {
    paramFile = paramFile.listFiles();
    if (paramFile == null) {
      return 0L;
    }
    int j = paramFile.length;
    int k = 0;
    for (l1 = 0L;; l1 = l2)
    {
      l2 = l1;
      if (k >= j) {
        break;
      }
      File localFile = paramFile[k];
      l2 = l1;
      try
      {
        if (!k(localFile))
        {
          l2 = m(localFile);
          l1 += l2;
          l2 = l1;
          if (l1 < 0L) {
            l2 = l1;
          }
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          l2 = l1;
        }
      }
      k++;
    }
    return l2;
  }
  
  private static File[] p(File paramFile)
    throws IOException
  {
    if (paramFile.exists())
    {
      if (paramFile.isDirectory())
      {
        localObject = paramFile.listFiles();
        if (localObject != null) {
          return (File[])localObject;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Failed to list contents of ");
        ((StringBuilder)localObject).append(paramFile);
        throw new IOException(((StringBuilder)localObject).toString());
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramFile);
      ((StringBuilder)localObject).append(" is not a directory");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramFile);
    ((StringBuilder)localObject).append(" does not exist");
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\io\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */