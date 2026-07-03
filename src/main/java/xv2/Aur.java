package xv2;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Aur {
    VBox vBox = new VBox(5);
    ArrayList<String> allEntries;
    ArrayList<Integer> getI04=new ArrayList<>();
    ArrayList<Integer> getBoostStart=new ArrayList<>();
    ArrayList<Integer> getBoostLoop=new ArrayList<>();
    ArrayList<Integer> getBoostEnd=new ArrayList<>();
    ArrayList<Integer> getKiaiCharge=new ArrayList<>();
    ArrayList<Integer> getKiryokuMax=new ArrayList<>();
    ArrayList<Integer> getHenshinStart=new ArrayList<>();
    ArrayList<Integer> getHenshinEnd=new ArrayList<>();

    ArrayList<Integer> getCharaId=new ArrayList<>();
    ArrayList<Integer> getCostume=new ArrayList<>();
    ArrayList<Integer> getAuraId=new ArrayList<>();
    ArrayList<Boolean> getGlare=new ArrayList<>();

    ListView<String> listView=new ListView<>();

    HBox hBox=new HBox(10);

    //copy containers
    private int copyI04;
    private int copyBoostStart;
    private int copyBoostLoop;
    private int copyBoostEnd;
    private int copyKiaiCharge;
    private int copyKiryokuMax;
    private int copyHenshinStart;
    private int copyHenshinEnd;
    
    int characterEntries;
    
    public Aur(){
        vBox.setPadding(new Insets(5,5,5,5));
        entriesActionListener();
        entriesKeysListener();
        vBoxListener();
    }
    public SplitPane createSplitPane(){
       SplitPane splitPane =new SplitPane(createHBoxLeft(),createVBoxRight());
       splitPane.setDividerPositions(0.43);
       return splitPane;
        
    }

    private HBox createHBoxLeft(){
        VBox vBox=new VBox();
        this.hBox.getChildren().addAll(listView,vBox);
        return hBox;
    }

    private VBox createVBoxAuraId(int i){
        
        VBox auraIdVBox=new VBox(60);
        auraIdVBox.setPadding(new Insets(30,0,0,0));

        HBox i04HBox=new HBox(40);
        Label lblI04=new Label("I_04: ");
        lblI04.setPrefWidth(80);
        TextField txtI04=new TextField(String.valueOf(getI04.get(i)));
        txtI04.textProperty().addListener((obs,oldText,newText)->{
            if (txtI04.getText().contains("-")) {
                return;
            }
            try {
                getI04.set(i, Integer.parseInt(newText)); 
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        });
        i04HBox.setAlignment(Pos.CENTER_LEFT);
        i04HBox.getChildren().addAll(lblI04,txtI04);

        HBox boostStartHBox=new HBox(40);
        Label lblBoostStart=new Label("BoostStart: ");
        lblBoostStart.setPrefWidth(80);
        TextField txtBoostStart=new TextField(String.valueOf(getBoostStart.get(i)));
        txtBoostStart.textProperty().addListener((obs,oldText,newText)->{
            if (txtBoostStart.getText().contains("-")) {
                return;
            }
            try {
                getBoostStart.set(i, Integer.parseInt(newText)); 
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        });
        boostStartHBox.setAlignment(Pos.CENTER_LEFT);
        boostStartHBox.getChildren().addAll(lblBoostStart,txtBoostStart);

        HBox boostLoopHBox=new HBox(40);
        Label lblBoostLoop=new Label("BoostLoop: ");
        lblBoostLoop.setPrefWidth(80);
        TextField txtBoostLoop=new TextField(String.valueOf(getBoostLoop.get(i)));
        txtBoostLoop.textProperty().addListener((obs,oldText,newText)->{
            if (txtBoostLoop.getText().contains("-")) {
                return;
            }
            try {
                getBoostLoop.set(i, Integer.parseInt(newText)); 
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        });
        boostLoopHBox.setAlignment(Pos.CENTER_LEFT);
        boostLoopHBox.getChildren().addAll(lblBoostLoop,txtBoostLoop);

        HBox boostEndHBox=new HBox(40);
        Label lblBoostEnd=new Label("BoostEnd: ");
        lblBoostEnd.setPrefWidth(80);
        TextField txtBoostEnd=new TextField(String.valueOf(getBoostEnd.get(i)));
        txtBoostEnd.textProperty().addListener((obs,oldText,newText)->{
            if (txtBoostEnd.getText().contains("-")) {
                return;
            }
            try {
                getBoostEnd.set(i, Integer.parseInt(newText)); 
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        });
        boostEndHBox.setAlignment(Pos.CENTER_LEFT);
        boostEndHBox.getChildren().addAll(lblBoostEnd,txtBoostEnd);

        HBox kiaiChargeHBox=new HBox(40);
        Label lblKiaiCharge=new Label("KiaiCharge: ");
        lblKiaiCharge.setPrefWidth(80);
        TextField txtKiaiCharge=new TextField(String.valueOf(getKiaiCharge.get(i)));
        txtKiaiCharge.textProperty().addListener((obs,oldText,newText)->{
            if (txtKiaiCharge.getText().contains("-")) {
                return;
            }
            try {
                getKiaiCharge.set(i, Integer.parseInt(newText)); 
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        });
        kiaiChargeHBox.setAlignment(Pos.CENTER_LEFT);
        kiaiChargeHBox.getChildren().addAll(lblKiaiCharge,txtKiaiCharge);

        HBox kiryokuMaxHBox=new HBox(40);
        Label lblKiryokuMax=new Label("KiryokuMax: ");
        lblKiryokuMax.setPrefWidth(80);
        TextField txtKiryokuMax=new TextField(String.valueOf(getKiryokuMax.get(i)));
        txtKiryokuMax.textProperty().addListener((obs,oldText,newText)->{
            if (txtKiryokuMax.getText().contains("-")) {
                return;
            }
            try {
                getKiryokuMax.set(i, Integer.parseInt(newText)); 
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        });
        kiryokuMaxHBox.setAlignment(Pos.CENTER_LEFT);
        kiryokuMaxHBox.getChildren().addAll(lblKiryokuMax,txtKiryokuMax);

        HBox henshinStartHBox=new HBox(40);
        Label lblHenshinStart=new Label("HenshinStart: ");
        lblHenshinStart.setPrefWidth(80);
        TextField txtHenshinStart=new TextField(String.valueOf(getHenshinStart.get(i)));
        txtHenshinStart.textProperty().addListener((obs,oldText,newText)->{
            if (txtHenshinStart.getText().contains("-")) {
                return;
            }
            try {
                getHenshinStart.set(i, Integer.parseInt(newText)); 
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        });
        henshinStartHBox.setAlignment(Pos.CENTER_LEFT);
        henshinStartHBox.getChildren().addAll(lblHenshinStart,txtHenshinStart);

        HBox henshinEndHBox=new HBox(40);
        Label lblHenshinEnd=new Label("HenshinEnd: ");
        lblHenshinEnd.setPrefWidth(80);
        TextField txtHenshinEnd=new TextField(String.valueOf(getHenshinEnd.get(i)));
        txtHenshinEnd.textProperty().addListener((obs,oldText,newText)->{
            if (txtHenshinEnd.getText().contains("-")) {
                return;
            }
            try {
                getHenshinEnd.set(i, Integer.parseInt(newText)); 
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        });
        henshinEndHBox.setAlignment(Pos.CENTER_LEFT);
        henshinEndHBox.getChildren().addAll(lblHenshinEnd,txtHenshinEnd);

        auraIdVBox.getChildren().addAll(i04HBox,boostStartHBox,boostLoopHBox,boostEndHBox,kiaiChargeHBox,kiryokuMaxHBox,henshinStartHBox,henshinEndHBox);
        this.hBox.getChildren().add(auraIdVBox);
        
        return auraIdVBox;

    }
    private ScrollPane createScrollPane(){
        ScrollPane scrollPane=new ScrollPane();
        scrollPane.setContent(vBox);
        return scrollPane;
        
    }
    private VBox createVBoxRight(){
        VBox vBox=new VBox();
        vBox.getChildren().addAll(createToolBarRight(),createScrollPane());
        return vBox;
    }

    private ToolBar createToolBarRight(){
        Button insertEntry=new Button("Insert Chara Id");
        insertEntry.setOnAction(event->{
            getCharaId.add(0);
            getCostume.add(0);
            getAuraId.add(0);
            getGlare.add(false);
            createVBoxRightCharaId();
            characterEntries+=1;
        });

        Button removeEntry=new Button("Remove Chara Id");
        removeEntry.setOnAction(event->{
            try {
                getCharaId.remove(characterEntries-1);
                getCostume.remove(characterEntries-1);
                getAuraId.remove(characterEntries-1);
                getGlare.remove(characterEntries-1);
                vBox.getChildren().remove(characterEntries);
                characterEntries-=1;
            } catch (IndexOutOfBoundsException e) {
                Popups.ErrorOutOfBounds();
                e.printStackTrace();
            }

        });
        ToolBar toolBar=new ToolBar(
            insertEntry,
            removeEntry
        );
        return toolBar;
    }
    
    private VBox createVBoxRightCharaId(){
        HBox hBox=new HBox(10);

        Label lblCharaId=new Label("Chara Id");
        TextField txtCharaId=new TextField(String.valueOf(getCharaId.getLast()));
        txtCharaId.textProperty().addListener((obs,oldText,newText)->{
            if (txtCharaId.getText().contains("-")) {
                return;
            }
            try {
                int indexOfHBox = vBox.getChildren().indexOf(txtCharaId.getParent());
                getCharaId.set(indexOfHBox, Integer.parseInt(newText));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        });

        Label lblCostume=new Label("Costume");
        TextField txtCostume=new TextField(String.valueOf(getCostume.getLast()));
        txtCostume.textProperty().addListener((obs,oldText,newText)->{
            if (txtCharaId.getText().contains("-")) {
                return;
            }
            try {
                int indexOfHBox = vBox.getChildren().indexOf(txtCostume.getParent());
                getCostume.set(indexOfHBox, Integer.parseInt(newText));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        });

        Label lblAuraId=new Label("Aura Id");
        TextField txtAuraId=new TextField(String.valueOf(getAuraId.getLast()));
        txtAuraId.textProperty().addListener((obs,oldText,newText)->{
            if (txtAuraId.getText().contains("-")) {
                return;
            }
            try {
                int indexOfHBox = vBox.getChildren().indexOf(txtAuraId.getParent());
                getAuraId.set(indexOfHBox, Integer.parseInt(newText));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        });

        Label lblGlare=new Label("Glare");
        CheckBox glareCheckBox=new CheckBox();
        glareCheckBox.setSelected(getGlare.getLast().booleanValue());
        glareCheckBox.selectedProperty().addListener((obs,oldValue,newValue)->{
            try {
                int indexOfHBox = vBox.getChildren().indexOf(txtAuraId.getParent());
                
                getGlare.set(indexOfHBox, newValue);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

        });

        hBox.getChildren().addAll(lblCharaId,txtCharaId,lblCostume,txtCostume,lblAuraId,txtAuraId,lblGlare,glareCheckBox);
        hBox.setAlignment(Pos.CENTER_LEFT);
        vBox.getChildren().add(hBox);

        return vBox;
    }

    private void entriesActionListener(){
        listView.getSelectionModel().selectedItemProperty().addListener((obs,oldValue,newValue)->{
            if(newValue==null){
                return;
            }
            //System.out.println("entry clicked: "+listView.getSelectionModel().getSelectedIndex());
            hBox.getChildren().remove(1);
            hBox.getChildren().set(1, createVBoxAuraId(listView.getSelectionModel().getSelectedIndex()));
        });
        listView.setOnMouseClicked(e->{
            if(e.getButton()==MouseButton.SECONDARY){
                ContextMenu contextMenu=new ContextMenu();
                MenuItem copy=new MenuItem("Copy Ctrl+C");
                MenuItem paste=new MenuItem("Paste Ctrl+V");
                MenuItem delete=new MenuItem("Delete Delete");
                MenuItem append=new MenuItem("Append Ctrl+A");
                MenuItem insert=new MenuItem("Insert Ctrl+I");
                contextMenu.getItems().addAll(copy,paste,delete,append,insert);
                listView.setContextMenu(contextMenu);
                contextMenu.setOnAction(event->{
                    if(event.getTarget()==copy){
                        Copy();
                    }
                    if(event.getTarget()==paste){
                        Paste();
                    }
                    if(event.getTarget()==delete){
                       Delete();
                    }
                    if(event.getTarget()==append){
                        Append();
                    }
                    if(event.getTarget()==insert){
                        Insert();
                    }
                });
            }
        });
    }

    private void vBoxListener(){
        vBox.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> {
        });
    }

    private void entriesKeysListener(){
        listView.setOnKeyPressed(e->{
            if(e.isControlDown()&&e.getCode()==KeyCode.C){
                Copy();
            }
            if(e.isControlDown()&&e.getCode()==KeyCode.V){
                Paste();
            }
            if(e.getCode()==KeyCode.DELETE){
                Delete();
            }
            if(e.isControlDown()&&e.getCode()==KeyCode.A){
                Append();
                
            }
            if(e.isControlDown()&&e.getCode()==KeyCode.I){
                Insert();
            }
        });
    }

    private void Copy(){
        copyI04=getI04.get(listView.getSelectionModel().getSelectedIndex());
        copyBoostStart=getBoostStart.get(listView.getSelectionModel().getSelectedIndex());
        copyBoostLoop=getBoostLoop.get(listView.getSelectionModel().getSelectedIndex());
        copyBoostEnd=getBoostEnd.get(listView.getSelectionModel().getSelectedIndex());
        copyKiaiCharge=getKiaiCharge.get(listView.getSelectionModel().getSelectedIndex());
        copyKiryokuMax=getKiryokuMax.get(listView.getSelectionModel().getSelectedIndex());
        copyHenshinStart=getHenshinStart.get(listView.getSelectionModel().getSelectedIndex());
        copyHenshinEnd=getHenshinEnd.get(listView.getSelectionModel().getSelectedIndex());
    }

    private void Paste(){
        getI04.set(listView.getSelectionModel().getSelectedIndex(), copyI04);
        getBoostStart.set(listView.getSelectionModel().getSelectedIndex(), copyBoostStart);
        getBoostLoop.set(listView.getSelectionModel().getSelectedIndex(), copyBoostLoop);
        getBoostEnd.set(listView.getSelectionModel().getSelectedIndex(), copyBoostEnd);
        getKiaiCharge.set(listView.getSelectionModel().getSelectedIndex(), copyKiaiCharge);
        getKiryokuMax.set(listView.getSelectionModel().getSelectedIndex(), copyKiryokuMax);
        getHenshinStart.set(listView.getSelectionModel().getSelectedIndex(), copyHenshinStart);
        getHenshinEnd.set(listView.getSelectionModel().getSelectedIndex(), copyHenshinEnd);
        hBox.getChildren().remove(1);
        hBox.getChildren().set(1, createVBoxAuraId(listView.getSelectionModel().getSelectedIndex()));
    }

    private void Delete(){
        if(listView.getSelectionModel().getSelectedIndex() == 0) return;
        getI04.remove(listView.getSelectionModel().getSelectedIndex());
        getBoostStart.remove(listView.getSelectionModel().getSelectedIndex());
        getBoostLoop.remove(listView.getSelectionModel().getSelectedIndex());
        getBoostEnd.remove(listView.getSelectionModel().getSelectedIndex());
        getKiaiCharge.remove(listView.getSelectionModel().getSelectedIndex());
        getKiryokuMax.remove(listView.getSelectionModel().getSelectedIndex());
        getHenshinStart.remove(listView.getSelectionModel().getSelectedIndex());
        getHenshinEnd.remove(listView.getSelectionModel().getSelectedIndex());
        allEntries.remove(listView.getSelectionModel().getSelectedIndex());
        listView.getItems().remove(listView.getSelectionModel().getSelectedIndex());
        
        for(int i=0;i<listView.getItems().size();i++){
            allEntries.set(i,new String("Aura Id: "+i));
            listView.getItems().set(i,allEntries.get(i));
        }
    }

    private void Append(){
        getI04.add(listView.getSelectionModel().getSelectedIndex()+1,0);
        getBoostStart.add(listView.getSelectionModel().getSelectedIndex()+1,0);
        getBoostLoop.add(listView.getSelectionModel().getSelectedIndex()+1,0);
        getBoostEnd.add(listView.getSelectionModel().getSelectedIndex()+1,0);
        getKiaiCharge.add(listView.getSelectionModel().getSelectedIndex()+1,0);
        getKiryokuMax.add(listView.getSelectionModel().getSelectedIndex()+1,0);
        getHenshinStart.add(listView.getSelectionModel().getSelectedIndex()+1,0);
        getHenshinEnd.add(listView.getSelectionModel().getSelectedIndex()+1,0);
        allEntries.add(new String("Aura Id: "+listView.getItems().size()));
        listView.getItems().add(allEntries.getLast());
    }
    private void Insert(){
        if(listView.getSelectionModel().getSelectedIndex()>0){
            getI04.add(listView.getSelectionModel().getSelectedIndex()-1,0);
            getBoostStart.add(listView.getSelectionModel().getSelectedIndex()-1,0);
            getBoostLoop.add(listView.getSelectionModel().getSelectedIndex()-1,0);
            getBoostEnd.add(listView.getSelectionModel().getSelectedIndex()-1,0);
            getKiaiCharge.add(listView.getSelectionModel().getSelectedIndex()-1,0);
            getKiryokuMax.add(listView.getSelectionModel().getSelectedIndex()-1,0);
            getHenshinStart.add(listView.getSelectionModel().getSelectedIndex()-1,0);
            getHenshinEnd.add(listView.getSelectionModel().getSelectedIndex()-1,0);
            allEntries.add(new String("Aura Id: "+listView.getItems().size()));
            listView.getItems().add(allEntries.getLast());
        }
        else if(listView.getSelectionModel().getSelectedIndex()==0){
            getI04.add(listView.getSelectionModel().getSelectedIndex(),0);
            getBoostStart.add(listView.getSelectionModel().getSelectedIndex(),0);
            getBoostLoop.add(listView.getSelectionModel().getSelectedIndex(),0);
            getBoostEnd.add(listView.getSelectionModel().getSelectedIndex(),0);
            getKiaiCharge.add(listView.getSelectionModel().getSelectedIndex(),0);
            getKiryokuMax.add(listView.getSelectionModel().getSelectedIndex(),0);
            getHenshinStart.add(listView.getSelectionModel().getSelectedIndex(),0);
            getHenshinEnd.add(listView.getSelectionModel().getSelectedIndex(),0);
            allEntries.add(new String("Aura Id: "+listView.getItems().size()));
            listView.getItems().add(allEntries.getLast());
        }
    }

    public void aurReader(Path path){
        try(FileChannel channel=FileChannel.open(path, StandardOpenOption.READ)) {
            int auraoffset=32;
            int charaOffset=0;
            int effectsOffset=0;
            int auraEntries;
            
            ByteBuffer intBuffer=ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
            
            //reading aura entries
            channel.position(8);
            intBuffer.clear();
            channel.read(intBuffer);
            intBuffer.flip();
            auraEntries=intBuffer.getInt();

            allEntries=new ArrayList<>(auraEntries);
            for(int i=0;i<auraEntries;i++){
                allEntries.add(new String("Aura Id: "+i));
                listView.getItems().add(allEntries.get(i));
            }

            //reading character entries
            channel.position(24);
            intBuffer.clear();
            channel.read(intBuffer);
            intBuffer.flip();
            characterEntries=intBuffer.getInt();

            //reading character entries offstet
            channel.position(28);
            intBuffer.clear();
            channel.read(intBuffer);
            intBuffer.flip();
            charaOffset=intBuffer.getInt();

            for(int i=0;i<auraEntries;i++){
                //reading i04
                channel.position(auraoffset+16*i+4);
                intBuffer.clear();
                channel.read(intBuffer);
                intBuffer.flip();
                getI04.add(intBuffer.getInt());

                //reading effectOffset
                channel.position(auraoffset+16*i+12);
                intBuffer.clear();
                channel.read(intBuffer);
                intBuffer.flip();
                effectsOffset=intBuffer.getInt();

                //reading boostStart
                channel.position(effectsOffset+4);
                intBuffer.clear();
                channel.read(intBuffer);
                intBuffer.flip();
                getBoostStart.add(intBuffer.getInt());

                //reading boostLoop
                channel.position(effectsOffset+12);
                intBuffer.clear();
                channel.read(intBuffer);
                intBuffer.flip();
                getBoostLoop.add(intBuffer.getInt());

                //reading boostEnd
                channel.position(effectsOffset+20);
                intBuffer.clear();
                channel.read(intBuffer);
                intBuffer.flip();
                getBoostEnd.add(intBuffer.getInt());

                //reading kiaiCharge
                channel.position(effectsOffset+28);
                intBuffer.clear();
                channel.read(intBuffer);
                intBuffer.flip();
                getKiaiCharge.add(intBuffer.getInt());

                //reading kiryokuMax
                channel.position(effectsOffset+36);
                intBuffer.clear();
                channel.read(intBuffer);
                intBuffer.flip();
                getKiryokuMax.add(intBuffer.getInt());

                //reading HenshinStart
                channel.position(effectsOffset+44);
                intBuffer.clear();
                channel.read(intBuffer);
                intBuffer.flip();
                getHenshinStart.add(intBuffer.getInt());

                //reading HenshinEnd
                channel.position(effectsOffset+52);
                intBuffer.clear();
                channel.read(intBuffer);
                intBuffer.flip();
                getHenshinEnd.add(intBuffer.getInt());
                //System.out.println("looking at: "+(effectsOffset+52));
            }
            for(int i=0;i<characterEntries;i++){
                channel.position(charaOffset+16*i);
                intBuffer.clear();
                channel.read(intBuffer);
                intBuffer.flip();
                getCharaId.add(intBuffer.getInt());
    
                channel.position(charaOffset+16*i+4);
                intBuffer.clear();
                channel.read(intBuffer);
                intBuffer.flip();
                getCostume.add(intBuffer.getInt());

                channel.position(charaOffset+16*i+8);
                intBuffer.clear();
                channel.read(intBuffer);
                intBuffer.flip();
                getAuraId.add(intBuffer.getInt());
                
                channel.position(charaOffset+16*i+12);
                intBuffer.clear();
                channel.read(intBuffer);
                intBuffer.flip();
                getGlare.add(intBuffer.getInt()==1);
                
                createVBoxRightCharaId();
            }
            
        } catch (IOException e) {
            System.err.println(e);
            
        }
    }

    public void aurWriter(Path path){
        try(FileChannel channel=FileChannel.open(path,StandardOpenOption.WRITE,StandardOpenOption.CREATE,StandardOpenOption.TRUNCATE_EXISTING)) {
            int effectCount=7;
            int auraOffset=32;
            int auraTypeOffset=32+allEntries.size()*16+allEntries.size()*56;
            int charaOffset=32+allEntries.size()*16+allEntries.size()*56+120;
            String auraTypes =  
            "BoostStart\0" + 
            "BoostLoop\0" + 
            "BoostEnd\0" + 
            "KiaiCharge\0" + 
            "KiryokuMax\0" + 
            "HenshinStart\0" + 
            "HenshinEnd\0";

            ByteBuffer intBuffer=ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
            
            //writing magic
            channel.write(ByteBuffer.wrap(new byte[]{0x23,0x41,0x55,0x52}));
          
            //writing endinanes
            channel.position(4);
            channel.write(ByteBuffer.wrap(new byte[]{(byte)0xFE,(byte)0xFF}));
            
            //writing header size 
            channel.position(6);
            channel.write(ByteBuffer.wrap(new byte[]{0x20,0x00}));

            //writing total aura entries
            channel.position(8);
            intBuffer.clear();
            intBuffer.putInt(allEntries.size());
            intBuffer.flip();
            channel.write(intBuffer);

            //writing auraoffset 
            channel.position(12);
            intBuffer.clear();
            intBuffer.putInt(auraOffset);
            intBuffer.flip();
            channel.write(intBuffer);
            
            //writing effect count
            channel.position(16);
            intBuffer.clear();
            intBuffer.putInt(effectCount);
            intBuffer.flip();
            channel.write(intBuffer);
            
            //writing aura type offset
            channel.position(20);
            intBuffer.clear();
            intBuffer.putInt(auraTypeOffset);
            intBuffer.flip();
            channel.write(intBuffer);

            //writing character entries
            channel.position(24);
            intBuffer.clear();
            intBuffer.putInt(characterEntries);
            intBuffer.flip();
            channel.write(intBuffer);

            //writing character id offset
            channel.position(28);
            intBuffer.clear();
            intBuffer.putInt(charaOffset);
            intBuffer.flip();
            channel.write(intBuffer);

            //writing boostStart textString offset
            channel.position(auraTypeOffset);
            intBuffer.clear();
            intBuffer.putInt(auraTypeOffset+28);
            intBuffer.flip();
            channel.write(intBuffer);

            //writing boostLoop textString offset
            channel.position(auraTypeOffset+4);
            intBuffer.clear();
            intBuffer.putInt(auraTypeOffset+39);
            intBuffer.flip();
            channel.write(intBuffer);

            //writing boostEnd textString offset
            channel.position(auraTypeOffset+8);
            intBuffer.clear();
            intBuffer.putInt(auraTypeOffset+49);
            intBuffer.flip();
            channel.write(intBuffer);

            //writing kiaiCharge textString offset
            channel.position(auraTypeOffset+12);
            intBuffer.clear();
            intBuffer.putInt(auraTypeOffset+58);
            intBuffer.flip();
            channel.write(intBuffer);

            //writing kiryokuMax textString offset
            channel.position(auraTypeOffset+16);
            intBuffer.clear();
            intBuffer.putInt(auraTypeOffset+69);
            intBuffer.flip();
            channel.write(intBuffer);

            //writing henshinStart textString offset
            channel.position(auraTypeOffset+20);
            intBuffer.clear();
            intBuffer.putInt(auraTypeOffset+80);
            intBuffer.flip();
            channel.write(intBuffer);

            //writing henshinEnd textString offset
            channel.position(auraTypeOffset+24);
            intBuffer.clear();
            intBuffer.putInt(auraTypeOffset+93);
            intBuffer.flip();
            channel.write(intBuffer);

            channel.position(auraTypeOffset+28);
            channel.write(ByteBuffer.wrap(auraTypes.getBytes(StandardCharsets.ISO_8859_1)));

            for(int i=0;i<allEntries.size();i++){
                //writing aura id initial
                channel.position(auraOffset+(16*i));
                intBuffer.clear();
                intBuffer.putInt(allEntries.indexOf(allEntries.get(i)));
                intBuffer.flip();
                channel.write(intBuffer);
                
                //writing i04
                channel.position(auraOffset+(16*i)+4);
                intBuffer.clear();
                intBuffer.putInt(getI04.get(i));
                intBuffer.flip();
                channel.write(intBuffer);

                //writing effectCount
                channel.position(auraOffset+(16*i)+8);
                intBuffer.clear();
                intBuffer.putInt(effectCount);
                intBuffer.flip();
                channel.write(intBuffer);
                
                //writing effectsOffset
                channel.position(auraOffset+(16*i)+12);
                intBuffer.clear();
                intBuffer.putInt(allEntries.size()*16+32+56*i);
                intBuffer.flip();
                channel.write(intBuffer);

                //writing boostStart
                channel.position(allEntries.size()*16+32+56*i+4);
                intBuffer.clear();
                intBuffer.putInt(getBoostStart.get(i));
                intBuffer.flip();
                channel.write(intBuffer);

                //write 1
                channel.position(allEntries.size()*16+32+56*i+8);
                channel.write(ByteBuffer.wrap(new byte[]{0x01,0x00,0x00,0x00}));

                //write boostLoop
                channel.position(allEntries.size()*16+32+56*i+12);
                intBuffer.clear();
                intBuffer.putInt(getBoostLoop.get(i));
                intBuffer.flip();
                channel.write(intBuffer);

                //write 2
                channel.position(allEntries.size()*16+32+56*i+16);
                channel.write(ByteBuffer.wrap(new byte[]{0x02,0x00,0x00,0x00}));
                
                //write boostEnd
                channel.position(allEntries.size()*16+32+56*i+20);
                intBuffer.clear();
                intBuffer.putInt(getBoostEnd.get(i));
                intBuffer.flip();
                channel.write(intBuffer);

                //write 3
                channel.position(allEntries.size()*16+32+56*i+24);
                channel.write(ByteBuffer.wrap(new byte[]{0x03,0x00,0x00,0x00}));

                //write kiai charge
                channel.position(allEntries.size()*16+32+56*i+28);
                intBuffer.clear();
                intBuffer.putInt(getKiaiCharge.get(i));
                intBuffer.flip();
                channel.write(intBuffer);

                //write 4
                channel.position(allEntries.size()*16+32+56*i+32);
                channel.write(ByteBuffer.wrap(new byte[]{0x04,0x00,0x00,0x00}));
                
                //write kiryoku max
                channel.position(allEntries.size()*16+32+56*i+36);
                intBuffer.clear();
                intBuffer.putInt(getKiryokuMax.get(i));
                intBuffer.flip();
                channel.write(intBuffer);

                //write 5
                channel.position(allEntries.size()*16+32+56*i+40);
                channel.write(ByteBuffer.wrap(new byte[]{0x05,0x00,0x00,0x00}));

                //werite henshin start
                channel.position(allEntries.size()*16+32+56*i+44);
                intBuffer.clear();
                intBuffer.putInt(getHenshinStart.get(i));
                intBuffer.flip();
                channel.write(intBuffer);

                //write 6
                channel.position(allEntries.size()*16+32+56*i+48);
                channel.write(ByteBuffer.wrap(new byte[]{0x06,0x00,0x00,0x00}));

                //writing henshin end
                channel.position(allEntries.size()*16+32+56*i+52);
                intBuffer.clear();
                intBuffer.putInt(getHenshinEnd.get(i));
                intBuffer.flip();
                channel.write(intBuffer);
            }
            for(int i=0;i<characterEntries;i++){
            
                channel.position(charaOffset+(16*i));
                intBuffer.clear();
                intBuffer.putInt(getCharaId.get(i));
                intBuffer.flip();
                channel.write(intBuffer);
    
                channel.position(charaOffset+(16*i)+4);
                intBuffer.clear();
                intBuffer.putInt(getCostume.get(i));
                intBuffer.flip();
                channel.write(intBuffer);

                channel.position(charaOffset+(16*i)+8);
                intBuffer.clear();
                intBuffer.putInt(getAuraId.get(i));
                intBuffer.flip();
                channel.write(intBuffer);

                channel.position(charaOffset+(16*i)+12);
                intBuffer.clear();
                intBuffer.putInt(getGlare.get(i)?1:0);
                intBuffer.flip();
                channel.write(intBuffer);
            }
        } catch (IOException e) {
            System.err.println(e);
            Popups.ErrorSave(path.toFile().getName());   
        }
    }
}
