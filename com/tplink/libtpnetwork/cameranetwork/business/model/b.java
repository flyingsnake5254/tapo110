package com.tplink.libtpnetwork.cameranetwork.business.model;

import androidx.annotation.Nullable;
import com.tplink.libtpnetwork.cameranetwork.model.AlarmSoundType;

public class b
{
  private boolean a;
  private boolean b;
  private boolean c;
  private boolean d;
  private AlarmSoundType e;
  @Nullable
  private a f;
  
  public b a()
  {
    b localb = new b();
    localb.a = this.a;
    localb.b = this.b;
    localb.c = this.c;
    localb.d = this.d;
    localb.e = this.e;
    a locala = this.f;
    if (locala != null) {
      localb.f = locala.a();
    }
    return localb;
  }
  
  @Nullable
  public a b()
  {
    return this.f;
  }
  
  public AlarmSoundType c()
  {
    return this.e;
  }
  
  protected Object clone()
    throws CloneNotSupportedException
  {
    return super.clone();
  }
  
  public boolean d()
  {
    return this.a;
  }
  
  public boolean e()
  {
    return this.c;
  }
  
  public boolean f()
  {
    return this.d;
  }
  
  public boolean g()
  {
    return this.b;
  }
  
  public void h(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void i(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void j(@Nullable a parama)
  {
    this.f = parama;
  }
  
  public void k(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void l(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void m(AlarmSoundType paramAlarmSoundType)
  {
    this.e = paramAlarmSoundType;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\business\model\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */