package com.tplink.iot.view.me;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import com.tplink.iot.Utils.u0;
import com.tplink.iot.a;
import com.tplink.iot.base.BaseActivity;
import java.util.HashMap;
import kotlin.jvm.internal.j;

public final class VibrateSettingActivity
  extends BaseActivity
{
  private HashMap y;
  
  private final void f1()
  {
    b1(2131952602);
    int i = a.vibrate_switch;
    SwitchCompat localSwitchCompat = (SwitchCompat)e1(i);
    j.d(localSwitchCompat, "vibrate_switch");
    localSwitchCompat.setChecked(u0.b());
    ((SwitchCompat)e1(i)).setOnCheckedChangeListener(a.a);
  }
  
  public View e1(int paramInt)
  {
    if (this.y == null) {
      this.y = new HashMap();
    }
    View localView1 = (View)this.y.get(Integer.valueOf(paramInt));
    View localView2 = localView1;
    if (localView1 == null)
    {
      localView2 = findViewById(paramInt);
      this.y.put(Integer.valueOf(paramInt), localView2);
    }
    return localView2;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558705);
    f1();
  }
  
  static final class a
    implements CompoundButton.OnCheckedChangeListener
  {
    public static final a a = new a();
    
    public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      j.d(paramCompoundButton, "buttonView");
      if (!paramCompoundButton.isPressed()) {
        return;
      }
      u0.c(paramBoolean);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\me\VibrateSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */