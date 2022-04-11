package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes;

public class IntegerRange
  extends AbstractRange<Integer>
{
  private Integer from;
  private Integer to;
  
  public IntegerRange() {}
  
  private IntegerRange(Builder paramBuilder)
  {
    setFrom(paramBuilder.from);
    setTo(paramBuilder.to);
  }
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  public Integer getFrom()
  {
    return this.from;
  }
  
  public Integer getTo()
  {
    return this.to;
  }
  
  public void setFrom(Integer paramInteger)
  {
    this.from = paramInteger;
  }
  
  public void setTo(Integer paramInteger)
  {
    this.to = paramInteger;
  }
  
  public static final class Builder
  {
    private Integer from;
    private Integer to;
    
    public IntegerRange build()
    {
      return new IntegerRange(this, null);
    }
    
    public Builder from(Integer paramInteger)
    {
      this.from = paramInteger;
      return this;
    }
    
    public Builder to(Integer paramInteger)
    {
      this.to = paramInteger;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\lightstrip\lightingeffect\attributes\IntegerRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */