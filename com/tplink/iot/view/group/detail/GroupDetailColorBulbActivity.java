package com.tplink.iot.view.group.detail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.Utils.k;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.x0.i;
import com.tplink.iot.Utils.z0.o;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.base.LocationPrepareActivity;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.iot.view.colorbulb.EditAutoDialog;
import com.tplink.iot.view.colorbulb.EditAutoDialog.a;
import com.tplink.iot.view.colorbulb.EditColorBulbPresetDialog;
import com.tplink.iot.view.colorbulb.EditColorBulbPresetDialog.b;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.viewmodel.group.GroupDetailViewModel;
import com.tplink.iot.widget.BulbPresetsView;
import com.tplink.iot.widget.BulbPresetsView.c;
import com.tplink.iot.widget.colorbulb.ColorPresetView;
import com.tplink.iot.widget.colorbulb.ColorPresetView.a;
import com.tplink.iot.widget.colorbulb.SimpleTextSwitcher;
import com.tplink.iot.widget.colorbulb.light.LightBgAnimView;
import com.tplink.iot.widget.colorbulb.light.LightBulbView;
import com.tplink.iot.widget.colorbulb.light.LightBulbView.d;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat.a;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.AutoLightBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.EditPresetRule;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.yinglan.scrolllayout.ScrollLayout;
import com.yinglan.scrolllayout.ScrollLayout.Status;
import com.yinglan.scrolllayout.ScrollLayout.g;
import java.util.List;

public class GroupDetailColorBulbActivity
  extends BaseActivity
  implements View.OnClickListener, LightBulbView.d, EditColorBulbPresetDialog.b, EditAutoDialog.a
{
  private TextView H3;
  private SimpleTextSwitcher I3;
  private LightBulbView J3;
  private BulbPresetsView K3;
  private ColorPresetView L3;
  private View M3;
  private TPSwitchCompat N3;
  private ScrollLayout O3;
  private View P3;
  private View Q3;
  private String R3;
  private GroupDetailViewModel S3;
  private EditColorBulbPresetDialog T3 = null;
  private EditAutoDialog U3 = null;
  private GroupDetailDeviceListFragment V3;
  private GroupInfo W3;
  private List<String> X3;
  private ColorPresetView.a Y3 = new f();
  private ImageView p0;
  private CardView p1;
  private TextView p2;
  private TextView p3;
  private ImageView y;
  private ImageView z;
  
  private void A1()
  {
    if (getSupportFragmentManager().findFragmentByTag("EditAutoDialog") != null) {
      return;
    }
    EditAutoDialog localEditAutoDialog = EditAutoDialog.G0(s1());
    this.U3 = localEditAutoDialog;
    localEditAutoDialog.show(getSupportFragmentManager(), null);
    this.U3.I0(this);
  }
  
  private void B1(int paramInt, LightStateBean paramLightStateBean)
  {
    if (getSupportFragmentManager().findFragmentByTag("EditColorBulbPresetDialog") != null) {
      return;
    }
    paramLightStateBean = EditColorBulbPresetDialog.I0(true, paramInt, paramLightStateBean);
    this.T3 = paramLightStateBean;
    paramLightStateBean.show(getSupportFragmentManager(), "EditColorBulbPresetDialog");
    this.T3.J0(this);
  }
  
  private void C1()
  {
    this.y.setImageResource(2131689849);
    this.z.setImageDrawable(getResources().getDrawable(2131689837));
    this.p2.setTextColor(getResources().getColor(2131100206));
    this.p3.setTextColor(getResources().getColor(2131100206));
    this.p3.setCompoundDrawablesRelativeWithIntrinsicBounds(ResourcesCompat.getDrawable(getResources(), 2131689785, null), null, null, null);
  }
  
  private void D1()
  {
    this.y.setImageResource(2131689776);
    this.z.setImageDrawable(getResources().getDrawable(2131689835));
    this.p2.setTextColor(getResources().getColor(2131099799));
    this.p3.setTextColor(getResources().getColor(2131099799));
    this.p3.setCompoundDrawablesRelativeWithIntrinsicBounds(ResourcesCompat.getDrawable(getResources(), 2131689784, null), null, null, null);
  }
  
  private void E1()
  {
    new TPMaterialDialogV2.Builder(this).j(getString(2131953797)).b(false).c(false).l(2131951763, 2131099804, null).o(2131951767, 2131099808, new g()).g(8, 8).a().show();
  }
  
  private void F1()
  {
    this.S3.p().observe(this, new d());
    this.S3.t().observe(this, new e());
  }
  
  private void G1()
  {
    Object localObject = this.W3;
    if (localObject == null) {
      return;
    }
    this.p2.setText(o.d(this, ((GroupInfo)localObject).getName()));
    localObject = o.a(this.W3);
    boolean bool = TextUtils.isEmpty((CharSequence)localObject);
    int i = 8;
    if (bool)
    {
      this.p3.setVisibility(8);
    }
    else
    {
      this.p3.setVisibility(0);
      this.p3.setText((CharSequence)localObject);
    }
    localObject = this.N3;
    if (this.W3.getCommon() == null) {
      bool = false;
    } else {
      bool = this.W3.getCommon().booleanValue();
    }
    ((TPSwitchCompat)localObject).setChecked(bool);
    int j = this.S3.m(this.W3);
    this.H3.setText(String.valueOf(j));
    this.N3.setEnabled(true);
    this.Q3.setAlpha(1.0F);
    this.p2.setEnabled(true);
    this.p3.setEnabled(true);
    this.P3.setEnabled(true);
    this.P3.setAlpha(1.0F);
    localObject = this.p1;
    if (com.tplink.libtpnetwork.Utils.g.l(this.W3)) {
      i = 0;
    }
    ((FrameLayout)localObject).setVisibility(i);
  }
  
  private void H1()
  {
    if (this.W3 == null) {
      return;
    }
    List localList;
    if (w1())
    {
      localList = com.tplink.libtpnetwork.Utils.g.f(this.W3);
      this.L3.setColorPresets(localList);
      this.M3.setVisibility(0);
      this.K3.setVisibility(8);
    }
    else
    {
      localList = com.tplink.libtpnetwork.Utils.g.c(this.W3);
      this.K3.setPresets(localList);
      this.K3.setVisibility(0);
      this.M3.setVisibility(8);
    }
  }
  
  private void I1()
  {
    if (this.W3 != null)
    {
      int i;
      if (w1()) {
        i = com.tplink.libtpnetwork.Utils.g.e(this.W3);
      } else {
        i = com.tplink.iot.Utils.z0.g.g();
      }
      this.J3.r(com.tplink.libtpnetwork.Utils.g.k(this.W3), com.tplink.libtpnetwork.Utils.g.b(this.W3), i);
      if (com.tplink.libtpnetwork.Utils.g.k(this.W3)) {
        D1();
      } else {
        C1();
      }
    }
  }
  
  private void o1()
  {
    Object localObject = this.W3;
    if (localObject == null) {
      return;
    }
    localObject = this.S3.s((GroupInfo)localObject);
    this.X3 = ((List)localObject);
    if ((localObject != null) && (!((List)localObject).isEmpty())) {
      E1();
    } else {
      q1();
    }
  }
  
  private String s1()
  {
    return com.tplink.libtpnetwork.Utils.g.h(this.W3);
  }
  
  private void t1()
  {
    FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
    if (this.V3 == null) {
      this.V3 = GroupDetailDeviceListFragment.V1(this.R3);
    }
    if (this.V3.isAdded()) {
      localFragmentTransaction.show(this.V3);
    } else {
      localFragmentTransaction.add(2131363330, this.V3, "Group_Device_List");
    }
    localFragmentTransaction.commitAllowingStateLoss();
  }
  
  private void u1()
  {
    this.L3.setOnColorPresetCheckedListener(this.Y3);
    this.K3.setOnPresetItemCheckListener(new b());
    this.N3.setOnSwitchCheckedChangeListener(new c());
  }
  
  private void v1()
  {
    LightBgAnimView localLightBgAnimView = (LightBgAnimView)findViewById(2131362281);
    this.y = ((ImageView)findViewById(2131363002));
    this.z = ((ImageView)findViewById(2131363121));
    this.p2 = ((TextView)findViewById(2131364536));
    Object localObject = (CardView)findViewById(2131362194);
    this.p1 = ((CardView)localObject);
    ((FrameLayout)localObject).setVisibility(8);
    this.p3 = ((TextView)findViewById(2131364515));
    this.I3 = ((SimpleTextSwitcher)findViewById(2131364199));
    this.J3 = ((LightBulbView)findViewById(2131362157));
    localObject = findViewById(2131362672);
    this.K3 = ((BulbPresetsView)findViewById(2131363851));
    this.L3 = ((ColorPresetView)findViewById(2131362292));
    this.M3 = findViewById(2131362291);
    View localView = findViewById(2131363330);
    this.N3 = ((TPSwitchCompat)findViewById(2131364126));
    this.O3 = ((ScrollLayout)findViewById(2131363972));
    this.Q3 = findViewById(2131363879);
    this.P3 = findViewById(2131362919);
    this.H3 = ((TextView)findViewById(2131364573));
    this.p0 = ((ImageView)findViewById(2131363103));
    t1();
    this.J3.m(localLightBgAnimView, (View)localObject, this.I3);
    this.O3.setMinOffset(k.a(this, 50.0F) + d.A(this));
    this.O3.setOnScrollChangedListener(new a());
    localView.post(new a(this));
    this.J3.setOnBulbOperationListener(this);
    this.y.setOnClickListener(this);
    this.z.setOnClickListener(this);
    findViewById(2131363103).setOnClickListener(this);
    this.P3.setOnClickListener(this);
    u1();
  }
  
  private boolean w1()
  {
    return o.f(this.W3);
  }
  
  public static void z1(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, GroupDetailColorBulbActivity.class);
    localIntent.putExtra("group_id", paramString);
    paramContext.startActivity(localIntent);
  }
  
  public void J(int paramInt, boolean paramBoolean)
  {
    this.S3.z(this.R3, paramInt);
  }
  
  public void J0(String paramString)
  {
    this.S3.y(this.R3, new AutoLightBean(true, paramString));
  }
  
  public void L(int paramInt)
  {
    this.I3.a(true, paramInt, false);
  }
  
  public void U(LightStateBean paramLightStateBean)
  {
    this.S3.G(this.R3, paramLightStateBean);
  }
  
  public void g(int paramInt, LightStateBean paramLightStateBean)
  {
    EditPresetRule localEditPresetRule = new EditPresetRule();
    localEditPresetRule.setIndex(paramInt);
    localEditPresetRule.setState(paramLightStateBean);
    this.S3.k(this.W3, localEditPresetRule);
    this.S3.G(this.R3, paramLightStateBean);
  }
  
  public void h(LightStateBean paramLightStateBean) {}
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 200) && (com.tplink.iot.view.quicksetup.base.f.a.a(this))) {
      r1();
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131363121: 
      GroupBulbSettingsActivity.l1(this, this.R3);
      break;
    case 2131363103: 
      if (this.O3.getCurrentStatus() == ScrollLayout.Status.CLOSED) {
        this.O3.o();
      } else if (this.O3.getCurrentStatus() == ScrollLayout.Status.OPENED) {
        this.O3.m();
      }
      break;
    case 2131363002: 
      onBackPressed();
      break;
    case 2131362919: 
      GroupEditDeviceListActivity.q1(this, this.R3);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558529);
    d.J(this, findViewById(2131363353));
    this.R3 = getIntent().getStringExtra("group_id");
    this.S3 = ((GroupDetailViewModel)ViewModelProviders.of(this).get(GroupDetailViewModel.class));
    v1();
    F1();
    i.s();
  }
  
  protected void onDestroy()
  {
    LightBulbView localLightBulbView = this.J3;
    if (localLightBulbView != null) {
      localLightBulbView.p();
    }
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.S3.n(this.R3);
  }
  
  public void p1()
  {
    if (!com.tplink.iot.view.quicksetup.base.f.a.a(this)) {
      startActivityForResult(new Intent(this, LocationPrepareActivity.class), 200);
    } else {
      r1();
    }
  }
  
  public void q1()
  {
    this.L3.d();
    this.S3.y(this.R3, new AutoLightBean(true, s1()));
    A1();
  }
  
  public void r1()
  {
    List localList = this.X3;
    if ((localList != null) && (!localList.isEmpty()))
    {
      s0.l(this);
      this.S3.C(this.X3, new AutoLightBean(true, s1()));
    }
  }
  
  public void w0(boolean paramBoolean)
  {
    this.S3.E(this.R3, paramBoolean);
  }
  
  class a
    implements ScrollLayout.g
  {
    a() {}
    
    public void a(ScrollLayout.Status paramStatus)
    {
      if (paramStatus == ScrollLayout.Status.OPENED) {
        GroupDetailColorBulbActivity.e1(GroupDetailColorBulbActivity.this).setImageResource(2131689831);
      } else if (paramStatus == ScrollLayout.Status.CLOSED) {
        GroupDetailColorBulbActivity.e1(GroupDetailColorBulbActivity.this).setImageResource(2131689830);
      }
    }
    
    public void b(float paramFloat) {}
    
    public void c(int paramInt) {}
  }
  
  class b
    implements BulbPresetsView.c
  {
    b() {}
    
    public void a(int paramInt)
    {
      GroupDetailColorBulbActivity.this.J(paramInt, false);
    }
  }
  
  class c
    implements TPSwitchCompat.a
  {
    c() {}
    
    public void c(CompoundButton paramCompoundButton, boolean paramBoolean1, boolean paramBoolean2)
    {
      if (paramBoolean2) {
        GroupDetailColorBulbActivity.g1(GroupDetailColorBulbActivity.this).h(GroupDetailColorBulbActivity.f1(GroupDetailColorBulbActivity.this), paramBoolean1);
      }
    }
  }
  
  class d
    implements Observer<List<GroupInfo>>
  {
    d() {}
    
    public void a(List<GroupInfo> paramList)
    {
      paramList = GroupDetailColorBulbActivity.g1(GroupDetailColorBulbActivity.this).o(paramList, GroupDetailColorBulbActivity.f1(GroupDetailColorBulbActivity.this));
      if (paramList != null)
      {
        GroupDetailColorBulbActivity.h1(GroupDetailColorBulbActivity.this, paramList);
        GroupDetailColorBulbActivity.i1(GroupDetailColorBulbActivity.this);
        GroupDetailColorBulbActivity.j1(GroupDetailColorBulbActivity.this);
        GroupDetailColorBulbActivity.k1(GroupDetailColorBulbActivity.this);
      }
    }
  }
  
  class e
    implements Observer<Integer>
  {
    e() {}
    
    public void a(@Nullable Integer paramInteger)
    {
      if ((paramInteger != null) && (paramInteger.intValue() == 0))
      {
        s0.g();
        GroupDetailColorBulbActivity.this.q1();
      }
      else if ((paramInteger != null) && (paramInteger.intValue() == 30))
      {
        s0.g();
        s0.s(GroupDetailColorBulbActivity.this, 2131952742);
      }
      else
      {
        s0.g();
        s0.n(GroupDetailColorBulbActivity.this, 2131953328);
      }
    }
  }
  
  class f
    implements ColorPresetView.a
  {
    f() {}
    
    public void a(int paramInt, LightStateBean paramLightStateBean)
    {
      GroupDetailColorBulbActivity.g1(GroupDetailColorBulbActivity.this).G(GroupDetailColorBulbActivity.f1(GroupDetailColorBulbActivity.this), paramLightStateBean);
    }
    
    public void b()
    {
      GroupDetailColorBulbActivity.n1(GroupDetailColorBulbActivity.this);
    }
    
    public void c(int paramInt1, int paramInt2, LightStateBean paramLightStateBean)
    {
      GroupDetailColorBulbActivity.l1(GroupDetailColorBulbActivity.this, paramInt1, paramLightStateBean);
    }
    
    public void d()
    {
      GroupDetailColorBulbActivity.m1(GroupDetailColorBulbActivity.this);
    }
  }
  
  class g
    implements TPMaterialDialogV2.d
  {
    g() {}
    
    public void onClick(View paramView)
    {
      GroupDetailColorBulbActivity.this.p1();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\group\detail\GroupDetailColorBulbActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */