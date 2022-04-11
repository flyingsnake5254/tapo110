package com.google.android.exoplayer2.upstream;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

public final class Loader
{
  public static final c a = g(false, -9223372036854775807L);
  public static final c b = g(true, -9223372036854775807L);
  public static final c c = new c(2, -9223372036854775807L, null);
  public static final c d = new c(3, -9223372036854775807L, null);
  private final ExecutorService e;
  @Nullable
  private d<? extends e> f;
  @Nullable
  private IOException g;
  
  public Loader(String paramString)
  {
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {
      paramString = "ExoPlayer:Loader:".concat(paramString);
    } else {
      paramString = new String("ExoPlayer:Loader:");
    }
    this.e = o0.s0(paramString);
  }
  
  public static c g(boolean paramBoolean, long paramLong)
  {
    return new c(paramBoolean, paramLong, null);
  }
  
  public void e()
  {
    ((d)g.i(this.f)).a(false);
  }
  
  public void f()
  {
    this.g = null;
  }
  
  public boolean h()
  {
    boolean bool;
    if (this.g != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean i()
  {
    boolean bool;
    if (this.f != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void j()
    throws IOException
  {
    k(Integer.MIN_VALUE);
  }
  
  public void k(int paramInt)
    throws IOException
  {
    Object localObject = this.g;
    if (localObject == null)
    {
      localObject = this.f;
      if (localObject != null)
      {
        int i = paramInt;
        if (paramInt == Integer.MIN_VALUE) {
          i = ((d)localObject).c;
        }
        ((d)localObject).e(i);
      }
      return;
    }
    throw ((Throwable)localObject);
  }
  
  public void l()
  {
    m(null);
  }
  
  public void m(@Nullable f paramf)
  {
    d locald = this.f;
    if (locald != null) {
      locald.a(true);
    }
    if (paramf != null) {
      this.e.execute(new g(paramf));
    }
    this.e.shutdown();
  }
  
  public <T extends e> long n(T paramT, b<T> paramb, int paramInt)
  {
    Looper localLooper = (Looper)g.i(Looper.myLooper());
    this.g = null;
    long l = SystemClock.elapsedRealtime();
    new d(localLooper, paramT, paramb, paramInt, l).f(0L);
    return l;
  }
  
  public static final class UnexpectedLoaderException
    extends IOException
  {
    public UnexpectedLoaderException(Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
  
  public static abstract interface b<T extends Loader.e>
  {
    public abstract void b(T paramT, long paramLong1, long paramLong2, boolean paramBoolean);
    
    public abstract void h(T paramT, long paramLong1, long paramLong2);
    
    public abstract Loader.c n(T paramT, long paramLong1, long paramLong2, IOException paramIOException, int paramInt);
  }
  
  public static final class c
  {
    private final int a;
    private final long b;
    
    private c(int paramInt, long paramLong)
    {
      this.a = paramInt;
      this.b = paramLong;
    }
    
    public boolean c()
    {
      int i = this.a;
      boolean bool1 = true;
      boolean bool2 = bool1;
      if (i != 0) {
        if (i == 1) {
          bool2 = bool1;
        } else {
          bool2 = false;
        }
      }
      return bool2;
    }
  }
  
  @SuppressLint({"HandlerLeak"})
  private final class d<T extends Loader.e>
    extends Handler
    implements Runnable
  {
    public final int c;
    private final T d;
    private final long f;
    private boolean p0;
    private volatile boolean p1;
    @Nullable
    private Loader.b<T> q;
    @Nullable
    private IOException x;
    private int y;
    @Nullable
    private Thread z;
    
    public d(T paramT, Loader.b<T> paramb, int paramInt, long paramLong)
    {
      super();
      this.d = paramb;
      this.q = paramInt;
      this.c = paramLong;
      Object localObject;
      this.f = localObject;
    }
    
    private void b()
    {
      this.x = null;
      Loader.d(Loader.this).execute((Runnable)g.e(Loader.a(Loader.this)));
    }
    
    private void c()
    {
      Loader.b(Loader.this, null);
    }
    
    private long d()
    {
      return Math.min((this.y - 1) * 1000, 5000);
    }
    
    public void a(boolean paramBoolean)
    {
      this.p1 = paramBoolean;
      this.x = null;
      if (hasMessages(0))
      {
        this.p0 = true;
        removeMessages(0);
        if (paramBoolean) {
          break label72;
        }
        sendEmptyMessage(1);
      }
      try
      {
        this.p0 = true;
        this.d.c();
        Thread localThread = this.z;
        if (localThread != null) {
          localThread.interrupt();
        }
        label72:
        if (paramBoolean)
        {
          c();
          long l = SystemClock.elapsedRealtime();
          ((Loader.b)g.e(this.q)).b(this.d, l, l - this.f, true);
          this.q = null;
        }
        return;
      }
      finally {}
    }
    
    public void e(int paramInt)
      throws IOException
    {
      IOException localIOException = this.x;
      if ((localIOException != null) && (this.y > paramInt)) {
        throw localIOException;
      }
    }
    
    public void f(long paramLong)
    {
      boolean bool;
      if (Loader.a(Loader.this) == null) {
        bool = true;
      } else {
        bool = false;
      }
      g.g(bool);
      Loader.b(Loader.this, this);
      if (paramLong > 0L) {
        sendEmptyMessageDelayed(0, paramLong);
      } else {
        b();
      }
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (this.p1) {
        return;
      }
      int i = paramMessage.what;
      if (i == 0)
      {
        b();
        return;
      }
      if (i != 3)
      {
        c();
        long l1 = SystemClock.elapsedRealtime();
        long l2 = l1 - this.f;
        Loader.b localb = (Loader.b)g.e(this.q);
        if (this.p0)
        {
          localb.b(this.d, l1, l2, false);
          return;
        }
        i = paramMessage.what;
        if (i != 1)
        {
          if (i == 2)
          {
            paramMessage = (IOException)paramMessage.obj;
            this.x = paramMessage;
            i = this.y + 1;
            this.y = i;
            paramMessage = localb.n(this.d, l1, l2, paramMessage, i);
            if (Loader.c.a(paramMessage) == 3)
            {
              Loader.c(Loader.this, this.x);
            }
            else if (Loader.c.a(paramMessage) != 2)
            {
              if (Loader.c.a(paramMessage) == 1) {
                this.y = 1;
              }
              if (Loader.c.b(paramMessage) != -9223372036854775807L) {
                l2 = Loader.c.b(paramMessage);
              } else {
                l2 = d();
              }
              f(l2);
            }
          }
        }
        else {
          try
          {
            localb.h(this.d, l1, l2);
          }
          catch (RuntimeException paramMessage)
          {
            u.d("LoadTask", "Unexpected exception handling load completed", paramMessage);
            Loader.c(Loader.this, new Loader.UnexpectedLoaderException(paramMessage));
          }
        }
        return;
      }
      throw ((Error)paramMessage.obj);
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 95	com/google/android/exoplayer2/upstream/Loader$d:p0	Z
      //   6: ifne +8 -> 14
      //   9: iconst_1
      //   10: istore_1
      //   11: goto +5 -> 16
      //   14: iconst_0
      //   15: istore_1
      //   16: aload_0
      //   17: invokestatic 200	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   20: putfield 108	com/google/android/exoplayer2/upstream/Loader$d:z	Ljava/lang/Thread;
      //   23: aload_0
      //   24: monitorexit
      //   25: iload_1
      //   26: ifeq +66 -> 92
      //   29: aload_0
      //   30: getfield 42	com/google/android/exoplayer2/upstream/Loader$d:d	Lcom/google/android/exoplayer2/upstream/Loader$e;
      //   33: invokevirtual 206	java/lang/Object:getClass	()Ljava/lang/Class;
      //   36: invokevirtual 212	java/lang/Class:getSimpleName	()Ljava/lang/String;
      //   39: astore_2
      //   40: aload_2
      //   41: invokevirtual 218	java/lang/String:length	()I
      //   44: ifeq +13 -> 57
      //   47: ldc -36
      //   49: aload_2
      //   50: invokevirtual 224	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   53: astore_2
      //   54: goto +13 -> 67
      //   57: new 214	java/lang/String
      //   60: dup
      //   61: ldc -36
      //   63: invokespecial 227	java/lang/String:<init>	(Ljava/lang/String;)V
      //   66: astore_2
      //   67: aload_2
      //   68: invokestatic 231	com/google/android/exoplayer2/util/m0:a	(Ljava/lang/String;)V
      //   71: aload_0
      //   72: getfield 42	com/google/android/exoplayer2/upstream/Loader$d:d	Lcom/google/android/exoplayer2/upstream/Loader$e;
      //   75: invokeinterface 233 1 0
      //   80: invokestatic 234	com/google/android/exoplayer2/util/m0:c	()V
      //   83: goto +9 -> 92
      //   86: astore_2
      //   87: invokestatic 234	com/google/android/exoplayer2/util/m0:c	()V
      //   90: aload_2
      //   91: athrow
      //   92: aload_0
      //   93: monitorenter
      //   94: aload_0
      //   95: aconst_null
      //   96: putfield 108	com/google/android/exoplayer2/upstream/Loader$d:z	Ljava/lang/Thread;
      //   99: invokestatic 238	java/lang/Thread:interrupted	()Z
      //   102: pop
      //   103: aload_0
      //   104: monitorexit
      //   105: aload_0
      //   106: getfield 89	com/google/android/exoplayer2/upstream/Loader$d:p1	Z
      //   109: ifne +136 -> 245
      //   112: aload_0
      //   113: iconst_1
      //   114: invokevirtual 102	android/os/Handler:sendEmptyMessage	(I)Z
      //   117: pop
      //   118: goto +127 -> 245
      //   121: astore_2
      //   122: aload_0
      //   123: monitorexit
      //   124: aload_2
      //   125: athrow
      //   126: astore_2
      //   127: aload_0
      //   128: monitorexit
      //   129: aload_2
      //   130: athrow
      //   131: astore_2
      //   132: aload_0
      //   133: getfield 89	com/google/android/exoplayer2/upstream/Loader$d:p1	Z
      //   136: ifne +20 -> 156
      //   139: ldc -79
      //   141: ldc -16
      //   143: aload_2
      //   144: invokestatic 184	com/google/android/exoplayer2/util/u:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   147: aload_0
      //   148: iconst_3
      //   149: aload_2
      //   150: invokevirtual 244	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
      //   153: invokevirtual 247	android/os/Message:sendToTarget	()V
      //   156: aload_2
      //   157: athrow
      //   158: astore_2
      //   159: aload_0
      //   160: getfield 89	com/google/android/exoplayer2/upstream/Loader$d:p1	Z
      //   163: ifne +82 -> 245
      //   166: ldc -79
      //   168: ldc -7
      //   170: aload_2
      //   171: invokestatic 184	com/google/android/exoplayer2/util/u:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   174: aload_0
      //   175: iconst_2
      //   176: new 186	com/google/android/exoplayer2/upstream/Loader$UnexpectedLoaderException
      //   179: dup
      //   180: aload_2
      //   181: invokespecial 189	com/google/android/exoplayer2/upstream/Loader$UnexpectedLoaderException:<init>	(Ljava/lang/Throwable;)V
      //   184: invokevirtual 244	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
      //   187: invokevirtual 247	android/os/Message:sendToTarget	()V
      //   190: goto +55 -> 245
      //   193: astore_2
      //   194: aload_0
      //   195: getfield 89	com/google/android/exoplayer2/upstream/Loader$d:p1	Z
      //   198: ifne +47 -> 245
      //   201: ldc -79
      //   203: ldc -5
      //   205: aload_2
      //   206: invokestatic 184	com/google/android/exoplayer2/util/u:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   209: aload_0
      //   210: iconst_2
      //   211: new 186	com/google/android/exoplayer2/upstream/Loader$UnexpectedLoaderException
      //   214: dup
      //   215: aload_2
      //   216: invokespecial 189	com/google/android/exoplayer2/upstream/Loader$UnexpectedLoaderException:<init>	(Ljava/lang/Throwable;)V
      //   219: invokevirtual 244	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
      //   222: invokevirtual 247	android/os/Message:sendToTarget	()V
      //   225: goto +20 -> 245
      //   228: astore_2
      //   229: aload_0
      //   230: getfield 89	com/google/android/exoplayer2/upstream/Loader$d:p1	Z
      //   233: ifne +12 -> 245
      //   236: aload_0
      //   237: iconst_2
      //   238: aload_2
      //   239: invokevirtual 244	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
      //   242: invokevirtual 247	android/os/Message:sendToTarget	()V
      //   245: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	246	0	this	d
      //   10	16	1	i	int
      //   39	29	2	str	String
      //   86	5	2	localObject1	Object
      //   121	4	2	localObject2	Object
      //   126	4	2	localObject3	Object
      //   131	26	2	localError	Error
      //   158	23	2	localOutOfMemoryError	OutOfMemoryError
      //   193	23	2	localException	Exception
      //   228	11	2	localIOException	IOException
      // Exception table:
      //   from	to	target	type
      //   71	80	86	finally
      //   94	105	121	finally
      //   122	124	121	finally
      //   2	9	126	finally
      //   16	25	126	finally
      //   127	129	126	finally
      //   0	2	131	java/lang/Error
      //   29	54	131	java/lang/Error
      //   57	67	131	java/lang/Error
      //   67	71	131	java/lang/Error
      //   80	83	131	java/lang/Error
      //   87	92	131	java/lang/Error
      //   92	94	131	java/lang/Error
      //   105	118	131	java/lang/Error
      //   124	126	131	java/lang/Error
      //   129	131	131	java/lang/Error
      //   0	2	158	java/lang/OutOfMemoryError
      //   29	54	158	java/lang/OutOfMemoryError
      //   57	67	158	java/lang/OutOfMemoryError
      //   67	71	158	java/lang/OutOfMemoryError
      //   80	83	158	java/lang/OutOfMemoryError
      //   87	92	158	java/lang/OutOfMemoryError
      //   92	94	158	java/lang/OutOfMemoryError
      //   105	118	158	java/lang/OutOfMemoryError
      //   124	126	158	java/lang/OutOfMemoryError
      //   129	131	158	java/lang/OutOfMemoryError
      //   0	2	193	java/lang/Exception
      //   29	54	193	java/lang/Exception
      //   57	67	193	java/lang/Exception
      //   67	71	193	java/lang/Exception
      //   80	83	193	java/lang/Exception
      //   87	92	193	java/lang/Exception
      //   92	94	193	java/lang/Exception
      //   105	118	193	java/lang/Exception
      //   124	126	193	java/lang/Exception
      //   129	131	193	java/lang/Exception
      //   0	2	228	java/io/IOException
      //   29	54	228	java/io/IOException
      //   57	67	228	java/io/IOException
      //   67	71	228	java/io/IOException
      //   80	83	228	java/io/IOException
      //   87	92	228	java/io/IOException
      //   92	94	228	java/io/IOException
      //   105	118	228	java/io/IOException
      //   124	126	228	java/io/IOException
      //   129	131	228	java/io/IOException
    }
  }
  
  public static abstract interface e
  {
    public abstract void a()
      throws IOException;
    
    public abstract void c();
  }
  
  public static abstract interface f
  {
    public abstract void p();
  }
  
  private static final class g
    implements Runnable
  {
    private final Loader.f c;
    
    public g(Loader.f paramf)
    {
      this.c = paramf;
    }
    
    public void run()
    {
      this.c.p();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\upstream\Loader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */