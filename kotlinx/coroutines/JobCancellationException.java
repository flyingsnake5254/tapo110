package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.j;

public final class JobCancellationException
  extends CancellationException
  implements w<JobCancellationException>
{
  public final d1 job;
  
  public JobCancellationException(String paramString, Throwable paramThrowable, d1 paramd1)
  {
    super(paramString);
    this.job = paramd1;
    if (paramThrowable != null) {
      initCause(paramThrowable);
    }
  }
  
  public JobCancellationException createCopy()
  {
    if (g0.c())
    {
      String str = getMessage();
      if (str == null) {
        j.n();
      }
      return new JobCancellationException(str, this, this.job);
    }
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject != this) {
      if ((paramObject instanceof JobCancellationException))
      {
        paramObject = (JobCancellationException)paramObject;
        if ((j.a(((CancellationException)paramObject).getMessage(), getMessage())) && (j.a(((JobCancellationException)paramObject).job, this.job)) && (j.a(((CancellationException)paramObject).getCause(), getCause()))) {}
      }
      else
      {
        return false;
      }
    }
    boolean bool = true;
    return bool;
  }
  
  public Throwable fillInStackTrace()
  {
    if (g0.c())
    {
      Throwable localThrowable = super.fillInStackTrace();
      j.b(localThrowable, "super.fillInStackTrace()");
      return localThrowable;
    }
    return this;
  }
  
  public int hashCode()
  {
    Object localObject = getMessage();
    if (localObject == null) {
      j.n();
    }
    int i = ((String)localObject).hashCode();
    int j = this.job.hashCode();
    localObject = getCause();
    int k;
    if (localObject != null) {
      k = ((Throwable)localObject).hashCode();
    } else {
      k = 0;
    }
    return (i * 31 + j) * 31 + k;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append("; job=");
    localStringBuilder.append(this.job);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\JobCancellationException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */