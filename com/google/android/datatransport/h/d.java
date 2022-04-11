package com.google.android.datatransport.h;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.datatransport.Priority;
import java.util.Arrays;
import java.util.Objects;

final class d
  extends n
{
  private final String a;
  private final byte[] b;
  private final Priority c;
  
  private d(String paramString, @Nullable byte[] paramArrayOfByte, Priority paramPriority)
  {
    this.a = paramString;
    this.b = paramArrayOfByte;
    this.c = paramPriority;
  }
  
  public String b()
  {
    return this.a;
  }
  
  @Nullable
  public byte[] c()
  {
    return this.b;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public Priority d()
  {
    return this.c;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof n))
    {
      n localn = (n)paramObject;
      if (this.a.equals(localn.b()))
      {
        byte[] arrayOfByte = this.b;
        if ((localn instanceof d)) {
          paramObject = ((d)localn).b;
        } else {
          paramObject = localn.c();
        }
        if ((Arrays.equals(arrayOfByte, (byte[])paramObject)) && (this.c.equals(localn.d()))) {}
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
    return ((this.a.hashCode() ^ 0xF4243) * 1000003 ^ Arrays.hashCode(this.b)) * 1000003 ^ this.c.hashCode();
  }
  
  static final class b
    extends n.a
  {
    private String a;
    private byte[] b;
    private Priority c;
    
    public n a()
    {
      Object localObject1 = this.a;
      Object localObject2 = "";
      if (localObject1 == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(" backendName");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.c == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" priority");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      if (((String)localObject1).isEmpty()) {
        return new d(this.a, this.b, this.c, null);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Missing required properties:");
      ((StringBuilder)localObject2).append((String)localObject1);
      throw new IllegalStateException(((StringBuilder)localObject2).toString());
    }
    
    public n.a b(String paramString)
    {
      Objects.requireNonNull(paramString, "Null backendName");
      this.a = paramString;
      return this;
    }
    
    public n.a c(@Nullable byte[] paramArrayOfByte)
    {
      this.b = paramArrayOfByte;
      return this;
    }
    
    public n.a d(Priority paramPriority)
    {
      Objects.requireNonNull(paramPriority, "Null priority");
      this.c = paramPriority;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\h\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */