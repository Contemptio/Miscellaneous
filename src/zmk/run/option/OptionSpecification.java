package zmk.run.option;

import zmk.run.option.type.Option;

public interface OptionSpecification {
    String optionName();

    Option<?> option();
}
