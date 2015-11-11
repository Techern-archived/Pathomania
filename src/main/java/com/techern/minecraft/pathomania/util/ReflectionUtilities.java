package com.techern.minecraft.pathomania.util;

import java.lang.reflect.Field;

/**
 * A class used to help with Java's reflection abilities
 *
 * @since 0.0.1
 */
public class ReflectionUtilities {

    /**
     * Gets a {@link Field} in a {@link Class}'s hierarchy
     *
     * @param classBeingSearched The {@link Class} being searched
     * @param fieldName The {@link Field}'s name
     * @return A {@link Field} if successful
     *
     * @throws NoSuchFieldException If not field in the hierarchy
     * @since 0.0.1
     */
    public static Field getFieldInHierarchy(Class<?> classBeingSearched, String fieldName) throws NoSuchFieldException {
        try {
            return classBeingSearched.getDeclaredField(fieldName);
        } catch (NoSuchFieldException exception) {
            Class<?> superClass = classBeingSearched.getSuperclass();

            //Check to see if it exists
            if (superClass != null) {
                return getFieldInHierarchy(superClass, fieldName);
            } else {
                throw new NoSuchFieldException("Not even in hierarchy: \"" + fieldName + "\"");
            }
        }
    }

}
