package kotlinx.coroutines;

import kotlinx.coroutines.internal.t;

public final class k1
{
  private static final t a = new t("SEALED");
  private static final p0 b = new p0(false);
  private static final p0 c = new p0(true);
  
  public static final Object d(Object paramObject)
  {
    Object localObject = paramObject;
    if ((paramObject instanceof y0)) {
      localObject = new z0((y0)paramObject);
    }
    return localObject;
  }
  
  public static final Object e(Object paramObject)
  {
    if (!(paramObject instanceof z0)) {
      localObject1 = null;
    } else {
      localObject1 = paramObject;
    }
    Object localObject2 = (z0)localObject1;
    Object localObject1 = paramObject;
    if (localObject2 != null)
    {
      localObject2 = ((z0)localObject2).a;
      localObject1 = paramObject;
      if (localObject2 != null) {
        localObject1 = localObject2;
      }
    }
    return localObject1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\k1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */