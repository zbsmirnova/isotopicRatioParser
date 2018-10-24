package zbsmirnova.isotopicRatioParser.util;

import zbsmirnova.isotopicRatioParser.model.Element;

public class ElementUtil {
    public static boolean isNew(Element element){
        return element.getId() == null;
    }
}
