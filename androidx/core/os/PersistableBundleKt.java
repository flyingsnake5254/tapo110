package androidx.core.os;

import android.os.Build.VERSION;
import android.os.PersistableBundle;
import androidx.annotation.RequiresApi;
import kotlin.Pair;
import kotlin.jvm.internal.j;

public final class PersistableBundleKt
{
  @RequiresApi(21)
  public static final PersistableBundle persistableBundleOf(Pair<String, ? extends Object>... paramVarArgs)
  {
    j.f(paramVarArgs, "pairs");
    Object localObject1 = new PersistableBundle(paramVarArgs.length);
    int i = paramVarArgs.length;
    int j = 0;
    while (j < i)
    {
      Object localObject2 = paramVarArgs[j];
      String str = (String)((Pair)localObject2).component1();
      localObject2 = ((Pair)localObject2).component2();
      Class localClass;
      if (localObject2 == null)
      {
        ((PersistableBundle)localObject1).putString(str, null);
      }
      else if ((localObject2 instanceof Boolean))
      {
        if (Build.VERSION.SDK_INT >= 22)
        {
          ((PersistableBundle)localObject1).putBoolean(str, ((Boolean)localObject2).booleanValue());
        }
        else
        {
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("Illegal value type boolean for key \"");
          paramVarArgs.append(str);
          paramVarArgs.append('"');
          throw new IllegalArgumentException(paramVarArgs.toString());
        }
      }
      else if ((localObject2 instanceof Double))
      {
        ((PersistableBundle)localObject1).putDouble(str, ((Number)localObject2).doubleValue());
      }
      else if ((localObject2 instanceof Integer))
      {
        ((PersistableBundle)localObject1).putInt(str, ((Number)localObject2).intValue());
      }
      else if ((localObject2 instanceof Long))
      {
        ((PersistableBundle)localObject1).putLong(str, ((Number)localObject2).longValue());
      }
      else if ((localObject2 instanceof String))
      {
        ((PersistableBundle)localObject1).putString(str, (String)localObject2);
      }
      else if ((localObject2 instanceof boolean[]))
      {
        if (Build.VERSION.SDK_INT >= 22)
        {
          ((PersistableBundle)localObject1).putBooleanArray(str, (boolean[])localObject2);
        }
        else
        {
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("Illegal value type boolean[] for key \"");
          paramVarArgs.append(str);
          paramVarArgs.append('"');
          throw new IllegalArgumentException(paramVarArgs.toString());
        }
      }
      else if ((localObject2 instanceof double[]))
      {
        ((PersistableBundle)localObject1).putDoubleArray(str, (double[])localObject2);
      }
      else if ((localObject2 instanceof int[]))
      {
        ((PersistableBundle)localObject1).putIntArray(str, (int[])localObject2);
      }
      else if ((localObject2 instanceof long[]))
      {
        ((PersistableBundle)localObject1).putLongArray(str, (long[])localObject2);
      }
      else
      {
        if (!(localObject2 instanceof Object[])) {
          break label491;
        }
        localClass = localObject2.getClass().getComponentType();
        if (localClass == null) {
          j.n();
        }
        j.b(localClass, "value::class.java.componentType!!");
        if (!String.class.isAssignableFrom(localClass)) {
          break label431;
        }
        ((PersistableBundle)localObject1).putStringArray(str, (String[])localObject2);
      }
      j++;
      continue;
      label431:
      localObject1 = localClass.getCanonicalName();
      paramVarArgs = new StringBuilder();
      paramVarArgs.append("Illegal value array type ");
      paramVarArgs.append((String)localObject1);
      paramVarArgs.append(" for key \"");
      paramVarArgs.append(str);
      paramVarArgs.append('"');
      throw new IllegalArgumentException(paramVarArgs.toString());
      label491:
      localObject1 = localObject2.getClass().getCanonicalName();
      paramVarArgs = new StringBuilder();
      paramVarArgs.append("Illegal value type ");
      paramVarArgs.append((String)localObject1);
      paramVarArgs.append(" for key \"");
      paramVarArgs.append(str);
      paramVarArgs.append('"');
      throw new IllegalArgumentException(paramVarArgs.toString());
    }
    return (PersistableBundle)localObject1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\os\PersistableBundleKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */