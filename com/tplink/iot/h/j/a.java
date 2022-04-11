package com.tplink.iot.h.j;

import java.io.File;
import java.io.IOException;

public class a
{
  public static void a(File paramFile)
  {
    if (paramFile.exists()) {
      if (paramFile.isFile())
      {
        paramFile.delete();
      }
      else if (paramFile.isDirectory())
      {
        File[] arrayOfFile = paramFile.listFiles();
        for (int i = 0; i < arrayOfFile.length; i++) {
          a(arrayOfFile[i]);
        }
        paramFile.delete();
      }
    }
  }
  
  public static void b(File paramFile)
  {
    if (paramFile.exists()) {
      if (paramFile.isFile())
      {
        paramFile.delete();
      }
      else if (paramFile.isDirectory())
      {
        paramFile = paramFile.listFiles();
        for (int i = 0; i < paramFile.length; i++) {
          a(paramFile[i]);
        }
      }
    }
  }
  
  public static void c(String paramString1, String paramString2)
  {
    try
    {
      File localFile = new java/io/File;
      localFile.<init>(paramString1);
      paramString1 = new java/io/File;
      paramString1.<init>(paramString2);
      org.apache.commons.io.a.l(localFile, paramString1);
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  /* Error */
  public static com.tplink.iot.h.h.a d(String paramString1, String paramString2)
    throws IOException
  {
    // Byte code:
    //   0: new 55	com/tplink/iot/h/h/a
    //   3: dup
    //   4: invokespecial 57	com/tplink/iot/h/h/a:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: aload_1
    //   10: invokevirtual 59	com/tplink/iot/h/h/a:d	(Ljava/lang/String;)V
    //   13: new 61	java/io/InputStreamReader
    //   16: astore_1
    //   17: new 63	java/io/ByteArrayInputStream
    //   20: astore_3
    //   21: aload_3
    //   22: aload_0
    //   23: getstatic 69	java/nio/charset/StandardCharsets:UTF_8	Ljava/nio/charset/Charset;
    //   26: invokevirtual 75	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   29: invokespecial 78	java/io/ByteArrayInputStream:<init>	([B)V
    //   32: aload_1
    //   33: aload_3
    //   34: getstatic 69	java/nio/charset/StandardCharsets:UTF_8	Ljava/nio/charset/Charset;
    //   37: invokespecial 81	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   40: new 83	java/io/BufferedReader
    //   43: astore 4
    //   45: aload 4
    //   47: aload_1
    //   48: invokespecial 86	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   51: lconst_0
    //   52: lstore 5
    //   54: fconst_0
    //   55: fstore 7
    //   57: aload_1
    //   58: astore_3
    //   59: aload 4
    //   61: astore 8
    //   63: aload 4
    //   65: invokevirtual 90	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   68: astore 9
    //   70: aload 9
    //   72: ifnull +281 -> 353
    //   75: aload_1
    //   76: astore_3
    //   77: aload 4
    //   79: astore 8
    //   81: aload 9
    //   83: ldc 92
    //   85: invokevirtual 96	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   88: ifeq +225 -> 313
    //   91: fload 7
    //   93: fstore 10
    //   95: aload 9
    //   97: astore_0
    //   98: aload_1
    //   99: astore_3
    //   100: aload 4
    //   102: astore 8
    //   104: aload 9
    //   106: ldc 98
    //   108: invokevirtual 96	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   111: ifeq +128 -> 239
    //   114: aload_1
    //   115: astore_3
    //   116: aload 4
    //   118: astore 8
    //   120: aload 9
    //   122: bipush 8
    //   124: invokevirtual 102	java/lang/String:substring	(I)Ljava/lang/String;
    //   127: astore 9
    //   129: aload_1
    //   130: astore_3
    //   131: aload 4
    //   133: astore 8
    //   135: aload 9
    //   137: ldc 104
    //   139: invokevirtual 107	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   142: ifeq +26 -> 168
    //   145: aload_1
    //   146: astore_3
    //   147: aload 4
    //   149: astore 8
    //   151: aload 9
    //   153: iconst_0
    //   154: aload 9
    //   156: invokevirtual 111	java/lang/String:length	()I
    //   159: iconst_1
    //   160: isub
    //   161: invokevirtual 114	java/lang/String:substring	(II)Ljava/lang/String;
    //   164: astore_0
    //   165: goto +42 -> 207
    //   168: aload 9
    //   170: astore_0
    //   171: aload_1
    //   172: astore_3
    //   173: aload 4
    //   175: astore 8
    //   177: aload 9
    //   179: ldc 104
    //   181: invokevirtual 118	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   184: ifeq +23 -> 207
    //   187: aload_1
    //   188: astore_3
    //   189: aload 4
    //   191: astore 8
    //   193: aload 9
    //   195: iconst_0
    //   196: aload 9
    //   198: ldc 104
    //   200: invokevirtual 122	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   203: invokevirtual 114	java/lang/String:substring	(II)Ljava/lang/String;
    //   206: astore_0
    //   207: aload_1
    //   208: astore_3
    //   209: aload 4
    //   211: astore 8
    //   213: aload_0
    //   214: invokestatic 128	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   217: fstore 10
    //   219: goto +20 -> 239
    //   222: astore 9
    //   224: aload_1
    //   225: astore_3
    //   226: aload 4
    //   228: astore 8
    //   230: aload 9
    //   232: invokevirtual 129	java/lang/NumberFormatException:printStackTrace	()V
    //   235: fload 7
    //   237: fstore 10
    //   239: fload 10
    //   241: fstore 7
    //   243: aload_1
    //   244: astore_3
    //   245: aload 4
    //   247: astore 8
    //   249: aload_0
    //   250: ldc -125
    //   252: invokevirtual 96	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   255: ifeq -198 -> 57
    //   258: aload_1
    //   259: astore_3
    //   260: aload 4
    //   262: astore 8
    //   264: aload_0
    //   265: bipush 17
    //   267: invokevirtual 102	java/lang/String:substring	(I)Ljava/lang/String;
    //   270: ldc -123
    //   272: invokevirtual 137	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   275: astore_0
    //   276: fload 10
    //   278: fstore 7
    //   280: aload_1
    //   281: astore_3
    //   282: aload 4
    //   284: astore 8
    //   286: aload_0
    //   287: arraylength
    //   288: iconst_2
    //   289: if_icmpne -232 -> 57
    //   292: aload_1
    //   293: astore_3
    //   294: aload 4
    //   296: astore 8
    //   298: aload_0
    //   299: iconst_0
    //   300: aaload
    //   301: invokestatic 143	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   304: lstore 5
    //   306: fload 10
    //   308: fstore 7
    //   310: goto -253 -> 57
    //   313: aload_1
    //   314: astore_3
    //   315: aload 4
    //   317: astore 8
    //   319: new 145	com/tplink/iot/h/h/b
    //   322: astore_0
    //   323: aload_1
    //   324: astore_3
    //   325: aload 4
    //   327: astore 8
    //   329: aload_0
    //   330: aload 9
    //   332: fload 7
    //   334: lload 5
    //   336: invokespecial 148	com/tplink/iot/h/h/b:<init>	(Ljava/lang/String;FJ)V
    //   339: aload_1
    //   340: astore_3
    //   341: aload 4
    //   343: astore 8
    //   345: aload_2
    //   346: aload_0
    //   347: invokevirtual 151	com/tplink/iot/h/h/a:a	(Lcom/tplink/iot/h/h/b;)V
    //   350: goto -299 -> 51
    //   353: aload_1
    //   354: invokevirtual 154	java/io/InputStreamReader:close	()V
    //   357: aload 4
    //   359: invokevirtual 155	java/io/BufferedReader:close	()V
    //   362: goto +82 -> 444
    //   365: astore_3
    //   366: aload 4
    //   368: astore_0
    //   369: aload_3
    //   370: astore 4
    //   372: goto +32 -> 404
    //   375: astore_0
    //   376: aconst_null
    //   377: astore 8
    //   379: goto +70 -> 449
    //   382: astore 4
    //   384: aconst_null
    //   385: astore_0
    //   386: goto +18 -> 404
    //   389: astore_0
    //   390: aconst_null
    //   391: astore_1
    //   392: aload_1
    //   393: astore 8
    //   395: goto +54 -> 449
    //   398: astore 4
    //   400: aconst_null
    //   401: astore_1
    //   402: aload_1
    //   403: astore_0
    //   404: aload_1
    //   405: astore_3
    //   406: aload_0
    //   407: astore 8
    //   409: aload 4
    //   411: invokevirtual 156	java/lang/Exception:printStackTrace	()V
    //   414: aload_1
    //   415: ifnull +14 -> 429
    //   418: aload_1
    //   419: invokevirtual 154	java/io/InputStreamReader:close	()V
    //   422: goto +7 -> 429
    //   425: astore_0
    //   426: goto +14 -> 440
    //   429: aload_0
    //   430: ifnull +14 -> 444
    //   433: aload_0
    //   434: invokevirtual 155	java/io/BufferedReader:close	()V
    //   437: goto +7 -> 444
    //   440: aload_0
    //   441: invokevirtual 47	java/io/IOException:printStackTrace	()V
    //   444: aload_2
    //   445: areturn
    //   446: astore_0
    //   447: aload_3
    //   448: astore_1
    //   449: aload_1
    //   450: ifnull +14 -> 464
    //   453: aload_1
    //   454: invokevirtual 154	java/io/InputStreamReader:close	()V
    //   457: goto +7 -> 464
    //   460: astore_1
    //   461: goto +16 -> 477
    //   464: aload 8
    //   466: ifnull +15 -> 481
    //   469: aload 8
    //   471: invokevirtual 155	java/io/BufferedReader:close	()V
    //   474: goto +7 -> 481
    //   477: aload_1
    //   478: invokevirtual 47	java/io/IOException:printStackTrace	()V
    //   481: aload_0
    //   482: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	483	0	paramString1	String
    //   0	483	1	paramString2	String
    //   7	438	2	locala	com.tplink.iot.h.h.a
    //   20	321	3	localObject1	Object
    //   365	5	3	localException1	Exception
    //   405	43	3	str1	String
    //   43	328	4	localObject2	Object
    //   382	1	4	localException2	Exception
    //   398	12	4	localException3	Exception
    //   52	283	5	l	long
    //   55	278	7	f1	float
    //   61	409	8	localObject3	Object
    //   68	129	9	str2	String
    //   222	109	9	localNumberFormatException	NumberFormatException
    //   93	214	10	f2	float
    // Exception table:
    //   from	to	target	type
    //   213	219	222	java/lang/NumberFormatException
    //   63	70	365	java/lang/Exception
    //   81	91	365	java/lang/Exception
    //   104	114	365	java/lang/Exception
    //   120	129	365	java/lang/Exception
    //   135	145	365	java/lang/Exception
    //   151	165	365	java/lang/Exception
    //   177	187	365	java/lang/Exception
    //   193	207	365	java/lang/Exception
    //   213	219	365	java/lang/Exception
    //   230	235	365	java/lang/Exception
    //   249	258	365	java/lang/Exception
    //   264	276	365	java/lang/Exception
    //   286	292	365	java/lang/Exception
    //   298	306	365	java/lang/Exception
    //   319	323	365	java/lang/Exception
    //   329	339	365	java/lang/Exception
    //   345	350	365	java/lang/Exception
    //   40	51	375	finally
    //   40	51	382	java/lang/Exception
    //   13	40	389	finally
    //   13	40	398	java/lang/Exception
    //   353	362	425	java/io/IOException
    //   418	422	425	java/io/IOException
    //   433	437	425	java/io/IOException
    //   63	70	446	finally
    //   81	91	446	finally
    //   104	114	446	finally
    //   120	129	446	finally
    //   135	145	446	finally
    //   151	165	446	finally
    //   177	187	446	finally
    //   193	207	446	finally
    //   213	219	446	finally
    //   230	235	446	finally
    //   249	258	446	finally
    //   264	276	446	finally
    //   286	292	446	finally
    //   298	306	446	finally
    //   319	323	446	finally
    //   329	339	446	finally
    //   345	350	446	finally
    //   409	414	446	finally
    //   453	457	460	java/io/IOException
    //   469	474	460	java/io/IOException
  }
  
  /* Error */
  public static String e(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_0
    //   5: ifnonnull +5 -> 10
    //   8: aconst_null
    //   9: areturn
    //   10: new 161	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   17: astore 4
    //   19: new 61	java/io/InputStreamReader
    //   22: astore 5
    //   24: new 63	java/io/ByteArrayInputStream
    //   27: astore 6
    //   29: aload 6
    //   31: aload_0
    //   32: getstatic 69	java/nio/charset/StandardCharsets:UTF_8	Ljava/nio/charset/Charset;
    //   35: invokevirtual 75	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   38: invokespecial 78	java/io/ByteArrayInputStream:<init>	([B)V
    //   41: aload 5
    //   43: aload 6
    //   45: getstatic 69	java/nio/charset/StandardCharsets:UTF_8	Ljava/nio/charset/Charset;
    //   48: invokespecial 81	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   51: new 83	java/io/BufferedReader
    //   54: astore 6
    //   56: aload 6
    //   58: aload 5
    //   60: invokespecial 86	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   63: iconst_0
    //   64: istore 7
    //   66: aload 6
    //   68: invokevirtual 90	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   71: astore_3
    //   72: aload_3
    //   73: ifnull +42 -> 115
    //   76: aload_3
    //   77: astore_0
    //   78: aload_3
    //   79: ldc -92
    //   81: invokevirtual 107	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   84: ifeq +5 -> 89
    //   87: aload_1
    //   88: astore_0
    //   89: iload 7
    //   91: ifle +11 -> 102
    //   94: aload 4
    //   96: ldc -90
    //   98: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload 4
    //   104: aload_0
    //   105: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: iinc 7 1
    //   112: goto -46 -> 66
    //   115: aload 5
    //   117: invokevirtual 154	java/io/InputStreamReader:close	()V
    //   120: aload 6
    //   122: invokevirtual 155	java/io/BufferedReader:close	()V
    //   125: goto +95 -> 220
    //   128: astore_0
    //   129: goto +17 -> 146
    //   132: astore_0
    //   133: aload 6
    //   135: astore_1
    //   136: aload_0
    //   137: astore 6
    //   139: goto +24 -> 163
    //   142: astore_0
    //   143: aconst_null
    //   144: astore 6
    //   146: aload 5
    //   148: astore_1
    //   149: aload 6
    //   151: astore 5
    //   153: aload_0
    //   154: astore 6
    //   156: goto +77 -> 233
    //   159: astore 6
    //   161: aconst_null
    //   162: astore_1
    //   163: aload 5
    //   165: astore_0
    //   166: goto +19 -> 185
    //   169: astore 6
    //   171: aconst_null
    //   172: astore 5
    //   174: aload_2
    //   175: astore_1
    //   176: goto +57 -> 233
    //   179: astore 6
    //   181: aconst_null
    //   182: astore_1
    //   183: aload_3
    //   184: astore_0
    //   185: aload 6
    //   187: invokevirtual 156	java/lang/Exception:printStackTrace	()V
    //   190: aload_0
    //   191: ifnull +14 -> 205
    //   194: aload_0
    //   195: invokevirtual 154	java/io/InputStreamReader:close	()V
    //   198: goto +7 -> 205
    //   201: astore_0
    //   202: goto +14 -> 216
    //   205: aload_1
    //   206: ifnull +14 -> 220
    //   209: aload_1
    //   210: invokevirtual 155	java/io/BufferedReader:close	()V
    //   213: goto +7 -> 220
    //   216: aload_0
    //   217: invokevirtual 47	java/io/IOException:printStackTrace	()V
    //   220: aload 4
    //   222: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: areturn
    //   226: astore 6
    //   228: aload_1
    //   229: astore 5
    //   231: aload_0
    //   232: astore_1
    //   233: aload_1
    //   234: ifnull +14 -> 248
    //   237: aload_1
    //   238: invokevirtual 154	java/io/InputStreamReader:close	()V
    //   241: goto +7 -> 248
    //   244: astore_0
    //   245: goto +16 -> 261
    //   248: aload 5
    //   250: ifnull +15 -> 265
    //   253: aload 5
    //   255: invokevirtual 155	java/io/BufferedReader:close	()V
    //   258: goto +7 -> 265
    //   261: aload_0
    //   262: invokevirtual 47	java/io/IOException:printStackTrace	()V
    //   265: aload 6
    //   267: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	268	0	paramString1	String
    //   0	268	1	paramString2	String
    //   1	174	2	localObject1	Object
    //   3	181	3	str	String
    //   17	204	4	localStringBuilder	StringBuilder
    //   22	232	5	localObject2	Object
    //   27	128	6	localObject3	Object
    //   159	1	6	localException1	Exception
    //   169	1	6	localObject4	Object
    //   179	7	6	localException2	Exception
    //   226	40	6	localObject5	Object
    //   64	46	7	i	int
    // Exception table:
    //   from	to	target	type
    //   66	72	128	finally
    //   78	87	128	finally
    //   94	102	128	finally
    //   102	109	128	finally
    //   66	72	132	java/lang/Exception
    //   78	87	132	java/lang/Exception
    //   94	102	132	java/lang/Exception
    //   102	109	132	java/lang/Exception
    //   51	63	142	finally
    //   51	63	159	java/lang/Exception
    //   19	51	169	finally
    //   19	51	179	java/lang/Exception
    //   115	125	201	java/io/IOException
    //   194	198	201	java/io/IOException
    //   209	213	201	java/io/IOException
    //   185	190	226	finally
    //   237	241	244	java/io/IOException
    //   253	258	244	java/io/IOException
  }
  
  /* Error */
  public static void f(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 8	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 37	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: aload_2
    //   10: invokevirtual 178	java/io/File:getParentFile	()Ljava/io/File;
    //   13: invokevirtual 12	java/io/File:exists	()Z
    //   16: ifne +11 -> 27
    //   19: aload_2
    //   20: invokevirtual 178	java/io/File:getParentFile	()Ljava/io/File;
    //   23: invokevirtual 181	java/io/File:mkdirs	()Z
    //   26: pop
    //   27: aload_2
    //   28: invokevirtual 12	java/io/File:exists	()Z
    //   31: ifeq +8 -> 39
    //   34: aload_2
    //   35: invokevirtual 18	java/io/File:delete	()Z
    //   38: pop
    //   39: new 183	java/io/BufferedWriter
    //   42: astore_0
    //   43: new 185	java/io/OutputStreamWriter
    //   46: astore_3
    //   47: new 187	java/io/FileOutputStream
    //   50: astore 4
    //   52: aload 4
    //   54: aload_2
    //   55: invokespecial 189	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   58: aload_3
    //   59: aload 4
    //   61: invokespecial 192	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   64: aload_0
    //   65: aload_3
    //   66: invokespecial 195	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   69: aload_0
    //   70: aload_1
    //   71: invokevirtual 198	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   74: aload_0
    //   75: invokevirtual 201	java/io/BufferedWriter:flush	()V
    //   78: aload_0
    //   79: invokevirtual 202	java/io/BufferedWriter:close	()V
    //   82: goto +27 -> 109
    //   85: astore_1
    //   86: aload_1
    //   87: athrow
    //   88: astore_2
    //   89: aload_0
    //   90: invokevirtual 202	java/io/BufferedWriter:close	()V
    //   93: goto +9 -> 102
    //   96: astore_0
    //   97: aload_1
    //   98: aload_0
    //   99: invokevirtual 208	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   102: aload_2
    //   103: athrow
    //   104: astore_0
    //   105: aload_0
    //   106: invokevirtual 47	java/io/IOException:printStackTrace	()V
    //   109: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	paramString1	String
    //   0	110	1	paramString2	String
    //   8	47	2	localFile	File
    //   88	15	2	localObject	Object
    //   46	20	3	localOutputStreamWriter	java.io.OutputStreamWriter
    //   50	10	4	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   69	78	85	finally
    //   86	88	88	finally
    //   89	93	96	finally
    //   39	69	104	java/io/IOException
    //   78	82	104	java/io/IOException
    //   97	102	104	java/io/IOException
    //   102	104	104	java/io/IOException
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\h\j\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */