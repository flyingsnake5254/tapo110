package com.google.android.datatransport.h;

import com.google.android.datatransport.b;
import com.google.android.datatransport.c;
import com.google.android.datatransport.d;
import com.google.auto.value.AutoValue;
import com.google.auto.value.AutoValue.Builder;

@AutoValue
abstract class m
{
  public static a a()
  {
    return new c.b();
  }
  
  public abstract b b();
  
  abstract c<?> c();
  
  public byte[] d()
  {
    return (byte[])e().apply(c().b());
  }
  
  abstract d<?, byte[]> e();
  
  public abstract n f();
  
  public abstract String g();
  
  @AutoValue.Builder
  public static abstract class a
  {
    public abstract m a();
    
    abstract a b(b paramb);
    
    abstract a c(c<?> paramc);
    
    abstract a d(d<?, byte[]> paramd);
    
    public abstract a e(n paramn);
    
    public abstract a f(String paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\h\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */