package com.tplink.iot.view.feedback;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tplink.iot.Utils.StatusBarUtils;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;

public class SelectFeedbackDeviceActivity
  extends BaseActivity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131559349);
    StatusBarUtils.n(this, ContextCompat.getColor(this, 2131099771));
    FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
    SelectFeedbackDeviceFragment localSelectFeedbackDeviceFragment = (SelectFeedbackDeviceFragment)Fragment.instantiate(this, SelectFeedbackDeviceFragment.class.getName());
    paramBundle = getIntent().getExtras();
    if (paramBundle != null) {
      localSelectFeedbackDeviceFragment.setArguments(paramBundle);
    }
    localFragmentTransaction.add(2131362321, localSelectFeedbackDeviceFragment);
    localFragmentTransaction.commitAllowingStateLoss();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\feedback\SelectFeedbackDeviceActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */