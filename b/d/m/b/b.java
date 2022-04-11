package b.d.m.b;

import android.text.TextUtils;
import b.d.i.a.a.f;
import b.d.i.a.b.c.n;
import com.tplink.libtpcommonstream.stream.control.common.CommonPayload;
import com.tplink.libtpcommonstream.stream.control.common.StreamControlNotification;
import com.tplink.libtpcommonstream.stream.control.common.StreamControlRequest;
import com.tplink.libtpcommonstream.stream.control.common.StreamControlResponse;
import com.tplink.libtpcommonstream.stream.control.notification.StreamStatus;
import com.tplink.libtpcommonstream.stream.control.request.DoStopRequest;
import com.tplink.libtpcommonstream.stream.control.response.GetDownloadResponse;
import com.tplink.libtpcommonstream.stream.control.response.Response;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

public class b
  extends f
{
  private Future<Boolean> H3;
  private volatile boolean I3 = true;
  private com.tplink.libtpstreamconnectionsocket.a J3;
  private String K3;
  private b.d.p.a L3;
  private int M3;
  private String N3;
  private final Object O3 = new Object();
  private n P3;
  private final String Q3;
  private a R3;
  private a p2;
  private d p3;
  
  public b(String paramString)
  {
    this.Q3 = paramString;
    this.I3 = true;
    this.K3 = null;
  }
  
  private StreamStatus o(StreamControlNotification<Object> paramStreamControlNotification)
  {
    if ("stream_status".equals(paramStreamControlNotification.getEventType())) {
      return (StreamStatus)paramStreamControlNotification.getResult();
    }
    return null;
  }
  
  public void f(String arg1)
  {
    if ((this.J3 != null) && (!TextUtils.isEmpty(this.Q3)))
    {
      HashMap localHashMap = new HashMap();
      if (!TextUtils.isEmpty(this.K3)) {
        localHashMap.put("X-Session-Id", this.K3);
      }
      this.J3.t(???, localHashMap);
      synchronized (this.O3)
      {
        this.O3.notifyAll();
      }
    }
  }
  
  /* Error */
  public Boolean l()
    throws Exception
  {
    // Byte code:
    //   0: invokestatic 115	b/d/d/a/a:d	()Ljava/lang/String;
    //   3: astore_1
    //   4: aload_1
    //   5: astore_2
    //   6: aload_1
    //   7: invokestatic 90	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifeq +7 -> 17
    //   13: invokestatic 119	com/tplink/libmediakit/jniinterface/GenKey:a	()Ljava/lang/String;
    //   16: astore_2
    //   17: aload_0
    //   18: invokevirtual 123	b/d/i/a/a/f:e	()Z
    //   21: ifeq +51 -> 72
    //   24: new 92	java/util/HashMap
    //   27: dup
    //   28: invokespecial 93	java/util/HashMap:<init>	()V
    //   31: astore_1
    //   32: aload_1
    //   33: ldc 125
    //   35: ldc 127
    //   37: invokeinterface 101 3 0
    //   42: pop
    //   43: aload_0
    //   44: getfield 129	b/d/i/a/a/f:d	Ljava/lang/String;
    //   47: aload_0
    //   48: getfield 131	b/d/i/a/a/f:f	I
    //   51: invokestatic 134	com/tplink/libtpstreamconnectionsocket/a:o	(Ljava/lang/String;I)Ljava/lang/String;
    //   54: astore_3
    //   55: invokestatic 139	b/d/i/a/c/a:a	()Lb/d/i/a/c/a;
    //   58: aload_3
    //   59: ldc -115
    //   61: aload_2
    //   62: ldc -113
    //   64: aload_1
    //   65: invokevirtual 147	b/d/i/a/c/a:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
    //   68: astore_1
    //   69: goto +6 -> 75
    //   72: ldc -107
    //   74: astore_1
    //   75: aload_1
    //   76: invokestatic 90	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   79: istore 4
    //   81: iconst_1
    //   82: istore 5
    //   84: iload 4
    //   86: ifeq +138 -> 224
    //   89: aload_0
    //   90: invokevirtual 123	b/d/i/a/a/f:e	()Z
    //   93: ifeq +131 -> 224
    //   96: aload_0
    //   97: getfield 151	b/d/m/b/b:p2	Lb/d/m/b/a;
    //   100: ifnull +90 -> 190
    //   103: invokestatic 139	b/d/i/a/c/a:a	()Lb/d/i/a/c/a;
    //   106: invokevirtual 155	b/d/i/a/c/a:b	()Ljava/util/List;
    //   109: astore_2
    //   110: aload_2
    //   111: invokeinterface 159 1 0
    //   116: ifne +44 -> 160
    //   119: aload_0
    //   120: getfield 151	b/d/m/b/b:p2	Lb/d/m/b/a;
    //   123: aload_0
    //   124: getfield 161	b/d/i/a/a/f:c	Ljava/lang/String;
    //   127: aload_0
    //   128: getfield 163	b/d/m/b/b:N3	Ljava/lang/String;
    //   131: aload_0
    //   132: getfield 165	b/d/m/b/b:M3	I
    //   135: aload_2
    //   136: aload_2
    //   137: invokeinterface 169 1 0
    //   142: iconst_1
    //   143: isub
    //   144: invokeinterface 173 2 0
    //   149: checkcast 76	java/lang/Exception
    //   152: invokeinterface 178 5 0
    //   157: goto +33 -> 190
    //   160: aload_0
    //   161: getfield 151	b/d/m/b/b:p2	Lb/d/m/b/a;
    //   164: aload_0
    //   165: getfield 161	b/d/i/a/a/f:c	Ljava/lang/String;
    //   168: aload_0
    //   169: getfield 163	b/d/m/b/b:N3	Ljava/lang/String;
    //   172: aload_0
    //   173: getfield 165	b/d/m/b/b:M3	I
    //   176: new 76	java/lang/Exception
    //   179: dup
    //   180: ldc -76
    //   182: invokespecial 182	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   185: invokeinterface 178 5 0
    //   190: aload_0
    //   191: getfield 184	b/d/m/b/b:p3	Lb/d/m/b/d;
    //   194: astore_2
    //   195: aload_2
    //   196: ifnull +24 -> 220
    //   199: aload_2
    //   200: aload_0
    //   201: getfield 161	b/d/i/a/a/f:c	Ljava/lang/String;
    //   204: aload_0
    //   205: getfield 187	b/d/i/a/a/f:x	I
    //   208: new 76	java/lang/Exception
    //   211: dup
    //   212: invokespecial 188	java/lang/Exception:<init>	()V
    //   215: invokeinterface 193 4 0
    //   220: getstatic 199	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   223: areturn
    //   224: new 103	com/tplink/libtpstreamconnectionsocket/a
    //   227: astore_3
    //   228: aload_3
    //   229: aload_0
    //   230: getfield 129	b/d/i/a/a/f:d	Ljava/lang/String;
    //   233: aload_0
    //   234: getfield 131	b/d/i/a/a/f:f	I
    //   237: invokespecial 202	com/tplink/libtpstreamconnectionsocket/a:<init>	(Ljava/lang/String;I)V
    //   240: aload_0
    //   241: aload_3
    //   242: putfield 84	b/d/m/b/b:J3	Lcom/tplink/libtpstreamconnectionsocket/a;
    //   245: aload_3
    //   246: sipush 30000
    //   249: invokevirtual 206	com/tplink/libtpstreamconnectionsocket/a:F	(I)Lcom/tplink/libtpstreamconnectionsocket/a;
    //   252: pop
    //   253: aload_0
    //   254: getfield 84	b/d/m/b/b:J3	Lcom/tplink/libtpstreamconnectionsocket/a;
    //   257: sipush 30000
    //   260: invokevirtual 209	com/tplink/libtpstreamconnectionsocket/a:H	(I)Lcom/tplink/libtpstreamconnectionsocket/a;
    //   263: pop
    //   264: aload_0
    //   265: getfield 84	b/d/m/b/b:J3	Lcom/tplink/libtpstreamconnectionsocket/a;
    //   268: ldc -113
    //   270: invokevirtual 213	com/tplink/libtpstreamconnectionsocket/a:G	(Ljava/lang/String;)Lcom/tplink/libtpstreamconnectionsocket/a;
    //   273: pop
    //   274: bipush 17
    //   276: aload_0
    //   277: invokevirtual 215	b/d/i/a/a/f:a	()I
    //   280: if_icmpne +18 -> 298
    //   283: aload_0
    //   284: getfield 84	b/d/m/b/b:J3	Lcom/tplink/libtpstreamconnectionsocket/a;
    //   287: aload_0
    //   288: getfield 161	b/d/i/a/a/f:c	Ljava/lang/String;
    //   291: invokevirtual 217	com/tplink/libtpstreamconnectionsocket/a:e	(Ljava/lang/String;)Lcom/tplink/libtpstreamconnectionsocket/a;
    //   294: pop
    //   295: goto +11 -> 306
    //   298: aload_0
    //   299: getfield 84	b/d/m/b/b:J3	Lcom/tplink/libtpstreamconnectionsocket/a;
    //   302: invokevirtual 220	com/tplink/libtpstreamconnectionsocket/a:d	()Lcom/tplink/libtpstreamconnectionsocket/a;
    //   305: pop
    //   306: aload_0
    //   307: invokevirtual 215	b/d/i/a/a/f:a	()I
    //   310: ifne +6 -> 316
    //   313: goto +6 -> 319
    //   316: iconst_0
    //   317: istore 5
    //   319: aload_0
    //   320: getfield 84	b/d/m/b/b:J3	Lcom/tplink/libtpstreamconnectionsocket/a;
    //   323: aload_1
    //   324: iload 5
    //   326: invokevirtual 224	com/tplink/libtpstreamconnectionsocket/a:q	(Ljava/lang/String;Z)I
    //   329: istore 6
    //   331: iload 6
    //   333: sipush 200
    //   336: if_icmpne +73 -> 409
    //   339: aload_0
    //   340: getfield 84	b/d/m/b/b:J3	Lcom/tplink/libtpstreamconnectionsocket/a;
    //   343: invokevirtual 228	com/tplink/libtpstreamconnectionsocket/a:p	()Ljava/util/Map;
    //   346: astore_1
    //   347: aload_1
    //   348: ldc -26
    //   350: invokeinterface 233 2 0
    //   355: ifeq +54 -> 409
    //   358: aload_1
    //   359: ldc -26
    //   361: invokeinterface 236 2 0
    //   366: checkcast 61	java/lang/String
    //   369: astore_1
    //   370: new 238	java/lang/StringBuilder
    //   373: astore_3
    //   374: aload_3
    //   375: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   378: aload_3
    //   379: ldc -107
    //   381: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: pop
    //   385: aload_3
    //   386: aload_1
    //   387: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: pop
    //   391: ldc -11
    //   393: aload_3
    //   394: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: invokestatic 253	b/d/p/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   400: aload_0
    //   401: aload_1
    //   402: aload_2
    //   403: invokestatic 258	b/d/i/a/a/e:b	(Ljava/lang/String;Ljava/lang/String;)Lb/d/p/a;
    //   406: putfield 260	b/d/m/b/b:L3	Lb/d/p/a;
    //   409: iload 6
    //   411: sipush 200
    //   414: if_icmpeq +276 -> 690
    //   417: iload 6
    //   419: sipush 204
    //   422: if_icmpeq +268 -> 690
    //   425: new 238	java/lang/StringBuilder
    //   428: astore_2
    //   429: aload_2
    //   430: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   433: aload_2
    //   434: ldc_w 262
    //   437: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: pop
    //   441: aload_2
    //   442: aload_0
    //   443: getfield 161	b/d/i/a/a/f:c	Ljava/lang/String;
    //   446: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: pop
    //   450: aload_2
    //   451: ldc_w 264
    //   454: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: pop
    //   458: aload_2
    //   459: iload 6
    //   461: invokevirtual 267	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   464: pop
    //   465: ldc -11
    //   467: aload_2
    //   468: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   471: invokestatic 253	b/d/p/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   474: iload 6
    //   476: sipush 401
    //   479: if_icmpne +201 -> 680
    //   482: sipush 256
    //   485: aload_0
    //   486: invokevirtual 215	b/d/i/a/a/f:a	()I
    //   489: if_icmpne +58 -> 547
    //   492: aload_0
    //   493: getfield 151	b/d/m/b/b:p2	Lb/d/m/b/a;
    //   496: astore 7
    //   498: aload 7
    //   500: ifnull +97 -> 597
    //   503: aload_0
    //   504: getfield 161	b/d/i/a/a/f:c	Ljava/lang/String;
    //   507: astore_2
    //   508: aload_0
    //   509: getfield 163	b/d/m/b/b:N3	Ljava/lang/String;
    //   512: astore_1
    //   513: aload_0
    //   514: getfield 165	b/d/m/b/b:M3	I
    //   517: istore 8
    //   519: new 76	java/lang/Exception
    //   522: astore_3
    //   523: aload_3
    //   524: iload 6
    //   526: invokestatic 271	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   529: invokespecial 182	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   532: aload 7
    //   534: aload_2
    //   535: aload_1
    //   536: iload 8
    //   538: aload_3
    //   539: invokeinterface 178 5 0
    //   544: goto +53 -> 597
    //   547: aload_0
    //   548: getfield 151	b/d/m/b/b:p2	Lb/d/m/b/a;
    //   551: astore 7
    //   553: aload 7
    //   555: ifnull +42 -> 597
    //   558: aload_0
    //   559: getfield 161	b/d/i/a/a/f:c	Ljava/lang/String;
    //   562: astore_2
    //   563: aload_0
    //   564: getfield 163	b/d/m/b/b:N3	Ljava/lang/String;
    //   567: astore_1
    //   568: aload_0
    //   569: getfield 165	b/d/m/b/b:M3	I
    //   572: istore 8
    //   574: new 273	com/tplink/libtpstreamconnectionsocket/EncryptException
    //   577: astore_3
    //   578: aload_3
    //   579: ldc_w 275
    //   582: invokespecial 276	com/tplink/libtpstreamconnectionsocket/EncryptException:<init>	(Ljava/lang/String;)V
    //   585: aload 7
    //   587: aload_2
    //   588: aload_1
    //   589: iload 8
    //   591: aload_3
    //   592: invokeinterface 178 5 0
    //   597: aload_0
    //   598: getfield 184	b/d/m/b/b:p3	Lb/d/m/b/d;
    //   601: astore_1
    //   602: aload_1
    //   603: ifnull +32 -> 635
    //   606: aload_0
    //   607: getfield 161	b/d/i/a/a/f:c	Ljava/lang/String;
    //   610: astore_2
    //   611: aload_0
    //   612: getfield 187	b/d/i/a/a/f:x	I
    //   615: istore 8
    //   617: new 76	java/lang/Exception
    //   620: astore_3
    //   621: aload_3
    //   622: invokespecial 188	java/lang/Exception:<init>	()V
    //   625: aload_1
    //   626: aload_2
    //   627: iload 8
    //   629: aload_3
    //   630: invokeinterface 193 4 0
    //   635: aload_0
    //   636: getfield 84	b/d/m/b/b:J3	Lcom/tplink/libtpstreamconnectionsocket/a;
    //   639: astore_2
    //   640: aload_2
    //   641: ifnull +7 -> 648
    //   644: aload_2
    //   645: invokevirtual 278	com/tplink/libtpstreamconnectionsocket/a:f	()V
    //   648: getstatic 281	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   651: astore_1
    //   652: aload_0
    //   653: iconst_0
    //   654: putfield 39	b/d/m/b/b:I3	Z
    //   657: aload_0
    //   658: invokevirtual 283	b/d/m/b/b:q	()V
    //   661: aload_0
    //   662: getfield 84	b/d/m/b/b:J3	Lcom/tplink/libtpstreamconnectionsocket/a;
    //   665: astore_2
    //   666: aload_2
    //   667: ifnull +7 -> 674
    //   670: aload_2
    //   671: invokevirtual 278	com/tplink/libtpstreamconnectionsocket/a:f	()V
    //   674: aload_0
    //   675: invokevirtual 286	b/d/m/b/b:m	()V
    //   678: aload_1
    //   679: areturn
    //   680: new 288	java/io/IOException
    //   683: astore_2
    //   684: aload_2
    //   685: invokespecial 289	java/io/IOException:<init>	()V
    //   688: aload_2
    //   689: athrow
    //   690: new 238	java/lang/StringBuilder
    //   693: astore_2
    //   694: aload_2
    //   695: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   698: aload_2
    //   699: ldc_w 262
    //   702: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: pop
    //   706: aload_2
    //   707: aload_0
    //   708: getfield 161	b/d/i/a/a/f:c	Ljava/lang/String;
    //   711: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   714: pop
    //   715: aload_2
    //   716: ldc_w 291
    //   719: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   722: pop
    //   723: aload_2
    //   724: aload_0
    //   725: invokevirtual 215	b/d/i/a/a/f:a	()I
    //   728: invokevirtual 267	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   731: pop
    //   732: ldc -11
    //   734: aload_2
    //   735: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   738: invokestatic 253	b/d/p/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   741: aload_0
    //   742: invokevirtual 294	b/d/m/b/b:n	()V
    //   745: aload_0
    //   746: iconst_0
    //   747: putfield 39	b/d/m/b/b:I3	Z
    //   750: aload_0
    //   751: invokevirtual 283	b/d/m/b/b:q	()V
    //   754: aload_0
    //   755: getfield 84	b/d/m/b/b:J3	Lcom/tplink/libtpstreamconnectionsocket/a;
    //   758: astore_2
    //   759: aload_2
    //   760: ifnull +136 -> 896
    //   763: goto +129 -> 892
    //   766: astore_1
    //   767: goto +137 -> 904
    //   770: astore_2
    //   771: new 238	java/lang/StringBuilder
    //   774: astore_1
    //   775: aload_1
    //   776: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   779: aload_1
    //   780: ldc_w 262
    //   783: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   786: pop
    //   787: aload_1
    //   788: aload_0
    //   789: getfield 161	b/d/i/a/a/f:c	Ljava/lang/String;
    //   792: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: pop
    //   796: aload_1
    //   797: ldc_w 296
    //   800: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   803: pop
    //   804: aload_1
    //   805: aload_2
    //   806: invokevirtual 297	java/lang/Exception:toString	()Ljava/lang/String;
    //   809: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   812: pop
    //   813: ldc -11
    //   815: aload_1
    //   816: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   819: invokestatic 253	b/d/p/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   822: aload_0
    //   823: getfield 151	b/d/m/b/b:p2	Lb/d/m/b/a;
    //   826: astore_1
    //   827: aload_1
    //   828: ifnull +22 -> 850
    //   831: aload_1
    //   832: aload_0
    //   833: getfield 161	b/d/i/a/a/f:c	Ljava/lang/String;
    //   836: aload_0
    //   837: getfield 163	b/d/m/b/b:N3	Ljava/lang/String;
    //   840: aload_0
    //   841: getfield 165	b/d/m/b/b:M3	I
    //   844: aload_2
    //   845: invokeinterface 178 5 0
    //   850: aload_0
    //   851: getfield 184	b/d/m/b/b:p3	Lb/d/m/b/d;
    //   854: astore_1
    //   855: aload_1
    //   856: ifnull +18 -> 874
    //   859: aload_1
    //   860: aload_0
    //   861: getfield 161	b/d/i/a/a/f:c	Ljava/lang/String;
    //   864: aload_0
    //   865: getfield 187	b/d/i/a/a/f:x	I
    //   868: aload_2
    //   869: invokeinterface 193 4 0
    //   874: aload_0
    //   875: iconst_0
    //   876: putfield 39	b/d/m/b/b:I3	Z
    //   879: aload_0
    //   880: invokevirtual 283	b/d/m/b/b:q	()V
    //   883: aload_0
    //   884: getfield 84	b/d/m/b/b:J3	Lcom/tplink/libtpstreamconnectionsocket/a;
    //   887: astore_2
    //   888: aload_2
    //   889: ifnull +7 -> 896
    //   892: aload_2
    //   893: invokevirtual 278	com/tplink/libtpstreamconnectionsocket/a:f	()V
    //   896: aload_0
    //   897: invokevirtual 286	b/d/m/b/b:m	()V
    //   900: getstatic 199	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   903: areturn
    //   904: aload_0
    //   905: iconst_0
    //   906: putfield 39	b/d/m/b/b:I3	Z
    //   909: aload_0
    //   910: invokevirtual 283	b/d/m/b/b:q	()V
    //   913: aload_0
    //   914: getfield 84	b/d/m/b/b:J3	Lcom/tplink/libtpstreamconnectionsocket/a;
    //   917: astore_2
    //   918: aload_2
    //   919: ifnull +7 -> 926
    //   922: aload_2
    //   923: invokevirtual 278	com/tplink/libtpstreamconnectionsocket/a:f	()V
    //   926: aload_0
    //   927: invokevirtual 286	b/d/m/b/b:m	()V
    //   930: aload_1
    //   931: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	932	0	this	b
    //   3	676	1	localObject1	Object
    //   766	1	1	localObject2	Object
    //   774	157	1	localObject3	Object
    //   5	755	2	localObject4	Object
    //   770	99	2	localException	Exception
    //   887	36	2	locala	com.tplink.libtpstreamconnectionsocket.a
    //   54	576	3	localObject5	Object
    //   79	6	4	bool1	boolean
    //   82	243	5	bool2	boolean
    //   329	196	6	i	int
    //   496	90	7	locala1	a
    //   517	111	8	j	int
    // Exception table:
    //   from	to	target	type
    //   224	295	766	finally
    //   298	306	766	finally
    //   306	313	766	finally
    //   319	331	766	finally
    //   339	409	766	finally
    //   425	474	766	finally
    //   482	498	766	finally
    //   503	544	766	finally
    //   547	553	766	finally
    //   558	597	766	finally
    //   597	602	766	finally
    //   606	635	766	finally
    //   635	640	766	finally
    //   644	648	766	finally
    //   648	652	766	finally
    //   680	690	766	finally
    //   690	745	766	finally
    //   771	827	766	finally
    //   831	850	766	finally
    //   850	855	766	finally
    //   859	874	766	finally
    //   224	295	770	java/lang/Exception
    //   298	306	770	java/lang/Exception
    //   306	313	770	java/lang/Exception
    //   319	331	770	java/lang/Exception
    //   339	409	770	java/lang/Exception
    //   425	474	770	java/lang/Exception
    //   482	498	770	java/lang/Exception
    //   503	544	770	java/lang/Exception
    //   547	553	770	java/lang/Exception
    //   558	597	770	java/lang/Exception
    //   597	602	770	java/lang/Exception
    //   606	635	770	java/lang/Exception
    //   635	640	770	java/lang/Exception
    //   644	648	770	java/lang/Exception
    //   648	652	770	java/lang/Exception
    //   680	690	770	java/lang/Exception
    //   690	745	770	java/lang/Exception
  }
  
  protected void m() {}
  
  protected void n()
    throws Exception
  {
    if (!TextUtils.isEmpty(this.Q3))
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("requestDownload ");
      ((StringBuilder)???).append(this.Q3);
      b.d.p.d.a("DownloadStreamConnection", ((StringBuilder)???).toString());
      ??? = new HashMap();
      ((Map)???).put("X-Data-Window-Size", "50");
      this.J3.t(this.Q3, (Map)???);
    }
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      ??? = null;
      while (this.I3)
      {
        this.J3.g();
        Object localObject2 = this.J3.p();
        if ((((Map)localObject2).size() != 0) && (((Map)localObject2).containsKey("Content-Type")))
        {
          boolean bool = this.y;
          int i = 0;
          if (bool)
          {
            this.y = false;
            localObject4 = this.p3;
            if (localObject4 != null) {
              ((d)localObject4).r(this.c, this.x);
            }
          }
          Object localObject4 = (String)((Map)localObject2).get("Content-Type");
          String str = (String)((Map)localObject2).get("X-Session-Id");
          int j = i;
          if (((Map)localObject2).containsKey("X-If-Encrypt"))
          {
            j = i;
            if ("1".equals(((Map)localObject2).get("X-If-Encrypt"))) {
              j = 1;
            }
          }
          Object localObject5;
          if ("image/jpeg".equals(localObject4))
          {
            localObject2 = this.J3.m();
            localObject4 = localObject2;
            if (j != 0)
            {
              localObject5 = this.L3;
              localObject4 = localObject2;
              if (localObject5 != null) {
                localObject4 = ((b.d.p.a)localObject5).a((byte[])localObject2, localObject2.length);
              }
            }
            localObject5 = this.K3;
            localObject2 = ???;
            if (localObject5 != null)
            {
              localObject2 = ???;
              if (((String)localObject5).equals(str))
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("session ");
                ((StringBuilder)localObject2).append(str);
                ((StringBuilder)localObject2).append(" rawData ");
                ((StringBuilder)localObject2).append(localObject4.length);
                b.d.p.d.a("DownloadStreamConnection", ((StringBuilder)localObject2).toString());
                localObject5 = (ByteBuffer)localHashMap.get(this.K3);
                localObject2 = localObject5;
                if (localObject5 == null)
                {
                  localObject2 = ByteBuffer.allocate(102400);
                  localHashMap.put(this.K3, localObject2);
                }
                ((ByteBuffer)localObject2).put((byte[])localObject4);
                localObject2 = ???;
              }
            }
          }
          else
          {
            localObject2 = ???;
            if ("application/json".equals(localObject4))
            {
              localObject4 = this.J3.m();
              localObject2 = localObject4;
              if (j != 0)
              {
                localObject5 = this.L3;
                localObject2 = localObject4;
                if (localObject5 != null) {
                  localObject2 = ((b.d.p.a)localObject5).a((byte[])localObject4, localObject4.length);
                }
              }
              localObject2 = new String((byte[])localObject2);
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("payload: ");
              ((StringBuilder)localObject4).append((String)localObject2);
              b.d.p.d.a("DownloadStreamConnection", ((StringBuilder)localObject4).toString());
              localObject5 = (CommonPayload)b.d.i.a.b.b.b((String)localObject2, CommonPayload.class);
              if ("notification".equals(((CommonPayload)localObject5).getType()))
              {
                localObject2 = b.d.i.a.b.b.c((CommonPayload)localObject5);
                if ((localObject2 != null) && (this.P3 != null))
                {
                  ??? = new StringBuilder();
                  ((StringBuilder)???).append("event type ");
                  ((StringBuilder)???).append(((StreamControlNotification)localObject2).getEventType());
                  b.d.p.d.a("DownloadStreamConnection", ((StringBuilder)???).toString());
                  this.P3.a(this.c, (StreamControlNotification)localObject2);
                }
                localObject2 = o((StreamControlNotification)localObject2);
              }
              else
              {
                localObject2 = ???;
                if ("response".equals(((CommonPayload)localObject5).getType())) {
                  if (this.K3 == null)
                  {
                    localObject5 = (GetDownloadResponse)b.d.i.a.b.b.e((CommonPayload)localObject5, GetDownloadResponse.class).getResult();
                    if ((((Response)localObject5).getErrorCode() == 0) && (!TextUtils.isEmpty(((GetDownloadResponse)localObject5).getSessionId())))
                    {
                      x(((GetDownloadResponse)localObject5).getSessionId());
                      localObject4 = this.R3;
                      localObject2 = ???;
                      if (localObject4 != null)
                      {
                        ((a)localObject4).a();
                        localObject2 = ???;
                      }
                    }
                    else
                    {
                      localObject4 = this.R3;
                      localObject2 = ???;
                      if (localObject4 != null)
                      {
                        ((a)localObject4).b(((Response)localObject5).getErrorCode());
                        localObject2 = ???;
                      }
                    }
                  }
                  else
                  {
                    localObject4 = this.P3;
                    localObject2 = ???;
                    if (localObject4 != null)
                    {
                      ((n)localObject4).c((CommonPayload)localObject5);
                      localObject2 = ???;
                    }
                  }
                }
              }
            }
          }
          localObject4 = this.K3;
          ??? = localObject2;
          if (localObject4 != null)
          {
            ??? = localObject2;
            if (((String)localObject4).equals(str))
            {
              ??? = localObject2;
              if (localObject2 != null)
              {
                ??? = localObject2;
                if ("finished".equals(((StreamStatus)localObject2).getStatus()))
                {
                  localObject2 = (ByteBuffer)localHashMap.remove(this.K3);
                  if (localObject2 != null)
                  {
                    ((ByteBuffer)localObject2).flip();
                    localObject4 = new byte[((ByteBuffer)localObject2).limit()];
                    ((ByteBuffer)localObject2).get((byte[])localObject4);
                    ??? = this.p2;
                    if (??? != null) {
                      ((a)???).a(this.c, this.N3, this.M3, (byte[])localObject4);
                    }
                    ((ByteBuffer)localObject2).clear();
                  }
                  else
                  {
                    ??? = this.p2;
                    if (??? != null) {
                      ((a)???).b(this.c, this.N3, this.M3, new Exception("image data null"));
                    }
                  }
                  synchronized (this.O3)
                  {
                    this.O3.notifyAll();
                    this.O3.wait();
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void p()
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("设备：");
    ((StringBuilder)???).append(this.c);
    ((StringBuilder)???).append("Download流被release()");
    b.d.p.d.a("DownloadStreamConnection", ((StringBuilder)???).toString());
    this.I3 = false;
    synchronized (this.O3)
    {
      this.O3.notifyAll();
      this.p2 = null;
      this.p3 = null;
      this.R3 = null;
      ??? = this.H3;
      if (??? != null) {
        ((Future)???).cancel(true);
      }
      return;
    }
  }
  
  protected void q()
  {
    if ((this.J3 != null) && (!TextUtils.isEmpty(this.K3))) {
      try
      {
        int i = this.P3.b();
        Object localObject1 = new com/tplink/libtpcommonstream/stream/control/request/DoStopRequest;
        ((DoStopRequest)localObject1).<init>();
        Object localObject2 = new com/tplink/libtpcommonstream/stream/control/common/StreamControlRequest;
        ((StreamControlRequest)localObject2).<init>(localObject1);
        ((StreamControlRequest)localObject2).setSeq(i);
        localObject2 = b.d.i.a.b.b.d((StreamControlRequest)localObject2);
        localObject1 = new java/util/HashMap;
        ((HashMap)localObject1).<init>();
        ((Map)localObject1).put("Content-Type", "application/json");
        ((Map)localObject1).put("X-Session-Id", this.K3);
        this.J3.I(true);
        this.J3.D((Map)localObject1, (String)localObject2);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void r(n paramn)
  {
    this.P3 = paramn;
  }
  
  public void s(a parama)
  {
    this.R3 = parama;
  }
  
  public void t(a parama)
  {
    this.p2 = parama;
  }
  
  public void u(int paramInt)
  {
    this.M3 = paramInt;
  }
  
  public void v(d paramd)
  {
    this.p3 = paramd;
  }
  
  public void w(Future<Boolean> paramFuture)
  {
    this.H3 = paramFuture;
  }
  
  public void x(String paramString)
  {
    this.K3 = paramString;
  }
  
  public void y(String paramString)
  {
    this.N3 = paramString;
  }
  
  public void z(String paramString)
  {
    this.K3 = paramString;
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void b(int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\m\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */