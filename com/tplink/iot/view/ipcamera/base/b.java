package com.tplink.iot.view.ipcamera.base;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.wifi.ScanResult;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.adapters.ListenerUtil;
import androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged;
import androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged;
import androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged;
import androidx.recyclerview.widget.RecyclerView;
import b.d.q.b.o;
import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.h;
import com.bumptech.glide.i;
import com.bumptech.glide.load.engine.j;
import com.bumptech.glide.request.g;
import com.tplink.iot.view.ipcamera.onboardingv2.CameraSSIDAdapter;
import com.tplink.iot.view.ipcamera.onboardingv2.CameraWifiListAdapter;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.view.ipcamera.widget.calendar.scrollCalendar.ScrollCalendar;
import com.tplink.iot.view.ipcamera.widget.scollitem.ScrollPlayRatePicker;
import com.tplink.iot.view.ipcamera.widget.scollitem.ScrollPlayRatePicker.a;
import com.tplink.iot.view.ipcamera.widget.timeaxis.TimeAxisLayout;
import com.tplink.iot.view.ipcamera.widget.timeaxis.TimeAxisLayout.Status;
import com.tplink.iot.view.ipcamera.widget.timeaxis.TimeAxisLayout.b;
import com.tplink.iot.viewmodel.ipcamera.play.VodPlayRate;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.iot.widget.cameralive.VideoSurfaceViewLayout;
import com.tplink.libtpnetwork.Utils.d0;
import com.tplink.libtpnetwork.cameranetwork.model.Wifi;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class b
{
  @BindingAdapter({"onTouch"})
  public static void A(View paramView, View.OnTouchListener paramOnTouchListener)
  {
    paramView.setOnTouchListener(paramOnTouchListener);
  }
  
  @BindingAdapter({"paddingBottom"})
  public static void B(View paramView, Number paramNumber)
  {
    int i = paramView.getPaddingStart();
    int j = paramView.getPaddingEnd();
    int k = paramView.getPaddingTop();
    Context localContext = paramView.getContext();
    float f;
    if (paramNumber == null) {
      f = 0.0F;
    } else {
      f = paramNumber.floatValue();
    }
    paramView.setPaddingRelative(i, k, j, o.a(localContext, f));
  }
  
  @BindingAdapter({"paddingTop"})
  public static void C(View paramView, Number paramNumber)
  {
    Context localContext = paramView.getContext();
    float f;
    if (paramNumber == null) {
      f = 0.0F;
    } else {
      f = paramNumber.floatValue();
    }
    int i = o.a(localContext, f);
    int j = paramView.getPaddingEnd();
    paramView.setPaddingRelative(i, paramView.getPaddingTop(), j, paramView.getPaddingBottom());
  }
  
  @BindingAdapter({"preImageCover"})
  public static void D(ImageView paramImageView, String paramString)
  {
    if (paramString == null) {
      return;
    }
    com.bumptech.glide.c.v(paramImageView).s(paramString).m0(new g().f(j.a)).u0(new b(paramImageView));
  }
  
  @BindingAdapter(requireAll=false, value={"preImageUrl", "useCache"})
  public static void E(ImageView paramImageView, String paramString, boolean paramBoolean)
  {
    if (paramString == null)
    {
      paramImageView.setImageResource(2131689559);
      paramImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      return;
    }
    com.bumptech.glide.c.v(paramImageView).s(paramString).m0(((g)((g)new g().j(2131231605)).f(j.b)).e0(paramBoolean ^ true)).u0(new a(paramImageView, 2131231605));
  }
  
  @BindingAdapter({"presetImage"})
  public static void F(ImageView paramImageView, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    if ((paramObject instanceof Bitmap))
    {
      paramImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      paramImageView.setImageBitmap((Bitmap)paramObject);
    }
    else
    {
      com.bumptech.glide.c.v(paramImageView).g((g)((g)new g().f(j.b)).j(2131231028)).r(paramObject).u0(new c(paramImageView));
    }
  }
  
  @BindingAdapter({"ssidList"})
  public static void G(RecyclerView paramRecyclerView, List<ScanResult> paramList)
  {
    if (paramRecyclerView != null) {
      ((CameraSSIDAdapter)paramRecyclerView.getAdapter()).q(paramList);
    }
  }
  
  @BindingAdapter({"textSizeSp"})
  public static void H(TextView paramTextView, float paramFloat)
  {
    paramTextView.setTextSize(2, paramFloat);
  }
  
  @BindingAdapter(requireAll=false, value={"android:beforeTextChanged", "android:onTextChanged", "android:afterTextChanged", "textAttrChanged"})
  public static void I(DrawableEditText paramDrawableEditText, TextViewBindingAdapter.BeforeTextChanged paramBeforeTextChanged, final TextViewBindingAdapter.OnTextChanged paramOnTextChanged, final TextViewBindingAdapter.AfterTextChanged paramAfterTextChanged, final InverseBindingListener paramInverseBindingListener)
  {
    paramOnTextChanged = new d(paramBeforeTextChanged, paramOnTextChanged, paramInverseBindingListener, paramAfterTextChanged);
    paramBeforeTextChanged = (TextWatcher)ListenerUtil.trackListener(paramDrawableEditText, paramOnTextChanged, 2131364194);
    if (paramBeforeTextChanged != null) {
      paramDrawableEditText.l(paramBeforeTextChanged);
    }
    paramDrawableEditText.f(paramOnTextChanged);
  }
  
  @BindingAdapter({"bind_text"})
  public static void J(DrawableEditText paramDrawableEditText, String paramString)
  {
    if (paramDrawableEditText != null)
    {
      String str1;
      if (paramDrawableEditText.getText() == null) {
        str1 = "";
      } else {
        str1 = paramDrawableEditText.getText().toString();
      }
      String str2 = paramString;
      if (paramString == null) {
        str2 = "";
      }
      if (str1.equalsIgnoreCase(str2)) {
        return;
      }
      paramDrawableEditText.setText(str2);
    }
  }
  
  @BindingAdapter({"showLoading"})
  public static void K(CameraLoadingView paramCameraLoadingView, Boolean paramBoolean)
  {
    if ((paramBoolean != null) && (paramBoolean.booleanValue())) {
      paramCameraLoadingView.b();
    } else {
      paramCameraLoadingView.a();
    }
  }
  
  @BindingAdapter({"currentTime"})
  public static void L(TimeAxisLayout paramTimeAxisLayout, int paramInt)
  {
    paramTimeAxisLayout.setCurrentTime(paramInt);
  }
  
  @BindingAdapter({"detectTimes"})
  public static void M(TimeAxisLayout paramTimeAxisLayout, List<ArrayList<int[]>> paramList)
  {
    if (paramList != null)
    {
      ArrayList localArrayList1 = (ArrayList)paramList.get(0);
      ArrayList localArrayList2 = (ArrayList)paramList.get(1);
      ArrayList localArrayList3 = (ArrayList)paramList.get(2);
      ArrayList localArrayList4 = (ArrayList)paramList.get(3);
      ArrayList localArrayList5 = (ArrayList)paramList.get(4);
      paramList = (ArrayList)paramList.get(5);
      if (localArrayList1 != null) {
        paramTimeAxisLayout.setBabyCryDetectTimes(localArrayList1);
      }
      if (localArrayList2 != null) {
        paramTimeAxisLayout.setPersonDetectTimes(localArrayList2);
      }
      if (localArrayList3 != null) {
        paramTimeAxisLayout.setAreaIntrusionDetectTimes(localArrayList3);
      }
      if (localArrayList4 != null) {
        paramTimeAxisLayout.setLineCrossingDetectTimes(localArrayList4);
      }
      if (localArrayList5 != null) {
        paramTimeAxisLayout.setCameraTamperDetectTimes(localArrayList5);
      }
      if (paramList != null) {
        paramTimeAxisLayout.setMotionDetectTimesV2(paramList);
      }
    }
  }
  
  @BindingAdapter({"timeChangedListener"})
  public static void N(TimeAxisLayout paramTimeAxisLayout, TimeAxisLayout.b paramb)
  {
    paramTimeAxisLayout.setIOnTimeChangedListener(paramb);
  }
  
  @BindingAdapter({"recordTimes"})
  public static void O(TimeAxisLayout paramTimeAxisLayout, Pair<ArrayList<int[]>, ArrayList<int[]>> paramPair)
  {
    Object localObject = null;
    if (paramPair != null)
    {
      localObject = (ArrayList)paramPair.first;
      ArrayList localArrayList = (ArrayList)paramPair.second;
      paramPair = (Pair<ArrayList<int[]>, ArrayList<int[]>>)localObject;
      localObject = localArrayList;
    }
    else
    {
      paramPair = null;
    }
    paramTimeAxisLayout.t(TimeAxisLayout.Status.DATA);
    paramTimeAxisLayout.o();
    paramTimeAxisLayout.setMotionDetectTimes((ArrayList)localObject);
    paramTimeAxisLayout.setRecordTimes(paramPair);
  }
  
  @BindingAdapter({"zoomRatio"})
  public static void P(TimeAxisLayout paramTimeAxisLayout, float paramFloat)
  {
    paramTimeAxisLayout.setZoomRatio(paramFloat);
  }
  
  @BindingAdapter({"visibleOrGone"})
  public static void Q(View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramView.setVisibility(0);
    } else {
      paramView.setVisibility(8);
    }
  }
  
  @BindingAdapter(requireAll=false, value={"fadeAnimation", "fadeAnimationDisable"})
  public static void a(ViewGroup paramViewGroup, boolean paramBoolean, Boolean paramBoolean1)
  {
    if ((paramBoolean1 != null) && (paramBoolean1.booleanValue())) {
      return;
    }
    if (paramViewGroup.getTag() == null) {
      paramViewGroup.setTag(Boolean.TRUE);
    }
    if (paramBoolean)
    {
      paramBoolean1 = new AlphaAnimation(0.1F, 1.0F);
      paramBoolean1.setDuration(300L);
      paramViewGroup.startAnimation(paramBoolean1);
    }
    else
    {
      paramBoolean1 = new AlphaAnimation(1.0F, 0.1F);
      paramBoolean1.setDuration(300L);
      paramViewGroup.startAnimation(paramBoolean1);
    }
  }
  
  @BindingAdapter(requireAll=false, value={"snapshotDismiss", "isMultiScreen"})
  public static void b(ViewGroup paramViewGroup, Boolean paramBoolean1, Boolean paramBoolean2)
  {
    if ((paramBoolean2 != null) && ((paramViewGroup instanceof VideoSurfaceViewLayout))) {
      ((VideoSurfaceViewLayout)paramViewGroup).setMultiScreen(paramBoolean2.booleanValue());
    }
    float f;
    if ((paramBoolean2 != null) && (paramBoolean2.booleanValue())) {
      f = 0.45F;
    } else {
      f = 0.3F;
    }
    if (paramBoolean1 != null) {
      if (paramBoolean1.booleanValue())
      {
        paramBoolean1 = new ScaleAnimation(1.0F, f, 1.0F, f, 2, 0.0F, 2, 1.0F);
        paramBoolean1.setDuration(1000L);
        paramBoolean1.setFillAfter(true);
        paramViewGroup.startAnimation(paramBoolean1);
      }
      else
      {
        paramViewGroup.clearAnimation();
      }
    }
  }
  
  @BindingAdapter(requireAll=false, value={"disable", "overshadowValue"})
  public static void c(View paramView, Boolean paramBoolean, Float paramFloat)
  {
    if (paramBoolean == null) {
      return;
    }
    paramView.setEnabled(paramBoolean.booleanValue() ^ true);
    float f;
    if (paramFloat == null) {
      f = 0.4F;
    } else {
      f = paramFloat.floatValue();
    }
    if (!paramBoolean.booleanValue()) {
      f = 1.0F;
    }
    paramView.setAlpha(f);
  }
  
  @InverseBindingAdapter(attribute="bind_text", event="textAttrChanged")
  public static String d(DrawableEditText paramDrawableEditText)
  {
    return paramDrawableEditText.getText().toString();
  }
  
  @BindingAdapter({"onMonthDateClick"})
  public static void f(ScrollCalendar paramScrollCalendar, com.tplink.iot.view.ipcamera.widget.calendar.b paramb)
  {
    paramScrollCalendar.setMonthDateClickListener(paramb);
  }
  
  @BindingAdapter({"currentDate"})
  public static void g(ScrollCalendar paramScrollCalendar, com.tplink.iot.view.ipcamera.widget.calendar.d paramd)
  {
    if (paramd != null) {
      paramScrollCalendar.setCurrentDate(paramd);
    }
  }
  
  @BindingAdapter({"endOfDay"})
  public static void h(ScrollCalendar paramScrollCalendar, Calendar paramCalendar)
  {
    if (paramCalendar != null) {
      paramScrollCalendar.d(paramCalendar);
    }
  }
  
  @BindingAdapter({"markedDays"})
  public static void i(ScrollCalendar paramScrollCalendar, List<com.tplink.iot.view.ipcamera.widget.calendar.d> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramScrollCalendar.setMarkDays(paramList);
    } else {
      paramScrollCalendar.setMarkDays(null);
    }
  }
  
  @BindingAdapter({"selectDay"})
  public static void j(ScrollCalendar paramScrollCalendar, com.tplink.iot.view.ipcamera.widget.calendar.d paramd)
  {
    if (paramd != null) {
      paramScrollCalendar.setSelectedDay(paramd);
    }
  }
  
  @BindingAdapter({"selectMonth"})
  public static void k(ScrollCalendar paramScrollCalendar, com.tplink.iot.view.ipcamera.widget.calendar.d paramd)
  {
    if (paramd != null) {
      paramScrollCalendar.setSelectMonth(paramd);
    }
  }
  
  @BindingAdapter({"onMonthSelected"})
  public static void l(ScrollCalendar paramScrollCalendar, com.tplink.iot.view.ipcamera.widget.calendar.c paramc)
  {
    paramScrollCalendar.setOnMonthSelectedListener(paramc);
  }
  
  @BindingAdapter({"onPlayRateClick"})
  public static void m(ScrollPlayRatePicker paramScrollPlayRatePicker, ScrollPlayRatePicker.a parama)
  {
    paramScrollPlayRatePicker.setItemClickListener(parama);
  }
  
  @BindingAdapter(requireAll=false, value={"overshadow", "overshadowValue"})
  public static void n(View paramView, Boolean paramBoolean, Float paramFloat)
  {
    if (paramBoolean == null) {
      return;
    }
    float f;
    if (paramFloat == null) {
      f = 0.4F;
    } else {
      f = paramFloat.floatValue();
    }
    if (!paramBoolean.booleanValue()) {
      f = 1.0F;
    }
    paramView.setAlpha(f);
  }
  
  @BindingAdapter(requireAll=false, value={"selectNone", "playRate"})
  public static void o(ScrollPlayRatePicker paramScrollPlayRatePicker, boolean paramBoolean, VodPlayRate paramVodPlayRate)
  {
    if (paramBoolean) {
      paramScrollPlayRatePicker.e();
    } else if (paramVodPlayRate != null) {
      paramScrollPlayRatePicker.d(paramVodPlayRate);
    }
  }
  
  @BindingAdapter({"autoRotate"})
  public static void p(View paramView, boolean paramBoolean)
  {
    Object localObject = paramView.getTag(2131363922);
    if (localObject == null)
    {
      if (paramBoolean)
      {
        localObject = ObjectAnimator.ofFloat(paramView, "rotation", new float[] { 0.0F, 360.0F });
        paramView.setTag(2131363922, localObject);
        paramView = (View)localObject;
      }
    }
    else {
      paramView = (ObjectAnimator)localObject;
    }
    if (paramBoolean)
    {
      paramView.setInterpolator(new LinearInterpolator());
      paramView.setRepeatCount(-1);
      paramView.setDuration(600L);
      paramView.start();
    }
    else
    {
      paramView.end();
    }
  }
  
  @BindingAdapter(requireAll=false, value={"avoidClicks", "avoidClicksDurationMilliseconds"})
  public static void q(View paramView, Boolean paramBoolean, Long paramLong)
  {
    if (paramBoolean == null) {
      return;
    }
    if (paramBoolean.booleanValue()) {
      paramView.setOnTouchListener(new e(paramLong));
    } else {
      paramView.setOnTouchListener(null);
    }
  }
  
  @BindingAdapter({"wifiList", "wpa3Supported"})
  public static void r(RecyclerView paramRecyclerView, List<Wifi> paramList, boolean paramBoolean)
  {
    if (paramRecyclerView != null)
    {
      paramRecyclerView = (CameraWifiListAdapter)paramRecyclerView.getAdapter();
      paramRecyclerView.t(paramBoolean);
      paramRecyclerView.s(paramList);
    }
  }
  
  @BindingAdapter({"delayVisible"})
  public static void s(LottieAnimationView paramLottieAnimationView, Boolean paramBoolean)
  {
    if (org.apache.commons.lang.b.b(paramBoolean))
    {
      Object localObject = paramLottieAnimationView.getTag(2131362385);
      paramBoolean = (Boolean)localObject;
      if (localObject == null)
      {
        paramBoolean = new a(paramLottieAnimationView);
        paramLottieAnimationView.setTag(2131362385, paramBoolean);
      }
      paramLottieAnimationView.postDelayed((Runnable)paramBoolean, 100L);
    }
    else
    {
      paramBoolean = paramLottieAnimationView.getTag(2131362385);
      if (paramBoolean != null) {
        paramLottieAnimationView.removeCallbacks((Runnable)paramBoolean);
      }
      paramLottieAnimationView.setVisibility(8);
    }
  }
  
  @BindingAdapter(requireAll=false, value={"exitDst", "exitDstHour", "exitDstMinute"})
  public static void t(TimeAxisLayout paramTimeAxisLayout, Boolean paramBoolean, Integer paramInteger1, Integer paramInteger2)
  {
    int i = 0;
    boolean bool;
    if (paramBoolean != null) {
      bool = paramBoolean.booleanValue();
    } else {
      bool = false;
    }
    int j;
    if (paramInteger1 != null) {
      j = paramInteger1.intValue();
    } else {
      j = 1;
    }
    if (paramInteger2 != null) {
      i = paramInteger2.intValue();
    }
    paramTimeAxisLayout.s(bool, j, i);
  }
  
  @BindingAdapter({"layout_alignParentEnd"})
  public static void u(View paramView, boolean paramBoolean)
  {
    paramView = paramView.getLayoutParams();
    if ((paramView instanceof RelativeLayout.LayoutParams))
    {
      paramView = (RelativeLayout.LayoutParams)paramView;
      if (paramBoolean) {
        paramView.addRule(11);
      } else {
        paramView.removeRule(11);
      }
    }
  }
  
  @BindingAdapter({"margin"})
  public static void v(View paramView, Number paramNumber)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    paramView = paramView.getContext();
    float f;
    if (paramNumber == null) {
      f = 0.0F;
    } else {
      f = paramNumber.floatValue();
    }
    int i = o.a(paramView, f);
    localMarginLayoutParams.setMargins(i, i, i, i);
  }
  
  @BindingAdapter({"marginAndAlign"})
  public static void w(View paramView, boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramBoolean)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.addRule(12, -1);
      localLayoutParams.bottomMargin = o.a(paramView.getContext(), 8.0F);
    }
    else
    {
      localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.removeRule(12);
      localLayoutParams.bottomMargin = o.a(paramView.getContext(), 6.0F);
    }
  }
  
  @BindingAdapter({"marginEnd"})
  public static void x(View paramView, Number paramNumber)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    paramView = paramView.getContext();
    float f;
    if (paramNumber == null) {
      f = 0.0F;
    } else {
      f = paramNumber.floatValue();
    }
    localMarginLayoutParams.setMarginEnd(o.a(paramView, f));
  }
  
  @BindingAdapter({"marginStart"})
  public static void y(View paramView, Number paramNumber)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    paramView = paramView.getContext();
    float f;
    if (paramNumber == null) {
      f = 0.0F;
    } else {
      f = paramNumber.floatValue();
    }
    localMarginLayoutParams.setMarginStart(o.a(paramView, f));
  }
  
  @BindingAdapter({"marginTop"})
  public static void z(View paramView, Number paramNumber)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    paramView = paramView.getContext();
    float f;
    if (paramNumber == null) {
      f = 0.0F;
    } else {
      f = paramNumber.floatValue();
    }
    localMarginLayoutParams.topMargin = o.a(paramView, f);
  }
  
  static final class a
    extends com.bumptech.glide.request.k.d<ImageView, Drawable>
  {
    a(ImageView paramImageView, int paramInt)
    {
      super();
    }
    
    public void h(@Nullable Drawable paramDrawable)
    {
      ((ImageView)this.f).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      ((ImageView)this.f).setImageDrawable(paramDrawable);
    }
    
    protected void l(@Nullable Drawable paramDrawable)
    {
      ((ImageView)this.f).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      ((ImageView)this.f).setImageResource(this.z);
    }
    
    public void o(@NonNull Drawable paramDrawable, @Nullable com.bumptech.glide.request.l.b<? super Drawable> paramb)
    {
      ((ImageView)this.f).setScaleType(ImageView.ScaleType.FIT_XY);
      ((ImageView)this.f).setImageDrawable(paramDrawable);
    }
  }
  
  static final class b
    extends com.bumptech.glide.request.k.d<ImageView, Drawable>
  {
    b(ImageView paramImageView)
    {
      super();
    }
    
    public void h(@Nullable Drawable paramDrawable) {}
    
    protected void l(@Nullable Drawable paramDrawable) {}
    
    public void o(@NonNull Drawable paramDrawable, @Nullable com.bumptech.glide.request.l.b<? super Drawable> paramb)
    {
      ((ImageView)this.f).setScaleType(ImageView.ScaleType.FIT_XY);
      ((ImageView)this.f).setImageDrawable(paramDrawable);
    }
  }
  
  static final class c
    extends com.bumptech.glide.request.k.d<ImageView, Drawable>
  {
    c(ImageView paramImageView)
    {
      super();
    }
    
    public void h(@Nullable Drawable paramDrawable)
    {
      ((ImageView)this.f).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      ((ImageView)this.f).setImageDrawable(paramDrawable);
    }
    
    protected void l(@Nullable Drawable paramDrawable) {}
    
    public void o(@NonNull Drawable paramDrawable, @Nullable com.bumptech.glide.request.l.b<? super Drawable> paramb)
    {
      ((ImageView)this.f).setScaleType(ImageView.ScaleType.FIT_XY);
      ((ImageView)this.f).setImageDrawable(paramDrawable);
    }
  }
  
  static final class d
    implements TextWatcher
  {
    d(TextViewBindingAdapter.BeforeTextChanged paramBeforeTextChanged, TextViewBindingAdapter.OnTextChanged paramOnTextChanged, InverseBindingListener paramInverseBindingListener, TextViewBindingAdapter.AfterTextChanged paramAfterTextChanged) {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      TextViewBindingAdapter.AfterTextChanged localAfterTextChanged = paramAfterTextChanged;
      if (localAfterTextChanged != null) {
        localAfterTextChanged.afterTextChanged(paramEditable);
      }
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      TextViewBindingAdapter.BeforeTextChanged localBeforeTextChanged = this.c;
      if (localBeforeTextChanged != null) {
        localBeforeTextChanged.beforeTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
      }
    }
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      TextViewBindingAdapter.OnTextChanged localOnTextChanged = paramOnTextChanged;
      if (localOnTextChanged != null) {
        localOnTextChanged.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
      }
      paramCharSequence = paramInverseBindingListener;
      if (paramCharSequence != null) {
        paramCharSequence.onChange();
      }
    }
  }
  
  static final class e
    implements View.OnTouchListener
  {
    long c = 0L;
    long d;
    
    e(Long paramLong)
    {
      this.d = ((Long)d0.b(paramLong, Long.valueOf(500L))).longValue();
    }
    
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      if (paramMotionEvent.getAction() == 0)
      {
        long l = System.currentTimeMillis();
        if (l - this.c < this.d) {
          return true;
        }
        this.c = l;
      }
      return false;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\base\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */