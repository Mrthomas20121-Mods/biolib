package mrthomas20121.biolib.util;

import java.util.Collection;
import java.util.EnumMap;
import java.util.function.Function;

/**
 * Create an EnumObj for when you want to register values based on an enum
 * @param <A> the enum
 * @param <B> the thing you want to create
 */
public class EnumObj<A extends Enum<A>, B> {

    protected final EnumMap<A, B> map;
    protected final Class<A> aClass;

    public EnumObj(Class<A> aClass) {
       this.map = new EnumMap<>(aClass);
       this.aClass = aClass;
    }

    public Collection<B> getValues() {
        return map.values();
    }

    public B getValue(A value) {
        return this.map.get(value);
    }

    public EnumMap<A, B> getMap() {
        return map;
    }

    public EnumObj<A, B> create(Function<A, B> predicate) {
        if(this.aClass.isEnum()) {
            A[] enumValues = aClass.getEnumConstants();

            for(A value: enumValues) {
                map.put(value, predicate.apply(value));
            }
        }
        return this;
    }
}
