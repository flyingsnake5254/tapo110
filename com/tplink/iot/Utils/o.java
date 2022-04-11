package com.tplink.iot.Utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class o
{
  public static void a(FragmentActivity paramFragmentActivity, int paramInt, String paramString)
  {
    if (paramFragmentActivity.getSupportFragmentManager().findFragmentById(paramInt) == null)
    {
      paramString = Fragment.instantiate(paramFragmentActivity, paramString);
      Bundle localBundle = paramFragmentActivity.getIntent().getExtras();
      if (localBundle != null) {
        paramString.setArguments(localBundle);
      }
      paramFragmentActivity = paramFragmentActivity.getSupportFragmentManager().beginTransaction();
      paramFragmentActivity.add(paramInt, paramString);
      paramFragmentActivity.commitAllowingStateLoss();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */