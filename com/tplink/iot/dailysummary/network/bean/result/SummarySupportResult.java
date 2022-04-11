package com.tplink.iot.dailysummary.network.bean.result;

public class SummarySupportResult
{
  private Boolean support;
  private Boolean upgrade;
  
  public Boolean getSupport()
  {
    return this.support;
  }
  
  public Boolean getUpgrade()
  {
    return this.upgrade;
  }
  
  public void setSupport(Boolean paramBoolean)
  {
    this.support = paramBoolean;
  }
  
  public void setUpgrade(Boolean paramBoolean)
  {
    this.upgrade = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SummarySupportResult{isSupport=");
    localStringBuilder.append(this.support);
    localStringBuilder.append(", upgrade=");
    localStringBuilder.append(this.upgrade);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\dailysummary\network\bean\result\SummarySupportResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */