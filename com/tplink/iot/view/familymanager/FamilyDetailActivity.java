package com.tplink.iot.view.familymanager;

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

public class FamilyDetailActivity
  extends BaseActivity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558991);
    StatusBarUtils.n(this, ContextCompat.getColor(this, 2131099771));
    paramBundle = getSupportFragmentManager().beginTransaction();
    FamilyDetailFragment localFamilyDetailFragment = (FamilyDetailFragment)Fragment.instantiate(this, FamilyDetailFragment.class.getName());
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null) {
      localFamilyDetailFragment.setArguments(localBundle);
    }
    paramBundle.add(2131362321, localFamilyDetailFragment);
    paramBundle.commitAllowingStateLoss();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\familymanager\FamilyDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */