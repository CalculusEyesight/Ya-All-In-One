package xv2;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
class Agd {

    VBox vBox= new VBox(5);

    ArrayList<Integer> getLevel=new ArrayList<>();
    ArrayList<Integer> getXpToNextLevel=new ArrayList<>();
    ArrayList<Integer> getXpToThisLevel=new ArrayList<>();
    ArrayList<Integer> getAttributePointsGained=new ArrayList<>();

    private int entries=0;

    public Agd(){
        this.vBox.setPadding(new Insets(0,0,0,60));
        vBoxListener();
    }
    public VBox createVbox(){
        VBox vBox=new VBox();
        vBox.getChildren().addAll(createToolBar(),createScrollPane());
        return vBox;
    }

    private ScrollPane createScrollPane(){
        ScrollPane scrollPane=new ScrollPane();
        scrollPane.setContent(vBox);
        return scrollPane;
    }

    private ToolBar createToolBar(){
        Button insertEntry=new Button("Insert Entry");
        insertEntry.setOnAction(event->{
            getLevel.add(0);
            getXpToNextLevel.add(0);
            getXpToThisLevel.add(0);
            getAttributePointsGained.add(0);
            createVBoxAgdData();
            entries+=1;
        });
        Button removeEntry=new Button("Remove Entry");
        removeEntry.setOnAction(event->{
            try {
                getLevel.remove(entries-1);
                getXpToNextLevel.remove(entries-1);
                getXpToThisLevel.remove(entries-1);
                getAttributePointsGained.remove(entries-1);
                this.vBox.getChildren().remove(entries);
                entries-=1;
            } catch (IndexOutOfBoundsException e) {
                Popups.ErrorOutOfBounds();
            }
        });
        ToolBar toolBar=new ToolBar(
            insertEntry,
            removeEntry
        );
        return toolBar;
    }

    private VBox createVBoxAgdData(){
        HBox hBox=new HBox(30);
        Label lblLevel=new Label("Level");
        TextField txtLevel=new TextField(String.valueOf(getLevel.getLast()));
        txtLevel.textProperty().addListener((obs,oldText,newText)->{
            if (txtLevel.getText().contains("-")) {
                return;
            }
            try {
                int indexOfHBox = vBox.getChildren().indexOf(txtLevel.getParent());
                getLevel.set(indexOfHBox, Integer.parseInt(newText));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        });


        Label lblXpToNextLevel=new Label("Xp To Next Level");
        TextField txtXpToNextLevel=new TextField(String.valueOf(getXpToNextLevel.getLast()));
        txtXpToNextLevel.textProperty().addListener((obs,oldText,newText)->{
            if (txtXpToNextLevel.getText().contains("-")) {
                return;
            }
            try {
                int indexOfHBox = vBox.getChildren().indexOf(txtXpToNextLevel.getParent());
                getXpToNextLevel.set(indexOfHBox, Integer.parseInt(newText));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        });
        Label lblXpToThisLevel=new Label("Xp To This Level");
        TextField txtXpToThisLevel=new TextField(String.valueOf(getXpToThisLevel.getLast()));
        txtXpToThisLevel.textProperty().addListener((obs,oldText,newText)->{
            if (txtXpToThisLevel.getText().contains("-")) {
                return;
            }
            try {
                int indexOfHBox = vBox.getChildren().indexOf(txtXpToThisLevel.getParent());
                getXpToThisLevel.set(indexOfHBox, Integer.parseInt(newText));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        });

        Label lblAttributePointsGained=new Label("Attribute Points Gained");
        TextField txtAttributePointsGained=new TextField(String.valueOf(getAttributePointsGained.getLast()));
        txtAttributePointsGained.textProperty().addListener((obs,oldText,newText)->{
            if (txtAttributePointsGained.getText().contains("-")) {
                return;
            }
            try {
                int indexOfHBox = vBox.getChildren().indexOf(txtAttributePointsGained.getParent());
                getAttributePointsGained.set(indexOfHBox, Integer.parseInt(newText));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        });

       hBox.getChildren().addAll(lblLevel,txtLevel,lblXpToNextLevel,txtXpToNextLevel,lblXpToThisLevel,txtXpToThisLevel,lblAttributePointsGained,txtAttributePointsGained);
       vBox.getChildren().add(hBox);
       
       return vBox;
    }
    private void vBoxListener(){
        vBox.addEventFilter(MouseEvent.ANY, event -> {
        });
    }

    public void agdReader(Path path){
        try(FileChannel channel=FileChannel.open(path, StandardOpenOption.READ)) {
            int offset=16;
            
            ByteBuffer intBuffer=ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
            ByteBuffer shortBuffer=ByteBuffer.allocate(2).order(ByteOrder.LITTLE_ENDIAN);

            channel.position(8);
            shortBuffer.clear();
            channel.read(shortBuffer);
            shortBuffer.flip();
            entries=shortBuffer.getShort();
            
            for(int i=0;i<entries;i++){
                //reading level
                channel.position(offset*(i+1));
                intBuffer.clear();
                channel.read(intBuffer);
                intBuffer.flip();
                getLevel.add(intBuffer.getInt());
                
                //reading xptonextlevel
                channel.position(offset*(i+1)+4);
                intBuffer.clear();
                channel.read(intBuffer);
                intBuffer.flip();
                getXpToNextLevel.add(intBuffer.getInt());
                
                //reading xptothislevel
                channel.position(offset*(i+1)+8);
                intBuffer.clear();
                channel.read(intBuffer);
                intBuffer.flip();
                getXpToThisLevel.add(intBuffer.getInt());

                //reading attributepointsgained
                channel.position(offset*(i+1)+12);
                intBuffer.clear();
                channel.read(intBuffer);
                intBuffer.flip();
                getAttributePointsGained.add(intBuffer.getInt());

                createVBoxAgdData();
            }
        } catch (IOException e) {
            System.err.println(e);
            Popups.ErrorLoad(path.toFile().getName());
        }
    }

    public void agdWriter(Path path){
        try(FileChannel channel=FileChannel.open(path, StandardOpenOption.WRITE,StandardOpenOption.CREATE,StandardOpenOption.TRUNCATE_EXISTING)) {
            int offset=16;
            
            ByteBuffer intBuffer=ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
            
            channel.position(0);
            channel.write(ByteBuffer.wrap(new byte[]{0x23,0x41,0x47,0x44}));
          
            channel.position(4);
            channel.write(ByteBuffer.wrap(new byte[]{(byte)0xFE,(byte)0xFF}));

            channel.position(6);
            channel.write(ByteBuffer.wrap(new byte[]{0x10,0x00}));

            channel.position(8);
            intBuffer.clear();
            intBuffer.putInt(entries);
            intBuffer.flip();
            channel.write(intBuffer);

            channel.position(12);
            channel.write(ByteBuffer.wrap(new byte[]{0x10,0x00,0x00,0x00}));

            for(int i=0;i<entries;i++){
                //writing level
                channel.position(offset*(i+1));
                intBuffer.clear();
                intBuffer.putInt(getLevel.get(i));
                intBuffer.flip();
                channel.write(intBuffer);

                //writing xptonextlevel
                channel.position(offset*(i+1)+4);
                intBuffer.clear();
                intBuffer.putInt(getXpToNextLevel.get(i));
                intBuffer.flip();
                channel.write(intBuffer);

                //writing xptothislevel
                channel.position(offset*(i+1)+8);
                intBuffer.clear();
                intBuffer.putInt(getXpToThisLevel.get(i));
                intBuffer.flip();
                channel.write(intBuffer);
                
                //writing attributepointsgained
                channel.position(offset*(i+1)+12);
                intBuffer.clear();
                intBuffer.putInt(getAttributePointsGained.get(i));
                intBuffer.flip();
                channel.write(intBuffer);
            }
            
        } catch (IOException e) {
            System.err.println(e);
            Popups.ErrorSave(path.toFile().getName());
        }
    }
}
