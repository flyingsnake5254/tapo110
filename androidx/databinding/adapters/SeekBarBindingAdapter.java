package androidx.databinding.adapters;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.InverseBindingMethods;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
@InverseBindingMethods({@androidx.databinding.InverseBindingMethod(attribute="android:progress", type=SeekBar.class)})
public class SeekBarBindingAdapter
{
  @BindingAdapter(requireAll=false, value={"android:onStartTrackingTouch", "android:onStopTrackingTouch", "android:onProgressChanged", "android:progressAttrChanged"})
  public static void setOnSeekBarChangeListener(SeekBar paramSeekBar, final OnStartTrackingTouch paramOnStartTrackingTouch, final OnStopTrackingTouch paramOnStopTrackingTouch, OnProgressChanged paramOnProgressChanged, final InverseBindingListener paramInverseBindingListener)
  {
    if ((paramOnStartTrackingTouch == null) && (paramOnStopTrackingTouch == null) && (paramOnProgressChanged == null) && (paramInverseBindingListener == null)) {
      paramSeekBar.setOnSeekBarChangeListener(null);
    } else {
      paramSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
      {
        public void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          SeekBarBindingAdapter.OnProgressChanged localOnProgressChanged = this.val$progressChanged;
          if (localOnProgressChanged != null) {
            localOnProgressChanged.onProgressChanged(paramAnonymousSeekBar, paramAnonymousInt, paramAnonymousBoolean);
          }
          paramAnonymousSeekBar = paramInverseBindingListener;
          if (paramAnonymousSeekBar != null) {
            paramAnonymousSeekBar.onChange();
          }
        }
        
        public void onStartTrackingTouch(SeekBar paramAnonymousSeekBar)
        {
          SeekBarBindingAdapter.OnStartTrackingTouch localOnStartTrackingTouch = paramOnStartTrackingTouch;
          if (localOnStartTrackingTouch != null) {
            localOnStartTrackingTouch.onStartTrackingTouch(paramAnonymousSeekBar);
          }
        }
        
        public void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
        {
          SeekBarBindingAdapter.OnStopTrackingTouch localOnStopTrackingTouch = paramOnStopTrackingTouch;
          if (localOnStopTrackingTouch != null) {
            localOnStopTrackingTouch.onStopTrackingTouch(paramAnonymousSeekBar);
          }
        }
      });
    }
  }
  
  @BindingAdapter({"android:progress"})
  public static void setProgress(SeekBar paramSeekBar, int paramInt)
  {
    if (paramInt != paramSeekBar.getProgress()) {
      paramSeekBar.setProgress(paramInt);
    }
  }
  
  public static abstract interface OnProgressChanged
  {
    public abstract void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean);
  }
  
  public static abstract interface OnStartTrackingTouch
  {
    public abstract void onStartTrackingTouch(SeekBar paramSeekBar);
  }
  
  public static abstract interface OnStopTrackingTouch
  {
    public abstract void onStopTrackingTouch(SeekBar paramSeekBar);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\databinding\adapters\SeekBarBindingAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */