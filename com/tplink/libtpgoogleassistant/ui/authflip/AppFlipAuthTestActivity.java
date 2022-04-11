package com.tplink.libtpgoogleassistant.ui.authflip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AppCompatActivity;
import b.d.k.b;

public class AppFlipAuthTestActivity
  extends AppCompatActivity
{
  private void P0(b.d.k.e.a parama)
  {
    parama.a("authCodeXXXXXX");
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(b.activity_app_flip_auth_test);
    if (!b.d.k.f.a.c(getApplicationContext(), getCallingActivity(), getIntent()))
    {
      finish();
      return;
    }
    findViewById(b.d.k.a.btn).setOnClickListener(new a(this));
  }
  
  class a
    implements b.d.k.e.a
  {
    a() {}
    
    public void a(String paramString)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("AUTHORIZATION_CODE", paramString);
        AppFlipAuthTestActivity.this.setResult(-1, localIntent);
      }
      else
      {
        paramString = new Intent();
        paramString.putExtra("ERROR_TYPE", 1);
        paramString.putExtra("ERROR_CODE", 1);
        paramString.putExtra("ERROR_DESCRIPTION", "Invalid Request");
        AppFlipAuthTestActivity.this.setResult(-2, paramString);
      }
      AppFlipAuthTestActivity.this.finish();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpgoogleassistant\ui\authflip\AppFlipAuthTestActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */