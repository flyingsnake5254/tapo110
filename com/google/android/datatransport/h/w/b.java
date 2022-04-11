package com.google.android.datatransport.h.w;

public final class b
{
  public static <TInput, TResult, TException extends Throwable> TResult a(int paramInt, TInput paramTInput, a<TInput, TResult, TException> parama, c<TInput, TResult> paramc)
    throws Throwable
  {
    int i = paramInt;
    Object localObject = paramTInput;
    if (paramInt < 1) {
      return (TResult)parama.apply(paramTInput);
    }
    do
    {
      paramTInput = parama.apply(localObject);
      localObject = paramc.a(localObject, paramTInput);
      if (localObject == null) {
        break;
      }
      paramInt = i - 1;
      i = paramInt;
    } while (paramInt >= 1);
    return paramTInput;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\h\w\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */