package com.tplink.iot.view.ipcamera.widget.progressbar;

import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.InverseBindingListener;

public class a
{
  @InverseBindingAdapter(attribute="criticalLineVisible", event="criticalLineVisibilityChanged")
  public static boolean a(MultiColorSeekBar paramMultiColorSeekBar)
  {
    return paramMultiColorSeekBar.d();
  }
  
  @InverseBindingAdapter(attribute="progress", event="progressChanged")
  public static int b(MultiColorSeekBar paramMultiColorSeekBar)
  {
    return paramMultiColorSeekBar.getProgress();
  }
  
  @BindingAdapter({"criticalLineVisible"})
  public static void c(MultiColorSeekBar paramMultiColorSeekBar, boolean paramBoolean) {}
  
  @BindingAdapter({"progress"})
  public static void d(MultiColorSeekBar paramMultiColorSeekBar, int paramInt)
  {
    paramMultiColorSeekBar.setProgress(paramInt);
  }
  
  @BindingAdapter(requireAll=false, value={"progressChanged", "criticalLineVisibilityChanged"})
  public static void e(MultiColorSeekBar paramMultiColorSeekBar, InverseBindingListener paramInverseBindingListener1, final InverseBindingListener paramInverseBindingListener2)
  {
    paramMultiColorSeekBar.setSeekbarAttrsChangedListener(new a(paramInverseBindingListener1, paramInverseBindingListener2));
  }
  
  static final class a
    implements MultiColorSeekBar.a
  {
    a(InverseBindingListener paramInverseBindingListener1, InverseBindingListener paramInverseBindingListener2) {}
    
    public void a(boolean paramBoolean)
    {
      paramInverseBindingListener2.onChange();
    }
    
    public void b(int paramInt)
    {
      this.a.onChange();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\widget\progressbar\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */