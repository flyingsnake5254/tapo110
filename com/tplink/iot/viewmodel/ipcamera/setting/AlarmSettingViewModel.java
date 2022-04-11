package com.tplink.iot.viewmodel.ipcamera.setting;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tplink.iot.Utils.x0.d;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.model.AlertOption;
import com.tplink.libtpnetwork.cameranetwork.business.model.a;
import com.tplink.libtpnetwork.cameranetwork.business.repo.AlarmSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.model.AlarmSoundType;
import com.tplink.libtpnetwork.cameranetwork.model.BitwiseWeekDay;
import com.tplink.libtpnetwork.cameranetwork.model.BitwiseWeekDayUtils;
import com.tplink.libtpnetwork.cameranetwork.model.Schedule;
import io.reactivex.e0.c;
import java.util.List;
import java.util.Locale;

public class AlarmSettingViewModel
  extends AndroidViewModel
{
  public final MutableLiveData<Boolean> a;
  public final MutableLiveData<Boolean> b;
  public final MutableLiveData<Boolean> c;
  public ObservableBoolean d;
  public ObservableBoolean e;
  public ObservableField<String> f;
  public ObservableField<String> g;
  public ObservableField<String> h;
  public ObservableField<String> i;
  public ObservableInt j;
  public ObservableBoolean k;
  public ObservableBoolean l;
  private AlertOption m;
  private AlarmSoundType n;
  public a o;
  private io.reactivex.e0.b p;
  private AlarmSettingRepository q;
  private String r;
  private int s;
  private boolean t;
  
  public AlarmSettingViewModel(@NonNull Application paramApplication, TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramApplication);
    paramApplication = Boolean.FALSE;
    this.a = new MutableLiveData(paramApplication);
    this.b = new MutableLiveData(paramApplication);
    this.c = new MutableLiveData(paramApplication);
    this.d = new ObservableBoolean(false);
    this.e = new ObservableBoolean(true);
    this.f = new ObservableField();
    this.g = new ObservableField();
    this.h = new ObservableField("00:00");
    this.i = new ObservableField("23:59");
    this.j = new ObservableInt(127);
    this.k = new ObservableBoolean(false);
    this.l = new ObservableBoolean(false);
    this.p = new io.reactivex.e0.b();
    paramApplication = paramTPCameraDeviceContext.getDeviceIdMD5();
    this.r = paramApplication;
    this.q = ((AlarmSettingRepository)e.c(paramApplication, AlarmSettingRepository.class));
  }
  
  private void K()
  {
    L(true);
  }
  
  private void L(boolean paramBoolean)
  {
    Object localObject = this.q.z();
    this.d.set(((com.tplink.libtpnetwork.cameranetwork.business.model.b)localObject).d());
    this.c.postValue(Boolean.valueOf(((com.tplink.libtpnetwork.cameranetwork.business.model.b)localObject).f()));
    ObservableBoolean localObservableBoolean = this.e;
    boolean bool1 = ((com.tplink.libtpnetwork.cameranetwork.business.model.b)localObject).g();
    boolean bool2 = false;
    if ((bool1) && (((com.tplink.libtpnetwork.cameranetwork.business.model.b)localObject).d())) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    localObservableBoolean.set(bool1);
    this.m = k(((com.tplink.libtpnetwork.cameranetwork.business.model.b)localObject).g(), ((com.tplink.libtpnetwork.cameranetwork.business.model.b)localObject).e());
    this.n = ((com.tplink.libtpnetwork.cameranetwork.business.model.b)localObject).c();
    this.f.set(g(this.m));
    localObservableBoolean = this.l;
    bool1 = bool2;
    if (this.m != AlertOption.LIGHT) {
      bool1 = true;
    }
    localObservableBoolean.set(bool1);
    this.g.set(h(this.n));
    if (((com.tplink.libtpnetwork.cameranetwork.business.model.b)localObject).b() != null) {
      this.o = ((com.tplink.libtpnetwork.cameranetwork.business.model.b)localObject).b();
    } else {
      this.o = new a(0, 0, 23, 59, BitwiseWeekDayUtils.daysFromRawSet(127));
    }
    localObject = ((com.tplink.libtpnetwork.cameranetwork.business.model.b)localObject).b();
    this.o = ((a)localObject);
    if (!paramBoolean) {
      return;
    }
    if (localObject != null)
    {
      localObject = ((a)localObject).b();
      this.h.set(i(((Schedule)localObject).getStartHour(), ((Schedule)localObject).getStartMinute()));
      this.i.set(i(((Schedule)localObject).getEndHour(), ((Schedule)localObject).getEndMinute()));
      this.k.set(((Schedule)localObject).isCrossTwoDays());
      this.j.set(((Schedule)localObject).getType());
    }
  }
  
  private void M()
  {
    b.d.q.b.l.g(this.r, this.t, new j(this));
  }
  
  private void R()
  {
    a locala = this.o;
    if ((locala == null) || (locala.b() == null)) {
      this.o = new a(0, 0, 23, 59, BitwiseWeekDayUtils.daysFromRawSet(127));
    }
  }
  
  private void S(boolean paramBoolean)
  {
    b.d.q.b.l.s(this.r, this.t, new g(this, paramBoolean));
  }
  
  private void f(io.reactivex.q<Boolean> paramq)
  {
    paramq = paramq.F(new n(this)).y(new k(this)).H0(new l(this), new p(this));
    this.p.b(paramq);
  }
  
  private String g(AlertOption paramAlertOption)
  {
    int i1 = a.a[paramAlertOption.ordinal()];
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3) {
          return "";
        }
        return getApplication().getString(2131951808);
      }
      return getApplication().getString(2131951806);
    }
    return getApplication().getString(2131951807);
  }
  
  private String h(AlarmSoundType paramAlarmSoundType)
  {
    if (paramAlarmSoundType != null)
    {
      if (a.b[paramAlarmSoundType.ordinal()] != 1) {
        return getApplication().getString(2131951802);
      }
      return getApplication().getString(2131951803);
    }
    return "";
  }
  
  private String i(int paramInt1, int paramInt2)
  {
    return String.format(Locale.US, "%02d:%02d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  private static AlertOption k(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2)) {
      return AlertOption.BOTH;
    }
    if (paramBoolean2) {
      return AlertOption.LIGHT;
    }
    return AlertOption.SOUND;
  }
  
  public void N()
  {
    if (this.s == 3) {
      L(false);
    } else {
      M();
    }
  }
  
  public void O()
  {
    if (this.s == 3)
    {
      R();
      f(this.q.u(false, this.o));
    }
    else
    {
      S(false);
    }
  }
  
  public void P()
  {
    if (this.s == 3)
    {
      R();
      f(this.q.u(true, this.o));
    }
    else
    {
      S(true);
    }
  }
  
  public boolean[] Q(int paramInt)
  {
    List localList1 = BitwiseWeekDayUtils.getAllDays();
    List localList2 = BitwiseWeekDayUtils.daysFromRawSet(paramInt);
    boolean[] arrayOfBoolean = new boolean[localList1.size()];
    for (paramInt = 0; paramInt < localList1.size(); paramInt++) {
      arrayOfBoolean[paramInt] = localList2.contains(localList1.get(paramInt));
    }
    return arrayOfBoolean;
  }
  
  public void T(boolean paramBoolean)
  {
    if (this.s == 3) {
      f(this.q.s(paramBoolean));
    } else {
      b.d.q.b.l.s(this.r, this.t, new o(this, paramBoolean));
    }
    String str = this.r;
    boolean bool;
    if (this.s != 3) {
      bool = true;
    } else {
      bool = false;
    }
    d.a(str, paramBoolean, bool);
  }
  
  public void U(boolean paramBoolean, @NonNull String paramString1, @NonNull String paramString2, @NonNull List<BitwiseWeekDay> paramList)
  {
    paramString1 = paramString1.split(":");
    if (paramString1.length == 2) {
      try
      {
        i1 = Integer.parseInt(paramString1[0]);
        try
        {
          i2 = Integer.parseInt(paramString1[1]);
          i3 = i1;
        }
        catch (NumberFormatException paramString1) {}
        paramString1.printStackTrace();
      }
      catch (NumberFormatException paramString1)
      {
        i1 = 0;
      }
    } else {
      i1 = 0;
    }
    int i2 = 0;
    int i3 = i1;
    paramString1 = paramString2.split(":");
    int i4 = paramString1.length;
    int i1 = 23;
    if (i4 == 2) {
      try
      {
        i4 = Integer.parseInt(paramString1[0]);
        i1 = i4;
        i5 = Integer.parseInt(paramString1[1]);
        i1 = i5;
        i5 = i4;
        i4 = i1;
      }
      catch (NumberFormatException paramString1)
      {
        paramString1.printStackTrace();
        break label131;
      }
    } else {
      i1 = 23;
    }
    label131:
    i4 = 59;
    int i5 = i1;
    paramString1 = new a(i3, i2, i5, i4, paramList);
    paramString2 = paramString1.b();
    this.h.set(i(paramString2.getStartHour(), paramString2.getStartMinute()));
    this.i.set(i(paramString2.getEndHour(), paramString2.getEndMinute()));
    this.k.set(paramString2.isCrossTwoDays());
    this.j.set(paramString2.getType());
    if (this.s == 3) {
      f(this.q.u(paramBoolean, paramString1));
    } else {
      b.d.q.b.l.s(this.r, this.t, new h(paramBoolean, paramString2));
    }
  }
  
  public a j()
  {
    return this.o;
  }
  
  public void l(int paramInt)
  {
    this.s = paramInt;
    boolean bool = true;
    if (paramInt != 1) {
      bool = false;
    }
    this.t = bool;
    if (paramInt == 3)
    {
      c localc = this.q.M().F(new f(this)).y(new i(this)).H0(new m(this), new q(this));
      this.p.b(localc);
    }
    else
    {
      M();
    }
  }
  
  protected void onCleared()
  {
    super.onCleared();
    this.p.dispose();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\setting\AlarmSettingViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */