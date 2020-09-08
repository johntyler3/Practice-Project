package topics.string;

//leetCode #1108
public class DefangIpAddress {

    public String defangIPaddr(String address) {
        String fang = "[.]";

        StringBuilder sb = new StringBuilder();
        for (char ch :  address.toCharArray()) {
            if (ch == '.') {
                sb.append(fang);
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

}
