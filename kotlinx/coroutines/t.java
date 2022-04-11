package kotlinx.coroutines;

final class t
{
  public final Object a;
  public final Object b;
  public final p1 c;
  
  public t(Object paramObject1, Object paramObject2, p1 paramp1)
  {
    this.a = paramObject1;
    this.b = paramObject2;
    this.c = paramp1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CompletedIdempotentResult[");
    localStringBuilder.append(this.b);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */