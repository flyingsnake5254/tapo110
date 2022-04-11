package com.tplink.zxing.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import b.d.e0.d;
import b.d.e0.e;

public class CaptureActivity
  extends AppCompatActivity
{
  a c = new b();
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(e.camera);
    paramBundle = new CaptureFragment();
    paramBundle.J0(this.c);
    getSupportFragmentManager().beginTransaction().replace(d.fl_zxing_container, paramBundle).commit();
    paramBundle.K0(new a());
  }
  
  class a
    implements CaptureFragment.b
  {
    a() {}
    
    public void a(Exception paramException)
    {
      if (paramException != null) {
        Log.e("TAG", "callBack: ", paramException);
      }
    }
  }
  
  class b
    implements a
  {
    b() {}
    
    public void a(Bitmap paramBitmap, String paramString)
    {
      Intent localIntent = new Intent();
      paramBitmap = new Bundle();
      paramBitmap.putInt("result_type", 1);
      paramBitmap.putString("result_string", paramString);
      localIntent.putExtras(paramBitmap);
      CaptureActivity.this.setResult(-1, localIntent);
      CaptureActivity.this.finish();
    }
    
    public void b()
    {
      Intent localIntent = new Intent();
      Bundle localBundle = new Bundle();
      localBundle.putInt("result_type", 2);
      localBundle.putString("result_string", "");
      localIntent.putExtras(localBundle);
      CaptureActivity.this.setResult(-1, localIntent);
      CaptureActivity.this.finish();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\zxing\activity\CaptureActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */