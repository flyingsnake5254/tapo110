package com.tplink.iot.view.quicksetup.bulb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.Utils.d0.g;
import com.tplink.iot.base.BaseActivity;

public class SoftAPBulbGuideFirstActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private boolean p0 = false;
  private String p1;
  private long p2 = 0L;
  private View y;
  private View z;
  
  private void f1()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getExtras();
      if (localObject != null) {
        this.p1 = ((Bundle)localObject).getString("device_model");
      }
    }
  }
  
  public static void g1(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, SoftAPBulbGuideFirstActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putString("device_model", paramString);
    localIntent.putExtras(localBundle);
    paramContext.startActivity(localIntent);
  }
  
  private void h1()
  {
    this.y.setVisibility(8);
    this.z.setVisibility(0);
    this.p0 = true;
  }
  
  private void i1()
  {
    this.y.setVisibility(0);
    this.z.setVisibility(8);
    this.p0 = false;
  }
  
  public void onBackPressed()
  {
    if (this.p0) {
      i1();
    } else {
      super.onBackPressed();
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362826)
    {
      if (i == 2131363742) {
        SoftAPBulbGuideSecondActivity.I1(this, this.p1, this.p2);
      }
    }
    else {
      onBackPressed();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558668);
    f1();
    this.y = findViewById(2131363166);
    this.z = findViewById(2131363167);
    findViewById(2131363742).setOnClickListener(this);
    findViewById(2131362826).setOnClickListener(this);
    d0.h((TextView)findViewById(2131364354), getString(2131953536), ContextCompat.getColor(this, 2131099811), new a());
    this.p2 = System.currentTimeMillis();
  }
  
  class a
    implements d0.g
  {
    a() {}
    
    public void a()
    {
      SoftAPBulbGuideFirstActivity.e1(SoftAPBulbGuideFirstActivity.this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\bulb\SoftAPBulbGuideFirstActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */