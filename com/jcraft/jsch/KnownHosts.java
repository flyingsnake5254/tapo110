package com.jcraft.jsch;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Vector;

public class KnownHosts
  implements HostKeyRepository
{
  private static final String _known_hosts = "known_hosts";
  private static final byte[] cr = Util.str2byte("\n");
  private static final byte[] space = { 32 };
  private MAC hmacsha1 = null;
  private JSch jsch = null;
  private String known_hosts = null;
  private Vector pool = null;
  
  KnownHosts(JSch paramJSch)
  {
    this.jsch = paramJSch;
    this.hmacsha1 = getHMACSHA1();
    this.pool = new Vector();
  }
  
  private void addInvalidLine(String paramString)
    throws JSchException
  {
    paramString = new HostKey(paramString, 6, null);
    this.pool.addElement(paramString);
  }
  
  private String deleteSubString(String paramString1, String paramString2)
  {
    int i = paramString2.length();
    int j = paramString1.length();
    int k = 0;
    while (k < j)
    {
      int m = paramString1.indexOf(',', k);
      if (m != -1) {
        if (!paramString2.equals(paramString1.substring(k, m)))
        {
          k = m + 1;
        }
        else
        {
          paramString2 = new StringBuilder();
          paramString2.append(paramString1.substring(0, k));
          paramString2.append(paramString1.substring(m + 1));
          return paramString2.toString();
        }
      }
    }
    String str = paramString1;
    if (paramString1.endsWith(paramString2))
    {
      str = paramString1;
      if (j - k == i)
      {
        if (i == j) {
          k = 0;
        } else {
          k = j - i - 1;
        }
        str = paramString1.substring(0, k);
      }
    }
    return str;
  }
  
  private MAC getHMACSHA1()
  {
    if (this.hmacsha1 == null) {
      try
      {
        this.hmacsha1 = ((MAC)Class.forName(JSch.getConfig("hmac-sha1")).newInstance());
      }
      catch (Exception localException)
      {
        PrintStream localPrintStream = System.err;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("hmacsha1: ");
        localStringBuilder.append(localException);
        localPrintStream.println(localStringBuilder.toString());
      }
    }
    return this.hmacsha1;
  }
  
  public void add(HostKey paramHostKey, UserInfo paramUserInfo)
  {
    int i = paramHostKey.type;
    Object localObject1 = paramHostKey.getHost();
    Object localObject2 = this.pool;
    int j = 0;
    i = 0;
    try
    {
      while (i < this.pool.size())
      {
        ((HostKey)this.pool.elementAt(i)).isMatched((String)localObject1);
        i++;
      }
      this.pool.addElement(paramHostKey);
      paramHostKey = getKnownHostsRepositoryID();
      if (paramHostKey != null)
      {
        localObject1 = new File(Util.checkTilde(paramHostKey));
        int k;
        if (!((File)localObject1).exists())
        {
          k = j;
          if (paramUserInfo != null)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(paramHostKey);
            ((StringBuilder)localObject2).append(" does not exist.\n");
            ((StringBuilder)localObject2).append("Are you sure you want to create it?");
            boolean bool = paramUserInfo.promptYesNo(((StringBuilder)localObject2).toString());
            localObject2 = ((File)localObject1).getParentFile();
            k = bool;
            if (bool)
            {
              k = bool;
              if (localObject2 != null)
              {
                k = bool;
                if (!((File)localObject2).exists())
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append("The parent directory ");
                  ((StringBuilder)localObject1).append(localObject2);
                  ((StringBuilder)localObject1).append(" does not exist.\n");
                  ((StringBuilder)localObject1).append("Are you sure you want to create it?");
                  bool = paramUserInfo.promptYesNo(((StringBuilder)localObject1).toString());
                  k = bool;
                  if (bool) {
                    if (!((File)localObject2).mkdirs())
                    {
                      localObject1 = new StringBuilder();
                      ((StringBuilder)localObject1).append(localObject2);
                      ((StringBuilder)localObject1).append(" has not been created.");
                      paramUserInfo.showMessage(((StringBuilder)localObject1).toString());
                      k = 0;
                    }
                    else
                    {
                      localObject1 = new StringBuilder();
                      ((StringBuilder)localObject1).append(localObject2);
                      ((StringBuilder)localObject1).append(" has been succesfully created.\nPlease check its access permission.");
                      paramUserInfo.showMessage(((StringBuilder)localObject1).toString());
                      k = bool;
                    }
                  }
                }
              }
            }
            if (localObject2 == null) {
              k = j;
            }
          }
        }
        else
        {
          k = 1;
        }
        if (k != 0) {
          try
          {
            sync(paramHostKey);
          }
          catch (Exception paramUserInfo)
          {
            paramHostKey = System.err;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("sync known_hosts: ");
            ((StringBuilder)localObject2).append(paramUserInfo);
            paramHostKey.println(((StringBuilder)localObject2).toString());
          }
        }
      }
      return;
    }
    finally {}
  }
  
  public int check(String paramString, byte[] paramArrayOfByte)
  {
    if (paramString == null) {
      return 1;
    }
    try
    {
      HostKey localHostKey1 = new HostKey(paramString, 0, paramArrayOfByte);
      Vector localVector = this.pool;
      int i = 0;
      int j = 1;
      try
      {
        while (i < this.pool.size())
        {
          HostKey localHostKey2 = (HostKey)this.pool.elementAt(i);
          int k = j;
          if (localHostKey2.isMatched(paramString))
          {
            k = j;
            if (localHostKey2.type == localHostKey1.type)
            {
              if (Util.array_equals(localHostKey2.key, paramArrayOfByte)) {
                return 0;
              }
              k = 2;
            }
          }
          i++;
          j = k;
        }
        if ((j == 1) && (paramString.startsWith("[")) && (paramString.indexOf("]:") > 1)) {
          return check(paramString.substring(1, paramString.indexOf("]:")), paramArrayOfByte);
        }
        return j;
      }
      finally {}
      return 1;
    }
    catch (JSchException paramString) {}
  }
  
  HostKey createHashedHostKey(String paramString, byte[] paramArrayOfByte)
    throws JSchException
  {
    paramString = new HashedHostKey(paramString, paramArrayOfByte);
    paramString.hash();
    return paramString;
  }
  
  void dump(OutputStream paramOutputStream)
    throws IOException
  {
    try
    {
      Vector localVector = this.pool;
      int i = 0;
      try
      {
        while (i < this.pool.size())
        {
          HostKey localHostKey = (HostKey)this.pool.elementAt(i);
          Object localObject = localHostKey.getMarker();
          String str1 = localHostKey.getHost();
          String str2 = localHostKey.getType();
          String str3 = localHostKey.getComment();
          if (str2.equals("UNKNOWN"))
          {
            paramOutputStream.write(Util.str2byte(str1));
            paramOutputStream.write(cr);
          }
          else
          {
            if (((String)localObject).length() != 0)
            {
              paramOutputStream.write(Util.str2byte((String)localObject));
              paramOutputStream.write(space);
            }
            paramOutputStream.write(Util.str2byte(str1));
            localObject = space;
            paramOutputStream.write((byte[])localObject);
            paramOutputStream.write(Util.str2byte(str2));
            paramOutputStream.write((byte[])localObject);
            paramOutputStream.write(Util.str2byte(localHostKey.getKey()));
            if (str3 != null)
            {
              paramOutputStream.write((byte[])localObject);
              paramOutputStream.write(Util.str2byte(str3));
            }
            paramOutputStream.write(cr);
          }
          i++;
        }
      }
      finally {}
      return;
    }
    catch (Exception paramOutputStream)
    {
      System.err.println(paramOutputStream);
    }
  }
  
  public HostKey[] getHostKey()
  {
    return getHostKey(null, null);
  }
  
  public HostKey[] getHostKey(String paramString1, String paramString2)
  {
    synchronized (this.pool)
    {
      Object localObject1 = new java/util/ArrayList;
      ((ArrayList)localObject1).<init>();
      for (int i = 0; i < this.pool.size(); i++)
      {
        localObject2 = (HostKey)this.pool.elementAt(i);
        if ((((HostKey)localObject2).type != 6) && ((paramString1 == null) || ((((HostKey)localObject2).isMatched(paramString1)) && ((paramString2 == null) || (((HostKey)localObject2).getType().equals(paramString2)))))) {
          ((ArrayList)localObject1).add(localObject2);
        }
      }
      int j = ((ArrayList)localObject1).size();
      Object localObject2 = new HostKey[j];
      for (i = 0; i < ((ArrayList)localObject1).size(); i++) {
        localObject2[i] = ((HostKey)((ArrayList)localObject1).get(i));
      }
      localObject1 = localObject2;
      if (paramString1 != null)
      {
        localObject1 = localObject2;
        if (paramString1.startsWith("["))
        {
          localObject1 = localObject2;
          if (paramString1.indexOf("]:") > 1)
          {
            paramString1 = getHostKey(paramString1.substring(1, paramString1.indexOf("]:")), paramString2);
            localObject1 = localObject2;
            if (paramString1.length > 0)
            {
              localObject1 = new HostKey[paramString1.length + j];
              System.arraycopy(localObject2, 0, localObject1, 0, j);
              System.arraycopy(paramString1, 0, localObject1, j, paramString1.length);
            }
          }
        }
      }
      return (HostKey[])localObject1;
    }
  }
  
  String getKnownHostsFile()
  {
    return this.known_hosts;
  }
  
  public String getKnownHostsRepositoryID()
  {
    return this.known_hosts;
  }
  
  public void remove(String paramString1, String paramString2)
  {
    remove(paramString1, paramString2, null);
  }
  
  /* Error */
  public void remove(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 47	com/jcraft/jsch/KnownHosts:pool	Ljava/util/Vector;
    //   4: astore 4
    //   6: aload 4
    //   8: monitorenter
    //   9: iconst_0
    //   10: istore 5
    //   12: iconst_0
    //   13: istore 6
    //   15: iload 5
    //   17: aload_0
    //   18: getfield 47	com/jcraft/jsch/KnownHosts:pool	Ljava/util/Vector;
    //   21: invokevirtual 160	java/util/Vector:size	()I
    //   24: if_icmpge +150 -> 174
    //   27: aload_0
    //   28: getfield 47	com/jcraft/jsch/KnownHosts:pool	Ljava/util/Vector;
    //   31: iload 5
    //   33: invokevirtual 164	java/util/Vector:elementAt	(I)Ljava/lang/Object;
    //   36: checkcast 64	com/jcraft/jsch/HostKey
    //   39: astore 7
    //   41: aload_1
    //   42: ifnull +56 -> 98
    //   45: iload 6
    //   47: istore 8
    //   49: aload 7
    //   51: aload_1
    //   52: invokevirtual 167	com/jcraft/jsch/HostKey:isMatched	(Ljava/lang/String;)Z
    //   55: ifeq +109 -> 164
    //   58: aload_2
    //   59: ifnull +39 -> 98
    //   62: iload 6
    //   64: istore 8
    //   66: aload 7
    //   68: invokevirtual 250	com/jcraft/jsch/HostKey:getType	()Ljava/lang/String;
    //   71: aload_2
    //   72: invokevirtual 92	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   75: ifeq +89 -> 164
    //   78: aload_3
    //   79: ifnull +19 -> 98
    //   82: iload 6
    //   84: istore 8
    //   86: aload_3
    //   87: aload 7
    //   89: getfield 216	com/jcraft/jsch/HostKey:key	[B
    //   92: invokestatic 220	com/jcraft/jsch/Util:array_equals	([B[B)Z
    //   95: ifeq +69 -> 164
    //   98: aload 7
    //   100: invokevirtual 157	com/jcraft/jsch/HostKey:getHost	()Ljava/lang/String;
    //   103: astore 9
    //   105: aload 9
    //   107: aload_1
    //   108: invokevirtual 92	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   111: ifne +40 -> 151
    //   114: aload 7
    //   116: instanceof 8
    //   119: ifeq +17 -> 136
    //   122: aload 7
    //   124: checkcast 8	com/jcraft/jsch/KnownHosts$HashedHostKey
    //   127: invokevirtual 293	com/jcraft/jsch/KnownHosts$HashedHostKey:isHashed	()Z
    //   130: ifeq +6 -> 136
    //   133: goto +18 -> 151
    //   136: aload 7
    //   138: aload_0
    //   139: aload 9
    //   141: aload_1
    //   142: invokespecial 295	com/jcraft/jsch/KnownHosts:deleteSubString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   145: putfield 298	com/jcraft/jsch/HostKey:host	Ljava/lang/String;
    //   148: goto +13 -> 161
    //   151: aload_0
    //   152: getfield 47	com/jcraft/jsch/KnownHosts:pool	Ljava/util/Vector;
    //   155: aload 7
    //   157: invokevirtual 301	java/util/Vector:removeElement	(Ljava/lang/Object;)Z
    //   160: pop
    //   161: iconst_1
    //   162: istore 8
    //   164: iinc 5 1
    //   167: iload 8
    //   169: istore 6
    //   171: goto -156 -> 15
    //   174: aload 4
    //   176: monitorexit
    //   177: iload 6
    //   179: ifeq +7 -> 186
    //   182: aload_0
    //   183: invokevirtual 303	com/jcraft/jsch/KnownHosts:sync	()V
    //   186: return
    //   187: astore_1
    //   188: aload 4
    //   190: monitorexit
    //   191: aload_1
    //   192: athrow
    //   193: astore_1
    //   194: goto -8 -> 186
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	this	KnownHosts
    //   0	197	1	paramString1	String
    //   0	197	2	paramString2	String
    //   0	197	3	paramArrayOfByte	byte[]
    //   4	185	4	localVector	Vector
    //   10	155	5	i	int
    //   13	165	6	j	int
    //   39	117	7	localHostKey	HostKey
    //   47	121	8	k	int
    //   103	37	9	str	String
    // Exception table:
    //   from	to	target	type
    //   15	41	187	finally
    //   49	58	187	finally
    //   66	78	187	finally
    //   86	98	187	finally
    //   98	133	187	finally
    //   136	148	187	finally
    //   151	161	187	finally
    //   174	177	187	finally
    //   188	191	187	finally
    //   182	186	193	java/lang/Exception
  }
  
  /* Error */
  void setKnownHosts(java.io.InputStream paramInputStream)
    throws JSchException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 47	com/jcraft/jsch/KnownHosts:pool	Ljava/util/Vector;
    //   4: invokevirtual 308	java/util/Vector:removeAllElements	()V
    //   7: new 310	java/lang/StringBuffer
    //   10: dup
    //   11: invokespecial 311	java/lang/StringBuffer:<init>	()V
    //   14: astore_2
    //   15: sipush 1024
    //   18: newarray <illegal type>
    //   20: astore_3
    //   21: iconst_0
    //   22: istore 4
    //   24: aload_1
    //   25: invokevirtual 316	java/io/InputStream:read	()I
    //   28: istore 5
    //   30: iload 5
    //   32: iconst_m1
    //   33: if_icmpne +27 -> 60
    //   36: iload 4
    //   38: ifne +60 -> 98
    //   41: aload_1
    //   42: invokevirtual 319	java/io/InputStream:close	()V
    //   45: return
    //   46: astore_1
    //   47: new 62	com/jcraft/jsch/JSchException
    //   50: dup
    //   51: aload_1
    //   52: invokevirtual 320	java/io/IOException:toString	()Ljava/lang/String;
    //   55: aload_1
    //   56: invokespecial 323	com/jcraft/jsch/JSchException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   59: athrow
    //   60: iload 5
    //   62: bipush 13
    //   64: if_icmpne +6 -> 70
    //   67: goto -43 -> 24
    //   70: iload 5
    //   72: bipush 10
    //   74: if_icmpne +6 -> 80
    //   77: goto +21 -> 98
    //   80: aload_3
    //   81: astore 6
    //   83: aload_3
    //   84: arraylength
    //   85: iload 4
    //   87: if_icmpgt +825 -> 912
    //   90: iload 4
    //   92: sipush 10240
    //   95: if_icmple +799 -> 894
    //   98: iconst_0
    //   99: istore 5
    //   101: iload 5
    //   103: iload 4
    //   105: if_icmpge +53 -> 158
    //   108: aload_3
    //   109: iload 5
    //   111: baload
    //   112: istore 7
    //   114: iload 7
    //   116: bipush 32
    //   118: if_icmpeq +34 -> 152
    //   121: iload 7
    //   123: bipush 9
    //   125: if_icmpne +6 -> 131
    //   128: goto +24 -> 152
    //   131: iload 7
    //   133: bipush 35
    //   135: if_icmpne +23 -> 158
    //   138: aload_0
    //   139: aload_3
    //   140: iconst_0
    //   141: iload 4
    //   143: invokestatic 327	com/jcraft/jsch/Util:byte2str	([BII)Ljava/lang/String;
    //   146: invokespecial 329	com/jcraft/jsch/KnownHosts:addInvalidLine	(Ljava/lang/String;)V
    //   149: goto +742 -> 891
    //   152: iinc 5 1
    //   155: goto -54 -> 101
    //   158: iload 5
    //   160: iload 4
    //   162: if_icmplt +17 -> 179
    //   165: aload_0
    //   166: aload_3
    //   167: iconst_0
    //   168: iload 4
    //   170: invokestatic 327	com/jcraft/jsch/Util:byte2str	([BII)Ljava/lang/String;
    //   173: invokespecial 329	com/jcraft/jsch/KnownHosts:addInvalidLine	(Ljava/lang/String;)V
    //   176: goto +715 -> 891
    //   179: aload_2
    //   180: iconst_0
    //   181: invokevirtual 333	java/lang/StringBuffer:setLength	(I)V
    //   184: iload 5
    //   186: istore 7
    //   188: iload 5
    //   190: iload 4
    //   192: if_icmpge +47 -> 239
    //   195: iload 5
    //   197: iconst_1
    //   198: iadd
    //   199: istore 7
    //   201: aload_3
    //   202: iload 5
    //   204: baload
    //   205: istore 5
    //   207: iload 5
    //   209: bipush 32
    //   211: if_icmpeq +28 -> 239
    //   214: iload 5
    //   216: bipush 9
    //   218: if_icmpne +6 -> 224
    //   221: goto +18 -> 239
    //   224: aload_2
    //   225: iload 5
    //   227: i2c
    //   228: invokevirtual 336	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   231: pop
    //   232: iload 7
    //   234: istore 5
    //   236: goto -52 -> 184
    //   239: aload_2
    //   240: invokevirtual 337	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   243: astore 8
    //   245: iload 7
    //   247: iload 4
    //   249: if_icmpge +631 -> 880
    //   252: iload 7
    //   254: istore 5
    //   256: aload 8
    //   258: invokevirtual 80	java/lang/String:length	()I
    //   261: ifne +6 -> 267
    //   264: goto +616 -> 880
    //   267: iload 5
    //   269: iload 4
    //   271: if_icmpge +29 -> 300
    //   274: aload_3
    //   275: iload 5
    //   277: baload
    //   278: istore 7
    //   280: iload 7
    //   282: bipush 32
    //   284: if_icmpeq +10 -> 294
    //   287: iload 7
    //   289: bipush 9
    //   291: if_icmpne +9 -> 300
    //   294: iinc 5 1
    //   297: goto -30 -> 267
    //   300: aload 8
    //   302: iconst_0
    //   303: invokevirtual 341	java/lang/String:charAt	(I)C
    //   306: bipush 64
    //   308: if_icmpne +158 -> 466
    //   311: aload_2
    //   312: iconst_0
    //   313: invokevirtual 333	java/lang/StringBuffer:setLength	(I)V
    //   316: iload 5
    //   318: istore 7
    //   320: iload 5
    //   322: iload 4
    //   324: if_icmpge +47 -> 371
    //   327: iload 5
    //   329: iconst_1
    //   330: iadd
    //   331: istore 7
    //   333: aload_3
    //   334: iload 5
    //   336: baload
    //   337: istore 5
    //   339: iload 5
    //   341: bipush 32
    //   343: if_icmpeq +28 -> 371
    //   346: iload 5
    //   348: bipush 9
    //   350: if_icmpne +6 -> 356
    //   353: goto +18 -> 371
    //   356: aload_2
    //   357: iload 5
    //   359: i2c
    //   360: invokevirtual 336	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   363: pop
    //   364: iload 7
    //   366: istore 5
    //   368: goto -52 -> 316
    //   371: aload_2
    //   372: invokevirtual 337	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   375: astore 9
    //   377: iload 7
    //   379: iload 4
    //   381: if_icmpge +71 -> 452
    //   384: aload 9
    //   386: invokevirtual 80	java/lang/String:length	()I
    //   389: ifne +6 -> 395
    //   392: goto +60 -> 452
    //   395: iload 7
    //   397: istore 5
    //   399: aload 8
    //   401: astore 10
    //   403: aload 9
    //   405: astore 6
    //   407: iload 7
    //   409: iload 4
    //   411: if_icmpge +64 -> 475
    //   414: aload_3
    //   415: iload 7
    //   417: baload
    //   418: istore 11
    //   420: iload 11
    //   422: bipush 32
    //   424: if_icmpeq +22 -> 446
    //   427: iload 7
    //   429: istore 5
    //   431: aload 8
    //   433: astore 10
    //   435: aload 9
    //   437: astore 6
    //   439: iload 11
    //   441: bipush 9
    //   443: if_icmpne +32 -> 475
    //   446: iinc 7 1
    //   449: goto -54 -> 395
    //   452: aload_0
    //   453: aload_3
    //   454: iconst_0
    //   455: iload 4
    //   457: invokestatic 327	com/jcraft/jsch/Util:byte2str	([BII)Ljava/lang/String;
    //   460: invokespecial 329	com/jcraft/jsch/KnownHosts:addInvalidLine	(Ljava/lang/String;)V
    //   463: goto +428 -> 891
    //   466: aload 8
    //   468: astore 6
    //   470: ldc_w 343
    //   473: astore 10
    //   475: aload_2
    //   476: iconst_0
    //   477: invokevirtual 333	java/lang/StringBuffer:setLength	(I)V
    //   480: iload 5
    //   482: istore 7
    //   484: iload 5
    //   486: iload 4
    //   488: if_icmpge +47 -> 535
    //   491: iload 5
    //   493: iconst_1
    //   494: iadd
    //   495: istore 7
    //   497: aload_3
    //   498: iload 5
    //   500: baload
    //   501: istore 5
    //   503: iload 5
    //   505: bipush 32
    //   507: if_icmpeq +28 -> 535
    //   510: iload 5
    //   512: bipush 9
    //   514: if_icmpne +6 -> 520
    //   517: goto +18 -> 535
    //   520: aload_2
    //   521: iload 5
    //   523: i2c
    //   524: invokevirtual 336	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   527: pop
    //   528: iload 7
    //   530: istore 5
    //   532: goto -52 -> 480
    //   535: aload_2
    //   536: invokevirtual 337	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   539: astore 8
    //   541: aload 8
    //   543: invokestatic 346	com/jcraft/jsch/HostKey:name2type	(Ljava/lang/String;)I
    //   546: bipush 6
    //   548: if_icmpeq +13 -> 561
    //   551: aload 8
    //   553: invokestatic 346	com/jcraft/jsch/HostKey:name2type	(Ljava/lang/String;)I
    //   556: istore 11
    //   558: goto +10 -> 568
    //   561: iload 4
    //   563: istore 7
    //   565: iconst_m1
    //   566: istore 11
    //   568: iload 7
    //   570: istore 5
    //   572: iload 7
    //   574: iload 4
    //   576: if_icmplt +17 -> 593
    //   579: aload_0
    //   580: aload_3
    //   581: iconst_0
    //   582: iload 4
    //   584: invokestatic 327	com/jcraft/jsch/Util:byte2str	([BII)Ljava/lang/String;
    //   587: invokespecial 329	com/jcraft/jsch/KnownHosts:addInvalidLine	(Ljava/lang/String;)V
    //   590: goto +301 -> 891
    //   593: iload 5
    //   595: iload 4
    //   597: if_icmpge +29 -> 626
    //   600: aload_3
    //   601: iload 5
    //   603: baload
    //   604: istore 7
    //   606: iload 7
    //   608: bipush 32
    //   610: if_icmpeq +10 -> 620
    //   613: iload 7
    //   615: bipush 9
    //   617: if_icmpne +9 -> 626
    //   620: iinc 5 1
    //   623: goto -30 -> 593
    //   626: aload_2
    //   627: iconst_0
    //   628: invokevirtual 333	java/lang/StringBuffer:setLength	(I)V
    //   631: iload 5
    //   633: istore 7
    //   635: iload 5
    //   637: iload 4
    //   639: if_icmpge +67 -> 706
    //   642: iload 5
    //   644: iconst_1
    //   645: iadd
    //   646: istore 7
    //   648: aload_3
    //   649: iload 5
    //   651: baload
    //   652: istore 5
    //   654: iload 5
    //   656: bipush 13
    //   658: if_icmpne +6 -> 664
    //   661: goto +38 -> 699
    //   664: iload 5
    //   666: bipush 10
    //   668: if_icmpne +6 -> 674
    //   671: goto +35 -> 706
    //   674: iload 5
    //   676: bipush 32
    //   678: if_icmpeq +28 -> 706
    //   681: iload 5
    //   683: bipush 9
    //   685: if_icmpne +6 -> 691
    //   688: goto +18 -> 706
    //   691: aload_2
    //   692: iload 5
    //   694: i2c
    //   695: invokevirtual 336	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   698: pop
    //   699: iload 7
    //   701: istore 5
    //   703: goto -72 -> 631
    //   706: aload_2
    //   707: invokevirtual 337	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   710: astore 9
    //   712: aload 9
    //   714: invokevirtual 80	java/lang/String:length	()I
    //   717: ifne +17 -> 734
    //   720: aload_0
    //   721: aload_3
    //   722: iconst_0
    //   723: iload 4
    //   725: invokestatic 327	com/jcraft/jsch/Util:byte2str	([BII)Ljava/lang/String;
    //   728: invokespecial 329	com/jcraft/jsch/KnownHosts:addInvalidLine	(Ljava/lang/String;)V
    //   731: goto +160 -> 891
    //   734: iload 7
    //   736: iload 4
    //   738: if_icmpge +29 -> 767
    //   741: aload_3
    //   742: iload 7
    //   744: baload
    //   745: istore 5
    //   747: iload 5
    //   749: bipush 32
    //   751: if_icmpeq +10 -> 761
    //   754: iload 5
    //   756: bipush 9
    //   758: if_icmpne +9 -> 767
    //   761: iinc 7 1
    //   764: goto -30 -> 734
    //   767: aconst_null
    //   768: astore 8
    //   770: iload 7
    //   772: iload 4
    //   774: if_icmpge +61 -> 835
    //   777: aload_2
    //   778: iconst_0
    //   779: invokevirtual 333	java/lang/StringBuffer:setLength	(I)V
    //   782: iload 7
    //   784: iload 4
    //   786: if_icmpge +43 -> 829
    //   789: aload_3
    //   790: iload 7
    //   792: baload
    //   793: istore 5
    //   795: iload 5
    //   797: bipush 13
    //   799: if_icmpne +6 -> 805
    //   802: goto +21 -> 823
    //   805: iload 5
    //   807: bipush 10
    //   809: if_icmpne +6 -> 815
    //   812: goto +17 -> 829
    //   815: aload_2
    //   816: iload 5
    //   818: i2c
    //   819: invokevirtual 336	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   822: pop
    //   823: iinc 7 1
    //   826: goto -44 -> 782
    //   829: aload_2
    //   830: invokevirtual 337	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   833: astore 8
    //   835: new 8	com/jcraft/jsch/KnownHosts$HashedHostKey
    //   838: astore 12
    //   840: aload 12
    //   842: aload_0
    //   843: aload 10
    //   845: aload 6
    //   847: iload 11
    //   849: aload 9
    //   851: invokestatic 34	com/jcraft/jsch/Util:str2byte	(Ljava/lang/String;)[B
    //   854: iconst_0
    //   855: aload 9
    //   857: invokevirtual 80	java/lang/String:length	()I
    //   860: invokestatic 350	com/jcraft/jsch/Util:fromBase64	([BII)[B
    //   863: aload 8
    //   865: invokespecial 353	com/jcraft/jsch/KnownHosts$HashedHostKey:<init>	(Lcom/jcraft/jsch/KnownHosts;Ljava/lang/String;Ljava/lang/String;I[BLjava/lang/String;)V
    //   868: aload_0
    //   869: getfield 47	com/jcraft/jsch/KnownHosts:pool	Ljava/util/Vector;
    //   872: aload 12
    //   874: invokevirtual 71	java/util/Vector:addElement	(Ljava/lang/Object;)V
    //   877: goto +14 -> 891
    //   880: aload_0
    //   881: aload_3
    //   882: iconst_0
    //   883: iload 4
    //   885: invokestatic 327	com/jcraft/jsch/Util:byte2str	([BII)Ljava/lang/String;
    //   888: invokespecial 329	com/jcraft/jsch/KnownHosts:addInvalidLine	(Ljava/lang/String;)V
    //   891: goto -870 -> 21
    //   894: aload_3
    //   895: arraylength
    //   896: iconst_2
    //   897: imul
    //   898: newarray <illegal type>
    //   900: astore 6
    //   902: aload_3
    //   903: iconst_0
    //   904: aload 6
    //   906: iconst_0
    //   907: aload_3
    //   908: arraylength
    //   909: invokestatic 284	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   912: aload 6
    //   914: iload 4
    //   916: iload 5
    //   918: i2b
    //   919: i2b
    //   920: bastore
    //   921: iinc 4 1
    //   924: aload 6
    //   926: astore_3
    //   927: goto -903 -> 24
    //   930: astore_3
    //   931: goto +34 -> 965
    //   934: astore_3
    //   935: aload_3
    //   936: instanceof 62
    //   939: ifne +21 -> 960
    //   942: new 62	com/jcraft/jsch/JSchException
    //   945: astore 6
    //   947: aload 6
    //   949: aload_3
    //   950: invokevirtual 354	java/lang/Exception:toString	()Ljava/lang/String;
    //   953: aload_3
    //   954: invokespecial 323	com/jcraft/jsch/JSchException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   957: aload 6
    //   959: athrow
    //   960: aload_3
    //   961: checkcast 62	com/jcraft/jsch/JSchException
    //   964: athrow
    //   965: aload_1
    //   966: invokevirtual 319	java/io/InputStream:close	()V
    //   969: aload_3
    //   970: athrow
    //   971: astore_1
    //   972: new 62	com/jcraft/jsch/JSchException
    //   975: dup
    //   976: aload_1
    //   977: invokevirtual 320	java/io/IOException:toString	()Ljava/lang/String;
    //   980: aload_1
    //   981: invokespecial 323	com/jcraft/jsch/JSchException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   984: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	985	0	this	KnownHosts
    //   0	985	1	paramInputStream	java.io.InputStream
    //   14	816	2	localStringBuffer	StringBuffer
    //   20	907	3	localObject1	Object
    //   930	1	3	localObject2	Object
    //   934	36	3	localException	Exception
    //   22	900	4	i	int
    //   28	889	5	j	int
    //   81	877	6	localObject3	Object
    //   112	712	7	k	int
    //   243	621	8	str1	String
    //   375	481	9	str2	String
    //   401	443	10	str3	String
    //   418	430	11	m	int
    //   838	35	12	localHashedHostKey	HashedHostKey
    // Exception table:
    //   from	to	target	type
    //   41	45	46	java/io/IOException
    //   15	21	930	finally
    //   24	30	930	finally
    //   83	90	930	finally
    //   138	149	930	finally
    //   165	176	930	finally
    //   179	184	930	finally
    //   224	232	930	finally
    //   239	245	930	finally
    //   256	264	930	finally
    //   300	316	930	finally
    //   356	364	930	finally
    //   371	377	930	finally
    //   384	392	930	finally
    //   452	463	930	finally
    //   475	480	930	finally
    //   520	528	930	finally
    //   535	558	930	finally
    //   579	590	930	finally
    //   626	631	930	finally
    //   691	699	930	finally
    //   706	712	930	finally
    //   712	731	930	finally
    //   777	782	930	finally
    //   815	823	930	finally
    //   829	835	930	finally
    //   835	877	930	finally
    //   880	891	930	finally
    //   894	912	930	finally
    //   935	960	930	finally
    //   960	965	930	finally
    //   15	21	934	java/lang/Exception
    //   24	30	934	java/lang/Exception
    //   83	90	934	java/lang/Exception
    //   138	149	934	java/lang/Exception
    //   165	176	934	java/lang/Exception
    //   179	184	934	java/lang/Exception
    //   224	232	934	java/lang/Exception
    //   239	245	934	java/lang/Exception
    //   256	264	934	java/lang/Exception
    //   300	316	934	java/lang/Exception
    //   356	364	934	java/lang/Exception
    //   371	377	934	java/lang/Exception
    //   384	392	934	java/lang/Exception
    //   452	463	934	java/lang/Exception
    //   475	480	934	java/lang/Exception
    //   520	528	934	java/lang/Exception
    //   535	558	934	java/lang/Exception
    //   579	590	934	java/lang/Exception
    //   626	631	934	java/lang/Exception
    //   691	699	934	java/lang/Exception
    //   706	712	934	java/lang/Exception
    //   712	731	934	java/lang/Exception
    //   777	782	934	java/lang/Exception
    //   815	823	934	java/lang/Exception
    //   829	835	934	java/lang/Exception
    //   835	877	934	java/lang/Exception
    //   880	891	934	java/lang/Exception
    //   894	912	934	java/lang/Exception
    //   965	969	971	java/io/IOException
  }
  
  void setKnownHosts(String paramString)
    throws JSchException
  {
    try
    {
      this.known_hosts = paramString;
      FileInputStream localFileInputStream = new java/io/FileInputStream;
      localFileInputStream.<init>(Util.checkTilde(paramString));
      setKnownHosts(localFileInputStream);
      return;
    }
    catch (FileNotFoundException paramString)
    {
      for (;;) {}
    }
  }
  
  protected void sync()
    throws IOException
  {
    String str = this.known_hosts;
    if (str != null) {
      sync(str);
    }
  }
  
  protected void sync(String paramString)
    throws IOException
  {
    if (paramString == null) {
      return;
    }
    try
    {
      FileOutputStream localFileOutputStream = new java/io/FileOutputStream;
      localFileOutputStream.<init>(Util.checkTilde(paramString));
      dump(localFileOutputStream);
      localFileOutputStream.close();
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  class HashedHostKey
    extends HostKey
  {
    private static final String HASH_DELIM = "|";
    private static final String HASH_MAGIC = "|1|";
    byte[] hash = null;
    private boolean hashed = false;
    byte[] salt = null;
    
    HashedHostKey(String paramString, int paramInt, byte[] paramArrayOfByte)
      throws JSchException
    {
      this("", paramString, paramInt, paramArrayOfByte, null);
    }
    
    HashedHostKey(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte, String paramString3)
      throws JSchException
    {
      super(paramString2, paramInt, paramArrayOfByte, paramString3);
      if ((this.host.startsWith("|1|")) && (this.host.substring(3).indexOf("|") > 0))
      {
        paramString1 = this.host.substring(3);
        this$1 = paramString1.substring(0, paramString1.indexOf("|"));
        paramString1 = paramString1.substring(paramString1.indexOf("|") + 1);
        this.salt = Util.fromBase64(Util.str2byte(KnownHosts.this), 0, KnownHosts.this.length());
        this$1 = Util.fromBase64(Util.str2byte(paramString1), 0, paramString1.length());
        this.hash = KnownHosts.this;
        if ((this.salt.length == 20) && (KnownHosts.this.length == 20))
        {
          this.hashed = true;
        }
        else
        {
          this.salt = null;
          this.hash = null;
        }
      }
    }
    
    HashedHostKey(String paramString, byte[] paramArrayOfByte)
      throws JSchException
    {
      this(paramString, 0, paramArrayOfByte);
    }
    
    void hash()
    {
      if (this.hashed) {
        return;
      }
      MAC localMAC = KnownHosts.this.getHMACSHA1();
      if (this.salt == null) {
        synchronized (Session.random)
        {
          byte[] arrayOfByte2 = new byte[localMAC.getBlockSize()];
          this.salt = arrayOfByte2;
          ((Random)???).fill(arrayOfByte2, 0, arrayOfByte2.length);
        }
      }
      try
      {
        try
        {
          ((MAC)localObject1).init(this.salt);
          ??? = Util.str2byte(this.host);
          ((MAC)localObject1).update((byte[])???, 0, ???.length);
          ??? = new byte[((MAC)localObject1).getBlockSize()];
          this.hash = ((byte[])???);
          ((MAC)localObject1).doFinal((byte[])???, 0);
        }
        finally {}
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder;
        byte[] arrayOfByte1;
        for (;;) {}
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("|1|");
      arrayOfByte1 = this.salt;
      localStringBuilder.append(Util.byte2str(Util.toBase64(arrayOfByte1, 0, arrayOfByte1.length)));
      localStringBuilder.append("|");
      arrayOfByte1 = this.hash;
      localStringBuilder.append(Util.byte2str(Util.toBase64(arrayOfByte1, 0, arrayOfByte1.length)));
      this.host = localStringBuilder.toString();
      this.hashed = true;
    }
    
    boolean isHashed()
    {
      return this.hashed;
    }
    
    boolean isMatched(String paramString)
    {
      if (!this.hashed) {
        return super.isMatched(paramString);
      }
      try
      {
        synchronized (KnownHosts.this.getHMACSHA1())
        {
          ???.init(this.salt);
          paramString = Util.str2byte(paramString);
          ???.update(paramString, 0, paramString.length);
          paramString = new byte[???.getBlockSize()];
          ???.doFinal(paramString, 0);
          boolean bool = Util.array_equals(this.hash, paramString);
          return bool;
        }
        return false;
      }
      catch (Exception paramString)
      {
        System.out.println(paramString);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\KnownHosts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */