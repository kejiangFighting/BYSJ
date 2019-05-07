package db;

public class test {
	public static void main(String[] args) {
//        WordReader.extractDoc("d:/1.docx","d:/ee.html");
		String fujianYuashiMing="功能需求.docx";
        String filename= fujianYuashiMing.substring(0,fujianYuashiMing.lastIndexOf("."));

        System.out.print(filename);
    }
}
