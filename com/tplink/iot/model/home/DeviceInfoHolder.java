package com.tplink.iot.model.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.animation.Animation;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.Utils.u0;
import com.tplink.iot.Utils.w;
import com.tplink.iot.Utils.w0.a;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.Utils.z0.o;
import com.tplink.iot.Utils.z0.p;
import com.tplink.iot.Utils.z0.r;
import com.tplink.iot.devices.lightstrip.widget.LightingEffectPointView;
import com.tplink.iot.g.b.c.c;
import com.tplink.iot.g.d.a.b;
import com.tplink.iot.widget.RippleCardView;
import com.tplink.iot.widget.colorbulb.ColorPointHomeView;
import com.tplink.libtpcontrols.materialnormalcompat.checkbox.TPCheckboxCompat;
import com.tplink.libtpcontrols.materialnormalcompat.checkbox.TPCheckboxCompat.a;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.group.GroupBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.IoTLightStripDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.IoTSubDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.common.TriggerLog;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractSubThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.SensorRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.SwitchRepository;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;
import com.tplink.libtpnetwork.enumerate.EnumIoTDeviceState;
import com.tplink.libtpnetwork.enumerate.EnumTRVState;
import java.util.ArrayList;
import java.util.List;

public class DeviceInfoHolder
  extends RecyclerView.ViewHolder
  implements com.tplink.iot.adapter.home.i
{
  private TextView H3;
  private TextView I3;
  private TextView J3;
  private TextView K3;
  private ColorPointHomeView L3;
  private RelativeLayout M3;
  private LightingEffectPointView N3;
  private ImageView O3;
  private TPCheckboxCompat P3;
  private RippleCardView Q3;
  private CardView R3;
  private ImageView S3;
  private View T3;
  private ImageView U3;
  private boolean V3;
  private Context c;
  private Animation d;
  private e f;
  private ImageView p0;
  private TextView p1;
  private TextView p2;
  private TextView p3;
  private TextView q;
  private TextView x;
  private ImageView y;
  private ImageView z;
  
  public DeviceInfoHolder(Context paramContext, View paramView, Animation paramAnimation)
  {
    this(paramContext, paramView, paramAnimation, true);
  }
  
  public DeviceInfoHolder(Context paramContext, View paramView, Animation paramAnimation, boolean paramBoolean)
  {
    super(paramView);
    this.c = paramContext;
    this.T3 = paramView;
    this.d = paramAnimation;
    this.V3 = paramBoolean;
    this.q = ((TextView)paramView.findViewById(2131364409));
    this.x = ((TextView)paramView.findViewById(2131364484));
    this.y = ((ImageView)paramView.findViewById(2131363066));
    this.p0 = ((ImageView)paramView.findViewById(2131363077));
    this.p2 = ((TextView)paramView.findViewById(2131363067));
    this.p3 = ((TextView)paramView.findViewById(2131363006));
    this.L3 = ((ColorPointHomeView)paramView.findViewById(2131362290));
    this.H3 = ((TextView)paramView.findViewById(2131364403));
    this.I3 = ((TextView)paramView.findViewById(2131364522));
    this.J3 = ((TextView)paramView.findViewById(2131364704));
    this.K3 = ((TextView)paramView.findViewById(2131364702));
    this.M3 = ((RelativeLayout)paramView.findViewById(2131363882));
    this.N3 = ((LightingEffectPointView)paramView.findViewById(2131363235));
    this.O3 = ((ImageView)paramView.findViewById(2131363517));
    this.P3 = ((TPCheckboxCompat)paramView.findViewById(2131362205));
    this.Q3 = ((RippleCardView)paramView.findViewById(2131362351));
    this.R3 = ((CardView)paramView.findViewById(2131362727));
    this.S3 = ((ImageView)paramView.findViewById(2131362776));
    this.p1 = ((TextView)paramView.findViewById(2131363086));
    this.z = ((ImageView)paramView.findViewById(2131363029));
    this.U3 = ((ImageView)paramView.findViewById(2131363031));
    if (w.c()) {
      this.S3.setImageResource(2131231131);
    } else {
      this.S3.setImageResource(2131231132);
    }
    this.N3.setEffectImageId(2131689896);
  }
  
  private void A(e parame)
  {
    e locale = this.f;
    if (locale != null) {
      locale.d(parame);
    }
  }
  
  private void B(e parame)
  {
    e locale = this.f;
    if (locale != null) {
      locale.b(parame);
    }
  }
  
  private void C()
  {
    E();
    this.P3.setCompoundDrawablesRelativeWithIntrinsicBounds(this.c.getResources().getDrawable(2131231495), null, null, null);
    this.z.clearAnimation();
    this.z.setVisibility(4);
    this.Q3.setCardElevation(0.0F);
    this.Q3.setCardBackgroundColor(this.c.getResources().getColor(2131099743));
    this.R3.setCardBackgroundColor(o());
    this.q.setTextColor(this.c.getResources().getColor(2131099756));
    this.x.setTextColor(this.c.getResources().getColor(2131099756));
    TextView localTextView = this.p2;
    int i;
    if (t()) {
      i = 8;
    } else {
      i = 0;
    }
    localTextView.setVisibility(i);
    this.S3.setVisibility(4);
    this.p2.setText(this.c.getResources().getString(2131951749));
  }
  
  private void D()
  {
    this.P3.setCompoundDrawablesRelativeWithIntrinsicBounds(this.c.getResources().getDrawable(2131231495), null, null, null);
    this.Q3.setCardBackgroundColor(this.c.getResources().getColor(2131100206));
    this.q.setTextColor(this.c.getResources().getColor(2131099729));
    this.x.setTextColor(this.c.getResources().getColor(2131099754));
    this.S3.setVisibility(4);
  }
  
  private void E()
  {
    this.p3.setVisibility(8);
    this.p0.setVisibility(8);
    this.L3.setVisibility(8);
    this.H3.setVisibility(8);
    this.I3.setVisibility(8);
    this.N3.setVisibility(8);
    this.K3.setVisibility(8);
    this.J3.setVisibility(8);
  }
  
  private void F()
  {
    E();
    this.S3.setVisibility(4);
    this.p2.setVisibility(8);
    this.Q3.setCardElevation(com.tplink.iot.Utils.j.a(this.c, 2.0F));
    if (t())
    {
      this.z.setVisibility(4);
      this.z.clearAnimation();
    }
    else
    {
      this.z.setVisibility(0);
      if (this.z.getAnimation() == null) {
        this.z.startAnimation(this.d);
      }
    }
    this.P3.setCompoundDrawablesRelativeWithIntrinsicBounds(this.c.getResources().getDrawable(2131231495), null, null, null);
    this.Q3.setCardBackgroundColor(this.c.getResources().getColor(2131100206));
    this.R3.setCardBackgroundColor(o());
    this.q.setTextColor(this.c.getResources().getColor(2131099729));
    this.x.setTextColor(this.c.getResources().getColor(2131099754));
  }
  
  private void G()
  {
    E();
    this.P3.setCompoundDrawablesRelativeWithIntrinsicBounds(this.c.getResources().getDrawable(2131231495), null, null, null);
    this.z.clearAnimation();
    this.z.setVisibility(4);
    this.Q3.setCardElevation(0.0F);
    this.Q3.setCardBackgroundColor(this.c.getResources().getColor(2131099743));
    this.R3.setCardBackgroundColor(o());
    this.q.setTextColor(this.c.getResources().getColor(2131099756));
    this.x.setTextColor(this.c.getResources().getColor(2131099756));
    TextView localTextView = this.p2;
    int i;
    if (t()) {
      i = 8;
    } else {
      i = 0;
    }
    localTextView.setVisibility(i);
    this.S3.setVisibility(4);
  }
  
  private void H()
  {
    E();
    if (w.c()) {
      this.S3.setImageResource(2131231131);
    } else {
      this.S3.setImageResource(2131231132);
    }
    ImageView localImageView = this.S3;
    int i;
    if (t()) {
      i = 4;
    } else {
      i = 0;
    }
    localImageView.setVisibility(i);
    this.z.clearAnimation();
    this.z.setVisibility(4);
    this.p2.setVisibility(4);
    this.Q3.setCardElevation(com.tplink.iot.Utils.j.a(this.c, 2.0F));
  }
  
  private void I(k paramk)
  {
    if (paramk == null) {
      return;
    }
    BaseALIoTDevice localBaseALIoTDevice = paramk.g();
    if (localBaseALIoTDevice == null) {
      return;
    }
    TextView localTextView = this.p1;
    boolean bool = paramk.t();
    int i = 0;
    int j;
    if ((bool) && (this.V3)) {
      j = 0;
    } else {
      j = 8;
    }
    localTextView.setVisibility(j);
    this.q.setText(l.e(this.c, localBaseALIoTDevice.getDeviceType(), localBaseALIoTDevice.getDeviceName(), localBaseALIoTDevice.getDeviceModel()));
    l.o(this.c, localBaseALIoTDevice, this.y);
    this.x.setText(l.b(this.c, localBaseALIoTDevice));
    this.U3.setImageResource(2131689712);
    paramk = this.U3;
    if (localBaseALIoTDevice.isUserRoleTypeDevice()) {
      j = i;
    } else {
      j = 4;
    }
    paramk.setVisibility(j);
    this.p2.setText(2131952826);
    this.R3.setVisibility(8);
    M(localBaseALIoTDevice);
  }
  
  private void J(GroupBean paramGroupBean)
  {
    this.p0.setVisibility(8);
    TPCheckboxCompat localTPCheckboxCompat = this.P3;
    int i;
    if (t()) {
      i = 0;
    } else {
      i = 4;
    }
    localTPCheckboxCompat.setVisibility(i);
    if ((!paramGroupBean.isOnline()) && (!paramGroupBean.isPartOffline()))
    {
      if ((!paramGroupBean.isOffLine()) && (!paramGroupBean.isEmpty())) {
        F();
      } else {
        G();
      }
    }
    else
    {
      H();
      if (paramGroupBean.isDeviceOn())
      {
        if (paramGroupBean.isBulbGroup())
        {
          i = paramGroupBean.getBrightness();
          this.p3.setText(String.format("%d%%", new Object[] { Integer.valueOf(i) }));
          this.p3.setVisibility(0);
          if (o.f(paramGroupBean.getGroupInfo()))
          {
            this.L3.setVisibility(0);
            this.L3.setInnerCircleColor(com.tplink.libtpnetwork.Utils.g.e(paramGroupBean.getGroupInfo()));
          }
          else
          {
            this.L3.setVisibility(8);
          }
        }
        P();
      }
      else
      {
        O();
      }
    }
  }
  
  private void K(g paramg)
  {
    if (paramg == null) {
      return;
    }
    paramg = paramg.h();
    if (paramg == null) {
      return;
    }
    this.p1.setVisibility(8);
    this.q.setText(o.d(this.c, paramg.getName()));
    o.h(paramg, this.y);
    this.x.setText(o.b(paramg));
    this.U3.setImageResource(2131690245);
    Object localObject = this.U3;
    int i;
    if (paramg.isPartOffline()) {
      i = 0;
    } else {
      i = 4;
    }
    ((ImageView)localObject).setVisibility(i);
    localObject = this.p2;
    if (paramg.isEmpty()) {
      i = 2131953206;
    } else {
      i = 2131952826;
    }
    ((TextView)localObject).setText(i);
    this.R3.setVisibility(0);
    J(paramg);
  }
  
  private void L()
  {
    this.P3.setCompoundDrawablesRelativeWithIntrinsicBounds(this.c.getResources().getDrawable(2131231495), null, null, null);
    this.Q3.setCardBackgroundColor(this.c.getResources().getColor(2131100206));
    this.q.setTextColor(this.c.getResources().getColor(2131099729));
    this.x.setTextColor(this.c.getResources().getColor(2131099754));
  }
  
  @SuppressLint({"DefaultLocale"})
  private void M(BaseALIoTDevice paramBaseALIoTDevice)
  {
    Object localObject = this.M3;
    int i = 0;
    ((RelativeLayout)localObject).setVisibility(0);
    localObject = this.P3;
    int j;
    if (t()) {
      j = 0;
    } else {
      j = 4;
    }
    ((CheckBox)localObject).setVisibility(j);
    u(paramBaseALIoTDevice);
    if (((paramBaseALIoTDevice instanceof ALCameraDevice)) && (((ALCameraDevice)paramBaseALIoTDevice).isCameraLocked()))
    {
      C();
    }
    else if (paramBaseALIoTDevice.isOnline())
    {
      H();
      S(paramBaseALIoTDevice);
      R(paramBaseALIoTDevice);
      if (paramBaseALIoTDevice.isCamera())
      {
        D();
      }
      else if ((!paramBaseALIoTDevice.isHub()) && (!paramBaseALIoTDevice.isSensor()) && (!paramBaseALIoTDevice.isEnergy()))
      {
        boolean bool = paramBaseALIoTDevice.isDeviceOn();
        j = 2131690217;
        if (bool)
        {
          if (paramBaseALIoTDevice.isBulb())
          {
            i = paramBaseALIoTDevice.getBrightness();
            this.p3.setText(String.format("%d%%", new Object[] { Integer.valueOf(i) }));
            if ((paramBaseALIoTDevice.isLightStrip()) && ((paramBaseALIoTDevice.getLocalIoTDevice() instanceof IoTLightStripDevice)))
            {
              localObject = (IoTLightStripDevice)paramBaseALIoTDevice.getLocalIoTDevice();
              this.N3.setVisibility(0);
              if (((IoTLightStripDevice)localObject).isLightingEffectEnabled())
              {
                this.N3.h(1);
                this.p3.setVisibility(0);
                this.p3.setText(String.format("%d%%", new Object[] { Integer.valueOf(((IoTLightStripDevice)localObject).getLightingEffectBrightness()) }));
                this.O3.setVisibility(4);
              }
              else if ((((IoTLightStripDevice)localObject).isMusicRhythmEnable() != null) && (((IoTLightStripDevice)localObject).isMusicRhythmEnable().booleanValue()) && (!((IoTLightStripDevice)localObject).isV1MusicRhythmEnableComponent()))
              {
                this.N3.setVisibility(8);
                this.p3.setVisibility(8);
                this.O3.setVisibility(0);
                paramBaseALIoTDevice = this.O3;
                if (!((LocalIoTBaseDevice)localObject).isDeviceOn()) {
                  j = 2131690216;
                }
                paramBaseALIoTDevice.setImageResource(j);
              }
              else
              {
                this.N3.setColor(c.m((IoTLightStripDevice)localObject));
                this.N3.h(0);
                this.p3.setVisibility(0);
                this.O3.setVisibility(4);
              }
            }
            else if (a.e(paramBaseALIoTDevice.getDeviceIdMD5()))
            {
              if (paramBaseALIoTDevice.isDynamicLightEffectEnable())
              {
                this.p0.setVisibility(0);
                this.p0.setImageResource(com.tplink.iot.Utils.z0.i.f(paramBaseALIoTDevice.getDynamicLightEffectId()));
              }
              else
              {
                this.p3.setVisibility(0);
                this.L3.setVisibility(0);
                this.L3.setInnerCircleColor(com.tplink.iot.Utils.z0.i.c(paramBaseALIoTDevice.getColorTemp(), paramBaseALIoTDevice.getHue(), paramBaseALIoTDevice.getSaturation()));
              }
            }
            else
            {
              this.p3.setVisibility(0);
            }
          }
          P();
        }
        else
        {
          if ((paramBaseALIoTDevice.isLightStrip()) && ((paramBaseALIoTDevice.getLocalIoTDevice() instanceof IoTLightStripDevice)))
          {
            paramBaseALIoTDevice = (IoTLightStripDevice)paramBaseALIoTDevice.getLocalIoTDevice();
            if ((paramBaseALIoTDevice.isMusicRhythmEnable() != null) && (paramBaseALIoTDevice.isMusicRhythmEnable().booleanValue()) && (!paramBaseALIoTDevice.isV1MusicRhythmEnableComponent()))
            {
              this.N3.setVisibility(8);
              this.p3.setVisibility(8);
              this.O3.setVisibility(0);
              localObject = this.O3;
              if (!paramBaseALIoTDevice.isDeviceOn()) {
                j = 2131690216;
              }
              ((ImageView)localObject).setImageResource(j);
            }
            else
            {
              this.O3.setVisibility(4);
            }
          }
          O();
        }
      }
      else
      {
        L();
        if (paramBaseALIoTDevice.isHub())
        {
          if (paramBaseALIoTDevice.getGuardOn()) {
            this.S3.setImageResource(p.b(paramBaseALIoTDevice.getGuardMode()));
          } else {
            this.S3.setVisibility(4);
          }
        }
        else if (paramBaseALIoTDevice.isSensor())
        {
          this.S3.setVisibility(4);
        }
        else if (b.k(paramBaseALIoTDevice))
        {
          localObject = this.M3;
          if (t()) {
            j = i;
          } else {
            j = 8;
          }
          ((RelativeLayout)localObject).setVisibility(j);
          this.S3.setVisibility(4);
          Q(paramBaseALIoTDevice);
        }
      }
    }
    else if (paramBaseALIoTDevice.isDeviceOffLine())
    {
      G();
    }
    else
    {
      F();
    }
  }
  
  private void N(boolean paramBoolean)
  {
    e locale = this.f;
    if (locale != null) {
      locale.c(paramBoolean);
    }
  }
  
  private void O()
  {
    this.P3.setCompoundDrawablesRelativeWithIntrinsicBounds(this.c.getResources().getDrawable(2131231495), null, null, null);
    this.Q3.setCardBackgroundColor(this.c.getResources().getColor(2131100206));
    this.R3.setCardBackgroundColor(o());
    this.q.setTextColor(this.c.getResources().getColor(2131099729));
    this.x.setTextColor(this.c.getResources().getColor(2131099754));
    this.S3.setSelected(false);
  }
  
  private void P()
  {
    this.P3.setCompoundDrawablesRelativeWithIntrinsicBounds(this.c.getResources().getDrawable(2131231496), null, null, null);
    this.Q3.setCardBackgroundColor(this.c.getResources().getColor(2131099808));
    this.R3.setCardBackgroundColor(this.c.getResources().getColor(2131099726));
    this.q.setTextColor(this.c.getResources().getColor(2131100206));
    this.x.setTextColor(this.c.getResources().getColor(2131099755));
    this.S3.setSelected(true);
  }
  
  @SuppressLint({"SetTextI18n"})
  private void Q(BaseALIoTDevice<?> paramBaseALIoTDevice)
  {
    int i = 8;
    int j = 0;
    int k = 0;
    if ((paramBaseALIoTDevice != null) && ((paramBaseALIoTDevice.getLocalIoTDevice() instanceof IoTSubDevice)))
    {
      Object localObject = (IoTSubDevice)paramBaseALIoTDevice.getLocalIoTDevice();
      String str = b.c(((IoTSubDevice)localObject).getCurrentTemp(), ((IoTSubDevice)localObject).getTempUnit());
      if (((IoTSubDevice)localObject).getTrvStates() != null) {
        paramBaseALIoTDevice = ((IoTSubDevice)localObject).getTrvStates();
      } else {
        paramBaseALIoTDevice = new ArrayList();
      }
      boolean bool = paramBaseALIoTDevice.contains(EnumTRVState.SHUTDOWN);
      TextView localTextView = this.J3;
      if (bool) {
        j = 8;
      } else {
        j = 0;
      }
      localTextView.setVisibility(j);
      localTextView = this.K3;
      if (bool) {
        j = i;
      } else {
        j = 0;
      }
      localTextView.setVisibility(j);
      if (bool)
      {
        this.J3.setText("");
        this.K3.setText("");
      }
      else if (paramBaseALIoTDevice.contains(EnumTRVState.DEVICE_ERROR))
      {
        this.J3.setText("--");
        this.K3.setText(2131954313);
      }
      else
      {
        if (paramBaseALIoTDevice.contains(EnumTRVState.LOW_BATTERY))
        {
          this.J3.setText(str);
          this.K3.setText(2131954189);
          j = 2131231273;
          break label441;
        }
        if (paramBaseALIoTDevice.contains(EnumTRVState.WINDOW_OPEN))
        {
          this.J3.setText(str);
          this.K3.setText(2131954332);
          j = 2131231272;
          break label441;
        }
        if (b.n((IoTSubDevice)localObject))
        {
          this.J3.setText(str);
          paramBaseALIoTDevice = b.e(((IoTSubDevice)localObject).getTargetTemp(), ((IoTSubDevice)localObject).getTempUnit());
          this.K3.setText(this.c.getString(2131954342, new Object[] { paramBaseALIoTDevice }));
          j = -1;
          k = 1;
          break label441;
        }
        if (b.m((IoTSubDevice)localObject))
        {
          localObject = this.J3;
          paramBaseALIoTDevice = new StringBuilder();
          paramBaseALIoTDevice.append(str);
          paramBaseALIoTDevice.append("(");
          paramBaseALIoTDevice.append(this.c.getString(2131954118));
          paramBaseALIoTDevice.append(")");
          ((TextView)localObject).setText(paramBaseALIoTDevice.toString());
          this.K3.setText(2131954320);
          j = 2131231275;
          break label441;
        }
        this.J3.setText(str);
        this.K3.setText("");
      }
      j = -1;
      label441:
      if (k != 0) {
        paramBaseALIoTDevice = ResourcesCompat.getDrawable(this.c.getResources(), 2131231271, null);
      } else {
        paramBaseALIoTDevice = null;
      }
      this.J3.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, paramBaseALIoTDevice, null);
      if (j != -1) {
        paramBaseALIoTDevice = ResourcesCompat.getDrawable(this.c.getResources(), j, null);
      } else {
        paramBaseALIoTDevice = null;
      }
      this.K3.setCompoundDrawablesRelativeWithIntrinsicBounds(paramBaseALIoTDevice, null, null, null);
    }
    else
    {
      this.J3.setVisibility(8);
      this.K3.setVisibility(8);
      k = j;
    }
    if (k != 0)
    {
      this.P3.setCompoundDrawablesRelativeWithIntrinsicBounds(ResourcesCompat.getDrawable(this.c.getResources(), 2131231496, null), null, null, null);
      this.Q3.setCardBackgroundColor(this.c.getResources().getColor(2131099808));
      this.q.setTextColor(this.c.getResources().getColor(2131100206));
      this.x.setTextColor(this.c.getResources().getColor(2131099755));
      this.J3.setTextColor(this.c.getResources().getColor(2131100206));
      this.K3.setTextColor(this.c.getResources().getColor(2131099967));
    }
    else
    {
      this.P3.setCompoundDrawablesRelativeWithIntrinsicBounds(ResourcesCompat.getDrawable(this.c.getResources(), 2131231495, null), null, null, null);
      this.Q3.setCardBackgroundColor(this.c.getResources().getColor(2131100206));
      this.q.setTextColor(this.c.getResources().getColor(2131099729));
      this.x.setTextColor(this.c.getResources().getColor(2131099754));
      this.J3.setTextColor(this.c.getResources().getColor(2131099729));
      this.K3.setTextColor(this.c.getResources().getColor(2131099804));
    }
  }
  
  private void R(@NonNull BaseALIoTDevice paramBaseALIoTDevice)
  {
    if ((paramBaseALIoTDevice.isSupportIoTComponent(EnumIoTComponent.BATTERY_DETECT)) && (!b.k(paramBaseALIoTDevice)))
    {
      if (!q(paramBaseALIoTDevice)) {
        return;
      }
      boolean bool = paramBaseALIoTDevice.isSwitch();
      int i = 2131231273;
      if (bool)
      {
        this.I3.setVisibility(0);
        Object localObject = this.c.getResources();
        if (paramBaseALIoTDevice.isDeviceOn()) {
          i = 2131231274;
        }
        localObject = ResourcesCompat.getDrawable((Resources)localObject, i, null);
        this.I3.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable)localObject, null, null, null);
        this.I3.setTextColor(r(paramBaseALIoTDevice));
      }
      else if (paramBaseALIoTDevice.isSensor())
      {
        if (this.H3.getVisibility() == 0)
        {
          paramBaseALIoTDevice = ResourcesCompat.getDrawable(this.c.getResources(), 2131231273, null);
          this.H3.setCompoundDrawablesRelativeWithIntrinsicBounds(paramBaseALIoTDevice, null, null, null);
        }
        else
        {
          this.I3.setVisibility(0);
        }
      }
    }
  }
  
  private void S(BaseALIoTDevice<?> paramBaseALIoTDevice)
  {
    boolean bool1 = paramBaseALIoTDevice.isSupportIoTComponent(EnumIoTComponent.TRIGGER_LOG);
    boolean bool2 = paramBaseALIoTDevice.isSwitch();
    if ((bool1) && (!bool2))
    {
      TriggerLog localTriggerLog = p(paramBaseALIoTDevice);
      if ((localTriggerLog != null) && (localTriggerLog.getTimestamp() > 0L))
      {
        TextView localTextView = this.H3;
        int i = 0;
        localTextView.setVisibility(0);
        this.H3.setText(r.b(this.c, paramBaseALIoTDevice, localTriggerLog));
        this.H3.setTextColor(this.c.getResources().getColor(2131099729));
        if (paramBaseALIoTDevice.isSensor())
        {
          paramBaseALIoTDevice = this.M3;
          if (!t()) {
            i = 8;
          }
          paramBaseALIoTDevice.setVisibility(i);
        }
      }
    }
  }
  
  private boolean n(e parame)
  {
    e locale = this.f;
    if (locale != null) {
      return locale.g(parame);
    }
    return false;
  }
  
  private int o()
  {
    return this.c.getResources().getColor(2131099752);
  }
  
  @Nullable
  private TriggerLog p(@NonNull BaseALIoTDevice<?> paramBaseALIoTDevice)
  {
    if (paramBaseALIoTDevice.isSwitch()) {
      return (TriggerLog)((SwitchRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(paramBaseALIoTDevice.getDeviceIdMD5(), SwitchRepository.class)).k1().getValue();
    }
    return ((SensorRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(paramBaseALIoTDevice.getDeviceIdMD5(), SensorRepository.class)).j4();
  }
  
  private boolean q(@NonNull BaseALIoTDevice paramBaseALIoTDevice)
  {
    if (paramBaseALIoTDevice.isSwitch()) {
      return ((SwitchRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(paramBaseALIoTDevice.getDeviceIdMD5(), SwitchRepository.class)).o4();
    }
    return ((SensorRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(paramBaseALIoTDevice.getDeviceIdMD5(), SensorRepository.class)).k4();
  }
  
  private int r(BaseALIoTDevice paramBaseALIoTDevice)
  {
    int i;
    if (paramBaseALIoTDevice.isDeviceOn()) {
      i = this.c.getResources().getColor(2131100206);
    } else {
      i = this.c.getResources().getColor(2131099729);
    }
    return i;
  }
  
  private boolean t()
  {
    e locale = this.f;
    if (locale != null) {
      return locale.a();
    }
    return false;
  }
  
  private void u(BaseALIoTDevice paramBaseALIoTDevice)
  {
    EnumIoTDeviceState localEnumIoTDeviceState1 = paramBaseALIoTDevice.getLastDeviceStatus();
    EnumIoTDeviceState localEnumIoTDeviceState2 = paramBaseALIoTDevice.getDeviceState();
    long l = paramBaseALIoTDevice.getLoadingStartTimestamp();
    boolean bool = paramBaseALIoTDevice.isOnline();
    EnumIoTDeviceState localEnumIoTDeviceState3 = EnumIoTDeviceState.LOADING;
    if (localEnumIoTDeviceState2 != localEnumIoTDeviceState3)
    {
      if ((localEnumIoTDeviceState1 == localEnumIoTDeviceState3) && (l > 0L))
      {
        com.tplink.iot.Utils.x0.j.a(paramBaseALIoTDevice.getDeviceIdMD5(), System.currentTimeMillis() - l, bool);
        paramBaseALIoTDevice.setLoadingStartTimestamp(0L);
      }
      if ((localEnumIoTDeviceState2 != localEnumIoTDeviceState1) && (localEnumIoTDeviceState1 != localEnumIoTDeviceState3)) {
        com.tplink.iot.Utils.x0.j.b(paramBaseALIoTDevice.getDeviceIdMD5(), bool);
      }
    }
  }
  
  private void v(e parame)
  {
    e locale = this.f;
    if (locale != null) {
      locale.i(parame);
    }
  }
  
  private void w(e parame)
  {
    e locale = this.f;
    if (locale != null) {
      locale.j(parame);
    }
  }
  
  private void x()
  {
    e locale = this.f;
    if (locale != null) {
      locale.h();
    }
  }
  
  private boolean y(e parame)
  {
    if (t()) {
      return true;
    }
    B(parame);
    w(parame);
    N(true);
    return true;
  }
  
  private void z(int paramInt, e parame, boolean paramBoolean)
  {
    e locale = this.f;
    if (locale != null) {
      locale.l(paramInt, parame, paramBoolean);
    }
  }
  
  public void a()
  {
    this.T3.setScaleX(1.0F);
    this.T3.setScaleY(1.0F);
  }
  
  public void b()
  {
    this.T3.setScaleX(1.1F);
    this.T3.setScaleY(1.1F);
  }
  
  public void s(final e parame, final int paramInt, e parame1)
  {
    this.f = parame1;
    if ((parame instanceof k))
    {
      parame1 = (k)parame;
      I(parame1);
      if (parame1.s()) {
        this.S3.setEnabled(false);
      } else {
        this.S3.setEnabled(true);
      }
    }
    else
    {
      if (!(parame instanceof g)) {
        return;
      }
      K((g)parame);
    }
    this.T3.setOnLongClickListener(new a(parame));
    this.T3.setOnClickListener(new b(parame));
    this.P3.setOnCheckedChangeListener(new c(parame));
    this.P3.setChecked(n(parame));
    this.S3.setOnClickListener(new d(parame, paramInt));
  }
  
  class a
    implements View.OnLongClickListener
  {
    a(e parame) {}
    
    public boolean onLongClick(View paramView)
    {
      if (DeviceInfoHolder.c(DeviceInfoHolder.this)) {
        return DeviceInfoHolder.d(DeviceInfoHolder.this, parame);
      }
      return true;
    }
  }
  
  class b
    implements View.OnClickListener
  {
    b(e parame) {}
    
    public void onClick(View paramView)
    {
      if (!DeviceInfoHolder.f(DeviceInfoHolder.this))
      {
        paramView = parame;
        if ((paramView instanceof k)) {
          ((k)paramView).B(false);
        }
        DeviceInfoHolder.g(DeviceInfoHolder.this, parame);
      }
    }
  }
  
  class c
    implements TPCheckboxCompat.a
  {
    c(e parame) {}
    
    public void c(CompoundButton paramCompoundButton, boolean paramBoolean1, boolean paramBoolean2)
    {
      if (paramBoolean2) {
        if (paramBoolean1) {
          DeviceInfoHolder.h(DeviceInfoHolder.this, parame);
        } else {
          DeviceInfoHolder.i(DeviceInfoHolder.this, parame);
        }
      }
      DeviceInfoHolder.j(DeviceInfoHolder.this);
    }
  }
  
  class d
    implements View.OnClickListener
  {
    d(e parame, int paramInt) {}
    
    public void onClick(View paramView)
    {
      DeviceInfoHolder.k(DeviceInfoHolder.this).setEnabled(false);
      paramView = parame;
      if ((paramView instanceof k)) {
        ((k)paramView).B(false);
      }
      DeviceInfoHolder.k(DeviceInfoHolder.this).setSelected(DeviceInfoHolder.k(DeviceInfoHolder.this).isSelected() ^ true);
      DeviceInfoHolder.l(DeviceInfoHolder.this).e(DeviceInfoHolder.k(DeviceInfoHolder.this).isSelected());
      u0.a(DeviceInfoHolder.m(DeviceInfoHolder.this), 100L);
      paramView = DeviceInfoHolder.this;
      DeviceInfoHolder.e(paramView, paramInt, parame, DeviceInfoHolder.k(paramView).isSelected());
      DeviceInfoHolder.k(DeviceInfoHolder.this).postDelayed(new a(), 500L);
    }
    
    class a
      implements Runnable
    {
      a() {}
      
      public void run()
      {
        DeviceInfoHolder.k(DeviceInfoHolder.this).setEnabled(true);
      }
    }
  }
  
  public static abstract interface e
  {
    public abstract boolean a();
    
    public abstract void b(e parame);
    
    public abstract void c(boolean paramBoolean);
    
    public abstract void d(e parame);
    
    public abstract boolean g(e parame);
    
    public abstract void h();
    
    public abstract void i(e parame);
    
    public abstract void j(e parame);
    
    public abstract void l(int paramInt, e parame, boolean paramBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\model\home\DeviceInfoHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */