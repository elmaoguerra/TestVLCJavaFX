package com.gmail.maoguerra007.testvlcjavafx;

import com.sun.jna.Memory;
import com.sun.jna.NativeLibrary;
import java.nio.ByteBuffer;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritablePixelFormat;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import uk.co.caprica.vlcj.binding.internal.libvlc_media_t;
import uk.co.caprica.vlcj.component.DirectMediaPlayerComponent;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;
import uk.co.caprica.vlcj.discovery.windows.DefaultWindowsNativeDiscoveryStrategy;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerEventListener;
import uk.co.caprica.vlcj.player.direct.BufferFormat;
import uk.co.caprica.vlcj.player.direct.BufferFormatCallback;
import uk.co.caprica.vlcj.player.direct.DefaultDirectMediaPlayer;
import uk.co.caprica.vlcj.player.direct.DirectMediaPlayer;
import uk.co.caprica.vlcj.player.direct.format.RV32BufferFormat;


public class MainApp extends Application {

    private DirectMediaPlayerComponent mp;
    private DirectMediaPlayer player;
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;
    private PixelWriter pixelWriter;
    private WritablePixelFormat<ByteBuffer> byteBgraInstance;

    @Override
    public void start(Stage stage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
//
//        Scene scene = new Scene(root);
//        scene.getStylesheets().add("/styles/Styles.css");
//
//        stage.setTitle("JavaFX and Maven");
//        stage.setScene(scene);
//        stage.show();
        try {
            //NativeLibrary.addSearchPath("libvlc", getClass().getResource("/lib").toURI().getPath());
            NativeLibrary.addSearchPath("libvlc", "C:/Program Files/VideoLan/VLC/");
            new NativeDiscovery(new DefaultWindowsNativeDiscoveryStrategy()).discover();
        } catch (Exception e) {

            int a = 0;
        }


        BorderPane borderPane = new BorderPane();
        final Canvas canvas = new Canvas(WIDTH, HEIGHT);
        borderPane.setCenter(canvas);
        System.out.println(">>> " + canvas.getGraphicsContext2D().getPixelWriter().getPixelFormat());
        Scene scene = new Scene(borderPane);
        pixelWriter = canvas.getGraphicsContext2D().getPixelWriter();
        byteBgraInstance = PixelFormat.getByteBgraPreInstance();

        mp = new DirectMediaPlayerComponent(new BufferFormatCallback() {

            @Override
            public BufferFormat getBufferFormat(int sourceWidth, int sourceHeight) {
                return new RV32BufferFormat((int) WIDTH, (int) HEIGHT);
            }
        }) {//"RV32", (int) imgWidth, (int) imgHeight, (int) imgWidth * 4) {

        };
        player = mp.getMediaPlayer();

        player.addMediaPlayerEventListener(new MediaPlayerEventListener() {

            @Override
            public void mediaChanged(MediaPlayer mp, libvlc_media_t l, String string) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void opening(MediaPlayer mp) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void buffering(MediaPlayer mp, float f) {
                //renderFrame();
            }

            @Override
            public void playing(MediaPlayer mp) {
                //renderFrame();
            }

            @Override
            public void paused(MediaPlayer mp) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void stopped(MediaPlayer mp) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void forward(MediaPlayer mp) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void backward(MediaPlayer mp) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void finished(MediaPlayer mp) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void timeChanged(MediaPlayer mp, long l) {
                //renderFrame();
            }

            @Override
            public void positionChanged(MediaPlayer mp, float f) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void seekableChanged(MediaPlayer mp, int i) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void pausableChanged(MediaPlayer mp, int i) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void titleChanged(MediaPlayer mp, int i) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void snapshotTaken(MediaPlayer mp, String string) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void lengthChanged(MediaPlayer mp, long l) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void videoOutput(MediaPlayer mp, int i) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void scrambledChanged(MediaPlayer mp, int i) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void elementaryStreamAdded(MediaPlayer mp, int i, int i1) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void elementaryStreamDeleted(MediaPlayer mp, int i, int i1) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void elementaryStreamSelected(MediaPlayer mp, int i, int i1) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void corked(MediaPlayer mp, boolean bln) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void muted(MediaPlayer mp, boolean bln) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void volumeChanged(MediaPlayer mp, float f) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void audioDeviceChanged(MediaPlayer mp, String string) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void chapterChanged(MediaPlayer mp, int i) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void error(MediaPlayer mp) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mediaMetaChanged(MediaPlayer mp, int i) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mediaSubItemAdded(MediaPlayer mp, libvlc_media_t l) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mediaDurationChanged(MediaPlayer mp, long l) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mediaParsedChanged(MediaPlayer mp, int i) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mediaFreed(MediaPlayer mp) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mediaStateChanged(MediaPlayer mp, int i) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mediaSubItemTreeAdded(MediaPlayer mp, libvlc_media_t l) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void newMedia(MediaPlayer mp) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void subItemPlayed(MediaPlayer mp, int i) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void subItemFinished(MediaPlayer mp, int i) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void endOfSubItems(MediaPlayer mp) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        player.playMedia("C:\\VKSavatar\\proyectos\\Avatar\\Temas\\Basico\\Archivos\\Videos Avatar\\video6.mp4");

        initTimer();

        stage.setScene(scene);
        stage.show();
    }
    private AnimationTimer timer;

    private void initTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (mp.getMediaPlayer().isPlaying()) {
                    renderFrame();
                }
            }
        };
        timer.start();
    }

    protected void startTimer() {
        timer.start();
    }

    protected void stopTimer() {
        timer.stop();
        mp.getMediaPlayer().stop();
        mp.getMediaPlayer().release();
    }


    protected final void renderFrame() {
        Memory[] nativeBuffers = mp.getMediaPlayer().lock();
        if (nativeBuffers != null) {
// FIXME there may be more efficient ways to do this...
// Since this is now being called by a specific rendering time, independent of the native video callbacks being
// invoked, some more defensive conditional checks are needed
            Memory nativeBuffer = nativeBuffers[0];
            if (nativeBuffer != null) {
                ByteBuffer byteBuffer = nativeBuffer.getByteBuffer(0, nativeBuffer.size());
                BufferFormat bufferFormat = ((DefaultDirectMediaPlayer) mp.getMediaPlayer()).getBufferFormat();
                if (bufferFormat.getWidth() > 0 && bufferFormat.getHeight() > 0) {
                    pixelWriter.setPixels(0, 0, bufferFormat.getWidth(), bufferFormat.getHeight(), byteBgraInstance, byteBuffer, bufferFormat.getPitches()[0]);
                }
            }
        }
        mp.getMediaPlayer().unlock();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
