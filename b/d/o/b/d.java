package b.d.o.b;

import android.text.TextUtils;
import b.d.i.a.b.b;
import b.d.i.a.b.c.n;
import com.tplink.libtpappcommonmedia.bean.stream.BitStreamType;
import com.tplink.libtpappcommonmedia.exception.CameraException;
import com.tplink.libtpcommonstream.stream.control.common.CommonPayload;
import com.tplink.libtpcommonstream.stream.control.common.StreamControlNotification;
import com.tplink.libtpcommonstream.stream.control.common.StreamControlRequest;
import com.tplink.libtpcommonstream.stream.control.common.StreamControlResponse;
import com.tplink.libtpcommonstream.stream.control.notification.ChannelMotorStatus;
import com.tplink.libtpcommonstream.stream.control.notification.MotorStatus;
import com.tplink.libtpcommonstream.stream.control.request.DoStopRequest;
import com.tplink.libtpcommonstream.stream.control.response.GetPreviewResponse;
import com.tplink.libtpcommonstream.stream.control.response.Response;
import com.tplink.libtpmediastatistics.ConnectionInfoVO;
import com.tplink.libtpmediastatistics.ConnectionVO;
import com.tplink.libtpmediastatistics.OnceConnectionVO;
import com.tplink.libtpmediastatistics.StatisticsManager;
import com.tplink.libtpmediastatistics.StatisticsStreamType;
import com.tplink.libtpmediastatistics.StopReason;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

public class d
  extends b.d.i.a.a.f
{
  protected f H3;
  protected n I3;
  protected Future<Boolean> J3;
  protected com.tplink.libtpstreamconnectionsocket.a K3;
  protected String L3;
  protected volatile boolean M3;
  protected b.d.p.a N3;
  protected final String O3;
  protected final String P3;
  protected boolean Q3;
  protected long R3;
  protected long S3;
  protected boolean T3;
  private String p2 = "LiveStreamConnection";
  protected c p3;
  
  public d(String paramString1, String paramString2)
  {
    this.O3 = paramString1;
    this.P3 = paramString2;
    this.M3 = true;
    this.L3 = null;
    this.Q3 = true;
  }
  
  public void f(String paramString)
  {
    if ((this.K3 != null) && (!TextUtils.isEmpty(this.O3)))
    {
      HashMap localHashMap = new HashMap();
      if (!TextUtils.isEmpty(this.L3)) {
        localHashMap.put("X-Session-Id", this.L3);
      }
      this.K3.t(paramString, localHashMap);
    }
  }
  
  /* Error */
  public Boolean l()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	b/d/o/b/d:p2	Ljava/lang/String;
    //   4: astore_1
    //   5: new 89	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   12: astore_2
    //   13: aload_2
    //   14: ldc 92
    //   16: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: pop
    //   20: aload_2
    //   21: aload_0
    //   22: getfield 99	b/d/i/a/a/f:c	Ljava/lang/String;
    //   25: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload_2
    //   30: ldc 101
    //   32: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload_2
    //   37: aload_0
    //   38: getfield 104	b/d/i/a/a/f:d	Ljava/lang/String;
    //   41: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload_2
    //   46: ldc 106
    //   48: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload_2
    //   53: aload_0
    //   54: invokevirtual 110	b/d/i/a/a/f:a	()I
    //   57: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload_1
    //   62: aload_2
    //   63: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 121	b/d/p/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: aload_0
    //   70: invokevirtual 124	b/d/o/b/d:m	()V
    //   73: invokestatic 128	b/d/d/a/a:d	()Ljava/lang/String;
    //   76: astore_2
    //   77: aload_2
    //   78: astore_1
    //   79: aload_2
    //   80: invokestatic 68	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   83: ifeq +7 -> 90
    //   86: invokestatic 132	com/tplink/libmediakit/jniinterface/GenKey:a	()Ljava/lang/String;
    //   89: astore_1
    //   90: aload_0
    //   91: getfield 38	b/d/o/b/d:p2	Ljava/lang/String;
    //   94: astore_2
    //   95: new 89	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   102: astore_3
    //   103: aload_3
    //   104: ldc -122
    //   106: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload_3
    //   111: ldc -120
    //   113: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload_3
    //   118: ldc -118
    //   120: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload_3
    //   125: aload_1
    //   126: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload_3
    //   131: ldc 106
    //   133: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload_3
    //   138: aload_0
    //   139: invokevirtual 110	b/d/i/a/a/f:a	()I
    //   142: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload_2
    //   147: aload_3
    //   148: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 121	b/d/p/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   154: aload_0
    //   155: invokevirtual 142	b/d/i/a/a/f:e	()Z
    //   158: ifeq +51 -> 209
    //   161: new 70	java/util/HashMap
    //   164: dup
    //   165: invokespecial 71	java/util/HashMap:<init>	()V
    //   168: astore_2
    //   169: aload_2
    //   170: ldc -112
    //   172: ldc -110
    //   174: invokeinterface 79 3 0
    //   179: pop
    //   180: aload_0
    //   181: getfield 104	b/d/i/a/a/f:d	Ljava/lang/String;
    //   184: aload_0
    //   185: getfield 149	b/d/i/a/a/f:f	I
    //   188: invokestatic 153	com/tplink/libtpstreamconnectionsocket/a:o	(Ljava/lang/String;I)Ljava/lang/String;
    //   191: astore_3
    //   192: invokestatic 158	b/d/i/a/c/a:a	()Lb/d/i/a/c/a;
    //   195: aload_3
    //   196: ldc -120
    //   198: aload_1
    //   199: ldc -96
    //   201: aload_2
    //   202: invokevirtual 163	b/d/i/a/c/a:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
    //   205: astore_2
    //   206: goto +6 -> 212
    //   209: ldc -91
    //   211: astore_2
    //   212: aload_0
    //   213: getfield 38	b/d/o/b/d:p2	Ljava/lang/String;
    //   216: astore 4
    //   218: new 89	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   225: astore_3
    //   226: aload_3
    //   227: ldc -89
    //   229: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload_3
    //   234: aload_2
    //   235: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload_3
    //   240: ldc 106
    //   242: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: pop
    //   246: aload_3
    //   247: aload_0
    //   248: invokevirtual 110	b/d/i/a/a/f:a	()I
    //   251: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: aload 4
    //   257: aload_3
    //   258: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokestatic 121	b/d/p/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   264: aload_2
    //   265: invokestatic 68	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   268: ifeq +132 -> 400
    //   271: aload_0
    //   272: invokevirtual 142	b/d/i/a/a/f:e	()Z
    //   275: ifeq +125 -> 400
    //   278: aload_0
    //   279: getfield 169	b/d/o/b/d:p3	Lb/d/o/b/c;
    //   282: ifnull +83 -> 365
    //   285: aload_0
    //   286: getfield 172	b/d/i/a/a/f:x	I
    //   289: bipush 17
    //   291: if_icmpeq +74 -> 365
    //   294: invokestatic 158	b/d/i/a/c/a:a	()Lb/d/i/a/c/a;
    //   297: invokevirtual 176	b/d/i/a/c/a:b	()Ljava/util/List;
    //   300: astore_1
    //   301: aload_1
    //   302: invokeinterface 180 1 0
    //   307: ifne +36 -> 343
    //   310: aload_0
    //   311: getfield 169	b/d/o/b/d:p3	Lb/d/o/b/c;
    //   314: aload_0
    //   315: getfield 99	b/d/i/a/a/f:c	Ljava/lang/String;
    //   318: aload_1
    //   319: aload_1
    //   320: invokeinterface 183 1 0
    //   325: iconst_1
    //   326: isub
    //   327: invokeinterface 187 2 0
    //   332: checkcast 53	java/lang/Exception
    //   335: invokeinterface 192 3 0
    //   340: goto +25 -> 365
    //   343: aload_0
    //   344: getfield 169	b/d/o/b/d:p3	Lb/d/o/b/c;
    //   347: aload_0
    //   348: getfield 99	b/d/i/a/a/f:c	Ljava/lang/String;
    //   351: new 53	java/lang/Exception
    //   354: dup
    //   355: ldc -62
    //   357: invokespecial 196	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   360: invokeinterface 192 3 0
    //   365: aload_0
    //   366: getfield 198	b/d/o/b/d:H3	Lb/d/o/b/f;
    //   369: astore_1
    //   370: aload_1
    //   371: ifnull +25 -> 396
    //   374: aload_1
    //   375: aload_0
    //   376: getfield 99	b/d/i/a/a/f:c	Ljava/lang/String;
    //   379: aload_0
    //   380: getfield 172	b/d/i/a/a/f:x	I
    //   383: iconst_0
    //   384: new 53	java/lang/Exception
    //   387: dup
    //   388: invokespecial 199	java/lang/Exception:<init>	()V
    //   391: invokeinterface 204 5 0
    //   396: getstatic 210	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   399: areturn
    //   400: new 81	com/tplink/libtpstreamconnectionsocket/a
    //   403: astore_3
    //   404: aload_3
    //   405: aload_0
    //   406: getfield 104	b/d/i/a/a/f:d	Ljava/lang/String;
    //   409: aload_0
    //   410: getfield 149	b/d/i/a/a/f:f	I
    //   413: invokespecial 213	com/tplink/libtpstreamconnectionsocket/a:<init>	(Ljava/lang/String;I)V
    //   416: aload_0
    //   417: aload_3
    //   418: putfield 62	b/d/o/b/d:K3	Lcom/tplink/libtpstreamconnectionsocket/a;
    //   421: aload_3
    //   422: sipush 30000
    //   425: invokevirtual 217	com/tplink/libtpstreamconnectionsocket/a:F	(I)Lcom/tplink/libtpstreamconnectionsocket/a;
    //   428: pop
    //   429: aload_0
    //   430: getfield 62	b/d/o/b/d:K3	Lcom/tplink/libtpstreamconnectionsocket/a;
    //   433: sipush 15000
    //   436: invokevirtual 220	com/tplink/libtpstreamconnectionsocket/a:H	(I)Lcom/tplink/libtpstreamconnectionsocket/a;
    //   439: pop
    //   440: aload_0
    //   441: getfield 62	b/d/o/b/d:K3	Lcom/tplink/libtpstreamconnectionsocket/a;
    //   444: ldc -96
    //   446: invokevirtual 224	com/tplink/libtpstreamconnectionsocket/a:G	(Ljava/lang/String;)Lcom/tplink/libtpstreamconnectionsocket/a;
    //   449: pop
    //   450: bipush 17
    //   452: aload_0
    //   453: invokevirtual 110	b/d/i/a/a/f:a	()I
    //   456: if_icmpne +18 -> 474
    //   459: aload_0
    //   460: getfield 62	b/d/o/b/d:K3	Lcom/tplink/libtpstreamconnectionsocket/a;
    //   463: aload_0
    //   464: getfield 99	b/d/i/a/a/f:c	Ljava/lang/String;
    //   467: invokevirtual 226	com/tplink/libtpstreamconnectionsocket/a:e	(Ljava/lang/String;)Lcom/tplink/libtpstreamconnectionsocket/a;
    //   470: pop
    //   471: goto +11 -> 482
    //   474: aload_0
    //   475: getfield 62	b/d/o/b/d:K3	Lcom/tplink/libtpstreamconnectionsocket/a;
    //   478: invokevirtual 229	com/tplink/libtpstreamconnectionsocket/a:d	()Lcom/tplink/libtpstreamconnectionsocket/a;
    //   481: pop
    //   482: aload_0
    //   483: invokevirtual 110	b/d/i/a/a/f:a	()I
    //   486: ifne +9 -> 495
    //   489: iconst_1
    //   490: istore 5
    //   492: goto +6 -> 498
    //   495: iconst_0
    //   496: istore 5
    //   498: aload_0
    //   499: getfield 38	b/d/o/b/d:p2	Ljava/lang/String;
    //   502: astore_3
    //   503: new 89	java/lang/StringBuilder
    //   506: astore 4
    //   508: aload 4
    //   510: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   513: aload 4
    //   515: ldc -25
    //   517: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: pop
    //   521: aload 4
    //   523: iload 5
    //   525: invokevirtual 234	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   528: pop
    //   529: aload 4
    //   531: ldc 106
    //   533: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: pop
    //   537: aload 4
    //   539: aload_0
    //   540: invokevirtual 110	b/d/i/a/a/f:a	()I
    //   543: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   546: pop
    //   547: aload_3
    //   548: aload 4
    //   550: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   553: invokestatic 121	b/d/p/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   556: aload_0
    //   557: getfield 62	b/d/o/b/d:K3	Lcom/tplink/libtpstreamconnectionsocket/a;
    //   560: aload_2
    //   561: iload 5
    //   563: invokevirtual 238	com/tplink/libtpstreamconnectionsocket/a:q	(Ljava/lang/String;Z)I
    //   566: istore 6
    //   568: aload_0
    //   569: getfield 38	b/d/o/b/d:p2	Ljava/lang/String;
    //   572: astore_2
    //   573: new 89	java/lang/StringBuilder
    //   576: astore_3
    //   577: aload_3
    //   578: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   581: aload_3
    //   582: ldc -16
    //   584: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: pop
    //   588: aload_3
    //   589: iload 6
    //   591: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   594: pop
    //   595: aload_3
    //   596: ldc 106
    //   598: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: pop
    //   602: aload_3
    //   603: aload_0
    //   604: invokevirtual 110	b/d/i/a/a/f:a	()I
    //   607: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   610: pop
    //   611: aload_2
    //   612: aload_3
    //   613: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   616: invokestatic 121	b/d/p/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   619: iload 6
    //   621: sipush 200
    //   624: if_icmpne +84 -> 708
    //   627: aload_0
    //   628: getfield 62	b/d/o/b/d:K3	Lcom/tplink/libtpstreamconnectionsocket/a;
    //   631: invokevirtual 244	com/tplink/libtpstreamconnectionsocket/a:p	()Ljava/util/Map;
    //   634: astore_2
    //   635: aload_2
    //   636: ldc -10
    //   638: invokeinterface 250 2 0
    //   643: ifeq +65 -> 708
    //   646: aload_2
    //   647: ldc -10
    //   649: invokeinterface 253 2 0
    //   654: checkcast 255	java/lang/String
    //   657: astore_2
    //   658: aload_0
    //   659: getfield 38	b/d/o/b/d:p2	Ljava/lang/String;
    //   662: astore 4
    //   664: new 89	java/lang/StringBuilder
    //   667: astore_3
    //   668: aload_3
    //   669: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   672: aload_3
    //   673: ldc -91
    //   675: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: pop
    //   679: aload_3
    //   680: aload_2
    //   681: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   684: pop
    //   685: aload 4
    //   687: aload_3
    //   688: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   691: invokestatic 121	b/d/p/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   694: aload_0
    //   695: aload_2
    //   696: aload_1
    //   697: invokestatic 260	b/d/i/a/a/e:b	(Ljava/lang/String;Ljava/lang/String;)Lb/d/p/a;
    //   700: putfield 262	b/d/o/b/d:N3	Lb/d/p/a;
    //   703: aload_0
    //   704: iconst_1
    //   705: putfield 264	b/d/o/b/d:T3	Z
    //   708: iload 6
    //   710: sipush 200
    //   713: if_icmpeq +307 -> 1020
    //   716: iload 6
    //   718: sipush 204
    //   721: if_icmpeq +299 -> 1020
    //   724: aload_0
    //   725: getfield 38	b/d/o/b/d:p2	Ljava/lang/String;
    //   728: astore_2
    //   729: new 89	java/lang/StringBuilder
    //   732: astore_1
    //   733: aload_1
    //   734: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   737: aload_1
    //   738: ldc 92
    //   740: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: pop
    //   744: aload_1
    //   745: aload_0
    //   746: getfield 99	b/d/i/a/a/f:c	Ljava/lang/String;
    //   749: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   752: pop
    //   753: aload_1
    //   754: ldc_w 266
    //   757: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   760: pop
    //   761: aload_1
    //   762: iload 6
    //   764: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   767: pop
    //   768: aload_1
    //   769: ldc 106
    //   771: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   774: pop
    //   775: aload_1
    //   776: aload_0
    //   777: invokevirtual 110	b/d/i/a/a/f:a	()I
    //   780: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   783: pop
    //   784: aload_2
    //   785: aload_1
    //   786: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   789: invokestatic 121	b/d/p/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   792: iload 6
    //   794: sipush 401
    //   797: if_icmpne +213 -> 1010
    //   800: sipush 256
    //   803: aload_0
    //   804: invokevirtual 110	b/d/i/a/a/f:a	()I
    //   807: if_icmpne +41 -> 848
    //   810: aload_0
    //   811: getfield 169	b/d/o/b/d:p3	Lb/d/o/b/c;
    //   814: astore_1
    //   815: aload_1
    //   816: ifnull +65 -> 881
    //   819: aload_0
    //   820: getfield 99	b/d/i/a/a/f:c	Ljava/lang/String;
    //   823: astore_2
    //   824: new 53	java/lang/Exception
    //   827: astore_3
    //   828: aload_3
    //   829: iload 6
    //   831: invokestatic 270	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   834: invokespecial 196	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   837: aload_1
    //   838: aload_2
    //   839: aload_3
    //   840: invokeinterface 192 3 0
    //   845: goto +36 -> 881
    //   848: aload_0
    //   849: getfield 169	b/d/o/b/d:p3	Lb/d/o/b/c;
    //   852: astore_1
    //   853: aload_1
    //   854: ifnull +27 -> 881
    //   857: aload_0
    //   858: getfield 99	b/d/i/a/a/f:c	Ljava/lang/String;
    //   861: astore_2
    //   862: new 272	com/tplink/libtpstreamconnectionsocket/EncryptException
    //   865: astore_3
    //   866: aload_3
    //   867: ldc_w 274
    //   870: invokespecial 275	com/tplink/libtpstreamconnectionsocket/EncryptException:<init>	(Ljava/lang/String;)V
    //   873: aload_1
    //   874: aload_2
    //   875: aload_3
    //   876: invokeinterface 192 3 0
    //   881: aload_0
    //   882: getfield 198	b/d/o/b/d:H3	Lb/d/o/b/f;
    //   885: astore_3
    //   886: aload_3
    //   887: ifnull +33 -> 920
    //   890: aload_0
    //   891: getfield 99	b/d/i/a/a/f:c	Ljava/lang/String;
    //   894: astore_2
    //   895: aload_0
    //   896: getfield 172	b/d/i/a/a/f:x	I
    //   899: istore 6
    //   901: new 53	java/lang/Exception
    //   904: astore_1
    //   905: aload_1
    //   906: invokespecial 199	java/lang/Exception:<init>	()V
    //   909: aload_3
    //   910: aload_2
    //   911: iload 6
    //   913: iconst_0
    //   914: aload_1
    //   915: invokeinterface 204 5 0
    //   920: aload_0
    //   921: getfield 62	b/d/o/b/d:K3	Lcom/tplink/libtpstreamconnectionsocket/a;
    //   924: astore_1
    //   925: aload_1
    //   926: ifnull +7 -> 933
    //   929: aload_1
    //   930: invokevirtual 277	com/tplink/libtpstreamconnectionsocket/a:f	()V
    //   933: getstatic 280	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   936: astore_2
    //   937: aload_0
    //   938: getfield 38	b/d/o/b/d:p2	Ljava/lang/String;
    //   941: astore_3
    //   942: new 89	java/lang/StringBuilder
    //   945: dup
    //   946: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   949: astore_1
    //   950: aload_1
    //   951: ldc 92
    //   953: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   956: pop
    //   957: aload_1
    //   958: aload_0
    //   959: getfield 99	b/d/i/a/a/f:c	Ljava/lang/String;
    //   962: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   965: pop
    //   966: aload_1
    //   967: ldc_w 282
    //   970: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   973: pop
    //   974: aload_1
    //   975: aload_0
    //   976: invokevirtual 110	b/d/i/a/a/f:a	()I
    //   979: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   982: pop
    //   983: aload_3
    //   984: aload_1
    //   985: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   988: invokestatic 121	b/d/p/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   991: aload_0
    //   992: iconst_0
    //   993: putfield 44	b/d/o/b/d:M3	Z
    //   996: aload_0
    //   997: invokevirtual 285	b/d/o/b/d:r	()V
    //   1000: aload_0
    //   1001: invokevirtual 287	b/d/o/b/d:q	()V
    //   1004: aload_0
    //   1005: invokevirtual 290	b/d/o/b/d:n	()V
    //   1008: aload_2
    //   1009: areturn
    //   1010: new 292	java/io/IOException
    //   1013: astore_1
    //   1014: aload_1
    //   1015: invokespecial 293	java/io/IOException:<init>	()V
    //   1018: aload_1
    //   1019: athrow
    //   1020: aload_0
    //   1021: getfield 38	b/d/o/b/d:p2	Ljava/lang/String;
    //   1024: astore_2
    //   1025: new 89	java/lang/StringBuilder
    //   1028: astore_1
    //   1029: aload_1
    //   1030: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   1033: aload_1
    //   1034: ldc 92
    //   1036: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1039: pop
    //   1040: aload_1
    //   1041: aload_0
    //   1042: getfield 99	b/d/i/a/a/f:c	Ljava/lang/String;
    //   1045: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1048: pop
    //   1049: aload_1
    //   1050: ldc_w 295
    //   1053: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1056: pop
    //   1057: aload_1
    //   1058: aload_0
    //   1059: invokevirtual 110	b/d/i/a/a/f:a	()I
    //   1062: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1065: pop
    //   1066: aload_2
    //   1067: aload_1
    //   1068: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1071: invokestatic 121	b/d/p/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1074: aload_0
    //   1075: invokevirtual 297	b/d/o/b/d:o	()V
    //   1078: aload_0
    //   1079: getfield 38	b/d/o/b/d:p2	Ljava/lang/String;
    //   1082: astore_1
    //   1083: new 89	java/lang/StringBuilder
    //   1086: dup
    //   1087: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   1090: astore_2
    //   1091: goto +291 -> 1382
    //   1094: astore_1
    //   1095: goto +349 -> 1444
    //   1098: astore_1
    //   1099: aload_0
    //   1100: getfield 38	b/d/o/b/d:p2	Ljava/lang/String;
    //   1103: astore_3
    //   1104: new 89	java/lang/StringBuilder
    //   1107: astore_2
    //   1108: aload_2
    //   1109: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   1112: aload_2
    //   1113: ldc 92
    //   1115: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1118: pop
    //   1119: aload_2
    //   1120: aload_0
    //   1121: getfield 99	b/d/i/a/a/f:c	Ljava/lang/String;
    //   1124: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1127: pop
    //   1128: aload_2
    //   1129: ldc_w 299
    //   1132: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1135: pop
    //   1136: aload_2
    //   1137: aload_1
    //   1138: invokevirtual 300	java/lang/Exception:toString	()Ljava/lang/String;
    //   1141: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1144: pop
    //   1145: aload_2
    //   1146: ldc 106
    //   1148: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1151: pop
    //   1152: aload_2
    //   1153: aload_0
    //   1154: invokevirtual 110	b/d/i/a/a/f:a	()I
    //   1157: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1160: pop
    //   1161: aload_3
    //   1162: aload_2
    //   1163: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1166: invokestatic 302	b/d/p/d:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   1169: aload_1
    //   1170: invokevirtual 305	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1173: ifnull +39 -> 1212
    //   1176: aload_1
    //   1177: invokevirtual 305	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1180: ldc_w 307
    //   1183: invokevirtual 310	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1186: ifeq +26 -> 1212
    //   1189: aload_0
    //   1190: getfield 169	b/d/o/b/d:p3	Lb/d/o/b/c;
    //   1193: astore_2
    //   1194: aload_2
    //   1195: ifnull +42 -> 1237
    //   1198: aload_2
    //   1199: aload_0
    //   1200: getfield 99	b/d/i/a/a/f:c	Ljava/lang/String;
    //   1203: aload_1
    //   1204: invokeinterface 192 3 0
    //   1209: goto +28 -> 1237
    //   1212: aload_0
    //   1213: getfield 198	b/d/o/b/d:H3	Lb/d/o/b/f;
    //   1216: astore_2
    //   1217: aload_2
    //   1218: ifnull +19 -> 1237
    //   1221: aload_2
    //   1222: aload_0
    //   1223: getfield 99	b/d/i/a/a/f:c	Ljava/lang/String;
    //   1226: aload_0
    //   1227: getfield 172	b/d/i/a/a/f:x	I
    //   1230: iconst_1
    //   1231: aload_1
    //   1232: invokeinterface 204 5 0
    //   1237: aload_0
    //   1238: getfield 38	b/d/o/b/d:p2	Ljava/lang/String;
    //   1241: astore_1
    //   1242: new 89	java/lang/StringBuilder
    //   1245: dup
    //   1246: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   1249: astore_2
    //   1250: goto +132 -> 1382
    //   1253: astore_1
    //   1254: aload_0
    //   1255: getfield 38	b/d/o/b/d:p2	Ljava/lang/String;
    //   1258: astore_3
    //   1259: new 89	java/lang/StringBuilder
    //   1262: astore_2
    //   1263: aload_2
    //   1264: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   1267: aload_2
    //   1268: ldc 92
    //   1270: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1273: pop
    //   1274: aload_2
    //   1275: aload_0
    //   1276: getfield 99	b/d/i/a/a/f:c	Ljava/lang/String;
    //   1279: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1282: pop
    //   1283: aload_2
    //   1284: ldc_w 312
    //   1287: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1290: pop
    //   1291: aload_2
    //   1292: aload_1
    //   1293: invokevirtual 313	java/net/MalformedURLException:toString	()Ljava/lang/String;
    //   1296: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1299: pop
    //   1300: aload_2
    //   1301: ldc 106
    //   1303: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1306: pop
    //   1307: aload_2
    //   1308: aload_0
    //   1309: invokevirtual 110	b/d/i/a/a/f:a	()I
    //   1312: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1315: pop
    //   1316: aload_3
    //   1317: aload_2
    //   1318: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1321: invokestatic 121	b/d/p/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1324: aload_0
    //   1325: getfield 169	b/d/o/b/d:p3	Lb/d/o/b/c;
    //   1328: astore_2
    //   1329: aload_2
    //   1330: ifnull +14 -> 1344
    //   1333: aload_2
    //   1334: aload_0
    //   1335: getfield 99	b/d/i/a/a/f:c	Ljava/lang/String;
    //   1338: aload_1
    //   1339: invokeinterface 192 3 0
    //   1344: aload_0
    //   1345: getfield 198	b/d/o/b/d:H3	Lb/d/o/b/f;
    //   1348: astore_2
    //   1349: aload_2
    //   1350: ifnull +19 -> 1369
    //   1353: aload_2
    //   1354: aload_0
    //   1355: getfield 99	b/d/i/a/a/f:c	Ljava/lang/String;
    //   1358: aload_0
    //   1359: getfield 172	b/d/i/a/a/f:x	I
    //   1362: iconst_0
    //   1363: aload_1
    //   1364: invokeinterface 204 5 0
    //   1369: aload_0
    //   1370: getfield 38	b/d/o/b/d:p2	Ljava/lang/String;
    //   1373: astore_1
    //   1374: new 89	java/lang/StringBuilder
    //   1377: dup
    //   1378: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   1381: astore_2
    //   1382: aload_2
    //   1383: ldc 92
    //   1385: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1388: pop
    //   1389: aload_2
    //   1390: aload_0
    //   1391: getfield 99	b/d/i/a/a/f:c	Ljava/lang/String;
    //   1394: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1397: pop
    //   1398: aload_2
    //   1399: ldc_w 282
    //   1402: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1405: pop
    //   1406: aload_2
    //   1407: aload_0
    //   1408: invokevirtual 110	b/d/i/a/a/f:a	()I
    //   1411: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1414: pop
    //   1415: aload_1
    //   1416: aload_2
    //   1417: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1420: invokestatic 121	b/d/p/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1423: aload_0
    //   1424: iconst_0
    //   1425: putfield 44	b/d/o/b/d:M3	Z
    //   1428: aload_0
    //   1429: invokevirtual 285	b/d/o/b/d:r	()V
    //   1432: aload_0
    //   1433: invokevirtual 287	b/d/o/b/d:q	()V
    //   1436: aload_0
    //   1437: invokevirtual 290	b/d/o/b/d:n	()V
    //   1440: getstatic 210	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1443: areturn
    //   1444: aload_0
    //   1445: getfield 38	b/d/o/b/d:p2	Ljava/lang/String;
    //   1448: astore_3
    //   1449: new 89	java/lang/StringBuilder
    //   1452: dup
    //   1453: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   1456: astore_2
    //   1457: aload_2
    //   1458: ldc 92
    //   1460: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1463: pop
    //   1464: aload_2
    //   1465: aload_0
    //   1466: getfield 99	b/d/i/a/a/f:c	Ljava/lang/String;
    //   1469: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1472: pop
    //   1473: aload_2
    //   1474: ldc_w 282
    //   1477: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1480: pop
    //   1481: aload_2
    //   1482: aload_0
    //   1483: invokevirtual 110	b/d/i/a/a/f:a	()I
    //   1486: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1489: pop
    //   1490: aload_3
    //   1491: aload_2
    //   1492: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1495: invokestatic 121	b/d/p/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1498: aload_0
    //   1499: iconst_0
    //   1500: putfield 44	b/d/o/b/d:M3	Z
    //   1503: aload_0
    //   1504: invokevirtual 285	b/d/o/b/d:r	()V
    //   1507: aload_0
    //   1508: invokevirtual 287	b/d/o/b/d:q	()V
    //   1511: aload_0
    //   1512: invokevirtual 290	b/d/o/b/d:n	()V
    //   1515: aload_1
    //   1516: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1517	0	this	d
    //   4	1079	1	localObject1	Object
    //   1094	1	1	localObject2	Object
    //   1098	134	1	localException	Exception
    //   1241	1	1	str1	String
    //   1253	111	1	localMalformedURLException	java.net.MalformedURLException
    //   1373	143	1	str2	String
    //   12	1480	2	localObject3	Object
    //   102	1389	3	localObject4	Object
    //   216	470	4	localObject5	Object
    //   490	72	5	bool	boolean
    //   566	346	6	i	int
    // Exception table:
    //   from	to	target	type
    //   400	471	1094	finally
    //   474	482	1094	finally
    //   482	489	1094	finally
    //   498	619	1094	finally
    //   627	708	1094	finally
    //   724	792	1094	finally
    //   800	815	1094	finally
    //   819	845	1094	finally
    //   848	853	1094	finally
    //   857	881	1094	finally
    //   881	886	1094	finally
    //   890	920	1094	finally
    //   920	925	1094	finally
    //   929	933	1094	finally
    //   933	937	1094	finally
    //   1010	1020	1094	finally
    //   1020	1078	1094	finally
    //   1099	1194	1094	finally
    //   1198	1209	1094	finally
    //   1212	1217	1094	finally
    //   1221	1237	1094	finally
    //   1254	1329	1094	finally
    //   1333	1344	1094	finally
    //   1344	1349	1094	finally
    //   1353	1369	1094	finally
    //   400	471	1098	java/lang/Exception
    //   474	482	1098	java/lang/Exception
    //   482	489	1098	java/lang/Exception
    //   498	619	1098	java/lang/Exception
    //   627	708	1098	java/lang/Exception
    //   724	792	1098	java/lang/Exception
    //   800	815	1098	java/lang/Exception
    //   819	845	1098	java/lang/Exception
    //   848	853	1098	java/lang/Exception
    //   857	881	1098	java/lang/Exception
    //   881	886	1098	java/lang/Exception
    //   890	920	1098	java/lang/Exception
    //   920	925	1098	java/lang/Exception
    //   929	933	1098	java/lang/Exception
    //   933	937	1098	java/lang/Exception
    //   1010	1020	1098	java/lang/Exception
    //   1020	1078	1098	java/lang/Exception
    //   400	471	1253	java/net/MalformedURLException
    //   474	482	1253	java/net/MalformedURLException
    //   482	489	1253	java/net/MalformedURLException
    //   498	619	1253	java/net/MalformedURLException
    //   627	708	1253	java/net/MalformedURLException
    //   724	792	1253	java/net/MalformedURLException
    //   800	815	1253	java/net/MalformedURLException
    //   819	845	1253	java/net/MalformedURLException
    //   848	853	1253	java/net/MalformedURLException
    //   857	881	1253	java/net/MalformedURLException
    //   881	886	1253	java/net/MalformedURLException
    //   890	920	1253	java/net/MalformedURLException
    //   920	925	1253	java/net/MalformedURLException
    //   929	933	1253	java/net/MalformedURLException
    //   933	937	1253	java/net/MalformedURLException
    //   1010	1020	1253	java/net/MalformedURLException
    //   1020	1078	1253	java/net/MalformedURLException
  }
  
  protected void m()
  {
    this.T3 = false;
    this.R3 = System.currentTimeMillis();
  }
  
  protected void n()
  {
    if (256 != this.x)
    {
      long l = System.currentTimeMillis();
      this.S3 = l;
      int i = this.q;
      if (i == 1) {
        localObject1 = StatisticsStreamType.MIXED;
      } else if (i == 3) {
        localObject1 = StatisticsStreamType.VIDEO;
      } else {
        localObject1 = StatisticsStreamType.AUDIO;
      }
      i = Math.round((float)(l - this.R3) / 1000.0F);
      Object localObject2 = StatisticsManager.getInstance().getOnceConnectionCacheKey(this.c, (StatisticsStreamType)localObject1, this.x);
      OnceConnectionVO localOnceConnectionVO = StatisticsManager.getInstance().getAndRemoveOnceConnectionVO((String)localObject2);
      localOnceConnectionVO.setFlowUsed(this.K3.j());
      localOnceConnectionVO.setWatchTime(i);
      if (i > 7140) {
        localOnceConnectionVO.setStopReason(StopReason.RELAY_TIME_LIMIT.value());
      }
      String str = StatisticsManager.getInstance().getConnectionInfoCacheKey(this.c, (StatisticsStreamType)localObject1);
      localObject2 = StatisticsManager.getInstance().getConnectionInfoVO(str);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ConnectionInfoVO();
        StatisticsManager.getInstance().insertConnectionInfoVO(str, (ConnectionInfoVO)localObject1);
      }
      i = this.x;
      if (i == 16) {
        ((ConnectionInfoVO)localObject1).getP2pConnectionVO().addData(localOnceConnectionVO);
      } else if (i == 0) {
        ((ConnectionInfoVO)localObject1).getRelayConnectionVO().addData(localOnceConnectionVO);
      }
    }
  }
  
  protected void o()
    throws Exception
  {
    Object localObject1;
    Object localObject2;
    if (!TextUtils.isEmpty(this.O3))
    {
      localObject1 = this.p2;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("requestPreview ");
      ((StringBuilder)localObject2).append(this.O3);
      ((StringBuilder)localObject2).append(" contentType ");
      ((StringBuilder)localObject2).append(a());
      b.d.p.d.a((String)localObject1, ((StringBuilder)localObject2).toString());
      this.K3.t(this.O3, null);
    }
    while (this.M3)
    {
      this.K3.g();
      localObject2 = this.K3.p();
      if (((Map)localObject2).size() != 0)
      {
        Object localObject3;
        if ((this.y) && (this.p1))
        {
          this.z = true;
          this.y = false;
          if (this.H3 != null)
          {
            localObject3 = this.p2;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("liveStreamConnectionSuccess  contype ");
            ((StringBuilder)localObject1).append(a());
            b.d.p.d.a((String)localObject3, ((StringBuilder)localObject1).toString());
            this.H3.a(this.c, c(), a());
          }
          localObject1 = this.p3;
          if (localObject1 != null) {
            ((c)localObject1).a(this.c, a());
          }
        }
        if (((Map)localObject2).containsKey("Content-Type"))
        {
          localObject3 = (String)((Map)localObject2).get("Content-Type");
          localObject1 = (String)((Map)localObject2).get("X-Session-Id");
          int i;
          if ((((Map)localObject2).containsKey("X-If-Encrypt")) && ("1".equals(((Map)localObject2).get("X-If-Encrypt")))) {
            i = 1;
          } else {
            i = 0;
          }
          if ("video/mp2t".equals(localObject3))
          {
            this.p1 = true;
            localObject1 = this.K3.m();
            localObject2 = localObject1;
            if (i != 0)
            {
              localObject3 = this.N3;
              localObject2 = localObject1;
              if (localObject3 != null) {
                localObject2 = ((b.d.p.a)localObject3).a((byte[])localObject1, localObject1.length);
              }
            }
            if (this.L3 != null)
            {
              localObject1 = this.p3;
              if (localObject1 != null) {
                ((c)localObject1).c(this.c, (byte[])localObject2);
              }
            }
          }
          else if ("application/json".equals(localObject3))
          {
            localObject1 = this.K3.m();
            localObject2 = localObject1;
            if (i != 0)
            {
              localObject3 = this.N3;
              localObject2 = localObject1;
              if (localObject3 != null) {
                localObject2 = ((b.d.p.a)localObject3).a((byte[])localObject1, localObject1.length);
              }
            }
            localObject1 = new String((byte[])localObject2);
            localObject3 = this.p2;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("payload: ");
            ((StringBuilder)localObject2).append((String)localObject1);
            b.d.p.d.a((String)localObject3, ((StringBuilder)localObject2).toString());
            localObject2 = (CommonPayload)b.b((String)localObject1, CommonPayload.class);
            if ("notification".equals(((CommonPayload)localObject2).getType()))
            {
              localObject2 = b.c((CommonPayload)localObject2);
              if ((localObject2 != null) && (this.I3 != null))
              {
                localObject1 = this.p2;
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("event type ");
                ((StringBuilder)localObject3).append(((StreamControlNotification)localObject2).getEventType());
                b.d.p.d.a((String)localObject1, ((StringBuilder)localObject3).toString());
                this.I3.a(this.c, (StreamControlNotification)localObject2);
              }
              if ((localObject2 != null) && ("channel_motor_status".equals(((StreamControlNotification)localObject2).getEventType())))
              {
                localObject2 = ((ChannelMotorStatus)((StreamControlNotification)localObject2).getResult()).getStatus();
                if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
                {
                  localObject2 = (String)((List)localObject2).get(0);
                  this.p3.e(this.c, MotorStatus.MOVING.getValue().equals(localObject2));
                }
              }
            }
            else if ("response".equals(((CommonPayload)localObject2).getType()))
            {
              if (this.L3 == null)
              {
                localObject2 = (GetPreviewResponse)b.e((CommonPayload)localObject2, GetPreviewResponse.class).getResult();
                if ((((Response)localObject2).getErrorCode() == 0) && (!TextUtils.isEmpty(((GetPreviewResponse)localObject2).getSessionId())))
                {
                  w(((GetPreviewResponse)localObject2).getSessionId());
                }
                else if (((Response)localObject2).getErrorCode() == -52405)
                {
                  if ((this.Q3) && (!TextUtils.isEmpty(this.P3)))
                  {
                    this.Q3 = false;
                    this.K3.t(this.P3, null);
                    localObject2 = this.p3;
                    if (localObject2 != null) {
                      ((c)localObject2).d(this.c, BitStreamType.MINOR_VGA);
                    }
                  }
                  else
                  {
                    localObject2 = this.p3;
                    if (localObject2 != null) {
                      ((c)localObject2).b(this.c, new CameraException(-52405, "need too try use vga"));
                    }
                  }
                }
                else if (((Response)localObject2).getErrorCode() == -52419)
                {
                  localObject2 = this.H3;
                  if (localObject2 != null) {
                    ((f)localObject2).t(this.c, this.x, false, new Exception());
                  }
                }
                else
                {
                  localObject2 = this.p3;
                  if (localObject2 != null) {
                    ((c)localObject2).b(this.c, new Exception("Live Stream Connected session callback error"));
                  }
                }
              }
              else
              {
                localObject1 = this.I3;
                if (localObject1 != null) {
                  ((n)localObject1).c((CommonPayload)localObject2);
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
    String str = this.p2;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("设备：");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append("直播流被release()");
    b.d.p.d.a(str, ((StringBuilder)localObject).toString());
    this.M3 = false;
    this.p3 = null;
    this.H3 = null;
    localObject = this.J3;
    if (localObject != null)
    {
      ((Future)localObject).cancel(true);
      this.J3 = null;
    }
  }
  
  protected void q()
  {
    com.tplink.libtpstreamconnectionsocket.a locala = this.K3;
    if (locala != null) {
      locala.f();
    }
    this.N3 = null;
  }
  
  protected void r()
  {
    if ((this.K3 != null) && (!TextUtils.isEmpty(this.L3))) {
      try
      {
        int i = this.I3.b();
        Object localObject1 = new com/tplink/libtpcommonstream/stream/control/request/DoStopRequest;
        ((DoStopRequest)localObject1).<init>();
        Object localObject2 = new com/tplink/libtpcommonstream/stream/control/common/StreamControlRequest;
        ((StreamControlRequest)localObject2).<init>(localObject1);
        ((StreamControlRequest)localObject2).setSeq(i);
        localObject1 = b.d((StreamControlRequest)localObject2);
        localObject2 = new java/util/HashMap;
        ((HashMap)localObject2).<init>();
        ((Map)localObject2).put("Content-Type", "application/json");
        ((Map)localObject2).put("X-Session-Id", this.L3);
        this.K3.I(true);
        this.K3.D((Map)localObject2, (String)localObject1);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void s(c paramc)
  {
    this.p3 = paramc;
  }
  
  public void t(f paramf)
  {
    this.H3 = paramf;
  }
  
  public void u(n paramn)
  {
    this.I3 = paramn;
  }
  
  public void v(Future<Boolean> paramFuture)
  {
    this.J3 = paramFuture;
  }
  
  public void w(String paramString)
  {
    this.L3 = paramString;
    String str = this.p2;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sessionId ");
    localStringBuilder.append(paramString);
    b.d.p.d.a(str, localStringBuilder.toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\o\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */