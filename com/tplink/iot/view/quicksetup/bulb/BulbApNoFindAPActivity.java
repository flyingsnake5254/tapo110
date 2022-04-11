package com.tplink.iot.view.quicksetup.bulb;

import android.app.Activity;
import android.content.Context;
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
import com.tplink.iot.view.quicksetup.bulb.utils.QuickSetupInfoBundle;

public class BulbApNoFindAPActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private QuickSetupInfoBundle y;
  
  private void f1()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getExtras();
      if (localObject != null) {
        this.y = ((QuickSetupInfoBundle)((Bundle)localObject).getSerializable("quick_setup_bundle"));
      }
    }
  }
  
  private void g1()
  {
    Intent localIntent = new Intent(this, BulbApNamePasswordInputActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("quick_setup_bundle", this.y);
    localIntent.putExtras(localBundle);
    startActivity(localIntent);
  }
  
  private void h1()
  {
    ((ImageView)findViewById(2131362826)).setOnClickListener(this);
    d0.d(this, (TextView)findViewById(2131364566), 2131953495, getString(2131953496), new a());
  }
  
  public static void i1(Context paramContext, QuickSetupInfoBundle paramQuickSetupInfoBundle)
  {
    Intent localIntent = new Intent(paramContext, BulbApNoFindAPActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("quick_setup_bundle", paramQuickSetupInfoBundle);
    localIntent.putExtras(localBundle);
    paramContext.startActivity(localIntent);
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
      BulbApNoFindAPActivity.e1(BulbApNoFindAPActivity.this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\bulb\BulbApNoFindAPActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */