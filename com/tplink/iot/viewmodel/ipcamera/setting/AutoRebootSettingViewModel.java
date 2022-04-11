package com.tplink.iot.viewmodel.ipcamera.setting;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CameraSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CommonCameraRepository;
import com.tplink.libtpnetwork.cameranetwork.model.OptionSwitch;
import com.tplink.libtpnetwork.cameranetwork.model.RebootInfo;
import com.tplink.libtpnetwork.cameranetwork.model.RebootInfoCache;
import io.reactivex.e0.b;
import io.reactivex.e0.c;
import io.reactivex.g0.a;
import io.reactivex.q;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AutoRebootSettingViewModel
  extends AndroidViewModel
{
  private CameraSettingRepository a;
  private CommonCameraRepository b;
  public ObservableBoolean c = new ObservableBoolean(false);
  private b d = new b();
  private String e;
  public RebootInfoCache f;
  private MutableLiveData<RebootInfoCache> g = new MutableLiveData();
  private SingleLiveEvent<Integer> h = new SingleLiveEvent();
  private boolean i = false;
  
  public AutoRebootSettingViewModel(@NonNull Application paramApplication, TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramApplication);
    this.e = paramTPCameraDeviceContext.getDeviceIdMD5();
    this.b = ((CommonCameraRepository)e.b(paramTPCameraDeviceContext, CommonCameraRepository.class));
    this.a = ((CameraSettingRepository)e.b(paramTPCameraDeviceContext, CameraSettingRepository.class));
  }
  
  private void v()
  {
    c localc = this.a.E().F(new b()).y(new a()).H0(new z0(this), a1.c);
    this.d.b(localc);
  }
  
  private String x(int paramInt)
  {
    int j = paramInt / 60 % 24;
    paramInt %= 60;
    Object localObject = new java/lang/StringBuilder;
    if (j < 10)
    {
      ((StringBuilder)localObject).<init>();
      ((StringBuilder)localObject).append("0");
    }
    else
    {
      ((StringBuilder)localObject).<init>();
      ((StringBuilder)localObject).append("");
    }
    ((StringBuilder)localObject).append(j);
    String str = ((StringBuilder)localObject).toString();
    if (paramInt < 10)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("0");
      ((StringBuilder)localObject).append(paramInt);
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramInt);
      localObject = ((StringBuilder)localObject).toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(":");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(":00");
    return localStringBuilder.toString();
  }
  
  public LiveData<RebootInfoCache> f()
  {
    return this.g;
  }
  
  public SingleLiveEvent<Integer> g()
  {
    return this.h;
  }
  
  public int h(String paramString)
  {
    if (Pattern.compile("(\\d{2}):(\\d{2}):(\\d{2})").matcher(paramString).matches())
    {
      paramString = paramString.split(":");
      return Integer.parseInt(paramString[0]) * 60 + Integer.parseInt(paramString[1]);
    }
    return 180;
  }
  
  protected void onCleared()
  {
    super.onCleared();
    this.d.dispose();
  }
  
  public void u()
  {
    c localc = this.b.K0().H0(new d1(this), h9.c);
    this.d.b(localc);
  }
  
  public void w(boolean paramBoolean, int paramInt)
  {
    com.tplink.iot.Utils.x0.g.a(this.e, paramBoolean, x(paramInt));
    String str1 = OptionSwitch.fromBoolean(paramBoolean).getRaw();
    String str2 = x(paramInt);
    if (this.i) {
      localObject = Integer.valueOf(30);
    } else {
      localObject = null;
    }
    Object localObject = new RebootInfo(null, "0", str1, str2, (Integer)localObject);
    localObject = this.a.F1((RebootInfo)localObject).F(new y0(this)).y(new c()).H0(new c1(this), new b1(this));
    this.d.b((c)localObject);
  }
  
  class a
    implements a
  {
    a() {}
    
    public void run()
      throws Exception
    {
      AutoRebootSettingViewModel.this.c.set(false);
    }
  }
  
  class b
    implements io.reactivex.g0.g<c>
  {
    b() {}
    
    public void a(c paramc)
      throws Exception
    {
      AutoRebootSettingViewModel.this.c.set(true);
    }
  }
  
  class c
    implements a
  {
    c() {}
    
    public void run()
      throws Exception
    {
      AutoRebootSettingViewModel.this.c.set(false);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\setting\AutoRebootSettingViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */