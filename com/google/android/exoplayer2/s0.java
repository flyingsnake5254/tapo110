package com.google.android.exoplayer2;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioFocusRequest.Builder;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.audio.p;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;

final class s0
{
  private final AudioManager a;
  private final a b;
  @Nullable
  private b c;
  @Nullable
  private p d;
  private int e;
  private int f;
  private float g = 1.0F;
  private AudioFocusRequest h;
  private boolean i;
  
  public s0(Context paramContext, Handler paramHandler, b paramb)
  {
    this.a = ((AudioManager)g.e((AudioManager)paramContext.getApplicationContext().getSystemService("audio")));
    this.c = paramb;
    this.b = new a(paramHandler);
    this.e = 0;
  }
  
  private void a()
  {
    this.a.abandonAudioFocus(this.b);
  }
  
  private void b()
  {
    if (this.e == 0) {
      return;
    }
    if (o0.a >= 26) {
      c();
    } else {
      a();
    }
    n(0);
  }
  
  @RequiresApi(26)
  private void c()
  {
    AudioFocusRequest localAudioFocusRequest = this.h;
    if (localAudioFocusRequest != null) {
      this.a.abandonAudioFocusRequest(localAudioFocusRequest);
    }
  }
  
  private static int e(@Nullable p paramp)
  {
    if (paramp == null) {
      return 0;
    }
    int j = paramp.e;
    switch (j)
    {
    case 15: 
    default: 
      paramp = new StringBuilder(37);
      paramp.append("Unidentified audio usage: ");
      paramp.append(j);
      u.h("AudioFocusManager", paramp.toString());
      return 0;
    case 16: 
      if (o0.a >= 19) {
        return 4;
      }
      return 2;
    case 11: 
      if (paramp.c == 1) {
        return 2;
      }
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 12: 
    case 13: 
      return 3;
    case 3: 
      return 0;
    case 2: 
    case 4: 
      return 2;
    case 1: 
    case 14: 
      return 1;
    }
    u.h("AudioFocusManager", "Specify a proper usage in the audio attributes for audio focus handling. Using AUDIOFOCUS_GAIN by default.");
    return 1;
  }
  
  private void f(int paramInt)
  {
    b localb = this.c;
    if (localb != null) {
      localb.A(paramInt);
    }
  }
  
  private void h(int paramInt)
  {
    if ((paramInt != -3) && (paramInt != -2))
    {
      if (paramInt != -1)
      {
        if (paramInt != 1)
        {
          StringBuilder localStringBuilder = new StringBuilder(38);
          localStringBuilder.append("Unknown focus change type: ");
          localStringBuilder.append(paramInt);
          u.h("AudioFocusManager", localStringBuilder.toString());
          return;
        }
        n(1);
        f(1);
        return;
      }
      f(-1);
      b();
      return;
    }
    if ((paramInt != -2) && (!q()))
    {
      n(3);
    }
    else
    {
      f(0);
      n(2);
    }
  }
  
  private int j()
  {
    if (this.e == 1) {
      return 1;
    }
    int j;
    if (o0.a >= 26) {
      j = l();
    } else {
      j = k();
    }
    if (j == 1)
    {
      n(1);
      return 1;
    }
    n(0);
    return -1;
  }
  
  private int k()
  {
    return this.a.requestAudioFocus(this.b, o0.Y(((p)g.e(this.d)).e), this.f);
  }
  
  @RequiresApi(26)
  private int l()
  {
    Object localObject = this.h;
    if ((localObject == null) || (this.i))
    {
      if (localObject == null) {
        localObject = new AudioFocusRequest.Builder(this.f);
      } else {
        localObject = new AudioFocusRequest.Builder(this.h);
      }
      boolean bool = q();
      this.h = ((AudioFocusRequest.Builder)localObject).setAudioAttributes(((p)g.e(this.d)).a()).setWillPauseWhenDucked(bool).setOnAudioFocusChangeListener(this.b).build();
      this.i = false;
    }
    return this.a.requestAudioFocus(this.h);
  }
  
  private void n(int paramInt)
  {
    if (this.e == paramInt) {
      return;
    }
    this.e = paramInt;
    float f1;
    if (paramInt == 3) {
      f1 = 0.2F;
    } else {
      f1 = 1.0F;
    }
    if (this.g == f1) {
      return;
    }
    this.g = f1;
    b localb = this.c;
    if (localb != null) {
      localb.z(f1);
    }
  }
  
  private boolean o(int paramInt)
  {
    boolean bool1 = true;
    boolean bool2 = bool1;
    if (paramInt != 1) {
      if (this.f != 1) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
    }
    return bool2;
  }
  
  private boolean q()
  {
    p localp = this.d;
    boolean bool = true;
    if ((localp == null) || (localp.c != 1)) {
      bool = false;
    }
    return bool;
  }
  
  public float g()
  {
    return this.g;
  }
  
  public void i()
  {
    this.c = null;
    b();
  }
  
  public void m(@Nullable p paramp)
  {
    if (!o0.b(this.d, paramp))
    {
      this.d = paramp;
      int j = e(paramp);
      this.f = j;
      boolean bool1 = true;
      boolean bool2 = bool1;
      if (j != 1) {
        if (j == 0) {
          bool2 = bool1;
        } else {
          bool2 = false;
        }
      }
      g.b(bool2, "Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME.");
    }
  }
  
  public int p(boolean paramBoolean, int paramInt)
  {
    boolean bool = o(paramInt);
    paramInt = -1;
    if (bool)
    {
      b();
      if (paramBoolean) {
        paramInt = 1;
      }
      return paramInt;
    }
    if (paramBoolean) {
      paramInt = j();
    }
    return paramInt;
  }
  
  private class a
    implements AudioManager.OnAudioFocusChangeListener
  {
    private final Handler c;
    
    public a(Handler paramHandler)
    {
      this.c = paramHandler;
    }
    
    public void onAudioFocusChange(int paramInt)
    {
      this.c.post(new b(this, paramInt));
    }
  }
  
  public static abstract interface b
  {
    public abstract void A(int paramInt);
    
    public abstract void z(float paramFloat);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\s0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */