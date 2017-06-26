package zmk.run.option;

import java.util.Collection;
import java.util.Map;

import zmk.run.option.type.Option;

/**
 * Base class for an options' registry.
 * 
 * @author Zimon
 *
 */
public abstract class OptionRegistry implements Options {
    protected Map<String, Option<?>> optionsMap;

    /**
     * Creates a new option registry using options set by {@link #options()}.
     */
    protected OptionRegistry() {
        for (Option<?> option : options()) {
            optionsMap.put(option.name(), option);
        }
    }

    protected abstract Collection<Option<?>> options();

    @Override
    public final Option<?> get(String name) {
        if (!optionsMap.containsKey(name)) {
            throw new NoSuchOptionException(name);
        }
        return optionsMap.get(name);
    }
}
