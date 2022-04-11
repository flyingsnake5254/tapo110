package kotlinx.coroutines;

import kotlin.jvm.internal.j;
import kotlinx.coroutines.internal.a;

public abstract class q0
  extends y
{
  private long c;
  private boolean d;
  private a<m0<?>> f;
  
  private final long v(boolean paramBoolean)
  {
    long l;
    if (paramBoolean) {
      l = 4294967296L;
    } else {
      l = 1L;
    }
    return l;
  }
  
  public final boolean A()
  {
    long l = this.c;
    boolean bool = true;
    if (l < v(true)) {
      bool = false;
    }
    return bool;
  }
  
  public final boolean B()
  {
    a locala = this.f;
    boolean bool;
    if (locala != null) {
      bool = locala.c();
    } else {
      bool = true;
    }
    return bool;
  }
  
  public final boolean C()
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      localObject = (m0)((a)localObject).d();
      if (localObject != null)
      {
        ((m0)localObject).run();
        return true;
      }
    }
    return false;
  }
  
  protected void shutdown() {}
  
  public final void u(boolean paramBoolean)
  {
    long l = this.c - v(paramBoolean);
    this.c = l;
    if (l > 0L) {
      return;
    }
    if (g0.a())
    {
      int i;
      if (this.c == 0L) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        throw new AssertionError();
      }
    }
    if (this.d) {
      shutdown();
    }
  }
  
  public final void w(m0<?> paramm0)
  {
    j.f(paramm0, "task");
    a locala = this.f;
    if (locala == null)
    {
      locala = new a();
      this.f = locala;
    }
    locala.a(paramm0);
  }
  
  protected long x()
  {
    a locala = this.f;
    long l1 = Long.MAX_VALUE;
    long l2 = l1;
    if (locala != null) {
      if (locala.c()) {
        l2 = l1;
      } else {
        l2 = 0L;
      }
    }
    return l2;
  }
  
  public final void y(boolean paramBoolean)
  {
    this.c += v(paramBoolean);
    if (!paramBoolean) {
      this.d = true;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\q0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */