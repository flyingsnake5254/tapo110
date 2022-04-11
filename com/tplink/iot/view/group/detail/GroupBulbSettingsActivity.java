package com.tplink.iot.view.group.detail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.z0.g;
import com.tplink.iot.Utils.z0.o;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.iot.view.group.info.GroupAvatarActivity;
import com.tplink.iot.view.group.info.GroupLocationSelectActivity;
import com.tplink.iot.view.group.info.GroupNameActivity;
import com.tplink.iot.viewmodel.group.GroupSettingViewModel;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.iot.widget.ItemSettingLayout;
import com.tplink.libtpnetwork.enumerate.EnumBulbAvatarType;
import java.util.List;

public class GroupBulbSettingsActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private String H3;
  private ItemSettingLayout p0;
  private View p1;
  private GroupSettingViewModel p2;
  private GroupInfo p3;
  private ImageView y;
  private ItemSettingLayout z;
  
  private void k1()
  {
    c1(getString(2131952789));
    this.y = ((ImageView)findViewById(2131363673));
    this.z = ((ItemSettingLayout)findViewById(2131362936));
    this.p0 = ((ItemSettingLayout)findViewById(2131362930));
    Object localObject = findViewById(2131362891);
    this.p1 = ((View)localObject);
    ((View)localObject).setVisibility(8);
    localObject = (Button)findViewById(2131362097);
    findViewById(2131362888).setOnClickListener(this);
    this.y.setOnClickListener(this);
    this.z.setOnClickListener(this);
    this.p0.setOnClickListener(this);
    ((Button)localObject).setOnClickListener(this);
    this.p1.setOnClickListener(this);
  }
  
  public static void l1(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, GroupBulbSettingsActivity.class);
    localIntent.putExtra("group_id", paramString);
    paramContext.startActivity(localIntent);
  }
  
  private void m1()
  {
    s0.p(this, getString(2131952444));
  }
  
  private void n1()
  {
    s0.l(this);
    this.p2.j(this.H3);
  }
  
  private void o1()
  {
    String str = getString(2131952788);
    new TPMaterialDialogV2.Builder(this).j(str).l(2131952391, 2131099804, null).o(2131952451, 2131099812, new d()).g(8, 8).b(false).c(false).a().show();
  }
  
  private void p1()
  {
    this.p2.o().observe(this, new a());
    this.p2.r().observe(this, new b());
    this.p2.l().observe(this, new c());
  }
  
  private void q1()
  {
    Object localObject = this.p3;
    if (localObject != null)
    {
      this.p0.setItemInfo(o.a((GroupInfo)localObject));
      this.y.setImageResource(g.d(EnumBulbAvatarType.fromString(this.p3.getAvatarUrl())));
      this.z.setItemInfo(o.d(this, this.p3.getName()));
      localObject = this.p1;
      int i;
      if (o.f(this.p3)) {
        i = 8;
      } else {
        i = 0;
      }
      ((View)localObject).setVisibility(i);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131362936: 
      GroupNameActivity.i1(this, this.H3);
      break;
    case 2131362930: 
      GroupLocationSelectActivity.q1(this, this.H3);
      break;
    case 2131362891: 
      GroupBulbBrightnessPresetActivity.j1(this, this.H3);
      break;
    case 2131362888: 
    case 2131363673: 
      GroupAvatarActivity.j1(this, this.H3);
      break;
    case 2131362097: 
      o1();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558527);
    this.H3 = getIntent().getStringExtra("group_id");
    this.p2 = ((GroupSettingViewModel)ViewModelProviders.of(this).get(GroupSettingViewModel.class));
    k1();
    p1();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.p2.m(this.H3);
  }
  
  class a
    implements Observer<List<GroupInfo>>
  {
    a() {}
    
    public void a(List<GroupInfo> paramList)
    {
      paramList = GroupBulbSettingsActivity.f1(GroupBulbSettingsActivity.this).n(paramList, GroupBulbSettingsActivity.e1(GroupBulbSettingsActivity.this));
      if (paramList != null)
      {
        GroupBulbSettingsActivity.g1(GroupBulbSettingsActivity.this, paramList);
        GroupBulbSettingsActivity.h1(GroupBulbSettingsActivity.this);
      }
    }
  }
  
  class b
    implements Observer<i<Void>>
  {
    b() {}
    
    public void a(@Nullable i<Void> parami)
    {
      
      if ((parami != null) && (parami.b() == 0)) {
        GroupBulbSettingsActivity.this.Y0();
      } else {
        GroupBulbSettingsActivity.i1(GroupBulbSettingsActivity.this);
      }
    }
  }
  
  class c
    implements Observer<Boolean>
  {
    c() {}
    
    public void a(Boolean paramBoolean)
    {
      if ((paramBoolean != null) && (paramBoolean.booleanValue()))
      {
        s0.g();
        GroupBulbSettingsActivity.this.Y0();
      }
      else
      {
        s0.g();
        GroupBulbSettingsActivity.i1(GroupBulbSettingsActivity.this);
      }
    }
  }
  
  class d
    implements TPMaterialDialogV2.d
  {
    d() {}
    
    public void onClick(View paramView)
    {
      GroupBulbSettingsActivity.j1(GroupBulbSettingsActivity.this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\group\detail\GroupBulbSettingsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */