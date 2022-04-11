package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes;

public class DoubleAttributeLimits
  extends AbstractNumberAttributeLimits<Double>
{
  private DoubleRange absolute;
  private DoubleRangeLimit range;
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  public DoubleRange getAbsolute()
  {
    return this.absolute;
  }
  
  public DoubleRangeLimit getRange()
  {
    return this.range;
  }
  
  public void setAbsolute(AbstractRange<Double> paramAbstractRange)
  {
    this.absolute = ((DoubleRange)paramAbstractRange);
  }
  
  public void setAbsolute(DoubleRange paramDoubleRange)
  {
    this.absolute = paramDoubleRange;
  }
  
  public void setRange(AbstractRangeLimit<Double> paramAbstractRangeLimit)
  {
    this.range = ((DoubleRangeLimit)paramAbstractRangeLimit);
  }
  
  public void setRange(DoubleRangeLimit paramDoubleRangeLimit)
  {
    this.range = paramDoubleRangeLimit;
  }
  
  public static final class Builder
  {
    private DoubleRange absolute;
    private DoubleRangeLimit range;
    
    public Builder absolute(DoubleRange paramDoubleRange)
    {
      this.absolute = paramDoubleRange;
      return this;
    }
    
    public DoubleAttributeLimits build()
    {
      DoubleAttributeLimits localDoubleAttributeLimits = new DoubleAttributeLimits();
      localDoubleAttributeLimits.setAbsolute(this.absolute);
      localDoubleAttributeLimits.setRange(this.range);
      return localDoubleAttributeLimits;
    }
    
    public Builder range(DoubleRangeLimit paramDoubleRangeLimit)
    {
      this.range = paramDoubleRangeLimit;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\lightstrip\lightingeffect\attributes\DoubleAttributeLimits.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */