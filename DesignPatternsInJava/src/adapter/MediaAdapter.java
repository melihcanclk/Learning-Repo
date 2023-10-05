package adapter;

public class MediaAdapter implements MediaPlayer{
    AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType) {
        advancedMediaPlayer = switch (audioType.toLowerCase()){
            case "vlc":
                yield new VlcPlayer();
            case "mp4":
                yield new Mp4Player();
            default:
                throw new IllegalStateException("Unexpected value: " + audioType.toLowerCase());

        };
    }

    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("vlc")){
            advancedMediaPlayer.playVlc(fileName);
        }
        else if(audioType.equalsIgnoreCase("mp4")){
            advancedMediaPlayer.playMp4(fileName);
        }
    }
}
