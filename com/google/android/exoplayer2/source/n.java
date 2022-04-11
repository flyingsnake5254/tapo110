package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.o2.i0.f;
import com.google.android.exoplayer2.o2.j;
import com.google.android.exoplayer2.o2.k;
import com.google.android.exoplayer2.o2.o;
import com.google.android.exoplayer2.o2.x;
import com.google.android.exoplayer2.util.g;
import java.io.IOException;

public final class n
  implements i0
{
  private final o a;
  @Nullable
  private j b;
  @Nullable
  private k c;
  
  public n(o paramo)
  {
    this.a = paramo;
  }
  
  public int a(x paramx)
    throws IOException
  {
    return ((j)g.e(this.b)).e((k)g.e(this.c), paramx);
  }
  
  public void b()
  {
    j localj = this.b;
    if ((localj instanceof f)) {
      ((f)localj).h();
    }
  }
  
  public void c(long paramLong1, long paramLong2)
  {
    ((j)g.e(this.b)).c(paramLong1, paramLong2);
  }
  
  /* Error */
  public void d(com.google.android.exoplayer2.upstream.i parami, android.net.Uri paramUri, java.util.Map<String, java.util.List<String>> paramMap, long paramLong1, long paramLong2, com.google.android.exoplayer2.o2.l paraml)
    throws IOException
  {
    // Byte code:
    //   0: new 56	com/google/android/exoplayer2/o2/g
    //   3: dup
    //   4: aload_1
    //   5: lload 4
    //   7: lload 6
    //   9: invokespecial 59	com/google/android/exoplayer2/o2/g:<init>	(Lcom/google/android/exoplayer2/upstream/i;JJ)V
    //   12: astore_1
    //   13: aload_0
    //   14: aload_1
    //   15: putfield 36	com/google/android/exoplayer2/source/n:c	Lcom/google/android/exoplayer2/o2/k;
    //   18: aload_0
    //   19: getfield 26	com/google/android/exoplayer2/source/n:b	Lcom/google/android/exoplayer2/o2/j;
    //   22: ifnull +4 -> 26
    //   25: return
    //   26: aload_0
    //   27: getfield 20	com/google/android/exoplayer2/source/n:a	Lcom/google/android/exoplayer2/o2/o;
    //   30: aload_2
    //   31: aload_3
    //   32: invokeinterface 64 3 0
    //   37: astore_3
    //   38: aload_3
    //   39: arraylength
    //   40: istore 9
    //   42: iconst_0
    //   43: istore 10
    //   45: iload 9
    //   47: iconst_1
    //   48: if_icmpne +13 -> 61
    //   51: aload_0
    //   52: aload_3
    //   53: iconst_0
    //   54: aaload
    //   55: putfield 26	com/google/android/exoplayer2/source/n:b	Lcom/google/android/exoplayer2/o2/j;
    //   58: goto +172 -> 230
    //   61: aload_3
    //   62: arraylength
    //   63: istore 11
    //   65: iconst_0
    //   66: istore 9
    //   68: iload 9
    //   70: iload 11
    //   72: if_icmpge +151 -> 223
    //   75: aload_3
    //   76: iload 9
    //   78: aaload
    //   79: astore 12
    //   81: aload 12
    //   83: aload_1
    //   84: invokeinterface 67 2 0
    //   89: ifeq +22 -> 111
    //   92: aload_0
    //   93: aload 12
    //   95: putfield 26	com/google/android/exoplayer2/source/n:b	Lcom/google/android/exoplayer2/o2/j;
    //   98: iconst_1
    //   99: invokestatic 71	com/google/android/exoplayer2/util/g:g	(Z)V
    //   102: aload_1
    //   103: invokeinterface 73 1 0
    //   108: goto +115 -> 223
    //   111: aload_0
    //   112: getfield 26	com/google/android/exoplayer2/source/n:b	Lcom/google/android/exoplayer2/o2/j;
    //   115: ifnonnull +88 -> 203
    //   118: aload_1
    //   119: invokeinterface 77 1 0
    //   124: lload 4
    //   126: lcmp
    //   127: ifne +70 -> 197
    //   130: goto +73 -> 203
    //   133: astore_2
    //   134: aload_0
    //   135: getfield 26	com/google/android/exoplayer2/source/n:b	Lcom/google/android/exoplayer2/o2/j;
    //   138: ifnonnull +19 -> 157
    //   141: iload 10
    //   143: istore 13
    //   145: aload_1
    //   146: invokeinterface 77 1 0
    //   151: lload 4
    //   153: lcmp
    //   154: ifne +6 -> 160
    //   157: iconst_1
    //   158: istore 13
    //   160: iload 13
    //   162: invokestatic 71	com/google/android/exoplayer2/util/g:g	(Z)V
    //   165: aload_1
    //   166: invokeinterface 73 1 0
    //   171: aload_2
    //   172: athrow
    //   173: astore 12
    //   175: aload_0
    //   176: getfield 26	com/google/android/exoplayer2/source/n:b	Lcom/google/android/exoplayer2/o2/j;
    //   179: ifnonnull +24 -> 203
    //   182: aload_1
    //   183: invokeinterface 77 1 0
    //   188: lload 4
    //   190: lcmp
    //   191: ifne +6 -> 197
    //   194: goto +9 -> 203
    //   197: iconst_0
    //   198: istore 13
    //   200: goto +6 -> 206
    //   203: iconst_1
    //   204: istore 13
    //   206: iload 13
    //   208: invokestatic 71	com/google/android/exoplayer2/util/g:g	(Z)V
    //   211: aload_1
    //   212: invokeinterface 73 1 0
    //   217: iinc 9 1
    //   220: goto -152 -> 68
    //   223: aload_0
    //   224: getfield 26	com/google/android/exoplayer2/source/n:b	Lcom/google/android/exoplayer2/o2/j;
    //   227: ifnull +15 -> 242
    //   230: aload_0
    //   231: getfield 26	com/google/android/exoplayer2/source/n:b	Lcom/google/android/exoplayer2/o2/j;
    //   234: aload 8
    //   236: invokeinterface 80 2 0
    //   241: return
    //   242: aload_3
    //   243: invokestatic 86	com/google/android/exoplayer2/util/o0:H	([Ljava/lang/Object;)Ljava/lang/String;
    //   246: astore_1
    //   247: new 88	java/lang/StringBuilder
    //   250: dup
    //   251: aload_1
    //   252: invokestatic 94	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   255: invokevirtual 98	java/lang/String:length	()I
    //   258: bipush 58
    //   260: iadd
    //   261: invokespecial 101	java/lang/StringBuilder:<init>	(I)V
    //   264: astore_3
    //   265: aload_3
    //   266: ldc 103
    //   268: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: aload_3
    //   273: aload_1
    //   274: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: aload_3
    //   279: ldc 109
    //   281: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: new 111	com/google/android/exoplayer2/source/UnrecognizedInputFormatException
    //   288: dup
    //   289: aload_3
    //   290: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: aload_2
    //   294: invokestatic 32	com/google/android/exoplayer2/util/g:e	(Ljava/lang/Object;)Ljava/lang/Object;
    //   297: checkcast 117	android/net/Uri
    //   300: invokespecial 120	com/google/android/exoplayer2/source/UnrecognizedInputFormatException:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   303: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	this	n
    //   0	304	1	parami	com.google.android.exoplayer2.upstream.i
    //   0	304	2	paramUri	android.net.Uri
    //   0	304	3	paramMap	java.util.Map<String, java.util.List<String>>
    //   0	304	4	paramLong1	long
    //   0	304	6	paramLong2	long
    //   0	304	8	paraml	com.google.android.exoplayer2.o2.l
    //   40	178	9	i	int
    //   43	99	10	bool1	boolean
    //   63	10	11	j	int
    //   79	15	12	localj	j
    //   173	1	12	localEOFException	java.io.EOFException
    //   143	64	13	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   81	98	133	finally
    //   81	98	173	java/io/EOFException
  }
  
  public long e()
  {
    k localk = this.c;
    long l;
    if (localk != null) {
      l = localk.getPosition();
    } else {
      l = -1L;
    }
    return l;
  }
  
  public void release()
  {
    j localj = this.b;
    if (localj != null)
    {
      localj.release();
      this.b = null;
    }
    this.c = null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */