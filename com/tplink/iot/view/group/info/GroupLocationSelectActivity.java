package com.tplink.iot.view.group.info;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.adapter.group.GroupRoomLocationAdapter;
import com.tplink.iot.adapter.quicksetup.f;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.family.common.RoomInfo;
import com.tplink.iot.core.o;
import com.tplink.iot.viewmodel.group.GroupLocationViewModel;
import java.util.List;

public class GroupLocationSelectActivity
  extends BaseActivity
{
  private GroupLocationViewModel H3;
  private MenuItem I3;
  private GroupRoomLocationAdapter J3;
  private boolean p0 = false;
  private List<RoomInfo> p1;
  private String p2;
  private int p3 = 0;
  private String y;
  private String z;
  
  private boolean k1()
  {
    List localList = this.p1;
    return (localList != null) && (!localList.isEmpty()) && ((TextUtils.isEmpty(this.p2)) || (this.p3 >= this.p1.size()) || (!this.p2.equals(((RoomInfo)this.p1.get(this.p3)).getId())));
  }
  
  private void l1()
  {
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      this.y = localIntent.getStringExtra("group_id");
      this.z = localIntent.getStringExtra("room_id");
      this.p0 = (TextUtils.isEmpty(this.y) ^ true);
    }
  }
  
  private void m1()
  {
    if (this.J3.p() >= 32) {
      v1();
    } else {
      GroupLocationCustomActivity.p1(this, 111);
    }
  }
  
  private void n1()
  {
    this.p1 = this.H3.j();
    if (this.p0) {
      this.p2 = this.H3.k(this.y);
    } else {
      this.p2 = this.z;
    }
    if (!TextUtils.isEmpty(this.p2))
    {
      Object localObject = this.p1;
      if ((localObject != null) && (!((List)localObject).isEmpty())) {
        for (int i = 0; i < this.p1.size(); i++)
        {
          localObject = (RoomInfo)this.p1.get(i);
          if (this.p2.equals(((RoomInfo)localObject).getId()))
          {
            this.p3 = i;
            break;
          }
        }
      }
    }
  }
  
  private void o1()
  {
    b1(2131953794);
    RecyclerView localRecyclerView = (RecyclerView)findViewById(2131363820);
    localRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    GroupRoomLocationAdapter localGroupRoomLocationAdapter = new GroupRoomLocationAdapter(this, this.p1, this.p3);
    this.J3 = localGroupRoomLocationAdapter;
    localRecyclerView.setAdapter(localGroupRoomLocationAdapter);
    this.J3.q(new a());
  }
  
  public static void p1(Activity paramActivity, int paramInt, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, GroupLocationSelectActivity.class);
    localIntent.putExtra("room_id", paramString);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  public static void q1(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, GroupLocationSelectActivity.class);
    localIntent.putExtra("group_id", paramString);
    paramContext.startActivity(localIntent);
  }
  
  private void r1()
  {
    s0.p(this, getString(2131952444));
  }
  
  private void s1()
  {
    if (this.p0) {
      u1();
    } else {
      t1();
    }
  }
  
  private void t1()
  {
    Object localObject = this.p1;
    if (localObject != null) {
      localObject = ((RoomInfo)((List)localObject).get(this.p3)).getName();
    } else {
      localObject = null;
    }
    String str = this.H3.l((String)localObject);
    Intent localIntent = getIntent();
    localIntent.putExtra("room_id", str);
    localIntent.putExtra("room_name", (String)localObject);
    setResult(-1, localIntent);
    finish();
  }
  
  private void u1()
  {
    Object localObject = this.p1;
    if (localObject != null) {
      localObject = ((RoomInfo)((List)localObject).get(this.p3)).getName();
    } else {
      localObject = null;
    }
    s0.l(this);
    this.H3.n(this.y, (String)localObject);
  }
  
  private void v1()
  {
    new TPMaterialDialogV2.Builder(this).j(getString(2131953671, new Object[] { Integer.valueOf(32) })).o(2131951761, 2131099808, null).g(8, 8).b(false).c(false).a().show();
  }
  
  private void w1()
  {
    this.H3.m().observe(this, new b());
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 111) && (paramIntent != null))
    {
      paramIntent = paramIntent.getStringExtra("extra_new_custom_room_id");
      this.p1 = this.H3.j();
      this.J3.notifyDataSetChanged();
      if (!TextUtils.isEmpty(paramIntent))
      {
        List localList = this.p1;
        if ((localList != null) && (!localList.isEmpty())) {
          for (paramInt1 = 0; paramInt1 < this.p1.size(); paramInt1++) {
            if (paramIntent.equals(((RoomInfo)this.p1.get(paramInt1)).getId()))
            {
              this.p3 = paramInt1;
              if (!TextUtils.equals(this.p2, paramIntent))
              {
                paramIntent = this.I3;
                if (paramIntent != null) {
                  paramIntent.setEnabled(k1());
                }
              }
              this.J3.r(this.p3);
              break;
            }
          }
        }
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558532);
    this.H3 = ((GroupLocationViewModel)ViewModelProviders.of(this).get(GroupLocationViewModel.class));
    l1();
    n1();
    o1();
    w1();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623941, paramMenu);
    MenuItem localMenuItem = paramMenu.findItem(2131362300);
    this.I3 = localMenuItem;
    localMenuItem.setEnabled(k1());
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131362300) {
      s1();
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  class a
    implements f
  {
    a() {}
    
    public void a(View paramView, int paramInt)
    {
      if ((GroupLocationSelectActivity.e1(GroupLocationSelectActivity.this) != null) && (!GroupLocationSelectActivity.e1(GroupLocationSelectActivity.this).isEmpty()) && (paramInt < GroupLocationSelectActivity.e1(GroupLocationSelectActivity.this).size()))
      {
        GroupLocationSelectActivity.f1(GroupLocationSelectActivity.this, paramInt);
        if (GroupLocationSelectActivity.g1(GroupLocationSelectActivity.this) != null) {
          GroupLocationSelectActivity.g1(GroupLocationSelectActivity.this).setEnabled(GroupLocationSelectActivity.h1(GroupLocationSelectActivity.this));
        }
      }
      else
      {
        GroupLocationSelectActivity.i1(GroupLocationSelectActivity.this);
      }
    }
  }
  
  class b
    implements Observer<Boolean>
  {
    b() {}
    
    public void a(@Nullable Boolean paramBoolean)
    {
      if ((paramBoolean != null) && (paramBoolean.booleanValue()))
      {
        s0.g();
        GroupLocationSelectActivity.this.finish();
      }
      else
      {
        s0.g();
        GroupLocationSelectActivity.j1(GroupLocationSelectActivity.this);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\group\info\GroupLocationSelectActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */