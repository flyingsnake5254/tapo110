package com.tplink.iot.Utils.extension;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelStore;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

public final class DelegateUtilsKt$iotViewModels$2
  extends Lambda
  implements a<ViewModelStore>
{
  public DelegateUtilsKt$iotViewModels$2(Fragment paramFragment)
  {
    super(0);
  }
  
  public final ViewModelStore invoke()
  {
    ViewModelStore localViewModelStore = this.$this_iotViewModels.getViewModelStore();
    j.d(localViewModelStore, "viewModelStore");
    return localViewModelStore;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\extension\DelegateUtilsKt$iotViewModels$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */