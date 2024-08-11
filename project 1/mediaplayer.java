// ModernMediaPlayer Interface
interface ModernMediaPlayer {
    void play(String fileName);
}

// LegacyAudioPlayer Class
class LegacyAudioPlayer {
    public void playLegacyFormat(String fileName) {
        System.out.println("Playing legacy audio file: " + fileName);
    }
}

// Adapter for LegacyAudioPlayer to be used with ModernMediaPlayer interface
class LegacyToModernAdapter implements ModernMediaPlayer {
    private LegacyAudioPlayer legacyAudioPlayer;

    public LegacyToModernAdapter(LegacyAudioPlayer legacyAudioPlayer) {
        this.legacyAudioPlayer = legacyAudioPlayer;
    }

    @Override
    public void play(String fileName) {
        // Assuming fileName is in a legacy format
        legacyAudioPlayer.playLegacyFormat(fileName);
    }
}

// ModernMediaPlayer Implementation
class ModernMediaPlayerImpl implements ModernMediaPlayer {
    @Override
    public void play(String fileName) {
        System.out.println("Playing modern audio file: " + fileName);
    }
}

// Client Code
public class MediaPlayerClient {
    public static void main(String[] args) {
        // Create legacy audio player instance
        LegacyAudioPlayer legacyPlayer = new LegacyAudioPlayer();
        // Create adapter for legacy player to use with modern media player interface
        ModernMediaPlayer adapter = new LegacyToModernAdapter(legacyPlayer);

        // Create modern media player instance
        ModernMediaPlayer modernPlayer = new ModernMediaPlayerImpl();

        // Play files using both players
        System.out.println("Using Legacy to Modern Adapter:");
        adapter.play("legacyFile.abc");  // Uses legacy player

        System.out.println("\nUsing Modern Media Player:");
        modernPlayer.play("modernFile.mp3");  // Uses modern player
    }
}
