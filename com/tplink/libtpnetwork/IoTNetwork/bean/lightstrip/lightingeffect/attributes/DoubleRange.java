package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes;

public class DoubleRange
  extends AbstractRange<Double>
{
  private Double from;
  private Double to;
  
  public DoubleRange() {}
  
  private DoubleRange(Builder paramBuilder)
  {
    setFrom(paramBuilder.from);
    setTo(paramBuilder.to);
  }
  
  public Double getFrom()
  {
    return this.from;
  }
  
  public Double getTo()
  {
    return this.to;
  }
  
  public void setFrom(Double paramDouble)
  {
    this.from = paramDouble;
  }
  
  public void setTo(Double paramDouble)
  {
    this.to = paramDouble;
  }
  
  public static final class Builder
  {
    private Double from;
    private Double to;
    
    public DoubleRange build()
    {
      return new DoubleRange(this, null);
    }
    
    public Builder from(Double paramDouble)
    {
      this.from = paramDouble;
      return this;
    }
    
    public Builder to(Double paramDouble)
    {
      this.to = paramDouble;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\lightstrip\lightingeffect\attributes\DoubleRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */