package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.o0;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public final class RawResourceDataSource
  extends h
{
  private final Resources f;
  private final String g;
  @Nullable
  private Uri h;
  @Nullable
  private AssetFileDescriptor i;
  @Nullable
  private InputStream j;
  private long k;
  private boolean l;
  
  public RawResourceDataSource(Context paramContext)
  {
    super(false);
    this.f = paramContext.getResources();
    this.g = paramContext.getPackageName();
  }
  
  public static Uri buildRawResourceUri(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(26);
    localStringBuilder.append("rawresource:///");
    localStringBuilder.append(paramInt);
    return Uri.parse(localStringBuilder.toString());
  }
  
  /* Error */
  public void close()
    throws RawResourceDataSource.RawResourceDataSourceException
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: putfield 73	com/google/android/exoplayer2/upstream/RawResourceDataSource:h	Landroid/net/Uri;
    //   5: aload_0
    //   6: getfield 75	com/google/android/exoplayer2/upstream/RawResourceDataSource:j	Ljava/io/InputStream;
    //   9: astore_1
    //   10: aload_1
    //   11: ifnull +7 -> 18
    //   14: aload_1
    //   15: invokevirtual 79	java/io/InputStream:close	()V
    //   18: aload_0
    //   19: aconst_null
    //   20: putfield 75	com/google/android/exoplayer2/upstream/RawResourceDataSource:j	Ljava/io/InputStream;
    //   23: aload_0
    //   24: getfield 81	com/google/android/exoplayer2/upstream/RawResourceDataSource:i	Landroid/content/res/AssetFileDescriptor;
    //   27: astore_1
    //   28: aload_1
    //   29: ifnull +7 -> 36
    //   32: aload_1
    //   33: invokevirtual 84	android/content/res/AssetFileDescriptor:close	()V
    //   36: aload_0
    //   37: aconst_null
    //   38: putfield 81	com/google/android/exoplayer2/upstream/RawResourceDataSource:i	Landroid/content/res/AssetFileDescriptor;
    //   41: aload_0
    //   42: getfield 86	com/google/android/exoplayer2/upstream/RawResourceDataSource:l	Z
    //   45: ifeq +12 -> 57
    //   48: aload_0
    //   49: iconst_0
    //   50: putfield 86	com/google/android/exoplayer2/upstream/RawResourceDataSource:l	Z
    //   53: aload_0
    //   54: invokevirtual 89	com/google/android/exoplayer2/upstream/h:p	()V
    //   57: return
    //   58: astore_1
    //   59: goto +19 -> 78
    //   62: astore_1
    //   63: new 6	com/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException
    //   66: astore_2
    //   67: aload_2
    //   68: aconst_null
    //   69: aload_1
    //   70: sipush 2000
    //   73: invokespecial 92	com/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;I)V
    //   76: aload_2
    //   77: athrow
    //   78: aload_0
    //   79: aconst_null
    //   80: putfield 81	com/google/android/exoplayer2/upstream/RawResourceDataSource:i	Landroid/content/res/AssetFileDescriptor;
    //   83: aload_0
    //   84: getfield 86	com/google/android/exoplayer2/upstream/RawResourceDataSource:l	Z
    //   87: ifeq +12 -> 99
    //   90: aload_0
    //   91: iconst_0
    //   92: putfield 86	com/google/android/exoplayer2/upstream/RawResourceDataSource:l	Z
    //   95: aload_0
    //   96: invokevirtual 89	com/google/android/exoplayer2/upstream/h:p	()V
    //   99: aload_1
    //   100: athrow
    //   101: astore_2
    //   102: goto +19 -> 121
    //   105: astore_2
    //   106: new 6	com/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException
    //   109: astore_1
    //   110: aload_1
    //   111: aconst_null
    //   112: aload_2
    //   113: sipush 2000
    //   116: invokespecial 92	com/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;I)V
    //   119: aload_1
    //   120: athrow
    //   121: aload_0
    //   122: aconst_null
    //   123: putfield 75	com/google/android/exoplayer2/upstream/RawResourceDataSource:j	Ljava/io/InputStream;
    //   126: aload_0
    //   127: getfield 81	com/google/android/exoplayer2/upstream/RawResourceDataSource:i	Landroid/content/res/AssetFileDescriptor;
    //   130: astore_1
    //   131: aload_1
    //   132: ifnull +7 -> 139
    //   135: aload_1
    //   136: invokevirtual 84	android/content/res/AssetFileDescriptor:close	()V
    //   139: aload_0
    //   140: aconst_null
    //   141: putfield 81	com/google/android/exoplayer2/upstream/RawResourceDataSource:i	Landroid/content/res/AssetFileDescriptor;
    //   144: aload_0
    //   145: getfield 86	com/google/android/exoplayer2/upstream/RawResourceDataSource:l	Z
    //   148: ifeq +12 -> 160
    //   151: aload_0
    //   152: iconst_0
    //   153: putfield 86	com/google/android/exoplayer2/upstream/RawResourceDataSource:l	Z
    //   156: aload_0
    //   157: invokevirtual 89	com/google/android/exoplayer2/upstream/h:p	()V
    //   160: aload_2
    //   161: athrow
    //   162: astore_1
    //   163: goto +19 -> 182
    //   166: astore_2
    //   167: new 6	com/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException
    //   170: astore_1
    //   171: aload_1
    //   172: aconst_null
    //   173: aload_2
    //   174: sipush 2000
    //   177: invokespecial 92	com/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;I)V
    //   180: aload_1
    //   181: athrow
    //   182: aload_0
    //   183: aconst_null
    //   184: putfield 81	com/google/android/exoplayer2/upstream/RawResourceDataSource:i	Landroid/content/res/AssetFileDescriptor;
    //   187: aload_0
    //   188: getfield 86	com/google/android/exoplayer2/upstream/RawResourceDataSource:l	Z
    //   191: ifeq +12 -> 203
    //   194: aload_0
    //   195: iconst_0
    //   196: putfield 86	com/google/android/exoplayer2/upstream/RawResourceDataSource:l	Z
    //   199: aload_0
    //   200: invokevirtual 89	com/google/android/exoplayer2/upstream/h:p	()V
    //   203: aload_1
    //   204: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	this	RawResourceDataSource
    //   9	24	1	localObject1	Object
    //   58	1	1	localObject2	Object
    //   62	38	1	localIOException1	IOException
    //   109	27	1	localObject3	Object
    //   162	1	1	localObject4	Object
    //   170	34	1	localRawResourceDataSourceException1	RawResourceDataSourceException
    //   66	11	2	localRawResourceDataSourceException2	RawResourceDataSourceException
    //   101	1	2	localObject5	Object
    //   105	56	2	localIOException2	IOException
    //   166	8	2	localIOException3	IOException
    // Exception table:
    //   from	to	target	type
    //   23	28	58	finally
    //   32	36	58	finally
    //   63	78	58	finally
    //   23	28	62	java/io/IOException
    //   32	36	62	java/io/IOException
    //   5	10	101	finally
    //   14	18	101	finally
    //   106	121	101	finally
    //   5	10	105	java/io/IOException
    //   14	18	105	java/io/IOException
    //   126	131	162	finally
    //   135	139	162	finally
    //   167	182	162	finally
    //   126	131	166	java/io/IOException
    //   135	139	166	java/io/IOException
  }
  
  @Nullable
  public Uri getUri()
  {
    return this.h;
  }
  
  /* Error */
  public long j(n paramn)
    throws RawResourceDataSource.RawResourceDataSourceException
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 106	com/google/android/exoplayer2/upstream/n:a	Landroid/net/Uri;
    //   4: astore_2
    //   5: aload_0
    //   6: aload_2
    //   7: putfield 73	com/google/android/exoplayer2/upstream/RawResourceDataSource:h	Landroid/net/Uri;
    //   10: ldc 108
    //   12: aload_2
    //   13: invokevirtual 111	android/net/Uri:getScheme	()Ljava/lang/String;
    //   16: invokestatic 117	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   19: ifne +213 -> 232
    //   22: ldc 119
    //   24: aload_2
    //   25: invokevirtual 111	android/net/Uri:getScheme	()Ljava/lang/String;
    //   28: invokestatic 117	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   31: ifeq +37 -> 68
    //   34: aload_2
    //   35: invokevirtual 123	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   38: invokeinterface 129 1 0
    //   43: iconst_1
    //   44: if_icmpne +24 -> 68
    //   47: aload_2
    //   48: invokevirtual 132	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   51: invokestatic 138	com/google/android/exoplayer2/util/g:e	(Ljava/lang/Object;)Ljava/lang/Object;
    //   54: checkcast 140	java/lang/String
    //   57: ldc -114
    //   59: invokevirtual 146	java/lang/String:matches	(Ljava/lang/String;)Z
    //   62: ifeq +6 -> 68
    //   65: goto +167 -> 232
    //   68: ldc 119
    //   70: aload_2
    //   71: invokevirtual 111	android/net/Uri:getScheme	()Ljava/lang/String;
    //   74: invokestatic 117	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   77: ifeq +141 -> 218
    //   80: aload_2
    //   81: invokevirtual 149	android/net/Uri:getPath	()Ljava/lang/String;
    //   84: invokestatic 138	com/google/android/exoplayer2/util/g:e	(Ljava/lang/Object;)Ljava/lang/Object;
    //   87: checkcast 140	java/lang/String
    //   90: astore_3
    //   91: aload_3
    //   92: astore 4
    //   94: aload_3
    //   95: ldc -105
    //   97: invokevirtual 154	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   100: ifeq +10 -> 110
    //   103: aload_3
    //   104: iconst_1
    //   105: invokevirtual 158	java/lang/String:substring	(I)Ljava/lang/String;
    //   108: astore 4
    //   110: aload_2
    //   111: invokevirtual 161	android/net/Uri:getHost	()Ljava/lang/String;
    //   114: astore_3
    //   115: aload_3
    //   116: invokestatic 165	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   119: ifeq +9 -> 128
    //   122: ldc -89
    //   124: astore_3
    //   125: goto +13 -> 138
    //   128: aload_3
    //   129: invokestatic 171	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   132: ldc -83
    //   134: invokevirtual 177	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   137: astore_3
    //   138: aload_3
    //   139: invokestatic 171	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   142: astore_3
    //   143: aload 4
    //   145: invokestatic 171	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   148: astore 4
    //   150: aload 4
    //   152: invokevirtual 180	java/lang/String:length	()I
    //   155: ifeq +14 -> 169
    //   158: aload_3
    //   159: aload 4
    //   161: invokevirtual 177	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   164: astore 4
    //   166: goto +13 -> 179
    //   169: new 140	java/lang/String
    //   172: dup
    //   173: aload_3
    //   174: invokespecial 183	java/lang/String:<init>	(Ljava/lang/String;)V
    //   177: astore 4
    //   179: aload_0
    //   180: getfield 35	com/google/android/exoplayer2/upstream/RawResourceDataSource:f	Landroid/content/res/Resources;
    //   183: aload 4
    //   185: ldc -71
    //   187: aload_0
    //   188: getfield 41	com/google/android/exoplayer2/upstream/RawResourceDataSource:g	Ljava/lang/String;
    //   191: invokevirtual 191	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   194: istore 5
    //   196: iload 5
    //   198: ifeq +6 -> 204
    //   201: goto +46 -> 247
    //   204: new 6	com/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException
    //   207: dup
    //   208: ldc -63
    //   210: aconst_null
    //   211: sipush 2005
    //   214: invokespecial 92	com/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;I)V
    //   217: athrow
    //   218: new 6	com/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException
    //   221: dup
    //   222: ldc -61
    //   224: aconst_null
    //   225: sipush 1004
    //   228: invokespecial 92	com/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;I)V
    //   231: athrow
    //   232: aload_2
    //   233: invokevirtual 132	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   236: invokestatic 138	com/google/android/exoplayer2/util/g:e	(Ljava/lang/Object;)Ljava/lang/Object;
    //   239: checkcast 140	java/lang/String
    //   242: invokestatic 201	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   245: istore 5
    //   247: aload_0
    //   248: aload_1
    //   249: invokevirtual 205	com/google/android/exoplayer2/upstream/h:q	(Lcom/google/android/exoplayer2/upstream/n;)V
    //   252: aload_0
    //   253: getfield 35	com/google/android/exoplayer2/upstream/RawResourceDataSource:f	Landroid/content/res/Resources;
    //   256: iload 5
    //   258: invokevirtual 209	android/content/res/Resources:openRawResourceFd	(I)Landroid/content/res/AssetFileDescriptor;
    //   261: astore 4
    //   263: aload_0
    //   264: aload 4
    //   266: putfield 81	com/google/android/exoplayer2/upstream/RawResourceDataSource:i	Landroid/content/res/AssetFileDescriptor;
    //   269: aload 4
    //   271: ifnull +327 -> 598
    //   274: aload 4
    //   276: invokevirtual 213	android/content/res/AssetFileDescriptor:getLength	()J
    //   279: lstore 6
    //   281: new 215	java/io/FileInputStream
    //   284: dup
    //   285: aload 4
    //   287: invokevirtual 219	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   290: invokespecial 222	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   293: astore_3
    //   294: aload_0
    //   295: aload_3
    //   296: putfield 75	com/google/android/exoplayer2/upstream/RawResourceDataSource:j	Ljava/io/InputStream;
    //   299: lload 6
    //   301: ldc2_w 223
    //   304: lcmp
    //   305: istore 5
    //   307: iload 5
    //   309: ifeq +31 -> 340
    //   312: aload_1
    //   313: getfield 226	com/google/android/exoplayer2/upstream/n:g	J
    //   316: lload 6
    //   318: lcmp
    //   319: ifgt +6 -> 325
    //   322: goto +18 -> 340
    //   325: new 6	com/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException
    //   328: astore_1
    //   329: aload_1
    //   330: aconst_null
    //   331: aconst_null
    //   332: sipush 2008
    //   335: invokespecial 92	com/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;I)V
    //   338: aload_1
    //   339: athrow
    //   340: aload 4
    //   342: invokevirtual 229	android/content/res/AssetFileDescriptor:getStartOffset	()J
    //   345: lstore 8
    //   347: aload_3
    //   348: aload_1
    //   349: getfield 226	com/google/android/exoplayer2/upstream/n:g	J
    //   352: lload 8
    //   354: ladd
    //   355: invokevirtual 233	java/io/FileInputStream:skip	(J)J
    //   358: lload 8
    //   360: lsub
    //   361: lstore 8
    //   363: lload 8
    //   365: aload_1
    //   366: getfield 226	com/google/android/exoplayer2/upstream/n:g	J
    //   369: lcmp
    //   370: ifne +196 -> 566
    //   373: iload 5
    //   375: ifne +73 -> 448
    //   378: aload_3
    //   379: invokevirtual 237	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   382: astore 4
    //   384: aload 4
    //   386: invokevirtual 241	java/nio/channels/FileChannel:size	()J
    //   389: lconst_0
    //   390: lcmp
    //   391: ifne +13 -> 404
    //   394: aload_0
    //   395: ldc2_w 223
    //   398: putfield 243	com/google/android/exoplayer2/upstream/RawResourceDataSource:k	J
    //   401: goto +67 -> 468
    //   404: aload 4
    //   406: invokevirtual 241	java/nio/channels/FileChannel:size	()J
    //   409: aload 4
    //   411: invokevirtual 246	java/nio/channels/FileChannel:position	()J
    //   414: lsub
    //   415: lstore 6
    //   417: aload_0
    //   418: lload 6
    //   420: putfield 243	com/google/android/exoplayer2/upstream/RawResourceDataSource:k	J
    //   423: lload 6
    //   425: lconst_0
    //   426: lcmp
    //   427: iflt +6 -> 433
    //   430: goto +38 -> 468
    //   433: new 6	com/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException
    //   436: astore_1
    //   437: aload_1
    //   438: aconst_null
    //   439: aconst_null
    //   440: sipush 2008
    //   443: invokespecial 92	com/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;I)V
    //   446: aload_1
    //   447: athrow
    //   448: lload 6
    //   450: lload 8
    //   452: lsub
    //   453: lstore 6
    //   455: aload_0
    //   456: lload 6
    //   458: putfield 243	com/google/android/exoplayer2/upstream/RawResourceDataSource:k	J
    //   461: lload 6
    //   463: lconst_0
    //   464: lcmp
    //   465: iflt +88 -> 553
    //   468: aload_1
    //   469: getfield 248	com/google/android/exoplayer2/upstream/n:h	J
    //   472: lstore 6
    //   474: lload 6
    //   476: ldc2_w 223
    //   479: lcmp
    //   480: ifeq +36 -> 516
    //   483: aload_0
    //   484: getfield 243	com/google/android/exoplayer2/upstream/RawResourceDataSource:k	J
    //   487: lstore 8
    //   489: lload 8
    //   491: ldc2_w 223
    //   494: lcmp
    //   495: ifne +6 -> 501
    //   498: goto +12 -> 510
    //   501: lload 8
    //   503: lload 6
    //   505: invokestatic 254	java/lang/Math:min	(JJ)J
    //   508: lstore 6
    //   510: aload_0
    //   511: lload 6
    //   513: putfield 243	com/google/android/exoplayer2/upstream/RawResourceDataSource:k	J
    //   516: aload_0
    //   517: iconst_1
    //   518: putfield 86	com/google/android/exoplayer2/upstream/RawResourceDataSource:l	Z
    //   521: aload_0
    //   522: aload_1
    //   523: invokevirtual 257	com/google/android/exoplayer2/upstream/h:r	(Lcom/google/android/exoplayer2/upstream/n;)V
    //   526: aload_1
    //   527: getfield 248	com/google/android/exoplayer2/upstream/n:h	J
    //   530: lstore 6
    //   532: lload 6
    //   534: ldc2_w 223
    //   537: lcmp
    //   538: ifeq +6 -> 544
    //   541: goto +9 -> 550
    //   544: aload_0
    //   545: getfield 243	com/google/android/exoplayer2/upstream/RawResourceDataSource:k	J
    //   548: lstore 6
    //   550: lload 6
    //   552: lreturn
    //   553: new 259	com/google/android/exoplayer2/upstream/DataSourceException
    //   556: astore_1
    //   557: aload_1
    //   558: sipush 2008
    //   561: invokespecial 260	com/google/android/exoplayer2/upstream/DataSourceException:<init>	(I)V
    //   564: aload_1
    //   565: athrow
    //   566: new 6	com/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException
    //   569: astore_1
    //   570: aload_1
    //   571: aconst_null
    //   572: aconst_null
    //   573: sipush 2008
    //   576: invokespecial 92	com/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;I)V
    //   579: aload_1
    //   580: athrow
    //   581: astore_1
    //   582: new 6	com/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException
    //   585: dup
    //   586: aconst_null
    //   587: aload_1
    //   588: sipush 2000
    //   591: invokespecial 92	com/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;I)V
    //   594: athrow
    //   595: astore_1
    //   596: aload_1
    //   597: athrow
    //   598: aload_2
    //   599: invokestatic 171	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   602: astore_1
    //   603: new 46	java/lang/StringBuilder
    //   606: dup
    //   607: aload_1
    //   608: invokevirtual 180	java/lang/String:length	()I
    //   611: bipush 24
    //   613: iadd
    //   614: invokespecial 49	java/lang/StringBuilder:<init>	(I)V
    //   617: astore 4
    //   619: aload 4
    //   621: ldc_w 262
    //   624: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: pop
    //   628: aload 4
    //   630: aload_1
    //   631: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: pop
    //   635: new 6	com/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException
    //   638: dup
    //   639: aload 4
    //   641: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   644: aconst_null
    //   645: sipush 2000
    //   648: invokespecial 92	com/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;I)V
    //   651: athrow
    //   652: astore_1
    //   653: new 6	com/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException
    //   656: dup
    //   657: aconst_null
    //   658: aload_1
    //   659: sipush 2005
    //   662: invokespecial 92	com/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;I)V
    //   665: athrow
    //   666: astore_1
    //   667: new 6	com/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException
    //   670: dup
    //   671: ldc_w 264
    //   674: aconst_null
    //   675: sipush 1004
    //   678: invokespecial 92	com/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;I)V
    //   681: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	682	0	this	RawResourceDataSource
    //   0	682	1	paramn	n
    //   4	595	2	localUri	Uri
    //   90	289	3	localObject1	Object
    //   92	548	4	localObject2	Object
    //   194	63	5	m	int
    //   305	69	5	bool	boolean
    //   279	272	6	l1	long
    //   345	157	8	l2	long
    // Exception table:
    //   from	to	target	type
    //   312	322	581	java/io/IOException
    //   325	340	581	java/io/IOException
    //   340	373	581	java/io/IOException
    //   378	401	581	java/io/IOException
    //   404	423	581	java/io/IOException
    //   433	448	581	java/io/IOException
    //   455	461	581	java/io/IOException
    //   553	566	581	java/io/IOException
    //   566	581	581	java/io/IOException
    //   312	322	595	com/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException
    //   325	340	595	com/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException
    //   340	373	595	com/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException
    //   378	401	595	com/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException
    //   404	423	595	com/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException
    //   433	448	595	com/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException
    //   455	461	595	com/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException
    //   553	566	595	com/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException
    //   566	581	595	com/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException
    //   252	263	652	android/content/res/Resources$NotFoundException
    //   232	247	666	java/lang/NumberFormatException
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws RawResourceDataSource.RawResourceDataSourceException
  {
    if (paramInt2 == 0) {
      return 0;
    }
    long l1 = this.k;
    if (l1 == 0L) {
      return -1;
    }
    long l2;
    if (l1 != -1L) {
      l2 = paramInt2;
    }
    try
    {
      paramInt2 = (int)Math.min(l1, l2);
      paramInt1 = ((InputStream)o0.i(this.j)).read(paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt1 == -1)
      {
        if (this.k == -1L) {
          return -1;
        }
        throw new RawResourceDataSourceException("End of stream reached having not read sufficient data.", new EOFException(), 2000);
      }
      l1 = this.k;
      if (l1 != -1L) {
        this.k = (l1 - paramInt1);
      }
      o(paramInt1);
      return paramInt1;
    }
    catch (IOException paramArrayOfByte)
    {
      throw new RawResourceDataSourceException(null, paramArrayOfByte, 2000);
    }
  }
  
  public static class RawResourceDataSourceException
    extends DataSourceException
  {
    @Deprecated
    public RawResourceDataSourceException(String paramString)
    {
      super(null, 2000);
    }
    
    public RawResourceDataSourceException(@Nullable String paramString, @Nullable Throwable paramThrowable, int paramInt)
    {
      super(paramThrowable, paramInt);
    }
    
    @Deprecated
    public RawResourceDataSourceException(Throwable paramThrowable)
    {
      super(2000);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\upstream\RawResourceDataSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */