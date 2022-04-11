package com.tplink.iot.devices.featuredactions.view.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.DrawableRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.tplink.iot.Utils.extension.e;
import com.tplink.iot.Utils.z0.q;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.databinding.FragmentAbstractFeaturedActionBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment;
import com.tplink.iot.devices.featuredactions.adapter.FeaturedActionDeviceSelectAdapter;
import com.tplink.iot.devices.featuredactions.viewmodel.base.AbstractFeaturedActionViewModel;
import com.tplink.iot.view.smart.actionsetup.ActionDetailActivity;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumIoTAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumIoTCategory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.h;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.p;

public abstract class AbstractFeaturedActionFragment<VM extends AbstractFeaturedActionViewModel>
  extends IoTMVVMBaseFragment<FragmentAbstractFeaturedActionBinding>
{
  public static final a p1 = new a(null);
  private MenuItem H3;
  private FeaturedActionDeviceSelectAdapter I3;
  private HashMap J3;
  private final String p2;
  private final kotlin.f p3 = h.b(new c(this));
  
  private final void h1()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.finish();
    }
  }
  
  private final void i1(SmartInfo paramSmartInfo)
  {
    startActivityForResult(ActionDetailActivity.G1(requireContext(), paramSmartInfo), 1180);
  }
  
  private final void j1(List<? extends BaseALIoTDevice<?>> paramList)
  {
    List localList = m1(X0(paramList));
    paramList = Z0(localList, d1());
    boolean bool = localList.isEmpty();
    int i = 0;
    int j;
    if ((bool) && (paramList.isEmpty())) {
      j = 1;
    } else {
      j = 0;
    }
    TextView localTextView = ((FragmentAbstractFeaturedActionBinding)J0()).q;
    j.d(localTextView, "mBinding.tvEmpty");
    if (j == 0) {
      i = 8;
    }
    localTextView.setVisibility(i);
    if (j != 0) {
      return;
    }
    v1(localList, paramList);
    b1().G(localList);
  }
  
  private final void l1(List<com.tplink.iot.g.a.a.b> paramList)
  {
    v1(paramList, Z0(paramList, d1()));
  }
  
  private final List<com.tplink.iot.g.a.a.b> m1(List<? extends BaseALIoTDevice<?>> paramList)
  {
    ArrayList localArrayList = new ArrayList(kotlin.collections.l.l(paramList, 10));
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (BaseALIoTDevice)localIterator.next();
      localArrayList.add(new com.tplink.iot.g.a.a.b(paramList, W0(paramList), null, 4, null));
    }
    return localArrayList;
  }
  
  private final void o1()
  {
    Object localObject = this.I3;
    if (localObject != null)
    {
      localObject = ((FeaturedActionDeviceSelectAdapter)localObject).J();
      if (localObject != null) {}
    }
    else
    {
      localObject = kotlin.collections.l.d();
    }
    localObject = n1((List)localObject);
    if (localObject.length == 1) {
      q1(localObject[0]);
    } else if (localObject.length == 2) {
      r1((SmartInfo[])localObject);
    }
  }
  
  private final void q1(final SmartInfo paramSmartInfo)
  {
    Context localContext = getContext();
    if (localContext != null) {
      e.r(localContext, new d(this, paramSmartInfo));
    }
  }
  
  private final void r1(final SmartInfo[] paramArrayOfSmartInfo)
  {
    Context localContext = getContext();
    if (localContext != null) {
      e.r(localContext, new e(this, paramArrayOfSmartInfo));
    }
  }
  
  private final void v1(List<com.tplink.iot.g.a.a.b> paramList, List<com.tplink.iot.model.iot.b> paramList1)
  {
    if (this.I3 == null)
    {
      localObject = requireContext();
      j.d(localObject, "requireContext()");
      FeaturedActionDeviceSelectAdapter localFeaturedActionDeviceSelectAdapter = new FeaturedActionDeviceSelectAdapter((Context)localObject);
      localFeaturedActionDeviceSelectAdapter.Q(new i(this));
      localObject = p.a;
      this.I3 = localFeaturedActionDeviceSelectAdapter;
      localObject = ((FragmentAbstractFeaturedActionBinding)J0()).d;
      j.d(localObject, "mBinding.recyclerViewDevice");
      ((RecyclerView)localObject).setAdapter(this.I3);
    }
    Object localObject = this.I3;
    if (localObject != null) {
      ((FeaturedActionDeviceSelectAdapter)localObject).O(paramList, paramList1);
    }
  }
  
  public void B0()
  {
    FragmentKt.findNavController(this).popBackStack();
  }
  
  public void H0()
  {
    HashMap localHashMap = this.J3;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public int I0()
  {
    return 2131558853;
  }
  
  public void N0()
  {
    Object localObject1 = ((FragmentAbstractFeaturedActionBinding)J0()).y;
    j.d(localObject1, "mBinding.tvTitle");
    ((TextView)localObject1).setText(f1());
    localObject1 = ((FragmentAbstractFeaturedActionBinding)J0()).f;
    j.d(localObject1, "mBinding.tvDescription");
    ((TextView)localObject1).setText(a1());
    ((FragmentAbstractFeaturedActionBinding)J0()).c.setImageResource(c1());
    Object localObject2 = ((FragmentAbstractFeaturedActionBinding)J0()).x;
    int i;
    if (e1() != null) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      i = 0;
    } else {
      i = 8;
    }
    ((View)localObject2).setVisibility(i);
    if (e1() == null)
    {
      localObject1 = "";
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("* ");
      ((StringBuilder)localObject1).append(e1());
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    ((TextView)localObject2).setText((CharSequence)localObject1);
    localObject1 = ((FragmentAbstractFeaturedActionBinding)J0()).d;
    j.d(localObject1, "mBinding.recyclerViewDevice");
    localObject2 = ((RecyclerView)localObject1).getItemAnimator();
    localObject1 = localObject2;
    if (!(localObject2 instanceof SimpleItemAnimator)) {
      localObject1 = null;
    }
    localObject1 = (SimpleItemAnimator)localObject1;
    if (localObject1 != null) {
      ((SimpleItemAnimator)localObject1).setSupportsChangeAnimations(false);
    }
  }
  
  @CallSuper
  public void R0()
  {
    b1().m().observe(getViewLifecycleOwner(), new f(this));
    b1().r().observe(getViewLifecycleOwner(), new g(this));
    b1().o().observe(getViewLifecycleOwner(), new h(this));
  }
  
  public abstract boolean W0(BaseALIoTDevice<?> paramBaseALIoTDevice);
  
  protected final List<BaseALIoTDevice<?>> X0(List<? extends BaseALIoTDevice<?>> paramList)
  {
    j.e(paramList, "deviceList");
    List localList = d1();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = localIterator.next();
      if (kotlin.collections.l.v(localList, EnumIoTCategory.fromString(((BaseALIoTDevice)paramList).getCategory()))) {
        localArrayList.add(paramList);
      }
    }
    return localArrayList;
  }
  
  protected final com.tplink.iot.model.iot.b Y0(EnumIoTCategory paramEnumIoTCategory)
  {
    j.e(paramEnumIoTCategory, "category");
    String str;
    switch (a.a[paramEnumIoTCategory.ordinal()])
    {
    default: 
      throw new NoWhenBranchMatchedException();
    case 12: 
      str = getString(2131954078);
      j.d(str, "getString(R.string.smart_thermostat)");
      paramEnumIoTCategory = new com.tplink.iot.model.iot.b(2131690097, str, paramEnumIoTCategory, null, 8, null);
      break;
    case 11: 
      str = getString(2131952871);
      j.d(str, "getString(R.string.iot_contact_sensor)");
      paramEnumIoTCategory = new com.tplink.iot.model.iot.b(2131690052, str, paramEnumIoTCategory, null, 8, null);
      break;
    case 10: 
      str = getString(2131952877);
      j.d(str, "getString(R.string.iot_motion_sensor)");
      paramEnumIoTCategory = new com.tplink.iot.model.iot.b(2131690049, str, paramEnumIoTCategory, null, 8, null);
      break;
    case 9: 
      str = getString(2131954030);
      j.d(str, "getString(R.string.smart_button)");
      paramEnumIoTCategory = new com.tplink.iot.model.iot.b(2131689969, str, paramEnumIoTCategory, null, 8, null);
      break;
    case 8: 
      str = getString(2131954061);
      j.d(str, "getString(R.string.smart_switch)");
      paramEnumIoTCategory = new com.tplink.iot.model.iot.b(2131690062, str, paramEnumIoTCategory, null, 8, null);
      break;
    case 7: 
      str = getString(2131953370);
      j.d(str, "getString(R.string.plug)");
      paramEnumIoTCategory = new com.tplink.iot.model.iot.b(2131690039, str, paramEnumIoTCategory, null, 8, null);
      break;
    case 6: 
      str = getString(2131954032);
      j.d(str, "getString(R.string.smart_camera)");
      paramEnumIoTCategory = new com.tplink.iot.model.iot.b(2131689971, str, paramEnumIoTCategory, null, 8, null);
      break;
    case 4: 
    case 5: 
      str = getString(2131954050);
      j.d(str, "getString(R.string.smart_hub)");
      paramEnumIoTCategory = new com.tplink.iot.model.iot.b(2131690022, str, paramEnumIoTCategory, null, 8, null);
      break;
    case 3: 
      int i = q.h(EnumIoTAvatarType.PLUG);
      str = getString(2131953370);
      j.d(str, "getString(R.string.plug)");
      paramEnumIoTCategory = new com.tplink.iot.model.iot.b(i, str, paramEnumIoTCategory, "https://www.tapo.com/en/product/smart-plug/");
      break;
    case 2: 
      str = getString(2131954052);
      j.d(str, "getString(R.string.smart_light_strip)");
      paramEnumIoTCategory = new com.tplink.iot.model.iot.b(2131690034, str, paramEnumIoTCategory, "https://www.tapo.com/en/product/smart-light-bulb/");
      break;
    case 1: 
      str = getString(2131954029);
      j.d(str, "getString(R.string.smart_bulb)");
      paramEnumIoTCategory = new com.tplink.iot.model.iot.b(2131689965, str, paramEnumIoTCategory, "https://www.tapo.com/en/product/smart-light-bulb/");
    }
    return paramEnumIoTCategory;
  }
  
  protected final List<com.tplink.iot.model.iot.b> Z0(List<com.tplink.iot.g.a.a.b> paramList, List<? extends EnumIoTCategory> paramList1)
  {
    j.e(paramList, "devices");
    j.e(paramList1, "supportCategories");
    paramList1 = new ArrayList(paramList1);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (com.tplink.iot.g.a.a.b)localIterator.next();
      if (paramList1.isEmpty()) {
        break;
      }
      paramList1.remove(EnumIoTCategory.fromString(paramList.a().getCategory()));
    }
    paramList = new ArrayList(kotlin.collections.l.l(paramList1, 10));
    localIterator = paramList1.iterator();
    while (localIterator.hasNext())
    {
      paramList1 = (EnumIoTCategory)localIterator.next();
      j.d(paramList1, "it");
      paramList.add(Y0(paramList1));
    }
    return paramList;
  }
  
  public abstract String a1();
  
  protected final VM b1()
  {
    return (AbstractFeaturedActionViewModel)this.p3.getValue();
  }
  
  @DrawableRes
  public abstract int c1();
  
  public abstract List<EnumIoTCategory> d1();
  
  public String e1()
  {
    return this.p2;
  }
  
  public abstract String f1();
  
  public abstract VM g1();
  
  protected final void k1(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer> parama)
  {
    j.e(parama, "event");
    parama = (Integer)parama.a();
    if ((parama != null) && (parama.intValue() == 100))
    {
      parama = getActivity();
      if (parama != null) {
        e.m(parama, null, 1, null);
      }
    }
    else if ((parama != null) && (parama.intValue() == 200))
    {
      parama = getActivity();
      if (parama != null) {
        e.f(parama, new b(this));
      }
    }
    else if ((parama != null) && (parama.intValue() == 300))
    {
      parama = getActivity();
      if (parama != null) {
        e.e(parama, null, 1, null);
      }
    }
  }
  
  public abstract SmartInfo[] n1(List<? extends BaseALIoTDevice<?>> paramList);
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 1180)) {
      h1();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setHasOptionsMenu(true);
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    j.e(paramMenu, "menu");
    j.e(paramMenuInflater, "inflater");
    paramMenuInflater.inflate(2131623947, paramMenu);
    this.H3 = paramMenu.findItem(2131361871);
    p1(false);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    j.e(paramMenuItem, "item");
    if (paramMenuItem.getItemId() == 2131361871)
    {
      o1();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  protected final void p1(boolean paramBoolean)
  {
    MenuItem localMenuItem = this.H3;
    if (localMenuItem != null) {
      localMenuItem.setEnabled(paramBoolean);
    }
  }
  
  protected final boolean s1(ThingModel paramThingModel, String paramString)
  {
    j.e(paramThingModel, "$this$supportEvent");
    j.e(paramString, "eventId");
    boolean bool;
    if (paramThingModel.getThingEvent(paramString) != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected final boolean t1(ThingModel paramThingModel, String paramString)
  {
    j.e(paramThingModel, "$this$supportProperty");
    j.e(paramString, "propertyId");
    boolean bool;
    if (paramThingModel.getThingProperty(paramString) != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected final boolean u1(ThingModel paramThingModel, String paramString)
  {
    j.e(paramThingModel, "$this$supportService");
    j.e(paramString, "serviceId");
    boolean bool;
    if (paramThingModel.getThingService(paramString) != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static final class a {}
  
  static final class b
    extends Lambda
    implements kotlin.jvm.b.a<p>
  {
    b(AbstractFeaturedActionFragment paramAbstractFeaturedActionFragment)
    {
      super();
    }
    
    public final void a()
    {
      AbstractFeaturedActionFragment.S0(this.c);
    }
  }
  
  static final class c
    extends Lambda
    implements kotlin.jvm.b.a<VM>
  {
    c(AbstractFeaturedActionFragment paramAbstractFeaturedActionFragment)
    {
      super();
    }
    
    public final VM a()
    {
      return this.c.g1();
    }
  }
  
  static final class d
    extends Lambda
    implements kotlin.jvm.b.l<com.tplink.iot.Utils.extension.f, p>
  {
    d(AbstractFeaturedActionFragment paramAbstractFeaturedActionFragment, SmartInfo paramSmartInfo)
    {
      super();
    }
    
    public final void a(com.tplink.iot.Utils.extension.f paramf)
    {
      j.e(paramf, "$receiver");
      paramf.h(2131953681);
      com.tplink.iot.Utils.extension.f.e(paramf, 2131952391, paramf.a(), null, 4, null);
      paramf.f(2131952398, paramf.b(), new a(this));
    }
    
    static final class a
      extends Lambda
      implements kotlin.jvm.b.a<p>
    {
      a(AbstractFeaturedActionFragment.d paramd)
      {
        super();
      }
      
      public final void a()
      {
        AbstractFeaturedActionFragment.d locald = this.c;
        AbstractFeaturedActionFragment.T0(locald.c, locald.d);
      }
    }
  }
  
  static final class e
    extends Lambda
    implements kotlin.jvm.b.l<com.tplink.iot.Utils.extension.f, p>
  {
    e(AbstractFeaturedActionFragment paramAbstractFeaturedActionFragment, SmartInfo[] paramArrayOfSmartInfo)
    {
      super();
    }
    
    public final void a(com.tplink.iot.Utils.extension.f paramf)
    {
      j.e(paramf, "$receiver");
      paramf.h(2131953682);
      com.tplink.iot.Utils.extension.f.e(paramf, 2131952391, paramf.a(), null, 4, null);
      paramf.f(2131952473, paramf.b(), new a(this));
    }
    
    static final class a
      extends Lambda
      implements kotlin.jvm.b.a<p>
    {
      a(AbstractFeaturedActionFragment.e parame)
      {
        super();
      }
      
      public final void a()
      {
        this.c.c.b1().g(this.c.d);
      }
    }
  }
  
  static final class f<T>
    implements Observer<List<? extends BaseALIoTDevice<?>>>
  {
    f(AbstractFeaturedActionFragment paramAbstractFeaturedActionFragment) {}
    
    public final void a(List<? extends BaseALIoTDevice<?>> paramList)
    {
      if (paramList != null) {
        AbstractFeaturedActionFragment.U0(this.a, paramList);
      }
    }
  }
  
  static final class g<T>
    implements Observer<List<? extends com.tplink.iot.g.a.a.b>>
  {
    g(AbstractFeaturedActionFragment paramAbstractFeaturedActionFragment) {}
    
    public final void a(List<com.tplink.iot.g.a.a.b> paramList)
    {
      if (paramList != null) {
        AbstractFeaturedActionFragment.V0(this.a, paramList);
      }
    }
  }
  
  static final class h<T>
    implements Observer<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>>
  {
    h(AbstractFeaturedActionFragment paramAbstractFeaturedActionFragment) {}
    
    public final void a(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer> parama)
    {
      if (parama != null) {
        this.a.k1(parama);
      }
    }
  }
  
  static final class i
    extends Lambda
    implements kotlin.jvm.b.l<Boolean, p>
  {
    i(AbstractFeaturedActionFragment paramAbstractFeaturedActionFragment)
    {
      super();
    }
    
    public final void a(boolean paramBoolean)
    {
      this.c.p1(paramBoolean ^ true);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\featuredactions\view\base\AbstractFeaturedActionFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */