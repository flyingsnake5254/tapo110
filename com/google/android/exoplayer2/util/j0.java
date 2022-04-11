package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

final class j0
  implements r
{
  @GuardedBy("messagePool")
  private static final List<b> a = new ArrayList(50);
  private final Handler b;
  
  public j0(Handler paramHandler)
  {
    this.b = paramHandler;
  }
  
  private static b m()
  {
    synchronized (a)
    {
      b localb;
      if (???.isEmpty())
      {
        localb = new com/google/android/exoplayer2/util/j0$b;
        localb.<init>(null);
      }
      else
      {
        localb = (b)???.remove(???.size() - 1);
      }
      return localb;
    }
  }
  
  private static void n(b paramb)
  {
    synchronized (a)
    {
      if (???.size() < 50) {
        ???.add(paramb);
      }
      return;
    }
  }
  
  public r.a a(int paramInt)
  {
    return m().d(this.b.obtainMessage(paramInt), this);
  }
  
  public boolean b(r.a parama)
  {
    return ((b)parama).c(this.b);
  }
  
  public boolean c(int paramInt)
  {
    return this.b.hasMessages(paramInt);
  }
  
  public r.a d(int paramInt1, int paramInt2, int paramInt3, @Nullable Object paramObject)
  {
    return m().d(this.b.obtainMessage(paramInt1, paramInt2, paramInt3, paramObject), this);
  }
  
  public r.a e(int paramInt, @Nullable Object paramObject)
  {
    return m().d(this.b.obtainMessage(paramInt, paramObject), this);
  }
  
  public void f(@Nullable Object paramObject)
  {
    this.b.removeCallbacksAndMessages(paramObject);
  }
  
  public r.a g(int paramInt1, int paramInt2, int paramInt3)
  {
    return m().d(this.b.obtainMessage(paramInt1, paramInt2, paramInt3), this);
  }
  
  public boolean h(Runnable paramRunnable)
  {
    return this.b.post(paramRunnable);
  }
  
  public boolean i(int paramInt)
  {
    return this.b.sendEmptyMessage(paramInt);
  }
  
  public boolean j(int paramInt, long paramLong)
  {
    return this.b.sendEmptyMessageAtTime(paramInt, paramLong);
  }
  
  public void k(int paramInt)
  {
    this.b.removeMessages(paramInt);
  }
  
  private static final class b
    implements r.a
  {
    @Nullable
    private Message a;
    @Nullable
    private j0 b;
    
    private void b()
    {
      this.a = null;
      this.b = null;
      j0.l(this);
    }
    
    public void a()
    {
      ((Message)g.e(this.a)).sendToTarget();
      b();
    }
    
    public boolean c(Handler paramHandler)
    {
      boolean bool = paramHandler.sendMessageAtFrontOfQueue((Message)g.e(this.a));
      b();
      return bool;
    }
    
    public b d(Message paramMessage, j0 paramj0)
    {
      this.a = paramMessage;
      this.b = paramj0;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\util\j0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */