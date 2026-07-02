package xv2;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import static xv2.BinaryUtilities.toUShort;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Bdm {

    Bdm(){
        entriesActionListener();
        entriesKeysListener();
        tabActionListener();
    }

    ArrayList <String> allEntries;
    ListView <String> listView=new ListView<>();
    TabPane mainTabPane =new TabPane();

    ArrayList <int[]> getDamageType=new ArrayList<>(); 
    ArrayList <int[]> getI02=new ArrayList<>();
    ArrayList <int[]> getDamageAmount= new ArrayList<>();
    ArrayList <int[]> getI06=new ArrayList<>();
    ArrayList <double[]> getF08=new ArrayList<>();
    ArrayList <int[]> getAcbType=new ArrayList<>();
    ArrayList <short[]> getCueId= new ArrayList<>();
    ArrayList <short[]> getEffect1Id=new ArrayList<>();
    ArrayList <int[]> getEffect1SkillId= new ArrayList<>();
    ArrayList <int[]> getEffect1EepkType =new ArrayList<>();
    ArrayList <int[]> getI22=new ArrayList<>();
    ArrayList <short[]> getEffect2Id=new ArrayList<>();
    ArrayList <int[]> getEffect2SkillId= new ArrayList<>();
    ArrayList <int[]> getEffect2EepkType =new ArrayList<>();
    ArrayList <int[]> getI30=new ArrayList<>();
    ArrayList <short[]> getEffect3Id=new ArrayList<>();
    ArrayList <int[]> getEffect3SkillId= new ArrayList<>();
    ArrayList <int[]> getEffect3EepkType =new ArrayList<>();
    ArrayList <int[]> getI38=new ArrayList<>();
    ArrayList <double[]> getPushbackStrength =new ArrayList<>();
    ArrayList <double[]> getPushbackAcceleration =new ArrayList<>();
    ArrayList <int []> getUserStunt =new ArrayList<>();
    ArrayList <int []> getKnockbackDuration =new ArrayList<>();
    ArrayList <int []> getKnockbackRecoveryAfterImpactTime =new ArrayList<>();
    ArrayList <int []> getKnockbackGroundImpactTime =new ArrayList<>();
    ArrayList <int []> getI58 =new ArrayList<>();
    ArrayList <int []> getVictimStunt =new ArrayList<>();
    ArrayList <double[]> getKnockbackStrengthX=new ArrayList<>();
    ArrayList <double[]> getKnockbackStrengthY=new ArrayList<>();
    ArrayList <double[]> getKnockbackStrengthZ=new ArrayList<>();
    ArrayList <double[]> getKnockbackDragY=new ArrayList<>();
    ArrayList <int[]> getI76=new ArrayList<>();
    ArrayList <int[]> getKnockbackGravityTime=new ArrayList<>();
    ArrayList <short[]> getVictimInvincibilityTime=new ArrayList<>();
    ArrayList <int[]> getI82=new ArrayList<>();
    ArrayList <int[]> getTransformationType=new ArrayList<>();
    ArrayList <short[]> getAlimentType=new ArrayList<>();
    ArrayList <int[]> getI88=new ArrayList<>();
    ArrayList <int[]> getI90=new ArrayList<>();
    ArrayList <int[]> getI92=new ArrayList<>();
    ArrayList <int[]> getDamageSpecial= new ArrayList<>();
    ArrayList <int[]> getDamageSpecial2= new ArrayList<>();
    ArrayList <int[]> getDamageSpecial3= new ArrayList<>();
    ArrayList <int[]> getStumbleType=new ArrayList<>();
    ArrayList <int[]> getSecondaryType=new ArrayList<>();
    ArrayList <short[]> getCameraShakeType=new ArrayList<>();
    ArrayList <int[]> getCameraShakeTime=new ArrayList<>();
    ArrayList <short[]> getUserBpeID=new ArrayList<>();
    ArrayList <short[]> getVictimBpeID=new ArrayList<>();
    ArrayList <short[]> getStaminaBrokenOverrideBdmId = new ArrayList<>();
    ArrayList <int []> getZVanishEnableTime = new ArrayList<>();
    ArrayList <int[]> getUserAnimationTime = new ArrayList<>();
    ArrayList <int[]> getVictimAnimationTime=new ArrayList<>();
    ArrayList <double[]> getUserAnimationSpeed = new ArrayList<>();
    ArrayList <double[]> getVictimAnimationSpeed =new ArrayList<>();
    
    //copy containers
    private int[] copyDamageType;
    private int[] copyI02;
    private int[] copyDamageAmount;
    private int[] copyI06;
    private double[] copyF08;
    private int[] copyAcbType;
    private short[] copyCueId;
    private short[] copyEffect1Id;
    private int[] copyEffect1SkillId;
    private int[] copyEffect1EepkType;
    private int[] copyI22;
    private short[] copyEffect2Id;
    private int[] copyEffect2SkillId;
    private int[] copyEffect2EepkType;
    private int[] copyI30;
    private short[] copyEffect3Id;
    private int[] copyEffect3SkillId;
    private int[] copyEffect3EepkType;
    private int[] copyI38;
    private double[] copyPushbackStrength;
    private double[] copyPushbackAcceleration;
    private int[] copyUserStunt;
    private int[] copyKnockbackDuration;
    private int[] copyKnockbackRecoveryAfterImpactTime;
    private int[] copyKnockbackGroundImpactTime;
    private int[] copyI58;
    private int[] copyVictimStunt;
    private double[] copyKnockbackStrengthX;
    private double[] copyKnockbackStrengthY;
    private double[] copyKnockbackStrengthZ;
    private double[] copyKnockbackDragY;
    private int[] copyI76;
    private int[] copyKnockbackGravityTime;
    private short[] copyVictimInvincibilityTime;
    private int[] copyI82;
    private int[] copyTransformationType;
    private short[] copyAlimentType;
    private int[] copyI88;
    private int[] copyI90;
    private int[] copyI92;
    private int[] copyDamageSpecial;
    private int[] copyDamageSpecial2;
    private int[] copyDamageSpecial3;
    private int[] copyStumbleType;
    private int[] copySecondaryType;
    private short[] copyCameraShakeType;
    private int[] copyCameraShakeTime;
    private short[] copyUserBpeID;
    private short[] copyVictimBpeID;
    private short[] copyStaminaBrokenOverrideBdmId;
    private int[] copyZVanishEnableTime;
    private int[] copyUserAnimationTime;
    private int[] copyVictimAnimationTime;
    private double[] copyUserAnimationSpeed;
    private double[] copyVictimAnimationSpeed;


    public HBox createHBox(){
        createMainTabPane();
        createSubTabPane();
        HBox hBox=new HBox(listView,mainTabPane);
        HBox.setHgrow(mainTabPane, Priority.ALWAYS);
        String css = getClass().getResource("/style.css").toExternalForm();
        hBox.getStylesheets().add(css); 
        return hBox;
    }

    public void createMainTabPane(){
        if (mainTabPane.getTabs().isEmpty()) {
            
            Tab defaultTab = new Tab("0: Default");
            Tab counterHitFrontTab = new Tab("1: Counter Hit (Front)");
            Tab primaryKnockbackTab = new Tab("2: Primary Knockback");
            Tab backTab = new Tab("3: Back");
            Tab groundImpactTab = new Tab("4: Ground Impact");
            Tab guardingTab=new Tab("5: Guarding");
            Tab stumbleTab=new Tab("6: Stumble");
            Tab counterHitBackTab = new Tab("7: Counter Hit (Back)");
            Tab floatingKnockbackTab=new Tab("8: Floating Knockback");
            Tab lyingOnGroundTab=new Tab("9: Lying On Ground");

            defaultTab.setClosable(false);
            counterHitFrontTab.setClosable(false);
            primaryKnockbackTab.setClosable(false);
            backTab.setClosable(false);
            groundImpactTab.setClosable(false);
            guardingTab.setClosable(false);
            stumbleTab.setClosable(false);
            counterHitBackTab.setClosable(false);
            floatingKnockbackTab.setClosable(false);
            lyingOnGroundTab.setClosable(false);

            defaultTab.setContent(createSubTabPane());
            counterHitFrontTab.setContent(createSubTabPane());
            primaryKnockbackTab.setContent(createSubTabPane());
            backTab.setContent(createSubTabPane());
            groundImpactTab.setContent(createSubTabPane());
            guardingTab.setContent(createSubTabPane());
            stumbleTab.setContent(createSubTabPane());
            counterHitBackTab.setContent(createSubTabPane());
            floatingKnockbackTab.setContent(createSubTabPane());
            lyingOnGroundTab.setContent(createSubTabPane());


            mainTabPane.getTabs().addAll(defaultTab, counterHitFrontTab, primaryKnockbackTab, backTab, groundImpactTab,guardingTab,stumbleTab,counterHitBackTab,floatingKnockbackTab,lyingOnGroundTab);
            
        }

    }

    public TabPane createSubTabPane(){
        TabPane subTabPane = new TabPane();
        

        Tab mainTab=new Tab("Main");
        Tab animationTab=new Tab("Animation");
        Tab soundTab=new Tab("Sound");
        Tab effectsTab=new Tab("Effects");
        Tab pushbackStunKnockbacTab=new Tab("Pushback/Stun/Knockback");
        Tab cameraTab=new Tab("Camera");
        Tab miscTab=new Tab("Misc");
        Tab unknownTab=new Tab("Unknown");

        mainTab.setClosable(false);
        animationTab.setClosable(false);
        soundTab.setClosable(false);
        effectsTab.setClosable(false);
        pushbackStunKnockbacTab.setClosable(false);
        cameraTab.setClosable(false);
        miscTab.setClosable(false);
        unknownTab.setClosable(false);
    
        subTabPane.getTabs().addAll(mainTab,animationTab,soundTab,effectsTab,pushbackStunKnockbacTab,cameraTab,miscTab,unknownTab);
        return subTabPane;
    }

    private VBox createMainVBox(int i, int j){

        VBox mainVBox=new VBox(20);
        mainVBox.setPadding(new Insets(20,0,0,5));

        //damage type
        HBox damageTypeHBox=new HBox(2);
        damageTypeHBox.setPadding(new Insets(20,0,0,8));

        Label damageTypeLabel=new Label("Damage Type");
        damageTypeLabel.setPrefWidth(160);

        GridPane damageTypeGridPane=new GridPane();
        damageTypeGridPane.getStyleClass().add("titled-address-box");
        damageTypeGridPane.setHgap(10);
        damageTypeGridPane.setVgap(10);

        ToggleGroup damageTypeToggleGroup=new ToggleGroup();
        RadioButton noEffect=new RadioButton("No Effect");
        noEffect.setToggleGroup(damageTypeToggleGroup);
        RadioButton block=new RadioButton("Block");
        block.setToggleGroup(damageTypeToggleGroup);
        RadioButton guardBreak=new RadioButton("Guard Break");
        guardBreak.setToggleGroup(damageTypeToggleGroup);
        RadioButton standard =new RadioButton("Standard");
        standard.setToggleGroup(damageTypeToggleGroup);
        RadioButton heavy=new RadioButton("Heavy");
        heavy.setToggleGroup(damageTypeToggleGroup);
        RadioButton knockback = new RadioButton("Knockback");
        knockback.setToggleGroup(damageTypeToggleGroup);
        RadioButton knockback1 = new RadioButton("Knockback 1");
        knockback1.setToggleGroup(damageTypeToggleGroup);
        RadioButton knockback2 = new RadioButton("Knockback 2");
        knockback2.setToggleGroup(damageTypeToggleGroup);
        RadioButton knockback3 = new RadioButton("Knockback 3");
        knockback3.setToggleGroup(damageTypeToggleGroup);
        RadioButton knockback4 = new RadioButton("Knockback 4");
        knockback4.setToggleGroup(damageTypeToggleGroup);
        RadioButton grab = new RadioButton("Grab");
        grab.setToggleGroup(damageTypeToggleGroup);
        RadioButton holdStomach = new RadioButton("Hold Stomach");
        holdStomach.setToggleGroup(damageTypeToggleGroup);
        RadioButton holdEyes = new RadioButton("Hold Eyes");
        holdEyes.setToggleGroup(damageTypeToggleGroup);
        RadioButton knockback5 = new RadioButton("Knockback 5");
        knockback5.setToggleGroup(damageTypeToggleGroup);
        RadioButton electric = new RadioButton("Electric");
        electric.setToggleGroup(damageTypeToggleGroup);
        RadioButton dazed = new RadioButton("Dazed");
        dazed.setToggleGroup(damageTypeToggleGroup);
        RadioButton paralysis = new RadioButton("Paralysis");
        paralysis.setToggleGroup(damageTypeToggleGroup);
        RadioButton freeze = new RadioButton("Freeze");
        freeze.setToggleGroup(damageTypeToggleGroup);
        RadioButton wildCard = new RadioButton("Wild-Card");
        wildCard.setToggleGroup(damageTypeToggleGroup);
        RadioButton unused = new RadioButton("Unused");
        unused.setToggleGroup(damageTypeToggleGroup);
        RadioButton heavyStaminaBreak = new RadioButton("Heavy Stamina Break");
        heavyStaminaBreak.setToggleGroup(damageTypeToggleGroup);
        RadioButton lightStaminaBreak = new RadioButton("Light Stamina Break");
        lightStaminaBreak.setToggleGroup(damageTypeToggleGroup);
        RadioButton giganticKiBlastPush = new RadioButton("Gigantic Ki Blast Push");
        giganticKiBlastPush.setToggleGroup(damageTypeToggleGroup);
        RadioButton brainWash = new RadioButton("Brain Wash");
        brainWash.setToggleGroup(damageTypeToggleGroup);
        RadioButton giganticKiBlastReturn = new RadioButton("Gigantic Ki Blast Return");
        giganticKiBlastReturn.setToggleGroup(damageTypeToggleGroup);
        RadioButton knockback6 = new RadioButton("Knockback 6");
        knockback6.setToggleGroup(damageTypeToggleGroup);
        RadioButton knockback7 = new RadioButton("Knockback 7");
        knockback7.setToggleGroup(damageTypeToggleGroup);
        RadioButton knockback8 = new RadioButton("Knockback 8");
        knockback8.setToggleGroup(damageTypeToggleGroup);
        RadioButton knockback9 = new RadioButton("Knockback 9");
        knockback9.setToggleGroup(damageTypeToggleGroup);
        RadioButton slowOpponent = new RadioButton("Slow Opponent");
        slowOpponent.setToggleGroup(damageTypeToggleGroup);
        RadioButton brainWash2 = new RadioButton("Brain Wash 2");
        brainWash2.setToggleGroup(damageTypeToggleGroup);
        RadioButton timeStop = new RadioButton("Time Stop");
        timeStop.setToggleGroup(damageTypeToggleGroup);
        
        switch (getDamageType.get(i)[j]) {
            case 1:  block.setSelected(true);                 break;
            case 2:  guardBreak.setSelected(true);            break;
            case 3:  standard.setSelected(true);              break;
            case 4:  heavy.setSelected(true);                 break;
            case 5:  knockback.setSelected(true);             break;
            case 6:  knockback1.setSelected(true);            break;
            case 7:  knockback2.setSelected(true);            break;
            case 8:  knockback3.setSelected(true);            break;
            case 9:  knockback4.setSelected(true);            break;
            case 10: grab.setSelected(true);                  break;
            case 11: holdStomach.setSelected(true);           break;
            case 12: holdEyes.setSelected(true);              break;
            case 13: knockback5.setSelected(true);            break;
            case 14: electric.setSelected(true);              break;
            case 15: dazed.setSelected(true);                 break;
            case 16: paralysis.setSelected(true);             break;
            case 17: freeze.setSelected(true);                break;
            case 18: wildCard.setSelected(true);              break;
            case 19: unused.setSelected(true);                break;
            case 20: heavyStaminaBreak.setSelected(true);     break;
            case 21: lightStaminaBreak.setSelected(true);     break;
            case 22: giganticKiBlastPush.setSelected(true);   break;
            case 23: brainWash.setSelected(true);             break;
            case 24: giganticKiBlastReturn.setSelected(true); break;
            case 25: knockback6.setSelected(true);            break;
            case 26: knockback7.setSelected(true);            break;
            case 27: knockback8.setSelected(true);            break;
            case 28: knockback9.setSelected(true);            break;
            case 29: slowOpponent.setSelected(true);          break;
            case 30: brainWash2.setSelected(true);            break;
            case 31: timeStop.setSelected(true);              break;
            default: noEffect.setSelected(true);              break;
        }

        damageTypeToggleGroup.selectedToggleProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue != null && newValue.isSelected()) {
                RadioButton selectedRadio = (RadioButton) newValue;
                
                if (selectedRadio == noEffect)                  { getDamageType.get(i)[j] = 0; }
                else if (selectedRadio == block)                { getDamageType.get(i)[j] = 1; }
                else if (selectedRadio == guardBreak)           { getDamageType.get(i)[j] = 2; }
                else if (selectedRadio == standard)             { getDamageType.get(i)[j] = 3; }
                else if (selectedRadio == heavy)                { getDamageType.get(i)[j] = 4; }
                else if (selectedRadio == knockback)            { getDamageType.get(i)[j] = 5; }
                else if (selectedRadio == knockback1)           { getDamageType.get(i)[j] = 6; }
                else if (selectedRadio == knockback2)           { getDamageType.get(i)[j] = 7; }
                else if (selectedRadio == knockback3)           { getDamageType.get(i)[j] = 8; }
                else if (selectedRadio == knockback4)           { getDamageType.get(i)[j] = 9; }
                else if (selectedRadio == grab)                 { getDamageType.get(i)[j] = 10; }
                else if (selectedRadio == holdStomach)          { getDamageType.get(i)[j] = 11; }
                else if (selectedRadio == holdEyes)             { getDamageType.get(i)[j] = 12; }
                else if (selectedRadio == knockback5)           { getDamageType.get(i)[j] = 13; }
                else if (selectedRadio == electric)             { getDamageType.get(i)[j] = 14; }
                else if (selectedRadio == dazed)                { getDamageType.get(i)[j] = 15; }
                else if (selectedRadio == paralysis)            { getDamageType.get(i)[j] = 16; }
                else if (selectedRadio == freeze)               { getDamageType.get(i)[j] = 17; }
                else if (selectedRadio == wildCard)             { getDamageType.get(i)[j] = 18; }
                else if (selectedRadio == unused)               { getDamageType.get(i)[j] = 19; }
                else if (selectedRadio == heavyStaminaBreak)    { getDamageType.get(i)[j] = 20; }
                else if (selectedRadio == lightStaminaBreak)    { getDamageType.get(i)[j] = 21; }
                else if (selectedRadio == giganticKiBlastPush)  { getDamageType.get(i)[j] = 22; }
                else if (selectedRadio == brainWash)            { getDamageType.get(i)[j] = 23; }
                else if (selectedRadio == giganticKiBlastReturn){ getDamageType.get(i)[j] = 24; }
                else if (selectedRadio == knockback6)           { getDamageType.get(i)[j] = 25; }
                else if (selectedRadio == knockback7)           { getDamageType.get(i)[j] = 26; }
                else if (selectedRadio == knockback8)           { getDamageType.get(i)[j] = 27; }
                else if (selectedRadio == knockback9)           { getDamageType.get(i)[j] = 28; }
                else if (selectedRadio == slowOpponent)         { getDamageType.get(i)[j] = 29; }
                else if (selectedRadio == brainWash2)           { getDamageType.get(i)[j] = 30; }
                else if (selectedRadio == timeStop)             { getDamageType.get(i)[j] = 31; }
            }
        });

        damageTypeGridPane.add(noEffect, 0, 0);   
        damageTypeGridPane.add(block, 1, 0);          
        damageTypeGridPane.add(guardBreak, 2, 0);          
        damageTypeGridPane.add(standard, 3, 0);          

        damageTypeGridPane.add(heavy, 0, 1);          
        damageTypeGridPane.add(knockback, 1, 1);          
        damageTypeGridPane.add(knockback1, 2, 1);          
        damageTypeGridPane.add(knockback2, 3, 1);          

        damageTypeGridPane.add(knockback3, 0, 2);          
        damageTypeGridPane.add(knockback4, 1, 2);   
        damageTypeGridPane.add(grab, 2, 2);
        damageTypeGridPane.add(holdStomach, 3, 2);

        damageTypeGridPane.add(holdEyes, 0, 3);
        damageTypeGridPane.add(knockback5, 1, 3);
        damageTypeGridPane.add(electric, 2, 3);
        damageTypeGridPane.add(dazed, 3, 3);

        damageTypeGridPane.add(paralysis, 0, 4);
        damageTypeGridPane.add(freeze, 1, 4);
        damageTypeGridPane.add(wildCard, 2, 4);
        damageTypeGridPane.add(unused, 3, 4);

        damageTypeGridPane.add(heavyStaminaBreak, 0, 5);
        damageTypeGridPane.add(lightStaminaBreak, 1, 5);
        damageTypeGridPane.add(giganticKiBlastPush, 2, 5);
        damageTypeGridPane.add(brainWash, 3, 5);

        damageTypeGridPane.add(giganticKiBlastReturn, 0, 6);
        damageTypeGridPane.add(knockback6, 1, 6);
        damageTypeGridPane.add(knockback7, 2, 6);
        damageTypeGridPane.add(knockback8, 3, 6);

        damageTypeGridPane.add(knockback9, 0, 7);
        damageTypeGridPane.add(slowOpponent, 1, 7);
        damageTypeGridPane.add(brainWash2, 2, 7);
        damageTypeGridPane.add(timeStop, 3, 7);
        
        damageTypeHBox.getChildren().addAll(damageTypeLabel,damageTypeGridPane);
        damageTypeHBox.setAlignment(Pos.CENTER_LEFT);
        //damage type

        //secondary type
        HBox secondaryTypeHBox=new HBox(2);
        secondaryTypeHBox.setPadding(new Insets(20,0,0,8));

        Label secondaryTypeLabel=new Label("Secondary Type");
        secondaryTypeLabel.setPrefWidth(160);

        //health properties
        Label healthPropertiesLabel=new Label("Health Properties");
        healthPropertiesLabel.getStyleClass().add("titled-address-label");

        CheckBox restoreHealth=new CheckBox("Restore Health");
        CheckBox unknown2=new CheckBox("Unknown2");
        CheckBox unknown3=new CheckBox("Unknown3");
        CheckBox unknown4= new CheckBox("Unknown4");

        restoreHealth.setSelected((getSecondaryType.get(i)[j] & 1) != 0);
        unknown2.setSelected((getSecondaryType.get(i)[j] & 2) != 0);
        unknown3.setSelected((getSecondaryType.get(i)[j] & 4) != 0);
        unknown4.setSelected((getSecondaryType.get(i)[j] & 8) != 0);

        restoreHealth.selectedProperty().addListener((obs,oldValue,newValue)->{
            if(newValue){
                getSecondaryType.get(i)[j]|=1;
            }
            else{
                getSecondaryType.get(i)[j]&=~1;
            }
        });
        unknown2.selectedProperty().addListener((obs,oldValue,newValue)->{
            if(newValue){
                getSecondaryType.get(i)[j]|=2;
            }
            else{
                getSecondaryType.get(i)[j]&=~2;
            }
        });
        unknown3.selectedProperty().addListener((obs,oldValue,newValue)->{
            if(newValue){
                getSecondaryType.get(i)[j]|=4;
            }
            else{
                getSecondaryType.get(i)[j]&=~4;
            }
        });
        unknown4.selectedProperty().addListener((obs,oldValue,newValue)->{
            if(newValue){
                getSecondaryType.get(i)[j]|=8;
            }
            else{
                getSecondaryType.get(i)[j]&=~8;
            }
        });
        VBox healthPropertiesBox = new VBox(2,restoreHealth,unknown2,unknown3,unknown4);

        VBox borderContainerHealthProperties=new VBox(healthPropertiesBox);
        borderContainerHealthProperties.getStyleClass().add("titled-address-box");
        borderContainerHealthProperties.setPadding(new Insets(12,0,0,0));

        StackPane healthPropertiesBoxStackPane = new StackPane();
        healthPropertiesBoxStackPane.getChildren().addAll(borderContainerHealthProperties,healthPropertiesLabel);

        StackPane.setAlignment(healthPropertiesLabel, Pos.TOP_LEFT);
        healthPropertiesLabel.setTranslateY(-8); 
        healthPropertiesLabel.setTranslateX(10);
        //health properties

        //unknown
        Label unknownLabel = new Label("Unknown");
        unknownLabel.getStyleClass().add("titled-address-label");

        CheckBox unknown5=new CheckBox("Unknown 5");
        CheckBox unknown6=new CheckBox("Unknown 6");
        CheckBox unknown7=new CheckBox("Unknown 7");
        CheckBox unknown8=new CheckBox("Unknown 8");


        unknown5.setSelected((getSecondaryType.get(i)[j] & 16L) != 0);
        unknown6.setSelected((getSecondaryType.get(i)[j] & 32L) != 0);
        unknown7.setSelected((getSecondaryType.get(i)[j] & 64L) != 0);
        unknown8.setSelected((getSecondaryType.get(i)[j] & 128L) != 0);


        unknown5.selectedProperty().addListener((obs,oldValue,newValue)->{
            if(newValue){
                getSecondaryType.get(i)[j]|=16;
            }
            else{
                getSecondaryType.get(i)[j]&=~16;
            }
        });
        unknown6.selectedProperty().addListener((obs,oldValue,newValue)->{
            if(newValue){
                getSecondaryType.get(i)[j]|=32;
            }
            else{
                getSecondaryType.get(i)[j]&=~32;
            }
        });
        unknown7.selectedProperty().addListener((obs,oldValue,newValue)->{
            if(newValue){
                getSecondaryType.get(i)[j]|=64;
            }
            else{
                getSecondaryType.get(i)[j]&=~64;
            }
        });
        unknown8.selectedProperty().addListener((obs,oldValue,newValue)->{
            if(newValue){
                getSecondaryType.get(i)[j]|=128;
            }
            else{
                getSecondaryType.get(i)[j]&=~128;
            }
        });
        VBox unknownVBox = new VBox(2,unknown5,unknown6,unknown7,unknown8);

        VBox borderContainerunknown=new VBox(unknownVBox);
        borderContainerunknown.getStyleClass().add("titled-address-box");
        borderContainerunknown.setPadding(new Insets(12,0,0,0));

        StackPane unknownStackPane = new StackPane();
        unknownStackPane.getChildren().addAll(borderContainerunknown,unknownLabel);

        StackPane.setAlignment(unknownLabel, Pos.TOP_LEFT);
        unknownLabel.setTranslateY(-8); 
        unknownLabel.setTranslateX(10);
        //unknown

        //damage properties
        Label damagePropertiesLabel = new Label("Damage Priorities");
        damagePropertiesLabel.getStyleClass().add("titled-address-label");

        CheckBox disableEvasiveUsage=new CheckBox("Disable Evasive Usage");
        CheckBox unknown10=new CheckBox("Unknown 10");
        CheckBox bypassTimeStopDamage=new CheckBox("Bypass Time Stop Damage");
        CheckBox bypassSuperArmor=new CheckBox("Bypass Super Armor");


        disableEvasiveUsage.setSelected((getSecondaryType.get(i)[j] & 256) != 0);
        unknown10.setSelected((getSecondaryType.get(i)[j] & 512) != 0);
        bypassTimeStopDamage.setSelected((getSecondaryType.get(i)[j] & 1024) != 0);
        bypassSuperArmor.setSelected((getSecondaryType.get(i)[j] & 2048) != 0);


        disableEvasiveUsage.selectedProperty().addListener((obs,oldValue,newValue)->{
            if(newValue){
                getSecondaryType.get(i)[j]|=256;
            }
            else{
                getSecondaryType.get(i)[j]&=~256;
            }
        });
        unknown10.selectedProperty().addListener((obs,oldValue,newValue)->{
            if(newValue){
                getSecondaryType.get(i)[j]|=512;
            }
            else{
                getSecondaryType.get(i)[j]&=~512;
            }
        });
        bypassTimeStopDamage.selectedProperty().addListener((obs,oldValue,newValue)->{
            if(newValue){
                getSecondaryType.get(i)[j]|=1024;
            }
            else{
                getSecondaryType.get(i)[j]&=~1024;
            }
        });
        bypassSuperArmor.selectedProperty().addListener((obs,oldValue,newValue)->{
            if(newValue){
                getSecondaryType.get(i)[j]|=2048;
            }
            else{
                getSecondaryType.get(i)[j]&=~2048;
            }
        });
        VBox damagePropertiesBox = new VBox(2,disableEvasiveUsage,unknown10,bypassTimeStopDamage,bypassSuperArmor);

        VBox borderContainerDamageProperties=new VBox(damagePropertiesBox);
        borderContainerDamageProperties.getStyleClass().add("titled-address-box");
        borderContainerDamageProperties.setPadding(new Insets(12,0,0,0));

        StackPane damagePropertiesStackPane = new StackPane();
        damagePropertiesStackPane.getChildren().addAll(borderContainerDamageProperties,damagePropertiesLabel);

        StackPane.setAlignment(damagePropertiesLabel, Pos.TOP_LEFT);
        damagePropertiesLabel.setTranslateY(-8); 
        damagePropertiesLabel.setTranslateX(10);
        //damage properties

        //damage orientation
        Label damageOrientationLabel = new Label("Damage Orientation");
        damageOrientationLabel.getStyleClass().add("titled-address-label");

        CheckBox faceOpponentAlways=new CheckBox("Face Opponent Always");
        CheckBox unknown14=new CheckBox("Unknown 14");
        CheckBox unknown15=new CheckBox("Unknown 15");
        CheckBox unknown16=new CheckBox("Unknown 16");


        faceOpponentAlways.setSelected((getSecondaryType.get(i)[j] & 4096) != 0);
        unknown14.setSelected((getSecondaryType.get(i)[j] & 8192) != 0);
        unknown15.setSelected((getSecondaryType.get(i)[j] & 16384) != 0);
        unknown16.setSelected((getSecondaryType.get(i)[j] & 2048) != 0);


        faceOpponentAlways.selectedProperty().addListener((obs,oldValue,newValue)->{
            if(newValue){
                getSecondaryType.get(i)[j]|=4096;
            }
            else{
                getSecondaryType.get(i)[j]&=~4096;
            }
        });
        unknown14.selectedProperty().addListener((obs,oldValue,newValue)->{
            if(newValue){
                getSecondaryType.get(i)[j]|=8192;
            }
            else{
                getSecondaryType.get(i)[j]&=~8192;
            }
        });
        unknown15.selectedProperty().addListener((obs,oldValue,newValue)->{
            if(newValue){
                getSecondaryType.get(i)[j]|=16384;
            }
            else{
                getSecondaryType.get(i)[j]&=~16384;
            }
        });
        unknown16.selectedProperty().addListener((obs,oldValue,newValue)->{
            if(newValue){
                getSecondaryType.get(i)[j]|=32768;
            }
            else{
                getSecondaryType.get(i)[j]&=~32768;
            }
        });
        VBox damageOrientationBox = new VBox(2,faceOpponentAlways,unknown14,unknown15,unknown16);

        VBox borderContainerDamageOrientation=new VBox(damageOrientationBox);
        borderContainerDamageOrientation.getStyleClass().add("titled-address-box");
        borderContainerDamageOrientation.setPadding(new Insets(12,0,0,0));

        StackPane damageOrientationStackPane = new StackPane();
        damageOrientationStackPane.getChildren().addAll(borderContainerDamageOrientation,damageOrientationLabel);

        StackPane.setAlignment(damageOrientationLabel, Pos.TOP_LEFT);
        damageOrientationLabel.setTranslateY(-8); 
        damageOrientationLabel.setTranslateX(10);
        //damage properties

        secondaryTypeHBox.getChildren().addAll(secondaryTypeLabel,healthPropertiesBoxStackPane,unknownStackPane,damagePropertiesStackPane,damageOrientationStackPane);
        secondaryTypeHBox.setAlignment(Pos.CENTER_LEFT);
        //secondary type

        //damage amount
        HBox damageAmountHBox=new HBox(2);
        damageAmountHBox.setPadding(new Insets(20,0,0,8));
        Label damageAmountLabel=new Label("Damage Amount");
        damageAmountLabel.setPrefWidth(160);

        Spinner<Integer> damageAmountSpinner=new Spinner<>(0,65535,0);
        damageAmountSpinner.setEditable(true);
        damageAmountSpinner.getValueFactory().setValue(getDamageAmount.get(i)[j]);
        damageAmountSpinner.valueProperty().addListener((obs,oldValue,newValue)->{
            if(newValue!=null){
                getDamageAmount.get(i)[j]=newValue;
            }

        });

        damageAmountHBox.getChildren().addAll(damageAmountLabel,damageAmountSpinner);
        damageAmountHBox.setAlignment(Pos.CENTER_LEFT);
        //damage amount

        
        //damage special
        HBox damageSpecialHBox=new HBox(2);
        damageSpecialHBox.setPadding(new Insets(20,0,0,8));
        Label damageSpecialLabel=new Label("Damage Special");
        damageSpecialLabel.setPrefWidth(160);

        Spinner<Integer> damageSpecialSpinner=new Spinner<>(0,65535,0);
        damageSpecialSpinner.setEditable(true);
        damageSpecialSpinner.getValueFactory().setValue(getDamageSpecial.get(i)[j]);
        damageSpecialSpinner.valueProperty().addListener((obs,oldValue,newValue)->{
            if(newValue!=null){
                getDamageSpecial.get(i)[j]=newValue;
            }

        });

        damageSpecialHBox.getChildren().addAll(damageSpecialLabel,damageSpecialSpinner);
        damageSpecialHBox.setAlignment(Pos.CENTER_LEFT);
        //damage special

        //damage special 2
        HBox damageSpecial2HBox=new HBox(2);
        damageSpecial2HBox.setPadding(new Insets(20,0,0,8));
        Label damageSpecial2Label=new Label("Damage Special 2");
        damageSpecial2Label.setPrefWidth(160);

        Spinner<Integer> damageSpecial2Spinner=new Spinner<>(0,65535,0);
        damageSpecial2Spinner.setEditable(true);
        damageSpecial2Spinner.getValueFactory().setValue(getDamageSpecial2.get(i)[j]);
        damageSpecial2Spinner.valueProperty().addListener((obs,oldValue,newValue)->{
            if(newValue!=null){
                getDamageSpecial2.get(i)[j]=newValue;
            }

        });

        damageSpecial2HBox.getChildren().addAll(damageSpecial2Label,damageSpecial2Spinner);
        damageSpecial2HBox.setAlignment(Pos.CENTER_LEFT);
        //damage special 2

        //damage special 3
        HBox damageSpecial3HBox=new HBox(2);
        damageSpecial3HBox.setPadding(new Insets(20,0,0,8));
        Label damageSpecial3Label=new Label("Damage Special 3");
        damageSpecial3Label.setPrefWidth(160);

        Spinner<Integer> damageSpecial3Spinner=new Spinner<>(0,65535,0);
        damageSpecial3Spinner.setEditable(true);
        damageSpecial3Spinner.getValueFactory().setValue(getDamageSpecial3.get(i)[j]);
        damageSpecial3Spinner.valueProperty().addListener((obs,oldValue,newValue)->{
            if(newValue!=null){
                getDamageSpecial3.get(i)[j]=newValue;
            }

        });

        damageSpecial3HBox.getChildren().addAll(damageSpecial3Label,damageSpecial3Spinner);
        damageSpecial3HBox.setAlignment(Pos.CENTER_LEFT);
        //damage special 3

        mainVBox.getChildren().addAll(damageTypeHBox,secondaryTypeHBox,damageAmountHBox,damageSpecialHBox,damageSpecial2HBox,damageSpecial3HBox);

        return mainVBox;

    }

    private VBox createAnimationVBox(int i, int j){
        VBox animationVBox = new VBox(5);

        //user animation time
        HBox userAnimationTimeHBox=new HBox(2);
        userAnimationTimeHBox.setPadding(new Insets(20,0,0,8));
        Label userAnimationTimeLabel=new Label("User Animation Time");
        userAnimationTimeLabel.setPrefWidth(160);

        Spinner<Integer> userAnimationTimeSpinner=new Spinner<>(0,65535,0);
        userAnimationTimeSpinner.setEditable(true);
        userAnimationTimeSpinner.getValueFactory().setValue(getUserAnimationTime.get(i)[j]);
        userAnimationTimeSpinner.valueProperty().addListener((obs,oldValue,newValue)->{
            if(newValue!=null){
                getUserAnimationTime.get(i)[j]=newValue;
            }

        });

        userAnimationTimeHBox.getChildren().addAll(userAnimationTimeLabel,userAnimationTimeSpinner);
        userAnimationTimeHBox.setAlignment(Pos.CENTER_LEFT);
        //user animation time

        //user animation speed
        HBox userAnimationSpeedHBox=new HBox(2);
        userAnimationSpeedHBox.setPadding(new Insets(20,0,0,8));
        Label userAnimationSpeed=new Label("User Animation Speed");
        userAnimationSpeed.setPrefWidth(160);

        Spinner<Double> userAnimationSpeedSpinner=new Spinner<>(Float.MIN_VALUE,Float.MAX_VALUE,0.0);
        userAnimationSpeedSpinner.setEditable(true);
        userAnimationSpeedSpinner.getValueFactory().setValue(getUserAnimationSpeed.get(i)[j]);
        userAnimationSpeedSpinner.valueProperty().addListener((obs,oldValue,newValue)->{
            if(newValue!=null){
                getUserAnimationSpeed.get(i)[j]=newValue;
            }
        });

        userAnimationSpeedHBox.getChildren().addAll(userAnimationSpeed,userAnimationSpeedSpinner);
        userAnimationSpeedHBox.setAlignment(Pos.CENTER_LEFT);
        //user animation speed

        //victim animation time
        HBox victimAnimationTimeHBox=new HBox(2);
        victimAnimationTimeHBox.setPadding(new Insets(20,0,0,8));
        Label victimAnimationTimeLabel=new Label("Victim Animation Time");
        victimAnimationTimeLabel.setPrefWidth(160);

        Spinner<Integer> victimAnimationTimeSpinner=new Spinner<>(0,65535,0);
        victimAnimationTimeSpinner.setEditable(true);
        victimAnimationTimeSpinner.getValueFactory().setValue(getVictimAnimationTime.get(i)[j]);
        victimAnimationTimeSpinner.valueProperty().addListener((obs,oldValue,newValue)->{
            if(newValue!=null){
                getVictimAnimationTime.get(i)[j]=newValue;
            }

        });

        victimAnimationTimeHBox.getChildren().addAll(victimAnimationTimeLabel,victimAnimationTimeSpinner);
        victimAnimationTimeHBox.setAlignment(Pos.CENTER_LEFT);
        //vcitim animation time

        //victim animation speed
        HBox victimAnimationSpeedHBox=new HBox(2);
        victimAnimationSpeedHBox.setPadding(new Insets(20,0,0,8));
        Label victimAnimationSpeed=new Label("Victim Animation Speed");
        victimAnimationSpeed.setPrefWidth(160);

        Spinner<Double> victimAnimationSpeedSpinner=new Spinner<>(Float.MIN_VALUE,Float.MAX_VALUE,0.0);
        victimAnimationSpeedSpinner.setEditable(true);
        victimAnimationSpeedSpinner.getValueFactory().setValue(getVictimAnimationSpeed.get(i)[j]);
        victimAnimationSpeedSpinner.valueProperty().addListener((obs,oldValue,newValue)->{
            if(newValue!=null){
                getVictimAnimationSpeed.get(i)[j]=newValue;
            }
        });

        victimAnimationSpeedHBox.getChildren().addAll(victimAnimationSpeed,victimAnimationSpeedSpinner);
        victimAnimationSpeedHBox.setAlignment(Pos.CENTER_LEFT);
        //victim animation speed

        animationVBox.getChildren().addAll(userAnimationTimeHBox,userAnimationSpeedHBox,victimAnimationTimeHBox,victimAnimationSpeedHBox);
        
        return animationVBox;
    }
    private VBox createSoundVBox(int i, int j){
        VBox soundVBox =new VBox(5);

        //sound type
        HBox acbTypeHBox = new HBox(2);
        acbTypeHBox.setPadding(new Insets(20,0,0,8));
        Label acbTypeLabel=new Label("Acb Type");
        acbTypeLabel.setPrefWidth(100);

        HBox acbTypeRadioButtonsHBox=new HBox(15);
        acbTypeRadioButtonsHBox.getStyleClass().add("titled-address-box");
        
        ToggleGroup acbTypeToggleGroup = new ToggleGroup();
        RadioButton common = new RadioButton("Common");
        common.setToggleGroup(acbTypeToggleGroup);
        RadioButton characterSE = new RadioButton("Character SE");
        characterSE.setToggleGroup(acbTypeToggleGroup);
        RadioButton characterVOX = new RadioButton("Character VOX");
        characterVOX.setToggleGroup(acbTypeToggleGroup);
        RadioButton skillSE = new RadioButton("Skill SE");
        skillSE.setToggleGroup(acbTypeToggleGroup);
        RadioButton skillVOX = new RadioButton("Skill VOX");
        skillVOX.setToggleGroup(acbTypeToggleGroup);


        switch (getDamageType.get(i)[j]) {
            case 2:  characterSE.setSelected(true);           break;
            case 3:  characterVOX.setSelected(true);          break;
            case 10: skillSE.setSelected(true);               break;
            case 11: skillVOX.setSelected(true);              break;
            default: common.setSelected(true);                break;
        }

        acbTypeToggleGroup.selectedToggleProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue != null && newValue.isSelected()) {
                RadioButton selectedRadio = (RadioButton) newValue;
                
                if (selectedRadio == common)                    { getDamageType.get(i)[j] = 0;  }
                else if (selectedRadio == characterSE)          { getDamageType.get(i)[j] = 2;  }
                else if (selectedRadio == characterVOX)         { getDamageType.get(i)[j] = 3;  }
                else if (selectedRadio == skillSE)              { getDamageType.get(i)[j] = 10; }
                else if (selectedRadio == skillVOX)             { getDamageType.get(i)[j] = 11; }
            }
        });
        acbTypeRadioButtonsHBox.getChildren().addAll(common,characterSE,characterVOX,skillSE,skillVOX);
        acbTypeHBox.getChildren().addAll(acbTypeLabel,acbTypeRadioButtonsHBox);
        acbTypeHBox.setAlignment(Pos.CENTER_LEFT);

        //sound type

        //victim animation speed
        HBox cueIdHBox=new HBox(2);
        cueIdHBox.setPadding(new Insets(20,0,0,8));
        Label cueIdSpeed=new Label("Cue Id");
        cueIdSpeed.setPrefWidth(100);

        Spinner<Integer> cueIdSpinner=new Spinner<>(Short.MIN_VALUE,Short.MAX_VALUE,0);
        cueIdSpinner.setEditable(true);
        cueIdSpinner.getValueFactory().setValue((int)getCueId.get(i)[j]);
        cueIdSpinner.valueProperty().addListener((obs,oldValue,newValue)->{
            if(newValue!=null){
                getCueId.get(i)[j]=newValue.shortValue();
            }
        });

        cueIdHBox.getChildren().addAll(cueIdSpeed,cueIdSpinner);
        cueIdHBox.setAlignment(Pos.CENTER_LEFT);
        //victim animation speed

        soundVBox.getChildren().addAll(acbTypeHBox,cueIdHBox);

        return soundVBox;
    }

    private ScrollPane createEffectsScrollPane(int i,int j){
        ScrollPane effectsScrollPane = new ScrollPane();
        VBox effectsVBox = new VBox(5);

        //effect 1 id
        HBox effect1IdHBox=new HBox(2);
        effect1IdHBox.setPadding(new Insets(20,0,0,8));
        Label effect1IdLabel=new Label("Effect 1 Id");
        effect1IdLabel.setPrefWidth(160);

        Spinner<Integer> effect1IdSpinner=new Spinner<>(Short.MIN_VALUE,Short.MAX_VALUE,0);
        effect1IdSpinner.setEditable(true);
        effect1IdSpinner.getValueFactory().setValue((int)getEffect1Id.get(i)[j]);
        effect1IdSpinner.valueProperty().addListener((obs,oldValue,newValue)->{
            if(newValue!=null){
                getEffect1Id.get(i)[j]=newValue.shortValue();
            }

        });

        effect1IdHBox.getChildren().addAll(effect1IdLabel,effect1IdSpinner);
        effect1IdHBox.setAlignment(Pos.CENTER_LEFT);
        //effect 1 id

        //effect 1 skill id
        HBox effect1SkillIdHBox=new HBox(2);
        effect1SkillIdHBox.setPadding(new Insets(20,0,0,8));
        Label effect1SkillIdLabel=new Label("Effect 1 Skill Id");
        effect1SkillIdLabel.setPrefWidth(160);

        Spinner<Integer> effect1SkillIdSpinner=new Spinner<>(0,65535,0);
        effect1SkillIdSpinner.setEditable(true);
        effect1SkillIdSpinner.getValueFactory().setValue(getEffect1SkillId.get(i)[j]);
        effect1SkillIdSpinner.valueProperty().addListener((obs,oldValue,newValue)->{
            if(newValue!=null){
                getEffect1SkillId.get(i)[j]=newValue;
            }

        });

        effect1SkillIdHBox.getChildren().addAll(effect1SkillIdLabel,effect1SkillIdSpinner);
        effect1SkillIdHBox.setAlignment(Pos.CENTER_LEFT);
        //effect 1 skill id

        //effect 1 eepk type
        HBox effect1EepkTypeHBox=new HBox(2);
        effect1EepkTypeHBox.setPadding(new Insets(20,0,0,8));
        Label effect1EepkTypeLabel=new Label("Effect 1 Eepk Type");
        effect1EepkTypeLabel.setPrefWidth(160);

        GridPane effect1EepkTypeGridPane =new GridPane();
        effect1EepkTypeGridPane.setHgap(15);
        effect1EepkTypeGridPane.setVgap(15);
        effect1EepkTypeGridPane.getStyleClass().add("titled-address-box");
         
        ToggleGroup effect1EepkTypeToggleGroup=new ToggleGroup();
        RadioButton commonEffect1 = new RadioButton("Common");
        commonEffect1.setToggleGroup(effect1EepkTypeToggleGroup);
        RadioButton stageBGEffect1 = new RadioButton("StageBG");
        stageBGEffect1.setToggleGroup(effect1EepkTypeToggleGroup);
        RadioButton characterEffect1 = new RadioButton("Character");
        characterEffect1.setToggleGroup(effect1EepkTypeToggleGroup);
        RadioButton awokenSkillEffect1 = new RadioButton("Awoken Skill");
        awokenSkillEffect1.setToggleGroup(effect1EepkTypeToggleGroup);
        RadioButton unknown4Effect1 = new RadioButton("Unknown 4");
        unknown4Effect1.setToggleGroup(effect1EepkTypeToggleGroup);
        RadioButton superSkillEffect1 = new RadioButton("Super Skill");
        superSkillEffect1.setToggleGroup(effect1EepkTypeToggleGroup);
        RadioButton ultimateSkillEffect1 = new RadioButton("Ultimate Skill");
        ultimateSkillEffect1.setToggleGroup(effect1EepkTypeToggleGroup);
        RadioButton evasiveSkillEffect1 = new RadioButton("Evasive Skill");
        evasiveSkillEffect1.setToggleGroup(effect1EepkTypeToggleGroup);
        RadioButton unknown8Effect1 = new RadioButton("Unknown 8");
        unknown8Effect1.setToggleGroup(effect1EepkTypeToggleGroup);
        RadioButton kiBlastSkillEffect1 = new RadioButton("Ki Blast Skill");
        kiBlastSkillEffect1.setToggleGroup(effect1EepkTypeToggleGroup);
        RadioButton unknown10Effect1 = new RadioButton("Unknown 10");
        unknown10Effect1.setToggleGroup(effect1EepkTypeToggleGroup);
        RadioButton stageEffect1 = new RadioButton("Stage");
        stageEffect1.setToggleGroup(effect1EepkTypeToggleGroup);
        RadioButton unknown12Effect1 = new RadioButton("Unknown 12");
        unknown12Effect1.setToggleGroup(effect1EepkTypeToggleGroup);
        RadioButton unknown13Effect1 = new RadioButton("Unknown 13");
        unknown13Effect1.setToggleGroup(effect1EepkTypeToggleGroup);
        RadioButton unknown14Effect1 = new RadioButton("Unknown 14");
        unknown14Effect1.setToggleGroup(effect1EepkTypeToggleGroup);
        RadioButton unknown15Effect1 = new RadioButton("Unknown 15");
        unknown15Effect1.setToggleGroup(effect1EepkTypeToggleGroup);

        switch (getEffect1EepkType.get(i)[j]) {
            case 1:  stageBGEffect1.setSelected(true);       break;
            case 2:  characterEffect1.setSelected(true);     break;
            case 3:  awokenSkillEffect1.setSelected(true);   break;
            case 4:  unknown4Effect1.setSelected(true);      break;
            case 5:  superSkillEffect1.setSelected(true);    break;
            case 6:  ultimateSkillEffect1.setSelected(true); break;
            case 7:  evasiveSkillEffect1.setSelected(true);   break;
            case 8:  unknown8Effect1.setSelected(true);      break;
            case 9:  kiBlastSkillEffect1.setSelected(true);  break;
            case 10: unknown10Effect1.setSelected(true);     break;
            case 11: stageEffect1.setSelected(true);         break;
            case 12: unknown12Effect1.setSelected(true);     break;
            case 13: unknown13Effect1.setSelected(true);     break;
            case 14: unknown14Effect1.setSelected(true);     break;
            case 15: unknown15Effect1.setSelected(true);     break;
            default: commonEffect1.setSelected(true);        break;
        }

        effect1EepkTypeToggleGroup.selectedToggleProperty().addListener((obs, oldValue, newValue) -> {
    if (newValue != null && newValue.isSelected()) {
        RadioButton selectedRadio = (RadioButton) newValue;
        
        if (selectedRadio == commonEffect1)               { getEffect1EepkType.get(i)[j] = 0;  }
            else if (selectedRadio == stageBGEffect1)          { getEffect1EepkType.get(i)[j] = 1;  }
            else if (selectedRadio == characterEffect1)        { getEffect1EepkType.get(i)[j] = 2;  }
            else if (selectedRadio == awokenSkillEffect1)      { getEffect1EepkType.get(i)[j] = 3;  }
            else if (selectedRadio == unknown4Effect1)         { getEffect1EepkType.get(i)[j] = 4;  }
            else if (selectedRadio == superSkillEffect1)       { getEffect1EepkType.get(i)[j] = 5;  }
            else if (selectedRadio == ultimateSkillEffect1)    { getEffect1EepkType.get(i)[j] = 6;  }
            else if (selectedRadio == evasiveSkillEffect1)     { getEffect1EepkType.get(i)[j] = 7;  }
            else if (selectedRadio == unknown8Effect1)         { getEffect1EepkType.get(i)[j] = 8;  }
            else if (selectedRadio == kiBlastSkillEffect1)     { getEffect1EepkType.get(i)[j] = 9;  }
            else if (selectedRadio == unknown10Effect1)        { getEffect1EepkType.get(i)[j] = 10; }
            else if (selectedRadio == stageEffect1)            { getEffect1EepkType.get(i)[j] = 11; }
            else if (selectedRadio == unknown12Effect1)        { getEffect1EepkType.get(i)[j] = 12; }
            else if (selectedRadio == unknown13Effect1)        { getEffect1EepkType.get(i)[j] = 13; }
            else if (selectedRadio == unknown14Effect1)        { getEffect1EepkType.get(i)[j] = 14; }
            else if (selectedRadio == unknown15Effect1)        { getEffect1EepkType.get(i)[j] = 15; }
        }
    });

        effect1EepkTypeGridPane.add(commonEffect1, 0, 0);   
        effect1EepkTypeGridPane.add(stageBGEffect1, 1, 0);          
        effect1EepkTypeGridPane.add(characterEffect1, 2, 0);          
        effect1EepkTypeGridPane.add(awokenSkillEffect1, 3, 0);          

        effect1EepkTypeGridPane.add(unknown4Effect1, 0, 1);          
        effect1EepkTypeGridPane.add(superSkillEffect1, 1, 1);           
        effect1EepkTypeGridPane.add(ultimateSkillEffect1, 2, 1);
        effect1EepkTypeGridPane.add(evasiveSkillEffect1, 3, 1);

        effect1EepkTypeGridPane.add(unknown8Effect1, 0, 2);
        effect1EepkTypeGridPane.add(kiBlastSkillEffect1, 1, 2);
        effect1EepkTypeGridPane.add(unknown10Effect1, 2, 2);
        effect1EepkTypeGridPane.add(stageEffect1, 3, 2);

        effect1EepkTypeGridPane.add(unknown12Effect1, 0, 3);
        effect1EepkTypeGridPane.add(unknown13Effect1, 1, 3);
        effect1EepkTypeGridPane.add(unknown14Effect1, 2, 3);
        effect1EepkTypeGridPane.add(unknown15Effect1, 3, 3);

        
        effect1EepkTypeHBox.getChildren().addAll(effect1EepkTypeLabel,effect1EepkTypeGridPane);
        effect1EepkTypeHBox.setAlignment(Pos.CENTER_LEFT);
        //effect 1 eepk type

        //effect 2 id
        HBox effect2IdHBox=new HBox(2);
        effect2IdHBox.setPadding(new Insets(20,0,0,8));
        Label effect2IdLabel=new Label("Effect 2 Id");
        effect2IdLabel.setPrefWidth(160);

        Spinner<Integer> effect2IdSpinner=new Spinner<>(Short.MIN_VALUE,Short.MAX_VALUE,0);
        effect2IdSpinner.setEditable(true);
        effect2IdSpinner.getValueFactory().setValue((int)getEffect2Id.get(i)[j]);
        effect2IdSpinner.valueProperty().addListener((obs,oldValue,newValue)->{
            if(newValue!=null){
                getEffect2Id.get(i)[j]=newValue.shortValue();
            }

        });

        effect2IdHBox.getChildren().addAll(effect2IdLabel,effect2IdSpinner);
        effect2IdHBox.setAlignment(Pos.CENTER_LEFT);
        //effect 2 id

        //effect 2 skill id
        HBox effect2SkillIdHBox=new HBox(2);
        effect2SkillIdHBox.setPadding(new Insets(20,0,0,8));
        Label effect2SkillIdLabel=new Label("Effect 2 Skill Id");
        effect2SkillIdLabel.setPrefWidth(160);

        Spinner<Integer> effect2SkillIdSpinner=new Spinner<>(0,65535,0);
        effect2SkillIdSpinner.setEditable(true);
        effect2SkillIdSpinner.getValueFactory().setValue(getEffect2SkillId.get(i)[j]);
        effect2SkillIdSpinner.valueProperty().addListener((obs,oldValue,newValue)->{
            if(newValue!=null){
                getEffect2SkillId.get(i)[j]=newValue;
            }

        });

        effect2SkillIdHBox.getChildren().addAll(effect2SkillIdLabel,effect2SkillIdSpinner);
        effect2SkillIdHBox.setAlignment(Pos.CENTER_LEFT);
        //effect 2 skill id

        //effect 2 eepk type
        HBox effect2EepkTypeHBox=new HBox(2);
        effect2EepkTypeHBox.setPadding(new Insets(20,0,0,8));
        Label effect2EepkTypeLabel=new Label("Effect 2 Eepk Type");
        effect2EepkTypeLabel.setPrefWidth(160);

        GridPane effect2EepkTypeGridPane =new GridPane();
        effect2EepkTypeGridPane.setHgap(15);
        effect2EepkTypeGridPane.setVgap(15);
        effect2EepkTypeGridPane.getStyleClass().add("titled-address-box");
         
        ToggleGroup effect2EepkTypeToggleGroup=new ToggleGroup();
        RadioButton commonEffect2 = new RadioButton("Common");
        commonEffect2.setToggleGroup(effect2EepkTypeToggleGroup);
        RadioButton stageBGEffect2 = new RadioButton("StageBG");
        stageBGEffect2.setToggleGroup(effect2EepkTypeToggleGroup);
        RadioButton characterEffect2 = new RadioButton("Character");
        characterEffect2.setToggleGroup(effect2EepkTypeToggleGroup);
        RadioButton awokenSkillEffect2 = new RadioButton("Awoken Skill");
        awokenSkillEffect2.setToggleGroup(effect2EepkTypeToggleGroup);
        RadioButton unknown4Effect2 = new RadioButton("Unknown 4");
        unknown4Effect2.setToggleGroup(effect2EepkTypeToggleGroup);
        RadioButton superSkillEffect2 = new RadioButton("Super Skill");
        superSkillEffect2.setToggleGroup(effect2EepkTypeToggleGroup);
        RadioButton ultimateSkillEffect2 = new RadioButton("Ultimate Skill");
        ultimateSkillEffect2.setToggleGroup(effect2EepkTypeToggleGroup);
        RadioButton evasiveSkillEffect2 = new RadioButton("Evasive Skill");
        evasiveSkillEffect2.setToggleGroup(effect2EepkTypeToggleGroup);
        RadioButton unknown8Effect2 = new RadioButton("Unknown 8");
        unknown8Effect2.setToggleGroup(effect2EepkTypeToggleGroup);
        RadioButton kiBlastSkillEffect2 = new RadioButton("Ki Blast Skill");
        kiBlastSkillEffect2.setToggleGroup(effect2EepkTypeToggleGroup);
        RadioButton unknown10Effect2 = new RadioButton("Unknown 10");
        unknown10Effect2.setToggleGroup(effect2EepkTypeToggleGroup);
        RadioButton stageEffect2 = new RadioButton("Stage");
        stageEffect2.setToggleGroup(effect2EepkTypeToggleGroup);
        RadioButton unknown12Effect2 = new RadioButton("Unknown 12");
        unknown12Effect2.setToggleGroup(effect2EepkTypeToggleGroup);
        RadioButton unknown13Effect2 = new RadioButton("Unknown 13");
        unknown13Effect2.setToggleGroup(effect2EepkTypeToggleGroup);
        RadioButton unknown14Effect2 = new RadioButton("Unknown 14");
        unknown14Effect2.setToggleGroup(effect2EepkTypeToggleGroup);
        RadioButton unknown15Effect2 = new RadioButton("Unknown 15");
        unknown15Effect2.setToggleGroup(effect2EepkTypeToggleGroup);

        switch (getEffect2EepkType.get(i)[j]) {
            case 1:  stageBGEffect2.setSelected(true);       break;
            case 2:  characterEffect2.setSelected(true);     break;
            case 3:  awokenSkillEffect2.setSelected(true);   break;
            case 4:  unknown4Effect2.setSelected(true);      break;
            case 5:  superSkillEffect2.setSelected(true);    break;
            case 6:  ultimateSkillEffect2.setSelected(true); break;
            case 7:  evasiveSkillEffect2.setSelected(true);   break;
            case 8:  unknown8Effect2.setSelected(true);      break;
            case 9:  kiBlastSkillEffect2.setSelected(true);  break;
            case 10: unknown10Effect2.setSelected(true);     break;
            case 11: stageEffect2.setSelected(true);         break;
            case 12: unknown12Effect2.setSelected(true);     break;
            case 13: unknown13Effect2.setSelected(true);     break;
            case 14: unknown14Effect2.setSelected(true);     break;
            case 15: unknown15Effect2.setSelected(true);     break;
            default: commonEffect2.setSelected(true);        break;
        }

        effect2EepkTypeToggleGroup.selectedToggleProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue != null && newValue.isSelected()) {
                RadioButton selectedRadio = (RadioButton) newValue;
        
                if      (selectedRadio == commonEffect2)           { getEffect2EepkType.get(i)[j] = 0;  }
                else if (selectedRadio == stageBGEffect2)          { getEffect2EepkType.get(i)[j] = 1;  }
                else if (selectedRadio == characterEffect2)        { getEffect2EepkType.get(i)[j] = 2;  }
                else if (selectedRadio == awokenSkillEffect2)      { getEffect2EepkType.get(i)[j] = 3;  }
                else if (selectedRadio == unknown4Effect2)         { getEffect2EepkType.get(i)[j] = 4;  }
                else if (selectedRadio == superSkillEffect2)       { getEffect2EepkType.get(i)[j] = 5;  }
                else if (selectedRadio == ultimateSkillEffect2)    { getEffect2EepkType.get(i)[j] = 6;  }
                else if (selectedRadio == evasiveSkillEffect2)     { getEffect2EepkType.get(i)[j] = 7;  }
                else if (selectedRadio == unknown8Effect2)         { getEffect2EepkType.get(i)[j] = 8;  }
                else if (selectedRadio == kiBlastSkillEffect2)     { getEffect2EepkType.get(i)[j] = 9;  }
                else if (selectedRadio == unknown10Effect2)        { getEffect2EepkType.get(i)[j] = 10; }
                else if (selectedRadio == stageEffect2)            { getEffect2EepkType.get(i)[j] = 11; }
                else if (selectedRadio == unknown12Effect2)        { getEffect2EepkType.get(i)[j] = 12; }
                else if (selectedRadio == unknown13Effect2)        { getEffect2EepkType.get(i)[j] = 13; }
                else if (selectedRadio == unknown14Effect2)        { getEffect2EepkType.get(i)[j] = 14; }
                else if (selectedRadio == unknown15Effect2)        { getEffect2EepkType.get(i)[j] = 15; }
            }
        });

        effect2EepkTypeGridPane.add(commonEffect2, 0, 0);   
        effect2EepkTypeGridPane.add(stageBGEffect1, 1, 0);          
        effect2EepkTypeGridPane.add(characterEffect2, 2, 0);          
        effect2EepkTypeGridPane.add(awokenSkillEffect2, 3, 0);          

        effect2EepkTypeGridPane.add(unknown4Effect2, 0, 1);          
        effect2EepkTypeGridPane.add(superSkillEffect2, 1, 1);           
        effect2EepkTypeGridPane.add(ultimateSkillEffect2, 2, 1);
        effect2EepkTypeGridPane.add(evasiveSkillEffect2, 3, 1);

        effect2EepkTypeGridPane.add(unknown8Effect2, 0, 2);
        effect2EepkTypeGridPane.add(kiBlastSkillEffect2, 1, 2);
        effect2EepkTypeGridPane.add(unknown10Effect2, 2, 2);
        effect2EepkTypeGridPane.add(stageEffect2, 3, 2);

        effect2EepkTypeGridPane.add(unknown12Effect2, 0, 3);
        effect2EepkTypeGridPane.add(unknown13Effect2, 1, 3);
        effect2EepkTypeGridPane.add(unknown14Effect2, 2, 3);
        effect2EepkTypeGridPane.add(unknown15Effect2, 3, 3);

        
        effect2EepkTypeHBox.getChildren().addAll(effect2EepkTypeLabel,effect2EepkTypeGridPane);
        effect2EepkTypeHBox.setAlignment(Pos.CENTER_LEFT);
        //effect 2 eepk type

        //effect 3 id
        HBox effect3IdHBox=new HBox(2);
        effect3IdHBox.setPadding(new Insets(20,0,0,8));
        Label effect3IdLabel=new Label("Effect 3 Id");
        effect3IdLabel.setPrefWidth(160);

        Spinner<Integer> effect3IdSpinner=new Spinner<>(Short.MIN_VALUE,Short.MAX_VALUE,0);
        effect3IdSpinner.setEditable(true);
        effect3IdSpinner.getValueFactory().setValue((int)getEffect3Id.get(i)[j]);
        effect3IdSpinner.valueProperty().addListener((obs,oldValue,newValue)->{
            if(newValue!=null){
                getEffect3Id.get(i)[j]=newValue.shortValue();
            }

        });

        effect3IdHBox.getChildren().addAll(effect3IdLabel,effect3IdSpinner);
        effect3IdHBox.setAlignment(Pos.CENTER_LEFT);
        //effect 3 id

        //effect 3 skill id
        HBox effect3SkillIdHBox=new HBox(2);
        effect3SkillIdHBox.setPadding(new Insets(20,0,0,8));
        Label effect3SkillIdLabel=new Label("Effect 3 Skill Id");
        effect3SkillIdLabel.setPrefWidth(160);

        Spinner<Integer> effect3SkillIdSpinner=new Spinner<>(0,65535,0);
        effect3SkillIdSpinner.setEditable(true);
        effect3SkillIdSpinner.getValueFactory().setValue(getEffect3SkillId.get(i)[j]);
        effect3SkillIdSpinner.valueProperty().addListener((obs,oldValue,newValue)->{
            if(newValue!=null){
                getEffect3SkillId.get(i)[j]=newValue;
            }

        });

        effect3SkillIdHBox.getChildren().addAll(effect3SkillIdLabel,effect3SkillIdSpinner);
        effect3SkillIdHBox.setAlignment(Pos.CENTER_LEFT);
        //effect 3 skill id

        //effect 3 eepk type
        HBox effect3EepkTypeHBox=new HBox(2);
        effect3EepkTypeHBox.setPadding(new Insets(20,0,0,8));
        Label effect3EepkTypeLabel=new Label("Effect 3 Eepk Type");
        effect3EepkTypeLabel.setPrefWidth(160);

        GridPane effect3EepkTypeGridPane =new GridPane();
        effect3EepkTypeGridPane.setHgap(15);
        effect3EepkTypeGridPane.setVgap(15);
        effect3EepkTypeGridPane.getStyleClass().add("titled-address-box");
         
        ToggleGroup effect3EepkTypeToggleGroup=new ToggleGroup();
        RadioButton commonEffect3 = new RadioButton("Common");
        commonEffect3.setToggleGroup(effect3EepkTypeToggleGroup);
        RadioButton stageBGEffect3 = new RadioButton("StageBG");
        stageBGEffect3.setToggleGroup(effect3EepkTypeToggleGroup);
        RadioButton characterEffect3 = new RadioButton("Character");
        characterEffect3.setToggleGroup(effect3EepkTypeToggleGroup);
        RadioButton awokenSkillEffect3 = new RadioButton("Awoken Skill");
        awokenSkillEffect3.setToggleGroup(effect3EepkTypeToggleGroup);
        RadioButton unknown4Effect3 = new RadioButton("Unknown 4");
        unknown4Effect3.setToggleGroup(effect3EepkTypeToggleGroup);
        RadioButton superSkillEffect3 = new RadioButton("Super Skill");
        superSkillEffect3.setToggleGroup(effect3EepkTypeToggleGroup);
        RadioButton ultimateSkillEffect3 = new RadioButton("Ultimate Skill");
        ultimateSkillEffect3.setToggleGroup(effect3EepkTypeToggleGroup);
        RadioButton evasiveSkillEffect3 = new RadioButton("Evasive Skill");
        evasiveSkillEffect3.setToggleGroup(effect3EepkTypeToggleGroup);
        RadioButton unknown8Effect3 = new RadioButton("Unknown 8");
        unknown8Effect3.setToggleGroup(effect3EepkTypeToggleGroup);
        RadioButton kiBlastSkillEffect3 = new RadioButton("Ki Blast Skill");
        kiBlastSkillEffect3.setToggleGroup(effect3EepkTypeToggleGroup);
        RadioButton unknown10Effect3 = new RadioButton("Unknown 10");
        unknown10Effect3.setToggleGroup(effect3EepkTypeToggleGroup);
        RadioButton stageEffect3 = new RadioButton("Stage");
        stageEffect3.setToggleGroup(effect3EepkTypeToggleGroup);
        RadioButton unknown12Effect3 = new RadioButton("Unknown 12");
        unknown12Effect3.setToggleGroup(effect3EepkTypeToggleGroup);
        RadioButton unknown13Effect3 = new RadioButton("Unknown 13");
        unknown13Effect3.setToggleGroup(effect3EepkTypeToggleGroup);
        RadioButton unknown14Effect3 = new RadioButton("Unknown 14");
        unknown14Effect3.setToggleGroup(effect3EepkTypeToggleGroup);
        RadioButton unknown15Effect3 = new RadioButton("Unknown 15");
        unknown15Effect3.setToggleGroup(effect3EepkTypeToggleGroup);

        switch (getEffect3EepkType.get(i)[j]) {
            case 1:  stageBGEffect3.setSelected(true);       break;
            case 2:  characterEffect3.setSelected(true);     break;
            case 3:  awokenSkillEffect3.setSelected(true);   break;
            case 4:  unknown4Effect3.setSelected(true);      break;
            case 5:  superSkillEffect3.setSelected(true);    break;
            case 6:  ultimateSkillEffect3.setSelected(true); break;
            case 7:  evasiveSkillEffect3.setSelected(true);   break;
            case 8:  unknown8Effect3.setSelected(true);      break;
            case 9:  kiBlastSkillEffect3.setSelected(true);  break;
            case 10: unknown10Effect3.setSelected(true);     break;
            case 11: stageEffect3.setSelected(true);         break;
            case 12: unknown12Effect3.setSelected(true);     break;
            case 13: unknown13Effect3.setSelected(true);     break;
            case 14: unknown14Effect3.setSelected(true);     break;
            case 15: unknown15Effect3.setSelected(true);     break;
            default: commonEffect3.setSelected(true);        break;
        }

        effect3EepkTypeToggleGroup.selectedToggleProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue != null && newValue.isSelected()) {
                RadioButton selectedRadio = (RadioButton) newValue;
        
                if      (selectedRadio == commonEffect3)           { getEffect3EepkType.get(i)[j] = 0;  }
                else if (selectedRadio == stageBGEffect3)          { getEffect3EepkType.get(i)[j] = 1;  }
                else if (selectedRadio == characterEffect3)        { getEffect3EepkType.get(i)[j] = 2;  }
                else if (selectedRadio == awokenSkillEffect3)      { getEffect3EepkType.get(i)[j] = 3;  }
                else if (selectedRadio == unknown4Effect3)         { getEffect3EepkType.get(i)[j] = 4;  }
                else if (selectedRadio == superSkillEffect3)       { getEffect3EepkType.get(i)[j] = 5;  }
                else if (selectedRadio == ultimateSkillEffect3)    { getEffect3EepkType.get(i)[j] = 6;  }
                else if (selectedRadio == evasiveSkillEffect3)     { getEffect3EepkType.get(i)[j] = 7;  }
                else if (selectedRadio == unknown8Effect3)         { getEffect3EepkType.get(i)[j] = 8;  }
                else if (selectedRadio == kiBlastSkillEffect3)     { getEffect3EepkType.get(i)[j] = 9;  }
                else if (selectedRadio == unknown10Effect3)        { getEffect3EepkType.get(i)[j] = 10; }
                else if (selectedRadio == stageEffect3)            { getEffect3EepkType.get(i)[j] = 11; }
                else if (selectedRadio == unknown12Effect3)        { getEffect3EepkType.get(i)[j] = 12; }
                else if (selectedRadio == unknown13Effect3)        { getEffect3EepkType.get(i)[j] = 13; }
                else if (selectedRadio == unknown14Effect3)        { getEffect3EepkType.get(i)[j] = 14; }
                else if (selectedRadio == unknown15Effect3)        { getEffect3EepkType.get(i)[j] = 15; }
            }
        });

        effect3EepkTypeGridPane.add(commonEffect3, 0, 0);   
        effect3EepkTypeGridPane.add(stageBGEffect1, 1, 0);          
        effect3EepkTypeGridPane.add(characterEffect3, 2, 0);          
        effect3EepkTypeGridPane.add(awokenSkillEffect3, 3, 0);          

        effect3EepkTypeGridPane.add(unknown4Effect3, 0, 1);          
        effect3EepkTypeGridPane.add(superSkillEffect3, 1, 1);           
        effect3EepkTypeGridPane.add(ultimateSkillEffect3, 2, 1);
        effect3EepkTypeGridPane.add(evasiveSkillEffect3, 3, 1);

        effect3EepkTypeGridPane.add(unknown8Effect3, 0, 2);
        effect3EepkTypeGridPane.add(kiBlastSkillEffect3, 1, 2);
        effect3EepkTypeGridPane.add(unknown10Effect3, 2, 2);
        effect3EepkTypeGridPane.add(stageEffect3, 3, 2);

        effect3EepkTypeGridPane.add(unknown12Effect3, 0, 3);
        effect3EepkTypeGridPane.add(unknown13Effect3, 1, 3);
        effect3EepkTypeGridPane.add(unknown14Effect3, 2, 3);
        effect3EepkTypeGridPane.add(unknown15Effect3, 3, 3);

        
        effect3EepkTypeHBox.getChildren().addAll(effect3EepkTypeLabel,effect3EepkTypeGridPane);
        effect3EepkTypeHBox.setAlignment(Pos.CENTER_LEFT);
        //effect 2 eepk type

        effectsVBox.getChildren().addAll(effect1IdHBox,effect1SkillIdHBox,effect1EepkTypeHBox,effect2IdHBox,effect2SkillIdHBox,effect2EepkTypeHBox,effect3IdHBox,effect3SkillIdHBox,effect3EepkTypeHBox);
        effectsScrollPane.setContent(effectsVBox);
        return effectsScrollPane;
    }

    private VBox createPushbackVBox(int i,int j){
        VBox pushBackVBox = new VBox(5);

        //pushback strength
        HBox pushbackStrengthHBox=new HBox(2);
        pushbackStrengthHBox.setPadding(new Insets(20,0,0,8));
        Label pushbackStrengthLabel=new Label("Pushback Strength");
        pushbackStrengthLabel.setPrefWidth(200);

        Spinner<Double> pushbackStrengthSpinner=new Spinner<>(Float.MIN_VALUE,Float.MAX_VALUE,0.0);
        pushbackStrengthSpinner.setEditable(true);
        pushbackStrengthSpinner.getValueFactory().setValue(getPushbackStrength.get(i)[j]);
        pushbackStrengthSpinner.valueProperty().addListener((obs,oldValue,newValue)->{
            if(newValue!=null){
                getPushbackStrength.get(i)[j]=newValue;
            }
        });

        pushbackStrengthHBox.getChildren().addAll(pushbackStrengthLabel,pushbackStrengthSpinner);
        pushbackStrengthHBox.setAlignment(Pos.CENTER_LEFT);
        //pushback strength

        //pushback acceleration
        HBox pushbackAccelerationHBox=new HBox(2);
        pushbackAccelerationHBox.setPadding(new Insets(20,0,0,8));
        Label pushbackAccelerationLabel=new Label("Pushback Acceleration");
        pushbackAccelerationLabel.setPrefWidth(200);

        Spinner<Double> pushbackAccelerationSpinner=new Spinner<>(Float.MIN_VALUE,Float.MAX_VALUE,0.0);
        pushbackAccelerationSpinner.setEditable(true);
        pushbackAccelerationSpinner.getValueFactory().setValue(getPushbackAcceleration.get(i)[j]);
        pushbackAccelerationSpinner.valueProperty().addListener((obs,oldValue,newValue)->{
            if(newValue!=null){
                getPushbackAcceleration.get(i)[j]=newValue;
            }
        });

        pushbackAccelerationHBox.getChildren().addAll(pushbackAccelerationLabel,pushbackAccelerationSpinner);
        pushbackAccelerationHBox.setAlignment(Pos.CENTER_LEFT);
        //pushback acceleration

        //user stunt
        HBox userStuntHBox=new HBox(2);
        userStuntHBox.setPadding(new Insets(20,0,0,8));
        Label userStuntLabel=new Label("User Stunt");
        userStuntLabel.setPrefWidth(200);

        Spinner<Integer> userStuntSpinner=new Spinner<>(0,65535,0);
        userStuntSpinner.setEditable(true);
        userStuntSpinner.getValueFactory().setValue(getUserStunt.get(i)[j]);
        userStuntSpinner.valueProperty().addListener((obs,oldValue,newValue)->{
            if(newValue!=null){
                getUserStunt.get(i)[j]=newValue;
            }

        });

        userStuntHBox.getChildren().addAll(userStuntLabel,userStuntSpinner);
        userStuntHBox.setAlignment(Pos.CENTER_LEFT);
        //user stunt

        //victim stunt
        HBox victimStuntHBox=new HBox(2);
        victimStuntHBox.setPadding(new Insets(20,0,0,8));
        Label victimStuntLabel=new Label("Victim Stunt");
        victimStuntLabel.setPrefWidth(200);

        Spinner<Integer> victimStuntSpinner=new Spinner<>(0,65535,0);
        victimStuntSpinner.setEditable(true);
        victimStuntSpinner.getValueFactory().setValue(getVictimStunt.get(i)[j]);
        victimStuntSpinner.valueProperty().addListener((obs,oldValue,newValue)->{
            if(newValue!=null){
                getVictimStunt.get(i)[j]=newValue;
            }

        });
        victimStuntHBox.getChildren().addAll(victimStuntLabel,victimStuntSpinner);
        victimStuntHBox.setAlignment(Pos.CENTER_LEFT);
        //victim stunt

       

        //knockback duration
        HBox knockbackDurationHBox=new HBox(2);
        knockbackDurationHBox.setPadding(new Insets(20,0,0,8));
        Label knockbackDurationLabel=new Label("Knockback Duration");
        knockbackDurationLabel.setPrefWidth(200);

        Spinner<Integer> knockbackDurationSpinner=new Spinner<>(0,65535,0);
        knockbackDurationSpinner.setEditable(true);
        knockbackDurationSpinner.getValueFactory().setValue(getKnockbackDuration.get(i)[j]);
        knockbackDurationSpinner.valueProperty().addListener((obs,oldValue,newValue)->{
            if(newValue!=null){
                getKnockbackDuration.get(i)[j]=newValue;
            }

        });
        knockbackDurationHBox.getChildren().addAll(knockbackDurationLabel,knockbackDurationSpinner);
        knockbackDurationHBox.setAlignment(Pos.CENTER_LEFT);
        //knockback duration

        //knockback ground impact time
        HBox knockbackGroundImpactTimeHBox=new HBox(2);
        knockbackGroundImpactTimeHBox.setPadding(new Insets(20,0,0,8));
        Label knockbackGroundImpactTimeLabel=new Label("Knockback Ground Impact Time");
        knockbackGroundImpactTimeLabel.setPrefWidth(200);

        Spinner<Integer> knockbackGroundImpactSpinner=new Spinner<>(0,65535,0);
        knockbackGroundImpactSpinner.setEditable(true);
        knockbackGroundImpactSpinner.getValueFactory().setValue(getKnockbackGroundImpactTime.get(i)[j]);
        knockbackGroundImpactSpinner.valueProperty().addListener((obs,oldValue,newValue)->{
            if(newValue!=null){
                getKnockbackGroundImpactTime.get(i)[j]=newValue;
            }

        });
        knockbackGroundImpactTimeHBox.getChildren().addAll(knockbackGroundImpactTimeLabel,knockbackGroundImpactSpinner);
        knockbackGroundImpactTimeHBox.setAlignment(Pos.CENTER_LEFT);
        //knockback ground impact time

        //knockback ground impact time
        HBox knockbackRecoveryAfterImpactTimeHBox=new HBox(2);
        knockbackRecoveryAfterImpactTimeHBox.setPadding(new Insets(20,0,0,8));
        Label knockbackRecoveryAfterImpactTimeLabel=new Label("Knockback Recovery After Impact");
        knockbackRecoveryAfterImpactTimeLabel.setPrefWidth(200);

        Spinner<Integer> knockbackRecoveryAfterImpactSpinner=new Spinner<>(0,65535,0);
        knockbackRecoveryAfterImpactSpinner.setEditable(true);
        knockbackRecoveryAfterImpactSpinner.getValueFactory().setValue(getKnockbackRecoveryAfterImpactTime.get(i)[j]);
        knockbackRecoveryAfterImpactSpinner.valueProperty().addListener((obs,oldValue,newValue)->{
            if(newValue!=null){
                getKnockbackRecoveryAfterImpactTime.get(i)[j]=newValue;
            }

        });
        knockbackRecoveryAfterImpactTimeHBox.getChildren().addAll(knockbackRecoveryAfterImpactTimeLabel,knockbackRecoveryAfterImpactSpinner);
        knockbackRecoveryAfterImpactTimeHBox.setAlignment(Pos.CENTER_LEFT);
        //knockback recovery after impact

        //knockback strength x
        HBox knockbackStrengthXHBox=new HBox(2);
        knockbackStrengthXHBox.setPadding(new Insets(20,0,0,8));
        Label knockbackStrengthXLabel=new Label("Knockback Strength X");
        knockbackStrengthXLabel.setPrefWidth(200);

        Spinner<Double> knockbackStrengthXSpinner=new Spinner<>(Float.MIN_VALUE,Float.MAX_VALUE,0.0);
        knockbackStrengthXSpinner.setEditable(true);
        knockbackStrengthXSpinner.getValueFactory().setValue(getKnockbackStrengthX.get(i)[j]);
        knockbackStrengthXSpinner.valueProperty().addListener((obs,oldValue,newValue)->{
            if(newValue!=null){
                getKnockbackStrengthX.get(i)[j]=newValue;
            }
        });

        knockbackStrengthXHBox.getChildren().addAll(knockbackStrengthXLabel,knockbackStrengthXSpinner);
        knockbackStrengthXHBox.setAlignment(Pos.CENTER_LEFT);
        //knockback strength x

        //knockback strength y
        HBox knockbackStrengthYHBox=new HBox(2);
        knockbackStrengthYHBox.setPadding(new Insets(20,0,0,8));
        Label knockbackStrengthYLabel=new Label("Knockback Strength Y");
        knockbackStrengthYLabel.setPrefWidth(200);

        Spinner<Double> knockbackStrengthYSpinner=new Spinner<>(Float.MIN_VALUE,Float.MAX_VALUE,0.0);
        knockbackStrengthYSpinner.setEditable(true);
        knockbackStrengthYSpinner.getValueFactory().setValue(getKnockbackStrengthY.get(i)[j]);
        knockbackStrengthYSpinner.valueProperty().addListener((obs,oldValue,newValue)->{
            if(newValue!=null){
                getKnockbackStrengthY.get(i)[j]=newValue;
            }
        });

        knockbackStrengthYHBox.getChildren().addAll(knockbackStrengthYLabel,knockbackStrengthYSpinner);
        knockbackStrengthYHBox.setAlignment(Pos.CENTER_LEFT);
        //knockback strength y

        //knockback strength z
        HBox knockbackStrengthZHBox=new HBox(2);
        knockbackStrengthZHBox.setPadding(new Insets(20,0,0,8));
        Label knockbackStrengthZLabel=new Label("Knockback Strength Z");
        knockbackStrengthZLabel.setPrefWidth(200);

        Spinner<Double> knockbackStrengthZSpinner=new Spinner<>(Float.MIN_VALUE,Float.MAX_VALUE,0.0);
        knockbackStrengthZSpinner.setEditable(true);
        knockbackStrengthZSpinner.getValueFactory().setValue(getKnockbackStrengthZ.get(i)[j]);
        knockbackStrengthZSpinner.valueProperty().addListener((obs,oldValue,newValue)->{
            if(newValue!=null){
                getKnockbackStrengthZ.get(i)[j]=newValue;
            }
        });

        knockbackStrengthZHBox.getChildren().addAll(knockbackStrengthZLabel,knockbackStrengthZSpinner);
        knockbackStrengthZHBox.setAlignment(Pos.CENTER_LEFT);
        //knockback strength z

        //knockback drag y
        HBox knockbackDragYHBox=new HBox(2);
        knockbackDragYHBox.setPadding(new Insets(20,0,0,8));
        Label knockbackSDragYLabel=new Label("Knockback Strength Y");
        knockbackSDragYLabel.setPrefWidth(200);

        Spinner<Double> knockbackSDragYSpinner=new Spinner<>(Float.MIN_VALUE,Float.MAX_VALUE,0.0);
        knockbackSDragYSpinner.setEditable(true);
        knockbackSDragYSpinner.getValueFactory().setValue(getKnockbackDragY.get(i)[j]);
        knockbackSDragYSpinner.valueProperty().addListener((obs,oldValue,newValue)->{
            if(newValue!=null){
                getKnockbackDragY.get(i)[j]=newValue;
            }
        });

        knockbackDragYHBox.getChildren().addAll(knockbackSDragYLabel,knockbackSDragYSpinner);
        knockbackDragYHBox.setAlignment(Pos.CENTER_LEFT);
        //knockback drag y

        //knockback gravity time
        HBox knockbackGravityTimeHBox=new HBox(2);
        knockbackGravityTimeHBox.setPadding(new Insets(20,0,0,8));
        Label knockbackGravityTimeLabel=new Label("Knockback Gravity Time");
        knockbackGravityTimeLabel.setPrefWidth(200);

        Spinner<Integer> knockbackGravityTimeSpinner=new Spinner<>(Short.MIN_VALUE,Short.MAX_VALUE,0);
        knockbackGravityTimeSpinner.setEditable(true);
        knockbackGravityTimeSpinner.getValueFactory().setValue(getKnockbackGravityTime.get(i)[j]);
        knockbackGravityTimeSpinner.valueProperty().addListener((obs,oldValue,newValue)->{
            if(newValue!=null){
                getKnockbackGravityTime.get(i)[j]=newValue;
            }

        });
        knockbackGravityTimeHBox.getChildren().addAll(knockbackGravityTimeLabel,knockbackGravityTimeSpinner);
        knockbackGravityTimeHBox.setAlignment(Pos.CENTER_LEFT);
        //knockback gravity time

        //knockback gravity time
        HBox victimInvincibilityTimeHBox=new HBox(2);
        victimInvincibilityTimeHBox.setPadding(new Insets(20,0,0,8));
        Label victimInvincibilityTimeLabel=new Label("Victim Invincibility Time");
        victimInvincibilityTimeLabel.setPrefWidth(200);

        Spinner<Integer> victimInvincibilityTimeSpinner=new Spinner<>(Short.MIN_VALUE,Short.MAX_VALUE,0);
        victimInvincibilityTimeSpinner.setEditable(true);
        victimInvincibilityTimeSpinner.getValueFactory().setValue((int)getVictimInvincibilityTime.get(i)[j]);
        victimInvincibilityTimeSpinner.valueProperty().addListener((obs,oldValue,newValue)->{
            if(newValue!=null){
                getVictimInvincibilityTime.get(i)[j]=newValue.shortValue();
            }

        });
        victimInvincibilityTimeHBox.getChildren().addAll(victimInvincibilityTimeLabel,victimInvincibilityTimeSpinner);
        victimInvincibilityTimeHBox.setAlignment(Pos.CENTER_LEFT);
        //knockback gravity time

        pushBackVBox.getChildren().addAll(pushbackStrengthHBox,pushbackAccelerationHBox,userStuntHBox,victimStuntHBox,knockbackDurationHBox,
        knockbackGroundImpactTimeHBox,knockbackRecoveryAfterImpactTimeHBox,knockbackStrengthXHBox,
        knockbackStrengthYHBox,knockbackStrengthZHBox,knockbackDragYHBox,knockbackGravityTimeHBox,victimInvincibilityTimeHBox);
        
        return pushBackVBox;
    }

    private VBox createCameraVBox(int i,int j){
        VBox cameraVBox = new VBox(5);

        //camera shake type
        HBox cameraShakeTypeHBox=new HBox(12);
        cameraShakeTypeHBox.setPadding(new Insets(20,0,0,8));
        Label cameraShakeTypeLabel=new Label("Camera Shake Type");
        cameraShakeTypeLabel.setPrefWidth(150);
        Label cameraShakeTypeIndicatorLabel = new Label();

        Spinner<Integer> cameraShakeTypeSpinner=new Spinner<>(Short.MIN_VALUE,Short.MAX_VALUE,0);
        cameraShakeTypeSpinner.setEditable(true);
        cameraShakeTypeSpinner.getValueFactory().setValue((int)getCameraShakeType.get(i)[j]);
        cameraShakeTypeSpinner.valueProperty().addListener((obs,oldValue,newValue)->{
            if(newValue!=null){
                getCameraShakeType.get(i)[j]=newValue.shortValue();
            }

        });
        cameraShakeTypeIndicatorLabel.setTextFill(Color.CRIMSON);
        cameraShakeTypeIndicatorLabel.textProperty().bind(
            Bindings.when(cameraShakeTypeSpinner.valueProperty().isEqualTo(-1).or(cameraShakeTypeSpinner.valueProperty().isEqualTo(3)).or(cameraShakeTypeSpinner.valueProperty().isEqualTo(4).or(cameraShakeTypeSpinner.valueProperty().isEqualTo(5).or(cameraShakeTypeSpinner.valueProperty().isEqualTo(9))))).then("None").
            otherwise(Bindings.when(cameraShakeTypeSpinner.valueProperty().isEqualTo(0)).then("Rumble").
            otherwise(Bindings.when(cameraShakeTypeSpinner.valueProperty().isEqualTo(1)).then("Heavy Rumble").
            otherwise(Bindings.when(cameraShakeTypeSpinner.valueProperty().isEqualTo(2)).then("Extreme Rumble").
            otherwise(Bindings.when(cameraShakeTypeSpinner.valueProperty().isEqualTo(6).or(cameraShakeTypeSpinner.valueProperty().isEqualTo(10))).then("Camera Zoom").
            otherwise(Bindings.when(cameraShakeTypeSpinner.valueProperty().isEqualTo(7)).then("Static Camera").
            otherwise(Bindings.when(cameraShakeTypeSpinner.valueProperty().isEqualTo(8)).then("Camera Focus").
            otherwise("Unknown")))))))
        );
        cameraShakeTypeHBox.getChildren().addAll(cameraShakeTypeLabel,cameraShakeTypeSpinner,cameraShakeTypeIndicatorLabel);
        cameraShakeTypeHBox.setAlignment(Pos.CENTER_LEFT);
        //camera shake type
        

        //camera shake time
        HBox cameraShakeTimeHBox=new HBox(12);
        cameraShakeTimeHBox.setPadding(new Insets(20,0,0,8));
        Label cameraShakeTimeLabel=new Label("Camera Shake Time");
        cameraShakeTimeLabel.setPrefWidth(150);

        Spinner<Integer> cameraShakeTimeSpinner=new Spinner<>(0,65535,0);
        cameraShakeTimeSpinner.setEditable(true);
        cameraShakeTimeSpinner.getValueFactory().setValue(getCameraShakeTime.get(i)[j]);
        cameraShakeTimeSpinner.valueProperty().addListener((obs,oldValue,newValue)->{
            if(newValue!=null){
                getCameraShakeTime.get(i)[j]=newValue.shortValue();
            }

        });
       
        cameraShakeTimeHBox.getChildren().addAll(cameraShakeTimeLabel,cameraShakeTimeSpinner);
        cameraShakeTimeHBox.setAlignment(Pos.CENTER_LEFT);
        //camera shake time

        //user bpe id
        HBox userBpeIdHBox=new HBox(12);
        userBpeIdHBox.setPadding(new Insets(20,0,0,8));
        Label userBpeIdLabel=new Label("User Bpe Id");
        userBpeIdLabel.setPrefWidth(150);

        Spinner<Integer> userBpeIdSpinner=new Spinner<>(Short.MIN_VALUE,Short.MAX_VALUE,0);
        userBpeIdSpinner.setEditable(true);
        userBpeIdSpinner.getValueFactory().setValue((int)getUserBpeID.get(i)[j]);
        userBpeIdSpinner.valueProperty().addListener((obs,oldValue,newValue)->{
            if(newValue!=null){
                getUserBpeID.get(i)[j]=newValue.shortValue();
            }

        });
       
        userBpeIdHBox.getChildren().addAll(userBpeIdLabel,userBpeIdSpinner);
        userBpeIdHBox.setAlignment(Pos.CENTER_LEFT);
        //user bpe id

        //opponent bpe id
        HBox victimBpeIdHBox=new HBox(12);
        victimBpeIdHBox.setPadding(new Insets(20,0,0,8));
        Label victimBpeIdLabel=new Label("Victim Bpe Id");
        victimBpeIdLabel.setPrefWidth(150);

        Spinner<Integer> victimBpeIdSpinner=new Spinner<>(Short.MIN_VALUE,Short.MAX_VALUE,0);
        victimBpeIdSpinner.setEditable(true);
        victimBpeIdSpinner.getValueFactory().setValue((int)getVictimBpeID.get(i)[j]);
        victimBpeIdSpinner.valueProperty().addListener((obs,oldValue,newValue)->{
            if(newValue!=null){
                getVictimBpeID.get(i)[j]=newValue.shortValue();
            }

        });
       
        victimBpeIdHBox.getChildren().addAll(victimBpeIdLabel,victimBpeIdSpinner);
        victimBpeIdHBox.setAlignment(Pos.CENTER_LEFT);
        //opponent bpe id

        cameraVBox.getChildren().addAll(cameraShakeTypeHBox,cameraShakeTimeHBox,userBpeIdHBox,victimBpeIdHBox);
        
        return cameraVBox;
    }

    private VBox createMiscVBox(int i,int j){
        VBox miscVBox = new VBox(5);

        //transformation type
        HBox transformationTypeHBox=new HBox(12);
        transformationTypeHBox.setPadding(new Insets(20,0,0,8));
        Label transformationTypeLabel=new Label("Transformation Type");
        transformationTypeLabel.setPrefWidth(180);
        Label trasnformationTypeIndicatorLabel = new Label();

        Spinner<Integer> trasnsformationTypeSpinner=new Spinner<>(0,65535,0);
        trasnsformationTypeSpinner.setEditable(true);
        trasnsformationTypeSpinner.getValueFactory().setValue(getTransformationType.get(i)[j]);
        trasnsformationTypeSpinner.valueProperty().addListener((obs,oldValue,newValue)->{
            if(newValue!=null){
                getTransformationType.get(i)[j]=newValue.shortValue();
            }

        });
        trasnformationTypeIndicatorLabel.setTextFill(Color.CRIMSON);
        trasnformationTypeIndicatorLabel.textProperty().bind(
            Bindings.when(trasnsformationTypeSpinner.valueProperty().isEqualTo(0)).then("None").
            otherwise(Bindings.when(trasnsformationTypeSpinner.valueProperty().isEqualTo(1)).then("Candy").
            otherwise("Unknown"))
        );
        transformationTypeHBox.getChildren().addAll(transformationTypeLabel,trasnsformationTypeSpinner,trasnformationTypeIndicatorLabel);
        transformationTypeHBox.setAlignment(Pos.CENTER_LEFT);
        //transformation type

        //aliment Type
        HBox alimentTypeHBox=new HBox(2);
        alimentTypeHBox.setPadding(new Insets(20,0,0,8));

        Label alimentTypeLabel=new Label("Aliment Type");
        alimentTypeLabel.setPrefWidth(190);

        //properties 1
        Label properties1Label=new Label("Properties #1");
        properties1Label.getStyleClass().add("titled-address-label");

        CheckBox unknown1=new CheckBox("Unknown1");
        CheckBox HP_DEF=new CheckBox("HP/DEF");
        CheckBox SPD=new CheckBox("SPD");
        CheckBox target= new CheckBox("Target");

        unknown1.setSelected((getAlimentType.get(i)[j] & 1) != 0);
        HP_DEF.setSelected((getAlimentType.get(i)[j] & 2) != 0);
        SPD.setSelected((getAlimentType.get(i)[j] & 4) != 0);
        target.setSelected((getAlimentType.get(i)[j] & 8) != 0);

        unknown1.selectedProperty().addListener((obs,oldValue,newValue)->{
            if(newValue){
                getAlimentType.get(i)[j]|=1;
            }
            else{
                getAlimentType.get(i)[j]&= ~1;
            }
        });
        HP_DEF.selectedProperty().addListener((obs,oldValue,newValue)->{
            if(newValue){
                getAlimentType.get(i)[j]|=2;
            }
            else{
                getAlimentType.get(i)[j]&=~2;
            }
        });
        SPD.selectedProperty().addListener((obs,oldValue,newValue)->{
            if(newValue){
                getAlimentType.get(i)[j]|=4;
            }
            else{
                getAlimentType.get(i)[j]&=~4;
            }
        });
        target.selectedProperty().addListener((obs,oldValue,newValue)->{
            if(newValue){
                getAlimentType.get(i)[j]|=8;
            }
            else{
                getAlimentType.get(i)[j]&=~8;
            }
        });
        VBox properties1Box = new VBox(2,unknown1,HP_DEF,SPD,target);

        VBox borderContainerProperties1=new VBox(properties1Box);
        borderContainerProperties1.getStyleClass().add("titled-address-box");
        borderContainerProperties1.setPadding(new Insets(12,0,0,0));

        StackPane properties1BoxStackPane = new StackPane();
        properties1BoxStackPane.getChildren().addAll(borderContainerProperties1,properties1Label);

        StackPane.setAlignment(properties1Label, Pos.TOP_LEFT);
        properties1Label.setTranslateY(-8); 
        properties1Label.setTranslateX(10);
        //properties 1

        //properties 2
        Label properties2Label=new Label("Properties #2");
        properties2Label.getStyleClass().add("titled-address-label");

        CheckBox sealAwokenSkill=new CheckBox("Seal Awoken Skill");
        CheckBox unknown6=new CheckBox("Unknown 6");
        CheckBox unknown7=new CheckBox("Unknown 7");
        CheckBox unknown8= new CheckBox("Unknown 8");

        sealAwokenSkill.setSelected((getAlimentType.get(i)[j] & 16) != 0);
        unknown6.setSelected((getAlimentType.get(i)[j] & 32) != 0);
        unknown7.setSelected((getAlimentType.get(i)[j] & 64) != 0);
        unknown8.setSelected((getAlimentType.get(i)[j] & 128) != 0);

        sealAwokenSkill.selectedProperty().addListener((obs,oldValue,newValue)->{
            if(newValue){
                getAlimentType.get(i)[j]|=16;
            }
            else{
                getAlimentType.get(i)[j]&= ~16;
            }
        });
        unknown6.selectedProperty().addListener((obs,oldValue,newValue)->{
            if(newValue){
                getAlimentType.get(i)[j]|=32;
            }
            else{
                getAlimentType.get(i)[j]&=~32;
            }
        });
        unknown7.selectedProperty().addListener((obs,oldValue,newValue)->{
            if(newValue){
                getAlimentType.get(i)[j]|=64;
            }
            else{
                getAlimentType.get(i)[j]&=~64;
            }
        });
        unknown8.selectedProperty().addListener((obs,oldValue,newValue)->{
            if(newValue){
                getAlimentType.get(i)[j]|=128;
            }
            else{
                getAlimentType.get(i)[j]&=~128;
            }
        });
        VBox properties2Box = new VBox(2,sealAwokenSkill,unknown6,unknown7,unknown8);

        VBox borderContainerProperties2=new VBox(properties2Box);
        borderContainerProperties2.getStyleClass().add("titled-address-box");
        borderContainerProperties2.setPadding(new Insets(12,0,0,0));

        StackPane properties2BoxStackPane = new StackPane();
        properties2BoxStackPane.getChildren().addAll(borderContainerProperties2,properties2Label);

        StackPane.setAlignment(properties2Label, Pos.TOP_LEFT);
        properties2Label.setTranslateY(-8); 
        properties2Label.setTranslateX(10);
        //properties 2
        alimentTypeHBox.getChildren().addAll(alimentTypeLabel,properties1BoxStackPane,properties2BoxStackPane);
        alimentTypeHBox.setAlignment(Pos.CENTER_LEFT);
        //aliment type

        //stumble type
        HBox stumbleTypeHBox=new HBox(2);
        stumbleTypeHBox.setPadding(new Insets(20,0,0,8));

        Label stumbleTypeLabel=new Label("Stumble Type");
        stumbleTypeLabel.setPrefWidth(190);

        //stumble group 1
        Label stumbleGroup1Label=new Label("Stumble Group 1");
        stumbleGroup1Label.getStyleClass().add("titled-address-label");

        CheckBox stumbleSet1=new CheckBox("Stumble Set 1");
        CheckBox stumbleSet2=new CheckBox("Stumble Set 2");
        CheckBox stumbleSet3=new CheckBox("Stumble Set 3");
        CheckBox stumbleSet4= new CheckBox("Stumble Set 4");

        stumbleSet1.setSelected((getStumbleType.get(i)[j] & 1) != 0);
        stumbleSet2.setSelected((getStumbleType.get(i)[j] & 2) != 0);
        stumbleSet3.setSelected((getStumbleType.get(i)[j] & 4) != 0);
        stumbleSet4.setSelected((getStumbleType.get(i)[j] & 8) != 0);

        stumbleSet1.selectedProperty().addListener((obs,oldValue,newValue)->{
            if(newValue){
                getStumbleType.get(i)[j]|=1;
            }
            else{
                getStumbleType.get(i)[j]&=~1;
            }
        });
        stumbleSet2.selectedProperty().addListener((obs,oldValue,newValue)->{
            if(newValue){
                getStumbleType.get(i)[j]|=2;
            }
            else{
                getStumbleType.get(i)[j]&=~2;
            }
        });
        stumbleSet3.selectedProperty().addListener((obs,oldValue,newValue)->{
            if(newValue){
                getStumbleType.get(i)[j]|=4;
            }
            else{
                getStumbleType.get(i)[j]&=~4;
            }
        });
        stumbleSet4.selectedProperty().addListener((obs,oldValue,newValue)->{
            if(newValue){
                getStumbleType.get(i)[j]|=8;
            }
            else{
                getStumbleType.get(i)[j]&=~8;
            }
        });
        VBox stumbleGroup1Box = new VBox(2,stumbleSet1,stumbleSet2,stumbleSet3,stumbleSet4);

        VBox borderContainerStumbleGroup1=new VBox(stumbleGroup1Box);
        borderContainerStumbleGroup1.getStyleClass().add("titled-address-box");
        borderContainerStumbleGroup1.setPadding(new Insets(12,0,0,0));

        StackPane stumbleGroup1BoxStackPane = new StackPane();
        stumbleGroup1BoxStackPane.getChildren().addAll(borderContainerStumbleGroup1,stumbleGroup1Label);

        StackPane.setAlignment(stumbleGroup1Label, Pos.TOP_LEFT);
        stumbleGroup1Label.setTranslateY(-8); 
        stumbleGroup1Label.setTranslateX(10);
        //stumble group 1

        //stumble group 2
        Label stumbleGroup2Label=new Label("Stumble Group 2");
        stumbleGroup2Label.getStyleClass().add("titled-address-label");

        CheckBox stumbleSet5=new CheckBox("Stumble Set 5");
        CheckBox stumbleSet6=new CheckBox("Stumble Set 6");
        CheckBox allStumbleSets=new CheckBox("All Stumble Sets");
        CheckBox unknown8StumbleSet= new CheckBox("Unknown 8");

        stumbleSet5.setSelected((getStumbleType.get(i)[j] & 16) != 0);
        stumbleSet6.setSelected((getStumbleType.get(i)[j] & 32) != 0);
        allStumbleSets.setSelected((getStumbleType.get(i)[j] & 64) != 0);
        unknown8StumbleSet.setSelected((getStumbleType.get(i)[j] & 128) != 0);

        stumbleSet5.selectedProperty().addListener((obs,oldValue,newValue)->{
            if(newValue){
                getStumbleType.get(i)[j]|=1;
            }
            else{
                getStumbleType.get(i)[j]&=~1;
            }
        });
        stumbleSet6.selectedProperty().addListener((obs,oldValue,newValue)->{
            if(newValue){
                getStumbleType.get(i)[j]|=2;
            }
            else{
                getStumbleType.get(i)[j]&=~2;
            }
        });
        allStumbleSets.selectedProperty().addListener((obs,oldValue,newValue)->{
            if(newValue){
                getStumbleType.get(i)[j]|=4;
            }
            else{
                getStumbleType.get(i)[j]&=~4;
            }
        });
        unknown8StumbleSet.selectedProperty().addListener((obs,oldValue,newValue)->{
            if(newValue){
                getStumbleType.get(i)[j]|=8;
            }
            else{
                getStumbleType.get(i)[j]&=~8;
            }
        });
        VBox stumbleGroup2Box = new VBox(2,stumbleSet5,stumbleSet6,allStumbleSets,unknown8StumbleSet);

        VBox borderContainerStumbleGroup2=new VBox(stumbleGroup2Box);
        borderContainerStumbleGroup2.getStyleClass().add("titled-address-box");
        borderContainerStumbleGroup2.setPadding(new Insets(12,0,0,0));

        StackPane stumbleGroup2BoxStackPane = new StackPane();
        stumbleGroup2BoxStackPane.getChildren().addAll(borderContainerStumbleGroup2,stumbleGroup2Label);

        StackPane.setAlignment(stumbleGroup2Label, Pos.TOP_LEFT);
        stumbleGroup2Label.setTranslateY(-8); 
        stumbleGroup2Label.setTranslateX(10);
        //stumble group 2

        //stumble group 3
        Label stumbleGroup3Label=new Label("Stumble Group 3");
        stumbleGroup3Label.getStyleClass().add("titled-address-label");

        CheckBox unknown9StumbleSets=new CheckBox("Unknown 9");
        CheckBox unknown10StumbleSets=new CheckBox("Unknown 10");
        CheckBox unknown11StumbleSets=new CheckBox("Unknown 11");
        CheckBox unknown12StumbleSet= new CheckBox("Unknown 12");

        unknown9StumbleSets.setSelected((getStumbleType.get(i)[j] & 16) != 0);
        unknown10StumbleSets.setSelected((getStumbleType.get(i)[j] & 32) != 0);
        unknown11StumbleSets.setSelected((getStumbleType.get(i)[j] & 64) != 0);
        unknown12StumbleSet.setSelected((getStumbleType.get(i)[j] & 128) != 0);

        unknown9StumbleSets.selectedProperty().addListener((obs,oldValue,newValue)->{
            if(newValue){
                getStumbleType.get(i)[j]|=16;
            }
            else{
                getStumbleType.get(i)[j]&=~16;
            }
        });
        unknown10StumbleSets.selectedProperty().addListener((obs,oldValue,newValue)->{
            if(newValue){
                getStumbleType.get(i)[j]|=32;
            }
            else{
                getStumbleType.get(i)[j]&=~32;
            }
        });
        unknown11StumbleSets.selectedProperty().addListener((obs,oldValue,newValue)->{
            if(newValue){
                getStumbleType.get(i)[j]|=64;
            }
            else{
                getStumbleType.get(i)[j]&=~64;
            }
        });
        unknown12StumbleSet.selectedProperty().addListener((obs,oldValue,newValue)->{
            if(newValue){
                getStumbleType.get(i)[j]|=128;
            }
            else{
                getStumbleType.get(i)[j]&=~128;
            }
        });
        VBox stumbleGroup3Box = new VBox(2,unknown9StumbleSets,unknown10StumbleSets,unknown11StumbleSets,unknown12StumbleSet);

        VBox borderContainerStumbleGroup3=new VBox(stumbleGroup3Box);
        borderContainerStumbleGroup3.getStyleClass().add("titled-address-box");
        borderContainerStumbleGroup3.setPadding(new Insets(12,0,0,0));

        StackPane stumbleGroup3BoxStackPane = new StackPane();
        stumbleGroup3BoxStackPane.getChildren().addAll(borderContainerStumbleGroup3,stumbleGroup3Label);

        StackPane.setAlignment(stumbleGroup3Label, Pos.TOP_LEFT);
        stumbleGroup3Label.setTranslateY(-8); 
        stumbleGroup3Label.setTranslateX(10);
        //stumble group 3

       //stumble group 4
        Label stumbleGroup4Label=new Label("Stumble Group 4");
        stumbleGroup4Label.getStyleClass().add("titled-address-label");

        CheckBox unknown13StumbleSets=new CheckBox("Unknown 13");
        CheckBox unknown14StumbleSets=new CheckBox("Unknown 14");
        CheckBox unknown15StumbleSets=new CheckBox("Unknown 15");
        CheckBox unknown16StumbleSet= new CheckBox("Unknown 16");

        unknown13StumbleSets.setSelected((getStumbleType.get(i)[j] & 256) != 0);
        unknown14StumbleSets.setSelected((getStumbleType.get(i)[j] & 512) != 0);
        unknown15StumbleSets.setSelected((getStumbleType.get(i)[j] & 1024) != 0);
        unknown16StumbleSet.setSelected((getStumbleType.get(i)[j] & 2048) != 0);

        unknown13StumbleSets.selectedProperty().addListener((obs,oldValue,newValue)->{
            if(newValue){
                getStumbleType.get(i)[j]|=256;
            }
            else{
                getStumbleType.get(i)[j]&=~256;
            }
        });
        unknown14StumbleSets.selectedProperty().addListener((obs,oldValue,newValue)->{
            if(newValue){
                getStumbleType.get(i)[j]|=512;
            }
            else{
                getStumbleType.get(i)[j]&=~512;
            }
        });
        unknown15StumbleSets.selectedProperty().addListener((obs,oldValue,newValue)->{
            if(newValue){
                getStumbleType.get(i)[j]|=1024;
            }
            else{
                getStumbleType.get(i)[j]&=~1024;
            }
        });
        unknown16StumbleSet.selectedProperty().addListener((obs,oldValue,newValue)->{
            if(newValue){
                getStumbleType.get(i)[j]|=2048;
            }
            else{
                getStumbleType.get(i)[j]&=~2048;
            }
        });
        VBox stumbleGroup4Box = new VBox(2,unknown13StumbleSets,unknown14StumbleSets,unknown15StumbleSets,unknown16StumbleSet);

        VBox borderContainerStumbleGroup4=new VBox(stumbleGroup4Box);
        borderContainerStumbleGroup4.getStyleClass().add("titled-address-box");
        borderContainerStumbleGroup4.setPadding(new Insets(12,0,0,0));

        StackPane stumbleGroup4BoxStackPane = new StackPane();
        stumbleGroup4BoxStackPane.getChildren().addAll(borderContainerStumbleGroup4,stumbleGroup4Label);

        StackPane.setAlignment(stumbleGroup4Label, Pos.TOP_LEFT);
        stumbleGroup4Label.setTranslateY(-8); 
        stumbleGroup4Label.setTranslateX(10);
        //stumble group 4

        stumbleTypeHBox.getChildren().addAll(stumbleTypeLabel,stumbleGroup1BoxStackPane,stumbleGroup2BoxStackPane,stumbleGroup3BoxStackPane,stumbleGroup4BoxStackPane);
        stumbleTypeHBox.setAlignment(Pos.CENTER_LEFT);
        //stumble type
        
        //stamina broken override bdm id
        HBox staminaBrokenOverrideBdmIdHBox=new HBox(12);
        staminaBrokenOverrideBdmIdHBox.setPadding(new Insets(20,0,0,8));
        Label staminaBrokenOverrideBdmIdLabel=new Label("Stamina Broken Override Bdm Id");
        staminaBrokenOverrideBdmIdLabel.setPrefWidth(180);

        Spinner<Integer> staminaBrokenOverrideBdmIdSpinner=new Spinner<>(0,65535,0);
        staminaBrokenOverrideBdmIdSpinner.setEditable(true);
        staminaBrokenOverrideBdmIdSpinner.getValueFactory().setValue((int)getStaminaBrokenOverrideBdmId.get(i)[j]);
        staminaBrokenOverrideBdmIdSpinner.valueProperty().addListener((obs,oldValue,newValue)->{
            if(newValue!=null){
                getStaminaBrokenOverrideBdmId.get(i)[j]=newValue.shortValue();
            }

        });

        staminaBrokenOverrideBdmIdHBox.getChildren().addAll(staminaBrokenOverrideBdmIdLabel,staminaBrokenOverrideBdmIdSpinner);
        staminaBrokenOverrideBdmIdHBox.setAlignment(Pos.CENTER_LEFT);
        //stamina broken override bdm id

        //z vanish enable time
        HBox zVanishEnableTimeHBox=new HBox(12);
        zVanishEnableTimeHBox.setPadding(new Insets(20,0,0,8));
        Label szVanishEnableTimeLabel=new Label("Z Vanish Enable Time");
        szVanishEnableTimeLabel.setPrefWidth(180);

        Spinner<Integer> zVanishEnableTimeSpinner=new Spinner<>(0,65535,0);
        zVanishEnableTimeSpinner.setEditable(true);
        zVanishEnableTimeSpinner.getValueFactory().setValue((int)getZVanishEnableTime.get(i)[j]);
        zVanishEnableTimeSpinner.valueProperty().addListener((obs,oldValue,newValue)->{
            if(newValue!=null){
                getZVanishEnableTime.get(i)[j]=newValue.shortValue();
            }

        });

        zVanishEnableTimeHBox.getChildren().addAll(szVanishEnableTimeLabel,zVanishEnableTimeSpinner);
        zVanishEnableTimeHBox.setAlignment(Pos.CENTER_LEFT);
        //z vanish enable time

        miscVBox.getChildren().addAll(transformationTypeHBox,alimentTypeHBox,stumbleTypeHBox,staminaBrokenOverrideBdmIdHBox,zVanishEnableTimeHBox);

        return miscVBox;
    }

    private VBox createUnknownVBox (int i,int j){
        VBox unknownVBox=new VBox(15);
        unknownVBox.setPadding(new Insets(20,0,0,8));

        //I_02
        HBox unknown02HBox=new HBox(2);
        Label lblI02=new Label("I_02: ");
        lblI02.setPrefWidth(100);
        TextField txtI02=new TextField(String.valueOf(getI02.get(i)[j]));
        txtI02.textProperty().addListener((obs, oldText, newText) -> {
            if (txtI02.getText().contains("-")) {
                return;
            }
            try {
                getI02.get(i)[j]=Integer.parseInt(newText);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        });
        unknown02HBox.getChildren().addAll(lblI02,txtI02);
        unknown02HBox.setAlignment(Pos.CENTER_LEFT);
        
        //I_02

        //I_06
        HBox unknown06HBox=new HBox(2);
        Label lblI06=new Label("I_06: ");
        lblI06.setPrefWidth(100);
        TextField txtI06=new TextField(String.valueOf(getI06.get(i)[j]));
        txtI06.textProperty().addListener((obs, oldText, newText) -> {
            if (txtI06.getText().contains("-")) {
                return;
            }
            try {
                getI06.get(i)[j]=Integer.parseInt(newText);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        });
        unknown06HBox.getChildren().addAll(lblI06,txtI06);
        unknown06HBox.setAlignment(Pos.CENTER_LEFT);
        //I_06

        //F_08
        HBox unknown08HBox=new HBox(2);
        Label lblF08=new Label("F_08: ");
        lblF08.setPrefWidth(100);
        TextField txtF08=new TextField(String.valueOf(getF08.get(i)[j]));
        txtF08.textProperty().addListener((obs, oldText, newText) -> {
            if (txtF08.getText().contains("-")) {
                return;
            }
            try {
                getF08.get(i)[j]=Integer.parseInt(newText);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        });
        unknown08HBox.getChildren().addAll(lblF08,txtF08);
        unknown08HBox.setAlignment(Pos.CENTER_LEFT);
        //F_08

        //I_22
        HBox unknown22HBox=new HBox(2);
        Label lblI22=new Label("I_22: ");
        lblI22.setPrefWidth(100);
        TextField txtI22=new TextField(String.valueOf(getI22.get(i)[j]));
        txtI22.textProperty().addListener((obs, oldText, newText) -> {
            if (txtI22.getText().contains("-")) {
                return;
            }
            try {
                getI22.get(i)[j]=Integer.parseInt(newText);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        });
        unknown22HBox.getChildren().addAll(lblI22,txtI22);
        unknown22HBox.setAlignment(Pos.CENTER_LEFT);
        //I_22

        //I_30
        HBox unknown30HBox=new HBox(2);
        Label lblI30=new Label("I_30: ");
        lblI30.setPrefWidth(100);
        TextField txtI30=new TextField(String.valueOf(getI30.get(i)[j]));
        txtI30.textProperty().addListener((obs, oldText, newText) -> {
            if (txtI30.getText().contains("-")) {
                return;
            }
            try {
                getI30.get(i)[j]=Integer.parseInt(newText);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        });
        unknown30HBox.getChildren().addAll(lblI30,txtI30);
        unknown30HBox.setAlignment(Pos.CENTER_LEFT);
        //I_30

        //I_38
        HBox unknown38HBox=new HBox(2);
        Label lblI38=new Label("I_38: ");
        lblI38.setPrefWidth(100);
        TextField txtI38=new TextField(String.valueOf(getI38.get(i)[j]));
        txtI38.textProperty().addListener((obs, oldText, newText) -> {
            if (txtI38.getText().contains("-")) {
                return;
            }
            try {
                getI38.get(i)[j]=Integer.parseInt(newText);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        });
        unknown38HBox.getChildren().addAll(lblI38,txtI38);
        unknown38HBox.setAlignment(Pos.CENTER_LEFT);
        //I_38

        //I_58
        HBox unknown58HBox=new HBox(2);
        Label lblI58=new Label("I_58: ");
        lblI58.setPrefWidth(100);
        TextField txtI58=new TextField(String.valueOf(getI58.get(i)[j]));
        txtI58.textProperty().addListener((obs, oldText, newText) -> {
            if (txtI58.getText().contains("-")) {
                return;
            }
            try {
                getI58.get(i)[j]=Integer.parseInt(newText);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        });
        unknown58HBox.getChildren().addAll(lblI58,txtI58);
        unknown58HBox.setAlignment(Pos.CENTER_LEFT);
        //I_58

        //I_76
        HBox unknown76HBox=new HBox(2);
        Label lblI76=new Label("I_76: ");
        lblI76.setPrefWidth(100);
        TextField txtI76=new TextField(String.valueOf(getI76.get(i)[j]));
        txtI76.textProperty().addListener((obs, oldText, newText) -> {
            if (txtI76.getText().contains("-")) {
                return;
            }
            try {
                getI58.get(i)[j]=Integer.parseInt(newText);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        });
        unknown76HBox.getChildren().addAll(lblI76,txtI76);
        unknown76HBox.setAlignment(Pos.CENTER_LEFT);
        //I_76

        //I_82
        HBox unknown82HBox=new HBox(2);
        Label lblI82=new Label("I_82: ");
        lblI82.setPrefWidth(100);
        TextField txtI82=new TextField(String.valueOf(getI82.get(i)[j]));
        txtI82.textProperty().addListener((obs, oldText, newText) -> {
            if (txtI82.getText().contains("-")) {
                return;
            }
            try {
                getI82.get(i)[j]=Integer.parseInt(newText);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        });
        unknown82HBox.getChildren().addAll(lblI82,txtI82);
        unknown82HBox.setAlignment(Pos.CENTER_LEFT);
        //I_82

        //I_88
        HBox unknown88HBox=new HBox(2);
        Label lblI88=new Label("I_88: ");
        lblI88.setPrefWidth(100);
        TextField txtI88=new TextField(String.valueOf(getI88.get(i)[j]));
        txtI88.textProperty().addListener((obs, oldText, newText) -> {
            if (txtI88.getText().contains("-")) {
                return;
            }
            try {
                getI88.get(i)[j]=Integer.parseInt(newText);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        });
        unknown88HBox.getChildren().addAll(lblI88,txtI88);
        unknown88HBox.setAlignment(Pos.CENTER_LEFT);
        //I_88

        //I_90
        HBox unknown90HBox=new HBox(2);
        Label lblI90=new Label("I_90: ");
        lblI90.setPrefWidth(100);
        TextField txtI90=new TextField(String.valueOf(getI90.get(i)[j]));
        txtI90.textProperty().addListener((obs, oldText, newText) -> {
            if (txtI90.getText().contains("-")) {
                return;
            }
            try {
                getI90.get(i)[j]=Integer.parseInt(newText);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        });
        unknown90HBox.getChildren().addAll(lblI90,txtI90);
        unknown90HBox.setAlignment(Pos.CENTER_LEFT);
        //I_90

        //I_92
        HBox unknown92HBox=new HBox(2);
        Label lblI92=new Label("I_92: ");
        lblI92.setPrefWidth(100);
        TextField txtI92=new TextField(String.valueOf(getI92.get(i)[j]));
        txtI92.textProperty().addListener((obs, oldText, newText) -> {
            if (txtI92.getText().contains("-")) {
                return;
            }
            try {
                getI92.get(i)[j]=Integer.parseInt(newText);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        });
        unknown92HBox.getChildren().addAll(lblI92,txtI92);
        unknown92HBox.setAlignment(Pos.CENTER_LEFT);
        //I_92

        unknownVBox.getChildren().addAll(unknown02HBox,unknown06HBox,unknown08HBox,unknown22HBox,unknown30HBox,unknown38HBox,unknown58HBox,unknown76HBox,unknown82HBox,unknown88HBox,unknown90HBox,unknown92HBox);


        return unknownVBox;
    }

    public void entriesActionListener(){
        listView.getSelectionModel().selectedItemProperty().addListener((obs,oldValue,newValue)->{
            if(newValue==null){
                return;
            }
            if (listView.getSelectionModel().getSelectedIndex() < 0 || mainTabPane.getSelectionModel().getSelectedIndex() < 0) {
                return; 
            }
          
            ((TabPane) mainTabPane.getTabs().get(mainTabPane.getSelectionModel().getSelectedIndex()).getContent()).getTabs().get(0).setContent(createMainVBox(listView.getSelectionModel().getSelectedIndex(), mainTabPane.getSelectionModel().getSelectedIndex()));
            ((TabPane) mainTabPane.getTabs().get(mainTabPane.getSelectionModel().getSelectedIndex()).getContent()).getTabs().get(1).setContent(createAnimationVBox(listView.getSelectionModel().getSelectedIndex(), mainTabPane.getSelectionModel().getSelectedIndex()));
            ((TabPane) mainTabPane.getTabs().get(mainTabPane.getSelectionModel().getSelectedIndex()).getContent()).getTabs().get(2).setContent(createSoundVBox(listView.getSelectionModel().getSelectedIndex(), mainTabPane.getSelectionModel().getSelectedIndex()));
            ((TabPane) mainTabPane.getTabs().get(mainTabPane.getSelectionModel().getSelectedIndex()).getContent()).getTabs().get(3).setContent(createEffectsScrollPane(listView.getSelectionModel().getSelectedIndex(), mainTabPane.getSelectionModel().getSelectedIndex()));
            ((TabPane) mainTabPane.getTabs().get(mainTabPane.getSelectionModel().getSelectedIndex()).getContent()).getTabs().get(4).setContent(createPushbackVBox(listView.getSelectionModel().getSelectedIndex(), mainTabPane.getSelectionModel().getSelectedIndex()));
            ((TabPane) mainTabPane.getTabs().get(mainTabPane.getSelectionModel().getSelectedIndex()).getContent()).getTabs().get(5).setContent(createCameraVBox(listView.getSelectionModel().getSelectedIndex(), mainTabPane.getSelectionModel().getSelectedIndex()));
            ((TabPane) mainTabPane.getTabs().get(mainTabPane.getSelectionModel().getSelectedIndex()).getContent()).getTabs().get(6).setContent(createMiscVBox(listView.getSelectionModel().getSelectedIndex(), mainTabPane.getSelectionModel().getSelectedIndex()));
            ((TabPane) mainTabPane.getTabs().get(mainTabPane.getSelectionModel().getSelectedIndex()).getContent()).getTabs().get(7).setContent(createUnknownVBox(listView.getSelectionModel().getSelectedIndex(), mainTabPane.getSelectionModel().getSelectedIndex()));

            
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

    public void tabActionListener(){
        mainTabPane.getSelectionModel().selectedItemProperty().addListener((obsevable,oldTab,newTab)->{
            if(newTab==null){
                return;
            }
            if (listView.getSelectionModel().getSelectedIndex() < 0 || mainTabPane.getSelectionModel().getSelectedIndex() < 0) {
                return; 
            }

            ((TabPane) mainTabPane.getTabs().get(mainTabPane.getTabs().indexOf(newTab)).getContent()).getTabs().get(0).setContent(createMainVBox(listView.getSelectionModel().getSelectedIndex(), mainTabPane.getTabs().indexOf(newTab)));
            ((TabPane) mainTabPane.getTabs().get(mainTabPane.getTabs().indexOf(newTab)).getContent()).getTabs().get(1).setContent(createAnimationVBox(listView.getSelectionModel().getSelectedIndex(), mainTabPane.getTabs().indexOf(newTab)));
            ((TabPane) mainTabPane.getTabs().get(mainTabPane.getTabs().indexOf(newTab)).getContent()).getTabs().get(2).setContent(createSoundVBox(listView.getSelectionModel().getSelectedIndex(), mainTabPane.getTabs().indexOf(newTab)));
            ((TabPane) mainTabPane.getTabs().get(mainTabPane.getTabs().indexOf(newTab)).getContent()).getTabs().get(3).setContent(createEffectsScrollPane(listView.getSelectionModel().getSelectedIndex(), mainTabPane.getTabs().indexOf(newTab)));
            ((TabPane) mainTabPane.getTabs().get(mainTabPane.getTabs().indexOf(newTab)).getContent()).getTabs().get(4).setContent(createPushbackVBox(listView.getSelectionModel().getSelectedIndex(), mainTabPane.getTabs().indexOf(newTab)));
            ((TabPane) mainTabPane.getTabs().get(mainTabPane.getTabs().indexOf(newTab)).getContent()).getTabs().get(5).setContent(createCameraVBox(listView.getSelectionModel().getSelectedIndex(), mainTabPane.getTabs().indexOf(newTab)));
            ((TabPane) mainTabPane.getTabs().get(mainTabPane.getTabs().indexOf(newTab)).getContent()).getTabs().get(6).setContent(createMiscVBox(listView.getSelectionModel().getSelectedIndex(), mainTabPane.getTabs().indexOf(newTab)));
            ((TabPane) mainTabPane.getTabs().get(mainTabPane.getTabs().indexOf(newTab)).getContent()).getTabs().get(7).setContent(createUnknownVBox(listView.getSelectionModel().getSelectedIndex(), mainTabPane.getTabs().indexOf(newTab)));
            ((TabPane) newTab.getContent()).getSelectionModel().select(((TabPane) oldTab.getContent()).getSelectionModel().getSelectedIndex());
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

    private void Copy() {

        if (listView.getSelectionModel().getSelectedIndex() < 0) return; 

        copyDamageType = getDamageType.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyI02 = getI02.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyDamageAmount = getDamageAmount.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyI06 = getI06.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyF08 = getF08.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyAcbType = getAcbType.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyCueId = getCueId.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyEffect1Id = getEffect1Id.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyEffect1SkillId = getEffect1SkillId.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyEffect1EepkType = getEffect1EepkType.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyI22 = getI22.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyEffect2Id = getEffect2Id.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyEffect2SkillId = getEffect2SkillId.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyEffect2EepkType = getEffect2EepkType.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyI30 = getI30.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyEffect3Id = getEffect3Id.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyEffect3SkillId = getEffect3SkillId.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyEffect3EepkType = getEffect3EepkType.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyI38 = getI38.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyPushbackStrength = getPushbackStrength.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyPushbackAcceleration = getPushbackAcceleration.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyUserStunt = getUserStunt.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyKnockbackDuration = getKnockbackDuration.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyKnockbackRecoveryAfterImpactTime = getKnockbackRecoveryAfterImpactTime.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyKnockbackGroundImpactTime = getKnockbackGroundImpactTime.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyI58 = getI58.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyVictimStunt = getVictimStunt.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyKnockbackStrengthX = getKnockbackStrengthX.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyKnockbackStrengthY = getKnockbackStrengthY.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyKnockbackStrengthZ = getKnockbackStrengthZ.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyKnockbackDragY = getKnockbackDragY.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyI76 = getI76.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyKnockbackGravityTime = getKnockbackGravityTime.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyVictimInvincibilityTime = getVictimInvincibilityTime.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyI82 = getI82.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyTransformationType = getTransformationType.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyAlimentType = getAlimentType.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyI88 = getI88.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyI90 = getI90.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyI92 = getI92.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyDamageSpecial = getDamageSpecial.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyDamageSpecial2 = getDamageSpecial2.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyDamageSpecial3 = getDamageSpecial3.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyStumbleType = getStumbleType.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copySecondaryType = getSecondaryType.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyCameraShakeType = getCameraShakeType.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyCameraShakeTime = getCameraShakeTime.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyUserBpeID = getUserBpeID.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyVictimBpeID = getVictimBpeID.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyStaminaBrokenOverrideBdmId = getStaminaBrokenOverrideBdmId.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyZVanishEnableTime = getZVanishEnableTime.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyUserAnimationTime = getUserAnimationTime.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyVictimAnimationTime = getVictimAnimationTime.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyUserAnimationSpeed = getUserAnimationSpeed.get(listView.getSelectionModel().getSelectedIndex()).clone();
        copyVictimAnimationSpeed = getVictimAnimationSpeed.get(listView.getSelectionModel().getSelectedIndex()).clone();
    }

    private void Paste() {
        // Safety check to ensure an item is actually selected and something was copied
        if (listView.getSelectionModel().getSelectedIndex() < 0 || copyDamageType == null) return; 

        getDamageType.set(listView.getSelectionModel().getSelectedIndex(), copyDamageType.clone());
        getI02.set(listView.getSelectionModel().getSelectedIndex(), copyI02.clone());
        getDamageAmount.set(listView.getSelectionModel().getSelectedIndex(), copyDamageAmount.clone());
        getI06.set(listView.getSelectionModel().getSelectedIndex(), copyI06.clone());
        getF08.set(listView.getSelectionModel().getSelectedIndex(), copyF08.clone());
        getAcbType.set(listView.getSelectionModel().getSelectedIndex(), copyAcbType.clone());
        getCueId.set(listView.getSelectionModel().getSelectedIndex(), copyCueId.clone());
        getEffect1Id.set(listView.getSelectionModel().getSelectedIndex(), copyEffect1Id.clone());
        getEffect1SkillId.set(listView.getSelectionModel().getSelectedIndex(), copyEffect1SkillId.clone());
        getEffect1EepkType.set(listView.getSelectionModel().getSelectedIndex(), copyEffect1EepkType.clone());
        getI22.set(listView.getSelectionModel().getSelectedIndex(), copyI22.clone());
        getEffect2Id.set(listView.getSelectionModel().getSelectedIndex(), copyEffect2Id.clone());
        getEffect2SkillId.set(listView.getSelectionModel().getSelectedIndex(), copyEffect2SkillId.clone());
        getEffect2EepkType.set(listView.getSelectionModel().getSelectedIndex(), copyEffect2EepkType.clone());
        getI30.set(listView.getSelectionModel().getSelectedIndex(), copyI30.clone());
        getEffect3Id.set(listView.getSelectionModel().getSelectedIndex(), copyEffect3Id.clone());
        getEffect3SkillId.set(listView.getSelectionModel().getSelectedIndex(), copyEffect3SkillId.clone());
        getEffect3EepkType.set(listView.getSelectionModel().getSelectedIndex(), copyEffect3EepkType.clone());
        getI38.set(listView.getSelectionModel().getSelectedIndex(), copyI38.clone());
        getPushbackStrength.set(listView.getSelectionModel().getSelectedIndex(), copyPushbackStrength.clone());
        getPushbackAcceleration.set(listView.getSelectionModel().getSelectedIndex(), copyPushbackAcceleration.clone());
        getUserStunt.set(listView.getSelectionModel().getSelectedIndex(), copyUserStunt.clone());
        getKnockbackDuration.set(listView.getSelectionModel().getSelectedIndex(), copyKnockbackDuration.clone());
        getKnockbackRecoveryAfterImpactTime.set(listView.getSelectionModel().getSelectedIndex(), copyKnockbackRecoveryAfterImpactTime.clone());
        getKnockbackGroundImpactTime.set(listView.getSelectionModel().getSelectedIndex(), copyKnockbackGroundImpactTime.clone());
        getI58.set(listView.getSelectionModel().getSelectedIndex(), copyI58.clone());
        getVictimStunt.set(listView.getSelectionModel().getSelectedIndex(), copyVictimStunt.clone());
        getKnockbackStrengthX.set(listView.getSelectionModel().getSelectedIndex(), copyKnockbackStrengthX.clone());
        getKnockbackStrengthY.set(listView.getSelectionModel().getSelectedIndex(), copyKnockbackStrengthY.clone());
        getKnockbackStrengthZ.set(listView.getSelectionModel().getSelectedIndex(), copyKnockbackStrengthZ.clone());
        getKnockbackDragY.set(listView.getSelectionModel().getSelectedIndex(), copyKnockbackDragY.clone());
        getI76.set(listView.getSelectionModel().getSelectedIndex(), copyI76.clone());
        getKnockbackGravityTime.set(listView.getSelectionModel().getSelectedIndex(), copyKnockbackGravityTime.clone());
        getVictimInvincibilityTime.set(listView.getSelectionModel().getSelectedIndex(), copyVictimInvincibilityTime.clone());
        getI82.set(listView.getSelectionModel().getSelectedIndex(), copyI82.clone());
        getTransformationType.set(listView.getSelectionModel().getSelectedIndex(), copyTransformationType.clone());
        getAlimentType.set(listView.getSelectionModel().getSelectedIndex(), copyAlimentType.clone());
        getI88.set(listView.getSelectionModel().getSelectedIndex(), copyI88.clone());
        getI90.set(listView.getSelectionModel().getSelectedIndex(), copyI90.clone());
        getI92.set(listView.getSelectionModel().getSelectedIndex(), copyI92.clone());
        getDamageSpecial.set(listView.getSelectionModel().getSelectedIndex(), copyDamageSpecial.clone());
        getDamageSpecial2.set(listView.getSelectionModel().getSelectedIndex(), copyDamageSpecial2.clone());
        getDamageSpecial3.set(listView.getSelectionModel().getSelectedIndex(), copyDamageSpecial3.clone());
        getStumbleType.set(listView.getSelectionModel().getSelectedIndex(), copyStumbleType.clone());
        getSecondaryType.set(listView.getSelectionModel().getSelectedIndex(), copySecondaryType.clone());
        getCameraShakeType.set(listView.getSelectionModel().getSelectedIndex(), copyCameraShakeType.clone());
        getCameraShakeTime.set(listView.getSelectionModel().getSelectedIndex(), copyCameraShakeTime.clone());
        getUserBpeID.set(listView.getSelectionModel().getSelectedIndex(), copyUserBpeID.clone());
        getVictimBpeID.set(listView.getSelectionModel().getSelectedIndex(), copyVictimBpeID.clone());
        getStaminaBrokenOverrideBdmId.set(listView.getSelectionModel().getSelectedIndex(), copyStaminaBrokenOverrideBdmId.clone());
        getZVanishEnableTime.set(listView.getSelectionModel().getSelectedIndex(), copyZVanishEnableTime.clone());
        getUserAnimationTime.set(listView.getSelectionModel().getSelectedIndex(), copyUserAnimationTime.clone());
        getVictimAnimationTime.set(listView.getSelectionModel().getSelectedIndex(), copyVictimAnimationTime.clone());
        getUserAnimationSpeed.set(listView.getSelectionModel().getSelectedIndex(), copyUserAnimationSpeed.clone());
        getVictimAnimationSpeed.set(listView.getSelectionModel().getSelectedIndex(), copyVictimAnimationSpeed.clone());

        ((TabPane) mainTabPane.getTabs().get(mainTabPane.getSelectionModel().getSelectedIndex()).getContent()).getTabs().get(0).setContent(createMainVBox(listView.getSelectionModel().getSelectedIndex(), mainTabPane.getSelectionModel().getSelectedIndex()));
        ((TabPane) mainTabPane.getTabs().get(mainTabPane.getSelectionModel().getSelectedIndex()).getContent()).getTabs().get(1).setContent(createAnimationVBox(listView.getSelectionModel().getSelectedIndex(), mainTabPane.getSelectionModel().getSelectedIndex()));
        ((TabPane) mainTabPane.getTabs().get(mainTabPane.getSelectionModel().getSelectedIndex()).getContent()).getTabs().get(2).setContent(createSoundVBox(listView.getSelectionModel().getSelectedIndex(), mainTabPane.getSelectionModel().getSelectedIndex()));
        ((TabPane) mainTabPane.getTabs().get(mainTabPane.getSelectionModel().getSelectedIndex()).getContent()).getTabs().get(3).setContent(createEffectsScrollPane(listView.getSelectionModel().getSelectedIndex(), mainTabPane.getSelectionModel().getSelectedIndex()));
        ((TabPane) mainTabPane.getTabs().get(mainTabPane.getSelectionModel().getSelectedIndex()).getContent()).getTabs().get(4).setContent(createPushbackVBox(listView.getSelectionModel().getSelectedIndex(), mainTabPane.getSelectionModel().getSelectedIndex()));
        ((TabPane) mainTabPane.getTabs().get(mainTabPane.getSelectionModel().getSelectedIndex()).getContent()).getTabs().get(5).setContent(createCameraVBox(listView.getSelectionModel().getSelectedIndex(), mainTabPane.getSelectionModel().getSelectedIndex()));
        ((TabPane) mainTabPane.getTabs().get(mainTabPane.getSelectionModel().getSelectedIndex()).getContent()).getTabs().get(6).setContent(createMiscVBox(listView.getSelectionModel().getSelectedIndex(), mainTabPane.getSelectionModel().getSelectedIndex()));
        ((TabPane) mainTabPane.getTabs().get(mainTabPane.getSelectionModel().getSelectedIndex()).getContent()).getTabs().get(7).setContent(createUnknownVBox(listView.getSelectionModel().getSelectedIndex(), mainTabPane.getSelectionModel().getSelectedIndex()));
    }

    private void Delete() {
        if (listView.getSelectionModel().getSelectedIndex() < 0) return;

        getDamageType.remove(listView.getSelectionModel().getSelectedIndex());
        getI02.remove(listView.getSelectionModel().getSelectedIndex());
        getDamageAmount.remove(listView.getSelectionModel().getSelectedIndex());
        getI06.remove(listView.getSelectionModel().getSelectedIndex());
        getF08.remove(listView.getSelectionModel().getSelectedIndex());
        getAcbType.remove(listView.getSelectionModel().getSelectedIndex());
        getCueId.remove(listView.getSelectionModel().getSelectedIndex());
        getEffect1Id.remove(listView.getSelectionModel().getSelectedIndex());
        getEffect1SkillId.remove(listView.getSelectionModel().getSelectedIndex());
        getEffect1EepkType.remove(listView.getSelectionModel().getSelectedIndex());
        getI22.remove(listView.getSelectionModel().getSelectedIndex());
        getEffect2Id.remove(listView.getSelectionModel().getSelectedIndex());
        getEffect2SkillId.remove(listView.getSelectionModel().getSelectedIndex());
        getEffect2EepkType.remove(listView.getSelectionModel().getSelectedIndex());
        getI30.remove(listView.getSelectionModel().getSelectedIndex());
        getEffect3Id.remove(listView.getSelectionModel().getSelectedIndex());
        getEffect3SkillId.remove(listView.getSelectionModel().getSelectedIndex());
        getEffect3EepkType.remove(listView.getSelectionModel().getSelectedIndex());
        getI38.remove(listView.getSelectionModel().getSelectedIndex());
        getPushbackStrength.remove(listView.getSelectionModel().getSelectedIndex());
        getPushbackAcceleration.remove(listView.getSelectionModel().getSelectedIndex());
        getUserStunt.remove(listView.getSelectionModel().getSelectedIndex());
        getKnockbackDuration.remove(listView.getSelectionModel().getSelectedIndex());
        getKnockbackRecoveryAfterImpactTime.remove(listView.getSelectionModel().getSelectedIndex());
        getKnockbackGroundImpactTime.remove(listView.getSelectionModel().getSelectedIndex());
        getI58.remove(listView.getSelectionModel().getSelectedIndex());
        getVictimStunt.remove(listView.getSelectionModel().getSelectedIndex());
        getKnockbackStrengthX.remove(listView.getSelectionModel().getSelectedIndex());
        getKnockbackStrengthY.remove(listView.getSelectionModel().getSelectedIndex());
        getKnockbackStrengthZ.remove(listView.getSelectionModel().getSelectedIndex());
        getKnockbackDragY.remove(listView.getSelectionModel().getSelectedIndex());
        getI76.remove(listView.getSelectionModel().getSelectedIndex());
        getKnockbackGravityTime.remove(listView.getSelectionModel().getSelectedIndex());
        getVictimInvincibilityTime.remove(listView.getSelectionModel().getSelectedIndex());
        getI82.remove(listView.getSelectionModel().getSelectedIndex());
        getTransformationType.remove(listView.getSelectionModel().getSelectedIndex());
        getAlimentType.remove(listView.getSelectionModel().getSelectedIndex());
        getI88.remove(listView.getSelectionModel().getSelectedIndex());
        getI90.remove(listView.getSelectionModel().getSelectedIndex());
        getI92.remove(listView.getSelectionModel().getSelectedIndex());
        getDamageSpecial.remove(listView.getSelectionModel().getSelectedIndex());
        getDamageSpecial2.remove(listView.getSelectionModel().getSelectedIndex());
        getDamageSpecial3.remove(listView.getSelectionModel().getSelectedIndex());
        getStumbleType.remove(listView.getSelectionModel().getSelectedIndex());
        getSecondaryType.remove(listView.getSelectionModel().getSelectedIndex());
        getCameraShakeType.remove(listView.getSelectionModel().getSelectedIndex());
        getCameraShakeTime.remove(listView.getSelectionModel().getSelectedIndex());
        getUserBpeID.remove(listView.getSelectionModel().getSelectedIndex());
        getVictimBpeID.remove(listView.getSelectionModel().getSelectedIndex());
        getStaminaBrokenOverrideBdmId.remove(listView.getSelectionModel().getSelectedIndex());
        getZVanishEnableTime.remove(listView.getSelectionModel().getSelectedIndex());
        getUserAnimationTime.remove(listView.getSelectionModel().getSelectedIndex());
        getVictimAnimationTime.remove(listView.getSelectionModel().getSelectedIndex());
        getUserAnimationSpeed.remove(listView.getSelectionModel().getSelectedIndex());
        getVictimAnimationSpeed.remove(listView.getSelectionModel().getSelectedIndex());

        listView.getItems().remove(listView.getSelectionModel().getSelectedIndex());

        for(int i=0;i<listView.getItems().size();i++){
            allEntries.set(i,new String("Entry: "+i));
            listView.getItems().set(i,allEntries.get(i));
        }
    }

   private void Append() {
        if (listView.getSelectionModel().getSelectedIndex() < 0) return;

        getDamageType.add(listView.getSelectionModel().getSelectedIndex() + 1, new int[10]);
        getI02.add(listView.getSelectionModel().getSelectedIndex() + 1, new int[10]);
        getDamageAmount.add(listView.getSelectionModel().getSelectedIndex() + 1, new int[10]);
        getI06.add(listView.getSelectionModel().getSelectedIndex() + 1, new int[10]);
        getF08.add(listView.getSelectionModel().getSelectedIndex() + 1, new double[10]);
        getAcbType.add(listView.getSelectionModel().getSelectedIndex() + 1, new int[10]);
        getCueId.add(listView.getSelectionModel().getSelectedIndex() + 1, new short[10]);
        getEffect1Id.add(listView.getSelectionModel().getSelectedIndex() + 1, new short[10]);
        getEffect1SkillId.add(listView.getSelectionModel().getSelectedIndex() + 1, new int[10]);
        getEffect1EepkType.add(listView.getSelectionModel().getSelectedIndex() + 1, new int[10]);
        getI22.add(listView.getSelectionModel().getSelectedIndex() + 1, new int[10]);
        getEffect2Id.add(listView.getSelectionModel().getSelectedIndex() + 1, new short[10]);
        getEffect2SkillId.add(listView.getSelectionModel().getSelectedIndex() + 1, new int[10]);
        getEffect2EepkType.add(listView.getSelectionModel().getSelectedIndex() + 1, new int[10]);
        getI30.add(listView.getSelectionModel().getSelectedIndex() + 1, new int[10]);
        getEffect3Id.add(listView.getSelectionModel().getSelectedIndex() + 1, new short[10]);
        getEffect3SkillId.add(listView.getSelectionModel().getSelectedIndex() + 1, new int[10]);
        getEffect3EepkType.add(listView.getSelectionModel().getSelectedIndex() + 1, new int[10]);
        getI38.add(listView.getSelectionModel().getSelectedIndex() + 1, new int[10]);
        getPushbackStrength.add(listView.getSelectionModel().getSelectedIndex() + 1, new double[10]);
        getPushbackAcceleration.add(listView.getSelectionModel().getSelectedIndex() + 1, new double[10]);
        getUserStunt.add(listView.getSelectionModel().getSelectedIndex() + 1, new int[10]);
        getKnockbackDuration.add(listView.getSelectionModel().getSelectedIndex() + 1, new int[10]);
        getKnockbackRecoveryAfterImpactTime.add(listView.getSelectionModel().getSelectedIndex() + 1, new int[10]);
        getKnockbackGroundImpactTime.add(listView.getSelectionModel().getSelectedIndex() + 1, new int[10]);
        getI58.add(listView.getSelectionModel().getSelectedIndex() + 1, new int[10]);
        getVictimStunt.add(listView.getSelectionModel().getSelectedIndex() + 1, new int[10]);
        getKnockbackStrengthX.add(listView.getSelectionModel().getSelectedIndex() + 1, new double[10]);
        getKnockbackStrengthY.add(listView.getSelectionModel().getSelectedIndex() + 1, new double[10]);
        getKnockbackStrengthZ.add(listView.getSelectionModel().getSelectedIndex() + 1, new double[10]);
        getKnockbackDragY.add(listView.getSelectionModel().getSelectedIndex() + 1, new double[10]);
        getI76.add(listView.getSelectionModel().getSelectedIndex() + 1, new int[10]);
        getKnockbackGravityTime.add(listView.getSelectionModel().getSelectedIndex() + 1, new int[10]);
        getVictimInvincibilityTime.add(listView.getSelectionModel().getSelectedIndex() + 1, new short[10]);
        getI82.add(listView.getSelectionModel().getSelectedIndex() + 1, new int[10]);
        getTransformationType.add(listView.getSelectionModel().getSelectedIndex() + 1, new int[10]);
        getAlimentType.add(listView.getSelectionModel().getSelectedIndex() + 1, new short[10]);
        getI88.add(listView.getSelectionModel().getSelectedIndex() + 1, new int[10]);
        getI90.add(listView.getSelectionModel().getSelectedIndex() + 1, new int[10]);
        getI92.add(listView.getSelectionModel().getSelectedIndex() + 1, new int[10]);
        getDamageSpecial.add(listView.getSelectionModel().getSelectedIndex() + 1, new int[10]);
        getDamageSpecial2.add(listView.getSelectionModel().getSelectedIndex() + 1, new int[10]);
        getDamageSpecial3.add(listView.getSelectionModel().getSelectedIndex() + 1, new int[10]);
        getStumbleType.add(listView.getSelectionModel().getSelectedIndex() + 1, new int[10]);
        getSecondaryType.add(listView.getSelectionModel().getSelectedIndex() + 1, new int[10]);
        getCameraShakeType.add(listView.getSelectionModel().getSelectedIndex() + 1, new short[10]);
        getCameraShakeTime.add(listView.getSelectionModel().getSelectedIndex() + 1, new int[10]);
        getUserBpeID.add(listView.getSelectionModel().getSelectedIndex() + 1, new short[10]);
        getVictimBpeID.add(listView.getSelectionModel().getSelectedIndex() + 1, new short[10]);
        getStaminaBrokenOverrideBdmId.add(listView.getSelectionModel().getSelectedIndex() + 1, new short[10]);
        getZVanishEnableTime.add(listView.getSelectionModel().getSelectedIndex() + 1, new int[10]);
        getUserAnimationTime.add(listView.getSelectionModel().getSelectedIndex() + 1, new int[10]);
        getVictimAnimationTime.add(listView.getSelectionModel().getSelectedIndex() + 1, new int[10]);
        getUserAnimationSpeed.add(listView.getSelectionModel().getSelectedIndex() + 1, new double[10]);
        getVictimAnimationSpeed.add(listView.getSelectionModel().getSelectedIndex() + 1, new double[10]);
        allEntries.add(new String("Entry: "+listView.getItems().size()));
        listView.getItems().add("Entry: " + listView.getItems().size());
    }

    private void Insert() {
        if (listView.getSelectionModel().getSelectedIndex() > 0) {
            getDamageType.add(listView.getSelectionModel().getSelectedIndex() - 1, new int[10]);
            getI02.add(listView.getSelectionModel().getSelectedIndex() - 1, new int[10]);
            getDamageAmount.add(listView.getSelectionModel().getSelectedIndex() - 1, new int[10]);
            getI06.add(listView.getSelectionModel().getSelectedIndex() - 1, new int[10]);
            getF08.add(listView.getSelectionModel().getSelectedIndex() - 1, new double[10]);
            getAcbType.add(listView.getSelectionModel().getSelectedIndex() - 1, new int[10]);
            getCueId.add(listView.getSelectionModel().getSelectedIndex() - 1, new short[10]);
            getEffect1Id.add(listView.getSelectionModel().getSelectedIndex() - 1, new short[10]);
            getEffect1SkillId.add(listView.getSelectionModel().getSelectedIndex() - 1, new int[10]);
            getEffect1EepkType.add(listView.getSelectionModel().getSelectedIndex() - 1, new int[10]);
            getI22.add(listView.getSelectionModel().getSelectedIndex() - 1, new int[10]);
            getEffect2Id.add(listView.getSelectionModel().getSelectedIndex() - 1, new short[10]);
            getEffect2SkillId.add(listView.getSelectionModel().getSelectedIndex() - 1, new int[10]);
            getEffect2EepkType.add(listView.getSelectionModel().getSelectedIndex() - 1, new int[10]);
            getI30.add(listView.getSelectionModel().getSelectedIndex() - 1, new int[10]);
            getEffect3Id.add(listView.getSelectionModel().getSelectedIndex() - 1, new short[10]);
            getEffect3SkillId.add(listView.getSelectionModel().getSelectedIndex() - 1, new int[10]);
            getEffect3EepkType.add(listView.getSelectionModel().getSelectedIndex() - 1, new int[10]);
            getI38.add(listView.getSelectionModel().getSelectedIndex() - 1, new int[10]);
            getPushbackStrength.add(listView.getSelectionModel().getSelectedIndex() - 1, new double[10]);
            getPushbackAcceleration.add(listView.getSelectionModel().getSelectedIndex() - 1, new double[10]);
            getUserStunt.add(listView.getSelectionModel().getSelectedIndex() - 1, new int[10]);
            getKnockbackDuration.add(listView.getSelectionModel().getSelectedIndex() - 1, new int[10]);
            getKnockbackRecoveryAfterImpactTime.add(listView.getSelectionModel().getSelectedIndex() - 1, new int[10]);
            getKnockbackGroundImpactTime.add(listView.getSelectionModel().getSelectedIndex() - 1, new int[10]);
            getI58.add(listView.getSelectionModel().getSelectedIndex() - 1, new int[10]);
            getVictimStunt.add(listView.getSelectionModel().getSelectedIndex() - 1, new int[10]);
            getKnockbackStrengthX.add(listView.getSelectionModel().getSelectedIndex() - 1, new double[10]);
            getKnockbackStrengthY.add(listView.getSelectionModel().getSelectedIndex() - 1, new double[10]);
            getKnockbackStrengthZ.add(listView.getSelectionModel().getSelectedIndex() - 1, new double[10]);
            getKnockbackDragY.add(listView.getSelectionModel().getSelectedIndex() - 1, new double[10]);
            getI76.add(listView.getSelectionModel().getSelectedIndex() - 1, new int[10]);
            getKnockbackGravityTime.add(listView.getSelectionModel().getSelectedIndex() - 1, new int[10]);
            getVictimInvincibilityTime.add(listView.getSelectionModel().getSelectedIndex() - 1, new short[10]);
            getI82.add(listView.getSelectionModel().getSelectedIndex() - 1, new int[10]);
            getTransformationType.add(listView.getSelectionModel().getSelectedIndex() - 1, new int[10]);
            getAlimentType.add(listView.getSelectionModel().getSelectedIndex() - 1, new short[10]);
            getI88.add(listView.getSelectionModel().getSelectedIndex() - 1, new int[10]);
            getI90.add(listView.getSelectionModel().getSelectedIndex() - 1, new int[10]);
            getI92.add(listView.getSelectionModel().getSelectedIndex() - 1, new int[10]);
            getDamageSpecial.add(listView.getSelectionModel().getSelectedIndex() - 1, new int[10]);
            getDamageSpecial2.add(listView.getSelectionModel().getSelectedIndex() - 1, new int[10]);
            getDamageSpecial3.add(listView.getSelectionModel().getSelectedIndex() - 1, new int[10]);
            getStumbleType.add(listView.getSelectionModel().getSelectedIndex() - 1, new int[10]);
            getSecondaryType.add(listView.getSelectionModel().getSelectedIndex() - 1, new int[10]);
            getCameraShakeType.add(listView.getSelectionModel().getSelectedIndex() - 1, new short[10]);
            getCameraShakeTime.add(listView.getSelectionModel().getSelectedIndex() - 1, new int[10]);
            getUserBpeID.add(listView.getSelectionModel().getSelectedIndex() - 1, new short[10]);
            getVictimBpeID.add(listView.getSelectionModel().getSelectedIndex() - 1, new short[10]);
            getStaminaBrokenOverrideBdmId.add(listView.getSelectionModel().getSelectedIndex() - 1, new short[10]);
            getZVanishEnableTime.add(listView.getSelectionModel().getSelectedIndex() - 1, new int[10]);
            getUserAnimationTime.add(listView.getSelectionModel().getSelectedIndex() - 1, new int[10]);
            getVictimAnimationTime.add(listView.getSelectionModel().getSelectedIndex() - 1, new int[10]);
            getUserAnimationSpeed.add(listView.getSelectionModel().getSelectedIndex() - 1, new double[10]);
            getVictimAnimationSpeed.add(listView.getSelectionModel().getSelectedIndex() - 1, new double[10]);
            allEntries.add(new String("Entry: "+listView.getItems().size()));
            listView.getItems().add("Entry: " + listView.getItems().size());
        } 
        else if (listView.getSelectionModel().getSelectedIndex() == 0) {
            getDamageType.add(listView.getSelectionModel().getSelectedIndex(), new int[10]);
            getI02.add(listView.getSelectionModel().getSelectedIndex(), new int[10]);
            getDamageAmount.add(listView.getSelectionModel().getSelectedIndex(), new int[10]);
            getI06.add(listView.getSelectionModel().getSelectedIndex(), new int[10]);
            getF08.add(listView.getSelectionModel().getSelectedIndex(), new double[10]);
            getAcbType.add(listView.getSelectionModel().getSelectedIndex(), new int[10]);
            getCueId.add(listView.getSelectionModel().getSelectedIndex(), new short[10]);
            getEffect1Id.add(listView.getSelectionModel().getSelectedIndex(), new short[10]);
            getEffect1SkillId.add(listView.getSelectionModel().getSelectedIndex(), new int[10]);
            getEffect1EepkType.add(listView.getSelectionModel().getSelectedIndex(), new int[10]);
            getI22.add(listView.getSelectionModel().getSelectedIndex(), new int[10]);
            getEffect2Id.add(listView.getSelectionModel().getSelectedIndex(), new short[10]);
            getEffect2SkillId.add(listView.getSelectionModel().getSelectedIndex(), new int[10]);
            getEffect2EepkType.add(listView.getSelectionModel().getSelectedIndex(), new int[10]);
            getI30.add(listView.getSelectionModel().getSelectedIndex(), new int[10]);
            getEffect3Id.add(listView.getSelectionModel().getSelectedIndex(), new short[10]);
            getEffect3SkillId.add(listView.getSelectionModel().getSelectedIndex(), new int[10]);
            getEffect3EepkType.add(listView.getSelectionModel().getSelectedIndex(), new int[10]);
            getI38.add(listView.getSelectionModel().getSelectedIndex(), new int[10]);
            getPushbackStrength.add(listView.getSelectionModel().getSelectedIndex(), new double[10]);
            getPushbackAcceleration.add(listView.getSelectionModel().getSelectedIndex(), new double[10]);
            getUserStunt.add(listView.getSelectionModel().getSelectedIndex(), new int[10]);
            getKnockbackDuration.add(listView.getSelectionModel().getSelectedIndex(), new int[10]);
            getKnockbackRecoveryAfterImpactTime.add(listView.getSelectionModel().getSelectedIndex(), new int[10]);
            getKnockbackGroundImpactTime.add(listView.getSelectionModel().getSelectedIndex(), new int[10]);
            getI58.add(listView.getSelectionModel().getSelectedIndex(), new int[10]);
            getVictimStunt.add(listView.getSelectionModel().getSelectedIndex(), new int[10]);
            getKnockbackStrengthX.add(listView.getSelectionModel().getSelectedIndex(), new double[10]);
            getKnockbackStrengthY.add(listView.getSelectionModel().getSelectedIndex(), new double[10]);
            getKnockbackStrengthZ.add(listView.getSelectionModel().getSelectedIndex(), new double[10]);
            getKnockbackDragY.add(listView.getSelectionModel().getSelectedIndex(), new double[10]);
            getI76.add(listView.getSelectionModel().getSelectedIndex(), new int[10]);
            getKnockbackGravityTime.add(listView.getSelectionModel().getSelectedIndex(), new int[10]);
            getVictimInvincibilityTime.add(listView.getSelectionModel().getSelectedIndex(), new short[10]);
            getI82.add(listView.getSelectionModel().getSelectedIndex(), new int[10]);
            getTransformationType.add(listView.getSelectionModel().getSelectedIndex(), new int[10]);
            getAlimentType.add(listView.getSelectionModel().getSelectedIndex(), new short[10]);
            getI88.add(listView.getSelectionModel().getSelectedIndex(), new int[10]);
            getI90.add(listView.getSelectionModel().getSelectedIndex(), new int[10]);
            getI92.add(listView.getSelectionModel().getSelectedIndex(), new int[10]);
            getDamageSpecial.add(listView.getSelectionModel().getSelectedIndex(), new int[10]);
            getDamageSpecial2.add(listView.getSelectionModel().getSelectedIndex(), new int[10]);
            getDamageSpecial3.add(listView.getSelectionModel().getSelectedIndex(), new int[10]);
            getStumbleType.add(listView.getSelectionModel().getSelectedIndex(), new int[10]);
            getSecondaryType.add(listView.getSelectionModel().getSelectedIndex(), new int[10]);
            getCameraShakeType.add(listView.getSelectionModel().getSelectedIndex(), new short[10]);
            getCameraShakeTime.add(listView.getSelectionModel().getSelectedIndex(), new int[10]);
            getUserBpeID.add(listView.getSelectionModel().getSelectedIndex(), new short[10]);
            getVictimBpeID.add(listView.getSelectionModel().getSelectedIndex(), new short[10]);
            getStaminaBrokenOverrideBdmId.add(listView.getSelectionModel().getSelectedIndex(), new short[10]);
            getZVanishEnableTime.add(listView.getSelectionModel().getSelectedIndex(), new int[10]);
            getUserAnimationTime.add(listView.getSelectionModel().getSelectedIndex(), new int[10]);
            getVictimAnimationTime.add(listView.getSelectionModel().getSelectedIndex(), new int[10]);
            getUserAnimationSpeed.add(listView.getSelectionModel().getSelectedIndex(), new double[10]);
            getVictimAnimationSpeed.add(listView.getSelectionModel().getSelectedIndex(), new double[10]);
            allEntries.add(new String("Entry: "+listView.getItems().size()));
            listView.getItems().add("Entry " + listView.getItems().size());
        }
    }

    public void bdmReader(Path path){
        try(FileChannel channel=FileChannel.open(path, StandardOpenOption.READ)) {
            ByteBuffer intBuffer=ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
            ByteBuffer shortBuffer=ByteBuffer.allocate(2).order(ByteOrder.LITTLE_ENDIAN);
            int bdmEntries;
            int entryOffset=16;
            
            channel.position(8);
            intBuffer.clear();
            channel.read(intBuffer);
            intBuffer.flip();
            bdmEntries=intBuffer.getInt();

            switch ((int)((path.toFile().length()-16)/bdmEntries)) {
                case 1284:
                    allEntries=new ArrayList<>(bdmEntries);
                    for(int i=0;i<bdmEntries;i++){
                        allEntries.add(new String("Entry "+i));
                        listView.getItems().add(allEntries.get(i));
                        getDamageType.add(new int[10]);
                        getI02.add(new int[10]);
                        getSecondaryType.add(new int[10]);
                        getDamageAmount.add(new int[10]);
                        getDamageSpecial.add(new int[10]);
                        getDamageSpecial2.add(new int[10]);
                        getDamageSpecial3.add(new int[10]);
                        getUserAnimationTime.add(new int[10]);
                        getUserAnimationSpeed.add(new double[10]);
                        getVictimAnimationTime.add(new int[10]);
                        getVictimAnimationSpeed.add(new double[10]);
                        getAcbType.add(new int[10]);
                        getCueId.add(new short[10]);
                        getEffect1Id.add(new short[10]);
                        getEffect1SkillId.add(new int[10]);
                        getEffect1EepkType.add(new int[10]);
                        getEffect2Id.add(new short[10]);
                        getEffect2SkillId.add(new int[10]);
                        getEffect2EepkType.add(new int[10]);
                        getEffect3Id.add(new short[10]);
                        getEffect3SkillId.add(new int[10]);
                        getEffect3EepkType.add(new int[10]);
                        getI06.add(new int[10]);
                        getF08.add(new double[10]);
                        getI22.add(new int[10]);
                        getI30.add(new int[10]);
                        getI38.add(new int[10]);
                        getPushbackStrength.add(new double[10]);
                        getPushbackAcceleration.add(new double[10]);
                        getUserStunt.add(new int[10]);
                        getKnockbackDuration.add(new int[10]);
                        getKnockbackRecoveryAfterImpactTime.add(new int[10]);
                        getKnockbackGroundImpactTime.add(new int[10]);
                        getI58.add(new int[10]);
                        getVictimStunt.add(new int[10]);
                        getKnockbackStrengthX.add(new double[10]);
                        getKnockbackStrengthY.add(new double[10]);
                        getKnockbackStrengthZ.add(new double[10]);
                        getKnockbackDragY.add(new double[10]);
                        getI76.add(new int[10]);
                        getKnockbackGravityTime.add(new int[10]);
                        getVictimInvincibilityTime.add(new short[10]);
                        getI82.add(new int[10]);
                        getTransformationType.add(new int[10]);
                        getAlimentType.add(new short[10]);
                        getI88.add(new int[10]);
                        getI90.add(new int[10]);
                        getI92.add(new int[10]);
                        getStumbleType.add(new int[10]);
                        getCameraShakeType.add(new short[10]);
                        getCameraShakeTime.add(new int[10]);
                        getUserBpeID.add(new short[10]);
                        getVictimBpeID.add(new short[10]);
                        getStaminaBrokenOverrideBdmId.add(new short[10]);
                        getZVanishEnableTime.add(new int[10]);
                        for(int j=0;j<10;j++){
                            channel.position(entryOffset+4+128*j+1284*i);
                            shortBuffer.clear();
                            channel.read(shortBuffer);
                            shortBuffer.flip();
                            getDamageType.get(i)[j]=toUShort(shortBuffer.getShort());

                            channel.position(entryOffset+6+128*j+1284*i);
                            shortBuffer.clear();
                            channel.read(shortBuffer);
                            shortBuffer.flip();
                            getI02.get(i)[j]=toUShort(shortBuffer.getShort());

                            channel.position(entryOffset+8+128*j+1284*i);
                            shortBuffer.clear();
                            channel.read(shortBuffer);
                            shortBuffer.flip();
                            getDamageAmount.get(i)[j]=toUShort(shortBuffer.getShort());

                            channel.position(entryOffset+10+128*j+1284*i);
                            shortBuffer.clear();
                            channel.read(shortBuffer);
                            shortBuffer.flip();
                            getI06.get(i)[j]=toUShort(shortBuffer.getShort());

                            channel.position(entryOffset+12+128*j+1284*i);
                            intBuffer.clear();
                            channel.read(intBuffer);
                            intBuffer.flip();
                            getF08.get(i)[j]=intBuffer.getFloat();

                            channel.position(entryOffset+16+128*j+1284*i);
                            shortBuffer.clear();
                            channel.read(shortBuffer);
                            shortBuffer.flip();
                            getAcbType.get(i)[j]=toUShort(shortBuffer.getShort());

                            channel.position(entryOffset+18+128*j+1284*i);
                            shortBuffer.clear();
                            channel.read(shortBuffer);
                            shortBuffer.flip();
                            getCueId.get(i)[j]=shortBuffer.getShort();

                            channel.position(entryOffset+20+128*j+1284*i);
                            shortBuffer.clear();
                            channel.read(shortBuffer);
                            shortBuffer.flip();
                            getEffect1Id.get(i)[j]=shortBuffer.getShort();

                            channel.position(entryOffset+22+128*j+1284*i);
                            shortBuffer.clear();
                            channel.read(shortBuffer);
                            shortBuffer.flip();
                            getEffect1SkillId.get(i)[j]=toUShort(shortBuffer.getShort());

                            channel.position(entryOffset+24+128*j+1284*i);
                            shortBuffer.clear();
                            channel.read(shortBuffer);
                            shortBuffer.flip();
                            getEffect1EepkType.get(i)[j]=toUShort(shortBuffer.getShort());

                            channel.position(entryOffset+26+128*j+1284*i);
                            shortBuffer.clear();
                            channel.read(shortBuffer);
                            shortBuffer.flip();
                            getI22.get(i)[j]=toUShort(shortBuffer.getShort());

                            channel.position(entryOffset+28+128*j+1284*i);
                            shortBuffer.clear();
                            channel.read(shortBuffer);
                            shortBuffer.flip();
                            getEffect2Id.get(i)[j]=shortBuffer.getShort();

                            channel.position(entryOffset+30+128*j+1284*i);
                            shortBuffer.clear();
                            channel.read(shortBuffer);
                            shortBuffer.flip();
                            getEffect2SkillId.get(i)[j]=toUShort(shortBuffer.getShort());

                            channel.position(entryOffset+32+128*j+1284*i);
                            shortBuffer.clear();
                            channel.read(shortBuffer);
                            shortBuffer.flip();
                            getEffect2EepkType.get(i)[j]=toUShort(shortBuffer.getShort());

                            channel.position(entryOffset+34+128*j+1284*i);
                            shortBuffer.clear();
                            channel.read(shortBuffer);
                            shortBuffer.flip();
                            getI30.get(i)[j]=toUShort(shortBuffer.getShort());

                            channel.position(entryOffset+36+128*j+1284*i);
                            shortBuffer.clear();
                            channel.read(shortBuffer);
                            shortBuffer.flip();
                            getEffect3Id.get(i)[j]=shortBuffer.getShort();

                            channel.position(entryOffset+38+128*j+1284*i);
                            shortBuffer.clear();
                            channel.read(shortBuffer);
                            shortBuffer.flip();
                            getEffect3SkillId.get(i)[j]=toUShort(shortBuffer.getShort());

                            channel.position(entryOffset+40+128*j+1284*i);
                            shortBuffer.clear();
                            channel.read(shortBuffer);
                            shortBuffer.flip();
                            getEffect3EepkType.get(i)[j]=toUShort(shortBuffer.getShort());

                            channel.position(entryOffset+42+128*j+1284*i);
                            shortBuffer.clear();
                            channel.read(shortBuffer);
                            shortBuffer.flip();
                            getI38.get(i)[j]=toUShort(shortBuffer.getShort());

                            channel.position(entryOffset+44+128*j+1284*i);
                            intBuffer.clear();
                            channel.read(intBuffer);
                            intBuffer.flip();
                            getPushbackStrength.get(i)[j]=(double)intBuffer.getFloat();

                            channel.position(entryOffset+48+128*j+1284*i);
                            intBuffer.clear();
                            channel.read(intBuffer);
                            intBuffer.flip();
                            getPushbackAcceleration.get(i)[j]=(double)intBuffer.getFloat();

                            channel.position(entryOffset+52+128*j+1284*i);
                            shortBuffer.clear();
                            channel.read(shortBuffer);
                            shortBuffer.flip();
                            getUserStunt.get(i)[j]=toUShort(shortBuffer.getShort());

                            channel.position(entryOffset+54+128*j+1284*i);
                            shortBuffer.clear();
                            channel.read(shortBuffer);
                            shortBuffer.flip();
                            getVictimStunt.get(i)[j]=toUShort(shortBuffer.getShort());

                            channel.position(entryOffset+56+128*j+1284*i);
                            shortBuffer.clear();
                            channel.read(shortBuffer);
                            shortBuffer.flip();
                            getKnockbackDuration.get(i)[j]=toUShort(shortBuffer.getShort());

                            channel.position(entryOffset+58+128*j+1284*i);
                            shortBuffer.clear();
                            channel.read(shortBuffer);
                            shortBuffer.flip();
                            getKnockbackRecoveryAfterImpactTime.get(i)[j]=toUShort(shortBuffer.getShort());

                            channel.position(entryOffset+60+128*j+1284*i);
                            shortBuffer.clear();
                            channel.read(shortBuffer);
                            shortBuffer.flip();
                            getKnockbackGroundImpactTime.get(i)[j]=toUShort(shortBuffer.getShort());

                            channel.position(entryOffset+62+128*j+1284*i);
                            shortBuffer.clear();
                            channel.read(shortBuffer);
                            shortBuffer.flip();
                            getI58.get(i)[j]=toUShort(shortBuffer.getShort());

                            channel.position(entryOffset+64+128*j+1284*i);
                            intBuffer.clear();
                            channel.read(intBuffer);
                            intBuffer.flip();
                            getKnockbackStrengthX.get(i)[j]=(double)intBuffer.getFloat();

                            channel.position(entryOffset+68+128*j+1284*i);
                            intBuffer.clear();
                            channel.read(intBuffer);
                            intBuffer.flip();
                            getKnockbackStrengthY.get(i)[j]=(double)intBuffer.getFloat();

                            channel.position(entryOffset+72+128*j+1284*i);
                            intBuffer.clear();
                            channel.read(intBuffer);
                            intBuffer.flip();
                            getKnockbackStrengthZ.get(i)[j]=(double)intBuffer.getFloat();

                            channel.position(entryOffset+76+128*j+1284*i);
                            intBuffer.clear();
                            channel.read(intBuffer);
                            intBuffer.flip();
                            getKnockbackDragY.get(i)[j]=(double)intBuffer.getFloat();

                            channel.position(entryOffset+80+128*j+1284*i);
                            shortBuffer.clear();
                            channel.read(shortBuffer);
                            shortBuffer.flip();
                            getI76.get(i)[j]=toUShort(shortBuffer.getShort());

                            channel.position(entryOffset+82+128*j+1284*i);
                            shortBuffer.clear();
                            channel.read(shortBuffer);
                            shortBuffer.flip();
                            getKnockbackGravityTime.get(i)[j]=toUShort(shortBuffer.getShort());

                            channel.position(entryOffset+84+128*j+1284*i);
                            shortBuffer.clear();
                            channel.read(shortBuffer);
                            shortBuffer.flip();
                            getVictimInvincibilityTime.get(i)[j]=shortBuffer.getShort();

                            channel.position(entryOffset+86+128*j+1284*i);
                            shortBuffer.clear();
                            channel.read(shortBuffer);
                            shortBuffer.flip();
                            getI82.get(i)[j]=shortBuffer.getShort();

                            channel.position(entryOffset+88+128*j+1284*i);
                            shortBuffer.clear();
                            channel.read(shortBuffer);
                            shortBuffer.flip();
                            getTransformationType.get(i)[j]=shortBuffer.getShort();

                            channel.position(entryOffset+90+128*j+1284*i);
                            shortBuffer.clear();
                            channel.read(shortBuffer);
                            shortBuffer.flip();
                            getAlimentType.get(i)[j]=shortBuffer.getShort();

                            channel.position(entryOffset+92+128*j+1284*i);
                            shortBuffer.clear();
                            channel.read(shortBuffer);
                            shortBuffer.flip();
                            getI88.get(i)[j]=toUShort(shortBuffer.getShort());

                            channel.position(entryOffset+94+128*j+1284*i);
                            shortBuffer.clear();
                            channel.read(shortBuffer);
                            shortBuffer.flip();
                            getI90.get(i)[j]=toUShort(shortBuffer.getShort());

                            channel.position(entryOffset+96+128*j+1284*i);
                            shortBuffer.clear();
                            channel.read(shortBuffer);
                            shortBuffer.flip();
                            getI92.get(i)[j]=toUShort(shortBuffer.getShort());

                            channel.position(entryOffset+98+128*j+1284*i);
                            shortBuffer.clear();
                            channel.read(shortBuffer);
                            shortBuffer.flip();
                            getDamageSpecial.get(i)[j]=toUShort(shortBuffer.getShort());

                            channel.position(entryOffset+100+128*j+1284*i);
                            shortBuffer.clear();
                            channel.read(shortBuffer);
                            shortBuffer.flip();
                            getDamageSpecial2.get(i)[j]=toUShort(shortBuffer.getShort());

                            channel.position(entryOffset+102+128*j+1284*i);
                            shortBuffer.clear();
                            channel.read(shortBuffer);
                            shortBuffer.flip();
                            getDamageSpecial3.get(i)[j]=toUShort(shortBuffer.getShort());

                            channel.position(entryOffset+104+128*j+1284*i);
                            shortBuffer.clear();
                            channel.read(shortBuffer);
                            shortBuffer.flip();
                            getStumbleType.get(i)[j]=toUShort(shortBuffer.getShort());

                            channel.position(entryOffset+106+128*j+1284*i);
                            shortBuffer.clear();
                            channel.read(shortBuffer);
                            shortBuffer.flip();
                            getSecondaryType.get(i)[j]=toUShort(shortBuffer.getShort());

                            channel.position(entryOffset+108+128*j+1284*i);
                            shortBuffer.clear();
                            channel.read(shortBuffer);
                            shortBuffer.flip();
                            getCameraShakeType.get(i)[j]=shortBuffer.getShort();

                            channel.position(entryOffset+110+128*j+1284*i);
                            shortBuffer.clear();
                            channel.read(shortBuffer);
                            shortBuffer.flip();
                            getCameraShakeTime.get(i)[j]=toUShort(shortBuffer.getShort());

                            channel.position(entryOffset+112+128*j+1284*i);
                            shortBuffer.clear();
                            channel.read(shortBuffer);
                            shortBuffer.flip();
                            getUserBpeID.get(i)[j]=shortBuffer.getShort();

                            channel.position(entryOffset+114+128*j+1284*i);
                            shortBuffer.clear();
                            channel.read(shortBuffer);
                            shortBuffer.flip();
                            getVictimBpeID.get(i)[j]=shortBuffer.getShort();

                            channel.position(entryOffset+116+128*j+1284*i);
                            shortBuffer.clear();
                            channel.read(shortBuffer);
                            shortBuffer.flip();
                            getStaminaBrokenOverrideBdmId.get(i)[j]=shortBuffer.getShort();

                            channel.position(entryOffset+118+128*j+1284*i);
                            shortBuffer.clear();
                            channel.read(shortBuffer);
                            shortBuffer.flip();
                            getZVanishEnableTime.get(i)[j]=toUShort(shortBuffer.getShort());

                            channel.position(entryOffset+120+128*j+1284*i);
                            shortBuffer.clear();
                            channel.read(shortBuffer);
                            shortBuffer.flip();
                            getUserAnimationTime.get(i)[j]=toUShort(shortBuffer.getShort());

                            channel.position(entryOffset+122+128*j+1284*i);
                            shortBuffer.clear();
                            channel.read(shortBuffer);
                            shortBuffer.flip();
                            getVictimAnimationTime.get(i)[j]=toUShort(shortBuffer.getShort());

                            channel.position(entryOffset+124+128*j+1284*i);
                            intBuffer.clear();
                            channel.read(intBuffer);
                            intBuffer.flip();
                            getUserAnimationSpeed.get(i)[j]=(double)intBuffer.getFloat();

                            channel.position(entryOffset+128+128*j+1284*i);
                            intBuffer.clear();
                            channel.read(intBuffer);
                            intBuffer.flip();
                            getVictimAnimationSpeed.get(i)[j]=(double)intBuffer.getFloat();
                        }
                    }
                    break;
            
                default:
                    Platform.runLater(()->{
                        Popups.LegacyFormat();
                    });
                    break;
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void bdmWriter(Path path){
        try(FileChannel channel=FileChannel.open(path,StandardOpenOption.WRITE,StandardOpenOption.CREATE,StandardOpenOption.TRUNCATE_EXISTING)) {
            ByteBuffer intBuffer=ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
            ByteBuffer shortBuffer=ByteBuffer.allocate(2).order(ByteOrder.LITTLE_ENDIAN);

            int entryOffset=16;
            channel.write(ByteBuffer.wrap(new byte[]{0x23,0x42,0x44,(byte)0x4D}));

            channel.position(4);
            channel.write(ByteBuffer.wrap(new byte[]{(byte)0xFE,(byte)0xFF}));

            channel.position(8);
            intBuffer.clear();
            intBuffer.putInt(allEntries.size());
            intBuffer.flip();
            channel.write(intBuffer);

            channel.position(12);
            intBuffer.clear();
            intBuffer.putInt(entryOffset);
            intBuffer.flip();
            channel.write(intBuffer);

            for(int i=0;i<allEntries.size();i++){
                for(int j=0;j<10;j++){
                    channel.position(entryOffset+4+128*j+1284*i);
                    shortBuffer.clear();
                    shortBuffer.putShort((short)getDamageType.get(i)[j]);
                    shortBuffer.flip();
                    channel.write(shortBuffer);

                    channel.position(entryOffset+6+128*j+1284*i);
                    shortBuffer.clear();
                    shortBuffer.putShort((short)getI02.get(i)[j]);
                    shortBuffer.flip();
                    channel.write(shortBuffer);

                    channel.position(entryOffset+8+128*j+1284*i);
                    shortBuffer.clear();
                    shortBuffer.putShort((short)getDamageAmount.get(i)[j]);
                    shortBuffer.flip();
                    channel.write(shortBuffer);

                    channel.position(entryOffset+10+128*j+1284*i);
                    shortBuffer.clear();
                    shortBuffer.putShort((short)getI06.get(i)[j]);
                    shortBuffer.flip();
                    channel.write(shortBuffer);

                    channel.position(entryOffset+12+128*j+1284*i);
                    intBuffer.clear();
                    intBuffer.putFloat((float)getF08.get(i)[j]);
                    intBuffer.flip();
                    channel.write(intBuffer);

                    channel.position(entryOffset+16+128*j+1284*i);
                    shortBuffer.clear();
                    shortBuffer.putShort((short)getAcbType.get(i)[j]);
                    shortBuffer.flip();
                    channel.write(shortBuffer);

                    channel.position(entryOffset+18+128*j+1284*i);
                    shortBuffer.clear();
                    shortBuffer.putShort(getCueId.get(i)[j]);
                    shortBuffer.flip();
                    channel.write(shortBuffer);

                    channel.position(entryOffset+20+128*j+1284*i);
                    shortBuffer.clear();
                    shortBuffer.putShort(getEffect1Id.get(i)[j]);
                    shortBuffer.flip();
                    channel.write(shortBuffer);

                    channel.position(entryOffset+22+128*j+1284*i);
                    shortBuffer.clear();
                    shortBuffer.putShort((short)getEffect1SkillId.get(i)[j]);
                    shortBuffer.flip();
                    channel.write(shortBuffer);

                    channel.position(entryOffset+24+128*j+1284*i);
                    shortBuffer.clear();
                    shortBuffer.putShort((short)getEffect1EepkType.get(i)[j]);
                    shortBuffer.flip();
                    channel.write(shortBuffer);

                    channel.position(entryOffset+26+128*j+1284*i);
                    shortBuffer.clear();
                    shortBuffer.putShort((short)getI22.get(i)[j]);
                    shortBuffer.flip();
                    channel.write(shortBuffer);

                    channel.position(entryOffset+28+128*j+1284*i);
                    shortBuffer.clear();
                    shortBuffer.putShort(getEffect2Id.get(i)[j]);
                    shortBuffer.flip();
                    channel.write(shortBuffer);

                    channel.position(entryOffset+30+128*j+1284*i);
                    shortBuffer.clear();
                    shortBuffer.putShort((short)getEffect2SkillId.get(i)[j]);
                    shortBuffer.flip();
                    channel.write(shortBuffer);

                    channel.position(entryOffset+32+128*j+1284*i);
                    shortBuffer.clear();
                    shortBuffer.putShort((short)getEffect2EepkType.get(i)[j]);
                    shortBuffer.flip();
                    channel.write(shortBuffer);

                    channel.position(entryOffset+34+128*j+1284*i);
                    shortBuffer.clear();
                    shortBuffer.putShort((short)getI30.get(i)[j]);
                    shortBuffer.flip();
                    channel.write(shortBuffer);

                    channel.position(entryOffset+36+128*j+1284*i);
                    shortBuffer.clear();
                    shortBuffer.putShort(getEffect3Id.get(i)[j]);
                    shortBuffer.flip();
                    channel.write(shortBuffer);

                    channel.position(entryOffset+38+128*j+1284*i);
                    shortBuffer.clear();
                    shortBuffer.putShort((short)getEffect3SkillId.get(i)[j]);
                    shortBuffer.flip();
                    channel.write(shortBuffer);

                    channel.position(entryOffset+40+128*j+1284*i);
                    shortBuffer.clear();
                    shortBuffer.putShort((short)getEffect3EepkType.get(i)[j]);
                    shortBuffer.flip();
                    channel.write(shortBuffer);

                    channel.position(entryOffset+42+128*j+1284*i);
                    shortBuffer.clear();
                    shortBuffer.putShort((short)getI38.get(i)[j]);
                    shortBuffer.flip();
                    channel.write(shortBuffer);

                    channel.position(entryOffset+44+128*j+1284*i);
                    intBuffer.clear();
                    intBuffer.putFloat((float)getPushbackStrength.get(i)[j]);
                    intBuffer.flip();
                    channel.write(intBuffer);

                    channel.position(entryOffset+48+128*j+1284*i);
                    intBuffer.clear();
                    intBuffer.putFloat((float)getPushbackAcceleration.get(i)[j]);
                    intBuffer.flip();
                    channel.write(intBuffer);

                    channel.position(entryOffset+52+128*j+1284*i);
                    shortBuffer.clear();
                    shortBuffer.putShort((short)getUserStunt.get(i)[j]);
                    shortBuffer.flip();
                    channel.write(shortBuffer);

                    channel.position(entryOffset+54+128*j+1284*i);
                    shortBuffer.clear();
                    shortBuffer.putShort((short)getVictimStunt.get(i)[j]);
                    shortBuffer.flip();
                    channel.write(shortBuffer);

                    channel.position(entryOffset+56+128*j+1284*i);
                    shortBuffer.clear();
                    shortBuffer.putShort((short)getKnockbackDuration.get(i)[j]);
                    shortBuffer.flip();
                    channel.write(shortBuffer);

                    channel.position(entryOffset+58+128*j+1284*i);
                    shortBuffer.clear();
                    shortBuffer.putShort((short)getKnockbackRecoveryAfterImpactTime.get(i)[j]);
                    shortBuffer.flip();
                    channel.write(shortBuffer);

                    channel.position(entryOffset+60+128*j+1284*i);
                    shortBuffer.clear();
                    shortBuffer.putShort((short)getKnockbackGroundImpactTime.get(i)[j]);
                    shortBuffer.flip();
                    channel.write(shortBuffer);

                    channel.position(entryOffset+62+128*j+1284*i);
                    shortBuffer.clear();
                    shortBuffer.putShort((short)getI58.get(i)[j]);
                    shortBuffer.flip();
                    channel.write(shortBuffer);

                    channel.position(entryOffset+64+128*j+1284*i);
                    intBuffer.clear();
                    intBuffer.putFloat((float)getKnockbackStrengthX.get(i)[j]);
                    intBuffer.flip();
                    channel.write(intBuffer);

                    channel.position(entryOffset+68+128*j+1284*i);
                    intBuffer.clear();
                    intBuffer.putFloat((float)getKnockbackStrengthY.get(i)[j]);
                    intBuffer.flip();
                    channel.write(intBuffer);

                    channel.position(entryOffset+72+128*j+1284*i);
                    intBuffer.clear();
                    intBuffer.putFloat((float)getKnockbackStrengthZ.get(i)[j]);
                    intBuffer.flip();
                    channel.write(intBuffer);

                    channel.position(entryOffset+76+128*j+1284*i);
                    intBuffer.clear();
                    intBuffer.putFloat((float)getKnockbackDragY.get(i)[j]);
                    intBuffer.flip();
                    channel.write(intBuffer);

                    channel.position(entryOffset+80+128*j+1284*i);
                    shortBuffer.clear();
                    shortBuffer.putShort((short)getI76.get(i)[j]);
                    shortBuffer.flip();
                    channel.write(shortBuffer);

                    channel.position(entryOffset+82+128*j+1284*i);
                    shortBuffer.clear();
                    shortBuffer.putShort((short)getKnockbackGravityTime.get(i)[j]);
                    shortBuffer.flip();
                    channel.write(shortBuffer);

                    channel.position(entryOffset+84+128*j+1284*i);
                    shortBuffer.clear();
                    shortBuffer.putShort(getVictimInvincibilityTime.get(i)[j]);
                    shortBuffer.flip();
                    channel.write(shortBuffer);

                    channel.position(entryOffset+86+128*j+1284*i);
                    shortBuffer.clear();
                    shortBuffer.putShort((short)getI82.get(i)[j]);
                    shortBuffer.flip();
                    channel.write(shortBuffer);

                    channel.position(entryOffset+88+128*j+1284*i);
                    shortBuffer.clear();
                    shortBuffer.putShort((short)getTransformationType.get(i)[j]);
                    shortBuffer.flip();
                    channel.write(shortBuffer);

                    channel.position(entryOffset+90+128*j+1284*i);
                    shortBuffer.clear();
                    shortBuffer.putShort(getAlimentType.get(i)[j]);
                    shortBuffer.flip();
                    channel.write(shortBuffer);

                    channel.position(entryOffset+92+128*j+1284*i);
                    shortBuffer.clear();
                    shortBuffer.putShort((short)getI88.get(i)[j]);
                    shortBuffer.flip();
                    channel.write(shortBuffer);

                    channel.position(entryOffset+94+128*j+1284*i);
                    shortBuffer.clear();
                    shortBuffer.putShort((short)getI90.get(i)[j]);
                    shortBuffer.flip();
                    channel.write(shortBuffer);

                    channel.position(entryOffset+96+128*j+1284*i);
                    shortBuffer.clear();
                    shortBuffer.putShort((short)getI92.get(i)[j]);
                    shortBuffer.flip();
                    channel.write(shortBuffer);

                    channel.position(entryOffset+98+128*j+1284*i);
                    shortBuffer.clear();
                    shortBuffer.putShort((short)getDamageSpecial.get(i)[j]);
                    shortBuffer.flip();
                    channel.write(shortBuffer);

                    channel.position(entryOffset+100+128*j+1284*i);
                    shortBuffer.clear();
                    shortBuffer.putShort((short)getDamageSpecial2.get(i)[j]);
                    shortBuffer.flip();
                    channel.write(shortBuffer);

                    channel.position(entryOffset+102+128*j+1284*i);
                    shortBuffer.clear();
                    shortBuffer.putShort((short)getDamageSpecial3.get(i)[j]);
                    shortBuffer.flip();
                    channel.write(shortBuffer);

                    channel.position(entryOffset+104+128*j+1284*i);
                    shortBuffer.clear();
                    shortBuffer.putShort((short)getStumbleType.get(i)[j]);
                    shortBuffer.flip();
                    channel.write(shortBuffer);

                    channel.position(entryOffset+106+128*j+1284*i);
                    shortBuffer.clear();
                    shortBuffer.putShort((short)getSecondaryType.get(i)[j]);
                    shortBuffer.flip();
                    channel.write(shortBuffer);

                    channel.position(entryOffset+108+128*j+1284*i);
                    shortBuffer.clear();
                    shortBuffer.putShort(getCameraShakeType.get(i)[j]);
                    shortBuffer.flip();
                    channel.write(shortBuffer);

                    channel.position(entryOffset+110+128*j+1284*i);
                    shortBuffer.clear();
                    shortBuffer.putShort((short)getCameraShakeTime.get(i)[j]);
                    shortBuffer.flip();
                    channel.write(shortBuffer);

                    channel.position(entryOffset+112+128*j+1284*i);
                    shortBuffer.clear();
                    shortBuffer.putShort(getUserBpeID.get(i)[j]);
                    shortBuffer.flip();
                    channel.write(shortBuffer);

                    channel.position(entryOffset+114+128*j+1284*i);
                    shortBuffer.clear();
                    shortBuffer.putShort(getVictimBpeID.get(i)[j]);
                    shortBuffer.flip();
                    channel.write(shortBuffer);

                    channel.position(entryOffset+116+128*j+1284*i);
                    shortBuffer.clear();
                    shortBuffer.putShort(getStaminaBrokenOverrideBdmId.get(i)[j]);
                    shortBuffer.flip();
                    channel.write(shortBuffer);

                    channel.position(entryOffset+118+128*j+1284*i);
                    shortBuffer.clear();
                    shortBuffer.putShort((short)getZVanishEnableTime.get(i)[j]);
                    shortBuffer.flip();
                    channel.write(shortBuffer);

                    channel.position(entryOffset+120+128*j+1284*i);
                    shortBuffer.clear();
                    shortBuffer.putShort((short)getUserAnimationTime.get(i)[j]);
                    shortBuffer.flip();
                    channel.write(shortBuffer);

                    channel.position(entryOffset+122+128*j+1284*i);
                    shortBuffer.clear();
                    shortBuffer.putShort((short)getVictimAnimationTime.get(i)[j]);
                    shortBuffer.flip();
                    channel.write(shortBuffer);

                    channel.position(entryOffset+124+128*j+1284*i);
                    intBuffer.clear();
                    intBuffer.putFloat((float)getUserAnimationSpeed.get(i)[j]);
                    intBuffer.flip();
                    channel.write(intBuffer);

                    channel.position(entryOffset+128+128*j+1284*i);
                    intBuffer.clear();
                    intBuffer.putFloat((float)getVictimAnimationSpeed.get(i)[j]);
                    intBuffer.flip();
                    channel.write(intBuffer);
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();

        }
    }
}
