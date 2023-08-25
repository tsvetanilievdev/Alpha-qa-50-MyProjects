package utils;

public class Methods {

    public static String createBodyJson(String title, String description, String projectKey, String issueTypeName){
        String body = "{\n" +
                "    \"fields\": {\n" +
                "        \"project\": {\n" +
                "            \"key\": \""+projectKey+"\"\n" +
                "        },\n" +
                "        \"summary\": \""+title+"\",\n" +
                "        \"description\": \""+description+"\",\n" +
                "        \"issuetype\": {\n" +
                "            \"id\": \""+10005+"\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        return body;
    }

    public  static String linkBodyJson(String inwardKey, String outwardKey){
        String body = "{\n" +
                "    \"type\": {\n" +
                "        \"name\": \"blocked by\"\n" +
                "    },\n" +
                "    \"inwardIssue\": {\n" +
                "        \"key\": \""+inwardKey+"\"\n" +
                "    },\n" +
                "    \"outwardIssue\": {\n" +
                "        \"key\": \""+outwardKey+"\"\n" +
                "    }\n" +
                "}";
        return body;
    }
}
