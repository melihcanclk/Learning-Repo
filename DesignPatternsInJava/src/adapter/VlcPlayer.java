package adapter;

public class VlcPlayer implements AdvancedMediaPlayer{
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing VLC file with name: " + fileName);
    }

    @Override
    public void playMp4(String fileName) {
     // do nothing
    }
}
