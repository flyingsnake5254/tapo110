package androidx.core.content;

import android.content.ContentValues;
import kotlin.Pair;
import kotlin.jvm.internal.j;

public final class ContentValuesKt
{
  public static final ContentValues contentValuesOf(Pair<String, ? extends Object>... paramVarArgs)
  {
    j.f(paramVarArgs, "pairs");
    Object localObject1 = new ContentValues(paramVarArgs.length);
    int i = paramVarArgs.length;
    int j = 0;
    while (j < i)
    {
      Object localObject2 = paramVarArgs[j];
      String str = (String)((Pair)localObject2).component1();
      localObject2 = ((Pair)localObject2).component2();
      if (localObject2 == null)
      {
        ((ContentValues)localObject1).putNull(str);
      }
      else if ((localObject2 instanceof String))
      {
        ((ContentValues)localObject1).put(str, (String)localObject2);
      }
      else if ((localObject2 instanceof Integer))
      {
        ((ContentValues)localObject1).put(str, (Integer)localObject2);
      }
      else if ((localObject2 instanceof Long))
      {
        ((ContentValues)localObject1).put(str, (Long)localObject2);
      }
      else if ((localObject2 instanceof Boolean))
      {
        ((ContentValues)localObject1).put(str, (Boolean)localObject2);
      }
      else if ((localObject2 instanceof Float))
      {
        ((ContentValues)localObject1).put(str, (Float)localObject2);
      }
      else if ((localObject2 instanceof Double))
      {
        ((ContentValues)localObject1).put(str, (Double)localObject2);
      }
      else if ((localObject2 instanceof byte[]))
      {
        ((ContentValues)localObject1).put(str, (byte[])localObject2);
      }
      else if ((localObject2 instanceof Byte))
      {
        ((ContentValues)localObject1).put(str, (Byte)localObject2);
      }
      else
      {
        if (!(localObject2 instanceof Short)) {
          break label263;
        }
        ((ContentValues)localObject1).put(str, (Short)localObject2);
      }
      j++;
      continue;
      label263:
      paramVarArgs = localObject2.getClass().getCanonicalName();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Illegal value type ");
      ((StringBuilder)localObject1).append(paramVarArgs);
      ((StringBuilder)localObject1).append(" for key \"");
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append('"');
      throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
    }
    return (ContentValues)localObject1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\content\ContentValuesKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */