package com.tplink.iot.view.cloudvideo;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tplink.iot.Utils.StatusBarUtils;
import com.tplink.iot.base.BaseActivity;

public class CloudVideoListActivity
  extends BaseActivity
{
  protected void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (1345 == paramInt1)
    {
      CloudVideoListFragment localCloudVideoListFragment = (CloudVideoListFragment)getSupportFragmentManager().findFragmentByTag(CloudVideoListFragment.class.getName());
      if (localCloudVideoListFragment != null) {
        localCloudVideoListFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (com.tplink.iot.core.o.a() == 0) {
      return;
    }
    setContentView(2131558737);
    StatusBarUtils.n(this, ContextCompat.getColor(this, 2131099771));
    com.tplink.iot.Utils.o.a(this, 2131362270, CloudVideoListFragment.class.getName());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\cloudvideo\CloudVideoListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */