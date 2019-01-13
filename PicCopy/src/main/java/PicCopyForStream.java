import javax.swing.*;
import java.io.*;
import java.util.Date;

public class PicCopyForStream {
    FileInputStream fr;
    FileOutputStream fw;
    String extName;

    public PicCopyForStream(String picPath) {
        File file=new File(picPath);
        if (!file.exists()){
            JOptionPane.showMessageDialog(null,"输入的图片不存在");
        }else {
            try {
                fr = new FileInputStream(picPath);
                extName=picPath.substring(picPath.lastIndexOf("."));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void uploadPic(String targetPath){
        File file = new File(targetPath+"/"+new Date().getTime()+extName);
        try {
            fw= new FileOutputStream(file);
            int length;
            byte[] size=new byte[1024];

            while ((length = fr.read(size))!=-1){
                fw.write(size,0,length);
//                fw.flush();
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
