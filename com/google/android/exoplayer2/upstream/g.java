package com.google.android.exoplayer2.upstream;

import android.os.Handler;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract interface g
{
  public abstract long a();
  
  @Nullable
  public abstract a0 c();
  
  public abstract void d(a parama);
  
  public abstract long e();
  
  public abstract void g(Handler paramHandler, a parama);
  
  public static abstract interface a
  {
    public abstract void r(int paramInt, long paramLong1, long paramLong2);
    
    public static final class a
    {
      private final CopyOnWriteArrayList<a> a = new CopyOnWriteArrayList();
      
      public void a(Handler paramHandler, g.a parama)
      {
        com.google.android.exoplayer2.util.g.e(paramHandler);
        com.google.android.exoplayer2.util.g.e(parama);
        d(parama);
        this.a.add(new a(paramHandler, parama));
      }
      
      public void b(int paramInt, long paramLong1, long paramLong2)
      {
        Iterator localIterator = this.a.iterator();
        while (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          if (!a.b(locala)) {
            a.c(locala).post(new a(locala, paramInt, paramLong1, paramLong2));
          }
        }
      }
      
      public void d(g.a parama)
      {
        Iterator localIterator = this.a.iterator();
        while (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          if (a.a(locala) == parama)
          {
            locala.d();
            this.a.remove(locala);
          }
        }
      }
      
      private static final class a
      {
        private final Handler a;
        private final g.a b;
        private boolean c;
        
        public a(Handler paramHandler, g.a parama)
        {
          this.a = paramHandler;
          this.b = parama;
        }
        
        public void d()
        {
          this.c = true;
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\upstream\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */