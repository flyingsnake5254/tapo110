package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import kotlin.coroutines.f;
import kotlin.jvm.internal.j;

public final class a
  extends b
{
  private volatile a _immediate;
  private final a c;
  private final Handler d;
  private final String f;
  private final boolean q;
  
  public a(Handler paramHandler, String paramString)
  {
    this(paramHandler, paramString, false);
  }
  
  private a(Handler paramHandler, String paramString, boolean paramBoolean)
  {
    super(null);
    this.d = paramHandler;
    this.f = paramString;
    this.q = paramBoolean;
    if (paramBoolean) {
      locala = this;
    }
    this._immediate = locala;
    locala = this._immediate;
    if (locala != null)
    {
      paramHandler = locala;
    }
    else
    {
      paramHandler = new a(paramHandler, paramString, true);
      this._immediate = paramHandler;
    }
    this.c = paramHandler;
  }
  
  public void dispatch(f paramf, Runnable paramRunnable)
  {
    j.f(paramf, "context");
    j.f(paramRunnable, "block");
    this.d.post(paramRunnable);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (((paramObject instanceof a)) && (((a)paramObject).d == this.d)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int hashCode()
  {
    return System.identityHashCode(this.d);
  }
  
  public boolean isDispatchNeeded(f paramf)
  {
    j.f(paramf, "context");
    boolean bool1 = this.q;
    boolean bool2 = true;
    boolean bool3 = bool2;
    if (bool1) {
      if ((j.a(Looper.myLooper(), this.d.getLooper()) ^ true)) {
        bool3 = bool2;
      } else {
        bool3 = false;
      }
    }
    return bool3;
  }
  
  public String toString()
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      if (this.q)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.f);
        ((StringBuilder)localObject).append(" [immediate]");
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    else
    {
      localObject = this.d.toString();
      j.b(localObject, "handler.toString()");
    }
    return (String)localObject;
  }
  
  public a v()
  {
    return this.c;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\android\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */