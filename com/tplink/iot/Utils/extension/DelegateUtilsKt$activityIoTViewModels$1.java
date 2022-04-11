package com.tplink.iot.Utils.extension;

import androidx.activity.ComponentActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelStore;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

public final class DelegateUtilsKt$activityIoTViewModels$1
  extends Lambda
  implements a<ViewModelStore>
{
  public DelegateUtilsKt$activityIoTViewModels$1(Fragment paramFragment)
  {
    super(0);
  }
  
  public final ViewModelStore invoke()
  {
    Object localObject = this.$this_activityIoTViewModels.requireActivity();
    j.d(localObject, "requireActivity()");
    localObject = ((ComponentActivity)localObject).getViewModelStore();
    j.d(localObject, "requireActivity().viewModelStore");
    return (ViewModelStore)localObject;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\extension\DelegateUtilsKt$activityIoTViewModels$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */