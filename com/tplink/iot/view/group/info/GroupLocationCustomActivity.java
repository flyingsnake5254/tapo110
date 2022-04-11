package com.tplink.iot.view.group.info;

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
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.model.iot.EnumDeviceNicknameType;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.viewmodel.group.GroupLocationViewModel;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.iot.widget.FlowTagLayout;
import com.tplink.iot.widget.FlowTagLayout.c;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.RoomBean;
import java.util.ArrayList;

public class GroupLocationCustomActivity
  extends BaseActivity
  implements FlowTagLayout.c
{
  private GroupLocationViewModel H3;
  private CharSequence p0;
  private FlowTagLayout p1;
  private boolean p2 = false;
  private MenuItem p3;
  private String y;
  private DrawableEditText z;
  
  private void m1()
  {
    Intent localIntent = getIntent();
    if (localIntent != null) {
      this.y = localIntent.getStringExtra("group_id");
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
    Object localObject = (FlowTagLayout)findViewById(2131362682);
    this.p1 = ((FlowTagLayout)localObject);
    ((FlowTagLayout)localObject).c(n1(), this);
    localObject = (DrawableEditText)findViewById(2131362506);
    this.z = ((DrawableEditText)localObject);
    ((DrawableEditText)localObject).f(new b());
    this.z.m();
  }
  
  public static void p1(Activity paramActivity, int paramInt)
  {
    paramActivity.startActivityForResult(new Intent(paramActivity, GroupLocationCustomActivity.class), paramInt);
  }
  
  private void q1()
  {
    new TPMaterialDialogV2.Builder(this).j(getString(2131953671, new Object[] { Integer.valueOf(32) })).o(2131951761, 2131099808, null).g(8, 8).b(false).c(false).a().show();
  }
  
  private void r1()
  {
    this.H3.i().observe(this, new a());
  }
  
  public void G(String paramString)
  {
    this.p2 = true;
    l.m(this.z, paramString);
    d.I(this);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558534);
    this.H3 = ((GroupLocationViewModel)ViewModelProviders.of(this).get(GroupLocationViewModel.class));
    m1();
    o1();
    r1();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623941, paramMenu);
    MenuItem localMenuItem = paramMenu.findItem(2131362300);
    this.p3 = localMenuItem;
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
      String str = this.z.getText().toString().trim();
      if (!TextUtils.isEmpty(this.H3.l(str)))
      {
        s0.p(this, getString(2131953674));
      }
      else
      {
        s0.l(this);
        this.H3.h(str);
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
            s0.n(GroupLocationCustomActivity.this, 2131953328);
          } else {
            GroupLocationCustomActivity.e1(GroupLocationCustomActivity.this);
          }
        }
        else
        {
          if (parami.a() != null)
          {
            Intent localIntent = new Intent();
            localIntent.putExtra("extra_new_custom_room_id", ((RoomBean)parami.a()).getRoomId());
            GroupLocationCustomActivity.this.setResult(-1, localIntent);
          }
          GroupLocationCustomActivity.this.finish();
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
        paramEditable.delete(GroupLocationCustomActivity.f1(GroupLocationCustomActivity.this).length() - 1, GroupLocationCustomActivity.f1(GroupLocationCustomActivity.this).length());
        GroupLocationCustomActivity.h1(GroupLocationCustomActivity.this).setText(paramEditable);
        GroupLocationCustomActivity.h1(GroupLocationCustomActivity.this).setSelection(paramEditable.length());
      }
      if (GroupLocationCustomActivity.i1(GroupLocationCustomActivity.this) != null) {
        GroupLocationCustomActivity.i1(GroupLocationCustomActivity.this).setEnabled(TextUtils.isEmpty(paramEditable) ^ true);
      }
      if (!GroupLocationCustomActivity.j1(GroupLocationCustomActivity.this)) {
        GroupLocationCustomActivity.l1(GroupLocationCustomActivity.this).d();
      } else {
        GroupLocationCustomActivity.k1(GroupLocationCustomActivity.this, false);
      }
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      GroupLocationCustomActivity.g1(GroupLocationCustomActivity.this, paramCharSequence);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\group\info\GroupLocationCustomActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */