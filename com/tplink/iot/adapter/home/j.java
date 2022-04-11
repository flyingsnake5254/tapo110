package com.tplink.iot.adapter.home;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.tplink.cloud.bean.push.NotificationMsgBean;
import com.tplink.iot.Utils.a0;
import com.tplink.iot.Utils.o0;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.cloud.bean.cloudvideo.common.CloudVideo;
import com.tplink.iot.cloud.bean.cloudvideo.common.PartCloudVideo;
import com.tplink.iot.view.cloudvideo.CloudVideoListActivity;
import com.tplink.iot.view.deviceshare.ShareDeviceActivity;
import com.tplink.iot.view.firmware.FirmwareSlideActivity;
import com.tplink.iot.view.iothub.HubDetailActivity;
import com.tplink.iot.view.iotsensor.SensorDetailActivity;
import com.tplink.iot.view.ipcamera.play.VideoPlayActivity;
import com.tplink.iot.view.tapocare.BillingActivity;
import com.tplink.iot.viewmodel.home.u;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.IacInfo;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.NotificationMsgAttachmentBean;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.CloudVideoRepository;
import com.tplink.libtpnetwork.Utils.i;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CameraSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CommonCameraRepository;
import com.tplink.libtpnetwork.enumerate.EnumIoTDeviceState;
import com.tplink.libtpnetwork.enumerate.EnumNotificationMsgType;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class j
  extends BaseExpandableListAdapter
{
  private Activity a;
  private FragmentManager b;
  private List<String> c;
  private Map<String, List<NotificationMsgBean>> d;
  private int e = 0;
  private List<NotificationMsgBean> f;
  private d g;
  private HashSet<String> h = new HashSet();
  private long i = 0L;
  
  public j(Activity paramActivity, FragmentManager paramFragmentManager)
  {
    this.a = paramActivity;
    this.b = paramFragmentManager;
    this.c = new ArrayList();
    this.d = new LinkedHashMap();
    this.f = new ArrayList();
  }
  
  private void e(EnumNotificationMsgType paramEnumNotificationMsgType, NotificationMsgBean paramNotificationMsgBean)
  {
    paramNotificationMsgBean = (NotificationMsgAttachmentBean)i.a(paramNotificationMsgBean.getAttachments(), NotificationMsgAttachmentBean.class);
    if ((paramNotificationMsgBean != null) && (!TextUtils.isEmpty(paramNotificationMsgBean.getDeviceId())))
    {
      paramNotificationMsgBean.setUuid(paramNotificationMsgBean.getMsgId());
      String str = b.d.w.h.a.g(paramNotificationMsgBean.getDeviceId());
      Object localObject = TPIoTClientManager.K1(str);
      if ((localObject != null) && (((TPBaseDeviceContext)localObject).getIoTDevice() != null))
      {
        localObject = ((TPBaseDeviceContext)localObject).getIoTDevice();
        if (((BaseALIoTDevice)localObject).getDeviceState() == EnumIoTDeviceState.LOADING) {
          s0.s(this.a, 2131954295);
        } else if (((BaseALIoTDevice)localObject).getDeviceState() == EnumIoTDeviceState.OFFLINE) {
          s0.s(this.a, 2131954296);
        } else if (!u.E(this.a, str, this.b)) {
          f(paramEnumNotificationMsgType, paramNotificationMsgBean, (BaseALIoTDevice)localObject);
        }
      }
      else
      {
        s0.s(this.a, 2131953220);
      }
    }
    else
    {
      s0.s(this.a, 2131953220);
    }
  }
  
  private void f(EnumNotificationMsgType paramEnumNotificationMsgType, NotificationMsgAttachmentBean paramNotificationMsgAttachmentBean, BaseALIoTDevice paramBaseALIoTDevice)
  {
    long l = System.currentTimeMillis();
    if (Math.abs(l - this.i) < 500L) {
      return;
    }
    this.i = l;
    if ((paramEnumNotificationMsgType != EnumNotificationMsgType.MOTION) && (paramEnumNotificationMsgType != EnumNotificationMsgType.AREA_INTRUSION_DETECTION) && (paramEnumNotificationMsgType != EnumNotificationMsgType.LINE_CROSSING_DETECTION) && (paramEnumNotificationMsgType != EnumNotificationMsgType.CAMERA_TAMPERING) && (paramEnumNotificationMsgType != EnumNotificationMsgType.CRYING) && (paramEnumNotificationMsgType != EnumNotificationMsgType.PERSON_DETECTED) && (paramEnumNotificationMsgType != EnumNotificationMsgType.PERSON_ENHANCED))
    {
      if (paramEnumNotificationMsgType == EnumNotificationMsgType.SD_INSUFFICIENT_STORAGE) {
        t(paramNotificationMsgAttachmentBean, paramEnumNotificationMsgType);
      } else {
        s(paramBaseALIoTDevice.getDeviceIdMD5());
      }
    }
    else {
      h(paramBaseALIoTDevice.getDeviceId(), paramNotificationMsgAttachmentBean, paramEnumNotificationMsgType);
    }
  }
  
  @SuppressLint({"CheckResult"})
  private void h(String paramString, NotificationMsgAttachmentBean paramNotificationMsgAttachmentBean, EnumNotificationMsgType paramEnumNotificationMsgType)
  {
    if ((!TextUtils.isEmpty(paramNotificationMsgAttachmentBean.getUuid())) && (a0.a(paramNotificationMsgAttachmentBean.getUuid())))
    {
      s0.l(this.a);
      long l = paramNotificationMsgAttachmentBean.getTime();
      q.f0(b.d.b.f.b.a(b.d.s.a.a.f(), CloudVideoRepository.class)).N(new c(paramString, paramNotificationMsgAttachmentBean)).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).H0(new f(this, l, paramString, paramNotificationMsgAttachmentBean, paramEnumNotificationMsgType), new d(this, paramNotificationMsgAttachmentBean, paramEnumNotificationMsgType));
    }
    else
    {
      t(paramNotificationMsgAttachmentBean, paramEnumNotificationMsgType);
    }
  }
  
  private String i(NotificationMsgBean paramNotificationMsgBean)
  {
    if (paramNotificationMsgBean.getAttachments() == null) {
      return null;
    }
    paramNotificationMsgBean = ((NotificationMsgAttachmentBean)i.a(paramNotificationMsgBean.getAttachments(), NotificationMsgAttachmentBean.class)).getDeviceId();
    if (!TextUtils.isEmpty(paramNotificationMsgBean)) {
      return b.d.w.h.a.g(paramNotificationMsgBean);
    }
    return null;
  }
  
  private int k(EnumNotificationMsgType paramEnumNotificationMsgType)
  {
    if (paramEnumNotificationMsgType == null) {
      return 2131689804;
    }
    switch (b.a[paramEnumNotificationMsgType.ordinal()])
    {
    default: 
      return 2131689804;
    case 28: 
    case 29: 
    case 30: 
    case 31: 
    case 32: 
    case 33: 
    case 34: 
      return 2131689810;
    case 27: 
      return 2131690036;
    case 26: 
      return 2131689812;
    case 25: 
      return 2131689821;
    case 24: 
      return 2131689819;
    case 23: 
      return 2131689803;
    case 22: 
      return 2131689814;
    case 21: 
      return 2131689805;
    case 20: 
      return 2131689809;
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
      return 2131689664;
    case 14: 
      return 2131689820;
    case 13: 
      return 2131689811;
    case 12: 
      return 2131689800;
    case 10: 
    case 11: 
      return 2131689817;
    case 9: 
      return 2131689801;
    case 8: 
      return 2131689802;
    case 7: 
      return 2131689816;
    case 6: 
      return 2131689815;
    case 5: 
      return 2131689813;
    case 4: 
      return 2131689807;
    case 3: 
      return 2131689808;
    case 2: 
      return 2131689822;
    }
    return 2131689818;
  }
  
  private String m(NotificationMsgBean paramNotificationMsgBean)
  {
    if (!TextUtils.isEmpty(paramNotificationMsgBean.getTitle())) {
      return paramNotificationMsgBean.getTitle();
    }
    paramNotificationMsgBean = EnumNotificationMsgType.fromString(paramNotificationMsgBean.getMsgType());
    if (paramNotificationMsgBean == null) {
      return "";
    }
    switch (b.a[paramNotificationMsgBean.ordinal()])
    {
    default: 
      return "";
    case 14: 
      return this.a.getString(2131953881);
    case 13: 
      return this.a.getString(2131953830);
    case 12: 
      return this.a.getString(2131953803);
    case 11: 
      return this.a.getString(2131953742);
    case 10: 
      return this.a.getString(2131953743);
    case 9: 
      return this.a.getString(2131952054);
    case 8: 
      return this.a.getString(2131951870);
    case 6: 
      return this.a.getString(2131952029);
    case 5: 
    case 7: 
      return this.a.getString(2131951944);
    case 4: 
      return this.a.getString(2131952526);
    case 3: 
      return this.a.getString(2131954507);
    case 2: 
      return this.a.getString(2131952599);
    }
    return this.a.getString(2131953929);
  }
  
  private void o(NotificationMsgBean paramNotificationMsgBean)
  {
    String str = i(paramNotificationMsgBean);
    if (str == null) {
      return;
    }
    paramNotificationMsgBean = TPIoTClientManager.I1(str);
    if (paramNotificationMsgBean == null) {
      return;
    }
    if (paramNotificationMsgBean.getDeviceState() == EnumIoTDeviceState.LOADING) {
      s0.s(this.a, 2131954295);
    } else if (paramNotificationMsgBean.getDeviceState() == EnumIoTDeviceState.OFFLINE) {
      s0.s(this.a, 2131954296);
    } else {
      HubDetailActivity.K1(this.a, str);
    }
  }
  
  private void p(NotificationMsgBean paramNotificationMsgBean)
  {
    String str = i(paramNotificationMsgBean);
    if (str == null) {
      return;
    }
    BaseALIoTDevice localBaseALIoTDevice = TPIoTClientManager.I1(str);
    if (localBaseALIoTDevice == null) {
      return;
    }
    if (localBaseALIoTDevice.getDeviceState() == EnumIoTDeviceState.LOADING) {
      s0.s(this.a, 2131954295);
    } else if (localBaseALIoTDevice.getDeviceState() == EnumIoTDeviceState.OFFLINE) {
      s0.s(this.a, 2131954296);
    } else {
      SensorDetailActivity.E1(this.a, str, paramNotificationMsgBean.getMsgType());
    }
  }
  
  private void q(CloudVideo paramCloudVideo, String paramString)
  {
    if (paramCloudVideo != null) {
      if ((paramCloudVideo.getPartCloudVideos() != null) && (paramCloudVideo.getPartCloudVideos().size() > 0))
      {
        PartCloudVideo localPartCloudVideo = (PartCloudVideo)paramCloudVideo.getPartCloudVideos().get(0);
        if ((localPartCloudVideo != null) && (localPartCloudVideo.getUri() != null)) {
          r(paramString, localPartCloudVideo.getM3u8(), localPartCloudVideo.getUri(), localPartCloudVideo.getDuration(), localPartCloudVideo.getStartTimestamp(), paramCloudVideo.getUuid());
        }
      }
      else
      {
        paramCloudVideo = this.a;
        s0.p(paramCloudVideo, paramCloudVideo.getString(2131954391));
      }
    }
  }
  
  private void r(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, String paramString4)
  {
    Intent localIntent = new Intent(this.a, CloudVideoListActivity.class);
    localIntent.putExtra("cloud_video_device_id", paramString1);
    if ((paramString2 != null) && (paramString3 != null))
    {
      localIntent.putExtra("cloud_video_m3u8", paramString2);
      localIntent.putExtra("cloud_video_uri", paramString3);
      localIntent.putExtra("cloud_video_duration", paramLong1);
      localIntent.putExtra("cloud_video_timestamp", paramLong2);
      localIntent.putExtra("cloud_video_uuid", paramString4);
    }
    this.a.startActivity(localIntent);
  }
  
  private void s(String paramString)
  {
    if (this.a != null)
    {
      Intent localIntent = new Intent(this.a, VideoPlayActivity.class);
      localIntent.putExtra("device_id_md5", paramString);
      localIntent.putExtra("online", true);
      this.a.startActivity(localIntent);
    }
  }
  
  @SuppressLint({"CheckResult"})
  private void t(NotificationMsgAttachmentBean paramNotificationMsgAttachmentBean, EnumNotificationMsgType paramEnumNotificationMsgType)
  {
    s0.l(this.a);
    String str = b.d.w.h.a.g(paramNotificationMsgAttachmentBean.getDeviceId());
    long l = paramNotificationMsgAttachmentBean.getTime();
    paramNotificationMsgAttachmentBean = (CameraSettingRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(str, CameraSettingRepository.class);
    q.f0(com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(str, CommonCameraRepository.class)).N(g.c).N(new e(paramNotificationMsgAttachmentBean)).l0(io.reactivex.d0.b.a.a()).H0(new b(this, paramNotificationMsgAttachmentBean, paramEnumNotificationMsgType, str, l), new a(this, str));
  }
  
  private void u(EnumNotificationMsgType paramEnumNotificationMsgType, NotificationMsgBean paramNotificationMsgBean)
  {
    if ((paramEnumNotificationMsgType != null) && (paramNotificationMsgBean != null))
    {
      int j = b.a[paramEnumNotificationMsgType.ordinal()];
      if (j != 1)
      {
        if (j != 2)
        {
          if (j != 27) {
            switch (j)
            {
            default: 
              switch (j)
              {
              default: 
                break;
              case 30: 
              case 31: 
              case 32: 
              case 33: 
              case 34: 
                v(paramNotificationMsgBean);
              }
              break;
            case 20: 
              o(paramNotificationMsgBean);
              break;
            case 15: 
            case 16: 
            case 17: 
            case 18: 
            case 19: 
              BillingActivity.f1(this.a, com.tplink.iot.Utils.v0.e.x());
              break;
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
              e(paramEnumNotificationMsgType, paramNotificationMsgBean);
              break;
            }
          } else {
            p(paramNotificationMsgBean);
          }
        }
        else {
          FirmwareSlideActivity.q1(this.a, "message_center");
        }
      }
      else {
        ShareDeviceActivity.B1(this.a, true);
      }
    }
  }
  
  private void v(NotificationMsgBean paramNotificationMsgBean)
  {
    paramNotificationMsgBean = (NotificationMsgAttachmentBean)i.c(paramNotificationMsgBean.getAttachments(), NotificationMsgAttachmentBean.class);
    if ((paramNotificationMsgBean != null) && (paramNotificationMsgBean.getIac() != null) && (!TextUtils.isEmpty(paramNotificationMsgBean.getIac().getTaskId())))
    {
      paramNotificationMsgBean = paramNotificationMsgBean.getIac().getTaskId();
      b.d.n.f.b.l().i(paramNotificationMsgBean);
    }
  }
  
  private boolean w(String paramString)
  {
    return paramString.matches("\\d{4}\\.\\d{2}\\.\\d{2}.*?");
  }
  
  public void H(List<NotificationMsgBean> paramList)
  {
    this.c.clear();
    this.d.clear();
    this.f.clear();
    this.h.clear();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (NotificationMsgBean)localIterator.next();
        Object localObject = o0.i(paramList.getTime(), this.h);
        if (this.d.get(localObject) == null)
        {
          this.c.add(localObject);
          this.d.put(localObject, new ArrayList());
        }
        localObject = this.d.get(localObject);
        Objects.requireNonNull(localObject);
        ((List)localObject).add(paramList);
      }
    }
    notifyDataSetChanged();
    paramList = this.g;
    if (paramList != null) {
      paramList.d0(0);
    }
  }
  
  public void I(int paramInt)
  {
    this.e = paramInt;
    this.f.clear();
    notifyDataSetChanged();
  }
  
  public void J(d paramd)
  {
    this.g = paramd;
  }
  
  public NotificationMsgBean g(int paramInt1, int paramInt2)
  {
    return (NotificationMsgBean)j(paramInt1).get(paramInt2);
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, final View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559064, null);
      paramView = new c();
      paramView.a = ((CheckBox)paramViewGroup.findViewById(2131362233));
      paramView.b = ((ImageView)paramViewGroup.findViewById(2131363092));
      paramView.c = ((ImageView)paramViewGroup.findViewById(2131363106));
      paramView.d = ((TextView)paramViewGroup.findViewById(2131364557));
      paramView.e = ((TextView)paramViewGroup.findViewById(2131364556));
      paramView.f = ((TextView)paramViewGroup.findViewById(2131364670));
      paramViewGroup.setTag(paramView);
    }
    else
    {
      localObject1 = (c)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject1;
    }
    final Object localObject1 = g(paramInt1, paramInt2);
    if (localObject1 != null)
    {
      Object localObject2 = EnumNotificationMsgType.fromString(((NotificationMsgBean)localObject1).getMsgType());
      CheckBox localCheckBox = paramView.a;
      paramInt1 = this.e;
      paramInt2 = 8;
      if (paramInt1 == 1) {
        paramInt1 = 0;
      } else {
        paramInt1 = 8;
      }
      localCheckBox.setVisibility(paramInt1);
      paramView.b.setImageResource(k((EnumNotificationMsgType)localObject2));
      localObject2 = paramView.c;
      if (((NotificationMsgBean)localObject1).isReadFlag()) {
        paramInt1 = paramInt2;
      } else {
        paramInt1 = 0;
      }
      ((ImageView)localObject2).setVisibility(paramInt1);
      paramView.a.setChecked(false);
      paramView.d.setText(m((NotificationMsgBean)localObject1));
      paramView.e.setText(((NotificationMsgBean)localObject1).getContent());
      paramView.f.setText(o0.a(this.a, o0.m(((NotificationMsgBean)localObject1).getTime())));
      paramViewGroup.setOnClickListener(new a((NotificationMsgBean)localObject1, paramView));
    }
    return paramViewGroup;
  }
  
  public int getChildrenCount(int paramInt)
  {
    return ((List)this.d.get(this.c.get(paramInt))).size();
  }
  
  public int getGroupCount()
  {
    return this.d.size();
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559062, null);
    }
    Object localObject = localView.findViewById(2131363370);
    paramViewGroup = (TextView)localView.findViewById(2131364729);
    paramView = (TextView)localView.findViewById(2131364467);
    String str = (String)this.c.get(paramInt);
    if (w(str))
    {
      ((View)localObject).setVisibility(0);
      localObject = str.substring(0, 4);
      str = str.substring(5);
      paramViewGroup.setText((CharSequence)localObject);
      paramView.setText(str);
    }
    else
    {
      ((View)localObject).setVisibility(8);
      paramView.setText(str);
    }
    return localView;
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public List<NotificationMsgBean> j(int paramInt)
  {
    return (List)this.d.get(this.c.get(paramInt));
  }
  
  public int l()
  {
    return this.e;
  }
  
  public List<NotificationMsgBean> n()
  {
    return new ArrayList(this.f);
  }
  
  class a
    implements View.OnClickListener
  {
    a(NotificationMsgBean paramNotificationMsgBean, j.c paramc) {}
    
    public void onClick(View paramView)
    {
      if (j.a(j.this) == 1)
      {
        if (j.b(j.this).contains(localObject1))
        {
          j.b(j.this).remove(localObject1);
          paramView.a.setChecked(false);
        }
        else
        {
          j.b(j.this).add(localObject1);
          paramView.a.setChecked(true);
        }
        if (j.c(j.this) != null) {
          j.c(j.this).d0(j.b(j.this).size());
        }
      }
      else
      {
        if (localObject1.getMsgType() != null)
        {
          paramView = EnumNotificationMsgType.fromString(localObject1.getMsgType());
          j.d(j.this, paramView, localObject1);
        }
        if (j.c(j.this) != null) {
          j.c(j.this).s(localObject1);
        }
      }
    }
  }
  
  public static class c
  {
    CheckBox a;
    ImageView b;
    ImageView c;
    TextView d;
    TextView e;
    TextView f;
  }
  
  public static abstract interface d
  {
    public abstract void d0(int paramInt);
    
    public abstract void s(NotificationMsgBean paramNotificationMsgBean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\home\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */