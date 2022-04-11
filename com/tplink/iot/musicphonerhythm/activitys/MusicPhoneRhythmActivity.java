package com.tplink.iot.musicphonerhythm.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tplink.iot.base.BaseActivity;

public class MusicPhoneRhythmActivity
  extends BaseActivity
{
  private String y;
  private String z;
  
  public static void e1(Activity paramActivity, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(paramActivity, MusicPhoneRhythmActivity.class);
    localIntent.putExtra("device_id_md5", paramString1);
    localIntent.putExtra("USER_DEVICE_IP", paramString2);
    paramActivity.startActivity(localIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558588);
    if (getIntent() == null) {
      return;
    }
    this.y = getIntent().getStringExtra("device_id_md5");
    this.z = getIntent().getStringExtra("USER_DEVICE_IP");
    FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
    paramBundle = new MusicPhoneRhythmFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("device_id_md5", this.y);
    localBundle.putString("USER_DEVICE_IP", this.z);
    paramBundle.setArguments(localBundle);
    localFragmentTransaction.add(2131362322, paramBundle);
    localFragmentTransaction.commitAllowingStateLoss();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\musicphonerhythm\activitys\MusicPhoneRhythmActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */