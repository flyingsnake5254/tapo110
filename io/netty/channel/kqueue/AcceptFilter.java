package io.netty.channel.kqueue;

import io.netty.util.internal.ObjectUtil;

public final class AcceptFilter
{
  static final AcceptFilter PLATFORM_UNSUPPORTED = new AcceptFilter("", "");
  private final String filterArgs;
  private final String filterName;
  
  public AcceptFilter(String paramString1, String paramString2)
  {
    this.filterName = ((String)ObjectUtil.checkNotNull(paramString1, "filterName"));
    this.filterArgs = ((String)ObjectUtil.checkNotNull(paramString2, "filterArgs"));
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof AcceptFilter)) {
      return false;
    }
    paramObject = (AcceptFilter)paramObject;
    if ((!this.filterName.equals(((AcceptFilter)paramObject).filterName)) || (!this.filterArgs.equals(((AcceptFilter)paramObject).filterArgs))) {
      bool = false;
    }
    return bool;
  }
  
  public String filterArgs()
  {
    return this.filterArgs;
  }
  
  public String filterName()
  {
    return this.filterName;
  }
  
  public int hashCode()
  {
    return (this.filterName.hashCode() + 31) * 31 + this.filterArgs.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.filterName);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.filterArgs);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\kqueue\AcceptFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */