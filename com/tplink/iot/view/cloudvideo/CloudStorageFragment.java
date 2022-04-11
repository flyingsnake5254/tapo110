package com.tplink.iot.view.cloudvideo;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.Utils.o0;
import com.tplink.iot.Utils.q0;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.v0.b.a;
import com.tplink.iot.Utils.x0.w;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.cloud.bean.cloudvideo.common.CloudVideo;
import com.tplink.iot.cloud.bean.cloudvideo.common.CloudVideoThumbnail;
import com.tplink.iot.cloud.bean.cloudvideo.common.DeviceCloudProduct;
import com.tplink.iot.cloud.bean.cloudvideo.common.OrderInfo;
import com.tplink.iot.cloud.bean.cloudvideo.common.PartCloudVideo;
import com.tplink.iot.cloud.bean.cloudvideo.result.TrialResult;
import com.tplink.iot.view.ipcamera.setting.firmware.FirmwareUpdateNewIpcActivity;
import com.tplink.iot.view.tapocare.BillingDialogActivity;
import com.tplink.iot.view.tapocare.TrialDialogActivity;
import com.tplink.iot.viewmodel.cloudvideo.CloudVideoViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VideoPlayViewModel;
import com.tplink.libtpnetwork.Utils.o;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CommonCameraRepository;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.List;

public class CloudStorageFragment
  extends BaseFragment
  implements b.a
{
  private boolean H3 = false;
  @BindView
  ImageView mCloseIv;
  @BindView
  TextView mCloudStorageConfirmTv;
  @BindView
  TextView mCloudStorageContentTv;
  @BindView
  TextView mCloudStorageTitleTv;
  @BindView
  View mCloudStorageVideoListView;
  @BindView
  View mCloudStorageView;
  @BindView
  View mCloudVideoListView;
  @BindView
  View mEmptyView;
  @BindView
  TextView mExpireTimeTv;
  @BindView
  ImageView mFirstCloudNoVideoIv;
  @BindView
  ImageView mFirstCloudVideoIv;
  @BindView
  TextView mFirstCloudVideoTv;
  @BindView
  View mFirstCloudVideoView;
  @BindView
  ImageView mNewDailySummaryPoint;
  @BindView
  ImageView mSecondCloudNoVideoIv;
  @BindView
  ImageView mSecondCloudVideoIv;
  @BindView
  TextView mSecondCloudVideoTv;
  @BindView
  View mSecondCloudVideoView;
  @BindView
  ImageView mThirdCloudNoVideoIv;
  @BindView
  ImageView mThirdCloudVideoIv;
  @BindView
  TextView mThirdCloudVideoTv;
  @BindView
  View mThirdCloudVideoView;
  private io.reactivex.e0.b p0 = new io.reactivex.e0.b();
  private boolean p1 = true;
  private boolean p2 = false;
  private DeviceCloudProduct p3;
  private CloudVideoViewModel q;
  private VideoPlayViewModel x;
  private String y = "";
  private List<CloudVideo> z = new ArrayList();
  
  private void U0()
  {
    if (TextUtils.isEmpty(this.y)) {
      return;
    }
    Object localObject = b.d.w.h.a.g(this.y);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    if (!com.tplink.libtpnetwork.Utils.f.f((String)localObject)) {
      return;
    }
    localObject = ((CommonCameraRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c((String)localObject, CommonCameraRepository.class)).K0().L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).G0(new i(this, (String)localObject));
    this.p0.b((io.reactivex.e0.c)localObject);
  }
  
  private void V0(String paramString)
  {
    if (getActivity() == null) {
      return;
    }
    Intent localIntent = new Intent(getActivity(), FirmwareUpdateNewIpcActivity.class);
    localIntent.putExtra("device_id_md5", paramString);
    startActivity(localIntent);
  }
  
  private void W0(CloudVideo paramCloudVideo)
  {
    if (paramCloudVideo != null) {
      if ((paramCloudVideo.getPartCloudVideos() != null) && (paramCloudVideo.getPartCloudVideos().size() > 0))
      {
        PartCloudVideo localPartCloudVideo = (PartCloudVideo)paramCloudVideo.getPartCloudVideos().get(0);
        if ((localPartCloudVideo != null) && (localPartCloudVideo.getUri() != null)) {
          X0(localPartCloudVideo.getM3u8(), localPartCloudVideo.getUri(), localPartCloudVideo.getDuration(), localPartCloudVideo.getStartTimestamp(), paramCloudVideo.getUuid());
        }
      }
      else
      {
        s0.p(getActivity(), getString(2131954391));
      }
    }
  }
  
  private void X0(String paramString1, String paramString2, long paramLong1, long paramLong2, String paramString3)
  {
    Intent localIntent = new Intent(getActivity(), CloudVideoListActivity.class);
    localIntent.putExtra("cloud_video_device_id", this.y);
    if ((paramString1 != null) && (paramString2 != null))
    {
      localIntent.putExtra("cloud_video_m3u8", paramString1);
      localIntent.putExtra("cloud_video_uri", paramString2);
      localIntent.putExtra("cloud_video_duration", paramLong1);
      localIntent.putExtra("cloud_video_timestamp", paramLong2);
      localIntent.putExtra("cloud_video_uuid", paramString3);
    }
    startActivity(localIntent);
  }
  
  private void Y0() {}
  
  private void q1(boolean paramBoolean)
  {
    this.mCloudStorageView.setVisibility(8);
    if (paramBoolean) {
      this.q.B0();
    } else {
      this.q.A0();
    }
  }
  
  private void r1()
  {
    if (getContext() != null)
    {
      float f1 = getResources().getDrawable(2131689575).getIntrinsicWidth();
      float f2 = com.tplink.libtpnetwork.cameranetwork.util.e.c(getContext())[0];
      float f3 = b.d.w.f.a.a(getContext(), 10.0F);
      Object localObject = new Paint();
      ((Paint)localObject).setTextSize(this.mCloudStorageConfirmTv.getTextSize());
      if (f2 - f1 - f3 < ((Paint)localObject).measureText(this.mCloudStorageConfirmTv.getText().toString()))
      {
        localObject = new ConstraintLayout.LayoutParams(-2, -2);
        ((ConstraintLayout.LayoutParams)localObject).topToBottom = 2131364330;
        ((ConstraintLayout.LayoutParams)localObject).startToStart = 2131363274;
        ((ConstraintLayout.LayoutParams)localObject).bottomToBottom = 2131363274;
        ((ViewGroup.MarginLayoutParams)localObject).leftMargin = b.d.w.f.a.a(getContext(), 12.0F);
        ((ViewGroup.MarginLayoutParams)localObject).rightMargin = b.d.w.f.a.a(getContext(), 12.0F);
        this.mCloudStorageConfirmTv.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  private void s1()
  {
    if (getActivity() == null) {
      return;
    }
    TPMaterialDialogV2.Builder localBuilder = new TPMaterialDialogV2.Builder(getActivity());
    localBuilder.h(2131951945);
    localBuilder.c(false);
    localBuilder.b(false);
    localBuilder.o(2131952441, 2131099808, null);
    localBuilder.l(2131951887, 2131099804, new f(this));
    localBuilder.g(8, 8);
    localBuilder.a().show();
  }
  
  private void t1(DeviceCloudProduct paramDeviceCloudProduct, boolean paramBoolean)
  {
    int i = this.q.R(paramDeviceCloudProduct, paramBoolean);
    int j = 0;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          this.p1 = false;
          this.mCloseIv.setOnClickListener(new j(this));
          paramDeviceCloudProduct = this.mCloudStorageView;
          if (!this.q.n()) {
            j = 8;
          }
          paramDeviceCloudProduct.setVisibility(j);
          this.mCloudStorageVideoListView.setVisibility(8);
          this.mCloudStorageConfirmTv.setText(getString(2131954269));
          r1();
        }
        else
        {
          this.p1 = false;
          this.mCloudStorageView.setVisibility(0);
          this.mCloudStorageVideoListView.setVisibility(8);
          p1();
        }
      }
      else
      {
        this.p1 = false;
        if (!this.H3)
        {
          this.H3 = true;
          U0();
        }
        this.mCloudStorageView.setVisibility(8);
        w1(paramDeviceCloudProduct);
        this.q.P(this.y);
        this.mCloudStorageVideoListView.setVisibility(0);
        this.mEmptyView.setVisibility(0);
      }
    }
    else
    {
      this.p1 = true;
      paramDeviceCloudProduct = this.mCloudStorageView;
      if (this.q.n()) {
        j = 0;
      } else {
        j = 8;
      }
      paramDeviceCloudProduct.setVisibility(j);
      this.mCloudStorageVideoListView.setVisibility(8);
      this.mCloseIv.setOnClickListener(new g(this));
      this.mCloudStorageConfirmTv.setText(String.format(getString(2131954233), new Object[] { "30" }));
      r1();
      z1();
    }
  }
  
  private void u1(final String paramString)
  {
    if (getActivity() == null) {
      return;
    }
    TPMaterialDialogV2.Builder localBuilder = new TPMaterialDialogV2.Builder(getActivity());
    localBuilder.r(2131953787);
    localBuilder.h(2131953788);
    localBuilder.c(false);
    localBuilder.b(false);
    localBuilder.o(2131954377, 2131099808, new f(paramString));
    localBuilder.l(2131952391, 2131099804, null);
    localBuilder.g(8, 8);
    localBuilder.a().show();
  }
  
  private void v1()
  {
    this.q.C().observe(this, new b());
    this.q.y().observe(this, new c());
    this.x.k.observe(this, new d());
    this.q.T().observe(this, new d(this));
    this.q.K().observe(this, new e(this));
    this.q.E().observe(this, new c(this));
    this.q.M().observe(this, new h(this));
  }
  
  private void w1(DeviceCloudProduct paramDeviceCloudProduct)
  {
    if (this.q.u(paramDeviceCloudProduct)) {
      this.mExpireTimeTv.setText(getResources().getString(2131952340, new Object[] { o0.r(paramDeviceCloudProduct.getEndTime()) }));
    } else {
      this.mExpireTimeTv.setText(getResources().getString(2131954263, new Object[] { o0.r(paramDeviceCloudProduct.getTrial().getEndTime()) }));
    }
  }
  
  private void x1(List<CloudVideo> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      if (this.z == null) {
        this.z = new ArrayList();
      }
      this.z.clear();
      this.z.addAll(paramList);
      this.mFirstCloudVideoView.setVisibility(4);
      this.mSecondCloudVideoView.setVisibility(4);
      this.mThirdCloudVideoView.setVisibility(4);
      this.mFirstCloudNoVideoIv.setVisibility(8);
      this.mSecondCloudNoVideoIv.setVisibility(8);
      this.mThirdCloudNoVideoIv.setVisibility(8);
      for (int i = 0; i < paramList.size(); i++)
      {
        Object localObject1 = (CloudVideo)paramList.get(i);
        Object localObject2 = ((CloudVideo)localObject1).getPartCloudVideos();
        int j;
        if ((localObject2 != null) && (!((List)localObject2).isEmpty())) {
          j = 0;
        } else {
          j = 1;
        }
        localObject2 = ((CloudVideoThumbnail)((CloudVideo)localObject1).getVideoThumbnails().get(0)).getUri();
        localObject1 = q0.b(((CloudVideo)localObject1).getEventLocalTime());
        if (i == 0)
        {
          this.mFirstCloudVideoView.setVisibility(0);
          if (j != 0) {
            this.mFirstCloudNoVideoIv.setVisibility(0);
          }
          this.mFirstCloudVideoTv.setText((CharSequence)localObject1);
          y1(this.mFirstCloudVideoIv, (String)localObject2);
        }
        else if (i == 1)
        {
          this.mSecondCloudVideoView.setVisibility(0);
          if (j != 0) {
            this.mSecondCloudNoVideoIv.setVisibility(0);
          }
          this.mSecondCloudVideoTv.setText((CharSequence)localObject1);
          y1(this.mSecondCloudVideoIv, (String)localObject2);
        }
        else if (i == 2)
        {
          this.mThirdCloudVideoView.setVisibility(0);
          if (j != 0) {
            this.mThirdCloudNoVideoIv.setVisibility(0);
          }
          this.mThirdCloudVideoTv.setText((CharSequence)localObject1);
          y1(this.mThirdCloudVideoIv, (String)localObject2);
          break;
        }
      }
    }
  }
  
  private void y1(ImageView paramImageView, String paramString)
  {
    if (paramImageView != null)
    {
      com.bumptech.glide.request.g localg = (com.bumptech.glide.request.g)((com.bumptech.glide.request.g)((com.bumptech.glide.request.g)new com.bumptech.glide.request.g().V(2131689581)).j(2131689581)).f(com.bumptech.glide.load.engine.j.d);
      com.bumptech.glide.c.x(getActivity()).s(paramString).m0(localg).x0(paramImageView);
    }
  }
  
  private void z1()
  {
    Object localObject = b.d.s.a.a.f();
    if ((localObject != null) && (((com.tplink.cloud.context.b)localObject).c() != null))
    {
      localObject = ((com.tplink.cloud.context.b)localObject).c().getAccountId();
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!o.h0().p0((String)localObject, this.y)))
      {
        o.h0().m1((String)localObject, this.y);
        w.H(this.x.j);
      }
    }
  }
  
  public void D0()
  {
    this.q.w(this.y);
  }
  
  @OnClick
  void firstCloudVideoClicked()
  {
    List localList = this.z;
    if ((localList != null) && (localList.size() >= 1)) {
      W0((CloudVideo)this.z.get(0));
    }
  }
  
  @OnClick
  void gotoStorageService()
  {
    
    if (this.p1)
    {
      TrialDialogActivity.f1(getActivity(), com.tplink.iot.Utils.v0.e.k(this.y));
      w.s();
    }
    else if (this.p2)
    {
      BillingDialogActivity.f1(getActivity(), com.tplink.iot.Utils.v0.e.x());
      w.p();
    }
    else
    {
      BillingDialogActivity.f1(getActivity(), com.tplink.iot.Utils.v0.e.i(this.y));
      w.u();
    }
  }
  
  public void onActivityCreated(@Nullable Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.q = ((CloudVideoViewModel)ViewModelProviders.of(this).get(CloudVideoViewModel.class));
    this.x = ((VideoPlayViewModel)ViewModelProviders.of(getActivity()).get(VideoPlayViewModel.class));
    this.mCloudStorageContentTv.setText(String.format(getString(2131954231), new Object[] { "30" }));
    v1();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1345) {
      this.q.w(this.y);
    } else {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558909, paramViewGroup, false);
    setHasOptionsMenu(false);
    ButterKnife.b(this, paramLayoutInflater);
    com.tplink.iot.Utils.v0.b.a().c(this);
    Y0();
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.p0.d();
  }
  
  public void onDestroyView()
  {
    com.tplink.iot.Utils.v0.b.a().d(this);
    super.onDestroyView();
  }
  
  @OnClick
  void onExpireClick()
  {
    
    if (this.q.u(this.p3)) {
      BillingDialogActivity.f1(getActivity(), com.tplink.iot.Utils.v0.e.g(this.y));
    } else if (this.q.t(this.p3)) {
      this.q.N().observe(this, new a());
    }
  }
  
  public void p1()
  {
    this.q.N().observe(this, new e());
  }
  
  @OnClick
  void secondCloudVideoClicked()
  {
    List localList = this.z;
    if ((localList != null) && (localList.size() >= 2)) {
      W0((CloudVideo)this.z.get(1));
    }
  }
  
  @OnClick
  void showVideoList()
  {
    X0(null, null, 0L, 0L, "");
  }
  
  @OnClick
  void thirdCloudVideoClicked()
  {
    List localList = this.z;
    if ((localList != null) && (localList.size() >= 3)) {
      W0((CloudVideo)this.z.get(2));
    }
  }
  
  class a
    implements Observer<List<OrderInfo>>
  {
    a() {}
    
    public void a(List<OrderInfo> paramList)
    {
      CloudStorageFragment.H0(CloudStorageFragment.this).N().removeObserver(this);
      if (CloudStorageFragment.H0(CloudStorageFragment.this).H(paramList, "")) {
        BillingDialogActivity.f1(CloudStorageFragment.this.getActivity(), com.tplink.iot.Utils.v0.e.x());
      } else {
        BillingDialogActivity.f1(CloudStorageFragment.this.getActivity(), com.tplink.iot.Utils.v0.e.i(CloudStorageFragment.I0(CloudStorageFragment.this)));
      }
    }
  }
  
  class b
    implements Observer<List<CloudVideo>>
  {
    b() {}
    
    public void a(List<CloudVideo> paramList)
    {
      CloudStorageFragment.this.mCloudStorageVideoListView.setVisibility(0);
      if ((paramList != null) && (paramList.size() > 0))
      {
        CloudStorageFragment.this.mCloudVideoListView.setVisibility(0);
        CloudStorageFragment.this.mEmptyView.setVisibility(8);
        CloudStorageFragment.K0(CloudStorageFragment.this, paramList);
      }
      else
      {
        CloudStorageFragment.this.mCloudVideoListView.setVisibility(8);
        CloudStorageFragment.this.mEmptyView.setVisibility(0);
      }
    }
  }
  
  class c
    implements Observer<DeviceCloudProduct>
  {
    c() {}
    
    public void a(DeviceCloudProduct paramDeviceCloudProduct)
    {
      CloudStorageFragment.N0(CloudStorageFragment.this, paramDeviceCloudProduct);
      paramDeviceCloudProduct = CloudStorageFragment.this;
      CloudStorageFragment.O0(paramDeviceCloudProduct, CloudStorageFragment.L0(paramDeviceCloudProduct), false);
    }
  }
  
  class d
    implements Observer<String>
  {
    d() {}
    
    public void a(String paramString)
    {
      String str = CloudStorageFragment.H0(CloudStorageFragment.this).G(paramString);
      if ((!TextUtils.isEmpty(paramString)) && (com.tplink.iot.Utils.v0.d.c(paramString)))
      {
        if (!CloudStorageFragment.H0(CloudStorageFragment.this).Y(paramString))
        {
          CloudStorageFragment.J0(CloudStorageFragment.this, str);
          if (!TextUtils.isEmpty(CloudStorageFragment.I0(CloudStorageFragment.this))) {
            CloudStorageFragment.H0(CloudStorageFragment.this).w(CloudStorageFragment.I0(CloudStorageFragment.this));
          }
        }
        return;
      }
      CloudStorageFragment.this.mCloudStorageView.setVisibility(8);
      CloudStorageFragment.this.mCloudStorageVideoListView.setVisibility(8);
    }
  }
  
  class e
    implements Observer<List<OrderInfo>>
  {
    e() {}
    
    public void e(List<OrderInfo> paramList)
    {
      CloudStorageFragment.H0(CloudStorageFragment.this).N().removeObserver(this);
      if (CloudStorageFragment.H0(CloudStorageFragment.this).H(paramList, ""))
      {
        CloudStorageFragment.P0(CloudStorageFragment.this, true);
        CloudStorageFragment.this.mCloseIv.setOnClickListener(new a(this));
        if (!CloudStorageFragment.H0(CloudStorageFragment.this).o()) {
          CloudStorageFragment.this.mCloudStorageView.setVisibility(8);
        }
        paramList = CloudStorageFragment.this;
        paramList.mCloudStorageConfirmTv.setText(paramList.getString(2131954241));
        CloudStorageFragment.Q0(CloudStorageFragment.this);
      }
      else
      {
        CloudStorageFragment.P0(CloudStorageFragment.this, false);
        CloudStorageFragment.this.mCloseIv.setOnClickListener(new b(this));
        if (!CloudStorageFragment.H0(CloudStorageFragment.this).n()) {
          CloudStorageFragment.this.mCloudStorageView.setVisibility(8);
        }
        paramList = CloudStorageFragment.this;
        paramList.mCloudStorageConfirmTv.setText(paramList.getString(2131954269));
        CloudStorageFragment.Q0(CloudStorageFragment.this);
      }
    }
  }
  
  class f
    implements TPMaterialDialogV2.d
  {
    f(String paramString) {}
    
    public void onClick(View paramView)
    {
      CloudStorageFragment.T0(CloudStorageFragment.this, paramString);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\cloudvideo\CloudStorageFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */