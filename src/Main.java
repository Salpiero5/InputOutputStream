import java.io.*;
import java.nio.file.*;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static void main(String[] args) throws Exception {


//        fileOutput();
//        fileInput();

//        fileBufferOutput(); // Create a txt file with Java 7 future
//        fileBufferInput();

//        inputOutput(); // Create a txt file and it has input and output buffer stream

//        inputSequence();
//        multipleInputSequence(); // Create a txt file with Java 7 future and write in a new txt file

//        dataStream();

//        fileReadWrite(); //Read and copy a jpg file
        //       scanner();

        pathMethod(); //Java 7 Future
    }

    private static void fileOutput() throws IOException {

        FileOutputStream fo = new FileOutputStream("F:\\New.txt");
        String s = "salman chetori";
        byte[] b = s.getBytes();
        fo.write(b);
        fo.close();
        System.out.println("success");

    }

    private static void fileInput() {

        int i = 0;
        try {
            FileInputStream fi = new FileInputStream("F:\\New.txt");
            while ((i = fi.read()) != -1) {
                System.out.print((char) i);
            }
            System.out.println();
            fi.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void fileBufferOutput() {

        try (FileOutputStream fout = new FileOutputStream("New Buffer.txt");
             BufferedOutputStream bout = new BufferedOutputStream(fout);
        ) {
            String s = "Welcome to javaTpoint.";
            byte b[] = s.getBytes();

            String s2 = " new sentence";
            byte b2[] = s2.getBytes();
            bout.write(b);
            bout.write(b2);
            bout.flush(); // خالی کردن بافر برای اعمال داده جدید ؟


        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("success");

    }

    private static void fileBufferInput() {

        try (
                FileInputStream fin = new FileInputStream("New Buffer.txt");
                BufferedInputStream bin = new BufferedInputStream(fin);) {
            int i;
            while ((i = bin.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void inputOutput() {

        try {
            OutputStream out = new FileOutputStream("F:\\note.txt");
            BufferedOutputStream bf = new BufferedOutputStream(out);
            String s = "public class Main {\n" +
                    "\n" +
                    "    public static void main(String[] args) {\n" +
                    "\n" +
                    "        fileOutput();\n" +
                    "        fileInput();\n" +
                    "\n" +
                    "        fileBufferOutput();\n" +
                    "        fileBufferInput();\n" +
                    "\n" +
                    "    }\n" +
                    "\n" +
                    "    private static void fileOutput() {\n" +
                    "        try {\n" +
                    "            FileOutputStream fo = new FileOutputStream(\"F:\\\\New.txt\");\n" +
                    "            String s = \"salman chetori\";\n" +
                    "            byte[] b = s.getBytes();\n" +
                    "            fo.write(b);\n" +
                    "            fo.close();\n" +
                    "            System.out.println(\"success\");\n" +
                    "        } catch (IOException e) {\n" +
                    "            System.out.println(\"Error\");\n" +
                    "        }\n" +
                    "    }\n" +
                    "\n" +
                    "    private static void fileInput() {\n" +
                    "\n" +
                    "        int i = 0;\n" +
                    "        try {\n" +
                    "            FileInputStream fi = new FileInputStream(\"F:\\\\New.txt\");\n" +
                    "            while ((i = fi.read()) != -1) {\n" +
                    "                System.out.print((char) i);\n" +
                    "            }\n" +
                    "            System.out.println();\n" +
                    "            fi.close();\n" +
                    "        } catch (IOException e) {\n" +
                    "            e.printStackTrace();\n" +
                    "        }\n" +
                    "\n" +
                    "    }\n" +
                    "\n" +
                    "    private static void fileBufferOutput() {\n" +
                    "        try {\n" +
                    "            FileOutputStream fout = new FileOutputStream(\"F:\\\\New Buffer.txt\");\n" +
                    "            BufferedOutputStream bout = new BufferedOutputStream(fout);\n" +
                    "            String s = \"Welcome to javaTpoint.\";\n" +
                    "            byte b[] = s.getBytes();\n" +
                    "            bout.write(b);\n" +
                    "            bout.flush(); // خالی کردن بافر برای اعمال داده جدید ؟\n" +
                    "            bout.close();\n" +
                    "            fout.close();\n" +
                    "            System.out.println(\"success\");\n" +
                    "        } catch (IOException e) {\n" +
                    "            e.printStackTrace();\n" +
                    "        }\n" +
                    "    }\n" +
                    "\n" +
                    "    private static void fileBufferInput() {\n" +
                    "        try {\n" +
                    "            FileInputStream fin = new FileInputStream(\"F:\\\\New Buffer.txt\");\n" +
                    "            BufferedInputStream bin = new BufferedInputStream(fin);\n" +
                    "            int i;\n" +
                    "            while ((i = bin.read()) != -1) {\n" +
                    "                System.out.print((char) i);\n" +
                    "            }\n" +
                    "            bin.close();\n" +
                    "            fin.close();\n" +
                    "        } catch (Exception e) {\n" +
                    "            System.out.println(e);\n" +
                    "        }" +
                    "//salmaaaaaaaaaaaaaaaaan";
            bf.write(s.getBytes());
            bf.close();
            out.close();
            bf.close();
            System.out.println("The codes have been written.");
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream in = new FileInputStream("F:\\note.txt");
            BufferedInputStream bf2 = new BufferedInputStream(in);

            int i = 0;

            while ((i = bf2.read()) != -1) {
                System.out.print((char) i);
            }

            in.close();
            bf2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void inputSequence() throws Exception {


        FileInputStream fi = new FileInputStream("F:\\New.txt");
        FileInputStream fi2 = new FileInputStream("F:\\note.txt");
        SequenceInputStream si = new SequenceInputStream(fi, fi2);

        int i;
        while ((i = si.read()) != -1) {
            System.out.print((char) i);
        }
        System.out.println();
        fi.close();
        fi2.close();
        si.close();
    }

    private static void multipleInputSequence() {

        try (FileInputStream fi1 = new FileInputStream("F:\\New.txt");
             FileInputStream fi2 = new FileInputStream("F:\\note.txt");
             FileInputStream fi3 = new FileInputStream("F:\\New Buffer.txt");
             FileOutputStream fout = new FileOutputStream("New Sequence.txt");
        ) {
            Vector v = new Vector();
            v.add(fi1);
            v.add(fi2);
            v.add(fi3);

            Enumeration e;
            e = v.elements();

            SequenceInputStream si = new SequenceInputStream(e);
            int i;

            while ((i = si.read()) != -1) {
                fout.write(i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void dataStream() {

        try (
                FileOutputStream fo = new FileOutputStream("DataStream.txt");
                DataOutputStream d = new DataOutputStream(fo);
        ) {
            d.writeBytes("HELOABFLA");
            d.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void fileReadWrite() {

        try (FileWriter fw = new FileWriter("F:\\FileNote.txt")) {

            fw.write("This has been written by FileWriter class!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try (FileReader fr = new FileReader("F:\\FileNote.txt")) {

            int i = 0;
            while ((i = fr.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void scanner() {

        Scanner sc = new Scanner("Hello#/#How#/#are you ");
        System.out.println(sc.hasNextBoolean());
        System.out.println(sc.hasNextBigDecimal());
        System.out.println(sc.hasNext());

        sc.useDelimiter("/");
        System.out.println(sc.delimiter());

        while (sc.hasNext()) {
            System.out.println(sc.next());
        }
    }

    private static void pathMethod() throws IOException {

        Path source = Paths.get("F:\\New.txt");
        Path target = Paths.get("F:\\NewNote_byPath.txt");

        System.out.println(source.getFileName());
        System.out.println(source.getRoot());

        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);

//        Files.delete(target);

    }
}

