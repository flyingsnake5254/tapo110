package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model;

public class PredefinedEffectTemplate
{
  private Long createdOn;
  private String predefinedEffectId;
  private String template;
  private Long updatedOn;
  
  public static PredefinedEffectTemplateBuilder builder()
  {
    return new PredefinedEffectTemplateBuilder(null);
  }
  
  public Long getCreatedOn()
  {
    return this.createdOn;
  }
  
  public String getPredefinedEffectId()
  {
    return this.predefinedEffectId;
  }
  
  public String getTemplate()
  {
    return this.template;
  }
  
  public Long getUpdatedOn()
  {
    return this.updatedOn;
  }
  
  public void setCreatedOn(Long paramLong)
  {
    this.createdOn = paramLong;
  }
  
  public void setPredefinedEffectId(String paramString)
  {
    this.predefinedEffectId = paramString;
  }
  
  public void setTemplate(String paramString)
  {
    this.template = paramString;
  }
  
  public void setUpdatedOn(Long paramLong)
  {
    this.updatedOn = paramLong;
  }
  
  public static final class PredefinedEffectTemplateBuilder
  {
    private Long createdOn;
    private String predefinedEffectId;
    private String template;
    private Long updatedOn;
    
    public PredefinedEffectTemplate build()
    {
      PredefinedEffectTemplate localPredefinedEffectTemplate = new PredefinedEffectTemplate();
      localPredefinedEffectTemplate.setPredefinedEffectId(this.predefinedEffectId);
      localPredefinedEffectTemplate.setTemplate(this.template);
      localPredefinedEffectTemplate.setCreatedOn(this.createdOn);
      localPredefinedEffectTemplate.setUpdatedOn(this.updatedOn);
      return localPredefinedEffectTemplate;
    }
    
    public PredefinedEffectTemplateBuilder createdOn(Long paramLong)
    {
      this.createdOn = paramLong;
      return this;
    }
    
    public PredefinedEffectTemplateBuilder predefinedEffectId(String paramString)
    {
      this.predefinedEffectId = paramString;
      return this;
    }
    
    public PredefinedEffectTemplateBuilder template(String paramString)
    {
      this.template = paramString;
      return this;
    }
    
    public PredefinedEffectTemplateBuilder updatedOn(Long paramLong)
    {
      this.updatedOn = paramLong;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\lightstrip\lightingeffect\model\PredefinedEffectTemplate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */