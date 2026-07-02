package xv2;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import javax.imageio.ImageIO;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.embed.swing.SwingFXUtils;
public class Emb {
    private int embEntries=0;
    private int i08;
    private boolean isPortrait=false;

    ArrayList<String> allEntries;
    
    ArrayList<byte []> allImages;

    ListView<String> listView=new ListView<>();

    HBox hBox=new HBox();
    Emb(){
        entriesActionListener();

    }

    public VBox createVBox(){
        VBox vBox=new VBox(createToolBar(),createHBox());
        VBox.setVgrow(hBox, Priority.ALWAYS);
        return vBox;
    }

    private ToolBar createToolBar(){
        Button addNewImage= new Button("Add New Images");
        addNewImage.setOnAction(event->{
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Resource File");
            fileChooser.getExtensionFilters().addAll(
            new ExtensionFilter("Image Files", "*.dds"));
            List<File> selectedFiles = fileChooser.showOpenMultipleDialog(null);
            try {
                if(selectedFiles!=null){
                    for(File file: selectedFiles){
                        allImages.add(Files.readAllBytes(file.toPath()));
                        allEntries.add(new String(file.getName()+"\0"));
                        listView.getItems().add(allEntries.getLast());
                    }

                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        });
        Button mergeEmb=new Button("Merge embs");
        mergeEmb.setOnAction(event->{
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Resource File");
            fileChooser.getExtensionFilters().addAll(
            new ExtensionFilter("Emb Files", "*.emb"));
            File selectedFile = fileChooser.showOpenDialog(null);
            if(selectedFile!=null){
                embReader(selectedFile.toPath(),allEntries.size());
            }
            
        });

        ToolBar toolBar=new ToolBar(
            addNewImage,
            mergeEmb
        );

        return toolBar;
    }

    private HBox createHBox(){
        ImageView imageView=new ImageView();
        this.hBox.getChildren().addAll(listView,imageView);
        return hBox;
    }

    private StackPane createImageView(int i){
        ImageView imageView=new ImageView();
        ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(allImages.get(i));
        try {
            BufferedImage bufferedImage=ImageIO.read(byteArrayInputStream);
            Image image= SwingFXUtils.toFXImage(bufferedImage, null);
            imageView.setImage(image);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        StackPane imageContainer=new StackPane(imageView);
        this.hBox.getChildren().add(imageContainer);
        HBox.setHgrow(imageContainer, Priority.ALWAYS);
        
        imageView.setFitHeight(600);
        imageView.setFitWidth(600);
        imageView.setSmooth(true);
        imageView.setCache(true);
        imageView.setPreserveRatio(true);

        return imageContainer;
    }

    private void entriesActionListener(){
        listView.getSelectionModel().selectedItemProperty().addListener((obs,oldValue,newValue)->{
            if(newValue==null){
                return;
            }
            //System.out.println("entry clicked: "+listView.getSelectionModel().getSelectedIndex());
            hBox.getChildren().remove(1);
            hBox.getChildren().set(1,createImageView(listView.getSelectionModel().getSelectedIndex()));
        });
        listView.setOnMouseClicked(e->{
            if(e.getButton()==MouseButton.SECONDARY){
                ContextMenu contextMenu=new ContextMenu();
                MenuItem delete=new MenuItem("Delete Delete");
                MenuItem append=new MenuItem("Append Ctrl+A");
                MenuItem insert=new MenuItem("Insert Ctrl+I");
                MenuItem replace=new MenuItem("Replace Ctrl+R");
                contextMenu.getItems().addAll(delete,append,insert,replace);
                listView.setContextMenu(contextMenu);
                contextMenu.setOnAction(event->{
                    if(event.getTarget()==delete){
                       Delete();
                    }
                    if(event.getTarget()==append){
                        Append();
                    }
                    if(event.getTarget()==insert){
                        Insert();
                    }
                    if(event.getTarget()==replace){
                        Replace();
                    }
                });
            }
        });
    }

    private void Delete(){ 
        allEntries.remove(listView.getSelectionModel().getSelectedIndex());
        allImages.remove(listView.getSelectionModel().getSelectedIndex());
        listView.getItems().remove(listView.getSelectionModel().getSelectedIndex());
    }

    private void Append(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
        new ExtensionFilter("Image Files", "*.dds"));
        File selectedFile = fileChooser.showOpenDialog(null);
        if(selectedFile!=null){
            try {
            allImages.add((listView.getSelectionModel().getSelectedIndex()+1),Files.readAllBytes(selectedFile.toPath()));
            allEntries.add((listView.getSelectionModel().getSelectedIndex()+1),new String(selectedFile.getName()));
            listView.getItems().add((listView.getSelectionModel().getSelectedIndex()+1),(allEntries.get(listView.getSelectionModel().getSelectedIndex()+1)));
            
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void Insert(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
        new ExtensionFilter("Image Files", "*.dds"));
        File selectedFile = fileChooser.showOpenDialog(null);
        if(selectedFile!=null){
            try {
            allImages.add((listView.getSelectionModel().getSelectedIndex()),Files.readAllBytes(selectedFile.toPath()));
            allEntries.add((listView.getSelectionModel().getSelectedIndex()),new String(selectedFile.getName()));
            listView.getItems().add((listView.getSelectionModel().getSelectedIndex()),(allEntries.get(listView.getSelectionModel().getSelectedIndex())));

            
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    private void Replace(){
        
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
        new ExtensionFilter("Image Files", "*.dds"));
        File selectedFile = fileChooser.showOpenDialog(null);
        if(selectedFile!=null){
            try {
            allImages.add((listView.getSelectionModel().getSelectedIndex()+1),Files.readAllBytes(selectedFile.toPath()));
            allEntries.add((listView.getSelectionModel().getSelectedIndex()+1),new String(selectedFile.getName()));
            
            listView.getItems().add(listView.getSelectionModel().getSelectedIndex() + 1, allEntries.get(listView.getSelectionModel().getSelectedIndex() + 1));
            allEntries.remove(listView.getSelectionModel().getSelectedIndex());
            allImages.remove(listView.getSelectionModel().getSelectedIndex());
            listView.getItems().remove(listView.getSelectionModel().getSelectedIndex());
            listView.getSelectionModel().select(listView.getSelectionModel().getSelectedIndex()+1);

            
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public void embReader(Path path){
        try(FileChannel channel=FileChannel.open(path, StandardOpenOption.READ)) {
            ByteBuffer byteBuffer=ByteBuffer.allocate(1).order(ByteOrder.LITTLE_ENDIAN);
            ByteBuffer intBuffer=ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
            ByteBuffer dynamicStringBuffer;
            ByteBuffer dynamicImageBuffer;
            int entriesOffset=32;
            int filesOffset;
            int fileNamesOffset;
            int imageOffset;
            int imageSize;

            channel.position(8);
            intBuffer.clear();
            channel.read(intBuffer);
            intBuffer.flip();
            i08=intBuffer.getInt();

            channel.position(12);
            intBuffer.clear();
            channel.read(intBuffer);
            intBuffer.flip();
            embEntries=intBuffer.getInt();
            
            channel.position(28);
            intBuffer.clear();
            channel.read(intBuffer);
            intBuffer.flip();
            filesOffset=intBuffer.getInt();


            allEntries=new ArrayList<>(embEntries);
            allImages=new ArrayList<>(embEntries);
            for(int i=0;i<embEntries;i++){
                if(filesOffset!=0){
                    isPortrait=true;
                    channel.position(filesOffset+i*4);
                    intBuffer.clear();
                    channel.read(intBuffer);
                    intBuffer.flip();
                    fileNamesOffset=intBuffer.getInt();
                    //System.out.println("file names offset: "+fileNamesOffset);

                    int counter=0;
                    do {
                        channel.position(fileNamesOffset+counter);
                        byteBuffer.clear();
                        channel.read(byteBuffer);
                        byteBuffer.flip();
                        counter++;
                    } while (byteBuffer.get()!=0);
                    dynamicStringBuffer=ByteBuffer.allocate(counter).order(ByteOrder.LITTLE_ENDIAN);
                    channel.position(fileNamesOffset);
                    dynamicStringBuffer.clear();
                    channel.read(dynamicStringBuffer);
                    dynamicStringBuffer.flip();
                    allEntries.add(new String(dynamicStringBuffer.array(),StandardCharsets.ISO_8859_1));
                    listView.getItems().add(allEntries.get(i));

                    channel.position(entriesOffset+i*8);
                    intBuffer.clear();
                    channel.read(intBuffer);
                    intBuffer.flip();
                    imageOffset=intBuffer.getInt();

                    channel.position(entriesOffset+4+i*8);
                    intBuffer.clear();
                    channel.read(intBuffer);
                    intBuffer.flip();
                    imageSize=intBuffer.getInt();

                    dynamicImageBuffer=ByteBuffer.allocate(imageSize);
                    channel.position(entriesOffset+imageOffset+i*8);
                    dynamicImageBuffer.clear();
                    channel.read(dynamicImageBuffer);
                    dynamicImageBuffer.flip();
                    allImages.add(dynamicImageBuffer.array());

                }
                else{
                    String dataString;
                    if (i < 10) { 
                        dataString = "DATA00"; 
                    } else if (i < 100) { 
                        dataString = "DATA0"; 
                    } else { 
                        dataString = "DATA"; 
                    }
                    allEntries.add(new String(dataString + i)); 
                    listView.getItems().add(allEntries.get(i));

                    channel.position(entriesOffset+i*8);
                    intBuffer.clear();
                    channel.read(intBuffer);
                    intBuffer.flip();
                    imageOffset=intBuffer.getInt();

                    channel.position(entriesOffset+4+i*8);
                    intBuffer.clear();
                    channel.read(intBuffer);
                    intBuffer.flip();
                    imageSize=intBuffer.getInt();

                    dynamicImageBuffer=ByteBuffer.allocate(imageSize);
                    channel.position(entriesOffset+imageOffset+i*8);
                    dynamicImageBuffer.clear();
                    channel.read(dynamicImageBuffer);
                    dynamicImageBuffer.flip();
                    allImages.add(dynamicImageBuffer.array());

                }
            }
        }
        catch(IOException e){
            e.printStackTrace();

        }
    }

    public void embReader(Path path, int initialEntries){
        try(FileChannel channel=FileChannel.open(path, StandardOpenOption.READ)) {
            ByteBuffer byteBuffer=ByteBuffer.allocate(1).order(ByteOrder.LITTLE_ENDIAN);
            ByteBuffer intBuffer=ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
            ByteBuffer dynamicStringBuffer;
            ByteBuffer dynamicImageBuffer;
            int entriesOffset=32;
            int filesOffset;
            int fileNamesOffset;
            int imageOffset;
            int imageSize;


            channel.position(12);
            intBuffer.clear();
            channel.read(intBuffer);
            intBuffer.flip();
            embEntries=intBuffer.getInt();
            
            channel.position(28);
            intBuffer.clear();
            channel.read(intBuffer);
            intBuffer.flip();
            filesOffset=intBuffer.getInt();

            allEntries.ensureCapacity(embEntries+initialEntries);
            allImages.ensureCapacity(embEntries+initialEntries);
            for(int i=0;i<embEntries;i++){
                if(filesOffset!=0){
                    channel.position(filesOffset+i*4);
                    intBuffer.clear();
                    channel.read(intBuffer);
                    intBuffer.flip();
                    fileNamesOffset=intBuffer.getInt();

                    int counter=0;
                    do {
                        channel.position(fileNamesOffset+counter);
                        byteBuffer.clear();
                        channel.read(byteBuffer);
                        byteBuffer.flip();
                        counter++;
                    } while (byteBuffer.get()!=0);
                    dynamicStringBuffer=ByteBuffer.allocate(counter).order(ByteOrder.LITTLE_ENDIAN);
                    channel.position(fileNamesOffset);
                    dynamicStringBuffer.clear();
                    channel.read(dynamicStringBuffer);
                    dynamicStringBuffer.flip();
                    allEntries.add(new String(dynamicStringBuffer.array(),StandardCharsets.ISO_8859_1));
                    listView.getItems().add(allEntries.getLast());

                    channel.position(entriesOffset+i*8);
                    intBuffer.clear();
                    channel.read(intBuffer);
                    intBuffer.flip();
                    imageOffset=intBuffer.getInt();

                    channel.position(entriesOffset+4+i*8);
                    intBuffer.clear();
                    channel.read(intBuffer);
                    intBuffer.flip();
                    imageSize=intBuffer.getInt();

                    dynamicImageBuffer=ByteBuffer.allocate(imageSize);
                    channel.position(entriesOffset+imageOffset+i*8);
                    dynamicImageBuffer.clear();
                    channel.read(dynamicImageBuffer);
                    dynamicImageBuffer.flip();
                    allImages.add(dynamicImageBuffer.array());

                }
                else{
                    allEntries.add(new String("DATA00"+i));
                    listView.getItems().add(allEntries.getLast());

                    channel.position(entriesOffset+i*8);
                    intBuffer.clear();
                    channel.read(intBuffer);
                    intBuffer.flip();
                    imageOffset=intBuffer.getInt();

                    channel.position(entriesOffset+4+i*8);
                    intBuffer.clear();
                    channel.read(intBuffer);
                    intBuffer.flip();
                    imageSize=intBuffer.getInt();

                    dynamicImageBuffer=ByteBuffer.allocate(imageSize);
                    channel.position(entriesOffset+imageOffset+i*8);
                    dynamicImageBuffer.clear();
                    channel.read(dynamicImageBuffer);
                    dynamicImageBuffer.flip();
                    allImages.add(dynamicImageBuffer.array());
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void embWriter(Path path){
        try(FileChannel channel=FileChannel.open(path, StandardOpenOption.WRITE,StandardOpenOption.CREATE,StandardOpenOption.TRUNCATE_EXISTING)) {
            
            ByteBuffer intBuffer=ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
            ByteBuffer dynamicStringBuffer;
            ByteBuffer dynamicImageBuffer;
            int entriesOffset=32;
            int imageSizeOffset=entriesOffset+4;
            int filesOffset=32+allEntries.size()*8;
            int absoluteDataStart=32+allEntries.size()*12;
            int byteBoundary64=64;
            while (((float) byteBoundary64 / absoluteDataStart) < 1) {
                byteBoundary64+=64;
            }
            absoluteDataStart=byteBoundary64;
            int imageOffset=absoluteDataStart-32;
            // int imageSize;

            //writing magic
            channel.write(ByteBuffer.wrap(new byte[]{0x23,0x45,(byte)0x4D,0x42}));

            //writing endinanes
            channel.position(4);
            channel.write(ByteBuffer.wrap(new byte[]{(byte)0xFE,(byte)0xFF}));

            //writing header size 
            channel.position(6);
            channel.write(ByteBuffer.wrap(new byte[]{0x20,0x00}));

            channel.position(8);
            intBuffer.clear();
            intBuffer.putInt(i08);
            intBuffer.flip();
            channel.write(intBuffer);

            channel.position(12);
            intBuffer.clear();
            intBuffer.putInt(allEntries.size());
            intBuffer.flip();
            channel.write(intBuffer);
            
            channel.position(24);
            intBuffer.clear();
            intBuffer.putInt(entriesOffset);
            intBuffer.flip();
            channel.write(intBuffer);
            if(isPortrait){
                int fileNamesOffset=absoluteDataStart+allImages.stream().mapToInt(arr -> arr.length).sum();

                channel.position(28);
                intBuffer.clear();
                intBuffer.putInt(filesOffset);
                intBuffer.flip();
                channel.write(intBuffer);
                for(int i=0;i<allEntries.size();i++){
                    channel.position(filesOffset+i*4);
                    intBuffer.clear();
                    intBuffer.putInt(fileNamesOffset);
                    intBuffer.flip();
                    channel.write(intBuffer);
                    
                    dynamicStringBuffer=ByteBuffer.allocate(allEntries.get(i).length());
                    channel.position(fileNamesOffset);
                    dynamicStringBuffer.clear();
                    dynamicStringBuffer=ByteBuffer.wrap(allEntries.get(i).getBytes());
                    channel.write(dynamicStringBuffer);

                    channel.position(entriesOffset+i*8);
                    intBuffer.clear();
                    intBuffer.putInt(imageOffset-i*8);
                    intBuffer.flip();
                    channel.write(intBuffer);

                    channel.position(imageSizeOffset+i*8);
                    intBuffer.clear();
                    intBuffer.putInt(allImages.get(i).length);
                    intBuffer.flip();
                    channel.write(intBuffer);

                    dynamicImageBuffer=ByteBuffer.allocate(allImages.get(i).length);
                    channel.position(absoluteDataStart);
                    dynamicImageBuffer.clear();
                    dynamicImageBuffer=ByteBuffer.wrap(allImages.get(i));
                    channel.write(dynamicImageBuffer);

                    fileNamesOffset+=allEntries.get(i).length();
                    absoluteDataStart+=allImages.get(i).length;
                    imageOffset+=(allImages.get(i).length);
                }

            }
            else{
               for(int i=0;i<allEntries.size();i++){
                    channel.position(entriesOffset+i*8);
                    intBuffer.clear();
                    intBuffer.putInt(imageOffset-i*8);
                    intBuffer.flip();
                    channel.write(intBuffer);

                    channel.position(imageSizeOffset+i*8);
                    intBuffer.clear();
                    intBuffer.putInt(allImages.get(i).length);
                    intBuffer.flip();
                    channel.write(intBuffer);

                    dynamicImageBuffer=ByteBuffer.allocate(allImages.get(i).length);
                    channel.position(absoluteDataStart);
                    dynamicImageBuffer.clear();
                    dynamicImageBuffer=ByteBuffer.wrap(allImages.get(i));
                    channel.write(dynamicImageBuffer);

                    absoluteDataStart+=allImages.get(i).length;
                    imageOffset+=allImages.get(i).length;
               }
                
            }
            
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
