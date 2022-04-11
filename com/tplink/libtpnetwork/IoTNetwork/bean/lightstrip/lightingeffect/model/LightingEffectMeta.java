package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model;

import java.util.List;

public class LightingEffectMeta
{
  private String alias;
  private String imageUrl;
  private List<String> tags;
  
  public static LightingEffectMetaBuilder builder()
  {
    return new LightingEffectMetaBuilder(null);
  }
  
  public String getAlias()
  {
    return this.alias;
  }
  
  public String getImageUrl()
  {
    return this.imageUrl;
  }
  
  public List<String> getTags()
  {
    return this.tags;
  }
  
  public void merge() {}
  
  public void setAlias(String paramString)
  {
    this.alias = paramString;
  }
  
  public void setImageUrl(String paramString)
  {
    this.imageUrl = paramString;
  }
  
  public void setTags(List<String> paramList)
  {
    this.tags = paramList;
  }
  
  public static final class LightingEffectMetaBuilder
  {
    private String alias;
    private String imageUrl;
    private List<String> tags;
    
    public LightingEffectMetaBuilder alias(String paramString)
    {
      this.alias = paramString;
      return this;
    }
    
    public LightingEffectMeta build()
    {
      LightingEffectMeta localLightingEffectMeta = new LightingEffectMeta();
      localLightingEffectMeta.setAlias(this.alias);
      localLightingEffectMeta.setTags(this.tags);
      localLightingEffectMeta.setImageUrl(this.imageUrl);
      return localLightingEffectMeta;
    }
    
    public LightingEffectMetaBuilder imageUrl(String paramString)
    {
      this.imageUrl = paramString;
      return this;
    }
    
    public LightingEffectMetaBuilder tags(List<String> paramList)
    {
      this.tags = paramList;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\lightstrip\lightingeffect\model\LightingEffectMeta.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */