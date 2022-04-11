package com.google.android.datatransport.cct.internal;

import androidx.annotation.Nullable;

final class e
  extends ClientInfo
{
  private final ClientInfo.ClientType a;
  private final a b;
  
  private e(@Nullable ClientInfo.ClientType paramClientType, @Nullable a parama)
  {
    this.a = paramClientType;
    this.b = parama;
  }
  
  @Nullable
  public a b()
  {
    return this.b;
  }
  
  @Nullable
  public ClientInfo.ClientType c()
  {
    return this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof ClientInfo))
    {
      paramObject = (ClientInfo)paramObject;
      Object localObject = this.a;
      if (localObject == null ? ((ClientInfo)paramObject).c() == null : ((Enum)localObject).equals(((ClientInfo)paramObject).c()))
      {
        localObject = this.b;
        if (localObject == null ? ((ClientInfo)paramObject).b() == null : localObject.equals(((ClientInfo)paramObject).b())) {}
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
    Object localObject = this.a;
    int i = 0;
    int j;
    if (localObject == null) {
      j = 0;
    } else {
      j = ((Enum)localObject).hashCode();
    }
    localObject = this.b;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return (j ^ 0xF4243) * 1000003 ^ i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ClientInfo{clientType=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", androidClientInfo=");
    localStringBuilder.append(this.b);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class b
    extends ClientInfo.a
  {
    private ClientInfo.ClientType a;
    private a b;
    
    public ClientInfo a()
    {
      return new e(this.a, this.b, null);
    }
    
    public ClientInfo.a b(@Nullable a parama)
    {
      this.b = parama;
      return this;
    }
    
    public ClientInfo.a c(@Nullable ClientInfo.ClientType paramClientType)
    {
      this.a = paramClientType;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\cct\internal\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */