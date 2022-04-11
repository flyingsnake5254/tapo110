package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Field;
import kotlin.jvm.internal.j;

public final class e
{
  private static final void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 <= paramInt1) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Debug metadata version mismatch. Expected: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", got ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(". Please update the Kotlin standard library.");
    throw new IllegalStateException(localStringBuilder.toString().toString());
  }
  
  private static final d b(BaseContinuationImpl paramBaseContinuationImpl)
  {
    return (d)paramBaseContinuationImpl.getClass().getAnnotation(d.class);
  }
  
  private static final int c(BaseContinuationImpl paramBaseContinuationImpl)
  {
    int i;
    try
    {
      Object localObject = paramBaseContinuationImpl.getClass().getDeclaredField("label");
      j.d(localObject, "field");
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(paramBaseContinuationImpl);
      paramBaseContinuationImpl = (BaseContinuationImpl)localObject;
      if (!(localObject instanceof Integer)) {
        paramBaseContinuationImpl = null;
      }
      paramBaseContinuationImpl = (Integer)paramBaseContinuationImpl;
      if (paramBaseContinuationImpl != null) {
        i = paramBaseContinuationImpl.intValue();
      } else {
        i = 0;
      }
      i--;
    }
    catch (Exception paramBaseContinuationImpl)
    {
      i = -1;
    }
    return i;
  }
  
  public static final StackTraceElement d(BaseContinuationImpl paramBaseContinuationImpl)
  {
    j.e(paramBaseContinuationImpl, "$this$getStackTraceElementImpl");
    d locald = b(paramBaseContinuationImpl);
    if (locald != null)
    {
      a(1, locald.v());
      int i = c(paramBaseContinuationImpl);
      if (i < 0) {
        i = -1;
      } else {
        i = locald.l()[i];
      }
      String str = g.c.b(paramBaseContinuationImpl);
      if (str == null)
      {
        paramBaseContinuationImpl = locald.c();
      }
      else
      {
        paramBaseContinuationImpl = new StringBuilder();
        paramBaseContinuationImpl.append(str);
        paramBaseContinuationImpl.append('/');
        paramBaseContinuationImpl.append(locald.c());
        paramBaseContinuationImpl = paramBaseContinuationImpl.toString();
      }
      return new StackTraceElement(paramBaseContinuationImpl, locald.m(), locald.f(), i);
    }
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\coroutines\jvm\internal\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */