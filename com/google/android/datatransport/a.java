package com.google.android.datatransport;

import androidx.annotation.Nullable;
import java.util.Objects;

final class a<T>
  extends c<T>
{
  private final Integer a;
  private final T b;
  private final Priority c;
  
  a(@Nullable Integer paramInteger, T paramT, Priority paramPriority)
  {
    this.a = paramInteger;
    Objects.requireNonNull(paramT, "Null payload");
    this.b = paramT;
    Objects.requireNonNull(paramPriority, "Null priority");
    this.c = paramPriority;
  }
  
  @Nullable
  public Integer a()
  {
    return this.a;
  }
  
  public T b()
  {
    return (T)this.b;
  }
  
  public Priority c()
  {
    return this.c;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof c))
    {
      paramObject = (c)paramObject;
      Integer localInteger = this.a;
      if ((localInteger == null ? ((c)paramObject).a() != null : !localInteger.equals(((c)paramObject).a())) || (!this.b.equals(((c)paramObject).b())) || (!this.c.equals(((c)paramObject).c()))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    Integer localInteger = this.a;
    int i;
    if (localInteger == null) {
      i = 0;
    } else {
      i = localInteger.hashCode();
    }
    return ((i ^ 0xF4243) * 1000003 ^ this.b.hashCode()) * 1000003 ^ this.c.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Event{code=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", payload=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", priority=");
    localStringBuilder.append(this.c);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */