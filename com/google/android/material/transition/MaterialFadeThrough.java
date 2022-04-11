package com.google.android.material.transition;

public final class MaterialFadeThrough
  extends MaterialVisibility<FadeThroughProvider>
{
  private static final float DEFAULT_START_SCALE = 0.92F;
  
  public MaterialFadeThrough()
  {
    super(createPrimaryAnimatorProvider(), createSecondaryAnimatorProvider());
  }
  
  private static FadeThroughProvider createPrimaryAnimatorProvider()
  {
    return new FadeThroughProvider();
  }
  
  private static VisibilityAnimatorProvider createSecondaryAnimatorProvider()
  {
    ScaleProvider localScaleProvider = new ScaleProvider();
    localScaleProvider.setScaleOnDisappear(false);
    localScaleProvider.setIncomingStartScale(0.92F);
    return localScaleProvider;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\transition\MaterialFadeThrough.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */