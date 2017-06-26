package zmk.run.option;

import zmk.run.option.type.Option;

public interface OptionSpecification {
    OptionSpecification[] values = null;

    Option<?> option();

    String name();
}
