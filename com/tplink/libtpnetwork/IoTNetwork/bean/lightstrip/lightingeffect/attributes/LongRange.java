package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes;

public class LongRange
  extends AbstractRange<Long>
{
  private Long from;
  private Long to;
  
  public LongRange() {}
  
  private LongRange(Builder paramBuilder)
  {
    setFrom(paramBuilder.from);
    setTo(paramBuilder.to);
  }
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  public Long getFrom()
  {
    return this.from;
  }
  
  public Long getTo()
  {
    return this.to;
  }
  
  public void setFrom(Long paramLong)
  {
    this.from = paramLong;
  }
  
  public void setTo(Long paramLong)
  {
    this.to = paramLong;
  }
  
  public static final class Builder
  {
    private Long from;
    private Long to;
    
    public LongRange build()
    {
      return new LongRange(this, null);
    }
    
    public Builder from(Long paramLong)
    {
      this.from = paramLong;
      return this;
    }
    
    public Builder to(Long paramLong)
    {
      this.to = paramLong;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\lightstrip\lightingeffect\attributes\LongRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */