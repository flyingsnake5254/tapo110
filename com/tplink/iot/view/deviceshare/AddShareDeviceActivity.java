package com.tplink.iot.view.deviceshare;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.d.w.h.b;
import com.tplink.iot.Utils.TPLongMaterialDialogV2.d;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.Utils.TPMaterialDialogV3;
import com.tplink.iot.Utils.TPMaterialDialogV3.Builder;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.Utils.d0.g;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.x0.q;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.adapter.deviceshare.DeviceShareUserRecordAdapter;
import com.tplink.iot.adapter.deviceshare.DeviceShareUserRecordAdapter.b;
import com.tplink.iot.adapter.deviceshare.RecordUserBean;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.share.params.DeviceShareListParams;
import com.tplink.iot.cloud.bean.share.params.DeviceShareParams;
import com.tplink.iot.core.o;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.view.wss.WssAmazonInstrWebActivity;
import com.tplink.iot.viewmodel.deviceshare.DeviceShareViewModel;
import com.tplink.iot.viewmodel.home.u;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.iot.widget.ListContentLongDialog.e;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.device.DeviceManagerInfoBean;
import com.tplink.libtpnetwork.TPCloudNetwork.device.TCDeviceBean;
import com.tplink.libtpnetwork.TPCloudNetwork.device.TCDeviceUserInfoBean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class AddShareDeviceActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private DeviceShareViewModel H3;
  private List<BaseALIoTDevice> I3 = new ArrayList();
  private ViewTreeObserver.OnGlobalLayoutListener J3 = new a();
  private Button p0;
  private View p1;
  private List<BaseALIoTDevice> p2 = new ArrayList();
  private List<TCDeviceUserInfoBean> p3 = new ArrayList();
  private View y;
  private DrawableEditText z;
  
  private void A1()
  {
    b1(2131953896);
    Object localObject = (ImageView)findViewById(2131363099);
    if (this.p2.size() == 1) {
      l.p(this, (BaseALIoTDevice)this.p2.get(0), (ImageView)localObject);
    } else if (this.p2.size() > 1) {
      ((ImageView)localObject).setImageResource(2131689987);
    }
    this.p1 = findViewById(2131363324);
    localObject = (Button)findViewById(2131362037);
    this.p0 = ((Button)localObject);
    ((Button)localObject).setEnabled(false);
    this.p0.setOnClickListener(this);
    d0.h((TextView)findViewById(2131364354), getString(2131954467), ContextCompat.getColor(this, 2131099811), new c());
    this.p3 = this.H3.z();
    localObject = (DrawableEditText)findViewById(2131362510);
    this.z = ((DrawableEditText)localObject);
    ((DrawableEditText)localObject).setThreshold(1);
    localObject = Arrays.asList(getResources().getStringArray(2130903043));
    this.z.setAdapter(new com.tplink.iot.adapter.deviceshare.a(this, r1(this.p3), (List)localObject));
    z1();
    DeviceShareUserRecordAdapter localDeviceShareUserRecordAdapter = new DeviceShareUserRecordAdapter(this, this.p3);
    localObject = (RecyclerView)findViewById(2131363810);
    ((RecyclerView)localObject).setLayoutManager(new LinearLayoutManager(this));
    ((RecyclerView)localObject).setItemAnimator(new DefaultItemAnimator());
    ((RecyclerView)localObject).setAdapter(localDeviceShareUserRecordAdapter);
    localDeviceShareUserRecordAdapter.n(new d());
    if (this.p3.isEmpty())
    {
      this.p1.setVisibility(8);
      this.z.getEditText().requestFocus();
      this.z.getEditText().setFocusable(true);
      this.z.getEditText().setFocusableInTouchMode(true);
    }
    else
    {
      this.p1.setVisibility(0);
    }
  }
  
  private boolean B1()
  {
    Rect localRect = new Rect();
    getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    boolean bool;
    if (getWindow().getDecorView().getHeight() * 2 / 3 > localRect.bottom) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean C1()
  {
    if (!B1())
    {
      List localList = this.p3;
      if ((localList != null) && (!localList.isEmpty())) {
        return true;
      }
    }
    boolean bool = false;
    return bool;
  }
  
  public static void D1(Context paramContext, List<BaseALIoTDevice> paramList)
  {
    Intent localIntent = new Intent(paramContext, AddShareDeviceActivity.class);
    Bundle localBundle = new Bundle();
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(((BaseALIoTDevice)paramList.next()).getDeviceIdMD5());
      }
    }
    localBundle.putSerializable("device_id_md5_list", localArrayList);
    localIntent.putExtras(localBundle);
    paramContext.startActivity(localIntent);
  }
  
  private void E1(TCDeviceUserInfoBean paramTCDeviceUserInfoBean)
  {
    if (paramTCDeviceUserInfoBean.getCloudUserName() != null)
    {
      this.z.setText(paramTCDeviceUserInfoBean.getCloudUserName());
      this.z.setSelection(paramTCDeviceUserInfoBean.getCloudUserName().length());
    }
  }
  
  private void F1()
  {
    View localView = getWindow().getDecorView().findViewById(16908290);
    this.y = localView;
    localView.getViewTreeObserver().addOnGlobalLayoutListener(this.J3);
  }
  
  private void G1()
  {
    this.H3.D().observe(this, new f());
    this.H3.F().observe(this, new g());
    this.H3.G().observe(this, new h());
  }
  
  private void H1()
  {
    d.I(this);
    String str = this.z.getText().toString().trim();
    if (TextUtils.equals(str, b.d.s.a.a.e()))
    {
      J1();
      return;
    }
    s0.l(this);
    DeviceShareListParams localDeviceShareListParams = new DeviceShareListParams();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.p2.iterator();
    while (localIterator.hasNext())
    {
      BaseALIoTDevice localBaseALIoTDevice = (BaseALIoTDevice)localIterator.next();
      DeviceShareParams localDeviceShareParams = new DeviceShareParams();
      if (localBaseALIoTDevice.getCloudIoTDevice() != null)
      {
        localDeviceShareParams.setThingName(localBaseALIoTDevice.getCloudIoTDevice().getDeviceId());
        localDeviceShareParams.setSubThing(localBaseALIoTDevice.isSubDevice());
        localDeviceShareParams.setDeviceType(localBaseALIoTDevice.getDeviceType());
      }
      else
      {
        if (localBaseALIoTDevice.getThingDevice() == null) {
          continue;
        }
        localDeviceShareParams.setThingName(localBaseALIoTDevice.getThingDevice().getThingName());
        localDeviceShareParams.setSubThing(localBaseALIoTDevice.isSubDevice());
        localDeviceShareParams.setDeviceType(localBaseALIoTDevice.getDeviceType());
      }
      localDeviceShareParams.setAppCategory("TP-Link_Tapo");
      localDeviceShareParams.setSharerUserName(str);
      localDeviceShareParams.setShareExpires(432000L);
      localArrayList.add(localDeviceShareParams);
    }
    localDeviceShareListParams.setShareList(localArrayList);
    this.H3.Q(localDeviceShareListParams);
  }
  
  private void I1(i<Void> parami)
  {
    if (parami == null)
    {
      s0.n(this, 2131952444);
      return;
    }
    int i = parami.b();
    if (i != 44918)
    {
      if (i != 45028) {
        s0.n(this, 2131952444);
      } else if (this.p2.size() == 1) {
        M1((BaseALIoTDevice)this.p2.get(0));
      } else {
        t1();
      }
    }
    else {
      s0.n(this, 2131951734);
    }
  }
  
  private void J1()
  {
    new TPMaterialDialogV3.Builder(this).f(getString(2131952569)).b(false).c(false).i(null, 2131099804, null).j(2131951761, 2131099808, null).a().show();
  }
  
  private void K1(List<BaseALIoTDevice> paramList)
  {
    u.v(this, paramList, new i());
  }
  
  private void L1()
  {
    new TPMaterialDialogV2.Builder(this).r(2131952571).j(getString(2131952570)).b(false).c(false).n(null, 2131099804, null).o(2131951761, 2131099808, new b()).g(8, 8).a().show();
  }
  
  private void M1(final BaseALIoTDevice paramBaseALIoTDevice)
  {
    u.w(this, paramBaseALIoTDevice.getDeviceType(), new j(paramBaseALIoTDevice));
  }
  
  private boolean N1()
  {
    return b.c(this.z.getText().toString().trim());
  }
  
  private List<RecordUserBean> r1(List<TCDeviceUserInfoBean> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (TCDeviceUserInfoBean)localIterator.next();
      localArrayList.add(new RecordUserBean(paramList.getCloudUserName(), paramList.getNickname()));
    }
    return localArrayList;
  }
  
  private void s1()
  {
    s0.n(this, 2131952444);
  }
  
  private void t1()
  {
    this.H3.C(this.p2);
  }
  
  private void u1()
  {
    List localList = w1();
    if ((localList != null) && (localList.size() != 0))
    {
      if (localList.size() == 1) {
        M1((BaseALIoTDevice)localList.get(0));
      } else {
        K1(localList);
      }
    }
    else {
      s0.n(this, 2131952444);
    }
  }
  
  private void v1()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getExtras();
      if (localObject != null)
      {
        localObject = (List)((Bundle)localObject).getSerializable("device_id_md5_list");
        if ((localObject != null) && (!((List)localObject).isEmpty()))
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            BaseALIoTDevice localBaseALIoTDevice = TPIoTClientManager.I1((String)((Iterator)localObject).next());
            if (localBaseALIoTDevice != null) {
              this.p2.add(localBaseALIoTDevice);
            }
          }
        }
      }
    }
  }
  
  private List<BaseALIoTDevice> w1()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.p2.iterator();
    while (localIterator.hasNext())
    {
      BaseALIoTDevice localBaseALIoTDevice = x1(((BaseALIoTDevice)localIterator.next()).getDeviceId());
      if ((localBaseALIoTDevice != null) && (localBaseALIoTDevice.getDeviceManagerInfo() != null) && (localBaseALIoTDevice.getDeviceManagerInfo().getUserInfo() != null) && (localBaseALIoTDevice.getDeviceManagerInfo().getUserInfo().size() > a.d(localBaseALIoTDevice.getDeviceType()))) {
        localArrayList.add(localBaseALIoTDevice);
      }
    }
    return localArrayList;
  }
  
  private BaseALIoTDevice x1(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = this.I3;
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          BaseALIoTDevice localBaseALIoTDevice = (BaseALIoTDevice)((Iterator)localObject).next();
          if ((localBaseALIoTDevice != null) && (localBaseALIoTDevice.getCloudIoTDevice() != null) && (paramString.equals(localBaseALIoTDevice.getCloudIoTDevice().getDeviceId()))) {
            return localBaseALIoTDevice;
          }
        }
      }
    }
    return null;
  }
  
  private void y1(BaseALIoTDevice paramBaseALIoTDevice)
  {
    ShareDeviceUserListActivity.v1(this, paramBaseALIoTDevice.getDeviceIdMD5());
  }
  
  private void z1()
  {
    this.z.f(new e());
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362037) {
      H1();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558434);
    this.H3 = ((DeviceShareViewModel)ViewModelProviders.of(this).get(DeviceShareViewModel.class));
    v1();
    A1();
    F1();
    G1();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    d.I(this);
    View localView = this.y;
    if (localView != null) {
      localView.getViewTreeObserver().removeOnGlobalLayoutListener(this.J3);
    }
  }
  
  class a
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    a() {}
    
    public void onGlobalLayout()
    {
      if (AddShareDeviceActivity.h1(AddShareDeviceActivity.this) != null)
      {
        View localView = AddShareDeviceActivity.h1(AddShareDeviceActivity.this);
        int i;
        if (AddShareDeviceActivity.i1(AddShareDeviceActivity.this)) {
          i = 0;
        } else {
          i = 8;
        }
        localView.setVisibility(i);
      }
    }
  }
  
  class b
    implements TPMaterialDialogV2.d
  {
    b() {}
    
    public void onClick(View paramView)
    {
      AddShareDeviceActivity.this.finish();
    }
  }
  
  class c
    implements d0.g
  {
    c() {}
    
    public void a()
    {
      WssAmazonInstrWebActivity.j1(AddShareDeviceActivity.this, "https://www.tp-link.com/en/support/faq/1439/");
    }
  }
  
  class d
    implements DeviceShareUserRecordAdapter.b
  {
    d() {}
    
    public void a(View paramView, int paramInt)
    {
      paramView = AddShareDeviceActivity.this;
      AddShareDeviceActivity.f1(paramView, (TCDeviceUserInfoBean)AddShareDeviceActivity.e1(paramView).get(paramInt));
    }
  }
  
  class e
    implements TextWatcher
  {
    e() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      AddShareDeviceActivity.k1(AddShareDeviceActivity.this).setEnabled(AddShareDeviceActivity.j1(AddShareDeviceActivity.this));
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  class f
    implements Observer<i<Void>>
  {
    f() {}
    
    public void a(@Nullable i<Void> parami)
    {
      if ((parami != null) && (parami.b() == 0)) {
        AddShareDeviceActivity.l1(AddShareDeviceActivity.this);
      } else {
        AddShareDeviceActivity.m1(AddShareDeviceActivity.this);
      }
    }
  }
  
  class g
    implements Observer<List<BaseALIoTDevice>>
  {
    g() {}
    
    public void a(@Nullable List<BaseALIoTDevice> paramList)
    {
      AddShareDeviceActivity.n1(AddShareDeviceActivity.this, paramList);
    }
  }
  
  class h
    implements Observer<i<Void>>
  {
    h() {}
    
    public void a(@Nullable i<Void> parami)
    {
      
      if ((parami != null) && (parami.b() == 0))
      {
        q.j(AddShareDeviceActivity.o1(AddShareDeviceActivity.this));
        AddShareDeviceActivity.p1(AddShareDeviceActivity.this);
      }
      else
      {
        q.i(parami);
        AddShareDeviceActivity.q1(AddShareDeviceActivity.this, parami);
      }
    }
  }
  
  class i
    implements ListContentLongDialog.e
  {
    i() {}
    
    public void dismiss()
    {
      AddShareDeviceActivity.this.W0(ShareDeviceActivity.class);
    }
  }
  
  class j
    implements TPLongMaterialDialogV2.d
  {
    j(BaseALIoTDevice paramBaseALIoTDevice) {}
    
    public void onClick(View paramView)
    {
      AddShareDeviceActivity.g1(AddShareDeviceActivity.this, paramBaseALIoTDevice);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\deviceshare\AddShareDeviceActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */