package com.darenzai.springframework.beans;

/**
 * <p>
 * description: PropertyValue
 * <p>
 *
 * @author 40233-胡佳艺 2023/06/09 9:01
 */
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }


}
