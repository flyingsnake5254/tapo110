package com.tplink.iot.viewmodel.ipcamera.setting;

import android.app.Application;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CameraSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CommonCameraRepository;
import com.tplink.libtpnetwork.cameranetwork.model.SdCardInfoCache;
import com.tplink.libtpnetwork.cameranetwork.model.SdCardStatus;
import com.tplink.libtpnetwork.cameranetwork.model.SettingsData;
import io.reactivex.e0.b;
import io.reactivex.e0.c;
import io.reactivex.q;
import java.util.concurrent.TimeUnit;

public class StoreManageViewModel
  extends AndroidViewModel
{
  public ObservableBoolean a = new ObservableBoolean(false);
  public final Drawable b = getApplication().getResources().getDrawable(2131231483);
  public final Drawable c = getApplication().getResources().getDrawable(2131231482);
  public final Drawable d = getApplication().getResources().getDrawable(2131231484);
  public final Drawable e = getApplication().getResources().getDrawable(2131231485);
  public final Drawable f = getApplication().getResources().getDrawable(2131231485);
  public final Drawable g = getApplication().getResources().getDrawable(2131231481);
  public ObservableField<String> h = new ObservableField();
  public ObservableField<String> i = new ObservableField();
  public ObservableInt j = new ObservableInt();
  public ObservableField<String> k = new ObservableField();
  public ObservableBoolean l = new ObservableBoolean(false);
  public ObservableBoolean m = new ObservableBoolean(false);
  public ObservableBoolean n = new ObservableBoolean(true);
  public ObservableField<Drawable> o = new ObservableField();
  public ObservableField<SdCardStatus> p = new ObservableField();
  public ObservableBoolean q = new ObservableBoolean();
  public ObservableBoolean r = new ObservableBoolean(false);
  private b s = new b();
  public MutableLiveData<Integer> t = new MutableLiveData();
  private int u = 0;
  public MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> v = new MutableLiveData();
  public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> w = new MutableLiveData();
  private String x;
  private CameraSettingRepository y;
  private CommonCameraRepository z;
  
  public StoreManageViewModel(@NonNull Application paramApplication, TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramApplication);
    paramApplication = paramTPCameraDeviceContext.getDeviceIdMD5();
    this.x = paramApplication;
    this.y = ((CameraSettingRepository)e.c(paramApplication, CameraSettingRepository.class));
    this.z = ((CommonCameraRepository)e.c(this.x, CommonCameraRepository.class));
  }
  
  private void j()
  {
    if (this.y.x().getSdCardInfoCache() != null)
    {
      this.r.set("dilatant_suspect".equals(this.y.x().getSdCardInfoCache().getDetectStatus()));
      this.p.set(this.y.x().getSdCardInfoCache().getStatus());
      Object localObject1;
      Object localObject2;
      Object localObject3;
      if (this.r.get())
      {
        this.o.set(this.g);
        localObject1 = this.y.x().getSdCardInfoCache().getTotalSpace();
        localObject2 = this.y.x().getSdCardInfoCache().getUsedSpace();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("total space:");
        ((StringBuilder)localObject3).append((String)localObject1);
        b.d.w.c.a.e("SDCardManage", ((StringBuilder)localObject3).toString());
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("used space:");
        ((StringBuilder)localObject3).append((String)localObject2);
        b.d.w.c.a.e("SDCardManage", ((StringBuilder)localObject3).toString());
        this.q.set(false);
        this.m.set(false);
        I();
      }
      else if (SdCardStatus.UNFORMATTED.equals(this.p.get()))
      {
        this.h.set(getApplication().getString(2131953875));
        this.i.set(getApplication().getString(2131953876));
        this.k.set(getApplication().getString(2131953844));
        this.o.set(this.e);
        this.q.set(false);
      }
      else if (SdCardStatus.ABNORMAL.equals(this.p.get()))
      {
        this.h.set(getApplication().getString(2131953877));
        this.i.set(getApplication().getString(2131953878));
        this.k.set(getApplication().getString(2131953844));
        this.o.set(this.f);
        this.q.set(false);
      }
      else
      {
        localObject3 = this.y.x().getSdCardInfoCache().getTotalSpace();
        localObject2 = this.y.x().getSdCardInfoCache().getUsedSpace();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("total space:");
        ((StringBuilder)localObject1).append((String)localObject3);
        b.d.w.c.a.e("SDCardManage", ((StringBuilder)localObject1).toString());
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("used space:");
        ((StringBuilder)localObject1).append((String)localObject2);
        b.d.w.c.a.e("SDCardManage", ((StringBuilder)localObject1).toString());
        this.q.set(true);
        this.j.set(this.y.D((String)localObject2, (String)localObject3));
        if (TextUtils.equals((CharSequence)localObject3, (CharSequence)localObject2)) {
          this.p.set(SdCardStatus.FULL);
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("currentStatus: ");
        ((StringBuilder)localObject2).append(((SdCardStatus)this.p.get()).name());
        b.d.w.c.a.e("SDCardManage", ((StringBuilder)localObject2).toString());
        if (SdCardStatus.NORMAL.equals(this.p.get()))
        {
          this.h.set(getApplication().getString(2131952558));
          this.i.set(null);
          this.o.set(this.b);
        }
        else if (SdCardStatus.FULL.equals(this.p.get()))
        {
          this.h.set(getApplication().getString(2131953873));
          this.i.set(getApplication().getString(2131953874));
          this.o.set(this.c);
        }
        else if (SdCardStatus.FORMATTING.equals(this.p.get()))
        {
          this.i.set(getApplication().getString(2131952557));
          this.l.set(true);
          this.t.postValue(Integer.valueOf(0));
          h();
        }
        else if (SdCardStatus.INSUFFICIENT.equals(this.p.get()))
        {
          this.o.set(this.c);
        }
        if (this.m.get())
        {
          this.o.set(this.d);
          this.h.set(getApplication().getString(2131953838));
          this.i.set(null);
        }
        I();
      }
    }
  }
  
  public q<Boolean> F()
  {
    return this.z.K0().N(new m8(this));
  }
  
  public void G(String paramString)
  {
    this.x = paramString;
  }
  
  public void H(boolean paramBoolean)
  {
    c localc = this.y.C1(paramBoolean).F(new o8(this)).y(new g8(this)).H0(new p8(this), new j8(this));
    this.s.b(localc);
  }
  
  public void I()
  {
    String str = this.y.x().getSdCardInfoCache().getTotalSpace();
    Object localObject1 = this.y.x().getSdCardInfoCache().getUsedSpace();
    Object localObject2;
    if (this.m.get())
    {
      localObject1 = this.k;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(getApplication().getString(2131953838));
      ((StringBuilder)localObject2).append("/");
      ((StringBuilder)localObject2).append(str);
      ((ObservableField)localObject1).set(((StringBuilder)localObject2).toString());
    }
    else
    {
      localObject2 = this.k;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("/");
      localStringBuilder.append(str);
      ((ObservableField)localObject2).set(localStringBuilder.toString());
    }
  }
  
  public void f()
  {
    this.s.dispose();
    this.s.d();
    this.s = new b();
  }
  
  public void g()
  {
    this.s.b(this.y.v().H0(new l8(this), new h8(this)));
  }
  
  public void h()
  {
    this.s.b(this.y.G().L0(io.reactivex.l0.a.c()).o(5L, TimeUnit.SECONDS).s0(new n8(this)).H0(new i8(this), new k8(this)));
  }
  
  public void i()
  {
    SdCardInfoCache localSdCardInfoCache = this.y.x().getSdCardInfoCache();
    if (localSdCardInfoCache != null) {
      this.m.set(localSdCardInfoCache.getLoopEnable());
    }
    this.n.set(true);
    j();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\setting\StoreManageViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */