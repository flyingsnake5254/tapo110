package com.google.android.material.transition.platform;

import androidx.annotation.RequiresApi;

@RequiresApi(21)
class FitModeResult
{
  final float currentEndHeight;
  final float currentEndWidth;
  final float currentStartHeight;
  final float currentStartWidth;
  final float endScale;
  final float startScale;
  
  FitModeResult(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    this.startScale = paramFloat1;
    this.endScale = paramFloat2;
    this.currentStartWidth = paramFloat3;
    this.currentStartHeight = paramFloat4;
    this.currentEndWidth = paramFloat5;
    this.currentEndHeight = paramFloat6;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\transition\platform\FitModeResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */