package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class SharedPreferencesKt
{
  @SuppressLint({"ApplySharedPref"})
  public static final void edit(SharedPreferences paramSharedPreferences, boolean paramBoolean, l<? super SharedPreferences.Editor, p> paraml)
  {
    j.f(paramSharedPreferences, "$this$edit");
    j.f(paraml, "action");
    paramSharedPreferences = paramSharedPreferences.edit();
    j.b(paramSharedPreferences, "editor");
    paraml.invoke(paramSharedPreferences);
    if (paramBoolean) {
      paramSharedPreferences.commit();
    } else {
      paramSharedPreferences.apply();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\content\SharedPreferencesKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */