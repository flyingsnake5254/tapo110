package com.tplink.iot.view.ipcamera.setting.firmware;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import b.d.b.f.b;
import b.d.s.a.a;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.view.main.MainActivity;
import com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.FirmwareManager;
import com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.u;

public class FirmwareUpdateNewIpcActivity
  extends BaseActivity
{
  private boolean p0;
  private String y;
  private boolean z = false;
  
  public static void g1(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramActivity, FirmwareUpdateNewIpcActivity.class);
    localIntent.putExtra("device_id_md5", paramString);
    localIntent.putExtra("upgrade", paramBoolean);
    paramActivity.startActivity(localIntent);
  }
  
  public String e1()
  {
    return this.y;
  }
  
  public boolean f1()
  {
    return this.p0;
  }
  
  public void h1(boolean paramBoolean)
  {
    this.z = paramBoolean;
  }
  
  public void i1(int paramInt)
  {
    Object localObject;
    if (paramInt == 0) {
      localObject = new FirmwareCheckFragment();
    } else if (paramInt == 1) {
      localObject = new FirmwareUpgradeFragment();
    } else {
      localObject = null;
    }
    getSupportFragmentManager().beginTransaction().replace(2131362323, (Fragment)localObject, "f1").commit();
  }
  
  public void onBackPressed()
  {
    if (this.z) {
      startActivity(new Intent(this, MainActivity.class));
    } else {
      super.onBackPressed();
    }
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558457);
    if (getIntent() == null) {
      finish();
    }
    this.y = getIntent().getStringExtra("device_id_md5");
    paramBundle = getIntent();
    int i = 0;
    this.p0 = paramBundle.getBooleanExtra("upgrade", false);
    paramBundle = ((FirmwareManager)b.a(a.f(), FirmwareManager.class)).g(this.y);
    int j = i;
    if (paramBundle != null) {
      if (!paramBundle.e()) {
        j = i;
      } else {
        j = 1;
      }
    }
    i1(j);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\firmware\FirmwareUpdateNewIpcActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */