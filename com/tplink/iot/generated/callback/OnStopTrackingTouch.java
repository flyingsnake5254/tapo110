package com.tplink.iot.generated.callback;

import android.widget.SeekBar;
import androidx.databinding.adapters.SeekBarBindingAdapter.OnStopTrackingTouch;

public final class OnStopTrackingTouch
  implements SeekBarBindingAdapter.OnStopTrackingTouch
{
  final a c;
  final int d;
  
  public OnStopTrackingTouch(a parama, int paramInt)
  {
    this.c = parama;
    this.d = paramInt;
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    this.c.a(this.d, paramSeekBar);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, SeekBar paramSeekBar);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\generated\callback\OnStopTrackingTouch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */