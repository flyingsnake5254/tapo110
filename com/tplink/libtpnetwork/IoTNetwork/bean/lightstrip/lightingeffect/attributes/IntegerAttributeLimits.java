package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes;

public class IntegerAttributeLimits
  extends AbstractNumberAttributeLimits<Integer>
{
  private IntegerRange absolute;
  private IntegerRangeLimit range;
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  public IntegerRange getAbsolute()
  {
    return this.absolute;
  }
  
  public IntegerRangeLimit getRange()
  {
    return this.range;
  }
  
  public void setAbsolute(AbstractRange<Integer> paramAbstractRange)
  {
    this.absolute = ((IntegerRange)paramAbstractRange);
  }
  
  public void setAbsolute(IntegerRange paramIntegerRange)
  {
    this.absolute = paramIntegerRange;
  }
  
  public void setRange(AbstractRangeLimit<Integer> paramAbstractRangeLimit)
  {
    this.range = ((IntegerRangeLimit)paramAbstractRangeLimit);
  }
  
  public void setRange(IntegerRangeLimit paramIntegerRangeLimit)
  {
    this.range = paramIntegerRangeLimit;
  }
  
  public static final class Builder
  {
    private IntegerRange absolute;
    private IntegerRangeLimit range;
    
    public Builder absolute(IntegerRange paramIntegerRange)
    {
      this.absolute = paramIntegerRange;
      return this;
    }
    
    public IntegerAttributeLimits build()
    {
      IntegerAttributeLimits localIntegerAttributeLimits = new IntegerAttributeLimits();
      localIntegerAttributeLimits.setAbsolute(this.absolute);
      localIntegerAttributeLimits.setRange(this.range);
      return localIntegerAttributeLimits;
    }
    
    public Builder range(IntegerRangeLimit paramIntegerRangeLimit)
    {
      this.range = paramIntegerRangeLimit;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\lightstrip\lightingeffect\attributes\IntegerAttributeLimits.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */