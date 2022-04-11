package com.tplink.iot.widget.cameralive;

import androidx.databinding.BindingAdapter;
import io.reactivex.m0.d;

public class y
{
  @BindingAdapter({"deviceIdMD5"})
  public static void a(VideoSurfaceViewLayout paramVideoSurfaceViewLayout, String paramString)
  {
    paramVideoSurfaceViewLayout.setDeviceIdMD5(paramString);
  }
  
  @BindingAdapter({"fullScreen"})
  public static void b(VideoSurfaceViewLayout paramVideoSurfaceViewLayout, boolean paramBoolean)
  {
    paramVideoSurfaceViewLayout.setFullScreen(paramBoolean);
  }
  
  @BindingAdapter({"highQuality"})
  public static void c(VideoSurfaceViewLayout paramVideoSurfaceViewLayout, boolean paramBoolean)
  {
    paramVideoSurfaceViewLayout.setIsHQ(paramBoolean);
  }
  
  @BindingAdapter({"isFocused"})
  public static void d(VideoSurfaceViewLayout paramVideoSurfaceViewLayout, boolean paramBoolean)
  {
    paramVideoSurfaceViewLayout.setIsFocused(paramBoolean);
  }
  
  @BindingAdapter({"rearrangeMode"})
  public static void e(VideoSurfaceViewLayout paramVideoSurfaceViewLayout, boolean paramBoolean)
  {
    paramVideoSurfaceViewLayout.k0(paramBoolean);
  }
  
  @BindingAdapter({"relayEventSubject"})
  public static void f(VideoSurfaceViewLayout paramVideoSurfaceViewLayout, d<Integer> paramd)
  {
    paramVideoSurfaceViewLayout.setRelayEventSubject(paramd);
  }
  
  @BindingAdapter({"videoResolution"})
  public static void g(VideoSurfaceViewLayout paramVideoSurfaceViewLayout, String paramString)
  {
    paramVideoSurfaceViewLayout.setVideoResolution(paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\cameralive\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */