package com.google.android.material.transition;

public final class MaterialFade
  extends MaterialVisibility<FadeProvider>
{
  private static final float DEFAULT_FADE_END_THRESHOLD_ENTER = 0.3F;
  private static final float DEFAULT_START_SCALE = 0.8F;
  
  public MaterialFade()
  {
    super(createPrimaryAnimatorProvider(), createSecondaryAnimatorProvider());
  }
  
  private static FadeProvider createPrimaryAnimatorProvider()
  {
    FadeProvider localFadeProvider = new FadeProvider();
    localFadeProvider.setIncomingEndThreshold(0.3F);
    return localFadeProvider;
  }
  
  private static VisibilityAnimatorProvider createSecondaryAnimatorProvider()
  {
    ScaleProvider localScaleProvider = new ScaleProvider();
    localScaleProvider.setScaleOnDisappear(false);
    localScaleProvider.setIncomingStartScale(0.8F);
    return localScaleProvider;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\transition\MaterialFade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */