package mrthomas20121.biolib.util;

import java.util.Collection;
import java.util.EnumMap;
import java.util.function.BiFunction;

/**
 * Create an TriEnumObj for when you want to register values based on 2 enum
 * @param <A> the enum
 * @param <B> the thing you want to create
 */
public class TriEnumObj<A extends Enum<A>, B extends Enum<B>, C> {

    private final EnumMap<A, EnumMap<B, C>> map;
    private final Class<A> aClass;
    private final Class<B> bClass;

    public TriEnumObj(Class<A> aClass, Class<B> bClass) {
       this.map = new EnumMap<>(aClass);
       this.aClass = aClass;
       this.bClass = bClass;
    }

    public C getValue(A value, B value2) {
        return map.get(value).get(value2);
    }

    public Collection<C> getValues(A value) {
        return map.get(value).values();
    }

    public TriEnumObj<A, B, C> create(BiFunction<A, B, C> predicate) {
        if(this.aClass.isEnum()) {
            A[] enumValues = aClass.getEnumConstants();
            B[] enumValuesB = bClass.getEnumConstants();

            for(A value: enumValues) {
                for(B valueB: enumValuesB) {
                    EnumMap<B, C> enumMap = new EnumMap<>(this.bClass);
                    enumMap.put(valueB, predicate.apply(value, valueB));
                    map.put(value, enumMap);
                }
            }
        }
        return this;
    }
}
