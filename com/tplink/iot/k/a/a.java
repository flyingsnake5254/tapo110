package com.tplink.iot.k.a;

import android.graphics.Color;
import android.media.AudioRecord;
import com.tplink.iot.k.c.b;
import com.tplink.iot.musicphonerhythm.activitys.MusicPhoneRhythmFragment;
import com.tplink.iot.musicphonerhythm.activitys.MusicPhoneRhythmFragment.h;
import com.tplink.iot.musicphonerhythm.bean.MusicRhythmGlobalConfigBean;
import com.tplink.iot.musicphonerhythm.bean.TUBPColorDbBean;
import com.tplink.iot.musicphonerhythm.bean.TUBPDataBean;
import com.tplink.iot.musicphonerhythm.jniInterface.MusicRhythmJni;
import com.tplink.libtpnetwork.cameranetwork.util.JsonUtils;
import java.net.InetSocketAddress;
import java.util.ArrayList;

public class a
  extends Thread
  implements MusicPhoneRhythmFragment.h
{
  private static final int c = AudioRecord.getMinBufferSize(16000, 16, 2);
  private static final int d = AudioRecord.getMinBufferSize(44000, 16, 2);
  private static com.tplink.iot.k.c.a f;
  private int H3 = -30;
  private int I3 = 7;
  int J3 = 0;
  InetSocketAddress K3 = null;
  int L3 = 0;
  int M3;
  private int p0 = 100;
  private boolean p1 = false;
  private int p2 = 0;
  private int p3 = 0;
  private AudioRecord q;
  private volatile boolean x = false;
  private com.tplink.iot.k.b.a y;
  private Integer z = Integer.valueOf(0);
  
  public a(String paramString1, String paramString2, String paramString3, int paramInt1, MusicPhoneRhythmFragment paramMusicPhoneRhythmFragment, MusicRhythmGlobalConfigBean paramMusicRhythmGlobalConfigBean, int paramInt2, int paramInt3)
  {
    if (paramInt2 == 1)
    {
      this.q = new AudioRecord(1, 16000, 2, 2, c);
      this.M3 = 0;
    }
    else if (paramInt2 == 2)
    {
      this.q = new AudioRecord(1, 44000, 2, 2, d);
      this.M3 = 1;
    }
    else
    {
      this.q = new AudioRecord(1, 44000, 2, 2, d);
    }
    f = new com.tplink.iot.k.c.a(paramString1, paramString2);
    this.K3 = new InetSocketAddress(paramString3, paramInt1);
    paramMusicPhoneRhythmFragment.r1(this);
    boolean bool = paramMusicRhythmGlobalConfigBean.isSingleColorEnable();
    this.p1 = bool;
    if (bool)
    {
      this.p2 = paramMusicRhythmGlobalConfigBean.getHue();
      this.p3 = paramMusicRhythmGlobalConfigBean.getSaturation();
    }
    this.p0 = paramMusicRhythmGlobalConfigBean.getBaseBrightness();
    this.I3 = paramInt3;
  }
  
  private int d(float paramFloat)
  {
    return Double.valueOf(paramFloat * 1.8D + 190.0D).intValue();
  }
  
  private int e(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    if (paramInt == 1) {}
    return 50;
  }
  
  private int g(int paramInt)
  {
    if (paramInt != 0) {
      this.L3 += 1;
    }
    switch (this.L3 % 8)
    {
    default: 
      return 0;
    case 7: 
      return Color.rgb(255, 135, 86);
    case 6: 
      return Color.rgb(255, 60, 109);
    case 5: 
      return Color.rgb(200, 222, 246);
    case 4: 
      return Color.rgb(120, 101, 237);
    case 3: 
      return Color.rgb(105, 253, 255);
    case 2: 
      return Color.rgb(9, 116, 242);
    case 1: 
      return Color.rgb(3, 255, 212);
    }
    return Color.rgb(253, 255, 246);
  }
  
  public static short h(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[(paramInt + 1)];
    return (short)(paramArrayOfByte[paramInt] & 0xFF | i << 8 & 0xFF00);
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.p1 = false;
    }
    else
    {
      this.p1 = true;
      Object localObject = new float[3];
      Color.colorToHSV(paramInt, (float[])localObject);
      this.p2 = ((int)localObject[0]);
      this.p3 = ((int)(localObject[1] * 100.0F));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSaveColorMode");
      ((StringBuilder)localObject).append(this.p2);
      ((StringBuilder)localObject).append("  ");
      ((StringBuilder)localObject).append(this.p3);
      b.d.w.c.a.c("onSaveColorModeChange", ((StringBuilder)localObject).toString());
    }
  }
  
  public void b(int paramInt)
  {
    this.H3 = b.f(paramInt).getValue()[1];
  }
  
  public void c(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSaveLightPercentMode=");
    localStringBuilder.append(paramInt);
    b.d.w.c.a.c("onSaveLightPercentModeChange", localStringBuilder.toString());
    this.p0 = paramInt;
  }
  
  public int f(int paramInt, float paramFloat)
  {
    if (paramFloat < -90.0F) {
      return Color.rgb(0, 0, 255);
    }
    switch (paramInt)
    {
    default: 
      return 0;
    case 11: 
      return Color.rgb(142, 201, 255);
    case 10: 
      return Color.rgb(168, 103, 124);
    case 9: 
      return Color.rgb(51, 204, 51);
    case 8: 
      return Color.rgb(187, 117, 252);
    case 7: 
      return Color.rgb(255, 127, 0);
    case 6: 
      return Color.rgb(127, 139, 253);
    case 5: 
      return Color.rgb(171, 0, 52);
    case 4: 
      return Color.rgb(195, 242, 255);
    case 3: 
      return Color.rgb(183, 70, 139);
    case 2: 
      return Color.rgb(255, 255, 0);
    case 1: 
      return Color.rgb(144, 0, 255);
    }
    return Color.rgb(255, 0, 0);
  }
  
  public void i()
  {
    this.x = false;
  }
  
  public void j(byte[] paramArrayOfByte)
  {
    Object localObject = new float['Ѐ'];
    short[] arrayOfShort = new short['Ѐ'];
    for (int i = 0; i < 1024; i++) {
      arrayOfShort[i] = h(paramArrayOfByte, i * 2);
    }
    for (i = 0; i < 1024; i++) {
      localObject[i] = ((float)(arrayOfShort[i] / Math.pow(2.0D, 15.0D)));
    }
    paramArrayOfByte = MusicRhythmJni.getAudioResult((float[])localObject, this.M3, this.I3);
    int j = (int)paramArrayOfByte[0];
    float f1 = paramArrayOfByte[1];
    i = f(j, f1);
    int k = d(f1);
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("线程为 ");
    paramArrayOfByte.append(getId());
    paramArrayOfByte.append("频率： ");
    paramArrayOfByte.append(j);
    paramArrayOfByte.append("Hz 能量： ");
    paramArrayOfByte.append(f1);
    paramArrayOfByte.append("dB颜色： ");
    paramArrayOfByte.append(i);
    b.d.w.c.a.c("getData v1.0", paramArrayOfByte.toString());
    paramArrayOfByte = new float[3];
    Color.colorToHSV(i, paramArrayOfByte);
    j = (int)paramArrayOfByte[0];
    i = (int)(paramArrayOfByte[1] * 100.0F);
    paramArrayOfByte = new ArrayList();
    if (this.p1)
    {
      paramArrayOfByte.add(Integer.valueOf(this.p2));
      paramArrayOfByte.add(Integer.valueOf(this.p3));
    }
    else
    {
      paramArrayOfByte.add(Integer.valueOf(j));
      paramArrayOfByte.add(Integer.valueOf(i));
    }
    j = this.p0;
    i = 100;
    k = k * j / 100;
    if (k < 1) {
      i = 1;
    } else if (k <= 100) {
      i = k;
    }
    paramArrayOfByte.add(Integer.valueOf(i));
    paramArrayOfByte.add(this.z);
    i = (int)(f1 - this.H3);
    localObject = new TUBPColorDbBean();
    ((TUBPColorDbBean)localObject).setColorState(paramArrayOfByte);
    ((TUBPColorDbBean)localObject).setDeltaDb(i);
    paramArrayOfByte = JsonUtils.g(new TUBPDataBean("play_music_rhythm", (TUBPColorDbBean)localObject));
    paramArrayOfByte = f.b(paramArrayOfByte);
    this.y.a(this.J3, paramArrayOfByte);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleTDPSend=decrypt=");
    ((StringBuilder)localObject).append(f.a(paramArrayOfByte));
    b.d.w.c.a.c("getData", ((StringBuilder)localObject).toString());
    this.J3 += 1;
  }
  
  public void k(byte[] paramArrayOfByte)
  {
    float[] arrayOfFloat = new float['Ѐ'];
    Object localObject = new short['Ѐ'];
    for (int i = 0; i < 1024; i++) {
      localObject[i] = h(paramArrayOfByte, i * 2);
    }
    for (i = 0; i < 1024; i++) {
      arrayOfFloat[i] = ((float)(localObject[i] / Math.pow(2.0D, 15.0D)));
    }
    paramArrayOfByte = MusicRhythmJni.getAudioResult(arrayOfFloat, this.M3, this.I3);
    int j = (int)paramArrayOfByte[0];
    int k = (int)paramArrayOfByte[1];
    int m = g(j);
    int n = e(k);
    paramArrayOfByte = new float[3];
    Color.colorToHSV(m, paramArrayOfByte);
    int i1 = (int)paramArrayOfByte[0];
    i = (int)(paramArrayOfByte[1] * 100.0F);
    localObject = new ArrayList();
    if (this.p1)
    {
      ((ArrayList)localObject).add(Integer.valueOf(this.p2));
      ((ArrayList)localObject).add(Integer.valueOf(this.p3));
    }
    else
    {
      ((ArrayList)localObject).add(Integer.valueOf(i1));
      ((ArrayList)localObject).add(Integer.valueOf(i));
    }
    i1 = n * this.p0 / 100;
    if (i1 < 1)
    {
      i = 1;
    }
    else
    {
      i = i1;
      if (i1 > 100) {
        i = 100;
      }
    }
    ((ArrayList)localObject).add(Integer.valueOf(i));
    ((ArrayList)localObject).add(this.z);
    paramArrayOfByte = new TUBPColorDbBean();
    paramArrayOfByte.setColorState((ArrayList)localObject);
    paramArrayOfByte.setDeltaDb(100);
    paramArrayOfByte = JsonUtils.g(new TUBPDataBean("play_music_rhythm", paramArrayOfByte));
    paramArrayOfByte = f.b(paramArrayOfByte);
    if (k != 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("线程为 ");
      ((StringBuilder)localObject).append(getId());
      ((StringBuilder)localObject).append("亮灭=： ");
      ((StringBuilder)localObject).append(k);
      ((StringBuilder)localObject).append(" 换色= ： ");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append("  颜色： ");
      ((StringBuilder)localObject).append(m);
      b.d.w.c.a.c("getData v1.1", ((StringBuilder)localObject).toString());
      this.y.a(this.J3, paramArrayOfByte);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleTDPSend=decrypt=");
      ((StringBuilder)localObject).append(f.a(paramArrayOfByte));
      b.d.w.c.a.c("getData", ((StringBuilder)localObject).toString());
    }
    this.J3 += 1;
  }
  
  public void run()
  {
    super.run();
    this.y = new com.tplink.iot.k.b.a(this.K3);
    MusicRhythmJni.init(this.M3);
    b.d.w.c.a.c("spl", "初始化");
    boolean bool = b.q();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("初始化 Availability=");
    ((StringBuilder)localObject).append(bool);
    b.d.w.c.a.c("spl", ((StringBuilder)localObject).toString());
    if ((bool) && (this.q.getState() == 1))
    {
      this.q.startRecording();
      this.x = true;
      this.y.b();
    }
    else
    {
      this.x = false;
      b.d.w.c.a.c("spl", "初始化 麦克风用不了！！！");
    }
    localObject = new byte['ࠀ'];
    int i = this.M3;
    if (i == 0) {
      while (this.x) {
        if (this.q.read((byte[])localObject, 0, 2048) == 2048) {
          j((byte[])localObject);
        }
      }
    }
    if (i == 1) {
      while (this.x) {
        if (this.q.read((byte[])localObject, 0, 2048) == 2048) {
          k((byte[])localObject);
        }
      }
    }
    this.q.stop();
  }
  
  public void start()
  {
    if (!this.x) {
      super.start();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\k\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */