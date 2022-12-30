package com.black_dog20.theonekey.client.utils;

import com.black_dog20.theonekey.TheOneKey;
import com.black_dog20.theonekey.api.plugin.IModPlugin;
import com.black_dog20.theonekey.api.plugin.OneKeyPlugin;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.forgespi.language.ModFileScanData;
import org.objectweb.asm.Type;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class PluginFinder {

    public static List<IModPlugin> getModPlugins() {
        return getInstances(OneKeyPlugin.class, IModPlugin.class);
    }

    private static <T> List<T> getInstances(Class<?> annotationClass, Class<T> instanceClass) {
        List<String> pluginClassNames = getPluginClassNames(annotationClass);
        return pluginClassNames.stream()
                .map(pluginClassName -> createInstance(instanceClass, pluginClassName))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private static List<String> getPluginClassNames(Class<?> annotationClass) {
        Type annotationType = Type.getType(annotationClass);
        return ModList.get().getAllScanData().stream()
                .map(ModFileScanData::getAnnotations)
                .flatMap(Collection::stream)
                .filter(a -> Objects.equals(a.annotationType(), annotationType))
                .map(ModFileScanData.AnnotationData::memberName)
                .collect(Collectors.toList());
    }

    private static <T> T createInstance(Class<T> instanceClass, String pluginClassName) {
        try {
            Class<?> asmClass = Class.forName(pluginClassName);
            Class<? extends T> asmInstanceClass = asmClass.asSubclass(instanceClass);
            return asmInstanceClass.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | LinkageError | ClassCastException e) {
            TheOneKey.LOGGER.error("Failed to load: {}", pluginClassName, e);
        }

        return null;
    }
}
