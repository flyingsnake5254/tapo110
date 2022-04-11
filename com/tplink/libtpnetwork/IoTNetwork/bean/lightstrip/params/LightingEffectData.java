package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params;

import androidx.annotation.Nullable;
import b.d.w.c.a;
import com.tplink.libtpnetwork.Utils.i;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class LightingEffectData
  implements Serializable
{
  public Integer bAdjusted;
  public Integer[][] backgrounds;
  public Integer brightness;
  public Integer[] brightness_range;
  public Integer custom;
  public Integer direction;
  public Integer[][] display_colors;
  public Integer duration;
  public Integer enable;
  public Integer expansion_strategy;
  public Integer fadeoff;
  public Integer[] hue_range;
  public String id;
  public Integer[][] init_states;
  public String name;
  public Integer random_seed;
  public Integer repeat_times;
  public Integer[] saturation_range;
  public Integer segment_length;
  public Integer[] segments;
  public Integer[][] sequence;
  public Integer spread;
  public Integer transition;
  public Integer[] transition_range;
  public String type;
  
  @Nullable
  public static LightingEffectData resolveObject(@Nullable Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    try
    {
      paramObject = (LightingEffectData)i.b(i.f(paramObject), LightingEffectData.class);
      return (LightingEffectData)paramObject;
    }
    catch (Exception localException)
    {
      paramObject = new StringBuilder();
      ((StringBuilder)paramObject).append("lightingEffect to Json Error: ");
      ((StringBuilder)paramObject).append(localException);
      a.n("LightStrip", ((StringBuilder)paramObject).toString());
    }
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (LightingEffectData)paramObject;
      int i;
      if ((Objects.equals(this.id, ((LightingEffectData)paramObject).id)) && (Objects.equals(this.type, ((LightingEffectData)paramObject).type)) && (Objects.equals(this.name, ((LightingEffectData)paramObject).name)) && (Objects.equals(this.custom, ((LightingEffectData)paramObject).custom)) && (Objects.equals(this.brightness, ((LightingEffectData)paramObject).brightness))) {
        i = 1;
      } else {
        i = 0;
      }
      if ("static".equals(this.type))
      {
        if ((i == 0) || (!Arrays.deepEquals(this.sequence, ((LightingEffectData)paramObject).sequence))) {
          bool2 = false;
        }
        return bool2;
      }
      if ((i != 0) && (Arrays.deepEquals(this.display_colors, ((LightingEffectData)paramObject).display_colors))) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
      return bool2;
    }
    return false;
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { this.id, this.type, this.name, this.custom, this.brightness }) * 31 + Arrays.hashCode(this.display_colors);
  }
  
  public boolean isGoogleLightingEffect()
  {
    String str = this.id;
    if (str != null) {
      return str.startsWith("Google_Lighting_Effects");
    }
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\lightstrip\params\LightingEffectData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */