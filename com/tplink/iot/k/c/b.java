package com.tplink.iot.k.c;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.media.AudioRecord;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import b.d.w.c.a;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.d.a;
import com.airbnb.lottie.j;
import com.airbnb.lottie.k;
import com.airbnb.lottie.w.e;
import com.tplink.iot.Utils.TPLongMaterialDialogV2;
import com.tplink.iot.Utils.TPLongMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPLongMaterialDialogV2.d;
import com.tplink.iot.Utils.TPLongThreeMaterialDialog;
import com.tplink.iot.Utils.TPLongThreeMaterialDialog.Builder;
import com.tplink.iot.Utils.TPLongThreeMaterialDialog.e;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.Utils.b0;
import com.tplink.iot.musicphonerhythm.bean.MusicRhythmGlobalConfigBean;
import com.tplink.iot.musicphonerhythm.enumerate.Sensitivity;
import com.tplink.iot.musicphonerhythm.enumerate.SpeedGap;
import com.tplink.iot.musicphonerhythm.views.MusicRhymeFirstShowGuideDialog;
import com.tplink.iot.view.feedback.EnumFeedbackCategory;
import com.tplink.iot.view.feedback.HelpAndFeedbackActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b
{
  public static ArrayList<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("single_lamp");
    return localArrayList;
  }
  
  public static MusicRhythmGlobalConfigBean b()
  {
    return new MusicRhythmGlobalConfigBean(false, 280, 0, 100);
  }
  
  private static String c(String paramString)
  {
    paramString.hashCode();
    int i = paramString.hashCode();
    int j = -1;
    switch (i)
    {
    default: 
      break;
    case 440747165: 
      if (paramString.equals("power_mode")) {
        j = 2;
      }
      break;
    case -208977225: 
      if (paramString.equals("light_flow")) {
        j = 1;
      }
      break;
    case -1731972241: 
      if (paramString.equals("single_lamp")) {
        j = 0;
      }
      break;
    }
    switch (j)
    {
    default: 
      return null;
    case 2: 
      return "music_rhythm_power_mode.json";
    case 1: 
      return "music_rhythm_flowing_beam_mode.json";
    }
    return "music_rhythm_single_lamp_mode.json";
  }
  
  public static ArrayList<String> d()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("single_lamp");
    return localArrayList;
  }
  
  public static String e(String paramString)
  {
    paramString.hashCode();
    int i = paramString.hashCode();
    int j = -1;
    switch (i)
    {
    default: 
      break;
    case 440747165: 
      if (paramString.equals("power_mode")) {
        j = 2;
      }
      break;
    case -208977225: 
      if (paramString.equals("light_flow")) {
        j = 1;
      }
      break;
    case -1731972241: 
      if (paramString.equals("single_lamp")) {
        j = 0;
      }
      break;
    }
    switch (j)
    {
    default: 
      return b0.a(2131953170);
    case 2: 
      return b0.a(2131953189);
    case 1: 
      return b0.a(2131953178);
    }
    return b0.a(2131953170);
  }
  
  public static Sensitivity f(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return Sensitivity.NORMAL_SENSITIVE;
            }
            return Sensitivity.VERY_SENSITIVE;
          }
          return Sensitivity.SENSITIVE;
        }
        return Sensitivity.NORMAL_SENSITIVE;
      }
      return Sensitivity.LITTLE_SENSITIVE;
    }
    return Sensitivity.LESS_SENSITIVE;
  }
  
  public static SpeedGap g(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return SpeedGap.NORMAL_SPEED;
            }
            return SpeedGap.VERY_FAST;
          }
          return SpeedGap.FAST;
        }
        return SpeedGap.NORMAL_SPEED;
      }
      return SpeedGap.SLOW;
    }
    return SpeedGap.VERY_SLOW;
  }
  
  public static void h(Activity paramActivity, int paramInt, final o paramo)
  {
    if (paramActivity == null) {
      return;
    }
    Object localObject1;
    Object localObject2;
    if (paramInt < 2)
    {
      localObject1 = new TPMaterialDialogV2.Builder(paramActivity);
      localObject2 = ((TPMaterialDialogV2.Builder)localObject1).a();
      ((TPMaterialDialogV2.Builder)localObject1).j(paramActivity.getApplicationContext().getString(2131953182)).o(2131952454, 2131099808, new g(paramo)).m(2131952391, new f((TPMaterialDialogV2)localObject2, paramo)).g(8, 0).b(false).c(false).a();
      ((TPMaterialDialogV2)localObject2).show();
    }
    else
    {
      localObject2 = new TPLongThreeMaterialDialog.Builder(paramActivity);
      localObject1 = ((TPLongThreeMaterialDialog.Builder)localObject2).a();
      ((TPLongThreeMaterialDialog.Builder)localObject2).e(2131953181).k(2131953180, 2131099808, new j(paramActivity, paramo)).m(2131952454, 2131099808, new i(paramo)).i(2131952391, new h((TPLongThreeMaterialDialog)localObject1, paramo)).d(8, 0).b(false).c(false).a();
      ((TPLongThreeMaterialDialog)localObject1).show();
    }
  }
  
  public static void i(Activity paramActivity, p paramp)
  {
    if (paramActivity == null) {
      return;
    }
    new TPMaterialDialogV2.Builder(paramActivity).h(2131953171).l(2131952432, 2131099794, new b(paramp)).o(2131951865, 2131099808, new a()).g(8, 8).b(false).c(false).a().show();
  }
  
  public static void j(FragmentManager paramFragmentManager)
  {
    MusicRhymeFirstShowGuideDialog.G0().show(paramFragmentManager, MusicRhymeFirstShowGuideDialog.c);
  }
  
  public static void k(final Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    TPLongMaterialDialogV2.Builder localBuilder = new TPLongMaterialDialogV2.Builder(paramActivity);
    TPLongMaterialDialogV2 localTPLongMaterialDialogV2 = localBuilder.a();
    localBuilder.g(paramActivity.getApplicationContext().getString(2131953183)).l(2131952441, 2131099808, new m(localTPLongMaterialDialogV2, paramActivity)).d(8, 0).b(false).c(false).a();
    if (!localTPLongMaterialDialogV2.isShowing()) {
      localTPLongMaterialDialogV2.show();
    }
  }
  
  public static void l(final Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    TPLongMaterialDialogV2.Builder localBuilder = new TPLongMaterialDialogV2.Builder(paramActivity);
    TPLongMaterialDialogV2 localTPLongMaterialDialogV2 = localBuilder.a();
    localBuilder.g(paramActivity.getApplicationContext().getString(2131953182)).l(2131952441, 2131099808, new k(localTPLongMaterialDialogV2, paramActivity)).d(8, 0).b(false).c(false).a();
    if (!localTPLongMaterialDialogV2.isShowing()) {
      localTPLongMaterialDialogV2.show();
    }
  }
  
  public static void m(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    TPLongMaterialDialogV2.Builder localBuilder = new TPLongMaterialDialogV2.Builder(paramActivity);
    TPLongMaterialDialogV2 localTPLongMaterialDialogV2 = localBuilder.a();
    localBuilder.g(paramActivity.getApplicationContext().getString(2131952984)).l(2131952441, 2131099808, new l(localTPLongMaterialDialogV2)).d(8, 0).b(false).c(false).a();
    if (!localTPLongMaterialDialogV2.isShowing()) {
      localTPLongMaterialDialogV2.show();
    }
  }
  
  public static void n(Activity paramActivity, q paramq)
  {
    if (paramActivity == null) {
      return;
    }
    new TPMaterialDialogV2.Builder(paramActivity).h(2131953184).l(2131953962, 2131099794, new d(paramq)).o(2131952391, 2131099808, new c()).g(8, 8).b(false).c(false).a().show();
  }
  
  public static void o(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    TPLongMaterialDialogV2.Builder localBuilder = new TPLongMaterialDialogV2.Builder(paramActivity);
    TPLongMaterialDialogV2 localTPLongMaterialDialogV2 = localBuilder.a();
    localBuilder.g(paramActivity.getApplicationContext().getString(2131953179)).l(2131952441, 2131099808, new n(localTPLongMaterialDialogV2)).d(8, 0).b(false).c(false).a();
    localTPLongMaterialDialogV2.show();
  }
  
  public static void p(LottieAnimationView paramLottieAnimationView, String paramString)
  {
    try
    {
      paramLottieAnimationView.setImageAssetsFolder("images/");
      paramString = c(paramString);
      paramString = d.a.a(paramLottieAnimationView.getContext(), paramString);
      paramLottieAnimationView.g();
      paramLottieAnimationView.setProgress(0.0F);
      if (paramString != null) {
        paramLottieAnimationView.setComposition(paramString);
      }
      paramLottieAnimationView.o();
      paramLottieAnimationView.setVisibility(0);
      paramString = new com/tplink/iot/k/c/b$e;
      paramString.<init>(paramLottieAnimationView);
      paramLottieAnimationView.d(paramString);
    }
    catch (Exception paramLottieAnimationView)
    {
      Log.e("lottie", "load local lottie anim error");
    }
  }
  
  public static boolean q()
  {
    AudioRecord localAudioRecord = new AudioRecord(1, 44100, 16, 1, 44100);
    bool1 = false;
    try
    {
      try
      {
        boolean bool2;
        if (localAudioRecord.getRecordingState() != 1) {
          bool2 = false;
        } else {
          bool2 = true;
        }
        bool3 = bool2;
        if (localAudioRecord.getState() == 1)
        {
          localAudioRecord.startRecording();
          if (localAudioRecord.getRecordingState() != 3)
          {
            localAudioRecord.stop();
            bool2 = false;
          }
          localAudioRecord.stop();
          bool3 = bool2;
        }
      }
      finally
      {
        localAudioRecord.release();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool3 = bool1;
      }
    }
    localAudioRecord.release();
    return bool3;
  }
  
  static final class a
    implements TPMaterialDialogV2.d
  {
    public void onClick(View paramView) {}
  }
  
  static final class b
    implements TPMaterialDialogV2.d
  {
    b(b.p paramp) {}
    
    public void onClick(View paramView)
    {
      this.a.a();
    }
  }
  
  static final class c
    implements TPMaterialDialogV2.d
  {
    public void onClick(View paramView) {}
  }
  
  static final class d
    implements TPMaterialDialogV2.d
  {
    d(b.q paramq) {}
    
    public void onClick(View paramView)
    {
      this.a.a();
    }
  }
  
  static final class e
    implements j
  {
    e(LottieAnimationView paramLottieAnimationView) {}
    
    @SuppressLint({"RestrictedApi"})
    public void a(com.airbnb.lottie.d paramd)
    {
      paramd = this.a.p(new com.airbnb.lottie.model.d(new String[] { "**" })).iterator();
      while (paramd.hasNext())
      {
        com.airbnb.lottie.model.d locald = (com.airbnb.lottie.model.d)paramd.next();
        a.c("mirror", locald.g());
        if ((!locald.h("矩形备份 2", 1)) && (!locald.h("矩形备份 5", 1)) && (!locald.h("矩形备份 8", 1)) && (!locald.h("矩形备份 11", 1)) && (!locald.h("矩形备份 14", 1)) && (!locald.h("矩形备份 17", 1)) && (!locald.h("矩形备份 20", 1)))
        {
          if ((!locald.h("矩形备份 3", 1)) && (!locald.h("矩形备份 6", 1)) && (!locald.h("矩形备份 9", 1)) && (!locald.h("矩形备份 12", 1)) && (!locald.h("矩形备份 15", 1)) && (!locald.h("矩形备份 18", 1)) && (!locald.h("矩形备份 21", 1)))
          {
            if ((!locald.h("矩形备份 4", 1)) && (!locald.h("矩形备份 7", 1)) && (!locald.h("矩形备份 10", 1)) && (!locald.h("矩形备份 13", 1)) && (!locald.h("矩形备份 16", 1)) && (!locald.h("矩形备份 19", 1))) {
              this.a.f(locald, k.D, new d());
            } else {
              this.a.f(locald, k.D, new c());
            }
          }
          else {
            this.a.f(locald, k.D, new b());
          }
        }
        else {
          this.a.f(locald, k.D, new a());
        }
      }
    }
    
    class a
      implements e<Integer[]>
    {
      a() {}
      
      public Integer[] b(com.airbnb.lottie.w.b<Integer[]> paramb)
      {
        return new Integer[] { Integer.valueOf(Color.argb(153, 219, 27, 255)), Integer.valueOf(Color.argb(255, 237, 139, 255)) };
      }
    }
    
    class b
      implements e<Integer[]>
    {
      b() {}
      
      public Integer[] b(com.airbnb.lottie.w.b<Integer[]> paramb)
      {
        return new Integer[] { Integer.valueOf(Color.argb(127, 245, 151, 163)), Integer.valueOf(Color.argb(219, 250, 202, 208)) };
      }
    }
    
    class c
      implements e<Integer[]>
    {
      c() {}
      
      public Integer[] b(com.airbnb.lottie.w.b<Integer[]> paramb)
      {
        return new Integer[] { Integer.valueOf(Color.argb(173, 62, 210, 242)), Integer.valueOf(Color.argb(255, 70, 224, 255)) };
      }
    }
    
    class d
      implements e<Integer[]>
    {
      d() {}
      
      public Integer[] b(com.airbnb.lottie.w.b<Integer[]> paramb)
      {
        return new Integer[] { Integer.valueOf(Color.argb(173, 62, 210, 242)), Integer.valueOf(Color.argb(255, 70, 224, 255)) };
      }
    }
  }
  
  static final class f
    implements TPMaterialDialogV2.d
  {
    f(TPMaterialDialogV2 paramTPMaterialDialogV2, b.o paramo) {}
    
    public void onClick(View paramView)
    {
      this.a.dismiss();
      paramo.cancel();
    }
  }
  
  static final class g
    implements TPMaterialDialogV2.d
  {
    g(b.o paramo) {}
    
    public void onClick(View paramView)
    {
      this.a.a();
    }
  }
  
  static final class h
    implements TPLongThreeMaterialDialog.e
  {
    h(TPLongThreeMaterialDialog paramTPLongThreeMaterialDialog, b.o paramo) {}
    
    public void onClick(View paramView)
    {
      this.a.dismiss();
      paramo.cancel();
    }
  }
  
  static final class i
    implements TPLongThreeMaterialDialog.e
  {
    i(b.o paramo) {}
    
    public void onClick(View paramView)
    {
      this.a.a();
    }
  }
  
  static final class j
    implements TPLongThreeMaterialDialog.e
  {
    j(Activity paramActivity, b.o paramo) {}
    
    public void onClick(View paramView)
    {
      Activity localActivity = this.a;
      paramView = new StringBuilder();
      paramView.append("https://www.tapo.com/app/#/faqDetail/122?locale=");
      paramView.append(com.tplink.iot.model.about.d.f());
      HelpAndFeedbackActivity.m1(localActivity, paramView.toString(), b0.a(2131952875), EnumFeedbackCategory.LIGHT_STRIP);
      paramo.cancel();
    }
  }
  
  static final class k
    implements TPLongMaterialDialogV2.d
  {
    k(TPLongMaterialDialogV2 paramTPLongMaterialDialogV2, Activity paramActivity) {}
    
    public void onClick(View paramView)
    {
      this.a.dismiss();
      paramActivity.finish();
    }
  }
  
  static final class l
    implements TPLongMaterialDialogV2.d
  {
    l(TPLongMaterialDialogV2 paramTPLongMaterialDialogV2) {}
    
    public void onClick(View paramView)
    {
      this.a.dismiss();
    }
  }
  
  static final class m
    implements TPLongMaterialDialogV2.d
  {
    m(TPLongMaterialDialogV2 paramTPLongMaterialDialogV2, Activity paramActivity) {}
    
    public void onClick(View paramView)
    {
      this.a.dismiss();
      paramActivity.finish();
    }
  }
  
  static final class n
    implements TPLongMaterialDialogV2.d
  {
    n(TPLongMaterialDialogV2 paramTPLongMaterialDialogV2) {}
    
    public void onClick(View paramView)
    {
      this.a.dismiss();
    }
  }
  
  public static abstract interface o
  {
    public abstract void a();
    
    public abstract void cancel();
  }
  
  public static abstract interface p
  {
    public abstract void a();
  }
  
  public static abstract interface q
  {
    public abstract void a();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\k\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */