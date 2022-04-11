package com.tplink.iot.view.ipcamera.cloudconnect;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;

public class CameraCloudConnectSuccessActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private void e1()
  {
    setResult(-1);
    finish();
  }
  
  protected void f1()
  {
    ((Button)findViewById(2131362055)).setOnClickListener(this);
    ((ImageView)findViewById(2131362826)).setOnClickListener(this);
  }
  
  public void onBackPressed()
  {
    e1();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i == 2131362055) || (i == 2131362826)) {
      e1();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558471);
    f1();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\cloudconnect\CameraCloudConnectSuccessActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */