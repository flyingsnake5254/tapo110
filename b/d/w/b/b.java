package b.d.w.b;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class b
{
  public static boolean a(File paramFile1, File paramFile2)
  {
    boolean bool = paramFile1.exists();
    int i = 0;
    if (!bool) {
      return false;
    }
    if (!paramFile2.exists()) {
      paramFile2.mkdirs();
    }
    if (paramFile1.isFile())
    {
      b(paramFile1, paramFile2);
    }
    else
    {
      String str = paramFile1.getName();
      Object localObject = new File(paramFile2, str);
      int j = 0;
      while (((File)localObject).exists())
      {
        j++;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append("-copy");
        ((StringBuilder)localObject).append(j);
        localObject = new File(paramFile2, ((StringBuilder)localObject).toString());
      }
      ((File)localObject).mkdirs();
      paramFile1 = paramFile1.listFiles();
      if (paramFile1 != null)
      {
        int k = paramFile1.length;
        for (j = i; j < k; j++) {
          a(paramFile1[j], (File)localObject);
        }
      }
    }
    return true;
  }
  
  /* Error */
  public static boolean b(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 12	java/io/File:exists	()Z
    //   4: istore_2
    //   5: iconst_0
    //   6: istore_3
    //   7: iload_3
    //   8: istore 4
    //   10: iload_2
    //   11: ifeq +292 -> 303
    //   14: aload_0
    //   15: invokevirtual 58	java/io/File:isDirectory	()Z
    //   18: ifeq +9 -> 27
    //   21: iload_3
    //   22: istore 4
    //   24: goto +279 -> 303
    //   27: aload_1
    //   28: invokevirtual 12	java/io/File:exists	()Z
    //   31: ifne +8 -> 39
    //   34: aload_1
    //   35: invokevirtual 15	java/io/File:mkdirs	()Z
    //   38: pop
    //   39: aload_0
    //   40: invokevirtual 25	java/io/File:getName	()Ljava/lang/String;
    //   43: astore 5
    //   45: ldc 60
    //   47: invokestatic 66	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   50: aload 5
    //   52: invokevirtual 70	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   55: astore 6
    //   57: aload 6
    //   59: invokevirtual 75	java/util/regex/Matcher:find	()Z
    //   62: ifeq +31 -> 93
    //   65: aload 5
    //   67: iconst_0
    //   68: aload 6
    //   70: invokevirtual 79	java/util/regex/Matcher:start	()I
    //   73: invokevirtual 85	java/lang/String:substring	(II)Ljava/lang/String;
    //   76: astore 7
    //   78: aload 5
    //   80: aload 6
    //   82: invokevirtual 79	java/util/regex/Matcher:start	()I
    //   85: invokevirtual 88	java/lang/String:substring	(I)Ljava/lang/String;
    //   88: astore 6
    //   90: goto +11 -> 101
    //   93: ldc 90
    //   95: astore 6
    //   97: aload 5
    //   99: astore 7
    //   101: new 8	java/io/File
    //   104: dup
    //   105: aload_1
    //   106: aload 5
    //   108: invokespecial 29	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   111: astore 5
    //   113: iconst_0
    //   114: istore 8
    //   116: aload 5
    //   118: invokevirtual 12	java/io/File:exists	()Z
    //   121: ifeq +65 -> 186
    //   124: iinc 8 1
    //   127: new 31	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   134: astore 5
    //   136: aload 5
    //   138: aload 7
    //   140: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aload 5
    //   146: ldc 40
    //   148: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload 5
    //   154: iload 8
    //   156: invokevirtual 43	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload 5
    //   162: aload 6
    //   164: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: new 8	java/io/File
    //   171: dup
    //   172: aload_1
    //   173: aload 5
    //   175: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokespecial 29	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   181: astore 5
    //   183: goto -67 -> 116
    //   186: new 92	java/io/FileInputStream
    //   189: astore_1
    //   190: aload_1
    //   191: aload_0
    //   192: invokespecial 95	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   195: aload_1
    //   196: invokevirtual 99	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   199: astore_0
    //   200: new 101	java/io/FileOutputStream
    //   203: astore_1
    //   204: aload_1
    //   205: aload 5
    //   207: invokespecial 102	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   210: aload_1
    //   211: invokevirtual 103	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   214: astore 6
    //   216: aload_0
    //   217: lconst_0
    //   218: aload_0
    //   219: invokevirtual 109	java/nio/channels/FileChannel:size	()J
    //   222: aload 6
    //   224: invokevirtual 113	java/nio/channels/FileChannel:transferTo	(JJLjava/nio/channels/WritableByteChannel;)J
    //   227: pop2
    //   228: aload 6
    //   230: ifnull +8 -> 238
    //   233: aload 6
    //   235: invokevirtual 116	java/nio/channels/FileChannel:close	()V
    //   238: aload_0
    //   239: invokevirtual 116	java/nio/channels/FileChannel:close	()V
    //   242: iconst_1
    //   243: istore 4
    //   245: goto +58 -> 303
    //   248: astore_1
    //   249: aload_1
    //   250: athrow
    //   251: astore 7
    //   253: aload 6
    //   255: ifnull +19 -> 274
    //   258: aload 6
    //   260: invokevirtual 116	java/nio/channels/FileChannel:close	()V
    //   263: goto +11 -> 274
    //   266: astore 6
    //   268: aload_1
    //   269: aload 6
    //   271: invokevirtual 122	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   274: aload 7
    //   276: athrow
    //   277: astore 7
    //   279: aload 7
    //   281: athrow
    //   282: astore_1
    //   283: aload_0
    //   284: ifnull +17 -> 301
    //   287: aload_0
    //   288: invokevirtual 116	java/nio/channels/FileChannel:close	()V
    //   291: goto +10 -> 301
    //   294: astore_0
    //   295: aload 7
    //   297: aload_0
    //   298: invokevirtual 122	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   301: aload_1
    //   302: athrow
    //   303: iload 4
    //   305: ireturn
    //   306: astore_0
    //   307: iload_3
    //   308: istore 4
    //   310: goto -7 -> 303
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	313	0	paramFile1	File
    //   0	313	1	paramFile2	File
    //   4	7	2	bool1	boolean
    //   6	302	3	bool2	boolean
    //   8	301	4	bool3	boolean
    //   43	163	5	localObject1	Object
    //   55	204	6	localObject2	Object
    //   266	4	6	localThrowable	Throwable
    //   76	63	7	localObject3	Object
    //   251	24	7	localObject4	Object
    //   277	19	7	localObject5	Object
    //   114	41	8	i	int
    // Exception table:
    //   from	to	target	type
    //   216	228	248	finally
    //   249	251	251	finally
    //   258	263	266	finally
    //   200	216	277	finally
    //   233	238	277	finally
    //   268	274	277	finally
    //   274	277	277	finally
    //   279	282	282	finally
    //   287	291	294	finally
    //   186	200	306	java/io/IOException
    //   238	242	306	java/io/IOException
    //   295	301	306	java/io/IOException
    //   301	303	306	java/io/IOException
  }
  
  public static boolean c(File paramFile)
  {
    if (paramFile != null) {}
    try
    {
      if (paramFile.exists())
      {
        if (!paramFile.isFile())
        {
          File[] arrayOfFile = paramFile.listFiles();
          if (arrayOfFile != null)
          {
            int i = arrayOfFile.length;
            for (int j = 0; j < i; j++) {
              c(arrayOfFile[j]);
            }
          }
        }
        boolean bool = paramFile.delete();
        return bool;
      }
    }
    catch (SecurityException paramFile)
    {
      for (;;) {}
    }
    return false;
  }
  
  public static boolean d(String paramString)
  {
    boolean bool = false;
    if (paramString == null) {
      return false;
    }
    paramString = new File(paramString);
    if ((!paramString.exists()) || (!paramString.isDirectory())) {
      bool = paramString.mkdirs();
    }
    return bool;
  }
  
  public static long e(File paramFile)
  {
    boolean bool = paramFile.exists();
    long l1 = 0L;
    long l2 = l1;
    if (bool)
    {
      if (paramFile.isFile()) {
        return paramFile.length();
      }
      paramFile = paramFile.listFiles();
      l2 = l1;
      if (paramFile != null)
      {
        int i = paramFile.length;
        for (int j = 0;; j++)
        {
          l2 = l1;
          if (j >= i) {
            break;
          }
          l1 += e(paramFile[j]);
        }
      }
    }
    return l2;
  }
  
  public static List<File> f(File[] paramArrayOfFile)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayOfFile != null) && (paramArrayOfFile.length > 0)) {
      localArrayList.addAll(Arrays.asList(paramArrayOfFile));
    }
    Collections.sort(localArrayList, a.c);
    return localArrayList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\w\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */