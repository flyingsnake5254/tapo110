package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes;

public class DoubleAttributeValue
  extends AbstractNumberAttributeValue<Double>
{
  private Double absolute;
  private DoubleAttributeLimits limits;
  private DoubleRange range;
  
  public DoubleAttributeValue() {}
  
  private DoubleAttributeValue(Builder paramBuilder)
  {
    setAbsolute(paramBuilder.absolute);
    setRange(paramBuilder.range);
    setLimits(paramBuilder.limits);
  }
  
  public Double getAbsolute()
  {
    return this.absolute;
  }
  
  public DoubleAttributeLimits getLimits()
  {
    return this.limits;
  }
  
  public DoubleRange getRange()
  {
    return this.range;
  }
  
  public void setAbsolute(Double paramDouble)
  {
    this.absolute = paramDouble;
  }
  
  public void setLimits(AbstractNumberAttributeLimits<Double> paramAbstractNumberAttributeLimits)
  {
    this.limits = ((DoubleAttributeLimits)paramAbstractNumberAttributeLimits);
  }
  
  public void setLimits(DoubleAttributeLimits paramDoubleAttributeLimits)
  {
    this.limits = paramDoubleAttributeLimits;
  }
  
  public void setRange(AbstractRange<Double> paramAbstractRange)
  {
    this.range = ((DoubleRange)paramAbstractRange);
  }
  
  public void setRange(DoubleRange paramDoubleRange)
  {
    this.range = paramDoubleRange;
  }
  
  public static final class Builder
  {
    private Double absolute;
    private DoubleAttributeLimits limits;
    private DoubleRange range;
    
    public Builder absolute(Double paramDouble)
    {
      this.absolute = paramDouble;
      return this;
    }
    
    public DoubleAttributeValue build()
    {
      return new DoubleAttributeValue(this, null);
    }
    
    public Builder limits(DoubleAttributeLimits paramDoubleAttributeLimits)
    {
      this.limits = paramDoubleAttributeLimits;
      return this;
    }
    
    public Builder range(DoubleRange paramDoubleRange)
    {
      this.range = paramDoubleRange;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\lightstrip\lightingeffect\attributes\DoubleAttributeValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */