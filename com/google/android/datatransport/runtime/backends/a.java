package com.google.android.datatransport.runtime.backends;

import androidx.annotation.Nullable;
import com.google.android.datatransport.h.i;
import java.util.Arrays;
import java.util.Objects;

final class a
  extends f
{
  private final Iterable<i> a;
  private final byte[] b;
  
  private a(Iterable<i> paramIterable, @Nullable byte[] paramArrayOfByte)
  {
    this.a = paramIterable;
    this.b = paramArrayOfByte;
  }
  
  public Iterable<i> b()
  {
    return this.a;
  }
  
  @Nullable
  public byte[] c()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof f))
    {
      paramObject = (f)paramObject;
      if (this.a.equals(((f)paramObject).b()))
      {
        byte[] arrayOfByte = this.b;
        if ((paramObject instanceof a)) {
          paramObject = ((a)paramObject).b;
        } else {
          paramObject = ((f)paramObject).c();
        }
        if (Arrays.equals(arrayOfByte, (byte[])paramObject)) {}
      }
      else
      {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    return (this.a.hashCode() ^ 0xF4243) * 1000003 ^ Arrays.hashCode(this.b);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BackendRequest{events=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", extras=");
    localStringBuilder.append(Arrays.toString(this.b));
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class b
    extends f.a
  {
    private Iterable<i> a;
    private byte[] b;
    
    public f a()
    {
      Object localObject1 = this.a;
      Object localObject2 = "";
      if (localObject1 == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(" events");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      if (((String)localObject2).isEmpty()) {
        return new a(this.a, this.b, null);
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Missing required properties:");
      ((StringBuilder)localObject1).append((String)localObject2);
      throw new IllegalStateException(((StringBuilder)localObject1).toString());
    }
    
    public f.a b(Iterable<i> paramIterable)
    {
      Objects.requireNonNull(paramIterable, "Null events");
      this.a = paramIterable;
      return this;
    }
    
    public f.a c(@Nullable byte[] paramArrayOfByte)
    {
      this.b = paramArrayOfByte;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\runtime\backends\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */