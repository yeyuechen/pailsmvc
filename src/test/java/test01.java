import java.util.ArrayList;
import java.util.List;

public class test01 {

    public static void main(String[] args) {

        List<String> vKeyWord = new ArrayList<>();
        vKeyWord.add("张三");
        vKeyWord.add("李四");
        String str = coven(vKeyWord, "2019-04-16", "2019-04-17");

        System.out.println(str);

    }

    private static String coven(List<String> vKeyWord, String sBegin, String sEnd) {
        StringBuilder os = new StringBuilder();

        os.append("{\"query\":{\"function_score\":{\"query\":{\"bool\":{\"must\":{\"multi_match\":{\"query\":[\"");

        for (int i = 0; i < vKeyWord.size(); i++) {
            os.append(vKeyWord.get(i));

            if (i != vKeyWord.size()-1) {
                os.append(" OR ");
            }
        }
        os.append("\"],\"fields\":[\"title^1\",\"content\"],\"type\":\"phrase\"}},\"filter\":{\"range\":{\"updatetime\":{\"gte\":\"");
        os.append(sBegin).append(" 09:00:00\",\"lte\":\"").append(sEnd).append(" 09:00:00\"}}}}}}},\"size\":100}");

        return os.toString();
    }
}
