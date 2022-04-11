package com.google.android.material.transition.platform;

import androidx.annotation.RequiresApi;

@RequiresApi(21)
abstract interface FadeModeEvaluator
{
  public abstract FadeModeResult evaluate(float paramFloat1, float paramFloat2, float paramFloat3);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\transition\platform\FadeModeEvaluator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */