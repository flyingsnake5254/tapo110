package com.tplink.iot.view.about;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.tplink.iot.Utils.StatusBarUtils;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;

public class LicenseItemActivity
  extends BaseActivity
{
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558556);
    paramBundle = getIntent().getStringExtra("toolbar_title");
    int i = getIntent().getIntExtra("content", -1);
    if (!TextUtils.isEmpty(paramBundle)) {
      c1(paramBundle);
    }
    paramBundle = (TextView)findViewById(2131363223);
    if (i != -1) {
      paramBundle.setText(i);
    }
    StatusBarUtils.n(this, ContextCompat.getColor(this, 2131099771));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\about\LicenseItemActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */