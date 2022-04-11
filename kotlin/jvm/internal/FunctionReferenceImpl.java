package kotlin.jvm.internal;

import kotlin.reflect.d;

public class FunctionReferenceImpl
  extends FunctionReference
{
  public FunctionReferenceImpl(int paramInt1, Class paramClass, String paramString1, String paramString2, int paramInt2)
  {
    super(paramInt1, CallableReference.NO_RECEIVER, paramClass, paramString1, paramString2, paramInt2);
  }
  
  public FunctionReferenceImpl(int paramInt1, Object paramObject, Class paramClass, String paramString1, String paramString2, int paramInt2)
  {
    super(paramInt1, paramObject, paramClass, paramString1, paramString2, paramInt2);
  }
  
  public FunctionReferenceImpl(int paramInt, d paramd, String paramString1, String paramString2)
  {
    super(paramInt, CallableReference.NO_RECEIVER, ((c)paramd).a(), paramString1, paramString2, paramd instanceof kotlin.reflect.c ^ true);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\jvm\internal\FunctionReferenceImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */