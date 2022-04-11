package com.tplink.iot.view.smart.template;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.h;
import com.bumptech.glide.i;
import com.bumptech.glide.load.engine.j;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.tplink.iot.adapter.smart.SmartTaskAdapter;
import com.tplink.iot.adapter.smart.SmartTriggerAdapter;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.smart.common.SmartAction;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.cloud.bean.smart.common.SmartTemplate;
import com.tplink.iot.cloud.bean.smart.common.SmartThingAction;
import com.tplink.iot.cloud.bean.smart.common.SmartTrigger;
import com.tplink.iot.cloud.bean.thing.common.ThingInfo;
import com.tplink.iot.viewmodel.smart.ActionSetupViewModel;
import com.tplink.iot.viewmodel.smart.SmartTemplateViewModel;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import java.util.Iterator;
import java.util.List;

public class SmartTemplateDetailActivity
  extends BaseActivity
{
  private SmartInfo H3 = null;
  private SmartTriggerAdapter I3;
  private SmartTaskAdapter J3;
  private SmartTemplateViewModel p0;
  private ActionSetupViewModel p1;
  private int p2 = 0;
  private SmartTemplate p3 = null;
  private Button y;
  private CollapsingToolbarLayout z;
  
  private void e1()
  {
    Object localObject = (Toolbar)findViewById(2131364170);
    ((Toolbar)localObject).setNavigationIcon(2131689849);
    setSupportActionBar((Toolbar)localObject);
    ((Toolbar)localObject).setNavigationOnClickListener(new f(this));
    this.z = ((CollapsingToolbarLayout)findViewById(2131362280));
    this.y = ((Button)findViewById(2131362142));
    this.I3 = new SmartTriggerAdapter(this, true);
    localObject = (RecyclerView)findViewById(2131362354);
    ((RecyclerView)localObject).setLayoutManager(new LinearLayoutManager(this));
    ((RecyclerView)localObject).setAdapter(this.I3);
    ((RecyclerView)localObject).setNestedScrollingEnabled(false);
    this.J3 = new SmartTaskAdapter(this, true);
    localObject = (RecyclerView)findViewById(2131362355);
    ((RecyclerView)localObject).setLayoutManager(new LinearLayoutManager(this));
    ((RecyclerView)localObject).setAdapter(this.J3);
    ((RecyclerView)localObject).setNestedScrollingEnabled(false);
  }
  
  public static Intent r1(Context paramContext, int paramInt)
  {
    paramContext = new Intent(paramContext, SmartTemplateDetailActivity.class);
    paramContext.putExtra("template_item_index", paramInt);
    return paramContext;
  }
  
  private void s1(SmartTemplate paramSmartTemplate)
  {
    if (paramSmartTemplate == null)
    {
      finish();
      return;
    }
    if (com.tplink.iot.view.smart.a.g.c(paramSmartTemplate)) {
      localObject1 = getString(2131954028);
    } else {
      localObject1 = paramSmartTemplate.getTitle();
    }
    this.z.setTitle((CharSequence)localObject1);
    ((TextView)findViewById(2131364653)).setText(paramSmartTemplate.getSubTitle());
    ((TextView)findViewById(2131364666)).setText(paramSmartTemplate.getName());
    Object localObject2 = (ImageView)findViewById(2131362000);
    Object localObject1 = (com.bumptech.glide.request.g)((com.bumptech.glide.request.g)((com.bumptech.glide.request.g)((com.bumptech.glide.request.g)new com.bumptech.glide.request.g().V(2131690377)).j(2131690377)).g()).f(j.d);
    com.bumptech.glide.c.u(((ImageView)localObject2).getContext()).s(paramSmartTemplate.getTitleDetailImgUrl()).m0((com.bumptech.glide.request.a)localObject1).x0((ImageView)localObject2);
    this.I3.A(paramSmartTemplate.getTriggerSetting());
    this.J3.t(paramSmartTemplate.getActionSetting());
    this.J3.u(paramSmartTemplate.getMarketingUrls());
    localObject1 = paramSmartTemplate.getTriggerSetting();
    boolean bool1 = false;
    if ((localObject1 != null) && (!paramSmartTemplate.getTriggerSetting().isManual())) {
      this.p1.M(false);
    }
    findViewById(2131362143).setOnClickListener(new d(this));
    localObject1 = (List)this.p0.h().getValue();
    boolean bool2 = bool1;
    if (localObject1 != null)
    {
      bool2 = bool1;
      if (!((List)localObject1).isEmpty())
      {
        bool2 = bool1;
        if (paramSmartTemplate.getActionSetting() != null)
        {
          Iterator localIterator1 = paramSmartTemplate.getActionSetting().getThings().iterator();
          bool2 = false;
          for (;;)
          {
            if (!localIterator1.hasNext()) {
              break label402;
            }
            paramSmartTemplate = (SmartThingAction)localIterator1.next();
            Iterator localIterator2 = ((List)localObject1).iterator();
            if (localIterator2.hasNext())
            {
              localObject2 = (ThingInfo)localIterator2.next();
              int i;
              if ((com.tplink.iot.view.smart.a.b.d(paramSmartTemplate.getCategory(), (ThingInfo)localObject2)) && (this.p1.Q(((ThingInfo)localObject2).getThingModelId(), paramSmartTemplate, ((ThingInfo)localObject2).getThingName()))) {
                i = 1;
              } else {
                i = 0;
              }
              if (i == 0) {
                break;
              }
              this.y.setOnClickListener(new a(this));
              bool2 = true;
            }
          }
        }
      }
    }
    label402:
    paramSmartTemplate = this.y;
    float f;
    if (bool2) {
      f = 1.0F;
    } else {
      f = 0.4F;
    }
    paramSmartTemplate.setAlpha(f);
    this.y.setEnabled(bool2);
  }
  
  private void t1()
  {
    this.p0.g();
    this.p0.f();
  }
  
  private void u1()
  {
    this.p0.k().observe(this, new c(this));
    this.p1.x().observe(this, new b(this));
    this.p1.B().observe(this, new e(this));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558662);
    com.tplink.iot.view.quicksetup.base.d.J(this, findViewById(2131364170));
    this.p0 = ((SmartTemplateViewModel)ViewModelProviders.of(this).get(SmartTemplateViewModel.class));
    this.p1 = ((ActionSetupViewModel)ViewModelProviders.of(this).get(ActionSetupViewModel.class));
    if (getIntent() != null) {
      this.p2 = getIntent().getIntExtra("template_item_index", 0);
    } else {
      finish();
    }
    e1();
    u1();
    t1();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\smart\template\SmartTemplateDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */