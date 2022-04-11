package com.bumptech.glide.load;

public enum PreferredColorSpace
{
  static
  {
    PreferredColorSpace localPreferredColorSpace1 = new PreferredColorSpace("SRGB", 0);
    SRGB = localPreferredColorSpace1;
    PreferredColorSpace localPreferredColorSpace2 = new PreferredColorSpace("DISPLAY_P3", 1);
    DISPLAY_P3 = localPreferredColorSpace2;
    $VALUES = new PreferredColorSpace[] { localPreferredColorSpace1, localPreferredColorSpace2 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\PreferredColorSpace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */