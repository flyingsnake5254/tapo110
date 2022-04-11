package com.google.android.exoplayer2.audio;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioAttributes.Builder;
import android.media.AudioFormat.Builder;
import android.media.AudioTrack;
import android.provider.Settings.Global;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.o0;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.a;
import com.google.common.primitives.d;
import java.util.Arrays;

public final class q
{
  public static final q a = new q(new int[] { 2 }, 8);
  private static final q b = new q(new int[] { 2, 5, 6 }, 8);
  private static final int[] c = { 5, 6, 18, 17, 14, 7, 8 };
  private final int[] d;
  private final int e;
  
  public q(@Nullable int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt != null)
    {
      paramArrayOfInt = Arrays.copyOf(paramArrayOfInt, paramArrayOfInt.length);
      this.d = paramArrayOfInt;
      Arrays.sort(paramArrayOfInt);
    }
    else
    {
      this.d = new int[0];
    }
    this.e = paramInt;
  }
  
  private static boolean b()
  {
    if (o0.a >= 17)
    {
      String str = o0.c;
      if (("Amazon".equals(str)) || ("Xiaomi".equals(str))) {
        return true;
      }
    }
    boolean bool = false;
    return bool;
  }
  
  public static q c(Context paramContext)
  {
    return d(paramContext, paramContext.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
  }
  
  @SuppressLint({"InlinedApi"})
  static q d(Context paramContext, @Nullable Intent paramIntent)
  {
    if ((b()) && (Settings.Global.getInt(paramContext.getContentResolver(), "external_surround_sound_enabled", 0) == 1)) {
      return b;
    }
    if ((o0.a >= 29) && (o0.n0(paramContext))) {
      return new q(a.a(), 8);
    }
    if ((paramIntent != null) && (paramIntent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) != 0)) {
      return new q(paramIntent.getIntArrayExtra("android.media.extra.ENCODINGS"), paramIntent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 8));
    }
    return a;
  }
  
  public int e()
  {
    return this.e;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof q)) {
      return false;
    }
    paramObject = (q)paramObject;
    if ((!Arrays.equals(this.d, ((q)paramObject).d)) || (this.e != ((q)paramObject).e)) {
      bool = false;
    }
    return bool;
  }
  
  public boolean f(int paramInt)
  {
    boolean bool;
    if (Arrays.binarySearch(this.d, paramInt) >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int hashCode()
  {
    return this.e + Arrays.hashCode(this.d) * 31;
  }
  
  public String toString()
  {
    int i = this.e;
    String str = Arrays.toString(this.d);
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 67);
    localStringBuilder.append("AudioCapabilities[maxChannelCount=");
    localStringBuilder.append(i);
    localStringBuilder.append(", supportedEncodings=");
    localStringBuilder.append(str);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  @RequiresApi(29)
  private static final class a
  {
    @DoNotInline
    public static int[] a()
    {
      ImmutableList.a locala = ImmutableList.builder();
      for (int k : q.a()) {
        if (AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(k).setSampleRate(48000).build(), new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(0).build())) {
          locala.h(Integer.valueOf(k));
        }
      }
      locala.h(Integer.valueOf(2));
      return d.j(locala.j());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\audio\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */