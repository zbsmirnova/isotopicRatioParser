package zbsmirnova.isotopicRatioParser.util;

import zbsmirnova.isotopicRatioParser.util.exception.NotFoundException;

public class ValidationUtil {

    private ValidationUtil() {
    }

    public static boolean checkNotFoundWithId(boolean found, int id) {
        return checkNotFound(found, "id=" + id);
    }

    public static <T> T checkNotFoundWithId(T object, int id) {
        return checkNotFound(object, "id=" + id);
    }

    public static <T> T checkNotFound(T object, String msg) {
        checkNotFound(object != null, msg);
        return object;
    }

    public static boolean checkNotFound(boolean found, String arg) {
        if (!found) {
            throw new NotFoundException(arg);
        }
        else return found;
    }

    public static String getMessage(Throwable e) {
        return e.getLocalizedMessage() != null ? e.getLocalizedMessage() : e.getClass().getName();
    }
}