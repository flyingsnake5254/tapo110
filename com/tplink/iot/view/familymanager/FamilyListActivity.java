package com.tplink.iot.view.familymanager;

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

public class FamilyListActivity
  extends BaseActivity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558993);
    StatusBarUtils.n(this, ContextCompat.getColor(this, 2131099771));
    paramBundle = getSupportFragmentManager().beginTransaction();
    paramBundle.add(2131362321, (FamilyListFragment)Fragment.instantiate(this, FamilyListFragment.class.getName()));
    paramBundle.commitAllowingStateLoss();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\familymanager\FamilyListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */