package kotlin.annotation;

public enum AnnotationTarget
{
  static
  {
    AnnotationTarget localAnnotationTarget1 = new AnnotationTarget("CLASS", 0);
    CLASS = localAnnotationTarget1;
    AnnotationTarget localAnnotationTarget2 = new AnnotationTarget("ANNOTATION_CLASS", 1);
    ANNOTATION_CLASS = localAnnotationTarget2;
    AnnotationTarget localAnnotationTarget3 = new AnnotationTarget("TYPE_PARAMETER", 2);
    TYPE_PARAMETER = localAnnotationTarget3;
    AnnotationTarget localAnnotationTarget4 = new AnnotationTarget("PROPERTY", 3);
    PROPERTY = localAnnotationTarget4;
    AnnotationTarget localAnnotationTarget5 = new AnnotationTarget("FIELD", 4);
    FIELD = localAnnotationTarget5;
    AnnotationTarget localAnnotationTarget6 = new AnnotationTarget("LOCAL_VARIABLE", 5);
    LOCAL_VARIABLE = localAnnotationTarget6;
    AnnotationTarget localAnnotationTarget7 = new AnnotationTarget("VALUE_PARAMETER", 6);
    VALUE_PARAMETER = localAnnotationTarget7;
    AnnotationTarget localAnnotationTarget8 = new AnnotationTarget("CONSTRUCTOR", 7);
    CONSTRUCTOR = localAnnotationTarget8;
    AnnotationTarget localAnnotationTarget9 = new AnnotationTarget("FUNCTION", 8);
    FUNCTION = localAnnotationTarget9;
    AnnotationTarget localAnnotationTarget10 = new AnnotationTarget("PROPERTY_GETTER", 9);
    PROPERTY_GETTER = localAnnotationTarget10;
    AnnotationTarget localAnnotationTarget11 = new AnnotationTarget("PROPERTY_SETTER", 10);
    PROPERTY_SETTER = localAnnotationTarget11;
    AnnotationTarget localAnnotationTarget12 = new AnnotationTarget("TYPE", 11);
    TYPE = localAnnotationTarget12;
    AnnotationTarget localAnnotationTarget13 = new AnnotationTarget("EXPRESSION", 12);
    EXPRESSION = localAnnotationTarget13;
    AnnotationTarget localAnnotationTarget14 = new AnnotationTarget("FILE", 13);
    FILE = localAnnotationTarget14;
    AnnotationTarget localAnnotationTarget15 = new AnnotationTarget("TYPEALIAS", 14);
    TYPEALIAS = localAnnotationTarget15;
    $VALUES = new AnnotationTarget[] { localAnnotationTarget1, localAnnotationTarget2, localAnnotationTarget3, localAnnotationTarget4, localAnnotationTarget5, localAnnotationTarget6, localAnnotationTarget7, localAnnotationTarget8, localAnnotationTarget9, localAnnotationTarget10, localAnnotationTarget11, localAnnotationTarget12, localAnnotationTarget13, localAnnotationTarget14, localAnnotationTarget15 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\annotation\AnnotationTarget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */