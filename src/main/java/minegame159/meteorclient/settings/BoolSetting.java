package minegame159.meteorclient.settings;

import minegame159.meteorclient.gui.widgets.WCheckbox;

import java.util.function.Consumer;

public class BoolSetting extends Setting<Boolean> {
    private BoolSetting(String name, String description, Boolean defaultValue, Consumer<Boolean> onChanged, Consumer<Setting<Boolean>> onModuleActivated) {
        super(name, description, defaultValue, onChanged, onModuleActivated);

        widget = new WCheckbox(get());
        ((WCheckbox) widget).setAction(wCheckbox -> set(wCheckbox.checked));
    }

    @Override
    protected Boolean parseImpl(String str) {
        if (str.equalsIgnoreCase("true") || str.equalsIgnoreCase("1")) return true;
        else if (str.equalsIgnoreCase("false") || str.equalsIgnoreCase("0")) return false;
        return null;
    }

    @Override
    protected void resetWidget() {
        ((WCheckbox) widget).checked = get();
    }

    @Override
    protected boolean isValueValid(Boolean value) {
        return true;
    }

    @Override
    protected String generateUsage() {
        return "#bluetrue #grayor #bluefalse";
    }

    public static class Builder {
        private String name = "undefined", description = "";
        private Boolean defaultValue;
        private Consumer<Boolean> onChanged;
        private Consumer<Setting<Boolean>> onModuleActivated;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder defaultValue(boolean defaultValue) {
            this.defaultValue = defaultValue;
            return this;
        }

        public Builder onChanged(Consumer<Boolean> onChanged) {
            this.onChanged = onChanged;
            return this;
        }

        public Builder onModuleActivated(Consumer<Setting<Boolean>> onModuleActivated) {
            this.onModuleActivated = onModuleActivated;
            return this;
        }

        public BoolSetting build() {
            return new BoolSetting(name, description, defaultValue, onChanged, onModuleActivated);
        }
    }
}