package com.tplink.iot.view.iothub.guardmode;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentManager.OnBackStackChangedListener;
import androidx.fragment.app.FragmentTransaction;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.base.BaseActivity;
import com.tplink.libtpnetwork.enumerate.EnumGuardMode;
import com.tplink.libtpnetwork.enumerate.EnumGuardMode.a;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class GuardModeConfigActivity
  extends BaseActivity
{
  public static final a y = new a(null);
  private String p0 = "";
  private final GuardModeConfigFragment p1 = new GuardModeConfigFragment();
  private EnumGuardMode p2 = EnumGuardMode.HOME;
  private String z = "";
  
  private final int h1(EnumGuardMode paramEnumGuardMode)
  {
    int i = a.a[paramEnumGuardMode.ordinal()];
    int j = 2131951888;
    int k = j;
    if (i != 1) {
      if (i != 2)
      {
        if (i != 3) {
          k = j;
        } else {
          k = 2131952805;
        }
      }
      else {
        k = 2131951868;
      }
    }
    return k;
  }
  
  private final void j1()
  {
    Object localObject1 = EnumGuardMode.Companion;
    Object localObject2 = getIntent();
    String str = "";
    if (localObject2 != null)
    {
      localObject2 = ((Intent)localObject2).getStringExtra("GuardMode");
      if (localObject2 != null) {}
    }
    else
    {
      localObject2 = "";
    }
    this.p2 = ((EnumGuardMode.a)localObject1).a((String)localObject2);
    localObject1 = getIntent();
    localObject2 = str;
    if (localObject1 != null)
    {
      localObject1 = ((Intent)localObject1).getStringExtra("device_id_md5");
      localObject2 = str;
      if (localObject1 != null) {
        localObject2 = localObject1;
      }
    }
    this.z = ((String)localObject2);
  }
  
  private final void k1()
  {
    int i = h1(this.p2);
    Object localObject = getResources().getString(i);
    j.d(localObject, "resources.getString(it)");
    this.p0 = ((String)localObject);
    localObject = p.a;
    b1(i);
    localObject = getSupportFragmentManager();
    GuardModeConfigFragment localGuardModeConfigFragment = this.p1;
    Bundle localBundle = new Bundle();
    localBundle.putString("device_id_md5", this.z);
    localGuardModeConfigFragment.setArguments(localBundle);
    ((FragmentManager)localObject).beginTransaction().add(2131362309, this.p1).commit();
    ((FragmentManager)localObject).addOnBackStackChangedListener(new b(this));
  }
  
  private final void l1()
  {
    new TPMaterialDialogV2.Builder(this).j(getString(2131953991)).l(2131952391, 2131099804, null).o(2131952432, 2131099808, new c(this)).g(8, 8).b(false).c(false).a().show();
  }
  
  public final EnumGuardMode g1()
  {
    return this.p2;
  }
  
  public final void i1(String paramString)
  {
    j.e(paramString, "tag");
    Object localObject1 = getSupportFragmentManager().findFragmentByTag(paramString);
    if (localObject1 == null)
    {
      switch (paramString.hashCode())
      {
      default: 
        break;
      case 512223062: 
        if (paramString.equals("AddTriggerDevicesFragment")) {
          localObject1 = new AddTriggerDevicesFragment();
        }
        break;
      case 170434681: 
        if (paramString.equals("SetAlarmTypeFragment")) {
          localObject1 = new SetAlarmTypeFragment();
        }
        break;
      case -553574132: 
        if (paramString.equals("SetAlarmTimeFragment")) {
          localObject1 = new SetAlarmTimeFragment();
        }
        break;
      case -1323229031: 
        if (paramString.equals("SetAlarmVolumeFragment")) {
          localObject1 = new SetAlarmVolumeFragment();
        }
        break;
      }
      localObject1 = null;
    }
    if (localObject1 != null)
    {
      Object localObject2 = new Bundle();
      ((Bundle)localObject2).putString("device_id_md5", this.z);
      p localp = p.a;
      ((Fragment)localObject1).setArguments((Bundle)localObject2);
      localObject2 = getSupportFragmentManager().beginTransaction();
      ((FragmentTransaction)localObject2).setCustomAnimations(2130772040, 2130772043, 2130772039, 2130772044);
      ((FragmentTransaction)localObject2).hide(this.p1);
      if (((Fragment)localObject1).isAdded()) {
        ((FragmentTransaction)localObject2).show((Fragment)localObject1);
      } else {
        ((FragmentTransaction)localObject2).add(2131362309, (Fragment)localObject1, paramString);
      }
      ((FragmentTransaction)localObject2).addToBackStack(paramString);
      ((FragmentTransaction)localObject2).commit();
    }
  }
  
  public void onBackPressed()
  {
    FragmentManager localFragmentManager = getSupportFragmentManager();
    j.d(localFragmentManager, "supportFragmentManager");
    if (localFragmentManager.getBackStackEntryCount() > 0) {
      getSupportFragmentManager().popBackStack();
    } else if ((this.p1.isVisible()) && (this.p1.a1())) {
      l1();
    } else {
      super.onBackPressed();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558536);
    j1();
    k1();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    j.e(paramMenuItem, "item");
    boolean bool;
    if (paramMenuItem.getItemId() != 16908332)
    {
      bool = super.onOptionsItemSelected(paramMenuItem);
    }
    else
    {
      onBackPressed();
      bool = true;
    }
    return bool;
  }
  
  public static final class a
  {
    public final Intent a(Context paramContext, String paramString1, String paramString2)
    {
      j.e(paramContext, "context");
      j.e(paramString1, "mode");
      j.e(paramString2, "deviceIdMD5");
      paramContext = new Intent(paramContext, GuardModeConfigActivity.class);
      paramContext.putExtra("GuardMode", paramString1);
      paramContext.putExtra("device_id_md5", paramString2);
      return paramContext;
    }
  }
  
  static final class b
    implements FragmentManager.OnBackStackChangedListener
  {
    b(GuardModeConfigActivity paramGuardModeConfigActivity) {}
    
    public final void onBackStackChanged()
    {
      if (GuardModeConfigActivity.e1(this.a).isVisible())
      {
        GuardModeConfigActivity localGuardModeConfigActivity = this.a;
        localGuardModeConfigActivity.c1(GuardModeConfigActivity.f1(localGuardModeConfigActivity));
      }
    }
  }
  
  static final class c
    implements TPMaterialDialogV2.d
  {
    c(GuardModeConfigActivity paramGuardModeConfigActivity) {}
    
    public final void onClick(View paramView)
    {
      this.a.finish();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\iothub\guardmode\GuardModeConfigActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */