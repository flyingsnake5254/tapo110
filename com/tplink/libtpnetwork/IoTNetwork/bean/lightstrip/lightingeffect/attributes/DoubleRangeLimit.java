package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes;

public class DoubleRangeLimit
  extends AbstractRangeLimit<Double>
{
  private DoubleRange max;
  private DoubleRange min;
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  public DoubleRange getMax()
  {
    return this.max;
  }
  
  public DoubleRange getMin()
  {
    return this.min;
  }
  
  public void setMax(AbstractRange<Double> paramAbstractRange)
  {
    this.max = ((DoubleRange)paramAbstractRange);
  }
  
  public void setMax(DoubleRange paramDoubleRange)
  {
    this.max = paramDoubleRange;
  }
  
  public void setMin(AbstractRange<Double> paramAbstractRange)
  {
    this.min = ((DoubleRange)paramAbstractRange);
  }
  
  public void setMin(DoubleRange paramDoubleRange)
  {
    this.min = paramDoubleRange;
  }
  
  public static final class Builder
  {
    private DoubleRange max;
    private DoubleRange min;
    
    public DoubleRangeLimit build()
    {
      DoubleRangeLimit localDoubleRangeLimit = new DoubleRangeLimit();
      localDoubleRangeLimit.setMax(this.max);
      localDoubleRangeLimit.setMin(this.min);
      return localDoubleRangeLimit;
    }
    
    public Builder max(DoubleRange paramDoubleRange)
    {
      this.max = paramDoubleRange;
      return this;
    }
    
    public Builder min(DoubleRange paramDoubleRange)
    {
      this.min = paramDoubleRange;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\lightstrip\lightingeffect\attributes\DoubleRangeLimit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */