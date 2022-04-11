package kotlinx.coroutines;

import kotlin.coroutines.a;
import kotlin.coroutines.f;
import kotlin.coroutines.f.b;
import kotlin.coroutines.f.c;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.j;
import kotlin.text.m;

public final class b0
  extends a
  implements w1<String>
{
  public static final a c = new a(null);
  private final long d;
  
  public b0(long paramLong)
  {
    super(c);
    this.d = paramLong;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof b0))
      {
        paramObject = (b0)paramObject;
        int i;
        if (this.d == ((b0)paramObject).d) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public <R> R fold(R paramR, p<? super R, ? super f.b, ? extends R> paramp)
  {
    j.f(paramp, "operation");
    return (R)w1.a.a(this, paramR, paramp);
  }
  
  public <E extends f.b> E get(f.c<E> paramc)
  {
    j.f(paramc, "key");
    return w1.a.b(this, paramc);
  }
  
  public int hashCode()
  {
    long l = this.d;
    return (int)(l ^ l >>> 32);
  }
  
  public f minusKey(f.c<?> paramc)
  {
    j.f(paramc, "key");
    return w1.a.c(this, paramc);
  }
  
  public f plus(f paramf)
  {
    j.f(paramf, "context");
    return w1.a.d(this, paramf);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CoroutineId(");
    localStringBuilder.append(this.d);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public final long u()
  {
    return this.d;
  }
  
  public void v(f paramf, String paramString)
  {
    j.f(paramf, "context");
    j.f(paramString, "oldState");
    paramf = Thread.currentThread();
    j.b(paramf, "Thread.currentThread()");
    paramf.setName(paramString);
  }
  
  public String w(f paramf)
  {
    j.f(paramf, "context");
    paramf = (c0)paramf.get(c0.c);
    if (paramf != null)
    {
      paramf = paramf.u();
      if (paramf != null) {}
    }
    else
    {
      paramf = "coroutine";
    }
    Thread localThread = Thread.currentThread();
    j.b(localThread, "currentThread");
    String str1 = localThread.getName();
    j.b(str1, "oldName");
    int i = m.R(str1, " @", 0, false, 6, null);
    int j = i;
    if (i < 0) {
      j = str1.length();
    }
    StringBuilder localStringBuilder = new StringBuilder(paramf.length() + j + 10);
    String str2 = str1.substring(0, j);
    j.b(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    localStringBuilder.append(str2);
    localStringBuilder.append(" @");
    localStringBuilder.append(paramf);
    localStringBuilder.append('#');
    localStringBuilder.append(this.d);
    paramf = localStringBuilder.toString();
    j.b(paramf, "StringBuilder(capacity).…builderAction).toString()");
    localThread.setName(paramf);
    return str1;
  }
  
  public static final class a
    implements f.c<b0>
  {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\b0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */