package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes;

public class LongAttributeValue
  extends AbstractNumberAttributeValue<Long>
{
  private Long absolute;
  private LongAttributeLimits limits;
  private LongRange range;
  
  public LongAttributeValue() {}
  
  private LongAttributeValue(Builder paramBuilder)
  {
    setAbsolute(paramBuilder.absolute);
    setRange(paramBuilder.range);
    setLimits(paramBuilder.limits);
  }
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  public Long getAbsolute()
  {
    return this.absolute;
  }
  
  public LongAttributeLimits getLimits()
  {
    return this.limits;
  }
  
  public LongRange getRange()
  {
    return this.range;
  }
  
  public void setAbsolute(Long paramLong)
  {
    this.absolute = paramLong;
  }
  
  public void setLimits(AbstractNumberAttributeLimits<Long> paramAbstractNumberAttributeLimits)
  {
    this.limits = ((LongAttributeLimits)paramAbstractNumberAttributeLimits);
  }
  
  public void setLimits(LongAttributeLimits paramLongAttributeLimits)
  {
    this.limits = paramLongAttributeLimits;
  }
  
  public void setRange(AbstractRange<Long> paramAbstractRange)
  {
    this.range = ((LongRange)paramAbstractRange);
  }
  
  public void setRange(LongRange paramLongRange)
  {
    this.range = paramLongRange;
  }
  
  public static final class Builder
  {
    private Long absolute;
    private LongAttributeLimits limits;
    private LongRange range;
    
    public Builder absolute(Long paramLong)
    {
      this.absolute = paramLong;
      return this;
    }
    
    public LongAttributeValue build()
    {
      return new LongAttributeValue(this, null);
    }
    
    public Builder limits(LongAttributeLimits paramLongAttributeLimits)
    {
      this.limits = paramLongAttributeLimits;
      return this;
    }
    
    public Builder range(LongRange paramLongRange)
    {
      this.range = paramLongRange;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\lightstrip\lightingeffect\attributes\LongAttributeValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */