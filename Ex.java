public class Ex {


    private String getCategoryPathName() {

        String str = "123_456_789";
        String result = "";
        String[] strArr = str.split("_");
        String temp = "";
        for (int i = 0; i < strArr.length; i++) {
            temp = temp + (i == 0 ? "" : "_") + strArr[i];
            temp = temp.strip();
            System.out.println(temp);
            result = "/" + temp;
        }

        return null;
    }

    public static void main(String[] args) {
        new Ex().getCategoryPathName();
    }


}
