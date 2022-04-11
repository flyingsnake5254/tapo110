package com.tplink.iot.view.ipcamera.setting.aidetection;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.SeekBar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.SeekBarBindingAdapter.OnStopTrackingTouch;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import b.d.w.c.a;
import com.tplink.iot.Utils.v0.e;
import com.tplink.iot.Utils.x0.w;
import com.tplink.iot.Utils.z0.h;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.cloudvideo.common.OrderInfo;
import com.tplink.iot.core.o;
import com.tplink.iot.databinding.ActivityAiDetectionBinding;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.view.tapocare.BillingDialogActivity;
import com.tplink.iot.view.tapocare.TrialDialogActivity;
import com.tplink.iot.viewmodel.cloudvideo.CloudVideoViewModel;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.aidetection.AIDetectionViewModel;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.EventObserver;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.List;
import kotlin.v.d;

public final class AIDetectionActivity
  extends BaseActivity
  implements View.OnClickListener, SeekBarBindingAdapter.OnStopTrackingTouch
{
  public static final a y = new a(null);
  private String H3;
  private int I3 = 3;
  public AIDetectionViewModel p0;
  public CloudVideoViewModel p1;
  private ActivityAiDetectionBinding p2;
  private final io.reactivex.e0.b p3 = new io.reactivex.e0.b();
  private final String z = AIDetectionActivity.class.getSimpleName();
  
  private final void f1(MutableLiveData<Boolean> paramMutableLiveData)
  {
    AIDetectionViewModel localAIDetectionViewModel;
    if (kotlin.jvm.internal.j.a((Boolean)paramMutableLiveData.getValue(), Boolean.TRUE))
    {
      localAIDetectionViewModel = this.p0;
      if (localAIDetectionViewModel == null) {
        kotlin.jvm.internal.j.t("mViewModel");
      }
      localAIDetectionViewModel.O(paramMutableLiveData);
    }
    else
    {
      localAIDetectionViewModel = this.p0;
      if (localAIDetectionViewModel == null) {
        kotlin.jvm.internal.j.t("mViewModel");
      }
      localAIDetectionViewModel.l(paramMutableLiveData);
    }
  }
  
  private final void i1()
  {
    Object localObject = getIntent().getStringExtra("device_id_md5");
    if (localObject == null) {
      localObject = "";
    }
    this.H3 = ((String)localObject);
    this.I3 = getIntent().getIntExtra("detection_home_mode", 3);
    localObject = this.H3;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("deviceIdMD5");
    }
    localObject = ViewModelProviders.of(this, new CameraViewModelFactory(this, (String)localObject)).get(AIDetectionViewModel.class);
    kotlin.jvm.internal.j.d(localObject, "ViewModelProviders.of(th…ionViewModel::class.java)");
    this.p0 = ((AIDetectionViewModel)localObject);
    localObject = ViewModelProviders.of(this).get(CloudVideoViewModel.class);
    kotlin.jvm.internal.j.d(localObject, "ViewModelProviders.of(th…deoViewModel::class.java)");
    this.p1 = ((CloudVideoViewModel)localObject);
    localObject = this.p0;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("mViewModel");
    }
    ((AIDetectionViewModel)localObject).F(this.I3);
  }
  
  private final void j1()
  {
    AIDetectionViewModel localAIDetectionViewModel = this.p0;
    if (localAIDetectionViewModel == null) {
      kotlin.jvm.internal.j.t("mViewModel");
    }
    localAIDetectionViewModel.z().observe(this, new EventObserver(new b(this)));
    localAIDetectionViewModel.v().observe(this, new EventObserver(new c(this)));
    localAIDetectionViewModel.A().observe(this, new EventObserver(new d(localAIDetectionViewModel, this)));
  }
  
  private final void k1()
  {
    Object localObject = DataBindingUtil.setContentView(this, 2131558438);
    kotlin.jvm.internal.j.d(localObject, "DataBindingUtil.setConte…ut.activity_ai_detection)");
    localObject = (ActivityAiDetectionBinding)localObject;
    this.p2 = ((ActivityAiDetectionBinding)localObject);
    if (localObject == null) {
      kotlin.jvm.internal.j.t("mDataBinding");
    }
    AIDetectionViewModel localAIDetectionViewModel = this.p0;
    if (localAIDetectionViewModel == null) {
      kotlin.jvm.internal.j.t("mViewModel");
    }
    ((ActivityAiDetectionBinding)localObject).l(localAIDetectionViewModel);
    ((ActivityAiDetectionBinding)localObject).h(this);
    ((ActivityAiDetectionBinding)localObject).i(this);
    ((ViewDataBinding)localObject).setLifecycleOwner(this);
    setTitle(2131951787);
  }
  
  private final void l1()
  {
    CloudVideoViewModel localCloudVideoViewModel = this.p1;
    if (localCloudVideoViewModel == null) {
      kotlin.jvm.internal.j.t("mVideoCloudViewModel");
    }
    localCloudVideoViewModel.N().observe(this, new Observer()
    {
      public void a(List<? extends OrderInfo> paramAnonymousList)
      {
        this.a.g1().N().removeObserver(this);
        if (this.a.g1().H(paramAnonymousList, ""))
        {
          BillingDialogActivity.f1(this.a, e.x());
        }
        else
        {
          paramAnonymousList = this.a;
          BillingDialogActivity.f1(paramAnonymousList, e.c(h.j(paramAnonymousList.h1().s())));
        }
      }
    });
  }
  
  public final CloudVideoViewModel g1()
  {
    CloudVideoViewModel localCloudVideoViewModel = this.p1;
    if (localCloudVideoViewModel == null) {
      kotlin.jvm.internal.j.t("mVideoCloudViewModel");
    }
    return localCloudVideoViewModel;
  }
  
  public final AIDetectionViewModel h1()
  {
    AIDetectionViewModel localAIDetectionViewModel = this.p0;
    if (localAIDetectionViewModel == null) {
      kotlin.jvm.internal.j.t("mViewModel");
    }
    return localAIDetectionViewModel;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1345)
    {
      paramIntent = this.p0;
      if (paramIntent == null) {
        kotlin.jvm.internal.j.t("mViewModel");
      }
      paramIntent = h.o(paramIntent.s(), false, new e(this)).H0(f.c, g.c);
      this.p3.b(paramIntent);
      com.tplink.iot.Utils.v0.b.a().b();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView != null)
    {
      Object localObject;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131364020: 
        paramView = this.p0;
        if (paramView == null) {
          kotlin.jvm.internal.j.t("mViewModel");
        }
        paramView.p().setValue(Integer.valueOf(50));
        paramView = this.p0;
        if (paramView == null) {
          kotlin.jvm.internal.j.t("mViewModel");
        }
        paramView.E();
        break;
      case 2131364019: 
        paramView = this.p0;
        if (paramView == null) {
          kotlin.jvm.internal.j.t("mViewModel");
        }
        paramView.p().setValue(Integer.valueOf(0));
        paramView = this.p0;
        if (paramView == null) {
          kotlin.jvm.internal.j.t("mViewModel");
        }
        paramView.E();
        break;
      case 2131364017: 
        paramView = this.p0;
        if (paramView == null) {
          kotlin.jvm.internal.j.t("mViewModel");
        }
        paramView.p().setValue(Integer.valueOf(100));
        paramView = this.p0;
        if (paramView == null) {
          kotlin.jvm.internal.j.t("mViewModel");
        }
        paramView.E();
        break;
      case 2131362791: 
        paramView = this.p0;
        if (paramView == null) {
          kotlin.jvm.internal.j.t("mViewModel");
        }
        paramView = paramView.s();
        localObject = this.p0;
        if (localObject == null) {
          kotlin.jvm.internal.j.t("mViewModel");
        }
        w.A(paramView, kotlin.jvm.internal.j.a((Boolean)((AIDetectionViewModel)localObject).t().getValue(), Boolean.FALSE));
        paramView = this.p0;
        if (paramView == null) {
          kotlin.jvm.internal.j.t("mViewModel");
        }
        f1(paramView.t());
        break;
      case 2131361998: 
        paramView = this.p0;
        if (paramView == null) {
          kotlin.jvm.internal.j.t("mViewModel");
        }
        paramView = (Integer)paramView.p().getValue();
        localObject = this.p0;
        if (localObject == null) {
          kotlin.jvm.internal.j.t("mViewModel");
        }
        int i = ((AIDetectionViewModel)localObject).w();
        if ((paramView != null) && (paramView.intValue() == i))
        {
          paramView = "high";
        }
        else
        {
          paramView = this.p0;
          if (paramView == null) {
            kotlin.jvm.internal.j.t("mViewModel");
          }
          paramView = (Integer)paramView.p().getValue();
          localObject = this.p0;
          if (localObject == null) {
            kotlin.jvm.internal.j.t("mViewModel");
          }
          i = ((AIDetectionViewModel)localObject).y();
          if ((paramView != null) && (paramView.intValue() == i)) {
            paramView = "medium";
          } else {
            paramView = "low";
          }
        }
        localObject = this.p0;
        if (localObject == null) {
          kotlin.jvm.internal.j.t("mViewModel");
        }
        localObject = ((AIDetectionViewModel)localObject).s();
        AIDetectionViewModel localAIDetectionViewModel = this.p0;
        if (localAIDetectionViewModel == null) {
          kotlin.jvm.internal.j.t("mViewModel");
        }
        w.a((String)localObject, kotlin.jvm.internal.j.a((Boolean)localAIDetectionViewModel.o().getValue(), Boolean.FALSE), paramView);
        paramView = this.p0;
        if (paramView == null) {
          kotlin.jvm.internal.j.t("mViewModel");
        }
        f1(paramView.o());
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    i1();
    k1();
    j1();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.p3.d();
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (paramSeekBar != null)
    {
      int i = paramSeekBar.getProgress();
      Object localObject = this.p0;
      if (localObject == null) {
        kotlin.jvm.internal.j.t("mViewModel");
      }
      localObject = ((AIDetectionViewModel)localObject).p();
      int j = paramSeekBar.getMax();
      double d = j;
      int k = (int)(0.75D * d);
      paramSeekBar = new d(k, j);
      d locald = new d((int)(d * 0.25D), k);
      if ((paramSeekBar.f(i)) && (!com.tplink.libtpnetwork.Utils.j.b((MutableLiveData)localObject, Integer.valueOf(i)))) {
        ((MutableLiveData)localObject).setValue(Integer.valueOf(j));
      } else if ((locald.f(i)) && (!com.tplink.libtpnetwork.Utils.j.b((MutableLiveData)localObject, Integer.valueOf(i)))) {
        ((MutableLiveData)localObject).setValue(Integer.valueOf(j / 2));
      } else if (!com.tplink.libtpnetwork.Utils.j.b((MutableLiveData)localObject, Integer.valueOf(i))) {
        ((MutableLiveData)localObject).setValue(Integer.valueOf(0));
      }
      paramSeekBar = this.p0;
      if (paramSeekBar == null) {
        kotlin.jvm.internal.j.t("mViewModel");
      }
      paramSeekBar.E();
    }
  }
  
  public static final class a
  {
    public final void a(Context paramContext, String paramString, int paramInt)
    {
      kotlin.jvm.internal.j.e(paramContext, "context");
      kotlin.jvm.internal.j.e(paramString, "deviceIdMD5");
      Intent localIntent = new Intent(paramContext, AIDetectionActivity.class);
      localIntent.putExtra("device_id_md5", paramString);
      localIntent.putExtra("detection_home_mode", paramInt);
      paramContext.startActivity(localIntent);
    }
  }
  
  static final class b<T>
    implements Observer<Boolean>
  {
    b(AIDetectionActivity paramAIDetectionActivity) {}
    
    public final void a(Boolean paramBoolean)
    {
      if (kotlin.jvm.internal.j.a(paramBoolean, Boolean.TRUE)) {
        AIDetectionActivity.e1(this.a);
      }
    }
  }
  
  static final class c<T>
    implements Observer<String>
  {
    c(AIDetectionActivity paramAIDetectionActivity) {}
    
    public final void a(String paramString)
    {
      if (paramString != null) {
        TSnackbar.y(this.a, paramString, -1).N();
      }
    }
  }
  
  static final class d<T>
    implements Observer<Boolean>
  {
    d(AIDetectionViewModel paramAIDetectionViewModel, AIDetectionActivity paramAIDetectionActivity) {}
    
    public final void a(Boolean paramBoolean)
    {
      if (kotlin.jvm.internal.j.a(paramBoolean, Boolean.TRUE)) {
        TrialDialogActivity.f1(jdField_this, e.d(h.j(this.a.s())));
      }
    }
  }
  
  static final class e<T>
    implements com.tplink.libtpnetwork.Utils.f0.b<Boolean>
  {
    e(AIDetectionActivity paramAIDetectionActivity) {}
    
    public final void b(Boolean paramBoolean)
    {
      this.a.h1().L().setValue(paramBoolean);
    }
  }
  
  static final class f<T>
    implements g<Integer>
  {
    public static final f c = new f();
    
    public final void a(int paramInt) {}
  }
  
  static final class g<T>
    implements g<Throwable>
  {
    public static final g c = new g();
    
    public final void a(Throwable paramThrowable)
    {
      a.e("CameraSettingsActivity", Log.getStackTraceString(paramThrowable));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\aidetection\AIDetectionActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */