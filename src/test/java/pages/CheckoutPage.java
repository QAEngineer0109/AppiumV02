package pages;

public class CheckoutPage extends BasePage {

    /**
     * Real-device safe verification: driver session is still alive.
     * Later, if you want, we can add webview context switching here.
     */
    public boolean isSessionAlive() {
        return driver.getSessionId() != null;
    }

    public CheckoutPage hideKeyboardIfVisible() {
        try { driver.hideKeyboard(); } catch (Exception ignored) {}
        return this;
    }
}

