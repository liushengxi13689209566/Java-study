package factory;

/**
 * @Date: 2022-03-11 11:06
 * @Author: liushengxi
 * @Description:
 */
public class SimpleFactory01 {
    public static void main(String[] args) {
        JsonRuleConfigParser jsonRuleConfigParser = (JsonRuleConfigParser) RuleConfigParserFactory.createParser("json");
        // 直接使用即可
    }
}

class RuleConfigParserFactory {
    public static IRuleConfigParser createParser(String configFormat) {
        IRuleConfigParser parser = null;
        if ("json".equalsIgnoreCase(configFormat)) {
            parser = new JsonRuleConfigParser();
        } else if ("xml".equalsIgnoreCase(configFormat)) {
            parser = new XmlRuleConfigParser();
        } else if ("yaml".equalsIgnoreCase(configFormat)) {
            parser = new YamlRuleConfigParser();
        } else if ("properties".equalsIgnoreCase(configFormat)) {
            parser = new PropertiesRuleConfigParser();
        }
        return parser;
    }
}

class JsonRuleConfigParser implements IRuleConfigParser {
}

class XmlRuleConfigParser implements IRuleConfigParser {
}

class YamlRuleConfigParser implements IRuleConfigParser {
}

class PropertiesRuleConfigParser implements IRuleConfigParser {
}
