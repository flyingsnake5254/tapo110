package com.tplink.iot.view.about;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tplink.iot.Utils.StatusBarUtils;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;

public class PrivacySettingActivity
  extends BaseActivity
{
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558715);
    b1(2131951658);
    StatusBarUtils.n(this, ContextCompat.getColor(this, 2131099771));
    paramBundle = getSupportFragmentManager().beginTransaction();
    paramBundle.replace(2131362321, new PrivacySettingFragment());
    paramBundle.commitAllowingStateLoss();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\about\PrivacySettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */