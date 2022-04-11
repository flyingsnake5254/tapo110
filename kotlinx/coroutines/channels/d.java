package kotlinx.coroutines.channels;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.j;
import kotlin.p;
import kotlinx.coroutines.g0;
import kotlinx.coroutines.internal.i.c;
import kotlinx.coroutines.selects.e;

public class d<E>
  extends a<E>
{
  private final ReentrantLock f;
  private Object[] q;
  private volatile int size;
  private int x;
  private final int y;
  
  public d(int paramInt)
  {
    this.y = paramInt;
    int i = 1;
    if (paramInt < 1) {
      i = 0;
    }
    if (i != 0)
    {
      this.f = new ReentrantLock();
      this.q = new Object[Math.min(paramInt, 8)];
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ArrayChannel capacity must be at least 1, but ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" was specified");
    throw new IllegalArgumentException(localStringBuilder.toString().toString());
  }
  
  private final void T(int paramInt)
  {
    Object[] arrayOfObject1 = this.q;
    if (paramInt >= arrayOfObject1.length)
    {
      Object[] arrayOfObject2 = new Object[Math.min(arrayOfObject1.length * 2, this.y)];
      for (int i = 0; i < paramInt; i++)
      {
        arrayOfObject1 = this.q;
        arrayOfObject2[i] = arrayOfObject1[((this.x + i) % arrayOfObject1.length)];
      }
      this.q = arrayOfObject2;
      this.x = 0;
    }
  }
  
  protected void G()
  {
    ReentrantLock localReentrantLock = this.f;
    localReentrantLock.lock();
    try
    {
      int i = this.size;
      for (int j = 0; j < i; j++)
      {
        this.q[this.x] = Integer.valueOf(0);
        this.x = ((this.x + 1) % this.q.length);
      }
      this.size = 0;
      p localp = p.a;
      localReentrantLock.unlock();
      super.G();
      return;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  protected final boolean K()
  {
    return false;
  }
  
  protected final boolean L()
  {
    boolean bool;
    if (this.size == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected Object P()
  {
    ReentrantLock localReentrantLock = this.f;
    localReentrantLock.lock();
    try
    {
      int i = this.size;
      if (i == 0)
      {
        localObject1 = k();
        if (localObject1 == null) {
          localObject1 = b.c;
        }
        return localObject1;
      }
      Object localObject3 = this.q;
      int j = this.x;
      Object localObject4 = localObject3[j];
      Object localObject1 = null;
      localObject3[j] = null;
      this.size = (i - 1);
      Object localObject5 = b.c;
      if (i == this.y)
      {
        localObject1 = null;
        localObject3 = localObject1;
        for (;;)
        {
          localObject6 = B();
          if (localObject6 == null) {
            break;
          }
          localObject3 = ((u)localObject6).O(null);
          if (localObject3 != null)
          {
            localObject5 = ((u)localObject6).M();
            localObject1 = localObject6;
            localObject6 = localObject5;
            break label157;
          }
          localObject1 = localObject6;
        }
        localObject6 = localObject5;
      }
      else
      {
        localObject3 = null;
        localObject6 = localObject5;
      }
      label157:
      if ((localObject6 != b.c) && (!(localObject6 instanceof k)))
      {
        this.size = i;
        localObject5 = this.q;
        localObject5[((this.x + i) % localObject5.length)] = localObject6;
      }
      this.x = ((this.x + 1) % this.q.length);
      Object localObject6 = p.a;
      localReentrantLock.unlock();
      if (localObject3 != null)
      {
        if (localObject1 == null) {
          j.n();
        }
        ((u)localObject1).L(localObject3);
      }
      return localObject4;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  protected Object Q(kotlinx.coroutines.selects.d<?> paramd)
  {
    j.f(paramd, "select");
    ReentrantLock localReentrantLock = this.f;
    localReentrantLock.lock();
    try
    {
      int i = this.size;
      if (i == 0)
      {
        paramd = k();
        if (paramd == null) {
          paramd = b.c;
        }
        return paramd;
      }
      Object localObject1 = this.q;
      int j = this.x;
      Object localObject2 = localObject1[j];
      localObject1[j] = null;
      this.size = (i - 1);
      Object localObject3 = b.c;
      if (i == this.y)
      {
        localObject1 = H();
        localObject4 = paramd.n((kotlinx.coroutines.internal.b)localObject1);
        if (localObject4 == null)
        {
          localObject5 = (u)((i.c)localObject1).k();
          localObject1 = ((a.f)localObject1).d;
          if (g0.a())
          {
            if (localObject1 != null) {
              j = 1;
            } else {
              j = 0;
            }
            if (j == 0)
            {
              paramd = new java/lang/AssertionError;
              paramd.<init>();
              throw paramd;
            }
          }
          if (localObject5 == null) {
            j.n();
          }
          localObject4 = ((u)localObject5).M();
          break label315;
        }
        if (localObject4 != localObject3)
        {
          if (localObject4 == e.c())
          {
            this.size = i;
            this.q[this.x] = localObject2;
            return localObject4;
          }
          if ((localObject4 instanceof k))
          {
            localObject5 = (u)localObject4;
            localObject1 = ((k)localObject4).O(null);
            break label315;
          }
          paramd = new java/lang/StringBuilder;
          paramd.<init>();
          paramd.append("performAtomicTrySelect(describeTryOffer) returned ");
          paramd.append(localObject4);
          localObject1 = paramd.toString();
          paramd = new java/lang/IllegalStateException;
          paramd.<init>(localObject1.toString());
          throw paramd;
        }
      }
      Object localObject4 = localObject3;
      localObject1 = null;
      Object localObject5 = localObject1;
      label315:
      if ((localObject4 != localObject3) && (!(localObject4 instanceof k)))
      {
        this.size = i;
        paramd = this.q;
        paramd[((this.x + i) % paramd.length)] = localObject4;
      }
      else if (!paramd.g(null))
      {
        this.size = i;
        this.q[this.x] = localObject2;
        paramd = e.c();
        return paramd;
      }
      this.x = ((this.x + 1) % this.q.length);
      paramd = p.a;
      localReentrantLock.unlock();
      if (localObject1 != null)
      {
        if (localObject5 == null) {
          j.n();
        }
        ((u)localObject5).L(localObject1);
      }
      return localObject2;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  protected String j()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(buffer:capacity=");
    localStringBuilder.append(this.y);
    localStringBuilder.append(",size=");
    localStringBuilder.append(this.size);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  protected final boolean s()
  {
    return false;
  }
  
  protected final boolean t()
  {
    boolean bool;
    if (this.size == this.y) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected Object v(E paramE)
  {
    ReentrantLock localReentrantLock = this.f;
    localReentrantLock.lock();
    try
    {
      int i = this.size;
      Object localObject1 = k();
      if (localObject1 != null) {
        return localObject1;
      }
      if (i < this.y)
      {
        this.size = (i + 1);
        if (i == 0)
        {
          Object localObject2;
          do
          {
            localObject1 = A();
            if (localObject1 == null) {
              break;
            }
            if ((localObject1 instanceof k))
            {
              this.size = i;
              return localObject1;
            }
            localObject2 = ((s)localObject1).m(paramE, null);
          } while (localObject2 == null);
          this.size = i;
          paramE = p.a;
          localReentrantLock.unlock();
          ((s)localObject1).j(localObject2);
          return ((s)localObject1).a();
        }
        T(i);
        localObject1 = this.q;
        localObject1[((this.x + i) % localObject1.length)] = paramE;
        paramE = b.a;
        return paramE;
      }
      paramE = b.b;
      return paramE;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\channels\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */