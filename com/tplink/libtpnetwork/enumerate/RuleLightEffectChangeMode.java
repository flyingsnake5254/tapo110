package com.tplink.libtpnetwork.enumerate;

public enum RuleLightEffectChangeMode
{
  private String name;
  
  static
  {
    RuleLightEffectChangeMode localRuleLightEffectChangeMode1 = new RuleLightEffectChangeMode("MODE_DIRECT", 0, "direct");
    MODE_DIRECT = localRuleLightEffectChangeMode1;
    RuleLightEffectChangeMode localRuleLightEffectChangeMode2 = new RuleLightEffectChangeMode("MODE_BLN", 1, "bln");
    MODE_BLN = localRuleLightEffectChangeMode2;
    $VALUES = new RuleLightEffectChangeMode[] { localRuleLightEffectChangeMode1, localRuleLightEffectChangeMode2 };
  }
  
  private RuleLightEffectChangeMode(String paramString)
  {
    this.name = paramString;
  }
  
  public static RuleLightEffectChangeMode fromString(String paramString)
  {
    if ("bln".equals(paramString)) {
      return MODE_BLN;
    }
    return MODE_DIRECT;
  }
  
  public String getName()
  {
    return this.name;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\enumerate\RuleLightEffectChangeMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */