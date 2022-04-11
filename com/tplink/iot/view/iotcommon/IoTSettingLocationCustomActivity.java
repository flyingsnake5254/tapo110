package com.tplink.iot.view.iotcommon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import b.d.w.h.a;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.model.iot.EnumDeviceNicknameType;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.viewmodel.iotcommon.IoTDeviceLocationViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.TPBaseDeviceViewModelFactory;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.iot.widget.FlowTagLayout;
import com.tplink.iot.widget.FlowTagLayout.c;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.RoomBean;
import java.util.ArrayList;

public class IoTSettingLocationCustomActivity
  extends BaseActivity
  implements FlowTagLayout.c
{
  private boolean H3 = false;
  private CharSequence p0;
  private MenuItem p1;
  private String p2;
  private IoTDeviceLocationViewModel p3;
  private DrawableEditText y;
  private FlowTagLayout z;
  
  private void m1()
  {
    Intent localIntent = getIntent();
    if (localIntent != null) {
      this.p2 = localIntent.getStringExtra("device_id");
    }
  }
  
  private ArrayList<String> n1()
  {
    ArrayList localArrayList = new ArrayList();
    for (EnumDeviceNicknameType localEnumDeviceNicknameType : EnumDeviceNicknameType.values()) {
      if (localEnumDeviceNicknameType != EnumDeviceNicknameType.CUSTOM) {
        localArrayList.add(EnumDeviceNicknameType.fromType(localEnumDeviceNicknameType));
      }
    }
    return localArrayList;
  }
  
  private void o1()
  {
    b1(2131953837);
    Object localObject = (FlowTagLayout)findViewById(2131362682);
    this.z = ((FlowTagLayout)localObject);
    ((FlowTagLayout)localObject).c(n1(), this);
    localObject = (DrawableEditText)findViewById(2131362506);
    this.y = ((DrawableEditText)localObject);
    ((DrawableEditText)localObject).f(new b());
    this.y.m();
  }
  
  private void p1()
  {
    new TPMaterialDialogV2.Builder(this).j(getString(2131953671, new Object[] { Integer.valueOf(32) })).o(2131951761, 2131099808, null).g(8, 8).b(false).c(false).a().show();
  }
  
  private void q1()
  {
    this.p3.l().observe(this, new a());
  }
  
  public void G(String paramString)
  {
    this.H3 = true;
    l.m(this.y, paramString);
    d.I(this);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558468);
    m1();
    this.p3 = ((IoTDeviceLocationViewModel)ViewModelProviders.of(this, new TPBaseDeviceViewModelFactory(this, a.g(this.p2))).get(IoTDeviceLocationViewModel.class));
    o1();
    q1();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623941, paramMenu);
    MenuItem localMenuItem = paramMenu.findItem(2131362300);
    this.p1 = localMenuItem;
    localMenuItem.setEnabled(false);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    d.I(this);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131362300)
    {
      String str = this.y.getText().toString().trim();
      if (!TextUtils.isEmpty(this.p3.o(str)))
      {
        s0.p(this, getString(2131953674));
      }
      else
      {
        s0.l(this);
        this.p3.j(str);
      }
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  class a
    implements Observer<i<RoomBean>>
  {
    a() {}
    
    public void a(@Nullable i<RoomBean> parami)
    {
      
      if (parami != null)
      {
        int i = parami.b();
        if (i != 0)
        {
          if (i != 15009) {
            s0.n(IoTSettingLocationCustomActivity.this, 2131953328);
          } else {
            IoTSettingLocationCustomActivity.e1(IoTSettingLocationCustomActivity.this);
          }
        }
        else
        {
          if (parami.a() != null)
          {
            Intent localIntent = new Intent();
            localIntent.putExtra("extra_new_custom_room_id", ((RoomBean)parami.a()).getRoomId());
            IoTSettingLocationCustomActivity.this.setResult(-1, localIntent);
          }
          IoTSettingLocationCustomActivity.this.finish();
        }
      }
    }
  }
  
  class b
    implements TextWatcher
  {
    b() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      if (paramEditable.toString().getBytes().length > 64)
      {
        paramEditable.delete(IoTSettingLocationCustomActivity.f1(IoTSettingLocationCustomActivity.this).length() - 1, IoTSettingLocationCustomActivity.f1(IoTSettingLocationCustomActivity.this).length());
        IoTSettingLocationCustomActivity.h1(IoTSettingLocationCustomActivity.this).setText(paramEditable);
        IoTSettingLocationCustomActivity.h1(IoTSettingLocationCustomActivity.this).setSelection(paramEditable.length());
      }
      if (IoTSettingLocationCustomActivity.i1(IoTSettingLocationCustomActivity.this) != null) {
        IoTSettingLocationCustomActivity.i1(IoTSettingLocationCustomActivity.this).setEnabled(TextUtils.isEmpty(paramEditable) ^ true);
      }
      if (!IoTSettingLocationCustomActivity.j1(IoTSettingLocationCustomActivity.this)) {
        IoTSettingLocationCustomActivity.l1(IoTSettingLocationCustomActivity.this).d();
      } else {
        IoTSettingLocationCustomActivity.k1(IoTSettingLocationCustomActivity.this, false);
      }
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      IoTSettingLocationCustomActivity.g1(IoTSettingLocationCustomActivity.this, paramCharSequence);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\iotcommon\IoTSettingLocationCustomActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */