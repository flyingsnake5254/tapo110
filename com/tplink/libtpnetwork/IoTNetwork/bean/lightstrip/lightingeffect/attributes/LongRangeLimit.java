package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes;

public class LongRangeLimit
  extends AbstractRangeLimit<Long>
{
  private LongRange max;
  private LongRange min;
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  public LongRange getMax()
  {
    return this.max;
  }
  
  public LongRange getMin()
  {
    return this.min;
  }
  
  public void setMax(AbstractRange<Long> paramAbstractRange)
  {
    this.max = ((LongRange)paramAbstractRange);
  }
  
  public void setMax(LongRange paramLongRange)
  {
    this.max = paramLongRange;
  }
  
  public void setMin(AbstractRange<Long> paramAbstractRange)
  {
    this.min = ((LongRange)paramAbstractRange);
  }
  
  public void setMin(LongRange paramLongRange)
  {
    this.min = paramLongRange;
  }
  
  public static final class Builder
  {
    private LongRange max;
    private LongRange min;
    
    public LongRangeLimit build()
    {
      LongRangeLimit localLongRangeLimit = new LongRangeLimit();
      localLongRangeLimit.setMax(this.max);
      localLongRangeLimit.setMin(this.min);
      return localLongRangeLimit;
    }
    
    public Builder max(LongRange paramLongRange)
    {
      this.max = paramLongRange;
      return this;
    }
    
    public Builder min(LongRange paramLongRange)
    {
      this.min = paramLongRange;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\lightstrip\lightingeffect\attributes\LongRangeLimit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */