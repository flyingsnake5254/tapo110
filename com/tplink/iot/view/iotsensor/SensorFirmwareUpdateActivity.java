package com.tplink.iot.view.iotsensor;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.viewmodel.iotsensor.SensorFirmwareUpdateViewModel;

public final class SensorFirmwareUpdateActivity
  extends SensorBaseActivity<SensorFirmwareUpdateViewModel>
{
  public SensorFirmwareUpdateActivity()
  {
    super(SensorFirmwareUpdateViewModel.class);
  }
  
  private final void k1()
  {
    new TPMaterialDialogV2.Builder(this).h(2131953785).l(2131952391, 2131099804, null).o(2131953754, 2131099808, a.a).b(false).c(false).y();
  }
  
  public void h1()
  {
    setContentView(2131558651);
    b1(2131952696);
    k1();
  }
  
  public void j1() {}
  
  static final class a
    implements TPMaterialDialogV2.d
  {
    public static final a a = new a();
    
    public final void onClick(View paramView) {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\iotsensor\SensorFirmwareUpdateActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */