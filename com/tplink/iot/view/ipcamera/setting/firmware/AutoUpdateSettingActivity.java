package com.tplink.iot.view.ipcamera.setting.firmware;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.a;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.AutoUpdateSettingViewMode;
import com.tplink.iot.widget.h;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import com.tplink.libtpnetwork.cameranetwork.model.AutoUpdateInfo;
import com.tplink.libtpnetwork.cameranetwork.model.OptionSwitch;
import com.tplink.libtpnetwork.cameranetwork.model.OptionSwitch.Companion;
import java.util.HashMap;
import kotlin.jvm.internal.j;
import org.apache.commons.lang.b;

public final class AutoUpdateSettingActivity
  extends BaseActivity
  implements AutoUpdateTimePickerDialog.a
{
  private HashMap H3;
  private final String[] p0 = h.d();
  private AutoUpdateTimePickerDialog p1;
  private int p2 = 180;
  private MenuItem p3;
  private String y;
  private AutoUpdateSettingViewMode z;
  
  private final int n1(int paramInt)
  {
    return paramInt / 60 % 24;
  }
  
  private final boolean q1()
  {
    Object localObject = this.z;
    if (localObject == null) {
      j.t("viewModel");
    }
    localObject = ((AutoUpdateSettingViewMode)localObject).f;
    boolean bool1 = true;
    boolean bool2 = bool1;
    if (localObject != null)
    {
      int i = a.auto_update_switch;
      bool2 = bool1;
      if ((CheckBox)e1(i) != null)
      {
        localObject = OptionSwitch.Companion;
        AutoUpdateSettingViewMode localAutoUpdateSettingViewMode = this.z;
        if (localAutoUpdateSettingViewMode == null) {
          j.t("viewModel");
        }
        boolean bool3 = ((OptionSwitch.Companion)localObject).isOn(localAutoUpdateSettingViewMode.f.getEnabled());
        localObject = (CheckBox)e1(i);
        j.d(localObject, "auto_update_switch");
        bool2 = bool1;
        if (bool3 == ((CheckBox)localObject).isChecked())
        {
          localAutoUpdateSettingViewMode = this.z;
          if (localAutoUpdateSettingViewMode == null) {
            j.t("viewModel");
          }
          localObject = this.z;
          if (localObject == null) {
            j.t("viewModel");
          }
          if (localAutoUpdateSettingViewMode.j(((AutoUpdateSettingViewMode)localObject).f.getTime()) != this.p2) {
            bool2 = bool1;
          } else {
            bool2 = false;
          }
        }
      }
    }
    return bool2;
  }
  
  private final void r1()
  {
    AutoUpdateTimePickerDialog localAutoUpdateTimePickerDialog = this.p1;
    if (localAutoUpdateTimePickerDialog != null)
    {
      j.c(localAutoUpdateTimePickerDialog);
      if (localAutoUpdateTimePickerDialog.isVisible()) {
        return;
      }
    }
    localAutoUpdateTimePickerDialog = AutoUpdateTimePickerDialog.A0(this.p2);
    this.p1 = localAutoUpdateTimePickerDialog;
    if (localAutoUpdateTimePickerDialog != null) {
      localAutoUpdateTimePickerDialog.B0(this);
    }
    localAutoUpdateTimePickerDialog = this.p1;
    if (localAutoUpdateTimePickerDialog != null) {
      localAutoUpdateTimePickerDialog.show(getSupportFragmentManager(), null);
    }
  }
  
  public View e1(int paramInt)
  {
    if (this.H3 == null) {
      this.H3 = new HashMap();
    }
    View localView1 = (View)this.H3.get(Integer.valueOf(paramInt));
    View localView2 = localView1;
    if (localView1 == null)
    {
      localView2 = findViewById(paramInt);
      this.H3.put(Integer.valueOf(paramInt), localView2);
    }
    return localView2;
  }
  
  public final void o1()
  {
    Object localObject = getIntent().getStringExtra("device_id_md5");
    if (localObject == null) {
      localObject = "";
    }
    this.y = ((String)localObject);
    if (localObject == null) {
      j.t("deviceIdMD5");
    }
    localObject = ViewModelProviders.of(this, new CameraViewModelFactory(this, (String)localObject)).get(AutoUpdateSettingViewMode.class);
    j.d(localObject, "ViewModelProviders.of(th…tingViewMode::class.java)");
    this.z = ((AutoUpdateSettingViewMode)localObject);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    o1();
    p1();
    s1();
    paramBundle = this.z;
    if (paramBundle == null) {
      j.t("viewModel");
    }
    paramBundle.f();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    j.e(paramMenu, "menu");
    getMenuInflater().inflate(2131623941, paramMenu);
    MenuItem localMenuItem = paramMenu.findItem(2131362300);
    j.d(localMenuItem, "menu.findItem(R.id.common_save)");
    this.p3 = localMenuItem;
    if (localMenuItem == null) {
      j.t("mMenuSave");
    }
    localMenuItem.setEnabled(q1());
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    j.e(paramMenuItem, "item");
    if (paramMenuItem.getItemId() == 2131362300)
    {
      AutoUpdateSettingViewMode localAutoUpdateSettingViewMode = this.z;
      if (localAutoUpdateSettingViewMode == null) {
        j.t("viewModel");
      }
      CheckBox localCheckBox = (CheckBox)e1(a.auto_update_switch);
      j.d(localCheckBox, "auto_update_switch");
      localAutoUpdateSettingViewMode.A(localCheckBox.isChecked(), this.p2);
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public final void p1()
  {
    setContentView(2131558449);
    b1(2131952684);
    ((CheckBox)e1(a.auto_update_switch)).setOnCheckedChangeListener(new a(this));
    int i = n1(this.p2);
    int j = a.auto_update_time;
    TextView localTextView = (TextView)e1(j);
    j.d(localTextView, "auto_update_time");
    localTextView.setText(this.p0[i]);
    ((TextView)e1(j)).setOnClickListener(new b(this));
  }
  
  public final void s1()
  {
    AutoUpdateSettingViewMode localAutoUpdateSettingViewMode = this.z;
    if (localAutoUpdateSettingViewMode == null) {
      j.t("viewModel");
    }
    localAutoUpdateSettingViewMode.g().observe(this, new c(this));
    localAutoUpdateSettingViewMode = this.z;
    if (localAutoUpdateSettingViewMode == null) {
      j.t("viewModel");
    }
    localAutoUpdateSettingViewMode.i().observe(this, new d(this));
    localAutoUpdateSettingViewMode = this.z;
    if (localAutoUpdateSettingViewMode == null) {
      j.t("viewModel");
    }
    localAutoUpdateSettingViewMode.h().observe(this, new e(this));
  }
  
  public void v(int paramInt)
  {
    this.p2 = (paramInt * 60);
    Object localObject = (TextView)e1(a.auto_update_time);
    j.d(localObject, "auto_update_time");
    ((TextView)localObject).setText(this.p0[paramInt]);
    localObject = this.p3;
    if (localObject == null) {
      j.t("mMenuSave");
    }
    ((MenuItem)localObject).setEnabled(q1());
  }
  
  static final class a
    implements CompoundButton.OnCheckedChangeListener
  {
    a(AutoUpdateSettingActivity paramAutoUpdateSettingActivity) {}
    
    public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      j.d(paramCompoundButton, "compoundButton");
      if (!paramCompoundButton.isPressed()) {
        return;
      }
      AutoUpdateSettingActivity.g1(this.a).setEnabled(AutoUpdateSettingActivity.k1(this.a));
      paramCompoundButton = (LinearLayout)this.a.e1(a.layout_auto_update_schedule);
      j.d(paramCompoundButton, "layout_auto_update_schedule");
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      paramCompoundButton.setVisibility(i);
    }
  }
  
  static final class b
    implements View.OnClickListener
  {
    b(AutoUpdateSettingActivity paramAutoUpdateSettingActivity) {}
    
    public final void onClick(View paramView)
    {
      AutoUpdateSettingActivity.m1(this.c);
    }
  }
  
  static final class c<T>
    implements Observer<AutoUpdateInfo>
  {
    c(AutoUpdateSettingActivity paramAutoUpdateSettingActivity) {}
    
    public final void a(AutoUpdateInfo paramAutoUpdateInfo)
    {
      if (paramAutoUpdateInfo != null)
      {
        AutoUpdateSettingActivity localAutoUpdateSettingActivity = this.a;
        AutoUpdateSettingActivity.l1(localAutoUpdateSettingActivity, AutoUpdateSettingActivity.j1(localAutoUpdateSettingActivity).j(paramAutoUpdateInfo.getTime()));
        boolean bool = OptionSwitch.Companion.isOn(paramAutoUpdateInfo.getEnabled());
        paramAutoUpdateInfo = (CheckBox)this.a.e1(a.auto_update_switch);
        j.d(paramAutoUpdateInfo, "auto_update_switch");
        paramAutoUpdateInfo.setChecked(bool);
        paramAutoUpdateInfo = this.a;
        int i = AutoUpdateSettingActivity.f1(paramAutoUpdateInfo, AutoUpdateSettingActivity.h1(paramAutoUpdateInfo));
        paramAutoUpdateInfo = (TextView)this.a.e1(a.auto_update_time);
        j.d(paramAutoUpdateInfo, "auto_update_time");
        paramAutoUpdateInfo.setText(AutoUpdateSettingActivity.i1(this.a)[i]);
        paramAutoUpdateInfo = (LinearLayout)this.a.e1(a.layout_auto_update_schedule);
        j.d(paramAutoUpdateInfo, "layout_auto_update_schedule");
        if (bool) {
          i = 0;
        } else {
          i = 8;
        }
        paramAutoUpdateInfo.setVisibility(i);
      }
    }
  }
  
  static final class d<T>
    implements Observer<Integer>
  {
    d(AutoUpdateSettingActivity paramAutoUpdateSettingActivity) {}
    
    public final void a(Integer paramInteger)
    {
      if (paramInteger != null) {
        if (paramInteger.intValue() == 0)
        {
          this.a.finish();
        }
        else if (paramInteger.intValue() == -1)
        {
          paramInteger = this.a;
          s0.p(paramInteger, paramInteger.getString(2131952444));
        }
      }
    }
  }
  
  static final class e<T>
    implements Observer<Boolean>
  {
    e(AutoUpdateSettingActivity paramAutoUpdateSettingActivity) {}
    
    public final void a(Boolean paramBoolean)
    {
      if (b.b(paramBoolean)) {
        ((CameraLoadingView)this.a.e1(a.loading_view)).b();
      } else {
        ((CameraLoadingView)this.a.e1(a.loading_view)).a();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\firmware\AutoUpdateSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */