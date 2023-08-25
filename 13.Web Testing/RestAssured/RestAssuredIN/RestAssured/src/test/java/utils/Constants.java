package utils;

public class Constants {

    public static final String JIRA_USERNAME = "tsvetanilievdev@gmail.com";
    public static final String JIRA_TOKEN = "ATATT3xFfGF0C1SgJMdnU2e0GNfiUxQLgydlQqiVHR1UZQx2LuQd-RURzUUKAd4OqTzD2_EGwDk8lw2q65Os6u6v04aG325MPpqUo6Kt1gU8JA3D3tLRYLEi1umdFeEDAHkDQoyg9x-YNt1YrOpdyb7JZwWeg3yIkD5FREokxgxPAs7sYdtQYxw=1D2CEEC0";

    public static final String PROJECT_KEY = "BBT";
    public static final String TITLE_STORY = "Find and Book Your Dream Vacations";
    public static final String TITLE_BUG = "Part of the website is shown on English although is Russian version";
    public static final String DESCRIPTION_STORY = "As a user I want to be able to find and book my dream vacations";
    public static final String DESCRIPTION_BUG = "Translation is not correct, half of the website is shown on English although is Russian version";
    public static final String BODY_STORY = String.format("{\n" +
            "\t\"fields\": {\n" +
            "\t\t\"components\": [],\n" +
            "\t\t\"description\": {\n" +
            "\t\t\t\"content\": [\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"content\": [\n" +
            "\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\"text\": \"%s\",\n" +
            "\t\t\t\t\t\t\t\"type\": \"text\"\n" +
            "\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t],\n" +
            "\t\t\t\t\t\"type\": \"paragraph\"\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"type\": \"doc\",\n" +
            "\t\t\t\"version\": 1\n" +
            "\t\t},\n" +
            "\t\t\"fixVersions\": [],\n" +
            "\t\t\"issuetype\": {\n" +
            "\t\t\t\"id\": \"10006\"\n" +
            "\t\t},\n" +
            "\t\t\"labels\": [],\n" +
            "\t\t\"priority\": {\n" +
            "\t\t\t\"iconUrl\": \"https://tsvetan-qa50.atlassian.net/images/icons/priorities/medium.svg\",\n" +
            "\t\t\t\"id\": \"3\",\n" +
            "\t\t\t\"name\": \"Medium\"\n" +
            "\t\t},\n" +
            "\t\t\"project\": {\n" +
            "\t\t\t\"key\": \"%s\"\n" +
            "\t\t},\n" +
            "\t\t\"summary\": \"%s\"\n" +
            "\t}\n" +
            "}",  DESCRIPTION_STORY,PROJECT_KEY, TITLE_STORY) ;

    public static final String BODY_BUG = String.format("{\n" +
            "\t\"fields\": {\n" +
            "\t\t\"components\": [],\n" +
            "\t\t\"description\": {\n" +
            "\t\t\t\"content\": [\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"content\": [\n" +
            "\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\"text\": \"%s\",\n" +
            "\t\t\t\t\t\t\t\"type\": \"text\"\n" +
            "\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t],\n" +
            "\t\t\t\t\t\"type\": \"paragraph\"\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"type\": \"doc\",\n" +
            "\t\t\t\"version\": 1\n" +
            "\t\t},\n" +
            "\t\t\"fixVersions\": [],\n" +
            "\t\t\"issuetype\": {\n" +
            "\t\t\t\"id\": \"10005\"\n" +
            "\t\t},\n" +
            "\t\t\"labels\": [],\n" +
            "\t\t\"priority\": {\n" +
            "\t\t\t\"iconUrl\": \"https://tsvetan-qa50.atlassian.net/images/icons/priorities/medium.svg\",\n" +
            "\t\t\t\"id\": \"1\",\n" +
            "\t\t\t\"name\": \"Highest\"\n" +
            "\t\t},\n" +
            "\t\t\"project\": {\n" +
            "\t\t\t\"key\": \"%s\"\n" +
            "\t\t},\n" +
            "\t\t\"summary\": \"%s\"\n" +
            "\t}\n" +
            "}",  DESCRIPTION_BUG,PROJECT_KEY, TITLE_BUG) ;

    public static String BODY_LINK_STORY_BUG = "{\n" +
            "    \"type\": {\n" +
            "        \"id\": \"10000\"\n" +
            "    },\n" +
            "    \"inwardIssue\": {\n" +
            "        \"key\": \"STORY_KEY\"\n" +
            "    },\n" +
            "    \"outwardIssue\": {\n" +
            "        \"key\": \"BUG_KEY\"\n" +
            "    }\n" +
            "}";


}
