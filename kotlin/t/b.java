package kotlin.t;

public abstract class b<V>
  implements d<Object, V>
{
  private V a;
  
  public b(V paramV)
  {
    this.a = paramV;
  }
  
  public void a(Object paramObject, kotlin.reflect.j<?> paramj, V paramV)
  {
    kotlin.jvm.internal.j.e(paramj, "property");
    paramObject = this.a;
    if (!d(paramj, paramObject, paramV)) {
      return;
    }
    this.a = paramV;
    c(paramj, paramObject, paramV);
  }
  
  public V b(Object paramObject, kotlin.reflect.j<?> paramj)
  {
    kotlin.jvm.internal.j.e(paramj, "property");
    return (V)this.a;
  }
  
  protected abstract void c(kotlin.reflect.j<?> paramj, V paramV1, V paramV2);
  
  protected boolean d(kotlin.reflect.j<?> paramj, V paramV1, V paramV2)
  {
    kotlin.jvm.internal.j.e(paramj, "property");
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\t\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */