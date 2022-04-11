package com.tplink.iot.view.colorbulb.effect;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.thing.common.ThingRuleLightEffect;
import com.tplink.iot.viewmodel.iotbulb.LightEffectViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.widget.BrightnessSeekBar;
import com.tplink.iot.widget.ItemSettingLayout;
import com.tplink.iot.widget.colorbulb.ColorLightEffectView;
import com.tplink.iot.widget.dialog.LightEffectShiftStyleDialog;
import com.tplink.iot.widget.dialog.LightEffectShiftStyleDialog.a;
import com.tplink.iot.widget.dialog.LightEffectTimeDialog;
import com.tplink.iot.widget.dialog.LightEffectTimeDialog.a;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightEffectRuleBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.enumerate.RuleLightEffectChangeMode;
import java.util.Iterator;
import java.util.List;

public class LightEffectConfigActivity
  extends BaseActivity
  implements View.OnClickListener, LightEffectTimeDialog.a, LightEffectShiftStyleDialog.a
{
  private LightEffectTimeDialog H3 = null;
  private BrightnessSeekBar I3;
  private String J3;
  private LightEffectViewModel K3;
  private long L3 = 1L;
  private RuleLightEffectChangeMode M3 = RuleLightEffectChangeMode.MODE_DIRECT;
  private String N3;
  private LightEffectRuleBean O3;
  private ItemSettingLayout p0;
  private ImageView p1;
  private ColorLightEffectView p2;
  private LightEffectShiftStyleDialog p3;
  private ItemSettingLayout y;
  private ItemSettingLayout z;
  
  private LightEffectRuleBean f1()
  {
    LightEffectRuleBean localLightEffectRuleBean = new LightEffectRuleBean();
    localLightEffectRuleBean.setSceneName(this.N3);
    Object localObject1 = this.M3;
    Object localObject2 = RuleLightEffectChangeMode.MODE_DIRECT;
    if (localObject1 == localObject2) {
      localObject1 = ((RuleLightEffectChangeMode)localObject2).getName();
    } else {
      localObject1 = RuleLightEffectChangeMode.MODE_BLN.getName();
    }
    localLightEffectRuleBean.setChangeMode((String)localObject1);
    localLightEffectRuleBean.setChangeTime(this.L3 * 1000L);
    int i = this.I3.getProgress();
    localObject1 = this.p2.getColorStatusList();
    localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((LightStateBean)((Iterator)localObject2).next()).setBrightness(i);
    }
    localLightEffectRuleBean.setStatusList((List)localObject1);
    localLightEffectRuleBean.setId(this.J3);
    return localLightEffectRuleBean;
  }
  
  private void g1()
  {
    this.K3.a.observe(this, new c(this));
    this.K3.b.observe(this, new a(this));
    this.K3.c.observe(this, new b(this));
  }
  
  private void h1()
  {
    this.p1 = ((ImageView)findViewById(2131363961));
    this.y = ((ItemSettingLayout)findViewById(2131362936));
    this.z = ((ItemSettingLayout)findViewById(2131362961));
    this.p0 = ((ItemSettingLayout)findViewById(2131362967));
    Object localObject = (ColorLightEffectView)findViewById(2131363229);
    this.p2 = ((ColorLightEffectView)localObject);
    ((ColorLightEffectView)localObject).setFragmentManager(getSupportFragmentManager());
    this.I3 = ((BrightnessSeekBar)findViewById(2131362027));
    this.y.setOnClickListener(this);
    this.z.setOnClickListener(this);
    this.p0.setOnClickListener(this);
    localObject = this.O3;
    if (localObject != null)
    {
      localObject = ((ThingRuleLightEffect)localObject).getSceneName();
      this.N3 = ((String)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.y.setItemInfo(this.N3);
      } else {
        this.y.setItemInfo(this.K3.j(this.J3));
      }
      if (this.O3.getChangeMode() != null) {
        this.M3 = RuleLightEffectChangeMode.fromString(this.O3.getChangeMode());
      }
      localObject = this.z;
      final int i;
      if (this.M3 == RuleLightEffectChangeMode.MODE_DIRECT) {
        i = 2131953720;
      } else {
        i = 2131953719;
      }
      ((ItemSettingLayout)localObject).setItemInfo(getString(i));
      this.L3 = (this.O3.getChangeTime() / 1000L);
      ItemSettingLayout localItemSettingLayout = this.p0;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.L3);
      ((StringBuilder)localObject).append(getString(2131953396));
      localItemSettingLayout.setItemInfo(((StringBuilder)localObject).toString());
      localObject = this.O3.getStatusList();
      this.p2.setLightEffectList((List)localObject);
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        i = ((LightStateBean)((List)localObject).get(0)).getBrightness();
        this.I3.post(new a(i));
      }
    }
  }
  
  public static void o1(Activity paramActivity, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(paramActivity, LightEffectConfigActivity.class);
    localIntent.putExtra("device_id_md5", paramString1);
    localIntent.putExtra("rule_id", paramString2);
    paramActivity.startActivity(localIntent);
  }
  
  private void p1(int paramInt)
  {
    LightEffectShiftStyleDialog localLightEffectShiftStyleDialog = this.p3;
    if ((localLightEffectShiftStyleDialog != null) && (localLightEffectShiftStyleDialog.isVisible())) {
      return;
    }
    localLightEffectShiftStyleDialog = LightEffectShiftStyleDialog.A0(paramInt);
    this.p3 = localLightEffectShiftStyleDialog;
    localLightEffectShiftStyleDialog.B0(this);
    this.p3.show(getSupportFragmentManager(), null);
  }
  
  private void q1(long paramLong)
  {
    LightEffectTimeDialog localLightEffectTimeDialog = this.H3;
    if ((localLightEffectTimeDialog != null) && (localLightEffectTimeDialog.isVisible())) {
      return;
    }
    localLightEffectTimeDialog = LightEffectTimeDialog.A0(paramLong);
    this.H3 = localLightEffectTimeDialog;
    localLightEffectTimeDialog.B0(this);
    this.H3.show(getSupportFragmentManager(), null);
  }
  
  public void j0(int paramInt)
  {
    this.L3 = paramInt;
    ItemSettingLayout localItemSettingLayout = this.p0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.L3);
    localStringBuilder.append(getString(2131953396));
    localItemSettingLayout.setItemInfo(localStringBuilder.toString());
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramIntent != null) && (paramInt1 == 102))
    {
      paramIntent = paramIntent.getStringExtra("name");
      this.N3 = paramIntent;
      this.y.setItemInfo(paramIntent);
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362936)
    {
      if (i != 2131362961)
      {
        if (i == 2131362967) {
          q1(this.L3);
        }
      }
      else
      {
        if (this.M3 == RuleLightEffectChangeMode.MODE_DIRECT) {
          i = 0;
        } else {
          i = 1;
        }
        p1(i);
      }
    }
    else {
      LightEffectNameEditActivity.e1(this, this.N3, 102);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558560);
    this.K3 = ((LightEffectViewModel)ViewModelProviders.of(this, new IoTViewModelFactory(this, getIntent().getStringExtra("device_id_md5"))).get(LightEffectViewModel.class));
    paramBundle = getIntent().getStringExtra("rule_id");
    this.J3 = paramBundle;
    this.O3 = this.K3.i(paramBundle);
    b1(2131953701);
    h1();
    g1();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623941, paramMenu);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131362300) {
      this.K3.g(f1());
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public void u0(int paramInt)
  {
    if (paramInt == 0) {
      localObject = RuleLightEffectChangeMode.MODE_DIRECT;
    } else {
      localObject = RuleLightEffectChangeMode.MODE_BLN;
    }
    this.M3 = ((RuleLightEffectChangeMode)localObject);
    Object localObject = this.z;
    if (paramInt == 0) {
      paramInt = 2131953720;
    } else {
      paramInt = 2131953719;
    }
    ((ItemSettingLayout)localObject).setItemInfo(getString(paramInt));
  }
  
  class a
    implements Runnable
  {
    a(int paramInt) {}
    
    public void run()
    {
      LightEffectConfigActivity.e1(LightEffectConfigActivity.this).setProgress(i);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\colorbulb\effect\LightEffectConfigActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */