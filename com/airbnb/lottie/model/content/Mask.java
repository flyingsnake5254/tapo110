package com.airbnb.lottie.model.content;

import com.airbnb.lottie.model.i.d;
import com.airbnb.lottie.model.i.h;

public class Mask
{
  private final MaskMode a;
  private final h b;
  private final d c;
  private final boolean d;
  
  public Mask(MaskMode paramMaskMode, h paramh, d paramd, boolean paramBoolean)
  {
    this.a = paramMaskMode;
    this.b = paramh;
    this.c = paramd;
    this.d = paramBoolean;
  }
  
  public MaskMode a()
  {
    return this.a;
  }
  
  public h b()
  {
    return this.b;
  }
  
  public d c()
  {
    return this.c;
  }
  
  public boolean d()
  {
    return this.d;
  }
  
  public static enum MaskMode
  {
    static
    {
      MaskMode localMaskMode1 = new MaskMode("MASK_MODE_ADD", 0);
      MASK_MODE_ADD = localMaskMode1;
      MaskMode localMaskMode2 = new MaskMode("MASK_MODE_SUBTRACT", 1);
      MASK_MODE_SUBTRACT = localMaskMode2;
      MaskMode localMaskMode3 = new MaskMode("MASK_MODE_INTERSECT", 2);
      MASK_MODE_INTERSECT = localMaskMode3;
      MaskMode localMaskMode4 = new MaskMode("MASK_MODE_NONE", 3);
      MASK_MODE_NONE = localMaskMode4;
      $VALUES = new MaskMode[] { localMaskMode1, localMaskMode2, localMaskMode3, localMaskMode4 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\model\content\Mask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */