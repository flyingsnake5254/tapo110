package com.google.android.exoplayer2;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.AudioTrack;
import android.media.MediaFormat;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.audio.r;
import com.google.android.exoplayer2.m2.h1;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.n2.b;
import com.google.android.exoplayer2.o2.o;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.g0;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.m;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import com.google.android.exoplayer2.video.s;
import com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView;
import com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView.b;
import com.google.android.exoplayer2.video.w;
import com.google.android.exoplayer2.video.y;
import com.google.android.exoplayer2.video.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;

public class h2
  extends t0
  implements e1
{
  private boolean A;
  @Nullable
  private TextureView B;
  private int C;
  private int D;
  private int E;
  @Nullable
  private com.google.android.exoplayer2.decoder.d F;
  @Nullable
  private com.google.android.exoplayer2.decoder.d G;
  private int H;
  private com.google.android.exoplayer2.audio.p I;
  private float J;
  private boolean K;
  private List<com.google.android.exoplayer2.text.c> L;
  private boolean M;
  private boolean N;
  @Nullable
  private PriorityTaskManager O;
  private boolean P;
  private boolean Q;
  private b R;
  private z S;
  protected final b2[] b;
  private final com.google.android.exoplayer2.util.k c;
  private final Context d;
  private final f1 e;
  private final c f;
  private final d g;
  private final CopyOnWriteArraySet<w> h;
  private final CopyOnWriteArraySet<r> i;
  private final CopyOnWriteArraySet<com.google.android.exoplayer2.text.k> j;
  private final CopyOnWriteArraySet<com.google.android.exoplayer2.metadata.e> k;
  private final CopyOnWriteArraySet<com.google.android.exoplayer2.n2.c> l;
  private final h1 m;
  private final r0 n;
  private final s0 o;
  private final i2 p;
  private final k2 q;
  private final l2 r;
  private final long s;
  @Nullable
  private Format t;
  @Nullable
  private Format u;
  @Nullable
  private AudioTrack v;
  @Nullable
  private Object w;
  @Nullable
  private Surface x;
  @Nullable
  private SurfaceHolder y;
  @Nullable
  private SphericalGLSurfaceView z;
  
  /* Error */
  protected h2(b paramb)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 97	com/google/android/exoplayer2/t0:<init>	()V
    //   4: new 99	com/google/android/exoplayer2/util/k
    //   7: dup
    //   8: invokespecial 100	com/google/android/exoplayer2/util/k:<init>	()V
    //   11: astore_2
    //   12: aload_0
    //   13: aload_2
    //   14: putfield 102	com/google/android/exoplayer2/h2:c	Lcom/google/android/exoplayer2/util/k;
    //   17: aload_1
    //   18: invokestatic 106	com/google/android/exoplayer2/h2$b:a	(Lcom/google/android/exoplayer2/h2$b;)Landroid/content/Context;
    //   21: invokevirtual 112	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   24: astore_3
    //   25: aload_0
    //   26: aload_3
    //   27: putfield 114	com/google/android/exoplayer2/h2:d	Landroid/content/Context;
    //   30: aload_1
    //   31: invokestatic 117	com/google/android/exoplayer2/h2$b:b	(Lcom/google/android/exoplayer2/h2$b;)Lcom/google/android/exoplayer2/m2/h1;
    //   34: astore 4
    //   36: aload_0
    //   37: aload 4
    //   39: putfield 119	com/google/android/exoplayer2/h2:m	Lcom/google/android/exoplayer2/m2/h1;
    //   42: aload_0
    //   43: aload_1
    //   44: invokestatic 122	com/google/android/exoplayer2/h2$b:m	(Lcom/google/android/exoplayer2/h2$b;)Lcom/google/android/exoplayer2/util/PriorityTaskManager;
    //   47: putfield 124	com/google/android/exoplayer2/h2:O	Lcom/google/android/exoplayer2/util/PriorityTaskManager;
    //   50: aload_0
    //   51: aload_1
    //   52: invokestatic 127	com/google/android/exoplayer2/h2$b:u	(Lcom/google/android/exoplayer2/h2$b;)Lcom/google/android/exoplayer2/audio/p;
    //   55: putfield 129	com/google/android/exoplayer2/h2:I	Lcom/google/android/exoplayer2/audio/p;
    //   58: aload_0
    //   59: aload_1
    //   60: invokestatic 132	com/google/android/exoplayer2/h2$b:v	(Lcom/google/android/exoplayer2/h2$b;)I
    //   63: putfield 134	com/google/android/exoplayer2/h2:C	I
    //   66: aload_0
    //   67: aload_1
    //   68: invokestatic 137	com/google/android/exoplayer2/h2$b:w	(Lcom/google/android/exoplayer2/h2$b;)Z
    //   71: putfield 139	com/google/android/exoplayer2/h2:K	Z
    //   74: aload_0
    //   75: aload_1
    //   76: invokestatic 142	com/google/android/exoplayer2/h2$b:x	(Lcom/google/android/exoplayer2/h2$b;)J
    //   79: putfield 144	com/google/android/exoplayer2/h2:s	J
    //   82: new 13	com/google/android/exoplayer2/h2$c
    //   85: astore 5
    //   87: aload 5
    //   89: aload_0
    //   90: aconst_null
    //   91: invokespecial 147	com/google/android/exoplayer2/h2$c:<init>	(Lcom/google/android/exoplayer2/h2;Lcom/google/android/exoplayer2/h2$a;)V
    //   94: aload_0
    //   95: aload 5
    //   97: putfield 149	com/google/android/exoplayer2/h2:f	Lcom/google/android/exoplayer2/h2$c;
    //   100: new 16	com/google/android/exoplayer2/h2$d
    //   103: astore 6
    //   105: aload 6
    //   107: aconst_null
    //   108: invokespecial 152	com/google/android/exoplayer2/h2$d:<init>	(Lcom/google/android/exoplayer2/h2$a;)V
    //   111: aload_0
    //   112: aload 6
    //   114: putfield 154	com/google/android/exoplayer2/h2:g	Lcom/google/android/exoplayer2/h2$d;
    //   117: new 156	java/util/concurrent/CopyOnWriteArraySet
    //   120: astore 7
    //   122: aload 7
    //   124: invokespecial 157	java/util/concurrent/CopyOnWriteArraySet:<init>	()V
    //   127: aload_0
    //   128: aload 7
    //   130: putfield 159	com/google/android/exoplayer2/h2:h	Ljava/util/concurrent/CopyOnWriteArraySet;
    //   133: new 156	java/util/concurrent/CopyOnWriteArraySet
    //   136: astore 7
    //   138: aload 7
    //   140: invokespecial 157	java/util/concurrent/CopyOnWriteArraySet:<init>	()V
    //   143: aload_0
    //   144: aload 7
    //   146: putfield 161	com/google/android/exoplayer2/h2:i	Ljava/util/concurrent/CopyOnWriteArraySet;
    //   149: new 156	java/util/concurrent/CopyOnWriteArraySet
    //   152: astore 7
    //   154: aload 7
    //   156: invokespecial 157	java/util/concurrent/CopyOnWriteArraySet:<init>	()V
    //   159: aload_0
    //   160: aload 7
    //   162: putfield 163	com/google/android/exoplayer2/h2:j	Ljava/util/concurrent/CopyOnWriteArraySet;
    //   165: new 156	java/util/concurrent/CopyOnWriteArraySet
    //   168: astore 7
    //   170: aload 7
    //   172: invokespecial 157	java/util/concurrent/CopyOnWriteArraySet:<init>	()V
    //   175: aload_0
    //   176: aload 7
    //   178: putfield 165	com/google/android/exoplayer2/h2:k	Ljava/util/concurrent/CopyOnWriteArraySet;
    //   181: new 156	java/util/concurrent/CopyOnWriteArraySet
    //   184: astore 7
    //   186: aload 7
    //   188: invokespecial 157	java/util/concurrent/CopyOnWriteArraySet:<init>	()V
    //   191: aload_0
    //   192: aload 7
    //   194: putfield 167	com/google/android/exoplayer2/h2:l	Ljava/util/concurrent/CopyOnWriteArraySet;
    //   197: new 169	android/os/Handler
    //   200: astore 8
    //   202: aload 8
    //   204: aload_1
    //   205: invokestatic 172	com/google/android/exoplayer2/h2$b:y	(Lcom/google/android/exoplayer2/h2$b;)Landroid/os/Looper;
    //   208: invokespecial 175	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   211: aload_1
    //   212: invokestatic 178	com/google/android/exoplayer2/h2$b:c	(Lcom/google/android/exoplayer2/h2$b;)Lcom/google/android/exoplayer2/f2;
    //   215: aload 8
    //   217: aload 5
    //   219: aload 5
    //   221: aload 5
    //   223: aload 5
    //   225: invokeinterface 183 6 0
    //   230: astore 7
    //   232: aload_0
    //   233: aload 7
    //   235: putfield 185	com/google/android/exoplayer2/h2:b	[Lcom/google/android/exoplayer2/b2;
    //   238: aload_0
    //   239: fconst_1
    //   240: putfield 187	com/google/android/exoplayer2/h2:J	F
    //   243: getstatic 191	com/google/android/exoplayer2/util/o0:a	I
    //   246: bipush 21
    //   248: if_icmpge +15 -> 263
    //   251: aload_0
    //   252: aload_0
    //   253: iconst_0
    //   254: invokespecial 195	com/google/android/exoplayer2/h2:d1	(I)I
    //   257: putfield 197	com/google/android/exoplayer2/h2:H	I
    //   260: goto +11 -> 271
    //   263: aload_0
    //   264: aload_3
    //   265: invokestatic 202	com/google/android/exoplayer2/w0:a	(Landroid/content/Context;)I
    //   268: putfield 197	com/google/android/exoplayer2/h2:H	I
    //   271: aload_0
    //   272: invokestatic 208	java/util/Collections:emptyList	()Ljava/util/List;
    //   275: putfield 210	com/google/android/exoplayer2/h2:L	Ljava/util/List;
    //   278: aload_0
    //   279: iconst_1
    //   280: putfield 212	com/google/android/exoplayer2/h2:M	Z
    //   283: new 214	com/google/android/exoplayer2/u1$b$a
    //   286: astore_3
    //   287: aload_3
    //   288: invokespecial 215	com/google/android/exoplayer2/u1$b$a:<init>	()V
    //   291: aload_3
    //   292: bipush 8
    //   294: newarray <illegal type>
    //   296: dup
    //   297: iconst_0
    //   298: bipush 20
    //   300: iastore
    //   301: dup
    //   302: iconst_1
    //   303: bipush 21
    //   305: iastore
    //   306: dup
    //   307: iconst_2
    //   308: bipush 22
    //   310: iastore
    //   311: dup
    //   312: iconst_3
    //   313: bipush 23
    //   315: iastore
    //   316: dup
    //   317: iconst_4
    //   318: bipush 24
    //   320: iastore
    //   321: dup
    //   322: iconst_5
    //   323: bipush 25
    //   325: iastore
    //   326: dup
    //   327: bipush 6
    //   329: bipush 26
    //   331: iastore
    //   332: dup
    //   333: bipush 7
    //   335: bipush 27
    //   337: iastore
    //   338: invokevirtual 218	com/google/android/exoplayer2/u1$b$a:c	([I)Lcom/google/android/exoplayer2/u1$b$a;
    //   341: invokevirtual 221	com/google/android/exoplayer2/u1$b$a:e	()Lcom/google/android/exoplayer2/u1$b;
    //   344: astore 9
    //   346: new 223	com/google/android/exoplayer2/f1
    //   349: astore_3
    //   350: aload_1
    //   351: invokestatic 226	com/google/android/exoplayer2/h2$b:d	(Lcom/google/android/exoplayer2/h2$b;)Lcom/google/android/exoplayer2/trackselection/m;
    //   354: astore 10
    //   356: aload_1
    //   357: invokestatic 229	com/google/android/exoplayer2/h2$b:e	(Lcom/google/android/exoplayer2/h2$b;)Lcom/google/android/exoplayer2/source/g0;
    //   360: astore 11
    //   362: aload_1
    //   363: invokestatic 232	com/google/android/exoplayer2/h2$b:f	(Lcom/google/android/exoplayer2/h2$b;)Lcom/google/android/exoplayer2/k1;
    //   366: astore 12
    //   368: aload_1
    //   369: invokestatic 235	com/google/android/exoplayer2/h2$b:g	(Lcom/google/android/exoplayer2/h2$b;)Lcom/google/android/exoplayer2/upstream/g;
    //   372: astore 13
    //   374: aload_1
    //   375: invokestatic 237	com/google/android/exoplayer2/h2$b:h	(Lcom/google/android/exoplayer2/h2$b;)Z
    //   378: istore 14
    //   380: aload_1
    //   381: invokestatic 240	com/google/android/exoplayer2/h2$b:i	(Lcom/google/android/exoplayer2/h2$b;)Lcom/google/android/exoplayer2/g2;
    //   384: astore 15
    //   386: aload_1
    //   387: invokestatic 242	com/google/android/exoplayer2/h2$b:j	(Lcom/google/android/exoplayer2/h2$b;)J
    //   390: lstore 16
    //   392: aload_1
    //   393: invokestatic 244	com/google/android/exoplayer2/h2$b:k	(Lcom/google/android/exoplayer2/h2$b;)J
    //   396: lstore 18
    //   398: aload_1
    //   399: invokestatic 247	com/google/android/exoplayer2/h2$b:l	(Lcom/google/android/exoplayer2/h2$b;)Lcom/google/android/exoplayer2/j1;
    //   402: astore 20
    //   404: aload_1
    //   405: invokestatic 249	com/google/android/exoplayer2/h2$b:n	(Lcom/google/android/exoplayer2/h2$b;)J
    //   408: lstore 21
    //   410: aload_1
    //   411: invokestatic 251	com/google/android/exoplayer2/h2$b:o	(Lcom/google/android/exoplayer2/h2$b;)Z
    //   414: istore 23
    //   416: aload_1
    //   417: invokestatic 254	com/google/android/exoplayer2/h2$b:p	(Lcom/google/android/exoplayer2/h2$b;)Lcom/google/android/exoplayer2/util/h;
    //   420: astore 24
    //   422: aload_1
    //   423: invokestatic 172	com/google/android/exoplayer2/h2$b:y	(Lcom/google/android/exoplayer2/h2$b;)Landroid/os/Looper;
    //   426: astore 25
    //   428: aload_3
    //   429: aload 7
    //   431: aload 10
    //   433: aload 11
    //   435: aload 12
    //   437: aload 13
    //   439: aload 4
    //   441: iload 14
    //   443: aload 15
    //   445: lload 16
    //   447: lload 18
    //   449: aload 20
    //   451: lload 21
    //   453: iload 23
    //   455: aload 24
    //   457: aload 25
    //   459: aload_0
    //   460: aload 9
    //   462: invokespecial 257	com/google/android/exoplayer2/f1:<init>	([Lcom/google/android/exoplayer2/b2;Lcom/google/android/exoplayer2/trackselection/m;Lcom/google/android/exoplayer2/source/g0;Lcom/google/android/exoplayer2/k1;Lcom/google/android/exoplayer2/upstream/g;Lcom/google/android/exoplayer2/m2/h1;ZLcom/google/android/exoplayer2/g2;JJLcom/google/android/exoplayer2/j1;JZLcom/google/android/exoplayer2/util/h;Landroid/os/Looper;Lcom/google/android/exoplayer2/u1;Lcom/google/android/exoplayer2/u1$b;)V
    //   465: aload_0
    //   466: astore 7
    //   468: aload 7
    //   470: aload_3
    //   471: putfield 259	com/google/android/exoplayer2/h2:e	Lcom/google/android/exoplayer2/f1;
    //   474: aload_3
    //   475: aload 5
    //   477: invokevirtual 263	com/google/android/exoplayer2/f1:m0	(Lcom/google/android/exoplayer2/u1$c;)V
    //   480: aload_3
    //   481: aload 5
    //   483: invokevirtual 267	com/google/android/exoplayer2/f1:l0	(Lcom/google/android/exoplayer2/e1$a;)V
    //   486: aload_1
    //   487: invokestatic 269	com/google/android/exoplayer2/h2$b:q	(Lcom/google/android/exoplayer2/h2$b;)J
    //   490: lconst_0
    //   491: lcmp
    //   492: ifle +11 -> 503
    //   495: aload_3
    //   496: aload_1
    //   497: invokestatic 269	com/google/android/exoplayer2/h2$b:q	(Lcom/google/android/exoplayer2/h2$b;)J
    //   500: invokevirtual 273	com/google/android/exoplayer2/f1:t0	(J)V
    //   503: new 275	com/google/android/exoplayer2/r0
    //   506: astore 4
    //   508: aload 4
    //   510: aload_1
    //   511: invokestatic 106	com/google/android/exoplayer2/h2$b:a	(Lcom/google/android/exoplayer2/h2$b;)Landroid/content/Context;
    //   514: aload 8
    //   516: aload 5
    //   518: invokespecial 278	com/google/android/exoplayer2/r0:<init>	(Landroid/content/Context;Landroid/os/Handler;Lcom/google/android/exoplayer2/r0$b;)V
    //   521: aload 7
    //   523: aload 4
    //   525: putfield 280	com/google/android/exoplayer2/h2:n	Lcom/google/android/exoplayer2/r0;
    //   528: aload 4
    //   530: aload_1
    //   531: invokestatic 282	com/google/android/exoplayer2/h2$b:r	(Lcom/google/android/exoplayer2/h2$b;)Z
    //   534: invokevirtual 285	com/google/android/exoplayer2/r0:b	(Z)V
    //   537: new 287	com/google/android/exoplayer2/s0
    //   540: astore_3
    //   541: aload_3
    //   542: aload_1
    //   543: invokestatic 106	com/google/android/exoplayer2/h2$b:a	(Lcom/google/android/exoplayer2/h2$b;)Landroid/content/Context;
    //   546: aload 8
    //   548: aload 5
    //   550: invokespecial 290	com/google/android/exoplayer2/s0:<init>	(Landroid/content/Context;Landroid/os/Handler;Lcom/google/android/exoplayer2/s0$b;)V
    //   553: aload 7
    //   555: aload_3
    //   556: putfield 292	com/google/android/exoplayer2/h2:o	Lcom/google/android/exoplayer2/s0;
    //   559: aload_1
    //   560: invokestatic 294	com/google/android/exoplayer2/h2$b:s	(Lcom/google/android/exoplayer2/h2$b;)Z
    //   563: ifeq +13 -> 576
    //   566: aload 7
    //   568: getfield 129	com/google/android/exoplayer2/h2:I	Lcom/google/android/exoplayer2/audio/p;
    //   571: astore 4
    //   573: goto +6 -> 579
    //   576: aconst_null
    //   577: astore 4
    //   579: aload_3
    //   580: aload 4
    //   582: invokevirtual 297	com/google/android/exoplayer2/s0:m	(Lcom/google/android/exoplayer2/audio/p;)V
    //   585: new 299	com/google/android/exoplayer2/i2
    //   588: astore 4
    //   590: aload 4
    //   592: aload_1
    //   593: invokestatic 106	com/google/android/exoplayer2/h2$b:a	(Lcom/google/android/exoplayer2/h2$b;)Landroid/content/Context;
    //   596: aload 8
    //   598: aload 5
    //   600: invokespecial 302	com/google/android/exoplayer2/i2:<init>	(Landroid/content/Context;Landroid/os/Handler;Lcom/google/android/exoplayer2/i2$b;)V
    //   603: aload 7
    //   605: aload 4
    //   607: putfield 304	com/google/android/exoplayer2/h2:p	Lcom/google/android/exoplayer2/i2;
    //   610: aload 4
    //   612: aload 7
    //   614: getfield 129	com/google/android/exoplayer2/h2:I	Lcom/google/android/exoplayer2/audio/p;
    //   617: getfield 308	com/google/android/exoplayer2/audio/p:e	I
    //   620: invokestatic 311	com/google/android/exoplayer2/util/o0:Y	(I)I
    //   623: invokevirtual 314	com/google/android/exoplayer2/i2:h	(I)V
    //   626: new 316	com/google/android/exoplayer2/k2
    //   629: astore 5
    //   631: aload 5
    //   633: aload_1
    //   634: invokestatic 106	com/google/android/exoplayer2/h2$b:a	(Lcom/google/android/exoplayer2/h2$b;)Landroid/content/Context;
    //   637: invokespecial 319	com/google/android/exoplayer2/k2:<init>	(Landroid/content/Context;)V
    //   640: aload 7
    //   642: aload 5
    //   644: putfield 321	com/google/android/exoplayer2/h2:q	Lcom/google/android/exoplayer2/k2;
    //   647: aload_1
    //   648: invokestatic 323	com/google/android/exoplayer2/h2$b:t	(Lcom/google/android/exoplayer2/h2$b;)I
    //   651: ifeq +9 -> 660
    //   654: iconst_1
    //   655: istore 14
    //   657: goto +6 -> 663
    //   660: iconst_0
    //   661: istore 14
    //   663: aload 5
    //   665: iload 14
    //   667: invokevirtual 325	com/google/android/exoplayer2/k2:a	(Z)V
    //   670: new 327	com/google/android/exoplayer2/l2
    //   673: astore 5
    //   675: aload 5
    //   677: aload_1
    //   678: invokestatic 106	com/google/android/exoplayer2/h2$b:a	(Lcom/google/android/exoplayer2/h2$b;)Landroid/content/Context;
    //   681: invokespecial 328	com/google/android/exoplayer2/l2:<init>	(Landroid/content/Context;)V
    //   684: aload 7
    //   686: aload 5
    //   688: putfield 330	com/google/android/exoplayer2/h2:r	Lcom/google/android/exoplayer2/l2;
    //   691: aload_1
    //   692: invokestatic 323	com/google/android/exoplayer2/h2$b:t	(Lcom/google/android/exoplayer2/h2$b;)I
    //   695: iconst_2
    //   696: if_icmpne +9 -> 705
    //   699: iconst_1
    //   700: istore 14
    //   702: goto +6 -> 708
    //   705: iconst_0
    //   706: istore 14
    //   708: aload 5
    //   710: iload 14
    //   712: invokevirtual 331	com/google/android/exoplayer2/l2:a	(Z)V
    //   715: aload 7
    //   717: aload 4
    //   719: invokestatic 335	com/google/android/exoplayer2/h2:Y0	(Lcom/google/android/exoplayer2/i2;)Lcom/google/android/exoplayer2/n2/b;
    //   722: putfield 337	com/google/android/exoplayer2/h2:R	Lcom/google/android/exoplayer2/n2/b;
    //   725: aload 7
    //   727: getstatic 341	com/google/android/exoplayer2/video/z:a	Lcom/google/android/exoplayer2/video/z;
    //   730: putfield 343	com/google/android/exoplayer2/h2:S	Lcom/google/android/exoplayer2/video/z;
    //   733: aload 7
    //   735: iconst_1
    //   736: bipush 102
    //   738: aload 7
    //   740: getfield 197	com/google/android/exoplayer2/h2:H	I
    //   743: invokestatic 349	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   746: invokespecial 353	com/google/android/exoplayer2/h2:n1	(IILjava/lang/Object;)V
    //   749: aload 7
    //   751: iconst_2
    //   752: bipush 102
    //   754: aload 7
    //   756: getfield 197	com/google/android/exoplayer2/h2:H	I
    //   759: invokestatic 349	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   762: invokespecial 353	com/google/android/exoplayer2/h2:n1	(IILjava/lang/Object;)V
    //   765: aload 7
    //   767: iconst_1
    //   768: iconst_3
    //   769: aload 7
    //   771: getfield 129	com/google/android/exoplayer2/h2:I	Lcom/google/android/exoplayer2/audio/p;
    //   774: invokespecial 353	com/google/android/exoplayer2/h2:n1	(IILjava/lang/Object;)V
    //   777: aload 7
    //   779: iconst_2
    //   780: iconst_4
    //   781: aload 7
    //   783: getfield 134	com/google/android/exoplayer2/h2:C	I
    //   786: invokestatic 349	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   789: invokespecial 353	com/google/android/exoplayer2/h2:n1	(IILjava/lang/Object;)V
    //   792: aload 7
    //   794: iconst_1
    //   795: bipush 101
    //   797: aload 7
    //   799: getfield 139	com/google/android/exoplayer2/h2:K	Z
    //   802: invokestatic 358	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   805: invokespecial 353	com/google/android/exoplayer2/h2:n1	(IILjava/lang/Object;)V
    //   808: aload 7
    //   810: iconst_2
    //   811: bipush 6
    //   813: aload 6
    //   815: invokespecial 353	com/google/android/exoplayer2/h2:n1	(IILjava/lang/Object;)V
    //   818: aload 7
    //   820: bipush 6
    //   822: bipush 7
    //   824: aload 6
    //   826: invokespecial 353	com/google/android/exoplayer2/h2:n1	(IILjava/lang/Object;)V
    //   829: aload_2
    //   830: invokevirtual 361	com/google/android/exoplayer2/util/k:e	()Z
    //   833: pop
    //   834: return
    //   835: astore_1
    //   836: goto +8 -> 844
    //   839: astore_1
    //   840: goto +4 -> 844
    //   843: astore_1
    //   844: aload_0
    //   845: getfield 102	com/google/android/exoplayer2/h2:c	Lcom/google/android/exoplayer2/util/k;
    //   848: invokevirtual 361	com/google/android/exoplayer2/util/k:e	()Z
    //   851: pop
    //   852: aload_1
    //   853: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	854	0	this	h2
    //   0	854	1	paramb	b
    //   11	819	2	localk	com.google.android.exoplayer2.util.k
    //   24	556	3	localObject1	Object
    //   34	684	4	localObject2	Object
    //   85	624	5	localObject3	Object
    //   103	722	6	locald	d
    //   120	699	7	localObject4	Object
    //   200	397	8	localHandler	android.os.Handler
    //   344	117	9	localb	u1.b
    //   354	78	10	localm	m
    //   360	74	11	localg0	g0
    //   366	70	12	localk1	k1
    //   372	66	13	localg	com.google.android.exoplayer2.upstream.g
    //   378	333	14	bool1	boolean
    //   384	60	15	localg2	g2
    //   390	56	16	l1	long
    //   396	52	18	l2	long
    //   402	48	20	localj1	j1
    //   408	44	21	l3	long
    //   414	40	23	bool2	boolean
    //   420	36	24	localh	com.google.android.exoplayer2.util.h
    //   426	32	25	localLooper	Looper
    // Exception table:
    //   from	to	target	type
    //   468	503	835	finally
    //   503	573	835	finally
    //   579	654	835	finally
    //   663	699	835	finally
    //   708	829	835	finally
    //   428	465	839	finally
    //   17	260	843	finally
    //   263	271	843	finally
    //   271	428	843	finally
  }
  
  private static b Y0(i2 parami2)
  {
    return new b(0, parami2.d(), parami2.c());
  }
  
  private static int a1(boolean paramBoolean, int paramInt)
  {
    int i1 = 1;
    int i2 = i1;
    if (paramBoolean)
    {
      i2 = i1;
      if (paramInt != 1) {
        i2 = 2;
      }
    }
    return i2;
  }
  
  private int d1(int paramInt)
  {
    AudioTrack localAudioTrack = this.v;
    if ((localAudioTrack != null) && (localAudioTrack.getAudioSessionId() != paramInt))
    {
      this.v.release();
      this.v = null;
    }
    if (this.v == null) {
      this.v = new AudioTrack(3, 4000, 4, 2, 2, 0, paramInt);
    }
    return this.v.getAudioSessionId();
  }
  
  private void e1(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != this.D) || (paramInt2 != this.E))
    {
      this.D = paramInt1;
      this.E = paramInt2;
      this.m.I(paramInt1, paramInt2);
      Iterator localIterator = this.h.iterator();
      while (localIterator.hasNext()) {
        ((w)localIterator.next()).I(paramInt1, paramInt2);
      }
    }
  }
  
  private void f1()
  {
    this.m.a(this.K);
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      ((r)localIterator.next()).a(this.K);
    }
  }
  
  private void k1()
  {
    if (this.z != null)
    {
      this.e.q0(this.g).n(10000).m(null).l();
      this.z.i(this.f);
      this.z = null;
    }
    Object localObject = this.B;
    if (localObject != null)
    {
      if (((TextureView)localObject).getSurfaceTextureListener() != this.f) {
        u.h("SimpleExoPlayer", "SurfaceTextureListener already unset or replaced.");
      } else {
        this.B.setSurfaceTextureListener(null);
      }
      this.B = null;
    }
    localObject = this.y;
    if (localObject != null)
    {
      ((SurfaceHolder)localObject).removeCallback(this.f);
      this.y = null;
    }
  }
  
  private void n1(int paramInt1, int paramInt2, @Nullable Object paramObject)
  {
    for (b2 localb2 : this.b) {
      if (localb2.f() == paramInt1) {
        this.e.q0(localb2).n(paramInt2).m(paramObject).l();
      }
    }
  }
  
  private void o1()
  {
    n1(1, 2, Float.valueOf(this.J * this.o.g()));
  }
  
  private void p1(SurfaceHolder paramSurfaceHolder)
  {
    this.A = false;
    this.y = paramSurfaceHolder;
    paramSurfaceHolder.addCallback(this.f);
    paramSurfaceHolder = this.y.getSurface();
    if ((paramSurfaceHolder != null) && (paramSurfaceHolder.isValid()))
    {
      paramSurfaceHolder = this.y.getSurfaceFrame();
      e1(paramSurfaceHolder.width(), paramSurfaceHolder.height());
    }
    else
    {
      e1(0, 0);
    }
  }
  
  private void q1(SurfaceTexture paramSurfaceTexture)
  {
    paramSurfaceTexture = new Surface(paramSurfaceTexture);
    r1(paramSurfaceTexture);
    this.x = paramSurfaceTexture;
  }
  
  private void r1(@Nullable Object paramObject)
  {
    Object localObject1 = new ArrayList();
    b2[] arrayOfb2 = this.b;
    int i1 = arrayOfb2.length;
    int i3;
    for (int i2 = 0;; i2++)
    {
      i3 = 1;
      if (i2 >= i1) {
        break;
      }
      localObject3 = arrayOfb2[i2];
      if (((b2)localObject3).f() == 2) {
        ((List)localObject1).add(this.e.q0((x1.b)localObject3).n(1).m(paramObject).l());
      }
    }
    Object localObject3 = this.w;
    if ((localObject3 != null) && (localObject3 != paramObject))
    {
      try
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((x1)((Iterator)localObject1).next()).a(this.s);
        }
        localObject2 = this.w;
      }
      catch (TimeoutException localTimeoutException)
      {
        i2 = i3;
      }
      catch (InterruptedException localInterruptedException)
      {
        Thread.currentThread().interrupt();
        i2 = 0;
      }
      Object localObject2;
      localObject3 = this.x;
      i3 = i2;
      if (localObject2 == localObject3)
      {
        ((Surface)localObject3).release();
        this.x = null;
        i3 = i2;
      }
    }
    else
    {
      i3 = 0;
    }
    this.w = paramObject;
    if (i3 != 0) {
      this.e.p1(false, ExoPlaybackException.createForUnexpected(new ExoTimeoutException(3), 1003));
    }
  }
  
  private void u1(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    int i1 = 0;
    if ((paramBoolean) && (paramInt1 != -1)) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    int i2 = i1;
    if (paramBoolean)
    {
      i2 = i1;
      if (paramInt1 != 1) {
        i2 = 1;
      }
    }
    this.e.o1(paramBoolean, i2, paramInt2);
  }
  
  private void v1()
  {
    int i1 = getPlaybackState();
    boolean bool1 = true;
    if (i1 != 1) {
      if ((i1 != 2) && (i1 != 3))
      {
        if (i1 != 4) {
          throw new IllegalStateException();
        }
      }
      else
      {
        boolean bool2 = Z0();
        k2 localk2 = this.q;
        if ((!E()) || (bool2)) {
          bool1 = false;
        }
        localk2.b(bool1);
        this.r.b(E());
        return;
      }
    }
    this.q.b(false);
    this.r.b(false);
  }
  
  private void w1()
  {
    this.c.b();
    if (Thread.currentThread() != x().getThread())
    {
      String str = o0.A("Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://exoplayer.dev/issues/player-accessed-on-wrong-thread", new Object[] { Thread.currentThread().getName(), x().getThread().getName() });
      if (!this.M)
      {
        IllegalStateException localIllegalStateException;
        if (this.N) {
          localIllegalStateException = null;
        } else {
          localIllegalStateException = new IllegalStateException();
        }
        u.i("SimpleExoPlayer", str, localIllegalStateException);
        this.N = true;
      }
      else
      {
        throw new IllegalStateException(str);
      }
    }
  }
  
  public com.google.android.exoplayer2.trackselection.k A()
  {
    w1();
    return this.e.A();
  }
  
  public void B(int paramInt, long paramLong)
  {
    w1();
    this.m.D1();
    this.e.B(paramInt, paramLong);
  }
  
  public u1.b C()
  {
    w1();
    return this.e.C();
  }
  
  public boolean E()
  {
    w1();
    return this.e.E();
  }
  
  public void F(boolean paramBoolean)
  {
    w1();
    this.e.F(paramBoolean);
  }
  
  public int G()
  {
    w1();
    return this.e.G();
  }
  
  public int H()
  {
    w1();
    return this.e.H();
  }
  
  public void I(@Nullable TextureView paramTextureView)
  {
    w1();
    if ((paramTextureView != null) && (paramTextureView == this.B)) {
      W0();
    }
  }
  
  public z J()
  {
    return this.S;
  }
  
  public int K()
  {
    w1();
    return this.e.K();
  }
  
  public long L()
  {
    w1();
    return this.e.L();
  }
  
  public long M()
  {
    w1();
    return this.e.M();
  }
  
  public void N(u1.e parame)
  {
    com.google.android.exoplayer2.util.g.e(parame);
    Q0(parame);
    V0(parame);
    U0(parame);
    T0(parame);
    R0(parame);
    S0(parame);
  }
  
  public void P(@Nullable SurfaceView paramSurfaceView)
  {
    w1();
    if (paramSurfaceView == null) {
      paramSurfaceView = null;
    } else {
      paramSurfaceView = paramSurfaceView.getHolder();
    }
    X0(paramSurfaceView);
  }
  
  public boolean Q()
  {
    w1();
    return this.e.Q();
  }
  
  @Deprecated
  public void Q0(r paramr)
  {
    com.google.android.exoplayer2.util.g.e(paramr);
    this.i.add(paramr);
  }
  
  public long R()
  {
    w1();
    return this.e.R();
  }
  
  @Deprecated
  public void R0(com.google.android.exoplayer2.n2.c paramc)
  {
    com.google.android.exoplayer2.util.g.e(paramc);
    this.l.add(paramc);
  }
  
  @Deprecated
  public void S0(u1.c paramc)
  {
    com.google.android.exoplayer2.util.g.e(paramc);
    this.e.m0(paramc);
  }
  
  @Deprecated
  public void T0(com.google.android.exoplayer2.metadata.e parame)
  {
    com.google.android.exoplayer2.util.g.e(parame);
    this.k.add(parame);
  }
  
  public m1 U()
  {
    return this.e.U();
  }
  
  @Deprecated
  public void U0(com.google.android.exoplayer2.text.k paramk)
  {
    com.google.android.exoplayer2.util.g.e(paramk);
    this.j.add(paramk);
  }
  
  public long V()
  {
    w1();
    return this.e.V();
  }
  
  @Deprecated
  public void V0(w paramw)
  {
    com.google.android.exoplayer2.util.g.e(paramw);
    this.h.add(paramw);
  }
  
  public long W()
  {
    w1();
    return this.e.W();
  }
  
  public void W0()
  {
    w1();
    k1();
    r1(null);
    e1(0, 0);
  }
  
  public void X0(@Nullable SurfaceHolder paramSurfaceHolder)
  {
    w1();
    if ((paramSurfaceHolder != null) && (paramSurfaceHolder == this.y)) {
      W0();
    }
  }
  
  public boolean Z0()
  {
    w1();
    return this.e.s0();
  }
  
  @Nullable
  public m a()
  {
    w1();
    return this.e.a();
  }
  
  @Nullable
  public ExoPlaybackException b1()
  {
    w1();
    return this.e.z0();
  }
  
  public t1 c()
  {
    w1();
    return this.e.c();
  }
  
  public float c1()
  {
    return this.J;
  }
  
  public void e(t1 paramt1)
  {
    w1();
    this.e.e(paramt1);
  }
  
  public boolean f()
  {
    w1();
    return this.e.f();
  }
  
  public long g()
  {
    w1();
    return this.e.g();
  }
  
  @Deprecated
  public void g1(r paramr)
  {
    this.i.remove(paramr);
  }
  
  public int getPlaybackState()
  {
    w1();
    return this.e.getPlaybackState();
  }
  
  public int getRepeatMode()
  {
    w1();
    return this.e.getRepeatMode();
  }
  
  @Deprecated
  public void h1(com.google.android.exoplayer2.n2.c paramc)
  {
    this.l.remove(paramc);
  }
  
  public void i(u1.e parame)
  {
    com.google.android.exoplayer2.util.g.e(parame);
    g1(parame);
    m1(parame);
    l1(parame);
    j1(parame);
    h1(parame);
    i1(parame);
  }
  
  @Deprecated
  public void i1(u1.c paramc)
  {
    this.e.j1(paramc);
  }
  
  public void j(List<l1> paramList, boolean paramBoolean)
  {
    w1();
    this.e.j(paramList, paramBoolean);
  }
  
  @Deprecated
  public void j1(com.google.android.exoplayer2.metadata.e parame)
  {
    this.k.remove(parame);
  }
  
  public void k(@Nullable SurfaceView paramSurfaceView)
  {
    w1();
    if ((paramSurfaceView instanceof s))
    {
      k1();
      r1(paramSurfaceView);
      p1(paramSurfaceView.getHolder());
    }
    else if ((paramSurfaceView instanceof SphericalGLSurfaceView))
    {
      k1();
      this.z = ((SphericalGLSurfaceView)paramSurfaceView);
      this.e.q0(this.g).n(10000).m(this.z).l();
      this.z.b(this.f);
      r1(this.z.getVideoSurface());
      p1(paramSurfaceView.getHolder());
    }
    else
    {
      if (paramSurfaceView == null) {
        paramSurfaceView = null;
      } else {
        paramSurfaceView = paramSurfaceView.getHolder();
      }
      s1(paramSurfaceView);
    }
  }
  
  public void l(int paramInt1, int paramInt2)
  {
    w1();
    this.e.l(paramInt1, paramInt2);
  }
  
  @Deprecated
  public void l1(com.google.android.exoplayer2.text.k paramk)
  {
    this.j.remove(paramk);
  }
  
  public int m()
  {
    w1();
    return this.e.m();
  }
  
  @Deprecated
  public void m1(w paramw)
  {
    this.h.remove(paramw);
  }
  
  public void p(boolean paramBoolean)
  {
    w1();
    int i1 = this.o.p(paramBoolean, getPlaybackState());
    u1(paramBoolean, i1, a1(paramBoolean, i1));
  }
  
  public void prepare()
  {
    w1();
    boolean bool = E();
    int i1 = this.o.p(bool, 2);
    u1(bool, i1, a1(bool, i1));
    this.e.prepare();
  }
  
  public List<com.google.android.exoplayer2.text.c> q()
  {
    w1();
    return this.L;
  }
  
  public int r()
  {
    w1();
    return this.e.r();
  }
  
  public void release()
  {
    w1();
    if (o0.a < 21)
    {
      localObject = this.v;
      if (localObject != null)
      {
        ((AudioTrack)localObject).release();
        this.v = null;
      }
    }
    this.n.b(false);
    this.p.g();
    this.q.b(false);
    this.r.b(false);
    this.o.i();
    this.e.release();
    this.m.E1();
    k1();
    Object localObject = this.x;
    if (localObject != null)
    {
      ((Surface)localObject).release();
      this.x = null;
    }
    if (this.P)
    {
      ((PriorityTaskManager)com.google.android.exoplayer2.util.g.e(this.O)).b(0);
      this.P = false;
    }
    this.L = Collections.emptyList();
    this.Q = true;
  }
  
  public void s1(@Nullable SurfaceHolder paramSurfaceHolder)
  {
    w1();
    if (paramSurfaceHolder == null)
    {
      W0();
    }
    else
    {
      k1();
      this.A = true;
      this.y = paramSurfaceHolder;
      paramSurfaceHolder.addCallback(this.f);
      Surface localSurface = paramSurfaceHolder.getSurface();
      if ((localSurface != null) && (localSurface.isValid()))
      {
        r1(localSurface);
        paramSurfaceHolder = paramSurfaceHolder.getSurfaceFrame();
        e1(paramSurfaceHolder.width(), paramSurfaceHolder.height());
      }
      else
      {
        r1(null);
        e1(0, 0);
      }
    }
  }
  
  public void setRepeatMode(int paramInt)
  {
    w1();
    this.e.setRepeatMode(paramInt);
  }
  
  public int t()
  {
    w1();
    return this.e.t();
  }
  
  public void t1(float paramFloat)
  {
    w1();
    paramFloat = o0.o(paramFloat, 0.0F, 1.0F);
    if (this.J == paramFloat) {
      return;
    }
    this.J = paramFloat;
    o1();
    this.m.R(paramFloat);
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      ((r)localIterator.next()).R(paramFloat);
    }
  }
  
  public TrackGroupArray u()
  {
    w1();
    return this.e.u();
  }
  
  public long v()
  {
    w1();
    return this.e.v();
  }
  
  public j2 w()
  {
    w1();
    return this.e.w();
  }
  
  public Looper x()
  {
    return this.e.x();
  }
  
  public void z(@Nullable TextureView paramTextureView)
  {
    w1();
    if (paramTextureView == null)
    {
      W0();
    }
    else
    {
      k1();
      this.B = paramTextureView;
      if (paramTextureView.getSurfaceTextureListener() != null) {
        u.h("SimpleExoPlayer", "Replacing existing SurfaceTextureListener.");
      }
      paramTextureView.setSurfaceTextureListener(this.f);
      SurfaceTexture localSurfaceTexture;
      if (paramTextureView.isAvailable()) {
        localSurfaceTexture = paramTextureView.getSurfaceTexture();
      } else {
        localSurfaceTexture = null;
      }
      if (localSurfaceTexture == null)
      {
        r1(null);
        e1(0, 0);
      }
      else
      {
        q1(localSurfaceTexture);
        e1(paramTextureView.getWidth(), paramTextureView.getHeight());
      }
    }
  }
  
  public static final class b
  {
    private final Context a;
    private final f2 b;
    private com.google.android.exoplayer2.util.h c;
    private long d;
    private m e;
    private g0 f;
    private k1 g;
    private com.google.android.exoplayer2.upstream.g h;
    private h1 i;
    private Looper j;
    @Nullable
    private PriorityTaskManager k;
    private com.google.android.exoplayer2.audio.p l;
    private boolean m;
    private int n;
    private boolean o;
    private boolean p;
    private int q;
    private boolean r;
    private g2 s;
    private long t;
    private long u;
    private j1 v;
    private long w;
    private long x;
    private boolean y;
    private boolean z;
    
    public b(Context paramContext, f2 paramf2)
    {
      this(paramContext, paramf2, new com.google.android.exoplayer2.o2.h());
    }
    
    public b(Context paramContext, f2 paramf2, o paramo)
    {
      this(paramContext, paramf2, new DefaultTrackSelector(paramContext), new com.google.android.exoplayer2.source.t(paramContext, paramo), new a1(), com.google.android.exoplayer2.upstream.p.l(paramContext), new h1(com.google.android.exoplayer2.util.h.a));
    }
    
    public b(Context paramContext, f2 paramf2, m paramm, g0 paramg0, k1 paramk1, com.google.android.exoplayer2.upstream.g paramg, h1 paramh1)
    {
      this.a = paramContext;
      this.b = paramf2;
      this.e = paramm;
      this.f = paramg0;
      this.g = paramk1;
      this.h = paramg;
      this.i = paramh1;
      this.j = o0.L();
      this.l = com.google.android.exoplayer2.audio.p.a;
      this.n = 0;
      this.q = 1;
      this.r = true;
      this.s = g2.e;
      this.t = 5000L;
      this.u = 15000L;
      this.v = new z0.b().a();
      this.c = com.google.android.exoplayer2.util.h.a;
      this.w = 500L;
      this.x = 2000L;
    }
    
    public h2 z()
    {
      com.google.android.exoplayer2.util.g.g(this.z ^ true);
      this.z = true;
      return new h2(this);
    }
  }
  
  private final class c
    implements y, com.google.android.exoplayer2.audio.t, com.google.android.exoplayer2.text.k, com.google.android.exoplayer2.metadata.e, SurfaceHolder.Callback, TextureView.SurfaceTextureListener, SphericalGLSurfaceView.b, s0.b, r0.b, i2.b, u1.c, e1.a
  {
    private c() {}
    
    public void A(int paramInt)
    {
      boolean bool = h2.this.E();
      h2.G0(h2.this, bool, paramInt, h2.F0(bool, paramInt));
    }
    
    public void B(List<com.google.android.exoplayer2.text.c> paramList)
    {
      h2.w0(h2.this, paramList);
      Iterator localIterator = h2.x0(h2.this).iterator();
      while (localIterator.hasNext()) {
        ((com.google.android.exoplayer2.text.k)localIterator.next()).B(paramList);
      }
    }
    
    public void D(Format paramFormat, @Nullable com.google.android.exoplayer2.decoder.e parame)
    {
      h2.n0(h2.this, paramFormat);
      h2.m0(h2.this).D(paramFormat, parame);
    }
    
    public void E(long paramLong)
    {
      h2.m0(h2.this).E(paramLong);
    }
    
    public void F(Exception paramException)
    {
      h2.m0(h2.this).F(paramException);
    }
    
    public void H(com.google.android.exoplayer2.decoder.d paramd)
    {
      h2.m0(h2.this).H(paramd);
      h2.n0(h2.this, null);
      h2.l0(h2.this, null);
    }
    
    public void L(com.google.android.exoplayer2.decoder.d paramd)
    {
      h2.m0(h2.this).L(paramd);
      h2.s0(h2.this, null);
      h2.r0(h2.this, null);
    }
    
    public void M(boolean paramBoolean)
    {
      if (h2.M0(h2.this) != null) {
        if ((paramBoolean) && (!h2.N0(h2.this)))
        {
          h2.M0(h2.this).a(0);
          h2.O0(h2.this, true);
        }
        else if ((!paramBoolean) && (h2.N0(h2.this)))
        {
          h2.M0(h2.this).b(0);
          h2.O0(h2.this, false);
        }
      }
    }
    
    public void T(int paramInt, long paramLong)
    {
      h2.m0(h2.this).T(paramInt, paramLong);
    }
    
    public void V(Format paramFormat, @Nullable com.google.android.exoplayer2.decoder.e parame)
    {
      h2.s0(h2.this, paramFormat);
      h2.m0(h2.this).V(paramFormat, parame);
    }
    
    public void X(Object paramObject, long paramLong)
    {
      h2.m0(h2.this).X(paramObject, paramLong);
      if (h2.q0(h2.this) == paramObject)
      {
        paramObject = h2.p0(h2.this).iterator();
        while (((Iterator)paramObject).hasNext()) {
          ((w)((Iterator)paramObject).next()).z();
        }
      }
    }
    
    public void Z(com.google.android.exoplayer2.decoder.d paramd)
    {
      h2.l0(h2.this, paramd);
      h2.m0(h2.this).Z(paramd);
    }
    
    public void a(boolean paramBoolean)
    {
      if (h2.t0(h2.this) == paramBoolean) {
        return;
      }
      h2.u0(h2.this, paramBoolean);
      h2.v0(h2.this);
    }
    
    public void b(Exception paramException)
    {
      h2.m0(h2.this).b(paramException);
    }
    
    public void b0(Exception paramException)
    {
      h2.m0(h2.this).b0(paramException);
    }
    
    public void c(z paramz)
    {
      h2.o0(h2.this, paramz);
      h2.m0(h2.this).c(paramz);
      Iterator localIterator = h2.p0(h2.this).iterator();
      while (localIterator.hasNext())
      {
        w localw = (w)localIterator.next();
        localw.c(paramz);
        localw.W(paramz.c, paramz.d, paramz.e, paramz.f);
      }
    }
    
    public void d0(boolean paramBoolean, int paramInt)
    {
      h2.P0(h2.this);
    }
    
    public void h(String paramString)
    {
      h2.m0(h2.this).h(paramString);
    }
    
    public void h0(int paramInt, long paramLong1, long paramLong2)
    {
      h2.m0(h2.this).h0(paramInt, paramLong1, paramLong2);
    }
    
    public void i(com.google.android.exoplayer2.decoder.d paramd)
    {
      h2.r0(h2.this, paramd);
      h2.m0(h2.this).i(paramd);
    }
    
    public void j0(long paramLong, int paramInt)
    {
      h2.m0(h2.this).j0(paramLong, paramInt);
    }
    
    public void k(String paramString, long paramLong1, long paramLong2)
    {
      h2.m0(h2.this).k(paramString, paramLong1, paramLong2);
    }
    
    public void l(int paramInt)
    {
      b localb = h2.I0(h2.H0(h2.this));
      if (!localb.equals(h2.J0(h2.this)))
      {
        h2.K0(h2.this, localb);
        Iterator localIterator = h2.L0(h2.this).iterator();
        while (localIterator.hasNext()) {
          ((com.google.android.exoplayer2.n2.c)localIterator.next()).k0(localb);
        }
      }
    }
    
    public void m()
    {
      h2.G0(h2.this, false, -1, 3);
    }
    
    public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      h2.D0(h2.this, paramSurfaceTexture);
      h2.C0(h2.this, paramInt1, paramInt2);
    }
    
    public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      h2.B0(h2.this, null);
      h2.C0(h2.this, 0, 0);
      return true;
    }
    
    public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      h2.C0(h2.this, paramInt1, paramInt2);
    }
    
    public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
    
    public void p(Surface paramSurface)
    {
      h2.B0(h2.this, null);
    }
    
    public void q(int paramInt)
    {
      h2.P0(h2.this);
    }
    
    public void r(Surface paramSurface)
    {
      h2.B0(h2.this, paramSurface);
    }
    
    public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
    {
      h2.C0(h2.this, paramInt2, paramInt3);
    }
    
    public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
    {
      if (h2.A0(h2.this)) {
        h2.B0(h2.this, paramSurfaceHolder.getSurface());
      }
    }
    
    public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
    {
      if (h2.A0(h2.this)) {
        h2.B0(h2.this, null);
      }
      h2.C0(h2.this, 0, 0);
    }
    
    public void t(String paramString)
    {
      h2.m0(h2.this).t(paramString);
    }
    
    public void u(String paramString, long paramLong1, long paramLong2)
    {
      h2.m0(h2.this).u(paramString, paramLong1, paramLong2);
    }
    
    public void w(Metadata paramMetadata)
    {
      h2.m0(h2.this).w(paramMetadata);
      h2.y0(h2.this).h1(paramMetadata);
      Iterator localIterator = h2.z0(h2.this).iterator();
      while (localIterator.hasNext()) {
        ((com.google.android.exoplayer2.metadata.e)localIterator.next()).w(paramMetadata);
      }
    }
    
    public void x(int paramInt, boolean paramBoolean)
    {
      Iterator localIterator = h2.L0(h2.this).iterator();
      while (localIterator.hasNext()) {
        ((com.google.android.exoplayer2.n2.c)localIterator.next()).x(paramInt, paramBoolean);
      }
    }
    
    public void y(boolean paramBoolean)
    {
      h2.P0(h2.this);
    }
    
    public void z(float paramFloat)
    {
      h2.E0(h2.this);
    }
  }
  
  private static final class d
    implements com.google.android.exoplayer2.video.t, com.google.android.exoplayer2.video.spherical.d, x1.b
  {
    @Nullable
    private com.google.android.exoplayer2.video.t c;
    @Nullable
    private com.google.android.exoplayer2.video.spherical.d d;
    @Nullable
    private com.google.android.exoplayer2.video.t f;
    @Nullable
    private com.google.android.exoplayer2.video.spherical.d q;
    
    public void a(long paramLong1, long paramLong2, Format paramFormat, @Nullable MediaFormat paramMediaFormat)
    {
      com.google.android.exoplayer2.video.t localt = this.f;
      if (localt != null) {
        localt.a(paramLong1, paramLong2, paramFormat, paramMediaFormat);
      }
      localt = this.c;
      if (localt != null) {
        localt.a(paramLong1, paramLong2, paramFormat, paramMediaFormat);
      }
    }
    
    public void c(long paramLong, float[] paramArrayOfFloat)
    {
      com.google.android.exoplayer2.video.spherical.d locald = this.q;
      if (locald != null) {
        locald.c(paramLong, paramArrayOfFloat);
      }
      locald = this.d;
      if (locald != null) {
        locald.c(paramLong, paramArrayOfFloat);
      }
    }
    
    public void e()
    {
      com.google.android.exoplayer2.video.spherical.d locald = this.q;
      if (locald != null) {
        locald.e();
      }
      locald = this.d;
      if (locald != null) {
        locald.e();
      }
    }
    
    public void k(int paramInt, @Nullable Object paramObject)
    {
      if (paramInt != 6)
      {
        if (paramInt != 7)
        {
          if (paramInt == 10000)
          {
            paramObject = (SphericalGLSurfaceView)paramObject;
            if (paramObject == null)
            {
              this.f = null;
              this.q = null;
            }
            else
            {
              this.f = ((SphericalGLSurfaceView)paramObject).getVideoFrameMetadataListener();
              this.q = ((SphericalGLSurfaceView)paramObject).getCameraMotionListener();
            }
          }
        }
        else {
          this.d = ((com.google.android.exoplayer2.video.spherical.d)paramObject);
        }
      }
      else {
        this.c = ((com.google.android.exoplayer2.video.t)paramObject);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\h2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */