package kotlinx.coroutines.internal;

import kotlin.jvm.internal.j;

public final class h
{
  private static final Object a = new t("CONDITION_FALSE");
  private static final Object b = new t("ALREADY_REMOVED");
  private static final Object c = new t("LIST_EMPTY");
  private static final Object d = new t("REMOVE_PREPARED");
  
  public static final Object b()
  {
    return a;
  }
  
  public static final Object c()
  {
    return c;
  }
  
  public static final i d(Object paramObject)
  {
    j.f(paramObject, "$this$unwrap");
    if (!(paramObject instanceof p)) {
      localObject = null;
    } else {
      localObject = paramObject;
    }
    Object localObject = (p)localObject;
    if (localObject != null)
    {
      localObject = ((p)localObject).a;
      if (localObject != null) {
        return (i)localObject;
      }
    }
    paramObject = (i)paramObject;
    return (i)paramObject;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\internal\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */