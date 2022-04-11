package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes;

public class LongAttributeLimits
  extends AbstractNumberAttributeLimits<Long>
{
  private LongRange absolute;
  private LongRangeLimit range;
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  public LongRange getAbsolute()
  {
    return this.absolute;
  }
  
  public LongRangeLimit getRange()
  {
    return this.range;
  }
  
  public void setAbsolute(AbstractRange<Long> paramAbstractRange)
  {
    this.absolute = ((LongRange)paramAbstractRange);
  }
  
  public void setAbsolute(LongRange paramLongRange)
  {
    this.absolute = paramLongRange;
  }
  
  public void setRange(AbstractRangeLimit<Long> paramAbstractRangeLimit)
  {
    this.range = ((LongRangeLimit)paramAbstractRangeLimit);
  }
  
  public void setRange(LongRangeLimit paramLongRangeLimit)
  {
    this.range = paramLongRangeLimit;
  }
  
  public static final class Builder
  {
    private LongRange absolute;
    private LongRangeLimit range;
    
    public Builder absolute(LongRange paramLongRange)
    {
      this.absolute = paramLongRange;
      return this;
    }
    
    public LongAttributeLimits build()
    {
      LongAttributeLimits localLongAttributeLimits = new LongAttributeLimits();
      localLongAttributeLimits.setAbsolute(this.absolute);
      localLongAttributeLimits.setRange(this.range);
      return localLongAttributeLimits;
    }
    
    public Builder range(LongRangeLimit paramLongRangeLimit)
    {
      this.range = paramLongRangeLimit;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\lightstrip\lightingeffect\attributes\LongAttributeLimits.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */