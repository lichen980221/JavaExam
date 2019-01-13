import javax.swing.*;
import java.io.*;
import java.util.Date;

public class PicCopyForChar {
    FileReader fr;
    FileWriter fw;
    String extName;

    public PicCopyForChar(String picPath) {
        File file=new File(picPath);
        if (!file.exists()){
            JOptionPane.showMessageDialog(null,"输入的图片不存在");
        }else {
            try {
                fr = new FileReader(picPath);
                extName=picPath.substring(picPath.lastIndexOf("."));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void uploadPic(String targetPath){
        File file = new File(targetPath+"/"+new Date().getTime()+extName);
        try {
            fw=new FileWriter(file);
            int length;
            while ((length = fr.read())!=-1){
                fw.write(length);
                fw.close();
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void close(){

            try {
                if (fw!=null)
                fw.close();
                if (fr!=null)
                    fr.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

    }
}
