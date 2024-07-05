import java.io.*;
import java.util.Arrays;

public class CSVDecending3 {
    public static void main(String[] args) {
        /*I/P
        654;54
        6545;64646;8646;5
        6565
        65465;654
         */
         /*O/P
        65465;64646;8646;6565;6545;654;654;54;5
         */
        cSVDecending3();
        System.out.println("10:43");
    }

    private static void cSVDecending3() {
        File file = new File("/home/prabakar/Documents/Task/RajeeSan/sample.txt");
        StringBuilder builder = new StringBuilder();
        String temp = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((temp = reader.readLine()) != null) {
                builder.append(temp + ";");
            }
            reader.close();
            builder.deleteCharAt(builder.length() - 1);
            String out = decendint(builder.toString());
            FileWriter writer = new FileWriter(file);
            writer.write(out);
            writer.close();
        } catch (IOException e) {
            System.out.println("can't read");
        }
    }

    private static String decendint(String str) {
        String arr[] = str.split(";");
        Arrays.sort(arr, (a, b) -> Integer.parseInt(b) - Integer.parseInt(a));
        return String.join(";", arr);
    }
}
