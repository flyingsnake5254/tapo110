package com.tplink.iot.view.ipcamera.preview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.tplink.iot.base.BaseActivity;
import com.tplink.libtpnetwork.Utils.o;

public class CameraPreferenceActivity
  extends BaseActivity
{
  private void e1()
  {
    Object localObject = o.h0();
    int i = 0;
    boolean bool = ((b.d.w.g.a)localObject).c("LIVE_ICON_VISIBLE", false);
    localObject = findViewById(2131362173);
    if (!bool) {
      i = 8;
    }
    ((View)localObject).setVisibility(i);
    CheckBox localCheckBox = (CheckBox)findViewById(2131362174);
    localCheckBox.setChecked(bool);
    localCheckBox.setOnCheckedChangeListener(new a((View)localObject));
  }
  
  private void f1()
  {
    Object localObject = o.h0();
    int i = 0;
    boolean bool = ((b.d.w.g.a)localObject).c("SPEED_ICON_VISIBLE", false);
    localObject = findViewById(2131362183);
    if (!bool) {
      i = 8;
    }
    ((View)localObject).setVisibility(i);
    CheckBox localCheckBox = (CheckBox)findViewById(2131362184);
    localCheckBox.setChecked(bool);
    localCheckBox.setOnCheckedChangeListener(new b((View)localObject));
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558472);
    setTitle(2131952598);
    e1();
    f1();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\preview\CameraPreferenceActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */