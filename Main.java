package mizhfac;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        log.trace("log trace");
        log.debug("log debug");

        Wizard wizard = new Wizard();
        wizard.teleport();  // The wizard can now teleport!

        log.info(formMessage());
        log.warn("log warn");
        log.error("log error");
        log.atInfo()
                .log(Main::formMessage);
        System.out.println("The happy end");
    }

    static String formMessage() {
        log.warn("formMessage executed");
        return "The message";
    }
}
