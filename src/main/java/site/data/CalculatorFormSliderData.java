package site.data;


public enum CalculatorFormSliderData {
    Amount("amount_slider"),
    Term("term_slider");

    private final String selector;

    CalculatorFormSliderData(String selector) {
        this.selector = selector;
    }

    public String getSelector() {
        return selector;
    }
}
