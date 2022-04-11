package b.d.g;

import android.media.AudioAttributes.Builder;
import android.media.AudioFormat.Builder;
import android.media.AudioTrack;
import android.media.AudioTrack.Builder;
import android.os.Build.VERSION;

public class a
{
  private static final int[] a = { 96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350, 0, 0, 0 };
  protected AudioTrack b;
  protected float c = 1.0F;
  protected float d = AudioTrack.getMaxVolume();
  protected int e;
  
  public a(int paramInt1, int paramInt2, int paramInt3)
  {
    int[] arrayOfInt = a;
    int i = arrayOfInt[paramInt1];
    this.e = i;
    i = AudioTrack.getMinBufferSize(i, paramInt2, paramInt3);
    if (Build.VERSION.SDK_INT >= 23) {
      this.b = new AudioTrack.Builder().setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(2).setLegacyStreamType(3).build()).setAudioFormat(new AudioFormat.Builder().setEncoding(paramInt3).setSampleRate(arrayOfInt[paramInt1]).setChannelMask(paramInt2).build()).setTransferMode(1).setBufferSizeInBytes(i * 10).build();
    } else {
      this.b = new AudioTrack(3, arrayOfInt[paramInt1], paramInt2, paramInt3, i * 10, 1);
    }
    g(this.d);
  }
  
  private void g(float paramFloat)
  {
    AudioTrack localAudioTrack = this.b;
    if (localAudioTrack != null) {
      localAudioTrack.setVolume(paramFloat * this.c);
    }
  }
  
  public void a()
  {
    AudioTrack localAudioTrack = this.b;
    if (localAudioTrack != null)
    {
      try
      {
        localAudioTrack.pause();
        this.b.flush();
        this.b.release();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      this.b = null;
    }
  }
  
  public float b()
  {
    return this.d;
  }
  
  public void c()
  {
    AudioTrack localAudioTrack = this.b;
    if (localAudioTrack != null) {
      try
      {
        localAudioTrack.pause();
        this.b.flush();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void d(com.tplink.libmediakit.media.audioprocess.a parama)
  {
    e(parama.d);
  }
  
  public void e(byte[] paramArrayOfByte)
  {
    AudioTrack localAudioTrack = this.b;
    if (localAudioTrack != null) {
      localAudioTrack.write(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
  }
  
  public void f()
  {
    AudioTrack localAudioTrack = this.b;
    if (localAudioTrack != null) {
      try
      {
        localAudioTrack.play();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void h()
  {
    this.b.play();
  }
  
  public void i(float paramFloat)
  {
    this.d = paramFloat;
    g(paramFloat);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\g\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */