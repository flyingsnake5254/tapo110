package com.tplink.iot.devices.featuredactions.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NavigationRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityFeaturedActionHostBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import kotlin.jvm.internal.j;

public final class FeaturedActionHostActivity
  extends IoTMVVMBaseActivity<ActivityFeaturedActionHostBinding>
{
  public static final a p0 = new a(null);
  private String p1 = "";
  private String p2 = "";
  
  @NavigationRes
  private final int n1()
  {
    int i;
    if (EnumDeviceType.fromType(this.p2) == EnumDeviceType.HUB) {
      i = 2131755010;
    } else if (j.a(this.p1, "T100")) {
      i = 2131755011;
    } else if (j.a(this.p1, "T110")) {
      i = 2131755009;
    } else if (j.a(this.p1, "S200B")) {
      i = 2131755008;
    } else {
      i = -1;
    }
    return i;
  }
  
  public static final void o1(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    p0.a(paramContext, paramString1, paramString2, paramString3);
  }
  
  public int e1()
  {
    return 2131558515;
  }
  
  public void h1()
  {
    super.h1();
    Object localObject1 = getIntent();
    String str = "";
    if (localObject1 != null)
    {
      localObject1 = ((Intent)localObject1).getStringExtra("DeviceModel");
      if (localObject1 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    this.p1 = ((String)localObject1);
    Object localObject2 = getIntent();
    localObject1 = str;
    if (localObject2 != null)
    {
      localObject2 = ((Intent)localObject2).getStringExtra("DeviceType");
      localObject1 = str;
      if (localObject2 != null) {
        localObject1 = localObject2;
      }
    }
    this.p2 = ((String)localObject1);
  }
  
  public void j1()
  {
    b1(2131954056);
    Bundle localBundle = new Bundle();
    localBundle.putString("device_id_md5", g1());
    localBundle.putString("DeviceModel", this.p1);
    Fragment localFragment = getSupportFragmentManager().findFragmentById(2131362629);
    Object localObject = localFragment;
    if (!(localFragment instanceof NavHostFragment)) {
      localObject = null;
    }
    localObject = (NavHostFragment)localObject;
    if ((n1() != -1) && (localObject != null))
    {
      localObject = ((NavHostFragment)localObject).getNavController();
      if (localObject != null) {
        ((NavController)localObject).setGraph(n1(), localBundle);
      }
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    j.e(paramMenuItem, "item");
    if (paramMenuItem.getItemId() == 16908332)
    {
      onBackPressed();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public static final class a
  {
    public final void a(Context paramContext, String paramString1, String paramString2, String paramString3)
    {
      j.e(paramContext, "context");
      Intent localIntent = new Intent(paramContext, FeaturedActionHostActivity.class);
      localIntent.putExtra("device_id_md5", paramString1);
      localIntent.putExtra("DeviceType", paramString2);
      localIntent.putExtra("DeviceModel", paramString3);
      paramContext.startActivity(localIntent);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\featuredactions\view\FeaturedActionHostActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */