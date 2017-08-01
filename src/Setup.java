import java.io.*;
import java.nio.file.NoSuchFileException;
import java.util.concurrent.TimeUnit;

public class Setup {

    public static String PathReader() throws IOException {
        BufferedReader pathReader = new BufferedReader(new InputStreamReader(System.in));
        String somePath = pathReader.readLine();
        return somePath;
    }

    public static void CheckFileExist(File name) throws InterruptedException {
        try{
            if(!name.isFile())
            throw new NoSuchFileException("Файл не найден по указанному пути");
        }catch (NoSuchFileException e){
            System.out.println(e.getMessage());
            TimeUnit.SECONDS.sleep(3);
            System.exit(9);
        }
    }

    protected static void ReadAndCompare(File sourceFile, File destFile)throws IOException{
        FileReader frSource = new FileReader(sourceFile);
        FileReader frDest = new FileReader(destFile);
        BufferedReader  brSource = new BufferedReader(frSource);
        BufferedReader  brDest = new BufferedReader(frDest);
        String lineSource = "";
        String lineDest = "";
        while(lineSource != null){
            lineSource = brSource.readLine();
            lineDest = brDest.readLine();
            if(lineSource == null){
                break;
            }else if((!lineSource.equals(lineDest))){
                System.out.println("Строки не совпадают\n" + lineSource + "   " + lineDest );
            }
        }
        System.out.println("Сравнение закончено, все строки совпадают");
    }
}
