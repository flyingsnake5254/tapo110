package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import com.google.android.exoplayer2.audio.DefaultAudioSink.d;
import com.google.android.exoplayer2.audio.q;
import com.google.android.exoplayer2.audio.t;
import com.google.android.exoplayer2.mediacodec.s;
import com.google.android.exoplayer2.metadata.f;
import com.google.android.exoplayer2.text.k;
import com.google.android.exoplayer2.text.l;
import com.google.android.exoplayer2.video.y;
import java.util.ArrayList;

public class c1
  implements f2
{
  private final Context a;
  private int b;
  private long c;
  private boolean d;
  private s e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  
  public c1(Context paramContext)
  {
    this.a = paramContext;
    this.b = 0;
    this.c = 5000L;
    this.e = s.a;
  }
  
  public b2[] a(Handler paramHandler, y paramy, t paramt, k paramk, com.google.android.exoplayer2.metadata.e parame)
  {
    ArrayList localArrayList = new ArrayList();
    h(this.a, this.b, this.e, this.d, paramHandler, paramy, this.c, localArrayList);
    paramy = c(this.a, this.i, this.j, this.k);
    if (paramy != null) {
      b(this.a, this.b, this.e, this.d, paramy, paramHandler, paramt, localArrayList);
    }
    g(this.a, paramk, paramHandler.getLooper(), this.b, localArrayList);
    e(this.a, parame, paramHandler.getLooper(), this.b, localArrayList);
    d(this.a, this.b, localArrayList);
    f(this.a, paramHandler, this.b, localArrayList);
    return (b2[])localArrayList.toArray(new b2[0]);
  }
  
  /* Error */
  protected void b(Context paramContext, int paramInt, s params, boolean paramBoolean, AudioSink paramAudioSink, Handler paramHandler, t paramt, ArrayList<b2> paramArrayList)
  {
    // Byte code:
    //   0: new 95	com/google/android/exoplayer2/audio/d0
    //   3: dup
    //   4: aload_1
    //   5: aload_3
    //   6: iload 4
    //   8: aload 6
    //   10: aload 7
    //   12: aload 5
    //   14: invokespecial 98	com/google/android/exoplayer2/audio/d0:<init>	(Landroid/content/Context;Lcom/google/android/exoplayer2/mediacodec/s;ZLandroid/os/Handler;Lcom/google/android/exoplayer2/audio/t;Lcom/google/android/exoplayer2/audio/AudioSink;)V
    //   17: astore_1
    //   18: aload_1
    //   19: aload_0
    //   20: getfield 100	com/google/android/exoplayer2/c1:f	Z
    //   23: invokevirtual 106	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:g0	(Z)V
    //   26: aload_1
    //   27: aload_0
    //   28: getfield 108	com/google/android/exoplayer2/c1:g	Z
    //   31: invokevirtual 111	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:h0	(Z)V
    //   34: aload_1
    //   35: aload_0
    //   36: getfield 113	com/google/android/exoplayer2/c1:h	Z
    //   39: invokevirtual 116	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:i0	(Z)V
    //   42: aload 8
    //   44: aload_1
    //   45: invokevirtual 120	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   48: pop
    //   49: iload_2
    //   50: ifne +4 -> 54
    //   53: return
    //   54: aload 8
    //   56: invokevirtual 124	java/util/ArrayList:size	()I
    //   59: istore 9
    //   61: iload 9
    //   63: istore 10
    //   65: iload_2
    //   66: iconst_2
    //   67: if_icmpne +9 -> 76
    //   70: iload 9
    //   72: iconst_1
    //   73: isub
    //   74: istore 10
    //   76: ldc 126
    //   78: invokestatic 132	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   81: iconst_3
    //   82: anewarray 128	java/lang/Class
    //   85: dup
    //   86: iconst_0
    //   87: ldc 65
    //   89: aastore
    //   90: dup
    //   91: iconst_1
    //   92: ldc -122
    //   94: aastore
    //   95: dup
    //   96: iconst_2
    //   97: ldc -120
    //   99: aastore
    //   100: invokevirtual 140	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   103: iconst_3
    //   104: anewarray 4	java/lang/Object
    //   107: dup
    //   108: iconst_0
    //   109: aload 6
    //   111: aastore
    //   112: dup
    //   113: iconst_1
    //   114: aload 7
    //   116: aastore
    //   117: dup
    //   118: iconst_2
    //   119: aload 5
    //   121: aastore
    //   122: invokevirtual 146	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   125: checkcast 83	com/google/android/exoplayer2/b2
    //   128: astore_1
    //   129: iload 10
    //   131: iconst_1
    //   132: iadd
    //   133: istore_2
    //   134: aload 8
    //   136: iload 10
    //   138: aload_1
    //   139: invokevirtual 149	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   142: ldc -105
    //   144: ldc -103
    //   146: invokestatic 158	com/google/android/exoplayer2/util/u:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   149: goto +25 -> 174
    //   152: astore_1
    //   153: iload_2
    //   154: istore 10
    //   156: goto +15 -> 171
    //   159: astore_1
    //   160: new 160	java/lang/RuntimeException
    //   163: dup
    //   164: ldc -94
    //   166: aload_1
    //   167: invokespecial 165	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   170: athrow
    //   171: iload 10
    //   173: istore_2
    //   174: ldc -89
    //   176: invokestatic 132	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   179: iconst_3
    //   180: anewarray 128	java/lang/Class
    //   183: dup
    //   184: iconst_0
    //   185: ldc 65
    //   187: aastore
    //   188: dup
    //   189: iconst_1
    //   190: ldc -122
    //   192: aastore
    //   193: dup
    //   194: iconst_2
    //   195: ldc -120
    //   197: aastore
    //   198: invokevirtual 140	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   201: iconst_3
    //   202: anewarray 4	java/lang/Object
    //   205: dup
    //   206: iconst_0
    //   207: aload 6
    //   209: aastore
    //   210: dup
    //   211: iconst_1
    //   212: aload 7
    //   214: aastore
    //   215: dup
    //   216: iconst_2
    //   217: aload 5
    //   219: aastore
    //   220: invokevirtual 146	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   223: checkcast 83	com/google/android/exoplayer2/b2
    //   226: astore_1
    //   227: iload_2
    //   228: iconst_1
    //   229: iadd
    //   230: istore 10
    //   232: aload 8
    //   234: iload_2
    //   235: aload_1
    //   236: invokevirtual 149	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   239: ldc -105
    //   241: ldc -87
    //   243: invokestatic 158	com/google/android/exoplayer2/util/u:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   246: goto +25 -> 271
    //   249: astore_1
    //   250: iload 10
    //   252: istore_2
    //   253: goto +15 -> 268
    //   256: astore_1
    //   257: new 160	java/lang/RuntimeException
    //   260: dup
    //   261: ldc -85
    //   263: aload_1
    //   264: invokespecial 165	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   267: athrow
    //   268: iload_2
    //   269: istore 10
    //   271: aload 8
    //   273: iload 10
    //   275: ldc -83
    //   277: invokestatic 132	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   280: iconst_3
    //   281: anewarray 128	java/lang/Class
    //   284: dup
    //   285: iconst_0
    //   286: ldc 65
    //   288: aastore
    //   289: dup
    //   290: iconst_1
    //   291: ldc -122
    //   293: aastore
    //   294: dup
    //   295: iconst_2
    //   296: ldc -120
    //   298: aastore
    //   299: invokevirtual 140	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   302: iconst_3
    //   303: anewarray 4	java/lang/Object
    //   306: dup
    //   307: iconst_0
    //   308: aload 6
    //   310: aastore
    //   311: dup
    //   312: iconst_1
    //   313: aload 7
    //   315: aastore
    //   316: dup
    //   317: iconst_2
    //   318: aload 5
    //   320: aastore
    //   321: invokevirtual 146	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   324: checkcast 83	com/google/android/exoplayer2/b2
    //   327: invokevirtual 149	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   330: ldc -105
    //   332: ldc -81
    //   334: invokestatic 158	com/google/android/exoplayer2/util/u:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   337: goto +15 -> 352
    //   340: astore_1
    //   341: new 160	java/lang/RuntimeException
    //   344: dup
    //   345: ldc -79
    //   347: aload_1
    //   348: invokespecial 165	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   351: athrow
    //   352: return
    //   353: astore_1
    //   354: goto -183 -> 171
    //   357: astore_1
    //   358: goto -90 -> 268
    //   361: astore_1
    //   362: goto -10 -> 352
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	365	0	this	c1
    //   0	365	1	paramContext	Context
    //   0	365	2	paramInt	int
    //   0	365	3	params	s
    //   0	365	4	paramBoolean	boolean
    //   0	365	5	paramAudioSink	AudioSink
    //   0	365	6	paramHandler	Handler
    //   0	365	7	paramt	t
    //   0	365	8	paramArrayList	ArrayList<b2>
    //   59	15	9	m	int
    //   63	211	10	n	int
    // Exception table:
    //   from	to	target	type
    //   134	149	152	java/lang/ClassNotFoundException
    //   76	129	159	java/lang/Exception
    //   134	149	159	java/lang/Exception
    //   232	246	249	java/lang/ClassNotFoundException
    //   174	227	256	java/lang/Exception
    //   232	246	256	java/lang/Exception
    //   271	337	340	java/lang/Exception
    //   76	129	353	java/lang/ClassNotFoundException
    //   174	227	357	java/lang/ClassNotFoundException
    //   271	337	361	java/lang/ClassNotFoundException
  }
  
  @Nullable
  protected AudioSink c(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    return new DefaultAudioSink(q.c(paramContext), new DefaultAudioSink.d(new AudioProcessor[0]), paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  protected void d(Context paramContext, int paramInt, ArrayList<b2> paramArrayList)
  {
    paramArrayList.add(new com.google.android.exoplayer2.video.spherical.e());
  }
  
  protected void e(Context paramContext, com.google.android.exoplayer2.metadata.e parame, Looper paramLooper, int paramInt, ArrayList<b2> paramArrayList)
  {
    paramArrayList.add(new f(parame, paramLooper));
  }
  
  protected void f(Context paramContext, Handler paramHandler, int paramInt, ArrayList<b2> paramArrayList) {}
  
  protected void g(Context paramContext, k paramk, Looper paramLooper, int paramInt, ArrayList<b2> paramArrayList)
  {
    paramArrayList.add(new l(paramk, paramLooper));
  }
  
  /* Error */
  protected void h(Context paramContext, int paramInt, s params, boolean paramBoolean, Handler paramHandler, y paramy, long paramLong, ArrayList<b2> paramArrayList)
  {
    // Byte code:
    //   0: new 217	com/google/android/exoplayer2/video/q
    //   3: dup
    //   4: aload_1
    //   5: aload_3
    //   6: lload 7
    //   8: iload 4
    //   10: aload 5
    //   12: aload 6
    //   14: bipush 50
    //   16: invokespecial 220	com/google/android/exoplayer2/video/q:<init>	(Landroid/content/Context;Lcom/google/android/exoplayer2/mediacodec/s;JZLandroid/os/Handler;Lcom/google/android/exoplayer2/video/y;I)V
    //   19: astore_1
    //   20: aload_1
    //   21: aload_0
    //   22: getfield 100	com/google/android/exoplayer2/c1:f	Z
    //   25: invokevirtual 106	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:g0	(Z)V
    //   28: aload_1
    //   29: aload_0
    //   30: getfield 108	com/google/android/exoplayer2/c1:g	Z
    //   33: invokevirtual 111	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:h0	(Z)V
    //   36: aload_1
    //   37: aload_0
    //   38: getfield 113	com/google/android/exoplayer2/c1:h	Z
    //   41: invokevirtual 116	com/google/android/exoplayer2/mediacodec/MediaCodecRenderer:i0	(Z)V
    //   44: aload 9
    //   46: aload_1
    //   47: invokevirtual 120	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   50: pop
    //   51: iload_2
    //   52: ifne +4 -> 56
    //   55: return
    //   56: aload 9
    //   58: invokevirtual 124	java/util/ArrayList:size	()I
    //   61: istore 10
    //   63: iload 10
    //   65: istore 11
    //   67: iload_2
    //   68: iconst_2
    //   69: if_icmpne +9 -> 78
    //   72: iload 10
    //   74: iconst_1
    //   75: isub
    //   76: istore 11
    //   78: ldc -34
    //   80: invokestatic 132	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   83: iconst_4
    //   84: anewarray 128	java/lang/Class
    //   87: dup
    //   88: iconst_0
    //   89: getstatic 228	java/lang/Long:TYPE	Ljava/lang/Class;
    //   92: aastore
    //   93: dup
    //   94: iconst_1
    //   95: ldc 65
    //   97: aastore
    //   98: dup
    //   99: iconst_2
    //   100: ldc -26
    //   102: aastore
    //   103: dup
    //   104: iconst_3
    //   105: getstatic 233	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   108: aastore
    //   109: invokevirtual 140	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   112: iconst_4
    //   113: anewarray 4	java/lang/Object
    //   116: dup
    //   117: iconst_0
    //   118: lload 7
    //   120: invokestatic 237	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   123: aastore
    //   124: dup
    //   125: iconst_1
    //   126: aload 5
    //   128: aastore
    //   129: dup
    //   130: iconst_2
    //   131: aload 6
    //   133: aastore
    //   134: dup
    //   135: iconst_3
    //   136: bipush 50
    //   138: invokestatic 240	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   141: aastore
    //   142: invokevirtual 146	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   145: checkcast 83	com/google/android/exoplayer2/b2
    //   148: astore_1
    //   149: iload 11
    //   151: iconst_1
    //   152: iadd
    //   153: istore_2
    //   154: aload 9
    //   156: iload 11
    //   158: aload_1
    //   159: invokevirtual 149	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   162: ldc -105
    //   164: ldc -14
    //   166: invokestatic 158	com/google/android/exoplayer2/util/u:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: goto +25 -> 194
    //   172: astore_1
    //   173: iload_2
    //   174: istore 11
    //   176: goto +15 -> 191
    //   179: astore_1
    //   180: new 160	java/lang/RuntimeException
    //   183: dup
    //   184: ldc -12
    //   186: aload_1
    //   187: invokespecial 165	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   190: athrow
    //   191: iload 11
    //   193: istore_2
    //   194: aload 9
    //   196: iload_2
    //   197: ldc -10
    //   199: invokestatic 132	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   202: iconst_4
    //   203: anewarray 128	java/lang/Class
    //   206: dup
    //   207: iconst_0
    //   208: getstatic 228	java/lang/Long:TYPE	Ljava/lang/Class;
    //   211: aastore
    //   212: dup
    //   213: iconst_1
    //   214: ldc 65
    //   216: aastore
    //   217: dup
    //   218: iconst_2
    //   219: ldc -26
    //   221: aastore
    //   222: dup
    //   223: iconst_3
    //   224: getstatic 233	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   227: aastore
    //   228: invokevirtual 140	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   231: iconst_4
    //   232: anewarray 4	java/lang/Object
    //   235: dup
    //   236: iconst_0
    //   237: lload 7
    //   239: invokestatic 237	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   242: aastore
    //   243: dup
    //   244: iconst_1
    //   245: aload 5
    //   247: aastore
    //   248: dup
    //   249: iconst_2
    //   250: aload 6
    //   252: aastore
    //   253: dup
    //   254: iconst_3
    //   255: bipush 50
    //   257: invokestatic 240	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   260: aastore
    //   261: invokevirtual 146	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   264: checkcast 83	com/google/android/exoplayer2/b2
    //   267: invokevirtual 149	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   270: ldc -105
    //   272: ldc -8
    //   274: invokestatic 158	com/google/android/exoplayer2/util/u:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   277: goto +15 -> 292
    //   280: astore_1
    //   281: new 160	java/lang/RuntimeException
    //   284: dup
    //   285: ldc -6
    //   287: aload_1
    //   288: invokespecial 165	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   291: athrow
    //   292: return
    //   293: astore_1
    //   294: goto -103 -> 191
    //   297: astore_1
    //   298: goto -6 -> 292
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	301	0	this	c1
    //   0	301	1	paramContext	Context
    //   0	301	2	paramInt	int
    //   0	301	3	params	s
    //   0	301	4	paramBoolean	boolean
    //   0	301	5	paramHandler	Handler
    //   0	301	6	paramy	y
    //   0	301	7	paramLong	long
    //   0	301	9	paramArrayList	ArrayList<b2>
    //   61	15	10	m	int
    //   65	127	11	n	int
    // Exception table:
    //   from	to	target	type
    //   154	169	172	java/lang/ClassNotFoundException
    //   78	149	179	java/lang/Exception
    //   154	169	179	java/lang/Exception
    //   194	277	280	java/lang/Exception
    //   78	149	293	java/lang/ClassNotFoundException
    //   194	277	297	java/lang/ClassNotFoundException
  }
  
  public c1 i(int paramInt)
  {
    this.b = paramInt;
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\c1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */