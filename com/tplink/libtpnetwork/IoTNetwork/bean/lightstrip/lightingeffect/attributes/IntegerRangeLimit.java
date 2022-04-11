package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes;

public class IntegerRangeLimit
  extends AbstractRangeLimit<Integer>
{
  private IntegerRange max;
  private IntegerRange min;
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  public IntegerRange getMax()
  {
    return this.max;
  }
  
  public IntegerRange getMin()
  {
    return this.min;
  }
  
  public void setMax(AbstractRange<Integer> paramAbstractRange)
  {
    this.max = ((IntegerRange)paramAbstractRange);
  }
  
  public void setMax(IntegerRange paramIntegerRange)
  {
    this.max = paramIntegerRange;
  }
  
  public void setMin(AbstractRange<Integer> paramAbstractRange)
  {
    this.min = ((IntegerRange)paramAbstractRange);
  }
  
  public void setMin(IntegerRange paramIntegerRange)
  {
    this.min = paramIntegerRange;
  }
  
  public static final class Builder
  {
    private IntegerRange max;
    private IntegerRange min;
    
    public IntegerRangeLimit build()
    {
      IntegerRangeLimit localIntegerRangeLimit = new IntegerRangeLimit();
      localIntegerRangeLimit.setMax(this.max);
      localIntegerRangeLimit.setMin(this.min);
      return localIntegerRangeLimit;
    }
    
    public Builder max(IntegerRange paramIntegerRange)
    {
      this.max = paramIntegerRange;
      return this;
    }
    
    public Builder min(IntegerRange paramIntegerRange)
    {
      this.min = paramIntegerRange;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\lightstrip\lightingeffect\attributes\IntegerRangeLimit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */