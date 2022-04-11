package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model;

public class Segment
{
  private Integer end;
  private LightingEffectSettings initialState;
  private Integer start;
  
  public static SegmentBuilder builder()
  {
    return new SegmentBuilder(null);
  }
  
  public Integer getEnd()
  {
    return this.end;
  }
  
  public LightingEffectSettings getInitialState()
  {
    return this.initialState;
  }
  
  public Integer getStart()
  {
    return this.start;
  }
  
  public void setEnd(Integer paramInteger)
  {
    this.end = paramInteger;
  }
  
  public void setInitialState(LightingEffectSettings paramLightingEffectSettings)
  {
    this.initialState = paramLightingEffectSettings;
  }
  
  public void setStart(Integer paramInteger)
  {
    this.start = paramInteger;
  }
  
  public static final class SegmentBuilder
  {
    private Integer end;
    private LightingEffectSettings initialState;
    private Integer start;
    
    public Segment build()
    {
      Segment localSegment = new Segment();
      localSegment.setStart(this.start);
      localSegment.setEnd(this.end);
      localSegment.setInitialState(this.initialState);
      return localSegment;
    }
    
    public SegmentBuilder end(Integer paramInteger)
    {
      this.end = paramInteger;
      return this;
    }
    
    public SegmentBuilder initialState(LightingEffectSettings paramLightingEffectSettings)
    {
      this.initialState = paramLightingEffectSettings;
      return this;
    }
    
    public SegmentBuilder start(Integer paramInteger)
    {
      this.start = paramInteger;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\lightstrip\lightingeffect\model\Segment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */