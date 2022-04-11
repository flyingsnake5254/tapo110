package com.google.android.datatransport.cct.internal;

import androidx.annotation.Nullable;

final class i
  extends NetworkConnectionInfo
{
  private final NetworkConnectionInfo.NetworkType a;
  private final NetworkConnectionInfo.MobileSubtype b;
  
  private i(@Nullable NetworkConnectionInfo.NetworkType paramNetworkType, @Nullable NetworkConnectionInfo.MobileSubtype paramMobileSubtype)
  {
    this.a = paramNetworkType;
    this.b = paramMobileSubtype;
  }
  
  @Nullable
  public NetworkConnectionInfo.MobileSubtype b()
  {
    return this.b;
  }
  
  @Nullable
  public NetworkConnectionInfo.NetworkType c()
  {
    return this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof NetworkConnectionInfo))
    {
      paramObject = (NetworkConnectionInfo)paramObject;
      Object localObject = this.a;
      if (localObject == null ? ((NetworkConnectionInfo)paramObject).c() == null : ((Enum)localObject).equals(((NetworkConnectionInfo)paramObject).c()))
      {
        localObject = this.b;
        if (localObject == null ? ((NetworkConnectionInfo)paramObject).b() == null : ((Enum)localObject).equals(((NetworkConnectionInfo)paramObject).b())) {}
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
      i = ((Enum)localObject).hashCode();
    }
    return (j ^ 0xF4243) * 1000003 ^ i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NetworkConnectionInfo{networkType=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mobileSubtype=");
    localStringBuilder.append(this.b);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class b
    extends NetworkConnectionInfo.a
  {
    private NetworkConnectionInfo.NetworkType a;
    private NetworkConnectionInfo.MobileSubtype b;
    
    public NetworkConnectionInfo a()
    {
      return new i(this.a, this.b, null);
    }
    
    public NetworkConnectionInfo.a b(@Nullable NetworkConnectionInfo.MobileSubtype paramMobileSubtype)
    {
      this.b = paramMobileSubtype;
      return this;
    }
    
    public NetworkConnectionInfo.a c(@Nullable NetworkConnectionInfo.NetworkType paramNetworkType)
    {
      this.a = paramNetworkType;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\cct\internal\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */