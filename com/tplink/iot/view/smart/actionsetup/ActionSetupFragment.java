package com.tplink.iot.view.smart.actionsetup;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.d.w.f.a;
import com.bumptech.glide.c;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.n0;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.x0.v;
import com.tplink.iot.adapter.smart.SmartTaskAdapter;
import com.tplink.iot.adapter.smart.SmartTaskAdapter.a;
import com.tplink.iot.adapter.smart.SmartTriggerAdapter;
import com.tplink.iot.adapter.smart.SmartTriggerAdapter.a;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.cloud.bean.smart.common.SmartAction;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.cloud.bean.smart.common.SmartThingTrigger;
import com.tplink.iot.cloud.bean.smart.common.SmartTrigger;
import com.tplink.iot.model.smart.e;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.viewmodel.smart.ActionSetupViewModel;
import com.tplink.iot.viewmodel.smart.SmartActionViewModel;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.iot.widget.ItemSmartSettingLayout;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.SmartRepository;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ActionSetupFragment
  extends BaseFragment
  implements TextWatcher, SmartTriggerAdapter.a, SmartTaskAdapter.a, AdapterView.OnItemSelectedListener, View.OnClickListener
{
  private TextView H3;
  private ImageView I3;
  private TextView J3;
  private Button K3;
  private ItemSmartSettingLayout L3;
  private ItemSmartSettingLayout M3;
  private TextView N3;
  private View O3;
  private View P3;
  private SmartInfo Q3;
  private SmartTriggerAdapter R3;
  private SmartTaskAdapter S3;
  private ActionSetupViewModel T3;
  private ActionDetailActivity U3;
  private int V3 = 0;
  private int W3 = 0;
  private int X3 = 1;
  private a Y3;
  private AppCompatSpinner p0;
  private LinearLayout p1;
  private ImageView p2;
  private TextView p3;
  private View q;
  private MenuItem x;
  private TextView y;
  private DrawableEditText z;
  
  private void H0()
  {
    Object localObject = (Toolbar)this.q.findViewById(2131364275);
    ((Toolbar)localObject).inflateMenu(2131623954);
    ((Toolbar)localObject).setNavigationIcon(2131689570);
    localObject = (TextView)this.q.findViewById(2131364290);
    this.y = ((TextView)localObject);
    ((TextView)localObject).setText(2131954054);
    localObject = (DrawableEditText)this.q.findViewById(2131362551);
    this.z = ((DrawableEditText)localObject);
    ((DrawableEditText)localObject).setMaxLength(64);
    this.z.f(this);
    localObject = new SmartTriggerAdapter(this.U3, false);
    this.R3 = ((SmartTriggerAdapter)localObject);
    ((SmartTriggerAdapter)localObject).B(this);
    localObject = (RecyclerView)this.q.findViewById(2131362352);
    ((RecyclerView)localObject).setLayoutManager(new LinearLayoutManager(this.U3));
    ((RecyclerView)localObject).setAdapter(this.R3);
    ((RecyclerView)localObject).setNestedScrollingEnabled(false);
    localObject = new SmartTaskAdapter(this.U3, false);
    this.S3 = ((SmartTaskAdapter)localObject);
    ((SmartTaskAdapter)localObject).v(this);
    localObject = (RecyclerView)this.q.findViewById(2131362353);
    ((RecyclerView)localObject).setLayoutManager(new LinearLayoutManager(this.U3));
    ((RecyclerView)localObject).setAdapter(this.S3);
    ((RecyclerView)localObject).setNestedScrollingEnabled(false);
    this.p3 = ((TextView)this.q.findViewById(2131364381));
    this.H3 = ((TextView)this.q.findViewById(2131362303));
    this.I3 = ((ImageView)this.q.findViewById(2131363154));
    localObject = getResources().getStringArray(2130903049);
    b localb = new b(this.U3, 2131559359, 2131559360, 2131364177, (String[])localObject, (String[])localObject);
    localObject = (AppCompatSpinner)this.q.findViewById(2131362302);
    this.p0 = ((AppCompatSpinner)localObject);
    ((Spinner)localObject).setOnItemSelectedListener(this);
    this.p0.setAdapter(localb);
    localObject = (ItemSmartSettingLayout)this.q.findViewById(2131363872);
    this.L3 = ((ItemSmartSettingLayout)localObject);
    ((RelativeLayout)localObject).setOnClickListener(this);
    localObject = (ItemSmartSettingLayout)this.q.findViewById(2131363873);
    this.M3 = ((ItemSmartSettingLayout)localObject);
    ((RelativeLayout)localObject).setOnClickListener(this);
    localObject = (TextView)this.q.findViewById(2131364328);
    this.J3 = ((TextView)localObject);
    ((TextView)localObject).setOnClickListener(this);
    this.p2 = ((ImageView)this.q.findViewById(2131363125));
    localObject = (LinearLayout)this.q.findViewById(2131363335);
    this.p1 = ((LinearLayout)localObject);
    ((LinearLayout)localObject).setOnClickListener(this);
    localObject = (Button)this.q.findViewById(2131362057);
    this.K3 = ((Button)localObject);
    ((Button)localObject).setOnClickListener(this);
    this.N3 = ((TextView)this.q.findViewById(2131364442));
    this.O3 = this.q.findViewById(2131362499);
    this.P3 = this.q.findViewById(2131362476);
    this.N3.setOnClickListener(this);
  }
  
  private boolean I0(SmartTrigger paramSmartTrigger)
  {
    boolean bool = true;
    if (paramSmartTrigger == null) {
      return true;
    }
    int i;
    if (paramSmartTrigger.getSchedules() != null) {
      i = paramSmartTrigger.getSchedules().size() + 0;
    } else {
      i = 0;
    }
    if ((paramSmartTrigger.getThings() != null) && (!paramSmartTrigger.getThings().isEmpty()))
    {
      paramSmartTrigger = paramSmartTrigger.getThings().iterator();
      int j = 0;
      for (;;)
      {
        k = j;
        if (!paramSmartTrigger.hasNext()) {
          break;
        }
        SmartThingTrigger localSmartThingTrigger = (SmartThingTrigger)paramSmartTrigger.next();
        if (localSmartThingTrigger.getEvent() != null) {
          j++;
        } else {
          localSmartThingTrigger.getStateReported();
        }
      }
    }
    int k = 0;
    if (i + k > 1) {
      bool = false;
    }
    return bool;
  }
  
  private <T> boolean J0(List<T> paramList)
  {
    boolean bool;
    if ((paramList != null) && (!paramList.isEmpty())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private void K0()
  {
    Object localObject = this.x;
    if (localObject == null) {
      return;
    }
    SmartInfo localSmartInfo = this.Q3;
    boolean bool1 = false;
    if (localSmartInfo == null)
    {
      ((MenuItem)localObject).setEnabled(false);
      return;
    }
    localObject = localSmartInfo.getTriggerSetting();
    int i;
    if ((localObject != null) && ((((SmartTrigger)localObject).isManual()) || (!J0(((SmartTrigger)localObject).getSchedules())) || (!J0(((SmartTrigger)localObject).getThings())))) {
      i = 0;
    } else {
      i = 1;
    }
    int j;
    if (this.p0.getSelectedItemPosition() == 1) {
      j = 1;
    } else {
      j = 0;
    }
    if ((j != 0) && (!I0((SmartTrigger)localObject))) {
      j = 0;
    } else {
      j = 1;
    }
    localObject = this.Q3.getActionSetting();
    int k;
    if ((localObject != null) && ((!J0(((SmartAction)localObject).getSmarts())) || (!J0(((SmartAction)localObject).getThings())))) {
      k = 0;
    } else {
      k = 1;
    }
    boolean bool2 = i1(this.z.getText());
    localObject = this.x;
    boolean bool3 = bool1;
    if (i == 0)
    {
      bool3 = bool1;
      if (j != 0)
      {
        bool3 = bool1;
        if (k == 0)
        {
          bool3 = bool1;
          if (bool2) {
            bool3 = true;
          }
        }
      }
    }
    ((MenuItem)localObject).setEnabled(bool3);
  }
  
  private void a1()
  {
    this.T3.y();
  }
  
  private boolean c1(@Nullable SmartTrigger paramSmartTrigger)
  {
    if (paramSmartTrigger == null) {
      return false;
    }
    if (paramSmartTrigger.isManual()) {
      return true;
    }
    int i;
    if ((this.T3.H() == 1) && (paramSmartTrigger.getSchedules() != null) && (!paramSmartTrigger.getSchedules().isEmpty())) {
      i = 1;
    } else {
      i = 0;
    }
    return i != 0;
  }
  
  private void d1()
  {
    Object localObject = this.Q3;
    if ((localObject != null) && (((SmartInfo)localObject).getTriggerSetting() != null))
    {
      localObject = new TPMaterialDialogV2.Builder(getContext());
      int i;
      if (this.Q3.getTriggerSetting().isManual()) {
        i = 2131953959;
      } else {
        i = 2131953958;
      }
      ((TPMaterialDialogV2.Builder)localObject).j(getString(i)).l(2131952391, 2131099804, null).o(2131952401, 2131099808, new i(this)).g(8, 8).b(false).c(false).a().show();
    }
  }
  
  private void e1()
  {
    Object localObject = SmartRepository.i;
    String str = this.Q3.getAvatarUrl();
    int i = localObject.length;
    for (int j = 0; j < i; j++) {
      if (localObject[j].equals(str))
      {
        j = 1;
        break label50;
      }
    }
    j = 0;
    label50:
    if (j == 0) {
      this.Q3.setAvatarUrl(localObject[0]);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("file:///android_asset/smart_icons/");
    ((StringBuilder)localObject).append(this.Q3.getAvatarUrl());
    ((StringBuilder)localObject).append(".png");
    localObject = ((StringBuilder)localObject).toString();
    c.w(this).s((String)localObject).x0(this.p2);
  }
  
  private void f1()
  {
    this.T3.D().observe(getViewLifecycleOwner(), new k(this));
    this.T3.x().observe(this, new h(this));
    this.T3.A().observe(this, new g(this));
    this.T3.z().observe(this, new f(this));
    this.T3.B().observe(this, new l(this));
  }
  
  private void g1(SmartInfo paramSmartInfo, List<e> paramList)
  {
    if ((paramSmartInfo != null) && (paramSmartInfo.getActionSetting() != null))
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (e)paramList.next();
        if (((e)localObject).b() == 1) {
          localArrayList1.add(((e)localObject).g());
        } else {
          localArrayList2.add(((e)localObject).f());
        }
      }
      Object localObject = paramSmartInfo.getActionSetting();
      paramList = localArrayList1;
      if (localArrayList1.isEmpty()) {
        paramList = null;
      }
      ((SmartAction)localObject).setThings(paramList);
      paramSmartInfo.getActionSetting().setSmarts(localArrayList2);
    }
  }
  
  private void h()
  {
    Object localObject1 = this.Q3;
    Object localObject2 = "";
    int i = 8;
    if (localObject1 == null)
    {
      this.z.setText("");
      this.z.setHint(2131953949);
      this.p1.setVisibility(8);
      this.N3.setVisibility(8);
      this.O3.setVisibility(8);
      this.P3.setVisibility(8);
      return;
    }
    this.z.clearFocus();
    Object localObject3 = this.Q3.getTriggerSetting();
    localObject1 = this.Q3.getActionSetting();
    this.R3.A((SmartTrigger)localObject3);
    this.S3.t((SmartAction)localObject1);
    if ((localObject3 != null) && (((SmartTrigger)localObject3).isManual())) {
      bool = true;
    } else {
      bool = false;
    }
    this.T3.i0(bool);
    localObject1 = this.T3;
    ((ActionSetupViewModel)localObject1).l0(((ActionSetupViewModel)localObject1).g());
    if ((localObject3 != null) && (((SmartTrigger)localObject3).getCondition() != null)) {
      this.T3.m0(((SmartTrigger)localObject3).getCondition().byteValue());
    }
    int j = this.T3.o();
    this.X3 = j;
    if (j == 1) {
      localObject1 = getString(2131954054);
    } else if (bool) {
      localObject1 = getString(2131953973);
    } else {
      localObject1 = getString(2131953972);
    }
    this.y.setText((CharSequence)localObject1);
    this.z.setText(this.T3.p());
    K0();
    this.W3 = 0;
    if ((localObject3 != null) && (((SmartTrigger)localObject3).getSchedules() != null)) {
      this.W3 += ((SmartTrigger)localObject3).getSchedules().size();
    }
    if ((localObject3 != null) && (((SmartTrigger)localObject3).getThings() != null)) {
      this.W3 += ((SmartTrigger)localObject3).getThings().size();
    }
    localObject1 = this.p1;
    if (bool) {
      j = 0;
    } else {
      j = 8;
    }
    ((LinearLayout)localObject1).setVisibility(j);
    localObject1 = this.N3;
    if ((!bool) && (this.W3 != 0)) {
      j = 0;
    } else {
      j = 8;
    }
    ((TextView)localObject1).setVisibility(j);
    localObject1 = this.O3;
    if ((!bool) && (this.W3 != 0)) {
      j = 0;
    } else {
      j = 8;
    }
    ((View)localObject1).setVisibility(j);
    localObject1 = this.P3;
    if ((!bool) && (this.W3 != 0)) {
      j = 0;
    } else {
      j = 8;
    }
    ((View)localObject1).setVisibility(j);
    if (bool) {
      e1();
    }
    if ((!bool) && (this.W3 > 1)) {
      j = 1;
    } else {
      j = 0;
    }
    localObject1 = this.p0;
    if (j != 0) {
      k = 0;
    } else {
      k = 8;
    }
    ((Spinner)localObject1).setVisibility(k);
    int k = this.T3.H();
    if (j != 0) {
      this.p0.setSelection(k);
    }
    if (k == 1) {
      k = 1;
    } else {
      k = 0;
    }
    if ((j != 0) && (k != 0) && (!I0((SmartTrigger)localObject3))) {
      j = 1;
    } else {
      j = 0;
    }
    localObject1 = this.I3;
    if (j != 0) {
      k = 0;
    } else {
      k = 8;
    }
    ((ImageView)localObject1).setVisibility(k);
    localObject1 = this.p3;
    if (j != 0) {
      j = 0;
    } else {
      j = 8;
    }
    ((TextView)localObject1).setVisibility(j);
    boolean bool = c1((SmartTrigger)localObject3);
    localObject1 = this.L3;
    if (bool) {
      j = 8;
    } else {
      j = 0;
    }
    ((RelativeLayout)localObject1).setVisibility(j);
    localObject3 = this.L3;
    if (this.R3.getItemCount() > 0) {
      localObject1 = "";
    } else {
      localObject1 = getResources().getString(2131953940);
    }
    ((ItemSmartSettingLayout)localObject3).setItemInfo((CharSequence)localObject1);
    localObject3 = this.M3;
    if (this.S3.getItemCount() > 0) {
      localObject1 = localObject2;
    } else {
      localObject1 = getResources().getString(2131953949);
    }
    ((ItemSmartSettingLayout)localObject3).setItemInfo((CharSequence)localObject1);
    k = this.T3.G(this.Q3);
    this.T3.k0(k);
    localObject2 = this.J3;
    if (k == 0)
    {
      localObject1 = getString(2131954006);
    }
    else
    {
      j = k / 3600;
      k %= 3600;
      localObject1 = getString(2131954008, new Object[] { Integer.valueOf(j), Integer.valueOf(k / 60), Integer.valueOf(k % 60) });
    }
    ((TextView)localObject2).setText((CharSequence)localObject1);
    localObject1 = this.K3;
    j = i;
    if (this.X3 == 2) {
      j = 0;
    }
    ((Button)localObject1).setVisibility(j);
  }
  
  private void h1(int paramInt)
  {
    TextView localTextView = this.J3;
    String str;
    if (paramInt == 0)
    {
      str = getString(2131954006);
    }
    else
    {
      int i = paramInt / 3600;
      int j = paramInt % 3600;
      str = getString(2131954008, new Object[] { Integer.valueOf(i), Integer.valueOf(j / 60), Integer.valueOf(j % 60) });
    }
    localTextView.setText(str);
    this.T3.q0(paramInt);
  }
  
  private boolean i1(CharSequence paramCharSequence)
  {
    return TextUtils.isEmpty(paramCharSequence) ^ true;
  }
  
  public void I(com.tplink.iot.model.smart.g paramg)
  {
    a.g(this.U3);
    SmartInfo localSmartInfo = this.T3.v();
    if ((localSmartInfo != null) && (localSmartInfo.getTriggerSetting() != null))
    {
      if (localSmartInfo.getTriggerSetting().isManual())
      {
        localSmartInfo.getTriggerSetting().setManual(false);
        this.T3.i0(false);
      }
      else
      {
        List localList;
        if (paramg.a() == 0)
        {
          localList = localSmartInfo.getTriggerSetting().getSchedules();
          if ((localList != null) && (paramg.b() != null)) {
            localList.remove(paramg.b());
          }
        }
        else if (paramg.a() == 1)
        {
          localList = localSmartInfo.getTriggerSetting().getThings();
          if ((localList != null) && (paramg.d() != null)) {
            localList.remove(paramg.d());
          }
        }
      }
      this.T3.p0(localSmartInfo);
    }
    K0();
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    this.T3.d0(paramEditable.toString());
    K0();
  }
  
  public void b1(a parama)
  {
    this.Y3 = parama;
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean d()
  {
    a locala = this.Y3;
    if (locala != null)
    {
      MenuItem localMenuItem = this.x;
      boolean bool;
      if ((localMenuItem != null) && (localMenuItem.isEnabled())) {
        bool = true;
      } else {
        bool = false;
      }
      locala.b(bool);
    }
    return true;
  }
  
  public void i0(int paramInt)
  {
    a.g(this.U3);
    Object localObject = this.T3.v();
    List localList = this.S3.r();
    localList.remove(paramInt);
    g1((SmartInfo)localObject, localList);
    this.T3.p0((SmartInfo)localObject);
    localObject = this.T3;
    ((ActionSetupViewModel)localObject).l0(((ActionSetupViewModel)localObject).g());
    K0();
  }
  
  public void o(com.tplink.iot.model.smart.g paramg)
  {
    a.g(this.U3);
    if ((paramg != null) && (paramg.d() != null))
    {
      paramg = ((SmartActionViewModel)ViewModelProviders.of(this.U3).get(SmartActionViewModel.class)).l(paramg.c());
      if ((paramg != null) && (paramg.getThingDevice() != null))
      {
        this.T3.f0(paramg);
        paramg = this.Y3;
        if (paramg != null) {
          paramg.d();
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    a.g(this.U3);
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131364442: 
      paramView = this.Y3;
      if (paramView != null) {
        paramView.i();
      }
      break;
    case 2131364328: 
      this.V3 = this.T3.F();
      n0.a(getFragmentManager(), this.V3, new j(this), "tag_action_delay_offset");
      break;
    case 2131363873: 
      paramView = this.Y3;
      if (paramView != null) {
        paramView.g();
      }
      break;
    case 2131363872: 
      if (this.W3 >= 10)
      {
        s0.p(this.U3, getString(2131953941, new Object[] { Integer.valueOf(10) }));
      }
      else
      {
        paramView = this.Y3;
        if (paramView != null) {
          paramView.e();
        }
      }
      break;
    case 2131363335: 
      paramView = this.Y3;
      if (paramView != null) {
        paramView.c();
      }
      break;
    case 2131362057: 
      if (this.X3 == 2) {
        d1();
      }
      break;
    }
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenuInflater.inflate(2131623954, paramMenu);
    this.x = paramMenu.findItem(2131361892);
    K0();
    super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.q = paramLayoutInflater.inflate(2131558952, paramViewGroup, false);
    paramLayoutInflater = (ActionDetailActivity)getActivity();
    this.U3 = paramLayoutInflater;
    if (paramLayoutInflater == null) {
      B0();
    }
    d.J(this.U3, this.q.findViewById(2131364275));
    setHasOptionsMenu(true);
    H0();
    paramLayoutInflater = (ActionSetupViewModel)ViewModelProviders.of(this.U3).get(ActionSetupViewModel.class);
    this.T3 = paramLayoutInflater;
    paramLayoutInflater.M(false);
    f1();
    return this.q;
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    a.g(this.U3);
    paramView = this.T3.v();
    paramAdapterView = paramView.getTriggerSetting();
    if ((paramAdapterView != null) && (!paramAdapterView.isManual()) && (this.p0.getVisibility() != 8))
    {
      if (paramInt == 0) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      if ((paramInt == 0) && (!I0(paramAdapterView)))
      {
        this.I3.setVisibility(0);
        this.p3.setVisibility(0);
      }
      else
      {
        this.I3.setVisibility(8);
        this.p3.setVisibility(8);
        paramAdapterView.setCondition(Byte.valueOf(paramInt ^ 0x1));
        paramView.setTriggerSetting(paramAdapterView);
        this.T3.p0(paramView);
      }
      K0();
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131361892)
    {
      s0.l(this.U3);
      v.d();
      paramMenuItem = this.T3.v();
      paramMenuItem.setName(this.z.getText().toString());
      if (paramMenuItem.getTriggerSetting() == null) {
        paramMenuItem.setTriggerSetting(new SmartTrigger());
      }
      if (this.T3.N())
      {
        paramMenuItem.getTriggerSetting().setSchedules(null);
        paramMenuItem.getTriggerSetting().setThings(null);
      }
      else
      {
        paramMenuItem.getTriggerSetting().setCondition(Byte.valueOf(this.T3.H()));
      }
      this.T3.j0(this.Q3, false);
    }
    else if (paramMenuItem.getItemId() == 16908332)
    {
      d();
    }
    return true;
  }
  
  public void onResume()
  {
    a1();
    super.onResume();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void u(int paramInt, e parame)
  {
    a.g(this.U3);
    if (parame == null) {
      return;
    }
    Object localObject = (SmartActionViewModel)ViewModelProviders.of(this.U3).get(SmartActionViewModel.class);
    if (parame.b() == 0)
    {
      localObject = ((SmartActionViewModel)localObject).m(parame.d());
      if (localObject != null)
      {
        boolean bool = ((SmartInfo)localObject).getTriggerSetting().isManual();
        if ((this.Y3 != null) && (!bool))
        {
          ActionSetupViewModel localActionSetupViewModel = this.T3;
          if (parame.a() != 0) {
            bool = true;
          } else {
            bool = false;
          }
          localActionSetupViewModel.h0((SmartInfo)localObject, bool);
          this.Y3.f();
        }
      }
    }
    else
    {
      parame = ((SmartActionViewModel)localObject).l(parame.h());
      if ((parame != null) && (parame.getThingDevice() != null))
      {
        this.T3.f0(parame);
        parame = this.Y3;
        if (parame != null) {
          parame.a();
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void b(boolean paramBoolean);
    
    public abstract void c();
    
    public abstract void d();
    
    public abstract void e();
    
    public abstract void f();
    
    public abstract void g();
    
    public abstract void h();
    
    public abstract void i();
  }
  
  private static class b
    extends ArrayAdapter<String>
  {
    private Context c;
    private int d;
    private int f;
    private int q;
    private String[] x;
    private String[] y;
    
    b(Context paramContext, int paramInt1, int paramInt2, int paramInt3, String[] paramArrayOfString1, String[] paramArrayOfString2)
    {
      super(paramInt1, paramInt3, paramArrayOfString1);
      this.c = paramContext;
      this.d = paramInt1;
      this.f = paramInt2;
      this.q = paramInt3;
      this.x = paramArrayOfString1;
      this.y = paramArrayOfString2;
    }
    
    public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView = paramView;
      if (paramView == null) {
        localView = LayoutInflater.from(this.c).inflate(this.f, paramViewGroup, false);
      }
      ((TextView)localView.findViewById(this.q)).setText(this.y[paramInt]);
      return localView;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView = paramView;
      if (paramView == null) {
        localView = LayoutInflater.from(this.c).inflate(this.d, paramViewGroup, false);
      }
      ((TextView)localView.findViewById(this.q)).setText(this.x[paramInt]);
      return localView;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\smart\actionsetup\ActionSetupFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */