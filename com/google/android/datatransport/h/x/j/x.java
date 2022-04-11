package com.google.android.datatransport.h.x.j;

import com.google.android.datatransport.h.i;
import com.google.android.datatransport.h.n;
import java.util.Objects;

final class x
  extends e0
{
  private final long a;
  private final n b;
  private final i c;
  
  x(long paramLong, n paramn, i parami)
  {
    this.a = paramLong;
    Objects.requireNonNull(paramn, "Null transportContext");
    this.b = paramn;
    Objects.requireNonNull(parami, "Null event");
    this.c = parami;
  }
  
  public i b()
  {
    return this.c;
  }
  
  public long c()
  {
    return this.a;
  }
  
  public n d()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof e0))
    {
      paramObject = (e0)paramObject;
      if ((this.a != ((e0)paramObject).c()) || (!this.b.equals(((e0)paramObject).d())) || (!this.c.equals(((e0)paramObject).b()))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    long l = this.a;
    int i = (int)(l ^ l >>> 32);
    int j = this.b.hashCode();
    return this.c.hashCode() ^ ((i ^ 0xF4243) * 1000003 ^ j) * 1000003;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PersistedEvent{id=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", transportContext=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", event=");
    localStringBuilder.append(this.c);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\h\x\j\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */