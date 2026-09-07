import javax.sound.sampled.AudioFileFormat;

public class MediaProcessingSystem {
    
    public interface  Playable {
    void play();        
    }
    interface Compressible{
        void compress();
    }
    abstract static class MediaFile{
        protected String fileName;

        public MediaFile(String fileName){
            this.fileName = fileName;
        }
        public void displayInfo(){
            System.out.println("名稱:"+fileName);
        }
        public abstract void open();
    }
    static class ImageFile extends MediaFile implements Compressible{
        public ImageFile(String fileName){
            super(fileName);
        }
        public void open(){
            System.out.println("開啟");
        }
        public void compress(){
            System.out.println("壓縮");
        }
    }
    static class AudioFile extends MediaFile implements Playable,Compressible{
        public AudioFile(String fileName){
            super(fileName);
        }
        public void open(){
            System.out.println("開啟");
        }
        public void play(){
            System.out.println("播放");
        }
        public void compress(){
            System.out.println("壓縮");
        }
    }
    static class VideoFile extends MediaFile implements Compressible{
        public VideoFile(String fileName){
            super(fileName);
        }
        public void open(){
            System.out.println("開啟");
        }
        public void compress(){
            System.out.println("壓縮");
        }
    }
    public static void main(String[] args) {
        
        MediaFile[] mediaFiles = {
            new ImageFile("a.jpg"),
            new AudioFile("B.mp3"),
            new VideoFile("c.mp4")
        };
       
    }}
   

    

