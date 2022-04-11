package com.tplink.iot.view.group.info;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.adapter.iotbulb.BulbSettingAvatarAdapter;
import com.tplink.iot.adapter.iotbulb.BulbSettingAvatarAdapter.c;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.model.iot.a;
import com.tplink.iot.viewmodel.group.GroupSettingViewModel;
import com.tplink.libtpnetwork.enumerate.EnumBulbAvatarType;
import java.util.ArrayList;
import java.util.List;

public class GroupAvatarActivity
  extends BaseActivity
  implements BulbSettingAvatarAdapter.c
{
  private String H3;
  private MenuItem I3;
  private boolean p0 = false;
  private GroupSettingViewModel p1;
  private List<a> p2 = new ArrayList();
  private BulbSettingAvatarAdapter p3;
  private String y;
  private String z;
  
  private void f1()
  {
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      this.y = localIntent.getStringExtra("group_id");
      this.z = localIntent.getStringExtra("group_avatar");
      this.p0 = (TextUtils.isEmpty(this.y) ^ true);
    }
  }
  
  private void g1()
  {
    b1(2131953793);
    RecyclerView localRecyclerView = (RecyclerView)findViewById(2131363820);
    localRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
    if (this.p0) {
      this.H3 = this.p1.k(this.y);
    } else {
      this.H3 = this.z;
    }
    EnumBulbAvatarType[] arrayOfEnumBulbAvatarType = EnumBulbAvatarType.values();
    int i = arrayOfEnumBulbAvatarType.length;
    int j = 0;
    int m;
    for (int k = 0; j < i; k = m)
    {
      localObject = arrayOfEnumBulbAvatarType[j];
      a locala = new a((EnumBulbAvatarType)localObject, false);
      m = k;
      if (!TextUtils.isEmpty(this.H3))
      {
        m = k;
        if (localObject == EnumBulbAvatarType.fromString(this.H3))
        {
          locala.c(true);
          m = 1;
        }
      }
      this.p2.add(locala);
      j++;
    }
    if (k == 0) {
      ((a)this.p2.get(0)).c(true);
    }
    Object localObject = new BulbSettingAvatarAdapter(this.p2);
    this.p3 = ((BulbSettingAvatarAdapter)localObject);
    ((BulbSettingAvatarAdapter)localObject).t(this);
    localRecyclerView.setAdapter(this.p3);
  }
  
  private boolean h1()
  {
    boolean bool;
    if ((!TextUtils.isEmpty(this.H3)) && (this.H3.equals(this.p3.p().getName()))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static void i1(Activity paramActivity, int paramInt, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, GroupAvatarActivity.class);
    localIntent.putExtra("group_avatar", paramString);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  public static void j1(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, GroupAvatarActivity.class);
    localIntent.putExtra("group_id", paramString);
    paramContext.startActivity(localIntent);
  }
  
  private void k1()
  {
    s0.p(this, getString(2131952444));
  }
  
  private void l1()
  {
    if (this.p0) {
      n1();
    } else {
      m1();
    }
  }
  
  private void m1()
  {
    String str = this.p3.p().getName();
    Intent localIntent = getIntent();
    localIntent.putExtra("group_avatar", str);
    setResult(-1, localIntent);
    finish();
  }
  
  private void n1()
  {
    s0.l(this);
    this.p1.u(this.y, this.p3.p().getName());
  }
  
  private void o1()
  {
    this.p1.s().observe(this, new a());
  }
  
  public void e(int paramInt)
  {
    this.I3.setEnabled(h1());
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558525);
    this.p1 = ((GroupSettingViewModel)ViewModelProviders.of(this).get(GroupSettingViewModel.class));
    f1();
    g1();
    o1();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623941, paramMenu);
    MenuItem localMenuItem = paramMenu.findItem(2131362300);
    this.I3 = localMenuItem;
    localMenuItem.setEnabled(h1());
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131362300) {
      l1();
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  class a
    implements Observer<Boolean>
  {
    a() {}
    
    public void a(Boolean paramBoolean)
    {
      if ((paramBoolean != null) && (paramBoolean.booleanValue()))
      {
        s0.g();
        GroupAvatarActivity.this.finish();
      }
      else
      {
        s0.g();
        GroupAvatarActivity.e1(GroupAvatarActivity.this);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\group\info\GroupAvatarActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */