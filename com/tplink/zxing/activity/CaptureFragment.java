package com.tplink.zxing.activity;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import b.d.e0.d;
import b.d.e0.e;
import b.d.e0.f;
import b.d.e0.h.h;
import b.d.e0.i.g;
import com.tplink.zxing.view.ViewfinderView;
import java.io.IOException;

public class CaptureFragment
  extends Fragment
  implements SurfaceHolder.Callback
{
  private final MediaPlayer.OnCompletionListener H3 = new a();
  @Nullable
  b I3;
  private b.d.e0.i.c c;
  private ViewfinderView d;
  private boolean f;
  private SurfaceView p0;
  private SurfaceHolder p1;
  private a p2;
  private Camera p3;
  private g q;
  private MediaPlayer x;
  private boolean y;
  private boolean z;
  
  private void G0()
  {
    if ((this.y) && (this.x == null))
    {
      getActivity().setVolumeControlStream(3);
      Object localObject = new MediaPlayer();
      this.x = ((MediaPlayer)localObject);
      ((MediaPlayer)localObject).setAudioStreamType(3);
      this.x.setOnCompletionListener(this.H3);
      localObject = getResources().openRawResourceFd(f.beep);
      try
      {
        this.x.setDataSource(((AssetFileDescriptor)localObject).getFileDescriptor(), ((AssetFileDescriptor)localObject).getStartOffset(), ((AssetFileDescriptor)localObject).getLength());
        ((AssetFileDescriptor)localObject).close();
        this.x.setVolume(0.1F, 0.1F);
        this.x.prepare();
      }
      catch (IOException localIOException)
      {
        this.x = null;
      }
    }
  }
  
  private void H0(SurfaceHolder paramSurfaceHolder)
  {
    try
    {
      b.d.e0.h.c.c().l(paramSurfaceHolder);
      this.p3 = b.d.e0.h.c.c().e();
      paramSurfaceHolder = this.I3;
      if (paramSurfaceHolder != null) {
        paramSurfaceHolder.a(null);
      }
      if (this.c == null) {
        this.c = new b.d.e0.i.c(this);
      }
      return;
    }
    catch (Exception paramSurfaceHolder)
    {
      b localb = this.I3;
      if (localb != null) {
        localb.a(paramSurfaceHolder);
      }
    }
  }
  
  private void I0()
  {
    if (this.z)
    {
      FragmentActivity localFragmentActivity = getActivity();
      getActivity();
      ((Vibrator)localFragmentActivity.getSystemService("vibrator")).vibrate(200L);
    }
  }
  
  public void A0()
  {
    this.d.c();
  }
  
  public Handler B0()
  {
    return this.c;
  }
  
  public void C0(String paramString, Bitmap paramBitmap)
  {
    this.q.b();
    I0();
    if ((paramString != null) && (!TextUtils.isEmpty(paramString)))
    {
      a locala = this.p2;
      if (locala != null) {
        locala.a(paramBitmap, paramString);
      }
    }
    else
    {
      paramString = this.p2;
      if (paramString != null) {
        paramString.b();
      }
    }
  }
  
  public void J0(a parama)
  {
    this.p2 = parama;
  }
  
  public void K0(b paramb)
  {
    this.I3 = paramb;
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    b.d.e0.h.c.i(getActivity().getApplication());
    this.f = false;
    this.q = new g(getActivity());
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramViewGroup = getArguments();
    if (paramViewGroup != null)
    {
      int i = paramViewGroup.getInt("layout_id");
      if (i != -1)
      {
        paramViewGroup = paramLayoutInflater.inflate(i, null);
        break label36;
      }
    }
    paramViewGroup = null;
    label36:
    paramBundle = paramViewGroup;
    if (paramViewGroup == null) {
      paramBundle = paramLayoutInflater.inflate(e.fragment_capture, null);
    }
    this.d = ((ViewfinderView)paramBundle.findViewById(d.viewfinder_view));
    paramLayoutInflater = (SurfaceView)paramBundle.findViewById(d.preview_view);
    this.p0 = paramLayoutInflater;
    this.p1 = paramLayoutInflater.getHolder();
    return paramBundle;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.q.c();
  }
  
  public void onPause()
  {
    super.onPause();
    b.d.e0.i.c localc = this.c;
    if (localc != null)
    {
      localc.a();
      this.c = null;
    }
    b.d.e0.h.c.c().b();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.f)
    {
      H0(this.p1);
    }
    else
    {
      this.p1.addCallback(this);
      this.p1.setType(3);
    }
    this.y = true;
    FragmentActivity localFragmentActivity = getActivity();
    getActivity();
    if (((AudioManager)localFragmentActivity.getSystemService("audio")).getRingerMode() != 2) {
      this.y = false;
    }
    G0();
    this.z = true;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (!this.f)
    {
      this.f = true;
      H0(paramSurfaceHolder);
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.f = false;
    paramSurfaceHolder = this.p3;
    if ((paramSurfaceHolder != null) && (paramSurfaceHolder != null) && (b.d.e0.h.c.c().j()))
    {
      if (!b.d.e0.h.c.c().k()) {
        this.p3.setPreviewCallback(null);
      }
      this.p3.stopPreview();
      b.d.e0.h.c.c().h().a(null, 0);
      b.d.e0.h.c.c().d().a(null, 0);
      b.d.e0.h.c.c().o(false);
    }
  }
  
  class a
    implements MediaPlayer.OnCompletionListener
  {
    a() {}
    
    public void onCompletion(MediaPlayer paramMediaPlayer)
    {
      paramMediaPlayer.seekTo(0);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(Exception paramException);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\zxing\activity\CaptureFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */