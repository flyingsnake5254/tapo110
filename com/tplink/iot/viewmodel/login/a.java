package com.tplink.iot.viewmodel.login;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;

public class a
{
  public final ObservableField<String> a;
  public final ObservableField<String> b;
  public final ObservableBoolean c;
  
  public a(String paramString1, String paramString2, boolean paramBoolean)
  {
    ObservableField localObservableField1 = new ObservableField();
    this.a = localObservableField1;
    ObservableField localObservableField2 = new ObservableField();
    this.b = localObservableField2;
    ObservableBoolean localObservableBoolean = new ObservableBoolean(false);
    this.c = localObservableBoolean;
    localObservableField1.set(paramString1);
    localObservableField2.set(paramString2);
    localObservableBoolean.set(paramBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\login\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */