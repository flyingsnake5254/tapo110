package androidx.core.os;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import java.io.Serializable;
import kotlin.Pair;
import kotlin.jvm.internal.j;

public final class BundleKt
{
  public static final Bundle bundleOf(Pair<String, ? extends Object>... paramVarArgs)
  {
    j.f(paramVarArgs, "pairs");
    Object localObject1 = new Bundle(paramVarArgs.length);
    int i = paramVarArgs.length;
    int j = 0;
    while (j < i)
    {
      Object localObject2 = paramVarArgs[j];
      String str = (String)((Pair)localObject2).component1();
      localObject2 = ((Pair)localObject2).component2();
      if (localObject2 == null)
      {
        ((Bundle)localObject1).putString(str, null);
      }
      else if ((localObject2 instanceof Boolean))
      {
        ((Bundle)localObject1).putBoolean(str, ((Boolean)localObject2).booleanValue());
      }
      else if ((localObject2 instanceof Byte))
      {
        ((Bundle)localObject1).putByte(str, ((Number)localObject2).byteValue());
      }
      else if ((localObject2 instanceof Character))
      {
        ((Bundle)localObject1).putChar(str, ((Character)localObject2).charValue());
      }
      else if ((localObject2 instanceof Double))
      {
        ((Bundle)localObject1).putDouble(str, ((Number)localObject2).doubleValue());
      }
      else if ((localObject2 instanceof Float))
      {
        ((Bundle)localObject1).putFloat(str, ((Number)localObject2).floatValue());
      }
      else if ((localObject2 instanceof Integer))
      {
        ((Bundle)localObject1).putInt(str, ((Number)localObject2).intValue());
      }
      else if ((localObject2 instanceof Long))
      {
        ((Bundle)localObject1).putLong(str, ((Number)localObject2).longValue());
      }
      else if ((localObject2 instanceof Short))
      {
        ((Bundle)localObject1).putShort(str, ((Number)localObject2).shortValue());
      }
      else if ((localObject2 instanceof Bundle))
      {
        ((Bundle)localObject1).putBundle(str, (Bundle)localObject2);
      }
      else if ((localObject2 instanceof CharSequence))
      {
        ((Bundle)localObject1).putCharSequence(str, (CharSequence)localObject2);
      }
      else if ((localObject2 instanceof Parcelable))
      {
        ((Bundle)localObject1).putParcelable(str, (Parcelable)localObject2);
      }
      else if ((localObject2 instanceof boolean[]))
      {
        ((Bundle)localObject1).putBooleanArray(str, (boolean[])localObject2);
      }
      else if ((localObject2 instanceof byte[]))
      {
        ((Bundle)localObject1).putByteArray(str, (byte[])localObject2);
      }
      else if ((localObject2 instanceof char[]))
      {
        ((Bundle)localObject1).putCharArray(str, (char[])localObject2);
      }
      else if ((localObject2 instanceof double[]))
      {
        ((Bundle)localObject1).putDoubleArray(str, (double[])localObject2);
      }
      else if ((localObject2 instanceof float[]))
      {
        ((Bundle)localObject1).putFloatArray(str, (float[])localObject2);
      }
      else if ((localObject2 instanceof int[]))
      {
        ((Bundle)localObject1).putIntArray(str, (int[])localObject2);
      }
      else if ((localObject2 instanceof long[]))
      {
        ((Bundle)localObject1).putLongArray(str, (long[])localObject2);
      }
      else if ((localObject2 instanceof short[]))
      {
        ((Bundle)localObject1).putShortArray(str, (short[])localObject2);
      }
      else if ((localObject2 instanceof Object[]))
      {
        Class localClass = localObject2.getClass().getComponentType();
        if (localClass == null) {
          j.n();
        }
        j.b(localClass, "value::class.java.componentType!!");
        if (Parcelable.class.isAssignableFrom(localClass))
        {
          ((Bundle)localObject1).putParcelableArray(str, (Parcelable[])localObject2);
        }
        else if (String.class.isAssignableFrom(localClass))
        {
          ((Bundle)localObject1).putStringArray(str, (String[])localObject2);
        }
        else if (CharSequence.class.isAssignableFrom(localClass))
        {
          ((Bundle)localObject1).putCharSequenceArray(str, (CharSequence[])localObject2);
        }
        else if (Serializable.class.isAssignableFrom(localClass))
        {
          ((Bundle)localObject1).putSerializable(str, (Serializable)localObject2);
        }
        else
        {
          paramVarArgs = localClass.getCanonicalName();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Illegal value array type ");
          ((StringBuilder)localObject1).append(paramVarArgs);
          ((StringBuilder)localObject1).append(" for key \"");
          ((StringBuilder)localObject1).append(str);
          ((StringBuilder)localObject1).append('"');
          throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
        }
      }
      else if ((localObject2 instanceof Serializable))
      {
        ((Bundle)localObject1).putSerializable(str, (Serializable)localObject2);
      }
      else
      {
        int k = Build.VERSION.SDK_INT;
        if ((k >= 18) && ((localObject2 instanceof IBinder)))
        {
          ((Bundle)localObject1).putBinder(str, (IBinder)localObject2);
        }
        else if ((k >= 21) && ((localObject2 instanceof Size)))
        {
          ((Bundle)localObject1).putSize(str, (Size)localObject2);
        }
        else
        {
          if ((k < 21) || (!(localObject2 instanceof SizeF))) {
            break label811;
          }
          ((Bundle)localObject1).putSizeF(str, (SizeF)localObject2);
        }
      }
      j++;
      continue;
      label811:
      paramVarArgs = localObject2.getClass().getCanonicalName();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Illegal value type ");
      ((StringBuilder)localObject1).append(paramVarArgs);
      ((StringBuilder)localObject1).append(" for key \"");
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append('"');
      throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
    }
    return (Bundle)localObject1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\os\BundleKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */