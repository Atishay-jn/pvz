package Game.frontend.PlantSelect;


import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class PlantSelectController
{
	private Stage primaryStage;

	@FXML
	private ImageView op0;

	@FXML
	private ImageView op1;

	@FXML
	private ImageView op2;

	@FXML
	private ImageView op3;

	@FXML
	private ImageView op4;

	@FXML
	private ImageView op5;

	@FXML
	private ImageView op6;

	@FXML
	private ImageView op7;

	@FXML
	private ImageView op8;

	@FXML
	private ImageView op9;

	@FXML
	private ImageView op10;

	@FXML
	private ImageView slot1;

	@FXML
	private ImageView slot2;

	@FXML
	private ImageView slot3;

	@FXML
	private  ImageView slot4;

	@FXML
	private ImageView slot5;

	@FXML
	private ImageView slot6;

	private boolean[] plants;
	private boolean[] slots = new boolean[6];

	void setPrimaryStage(Stage primaryStage)
	{
		for(int i=0;i<6;i++)
			slots[i] = false;
		this.primaryStage = primaryStage;
		op0.setImage(new Image(TallNut.getCostImage()));
		op1.setImage(new Image(WallNut.getCostImage()));
		op2.setImage(new Image(Jalapeno.getCostImage()));
		op3.setImage(new Image(PotatoMine.getCostImage()));
		op4.setImage(new Image(Sunflower.getCostImage()));
		op5.setImage(new Image(TwinSunflower.getCostImage()));
		op6.setImage(new Image(Firey.getCostImage()));
		op7.setImage(new Image(Frosty.getCostImage()));
		op8.setImage(new Image(Gun.getCostImage()));
		op9.setImage(new Image(PeaShooter.getCostImage()));
		op10.setImage(new Image(Repeater.getCostImage()));
		plants = CurrentUser.getUser().getPlantUnlocked();
		setOpacity();
	}

	private void setOpacity() {
		if(!plants[0])
			op0.setOpacity(0.5);
		else
			op0.setOpacity(1);
		if(!plants[1])
			op1.setOpacity(0.5);
		else
			op1.setOpacity(1);
		if(!plants[2])
			op2.setOpacity(0.5);
		else
			op2.setOpacity(1);
		if(!plants[3])
			op3.setOpacity(0.5);
		else
			op3.setOpacity(1);
		if(!plants[4])
			op4.setOpacity(0.5);
		else
			op4.setOpacity(1);
		if(!plants[5])
			op5.setOpacity(0.5);
		else
			op5.setOpacity(1);
		if(!plants[6])
			op6.setOpacity(0.5);
		else
			op6.setOpacity(1);
		if(!plants[7])
			op7.setOpacity(0.5);
		else
			op7.setOpacity(1);
		if(!plants[8])
			op8.setOpacity(0.5);
		else
			op8.setOpacity(1);
		if(!plants[9])
			op9.setOpacity(0.5);
		else
			op9.setOpacity(1);
		if(!plants[10])
			op10.setOpacity(0.5);
		else
			op10.setOpacity(1);
	}

	@FXML
	private void backClick() throws Exception
	{
		Game.frontend.LevelSelect.LevelSelect.getInstance().run(primaryStage);
	}

	@FXML
	private void shopClick() throws Exception
	{
		Game.frontend.Shop.Shop.getInstance().run(primaryStage);
	}

	@FXML
	private void playClick() throws Exception
	{
		Game.frontend.GameWindow.GameWindow.getInstance().run(primaryStage);
	}

	private void fillSlot(Image image) throws NoSlotLeftException
	{
		if(!slots[0]) {
			slot1.setImage(image);
			slots[0] = true;
		}
		else if(!slots[1]) {
			slot2.setImage(image);
			slots[1] = true;
		}
		else if(!slots[2]) {
			slot3.setImage(image);
			slots[2] = true;
		}
		else if(!slots[3]) {
			slot4.setImage(image);
			slots[3] = true;
		}
		else if(!slots[4]) {
			slot5.setImage(image);
			slots[4] = true;
		}
		else if(!slots[5]) {
			slot6.setImage(image);
			slots[5] = true;
		}
		else {
			throw new NoSlotLeftException("No slot available");
		}
	}

	@FXML
	private void op10Click(MouseEvent mouseEvent) {
		if(plants[10]) {
			try {
				fillSlot(op10.getImage());
				plants[10] = false;
				op10.setOpacity(0.5);
			}
			catch(NoSlotLeftException e) {
				plants[10] = true;
				op10.setOpacity(1);
			}
		}
	}

	@FXML
	private void op9Click(MouseEvent mouseEvent) {
		if(plants[9]) {
			try {
				fillSlot(op9.getImage());
				plants[9] = false;
				op9.setOpacity(0.5);
			}
			catch(NoSlotLeftException e) {
				plants[9] = true;
				op9.setOpacity(1);
			}
		}
	}

	@FXML
	private void op8Click(MouseEvent mouseEvent) {
		if(plants[8]) {
			try {
				fillSlot(op8.getImage());
				plants[8] = false;
				op8.setOpacity(0.5);
			}
			catch(NoSlotLeftException e) {
				plants[8] = true;
				op8.setOpacity(1);
			}
		}
	}

	@FXML
	private void op7Click(MouseEvent mouseEvent) {
		if(plants[7]) {
			try {
				fillSlot(op7.getImage());
				plants[7] = false;
				op7.setOpacity(0.5);
			}
			catch(NoSlotLeftException e) {
				plants[7] = true;
				op7.setOpacity(1);
			}
		}
	}

	@FXML
	private void op6Click(MouseEvent mouseEvent) {
		if(plants[6]) {
			try {
				fillSlot(op6.getImage());
				plants[6] = false;
				op6.setOpacity(0.5);
			}
			catch(NoSlotLeftException e) {
				plants[6] = true;
				op6.setOpacity(1);
			}
		}
	}

	@FXML
	private void op5Click(MouseEvent mouseEvent) {
		if(plants[5]) {
			try {
				fillSlot(op5.getImage());
				plants[5] = false;
				op5.setOpacity(0.5);
			}
			catch(NoSlotLeftException e) {
				plants[5] = true;
				op5.setOpacity(1);
			}
		}
	}

	@FXML
	private void op4Click(MouseEvent mouseEvent) {
		if(plants[4]) {
			try {
				fillSlot(op4.getImage());
				plants[4] = false;
				op4.setOpacity(0.5);
			}
			catch(NoSlotLeftException e) {
				plants[4] = true;
				op4.setOpacity(1);
			}
		}
	}

	@FXML
	private void op3Click(MouseEvent mouseEvent) {
		if(plants[3]) {
			try {
				fillSlot(op3.getImage());
				plants[3] = false;
				op3.setOpacity(0.5);
			}
			catch(NoSlotLeftException e) {
				plants[3] = true;
				op3.setOpacity(1);
			}
		}
	}

	@FXML
	private void op2Click(MouseEvent mouseEvent) {
		if(plants[2]) {
			try {
				fillSlot(op2.getImage());
				plants[2] = false;
				op2.setOpacity(0.5);
			}
			catch(NoSlotLeftException e) {
				plants[2] = true;
				op2.setOpacity(1);
			}
		}
	}

	@FXML
	private void op1Click(MouseEvent mouseEvent) {
		if(plants[1]) {
			try {
				fillSlot(op1.getImage());
				plants[1] = false;
				op1.setOpacity(0.5);
			}
			catch(NoSlotLeftException e) {
				plants[1] = true;
				op1.setOpacity(1);
			}
		}
	}

	@FXML
	private void op0Click(MouseEvent mouseEvent) {
		if(plants[0]) {
			try {
				fillSlot(op0.getImage());
				plants[0] = false;
				op0.setOpacity(0.5);
			}
			catch(NoSlotLeftException e) {
				plants[0] = true;
				op0.setOpacity(1);
			}
		}
	}

	@FXML
	private void slot6Click(MouseEvent mouseEvent) {
		if(op0.getImage() == slot6.getImage()) {
			op0.setOpacity(1);
			plants[0] = true;
			slot6.setImage(null);
			slots[5] = false;
		}
		else if (op1.getImage() == slot6.getImage()) {
			op1.setOpacity(1);
			plants[1] = true;
			slot6.setImage(null);
			slots[5] = false;
		}
		else if (op2.getImage() == slot6.getImage()) {
			op1.setOpacity(1);
			plants[1] = true;
			slot6.setImage(null);
			slots[5] = false;
		}
		else if (op3.getImage() == slot6.getImage()) {
			op3.setOpacity(1);
			plants[3] = true;
			slot6.setImage(null);
			slots[5] = false;
		}
		else if (op4.getImage() == slot6.getImage()) {
			op4.setOpacity(1);
			plants[4] = true;
			slot6.setImage(null);
			slots[5] = false;
		}
		else if (op5.getImage() == slot6.getImage()) {
			op5.setOpacity(1);
			plants[5] = true;
			slot6.setImage(null);
			slots[5] = false;
		}
		else if (op6.getImage() == slot6.getImage()) {
			op6.setOpacity(1);
			plants[6] = true;
			slot6.setImage(null);
			slots[5] = false;
		}
		else if (op7.getImage() == slot6.getImage()) {
			op7.setOpacity(1);
			plants[7] = true;
			slot6.setImage(null);
			slots[5] = false;
		}
		else if (op8.getImage() == slot6.getImage()) {
			op8.setOpacity(1);
			plants[8] = true;
			slot6.setImage(null);
			slots[5] = false;
		}
		else if (op9.getImage() == slot6.getImage()) {
			op9.setOpacity(1);
			plants[9] = true;
			slot6.setImage(null);
			slots[5] = false;
		}
		else if (op10.getImage() == slot6.getImage()) {
			op10.setOpacity(1);
			plants[10] = true;
			slot6.setImage(null);
			slots[5] = false;
		}
	}

	@FXML
	private void slot5Click(MouseEvent mouseEvent) {
		if(op0.getImage() == slot5.getImage()) {
			op0.setOpacity(1);
			plants[0] = true;
			slot5.setImage(null);
			slots[4] = false;
		}
		else if (op1.getImage() == slot5.getImage()) {
			op1.setOpacity(1);
			plants[1] = true;
			slot5.setImage(null);
			slots[4] = false;
		}
		else if (op2.getImage() == slot5.getImage()) {
			op1.setOpacity(1);
			plants[1] = true;
			slot5.setImage(null);
			slots[4] = false;
		}
		else if (op3.getImage() == slot5.getImage()) {
			op3.setOpacity(1);
			plants[3] = true;
			slot5.setImage(null);
			slots[4] = false;
		}
		else if (op4.getImage() == slot5.getImage()) {
			op4.setOpacity(1);
			plants[4] = true;
			slot5.setImage(null);
			slots[4] = false;
		}
		else if (op5.getImage() == slot5.getImage()) {
			op5.setOpacity(1);
			plants[5] = true;
			slot5.setImage(null);
			slots[4] = false;
		}
		else if (op6.getImage() == slot5.getImage()) {
			op6.setOpacity(1);
			plants[6] = true;
			slot5.setImage(null);
			slots[4] = false;
		}
		else if (op7.getImage() == slot5.getImage()) {
			op7.setOpacity(1);
			plants[7] = true;
			slot5.setImage(null);
			slots[4] = false;
		}
		else if (op8.getImage() == slot5.getImage()) {
			op8.setOpacity(1);
			plants[8] = true;
			slot5.setImage(null);
			slots[4] = false;
		}
		else if (op9.getImage() == slot5.getImage()) {
			op9.setOpacity(1);
			plants[9] = true;
			slot5.setImage(null);
			slots[4] = false;
		}
		else if (op10.getImage() == slot5.getImage()) {
			op10.setOpacity(1);
			plants[10] = true;
			slot5.setImage(null);
			slots[4] = false;
		}
	}

	@FXML
	private void slot4Click(MouseEvent mouseEvent) {
		if(op0.getImage() == slot4.getImage()) {
			op0.setOpacity(1);
			plants[0] = true;
			slot4.setImage(null);
			slots[3] = false;
		}
		else if (op1.getImage() == slot4.getImage()) {
			op1.setOpacity(1);
			plants[1] = true;
			slot4.setImage(null);
			slots[3] = false;
		}
		else if (op2.getImage() == slot4.getImage()) {
			op1.setOpacity(1);
			plants[1] = true;
			slot4.setImage(null);
			slots[3] = false;
		}
		else if (op3.getImage() == slot4.getImage()) {
			op3.setOpacity(1);
			plants[3] = true;
			slot4.setImage(null);
			slots[3] = false;
		}
		else if (op4.getImage() == slot4.getImage()) {
			op4.setOpacity(1);
			plants[4] = true;
			slot4.setImage(null);
			slots[3] = false;
		}
		else if (op5.getImage() == slot4.getImage()) {
			op5.setOpacity(1);
			plants[5] = true;
			slot4.setImage(null);
			slots[3] = false;
		}
		else if (op6.getImage() == slot4.getImage()) {
			op6.setOpacity(1);
			plants[6] = true;
			slot4.setImage(null);
			slots[3] = false;
		}
		else if (op7.getImage() == slot4.getImage()) {
			op7.setOpacity(1);
			plants[7] = true;
			slot4.setImage(null);
			slots[3] = false;
		}
		else if (op8.getImage() == slot4.getImage()) {
			op8.setOpacity(1);
			plants[8] = true;
			slot4.setImage(null);
			slots[3] = false;
		}
		else if (op9.getImage() == slot4.getImage()) {
			op9.setOpacity(1);
			plants[9] = true;
			slot4.setImage(null);
			slots[3] = false;
		}
		else if (op10.getImage() == slot4.getImage()) {
			op10.setOpacity(1);
			plants[10] = true;
			slot4.setImage(null);
			slots[3] = false;
		}
	}

	@FXML
	private void slot3Click(MouseEvent mouseEvent) {
		if(op0.getImage() == slot3.getImage()) {
			op0.setOpacity(1);
			plants[0] = true;
			slot3.setImage(null);
			slots[2] = false;
		}
		else if (op1.getImage() == slot3.getImage()) {
			op1.setOpacity(1);
			plants[1] = true;
			slot3.setImage(null);
			slots[2] = false;
		}
		else if (op2.getImage() == slot3.getImage()) {
			op1.setOpacity(1);
			plants[1] = true;
			slot3.setImage(null);
			slots[2] = false;
		}
		else if (op3.getImage() == slot3.getImage()) {
			op3.setOpacity(1);
			plants[3] = true;
			slot3.setImage(null);
			slots[2] = false;
		}
		else if (op4.getImage() == slot3.getImage()) {
			op4.setOpacity(1);
			plants[4] = true;
			slot3.setImage(null);
			slots[2] = false;
		}
		else if (op5.getImage() == slot3.getImage()) {
			op5.setOpacity(1);
			plants[5] = true;
			slot3.setImage(null);
			slots[2] = false;
		}
		else if (op6.getImage() == slot3.getImage()) {
			op6.setOpacity(1);
			plants[6] = true;
			slot3.setImage(null);
			slots[2] = false;
		}
		else if (op7.getImage() == slot3.getImage()) {
			op7.setOpacity(1);
			plants[7] = true;
			slot3.setImage(null);
			slots[2] = false;
		}
		else if (op8.getImage() == slot3.getImage()) {
			op8.setOpacity(1);
			plants[8] = true;
			slot3.setImage(null);
			slots[2] = false;
		}
		else if (op9.getImage() == slot3.getImage()) {
			op9.setOpacity(1);
			plants[9] = true;
			slot3.setImage(null);
			slots[2] = false;
		}
		else if (op10.getImage() == slot3.getImage()) {
			op10.setOpacity(1);
			plants[10] = true;
			slot3.setImage(null);
			slots[2] = false;
		}
	}

	@FXML
	private void slot2Click(MouseEvent mouseEvent) {
		if(op0.getImage() == slot2.getImage()) {
			op0.setOpacity(1);
			plants[0] = true;
			slot2.setImage(null);
			slots[1] = false;
		}
		else if (op1.getImage() == slot2.getImage()) {
			op1.setOpacity(1);
			plants[1] = true;
			slot2.setImage(null);
			slots[1] = false;
		}
		else if (op2.getImage() == slot2.getImage()) {
			op1.setOpacity(1);
			plants[1] = true;
			slot2.setImage(null);
			slots[1] = false;
		}
		else if (op3.getImage() == slot2.getImage()) {
			op3.setOpacity(1);
			plants[3] = true;
			slot2.setImage(null);
			slots[1] = false;
		}
		else if (op4.getImage() == slot2.getImage()) {
			op4.setOpacity(1);
			plants[4] = true;
			slot2.setImage(null);
			slots[1] = false;
		}
		else if (op5.getImage() == slot2.getImage()) {
			op5.setOpacity(1);
			plants[5] = true;
			slot2.setImage(null);
			slots[1] = false;
		}
		else if (op6.getImage() == slot2.getImage()) {
			op6.setOpacity(1);
			plants[6] = true;
			slot2.setImage(null);
			slots[1] = false;
		}
		else if (op7.getImage() == slot2.getImage()) {
			op7.setOpacity(1);
			plants[7] = true;
			slot2.setImage(null);
			slots[1] = false;
		}
		else if (op8.getImage() == slot2.getImage()) {
			op8.setOpacity(1);
			plants[8] = true;
			slot2.setImage(null);
			slots[1] = false;
		}
		else if (op9.getImage() == slot2.getImage()) {
			op9.setOpacity(1);
			plants[9] = true;
			slot2.setImage(null);
			slots[1] = false;
		}
		else if (op10.getImage() == slot2.getImage()) {
			op10.setOpacity(1);
			plants[10] = true;
			slot2.setImage(null);
			slots[1] = false;
		}
	}

	@FXML
	private void slot1Click(MouseEvent mouseEvent) {
		if(op0.getImage() == slot1.getImage()) {
			op0.setOpacity(1);
			plants[0] = true;
			slot1.setImage(null);
			slots[0] = false;
		}
		else if (op1.getImage() == slot1.getImage()) {
			op1.setOpacity(1);
			plants[1] = true;
			slot1.setImage(null);
			slots[0] = false;
		}
		else if (op2.getImage() == slot1.getImage()) {
			op1.setOpacity(1);
			plants[1] = true;
			slot1.setImage(null);
			slots[0] = false;
		}
		else if (op3.getImage() == slot1.getImage()) {
			op3.setOpacity(1);
			plants[3] = true;
			slot1.setImage(null);
			slots[0] = false;
		}
		else if (op4.getImage() == slot1.getImage()) {
			op4.setOpacity(1);
			plants[4] = true;
			slot1.setImage(null);
			slots[0] = false;
		}
		else if (op5.getImage() == slot1.getImage()) {
			op5.setOpacity(1);
			plants[5] = true;
			slot1.setImage(null);
			slots[0] = false;
		}
		else if (op6.getImage() == slot1.getImage()) {
			op6.setOpacity(1);
			plants[6] = true;
			slot1.setImage(null);
			slots[0] = false;
		}
		else if (op7.getImage() == slot1.getImage()) {
			op7.setOpacity(1);
			plants[7] = true;
			slot1.setImage(null);
			slots[0] = false;
		}
		else if (op8.getImage() == slot1.getImage()) {
			op8.setOpacity(1);
			plants[8] = true;
			slot1.setImage(null);
			slots[0] = false;
		}
		else if (op9.getImage() == slot1.getImage()) {
			op9.setOpacity(1);
			plants[9] = true;
			slot1.setImage(null);
			slots[0] = false;
		}
		else if (op10.getImage() == slot1.getImage()) {
			op10.setOpacity(1);
			plants[10] = true;
			slot1.setImage(null);
			slots[0] = false;
		}
	}
}
