package com.tplink.iot.view.deviceshare;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.d.w.h.b;
import com.tplink.cloud.bean.share.result.ShareBlacklistItemResult;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.Utils.d0.g;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.x0.q;
import com.tplink.iot.adapter.deviceshare.DeviceShareBlacklistRecordAdapter;
import com.tplink.iot.adapter.deviceshare.DeviceShareBlacklistRecordAdapter.c;
import com.tplink.iot.adapter.deviceshare.RecordUserBean;
import com.tplink.iot.adapter.deviceshare.a;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.view.wss.WssAmazonInstrWebActivity;
import com.tplink.iot.viewmodel.deviceshare.DeviceShareViewModel;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ShareBlacklistCacheBean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DeviceShareBlacklistAddUserActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private ViewTreeObserver.OnGlobalLayoutListener H3 = new e();
  private DrawableEditText p0;
  private View p1;
  private DeviceShareViewModel p2;
  private List<ShareBlacklistCacheBean> p3;
  private View y;
  private Button z;
  
  private List<RecordUserBean> i1(List<ShareBlacklistCacheBean> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (ShareBlacklistItemResult)localIterator.next();
        localArrayList.add(new RecordUserBean(paramList.getEmail(), paramList.getNickname()));
      }
    }
    return localArrayList;
  }
  
  private void j1()
  {
    this.p0.setThreshold(1);
    List localList = Arrays.asList(getResources().getStringArray(2130903043));
    this.p0.setAdapter(new a(this, i1(this.p3), localList));
    this.p0.f(new d());
  }
  
  private void k1()
  {
    b1(2131953885);
    this.z = ((Button)findViewById(2131362037));
    this.p0 = ((DrawableEditText)findViewById(2131362510));
    this.p1 = findViewById(2131363324);
    this.z.setOnClickListener(this);
    this.z.setEnabled(false);
    this.p3 = this.p2.y();
    j1();
    DeviceShareBlacklistRecordAdapter localDeviceShareBlacklistRecordAdapter = new DeviceShareBlacklistRecordAdapter(this, this.p3);
    Object localObject = (RecyclerView)findViewById(2131363820);
    ((RecyclerView)localObject).setLayoutManager(new LinearLayoutManager(this));
    ((RecyclerView)localObject).setAdapter(localDeviceShareBlacklistRecordAdapter);
    localDeviceShareBlacklistRecordAdapter.p(new a());
    localObject = this.p3;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      this.p1.setVisibility(0);
    }
    else
    {
      this.p1.setVisibility(8);
      this.p0.m();
    }
    d0.h((TextView)findViewById(2131364354), getString(2131954467), ContextCompat.getColor(this, 2131099811), new b());
  }
  
  private boolean l1()
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
  
  private boolean m1()
  {
    if (!l1())
    {
      List localList = this.p3;
      if ((localList != null) && (!localList.isEmpty())) {
        return true;
      }
    }
    boolean bool = false;
    return bool;
  }
  
  private void n1()
  {
    View localView = getWindow().getDecorView().findViewById(16908290);
    this.y = localView;
    localView.getViewTreeObserver().addOnGlobalLayoutListener(this.H3);
  }
  
  private void o1()
  {
    this.p2.v().observe(this, new c());
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362037)
    {
      s0.l(this);
      this.p2.t(this.p0.getText().toString());
      q.p();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558504);
    this.p2 = ((DeviceShareViewModel)ViewModelProviders.of(this).get(DeviceShareViewModel.class));
    k1();
    n1();
    o1();
  }
  
  protected void onDestroy()
  {
    d.I(this);
    View localView = this.y;
    if (localView != null) {
      localView.getViewTreeObserver().removeOnGlobalLayoutListener(this.H3);
    }
    super.onDestroy();
  }
  
  protected void onResume()
  {
    super.onResume();
    d.I(this);
  }
  
  class a
    implements DeviceShareBlacklistRecordAdapter.c
  {
    a() {}
    
    public void a(ShareBlacklistItemResult paramShareBlacklistItemResult)
    {
      if (paramShareBlacklistItemResult.getEmail() != null)
      {
        DeviceShareBlacklistAddUserActivity.e1(DeviceShareBlacklistAddUserActivity.this).setText(paramShareBlacklistItemResult.getEmail());
        DeviceShareBlacklistAddUserActivity.e1(DeviceShareBlacklistAddUserActivity.this).setSelection(paramShareBlacklistItemResult.getEmail().length());
      }
    }
  }
  
  class b
    implements d0.g
  {
    b() {}
    
    public void a()
    {
      WssAmazonInstrWebActivity.j1(DeviceShareBlacklistAddUserActivity.this, "https://www.tp-link.com/en/support/faq/1439/");
    }
  }
  
  class c
    implements Observer<i<Void>>
  {
    c() {}
    
    public void a(@Nullable i<Void> parami)
    {
      
      if (parami != null) {
        if (parami.b() == 0)
        {
          DeviceShareBlacklistAddUserActivity.this.setResult(-1);
          DeviceShareBlacklistAddUserActivity.this.finish();
        }
        else if (parami.b() == 44918)
        {
          s0.n(DeviceShareBlacklistAddUserActivity.this, 2131951734);
        }
        else
        {
          parami = DeviceShareBlacklistAddUserActivity.this;
          s0.p(parami, parami.getString(2131952444));
        }
      }
    }
  }
  
  class d
    implements TextWatcher
  {
    d() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      DeviceShareBlacklistAddUserActivity.f1(DeviceShareBlacklistAddUserActivity.this).setEnabled(b.c(DeviceShareBlacklistAddUserActivity.e1(DeviceShareBlacklistAddUserActivity.this).getText().toString().trim()));
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  class e
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    e() {}
    
    public void onGlobalLayout()
    {
      if (DeviceShareBlacklistAddUserActivity.g1(DeviceShareBlacklistAddUserActivity.this) != null)
      {
        View localView = DeviceShareBlacklistAddUserActivity.g1(DeviceShareBlacklistAddUserActivity.this);
        int i;
        if (DeviceShareBlacklistAddUserActivity.h1(DeviceShareBlacklistAddUserActivity.this)) {
          i = 0;
        } else {
          i = 8;
        }
        localView.setVisibility(i);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\deviceshare\DeviceShareBlacklistAddUserActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */