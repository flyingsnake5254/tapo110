package com.tplink.iot.view.quicksetup.common;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.Utils.d0.g;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.view.quicksetup.base.QuickSetupInfoBean;
import com.tplink.iot.view.quicksetup.base.d;

public class NoFindAPActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private QuickSetupInfoBean y;
  
  private void f1()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getExtras();
      if (localObject != null) {
        this.y = ((QuickSetupInfoBean)((Bundle)localObject).getSerializable("device_info_bean"));
      }
    }
  }
  
  private void g1()
  {
    d.D(this, ApNamePasswordInputActivity.class, this.y, null);
    finish();
  }
  
  private void h1()
  {
    ((ImageView)findViewById(2131362826)).setOnClickListener(this);
    d0.d(this, (TextView)findViewById(2131364566), 2131953495, getString(2131953497), new a());
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362826) {
      finish();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558591);
    f1();
    h1();
  }
  
  class a
    implements d0.g
  {
    a() {}
    
    public void a()
    {
      NoFindAPActivity.e1(NoFindAPActivity.this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\common\NoFindAPActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */