package io.netty.handler.ssl;

import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLException;
import javax.net.ssl.X509KeyManager;

class OpenSslKeyMaterialProvider
{
  private final X509KeyManager keyManager;
  private final String password;
  
  OpenSslKeyMaterialProvider(X509KeyManager paramX509KeyManager, String paramString)
  {
    this.keyManager = paramX509KeyManager;
    this.password = paramString;
  }
  
  static void validateKeyMaterialSupported(X509Certificate[] paramArrayOfX509Certificate, PrivateKey paramPrivateKey, String paramString)
    throws SSLException
  {
    validateSupported(paramArrayOfX509Certificate);
    validateSupported(paramPrivateKey, paramString);
  }
  
  /* Error */
  private static void validateSupported(PrivateKey paramPrivateKey, String paramString)
    throws SSLException
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: lconst_0
    //   6: lstore_2
    //   7: lload_2
    //   8: lstore 4
    //   10: getstatic 38	io/netty/buffer/UnpooledByteBufAllocator:DEFAULT	Lio/netty/buffer/UnpooledByteBufAllocator;
    //   13: aload_0
    //   14: invokestatic 44	io/netty/handler/ssl/ReferenceCountedOpenSslContext:toBIO	(Lio/netty/buffer/ByteBufAllocator;Ljava/security/PrivateKey;)J
    //   17: lstore 6
    //   19: lload 6
    //   21: aload_1
    //   22: invokestatic 50	io/netty/internal/tcnative/SSL:parsePrivateKey	(JLjava/lang/String;)J
    //   25: lstore 4
    //   27: lload 6
    //   29: invokestatic 54	io/netty/internal/tcnative/SSL:freeBIO	(J)V
    //   32: lload 4
    //   34: lconst_0
    //   35: lcmp
    //   36: ifeq +8 -> 44
    //   39: lload 4
    //   41: invokestatic 57	io/netty/internal/tcnative/SSL:freePrivateKey	(J)V
    //   44: return
    //   45: astore_0
    //   46: lload 6
    //   48: lstore 4
    //   50: goto +92 -> 142
    //   53: astore_1
    //   54: goto +11 -> 65
    //   57: astore_0
    //   58: goto +84 -> 142
    //   61: astore_1
    //   62: lload_2
    //   63: lstore 6
    //   65: lload 6
    //   67: lstore 4
    //   69: new 22	javax/net/ssl/SSLException
    //   72: astore 8
    //   74: lload 6
    //   76: lstore 4
    //   78: new 59	java/lang/StringBuilder
    //   81: astore 9
    //   83: lload 6
    //   85: lstore 4
    //   87: aload 9
    //   89: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   92: lload 6
    //   94: lstore 4
    //   96: aload 9
    //   98: ldc 62
    //   100: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: lload 6
    //   106: lstore 4
    //   108: aload 9
    //   110: aload_0
    //   111: invokeinterface 72 1 0
    //   116: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: lload 6
    //   122: lstore 4
    //   124: aload 8
    //   126: aload 9
    //   128: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: aload_1
    //   132: invokespecial 78	javax/net/ssl/SSLException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   135: lload 6
    //   137: lstore 4
    //   139: aload 8
    //   141: athrow
    //   142: lload 4
    //   144: invokestatic 54	io/netty/internal/tcnative/SSL:freeBIO	(J)V
    //   147: aload_0
    //   148: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	paramPrivateKey	PrivateKey
    //   0	149	1	paramString	String
    //   6	57	2	l1	long
    //   8	135	4	l2	long
    //   17	119	6	l3	long
    //   72	68	8	localSSLException	SSLException
    //   81	46	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   19	27	45	finally
    //   19	27	53	java/lang/Exception
    //   10	19	57	finally
    //   69	74	57	finally
    //   78	83	57	finally
    //   87	92	57	finally
    //   96	104	57	finally
    //   108	120	57	finally
    //   124	135	57	finally
    //   139	142	57	finally
    //   10	19	61	java/lang/Exception
  }
  
  /* Error */
  private static void validateSupported(X509Certificate[] paramArrayOfX509Certificate)
    throws SSLException
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +190 -> 191
    //   4: aload_0
    //   5: arraylength
    //   6: ifne +6 -> 12
    //   9: goto +182 -> 191
    //   12: aconst_null
    //   13: astore_1
    //   14: aconst_null
    //   15: astore_2
    //   16: lconst_0
    //   17: lstore_3
    //   18: aload_2
    //   19: astore 5
    //   21: lload_3
    //   22: lstore 6
    //   24: aload_1
    //   25: astore 8
    //   27: getstatic 38	io/netty/buffer/UnpooledByteBufAllocator:DEFAULT	Lio/netty/buffer/UnpooledByteBufAllocator;
    //   30: astore 9
    //   32: aload_2
    //   33: astore 5
    //   35: lload_3
    //   36: lstore 6
    //   38: aload_1
    //   39: astore 8
    //   41: aload 9
    //   43: iconst_1
    //   44: aload_0
    //   45: invokestatic 84	io/netty/handler/ssl/PemX509Certificate:toPEM	(Lio/netty/buffer/ByteBufAllocator;Z[Ljava/security/cert/X509Certificate;)Lio/netty/handler/ssl/PemEncoded;
    //   48: astore_0
    //   49: aload_0
    //   50: astore 5
    //   52: lload_3
    //   53: lstore 6
    //   55: aload_0
    //   56: astore 8
    //   58: aload 9
    //   60: aload_0
    //   61: invokeinterface 90 1 0
    //   66: invokestatic 93	io/netty/handler/ssl/ReferenceCountedOpenSslContext:toBIO	(Lio/netty/buffer/ByteBufAllocator;Lio/netty/handler/ssl/PemEncoded;)J
    //   69: lstore 10
    //   71: lload 10
    //   73: invokestatic 97	io/netty/internal/tcnative/SSL:parseX509Chain	(J)J
    //   76: lstore 6
    //   78: lload 10
    //   80: invokestatic 54	io/netty/internal/tcnative/SSL:freeBIO	(J)V
    //   83: lload 6
    //   85: lconst_0
    //   86: lcmp
    //   87: ifeq +8 -> 95
    //   90: lload 6
    //   92: invokestatic 100	io/netty/internal/tcnative/SSL:freeX509Chain	(J)V
    //   95: aload_0
    //   96: invokeinterface 106 1 0
    //   101: pop
    //   102: return
    //   103: astore 5
    //   105: lload 10
    //   107: lstore 6
    //   109: goto +63 -> 172
    //   112: astore_2
    //   113: goto +22 -> 135
    //   116: astore 8
    //   118: aload 5
    //   120: astore_0
    //   121: aload 8
    //   123: astore 5
    //   125: goto +47 -> 172
    //   128: astore_2
    //   129: lload_3
    //   130: lstore 10
    //   132: aload 8
    //   134: astore_0
    //   135: aload_0
    //   136: astore 5
    //   138: lload 10
    //   140: lstore 6
    //   142: new 22	javax/net/ssl/SSLException
    //   145: astore 8
    //   147: aload_0
    //   148: astore 5
    //   150: lload 10
    //   152: lstore 6
    //   154: aload 8
    //   156: ldc 108
    //   158: aload_2
    //   159: invokespecial 78	javax/net/ssl/SSLException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   162: aload_0
    //   163: astore 5
    //   165: lload 10
    //   167: lstore 6
    //   169: aload 8
    //   171: athrow
    //   172: lload 6
    //   174: invokestatic 54	io/netty/internal/tcnative/SSL:freeBIO	(J)V
    //   177: aload_0
    //   178: ifnull +10 -> 188
    //   181: aload_0
    //   182: invokeinterface 106 1 0
    //   187: pop
    //   188: aload 5
    //   190: athrow
    //   191: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	paramArrayOfX509Certificate	X509Certificate[]
    //   13	26	1	localObject1	Object
    //   15	18	2	localObject2	Object
    //   112	1	2	localException1	Exception
    //   128	31	2	localException2	Exception
    //   17	113	3	l1	long
    //   19	32	5	localObject3	Object
    //   103	16	5	localObject4	Object
    //   123	66	5	localObject5	Object
    //   22	151	6	l2	long
    //   25	32	8	localObject6	Object
    //   116	17	8	localObject7	Object
    //   145	25	8	localSSLException	SSLException
    //   30	29	9	localUnpooledByteBufAllocator	io.netty.buffer.UnpooledByteBufAllocator
    //   69	97	10	l3	long
    // Exception table:
    //   from	to	target	type
    //   71	78	103	finally
    //   71	78	112	java/lang/Exception
    //   27	32	116	finally
    //   41	49	116	finally
    //   58	71	116	finally
    //   142	147	116	finally
    //   154	162	116	finally
    //   169	172	116	finally
    //   27	32	128	java/lang/Exception
    //   41	49	128	java/lang/Exception
    //   58	71	128	java/lang/Exception
  }
  
  /* Error */
  OpenSslKeyMaterial chooseKeyMaterial(io.netty.buffer.ByteBufAllocator arg1, String arg2)
    throws java.lang.Exception
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 15	io/netty/handler/ssl/OpenSslKeyMaterialProvider:keyManager	Ljavax/net/ssl/X509KeyManager;
    //   4: aload_2
    //   5: invokeinterface 116 2 0
    //   10: astore_3
    //   11: aload_3
    //   12: ifnull +235 -> 247
    //   15: aload_3
    //   16: arraylength
    //   17: ifne +6 -> 23
    //   20: goto +227 -> 247
    //   23: aload_0
    //   24: getfield 15	io/netty/handler/ssl/OpenSslKeyMaterialProvider:keyManager	Ljavax/net/ssl/X509KeyManager;
    //   27: aload_2
    //   28: invokeinterface 120 2 0
    //   33: astore 4
    //   35: aload_1
    //   36: iconst_1
    //   37: aload_3
    //   38: invokestatic 84	io/netty/handler/ssl/PemX509Certificate:toPEM	(Lio/netty/buffer/ByteBufAllocator;Z[Ljava/security/cert/X509Certificate;)Lio/netty/handler/ssl/PemEncoded;
    //   41: astore_2
    //   42: lconst_0
    //   43: lstore 5
    //   45: aload_1
    //   46: aload_2
    //   47: invokeinterface 90 1 0
    //   52: invokestatic 93	io/netty/handler/ssl/ReferenceCountedOpenSslContext:toBIO	(Lio/netty/buffer/ByteBufAllocator;Lio/netty/handler/ssl/PemEncoded;)J
    //   55: lstore 7
    //   57: lload 7
    //   59: invokestatic 97	io/netty/internal/tcnative/SSL:parseX509Chain	(J)J
    //   62: lstore 9
    //   64: aload 4
    //   66: instanceof 122
    //   69: ifeq +18 -> 87
    //   72: aload 4
    //   74: checkcast 122	io/netty/handler/ssl/OpenSslPrivateKey
    //   77: lload 9
    //   79: aload_3
    //   80: invokevirtual 126	io/netty/handler/ssl/OpenSslPrivateKey:newKeyMaterial	(J[Ljava/security/cert/X509Certificate;)Lio/netty/handler/ssl/OpenSslKeyMaterial;
    //   83: astore_1
    //   84: goto +46 -> 130
    //   87: aload_1
    //   88: aload 4
    //   90: invokestatic 44	io/netty/handler/ssl/ReferenceCountedOpenSslContext:toBIO	(Lio/netty/buffer/ByteBufAllocator;Ljava/security/PrivateKey;)J
    //   93: lstore 5
    //   95: aload 4
    //   97: ifnonnull +9 -> 106
    //   100: lconst_0
    //   101: lstore 11
    //   103: goto +14 -> 117
    //   106: lload 5
    //   108: aload_0
    //   109: getfield 17	io/netty/handler/ssl/OpenSslKeyMaterialProvider:password	Ljava/lang/String;
    //   112: invokestatic 50	io/netty/internal/tcnative/SSL:parsePrivateKey	(JLjava/lang/String;)J
    //   115: lstore 11
    //   117: new 128	io/netty/handler/ssl/DefaultOpenSslKeyMaterial
    //   120: dup
    //   121: lload 9
    //   123: lload 11
    //   125: aload_3
    //   126: invokespecial 131	io/netty/handler/ssl/DefaultOpenSslKeyMaterial:<init>	(JJ[Ljava/security/cert/X509Certificate;)V
    //   129: astore_1
    //   130: lload 7
    //   132: invokestatic 54	io/netty/internal/tcnative/SSL:freeBIO	(J)V
    //   135: lload 5
    //   137: invokestatic 54	io/netty/internal/tcnative/SSL:freeBIO	(J)V
    //   140: aload_2
    //   141: invokeinterface 106 1 0
    //   146: pop
    //   147: aload_1
    //   148: areturn
    //   149: astore_1
    //   150: goto +54 -> 204
    //   153: astore_1
    //   154: goto +50 -> 204
    //   157: astore_1
    //   158: lconst_0
    //   159: lstore 11
    //   161: goto +43 -> 204
    //   164: astore_1
    //   165: lconst_0
    //   166: lstore 5
    //   168: lload 5
    //   170: lstore 11
    //   172: goto +32 -> 204
    //   175: astore_1
    //   176: lload 7
    //   178: lstore 5
    //   180: goto +7 -> 187
    //   183: astore_1
    //   184: lconst_0
    //   185: lstore 5
    //   187: lconst_0
    //   188: lstore 9
    //   190: lconst_0
    //   191: lstore 13
    //   193: lconst_0
    //   194: lstore 11
    //   196: lload 5
    //   198: lstore 7
    //   200: lload 13
    //   202: lstore 5
    //   204: lload 7
    //   206: invokestatic 54	io/netty/internal/tcnative/SSL:freeBIO	(J)V
    //   209: lload 5
    //   211: invokestatic 54	io/netty/internal/tcnative/SSL:freeBIO	(J)V
    //   214: lload 9
    //   216: lconst_0
    //   217: lcmp
    //   218: ifeq +8 -> 226
    //   221: lload 9
    //   223: invokestatic 100	io/netty/internal/tcnative/SSL:freeX509Chain	(J)V
    //   226: lload 11
    //   228: lconst_0
    //   229: lcmp
    //   230: ifeq +8 -> 238
    //   233: lload 11
    //   235: invokestatic 57	io/netty/internal/tcnative/SSL:freePrivateKey	(J)V
    //   238: aload_2
    //   239: invokeinterface 106 1 0
    //   244: pop
    //   245: aload_1
    //   246: athrow
    //   247: aconst_null
    //   248: areturn
    // Exception table:
    //   from	to	target	type
    //   117	130	149	finally
    //   106	117	157	finally
    //   64	84	164	finally
    //   87	95	164	finally
    //   57	64	175	finally
    //   45	57	183	finally
  }
  
  void destroy() {}
  
  X509KeyManager keyManager()
  {
    return this.keyManager;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\OpenSslKeyMaterialProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */