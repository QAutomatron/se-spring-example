package site.data;

/**
 * Data for sliders
 */
public enum CalculatorFormSliderData {
    Amount("amount_slider", 50, 425, 5),
    Term("term_slider", 10, 30, 1);

    private final String selector;
    private final int minValue;
    private final int maxValue;
    private final int step;

    CalculatorFormSliderData(String selector, int minValue, int maxValue, int step) {
        this.selector = selector;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.step = step;
    }

    public String getSelector() {
        return selector;
    }

    public int getMinValue() {
        return minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public int getStep() {
        return step;
    }
}
