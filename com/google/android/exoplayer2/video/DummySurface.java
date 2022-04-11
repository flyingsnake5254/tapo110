package com.google.android.exoplayer2.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.EGLSurfaceTexture;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.q;

@RequiresApi(17)
public final class DummySurface
  extends Surface
{
  private static int c;
  private static boolean d;
  public final boolean f;
  private final b q;
  private boolean x;
  
  private DummySurface(b paramb, SurfaceTexture paramSurfaceTexture, boolean paramBoolean)
  {
    super(paramSurfaceTexture);
    this.q = paramb;
    this.f = paramBoolean;
  }
  
  private static int a(Context paramContext)
  {
    if (q.h(paramContext))
    {
      if (q.i()) {
        return 1;
      }
      return 2;
    }
    return 0;
  }
  
  public static boolean b(Context paramContext)
  {
    try
    {
      boolean bool1 = d;
      boolean bool2 = true;
      if (!bool1)
      {
        c = a(paramContext);
        d = true;
      }
      int i = c;
      if (i == 0) {
        bool2 = false;
      }
      return bool2;
    }
    finally {}
  }
  
  public static DummySurface c(Context paramContext, boolean paramBoolean)
  {
    int i = 0;
    boolean bool;
    if ((paramBoolean) && (!b(paramContext))) {
      bool = false;
    } else {
      bool = true;
    }
    g.g(bool);
    paramContext = new b();
    if (paramBoolean) {
      i = c;
    }
    return paramContext.a(i);
  }
  
  public void release()
  {
    super.release();
    synchronized (this.q)
    {
      if (!this.x)
      {
        this.q.c();
        this.x = true;
      }
      return;
    }
  }
  
  private static class b
    extends HandlerThread
    implements Handler.Callback
  {
    private EGLSurfaceTexture c;
    private Handler d;
    @Nullable
    private Error f;
    @Nullable
    private RuntimeException q;
    @Nullable
    private DummySurface x;
    
    public b()
    {
      super();
    }
    
    private void b(int paramInt)
    {
      g.e(this.c);
      this.c.h(paramInt);
      SurfaceTexture localSurfaceTexture = this.c.g();
      boolean bool;
      if (paramInt != 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.x = new DummySurface(this, localSurfaceTexture, bool, null);
    }
    
    private void d()
    {
      g.e(this.c);
      this.c.i();
    }
    
    public DummySurface a(int paramInt)
    {
      start();
      this.d = new Handler(getLooper(), this);
      this.c = new EGLSurfaceTexture(this.d);
      try
      {
        Object localObject1 = this.d;
        int i = 0;
        ((Handler)localObject1).obtainMessage(1, paramInt, 0).sendToTarget();
        paramInt = i;
        while ((this.x == null) && (this.q == null))
        {
          localObject1 = this.f;
          if (localObject1 != null) {
            break;
          }
          try
          {
            wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            paramInt = 1;
          }
        }
        if (paramInt != 0) {
          Thread.currentThread().interrupt();
        }
        Object localObject2 = this.q;
        if (localObject2 == null)
        {
          localObject2 = this.f;
          if (localObject2 == null) {
            return (DummySurface)g.e(this.x);
          }
          throw ((Throwable)localObject2);
        }
        throw ((Throwable)localObject2);
      }
      finally {}
    }
    
    public void c()
    {
      g.e(this.d);
      this.d.sendEmptyMessage(2);
    }
    
    /* Error */
    public boolean handleMessage(Message paramMessage)
    {
      // Byte code:
      //   0: aload_1
      //   1: getfield 116	android/os/Message:what	I
      //   4: istore_2
      //   5: iload_2
      //   6: iconst_1
      //   7: if_icmpeq +44 -> 51
      //   10: iload_2
      //   11: iconst_2
      //   12: if_icmpeq +5 -> 17
      //   15: iconst_1
      //   16: ireturn
      //   17: aload_0
      //   18: invokespecial 118	com/google/android/exoplayer2/video/DummySurface$b:d	()V
      //   21: aload_0
      //   22: invokevirtual 122	android/os/HandlerThread:quit	()Z
      //   25: pop
      //   26: goto +15 -> 41
      //   29: astore_1
      //   30: ldc 124
      //   32: ldc 126
      //   34: aload_1
      //   35: invokestatic 131	com/google/android/exoplayer2/util/u:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   38: goto -17 -> 21
      //   41: iconst_1
      //   42: ireturn
      //   43: astore_1
      //   44: aload_0
      //   45: invokevirtual 122	android/os/HandlerThread:quit	()Z
      //   48: pop
      //   49: aload_1
      //   50: athrow
      //   51: aload_0
      //   52: aload_1
      //   53: getfield 134	android/os/Message:arg1	I
      //   56: invokespecial 136	com/google/android/exoplayer2/video/DummySurface$b:b	(I)V
      //   59: aload_0
      //   60: monitorenter
      //   61: aload_0
      //   62: invokevirtual 139	java/lang/Object:notify	()V
      //   65: aload_0
      //   66: monitorexit
      //   67: goto +64 -> 131
      //   70: astore_1
      //   71: aload_0
      //   72: monitorexit
      //   73: aload_1
      //   74: athrow
      //   75: astore_1
      //   76: goto +62 -> 138
      //   79: astore_1
      //   80: ldc 124
      //   82: ldc -115
      //   84: aload_1
      //   85: invokestatic 131	com/google/android/exoplayer2/util/u:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   88: aload_0
      //   89: aload_1
      //   90: putfield 88	com/google/android/exoplayer2/video/DummySurface$b:f	Ljava/lang/Error;
      //   93: aload_0
      //   94: monitorenter
      //   95: aload_0
      //   96: invokevirtual 139	java/lang/Object:notify	()V
      //   99: aload_0
      //   100: monitorexit
      //   101: goto +30 -> 131
      //   104: astore_1
      //   105: aload_0
      //   106: monitorexit
      //   107: aload_1
      //   108: athrow
      //   109: astore_1
      //   110: ldc 124
      //   112: ldc -115
      //   114: aload_1
      //   115: invokestatic 131	com/google/android/exoplayer2/util/u:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   118: aload_0
      //   119: aload_1
      //   120: putfield 86	com/google/android/exoplayer2/video/DummySurface$b:q	Ljava/lang/RuntimeException;
      //   123: aload_0
      //   124: monitorenter
      //   125: aload_0
      //   126: invokevirtual 139	java/lang/Object:notify	()V
      //   129: aload_0
      //   130: monitorexit
      //   131: iconst_1
      //   132: ireturn
      //   133: astore_1
      //   134: aload_0
      //   135: monitorexit
      //   136: aload_1
      //   137: athrow
      //   138: aload_0
      //   139: monitorenter
      //   140: aload_0
      //   141: invokevirtual 139	java/lang/Object:notify	()V
      //   144: aload_0
      //   145: monitorexit
      //   146: aload_1
      //   147: athrow
      //   148: astore_1
      //   149: aload_0
      //   150: monitorexit
      //   151: aload_1
      //   152: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	153	0	this	b
      //   0	153	1	paramMessage	Message
      //   4	9	2	i	int
      // Exception table:
      //   from	to	target	type
      //   17	21	29	finally
      //   30	38	43	finally
      //   61	67	70	finally
      //   71	73	70	finally
      //   51	59	75	finally
      //   80	93	75	finally
      //   110	123	75	finally
      //   51	59	79	java/lang/Error
      //   95	101	104	finally
      //   105	107	104	finally
      //   51	59	109	java/lang/RuntimeException
      //   125	131	133	finally
      //   134	136	133	finally
      //   140	146	148	finally
      //   149	151	148	finally
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\video\DummySurface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */