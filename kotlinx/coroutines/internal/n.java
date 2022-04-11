package kotlinx.coroutines.internal;

import kotlin.coroutines.f;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.m1;

final class n
  extends m1
{
  private final Throwable c;
  private final String d;
  
  public n(Throwable paramThrowable, String paramString)
  {
    this.c = paramThrowable;
    this.d = paramString;
  }
  
  private final Void w()
  {
    if (this.c != null)
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("Module with the Main dispatcher had failed to initialize");
      String str = this.d;
      if (str != null)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(". ");
        localStringBuilder2.append(str);
        str = localStringBuilder2.toString();
        if (str != null) {}
      }
      else
      {
        str = "";
      }
      localStringBuilder1.append(str);
      throw new IllegalStateException(localStringBuilder1.toString(), this.c);
    }
    throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android'");
  }
  
  public boolean isDispatchNeeded(f paramf)
  {
    j.f(paramf, "context");
    w();
    throw null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Main[missing");
    Object localObject;
    if (this.c != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(", cause=");
      ((StringBuilder)localObject).append(this.c);
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public m1 u()
  {
    return this;
  }
  
  public Void v(f paramf, Runnable paramRunnable)
  {
    j.f(paramf, "context");
    j.f(paramRunnable, "block");
    w();
    throw null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\internal\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */