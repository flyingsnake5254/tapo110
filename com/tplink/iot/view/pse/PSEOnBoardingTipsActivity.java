package com.tplink.iot.view.pse;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.view.quicksetup.ble.BleAddPlugActivity;

public class PSEOnBoardingTipsActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private String y;
  
  private void e1()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getExtras();
      if (localObject != null) {
        this.y = ((Bundle)localObject).getString("device_model");
      }
    }
  }
  
  private void f1()
  {
    BleAddPlugActivity.C1(this, this.y);
    finish();
  }
  
  private void g1()
  {
    findViewById(2131363013).setOnClickListener(this);
    findViewById(2131362035).setOnClickListener(this);
    findViewById(2131362054).setOnClickListener(this);
    TextView localTextView = (TextView)findViewById(2131364386);
    String str1 = getString(2131953439);
    String str2 = getString(2131953440);
    String str3 = getString(2131953441);
    String str4 = getString(2131953442);
    String str5 = getString(2131953443);
    String str6 = getString(2131953444);
    String str7 = getString(2131953445);
    String str8 = getString(2131953446);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str1);
    localStringBuilder.append("\n");
    localStringBuilder.append(str2);
    localStringBuilder.append("\n");
    localStringBuilder.append(str3);
    localStringBuilder.append("\n");
    localStringBuilder.append(str4);
    localStringBuilder.append("\n");
    localStringBuilder.append(str5);
    localStringBuilder.append("\n");
    localStringBuilder.append(str6);
    localStringBuilder.append("\n");
    localStringBuilder.append(str7);
    localStringBuilder.append("\n");
    localStringBuilder.append(str8);
    localTextView.setText(localStringBuilder.toString());
  }
  
  public static void h1(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, PSEOnBoardingTipsActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putString("device_model", paramString);
    localIntent.putExtras(localBundle);
    paramContext.startActivity(localIntent);
  }
  
  private void i1()
  {
    new TPMaterialDialogV2.Builder(this).j(getString(2131953434)).l(2131952391, 2131099804, null).o(2131953414, 2131099808, new a()).g(8, 8).b(false).c(false).a().show();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362035)
    {
      if (i != 2131362054)
      {
        if (i == 2131363013) {
          finish();
        }
      }
      else {
        i1();
      }
    }
    else {
      f1();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558618);
    e1();
    g1();
  }
  
  class a
    implements TPMaterialDialogV2.d
  {
    a() {}
    
    public void onClick(View paramView)
    {
      PSEOnBoardingTipsActivity.this.finish();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\pse\PSEOnBoardingTipsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */