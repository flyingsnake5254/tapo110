package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes;

public class IntegerAttributeValue
  extends AbstractNumberAttributeValue<Integer>
{
  private Integer absolute;
  private IntegerAttributeLimits limits;
  private IntegerRange range;
  
  public IntegerAttributeValue() {}
  
  private IntegerAttributeValue(Builder paramBuilder)
  {
    setAbsolute(paramBuilder.absolute);
    setRange(paramBuilder.range);
    setLimits(paramBuilder.limits);
  }
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  public Integer getAbsolute()
  {
    return this.absolute;
  }
  
  public IntegerAttributeLimits getLimits()
  {
    return this.limits;
  }
  
  public IntegerRange getRange()
  {
    return this.range;
  }
  
  public void setAbsolute(Integer paramInteger)
  {
    this.absolute = paramInteger;
  }
  
  public void setLimits(AbstractNumberAttributeLimits<Integer> paramAbstractNumberAttributeLimits)
  {
    this.limits = ((IntegerAttributeLimits)paramAbstractNumberAttributeLimits);
  }
  
  public void setLimits(IntegerAttributeLimits paramIntegerAttributeLimits)
  {
    this.limits = paramIntegerAttributeLimits;
  }
  
  public void setRange(AbstractRange<Integer> paramAbstractRange)
  {
    this.range = ((IntegerRange)paramAbstractRange);
  }
  
  public void setRange(IntegerRange paramIntegerRange)
  {
    this.range = paramIntegerRange;
  }
  
  public static final class Builder
  {
    private Integer absolute;
    private IntegerAttributeLimits limits;
    private IntegerRange range;
    
    public Builder absolute(Integer paramInteger)
    {
      this.absolute = paramInteger;
      return this;
    }
    
    public IntegerAttributeValue build()
    {
      return new IntegerAttributeValue(this, null);
    }
    
    public Builder limits(IntegerAttributeLimits paramIntegerAttributeLimits)
    {
      this.limits = paramIntegerAttributeLimits;
      return this;
    }
    
    public Builder range(IntegerRange paramIntegerRange)
    {
      this.range = paramIntegerRange;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\lightstrip\lightingeffect\attributes\IntegerAttributeValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */