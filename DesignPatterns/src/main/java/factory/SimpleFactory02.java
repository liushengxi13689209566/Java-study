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

class RuleConfigParserFactory02 {
    public static IRuleConfigParser createParser(String configFormat) {
        IRuleConfigParser parser = null;
        if ("json".equalsIgnoreCase(configFormat)) {
            // 1. 读取文件
            // 2. 查找其他类
            // 3. 组合  JsonRuleConfigParser 对象
            parser = new JsonRuleConfigParser();
        } else if ("xml".equalsIgnoreCase(configFormat)) {
            // 1. 读取文件
            // 2. 查找其他类
            // 3. 组合  XmlRuleConfigParser 对象
            parser = new XmlRuleConfigParser();
        } else if ("yaml".equalsIgnoreCase(configFormat)) {
            // 1. 读取文件
            // 2. 查找其他类
            // 3. 组合  YamlRuleConfigParser 对象
            parser = new YamlRuleConfigParser();
        } else if ("properties".equalsIgnoreCase(configFormat)) {
            // 1. 读取文件
            // 2. 查找其他类
            // 3. 组合  PropertiesRuleConfigParser 对象
            parser = new PropertiesRuleConfigParser();
        }
    }
}

