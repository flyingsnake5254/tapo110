package com.tplink.iot.Utils.extension;

import androidx.fragment.app.FragmentActivity;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.Lambda;

public final class DelegateUtilsKt$iotViewModels$factory$1
  extends Lambda
  implements a<IoTViewModelFactory>
{
  public DelegateUtilsKt$iotViewModels$factory$1(FragmentActivity paramFragmentActivity, String paramString)
  {
    super(0);
  }
  
  public final IoTViewModelFactory invoke()
  {
    return new IoTViewModelFactory(this.$this_iotViewModels, this.$deviceIdMD5);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\extension\DelegateUtilsKt$iotViewModels$factory$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */