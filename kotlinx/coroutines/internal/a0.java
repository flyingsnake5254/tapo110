package kotlinx.coroutines.internal;

import kotlin.coroutines.f;

final class a0
{
  private Object[] a;
  private int b;
  private final f c;
  
  public a0(f paramf, int paramInt)
  {
    this.c = paramf;
    this.a = new Object[paramInt];
  }
  
  public final void a(Object paramObject)
  {
    Object[] arrayOfObject = this.a;
    int i = this.b;
    this.b = (i + 1);
    arrayOfObject[i] = paramObject;
  }
  
  public final f b()
  {
    return this.c;
  }
  
  public final void c()
  {
    this.b = 0;
  }
  
  public final Object d()
  {
    Object[] arrayOfObject = this.a;
    int i = this.b;
    this.b = (i + 1);
    return arrayOfObject[i];
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\internal\a0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */