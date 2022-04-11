package b.d.a0.b;

import android.text.TextUtils;
import b.d.i.a.a.f;
import b.d.i.a.b.b;
import b.d.i.a.b.c.n;
import com.tplink.libtpappcommonmedia.exception.CameraException;
import com.tplink.libtpcommonstream.stream.control.common.CommonPayload;
import com.tplink.libtpcommonstream.stream.control.common.StreamControlNotification;
import com.tplink.libtpcommonstream.stream.control.common.StreamControlRequest;
import com.tplink.libtpcommonstream.stream.control.common.StreamControlResponse;
import com.tplink.libtpcommonstream.stream.control.notification.StreamStatus;
import com.tplink.libtpcommonstream.stream.control.request.DoStopRequest;
import com.tplink.libtpcommonstream.stream.control.response.GetPlaybackResponse;
import com.tplink.libtpcommonstream.stream.control.response.Response;
import com.tplink.libtpmediastatistics.ConnectionInfoVO;
import com.tplink.libtpmediastatistics.ConnectionVO;
import com.tplink.libtpmediastatistics.OnceConnectionVO;
import com.tplink.libtpmediastatistics.StatisticsManager;
import com.tplink.libtpmediastatistics.StatisticsStreamType;
import com.tplink.libtpmediastatistics.StopReason;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

public class e
  extends f
{
  protected d H3;
  protected g I3;
  protected n J3;
  protected String K3;
  protected com.tplink.libtpstreamconnectionsocket.a L3;
  protected String M3;
  protected volatile boolean N3;
  protected b.d.p.a O3;
  protected final String P3;
  protected volatile boolean Q3 = false;
  protected final Object R3 = new Object();
  protected long S3;
  protected long T3;
  protected boolean U3;
  protected long V3;
  private String p2 = "VodStreamConnection";
  protected Future<Boolean> p3;
  
  public e(String paramString)
  {
    this.P3 = paramString;
    this.N3 = true;
    this.M3 = null;
  }
  
  private long n(String paramString)
  {
    long l;
    try
    {
      l = Long.parseLong(paramString);
    }
    catch (Exception paramString)
    {
      l = 0L;
    }
    return l;
  }
  
  private void q()
  {
    d locald = this.H3;
    if (locald != null) {
      locald.g(this.c);
    }
  }
  
  public void A(d paramd)
  {
    this.H3 = paramd;
  }
  
  public void B(g paramg)
  {
    this.I3 = paramg;
  }
  
  public void C(n paramn)
  {
    this.J3 = paramn;
  }
  
  public void D(Future<Boolean> paramFuture)
  {
    this.p3 = paramFuture;
  }
  
  public void E(String paramString)
  {
    this.M3 = paramString;
    String str = this.p2;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sessionId ");
    localStringBuilder.append(paramString);
    b.d.p.d.a(str, localStringBuilder.toString());
  }
  
  public void F(String paramString)
  {
    this.K3 = paramString;
  }
  
  public void f(String paramString)
  {
    Object localObject = this.p2;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramString);
    b.d.p.d.a((String)localObject, localStringBuilder.toString());
    if ((this.L3 != null) && (!TextUtils.isEmpty(this.P3)))
    {
      localObject = new HashMap();
      if (!TextUtils.isEmpty(this.M3)) {
        ((Map)localObject).put("X-Session-Id", this.M3);
      }
      this.L3.t(paramString, (Map)localObject);
    }
  }
  
  /* Error */
  public Boolean l()
    throws Exception
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	b/d/a0/b/e:p2	Ljava/lang/String;
    //   4: astore_1
    //   5: new 94	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   12: astore_2
    //   13: aload_2
    //   14: ldc -103
    //   16: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: pop
    //   20: aload_2
    //   21: aload_0
    //   22: getfield 70	b/d/i/a/a/f:c	Ljava/lang/String;
    //   25: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload_2
    //   30: ldc -101
    //   32: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload_2
    //   37: aload_0
    //   38: getfield 114	b/d/a0/b/e:K3	Ljava/lang/String;
    //   41: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload_1
    //   46: aload_2
    //   47: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 111	b/d/p/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: aload_0
    //   54: invokevirtual 158	b/d/a0/b/e:o	()V
    //   57: invokestatic 163	b/d/d/a/a:d	()Ljava/lang/String;
    //   60: astore_1
    //   61: aload_1
    //   62: astore_2
    //   63: aload_1
    //   64: invokestatic 132	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   67: ifeq +7 -> 74
    //   70: invokestatic 167	com/tplink/libmediakit/jniinterface/GenKey:a	()Ljava/lang/String;
    //   73: astore_2
    //   74: aload_0
    //   75: invokevirtual 171	b/d/i/a/a/f:e	()Z
    //   78: ifeq +51 -> 129
    //   81: new 134	java/util/HashMap
    //   84: dup
    //   85: invokespecial 135	java/util/HashMap:<init>	()V
    //   88: astore_1
    //   89: aload_1
    //   90: ldc -83
    //   92: ldc -81
    //   94: invokeinterface 143 3 0
    //   99: pop
    //   100: aload_0
    //   101: getfield 177	b/d/i/a/a/f:d	Ljava/lang/String;
    //   104: aload_0
    //   105: getfield 180	b/d/i/a/a/f:f	I
    //   108: invokestatic 183	com/tplink/libtpstreamconnectionsocket/a:o	(Ljava/lang/String;I)Ljava/lang/String;
    //   111: astore_3
    //   112: invokestatic 188	b/d/i/a/c/a:a	()Lb/d/i/a/c/a;
    //   115: aload_3
    //   116: ldc -66
    //   118: aload_2
    //   119: ldc -64
    //   121: aload_1
    //   122: invokevirtual 195	b/d/i/a/c/a:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
    //   125: astore_1
    //   126: goto +6 -> 132
    //   129: ldc 124
    //   131: astore_1
    //   132: aload_1
    //   133: invokestatic 132	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   136: ifeq +132 -> 268
    //   139: aload_0
    //   140: invokevirtual 171	b/d/i/a/a/f:e	()Z
    //   143: ifeq +125 -> 268
    //   146: aload_0
    //   147: getfield 67	b/d/a0/b/e:H3	Lb/d/a0/b/d;
    //   150: ifnull +83 -> 233
    //   153: aload_0
    //   154: getfield 198	b/d/i/a/a/f:x	I
    //   157: bipush 17
    //   159: if_icmpeq +74 -> 233
    //   162: invokestatic 188	b/d/i/a/c/a:a	()Lb/d/i/a/c/a;
    //   165: invokevirtual 202	b/d/i/a/c/a:b	()Ljava/util/List;
    //   168: astore_2
    //   169: aload_2
    //   170: invokeinterface 206 1 0
    //   175: ifne +36 -> 211
    //   178: aload_0
    //   179: getfield 67	b/d/a0/b/e:H3	Lb/d/a0/b/d;
    //   182: aload_0
    //   183: getfield 70	b/d/i/a/a/f:c	Ljava/lang/String;
    //   186: aload_2
    //   187: aload_2
    //   188: invokeinterface 210 1 0
    //   193: iconst_1
    //   194: isub
    //   195: invokeinterface 214 2 0
    //   200: checkcast 59	java/lang/Exception
    //   203: invokeinterface 217 3 0
    //   208: goto +25 -> 233
    //   211: aload_0
    //   212: getfield 67	b/d/a0/b/e:H3	Lb/d/a0/b/d;
    //   215: aload_0
    //   216: getfield 70	b/d/i/a/a/f:c	Ljava/lang/String;
    //   219: new 59	java/lang/Exception
    //   222: dup
    //   223: ldc -37
    //   225: invokespecial 221	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   228: invokeinterface 217 3 0
    //   233: aload_0
    //   234: getfield 81	b/d/a0/b/e:I3	Lb/d/a0/b/g;
    //   237: astore_2
    //   238: aload_2
    //   239: ifnull +25 -> 264
    //   242: aload_2
    //   243: aload_0
    //   244: getfield 70	b/d/i/a/a/f:c	Ljava/lang/String;
    //   247: aload_0
    //   248: getfield 198	b/d/i/a/a/f:x	I
    //   251: iconst_0
    //   252: new 59	java/lang/Exception
    //   255: dup
    //   256: invokespecial 222	java/lang/Exception:<init>	()V
    //   259: invokeinterface 228 5 0
    //   264: getstatic 234	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   267: areturn
    //   268: new 145	com/tplink/libtpstreamconnectionsocket/a
    //   271: astore_3
    //   272: aload_3
    //   273: aload_0
    //   274: getfield 177	b/d/i/a/a/f:d	Ljava/lang/String;
    //   277: aload_0
    //   278: getfield 180	b/d/i/a/a/f:f	I
    //   281: invokespecial 237	com/tplink/libtpstreamconnectionsocket/a:<init>	(Ljava/lang/String;I)V
    //   284: aload_0
    //   285: aload_3
    //   286: putfield 126	b/d/a0/b/e:L3	Lcom/tplink/libtpstreamconnectionsocket/a;
    //   289: aload_3
    //   290: sipush 30000
    //   293: invokevirtual 240	com/tplink/libtpstreamconnectionsocket/a:F	(I)Lcom/tplink/libtpstreamconnectionsocket/a;
    //   296: pop
    //   297: aload_0
    //   298: getfield 126	b/d/a0/b/e:L3	Lcom/tplink/libtpstreamconnectionsocket/a;
    //   301: sipush 15000
    //   304: invokevirtual 243	com/tplink/libtpstreamconnectionsocket/a:H	(I)Lcom/tplink/libtpstreamconnectionsocket/a;
    //   307: pop
    //   308: aload_0
    //   309: getfield 126	b/d/a0/b/e:L3	Lcom/tplink/libtpstreamconnectionsocket/a;
    //   312: ldc -64
    //   314: invokevirtual 247	com/tplink/libtpstreamconnectionsocket/a:G	(Ljava/lang/String;)Lcom/tplink/libtpstreamconnectionsocket/a;
    //   317: pop
    //   318: bipush 17
    //   320: aload_0
    //   321: invokevirtual 249	b/d/i/a/a/f:a	()I
    //   324: if_icmpne +18 -> 342
    //   327: aload_0
    //   328: getfield 126	b/d/a0/b/e:L3	Lcom/tplink/libtpstreamconnectionsocket/a;
    //   331: aload_0
    //   332: getfield 70	b/d/i/a/a/f:c	Ljava/lang/String;
    //   335: invokevirtual 251	com/tplink/libtpstreamconnectionsocket/a:e	(Ljava/lang/String;)Lcom/tplink/libtpstreamconnectionsocket/a;
    //   338: pop
    //   339: goto +11 -> 350
    //   342: aload_0
    //   343: getfield 126	b/d/a0/b/e:L3	Lcom/tplink/libtpstreamconnectionsocket/a;
    //   346: invokevirtual 254	com/tplink/libtpstreamconnectionsocket/a:d	()Lcom/tplink/libtpstreamconnectionsocket/a;
    //   349: pop
    //   350: aload_0
    //   351: invokevirtual 249	b/d/i/a/a/f:a	()I
    //   354: ifne +9 -> 363
    //   357: iconst_1
    //   358: istore 4
    //   360: goto +6 -> 366
    //   363: iconst_0
    //   364: istore 4
    //   366: aload_0
    //   367: getfield 126	b/d/a0/b/e:L3	Lcom/tplink/libtpstreamconnectionsocket/a;
    //   370: aload_1
    //   371: iload 4
    //   373: invokevirtual 257	com/tplink/libtpstreamconnectionsocket/a:q	(Ljava/lang/String;Z)I
    //   376: istore 5
    //   378: iload 5
    //   380: sipush 200
    //   383: if_icmpne +89 -> 472
    //   386: aload_0
    //   387: getfield 126	b/d/a0/b/e:L3	Lcom/tplink/libtpstreamconnectionsocket/a;
    //   390: invokevirtual 261	com/tplink/libtpstreamconnectionsocket/a:p	()Ljava/util/Map;
    //   393: astore_1
    //   394: aload_1
    //   395: ldc_w 263
    //   398: invokeinterface 267 2 0
    //   403: ifeq +69 -> 472
    //   406: aload_1
    //   407: ldc_w 263
    //   410: invokeinterface 270 2 0
    //   415: checkcast 272	java/lang/String
    //   418: astore_1
    //   419: aload_0
    //   420: getfield 41	b/d/a0/b/e:p2	Ljava/lang/String;
    //   423: astore_3
    //   424: new 94	java/lang/StringBuilder
    //   427: astore 6
    //   429: aload 6
    //   431: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   434: aload 6
    //   436: ldc 124
    //   438: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: pop
    //   442: aload 6
    //   444: aload_1
    //   445: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: pop
    //   449: aload_3
    //   450: aload 6
    //   452: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   455: invokestatic 111	b/d/p/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   458: aload_0
    //   459: aload_1
    //   460: aload_2
    //   461: invokestatic 277	b/d/i/a/a/e:b	(Ljava/lang/String;Ljava/lang/String;)Lb/d/p/a;
    //   464: putfield 279	b/d/a0/b/e:O3	Lb/d/p/a;
    //   467: aload_0
    //   468: iconst_1
    //   469: putfield 281	b/d/a0/b/e:U3	Z
    //   472: iload 5
    //   474: sipush 200
    //   477: if_icmpeq +282 -> 759
    //   480: iload 5
    //   482: sipush 204
    //   485: if_icmpeq +274 -> 759
    //   488: aload_0
    //   489: getfield 41	b/d/a0/b/e:p2	Ljava/lang/String;
    //   492: astore_2
    //   493: new 94	java/lang/StringBuilder
    //   496: astore_1
    //   497: aload_1
    //   498: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   501: aload_1
    //   502: ldc -103
    //   504: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: pop
    //   508: aload_1
    //   509: aload_0
    //   510: getfield 70	b/d/i/a/a/f:c	Ljava/lang/String;
    //   513: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: pop
    //   517: aload_1
    //   518: ldc_w 283
    //   521: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: pop
    //   525: aload_1
    //   526: iload 5
    //   528: invokevirtual 286	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   531: pop
    //   532: aload_2
    //   533: aload_1
    //   534: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   537: invokestatic 111	b/d/p/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   540: iload 5
    //   542: sipush 401
    //   545: if_icmpne +204 -> 749
    //   548: sipush 256
    //   551: aload_0
    //   552: invokevirtual 249	b/d/i/a/a/f:a	()I
    //   555: if_icmpne +41 -> 596
    //   558: aload_0
    //   559: getfield 67	b/d/a0/b/e:H3	Lb/d/a0/b/d;
    //   562: astore_1
    //   563: aload_1
    //   564: ifnull +65 -> 629
    //   567: aload_0
    //   568: getfield 70	b/d/i/a/a/f:c	Ljava/lang/String;
    //   571: astore_3
    //   572: new 59	java/lang/Exception
    //   575: astore_2
    //   576: aload_2
    //   577: iload 5
    //   579: invokestatic 290	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   582: invokespecial 221	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   585: aload_1
    //   586: aload_3
    //   587: aload_2
    //   588: invokeinterface 217 3 0
    //   593: goto +36 -> 629
    //   596: aload_0
    //   597: getfield 67	b/d/a0/b/e:H3	Lb/d/a0/b/d;
    //   600: astore_3
    //   601: aload_3
    //   602: ifnull +27 -> 629
    //   605: aload_0
    //   606: getfield 70	b/d/i/a/a/f:c	Ljava/lang/String;
    //   609: astore_1
    //   610: new 292	com/tplink/libtpstreamconnectionsocket/EncryptException
    //   613: astore_2
    //   614: aload_2
    //   615: ldc_w 294
    //   618: invokespecial 295	com/tplink/libtpstreamconnectionsocket/EncryptException:<init>	(Ljava/lang/String;)V
    //   621: aload_3
    //   622: aload_1
    //   623: aload_2
    //   624: invokeinterface 217 3 0
    //   629: aload_0
    //   630: getfield 81	b/d/a0/b/e:I3	Lb/d/a0/b/g;
    //   633: astore_1
    //   634: aload_1
    //   635: ifnull +33 -> 668
    //   638: aload_0
    //   639: getfield 70	b/d/i/a/a/f:c	Ljava/lang/String;
    //   642: astore_2
    //   643: aload_0
    //   644: getfield 198	b/d/i/a/a/f:x	I
    //   647: istore 5
    //   649: new 59	java/lang/Exception
    //   652: astore_3
    //   653: aload_3
    //   654: invokespecial 222	java/lang/Exception:<init>	()V
    //   657: aload_1
    //   658: aload_2
    //   659: iload 5
    //   661: iconst_0
    //   662: aload_3
    //   663: invokeinterface 228 5 0
    //   668: aload_0
    //   669: getfield 126	b/d/a0/b/e:L3	Lcom/tplink/libtpstreamconnectionsocket/a;
    //   672: astore_2
    //   673: aload_2
    //   674: ifnull +7 -> 681
    //   677: aload_2
    //   678: invokevirtual 297	com/tplink/libtpstreamconnectionsocket/a:f	()V
    //   681: getstatic 300	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   684: astore_3
    //   685: aload_0
    //   686: getfield 41	b/d/a0/b/e:p2	Ljava/lang/String;
    //   689: astore_1
    //   690: new 94	java/lang/StringBuilder
    //   693: dup
    //   694: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   697: astore_2
    //   698: aload_2
    //   699: ldc -103
    //   701: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: pop
    //   705: aload_2
    //   706: aload_0
    //   707: getfield 70	b/d/i/a/a/f:c	Ljava/lang/String;
    //   710: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: pop
    //   714: aload_2
    //   715: ldc_w 302
    //   718: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: pop
    //   722: aload_1
    //   723: aload_2
    //   724: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   727: invokestatic 111	b/d/p/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   730: aload_0
    //   731: iconst_0
    //   732: putfield 52	b/d/a0/b/e:N3	Z
    //   735: aload_0
    //   736: invokevirtual 305	b/d/a0/b/e:y	()V
    //   739: aload_0
    //   740: invokevirtual 307	b/d/a0/b/e:t	()V
    //   743: aload_0
    //   744: invokevirtual 309	b/d/a0/b/e:p	()V
    //   747: aload_3
    //   748: areturn
    //   749: new 311	java/io/IOException
    //   752: astore_2
    //   753: aload_2
    //   754: invokespecial 312	java/io/IOException:<init>	()V
    //   757: aload_2
    //   758: athrow
    //   759: aload_0
    //   760: getfield 41	b/d/a0/b/e:p2	Ljava/lang/String;
    //   763: astore_2
    //   764: new 94	java/lang/StringBuilder
    //   767: astore_1
    //   768: aload_1
    //   769: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   772: aload_1
    //   773: ldc -103
    //   775: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   778: pop
    //   779: aload_1
    //   780: aload_0
    //   781: getfield 70	b/d/i/a/a/f:c	Ljava/lang/String;
    //   784: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: pop
    //   788: aload_1
    //   789: ldc_w 314
    //   792: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: pop
    //   796: aload_2
    //   797: aload_1
    //   798: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   801: invokestatic 111	b/d/p/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   804: aload_0
    //   805: invokevirtual 317	b/d/a0/b/e:r	()V
    //   808: aload_0
    //   809: getfield 41	b/d/a0/b/e:p2	Ljava/lang/String;
    //   812: astore_2
    //   813: new 94	java/lang/StringBuilder
    //   816: dup
    //   817: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   820: astore_1
    //   821: goto +259 -> 1080
    //   824: astore_3
    //   825: goto +308 -> 1133
    //   828: astore_2
    //   829: aload_0
    //   830: getfield 41	b/d/a0/b/e:p2	Ljava/lang/String;
    //   833: astore_3
    //   834: new 94	java/lang/StringBuilder
    //   837: astore_1
    //   838: aload_1
    //   839: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   842: aload_1
    //   843: ldc -103
    //   845: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   848: pop
    //   849: aload_1
    //   850: aload_0
    //   851: getfield 70	b/d/i/a/a/f:c	Ljava/lang/String;
    //   854: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   857: pop
    //   858: aload_1
    //   859: ldc_w 319
    //   862: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   865: pop
    //   866: aload_1
    //   867: aload_2
    //   868: invokevirtual 320	java/lang/Exception:toString	()Ljava/lang/String;
    //   871: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   874: pop
    //   875: aload_3
    //   876: aload_1
    //   877: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   880: invokestatic 111	b/d/p/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   883: aload_2
    //   884: invokevirtual 323	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   887: ifnull +39 -> 926
    //   890: aload_2
    //   891: invokevirtual 323	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   894: ldc_w 325
    //   897: invokevirtual 328	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   900: ifeq +26 -> 926
    //   903: aload_0
    //   904: getfield 67	b/d/a0/b/e:H3	Lb/d/a0/b/d;
    //   907: astore_1
    //   908: aload_1
    //   909: ifnull +42 -> 951
    //   912: aload_1
    //   913: aload_0
    //   914: getfield 70	b/d/i/a/a/f:c	Ljava/lang/String;
    //   917: aload_2
    //   918: invokeinterface 217 3 0
    //   923: goto +28 -> 951
    //   926: aload_0
    //   927: getfield 81	b/d/a0/b/e:I3	Lb/d/a0/b/g;
    //   930: astore_1
    //   931: aload_1
    //   932: ifnull +19 -> 951
    //   935: aload_1
    //   936: aload_0
    //   937: getfield 70	b/d/i/a/a/f:c	Ljava/lang/String;
    //   940: aload_0
    //   941: getfield 198	b/d/i/a/a/f:x	I
    //   944: iconst_1
    //   945: aload_2
    //   946: invokeinterface 228 5 0
    //   951: aload_0
    //   952: getfield 41	b/d/a0/b/e:p2	Ljava/lang/String;
    //   955: astore_2
    //   956: new 94	java/lang/StringBuilder
    //   959: dup
    //   960: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   963: astore_1
    //   964: goto +116 -> 1080
    //   967: astore_2
    //   968: aload_0
    //   969: getfield 41	b/d/a0/b/e:p2	Ljava/lang/String;
    //   972: astore_3
    //   973: new 94	java/lang/StringBuilder
    //   976: astore_1
    //   977: aload_1
    //   978: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   981: aload_1
    //   982: ldc -103
    //   984: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   987: pop
    //   988: aload_1
    //   989: aload_0
    //   990: getfield 70	b/d/i/a/a/f:c	Ljava/lang/String;
    //   993: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   996: pop
    //   997: aload_1
    //   998: ldc_w 330
    //   1001: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1004: pop
    //   1005: aload_1
    //   1006: aload_2
    //   1007: invokevirtual 331	java/net/MalformedURLException:toString	()Ljava/lang/String;
    //   1010: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1013: pop
    //   1014: aload_3
    //   1015: aload_1
    //   1016: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1019: invokestatic 111	b/d/p/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1022: aload_0
    //   1023: getfield 67	b/d/a0/b/e:H3	Lb/d/a0/b/d;
    //   1026: astore_1
    //   1027: aload_1
    //   1028: ifnull +14 -> 1042
    //   1031: aload_1
    //   1032: aload_0
    //   1033: getfield 70	b/d/i/a/a/f:c	Ljava/lang/String;
    //   1036: aload_2
    //   1037: invokeinterface 217 3 0
    //   1042: aload_0
    //   1043: getfield 81	b/d/a0/b/e:I3	Lb/d/a0/b/g;
    //   1046: astore_1
    //   1047: aload_1
    //   1048: ifnull +19 -> 1067
    //   1051: aload_1
    //   1052: aload_0
    //   1053: getfield 70	b/d/i/a/a/f:c	Ljava/lang/String;
    //   1056: aload_0
    //   1057: getfield 198	b/d/i/a/a/f:x	I
    //   1060: iconst_0
    //   1061: aload_2
    //   1062: invokeinterface 228 5 0
    //   1067: aload_0
    //   1068: getfield 41	b/d/a0/b/e:p2	Ljava/lang/String;
    //   1071: astore_2
    //   1072: new 94	java/lang/StringBuilder
    //   1075: dup
    //   1076: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   1079: astore_1
    //   1080: aload_1
    //   1081: ldc -103
    //   1083: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1086: pop
    //   1087: aload_1
    //   1088: aload_0
    //   1089: getfield 70	b/d/i/a/a/f:c	Ljava/lang/String;
    //   1092: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1095: pop
    //   1096: aload_1
    //   1097: ldc_w 302
    //   1100: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1103: pop
    //   1104: aload_2
    //   1105: aload_1
    //   1106: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1109: invokestatic 111	b/d/p/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1112: aload_0
    //   1113: iconst_0
    //   1114: putfield 52	b/d/a0/b/e:N3	Z
    //   1117: aload_0
    //   1118: invokevirtual 305	b/d/a0/b/e:y	()V
    //   1121: aload_0
    //   1122: invokevirtual 307	b/d/a0/b/e:t	()V
    //   1125: aload_0
    //   1126: invokevirtual 309	b/d/a0/b/e:p	()V
    //   1129: getstatic 234	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1132: areturn
    //   1133: aload_0
    //   1134: getfield 41	b/d/a0/b/e:p2	Ljava/lang/String;
    //   1137: astore_2
    //   1138: new 94	java/lang/StringBuilder
    //   1141: dup
    //   1142: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   1145: astore_1
    //   1146: aload_1
    //   1147: ldc -103
    //   1149: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1152: pop
    //   1153: aload_1
    //   1154: aload_0
    //   1155: getfield 70	b/d/i/a/a/f:c	Ljava/lang/String;
    //   1158: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1161: pop
    //   1162: aload_1
    //   1163: ldc_w 302
    //   1166: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1169: pop
    //   1170: aload_2
    //   1171: aload_1
    //   1172: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1175: invokestatic 111	b/d/p/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1178: aload_0
    //   1179: iconst_0
    //   1180: putfield 52	b/d/a0/b/e:N3	Z
    //   1183: aload_0
    //   1184: invokevirtual 305	b/d/a0/b/e:y	()V
    //   1187: aload_0
    //   1188: invokevirtual 307	b/d/a0/b/e:t	()V
    //   1191: aload_0
    //   1192: invokevirtual 309	b/d/a0/b/e:p	()V
    //   1195: aload_3
    //   1196: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1197	0	this	e
    //   4	1168	1	localObject1	Object
    //   12	801	2	localObject2	Object
    //   828	118	2	localException	Exception
    //   955	1	2	str1	String
    //   967	95	2	localMalformedURLException	java.net.MalformedURLException
    //   1071	100	2	str2	String
    //   111	637	3	localObject3	Object
    //   824	1	3	localObject4	Object
    //   833	363	3	str3	String
    //   358	14	4	bool	boolean
    //   376	284	5	i	int
    //   427	24	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   268	339	824	finally
    //   342	350	824	finally
    //   350	357	824	finally
    //   366	378	824	finally
    //   386	472	824	finally
    //   488	540	824	finally
    //   548	563	824	finally
    //   567	593	824	finally
    //   596	601	824	finally
    //   605	629	824	finally
    //   629	634	824	finally
    //   638	668	824	finally
    //   668	673	824	finally
    //   677	681	824	finally
    //   681	685	824	finally
    //   749	759	824	finally
    //   759	808	824	finally
    //   829	908	824	finally
    //   912	923	824	finally
    //   926	931	824	finally
    //   935	951	824	finally
    //   968	1027	824	finally
    //   1031	1042	824	finally
    //   1042	1047	824	finally
    //   1051	1067	824	finally
    //   268	339	828	java/lang/Exception
    //   342	350	828	java/lang/Exception
    //   350	357	828	java/lang/Exception
    //   366	378	828	java/lang/Exception
    //   386	472	828	java/lang/Exception
    //   488	540	828	java/lang/Exception
    //   548	563	828	java/lang/Exception
    //   567	593	828	java/lang/Exception
    //   596	601	828	java/lang/Exception
    //   605	629	828	java/lang/Exception
    //   629	634	828	java/lang/Exception
    //   638	668	828	java/lang/Exception
    //   668	673	828	java/lang/Exception
    //   677	681	828	java/lang/Exception
    //   681	685	828	java/lang/Exception
    //   749	759	828	java/lang/Exception
    //   759	808	828	java/lang/Exception
    //   268	339	967	java/net/MalformedURLException
    //   342	350	967	java/net/MalformedURLException
    //   350	357	967	java/net/MalformedURLException
    //   366	378	967	java/net/MalformedURLException
    //   386	472	967	java/net/MalformedURLException
    //   488	540	967	java/net/MalformedURLException
    //   548	563	967	java/net/MalformedURLException
    //   567	593	967	java/net/MalformedURLException
    //   596	601	967	java/net/MalformedURLException
    //   605	629	967	java/net/MalformedURLException
    //   629	634	967	java/net/MalformedURLException
    //   638	668	967	java/net/MalformedURLException
    //   668	673	967	java/net/MalformedURLException
    //   677	681	967	java/net/MalformedURLException
    //   681	685	967	java/net/MalformedURLException
    //   749	759	967	java/net/MalformedURLException
    //   759	808	967	java/net/MalformedURLException
  }
  
  public boolean m()
  {
    return TextUtils.isEmpty(this.M3) ^ true;
  }
  
  protected void o()
  {
    this.S3 = System.currentTimeMillis();
    this.N3 = true;
    this.U3 = false;
  }
  
  protected void p()
  {
    if (256 != this.x)
    {
      long l = System.currentTimeMillis();
      this.T3 = l;
      int i = Math.round((float)(l - this.S3) / 1000.0F);
      Object localObject1 = StatisticsManager.getInstance();
      Object localObject2 = this.c;
      Object localObject3 = StatisticsStreamType.SD_VOD;
      localObject2 = ((StatisticsManager)localObject1).getOnceConnectionCacheKey((String)localObject2, (StatisticsStreamType)localObject3, this.x);
      localObject1 = StatisticsManager.getInstance().getAndRemoveOnceConnectionVO((String)localObject2);
      ((OnceConnectionVO)localObject1).setFlowUsed(this.L3.j());
      ((OnceConnectionVO)localObject1).setWatchTime(i);
      if (i > 7140) {
        ((OnceConnectionVO)localObject1).setStopReason(StopReason.RELAY_TIME_LIMIT.value());
      }
      String str = StatisticsManager.getInstance().getConnectionInfoCacheKey(this.c, (StatisticsStreamType)localObject3);
      localObject2 = StatisticsManager.getInstance().getConnectionInfoVO(str);
      localObject3 = localObject2;
      if (localObject2 == null)
      {
        localObject3 = new ConnectionInfoVO();
        StatisticsManager.getInstance().insertConnectionInfoVO(str, (ConnectionInfoVO)localObject3);
      }
      i = this.x;
      if (i == 16) {
        ((ConnectionInfoVO)localObject3).getP2pConnectionVO().addData((OnceConnectionVO)localObject1);
      } else if (i == 0) {
        ((ConnectionInfoVO)localObject3).getRelayConnectionVO().addData((OnceConnectionVO)localObject1);
      }
    }
  }
  
  protected void r()
    throws Exception
  {
    ??? = this.p2;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestPlayback ");
    localStringBuilder.append(this.P3);
    b.d.p.d.a((String)???, localStringBuilder.toString());
    ??? = new HashMap();
    ((Map)???).put("X-Data-Window-Size", "50");
    this.L3.t(this.P3, (Map)???);
    while (this.N3)
    {
      if (this.Q3) {
        synchronized (this.R3)
        {
          this.R3.notifyAll();
          this.R3.wait();
        }
      }
      this.L3.g();
      ??? = this.L3.p();
      if (((Map)???).size() != 0)
      {
        Object localObject3;
        if ((this.y) && (this.p1))
        {
          this.y = false;
          localObject3 = this.I3;
          if (localObject3 != null) {
            ((g)localObject3).i(this.c, this.x);
          }
          localObject3 = this.H3;
          if (localObject3 != null) {
            ((d)localObject3).a(this.c, a());
          }
          a();
        }
        this.z = true;
        if (((Map)???).containsKey("Content-Type"))
        {
          Object localObject4;
          if (((Map)???).containsKey("X-Data-Sequence"))
          {
            localObject4 = (String)((Map)???).get("X-Data-Sequence");
            long l = n((String)localObject4);
            this.V3 = l;
            if (l % 25L == 0L)
            {
              if (l % 250L == 0L)
              {
                localObject3 = this.p2;
                localObject5 = new StringBuilder();
                ((StringBuilder)localObject5).append("send Sequence ");
                ((StringBuilder)localObject5).append((String)localObject4);
                b.d.p.d.a((String)localObject3, ((StringBuilder)localObject5).toString());
              }
              localObject5 = new HashMap();
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("");
              ((StringBuilder)localObject3).append(this.V3);
              ((Map)localObject5).put("X-Data-Received", ((StringBuilder)localObject3).toString());
              ((Map)localObject5).put("X-Session-Id", this.M3);
              ((Map)localObject5).put("Content-Type", "application/json");
              this.L3.D((Map)localObject5, "{\"type\":\"notification\",\"params\":{\"event_type\":\"stream_sequence\"}}");
            }
          }
          localObject3 = (String)((Map)???).get("Content-Type");
          Object localObject5 = (String)((Map)???).get("X-Session-Id");
          int i;
          if ((((Map)???).containsKey("X-If-Encrypt")) && ("1".equals(((Map)???).get("X-If-Encrypt")))) {
            i = 1;
          } else {
            i = 0;
          }
          if ("video/mp2t".equals(localObject3))
          {
            this.p1 = true;
            localObject3 = this.L3.m();
            ??? = localObject3;
            if (i != 0)
            {
              localObject4 = this.O3;
              ??? = localObject3;
              if (localObject4 != null) {
                ??? = ((b.d.p.a)localObject4).a((byte[])localObject3, localObject3.length);
              }
            }
            localObject3 = this.M3;
            if ((localObject3 != null) && (((String)localObject3).equals(localObject5)))
            {
              localObject3 = this.H3;
              if (localObject3 != null) {
                ((d)localObject3).c(this.c, (byte[])???);
              }
            }
          }
          else if ("application/json".equals(localObject3))
          {
            localObject3 = this.L3.m();
            ??? = localObject3;
            if (i != 0)
            {
              localObject5 = this.O3;
              ??? = localObject3;
              if (localObject5 != null) {
                ??? = ((b.d.p.a)localObject5).a((byte[])localObject3, localObject3.length);
              }
            }
            ??? = new String((byte[])???);
            localObject5 = this.p2;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("payload: ");
            ((StringBuilder)localObject3).append((String)???);
            b.d.p.d.a((String)localObject5, ((StringBuilder)localObject3).toString());
            ??? = (CommonPayload)b.b((String)???, CommonPayload.class);
            if ("notification".equals(((CommonPayload)???).getType()))
            {
              ??? = b.c((CommonPayload)???);
              if ((??? != null) && (this.J3 != null))
              {
                localObject5 = this.p2;
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("event type ");
                ((StringBuilder)localObject3).append(((StreamControlNotification)???).getEventType());
                b.d.p.d.a((String)localObject5, ((StringBuilder)localObject3).toString());
                this.J3.a(this.c, (StreamControlNotification)???);
              }
              if (??? != null) {
                if ("stream_finish".equals(((StreamControlNotification)???).getEventType()))
                {
                  q();
                  this.Q3 = true;
                }
                else if (("stream_status".equals(((StreamControlNotification)???).getEventType())) && ("finished".equals(((StreamStatus)((StreamControlNotification)???).getResult()).getStatus())))
                {
                  q();
                  this.Q3 = true;
                }
              }
            }
            else if ("response".equals(((CommonPayload)???).getType()))
            {
              if (this.M3 == null)
              {
                ??? = (GetPlaybackResponse)b.e((CommonPayload)???, GetPlaybackResponse.class).getResult();
                if ((((Response)???).getErrorCode() == 0) && (!TextUtils.isEmpty(((GetPlaybackResponse)???).getSessionId())))
                {
                  E(((GetPlaybackResponse)???).getSessionId());
                }
                else if (((Response)???).getErrorCode() == -52409)
                {
                  ??? = this.H3;
                  if (??? != null) {
                    ((d)???).b(this.c, new CameraException(-52409, "sd card is unplugged"));
                  }
                }
                else if (((Response)???).getErrorCode() == -52407)
                {
                  ??? = this.H3;
                  if (??? != null) {
                    ((d)???).b(this.c, new CameraException(-52407, "too many viewer"));
                  }
                }
                else if (((Response)???).getErrorCode() == -52419)
                {
                  ??? = this.I3;
                  if (??? != null) {
                    ((g)???).m(this.c, this.x, false, new Exception());
                  }
                }
                else if (((Response)???).getErrorCode() == -52402)
                {
                  ??? = this.H3;
                  if (??? != null) {
                    ((d)???).b(this.c, new CameraException(-52402, "invaliad request"));
                  }
                }
                else
                {
                  ??? = this.H3;
                  if (??? != null) {
                    ((d)???).b(this.c, new Exception("vod stream connected session callback error"));
                  }
                }
              }
              else
              {
                localObject3 = this.J3;
                if (localObject3 != null) {
                  ((n)localObject3).c((CommonPayload)???);
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void s()
  {
    String str = this.p2;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("设备：");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append("VOD流被release()");
    b.d.p.d.a(str, ((StringBuilder)localObject).toString());
    this.N3 = false;
    this.H3 = null;
    this.I3 = null;
    localObject = this.p3;
    if (localObject != null) {
      ((Future)localObject).cancel(true);
    }
  }
  
  protected void t()
  {
    com.tplink.libtpstreamconnectionsocket.a locala = this.L3;
    if (locala != null) {
      locala.f();
    }
  }
  
  public void u()
  {
    this.Q3 = false;
    synchronized (this.R3)
    {
      this.R3.notifyAll();
      return;
    }
  }
  
  public void v()
  {
    b.d.p.d.a(this.p2, "sendPauseCommand");
    if (!this.Q3) {
      this.Q3 = true;
    }
  }
  
  public void w()
  {
    if (this.Q3)
    {
      this.Q3 = false;
      synchronized (this.R3)
      {
        this.R3.notifyAll();
      }
    }
  }
  
  public void x()
  {
    b.d.p.d.a(this.p2, "sendSeekCommand");
    this.Q3 = false;
    synchronized (this.R3)
    {
      this.R3.notifyAll();
      return;
    }
  }
  
  protected void y()
  {
    if ((this.L3 != null) && (!TextUtils.isEmpty(this.M3))) {
      try
      {
        int i = this.J3.b();
        Object localObject1 = new com/tplink/libtpcommonstream/stream/control/request/DoStopRequest;
        ((DoStopRequest)localObject1).<init>();
        localObject2 = new com/tplink/libtpcommonstream/stream/control/common/StreamControlRequest;
        ((StreamControlRequest)localObject2).<init>(localObject1);
        ((StreamControlRequest)localObject2).setSeq(i);
        localObject1 = b.d((StreamControlRequest)localObject2);
        localObject2 = new java/util/HashMap;
        ((HashMap)localObject2).<init>();
        ((Map)localObject2).put("Content-Type", "application/json");
        ((Map)localObject2).put("X-Session-Id", this.M3);
        this.L3.I(true);
        this.L3.D((Map)localObject2, (String)localObject1);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        Object localObject2 = this.H3;
        if (localObject2 != null) {
          ((d)localObject2).b(this.c, localException);
        }
      }
    }
  }
  
  public void z()
  {
    if ((this.L3 != null) && (this.V3 % 25L == 0L) && (!TextUtils.isEmpty(this.M3)))
    {
      HashMap localHashMap = new HashMap();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.V3);
      localHashMap.put("X-Data-Received", localStringBuilder.toString());
      localHashMap.put("X-Session-Id", this.M3);
      localHashMap.put("Content-Type", "application/json");
      this.L3.t("{\"type\":\"notification\",\"params\":{\"event_type\":\"stream_sequence\"}}", localHashMap);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\a0\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */