package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Method;
import kotlin.jvm.internal.j;

final class g
{
  private static final a a = new a(null, null, null);
  public static a b;
  public static final g c = new g();
  
  private final a a(BaseContinuationImpl paramBaseContinuationImpl)
  {
    try
    {
      Method localMethod1 = Class.class.getDeclaredMethod("getModule", new Class[0]);
      Method localMethod2 = paramBaseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]);
      paramBaseContinuationImpl = paramBaseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]);
      a locala = new kotlin/coroutines/jvm/internal/g$a;
      locala.<init>(localMethod1, localMethod2, paramBaseContinuationImpl);
      b = locala;
      return locala;
    }
    catch (Exception paramBaseContinuationImpl)
    {
      paramBaseContinuationImpl = a;
      b = paramBaseContinuationImpl;
    }
    return paramBaseContinuationImpl;
  }
  
  public final String b(BaseContinuationImpl paramBaseContinuationImpl)
  {
    j.e(paramBaseContinuationImpl, "continuation");
    Object localObject1 = b;
    if (localObject1 == null) {
      localObject1 = a(paramBaseContinuationImpl);
    }
    Object localObject2 = a;
    Object localObject3 = null;
    Object localObject4 = null;
    if (localObject1 == localObject2) {
      return null;
    }
    Method localMethod = ((a)localObject1).a;
    localObject2 = localObject3;
    if (localMethod != null)
    {
      paramBaseContinuationImpl = localMethod.invoke(paramBaseContinuationImpl.getClass(), new Object[0]);
      localObject2 = localObject3;
      if (paramBaseContinuationImpl != null)
      {
        localMethod = ((a)localObject1).b;
        localObject2 = localObject3;
        if (localMethod != null)
        {
          paramBaseContinuationImpl = localMethod.invoke(paramBaseContinuationImpl, new Object[0]);
          localObject2 = localObject3;
          if (paramBaseContinuationImpl != null)
          {
            localObject1 = ((a)localObject1).c;
            if (localObject1 != null) {
              paramBaseContinuationImpl = ((Method)localObject1).invoke(paramBaseContinuationImpl, new Object[0]);
            } else {
              paramBaseContinuationImpl = null;
            }
            if (!(paramBaseContinuationImpl instanceof String)) {
              paramBaseContinuationImpl = (BaseContinuationImpl)localObject4;
            }
            localObject2 = (String)paramBaseContinuationImpl;
          }
        }
      }
    }
    return (String)localObject2;
  }
  
  private static final class a
  {
    public final Method a;
    public final Method b;
    public final Method c;
    
    public a(Method paramMethod1, Method paramMethod2, Method paramMethod3)
    {
      this.a = paramMethod1;
      this.b = paramMethod2;
      this.c = paramMethod3;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\coroutines\jvm\internal\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */