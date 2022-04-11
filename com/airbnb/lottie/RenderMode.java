package com.airbnb.lottie;

public enum RenderMode
{
  static
  {
    RenderMode localRenderMode1 = new RenderMode("AUTOMATIC", 0);
    AUTOMATIC = localRenderMode1;
    RenderMode localRenderMode2 = new RenderMode("HARDWARE", 1);
    HARDWARE = localRenderMode2;
    RenderMode localRenderMode3 = new RenderMode("SOFTWARE", 2);
    SOFTWARE = localRenderMode3;
    $VALUES = new RenderMode[] { localRenderMode1, localRenderMode2, localRenderMode3 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\RenderMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */